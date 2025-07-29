package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzwe extends zzwg {
    private zzwe() {
        super(null);
    }

    /* synthetic */ zzwe(zzwd zzwdVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwg
    final void zza(Object obj, long j) {
        ((zzvs) zzyg.zzf(obj, j)).zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwg
    final void zzb(Object obj, Object obj2, long j) {
        zzvs zzvsVarZzd = (zzvs) zzyg.zzf(obj, j);
        zzvs zzvsVar = (zzvs) zzyg.zzf(obj2, j);
        int size = zzvsVarZzd.size();
        int size2 = zzvsVar.size();
        if (size > 0 && size2 > 0) {
            if (!zzvsVarZzd.zzc()) {
                zzvsVarZzd = zzvsVarZzd.zzd(size2 + size);
            }
            zzvsVarZzd.addAll(zzvsVar);
        }
        if (size > 0) {
            zzvsVar = zzvsVarZzd;
        }
        zzyg.zzs(obj, j, zzvsVar);
    }
}
