package com.mrousavy.camera.core;

import android.media.AudioManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: CameraSession+Photo.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\t\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\n"}, d2 = {"isSilent", "", "Landroid/media/AudioManager;", "(Landroid/media/AudioManager;)Z", "takePhoto", "Lcom/mrousavy/camera/core/Photo;", "Lcom/mrousavy/camera/core/CameraSession;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lcom/mrousavy/camera/core/types/TakePhotoOptions;", "(Lcom/mrousavy/camera/core/CameraSession;Lcom/mrousavy/camera/core/types/TakePhotoOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "react-native-vision-camera_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraSession_PhotoKt {

    /* compiled from: CameraSession+Photo.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.mrousavy.camera.core.CameraSession_PhotoKt", f = "CameraSession+Photo.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {48}, m = "takePhoto", n = {"photoOutput", "$this$takePicture$iv", "file$iv", "metadataProvider$iv", "callback$iv", "executor$iv", "enableShutterSound", "isMirrored"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "Z$0"})
    /* renamed from: com.mrousavy.camera.core.CameraSession_PhotoKt$takePhoto$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CameraSession_PhotoKt.takePhoto(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object takePhoto(com.mrousavy.camera.core.CameraSession r17, com.mrousavy.camera.core.types.TakePhotoOptions r18, kotlin.coroutines.Continuation<? super com.mrousavy.camera.core.Photo> r19) {
        /*
            Method dump skipped, instructions count: 475
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraSession_PhotoKt.takePhoto(com.mrousavy.camera.core.CameraSession, com.mrousavy.camera.core.types.TakePhotoOptions, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final boolean isSilent(AudioManager audioManager) {
        return audioManager.getRingerMode() != 2;
    }
}
