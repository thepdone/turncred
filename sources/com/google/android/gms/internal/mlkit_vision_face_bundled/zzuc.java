package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.NoSuchElementException;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzuc extends zzue {
    final /* synthetic */ zzul zza;
    private int zzb = 0;
    private final int zzc;

    zzuc(zzul zzulVar) {
        this.zza = zzulVar;
        this.zzc = zzulVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzug
    public final byte zza() {
        int i = this.zzb;
        if (i >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i + 1;
        return this.zza.zzb(i);
    }
}
