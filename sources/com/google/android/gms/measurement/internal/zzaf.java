package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzaf {
    zzaf(Context context) {
    }

    public static boolean zza() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
