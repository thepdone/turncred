package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
final class zzli implements zzlj {
    @Override // com.google.android.gms.internal.measurement.zzlj
    public final int zza(int i, Object obj, Object obj2) {
        zzlg zzlgVar = (zzlg) obj;
        if (zzlgVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzlgVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final zzlh<?, ?> zza(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final Object zza(Object obj, Object obj2) {
        zzlg zzlgVarZzb = (zzlg) obj;
        zzlg zzlgVar = (zzlg) obj2;
        if (!zzlgVar.isEmpty()) {
            if (!zzlgVarZzb.zzd()) {
                zzlgVarZzb = zzlgVarZzb.zzb();
            }
            zzlgVarZzb.zza(zzlgVar);
        }
        return zzlgVarZzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final Object zzb(Object obj) {
        return zzlg.zza().zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final Object zzc(Object obj) {
        ((zzlg) obj).zzc();
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final Map<?, ?> zzd(Object obj) {
        return (zzlg) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final Map<?, ?> zze(Object obj) {
        return (zzlg) obj;
    }

    zzli() {
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final boolean zzf(Object obj) {
        return !((zzlg) obj).zzd();
    }
}
