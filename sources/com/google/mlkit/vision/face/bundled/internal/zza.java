package com.google.mlkit.vision.face.bundled.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Build;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzaf;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzag;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzah;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzai;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzaj;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzan;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzao;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzaq;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzar;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzd;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzo;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzp;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzs;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzt;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzte;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzti;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zztm;
import com.google.android.gms.vision.face.FaceDetectorV2Jni;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zza extends zztm {
    private final Context zza;
    private final zzah zzb;
    private final FaceDetectorV2Jni zzc;
    private long zzd = -1;

    zza(Context context, zzti zztiVar, FaceDetectorV2Jni faceDetectorV2Jni) {
        this.zza = context;
        int iZzc = zztiVar.zzc();
        zzaq zzaqVarZza = zzar.zza();
        zzaqVarZza.zzb("models_bundled");
        zzar zzarVar = (zzar) zzaqVarZza.zzn();
        int iZze = zztiVar.zze();
        zzai zzaiVarZza = zzaj.zza();
        zzaq zzaqVarZza2 = zzar.zza();
        zzaqVarZza2.zzb("models_bundled");
        zzaqVarZza2.zza(iZze == 2 ? "fssd_medium_8bit_v5.tflite" : "fssd_25_8bit_v2.tflite");
        zzaiVarZza.zzc((zzar) zzaqVarZza2.zzn());
        zzaq zzaqVarZza3 = zzar.zza();
        zzaqVarZza3.zzb("models_bundled");
        zzaqVarZza3.zza(iZze == 2 ? "fssd_medium_8bit_gray_v5.tflite" : "fssd_25_8bit_gray_v2.tflite");
        zzaiVarZza.zzb((zzar) zzaqVarZza3.zzn());
        zzaq zzaqVarZza4 = zzar.zza();
        zzaqVarZza4.zzb("models_bundled");
        zzaqVarZza4.zza(iZze == 2 ? "fssd_anchors_v5.pb" : "fssd_anchors_v2.pb");
        zzaiVarZza.zza((zzar) zzaqVarZza4.zzn());
        zzaiVarZza.zzd(zzarVar);
        zzaj zzajVar = (zzaj) zzaiVarZza.zzn();
        zzag zzagVarZza = zzah.zza();
        zzagVarZza.zzd(zzajVar);
        zzs zzsVarZza = zzt.zza();
        zzsVarZza.zza(zzarVar);
        zzsVarZza.zzb(zzarVar);
        zzagVarZza.zza(zzsVarZza);
        zzan zzanVarZza = zzao.zza();
        zzanVarZza.zzb(zzarVar);
        zzanVarZza.zzc(zzarVar);
        zzanVarZza.zzd(zzarVar);
        zzanVarZza.zza(zzarVar);
        zzagVarZza.zze(zzanVarZza);
        boolean z = false;
        boolean z2 = iZzc == 2;
        zzagVarZza.zzg(z2);
        if (!z2 && zztiVar.zzf()) {
            z = true;
        }
        zzagVarZza.zzb(z);
        zzagVarZza.zzf(zztiVar.zza());
        zzagVarZza.zzh(true);
        if (z2) {
            zzagVarZza.zzk(4);
            zzagVarZza.zzj(4);
        } else {
            int iZze2 = zztiVar.zze();
            if (iZze2 == 1) {
                zzagVarZza.zzk(2);
            } else if (iZze2 == 2) {
                zzagVarZza.zzk(3);
            }
            int iZzd = zztiVar.zzd();
            if (iZzd == 1) {
                zzagVarZza.zzj(2);
            } else if (iZzd == 2) {
                zzagVarZza.zzj(3);
            }
            int iZzb = zztiVar.zzb();
            if (iZzb == 1) {
                zzagVarZza.zzi(2);
            } else if (iZzb == 2) {
                zzagVarZza.zzi(3);
            }
        }
        this.zzb = (zzah) zzagVarZza.zzn();
        this.zzc = faceDetectorV2Jni;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List zze(com.google.android.gms.internal.mlkit_vision_face_bundled.zzaf r29) {
        /*
            Method dump skipped, instructions count: 610
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.face.bundled.internal.zza.zze(com.google.android.gms.internal.mlkit_vision_face_bundled.zzaf):java.util.List");
    }

    private static int zzf(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 4;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3) {
            return 2;
        }
        throw new IllegalArgumentException("Unsupported rotation degree: " + i);
    }

    private final List zzg(ByteBuffer byteBuffer, zzte zzteVar, int i) throws RemoteException {
        zzaf zzafVarZzb;
        zzo zzoVarZza = zzp.zza();
        zzoVarZza.zzc(zzteVar.zzd());
        zzoVarZza.zza(zzteVar.zza());
        zzoVarZza.zze(zzf(zzteVar.zzc()));
        zzoVarZza.zzd(i);
        if (zzteVar.zze() > 0) {
            zzoVarZza.zzb(zzteVar.zze() * 1000);
        }
        zzp zzpVar = (zzp) zzoVarZza.zzn();
        if (byteBuffer.isDirect()) {
            zzafVarZzb = this.zzc.zzd(this.zzd, byteBuffer, zzpVar);
        } else if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            zzafVarZzb = this.zzc.zzb(this.zzd, byteBuffer.array(), zzpVar);
        } else {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            zzafVarZzb = this.zzc.zzb(this.zzd, bArr, zzpVar);
        }
        return zzafVarZzb != null ? zze(zzafVarZzb) : new ArrayList();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zztn
    public final List zzb(IObjectWrapper iObjectWrapper, zzte zzteVar) throws RemoteException {
        zzaf zzafVarZzc;
        int iZzb = zzteVar.zzb();
        if (iZzb == -1) {
            return zzg(zzd.zza((Bitmap) ObjectWrapper.unwrap(iObjectWrapper), true), zzteVar, 2);
        }
        if (iZzb == 17) {
            return zzg((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper), zzteVar, 2);
        }
        if (iZzb != 35) {
            if (iZzb == 842094169) {
                return zzg((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper), zzteVar, 7);
            }
            String str = "Unsupported image format " + zzteVar.zzb() + " at API " + Build.VERSION.SDK_INT;
            Log.e("ThickFaceDetector", str);
            throw new RemoteException(str);
        }
        Image.Plane[] planes = ((Image) ObjectWrapper.unwrap(iObjectWrapper)).getPlanes();
        ByteBuffer buffer = planes[0].getBuffer();
        ByteBuffer buffer2 = planes[1].getBuffer();
        ByteBuffer buffer3 = planes[2].getBuffer();
        zzo zzoVarZza = zzp.zza();
        zzoVarZza.zzc(zzteVar.zzd());
        zzoVarZza.zza(zzteVar.zza());
        zzoVarZza.zze(zzf(zzteVar.zzc()));
        if (zzteVar.zze() > 0) {
            zzoVarZza.zzb(zzteVar.zze() * 1000);
        }
        zzp zzpVar = (zzp) zzoVarZza.zzn();
        if (buffer.isDirect()) {
            zzafVarZzc = this.zzc.zze(this.zzd, buffer, buffer2, buffer3, planes[0].getPixelStride(), planes[1].getPixelStride(), planes[2].getPixelStride(), planes[0].getRowStride(), planes[1].getRowStride(), planes[2].getRowStride(), zzpVar);
        } else if (buffer.hasArray() && buffer.arrayOffset() == 0) {
            zzafVarZzc = this.zzc.zzc(this.zzd, buffer.array(), buffer2.array(), buffer3.array(), planes[0].getPixelStride(), planes[1].getPixelStride(), planes[2].getPixelStride(), planes[0].getRowStride(), planes[1].getRowStride(), planes[2].getRowStride(), zzpVar);
        } else {
            byte[] bArr = new byte[buffer.remaining()];
            buffer.get(bArr);
            byte[] bArr2 = new byte[buffer2.remaining()];
            buffer.get(bArr);
            byte[] bArr3 = new byte[buffer3.remaining()];
            buffer.get(bArr);
            zzafVarZzc = this.zzc.zzc(this.zzd, bArr, bArr2, bArr3, planes[0].getPixelStride(), planes[1].getPixelStride(), planes[2].getPixelStride(), planes[0].getRowStride(), planes[1].getRowStride(), planes[2].getRowStride(), zzpVar);
        }
        return zzafVarZzc != null ? zze(zzafVarZzc) : new ArrayList();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zztn
    public final void zzc() {
        this.zzd = this.zzc.zza(this.zzb, this.zza.getAssets());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zztn
    public final void zzd() {
        long j = this.zzd;
        if (j > 0) {
            this.zzc.zzf(j);
            this.zzd = -1L;
        }
    }
}
