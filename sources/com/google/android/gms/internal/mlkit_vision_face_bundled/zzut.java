package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public abstract class zzut extends zzub {
    private static final Logger zzb = Logger.getLogger(zzut.class.getName());
    private static final boolean zzc = zzyg.zzx();
    zzuu zza;

    private zzut() {
    }

    /* synthetic */ zzut(zzus zzusVar) {
    }

    @Deprecated
    static int zzt(int i, zzws zzwsVar, zzxf zzxfVar) {
        int iZzw = zzw(i << 3);
        return iZzw + iZzw + ((zztu) zzwsVar).zzp(zzxfVar);
    }

    static int zzu(zzws zzwsVar, zzxf zzxfVar) {
        int iZzp = ((zztu) zzwsVar).zzp(zzxfVar);
        return zzw(iZzp) + iZzp;
    }

    public static int zzv(String str) {
        int length;
        try {
            length = zzyl.zzc(str);
        } catch (zzyk unused) {
            length = str.getBytes(zzvt.zzb).length;
        }
        return zzw(length) + length;
    }

    public static int zzw(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zzx(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static zzut zzy(byte[] bArr, int i, int i2) {
        return new zzuq(bArr, 0, i2);
    }

    final void zzA(String str, zzyk zzykVar) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzykVar);
        byte[] bytes = str.getBytes(zzvt.zzb);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzur(e);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b) throws IOException;

    public abstract void zzd(int i, boolean z) throws IOException;

    public abstract void zze(int i, zzul zzulVar) throws IOException;

    public abstract void zzf(int i, int i2) throws IOException;

    public abstract void zzg(int i) throws IOException;

    public abstract void zzh(int i, long j) throws IOException;

    public abstract void zzi(long j) throws IOException;

    public abstract void zzj(int i, int i2) throws IOException;

    public abstract void zzk(int i) throws IOException;

    public abstract void zzl(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzm(int i, String str) throws IOException;

    public abstract void zzo(int i, int i2) throws IOException;

    public abstract void zzp(int i, int i2) throws IOException;

    public abstract void zzq(int i) throws IOException;

    public abstract void zzr(int i, long j) throws IOException;

    public abstract void zzs(long j) throws IOException;

    public final void zzz() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }
}
