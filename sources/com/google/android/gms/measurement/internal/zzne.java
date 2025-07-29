package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzne implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzp zze;
    private final /* synthetic */ zzme zzf;

    zzne(zzme zzmeVar, AtomicReference atomicReference, String str, String str2, String str3, zzp zzpVar) {
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = zzpVar;
        this.zzf = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfz zzfzVar;
        synchronized (this.zza) {
            try {
                try {
                    zzfzVar = this.zzf.zzb;
                } finally {
                    this.zza.notify();
                }
            } catch (RemoteException e) {
                this.zzf.zzj().zzg().zza("(legacy) Failed to get conditional properties; remote exception", zzgo.zza(this.zzb), this.zzc, e);
                this.zza.set(Collections.emptyList());
            }
            if (zzfzVar == null) {
                this.zzf.zzj().zzg().zza("(legacy) Failed to get conditional properties; not connected to service", zzgo.zza(this.zzb), this.zzc, this.zzd);
                this.zza.set(Collections.emptyList());
                return;
            }
            if (TextUtils.isEmpty(this.zzb)) {
                Preconditions.checkNotNull(this.zze);
                this.zza.set(zzfzVar.zza(this.zzc, this.zzd, this.zze));
            } else {
                this.zza.set(zzfzVar.zza(this.zzb, this.zzc, this.zzd));
            }
            this.zzf.zzar();
            this.zza.notify();
        }
    }
}
