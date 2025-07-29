package expo.modules.documentpicker;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.share.internal.ShareConstants;
import io.sentry.rrweb.RRWebVideoEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DocumentDetailsReader.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J:\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u001b"}, d2 = {"Lexpo/modules/documentpicker/DocumentDetails;", "", "name", "", ShareConstants.MEDIA_URI, RRWebVideoEvent.JsonKeys.SIZE, "", "mimeType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getMimeType", "()Ljava/lang/String;", "getName", "getSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUri", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lexpo/modules/documentpicker/DocumentDetails;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "expo-document-picker_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DocumentDetails {
    private final String mimeType;
    private final String name;
    private final Integer size;
    private final String uri;

    public static /* synthetic */ DocumentDetails copy$default(DocumentDetails documentDetails, String str, String str2, Integer num, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = documentDetails.name;
        }
        if ((i & 2) != 0) {
            str2 = documentDetails.uri;
        }
        if ((i & 4) != 0) {
            num = documentDetails.size;
        }
        if ((i & 8) != 0) {
            str3 = documentDetails.mimeType;
        }
        return documentDetails.copy(str, str2, num, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getSize() {
        return this.size;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    public final DocumentDetails copy(String name, String uri, Integer size, String mimeType) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(uri, "uri");
        return new DocumentDetails(name, uri, size, mimeType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentDetails)) {
            return false;
        }
        DocumentDetails documentDetails = (DocumentDetails) other;
        return Intrinsics.areEqual(this.name, documentDetails.name) && Intrinsics.areEqual(this.uri, documentDetails.uri) && Intrinsics.areEqual(this.size, documentDetails.size) && Intrinsics.areEqual(this.mimeType, documentDetails.mimeType);
    }

    public int hashCode() {
        int iHashCode = ((this.name.hashCode() * 31) + this.uri.hashCode()) * 31;
        Integer num = this.size;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.mimeType;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "DocumentDetails(name=" + this.name + ", uri=" + this.uri + ", size=" + this.size + ", mimeType=" + this.mimeType + ")";
    }

    public DocumentDetails(String name, String uri, Integer num, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.name = name;
        this.uri = uri;
        this.size = num;
        this.mimeType = str;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getSize() {
        return this.size;
    }

    public final String getUri() {
        return this.uri;
    }
}
