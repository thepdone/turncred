package expo.modules.localauthentication;

import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LocalAuthenticationRecords.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/localauthentication/BiometricsSecurityLevel;", "", "Lexpo/modules/kotlin/types/Enumerable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "toNativeBiometricSecurityLevel", "", "WEAK", "STRONG", "expo-local-authentication_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BiometricsSecurityLevel implements Enumerable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BiometricsSecurityLevel[] $VALUES;
    private final String value;
    public static final BiometricsSecurityLevel WEAK = new BiometricsSecurityLevel("WEAK", 0, "weak");
    public static final BiometricsSecurityLevel STRONG = new BiometricsSecurityLevel("STRONG", 1, "strong");

    /* compiled from: LocalAuthenticationRecords.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BiometricsSecurityLevel.values().length];
            try {
                iArr[BiometricsSecurityLevel.WEAK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BiometricsSecurityLevel.STRONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ BiometricsSecurityLevel[] $values() {
        return new BiometricsSecurityLevel[]{WEAK, STRONG};
    }

    public static EnumEntries<BiometricsSecurityLevel> getEntries() {
        return $ENTRIES;
    }

    public static BiometricsSecurityLevel valueOf(String str) {
        return (BiometricsSecurityLevel) Enum.valueOf(BiometricsSecurityLevel.class, str);
    }

    public static BiometricsSecurityLevel[] values() {
        return (BiometricsSecurityLevel[]) $VALUES.clone();
    }

    private BiometricsSecurityLevel(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        BiometricsSecurityLevel[] biometricsSecurityLevelArr$values = $values();
        $VALUES = biometricsSecurityLevelArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(biometricsSecurityLevelArr$values);
    }

    public final int toNativeBiometricSecurityLevel() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return 255;
        }
        if (i == 2) {
            return 15;
        }
        throw new NoWhenBranchMatchedException();
    }
}
