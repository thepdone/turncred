package com.facebook.react.uimanager.style;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BorderStyle.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/facebook/react/uimanager/style/BorderStyle;", "", "(Ljava/lang/String;I)V", "SOLID", "DASHED", "DOTTED", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BorderStyle {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BorderStyle[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final BorderStyle SOLID = new BorderStyle("SOLID", 0);
    public static final BorderStyle DASHED = new BorderStyle("DASHED", 1);
    public static final BorderStyle DOTTED = new BorderStyle("DOTTED", 2);

    private static final /* synthetic */ BorderStyle[] $values() {
        return new BorderStyle[]{SOLID, DASHED, DOTTED};
    }

    @JvmStatic
    public static final BorderStyle fromString(String str) {
        return INSTANCE.fromString(str);
    }

    public static EnumEntries<BorderStyle> getEntries() {
        return $ENTRIES;
    }

    public static BorderStyle valueOf(String str) {
        return (BorderStyle) Enum.valueOf(BorderStyle.class, str);
    }

    public static BorderStyle[] values() {
        return (BorderStyle[]) $VALUES.clone();
    }

    private BorderStyle(String str, int i) {
    }

    static {
        BorderStyle[] borderStyleArr$values = $values();
        $VALUES = borderStyleArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(borderStyleArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: BorderStyle.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/facebook/react/uimanager/style/BorderStyle$Companion;", "", "()V", "fromString", "Lcom/facebook/react/uimanager/style/BorderStyle;", "borderStyle", "", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BorderStyle fromString(String borderStyle) {
            Intrinsics.checkNotNullParameter(borderStyle, "borderStyle");
            String lowerCase = borderStyle.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != -1338941519) {
                if (iHashCode != -1325970902) {
                    if (iHashCode == 109618859 && lowerCase.equals("solid")) {
                        return BorderStyle.SOLID;
                    }
                } else if (lowerCase.equals("dotted")) {
                    return BorderStyle.DOTTED;
                }
            } else if (lowerCase.equals("dashed")) {
                return BorderStyle.DASHED;
            }
            return null;
        }
    }
}
