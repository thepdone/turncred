package com.facebook.react.uimanager;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: NativeKind.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/react/uimanager/NativeKind;", "", "(Ljava/lang/String;I)V", "PARENT", "LEAF", "NONE", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NativeKind {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ NativeKind[] $VALUES;
    public static final NativeKind PARENT = new NativeKind("PARENT", 0);
    public static final NativeKind LEAF = new NativeKind("LEAF", 1);
    public static final NativeKind NONE = new NativeKind("NONE", 2);

    private static final /* synthetic */ NativeKind[] $values() {
        return new NativeKind[]{PARENT, LEAF, NONE};
    }

    public static EnumEntries<NativeKind> getEntries() {
        return $ENTRIES;
    }

    public static NativeKind valueOf(String str) {
        return (NativeKind) Enum.valueOf(NativeKind.class, str);
    }

    public static NativeKind[] values() {
        return (NativeKind[]) $VALUES.clone();
    }

    private NativeKind(String str, int i) {
    }

    static {
        NativeKind[] nativeKindArr$values = $values();
        $VALUES = nativeKindArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(nativeKindArr$values);
    }
}
