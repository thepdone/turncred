package com.th3rdwave.safeareacontext;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SafeAreaViewMode.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/th3rdwave/safeareacontext/SafeAreaViewMode;", "", "(Ljava/lang/String;I)V", "PADDING", "MARGIN", "react-native-safe-area-context_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SafeAreaViewMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SafeAreaViewMode[] $VALUES;
    public static final SafeAreaViewMode PADDING = new SafeAreaViewMode("PADDING", 0);
    public static final SafeAreaViewMode MARGIN = new SafeAreaViewMode("MARGIN", 1);

    private static final /* synthetic */ SafeAreaViewMode[] $values() {
        return new SafeAreaViewMode[]{PADDING, MARGIN};
    }

    public static EnumEntries<SafeAreaViewMode> getEntries() {
        return $ENTRIES;
    }

    public static SafeAreaViewMode valueOf(String str) {
        return (SafeAreaViewMode) Enum.valueOf(SafeAreaViewMode.class, str);
    }

    public static SafeAreaViewMode[] values() {
        return (SafeAreaViewMode[]) $VALUES.clone();
    }

    private SafeAreaViewMode(String str, int i) {
    }

    static {
        SafeAreaViewMode[] safeAreaViewModeArr$values = $values();
        $VALUES = safeAreaViewModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(safeAreaViewModeArr$values);
    }
}
