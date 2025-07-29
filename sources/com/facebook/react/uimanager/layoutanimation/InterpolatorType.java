package com.facebook.react.uimanager.layoutanimation;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: InterpolatorType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;", "", "(Ljava/lang/String;I)V", "LINEAR", "EASE_IN", "EASE_OUT", "EASE_IN_EASE_OUT", "SPRING", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InterpolatorType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InterpolatorType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final InterpolatorType LINEAR = new InterpolatorType("LINEAR", 0);
    public static final InterpolatorType EASE_IN = new InterpolatorType("EASE_IN", 1);
    public static final InterpolatorType EASE_OUT = new InterpolatorType("EASE_OUT", 2);
    public static final InterpolatorType EASE_IN_EASE_OUT = new InterpolatorType("EASE_IN_EASE_OUT", 3);
    public static final InterpolatorType SPRING = new InterpolatorType("SPRING", 4);

    private static final /* synthetic */ InterpolatorType[] $values() {
        return new InterpolatorType[]{LINEAR, EASE_IN, EASE_OUT, EASE_IN_EASE_OUT, SPRING};
    }

    @JvmStatic
    public static final InterpolatorType fromString(String str) {
        return INSTANCE.fromString(str);
    }

    public static EnumEntries<InterpolatorType> getEntries() {
        return $ENTRIES;
    }

    public static InterpolatorType valueOf(String str) {
        return (InterpolatorType) Enum.valueOf(InterpolatorType.class, str);
    }

    public static InterpolatorType[] values() {
        return (InterpolatorType[]) $VALUES.clone();
    }

    private InterpolatorType(String str, int i) {
    }

    static {
        InterpolatorType[] interpolatorTypeArr$values = $values();
        $VALUES = interpolatorTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(interpolatorTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: InterpolatorType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType$Companion;", "", "()V", "fromString", "Lcom/facebook/react/uimanager/layoutanimation/InterpolatorType;", "name", "", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @JvmStatic
        public final InterpolatorType fromString(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            String lowerCase = name.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            switch (lowerCase.hashCode()) {
                case -1965056864:
                    if (lowerCase.equals("easeout")) {
                        return InterpolatorType.EASE_OUT;
                    }
                    break;
                case -1310315117:
                    if (lowerCase.equals("easein")) {
                        return InterpolatorType.EASE_IN;
                    }
                    break;
                case -1102672091:
                    if (lowerCase.equals("linear")) {
                        return InterpolatorType.LINEAR;
                    }
                    break;
                case -895679987:
                    if (lowerCase.equals("spring")) {
                        return InterpolatorType.SPRING;
                    }
                    break;
                case 1164546989:
                    if (lowerCase.equals("easeineaseout")) {
                        return InterpolatorType.EASE_IN_EASE_OUT;
                    }
                    break;
            }
            throw new IllegalArgumentException("Unsupported interpolation type : " + name);
        }
    }
}
