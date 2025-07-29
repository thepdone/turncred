package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzjj;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzbd {
    private static final zzbd zza = new zzbd(null, 100);
    private final int zzb;
    private final String zzc;
    private final Boolean zzd;
    private final String zze;
    private final EnumMap<zzjj.zza, zzjm> zzf;

    public final int zza() {
        return this.zzb;
    }

    public final int hashCode() {
        Boolean bool = this.zzd;
        int i = bool == null ? 3 : bool == Boolean.TRUE ? 7 : 13;
        String str = this.zze;
        return this.zzc.hashCode() + (i * 29) + ((str == null ? 17 : str.hashCode()) * 137);
    }

    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        Iterator it = this.zzf.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String strZzb = zzjj.zzb((zzjm) entry.getValue());
            if (strZzb != null) {
                bundle.putString(((zzjj.zza) entry.getKey()).zze, strZzb);
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            bundle.putString("is_dma_region", bool.toString());
        }
        String str = this.zze;
        if (str != null) {
            bundle.putString("cps_display_str", str);
        }
        return bundle;
    }

    public static zzbd zza(Bundle bundle, int i) {
        if (bundle == null) {
            return new zzbd(null, i);
        }
        EnumMap enumMap = new EnumMap(zzjj.zza.class);
        for (zzjj.zza zzaVar : zzjl.DMA.zza()) {
            enumMap.put((EnumMap) zzaVar, (zzjj.zza) zzjj.zza(bundle.getString(zzaVar.zze)));
        }
        return new zzbd((EnumMap<zzjj.zza, zzjm>) enumMap, i, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    static zzbd zza(zzjm zzjmVar, int i) {
        EnumMap enumMap = new EnumMap(zzjj.zza.class);
        enumMap.put((EnumMap) zzjj.zza.AD_USER_DATA, (zzjj.zza) zzjmVar);
        return new zzbd((EnumMap<zzjj.zza, zzjm>) enumMap, -10, (Boolean) null, (String) null);
    }

    public static zzbd zza(String str) throws NumberFormatException {
        if (str == null || str.length() <= 0) {
            return zza;
        }
        String[] strArrSplit = str.split(":");
        int i = Integer.parseInt(strArrSplit[0]);
        EnumMap enumMap = new EnumMap(zzjj.zza.class);
        zzjj.zza[] zzaVarArrZza = zzjl.DMA.zza();
        int length = zzaVarArrZza.length;
        int i2 = 1;
        int i3 = 0;
        while (i3 < length) {
            enumMap.put((EnumMap) zzaVarArrZza[i3], (zzjj.zza) zzjj.zza(strArrSplit[i2].charAt(0)));
            i3++;
            i2++;
        }
        return new zzbd((EnumMap<zzjj.zza, zzjm>) enumMap, i, (Boolean) null, (String) null);
    }

    public final zzjm zzc() {
        zzjm zzjmVar = this.zzf.get(zzjj.zza.AD_USER_DATA);
        return zzjmVar == null ? zzjm.UNINITIALIZED : zzjmVar;
    }

    public static Boolean zza(Bundle bundle) {
        zzjm zzjmVarZza;
        if (bundle == null || (zzjmVarZza = zzjj.zza(bundle.getString("ad_personalization"))) == null) {
            return null;
        }
        int i = zzbc.zza[zzjmVarZza.ordinal()];
        if (i != 3) {
            return i != 4 ? null : true;
        }
        return false;
    }

    public final Boolean zzd() {
        return this.zzd;
    }

    private final String zzh() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzb);
        for (zzjj.zza zzaVar : zzjl.DMA.zza()) {
            sb.append(":");
            sb.append(zzjj.zza(this.zzf.get(zzaVar)));
        }
        return sb.toString();
    }

    public final String zze() {
        return this.zze;
    }

    public final String zzf() {
        return this.zzc;
    }

    public final String toString() {
        StringBuilder sbAppend = new StringBuilder("source=").append(zzjj.zza(this.zzb));
        for (zzjj.zza zzaVar : zzjl.DMA.zza()) {
            sbAppend.append(",");
            sbAppend.append(zzaVar.zze);
            sbAppend.append("=");
            zzjm zzjmVar = this.zzf.get(zzaVar);
            if (zzjmVar == null) {
                sbAppend.append("uninitialized");
            } else {
                int i = zzbc.zza[zzjmVar.ordinal()];
                if (i == 1) {
                    sbAppend.append("uninitialized");
                } else if (i == 2) {
                    sbAppend.append("eu_consent_policy");
                } else if (i == 3) {
                    sbAppend.append("denied");
                } else if (i == 4) {
                    sbAppend.append(PermissionsResponse.GRANTED_KEY);
                }
            }
        }
        if (this.zzd != null) {
            sbAppend.append(",isDmaRegion=").append(this.zzd);
        }
        if (this.zze != null) {
            sbAppend.append(",cpsDisplayStr=").append(this.zze);
        }
        return sbAppend.toString();
    }

    zzbd(Boolean bool, int i) {
        this((Boolean) null, i, (Boolean) null, (String) null);
    }

    zzbd(Boolean bool, int i, Boolean bool2, String str) {
        EnumMap<zzjj.zza, zzjm> enumMap = new EnumMap<>(zzjj.zza.class);
        this.zzf = enumMap;
        enumMap.put((EnumMap<zzjj.zza, zzjm>) zzjj.zza.AD_USER_DATA, (zzjj.zza) zzjj.zza(bool));
        this.zzb = i;
        this.zzc = zzh();
        this.zzd = bool2;
        this.zze = str;
    }

    private zzbd(EnumMap<zzjj.zza, zzjm> enumMap, int i, Boolean bool, String str) {
        EnumMap<zzjj.zza, zzjm> enumMap2 = new EnumMap<>(zzjj.zza.class);
        this.zzf = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzb = i;
        this.zzc = zzh();
        this.zzd = bool;
        this.zze = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbd)) {
            return false;
        }
        zzbd zzbdVar = (zzbd) obj;
        if (this.zzc.equalsIgnoreCase(zzbdVar.zzc) && Objects.equals(this.zzd, zzbdVar.zzd)) {
            return Objects.equals(this.zze, zzbdVar.zze);
        }
        return false;
    }

    public final boolean zzg() {
        Iterator<zzjm> it = this.zzf.values().iterator();
        while (it.hasNext()) {
            if (it.next() != zzjm.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }
}
