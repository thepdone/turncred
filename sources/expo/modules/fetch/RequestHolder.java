package expo.modules.fetch;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;

/* compiled from: NativeRequest.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lexpo/modules/fetch/RequestHolder;", "", "request", "Lokhttp3/Request;", "(Lokhttp3/Request;)V", "getRequest", "()Lokhttp3/Request;", "setRequest", "component1", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "expo_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* data */ class RequestHolder {
    private Request request;

    public static /* synthetic */ RequestHolder copy$default(RequestHolder requestHolder, Request request, int i, Object obj) {
        if ((i & 1) != 0) {
            request = requestHolder.request;
        }
        return requestHolder.copy(request);
    }

    /* renamed from: component1, reason: from getter */
    public final Request getRequest() {
        return this.request;
    }

    public final RequestHolder copy(Request request) {
        return new RequestHolder(request);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RequestHolder) && Intrinsics.areEqual(this.request, ((RequestHolder) other).request);
    }

    public int hashCode() {
        Request request = this.request;
        if (request == null) {
            return 0;
        }
        return request.hashCode();
    }

    public String toString() {
        return "RequestHolder(request=" + this.request + ")";
    }

    public RequestHolder(Request request) {
        this.request = request;
    }

    public final Request getRequest() {
        return this.request;
    }

    public final void setRequest(Request request) {
        this.request = request;
    }
}
