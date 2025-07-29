package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzuu implements zzyo {
    private final zzut zza;

    private zzuu(zzut zzutVar) {
        byte[] bArr = zzvt.zzd;
        this.zza = zzutVar;
        zzutVar.zza = this;
    }

    public static zzuu zza(zzut zzutVar) {
        zzuu zzuuVar = zzutVar.zza;
        return zzuuVar != null ? zzuuVar : new zzuu(zzutVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzB(int i, int i2) throws IOException {
        this.zza.zzp(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzD(int i, long j) throws IOException {
        this.zza.zzr(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    @Deprecated
    public final void zzF(int i) throws IOException {
        this.zza.zzo(i, 3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzG(int i, String str) throws IOException {
        this.zza.zzm(i, str);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzI(int i, int i2) throws IOException {
        this.zza.zzp(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzK(int i, long j) throws IOException {
        this.zza.zzr(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzb(int i, boolean z) throws IOException {
        this.zza.zzd(i, z);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzd(int i, zzul zzulVar) throws IOException {
        this.zza.zze(i, zzulVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zze(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zze(i, (zzul) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzf(int i, double d) throws IOException {
        this.zza.zzh(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    @Deprecated
    public final void zzh(int i) throws IOException {
        this.zza.zzo(i, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzj(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzm(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzo(int i, float f) throws IOException {
        this.zza.zzf(i, Float.floatToRawIntBits(f));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzq(int i, Object obj, zzxf zzxfVar) throws IOException {
        zzut zzutVar = this.zza;
        zzutVar.zzo(i, 3);
        zzxfVar.zzi((zzws) obj, zzutVar.zza);
        zzutVar.zzo(i, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzr(int i, int i2) throws IOException {
        this.zza.zzj(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzt(int i, long j) throws IOException {
        this.zza.zzr(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzv(int i, Object obj, zzxf zzxfVar) throws IOException {
        zzws zzwsVar = (zzws) obj;
        zzuq zzuqVar = (zzuq) this.zza;
        zzuqVar.zzq((i << 3) | 2);
        zzuqVar.zzq(((zztu) zzwsVar).zzp(zzxfVar));
        zzxfVar.zzi(zzwsVar, zzuqVar.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzw(int i, Object obj) throws IOException {
        if (obj instanceof zzul) {
            zzuq zzuqVar = (zzuq) this.zza;
            zzuqVar.zzq(11);
            zzuqVar.zzp(2, i);
            zzuqVar.zze(3, (zzul) obj);
            zzuqVar.zzq(12);
            return;
        }
        zzut zzutVar = this.zza;
        zzws zzwsVar = (zzws) obj;
        zzuq zzuqVar2 = (zzuq) zzutVar;
        zzuqVar2.zzq(11);
        zzuqVar2.zzp(2, i);
        zzuqVar2.zzq(26);
        zzuqVar2.zzq(zzwsVar.zzu());
        zzwsVar.zzL(zzutVar);
        zzuqVar2.zzq(12);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzx(int i, int i2) throws IOException {
        this.zza.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzz(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzH(int i, List list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzwa)) {
            while (i2 < list.size()) {
                this.zza.zzm(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzwa zzwaVar = (zzwa) list;
        while (i2 < list.size()) {
            Object objZzf = zzwaVar.zzf(i2);
            if (objZzf instanceof String) {
                this.zza.zzm(i, (String) objZzf);
            } else {
                this.zza.zze(i, (zzul) objZzf);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzJ(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzp(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int iZzw = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzw += zzut.zzw(((Integer) list.get(i3)).intValue());
        }
        this.zza.zzq(iZzw);
        while (i2 < list.size()) {
            this.zza.zzq(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzL(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzr(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int iZzx = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzx += zzut.zzx(((Long) list.get(i3)).longValue());
        }
        this.zza.zzq(iZzx);
        while (i2 < list.size()) {
            this.zza.zzs(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzc(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzd(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).booleanValue();
            i3++;
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzb(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzl(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzf(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).intValue();
            i3 += 4;
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzg(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzn(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).longValue();
            i3 += 8;
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzi(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzs(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzj(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int iZzx = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzx += zzut.zzx(((Integer) list.get(i3)).intValue());
        }
        this.zza.zzq(iZzx);
        while (i2 < list.size()) {
            this.zza.zzk(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzA(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).longValue();
            i3 += 8;
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzi(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzC(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zzut zzutVar = this.zza;
                int iIntValue = ((Integer) list.get(i2)).intValue();
                zzutVar.zzp(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int iZzw = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int iIntValue2 = ((Integer) list.get(i3)).intValue();
            iZzw += zzut.zzw((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
        }
        this.zza.zzq(iZzw);
        while (i2 < list.size()) {
            zzut zzutVar2 = this.zza;
            int iIntValue3 = ((Integer) list.get(i2)).intValue();
            zzutVar2.zzq((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzE(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zzut zzutVar = this.zza;
                long jLongValue = ((Long) list.get(i2)).longValue();
                zzutVar.zzr(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int iZzx = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            long jLongValue2 = ((Long) list.get(i3)).longValue();
            iZzx += zzut.zzx((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        this.zza.zzq(iZzx);
        while (i2 < list.size()) {
            zzut zzutVar2 = this.zza;
            long jLongValue3 = ((Long) list.get(i2)).longValue();
            zzutVar2.zzs((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzg(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).doubleValue();
            i3 += 8;
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzi(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzj(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzj(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int iZzx = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzx += zzut.zzx(((Integer) list.get(i3)).intValue());
        }
        this.zza.zzq(iZzx);
        while (i2 < list.size()) {
            this.zza.zzk(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzp(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzf(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).floatValue();
            i3 += 4;
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzg(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzu(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzr(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int iZzx = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzx += zzut.zzx(((Long) list.get(i3)).longValue());
        }
        this.zza.zzq(iZzx);
        while (i2 < list.size()) {
            this.zza.zzs(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyo
    public final void zzy(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzf(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzo(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).intValue();
            i3 += 4;
        }
        this.zza.zzq(i3);
        while (i2 < list.size()) {
            this.zza.zzg(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }
}
