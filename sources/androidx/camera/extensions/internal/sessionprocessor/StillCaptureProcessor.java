package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.OutputSurface;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.extensions.impl.CaptureProcessorImpl;
import androidx.camera.extensions.impl.ProcessResultImpl;
import androidx.camera.extensions.internal.ClientVersion;
import androidx.camera.extensions.internal.ExtensionVersion;
import androidx.camera.extensions.internal.Version;
import androidx.camera.extensions.internal.compat.workaround.CaptureOutputSurfaceForCaptureProcessor;
import androidx.camera.extensions.internal.sessionprocessor.CaptureResultImageMatcher;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class StillCaptureProcessor {
    private static final String TAG = "StillCaptureProcessor";
    private static final long UNSPECIFIED_TIMESTAMP = -1;
    CaptureOutputSurfaceForCaptureProcessor mCaptureOutputSurface;
    final CaptureProcessorImpl mCaptureProcessorImpl;
    private boolean mIsPostviewConfigured;
    final CaptureResultImageMatcher mCaptureResultImageMatcher = new CaptureResultImageMatcher();
    final Object mLock = new Object();
    HashMap<Integer, Pair<ImageReference, TotalCaptureResult>> mCaptureResults = new HashMap<>();
    OnCaptureResultCallback mOnCaptureResultCallback = null;
    TotalCaptureResult mSourceCaptureResult = null;
    boolean mIsClosed = false;
    long mTimeStampForOutputImage = -1;

    interface OnCaptureResultCallback {
        void onCaptureCompleted(long j, List<Pair<CaptureResult.Key, Object>> list);

        void onCaptureProcessProgressed(int i);

        void onError(Exception exc);

        void onProcessCompleted();
    }

    StillCaptureProcessor(CaptureProcessorImpl captureProcessorImpl, Surface surface, Size size, OutputSurface outputSurface, boolean z) {
        this.mCaptureProcessorImpl = captureProcessorImpl;
        CaptureOutputSurfaceForCaptureProcessor captureOutputSurfaceForCaptureProcessor = new CaptureOutputSurfaceForCaptureProcessor(surface, size, z);
        this.mCaptureOutputSurface = captureOutputSurfaceForCaptureProcessor;
        captureProcessorImpl.onOutputSurface(captureOutputSurfaceForCaptureProcessor.getSurface(), 35);
        captureProcessorImpl.onImageFormatUpdate(35);
        this.mIsPostviewConfigured = outputSurface != null;
        if (outputSurface != null && ClientVersion.isMinimumCompatibleVersion(Version.VERSION_1_4) && ExtensionVersion.isMinimumCompatibleVersion(Version.VERSION_1_4)) {
            Preconditions.checkArgument(outputSurface.getImageFormat() == 35);
            captureProcessorImpl.onResolutionUpdate(size, outputSurface.getSize());
            captureProcessorImpl.onPostviewOutputSurface(outputSurface.getSurface());
            return;
        }
        captureProcessorImpl.onResolutionUpdate(size);
    }

    void clearCaptureResults() {
        synchronized (this.mLock) {
            Iterator<Pair<ImageReference, TotalCaptureResult>> it = this.mCaptureResults.values().iterator();
            while (it.hasNext()) {
                ((ImageReference) it.next().first).decrement();
            }
            this.mCaptureResults.clear();
        }
    }

    void startCapture(final boolean z, final List<Integer> list, final OnCaptureResultCallback onCaptureResultCallback) {
        Logger.d(TAG, "Start the capture: enablePostview=" + z);
        this.mTimeStampForOutputImage = -1L;
        synchronized (this.mLock) {
            Preconditions.checkState(!this.mIsClosed, "StillCaptureProcessor is closed. Can't invoke startCapture()");
            this.mOnCaptureResultCallback = onCaptureResultCallback;
            clearCaptureResults();
        }
        this.mCaptureResultImageMatcher.clear();
        this.mCaptureResultImageMatcher.setImageReferenceListener(new CaptureResultImageMatcher.ImageReferenceListener() { // from class: androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor$$ExternalSyntheticLambda1
            @Override // androidx.camera.extensions.internal.sessionprocessor.CaptureResultImageMatcher.ImageReferenceListener
            public final void onImageReferenceIncoming(ImageReference imageReference, TotalCaptureResult totalCaptureResult, int i) {
                this.f$0.m236xbae267d5(list, onCaptureResultCallback, z, imageReference, totalCaptureResult, i);
            }
        });
    }

    /* renamed from: lambda$startCapture$0$androidx-camera-extensions-internal-sessionprocessor-StillCaptureProcessor, reason: not valid java name */
    /* synthetic */ void m236xbae267d5(List list, OnCaptureResultCallback onCaptureResultCallback, boolean z, ImageReference imageReference, TotalCaptureResult totalCaptureResult, int i) {
        synchronized (this.mLock) {
            if (this.mIsClosed) {
                imageReference.decrement();
                Logger.d(TAG, "Ignore image in closed state");
                return;
            }
            Logger.d(TAG, "onImageReferenceIncoming  captureStageId=" + i);
            this.mCaptureResults.put(Integer.valueOf(i), new Pair<>(imageReference, totalCaptureResult));
            Logger.d(TAG, "mCaptureResult has capture stage Id: " + this.mCaptureResults.keySet());
            if (this.mCaptureResults.keySet().containsAll(list)) {
                process(this.mCaptureResults, onCaptureResultCallback, z);
            }
        }
    }

    void process(Map<Integer, Pair<ImageReference, TotalCaptureResult>> map, final OnCaptureResultCallback onCaptureResultCallback, final boolean z) {
        final HashMap map2 = new HashMap();
        synchronized (this.mLock) {
            for (Integer num : map.keySet()) {
                Pair<ImageReference, TotalCaptureResult> pair = map.get(num);
                map2.put(num, new Pair(((ImageReference) pair.first).get(), (TotalCaptureResult) pair.second));
            }
        }
        CameraXExecutors.ioExecutor().execute(new Runnable() { // from class: androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m235xd81cd883(z, map2, onCaptureResultCallback);
            }
        });
    }

    /* renamed from: lambda$process$1$androidx-camera-extensions-internal-sessionprocessor-StillCaptureProcessor, reason: not valid java name */
    /* synthetic */ void m235xd81cd883(boolean z, HashMap map, final OnCaptureResultCallback onCaptureResultCallback) {
        synchronized (this.mLock) {
            try {
                try {
                } catch (Exception e) {
                    Logger.e(TAG, "mCaptureProcessorImpl.process exception ", e);
                    this.mOnCaptureResultCallback = null;
                    if (onCaptureResultCallback != null) {
                        onCaptureResultCallback.onError(e);
                    }
                    Logger.d(TAG, "CaptureProcessorImpl.process() finish");
                    OnCaptureResultCallback onCaptureResultCallback2 = this.mOnCaptureResultCallback;
                    if (onCaptureResultCallback2 != null) {
                        onCaptureResultCallback2.onProcessCompleted();
                        this.mOnCaptureResultCallback = null;
                    }
                }
                if (this.mIsClosed) {
                    Logger.d(TAG, "Ignore process() in closed state.");
                    return;
                }
                Logger.d(TAG, "CaptureProcessorImpl.process() begin");
                if (ExtensionVersion.isMinimumCompatibleVersion(Version.VERSION_1_4) && ClientVersion.isMinimumCompatibleVersion(Version.VERSION_1_4) && z && this.mIsPostviewConfigured) {
                    this.mCaptureProcessorImpl.processWithPostview(map, new ProcessResultImpl() { // from class: androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor.1
                        public void onCaptureCompleted(long j, List<Pair<CaptureResult.Key, Object>> list) {
                            onCaptureResultCallback.onCaptureCompleted(j, list);
                        }

                        public void onCaptureProcessProgressed(int i) {
                            onCaptureResultCallback.onCaptureProcessProgressed(i);
                        }
                    }, CameraXExecutors.directExecutor());
                } else if (ExtensionVersion.isMinimumCompatibleVersion(Version.VERSION_1_3) && ClientVersion.isMinimumCompatibleVersion(Version.VERSION_1_3)) {
                    this.mCaptureProcessorImpl.process(map, new ProcessResultImpl() { // from class: androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor.2
                        public void onCaptureCompleted(long j, List<Pair<CaptureResult.Key, Object>> list) {
                            onCaptureResultCallback.onCaptureCompleted(j, list);
                        }

                        public void onCaptureProcessProgressed(int i) {
                            onCaptureResultCallback.onCaptureProcessProgressed(i);
                        }
                    }, CameraXExecutors.directExecutor());
                } else {
                    this.mCaptureProcessorImpl.process(map);
                }
                Logger.d(TAG, "CaptureProcessorImpl.process() finish");
                OnCaptureResultCallback onCaptureResultCallback3 = this.mOnCaptureResultCallback;
                if (onCaptureResultCallback3 != null) {
                    onCaptureResultCallback3.onProcessCompleted();
                    this.mOnCaptureResultCallback = null;
                }
                clearCaptureResults();
            } finally {
                Logger.d(TAG, "CaptureProcessorImpl.process() finish");
                OnCaptureResultCallback onCaptureResultCallback4 = this.mOnCaptureResultCallback;
                if (onCaptureResultCallback4 != null) {
                    onCaptureResultCallback4.onProcessCompleted();
                    this.mOnCaptureResultCallback = null;
                }
                clearCaptureResults();
            }
        }
    }

    void notifyCaptureResult(TotalCaptureResult totalCaptureResult, int i) {
        Long l;
        this.mCaptureResultImageMatcher.captureResultIncoming(totalCaptureResult, i);
        if (this.mTimeStampForOutputImage == -1 && (l = (Long) totalCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP)) != null) {
            long jLongValue = l.longValue();
            this.mTimeStampForOutputImage = jLongValue;
            this.mCaptureOutputSurface.setOutputImageTimestamp(jLongValue);
        }
        synchronized (this.mLock) {
            if (this.mSourceCaptureResult == null) {
                this.mSourceCaptureResult = totalCaptureResult;
            }
        }
    }

    void notifyImage(ImageReference imageReference) {
        this.mCaptureResultImageMatcher.imageIncoming(imageReference);
    }

    void close() {
        synchronized (this.mLock) {
            Logger.d(TAG, "Close the StillCaptureProcessor");
            this.mIsClosed = true;
            clearCaptureResults();
            this.mCaptureResultImageMatcher.clearImageReferenceListener();
            this.mCaptureResultImageMatcher.clear();
            this.mCaptureOutputSurface.close();
        }
    }
}
