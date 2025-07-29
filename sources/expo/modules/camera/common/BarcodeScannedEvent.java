package expo.modules.camera.common;

import android.os.Bundle;
import com.facebook.react.uimanager.events.TouchesHelper;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonEvents.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rR\u001c\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R,\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u0017¨\u0006\u001f"}, d2 = {"Lexpo/modules/camera/common/BarcodeScannedEvent;", "Lexpo/modules/kotlin/records/Record;", TouchesHelper.TARGET_KEY, "", "data", "", "raw", "type", "cornerPoints", "Ljava/util/ArrayList;", "Landroid/os/Bundle;", "Lkotlin/collections/ArrayList;", "bounds", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Landroid/os/Bundle;)V", "getBounds$annotations", "()V", "getBounds", "()Landroid/os/Bundle;", "getCornerPoints$annotations", "getCornerPoints", "()Ljava/util/ArrayList;", "getData$annotations", "getData", "()Ljava/lang/String;", "getRaw$annotations", "getRaw", "getTarget$annotations", "getTarget", "()I", "getType$annotations", "getType", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BarcodeScannedEvent implements Record {
    private final Bundle bounds;
    private final ArrayList<Bundle> cornerPoints;
    private final String data;
    private final String raw;
    private final int target;
    private final String type;

    @Field
    public static /* synthetic */ void getBounds$annotations() {
    }

    @Field
    public static /* synthetic */ void getCornerPoints$annotations() {
    }

    @Field
    public static /* synthetic */ void getData$annotations() {
    }

    @Field
    public static /* synthetic */ void getRaw$annotations() {
    }

    @Field
    public static /* synthetic */ void getTarget$annotations() {
    }

    @Field
    public static /* synthetic */ void getType$annotations() {
    }

    public BarcodeScannedEvent(int i, String data, String raw, String type, ArrayList<Bundle> cornerPoints, Bundle bounds) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(raw, "raw");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(cornerPoints, "cornerPoints");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        this.target = i;
        this.data = data;
        this.raw = raw;
        this.type = type;
        this.cornerPoints = cornerPoints;
        this.bounds = bounds;
    }

    public final int getTarget() {
        return this.target;
    }

    public final String getData() {
        return this.data;
    }

    public final String getRaw() {
        return this.raw;
    }

    public final String getType() {
        return this.type;
    }

    public final ArrayList<Bundle> getCornerPoints() {
        return this.cornerPoints;
    }

    public final Bundle getBounds() {
        return this.bounds;
    }
}
