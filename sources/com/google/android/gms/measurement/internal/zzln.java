package com.google.android.gms.measurement.internal;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
final class zzln implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ Uri zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzlk zze;

    zzln(zzlk zzlkVar, boolean z, Uri uri, String str, String str2) {
        this.zza = z;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
        this.zze = zzlkVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzlk.zza(this.zze, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
