package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzfx<V> {
    private static final Object zza = new Object();
    private final String zzb;
    private final zzfv<V> zzc;
    private final V zzd;
    private final Object zze;
    private volatile V zzf;
    private volatile V zzg;

    public final V zza(V v) {
        synchronized (this.zze) {
        }
        if (v != null) {
            return v;
        }
        if (zzfu.zza == null) {
            return this.zzd;
        }
        synchronized (zza) {
            if (zzaf.zza()) {
                return this.zzg == null ? this.zzd : this.zzg;
            }
            try {
                for (zzfx zzfxVar : zzbn.zzdf) {
                    if (zzaf.zza()) {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                    V vZza = null;
                    try {
                        zzfv<V> zzfvVar = zzfxVar.zzc;
                        if (zzfvVar != null) {
                            vZza = zzfvVar.zza();
                        }
                    } catch (IllegalStateException unused) {
                    }
                    synchronized (zza) {
                        zzfxVar.zzg = vZza;
                    }
                }
            } catch (SecurityException unused2) {
            }
            zzfv<V> zzfvVar2 = this.zzc;
            if (zzfvVar2 == null) {
                return this.zzd;
            }
            try {
                return zzfvVar2.zza();
            } catch (IllegalStateException unused3) {
                return this.zzd;
            } catch (SecurityException unused4) {
                return this.zzd;
            }
        }
    }

    public final String zza() {
        return this.zzb;
    }

    private zzfx(String str, V v, V v2, zzfv<V> zzfvVar) {
        this.zze = new Object();
        this.zzf = null;
        this.zzg = null;
        this.zzb = str;
        this.zzd = v;
        this.zzc = zzfvVar;
    }
}
