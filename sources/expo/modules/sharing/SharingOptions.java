package expo.modules.sharing;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharingOptions.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\nR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lexpo/modules/sharing/SharingOptions;", "Lexpo/modules/kotlin/records/Record;", "mimeType", "", "UTI", "dialogTitle", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUTI$annotations", "()V", "getUTI", "()Ljava/lang/String;", "getDialogTitle$annotations", "getDialogTitle", "getMimeType$annotations", "getMimeType", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "expo-sharing_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SharingOptions implements Record {
    private final String UTI;
    private final String dialogTitle;
    private final String mimeType;

    public static /* synthetic */ SharingOptions copy$default(SharingOptions sharingOptions, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sharingOptions.mimeType;
        }
        if ((i & 2) != 0) {
            str2 = sharingOptions.UTI;
        }
        if ((i & 4) != 0) {
            str3 = sharingOptions.dialogTitle;
        }
        return sharingOptions.copy(str, str2, str3);
    }

    @Field
    public static /* synthetic */ void getDialogTitle$annotations() {
    }

    @Field
    public static /* synthetic */ void getMimeType$annotations() {
    }

    @Field
    public static /* synthetic */ void getUTI$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUTI() {
        return this.UTI;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDialogTitle() {
        return this.dialogTitle;
    }

    public final SharingOptions copy(String mimeType, String UTI, String dialogTitle) {
        return new SharingOptions(mimeType, UTI, dialogTitle);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SharingOptions)) {
            return false;
        }
        SharingOptions sharingOptions = (SharingOptions) other;
        return Intrinsics.areEqual(this.mimeType, sharingOptions.mimeType) && Intrinsics.areEqual(this.UTI, sharingOptions.UTI) && Intrinsics.areEqual(this.dialogTitle, sharingOptions.dialogTitle);
    }

    public int hashCode() {
        String str = this.mimeType;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.UTI;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.dialogTitle;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "SharingOptions(mimeType=" + this.mimeType + ", UTI=" + this.UTI + ", dialogTitle=" + this.dialogTitle + ")";
    }

    public SharingOptions(String str, String str2, String str3) {
        this.mimeType = str;
        this.UTI = str2;
        this.dialogTitle = str3;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getUTI() {
        return this.UTI;
    }

    public final String getDialogTitle() {
        return this.dialogTitle;
    }
}
