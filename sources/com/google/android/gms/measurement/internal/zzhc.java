package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.nimbusds.jose.jwk.JWKParameterNames;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.2.0 */
/* loaded from: classes3.dex */
public final class zzhc {
    private final String zza;
    private final Bundle zzb;
    private Bundle zzc;
    private final /* synthetic */ zzha zzd;

    /* JADX WARN: Removed duplicated region for block: B:35:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0120 A[Catch: NumberFormatException | JSONException -> 0x0128, NumberFormatException | JSONException -> 0x0128, TRY_LEAVE, TryCatch #1 {NumberFormatException | JSONException -> 0x0128, blocks: (B:9:0x0025, B:42:0x0091, B:42:0x0091, B:43:0x00a2, B:43:0x00a2, B:45:0x00a8, B:45:0x00a8, B:47:0x00b6, B:47:0x00b6, B:49:0x00c8, B:49:0x00c8, B:50:0x00d1, B:50:0x00d1, B:51:0x00d5, B:51:0x00d5, B:53:0x00db, B:53:0x00db, B:55:0x00e9, B:55:0x00e9, B:57:0x00fb, B:57:0x00fb, B:58:0x0104, B:58:0x0104, B:59:0x0108, B:59:0x0108, B:60:0x0114, B:60:0x0114, B:61:0x0120, B:61:0x0120, B:20:0x0052, B:23:0x005c, B:26:0x0066, B:29:0x0070, B:32:0x007a), top: B:75:0x0025, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle zza() {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhc.zza():android.os.Bundle");
    }

    private final String zzb(Bundle bundle) throws IllegalStateException, JSONException {
        JSONArray jSONArray = new JSONArray();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(JWKParameterNames.RSA_MODULUS, str);
                    if (com.google.android.gms.internal.measurement.zzoy.zza() && this.zzd.zze().zza(zzbn.zzcq)) {
                        if (obj instanceof String) {
                            jSONObject.put("v", String.valueOf(obj));
                            jSONObject.put(JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT, "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("v", String.valueOf(obj));
                            jSONObject.put(JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT, "l");
                        } else if (obj instanceof int[]) {
                            jSONObject.put("v", Arrays.toString((int[]) obj));
                            jSONObject.put(JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT, "ia");
                        } else if (obj instanceof long[]) {
                            jSONObject.put("v", Arrays.toString((long[]) obj));
                            jSONObject.put(JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT, "la");
                        } else if (obj instanceof Double) {
                            jSONObject.put("v", String.valueOf(obj));
                            jSONObject.put(JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT, "d");
                        } else {
                            this.zzd.zzj().zzg().zza("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                        }
                        jSONArray.put(jSONObject);
                    } else {
                        jSONObject.put("v", String.valueOf(obj));
                        if (obj instanceof String) {
                            jSONObject.put(JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT, "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put(JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT, "l");
                        } else if (obj instanceof Double) {
                            jSONObject.put(JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT, "d");
                        } else {
                            this.zzd.zzj().zzg().zza("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                        }
                        jSONArray.put(jSONObject);
                    }
                } catch (JSONException e) {
                    this.zzd.zzj().zzg().zza("Cannot serialize bundle value to SharedPreferences", e);
                }
            }
        }
        return jSONArray.toString();
    }

    public zzhc(zzha zzhaVar, String str, Bundle bundle) {
        this.zzd = zzhaVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = new Bundle();
    }

    public final void zza(Bundle bundle) {
        Bundle bundle2;
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = new Bundle(bundle);
        }
        SharedPreferences.Editor editorEdit = this.zzd.zzg().edit();
        if (bundle2.size() == 0) {
            editorEdit.remove(this.zza);
        } else {
            editorEdit.putString(this.zza, zzb(bundle2));
        }
        editorEdit.apply();
        this.zzc = bundle2;
    }
}
