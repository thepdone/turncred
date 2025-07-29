package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequest;
import io.sentry.rrweb.RRWebVideoEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestProgress.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\u0011R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/facebook/RequestProgress;", "", "callbackHandler", "Landroid/os/Handler;", "request", "Lcom/facebook/GraphRequest;", "(Landroid/os/Handler;Lcom/facebook/GraphRequest;)V", "lastReportedProgress", "", "<set-?>", "maxProgress", "getMaxProgress", "()J", "progress", "getProgress", "threshold", "addProgress", "", RRWebVideoEvent.JsonKeys.SIZE, "addToMax", "reportProgress", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RequestProgress {
    private final Handler callbackHandler;
    private long lastReportedProgress;
    private long maxProgress;
    private long progress;
    private final GraphRequest request;
    private final long threshold;

    public RequestProgress(Handler handler, GraphRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.callbackHandler = handler;
        this.request = request;
        this.threshold = FacebookSdk.getOnProgressThreshold();
    }

    public final long getProgress() {
        return this.progress;
    }

    public final long getMaxProgress() {
        return this.maxProgress;
    }

    public final void addProgress(long size) {
        long j = this.progress + size;
        this.progress = j;
        if (j >= this.lastReportedProgress + this.threshold || j >= this.maxProgress) {
            reportProgress();
        }
    }

    public final void addToMax(long size) {
        this.maxProgress += size;
    }

    public final void reportProgress() {
        if (this.progress > this.lastReportedProgress) {
            final GraphRequest.Callback callback = this.request.getCallback();
            final long j = this.maxProgress;
            if (j <= 0 || !(callback instanceof GraphRequest.OnProgressCallback)) {
                return;
            }
            final long j2 = this.progress;
            Handler handler = this.callbackHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.facebook.RequestProgress$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        RequestProgress.reportProgress$lambda$0(callback, j2, j);
                    }
                });
            } else {
                ((GraphRequest.OnProgressCallback) callback).onProgress(j2, j);
            }
            this.lastReportedProgress = this.progress;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportProgress$lambda$0(GraphRequest.Callback callback, long j, long j2) {
        ((GraphRequest.OnProgressCallback) callback).onProgress(j, j2);
    }
}
