package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
final class zzjl implements zzmf {
    private final zzjk zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final double zza() throws IOException {
        zzb(1);
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final float zzb() throws IOException {
        zzb(5);
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final int zzc() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            this.zzb = this.zza.zzi();
        }
        int i2 = this.zzb;
        if (i2 == 0 || i2 == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final int zze() throws IOException {
        zzb(0);
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final int zzf() throws IOException {
        zzb(5);
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final int zzg() throws IOException {
        zzb(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final int zzh() throws IOException {
        zzb(5);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final int zzi() throws IOException {
        zzb(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final int zzj() throws IOException {
        zzb(0);
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final long zzk() throws IOException {
        zzb(1);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final long zzl() throws IOException {
        zzb(0);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final long zzm() throws IOException {
        zzb(1);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final long zzn() throws IOException {
        zzb(0);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final long zzo() throws IOException {
        zzb(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final zziy zzp() throws IOException {
        zzb(2);
        return this.zza.zzq();
    }

    public static zzjl zza(zzjk zzjkVar) {
        if (zzjkVar.zzc != null) {
            return zzjkVar.zzc;
        }
        return new zzjl(zzjkVar);
    }

    private final Object zza(zzng zzngVar, Class<?> cls, zzjt zzjtVar) throws IOException {
        switch (zzjo.zza[zzngVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzs());
            case 2:
                return zzp();
            case 3:
                return Double.valueOf(zza());
            case 4:
                return Integer.valueOf(zze());
            case 5:
                return Integer.valueOf(zzf());
            case 6:
                return Long.valueOf(zzk());
            case 7:
                return Float.valueOf(zzb());
            case 8:
                return Integer.valueOf(zzg());
            case 9:
                return Long.valueOf(zzl());
            case 10:
                zzb(2);
                return zzb(zzma.zza().zza((Class) cls), zzjtVar);
            case 11:
                return Integer.valueOf(zzh());
            case 12:
                return Long.valueOf(zzm());
            case 13:
                return Integer.valueOf(zzi());
            case 14:
                return Long.valueOf(zzn());
            case 15:
                return zzr();
            case 16:
                return Integer.valueOf(zzj());
            case 17:
                return Long.valueOf(zzo());
            default:
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    private final <T> T zza(zzme<T> zzmeVar, zzjt zzjtVar) throws IOException {
        T tZza = zzmeVar.zza();
        zzc(tZza, zzmeVar, zzjtVar);
        zzmeVar.zzd(tZza);
        return tZza;
    }

    private final <T> T zzb(zzme<T> zzmeVar, zzjt zzjtVar) throws IOException {
        T tZza = zzmeVar.zza();
        zzd(tZza, zzmeVar, zzjtVar);
        zzmeVar.zzd(tZza);
        return tZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final String zzq() throws IOException {
        zzb(2);
        return this.zza.zzr();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final String zzr() throws IOException {
        zzb(2);
        return this.zza.zzs();
    }

    private zzjl(zzjk zzjkVar) {
        zzjk zzjkVar2 = (zzjk) zzkj.zza(zzjkVar, "input");
        this.zza = zzjkVar2;
        zzjkVar2.zzc = this;
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final <T> void zza(T t, zzme<T> zzmeVar, zzjt zzjtVar) throws IOException {
        zzb(3);
        zzc(t, zzmeVar, zzjtVar);
    }

    private final <T> void zzc(T t, zzme<T> zzmeVar, zzjt zzjtVar) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzmeVar.zza(t, this, zzjtVar);
            if (this.zzb == this.zzc) {
            } else {
                throw zzkp.zzg();
            }
        } finally {
            this.zzc = i;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final <T> void zzb(T t, zzme<T> zzmeVar, zzjt zzjtVar) throws IOException {
        zzb(2);
        zzd(t, zzmeVar, zzjtVar);
    }

    private final <T> void zzd(T t, zzme<T> zzmeVar, zzjt zzjtVar) throws IOException {
        int iZzj = this.zza.zzj();
        this.zza.zzv();
        int iZza = this.zza.zza(iZzj);
        this.zza.zza++;
        zzmeVar.zza(t, this, zzjtVar);
        this.zza.zzb(0);
        zzjk zzjkVar = this.zza;
        zzjkVar.zza--;
        this.zza.zzc(iZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final void zza(List<Boolean> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zziw) {
            zziw zziwVar = (zziw) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zziwVar.zza(this.zza.zzu());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zziwVar.zza(this.zza.zzu());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzkp.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Boolean.valueOf(this.zza.zzu()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Boolean.valueOf(this.zza.zzu()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzkp.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final void zzb(List<zziy> list) throws IOException {
        int iZzi;
        if ((this.zzb & 7) != 2) {
            throw zzkp.zza();
        }
        do {
            list.add(zzp());
            if (this.zza.zzt()) {
                return;
            } else {
                iZzi = this.zza.zzi();
            }
        } while (iZzi == this.zzb);
        this.zzd = iZzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final void zzc(List<Double> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzjs) {
            zzjs zzjsVar = (zzjs) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzjsVar.zza(this.zza.zza());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzj = this.zza.zzj();
                zzd(iZzj);
                int iZzc = this.zza.zzc() + iZzj;
                do {
                    zzjsVar.zza(this.zza.zza());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            throw zzkp.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                list.add(Double.valueOf(this.zza.zza()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzj2 = this.zza.zzj();
            zzd(iZzj2);
            int iZzc2 = this.zza.zzc() + iZzj2;
            do {
                list.add(Double.valueOf(this.zza.zza()));
            } while (this.zza.zzc() < iZzc2);
            return;
        }
        throw zzkp.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final void zzd(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzkh) {
            zzkh zzkhVar = (zzkh) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzkhVar.zzd(this.zza.zzd());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzkhVar.zzd(this.zza.zzd());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzkp.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzd()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Integer.valueOf(this.zza.zzd()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzkp.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final void zze(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzkh) {
            zzkh zzkhVar = (zzkh) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int iZzj = this.zza.zzj();
                zzc(iZzj);
                int iZzc = this.zza.zzc() + iZzj;
                do {
                    zzkhVar.zzd(this.zza.zze());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            if (i == 5) {
                do {
                    zzkhVar.zzd(this.zza.zze());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            throw zzkp.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int iZzj2 = this.zza.zzj();
            zzc(iZzj2);
            int iZzc2 = this.zza.zzc() + iZzj2;
            do {
                list.add(Integer.valueOf(this.zza.zze()));
            } while (this.zza.zzc() < iZzc2);
            return;
        }
        if (i2 == 5) {
            do {
                list.add(Integer.valueOf(this.zza.zze()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        throw zzkp.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final void zzf(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzlb) {
            zzlb zzlbVar = (zzlb) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzlbVar.zza(this.zza.zzk());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzj = this.zza.zzj();
                zzd(iZzj);
                int iZzc = this.zza.zzc() + iZzj;
                do {
                    zzlbVar.zza(this.zza.zzk());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            throw zzkp.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                list.add(Long.valueOf(this.zza.zzk()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzj2 = this.zza.zzj();
            zzd(iZzj2);
            int iZzc2 = this.zza.zzc() + iZzj2;
            do {
                list.add(Long.valueOf(this.zza.zzk()));
            } while (this.zza.zzc() < iZzc2);
            return;
        }
        throw zzkp.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final void zzg(List<Float> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzkc) {
            zzkc zzkcVar = (zzkc) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int iZzj = this.zza.zzj();
                zzc(iZzj);
                int iZzc = this.zza.zzc() + iZzj;
                do {
                    zzkcVar.zza(this.zza.zzb());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            if (i == 5) {
                do {
                    zzkcVar.zza(this.zza.zzb());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            throw zzkp.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int iZzj2 = this.zza.zzj();
            zzc(iZzj2);
            int iZzc2 = this.zza.zzc() + iZzj2;
            do {
                list.add(Float.valueOf(this.zza.zzb()));
            } while (this.zza.zzc() < iZzc2);
            return;
        }
        if (i2 == 5) {
            do {
                list.add(Float.valueOf(this.zza.zzb()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        throw zzkp.zza();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzmf
    @Deprecated
    public final <T> void zza(List<T> list, zzme<T> zzmeVar, zzjt zzjtVar) throws IOException {
        int iZzi;
        int i = this.zzb;
        if ((i & 7) != 3) {
            throw zzkp.zza();
        }
        do {
            list.add(zza(zzmeVar, zzjtVar));
            if (this.zza.zzt() || this.zzd != 0) {
                return;
            } else {
                iZzi = this.zza.zzi();
            }
        } while (iZzi == i);
        this.zzd = iZzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final void zzh(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzkh) {
            zzkh zzkhVar = (zzkh) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzkhVar.zzd(this.zza.zzf());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzkhVar.zzd(this.zza.zzf());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzkp.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzkp.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final void zzi(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzlb) {
            zzlb zzlbVar = (zzlb) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzlbVar.zza(this.zza.zzl());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzlbVar.zza(this.zza.zzl());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzkp.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.zza.zzl()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Long.valueOf(this.zza.zzl()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzkp.zza();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005b, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzmf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <K, V> void zza(java.util.Map<K, V> r8, com.google.android.gms.internal.measurement.zzlh<K, V> r9, com.google.android.gms.internal.measurement.zzjt r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.zzb(r0)
            com.google.android.gms.internal.measurement.zzjk r1 = r7.zza
            int r1 = r1.zzj()
            com.google.android.gms.internal.measurement.zzjk r2 = r7.zza
            int r1 = r2.zza(r1)
            K r2 = r9.zzb
            V r3 = r9.zzd
        L14:
            int r4 = r7.zzc()     // Catch: java.lang.Throwable -> L64
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5b
            com.google.android.gms.internal.measurement.zzjk r5 = r7.zza     // Catch: java.lang.Throwable -> L64
            boolean r5 = r5.zzt()     // Catch: java.lang.Throwable -> L64
            if (r5 != 0) goto L5b
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L46
            if (r4 == r0) goto L39
            boolean r4 = r7.zzt()     // Catch: com.google.android.gms.internal.measurement.zzko -> L4e java.lang.Throwable -> L64
            if (r4 == 0) goto L33
            goto L14
        L33:
            com.google.android.gms.internal.measurement.zzkp r4 = new com.google.android.gms.internal.measurement.zzkp     // Catch: com.google.android.gms.internal.measurement.zzko -> L4e java.lang.Throwable -> L64
            r4.<init>(r6)     // Catch: com.google.android.gms.internal.measurement.zzko -> L4e java.lang.Throwable -> L64
            throw r4     // Catch: com.google.android.gms.internal.measurement.zzko -> L4e java.lang.Throwable -> L64
        L39:
            com.google.android.gms.internal.measurement.zzng r4 = r9.zzc     // Catch: com.google.android.gms.internal.measurement.zzko -> L4e java.lang.Throwable -> L64
            V r5 = r9.zzd     // Catch: com.google.android.gms.internal.measurement.zzko -> L4e java.lang.Throwable -> L64
            java.lang.Class r5 = r5.getClass()     // Catch: com.google.android.gms.internal.measurement.zzko -> L4e java.lang.Throwable -> L64
            java.lang.Object r3 = r7.zza(r4, r5, r10)     // Catch: com.google.android.gms.internal.measurement.zzko -> L4e java.lang.Throwable -> L64
            goto L14
        L46:
            com.google.android.gms.internal.measurement.zzng r4 = r9.zza     // Catch: com.google.android.gms.internal.measurement.zzko -> L4e java.lang.Throwable -> L64
            r5 = 0
            java.lang.Object r2 = r7.zza(r4, r5, r5)     // Catch: com.google.android.gms.internal.measurement.zzko -> L4e java.lang.Throwable -> L64
            goto L14
        L4e:
            boolean r4 = r7.zzt()     // Catch: java.lang.Throwable -> L64
            if (r4 == 0) goto L55
            goto L14
        L55:
            com.google.android.gms.internal.measurement.zzkp r8 = new com.google.android.gms.internal.measurement.zzkp     // Catch: java.lang.Throwable -> L64
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L64
            throw r8     // Catch: java.lang.Throwable -> L64
        L5b:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L64
            com.google.android.gms.internal.measurement.zzjk r8 = r7.zza
            r8.zzc(r1)
            return
        L64:
            r8 = move-exception
            com.google.android.gms.internal.measurement.zzjk r9 = r7.zza
            r9.zzc(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjl.zza(java.util.Map, com.google.android.gms.internal.measurement.zzlh, com.google.android.gms.internal.measurement.zzjt):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzmf
    public final <T> void zzb(List<T> list, zzme<T> zzmeVar, zzjt zzjtVar) throws IOException {
        int iZzi;
        int i = this.zzb;
        if ((i & 7) != 2) {
            throw zzkp.zza();
        }
        do {
            list.add(zzb(zzmeVar, zzjtVar));
            if (this.zza.zzt() || this.zzd != 0) {
                return;
            } else {
                iZzi = this.zza.zzi();
            }
        } while (iZzi == i);
        this.zzd = iZzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final void zzj(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzkh) {
            zzkh zzkhVar = (zzkh) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int iZzj = this.zza.zzj();
                zzc(iZzj);
                int iZzc = this.zza.zzc() + iZzj;
                do {
                    zzkhVar.zzd(this.zza.zzg());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            if (i == 5) {
                do {
                    zzkhVar.zzd(this.zza.zzg());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            throw zzkp.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int iZzj2 = this.zza.zzj();
            zzc(iZzj2);
            int iZzc2 = this.zza.zzc() + iZzj2;
            do {
                list.add(Integer.valueOf(this.zza.zzg()));
            } while (this.zza.zzc() < iZzc2);
            return;
        }
        if (i2 == 5) {
            do {
                list.add(Integer.valueOf(this.zza.zzg()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        throw zzkp.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final void zzk(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzlb) {
            zzlb zzlbVar = (zzlb) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzlbVar.zza(this.zza.zzn());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzj = this.zza.zzj();
                zzd(iZzj);
                int iZzc = this.zza.zzc() + iZzj;
                do {
                    zzlbVar.zza(this.zza.zzn());
                } while (this.zza.zzc() < iZzc);
                return;
            }
            throw zzkp.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                list.add(Long.valueOf(this.zza.zzn()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzj2 = this.zza.zzj();
            zzd(iZzj2);
            int iZzc2 = this.zza.zzc() + iZzj2;
            do {
                list.add(Long.valueOf(this.zza.zzn()));
            } while (this.zza.zzc() < iZzc2);
            return;
        }
        throw zzkp.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final void zzl(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzkh) {
            zzkh zzkhVar = (zzkh) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzkhVar.zzd(this.zza.zzh());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzkhVar.zzd(this.zza.zzh());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzkp.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzkp.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final void zzm(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzlb) {
            zzlb zzlbVar = (zzlb) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzlbVar.zza(this.zza.zzo());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzlbVar.zza(this.zza.zzo());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzkp.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.zza.zzo()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Long.valueOf(this.zza.zzo()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzkp.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final void zzn(List<String> list) throws IOException {
        zza(list, false);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int iZzi;
        int iZzi2;
        if ((this.zzb & 7) != 2) {
            throw zzkp.zza();
        }
        if ((list instanceof zzkx) && !z) {
            zzkx zzkxVar = (zzkx) list;
            do {
                zzkxVar.zza(zzp());
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi2 = this.zza.zzi();
                }
            } while (iZzi2 == this.zzb);
            this.zzd = iZzi2;
            return;
        }
        do {
            list.add(z ? zzr() : zzq());
            if (this.zza.zzt()) {
                return;
            } else {
                iZzi = this.zza.zzi();
            }
        } while (iZzi == this.zzb);
        this.zzd = iZzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final void zzo(List<String> list) throws IOException {
        zza(list, true);
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final void zzp(List<Integer> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzkh) {
            zzkh zzkhVar = (zzkh) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzkhVar.zzd(this.zza.zzj());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzkhVar.zzd(this.zza.zzj());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzkp.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzj()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Integer.valueOf(this.zza.zzj()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzkp.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final void zzq(List<Long> list) throws IOException {
        int iZzi;
        int iZzi2;
        if (list instanceof zzlb) {
            zzlb zzlbVar = (zzlb) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzlbVar.zza(this.zza.zzp());
                    if (this.zza.zzt()) {
                        return;
                    } else {
                        iZzi2 = this.zza.zzi();
                    }
                } while (iZzi2 == this.zzb);
                this.zzd = iZzi2;
                return;
            }
            if (i == 2) {
                int iZzc = this.zza.zzc() + this.zza.zzj();
                do {
                    zzlbVar.zza(this.zza.zzp());
                } while (this.zza.zzc() < iZzc);
                zza(iZzc);
                return;
            }
            throw zzkp.zza();
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.zza.zzp()));
                if (this.zza.zzt()) {
                    return;
                } else {
                    iZzi = this.zza.zzi();
                }
            } while (iZzi == this.zzb);
            this.zzd = iZzi;
            return;
        }
        if (i2 == 2) {
            int iZzc2 = this.zza.zzc() + this.zza.zzj();
            do {
                list.add(Long.valueOf(this.zza.zzp()));
            } while (this.zza.zzc() < iZzc2);
            zza(iZzc2);
            return;
        }
        throw zzkp.zza();
    }

    private final void zza(int i) throws IOException {
        if (this.zza.zzc() != i) {
            throw zzkp.zzi();
        }
    }

    private final void zzb(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw zzkp.zza();
        }
    }

    private static void zzc(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzkp.zzg();
        }
    }

    private static void zzd(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzkp.zzg();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final boolean zzs() throws IOException {
        zzb(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    public final boolean zzt() throws IOException {
        int i;
        if (this.zza.zzt() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzd(i);
    }
}
