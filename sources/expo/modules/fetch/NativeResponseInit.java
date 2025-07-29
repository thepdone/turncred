package expo.modules.fetch;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeResponseInit.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0080\b\u0018\u00002\u00020\u0001B?\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001b\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u000bHÆ\u0003JM\u0010\u001b\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R#\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006 "}, d2 = {"Lexpo/modules/fetch/NativeResponseInit;", "", "headers", "", "Lkotlin/Pair;", "", "status", "", "statusText", "url", "redirected", "", "(Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Z)V", "getHeaders", "()Ljava/util/List;", "getRedirected", "()Z", "getStatus", "()I", "getStatusText", "()Ljava/lang/String;", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "expo_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class NativeResponseInit {
    private final List<Pair<String, String>> headers;
    private final boolean redirected;
    private final int status;
    private final String statusText;
    private final String url;

    public static /* synthetic */ NativeResponseInit copy$default(NativeResponseInit nativeResponseInit, List list, int i, String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = nativeResponseInit.headers;
        }
        if ((i2 & 2) != 0) {
            i = nativeResponseInit.status;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str = nativeResponseInit.statusText;
        }
        String str3 = str;
        if ((i2 & 8) != 0) {
            str2 = nativeResponseInit.url;
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            z = nativeResponseInit.redirected;
        }
        return nativeResponseInit.copy(list, i3, str3, str4, z);
    }

    public final List<Pair<String, String>> component1() {
        return this.headers;
    }

    /* renamed from: component2, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: component3, reason: from getter */
    public final String getStatusText() {
        return this.statusText;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getRedirected() {
        return this.redirected;
    }

    public final NativeResponseInit copy(List<Pair<String, String>> headers, int status, String statusText, String url, boolean redirected) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(statusText, "statusText");
        Intrinsics.checkNotNullParameter(url, "url");
        return new NativeResponseInit(headers, status, statusText, url, redirected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NativeResponseInit)) {
            return false;
        }
        NativeResponseInit nativeResponseInit = (NativeResponseInit) other;
        return Intrinsics.areEqual(this.headers, nativeResponseInit.headers) && this.status == nativeResponseInit.status && Intrinsics.areEqual(this.statusText, nativeResponseInit.statusText) && Intrinsics.areEqual(this.url, nativeResponseInit.url) && this.redirected == nativeResponseInit.redirected;
    }

    public int hashCode() {
        return (((((((this.headers.hashCode() * 31) + Integer.hashCode(this.status)) * 31) + this.statusText.hashCode()) * 31) + this.url.hashCode()) * 31) + Boolean.hashCode(this.redirected);
    }

    public String toString() {
        return "NativeResponseInit(headers=" + this.headers + ", status=" + this.status + ", statusText=" + this.statusText + ", url=" + this.url + ", redirected=" + this.redirected + ")";
    }

    public NativeResponseInit(List<Pair<String, String>> headers, int i, String statusText, String url, boolean z) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(statusText, "statusText");
        Intrinsics.checkNotNullParameter(url, "url");
        this.headers = headers;
        this.status = i;
        this.statusText = statusText;
        this.url = url;
        this.redirected = z;
    }

    public final List<Pair<String, String>> getHeaders() {
        return this.headers;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getStatusText() {
        return this.statusText;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean getRedirected() {
        return this.redirected;
    }
}
