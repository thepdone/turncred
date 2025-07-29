package com.facebook.react.bridge;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: MemoryPressure.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/react/bridge/MemoryPressure;", "", "(Ljava/lang/String;I)V", "UI_HIDDEN", "MODERATE", "CRITICAL", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MemoryPressure {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MemoryPressure[] $VALUES;
    public static final MemoryPressure UI_HIDDEN = new MemoryPressure("UI_HIDDEN", 0);
    public static final MemoryPressure MODERATE = new MemoryPressure("MODERATE", 1);
    public static final MemoryPressure CRITICAL = new MemoryPressure("CRITICAL", 2);

    private static final /* synthetic */ MemoryPressure[] $values() {
        return new MemoryPressure[]{UI_HIDDEN, MODERATE, CRITICAL};
    }

    public static EnumEntries<MemoryPressure> getEntries() {
        return $ENTRIES;
    }

    public static MemoryPressure valueOf(String str) {
        return (MemoryPressure) Enum.valueOf(MemoryPressure.class, str);
    }

    public static MemoryPressure[] values() {
        return (MemoryPressure[]) $VALUES.clone();
    }

    private MemoryPressure(String str, int i) {
    }

    static {
        MemoryPressure[] memoryPressureArr$values = $values();
        $VALUES = memoryPressureArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(memoryPressureArr$values);
    }
}
