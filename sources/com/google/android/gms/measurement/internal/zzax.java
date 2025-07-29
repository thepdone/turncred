package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzax {
    private final String zza;
    private long zzb;
    private final /* synthetic */ zzar zzc;

    /* JADX WARN: Removed duplicated region for block: B:45:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzav> zza() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzax.zza():java.util.List");
    }

    public zzax(zzar zzarVar, String str) {
        this.zzc = zzarVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = -1L;
    }

    public zzax(zzar zzarVar, String str, long j) {
        this.zzc = zzarVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = zzarVar.zza("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", new String[]{str, String.valueOf(j)}, -1L);
    }
}
