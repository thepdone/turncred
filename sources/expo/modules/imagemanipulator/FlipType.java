package expo.modules.imagemanipulator;

import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ImageManipulatorArguments.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lexpo/modules/imagemanipulator/FlipType;", "", "Lexpo/modules/kotlin/types/Enumerable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "VERTICAL", "HORIZONTAL", "expo-image-manipulator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlipType implements Enumerable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FlipType[] $VALUES;
    private final String value;
    public static final FlipType VERTICAL = new FlipType("VERTICAL", 0, "vertical");
    public static final FlipType HORIZONTAL = new FlipType("HORIZONTAL", 1, "horizontal");

    private static final /* synthetic */ FlipType[] $values() {
        return new FlipType[]{VERTICAL, HORIZONTAL};
    }

    public static EnumEntries<FlipType> getEntries() {
        return $ENTRIES;
    }

    public static FlipType valueOf(String str) {
        return (FlipType) Enum.valueOf(FlipType.class, str);
    }

    public static FlipType[] values() {
        return (FlipType[]) $VALUES.clone();
    }

    private FlipType(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        FlipType[] flipTypeArr$values = $values();
        $VALUES = flipTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(flipTypeArr$values);
    }
}
