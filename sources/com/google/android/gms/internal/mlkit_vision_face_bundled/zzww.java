package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzww implements zzxf {
    private final zzws zza;
    private final zzxw zzb;
    private final boolean zzc;
    private final zzuz zzd;

    private zzww(zzxw zzxwVar, zzuz zzuzVar, zzws zzwsVar) {
        this.zzb = zzxwVar;
        this.zzc = zzuzVar.zzg(zzwsVar);
        this.zzd = zzuzVar;
        this.zza = zzwsVar;
    }

    static zzww zzc(zzxw zzxwVar, zzuz zzuzVar, zzws zzwsVar) {
        return new zzww(zzxwVar, zzuzVar, zzwsVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxf
    public final int zza(Object obj) {
        zzxw zzxwVar = this.zzb;
        int iZzb = zzxwVar.zzb(zzxwVar.zzd(obj));
        return this.zzc ? iZzb + this.zzd.zzb(obj).zzb() : iZzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxf
    public final int zzb(Object obj) {
        int iHashCode = this.zzb.zzd(obj).hashCode();
        return this.zzc ? (iHashCode * 53) + this.zzd.zzb(obj).zza.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxf
    public final Object zze() {
        zzws zzwsVar = this.zza;
        return zzwsVar instanceof zzvn ? ((zzvn) zzwsVar).zzy() : zzwsVar.zzK().zzp();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxf
    public final void zzf(Object obj) {
        this.zzb.zzg(obj);
        this.zzd.zze(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxf
    public final void zzg(Object obj, Object obj2) {
        zzxh.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            zzxh.zzp(this.zzd, obj, obj2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bf A[EDGE_INSN: B:57:0x00bf->B:33:0x00bf BREAK  A[LOOP:1: B:18:0x0067->B:60:0x0067], SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzh(java.lang.Object r11, byte[] r12, int r13, int r14, com.google.android.gms.internal.mlkit_vision_face_bundled.zzty r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzvn r0 = (com.google.android.gms.internal.mlkit_vision_face_bundled.zzvn) r0
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzxx r1 = r0.zzc
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzxx r2 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzxx.zzc()
            if (r1 != r2) goto L11
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzxx r1 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzxx.zzf()
            r0.zzc = r1
        L11:
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzvj r11 = (com.google.android.gms.internal.mlkit_vision_face_bundled.zzvj) r11
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzvd r11 = r11.zzb()
            r0 = 0
            r2 = r0
        L19:
            if (r13 >= r14) goto Lca
            int r4 = com.google.android.gms.internal.mlkit_vision_face_bundled.zztz.zzi(r12, r13, r15)
            int r13 = r15.zza
            r3 = 11
            r5 = 2
            if (r13 == r3) goto L65
            r3 = r13 & 7
            if (r3 != r5) goto L60
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzuz r2 = r10.zzd
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzuy r3 = r15.zzd
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzws r5 = r10.zza
            int r6 = r13 >>> 3
            java.lang.Object r8 = r2.zzd(r3, r5, r6)
            if (r8 == 0) goto L55
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzxb r13 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzxb.zza()
            r2 = r8
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzvl r2 = (com.google.android.gms.internal.mlkit_vision_face_bundled.zzvl) r2
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzws r3 = r2.zzc
            java.lang.Class r3 = r3.getClass()
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzxf r13 = r13.zzb(r3)
            int r13 = com.google.android.gms.internal.mlkit_vision_face_bundled.zztz.zzd(r13, r12, r4, r14, r15)
            java.lang.Object r3 = r15.zzc
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzvk r2 = r2.zzd
            r11.zzj(r2, r3)
            goto L5e
        L55:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.google.android.gms.internal.mlkit_vision_face_bundled.zztz.zzh(r2, r3, r4, r5, r6, r7)
        L5e:
            r2 = r8
            goto L19
        L60:
            int r13 = com.google.android.gms.internal.mlkit_vision_face_bundled.zztz.zzo(r13, r12, r4, r14, r15)
            goto L19
        L65:
            r13 = 0
            r3 = r0
        L67:
            if (r4 >= r14) goto Lbf
            int r4 = com.google.android.gms.internal.mlkit_vision_face_bundled.zztz.zzi(r12, r4, r15)
            int r6 = r15.zza
            int r7 = r6 >>> 3
            r8 = r6 & 7
            if (r7 == r5) goto La3
            r9 = 3
            if (r7 == r9) goto L79
            goto Lb6
        L79:
            if (r2 == 0) goto L98
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzxb r6 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzxb.zza()
            r7 = r2
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzvl r7 = (com.google.android.gms.internal.mlkit_vision_face_bundled.zzvl) r7
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzws r8 = r7.zzc
            java.lang.Class r8 = r8.getClass()
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzxf r6 = r6.zzb(r8)
            int r4 = com.google.android.gms.internal.mlkit_vision_face_bundled.zztz.zzd(r6, r12, r4, r14, r15)
            java.lang.Object r6 = r15.zzc
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzvk r7 = r7.zzd
            r11.zzj(r7, r6)
            goto L67
        L98:
            if (r8 != r5) goto Lb6
            int r4 = com.google.android.gms.internal.mlkit_vision_face_bundled.zztz.zza(r12, r4, r15)
            java.lang.Object r3 = r15.zzc
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzul r3 = (com.google.android.gms.internal.mlkit_vision_face_bundled.zzul) r3
            goto L67
        La3:
            if (r8 != 0) goto Lb6
            int r4 = com.google.android.gms.internal.mlkit_vision_face_bundled.zztz.zzi(r12, r4, r15)
            int r13 = r15.zza
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzuz r2 = r10.zzd
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzuy r6 = r15.zzd
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzws r7 = r10.zza
            java.lang.Object r2 = r2.zzd(r6, r7, r13)
            goto L67
        Lb6:
            r7 = 12
            if (r6 == r7) goto Lbf
            int r4 = com.google.android.gms.internal.mlkit_vision_face_bundled.zztz.zzo(r6, r12, r4, r14, r15)
            goto L67
        Lbf:
            if (r3 == 0) goto Lc7
            int r13 = r13 << 3
            r13 = r13 | r5
            r1.zzj(r13, r3)
        Lc7:
            r13 = r4
            goto L19
        Lca:
            if (r13 != r14) goto Lcd
            return
        Lcd:
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzvv r11 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzvv.zze()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face_bundled.zzww.zzh(java.lang.Object, byte[], int, int, com.google.android.gms.internal.mlkit_vision_face_bundled.zzty):void");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxf
    public final void zzi(Object obj, zzyo zzyoVar) throws IOException {
        Iterator itZzf = this.zzd.zzb(obj).zzf();
        if (!itZzf.hasNext()) {
            zzxw zzxwVar = this.zzb;
            zzxwVar.zzi(zzxwVar.zzd(obj), zzyoVar);
        } else {
            zzvc zzvcVar = (zzvc) ((Map.Entry) itZzf.next()).getKey();
            if (zzvcVar.zzc() == zzyn.MESSAGE) {
                zzvcVar.zze();
            }
            throw new IllegalStateException("Found invalid MessageSet item.");
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxf
    public final boolean zzj(Object obj, Object obj2) {
        zzxw zzxwVar = this.zzb;
        if (!zzxwVar.zzd(obj).equals(zzxwVar.zzd(obj2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zzb(obj).equals(this.zzd.zzb(obj2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzxf
    public final boolean zzk(Object obj) {
        return this.zzd.zzb(obj).zzl();
    }
}
