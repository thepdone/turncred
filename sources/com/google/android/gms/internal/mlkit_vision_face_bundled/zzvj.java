package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public abstract class zzvj extends zzvn implements zzwt {
    protected zzvd zzb = zzvd.zzd();

    final zzvd zzb() {
        if (this.zzb.zzk()) {
            this.zzb = this.zzb.clone();
        }
        return this.zzb;
    }

    public final Object zzd(zzuw zzuwVar) {
        zzvl zzvlVar = (zzvl) zzuwVar;
        if (zzvlVar.zza != ((zzvn) zzf(6, null, null))) {
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }
        Object objZze = this.zzb.zze(zzvlVar.zzd);
        if (objZze == null) {
            return zzvlVar.zzb;
        }
        if (zzvlVar.zzd.zzb.zza() != zzyn.ENUM) {
            return objZze;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : (List) objZze) {
            if (zzvlVar.zzd.zzb.zza() == zzyn.ENUM) {
                ((Integer) obj).intValue();
                throw null;
            }
            arrayList.add(obj);
        }
        return arrayList;
    }
}
