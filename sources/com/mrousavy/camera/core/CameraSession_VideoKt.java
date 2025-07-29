package com.mrousavy.camera.core;

import android.location.Location;
import android.util.Log;
import android.util.Size;
import androidx.camera.video.FileOutputOptions;
import androidx.camera.video.PendingRecording;
import androidx.camera.video.Recorder;
import androidx.camera.video.Recording;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.VideoRecordEvent;
import androidx.core.util.Consumer;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mrousavy.camera.core.extensions.VideoRecordEvent_toCameraErrorKt;
import com.mrousavy.camera.core.types.RecordVideoOptions;
import com.mrousavy.camera.core.types.Video;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraSession+Video.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001ab\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\u000b2!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00010\u000bH\u0007\u001a\n\u0010\u0013\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0014"}, d2 = {"cancelRecording", "", "Lcom/mrousavy/camera/core/CameraSession;", "pauseRecording", "resumeRecording", "startRecording", "enableAudio", "", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lcom/mrousavy/camera/core/types/RecordVideoOptions;", "callback", "Lkotlin/Function1;", "Lcom/mrousavy/camera/core/types/Video;", "Lkotlin/ParameterName;", "name", "video", "onError", "Lcom/mrousavy/camera/core/CameraError;", "error", "stopRecording", "react-native-vision-camera_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraSession_VideoKt {
    public static final void startRecording(final CameraSession cameraSession, boolean z, final RecordVideoOptions options, final Function1<? super Video, Unit> callback, final Function1<? super CameraError, Unit> onError) throws RecordingInProgressError, MicrophonePermissionError, VideoNotEnabledError, CameraNotReadyError {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (cameraSession.getCamera() == null) {
            throw new CameraNotReadyError();
        }
        if (cameraSession.getRecording() != null) {
            throw new RecordingInProgressError();
        }
        final VideoCapture<Recorder> videoOutput$react_native_vision_camera_release = cameraSession.getVideoOutput$react_native_vision_camera_release();
        if (videoOutput$react_native_vision_camera_release == null) {
            throw new VideoNotEnabledError();
        }
        FileOutputOptions.Builder builder = new FileOutputOptions.Builder(options.getFile().getFile());
        Location location = cameraSession.getMetadataProvider().getLocation();
        if (location != null) {
            Log.i(CameraSession.TAG, "Setting Video Location to " + location.getLatitude() + ", " + location.getLongitude() + "...");
            builder.setLocation(location);
        }
        FileOutputOptions fileOutputOptionsBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(fileOutputOptionsBuild, "build(...)");
        PendingRecording pendingRecordingPrepareRecording = ((Recorder) videoOutput$react_native_vision_camera_release.getOutput()).prepareRecording(cameraSession.getContext(), fileOutputOptionsBuild);
        Intrinsics.checkNotNullExpressionValue(pendingRecordingPrepareRecording, "prepareRecording(...)");
        if (z) {
            cameraSession.checkMicrophonePermission$react_native_vision_camera_release();
            pendingRecordingPrepareRecording = PendingRecording.withAudioEnabled$default(pendingRecordingPrepareRecording, false, 1, null);
        }
        PendingRecording pendingRecordingAsPersistentRecording = pendingRecordingPrepareRecording.asPersistentRecording();
        cameraSession.setRecordingCanceled$react_native_vision_camera_release(false);
        cameraSession.setRecording$react_native_vision_camera_release(pendingRecordingAsPersistentRecording.start(CameraQueues.INSTANCE.getCameraExecutor(), new Consumer() { // from class: com.mrousavy.camera.core.CameraSession_VideoKt$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) throws UnknownRecorderError {
                CameraSession_VideoKt.startRecording$lambda$2(cameraSession, onError, options, videoOutput$react_native_vision_camera_release, callback, (VideoRecordEvent) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startRecording$lambda$2(CameraSession this_startRecording, Function1 onError, RecordVideoOptions options, VideoCapture videoOutput, Function1 callback, VideoRecordEvent videoRecordEvent) throws UnknownRecorderError {
        Intrinsics.checkNotNullParameter(this_startRecording, "$this_startRecording");
        Intrinsics.checkNotNullParameter(onError, "$onError");
        Intrinsics.checkNotNullParameter(options, "$options");
        Intrinsics.checkNotNullParameter(videoOutput, "$videoOutput");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (videoRecordEvent instanceof VideoRecordEvent.Start) {
            Log.i(CameraSession.TAG, "Recording started!");
            return;
        }
        if (videoRecordEvent instanceof VideoRecordEvent.Resume) {
            Log.i(CameraSession.TAG, "Recording resumed!");
            return;
        }
        if (videoRecordEvent instanceof VideoRecordEvent.Pause) {
            Log.i(CameraSession.TAG, "Recording paused!");
            return;
        }
        if (videoRecordEvent instanceof VideoRecordEvent.Status) {
            Log.i(CameraSession.TAG, "Status update! Recorded " + ((VideoRecordEvent.Status) videoRecordEvent).getRecordingStats().getNumBytesRecorded() + " bytes.");
            return;
        }
        if (videoRecordEvent instanceof VideoRecordEvent.Finalize) {
            if (this_startRecording.getIsRecordingCanceled()) {
                Log.i(CameraSession.TAG, "Recording was canceled, deleting file..");
                onError.invoke(new RecordingCanceledError());
                try {
                    options.getFile().getFile().delete();
                    return;
                } catch (Throwable th) {
                    this_startRecording.getCallback().onError(new FileIOError(th));
                    return;
                }
            }
            Log.i(CameraSession.TAG, "Recording stopped!");
            Intrinsics.checkNotNull(videoRecordEvent);
            VideoRecordEvent.Finalize finalize = (VideoRecordEvent.Finalize) videoRecordEvent;
            RecorderError cameraError = VideoRecordEvent_toCameraErrorKt.getCameraError(finalize);
            if (cameraError != null) {
                if (cameraError.getWasVideoRecorded()) {
                    Log.e(CameraSession.TAG, "Video Recorder encountered an error, but the video was recorded anyways.", cameraError);
                } else {
                    Log.e(CameraSession.TAG, "Video Recorder encountered a fatal error!", cameraError);
                    onError.invoke(cameraError);
                    return;
                }
            }
            long recordedDurationNanos = finalize.getRecordingStats().getRecordedDurationNanos() / 1000000;
            Log.i(CameraSession.TAG, "Successfully completed video recording! Captured " + (recordedDurationNanos / 1000.0d) + " seconds.");
            String path = finalize.getOutputResults().getOutputUri().getPath();
            if (path == null) {
                throw new UnknownRecorderError(false, null);
            }
            Size attachedSurfaceResolution = videoOutput.getAttachedSurfaceResolution();
            if (attachedSurfaceResolution == null) {
                attachedSurfaceResolution = new Size(0, 0);
            }
            callback.invoke(new Video(path, recordedDurationNanos, attachedSurfaceResolution));
        }
    }

    public static final void stopRecording(CameraSession cameraSession) throws NoRecordingInProgressError {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        Recording recording = cameraSession.getRecording();
        if (recording == null) {
            throw new NoRecordingInProgressError();
        }
        recording.stop();
        cameraSession.setRecording$react_native_vision_camera_release(null);
    }

    public static final void cancelRecording(CameraSession cameraSession) throws NoRecordingInProgressError {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        cameraSession.setRecordingCanceled$react_native_vision_camera_release(true);
        stopRecording(cameraSession);
    }

    public static final void pauseRecording(CameraSession cameraSession) throws NoRecordingInProgressError {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        Recording recording = cameraSession.getRecording();
        if (recording == null) {
            throw new NoRecordingInProgressError();
        }
        recording.pause();
    }

    public static final void resumeRecording(CameraSession cameraSession) throws NoRecordingInProgressError {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        Recording recording = cameraSession.getRecording();
        if (recording == null) {
            throw new NoRecordingInProgressError();
        }
        recording.resume();
    }
}
