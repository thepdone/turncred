package com.mrousavy.camera.core;

import android.media.Image;
import android.util.Log;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import com.mrousavy.camera.core.CameraConfiguration;
import com.mrousavy.camera.core.CameraSession;
import com.mrousavy.camera.core.types.CodeType;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CodeScannerPipeline.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0013B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\b\u0010\u0012\u001a\u00020\u000fH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/mrousavy/camera/core/CodeScannerPipeline;", "Ljava/io/Closeable;", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "configuration", "Lcom/mrousavy/camera/core/CameraConfiguration$CodeScanner;", "callback", "Lcom/mrousavy/camera/core/CameraSession$Callback;", "(Lcom/mrousavy/camera/core/CameraConfiguration$CodeScanner;Lcom/mrousavy/camera/core/CameraSession$Callback;)V", "getCallback", "()Lcom/mrousavy/camera/core/CameraSession$Callback;", "getConfiguration", "()Lcom/mrousavy/camera/core/CameraConfiguration$CodeScanner;", "scanner", "Lcom/google/mlkit/vision/barcode/BarcodeScanner;", "analyze", "", "imageProxy", "Landroidx/camera/core/ImageProxy;", "close", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CodeScannerPipeline implements Closeable, ImageAnalysis.Analyzer {
    private static final String TAG = "CodeScannerPipeline";
    private final CameraSession.Callback callback;
    private final CameraConfiguration.CodeScanner configuration;
    private final BarcodeScanner scanner;

    public CodeScannerPipeline(CameraConfiguration.CodeScanner configuration, CameraSession.Callback callback) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.configuration = configuration;
        this.callback = callback;
        List<CodeType> codeTypes = configuration.getCodeTypes();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(codeTypes, 10));
        Iterator<T> it = codeTypes.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((CodeType) it.next()).toBarcodeType()));
        }
        ArrayList arrayList2 = arrayList;
        BarcodeScannerOptions.Builder builder = new BarcodeScannerOptions.Builder();
        int iIntValue = ((Number) arrayList2.get(0)).intValue();
        int[] intArray = CollectionsKt.toIntArray(arrayList2);
        BarcodeScannerOptions barcodeScannerOptionsBuild = builder.setBarcodeFormats(iIntValue, Arrays.copyOf(intArray, intArray.length)).build();
        Intrinsics.checkNotNullExpressionValue(barcodeScannerOptionsBuild, "build(...)");
        BarcodeScanner client = BarcodeScanning.getClient(barcodeScannerOptionsBuild);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
        this.scanner = client;
    }

    public final CameraSession.Callback getCallback() {
        return this.callback;
    }

    public final CameraConfiguration.CodeScanner getConfiguration() {
        return this.configuration;
    }

    @Override // androidx.camera.core.ImageAnalysis.Analyzer
    public void analyze(final ImageProxy imageProxy) throws InvalidImageTypeError {
        Intrinsics.checkNotNullParameter(imageProxy, "imageProxy");
        Image image = imageProxy.getImage();
        if (image == null) {
            throw new InvalidImageTypeError();
        }
        try {
            final InputImage inputImageFromMediaImage = InputImage.fromMediaImage(image, imageProxy.getImageInfo().getRotationDegrees());
            Intrinsics.checkNotNullExpressionValue(inputImageFromMediaImage, "fromMediaImage(...)");
            Task<List<Barcode>> taskProcess = this.scanner.process(inputImageFromMediaImage);
            final Function1<List<Barcode>, Unit> function1 = new Function1<List<Barcode>, Unit>() { // from class: com.mrousavy.camera.core.CodeScannerPipeline.analyze.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<Barcode> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<Barcode> list) {
                    Intrinsics.checkNotNull(list);
                    if (list.isEmpty()) {
                        return;
                    }
                    CodeScannerPipeline.this.getCallback().onCodeScanned(list, new CodeScannerFrame(inputImageFromMediaImage.getWidth(), inputImageFromMediaImage.getHeight()));
                }
            };
            taskProcess.addOnSuccessListener(new OnSuccessListener() { // from class: com.mrousavy.camera.core.CodeScannerPipeline$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    CodeScannerPipeline.analyze$lambda$1(function1, obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.mrousavy.camera.core.CodeScannerPipeline$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    CodeScannerPipeline.analyze$lambda$2(this.f$0, exc);
                }
            }).addOnCompleteListener(new OnCompleteListener() { // from class: com.mrousavy.camera.core.CodeScannerPipeline$$ExternalSyntheticLambda2
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    CodeScannerPipeline.analyze$lambda$3(imageProxy, task);
                }
            });
        } catch (Throwable th) {
            Log.e(TAG, "Failed to process Image!", th);
            imageProxy.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void analyze$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void analyze$lambda$2(CodeScannerPipeline this$0, Exception error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "error");
        Exception exc = error;
        Log.e(TAG, "Failed to process Image!", exc);
        this$0.callback.onError(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void analyze$lambda$3(ImageProxy imageProxy, Task it) {
        Intrinsics.checkNotNullParameter(imageProxy, "$imageProxy");
        Intrinsics.checkNotNullParameter(it, "it");
        imageProxy.close();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.scanner.close();
    }
}
