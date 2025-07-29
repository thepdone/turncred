package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public class zzvi extends zzvh implements zzwt {
    protected zzvi(zzvj zzvjVar) {
        super(zzvjVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzvh, com.google.android.gms.internal.mlkit_vision_face_bundled.zzwr
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzvj zzp() {
        if (!((zzvj) this.zza).zzI()) {
            return (zzvj) this.zza;
        }
        ((zzvj) this.zza).zzb.zzh();
        return (zzvj) super.zzp();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzvh
    protected final void zzs() {
        super.zzs();
        if (((zzvj) this.zza).zzb != zzvd.zzd()) {
            zzvj zzvjVar = (zzvj) this.zza;
            zzvjVar.zzb = zzvjVar.zzb.clone();
        }
    }
}
