package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import java.util.List;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzfw {

    /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
    public static final class zza extends zzkg<zza, C0093zza> implements zzlo {
        private static final zza zzc;
        private static volatile zzlz<zza> zzd;
        private int zze;
        private int zzf;
        private zzkm<zze> zzg = zzcl();
        private zzkm<zzb> zzh = zzcl();
        private boolean zzi;
        private boolean zzj;

        /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
        /* renamed from: com.google.android.gms.internal.measurement.zzfw$zza$zza, reason: collision with other inner class name */
        public static final class C0093zza extends zzkg.zza<zza, C0093zza> implements zzlo {
            public final int zza() {
                return ((zza) this.zza).zzb();
            }

            public final int zzb() {
                return ((zza) this.zza).zzc();
            }

            public final C0093zza zza(int i, zzb.zza zzaVar) {
                zzam();
                zza.zza((zza) this.zza, i, (zzb) ((zzkg) zzaVar.zzaj()));
                return this;
            }

            public final C0093zza zza(int i, zze.zza zzaVar) {
                zzam();
                zza.zza((zza) this.zza, i, (zze) ((zzkg) zzaVar.zzaj()));
                return this;
            }

            public final zzb zza(int i) {
                return ((zza) this.zza).zza(i);
            }

            public final zze zzb(int i) {
                return ((zza) this.zza).zzb(i);
            }

            private C0093zza() {
                super(zza.zzc);
            }
        }

        public final int zza() {
            return this.zzf;
        }

        public final int zzb() {
            return this.zzh.size();
        }

        public final int zzc() {
            return this.zzg.size();
        }

        public final zzb zza(int i) {
            return this.zzh.get(i);
        }

        public final zze zzb(int i) {
            return this.zzg.get(i);
        }

        @Override // com.google.android.gms.internal.measurement.zzkg
        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzfx.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0093zza();
                case 3:
                    return zza(zzc, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zze", "zzf", "zzg", zze.class, "zzh", zzb.class, "zzi", "zzj"});
                case 4:
                    return zzc;
                case 5:
                    zzlz<zza> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zza.class) {
                            zzcVar = zzd;
                            if (zzcVar == null) {
                                zzcVar = new zzkg.zzc<>(zzc);
                                zzd = zzcVar;
                            }
                        }
                    }
                    return zzcVar;
                case 6:
                    return (byte) 1;
                default:
                    throw null;
            }
        }

        public final List<zzb> zze() {
            return this.zzh;
        }

        public final List<zze> zzf() {
            return this.zzg;
        }

        static /* synthetic */ void zza(zza zzaVar, int i, zzb zzbVar) {
            zzbVar.getClass();
            zzkm<zzb> zzkmVar = zzaVar.zzh;
            if (!zzkmVar.zzc()) {
                zzaVar.zzh = zzkg.zza(zzkmVar);
            }
            zzaVar.zzh.set(i, zzbVar);
        }

        static /* synthetic */ void zza(zza zzaVar, int i, zze zzeVar) {
            zzeVar.getClass();
            zzkm<zze> zzkmVar = zzaVar.zzg;
            if (!zzkmVar.zzc()) {
                zzaVar.zzg = zzkg.zza(zzkmVar);
            }
            zzaVar.zzg.set(i, zzeVar);
        }

        static {
            zza zzaVar = new zza();
            zzc = zzaVar;
            zzkg.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        public final boolean zzg() {
            return (this.zze & 1) != 0;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
    public static final class zzb extends zzkg<zzb, zza> implements zzlo {
        private static final zzb zzc;
        private static volatile zzlz<zzb> zzd;
        private int zze;
        private int zzf;
        private String zzg = "";
        private zzkm<zzc> zzh = zzcl();
        private boolean zzi;
        private zzd zzj;
        private boolean zzk;
        private boolean zzl;
        private boolean zzm;

        /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
        public static final class zza extends zzkg.zza<zzb, zza> implements zzlo {
            public final int zza() {
                return ((zzb) this.zza).zza();
            }

            public final zza zza(String str) {
                zzam();
                zzb.zza((zzb) this.zza, str);
                return this;
            }

            public final zza zza(int i, zzc zzcVar) {
                zzam();
                zzb.zza((zzb) this.zza, i, zzcVar);
                return this;
            }

            public final zzc zza(int i) {
                return ((zzb) this.zza).zza(i);
            }

            public final String zzb() {
                return ((zzb) this.zza).zzf();
            }

            private zza() {
                super(zzb.zzc);
            }
        }

        public final int zza() {
            return this.zzh.size();
        }

        public final int zzb() {
            return this.zzf;
        }

        public static zza zzc() {
            return zzc.zzcg();
        }

        public final zzc zza(int i) {
            return this.zzh.get(i);
        }

        public final zzd zze() {
            zzd zzdVar = this.zzj;
            return zzdVar == null ? zzd.zzc() : zzdVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzkg
        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzfx.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza();
                case 3:
                    return zza(zzc, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", zzc.class, "zzi", "zzj", "zzk", "zzl", "zzm"});
                case 4:
                    return zzc;
                case 5:
                    zzlz<zzb> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzb.class) {
                            zzcVar = zzd;
                            if (zzcVar == null) {
                                zzcVar = new zzkg.zzc<>(zzc);
                                zzd = zzcVar;
                            }
                        }
                    }
                    return zzcVar;
                case 6:
                    return (byte) 1;
                default:
                    throw null;
            }
        }

        public final String zzf() {
            return this.zzg;
        }

        public final List<zzc> zzg() {
            return this.zzh;
        }

        static /* synthetic */ void zza(zzb zzbVar, String str) {
            str.getClass();
            zzbVar.zze |= 2;
            zzbVar.zzg = str;
        }

        static /* synthetic */ void zza(zzb zzbVar, int i, zzc zzcVar) {
            zzcVar.getClass();
            zzkm<zzc> zzkmVar = zzbVar.zzh;
            if (!zzkmVar.zzc()) {
                zzbVar.zzh = zzkg.zza(zzkmVar);
            }
            zzbVar.zzh.set(i, zzcVar);
        }

        static {
            zzb zzbVar = new zzb();
            zzc = zzbVar;
            zzkg.zza((Class<zzb>) zzb.class, zzbVar);
        }

        private zzb() {
        }

        public final boolean zzh() {
            return this.zzk;
        }

        public final boolean zzi() {
            return this.zzl;
        }

        public final boolean zzj() {
            return this.zzm;
        }

        public final boolean zzk() {
            return (this.zze & 8) != 0;
        }

        public final boolean zzl() {
            return (this.zze & 1) != 0;
        }

        public final boolean zzm() {
            return (this.zze & 64) != 0;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
    public static final class zzc extends zzkg<zzc, zza> implements zzlo {
        private static final zzc zzc;
        private static volatile zzlz<zzc> zzd;
        private int zze;
        private zzf zzf;
        private zzd zzg;
        private boolean zzh;
        private String zzi = "";

        public static zzc zzb() {
            return zzc;
        }

        public final zzd zzc() {
            zzd zzdVar = this.zzg;
            return zzdVar == null ? zzd.zzc() : zzdVar;
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
        public static final class zza extends zzkg.zza<zzc, zza> implements zzlo {
            public final zza zza(String str) {
                zzam();
                zzc.zza((zzc) this.zza, str);
                return this;
            }

            private zza() {
                super(zzc.zzc);
            }
        }

        public final zzf zzd() {
            zzf zzfVar = this.zzf;
            return zzfVar == null ? zzf.zzd() : zzfVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzkg
        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzfx.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza();
                case 3:
                    return zza(zzc, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzc;
                case 5:
                    zzlz<zzc> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzc.class) {
                            zzcVar = zzd;
                            if (zzcVar == null) {
                                zzcVar = new zzkg.zzc<>(zzc);
                                zzd = zzcVar;
                            }
                        }
                    }
                    return zzcVar;
                case 6:
                    return (byte) 1;
                default:
                    throw null;
            }
        }

        public final String zze() {
            return this.zzi;
        }

        static /* synthetic */ void zza(zzc zzcVar, String str) {
            str.getClass();
            zzcVar.zze |= 8;
            zzcVar.zzi = str;
        }

        static {
            zzc zzcVar = new zzc();
            zzc = zzcVar;
            zzkg.zza((Class<zzc>) zzc.class, zzcVar);
        }

        private zzc() {
        }

        public final boolean zzf() {
            return this.zzh;
        }

        public final boolean zzg() {
            return (this.zze & 4) != 0;
        }

        public final boolean zzh() {
            return (this.zze & 2) != 0;
        }

        public final boolean zzi() {
            return (this.zze & 8) != 0;
        }

        public final boolean zzj() {
            return (this.zze & 1) != 0;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
    public static final class zze extends zzkg<zze, zza> implements zzlo {
        private static final zze zzc;
        private static volatile zzlz<zze> zzd;
        private int zze;
        private int zzf;
        private String zzg = "";
        private zzc zzh;
        private boolean zzi;
        private boolean zzj;
        private boolean zzk;

        public final int zza() {
            return this.zzf;
        }

        public final zzc zzb() {
            zzc zzcVar = this.zzh;
            return zzcVar == null ? zzc.zzb() : zzcVar;
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
        public static final class zza extends zzkg.zza<zze, zza> implements zzlo {
            public final zza zza(String str) {
                zzam();
                zze.zza((zze) this.zza, str);
                return this;
            }

            private zza() {
                super(zze.zzc);
            }
        }

        public static zza zzc() {
            return zzc.zzcg();
        }

        @Override // com.google.android.gms.internal.measurement.zzkg
        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzfx.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza();
                case 3:
                    return zza(zzc, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
                case 4:
                    return zzc;
                case 5:
                    zzlz<zze> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zze.class) {
                            zzcVar = zzd;
                            if (zzcVar == null) {
                                zzcVar = new zzkg.zzc<>(zzc);
                                zzd = zzcVar;
                            }
                        }
                    }
                    return zzcVar;
                case 6:
                    return (byte) 1;
                default:
                    throw null;
            }
        }

        public final String zze() {
            return this.zzg;
        }

        static /* synthetic */ void zza(zze zzeVar, String str) {
            str.getClass();
            zzeVar.zze |= 2;
            zzeVar.zzg = str;
        }

        static {
            zze zzeVar = new zze();
            zzc = zzeVar;
            zzkg.zza((Class<zze>) zze.class, zzeVar);
        }

        private zze() {
        }

        public final boolean zzf() {
            return this.zzi;
        }

        public final boolean zzg() {
            return this.zzj;
        }

        public final boolean zzh() {
            return this.zzk;
        }

        public final boolean zzi() {
            return (this.zze & 1) != 0;
        }

        public final boolean zzj() {
            return (this.zze & 32) != 0;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
    public static final class zzf extends zzkg<zzf, zzb> implements zzlo {
        private static final zzf zzc;
        private static volatile zzlz<zzf> zzd;
        private int zze;
        private int zzf;
        private boolean zzh;
        private String zzg = "";
        private zzkm<String> zzi = zzkg.zzcl();

        /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
        public static final class zzb extends zzkg.zza<zzf, zzb> implements zzlo {
            private zzb() {
                super(zzf.zzc);
            }
        }

        public final int zza() {
            return this.zzi.size();
        }

        public final zza zzb() {
            zza zzaVarZza = zza.zza(this.zzf);
            return zzaVarZza == null ? zza.UNKNOWN_MATCH_TYPE : zzaVarZza;
        }

        public static zzf zzd() {
            return zzc;
        }

        @Override // com.google.android.gms.internal.measurement.zzkg
        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzfx.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zzb();
                case 3:
                    return zza(zzc, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zze", "zzf", zza.zzb(), "zzg", "zzh", "zzi"});
                case 4:
                    return zzc;
                case 5:
                    zzlz<zzf> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzf.class) {
                            zzcVar = zzd;
                            if (zzcVar == null) {
                                zzcVar = new zzkg.zzc<>(zzc);
                                zzd = zzcVar;
                            }
                        }
                    }
                    return zzcVar;
                case 6:
                    return (byte) 1;
                default:
                    throw null;
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
        public enum zza implements zzki {
            UNKNOWN_MATCH_TYPE(0),
            REGEXP(1),
            BEGINS_WITH(2),
            ENDS_WITH(3),
            PARTIAL(4),
            EXACT(5),
            IN_LIST(6);

            private final int zzi;

            @Override // com.google.android.gms.internal.measurement.zzki
            public final int zza() {
                return this.zzi;
            }

            public static zza zza(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN_MATCH_TYPE;
                    case 1:
                        return REGEXP;
                    case 2:
                        return BEGINS_WITH;
                    case 3:
                        return ENDS_WITH;
                    case 4:
                        return PARTIAL;
                    case 5:
                        return EXACT;
                    case 6:
                        return IN_LIST;
                    default:
                        return null;
                }
            }

            public static zzkl zzb() {
                return zzga.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzi);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            zza(int i) {
                this.zzi = i;
            }
        }

        public final String zze() {
            return this.zzg;
        }

        public final List<String> zzf() {
            return this.zzi;
        }

        static {
            zzf zzfVar = new zzf();
            zzc = zzfVar;
            zzkg.zza((Class<zzf>) zzf.class, zzfVar);
        }

        private zzf() {
        }

        public final boolean zzg() {
            return this.zzh;
        }

        public final boolean zzh() {
            return (this.zze & 4) != 0;
        }

        public final boolean zzi() {
            return (this.zze & 2) != 0;
        }

        public final boolean zzj() {
            return (this.zze & 1) != 0;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
    public static final class zzd extends zzkg<zzd, zzb> implements zzlo {
        private static final zzd zzc;
        private static volatile zzlz<zzd> zzd;
        private int zze;
        private int zzf;
        private boolean zzg;
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
        public static final class zzb extends zzkg.zza<zzd, zzb> implements zzlo {
            private zzb() {
                super(zzd.zzc);
            }
        }

        public final zza zza() {
            zza zzaVarZza = zza.zza(this.zzf);
            return zzaVarZza == null ? zza.UNKNOWN_COMPARISON_TYPE : zzaVarZza;
        }

        public static zzd zzc() {
            return zzc;
        }

        @Override // com.google.android.gms.internal.measurement.zzkg
        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzfx.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zzb();
                case 3:
                    return zza(zzc, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zze", "zzf", zza.zzb(), "zzg", "zzh", "zzi", "zzj"});
                case 4:
                    return zzc;
                case 5:
                    zzlz<zzd> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzd.class) {
                            zzcVar = zzd;
                            if (zzcVar == null) {
                                zzcVar = new zzkg.zzc<>(zzc);
                                zzd = zzcVar;
                            }
                        }
                    }
                    return zzcVar;
                case 6:
                    return (byte) 1;
                default:
                    throw null;
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
        public enum zza implements zzki {
            UNKNOWN_COMPARISON_TYPE(0),
            LESS_THAN(1),
            GREATER_THAN(2),
            EQUAL(3),
            BETWEEN(4);

            private final int zzg;

            @Override // com.google.android.gms.internal.measurement.zzki
            public final int zza() {
                return this.zzg;
            }

            public static zza zza(int i) {
                if (i == 0) {
                    return UNKNOWN_COMPARISON_TYPE;
                }
                if (i == 1) {
                    return LESS_THAN;
                }
                if (i == 2) {
                    return GREATER_THAN;
                }
                if (i == 3) {
                    return EQUAL;
                }
                if (i != 4) {
                    return null;
                }
                return BETWEEN;
            }

            public static zzkl zzb() {
                return zzfy.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzg);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            zza(int i) {
                this.zzg = i;
            }
        }

        public final String zzd() {
            return this.zzh;
        }

        public final String zze() {
            return this.zzj;
        }

        public final String zzf() {
            return this.zzi;
        }

        static {
            zzd zzdVar = new zzd();
            zzc = zzdVar;
            zzkg.zza((Class<zzd>) zzd.class, zzdVar);
        }

        private zzd() {
        }

        public final boolean zzg() {
            return this.zzg;
        }

        public final boolean zzh() {
            return (this.zze & 1) != 0;
        }

        public final boolean zzi() {
            return (this.zze & 4) != 0;
        }

        public final boolean zzj() {
            return (this.zze & 2) != 0;
        }

        public final boolean zzk() {
            return (this.zze & 16) != 0;
        }

        public final boolean zzl() {
            return (this.zze & 8) != 0;
        }
    }
}
