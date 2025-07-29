package com.google.android.gms.measurement.internal;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.measurement.internal.zzjj;
import java.util.EnumMap;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
final class zzan {
    private final EnumMap<zzjj.zza, zzam> zza;

    public final zzam zza(zzjj.zza zzaVar) {
        zzam zzamVar = this.zza.get(zzaVar);
        return zzamVar == null ? zzam.UNSET : zzamVar;
    }

    public static zzan zza(String str) {
        EnumMap enumMap = new EnumMap(zzjj.zza.class);
        if (str.length() >= zzjj.zza.values().length) {
            int i = 0;
            if (str.charAt(0) == '1') {
                zzjj.zza[] zzaVarArrValues = zzjj.zza.values();
                int length = zzaVarArrValues.length;
                int i2 = 1;
                while (i < length) {
                    enumMap.put((EnumMap) zzaVarArrValues[i], (zzjj.zza) zzam.zza(str.charAt(i2)));
                    i++;
                    i2++;
                }
                return new zzan(enumMap);
            }
        }
        return new zzan();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        for (zzjj.zza zzaVar : zzjj.zza.values()) {
            zzam zzamVar = this.zza.get(zzaVar);
            if (zzamVar == null) {
                zzamVar = zzam.UNSET;
            }
            sb.append(zzamVar.zzl);
        }
        return sb.toString();
    }

    zzan() {
        this.zza = new EnumMap<>(zzjj.zza.class);
    }

    private zzan(EnumMap<zzjj.zza, zzam> enumMap) {
        EnumMap<zzjj.zza, zzam> enumMap2 = new EnumMap<>(zzjj.zza.class);
        this.zza = enumMap2;
        enumMap2.putAll(enumMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(com.google.android.gms.measurement.internal.zzjj.zza r3, int r4) {
        /*
            r2 = this;
            com.google.android.gms.measurement.internal.zzam r0 = com.google.android.gms.measurement.internal.zzam.UNSET
            r1 = -30
            if (r4 == r1) goto L1e
            r1 = -20
            if (r4 == r1) goto L1b
            r1 = -10
            if (r4 == r1) goto L18
            if (r4 == 0) goto L1b
            r1 = 30
            if (r4 == r1) goto L15
            goto L20
        L15:
            com.google.android.gms.measurement.internal.zzam r0 = com.google.android.gms.measurement.internal.zzam.INITIALIZATION
            goto L20
        L18:
            com.google.android.gms.measurement.internal.zzam r0 = com.google.android.gms.measurement.internal.zzam.MANIFEST
            goto L20
        L1b:
            com.google.android.gms.measurement.internal.zzam r0 = com.google.android.gms.measurement.internal.zzam.API
            goto L20
        L1e:
            com.google.android.gms.measurement.internal.zzam r0 = com.google.android.gms.measurement.internal.zzam.TCF
        L20:
            java.util.EnumMap<com.google.android.gms.measurement.internal.zzjj$zza, com.google.android.gms.measurement.internal.zzam> r4 = r2.zza
            r4.put(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zza(com.google.android.gms.measurement.internal.zzjj$zza, int):void");
    }

    public final void zza(zzjj.zza zzaVar, zzam zzamVar) {
        this.zza.put((EnumMap<zzjj.zza, zzam>) zzaVar, (zzjj.zza) zzamVar);
    }
}
