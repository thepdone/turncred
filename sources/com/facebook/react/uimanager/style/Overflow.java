package com.facebook.react.uimanager.style;

import com.facebook.react.uimanager.ViewProps;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Overflow.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/facebook/react/uimanager/style/Overflow;", "", "(Ljava/lang/String;I)V", "VISIBLE", "HIDDEN", "SCROLL", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Overflow {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Overflow[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final Overflow VISIBLE = new Overflow("VISIBLE", 0);
    public static final Overflow HIDDEN = new Overflow("HIDDEN", 1);
    public static final Overflow SCROLL = new Overflow("SCROLL", 2);

    private static final /* synthetic */ Overflow[] $values() {
        return new Overflow[]{VISIBLE, HIDDEN, SCROLL};
    }

    @JvmStatic
    public static final Overflow fromString(String str) {
        return INSTANCE.fromString(str);
    }

    public static EnumEntries<Overflow> getEntries() {
        return $ENTRIES;
    }

    public static Overflow valueOf(String str) {
        return (Overflow) Enum.valueOf(Overflow.class, str);
    }

    public static Overflow[] values() {
        return (Overflow[]) $VALUES.clone();
    }

    private Overflow(String str, int i) {
    }

    static {
        Overflow[] overflowArr$values = $values();
        $VALUES = overflowArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(overflowArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: Overflow.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/facebook/react/uimanager/style/Overflow$Companion;", "", "()V", "fromString", "Lcom/facebook/react/uimanager/style/Overflow;", ViewProps.OVERFLOW, "", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Overflow fromString(String overflow) {
            Intrinsics.checkNotNullParameter(overflow, "overflow");
            String lowerCase = overflow.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != -1217487446) {
                if (iHashCode != -907680051) {
                    if (iHashCode == 466743410 && lowerCase.equals(ViewProps.VISIBLE)) {
                        return Overflow.VISIBLE;
                    }
                } else if (lowerCase.equals(ViewProps.SCROLL)) {
                    return Overflow.SCROLL;
                }
            } else if (lowerCase.equals(ViewProps.HIDDEN)) {
                return Overflow.HIDDEN;
            }
            return null;
        }
    }
}
