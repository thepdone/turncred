package expo.modules.camera.records;

import com.facebook.share.internal.ShareConstants;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: CameraRecords.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lexpo/modules/camera/records/CameraMode;", "", "Lexpo/modules/kotlin/types/Enumerable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PICTURE", ShareConstants.VIDEO_URL, "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraMode implements Enumerable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CameraMode[] $VALUES;
    public static final CameraMode PICTURE = new CameraMode("PICTURE", 0, "picture");
    public static final CameraMode VIDEO = new CameraMode(ShareConstants.VIDEO_URL, 1, "video");
    private final String value;

    private static final /* synthetic */ CameraMode[] $values() {
        return new CameraMode[]{PICTURE, VIDEO};
    }

    public static EnumEntries<CameraMode> getEntries() {
        return $ENTRIES;
    }

    public static CameraMode valueOf(String str) {
        return (CameraMode) Enum.valueOf(CameraMode.class, str);
    }

    public static CameraMode[] values() {
        return (CameraMode[]) $VALUES.clone();
    }

    private CameraMode(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        CameraMode[] cameraModeArr$values = $values();
        $VALUES = cameraModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(cameraModeArr$values);
    }
}
