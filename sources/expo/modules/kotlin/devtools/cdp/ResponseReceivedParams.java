package expo.modules.kotlin.devtools.cdp;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.common.net.HttpHeaders;
import expo.modules.kotlin.devtools.cdp.ResourceType;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CdpNetworkTypes.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tBA\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\n\u0010\u000b\u001a\u00060\u0003j\u0002`\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\r\u0010\u001f\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\r\u0010!\u001a\u00060\u0003j\u0002`\fHÆ\u0003J\t\u0010\"\u001a\u00020\u000eHÆ\u0003J\t\u0010#\u001a\u00020\u0010HÆ\u0003J\t\u0010$\u001a\u00020\u0012HÆ\u0003JM\u0010%\u001a\u00020\u00002\f\b\u0002\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010\n\u001a\u00020\u00052\f\b\u0002\u0010\u000b\u001a\u00060\u0003j\u0002`\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u0010&\u001a\u00020\u00122\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\b\u0010+\u001a\u00020,H\u0016J\t\u0010-\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u000b\u001a\u00060\u0003j\u0002`\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Lexpo/modules/kotlin/devtools/cdp/ResponseReceivedParams;", "Lexpo/modules/kotlin/devtools/cdp/JsonSerializable;", "now", "Ljava/math/BigDecimal;", "requestId", "", "Lexpo/modules/kotlin/devtools/cdp/RequestId;", "okhttpResponse", "Lokhttp3/Response;", "(Ljava/math/BigDecimal;Ljava/lang/String;Lokhttp3/Response;)V", "loaderId", "timestamp", "Lexpo/modules/kotlin/devtools/cdp/MonotonicTime;", "type", "Lexpo/modules/kotlin/devtools/cdp/ResourceType;", io.sentry.protocol.Response.TYPE, "Lexpo/modules/kotlin/devtools/cdp/Response;", "hasExtraInfo", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;Lexpo/modules/kotlin/devtools/cdp/ResourceType;Lexpo/modules/kotlin/devtools/cdp/Response;Z)V", "getHasExtraInfo", "()Z", "getLoaderId", "()Ljava/lang/String;", "getRequestId", "getResponse", "()Lexpo/modules/kotlin/devtools/cdp/Response;", "getTimestamp", "()Ljava/math/BigDecimal;", "getType", "()Lexpo/modules/kotlin/devtools/cdp/ResourceType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toJSONObject", "Lorg/json/JSONObject;", InAppPurchaseConstants.METHOD_TO_STRING, "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ResponseReceivedParams implements JsonSerializable {
    public static final int $stable = 8;
    private final boolean hasExtraInfo;
    private final String loaderId;
    private final String requestId;
    private final Response response;
    private final BigDecimal timestamp;
    private final ResourceType type;

    public static /* synthetic */ ResponseReceivedParams copy$default(ResponseReceivedParams responseReceivedParams, String str, String str2, BigDecimal bigDecimal, ResourceType resourceType, Response response, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = responseReceivedParams.requestId;
        }
        if ((i & 2) != 0) {
            str2 = responseReceivedParams.loaderId;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            bigDecimal = responseReceivedParams.timestamp;
        }
        BigDecimal bigDecimal2 = bigDecimal;
        if ((i & 8) != 0) {
            resourceType = responseReceivedParams.type;
        }
        ResourceType resourceType2 = resourceType;
        if ((i & 16) != 0) {
            response = responseReceivedParams.response;
        }
        Response response2 = response;
        if ((i & 32) != 0) {
            z = responseReceivedParams.hasExtraInfo;
        }
        return responseReceivedParams.copy(str, str3, bigDecimal2, resourceType2, response2, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLoaderId() {
        return this.loaderId;
    }

    /* renamed from: component3, reason: from getter */
    public final BigDecimal getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component4, reason: from getter */
    public final ResourceType getType() {
        return this.type;
    }

    /* renamed from: component5, reason: from getter */
    public final Response getResponse() {
        return this.response;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getHasExtraInfo() {
        return this.hasExtraInfo;
    }

    public final ResponseReceivedParams copy(String requestId, String loaderId, BigDecimal timestamp, ResourceType type, Response response, boolean hasExtraInfo) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(loaderId, "loaderId");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(response, "response");
        return new ResponseReceivedParams(requestId, loaderId, timestamp, type, response, hasExtraInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResponseReceivedParams)) {
            return false;
        }
        ResponseReceivedParams responseReceivedParams = (ResponseReceivedParams) other;
        return Intrinsics.areEqual(this.requestId, responseReceivedParams.requestId) && Intrinsics.areEqual(this.loaderId, responseReceivedParams.loaderId) && Intrinsics.areEqual(this.timestamp, responseReceivedParams.timestamp) && this.type == responseReceivedParams.type && Intrinsics.areEqual(this.response, responseReceivedParams.response) && this.hasExtraInfo == responseReceivedParams.hasExtraInfo;
    }

    public int hashCode() {
        return (((((((((this.requestId.hashCode() * 31) + this.loaderId.hashCode()) * 31) + this.timestamp.hashCode()) * 31) + this.type.hashCode()) * 31) + this.response.hashCode()) * 31) + Boolean.hashCode(this.hasExtraInfo);
    }

    public String toString() {
        return "ResponseReceivedParams(requestId=" + this.requestId + ", loaderId=" + this.loaderId + ", timestamp=" + this.timestamp + ", type=" + this.type + ", response=" + this.response + ", hasExtraInfo=" + this.hasExtraInfo + ")";
    }

    public ResponseReceivedParams(String requestId, String loaderId, BigDecimal timestamp, ResourceType type, Response response, boolean z) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(loaderId, "loaderId");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(response, "response");
        this.requestId = requestId;
        this.loaderId = loaderId;
        this.timestamp = timestamp;
        this.type = type;
        this.response = response;
        this.hasExtraInfo = z;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public /* synthetic */ ResponseReceivedParams(String str, String str2, BigDecimal bigDecimal, ResourceType resourceType, Response response, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2, bigDecimal, resourceType, response, (i & 32) != 0 ? false : z);
    }

    public final String getLoaderId() {
        return this.loaderId;
    }

    public final BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public final ResourceType getType() {
        return this.type;
    }

    public final Response getResponse() {
        return this.response;
    }

    public final boolean getHasExtraInfo() {
        return this.hasExtraInfo;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ResponseReceivedParams(BigDecimal now, String requestId, okhttp3.Response okhttpResponse) {
        Intrinsics.checkNotNullParameter(now, "now");
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(okhttpResponse, "okhttpResponse");
        ResourceType.Companion companion = ResourceType.INSTANCE;
        String strHeader = okhttpResponse.header(HttpHeaders.CONTENT_TYPE, "");
        this(requestId, null, now, companion.fromMimeType(strHeader != null ? strHeader : ""), new Response(okhttpResponse), false, 34, null);
    }

    @Override // expo.modules.kotlin.devtools.cdp.JsonSerializable
    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("requestId", this.requestId);
        jSONObject.put("loaderId", this.loaderId);
        jSONObject.put("timestamp", this.timestamp);
        jSONObject.put("type", this.type.getValue());
        jSONObject.put(io.sentry.protocol.Response.TYPE, this.response.toJSONObject());
        jSONObject.put("hasExtraInfo", this.hasExtraInfo);
        return jSONObject;
    }
}
