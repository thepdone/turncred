package com.google.android.gms.internal.measurement;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzcy {
    public static final int zza;

    public static PendingIntent zza(Context context, int i, Intent intent, int i2) {
        return PendingIntent.getBroadcast(context, 0, intent, i2);
    }

    static {
        zza = Build.VERSION.SDK_INT >= 31 ? 33554432 : 0;
    }
}
