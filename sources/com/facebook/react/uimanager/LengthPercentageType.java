package com.facebook.react.uimanager;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LengthPercentage.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/react/uimanager/LengthPercentageType;", "", "(Ljava/lang/String;I)V", "POINT", "PERCENT", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LengthPercentageType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LengthPercentageType[] $VALUES;
    public static final LengthPercentageType POINT = new LengthPercentageType("POINT", 0);
    public static final LengthPercentageType PERCENT = new LengthPercentageType("PERCENT", 1);

    private static final /* synthetic */ LengthPercentageType[] $values() {
        return new LengthPercentageType[]{POINT, PERCENT};
    }

    public static EnumEntries<LengthPercentageType> getEntries() {
        return $ENTRIES;
    }

    public static LengthPercentageType valueOf(String str) {
        return (LengthPercentageType) Enum.valueOf(LengthPercentageType.class, str);
    }

    public static LengthPercentageType[] values() {
        return (LengthPercentageType[]) $VALUES.clone();
    }

    private LengthPercentageType(String str, int i) {
    }

    static {
        LengthPercentageType[] lengthPercentageTypeArr$values = $values();
        $VALUES = lengthPercentageTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(lengthPercentageTypeArr$values);
    }
}
