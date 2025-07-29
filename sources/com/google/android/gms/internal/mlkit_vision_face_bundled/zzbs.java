package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.Objects;
import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzbs extends zzbl {
    static final zzbl zza = new zzbs(null, new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    private zzbs(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    static zzbs zzg(int i, Object[] objArr, zzbk zzbkVar) {
        zzbc.zza(Objects.requireNonNull(objArr[0]), Objects.requireNonNull(objArr[1]));
        return new zzbs(null, objArr, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0003  */
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbl, java.util.Map
    @javax.annotation.CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object get(@javax.annotation.CheckForNull java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L5
        L3:
            r5 = r0
            goto L1f
        L5:
            int r1 = r4.zzc
            java.lang.Object[] r2 = r4.zzb
            r3 = 1
            if (r1 != r3) goto L3
            r1 = 0
            r1 = r2[r1]
            java.lang.Object r1 = java.util.Objects.requireNonNull(r1)
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L3
            r5 = r2[r3]
            java.lang.Object r5 = java.util.Objects.requireNonNull(r5)
        L1f:
            if (r5 != 0) goto L22
            return r0
        L22:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face_bundled.zzbs.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbl
    final zzbf zza() {
        return new zzbr(this.zzb, 1, this.zzc);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbl
    final zzbm zzd() {
        return new zzbp(this, this.zzb, 0, this.zzc);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbl
    final zzbm zze() {
        return new zzbq(this, new zzbr(this.zzb, 0, this.zzc));
    }
}
