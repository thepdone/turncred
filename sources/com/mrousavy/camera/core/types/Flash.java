package com.mrousavy.camera.core.types;

import com.mrousavy.camera.core.InvalidTypeScriptUnionError;
import com.mrousavy.camera.core.types.JSUnionValue;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.DebugKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Flash.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/mrousavy/camera/core/types/Flash;", "", "Lcom/mrousavy/camera/core/types/JSUnionValue;", "unionValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getUnionValue", "()Ljava/lang/String;", "toFlashMode", "", "OFF", "ON", "AUTO", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Flash implements JSUnionValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Flash[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String unionValue;
    public static final Flash OFF = new Flash("OFF", 0, DebugKt.DEBUG_PROPERTY_VALUE_OFF);
    public static final Flash ON = new Flash("ON", 1, "on");
    public static final Flash AUTO = new Flash("AUTO", 2, "auto");

    /* compiled from: Flash.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Flash.values().length];
            try {
                iArr[Flash.OFF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Flash.ON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Flash.AUTO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ Flash[] $values() {
        return new Flash[]{OFF, ON, AUTO};
    }

    public static EnumEntries<Flash> getEntries() {
        return $ENTRIES;
    }

    public static Flash valueOf(String str) {
        return (Flash) Enum.valueOf(Flash.class, str);
    }

    public static Flash[] values() {
        return (Flash[]) $VALUES.clone();
    }

    private Flash(String str, int i, String str2) {
        this.unionValue = str2;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    static {
        Flash[] flashArr$values = $values();
        $VALUES = flashArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(flashArr$values);
        INSTANCE = new Companion(null);
    }

    public final int toFlashMode() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 0;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* compiled from: Flash.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/mrousavy/camera/core/types/Flash$Companion;", "Lcom/mrousavy/camera/core/types/JSUnionValue$Companion;", "Lcom/mrousavy/camera/core/types/Flash;", "()V", "fromUnionValue", "unionValue", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion implements JSUnionValue.Companion<Flash> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mrousavy.camera.core.types.JSUnionValue.Companion
        public Flash fromUnionValue(String unionValue) throws InvalidTypeScriptUnionError {
            if (unionValue != null) {
                int iHashCode = unionValue.hashCode();
                if (iHashCode != 3551) {
                    if (iHashCode != 109935) {
                        if (iHashCode == 3005871 && unionValue.equals("auto")) {
                            return Flash.AUTO;
                        }
                    } else if (unionValue.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                        return Flash.OFF;
                    }
                } else if (unionValue.equals("on")) {
                    return Flash.ON;
                }
            }
            if (unionValue == null) {
                unionValue = "(null)";
            }
            throw new InvalidTypeScriptUnionError("flash", unionValue);
        }
    }
}
