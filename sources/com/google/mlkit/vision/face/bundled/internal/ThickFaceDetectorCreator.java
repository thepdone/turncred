package com.google.mlkit.vision.face.bundled.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzti;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zztn;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zztp;
import com.google.android.gms.vision.face.FaceDetectorV2Jni;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public class ThickFaceDetectorCreator extends zztp {
    static {
        System.loadLibrary("face_detector_v2_jni");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zztq
    public zztn newFaceDetector(IObjectWrapper iObjectWrapper, zzti zztiVar) throws RemoteException {
        return new zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zztiVar, new FaceDetectorV2Jni());
    }
}
