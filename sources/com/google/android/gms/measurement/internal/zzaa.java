package com.google.android.gms.measurement.internal;

import androidx.camera.video.AudioStats;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfw;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.PatternSyntaxException;

/* compiled from: com.google.android.gms:play-services-measurement@@22.2.0 */
/* loaded from: classes3.dex */
abstract class zzaa {
    String zza;
    int zzb;
    Boolean zzc;
    Boolean zzd;
    Long zze;
    Long zzf;

    private static Boolean zza(BigDecimal bigDecimal, zzfw.zzd zzdVar, double d) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzdVar);
        if (zzdVar.zzh() && zzdVar.zza() != zzfw.zzd.zza.UNKNOWN_COMPARISON_TYPE) {
            if (zzdVar.zza() == zzfw.zzd.zza.BETWEEN) {
                if (!zzdVar.zzl() || !zzdVar.zzk()) {
                    return null;
                }
            } else if (!zzdVar.zzi()) {
                return null;
            }
            zzfw.zzd.zza zzaVarZza = zzdVar.zza();
            if (zzdVar.zza() == zzfw.zzd.zza.BETWEEN) {
                if (zzpj.zzb(zzdVar.zzf()) && zzpj.zzb(zzdVar.zze())) {
                    try {
                        BigDecimal bigDecimal5 = new BigDecimal(zzdVar.zzf());
                        bigDecimal4 = new BigDecimal(zzdVar.zze());
                        bigDecimal3 = bigDecimal5;
                        bigDecimal2 = null;
                    } catch (NumberFormatException unused) {
                    }
                }
                return null;
            }
            if (!zzpj.zzb(zzdVar.zzd())) {
                return null;
            }
            try {
                bigDecimal2 = new BigDecimal(zzdVar.zzd());
                bigDecimal3 = null;
                bigDecimal4 = null;
            } catch (NumberFormatException unused2) {
            }
            if (zzaVarZza == zzfw.zzd.zza.BETWEEN) {
                if (bigDecimal3 == null) {
                    return null;
                }
            } else if (bigDecimal2 != null) {
            }
            int i = zzw.zzb[zzaVarZza.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4 || bigDecimal3 == null) {
                            return null;
                        }
                        if (bigDecimal.compareTo(bigDecimal3) >= 0 && bigDecimal.compareTo(bigDecimal4) <= 0) {
                            z = true;
                        }
                        return Boolean.valueOf(z);
                    }
                    if (bigDecimal2 != null) {
                        if (d == AudioStats.AUDIO_AMPLITUDE_NONE) {
                            return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
                        }
                        if (bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) > 0 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d).multiply(new BigDecimal(2)))) < 0) {
                            z = true;
                        }
                        return Boolean.valueOf(z);
                    }
                } else if (bigDecimal2 != null) {
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) > 0);
                }
            } else if (bigDecimal2 != null) {
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) < 0);
            }
        }
        return null;
    }

    abstract int zza();

    abstract boolean zzb();

    abstract boolean zzc();

    static Boolean zza(String str, zzfw.zzf zzfVar, zzgo zzgoVar) {
        String strZze;
        List<String> list;
        Preconditions.checkNotNull(zzfVar);
        if (str == null || !zzfVar.zzj() || zzfVar.zzb() == zzfw.zzf.zza.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        if (zzfVar.zzb() == zzfw.zzf.zza.IN_LIST) {
            if (zzfVar.zza() == 0) {
                return null;
            }
        } else if (!zzfVar.zzi()) {
            return null;
        }
        zzfw.zzf.zza zzaVarZzb = zzfVar.zzb();
        boolean zZzg = zzfVar.zzg();
        if (zZzg || zzaVarZzb == zzfw.zzf.zza.REGEXP || zzaVarZzb == zzfw.zzf.zza.IN_LIST) {
            strZze = zzfVar.zze();
        } else {
            strZze = zzfVar.zze().toUpperCase(Locale.ENGLISH);
        }
        String str2 = strZze;
        if (zzfVar.zza() == 0) {
            list = null;
        } else {
            List<String> listZzf = zzfVar.zzf();
            if (!zZzg) {
                ArrayList arrayList = new ArrayList(listZzf.size());
                Iterator<String> it = listZzf.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().toUpperCase(Locale.ENGLISH));
                }
                listZzf = Collections.unmodifiableList(arrayList);
            }
            list = listZzf;
        }
        return zza(str, zzaVarZzb, zZzg, str2, list, zzaVarZzb == zzfw.zzf.zza.REGEXP ? str2 : null, zzgoVar);
    }

    private static Boolean zza(String str, zzfw.zzf.zza zzaVar, boolean z, String str2, List<String> list, String str3, zzgo zzgoVar) throws IllegalStateException {
        if (str == null) {
            return null;
        }
        if (zzaVar == zzfw.zzf.zza.IN_LIST) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && zzaVar != zzfw.zzf.zza.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (zzw.zza[zzaVar.ordinal()]) {
            case 1:
                if (str3 != null) {
                    try {
                        break;
                    } catch (PatternSyntaxException unused) {
                        if (zzgoVar != null) {
                            zzgoVar.zzr().zza("Invalid regular expression in REGEXP audience filter. expression", str3);
                        }
                        return null;
                    }
                }
                break;
            case 6:
                if (list != null) {
                    break;
                }
                break;
        }
        return null;
    }

    static Boolean zza(double d, zzfw.zzd zzdVar) {
        try {
            return zza(new BigDecimal(d), zzdVar, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zza(long j, zzfw.zzd zzdVar) {
        try {
            return zza(new BigDecimal(j), zzdVar, AudioStats.AUDIO_AMPLITUDE_NONE);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zza(String str, zzfw.zzd zzdVar) {
        if (!zzpj.zzb(str)) {
            return null;
        }
        try {
            return zza(new BigDecimal(str), zzdVar, AudioStats.AUDIO_AMPLITUDE_NONE);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    zzaa(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }
}
