package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
enum zzam {
    UNSET('0'),
    REMOTE_DEFAULT('1'),
    REMOTE_DELEGATION('2'),
    MANIFEST('3'),
    INITIALIZATION('4'),
    API('5'),
    CHILD_ACCOUNT('6'),
    TCF('7'),
    REMOTE_ENFORCED_DEFAULT('8'),
    FAILSAFE('9');

    private final char zzl;

    public static zzam zza(char c) {
        for (zzam zzamVar : values()) {
            if (zzamVar.zzl == c) {
                return zzamVar;
            }
        }
        return UNSET;
    }

    zzam(char c) {
        this.zzl = c;
    }
}
