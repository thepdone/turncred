package com.mrousavy.camera.core.types;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: HardwareLevel.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/mrousavy/camera/core/types/HardwareLevel;", "", "Lcom/mrousavy/camera/core/types/JSUnionValue;", "unionValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "rank", "", "getRank", "()I", "getUnionValue", "()Ljava/lang/String;", "LEGACY", "LIMITED", "EXTERNAL", "FULL", "LEVEL_3", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HardwareLevel implements JSUnionValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HardwareLevel[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String unionValue;
    public static final HardwareLevel LEGACY = new HardwareLevel("LEGACY", 0, "legacy");
    public static final HardwareLevel LIMITED = new HardwareLevel("LIMITED", 1, "limited");
    public static final HardwareLevel EXTERNAL = new HardwareLevel("EXTERNAL", 2, "limited");
    public static final HardwareLevel FULL = new HardwareLevel("FULL", 3, "full");
    public static final HardwareLevel LEVEL_3 = new HardwareLevel("LEVEL_3", 4, "full");

    /* compiled from: HardwareLevel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HardwareLevel.values().length];
            try {
                iArr[HardwareLevel.LEGACY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HardwareLevel.LIMITED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HardwareLevel.EXTERNAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HardwareLevel.FULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[HardwareLevel.LEVEL_3.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ HardwareLevel[] $values() {
        return new HardwareLevel[]{LEGACY, LIMITED, EXTERNAL, FULL, LEVEL_3};
    }

    public static EnumEntries<HardwareLevel> getEntries() {
        return $ENTRIES;
    }

    public static HardwareLevel valueOf(String str) {
        return (HardwareLevel) Enum.valueOf(HardwareLevel.class, str);
    }

    public static HardwareLevel[] values() {
        return (HardwareLevel[]) $VALUES.clone();
    }

    private HardwareLevel(String str, int i, String str2) {
        this.unionValue = str2;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    static {
        HardwareLevel[] hardwareLevelArr$values = $values();
        $VALUES = hardwareLevelArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(hardwareLevelArr$values);
        INSTANCE = new Companion(null);
    }

    private final int getRank() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2 || i == 3) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 5) {
            return 3;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* compiled from: HardwareLevel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/mrousavy/camera/core/types/HardwareLevel$Companion;", "", "()V", "fromCameraHardwareLevel", "Lcom/mrousavy/camera/core/types/HardwareLevel;", "hardwareLevel", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HardwareLevel fromCameraHardwareLevel(int hardwareLevel) {
            if (hardwareLevel == 0) {
                return HardwareLevel.LIMITED;
            }
            if (hardwareLevel == 1) {
                return HardwareLevel.FULL;
            }
            if (hardwareLevel == 2) {
                return HardwareLevel.LEGACY;
            }
            if (hardwareLevel == 3) {
                return HardwareLevel.LEVEL_3;
            }
            if (hardwareLevel == 4) {
                return HardwareLevel.EXTERNAL;
            }
            return HardwareLevel.LEGACY;
        }
    }
}
