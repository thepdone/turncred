package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzgr;
import com.google.android.gms.internal.measurement.zzkg;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzgc {

    /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
    public static final class zza extends zzkg<zza, C0094zza> implements zzlo {
        private static final zza zzc;
        private static volatile zzlz<zza> zzd;
        private int zze;
        private boolean zzi;
        private zzkm<zzb> zzf = zzcl();
        private zzkm<zzc> zzg = zzcl();
        private zzkm<zzf> zzh = zzcl();
        private zzkm<zzb> zzj = zzcl();

        /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
        /* renamed from: com.google.android.gms.internal.measurement.zzgc$zza$zza, reason: collision with other inner class name */
        public static final class C0094zza extends zzkg.zza<zza, C0094zza> implements zzlo {
            private C0094zza() {
                super(zza.zzc);
            }
        }

        public static zza zzb() {
            return zzc;
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
        public static final class zzb extends zzkg<zzb, C0095zza> implements zzlo {
            private static final zzb zzc;
            private static volatile zzlz<zzb> zzd;
            private int zze;
            private int zzf;
            private int zzg;

            /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
            /* renamed from: com.google.android.gms.internal.measurement.zzgc$zza$zzb$zza, reason: collision with other inner class name */
            public static final class C0095zza extends zzkg.zza<zzb, C0095zza> implements zzlo {
                private C0095zza() {
                    super(zzb.zzc);
                }
            }

            public final zzd zzb() {
                zzd zzdVarZza = zzd.zza(this.zzg);
                return zzdVarZza == null ? zzd.CONSENT_STATUS_UNSPECIFIED : zzdVarZza;
            }

            public final zze zzc() {
                zze zzeVarZza = zze.zza(this.zzf);
                return zzeVarZza == null ? zze.CONSENT_TYPE_UNSPECIFIED : zzeVarZza;
            }

            @Override // com.google.android.gms.internal.measurement.zzkg
            protected final Object zza(int i, Object obj, Object obj2) {
                switch (zzgb.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C0095zza();
                    case 3:
                        return zza(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zze", "zzf", zze.zzb(), "zzg", zzd.zzb()});
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

            static {
                zzb zzbVar = new zzb();
                zzc = zzbVar;
                zzkg.zza((Class<zzb>) zzb.class, zzbVar);
            }

            private zzb() {
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
        public static final class zzc extends zzkg<zzc, C0096zza> implements zzlo {
            private static final zzc zzc;
            private static volatile zzlz<zzc> zzd;
            private int zze;
            private int zzf;
            private int zzg;

            /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
            /* renamed from: com.google.android.gms.internal.measurement.zzgc$zza$zzc$zza, reason: collision with other inner class name */
            public static final class C0096zza extends zzkg.zza<zzc, C0096zza> implements zzlo {
                private C0096zza() {
                    super(zzc.zzc);
                }
            }

            public final zze zzb() {
                zze zzeVarZza = zze.zza(this.zzg);
                return zzeVarZza == null ? zze.CONSENT_TYPE_UNSPECIFIED : zzeVarZza;
            }

            public final zze zzc() {
                zze zzeVarZza = zze.zza(this.zzf);
                return zzeVarZza == null ? zze.CONSENT_TYPE_UNSPECIFIED : zzeVarZza;
            }

            @Override // com.google.android.gms.internal.measurement.zzkg
            protected final Object zza(int i, Object obj, Object obj2) {
                switch (zzgb.zza[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new C0096zza();
                    case 3:
                        return zza(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zze", "zzf", zze.zzb(), "zzg", zze.zzb()});
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

            static {
                zzc zzcVar = new zzc();
                zzc = zzcVar;
                zzkg.zza((Class<zzc>) zzc.class, zzcVar);
            }

            private zzc() {
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzkg
        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzgb.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0094zza();
                case 3:
                    return zza(zzc, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004ဇ\u0000\u0005\u001b", new Object[]{"zze", "zzf", zzb.class, "zzg", zzc.class, "zzh", zzf.class, "zzi", "zzj", zzb.class});
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

        /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
        public enum zzd implements zzki {
            CONSENT_STATUS_UNSPECIFIED(0),
            GRANTED(1),
            DENIED(2);

            private final int zze;

            @Override // com.google.android.gms.internal.measurement.zzki
            public final int zza() {
                return this.zze;
            }

            public static zzd zza(int i) {
                if (i == 0) {
                    return CONSENT_STATUS_UNSPECIFIED;
                }
                if (i == 1) {
                    return GRANTED;
                }
                if (i != 2) {
                    return null;
                }
                return DENIED;
            }

            public static zzkl zzb() {
                return zzgd.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zze);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            zzd(int i) {
                this.zze = i;
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
        public enum zze implements zzki {
            CONSENT_TYPE_UNSPECIFIED(0),
            AD_STORAGE(1),
            ANALYTICS_STORAGE(2),
            AD_USER_DATA(3),
            AD_PERSONALIZATION(4);

            private final int zzg;

            @Override // com.google.android.gms.internal.measurement.zzki
            public final int zza() {
                return this.zzg;
            }

            public static zze zza(int i) {
                if (i == 0) {
                    return CONSENT_TYPE_UNSPECIFIED;
                }
                if (i == 1) {
                    return AD_STORAGE;
                }
                if (i == 2) {
                    return ANALYTICS_STORAGE;
                }
                if (i == 3) {
                    return AD_USER_DATA;
                }
                if (i != 4) {
                    return null;
                }
                return AD_PERSONALIZATION;
            }

            public static zzkl zzb() {
                return zzge.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzg);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            zze(int i) {
                this.zzg = i;
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
        public static final class zzf extends zzkg<zzf, C0097zza> implements zzlo {
            private static final zzf zzc;
            private static volatile zzlz<zzf> zzd;
            private int zze;
            private String zzf = "";
            private String zzg = "";

            /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
            /* renamed from: com.google.android.gms.internal.measurement.zzgc$zza$zzf$zza, reason: collision with other inner class name */
            public static final class C0097zza extends zzkg.zza<zzf, C0097zza> implements zzlo {
                private C0097zza() {
                    super(zzf.zzc);
                }
            }

            @Override // com.google.android.gms.internal.measurement.zzkg
            protected final Object zza(int i, Object obj, Object obj2) {
                switch (zzgb.zza[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new C0097zza();
                    case 3:
                        return zza(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
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

            public final String zzb() {
                return this.zzf;
            }

            static {
                zzf zzfVar = new zzf();
                zzc = zzfVar;
                zzkg.zza((Class<zzf>) zzf.class, zzfVar);
            }

            private zzf() {
            }
        }

        public final List<zzf> zzc() {
            return this.zzh;
        }

        public final List<zzb> zzd() {
            return this.zzf;
        }

        public final List<zzc> zze() {
            return this.zzg;
        }

        public final List<zzb> zzf() {
            return this.zzj;
        }

        static {
            zza zzaVar = new zza();
            zzc = zzaVar;
            zzkg.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        public final boolean zzg() {
            return this.zzi;
        }

        public final boolean zzh() {
            return (this.zze & 1) != 0;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
    public static final class zzc extends zzkg<zzc, zza> implements zzlo {
        private static final zzc zzc;
        private static volatile zzlz<zzc> zzd;
        private int zze;
        private String zzf = "";
        private boolean zzg;
        private boolean zzh;
        private int zzi;

        /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
        public static final class zza extends zzkg.zza<zzc, zza> implements zzlo {
            public final int zza() {
                return ((zzc) this.zza).zza();
            }

            public final zza zza(String str) {
                zzam();
                zzc.zza((zzc) this.zza, str);
                return this;
            }

            public final String zzb() {
                return ((zzc) this.zza).zzc();
            }

            private zza() {
                super(zzc.zzc);
            }

            public final boolean zzc() {
                return ((zzc) this.zza).zzd();
            }

            public final boolean zzd() {
                return ((zzc) this.zza).zze();
            }

            public final boolean zze() {
                return ((zzc) this.zza).zzf();
            }

            public final boolean zzf() {
                return ((zzc) this.zza).zzg();
            }

            public final boolean zzg() {
                return ((zzc) this.zza).zzh();
            }
        }

        public final int zza() {
            return this.zzi;
        }

        @Override // com.google.android.gms.internal.measurement.zzkg
        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzgb.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza();
                case 3:
                    return zza(zzc, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
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

        public final String zzc() {
            return this.zzf;
        }

        static /* synthetic */ void zza(zzc zzcVar, String str) {
            str.getClass();
            zzcVar.zze |= 1;
            zzcVar.zzf = str;
        }

        static {
            zzc zzcVar = new zzc();
            zzc = zzcVar;
            zzkg.zza((Class<zzc>) zzc.class, zzcVar);
        }

        private zzc() {
        }

        public final boolean zzd() {
            return this.zzg;
        }

        public final boolean zze() {
            return this.zzh;
        }

        public final boolean zzf() {
            return (this.zze & 2) != 0;
        }

        public final boolean zzg() {
            return (this.zze & 4) != 0;
        }

        public final boolean zzh() {
            return (this.zze & 8) != 0;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
    public static final class zzd extends zzkg<zzd, zza> implements zzlo {
        private static final zzd zzc;
        private static volatile zzlz<zzd> zzd;
        private int zze;
        private long zzf;
        private int zzh;
        private boolean zzm;
        private zza zzr;
        private zzf zzs;
        private zzi zzt;
        private zzg zzu;
        private zze zzv;
        private String zzg = "";
        private zzkm<zzh> zzi = zzcl();
        private zzkm<zzc> zzj = zzcl();
        private zzkm<zzfw.zza> zzk = zzcl();
        private String zzl = "";
        private zzkm<zzgr.zzc> zzn = zzcl();
        private zzkm<zzb> zzo = zzcl();
        private String zzp = "";
        private String zzq = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
        public static final class zza extends zzkg.zza<zzd, zza> implements zzlo {
            public final int zza() {
                return ((zzd) this.zza).zzb();
            }

            public final zzc zza(int i) {
                return ((zzd) this.zza).zza(i);
            }

            public final zza zzb() {
                zzam();
                zzd.zza((zzd) this.zza);
                return this;
            }

            public final zza zza(int i, zzc.zza zzaVar) {
                zzam();
                zzd.zza((zzd) this.zza, i, (zzc) ((zzkg) zzaVar.zzaj()));
                return this;
            }

            public final String zzc() {
                return ((zzd) this.zza).zzj();
            }

            public final List<zzfw.zza> zzd() {
                return Collections.unmodifiableList(((zzd) this.zza).zzk());
            }

            public final List<zzb> zze() {
                return Collections.unmodifiableList(((zzd) this.zza).zzl());
            }

            private zza() {
                super(zzd.zzc);
            }
        }

        public final int zza() {
            return this.zzn.size();
        }

        public final int zzb() {
            return this.zzj.size();
        }

        public final long zzc() {
            return this.zzf;
        }

        public final zza zzd() {
            zza zzaVar = this.zzr;
            return zzaVar == null ? zza.zzb() : zzaVar;
        }

        public final zzc zza(int i) {
            return this.zzj.get(i);
        }

        public static zza zze() {
            return zzc.zzcg();
        }

        public static zzd zzg() {
            return zzc;
        }

        public final zzi zzh() {
            zzi zziVar = this.zzt;
            return zziVar == null ? zzi.zzc() : zziVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzkg
        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzgb.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza();
                case 3:
                    return zza(zzc, "\u0004\u0011\u0000\u0001\u0001\u0013\u0011\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005\u000eဈ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011ဉ\t\u0012ဉ\n\u0013ဉ\u000b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzh.class, "zzj", zzc.class, "zzk", zzfw.zza.class, "zzl", "zzm", "zzn", zzgr.zzc.class, "zzo", zzb.class, "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv"});
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

        public final String zzi() {
            return this.zzg;
        }

        public final String zzj() {
            return this.zzp;
        }

        public final List<zzfw.zza> zzk() {
            return this.zzk;
        }

        public final List<zzb> zzl() {
            return this.zzo;
        }

        public final List<zzgr.zzc> zzm() {
            return this.zzn;
        }

        public final List<zzh> zzn() {
            return this.zzi;
        }

        static /* synthetic */ void zza(zzd zzdVar) {
            zzdVar.zzk = zzcl();
        }

        static /* synthetic */ void zza(zzd zzdVar, int i, zzc zzcVar) {
            zzcVar.getClass();
            zzkm<zzc> zzkmVar = zzdVar.zzj;
            if (!zzkmVar.zzc()) {
                zzdVar.zzj = zzkg.zza(zzkmVar);
            }
            zzdVar.zzj.set(i, zzcVar);
        }

        static {
            zzd zzdVar = new zzd();
            zzc = zzdVar;
            zzkg.zza((Class<zzd>) zzd.class, zzdVar);
        }

        private zzd() {
        }

        public final boolean zzo() {
            return (this.zze & 128) != 0;
        }

        public final boolean zzp() {
            return (this.zze & 2) != 0;
        }

        public final boolean zzq() {
            return (this.zze & 512) != 0;
        }

        public final boolean zzr() {
            return (this.zze & 1) != 0;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
    public static final class zzi extends zzkg<zzi, zza> implements zzlo {
        private static final zzi zzc;
        private static volatile zzlz<zzi> zzd;
        private int zze;
        private int zzi;
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzj = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
        public static final class zza extends zzkg.zza<zzi, zza> implements zzlo {
            private zza() {
                super(zzi.zzc);
            }
        }

        public final int zza() {
            return this.zzi;
        }

        public static zzi zzc() {
            return zzc;
        }

        @Override // com.google.android.gms.internal.measurement.zzkg
        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzgb.zza[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza();
                case 3:
                    return zza(zzc, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003\u0005ဈ\u0004", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
                case 4:
                    return zzc;
                case 5:
                    zzlz<zzi> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzi.class) {
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

        public final String zzd() {
            return this.zzg;
        }

        public final String zze() {
            return this.zzj;
        }

        public final String zzf() {
            return this.zzf;
        }

        static {
            zzi zziVar = new zzi();
            zzc = zziVar;
            zzkg.zza((Class<zzi>) zzi.class, zziVar);
        }

        private zzi() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
    public static final class zzb extends zzkg<zzb, zza> implements zzlo {
        private static final zzb zzc;
        private static volatile zzlz<zzb> zzd;
        private int zze;
        private String zzf = "";
        private zzkm<zzg> zzg = zzcl();
        private boolean zzh;

        /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
        public static final class zza extends zzkg.zza<zzb, zza> implements zzlo {
            private zza() {
                super(zzb.zzc);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzkg
        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzgb.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza();
                case 3:
                    return zza(zzc, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zze", "zzf", "zzg", zzg.class, "zzh"});
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

        public final String zzb() {
            return this.zzf;
        }

        static {
            zzb zzbVar = new zzb();
            zzc = zzbVar;
            zzkg.zza((Class<zzb>) zzb.class, zzbVar);
        }

        private zzb() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
    public static final class zze extends zzkg<zze, zza> implements zzlo {
        private static final zze zzc;
        private static volatile zzlz<zze> zzd;
        private zzkm<String> zze = zzkg.zzcl();

        /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
        public static final class zza extends zzkg.zza<zze, zza> implements zzlo {
            private zza() {
                super(zze.zzc);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzkg
        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzgb.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza();
                case 3:
                    return zza(zzc, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zze"});
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

        static {
            zze zzeVar = new zze();
            zzc = zzeVar;
            zzkg.zza((Class<zze>) zze.class, zzeVar);
        }

        private zze() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
    public static final class zzf extends zzkg<zzf, zza> implements zzlo {
        private static final zzf zzc;
        private static volatile zzlz<zzf> zzd;
        private int zze;
        private int zzf = 14;
        private int zzg = 11;
        private int zzh = 60;

        /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
        public static final class zza extends zzkg.zza<zzf, zza> implements zzlo {
            private zza() {
                super(zzf.zzc);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzkg
        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzgb.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza();
                case 3:
                    return zza(zzc, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
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

        static {
            zzf zzfVar = new zzf();
            zzc = zzfVar;
            zzkg.zza((Class<zzf>) zzf.class, zzfVar);
        }

        private zzf() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
    public static final class zzg extends zzkg<zzg, zza> implements zzlo {
        private static final zzg zzc;
        private static volatile zzlz<zzg> zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
        public static final class zza extends zzkg.zza<zzg, zza> implements zzlo {
            private zza() {
                super(zzg.zzc);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzkg
        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzgb.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza();
                case 3:
                    return zza(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
                case 4:
                    return zzc;
                case 5:
                    zzlz<zzg> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzg.class) {
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

        static {
            zzg zzgVar = new zzg();
            zzc = zzgVar;
            zzkg.zza((Class<zzg>) zzg.class, zzgVar);
        }

        private zzg() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
    public static final class zzh extends zzkg<zzh, zza> implements zzlo {
        private static final zzh zzc;
        private static volatile zzlz<zzh> zzd;
        private int zze;
        private String zzf = "";
        private String zzg = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
        public static final class zza extends zzkg.zza<zzh, zza> implements zzlo {
            private zza() {
                super(zzh.zzc);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzkg
        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzgb.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza();
                case 3:
                    return zza(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
                case 4:
                    return zzc;
                case 5:
                    zzlz<zzh> zzcVar = zzd;
                    if (zzcVar == null) {
                        synchronized (zzh.class) {
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

        public final String zzb() {
            return this.zzf;
        }

        public final String zzc() {
            return this.zzg;
        }

        static {
            zzh zzhVar = new zzh();
            zzc = zzhVar;
            zzkg.zza((Class<zzh>) zzh.class, zzhVar);
        }

        private zzh() {
        }
    }
}
