package expo.modules.kotlin.devtools.cdp;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CdpNetworkTypes.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB%\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\n\u0010\n\u001a\u00060\u0003j\u0002`\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\r\u0010\u0015\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003J\r\u0010\u0016\u001a\u00060\u0003j\u0002`\u000bHÆ\u0003J\t\u0010\u0017\u001a\u00020\rHÆ\u0003J/\u0010\u0018\u001a\u00020\u00002\f\b\u0002\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\f\b\u0002\u0010\n\u001a\u00060\u0003j\u0002`\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\b\u0010\u001f\u001a\u00020 H\u0016J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\n\u001a\u00060\u0003j\u0002`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lexpo/modules/kotlin/devtools/cdp/LoadingFinishedParams;", "Lexpo/modules/kotlin/devtools/cdp/JsonSerializable;", "now", "Ljava/math/BigDecimal;", "requestId", "", "Lexpo/modules/kotlin/devtools/cdp/RequestId;", io.sentry.protocol.Response.TYPE, "Lokhttp3/Response;", "(Ljava/math/BigDecimal;Ljava/lang/String;Lokhttp3/Response;)V", "timestamp", "Lexpo/modules/kotlin/devtools/cdp/MonotonicTime;", "encodedDataLength", "", "(Ljava/lang/String;Ljava/math/BigDecimal;J)V", "getEncodedDataLength", "()J", "getRequestId", "()Ljava/lang/String;", "getTimestamp", "()Ljava/math/BigDecimal;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toJSONObject", "Lorg/json/JSONObject;", InAppPurchaseConstants.METHOD_TO_STRING, "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class LoadingFinishedParams implements JsonSerializable {
    public static final int $stable = 8;
    private final long encodedDataLength;
    private final String requestId;
    private final BigDecimal timestamp;

    public static /* synthetic */ LoadingFinishedParams copy$default(LoadingFinishedParams loadingFinishedParams, String str, BigDecimal bigDecimal, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loadingFinishedParams.requestId;
        }
        if ((i & 2) != 0) {
            bigDecimal = loadingFinishedParams.timestamp;
        }
        if ((i & 4) != 0) {
            j = loadingFinishedParams.encodedDataLength;
        }
        return loadingFinishedParams.copy(str, bigDecimal, j);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: component2, reason: from getter */
    public final BigDecimal getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component3, reason: from getter */
    public final long getEncodedDataLength() {
        return this.encodedDataLength;
    }

    public final LoadingFinishedParams copy(String requestId, BigDecimal timestamp, long encodedDataLength) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        return new LoadingFinishedParams(requestId, timestamp, encodedDataLength);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadingFinishedParams)) {
            return false;
        }
        LoadingFinishedParams loadingFinishedParams = (LoadingFinishedParams) other;
        return Intrinsics.areEqual(this.requestId, loadingFinishedParams.requestId) && Intrinsics.areEqual(this.timestamp, loadingFinishedParams.timestamp) && this.encodedDataLength == loadingFinishedParams.encodedDataLength;
    }

    public int hashCode() {
        return (((this.requestId.hashCode() * 31) + this.timestamp.hashCode()) * 31) + Long.hashCode(this.encodedDataLength);
    }

    public String toString() {
        return "LoadingFinishedParams(requestId=" + this.requestId + ", timestamp=" + this.timestamp + ", encodedDataLength=" + this.encodedDataLength + ")";
    }

    public LoadingFinishedParams(String requestId, BigDecimal timestamp, long j) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.encodedDataLength = j;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public final long getEncodedDataLength() {
        return this.encodedDataLength;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LoadingFinishedParams(BigDecimal now, String requestId, okhttp3.Response response) {
        Intrinsics.checkNotNullParameter(now, "now");
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(response, "response");
        ResponseBody responseBodyBody = response.body();
        this(requestId, now, responseBodyBody != null ? responseBodyBody.get$contentLength() : 0L);
    }

    @Override // expo.modules.kotlin.devtools.cdp.JsonSerializable
    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("requestId", this.requestId);
        jSONObject.put("timestamp", this.timestamp);
        jSONObject.put("encodedDataLength", this.encodedDataLength);
        return jSONObject;
    }
}
