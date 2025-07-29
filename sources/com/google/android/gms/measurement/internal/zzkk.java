package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.util.SparseArray;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzkk implements FutureCallback<Object> {
    private final /* synthetic */ zzog zza;
    private final /* synthetic */ zzju zzb;

    zzkk(zzju zzjuVar, zzog zzogVar) {
        this.zza = zzogVar;
        this.zzb = zzjuVar;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable th) throws IllegalStateException {
        this.zzb.zzv();
        this.zzb.zzh = false;
        int iZza = (this.zzb.zze().zza(zzbn.zzct) ? zzju.zza(this.zzb, th) : 2) - 1;
        if (iZza == 0) {
            this.zzb.zzj().zzr().zza("registerTriggerAsync failed with retriable error. Will try later. App ID, throwable", zzgo.zza(this.zzb.zzg().zzaf()), zzgo.zza(th.toString()));
            this.zzb.zzi = 1;
            this.zzb.zzan().add(this.zza);
            return;
        }
        if (iZza != 1) {
            if (iZza != 2) {
                return;
            }
            this.zzb.zzj().zzg().zza("registerTriggerAsync failed. Dropping URI. App ID, Throwable", zzgo.zza(this.zzb.zzg().zzaf()), th);
            zza();
            this.zzb.zzi = 1;
            this.zzb.zzav();
            return;
        }
        this.zzb.zzan().add(this.zza);
        if (this.zzb.zzi > zzbn.zzbq.zza(null).intValue()) {
            this.zzb.zzi = 1;
            this.zzb.zzj().zzr().zza("registerTriggerAsync failed. May try later. App ID, throwable", zzgo.zza(this.zzb.zzg().zzaf()), zzgo.zza(th.toString()));
            return;
        }
        this.zzb.zzj().zzr().zza("registerTriggerAsync failed. App ID, delay in seconds, throwable", zzgo.zza(this.zzb.zzg().zzaf()), zzgo.zza(String.valueOf(this.zzb.zzi)), zzgo.zza(th.toString()));
        zzju zzjuVar = this.zzb;
        zzju.zzb(zzjuVar, zzjuVar.zzi);
        this.zzb.zzi <<= 1;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onSuccess(Object obj) throws IllegalStateException {
        this.zzb.zzv();
        zza();
        this.zzb.zzh = false;
        this.zzb.zzi = 1;
        this.zzb.zzj().zzc().zza("Successfully registered trigger URI", this.zza.zza);
        this.zzb.zzav();
    }

    private final void zza() {
        SparseArray<Long> sparseArrayZzm = this.zzb.zzk().zzm();
        sparseArrayZzm.put(this.zza.zzc, Long.valueOf(this.zza.zzb));
        zzha zzhaVarZzk = this.zzb.zzk();
        if (sparseArrayZzm == null) {
            zzhaVarZzk.zzi.zza(null);
            return;
        }
        int[] iArr = new int[sparseArrayZzm.size()];
        long[] jArr = new long[sparseArrayZzm.size()];
        for (int i = 0; i < sparseArrayZzm.size(); i++) {
            iArr[i] = sparseArrayZzm.keyAt(i);
            jArr[i] = sparseArrayZzm.valueAt(i).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        zzhaVarZzk.zzi.zza(bundle);
    }
}
