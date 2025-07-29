package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzpq;
import com.google.android.gms.measurement.internal.zzjj;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzgg extends zzf {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private long zzg;
    private List<String> zzh;
    private String zzi;
    private int zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private long zzn;
    private String zzo;

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzab() {
        return true;
    }

    final int zzac() {
        zzw();
        return this.zzj;
    }

    final int zzad() {
        zzw();
        return this.zzc;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zza zzc() {
        return super.zzc();
    }

    final zzp zza(String str) throws IllegalStateException {
        long jMin;
        long j;
        long j2;
        boolean z;
        boolean z2;
        String str2;
        int iZzc;
        zzv();
        String strZzaf = zzaf();
        String strZzah = zzah();
        zzw();
        String str3 = this.zzb;
        long jZzad = zzad();
        zzw();
        Preconditions.checkNotNull(this.zzd);
        String str4 = this.zzd;
        zzw();
        zzv();
        if (this.zzf == 0) {
            this.zzf = this.zzu.zzv().zza(zza(), zza().getPackageName());
        }
        long j3 = this.zzf;
        boolean zZzae = this.zzu.zzae();
        boolean z3 = !zzk().zzm;
        zzv();
        String strZzak = !this.zzu.zzae() ? null : zzak();
        zzic zzicVar = this.zzu;
        long jZza = zzicVar.zzn().zzc.zza();
        if (jZza == 0) {
            jMin = zzicVar.zza;
        } else {
            jMin = Math.min(zzicVar.zza, jZza);
        }
        long j4 = jMin;
        int iZzac = zzac();
        boolean zZzw = zze().zzw();
        zzha zzhaVarZzk = zzk();
        zzhaVarZzk.zzv();
        boolean z4 = zzhaVarZzk.zzg().getBoolean("deferred_analytics_collection", false);
        String strZzae = zzae();
        Boolean boolValueOf = Boolean.valueOf(zze().zzc("google_analytics_default_allow_ad_personalization_signals", true) != zzjm.GRANTED);
        long j5 = this.zzg;
        List<String> list = this.zzh;
        String strZzf = zzk().zzp().zzf();
        if (this.zzi == null) {
            this.zzi = zzs().zzq();
        }
        String str5 = this.zzi;
        if (zzk().zzp().zza(zzjj.zza.ANALYTICS_STORAGE)) {
            zzv();
            j = j5;
            j2 = 0;
            if (this.zzn != 0) {
                z = zZzae;
                z2 = z3;
                long jCurrentTimeMillis = zzb().currentTimeMillis() - this.zzn;
                if (this.zzm != null && jCurrentTimeMillis > 86400000 && this.zzo == null) {
                    zzaj();
                }
            } else {
                z = zZzae;
                z2 = z3;
            }
            if (this.zzm == null) {
                zzaj();
            }
            str2 = this.zzm;
        } else {
            j = j5;
            z = zZzae;
            z2 = z3;
            j2 = 0;
            str2 = null;
        }
        boolean zZzab = zze().zzab();
        long jZzc = zzs().zzc(zzaf());
        int iZza = zzk().zzp().zza();
        String strZzf2 = zzk().zzo().zzf();
        if (com.google.android.gms.internal.measurement.zzoy.zza() && zze().zza(zzbn.zzcq)) {
            zzs();
            iZzc = zzpn.zzc();
        } else {
            iZzc = 0;
        }
        return new zzp(strZzaf, strZzah, str3, jZzad, str4, 114010L, j3, str, z, z2, strZzak, j4, iZzac, zZzw, z4, strZzae, boolValueOf, j, list, (String) null, strZzf, str5, str2, zZzab, jZzc, iZza, strZzf2, iZzc, (com.google.android.gms.internal.measurement.zzoy.zza() && zze().zza(zzbn.zzcq)) ? zzs().zzm() : j2, zze().zzr(), new zzd(zze().zzc("google_analytics_default_allow_ad_personalization_signals", true)).zzb(), this.zzu.zza, zze().zza(zzbn.zzcl) ? zzo().zzac().zza() : 0);
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ zzaf zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzai zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzbf zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzgg zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzgj zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzgl zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ zzgo zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzha zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    @Pure
    public final /* bridge */ /* synthetic */ zzhv zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzju zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzlp zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzls zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzlz zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzme zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zznx zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    @Pure
    public final /* bridge */ /* synthetic */ zzpn zzs() {
        return super.zzs();
    }

    final String zzae() {
        zzw();
        return this.zzl;
    }

    final String zzaf() {
        zzw();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    final String zzag() {
        zzw();
        Preconditions.checkNotNull(this.zze);
        return this.zze;
    }

    private final String zzak() throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (zzpq.zza() && zze().zza(zzbn.zzcb)) {
            zzj().zzq().zza("Disabled IID for tests.");
            return null;
        }
        try {
            Class<?> clsLoadClass = zza().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (clsLoadClass == null) {
                return null;
            }
            try {
                Object objInvoke = clsLoadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, zza());
                if (objInvoke == null) {
                    return null;
                }
                try {
                    return (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(objInvoke, new Object[0]);
                } catch (Exception unused) {
                    zzj().zzw().zza("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception unused2) {
                zzj().zzx().zza("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
        }
    }

    final String zzah() {
        zzv();
        zzw();
        Preconditions.checkNotNull(this.zzk);
        return this.zzk;
    }

    final List<String> zzai() {
        return this.zzh;
    }

    zzgg(zzic zzicVar, long j) {
        super(zzicVar);
        this.zzn = 0L;
        this.zzo = null;
        this.zzg = j;
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzu() {
        super.zzu();
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzv() {
        super.zzv();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:0|2|(1:4)(22:85|6|(1:10)(2:11|(1:13))|83|14|(4:16|(1:18)(1:20)|87|21)|26|(1:31)(1:30)|32|33|(1:46)|47|(1:49)|89|50|(1:52)(1:53)|54|(1:56)|(3:58|(1:60)(1:61)|62)|66|(1:77)(2:68|(1:70)(4:71|(3:74|(1:92)(1:93)|72)|91|77))|(2:79|80)(2:81|82))|5|26|(2:28|31)(0)|32|33|(0)|47|(0)|89|50|(0)(0)|54|(0)|(0)|66|(0)(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01ca, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01cb, code lost:
    
        zzj().zzg().zza("Fetching Google App Id failed with exception. appId", com.google.android.gms.measurement.internal.zzgo.zza(r0), r2);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0194 A[Catch: IllegalStateException -> 0x01ca, TryCatch #3 {IllegalStateException -> 0x01ca, blocks: (B:50:0x016f, B:54:0x018c, B:56:0x0194, B:58:0x01ad, B:60:0x01c1, B:62:0x01c6, B:61:0x01c4), top: B:89:0x016f }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01ad A[Catch: IllegalStateException -> 0x01ca, TryCatch #3 {IllegalStateException -> 0x01ca, blocks: (B:50:0x016f, B:54:0x018c, B:56:0x0194, B:58:0x01ad, B:60:0x01c1, B:62:0x01c6, B:61:0x01c4), top: B:89:0x016f }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x022b  */
    @Override // com.google.android.gms.measurement.internal.zzf
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void zzz() throws java.lang.IllegalStateException, android.content.res.Resources.NotFoundException, android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 580
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgg.zzz():void");
    }

    final void zzaj() {
        String str;
        zzv();
        if (!zzk().zzp().zza(zzjj.zza.ANALYTICS_STORAGE)) {
            zzj().zzc().zza("Analytics Storage consent is not granted");
            str = null;
        } else {
            byte[] bArr = new byte[16];
            zzs().zzw().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        }
        zzj().zzc().zza(String.format("Resetting session stitching token to %s", str == null ? "null" : "not null"));
        this.zzm = str;
        this.zzn = zzb().currentTimeMillis();
    }

    final boolean zzb(String str) {
        String str2 = this.zzo;
        boolean z = (str2 == null || str2.equals(str)) ? false : true;
        this.zzo = str;
        return z;
    }
}
