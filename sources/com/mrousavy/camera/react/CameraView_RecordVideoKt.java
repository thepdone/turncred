package com.mrousavy.camera.react;

import androidx.core.content.ContextCompat;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableMap;
import com.mrousavy.camera.core.CameraError;
import com.mrousavy.camera.core.CameraNotReadyError;
import com.mrousavy.camera.core.CameraSession_VideoKt;
import com.mrousavy.camera.core.MicrophonePermissionError;
import com.mrousavy.camera.core.NoRecordingInProgressError;
import com.mrousavy.camera.core.RecordingInProgressError;
import com.mrousavy.camera.core.VideoNotEnabledError;
import com.mrousavy.camera.core.types.RecordVideoOptions;
import com.mrousavy.camera.core.types.Video;
import com.mrousavy.camera.react.utils.CallbackPromiseKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraView+RecordVideo.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0002¨\u0006\u000b"}, d2 = {"cancelRecording", "", "Lcom/mrousavy/camera/react/CameraView;", "pauseRecording", "resumeRecording", "startRecording", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lcom/mrousavy/camera/core/types/RecordVideoOptions;", "onRecordCallback", "Lcom/facebook/react/bridge/Callback;", "stopRecording", "react-native-vision-camera_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraView_RecordVideoKt {
    public static final void startRecording(CameraView cameraView, RecordVideoOptions options, final Callback onRecordCallback) throws RecordingInProgressError, MicrophonePermissionError, VideoNotEnabledError, CameraNotReadyError {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(onRecordCallback, "onRecordCallback");
        if (cameraView.getAudio() && ContextCompat.checkSelfPermission(cameraView.getContext(), "android.permission.RECORD_AUDIO") != 0) {
            throw new MicrophonePermissionError();
        }
        CameraSession_VideoKt.startRecording(cameraView.getCameraSession(), cameraView.getAudio(), options, new Function1<Video, Unit>() { // from class: com.mrousavy.camera.react.CameraView_RecordVideoKt$startRecording$callback$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Video video) {
                invoke2(video);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Video video) {
                Intrinsics.checkNotNullParameter(video, "video");
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putString("path", video.getPath());
                writableMapCreateMap.putDouble("duration", video.getDurationMs() / 1000.0d);
                writableMapCreateMap.putInt("width", video.getSize().getWidth());
                writableMapCreateMap.putInt("height", video.getSize().getHeight());
                onRecordCallback.invoke(writableMapCreateMap, null);
            }
        }, new Function1<CameraError, Unit>() { // from class: com.mrousavy.camera.react.CameraView_RecordVideoKt$startRecording$onError$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CameraError cameraError) {
                invoke2(cameraError);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CameraError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onRecordCallback.invoke(null, CallbackPromiseKt.makeErrorMap$default(error.getCode(), error.getMessage(), null, null, 12, null));
            }
        });
    }

    public static final void pauseRecording(CameraView cameraView) throws NoRecordingInProgressError {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        CameraSession_VideoKt.pauseRecording(cameraView.getCameraSession());
    }

    public static final void resumeRecording(CameraView cameraView) throws NoRecordingInProgressError {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        CameraSession_VideoKt.resumeRecording(cameraView.getCameraSession());
    }

    public static final void stopRecording(CameraView cameraView) throws NoRecordingInProgressError {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        CameraSession_VideoKt.stopRecording(cameraView.getCameraSession());
    }

    public static final void cancelRecording(CameraView cameraView) throws NoRecordingInProgressError {
        Intrinsics.checkNotNullParameter(cameraView, "<this>");
        CameraSession_VideoKt.cancelRecording(cameraView.getCameraSession());
    }
}
