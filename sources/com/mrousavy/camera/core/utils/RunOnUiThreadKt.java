package com.mrousavy.camera.core.utils;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.UiThreadUtil;
import io.sentry.protocol.SentryStackFrame;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: runOnUiThread.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u000e\b\u0004\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0086\bø\u0001\u0000\u001a$\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u000e\b\u0004\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0003H\u0086H¢\u0006\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, d2 = {"runOnUiThread", "", SentryStackFrame.JsonKeys.FUNCTION, "Lkotlin/Function0;", "runOnUiThreadAndWait", ExifInterface.GPS_DIRECTION_TRUE, "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "react-native-vision-camera_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RunOnUiThreadKt {
    public static final <T> Object runOnUiThreadAndWait(Function0<? extends T> function0, Continuation<? super T> continuation) {
        if (UiThreadUtil.isOnUiThread()) {
            return function0.invoke();
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        UiThreadUtil.runOnUiThread(new RunOnUiThreadKt$runOnUiThreadAndWait$2$1(cancellableContinuationImpl, function0));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private static final <T> Object runOnUiThreadAndWait$$forInline(Function0<? extends T> function0, Continuation<? super T> continuation) {
        if (UiThreadUtil.isOnUiThread()) {
            return function0.invoke();
        }
        InlineMarker.mark(0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        UiThreadUtil.runOnUiThread(new RunOnUiThreadKt$runOnUiThreadAndWait$2$1(cancellableContinuationImpl, function0));
        Unit unit = Unit.INSTANCE;
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return result;
    }

    public static final void runOnUiThread(final Function0<Unit> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        if (UiThreadUtil.isOnUiThread()) {
            function.invoke();
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.mrousavy.camera.core.utils.RunOnUiThreadKt.runOnUiThread.1
                @Override // java.lang.Runnable
                public final void run() {
                    function.invoke();
                }
            });
        }
    }
}
