package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
public class zzku {
    private volatile zzlm zza;
    private volatile zziy zzb;
    private volatile boolean zzc;

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzb != null) {
            return this.zzb.zzb();
        }
        if (this.zza != null) {
            return this.zza.zzcf();
        }
        return 0;
    }

    public final zziy zzb() {
        if (this.zzb != null) {
            return this.zzb;
        }
        synchronized (this) {
            if (this.zzb != null) {
                return this.zzb;
            }
            if (this.zza == null) {
                this.zzb = zziy.zza;
            } else {
                this.zzb = this.zza.zzcd();
            }
            return this.zzb;
        }
    }

    private final zzlm zzb(zzlm zzlmVar) {
        if (this.zza == null) {
            synchronized (this) {
                if (this.zza == null) {
                    try {
                        this.zza = zzlmVar;
                        this.zzb = zziy.zza;
                    } catch (zzkp unused) {
                        this.zzc = true;
                        this.zza = zzlmVar;
                        this.zzb = zziy.zza;
                    }
                }
            }
        }
        return this.zza;
    }

    public final zzlm zza(zzlm zzlmVar) {
        zzlm zzlmVar2 = this.zza;
        this.zzb = null;
        this.zza = zzlmVar;
        return zzlmVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzku)) {
            return false;
        }
        zzku zzkuVar = (zzku) obj;
        zzlm zzlmVar = this.zza;
        zzlm zzlmVar2 = zzkuVar.zza;
        if (zzlmVar == null && zzlmVar2 == null) {
            return zzb().equals(zzkuVar.zzb());
        }
        if (zzlmVar != null && zzlmVar2 != null) {
            return zzlmVar.equals(zzlmVar2);
        }
        if (zzlmVar != null) {
            return zzlmVar.equals(zzkuVar.zzb(zzlmVar.zzal()));
        }
        return zzb(zzlmVar2.zzal()).equals(zzlmVar2);
    }
}
