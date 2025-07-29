package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzhi implements ServiceConnection {
    final /* synthetic */ zzhj zza;
    private final String zzb;

    zzhi(zzhj zzhjVar, String str) {
        this.zza = zzhjVar;
        this.zzb = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) throws IllegalStateException {
        if (iBinder == null) {
            this.zza.zza.zzj().zzr().zza("Install Referrer connection returned with null binder");
            return;
        }
        try {
            com.google.android.gms.internal.measurement.zzbz zzbzVarZza = com.google.android.gms.internal.measurement.zzby.zza(iBinder);
            if (zzbzVarZza == null) {
                this.zza.zza.zzj().zzr().zza("Install Referrer Service implementation was not found");
            } else {
                this.zza.zza.zzj().zzq().zza("Install Referrer Service connected");
                this.zza.zza.zzl().zzb(new zzhl(this, zzbzVarZza, this));
            }
        } catch (RuntimeException e) {
            this.zza.zza.zzj().zzr().zza("Exception occurred while calling Install Referrer API", e);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) throws IllegalStateException {
        this.zza.zza.zzj().zzq().zza("Install Referrer Service disconnected");
    }
}
