package com.facebook.react;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: JSEngineResolutionAlgorithm.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/react/JSEngineResolutionAlgorithm;", "", "(Ljava/lang/String;I)V", "JSC", "HERMES", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class JSEngineResolutionAlgorithm {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ JSEngineResolutionAlgorithm[] $VALUES;
    public static final JSEngineResolutionAlgorithm JSC = new JSEngineResolutionAlgorithm("JSC", 0);
    public static final JSEngineResolutionAlgorithm HERMES = new JSEngineResolutionAlgorithm("HERMES", 1);

    private static final /* synthetic */ JSEngineResolutionAlgorithm[] $values() {
        return new JSEngineResolutionAlgorithm[]{JSC, HERMES};
    }

    public static EnumEntries<JSEngineResolutionAlgorithm> getEntries() {
        return $ENTRIES;
    }

    public static JSEngineResolutionAlgorithm valueOf(String str) {
        return (JSEngineResolutionAlgorithm) Enum.valueOf(JSEngineResolutionAlgorithm.class, str);
    }

    public static JSEngineResolutionAlgorithm[] values() {
        return (JSEngineResolutionAlgorithm[]) $VALUES.clone();
    }

    private JSEngineResolutionAlgorithm(String str, int i) {
    }

    static {
        JSEngineResolutionAlgorithm[] jSEngineResolutionAlgorithmArr$values = $values();
        $VALUES = jSEngineResolutionAlgorithmArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(jSEngineResolutionAlgorithmArr$values);
    }
}
