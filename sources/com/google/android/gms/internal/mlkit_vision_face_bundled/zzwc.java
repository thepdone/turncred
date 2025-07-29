package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzwc extends zzwg {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzwc() {
        super(null);
    }

    /* synthetic */ zzwc(zzwb zzwbVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwg
    final void zza(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzyg.zzf(obj, j);
        if (list instanceof zzwa) {
            objUnmodifiableList = ((zzwa) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzxa) && (list instanceof zzvs)) {
                zzvs zzvsVar = (zzvs) list;
                if (zzvsVar.zzc()) {
                    zzvsVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzyg.zzs(obj, j, objUnmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwg
    final void zzb(Object obj, Object obj2, long j) {
        zzvz zzvzVar;
        List list = (List) zzyg.zzf(obj2, j);
        int size = list.size();
        List listZzd = (List) zzyg.zzf(obj, j);
        if (listZzd.isEmpty()) {
            listZzd = listZzd instanceof zzwa ? new zzvz(size) : ((listZzd instanceof zzxa) && (listZzd instanceof zzvs)) ? ((zzvs) listZzd).zzd(size) : new ArrayList(size);
            zzyg.zzs(obj, j, listZzd);
        } else {
            if (zza.isAssignableFrom(listZzd.getClass())) {
                ArrayList arrayList = new ArrayList(listZzd.size() + size);
                arrayList.addAll(listZzd);
                zzyg.zzs(obj, j, arrayList);
                zzvzVar = arrayList;
            } else if (listZzd instanceof zzyb) {
                zzvz zzvzVar2 = new zzvz(listZzd.size() + size);
                zzvzVar2.addAll(zzvzVar2.size(), (zzyb) listZzd);
                zzyg.zzs(obj, j, zzvzVar2);
                zzvzVar = zzvzVar2;
            } else if ((listZzd instanceof zzxa) && (listZzd instanceof zzvs)) {
                zzvs zzvsVar = (zzvs) listZzd;
                if (!zzvsVar.zzc()) {
                    listZzd = zzvsVar.zzd(listZzd.size() + size);
                    zzyg.zzs(obj, j, listZzd);
                }
            }
            listZzd = zzvzVar;
        }
        int size2 = listZzd.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            listZzd.addAll(list);
        }
        if (size2 > 0) {
            list = listZzd;
        }
        zzyg.zzs(obj, j, list);
    }
}
