package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
class zzgy extends BroadcastReceiver {
    private final zzou zza;
    private boolean zzb;
    private boolean zzc;

    zzgy(zzou zzouVar) {
        Preconditions.checkNotNull(zzouVar);
        this.zza = zzouVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws IllegalStateException {
        this.zza.zzt();
        String action = intent.getAction();
        this.zza.zzj().zzq().zza("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zZzr = this.zza.zzh().zzr();
            if (this.zzc != zZzr) {
                this.zzc = zZzr;
                this.zza.zzl().zzb(new zzhb(this, zZzr));
                return;
            }
            return;
        }
        this.zza.zzj().zzr().zza("NetworkBroadcastReceiver received unknown action", action);
    }

    public final void zza() {
        this.zza.zzt();
        this.zza.zzl().zzv();
        if (this.zzb) {
            return;
        }
        this.zza.zza().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.zzc = this.zza.zzh().zzr();
        this.zza.zzj().zzq().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzc));
        this.zzb = true;
    }

    public final void zzb() {
        this.zza.zzt();
        this.zza.zzl().zzv();
        this.zza.zzl().zzv();
        if (this.zzb) {
            this.zza.zzj().zzq().zza("Unregistering connectivity change receiver");
            this.zzb = false;
            this.zzc = false;
            try {
                this.zza.zza().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.zza.zzj().zzg().zza("Failed to unregister the network broadcast receiver", e);
            }
        }
    }
}
