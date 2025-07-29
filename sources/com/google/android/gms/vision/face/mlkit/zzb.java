package com.google.android.gms.vision.face.mlkit;

import android.content.Context;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zznv;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zznw;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzso;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzsp;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzst;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzte;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzti;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.List;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzb {
    private final zzd zza;

    public zzb(Context context, boolean z) {
        zzso zzsoVarZzd = zzso.zzd("optional-module-face").zzd();
        this.zza = new zzd(context, new zzst(context, new SharedPrefManager(context), new zzsp(context, zzsoVarZzd), zzsoVarZzd.zzb()), false);
    }

    final void zza(zzti zztiVar, zzte zzteVar, List list, long j) throws Throwable {
        this.zza.zza(zztiVar, zznw.OPTIONAL_MODULE_FACE_DETECTION_INFERENCE, zznv.NO_ERROR);
    }

    final void zzb(zzti zztiVar, String str, long j) throws Throwable {
        this.zza.zza(zztiVar, zznw.OPTIONAL_MODULE_FACE_DETECTION_CREATE, str != null ? zznv.OPTIONAL_MODULE_CREATE_ERROR : zznv.NO_ERROR);
    }

    final void zzc(zzti zztiVar) throws Throwable {
        this.zza.zza(zztiVar, zznw.OPTIONAL_MODULE_FACE_DETECTION_INIT, zznv.NO_ERROR);
    }
}
