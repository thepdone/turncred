package expo.modules.camera.records;

import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.coroutines.DebugKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: CameraRecords.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lexpo/modules/camera/records/FlashMode;", "", "Lexpo/modules/kotlin/types/Enumerable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "mapToLens", "", "AUTO", "ON", "OFF", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlashMode implements Enumerable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FlashMode[] $VALUES;
    private final String value;
    public static final FlashMode AUTO = new FlashMode("AUTO", 0, "auto");
    public static final FlashMode ON = new FlashMode("ON", 1, "on");
    public static final FlashMode OFF = new FlashMode("OFF", 2, DebugKt.DEBUG_PROPERTY_VALUE_OFF);

    /* compiled from: CameraRecords.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FlashMode.values().length];
            try {
                iArr[FlashMode.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FlashMode.OFF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FlashMode.ON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ FlashMode[] $values() {
        return new FlashMode[]{AUTO, ON, OFF};
    }

    public static EnumEntries<FlashMode> getEntries() {
        return $ENTRIES;
    }

    public static FlashMode valueOf(String str) {
        return (FlashMode) Enum.valueOf(FlashMode.class, str);
    }

    public static FlashMode[] values() {
        return (FlashMode[]) $VALUES.clone();
    }

    private FlashMode(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        FlashMode[] flashModeArr$values = $values();
        $VALUES = flashModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(flashModeArr$values);
    }

    public final int mapToLens() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 2;
        }
        if (i == 3) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }
}
