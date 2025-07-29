package com.mrousavy.camera.core.utils;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: runOnUiThread.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "run"}, k = 3, mv = {1, 9, 0}, xi = 176)
/* loaded from: classes5.dex */
public final class RunOnUiThreadKt$runOnUiThreadAndWait$2$1 implements Runnable {
    final /* synthetic */ CancellableContinuation<T> $continuation;
    final /* synthetic */ Function0<T> $function;

    /* JADX WARN: Multi-variable type inference failed */
    public RunOnUiThreadKt$runOnUiThreadAndWait$2$1(CancellableContinuation<? super T> cancellableContinuation, Function0<? extends T> function0) {
        this.$continuation = cancellableContinuation;
        this.$function = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.$continuation.isCancelled()) {
            throw new CancellationException();
        }
        Object objInvoke = this.$function.invoke();
        Continuation continuation = this.$continuation;
        Result.Companion companion = Result.INSTANCE;
        continuation.resumeWith(Result.m5937constructorimpl(objInvoke));
    }
}
