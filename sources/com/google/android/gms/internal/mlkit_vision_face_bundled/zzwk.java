package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzwk implements zzxg {
    private static final zzwq zza = new zzwi();
    private final zzwq zzb;

    public zzwk() {
        zzwq zzwqVar;
        zzwq[] zzwqVarArr = new zzwq[2];
        zzwqVarArr[0] = zzvg.zza();
        try {
            zzwqVar = (zzwq) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzwqVar = zza;
        }
        zzwqVarArr[1] = zzwqVar;
        zzwj zzwjVar = new zzwj(zzwqVarArr);
        byte[] bArr = zzvt.zzd;
        this.zzb = zzwjVar;
    }

    private static boolean zzb(zzwp zzwpVar) {
        return zzwpVar.zzc() + (-1) != 1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxg
    public final zzxf zza(Class cls) {
        zzxh.zzr(cls);
        zzwp zzwpVarZzb = this.zzb.zzb(cls);
        return zzwpVarZzb.zzb() ? zzvn.class.isAssignableFrom(cls) ? zzww.zzc(zzxh.zzn(), zzvb.zzb(), zzwpVarZzb.zza()) : zzww.zzc(zzxh.zzm(), zzvb.zza(), zzwpVarZzb.zza()) : zzvn.class.isAssignableFrom(cls) ? zzb(zzwpVarZzb) ? zzwv.zzl(cls, zzwpVarZzb, zzwz.zzb(), zzwg.zzd(), zzxh.zzn(), zzvb.zzb(), zzwo.zzb()) : zzwv.zzl(cls, zzwpVarZzb, zzwz.zzb(), zzwg.zzd(), zzxh.zzn(), null, zzwo.zzb()) : zzb(zzwpVarZzb) ? zzwv.zzl(cls, zzwpVarZzb, zzwz.zza(), zzwg.zzc(), zzxh.zzm(), zzvb.zza(), zzwo.zza()) : zzwv.zzl(cls, zzwpVarZzb, zzwz.zza(), zzwg.zzc(), zzxh.zzm(), null, zzwo.zza());
    }
}
