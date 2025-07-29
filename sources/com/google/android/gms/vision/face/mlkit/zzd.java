package com.google.android.gms.vision.face.mlkit;

import android.content.Context;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzj;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzmy;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzmz;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzna;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zznb;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zznc;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zznu;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zznv;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zznw;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzst;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzti;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzd {
    private final zzst zza;

    public zzd(Context context, zzst zzstVar, boolean z) {
        zzj.zza(context);
        this.zza = zzstVar;
        zzj.zza(context);
    }

    public final void zza(zzti zztiVar, zznw zznwVar, zznv zznvVar) throws Throwable {
        zzmy zzmyVar = new zzmy();
        if (zztiVar.zzb() == 2) {
            zzmyVar.zza(zzmz.ALL_CLASSIFICATIONS);
        } else {
            zzmyVar.zza(zzmz.NO_CLASSIFICATIONS);
        }
        if (zztiVar.zzd() == 2) {
            zzmyVar.zzd(zznb.ALL_LANDMARKS);
        } else {
            zzmyVar.zzd(zznb.NO_LANDMARKS);
        }
        if (zztiVar.zzc() == 2) {
            zzmyVar.zzb(zzna.ALL_CONTOURS);
        } else {
            zzmyVar.zzb(zzna.NO_CONTOURS);
        }
        if (zztiVar.zze() == 2) {
            zzmyVar.zzf(zznc.ACCURATE);
        } else {
            zzmyVar.zzf(zznc.FAST);
        }
        zzmyVar.zze(Float.valueOf(zztiVar.zza()));
        zzmyVar.zzc(Boolean.valueOf(zztiVar.zzf()));
        this.zza.zzc(new zzc(zznu.TYPE_THICK, zzmyVar.zzk(), zznvVar, zznwVar == zznw.OPTIONAL_MODULE_FACE_DETECTION_CREATE ? 1 : 0), zznwVar);
    }
}
