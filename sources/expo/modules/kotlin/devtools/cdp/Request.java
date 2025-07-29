package expo.modules.kotlin.devtools.cdp;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import expo.modules.kotlin.devtools.OkHttpExtensionsKt;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okhttp3.RequestBody;
import okio.Buffer;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CdpNetworkTypes.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B7\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tj\u0002`\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\fJ\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u0019\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tj\u0002`\nHÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003JC\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tj\u0002`\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\t\u0010 \u001a\u00020\u0006HÖ\u0001R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\tj\u0002`\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006!"}, d2 = {"Lexpo/modules/kotlin/devtools/cdp/Request;", "Lexpo/modules/kotlin/devtools/cdp/JsonSerializable;", "request", "Lokhttp3/Request;", "(Lokhttp3/Request;)V", "url", "", "method", "headers", "", "Lexpo/modules/kotlin/devtools/cdp/Headers;", "postData", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "getHeaders", "()Ljava/util/Map;", "getMethod", "()Ljava/lang/String;", "getPostData", "getUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toJSONObject", "Lorg/json/JSONObject;", InAppPurchaseConstants.METHOD_TO_STRING, "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Request implements JsonSerializable {
    public static final int $stable = 8;
    private final Map<String, String> headers;
    private final String method;
    private final String postData;
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Request copy$default(Request request, String str, String str2, Map map, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = request.url;
        }
        if ((i & 2) != 0) {
            str2 = request.method;
        }
        if ((i & 4) != 0) {
            map = request.headers;
        }
        if ((i & 8) != 0) {
            str3 = request.postData;
        }
        return request.copy(str, str2, map, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    public final Map<String, String> component3() {
        return this.headers;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPostData() {
        return this.postData;
    }

    public final Request copy(String url, String method, Map<String, String> headers, String postData) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        return new Request(url, method, headers, postData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Request)) {
            return false;
        }
        Request request = (Request) other;
        return Intrinsics.areEqual(this.url, request.url) && Intrinsics.areEqual(this.method, request.method) && Intrinsics.areEqual(this.headers, request.headers) && Intrinsics.areEqual(this.postData, request.postData);
    }

    public int hashCode() {
        int iHashCode = ((((this.url.hashCode() * 31) + this.method.hashCode()) * 31) + this.headers.hashCode()) * 31;
        String str = this.postData;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Request(url=" + this.url + ", method=" + this.method + ", headers=" + this.headers + ", postData=" + this.postData + ")";
    }

    public Request(String url, String method, Map<String, String> headers, String str) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.postData = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getMethod() {
        return this.method;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final String getPostData() {
        return this.postData;
    }

    public Request(okhttp3.Request request) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        String url = request.url().getUrl();
        String strMethod = request.method();
        Map<String, String> singleMap = OkHttpExtensionsKt.toSingleMap(request.headers());
        RequestBody requestBodyBody = request.body();
        String utf8 = null;
        if (requestBodyBody != null && requestBodyBody.contentLength() < 1048576) {
            Buffer buffer = new Buffer();
            requestBodyBody.writeTo(buffer);
            utf8 = buffer.readUtf8(RangesKt.coerceAtMost(buffer.size(), 1048576L));
        }
        this(url, strMethod, singleMap, utf8);
    }

    @Override // expo.modules.kotlin.devtools.cdp.JsonSerializable
    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", this.url);
        jSONObject.put("method", this.method);
        jSONObject.put("headers", new JSONObject(this.headers));
        String str = this.postData;
        if (str != null) {
            jSONObject.put("postData", str);
        }
        return jSONObject;
    }
}
