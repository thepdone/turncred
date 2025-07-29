package com.google.android.gms.internal.measurement;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
final class zzlr {
    private static final char[] zza;

    static String zza(zzlm zzlmVar, String str) throws SecurityException {
        StringBuilder sb = new StringBuilder();
        sb.append("# ").append(str);
        zza(zzlmVar, sb, 0);
        return sb.toString();
    }

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    private static void zza(int i, StringBuilder sb) {
        while (i > 0) {
            char[] cArr = zza;
            int length = i > cArr.length ? cArr.length : i;
            sb.append(cArr, 0, length);
            i -= length;
        }
    }

    static void zza(StringBuilder sb, int i, String str, Object obj) throws SecurityException {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zza(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zza(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zza(i, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i2 = 1; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (Character.isUpperCase(cCharAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(cCharAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"").append(zzmq.zza(zziy.zza((String) obj))).append(Typography.quote);
            return;
        }
        if (obj instanceof zziy) {
            sb.append(": \"").append(zzmq.zza((zziy) obj)).append(Typography.quote);
            return;
        }
        if (obj instanceof zzkg) {
            sb.append(" {");
            zza((zzkg) obj, sb, i + 2);
            sb.append("\n");
            zza(i, sb);
            sb.append("}");
            return;
        }
        if (obj instanceof Map.Entry) {
            sb.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            int i3 = i + 2;
            zza(sb, i3, SDKConstants.PARAM_KEY, entry.getKey());
            zza(sb, i3, "value", entry.getValue());
            sb.append("\n");
            zza(i, sb);
            sb.append("}");
            return;
        }
        sb.append(": ").append(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zza(com.google.android.gms.internal.measurement.zzlm r20, java.lang.StringBuilder r21, int r22) throws java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 593
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlr.zza(com.google.android.gms.internal.measurement.zzlm, java.lang.StringBuilder, int):void");
    }
}
