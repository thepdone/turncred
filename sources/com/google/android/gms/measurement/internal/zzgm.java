package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.tasks.OnFailureListener;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzgm {
    private static zzgm zza;
    private static final Duration zzb = Duration.ofMinutes(30);
    private final zzic zzc;
    private final TelemetryLoggingClient zzd;
    private final AtomicLong zze = new AtomicLong(-1);

    static zzgm zza(zzic zzicVar) {
        if (zza == null) {
            zza = new zzgm(zzicVar.zza(), zzicVar);
        }
        return zza;
    }

    private zzgm(Context context, zzic zzicVar) {
        this.zzd = TelemetryLogging.getClient(context, TelemetryLoggingOptions.builder().setApi("measurement:api").build());
        this.zzc = zzicVar;
    }

    public final synchronized void zza(int i, int i2, long j, long j2, int i3) {
        final long jElapsedRealtime = this.zzc.zzb().elapsedRealtime();
        if (this.zze.get() != -1 && jElapsedRealtime - this.zze.get() <= zzb.toMillis()) {
            return;
        }
        this.zzd.log(new TelemetryData(0, Arrays.asList(new MethodInvocation(36301, i2, 0, j, j2, null, null, 0, i3)))).addOnFailureListener(new OnFailureListener() { // from class: com.google.android.gms.measurement.internal.zzgp
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.zza.zze.set(jElapsedRealtime);
            }
        });
    }
}
