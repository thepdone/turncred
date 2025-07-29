package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:barcode-scanning@@17.3.0 */
/* loaded from: classes3.dex */
final class zzfq implements zzge {
    private final zzfm zza;
    private final zzgs zzb;
    private final boolean zzc;
    private final zzdt zzd;

    private zzfq(zzgs zzgsVar, zzdt zzdtVar, zzfm zzfmVar) {
        this.zzb = zzgsVar;
        this.zzc = zzfmVar instanceof zzed;
        this.zzd = zzdtVar;
        this.zza = zzfmVar;
    }

    static zzfq zzc(zzgs zzgsVar, zzdt zzdtVar, zzfm zzfmVar) {
        return new zzfq(zzgsVar, zzdtVar, zzfmVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final int zza(Object obj) {
        int iZzb = ((zzeh) obj).zzc.zzb();
        return this.zzc ? iZzb + ((zzed) obj).zzb.zzb() : iZzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final int zzb(Object obj) {
        int iHashCode = ((zzeh) obj).zzc.hashCode();
        return this.zzc ? (iHashCode * 53) + ((zzed) obj).zzb.zza.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final Object zze() {
        zzfm zzfmVar = this.zza;
        return zzfmVar instanceof zzeh ? ((zzeh) zzfmVar).zzK() : zzfmVar.zzZ().zzk();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzf(Object obj) {
        this.zzb.zza(obj);
        this.zzd.zza(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzg(Object obj, Object obj2) {
        zzgg.zzp(this.zzb, obj, obj2);
        if (this.zzc) {
            zzgg.zzo(this.zzd, obj, obj2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bb A[EDGE_INSN: B:57:0x00bb->B:33:0x00bb BREAK  A[LOOP:1: B:18:0x0065->B:60:0x0065], SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzh(java.lang.Object r11, byte[] r12, int r13, int r14, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh r0 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh) r0
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgt r1 = r0.zzc
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgt r2 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgt.zzc()
            if (r1 != r2) goto L11
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgt r1 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgt.zzf()
            r0.zzc = r1
        L11:
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed r11 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed) r11
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdx r11 = r11.zzc()
            r0 = 0
            r2 = r0
        L19:
            if (r13 >= r14) goto Lc6
            int r4 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcv.zzj(r12, r13, r15)
            int r13 = r15.zza
            r3 = 11
            r5 = 2
            if (r13 == r3) goto L63
            r3 = r13 & 7
            if (r3 != r5) goto L5e
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzds r2 = r15.zzd
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfm r3 = r10.zza
            int r5 = r13 >>> 3
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzef r8 = r2.zzb(r3, r5)
            r2 = r8
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzef r2 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzef) r2
            if (r8 == 0) goto L53
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfm r13 = r8.zza
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfu r2 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfu.zza()
            java.lang.Class r13 = r13.getClass()
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge r13 = r2.zzb(r13)
            int r13 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcv.zze(r13, r12, r4, r14, r15)
            java.lang.Object r2 = r15.zzc
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzee r3 = r8.zzb
            r11.zzi(r3, r2)
            goto L5c
        L53:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcv.zzi(r2, r3, r4, r5, r6, r7)
        L5c:
            r2 = r8
            goto L19
        L5e:
            int r13 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcv.zzp(r13, r12, r4, r14, r15)
            goto L19
        L63:
            r13 = 0
            r3 = r0
        L65:
            if (r4 >= r14) goto Lbb
            int r4 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcv.zzj(r12, r4, r15)
            int r6 = r15.zza
            int r7 = r6 >>> 3
            r8 = r6 & 7
            if (r7 == r5) goto L9e
            r9 = 3
            if (r7 == r9) goto L77
            goto Lb2
        L77:
            if (r2 == 0) goto L93
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfm r6 = r2.zza
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfu r7 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfu.zza()
            java.lang.Class r6 = r6.getClass()
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge r6 = r7.zzb(r6)
            int r4 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcv.zze(r6, r12, r4, r14, r15)
            java.lang.Object r6 = r15.zzc
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzee r7 = r2.zzb
            r11.zzi(r7, r6)
            goto L65
        L93:
            if (r8 != r5) goto Lb2
            int r4 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcv.zza(r12, r4, r15)
            java.lang.Object r3 = r15.zzc
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf r3 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf) r3
            goto L65
        L9e:
            if (r8 != 0) goto Lb2
            int r4 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcv.zzj(r12, r4, r15)
            int r13 = r15.zza
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzds r2 = r15.zzd
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfm r6 = r10.zza
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzef r2 = r2.zzb(r6, r13)
            r6 = r2
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzef r6 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzef) r6
            goto L65
        Lb2:
            r7 = 12
            if (r6 == r7) goto Lbb
            int r4 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcv.zzp(r6, r12, r4, r14, r15)
            goto L65
        Lbb:
            if (r3 == 0) goto Lc3
            int r13 = r13 << 3
            r13 = r13 | r5
            r1.zzj(r13, r3)
        Lc3:
            r13 = r4
            goto L19
        Lc6:
            if (r13 != r14) goto Lc9
            return
        Lc9:
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer r11 = new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer
            java.lang.String r12 = "Failed to parse the message."
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfq.zzh(java.lang.Object, byte[], int, int, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu):void");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzi(Object obj, zzhh zzhhVar) throws IOException {
        Iterator itZzf = ((zzed) obj).zzb.zzf();
        while (itZzf.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzf.next();
            zzdw zzdwVar = (zzdw) entry.getKey();
            if (zzdwVar.zze() != zzhg.MESSAGE) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zzdwVar.zzg();
            zzdwVar.zzf();
            if (entry instanceof zzeu) {
                zzhhVar.zzw(zzdwVar.zza(), ((zzeu) entry).zza().zzb());
            } else {
                zzhhVar.zzw(zzdwVar.zza(), entry.getValue());
            }
        }
        ((zzeh) obj).zzc.zzk(zzhhVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final boolean zzj(Object obj, Object obj2) {
        if (!((zzeh) obj).zzc.equals(((zzeh) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            return ((zzed) obj).zzb.equals(((zzed) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final boolean zzk(Object obj) {
        return ((zzed) obj).zzb.zzk();
    }
}
