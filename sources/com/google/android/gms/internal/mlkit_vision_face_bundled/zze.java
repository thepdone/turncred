package com.google.android.gms.internal.mlkit_vision_face_bundled;

import android.content.Context;
import javax.annotation.Nullable;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zze extends zzi {
    private final Context zza;

    @Nullable
    private final zzax zzb;

    zze(Context context, @Nullable zzax zzaxVar) {
        this.zza = context;
        this.zzb = zzaxVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzi) {
            zzi zziVar = (zzi) obj;
            if (this.zza.equals(zziVar.zza()) && this.zzb.equals(zziVar.zzb())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode();
    }

    public final String toString() {
        zzax zzaxVar = this.zzb;
        return "FlagsContext{context=" + this.zza.toString() + ", hermeticFileOverrides=" + zzaxVar.toString() + "}";
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzi
    final Context zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzi
    @Nullable
    final zzax zzb() {
        return this.zzb;
    }
}
