package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.concurrent.RunnableFuture;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.1 */
/* loaded from: classes3.dex */
final class zzew extends zzef implements RunnableFuture {

    @CheckForNull
    private volatile zzer zzc;

    zzew(zzxh zzxhVar) {
        this.zzc = new zzev(this, zzxhVar);
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzer zzerVar = this.zzc;
        if (zzerVar != null) {
            zzerVar.run();
        }
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzdz
    @CheckForNull
    protected final String zzf() {
        zzer zzerVar = this.zzc;
        if (zzerVar == null) {
            return super.zzf();
        }
        return "task=[" + zzerVar.toString() + "]";
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzdz
    protected final void zzm() {
        zzer zzerVar;
        if (zzp() && (zzerVar = this.zzc) != null) {
            zzerVar.zze();
        }
        this.zzc = null;
    }
}
