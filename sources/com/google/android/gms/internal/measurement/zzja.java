package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
final class zzja implements Comparator<zziy> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zziy zziyVar, zziy zziyVar2) {
        zziy zziyVar3 = zziyVar;
        zziy zziyVar4 = zziyVar2;
        zzje zzjeVar = (zzje) zziyVar3.iterator();
        zzje zzjeVar2 = (zzje) zziyVar4.iterator();
        while (zzjeVar.hasNext() && zzjeVar2.hasNext()) {
            int iCompare = Integer.compare(zziy.zza(zzjeVar.zza()), zziy.zza(zzjeVar2.zza()));
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Integer.compare(zziyVar3.zzb(), zziyVar4.zzb());
    }

    zzja() {
    }
}
