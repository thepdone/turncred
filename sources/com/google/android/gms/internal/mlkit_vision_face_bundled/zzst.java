package com.google.android.gms.internal.mlkit_vision_face_bundled;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzst {
    private static zzbj zza;
    private static final zzbl zzb = zzbl.zzc("optional-module-barcode", OptionalModuleUtils.BARCODE_MODULE_ID);
    private final String zzc;
    private final String zzd;
    private final zzsm zze;
    private final SharedPrefManager zzf;
    private final Task zzg;
    private final Task zzh;
    private final String zzi;
    private final int zzj;
    private final Map zzk = new HashMap();
    private final Map zzl = new HashMap();

    public zzst(Context context, final SharedPrefManager sharedPrefManager, zzsm zzsmVar, String str) {
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zzsmVar;
        zztc.zza();
        this.zzi = str;
        this.zzg = MLTaskExecutor.getInstance().scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_face_bundled.zzsr
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zza();
            }
        });
        MLTaskExecutor mLTaskExecutor = MLTaskExecutor.getInstance();
        Objects.requireNonNull(sharedPrefManager);
        this.zzh = mLTaskExecutor.scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_face_bundled.zzss
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return sharedPrefManager.getMlSdkInstanceId();
            }
        });
        zzbl zzblVar = zzb;
        this.zzj = zzblVar.containsKey(str) ? DynamiteModule.getRemoteVersion(context, (String) zzblVar.get(str)) : -1;
    }

    private static synchronized zzbj zzd() {
        zzbj zzbjVar = zza;
        if (zzbjVar != null) {
            return zzbjVar;
        }
        LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
        zzbg zzbgVar = new zzbg();
        for (int i = 0; i < locales.size(); i++) {
            zzbgVar.zza(CommonUtils.languageTagFromLocale(locales.get(i)));
        }
        zzbj zzbjVarZzb = zzbgVar.zzb();
        zza = zzbjVarZzb;
        return zzbjVarZzb;
    }

    final /* synthetic */ String zza() throws Exception {
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    final /* synthetic */ void zzb(zzsl zzslVar, zznw zznwVar, String str) {
        zzslVar.zzb(zznwVar);
        String strZzd = zzslVar.zzd();
        zzrl zzrlVar = new zzrl();
        zzrlVar.zzb(this.zzc);
        zzrlVar.zzc(this.zzd);
        zzrlVar.zzh(zzd());
        zzrlVar.zzg(true);
        zzrlVar.zzl(strZzd);
        zzrlVar.zzj(str);
        zzrlVar.zzi(this.zzh.isSuccessful() ? (String) this.zzh.getResult() : this.zzf.getMlSdkInstanceId());
        zzrlVar.zzd(10);
        zzrlVar.zzk(Integer.valueOf(this.zzj));
        zzslVar.zzc(zzrlVar);
        this.zze.zza(zzslVar);
    }

    public final void zzc(com.google.android.gms.vision.face.mlkit.zzc zzcVar, final zznw zznwVar) throws Throwable {
        final String version;
        Map map = this.zzk;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (map.get(zznwVar) != null && jElapsedRealtime - ((Long) this.zzk.get(zznwVar)).longValue() <= TimeUnit.SECONDS.toMillis(30L)) {
            return;
        }
        this.zzk.put(zznwVar, Long.valueOf(jElapsedRealtime));
        zznu zznuVar = zzcVar.zza;
        zzne zzneVar = zzcVar.zzb;
        zznv zznvVar = zzcVar.zzc;
        int i = zzcVar.zzd;
        zznx zznxVar = new zznx();
        zznxVar.zzd(zznuVar);
        zzmv zzmvVar = new zzmv();
        zzmvVar.zzb(zzneVar);
        zzmvVar.zza(zznvVar);
        zznxVar.zzf(zzmvVar.zzc());
        final zzsl zzslVarZzf = zzsw.zzf(zznxVar, i);
        if (this.zzg.isSuccessful()) {
            version = (String) this.zzg.getResult();
        } else {
            version = LibraryVersion.getInstance().getVersion(this.zzi);
        }
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_vision_face_bundled.zzsq
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzb(zzslVarZzf, zznwVar, version);
            }
        });
    }
}
