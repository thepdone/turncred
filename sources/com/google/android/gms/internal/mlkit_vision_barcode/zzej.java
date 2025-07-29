package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.1 */
/* loaded from: classes3.dex */
public final class zzej extends zzel {
    public static zzet zza(Object obj) {
        return new zzem(obj);
    }

    public static void zzb(zzet zzetVar, zzeh zzehVar, Executor executor) {
        zzetVar.zzl(new zzei(zzetVar, zzehVar), executor);
    }

    public static zzet zzc(zzxh zzxhVar, Executor executor) {
        zzew zzewVar = new zzew(zzxhVar);
        zzewVar.run();
        return zzewVar;
    }
}
