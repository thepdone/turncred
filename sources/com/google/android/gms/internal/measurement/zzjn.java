package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
public abstract class zzjn extends zziv {
    private static final Logger zzb = Logger.getLogger(zzjn.class.getName());
    private static final boolean zzc = zzmz.zzc();
    zzjp zza;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
    private static class zzb extends zzjn {
        private final byte[] zzb;
        private final int zzc;
        private int zzd;

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final int zza() {
            return this.zzc - this.zzd;
        }

        zzb(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if (((bArr.length - i2) | i2) < 0) {
                throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
            }
            this.zzb = bArr;
            this.zzd = 0;
            this.zzc = i2;
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zza(byte b) throws IOException {
            int i;
            int i2 = this.zzd;
            try {
                i = i2 + 1;
            } catch (IndexOutOfBoundsException e) {
                e = e;
            }
            try {
                this.zzb[i2] = b;
                this.zzd = i;
            } catch (IndexOutOfBoundsException e2) {
                e = e2;
                i2 = i;
                throw new zza(i2, this.zzc, 1, (Throwable) e);
            }
        }

        private final void zzc(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.zzb, this.zzd, i2);
                this.zzd += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(this.zzd, this.zzc, i2, (Throwable) e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzb(int i, boolean z) throws IOException {
            zzj(i, 0);
            zza(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzb(byte[] bArr, int i, int i2) throws IOException {
            zzk(i2);
            zzc(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzc(int i, zziy zziyVar) throws IOException {
            zzj(i, 2);
            zzb(zziyVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzb(zziy zziyVar) throws IOException {
            zzk(zziyVar.zzb());
            zziyVar.zza(this);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzg(int i, int i2) throws IOException {
            zzj(i, 5);
            zzh(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzh(int i) throws IOException {
            int i2 = this.zzd;
            try {
                byte[] bArr = this.zzb;
                bArr[i2] = (byte) i;
                bArr[i2 + 1] = (byte) (i >> 8);
                bArr[i2 + 2] = (byte) (i >> 16);
                bArr[i2 + 3] = i >> Ascii.CAN;
                this.zzd = i2 + 4;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(i2, this.zzc, 4, (Throwable) e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzf(int i, long j) throws IOException {
            zzj(i, 1);
            zzf(j);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzf(long j) throws IOException {
            int i = this.zzd;
            try {
                byte[] bArr = this.zzb;
                bArr[i] = (byte) j;
                bArr[i + 1] = (byte) (j >> 8);
                bArr[i + 2] = (byte) (j >> 16);
                bArr[i + 3] = (byte) (j >> 24);
                bArr[i + 4] = (byte) (j >> 32);
                bArr[i + 5] = (byte) (j >> 40);
                bArr[i + 6] = (byte) (j >> 48);
                bArr[i + 7] = (byte) (j >> 56);
                this.zzd = i + 8;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(i, this.zzc, 8, (Throwable) e);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzh(int i, int i2) throws IOException {
            zzj(i, 0);
            zzi(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzi(int i) throws IOException {
            if (i >= 0) {
                zzk(i);
            } else {
                zzh(i);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zziv
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            zzc(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        final void zzc(int i, zzlm zzlmVar, zzme zzmeVar) throws IOException {
            zzj(i, 2);
            zzk(((zzio) zzlmVar).zza(zzmeVar));
            zzmeVar.zza((zzme) zzlmVar, (zznl) this.zza);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzc(zzlm zzlmVar) throws IOException {
            zzk(zzlmVar.zzcf());
            zzlmVar.zza(this);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzb(int i, zzlm zzlmVar) throws IOException {
            zzj(1, 3);
            zzk(2, i);
            zzj(3, 2);
            zzc(zzlmVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzd(int i, zziy zziyVar) throws IOException {
            zzj(1, 3);
            zzk(2, i);
            zzc(3, zziyVar);
            zzj(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzb(int i, String str) throws IOException {
            zzj(i, 2);
            zzb(str);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzb(String str) throws IOException {
            int i = this.zzd;
            try {
                int iZzg = zzg(str.length() * 3);
                int iZzg2 = zzg(str.length());
                if (iZzg2 == iZzg) {
                    int i2 = i + iZzg2;
                    this.zzd = i2;
                    int iZza = zzna.zza(str, this.zzb, i2, zza());
                    this.zzd = i;
                    zzk((iZza - i) - iZzg2);
                    this.zzd = iZza;
                    return;
                }
                zzk(zzna.zza(str));
                this.zzd = zzna.zza(str, this.zzb, this.zzd, zza());
            } catch (zznd e) {
                this.zzd = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzj(int i, int i2) throws IOException {
            zzk((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzk(int i, int i2) throws IOException {
            zzj(i, 0);
            zzk(i2);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzk(int i) throws IOException {
            int i2;
            int i3 = this.zzd;
            while ((i & (-128)) != 0) {
                try {
                    i2 = i3 + 1;
                    try {
                        this.zzb[i3] = (byte) (i | 128);
                        i >>>= 7;
                        i3 = i2;
                    } catch (IndexOutOfBoundsException e) {
                        e = e;
                        i3 = i2;
                        throw new zza(i3, this.zzc, 1, (Throwable) e);
                    }
                } catch (IndexOutOfBoundsException e2) {
                    e = e2;
                    throw new zza(i3, this.zzc, 1, (Throwable) e);
                }
            }
            i2 = i3 + 1;
            this.zzb[i3] = (byte) i;
            this.zzd = i2;
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzh(int i, long j) throws IOException {
            zzj(i, 0);
            zzh(j);
        }

        @Override // com.google.android.gms.internal.measurement.zzjn
        public final void zzh(long j) throws IOException {
            int i;
            int i2 = this.zzd;
            if (zzjn.zzc && zza() >= 10) {
                while ((j & (-128)) != 0) {
                    zzmz.zza(this.zzb, i2, (byte) (((int) j) | 128));
                    j >>>= 7;
                    i2++;
                }
                i = i2 + 1;
                zzmz.zza(this.zzb, i2, (byte) j);
            } else {
                while ((j & (-128)) != 0) {
                    try {
                        int i3 = i2 + 1;
                        try {
                            this.zzb[i2] = (byte) (((int) j) | 128);
                            j >>>= 7;
                            i2 = i3;
                        } catch (IndexOutOfBoundsException e) {
                            e = e;
                            i2 = i3;
                            throw new zza(i2, this.zzc, 1, (Throwable) e);
                        }
                    } catch (IndexOutOfBoundsException e2) {
                        e = e2;
                    }
                }
                i = i2 + 1;
                try {
                    this.zzb[i2] = (byte) j;
                } catch (IndexOutOfBoundsException e3) {
                    e = e3;
                    i2 = i;
                    throw new zza(i2, this.zzc, 1, (Throwable) e);
                }
            }
            this.zzd = i;
        }
    }

    public static int zza(double d) {
        return 8;
    }

    public static int zza(float f) {
        return 4;
    }

    public static int zza(long j) {
        return 8;
    }

    public static int zza(boolean z) {
        return 1;
    }

    public static int zzb(int i) {
        return 4;
    }

    public static int zzc(long j) {
        return 8;
    }

    public static int zzd(int i) {
        return 4;
    }

    private static long zzi(long j) {
        return (j >> 63) ^ (j << 1);
    }

    private static int zzl(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract int zza();

    public abstract void zza(byte b) throws IOException;

    public abstract void zzb(int i, zzlm zzlmVar) throws IOException;

    public abstract void zzb(int i, String str) throws IOException;

    public abstract void zzb(int i, boolean z) throws IOException;

    public abstract void zzb(zziy zziyVar) throws IOException;

    public abstract void zzb(String str) throws IOException;

    abstract void zzb(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzc(int i, zziy zziyVar) throws IOException;

    abstract void zzc(int i, zzlm zzlmVar, zzme zzmeVar) throws IOException;

    public abstract void zzc(zzlm zzlmVar) throws IOException;

    public abstract void zzd(int i, zziy zziyVar) throws IOException;

    public abstract void zzf(int i, long j) throws IOException;

    public abstract void zzf(long j) throws IOException;

    public abstract void zzg(int i, int i2) throws IOException;

    public abstract void zzh(int i) throws IOException;

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzh(int i, long j) throws IOException;

    public abstract void zzh(long j) throws IOException;

    public abstract void zzi(int i) throws IOException;

    public abstract void zzj(int i, int i2) throws IOException;

    public abstract void zzk(int i) throws IOException;

    public abstract void zzk(int i, int i2) throws IOException;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
    public static class zza extends IOException {
        zza() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zza(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        private zza(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }

        zza(int i, int i2, int i3, Throwable th) {
            this(i, i2, i3, th);
        }

        private zza(long j, long j2, int i, Throwable th) {
            this(String.format(Locale.US, "Pos: %d, limit: %d, len: %d", Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)), th);
        }
    }

    public static int zza(int i, boolean z) {
        return zzg(i << 3) + 1;
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        return zzg(length) + length;
    }

    public static int zza(int i, zziy zziyVar) {
        int iZzg = zzg(i << 3);
        int iZzb = zziyVar.zzb();
        return iZzg + zzg(iZzb) + iZzb;
    }

    public static int zza(zziy zziyVar) {
        int iZzb = zziyVar.zzb();
        return zzg(iZzb) + iZzb;
    }

    public static int zza(int i, double d) {
        return zzg(i << 3) + 8;
    }

    public static int zza(int i, int i2) {
        return zzg(i << 3) + zze(i2);
    }

    public static int zza(int i) {
        return zze(i);
    }

    public static int zzb(int i, int i2) {
        return zzg(i << 3) + 4;
    }

    public static int zza(int i, long j) {
        return zzg(i << 3) + 8;
    }

    public static int zza(int i, float f) {
        return zzg(i << 3) + 4;
    }

    @Deprecated
    static int zza(int i, zzlm zzlmVar, zzme zzmeVar) {
        return (zzg(i << 3) << 1) + ((zzio) zzlmVar).zza(zzmeVar);
    }

    @Deprecated
    public static int zza(zzlm zzlmVar) {
        return zzlmVar.zzcf();
    }

    public static int zzc(int i, int i2) {
        return zzg(i << 3) + zze(i2);
    }

    public static int zzc(int i) {
        return zze(i);
    }

    public static int zzb(int i, long j) {
        return zzg(i << 3) + zze(j);
    }

    public static int zzb(long j) {
        return zze(j);
    }

    public static int zza(int i, zzku zzkuVar) {
        return (zzg(8) << 1) + zzf(2, i) + zzb(3, zzkuVar);
    }

    public static int zzb(int i, zzku zzkuVar) {
        int iZzg = zzg(i << 3);
        int iZza = zzkuVar.zza();
        return iZzg + zzg(iZza) + iZza;
    }

    public static int zza(zzku zzkuVar) {
        int iZza = zzkuVar.zza();
        return zzg(iZza) + iZza;
    }

    public static int zza(int i, zzlm zzlmVar) {
        return (zzg(8) << 1) + zzf(2, i) + zzg(24) + zzb(zzlmVar);
    }

    static int zzb(int i, zzlm zzlmVar, zzme zzmeVar) {
        return zzg(i << 3) + zza(zzlmVar, zzmeVar);
    }

    public static int zzb(zzlm zzlmVar) {
        int iZzcf = zzlmVar.zzcf();
        return zzg(iZzcf) + iZzcf;
    }

    static int zza(zzlm zzlmVar, zzme zzmeVar) {
        int iZza = ((zzio) zzlmVar).zza(zzmeVar);
        return zzg(iZza) + iZza;
    }

    public static int zzb(int i, zziy zziyVar) {
        return (zzg(8) << 1) + zzf(2, i) + zza(3, zziyVar);
    }

    public static int zzd(int i, int i2) {
        return zzg(i << 3) + 4;
    }

    public static int zzc(int i, long j) {
        return zzg(i << 3) + 8;
    }

    public static int zze(int i, int i2) {
        return zzg(i << 3) + zzg(zzl(i2));
    }

    public static int zze(int i) {
        return zzg(zzl(i));
    }

    public static int zzd(int i, long j) {
        return zzg(i << 3) + zze(zzi(j));
    }

    public static int zzd(long j) {
        return zze(zzi(j));
    }

    public static int zza(int i, String str) {
        return zzg(i << 3) + zza(str);
    }

    public static int zza(String str) {
        int length;
        try {
            length = zzna.zza(str);
        } catch (zznd unused) {
            length = str.getBytes(zzkj.zza).length;
        }
        return zzg(length) + length;
    }

    public static int zzf(int i) {
        return zzg(i << 3);
    }

    public static int zzf(int i, int i2) {
        return zzg(i << 3) + zzg(i2);
    }

    public static int zzg(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zze(int i, long j) {
        return zzg(i << 3) + zze(j);
    }

    public static int zze(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static zzjn zzb(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    private zzjn() {
    }

    public final void zzb() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void zza(String str, zznd zzndVar) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzndVar);
        byte[] bytes = str.getBytes(zzkj.zza);
        try {
            zzk(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zza(e);
        }
    }

    public final void zzb(boolean z) throws IOException {
        zza(z ? (byte) 1 : (byte) 0);
    }

    public final void zzb(int i, double d) throws IOException {
        zzf(i, Double.doubleToRawLongBits(d));
    }

    public final void zzb(double d) throws IOException {
        zzf(Double.doubleToRawLongBits(d));
    }

    public final void zzb(int i, float f) throws IOException {
        zzg(i, Float.floatToRawIntBits(f));
    }

    public final void zzb(float f) throws IOException {
        zzh(Float.floatToRawIntBits(f));
    }

    public final void zzi(int i, int i2) throws IOException {
        zzk(i, zzl(i2));
    }

    public final void zzj(int i) throws IOException {
        zzk(zzl(i));
    }

    public final void zzg(int i, long j) throws IOException {
        zzh(i, zzi(j));
    }

    public final void zzg(long j) throws IOException {
        zzh(zzi(j));
    }
}
