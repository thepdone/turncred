package com.google.android.gms.common.internal;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
/* loaded from: classes3.dex */
public final class zzu {
    public static final /* synthetic */ int zza = 0;
    private static final Uri zzb;
    private static final Uri zzc;

    static {
        Uri uri = Uri.parse("https://plus.google.com/");
        zzb = uri;
        zzc = uri.buildUpon().appendPath("circles").appendPath("find").build();
    }
}
