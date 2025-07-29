package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
/* loaded from: classes3.dex */
abstract class zzl extends zzj {
    private static final WeakReference zza = new WeakReference(null);
    private WeakReference zzb;

    zzl(byte[] bArr) {
        super(bArr);
        this.zzb = zza;
    }

    protected abstract byte[] zzb();

    @Override // com.google.android.gms.common.zzj
    final byte[] zzf() {
        byte[] bArrZzb;
        synchronized (this) {
            bArrZzb = (byte[]) this.zzb.get();
            if (bArrZzb == null) {
                bArrZzb = zzb();
                this.zzb = new WeakReference(bArrZzb);
            }
        }
        return bArrZzb;
    }
}
