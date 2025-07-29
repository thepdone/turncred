package androidx.camera.mlkit.vision;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.media.Image;
import android.util.Size;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.view.transform.ImageProxyTransformFactory;
import androidx.core.util.Consumer;
import com.canhub.cropper.CropImageOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.interfaces.Detector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class MlKitAnalyzer implements ImageAnalysis.Analyzer {
    private static final Size DEFAULT_SIZE = new Size(480, CropImageOptions.DEGREES_360);
    private static final String TAG = "MlKitAnalyzer";
    final Consumer<Result> mConsumer;
    private final List<Detector<?>> mDetectors;
    private final Executor mExecutor;
    final ImageProxyTransformFactory mImageAnalysisTransformFactory;
    private Matrix mSensorToTarget;
    private final int mTargetCoordinateSystem;

    public MlKitAnalyzer(List<Detector<?>> list, int i, Executor executor, Consumer<Result> consumer) {
        if (i != 0) {
            Iterator<Detector<?>> it = list.iterator();
            while (it.hasNext()) {
                Preconditions.checkArgument(it.next().getDetectorType() != 7, "Segmentation only works with COORDINATE_SYSTEM_ORIGINAL");
            }
        }
        this.mDetectors = new ArrayList(list);
        this.mTargetCoordinateSystem = i;
        this.mConsumer = consumer;
        this.mExecutor = executor;
        ImageProxyTransformFactory imageProxyTransformFactory = new ImageProxyTransformFactory();
        this.mImageAnalysisTransformFactory = imageProxyTransformFactory;
        imageProxyTransformFactory.setUsingRotationDegrees(true);
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public final void analyze(ImageProxy imageProxy) {
        Matrix matrix = new Matrix();
        int i = this.mTargetCoordinateSystem;
        if (i != 0) {
            Matrix matrix2 = this.mSensorToTarget;
            if (i != 2 && matrix2 == null) {
                Logger.d(TAG, "Sensor-to-target transformation is null.");
                imageProxy.close();
                return;
            }
            Matrix matrix3 = new Matrix(imageProxy.getImageInfo().getSensorToBufferTransformMatrix());
            RectF rectF = new RectF(0.0f, 0.0f, imageProxy.getWidth(), imageProxy.getHeight());
            matrix3.postConcat(TransformUtils.getRectToRect(rectF, TransformUtils.rotateRect(rectF, imageProxy.getImageInfo().getRotationDegrees()), imageProxy.getImageInfo().getRotationDegrees()));
            matrix3.invert(matrix);
            if (this.mTargetCoordinateSystem != 2) {
                matrix.postConcat(matrix2);
            }
        }
        detectRecursively(imageProxy, 0, matrix, new HashMap(), new HashMap());
    }

    private void detectRecursively(final ImageProxy imageProxy, final int i, final Matrix matrix, final Map<Detector<?>, Object> map, final Map<Detector<?>, Throwable> map2) {
        Image image = imageProxy.getImage();
        if (image == null) {
            Logger.e(TAG, "Image is null.");
            imageProxy.close();
            return;
        }
        if (i > this.mDetectors.size() - 1) {
            imageProxy.close();
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.mlkit.vision.MlKitAnalyzer$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m241x19489dab(map, imageProxy, map2);
                }
            });
            return;
        }
        final Detector<?> detector = this.mDetectors.get(i);
        try {
            detector.process(image, imageProxy.getImageInfo().getRotationDegrees(), matrix).addOnCompleteListener(this.mExecutor, new OnCompleteListener() { // from class: androidx.camera.mlkit.vision.MlKitAnalyzer$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    this.f$0.m242xdc35070a(map2, detector, map, imageProxy, i, matrix, task);
                }
            });
        } catch (Exception e) {
            map2.put(detector, new RuntimeException("Failed to process the image.", e));
            detectRecursively(imageProxy, i + 1, matrix, map, map2);
        }
    }

    /* renamed from: lambda$detectRecursively$0$androidx-camera-mlkit-vision-MlKitAnalyzer, reason: not valid java name */
    /* synthetic */ void m241x19489dab(Map map, ImageProxy imageProxy, Map map2) {
        this.mConsumer.accept(new Result(map, imageProxy.getImageInfo().getTimestamp(), map2));
    }

    /* renamed from: lambda$detectRecursively$1$androidx-camera-mlkit-vision-MlKitAnalyzer, reason: not valid java name */
    /* synthetic */ void m242xdc35070a(Map map, Detector detector, Map map2, ImageProxy imageProxy, int i, Matrix matrix, Task task) {
        if (task.isCanceled()) {
            map.put(detector, new CancellationException("The task is canceled."));
        } else if (task.isSuccessful()) {
            map2.put(detector, task.getResult());
        } else {
            map.put(detector, task.getException());
        }
        detectRecursively(imageProxy, i + 1, matrix, map2, map);
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public final Size getDefaultTargetResolution() {
        Size size = DEFAULT_SIZE;
        Iterator<Detector<?>> it = this.mDetectors.iterator();
        while (it.hasNext()) {
            Size targetResolution = getTargetResolution(it.next().getDetectorType());
            if (targetResolution.getHeight() * targetResolution.getWidth() > size.getWidth() * size.getHeight()) {
                size = targetResolution;
            }
        }
        return size;
    }

    private Size getTargetResolution(int i) {
        if (i == 1 || i == 4) {
            return new Size(1280, 720);
        }
        return DEFAULT_SIZE;
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public final int getTargetCoordinateSystem() {
        return this.mTargetCoordinateSystem;
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public final void updateTransform(Matrix matrix) {
        if (matrix == null) {
            this.mSensorToTarget = null;
        } else {
            this.mSensorToTarget = new Matrix(matrix);
        }
    }

    public static final class Result {
        private final Map<Detector<?>, Throwable> mThrowables;
        private final long mTimestamp;
        private final Map<Detector<?>, Object> mValues;

        public Result(Map<Detector<?>, Object> map, long j, Map<Detector<?>, Throwable> map2) {
            this.mValues = map;
            this.mThrowables = map2;
            this.mTimestamp = j;
        }

        public <T> T getValue(Detector<T> detector) {
            checkDetectorExists(detector);
            return (T) this.mValues.get(detector);
        }

        public Throwable getThrowable(Detector<?> detector) {
            checkDetectorExists(detector);
            return this.mThrowables.get(detector);
        }

        public long getTimestamp() {
            return this.mTimestamp;
        }

        private void checkDetectorExists(Detector<?> detector) {
            Preconditions.checkArgument(this.mValues.containsKey(detector) || this.mThrowables.containsKey(detector), "The detector does not exist");
        }
    }
}
