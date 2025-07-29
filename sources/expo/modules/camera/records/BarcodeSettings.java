package expo.modules.camera.records;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraRecords.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lexpo/modules/camera/records/BarcodeSettings;", "Lexpo/modules/kotlin/records/Record;", "barcodeTypes", "", "Lexpo/modules/camera/records/BarcodeType;", "(Ljava/util/List;)V", "getBarcodeTypes$annotations", "()V", "getBarcodeTypes", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BarcodeSettings implements Record {
    private final List<BarcodeType> barcodeTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BarcodeSettings copy$default(BarcodeSettings barcodeSettings, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = barcodeSettings.barcodeTypes;
        }
        return barcodeSettings.copy(list);
    }

    @Field
    public static /* synthetic */ void getBarcodeTypes$annotations() {
    }

    public final List<BarcodeType> component1() {
        return this.barcodeTypes;
    }

    public final BarcodeSettings copy(List<? extends BarcodeType> barcodeTypes) {
        Intrinsics.checkNotNullParameter(barcodeTypes, "barcodeTypes");
        return new BarcodeSettings(barcodeTypes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof BarcodeSettings) && Intrinsics.areEqual(this.barcodeTypes, ((BarcodeSettings) other).barcodeTypes);
    }

    public int hashCode() {
        return this.barcodeTypes.hashCode();
    }

    public String toString() {
        return "BarcodeSettings(barcodeTypes=" + this.barcodeTypes + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BarcodeSettings(List<? extends BarcodeType> barcodeTypes) {
        Intrinsics.checkNotNullParameter(barcodeTypes, "barcodeTypes");
        this.barcodeTypes = barcodeTypes;
    }

    public final List<BarcodeType> getBarcodeTypes() {
        return this.barcodeTypes;
    }
}
