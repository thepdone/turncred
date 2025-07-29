package expo.modules.documentpicker;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.IsNotEmpty;
import expo.modules.kotlin.records.Record;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DocumentPickerOptions.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J-\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lexpo/modules/documentpicker/DocumentPickerOptions;", "Lexpo/modules/kotlin/records/Record;", "copyToCacheDirectory", "", "type", "", "", "multiple", "(ZLjava/util/List;Z)V", "getCopyToCacheDirectory$annotations", "()V", "getCopyToCacheDirectory", "()Z", "getMultiple$annotations", "getMultiple", "getType$annotations", "getType", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "expo-document-picker_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DocumentPickerOptions implements Record {
    private final boolean copyToCacheDirectory;
    private final boolean multiple;
    private final List<String> type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DocumentPickerOptions copy$default(DocumentPickerOptions documentPickerOptions, boolean z, List list, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = documentPickerOptions.copyToCacheDirectory;
        }
        if ((i & 2) != 0) {
            list = documentPickerOptions.type;
        }
        if ((i & 4) != 0) {
            z2 = documentPickerOptions.multiple;
        }
        return documentPickerOptions.copy(z, list, z2);
    }

    @Field
    public static /* synthetic */ void getCopyToCacheDirectory$annotations() {
    }

    @Field
    public static /* synthetic */ void getMultiple$annotations() {
    }

    @Field
    @IsNotEmpty
    public static /* synthetic */ void getType$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getCopyToCacheDirectory() {
        return this.copyToCacheDirectory;
    }

    public final List<String> component2() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getMultiple() {
        return this.multiple;
    }

    public final DocumentPickerOptions copy(boolean copyToCacheDirectory, List<String> type, boolean multiple) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new DocumentPickerOptions(copyToCacheDirectory, type, multiple);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentPickerOptions)) {
            return false;
        }
        DocumentPickerOptions documentPickerOptions = (DocumentPickerOptions) other;
        return this.copyToCacheDirectory == documentPickerOptions.copyToCacheDirectory && Intrinsics.areEqual(this.type, documentPickerOptions.type) && this.multiple == documentPickerOptions.multiple;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.copyToCacheDirectory) * 31) + this.type.hashCode()) * 31) + Boolean.hashCode(this.multiple);
    }

    public String toString() {
        return "DocumentPickerOptions(copyToCacheDirectory=" + this.copyToCacheDirectory + ", type=" + this.type + ", multiple=" + this.multiple + ")";
    }

    public DocumentPickerOptions(boolean z, List<String> type, boolean z2) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.copyToCacheDirectory = z;
        this.type = type;
        this.multiple = z2;
    }

    public final boolean getCopyToCacheDirectory() {
        return this.copyToCacheDirectory;
    }

    public final List<String> getType() {
        return this.type;
    }

    public final boolean getMultiple() {
        return this.multiple;
    }
}
