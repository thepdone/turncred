package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.Arrays;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzbg extends zzbd {
    public zzbg() {
        super(4);
    }

    public final zzbj zzb() {
        this.zzc = true;
        return zzbj.zzg(this.zza, this.zzb);
    }

    public final zzbg zza(Object obj) {
        obj.getClass();
        int i = this.zzb;
        int i2 = i + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length < i2) {
            int i3 = length + (length >> 1) + 1;
            if (i3 < i2) {
                int iHighestOneBit = Integer.highestOneBit(i);
                i3 = iHighestOneBit + iHighestOneBit;
            }
            if (i3 < 0) {
                i3 = Integer.MAX_VALUE;
            }
            this.zza = Arrays.copyOf(objArr, i3);
            this.zzc = false;
        } else if (this.zzc) {
            this.zza = (Object[]) objArr.clone();
            this.zzc = false;
        }
        Object[] objArr2 = this.zza;
        int i4 = this.zzb;
        this.zzb = i4 + 1;
        objArr2[i4] = obj;
        return this;
    }
}
