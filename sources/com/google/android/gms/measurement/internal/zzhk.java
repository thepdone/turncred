package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzhk {
    private final zza zza;

    /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
    public interface zza {
        void doStartService(Context context, Intent intent);
    }

    public zzhk(zza zzaVar) {
        Preconditions.checkNotNull(zzaVar);
        this.zza = zzaVar;
    }

    public final void zza(Context context, Intent intent) throws IllegalStateException {
        zzgo zzgoVarZzj = zzic.zza(context, null, null).zzj();
        if (intent == null) {
            zzgoVarZzj.zzr().zza("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        zzgoVarZzj.zzq().zza("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzgoVarZzj.zzq().zza("Starting wakeful intent.");
            this.zza.doStartService(context, className);
            return;
        }
        if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            zzgoVarZzj.zzr().zza("Install Referrer Broadcasts are deprecated");
        }
    }
}
