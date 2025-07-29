package com.facebook.react.packagerconnection;

import com.facebook.common.logging.FLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationOnlyHandler.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0018\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/facebook/react/packagerconnection/NotificationOnlyHandler;", "Lcom/facebook/react/packagerconnection/RequestHandler;", "()V", "onNotification", "", "params", "", "onRequest", "responder", "Lcom/facebook/react/packagerconnection/Responder;", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class NotificationOnlyHandler implements RequestHandler {
    @Override // com.facebook.react.packagerconnection.RequestHandler
    public abstract void onNotification(Object params);

    @Override // com.facebook.react.packagerconnection.RequestHandler
    public final void onRequest(Object params, Responder responder) {
        Intrinsics.checkNotNullParameter(responder, "responder");
        responder.error("Request is not supported");
        FLog.e("JSPackagerClient", "Request is not supported");
    }
}
