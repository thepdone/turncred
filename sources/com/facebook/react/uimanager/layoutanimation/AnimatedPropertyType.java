package com.facebook.react.uimanager.layoutanimation;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AnimatedPropertyType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/facebook/react/uimanager/layoutanimation/AnimatedPropertyType;", "", "(Ljava/lang/String;I)V", "OPACITY", "SCALE_X", "SCALE_Y", "SCALE_XY", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AnimatedPropertyType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AnimatedPropertyType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final AnimatedPropertyType OPACITY = new AnimatedPropertyType("OPACITY", 0);
    public static final AnimatedPropertyType SCALE_X = new AnimatedPropertyType("SCALE_X", 1);
    public static final AnimatedPropertyType SCALE_Y = new AnimatedPropertyType("SCALE_Y", 2);
    public static final AnimatedPropertyType SCALE_XY = new AnimatedPropertyType("SCALE_XY", 3);

    private static final /* synthetic */ AnimatedPropertyType[] $values() {
        return new AnimatedPropertyType[]{OPACITY, SCALE_X, SCALE_Y, SCALE_XY};
    }

    @JvmStatic
    public static final AnimatedPropertyType fromString(String str) {
        return INSTANCE.fromString(str);
    }

    public static EnumEntries<AnimatedPropertyType> getEntries() {
        return $ENTRIES;
    }

    public static AnimatedPropertyType valueOf(String str) {
        return (AnimatedPropertyType) Enum.valueOf(AnimatedPropertyType.class, str);
    }

    public static AnimatedPropertyType[] values() {
        return (AnimatedPropertyType[]) $VALUES.clone();
    }

    private AnimatedPropertyType(String str, int i) {
    }

    static {
        AnimatedPropertyType[] animatedPropertyTypeArr$values = $values();
        $VALUES = animatedPropertyTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(animatedPropertyTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: AnimatedPropertyType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/facebook/react/uimanager/layoutanimation/AnimatedPropertyType$Companion;", "", "()V", "fromString", "Lcom/facebook/react/uimanager/layoutanimation/AnimatedPropertyType;", "name", "", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @JvmStatic
        public final AnimatedPropertyType fromString(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            switch (name.hashCode()) {
                case -1267206133:
                    if (name.equals(ViewProps.OPACITY)) {
                        return AnimatedPropertyType.OPACITY;
                    }
                    break;
                case -908189618:
                    if (name.equals(ViewProps.SCALE_X)) {
                        return AnimatedPropertyType.SCALE_X;
                    }
                    break;
                case -908189617:
                    if (name.equals(ViewProps.SCALE_Y)) {
                        return AnimatedPropertyType.SCALE_Y;
                    }
                    break;
                case 1910893003:
                    if (name.equals("scaleXY")) {
                        return AnimatedPropertyType.SCALE_XY;
                    }
                    break;
            }
            throw new IllegalArgumentException("Unsupported animated property: " + name);
        }
    }
}
