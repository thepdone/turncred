package com.th3rdwave.safeareacontext;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SafeAreaViewEdges.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/th3rdwave/safeareacontext/SafeAreaViewEdgeModes;", "", "(Ljava/lang/String;I)V", "OFF", "ADDITIVE", "MAXIMUM", "react-native-safe-area-context_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SafeAreaViewEdgeModes {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SafeAreaViewEdgeModes[] $VALUES;
    public static final SafeAreaViewEdgeModes OFF = new SafeAreaViewEdgeModes("OFF", 0);
    public static final SafeAreaViewEdgeModes ADDITIVE = new SafeAreaViewEdgeModes("ADDITIVE", 1);
    public static final SafeAreaViewEdgeModes MAXIMUM = new SafeAreaViewEdgeModes("MAXIMUM", 2);

    private static final /* synthetic */ SafeAreaViewEdgeModes[] $values() {
        return new SafeAreaViewEdgeModes[]{OFF, ADDITIVE, MAXIMUM};
    }

    public static EnumEntries<SafeAreaViewEdgeModes> getEntries() {
        return $ENTRIES;
    }

    public static SafeAreaViewEdgeModes valueOf(String str) {
        return (SafeAreaViewEdgeModes) Enum.valueOf(SafeAreaViewEdgeModes.class, str);
    }

    public static SafeAreaViewEdgeModes[] values() {
        return (SafeAreaViewEdgeModes[]) $VALUES.clone();
    }

    private SafeAreaViewEdgeModes(String str, int i) {
    }

    static {
        SafeAreaViewEdgeModes[] safeAreaViewEdgeModesArr$values = $values();
        $VALUES = safeAreaViewEdgeModesArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(safeAreaViewEdgeModesArr$values);
    }
}
