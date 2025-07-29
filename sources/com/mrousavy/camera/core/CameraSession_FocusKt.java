package com.mrousavy.camera.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: CameraSession+Focus.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"focus", "", "Lcom/mrousavy/camera/core/CameraSession;", "meteringPoint", "Landroidx/camera/core/MeteringPoint;", "(Lcom/mrousavy/camera/core/CameraSession;Landroidx/camera/core/MeteringPoint;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "react-native-vision-camera_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraSession_FocusKt {

    /* compiled from: CameraSession+Focus.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.mrousavy.camera.core.CameraSession_FocusKt", f = "CameraSession+Focus.kt", i = {}, l = {22}, m = "focus", n = {}, s = {})
    /* renamed from: com.mrousavy.camera.core.CameraSession_FocusKt$focus$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CameraSession_FocusKt.focus(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object focus(com.mrousavy.camera.core.CameraSession r18, androidx.camera.core.MeteringPoint r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) throws java.lang.Throwable {
        /*
            r0 = r20
            java.lang.String r1 = "Focusing to "
            boolean r2 = r0 instanceof com.mrousavy.camera.core.CameraSession_FocusKt.AnonymousClass1
            if (r2 == 0) goto L18
            r2 = r0
            com.mrousavy.camera.core.CameraSession_FocusKt$focus$1 r2 = (com.mrousavy.camera.core.CameraSession_FocusKt.AnonymousClass1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L1d
        L18:
            com.mrousavy.camera.core.CameraSession_FocusKt$focus$1 r2 = new com.mrousavy.camera.core.CameraSession_FocusKt$focus$1
            r2.<init>(r0)
        L1d:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            java.lang.String r6 = "CameraSession"
            if (r4 == 0) goto L39
            if (r4 != r5) goto L31
            kotlin.ResultKt.throwOnFailure(r0)     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
            goto Lae
        L31:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L39:
            kotlin.ResultKt.throwOnFailure(r0)
            androidx.camera.core.Camera r0 = r18.getCamera()
            if (r0 == 0) goto Ld0
            androidx.camera.core.FocusMeteringAction$Builder r4 = new androidx.camera.core.FocusMeteringAction$Builder
            r7 = r19
            r4.<init>(r7)
            androidx.camera.core.FocusMeteringAction r4 = r4.build()
            java.lang.String r7 = "build(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
            androidx.camera.core.CameraInfo r7 = r0.getCameraInfo()
            boolean r7 = r7.isFocusMeteringSupported(r4)
            if (r7 == 0) goto Lca
            java.util.List r7 = r4.getMeteringPointsAf()     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
            java.lang.String r8 = "getMeteringPointsAf(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
            r9 = r7
            java.lang.Iterable r9 = (java.lang.Iterable) r9     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
            com.mrousavy.camera.core.CameraSession_FocusKt$focus$2 r7 = new kotlin.jvm.functions.Function1<androidx.camera.core.MeteringPoint, java.lang.CharSequence>() { // from class: com.mrousavy.camera.core.CameraSession_FocusKt.focus.2
                static {
                    /*
                        com.mrousavy.camera.core.CameraSession_FocusKt$focus$2 r0 = new com.mrousavy.camera.core.CameraSession_FocusKt$focus$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.mrousavy.camera.core.CameraSession_FocusKt$focus$2) com.mrousavy.camera.core.CameraSession_FocusKt.focus.2.INSTANCE com.mrousavy.camera.core.CameraSession_FocusKt$focus$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraSession_FocusKt.AnonymousClass2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraSession_FocusKt.AnonymousClass2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                public final java.lang.CharSequence invoke(androidx.camera.core.MeteringPoint r4) {
                    /*
                        r3 = this;
                        float r0 = r4.getX()
                        float r4 = r4.getY()
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        java.lang.String r2 = "("
                        r1.<init>(r2)
                        java.lang.StringBuilder r0 = r1.append(r0)
                        java.lang.String r1 = ", "
                        java.lang.StringBuilder r0 = r0.append(r1)
                        java.lang.StringBuilder r4 = r0.append(r4)
                        java.lang.String r0 = ")"
                        java.lang.StringBuilder r4 = r4.append(r0)
                        java.lang.String r4 = r4.toString()
                        java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraSession_FocusKt.AnonymousClass2.invoke(androidx.camera.core.MeteringPoint):java.lang.CharSequence");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ java.lang.CharSequence invoke(androidx.camera.core.MeteringPoint r1) {
                    /*
                        r0 = this;
                        androidx.camera.core.MeteringPoint r1 = (androidx.camera.core.MeteringPoint) r1
                        java.lang.CharSequence r1 = r0.invoke(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraSession_FocusKt.AnonymousClass2.invoke(java.lang.Object):java.lang.Object");
                }
            }     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
            r15 = r7
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
            r16 = 31
            r17 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            java.lang.String r7 = kotlin.collections.CollectionsKt.joinToString$default(r9, r10, r11, r12, r13, r14, r15, r16, r17)     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
            r8.<init>(r1)     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
            java.lang.StringBuilder r1 = r8.append(r7)     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
            java.lang.String r7 = "..."
            java.lang.StringBuilder r1 = r1.append(r7)     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
            java.lang.String r1 = r1.toString()     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
            android.util.Log.i(r6, r1)     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
            androidx.camera.core.CameraControl r0 = r0.getCameraControl()     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
            com.google.common.util.concurrent.ListenableFuture r0 = r0.startFocusAndMetering(r4)     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
            java.lang.String r1 = "startFocusAndMetering(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
            com.mrousavy.camera.core.CameraQueues$Companion r1 = com.mrousavy.camera.core.CameraQueues.INSTANCE     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
            java.util.concurrent.ExecutorService r1 = r1.getCameraExecutor()     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
            java.util.concurrent.Executor r1 = (java.util.concurrent.Executor) r1     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
            r2.label = r5     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
            java.lang.Object r0 = com.mrousavy.camera.core.extensions.ListenableFuture_awaitKt.await(r0, r1, r2)     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
            if (r0 != r3) goto Lae
            return r3
        Lae:
            androidx.camera.core.FocusMeteringResult r0 = (androidx.camera.core.FocusMeteringResult) r0     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
            boolean r0 = r0.isFocusSuccessful()     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
            if (r0 == 0) goto Lbc
            java.lang.String r0 = "Focused successfully!"
            android.util.Log.i(r6, r0)     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
            goto Lc1
        Lbc:
            java.lang.String r0 = "Focus failed."
            android.util.Log.i(r6, r0)     // Catch: androidx.camera.core.CameraControl.OperationCanceledException -> Lc4
        Lc1:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        Lc4:
            com.mrousavy.camera.core.FocusCanceledError r0 = new com.mrousavy.camera.core.FocusCanceledError
            r0.<init>()
            throw r0
        Lca:
            com.mrousavy.camera.core.FocusNotSupportedError r0 = new com.mrousavy.camera.core.FocusNotSupportedError
            r0.<init>()
            throw r0
        Ld0:
            com.mrousavy.camera.core.CameraNotReadyError r0 = new com.mrousavy.camera.core.CameraNotReadyError
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraSession_FocusKt.focus(com.mrousavy.camera.core.CameraSession, androidx.camera.core.MeteringPoint, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
