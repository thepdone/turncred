package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzjj {
    public static final zzjj zza = new zzjj(null, null, 100);
    private final EnumMap<zza, zzjm> zzb;
    private final int zzc;

    public static boolean zza(int i, int i2) {
        if (i == -20 && i2 == -30) {
            return true;
        }
        return (i == -30 && i2 == -20) || i == i2 || i < i2;
    }

    static char zza(zzjm zzjmVar) {
        if (zzjmVar == null) {
            return '-';
        }
        int iOrdinal = zzjmVar.ordinal();
        if (iOrdinal == 1) {
            return '+';
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? '-' : '1';
        }
        return '0';
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
    public enum zza {
        AD_STORAGE("ad_storage"),
        ANALYTICS_STORAGE("analytics_storage"),
        AD_USER_DATA("ad_user_data"),
        AD_PERSONALIZATION("ad_personalization");

        public final String zze;

        zza(String str) {
            this.zze = str;
        }
    }

    public final int zza() {
        return this.zzc;
    }

    public final int hashCode() {
        int iHashCode = this.zzc * 17;
        Iterator<zzjm> it = this.zzb.values().iterator();
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + it.next().hashCode();
        }
        return iHashCode;
    }

    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        Iterator it = this.zzb.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String strZzb = zzb((zzjm) entry.getValue());
            if (strZzb != null) {
                bundle.putString(((zza) entry.getKey()).zze, strZzb);
            }
        }
        return bundle;
    }

    static zzjm zza(String str) {
        if (str == null) {
            return zzjm.UNINITIALIZED;
        }
        if (str.equals(PermissionsResponse.GRANTED_KEY)) {
            return zzjm.GRANTED;
        }
        if (str.equals("denied")) {
            return zzjm.DENIED;
        }
        return zzjm.UNINITIALIZED;
    }

    public final zzjm zzc() {
        zzjm zzjmVar = this.zzb.get(zza.AD_STORAGE);
        return zzjmVar == null ? zzjm.UNINITIALIZED : zzjmVar;
    }

    public final zzjm zzd() {
        zzjm zzjmVar = this.zzb.get(zza.ANALYTICS_STORAGE);
        return zzjmVar == null ? zzjm.UNINITIALIZED : zzjmVar;
    }

    static zzjm zza(char c) {
        if (c == '+') {
            return zzjm.POLICY;
        }
        if (c == '0') {
            return zzjm.DENIED;
        }
        if (c == '1') {
            return zzjm.GRANTED;
        }
        return zzjm.UNINITIALIZED;
    }

    static zzjm zza(Boolean bool) {
        if (bool == null) {
            return zzjm.UNINITIALIZED;
        }
        if (bool.booleanValue()) {
            return zzjm.GRANTED;
        }
        return zzjm.DENIED;
    }

    public static zzjj zza(Bundle bundle, int i) {
        if (bundle == null) {
            return new zzjj(null, null, i);
        }
        EnumMap enumMap = new EnumMap(zza.class);
        for (zza zzaVar : zzjl.STORAGE.zzd) {
            enumMap.put((EnumMap) zzaVar, (zza) zza(bundle.getString(zzaVar.zze)));
        }
        return new zzjj(enumMap, i);
    }

    public static zzjj zza(zzjm zzjmVar, zzjm zzjmVar2, int i) {
        EnumMap enumMap = new EnumMap(zza.class);
        enumMap.put((EnumMap) zza.AD_STORAGE, (zza) zzjmVar);
        enumMap.put((EnumMap) zza.ANALYTICS_STORAGE, (zza) zzjmVar2);
        return new zzjj(enumMap, -10);
    }

    public static zzjj zzb(String str) {
        return zza(str, 100);
    }

    public static zzjj zza(String str, int i) {
        EnumMap enumMap = new EnumMap(zza.class);
        if (str == null) {
            str = "";
        }
        zza[] zzaVarArrZza = zzjl.STORAGE.zza();
        for (int i2 = 0; i2 < zzaVarArrZza.length; i2++) {
            zza zzaVar = zzaVarArrZza[i2];
            int i3 = i2 + 2;
            if (i3 < str.length()) {
                enumMap.put((EnumMap) zzaVar, (zza) zza(str.charAt(i3)));
            } else {
                enumMap.put((EnumMap) zzaVar, (zza) zzjm.UNINITIALIZED);
            }
        }
        return new zzjj(enumMap, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzjj zza(com.google.android.gms.measurement.internal.zzjj r9) {
        /*
            r8 = this;
            java.util.EnumMap r0 = new java.util.EnumMap
            java.lang.Class<com.google.android.gms.measurement.internal.zzjj$zza> r1 = com.google.android.gms.measurement.internal.zzjj.zza.class
            r0.<init>(r1)
            com.google.android.gms.measurement.internal.zzjl r1 = com.google.android.gms.measurement.internal.zzjl.STORAGE
            com.google.android.gms.measurement.internal.zzjj$zza[] r1 = com.google.android.gms.measurement.internal.zzjl.zza(r1)
            int r2 = r1.length
            r3 = 0
        Lf:
            if (r3 >= r2) goto L54
            r4 = r1[r3]
            java.util.EnumMap<com.google.android.gms.measurement.internal.zzjj$zza, com.google.android.gms.measurement.internal.zzjm> r5 = r8.zzb
            java.lang.Object r5 = r5.get(r4)
            com.google.android.gms.measurement.internal.zzjm r5 = (com.google.android.gms.measurement.internal.zzjm) r5
            java.util.EnumMap<com.google.android.gms.measurement.internal.zzjj$zza, com.google.android.gms.measurement.internal.zzjm> r6 = r9.zzb
            java.lang.Object r6 = r6.get(r4)
            com.google.android.gms.measurement.internal.zzjm r6 = (com.google.android.gms.measurement.internal.zzjm) r6
            if (r5 != 0) goto L26
            goto L37
        L26:
            if (r6 != 0) goto L29
            goto L4c
        L29:
            com.google.android.gms.measurement.internal.zzjm r7 = com.google.android.gms.measurement.internal.zzjm.UNINITIALIZED
            if (r5 != r7) goto L2e
            goto L37
        L2e:
            com.google.android.gms.measurement.internal.zzjm r7 = com.google.android.gms.measurement.internal.zzjm.UNINITIALIZED
            if (r6 != r7) goto L33
            goto L4c
        L33:
            com.google.android.gms.measurement.internal.zzjm r7 = com.google.android.gms.measurement.internal.zzjm.POLICY
            if (r5 != r7) goto L39
        L37:
            r5 = r6
            goto L4c
        L39:
            com.google.android.gms.measurement.internal.zzjm r7 = com.google.android.gms.measurement.internal.zzjm.POLICY
            if (r6 != r7) goto L3e
            goto L4c
        L3e:
            com.google.android.gms.measurement.internal.zzjm r7 = com.google.android.gms.measurement.internal.zzjm.DENIED
            if (r5 == r7) goto L4a
            com.google.android.gms.measurement.internal.zzjm r5 = com.google.android.gms.measurement.internal.zzjm.DENIED
            if (r6 != r5) goto L47
            goto L4a
        L47:
            com.google.android.gms.measurement.internal.zzjm r5 = com.google.android.gms.measurement.internal.zzjm.GRANTED
            goto L4c
        L4a:
            com.google.android.gms.measurement.internal.zzjm r5 = com.google.android.gms.measurement.internal.zzjm.DENIED
        L4c:
            if (r5 == 0) goto L51
            r0.put(r4, r5)
        L51:
            int r3 = r3 + 1
            goto Lf
        L54:
            com.google.android.gms.measurement.internal.zzjj r9 = new com.google.android.gms.measurement.internal.zzjj
            r1 = 100
            r9.<init>(r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjj.zza(com.google.android.gms.measurement.internal.zzjj):com.google.android.gms.measurement.internal.zzjj");
    }

    public final zzjj zzb(zzjj zzjjVar) {
        EnumMap enumMap = new EnumMap(zza.class);
        for (zza zzaVar : zzjl.STORAGE.zzd) {
            zzjm zzjmVar = this.zzb.get(zzaVar);
            if (zzjmVar == zzjm.UNINITIALIZED) {
                zzjmVar = zzjjVar.zzb.get(zzaVar);
            }
            if (zzjmVar != null) {
                enumMap.put((EnumMap) zzaVar, (zza) zzjmVar);
            }
        }
        return new zzjj(enumMap, this.zzc);
    }

    static String zza(int i) {
        if (i == -30) {
            return "TCF";
        }
        if (i == -20) {
            return "API";
        }
        if (i == -10) {
            return "MANIFEST";
        }
        if (i == 0) {
            return "1P_API";
        }
        if (i == 30) {
            return "1P_INIT";
        }
        if (i == 90) {
            return "REMOTE_CONFIG";
        }
        if (i == 100) {
            return "UNKNOWN";
        }
        return "OTHER";
    }

    static String zzb(zzjm zzjmVar) {
        int iOrdinal = zzjmVar.ordinal();
        if (iOrdinal == 2) {
            return "denied";
        }
        if (iOrdinal != 3) {
            return null;
        }
        return PermissionsResponse.GRANTED_KEY;
    }

    public static String zza(Bundle bundle) {
        String string;
        zza[] zzaVarArr = zzjl.STORAGE.zzd;
        int length = zzaVarArr.length;
        int i = 0;
        while (true) {
            Boolean bool = null;
            if (i >= length) {
                return null;
            }
            zza zzaVar = zzaVarArr[i];
            if (bundle.containsKey(zzaVar.zze) && (string = bundle.getString(zzaVar.zze)) != null) {
                if (string != null) {
                    if (string.equals(PermissionsResponse.GRANTED_KEY)) {
                        bool = Boolean.TRUE;
                    } else if (string.equals("denied")) {
                        bool = Boolean.FALSE;
                    }
                }
                if (bool == null) {
                    return string;
                }
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String zze() {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "G1"
            r0.<init>(r1)
            com.google.android.gms.measurement.internal.zzjl r1 = com.google.android.gms.measurement.internal.zzjl.STORAGE
            com.google.android.gms.measurement.internal.zzjj$zza[] r1 = r1.zza()
            int r2 = r1.length
            r3 = 0
        Lf:
            if (r3 >= r2) goto L3a
            r4 = r1[r3]
            java.util.EnumMap<com.google.android.gms.measurement.internal.zzjj$zza, com.google.android.gms.measurement.internal.zzjm> r5 = r7.zzb
            java.lang.Object r4 = r5.get(r4)
            com.google.android.gms.measurement.internal.zzjm r4 = (com.google.android.gms.measurement.internal.zzjm) r4
            r5 = 45
            if (r4 == 0) goto L34
            int r4 = r4.ordinal()
            if (r4 == 0) goto L34
            r6 = 1
            if (r4 == r6) goto L32
            r6 = 2
            if (r4 == r6) goto L2f
            r6 = 3
            if (r4 == r6) goto L32
            goto L34
        L2f:
            r5 = 48
            goto L34
        L32:
            r5 = 49
        L34:
            r0.append(r5)
            int r3 = r3 + 1
            goto Lf
        L3a:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjj.zze():java.lang.String");
    }

    public final String zzf() {
        StringBuilder sb = new StringBuilder("G1");
        for (zza zzaVar : zzjl.STORAGE.zza()) {
            sb.append(zza(this.zzb.get(zzaVar)));
        }
        return sb.toString();
    }

    public final String toString() {
        StringBuilder sbAppend = new StringBuilder("source=").append(zza(this.zzc));
        for (zza zzaVar : zzjl.STORAGE.zzd) {
            sbAppend.append(",");
            sbAppend.append(zzaVar.zze);
            sbAppend.append("=");
            zzjm zzjmVar = this.zzb.get(zzaVar);
            if (zzjmVar == null) {
                zzjmVar = zzjm.UNINITIALIZED;
            }
            sbAppend.append(zzjmVar);
        }
        return sbAppend.toString();
    }

    private zzjj(EnumMap<zza, zzjm> enumMap, int i) {
        EnumMap<zza, zzjm> enumMap2 = new EnumMap<>(zza.class);
        this.zzb = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzc = i;
    }

    public zzjj(Boolean bool, Boolean bool2, int i) {
        EnumMap<zza, zzjm> enumMap = new EnumMap<>(zza.class);
        this.zzb = enumMap;
        enumMap.put((EnumMap<zza, zzjm>) zza.AD_STORAGE, (zza) zza((Boolean) null));
        enumMap.put((EnumMap<zza, zzjm>) zza.ANALYTICS_STORAGE, (zza) zza((Boolean) null));
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzjj)) {
            return false;
        }
        zzjj zzjjVar = (zzjj) obj;
        for (zza zzaVar : zzjl.STORAGE.zzd) {
            if (this.zzb.get(zzaVar) != zzjjVar.zzb.get(zzaVar)) {
                return false;
            }
        }
        return this.zzc == zzjjVar.zzc;
    }

    public final boolean zzg() {
        return zza(zza.AD_STORAGE);
    }

    public final boolean zza(zza zzaVar) {
        return this.zzb.get(zzaVar) != zzjm.DENIED;
    }

    public final boolean zzh() {
        return zza(zza.ANALYTICS_STORAGE);
    }

    public final boolean zzi() {
        Iterator<zzjm> it = this.zzb.values().iterator();
        while (it.hasNext()) {
            if (it.next() != zzjm.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzc(zzjj zzjjVar) {
        for (zza zzaVar : (zza[]) this.zzb.keySet().toArray(new zza[0])) {
            zzjm zzjmVar = this.zzb.get(zzaVar);
            zzjm zzjmVar2 = zzjjVar.zzb.get(zzaVar);
            if (zzjmVar == zzjm.DENIED && zzjmVar2 != zzjm.DENIED) {
                return true;
            }
        }
        return false;
    }
}
