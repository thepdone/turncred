package com.google.android.gms.vision.face.mlkit;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzti;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zztn;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zztp;
import com.google.android.gms.vision.face.FaceDetectorV2Jni;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public class FaceDetectorCreator extends zztp {
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zztq
    public zztn newFaceDetector(IObjectWrapper iObjectWrapper, zzti zztiVar) throws Throwable {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzb zzbVar = new zzb(context, true);
        try {
            System.loadLibrary("face_detector_v2_jni");
            zzbVar.zzb(zztiVar, null, SystemClock.elapsedRealtime() - jElapsedRealtime);
            return new zza(context, zztiVar, new FaceDetectorV2Jni(), zzbVar);
        } catch (UnsatisfiedLinkError e) {
            Log.e("FaceDetectorCreator", "Failed to load library face_detector_v2_jni");
            zzbVar.zzb(zztiVar, "Failed to load library face_detector_v2_jni", SystemClock.elapsedRealtime() - jElapsedRealtime);
            throw ((RemoteException) zze.zza("Failed to load library face_detector_v2_jni").initCause(e));
        }
    }
}
