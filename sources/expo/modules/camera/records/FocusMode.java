package expo.modules.camera.records;

import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.coroutines.DebugKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: CameraRecords.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lexpo/modules/camera/records/FocusMode;", "", "Lexpo/modules/kotlin/types/Enumerable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ON", "OFF", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FocusMode implements Enumerable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FocusMode[] $VALUES;
    private final String value;
    public static final FocusMode ON = new FocusMode("ON", 0, "on");
    public static final FocusMode OFF = new FocusMode("OFF", 1, DebugKt.DEBUG_PROPERTY_VALUE_OFF);

    private static final /* synthetic */ FocusMode[] $values() {
        return new FocusMode[]{ON, OFF};
    }

    public static EnumEntries<FocusMode> getEntries() {
        return $ENTRIES;
    }

    public static FocusMode valueOf(String str) {
        return (FocusMode) Enum.valueOf(FocusMode.class, str);
    }

    public static FocusMode[] values() {
        return (FocusMode[]) $VALUES.clone();
    }

    private FocusMode(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        FocusMode[] focusModeArr$values = $values();
        $VALUES = focusModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(focusModeArr$values);
    }
}
