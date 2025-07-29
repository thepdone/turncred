package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
final class zzlf implements zzln {
    private zzln[] zza;

    @Override // com.google.android.gms.internal.measurement.zzln
    public final zzlk zza(Class<?> cls) {
        for (zzln zzlnVar : this.zza) {
            if (zzlnVar.zzb(cls)) {
                return zzlnVar.zza(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
    }

    zzlf(zzln... zzlnVarArr) {
        this.zza = zzlnVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final boolean zzb(Class<?> cls) {
        for (zzln zzlnVar : this.zza) {
            if (zzlnVar.zzb(cls)) {
                return true;
            }
        }
        return false;
    }
}
