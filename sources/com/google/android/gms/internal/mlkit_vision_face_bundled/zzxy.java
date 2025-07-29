package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.io.IOException;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzxy extends zzxw {
    zzxy() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxw
    final /* synthetic */ int zza(Object obj) {
        return ((zzxx) obj).zza();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxw
    final /* synthetic */ int zzb(Object obj) {
        return ((zzxx) obj).zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxw
    final /* bridge */ /* synthetic */ Object zzc(Object obj) {
        zzvn zzvnVar = (zzvn) obj;
        zzxx zzxxVar = zzvnVar.zzc;
        if (zzxxVar != zzxx.zzc()) {
            return zzxxVar;
        }
        zzxx zzxxVarZzf = zzxx.zzf();
        zzvnVar.zzc = zzxxVarZzf;
        return zzxxVarZzf;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxw
    final /* synthetic */ Object zzd(Object obj) {
        return ((zzvn) obj).zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxw
    final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        if (zzxx.zzc().equals(obj2)) {
            return obj;
        }
        if (zzxx.zzc().equals(obj)) {
            return zzxx.zze((zzxx) obj, (zzxx) obj2);
        }
        ((zzxx) obj).zzd((zzxx) obj2);
        return obj;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxw
    final /* bridge */ /* synthetic */ void zzf(Object obj, int i, long j) {
        ((zzxx) obj).zzj(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxw
    final void zzg(Object obj) {
        ((zzvn) obj).zzc.zzh();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxw
    final /* synthetic */ void zzh(Object obj, Object obj2) {
        ((zzvn) obj).zzc = (zzxx) obj2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxw
    final /* synthetic */ void zzi(Object obj, zzyo zzyoVar) throws IOException {
        ((zzxx) obj).zzk(zzyoVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxw
    final /* synthetic */ void zzj(Object obj, zzyo zzyoVar) throws IOException {
        ((zzxx) obj).zzl(zzyoVar);
    }
}
