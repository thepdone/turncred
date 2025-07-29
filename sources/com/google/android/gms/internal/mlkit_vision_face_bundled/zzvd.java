package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzvd {
    private static final zzvd zzb = new zzvd(true);
    final zzxs zza = new zzxi(16);
    private boolean zzc;

    private zzvd() {
    }

    public static int zza(zzvc zzvcVar, Object obj) {
        int iZzd;
        int iZzw;
        zzym zzymVarZzb = zzvcVar.zzb();
        zzvcVar.zza();
        zzvcVar.zze();
        zzvcVar.zzd();
        int i = 0;
        for (Object obj2 : (List) obj) {
            int iZzw2 = zzut.zzw(1616448016);
            if (zzymVarZzb == zzym.GROUP) {
                zzws zzwsVar = (zzws) obj2;
                byte[] bArr = zzvt.zzd;
                if (zzwsVar instanceof zztv) {
                    throw null;
                }
                iZzw2 += iZzw2;
            }
            zzyn zzynVar = zzyn.INT;
            int iZzx = 4;
            switch (zzymVarZzb) {
                case DOUBLE:
                    ((Double) obj2).doubleValue();
                    iZzx = 8;
                    i += iZzw2 + iZzx;
                case FLOAT:
                    ((Float) obj2).floatValue();
                    i += iZzw2 + iZzx;
                case INT64:
                    iZzx = zzut.zzx(((Long) obj2).longValue());
                    i += iZzw2 + iZzx;
                case UINT64:
                    iZzx = zzut.zzx(((Long) obj2).longValue());
                    i += iZzw2 + iZzx;
                case INT32:
                    iZzx = zzut.zzx(((Integer) obj2).intValue());
                    i += iZzw2 + iZzx;
                case FIXED64:
                    ((Long) obj2).longValue();
                    iZzx = 8;
                    i += iZzw2 + iZzx;
                case FIXED32:
                    ((Integer) obj2).intValue();
                    i += iZzw2 + iZzx;
                case BOOL:
                    ((Boolean) obj2).booleanValue();
                    iZzx = 1;
                    i += iZzw2 + iZzx;
                case STRING:
                    if (obj2 instanceof zzul) {
                        iZzd = ((zzul) obj2).zzd();
                        iZzw = zzut.zzw(iZzd);
                        iZzx = iZzw + iZzd;
                        i += iZzw2 + iZzx;
                    } else {
                        iZzx = zzut.zzv((String) obj2);
                        i += iZzw2 + iZzx;
                    }
                case GROUP:
                    iZzx = ((zzws) obj2).zzu();
                    i += iZzw2 + iZzx;
                case MESSAGE:
                    if (obj2 instanceof zzvx) {
                        iZzd = ((zzvx) obj2).zza();
                        iZzw = zzut.zzw(iZzd);
                    } else {
                        iZzd = ((zzws) obj2).zzu();
                        iZzw = zzut.zzw(iZzd);
                    }
                    iZzx = iZzw + iZzd;
                    i += iZzw2 + iZzx;
                case BYTES:
                    if (obj2 instanceof zzul) {
                        iZzd = ((zzul) obj2).zzd();
                        iZzw = zzut.zzw(iZzd);
                    } else {
                        iZzd = ((byte[]) obj2).length;
                        iZzw = zzut.zzw(iZzd);
                    }
                    iZzx = iZzw + iZzd;
                    i += iZzw2 + iZzx;
                case UINT32:
                    iZzx = zzut.zzw(((Integer) obj2).intValue());
                    i += iZzw2 + iZzx;
                case ENUM:
                    iZzx = obj2 instanceof zzvp ? zzut.zzx(((zzvp) obj2).zza()) : zzut.zzx(((Integer) obj2).intValue());
                    i += iZzw2 + iZzx;
                case SFIXED32:
                    ((Integer) obj2).intValue();
                    i += iZzw2 + iZzx;
                case SFIXED64:
                    ((Long) obj2).longValue();
                    iZzx = 8;
                    i += iZzw2 + iZzx;
                case SINT32:
                    int iIntValue = ((Integer) obj2).intValue();
                    iZzx = zzut.zzw((iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i += iZzw2 + iZzx;
                case SINT64:
                    long jLongValue = ((Long) obj2).longValue();
                    iZzx = zzut.zzx((jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i += iZzw2 + iZzx;
                default:
                    throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
            }
        }
        return i;
    }

    public static zzvd zzd() {
        return zzb;
    }

    private final void zzm(Map.Entry entry) {
        zzvc zzvcVar = (zzvc) entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zzvx;
        zzvcVar.zze();
        if (z) {
            throw new IllegalStateException("Lazy fields can not be repeated");
        }
        Object objZze = zze(zzvcVar);
        if (objZze == null) {
            objZze = new ArrayList();
        }
        for (Object objZzb : (List) value) {
            List list = (List) objZze;
            if (objZzb instanceof zzwx) {
                objZzb = ((zzwx) objZzb).zzb();
            } else if (objZzb instanceof byte[]) {
                byte[] bArr = (byte[]) objZzb;
                int length = bArr.length;
                Object obj = new byte[length];
                System.arraycopy(bArr, 0, obj, 0, length);
                objZzb = obj;
            }
            list.add(objZzb);
        }
        this.zza.put(zzvcVar, objZze);
    }

    private static boolean zzn(Map.Entry entry) {
        zzvc zzvcVar = (zzvc) entry.getKey();
        if (zzvcVar.zzc() != zzyn.MESSAGE) {
            return true;
        }
        zzvcVar.zze();
        for (Object obj : (List) entry.getValue()) {
            if (obj instanceof zzwt) {
                if (!((zzwt) obj).zzt()) {
                    return false;
                }
            } else if (!(obj instanceof zzvx)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    private static final int zzo(Map.Entry entry) {
        zzvc zzvcVar = (zzvc) entry.getKey();
        Object value = entry.getValue();
        if (zzvcVar.zzc() == zzyn.MESSAGE) {
            zzvcVar.zze();
        }
        return zza(zzvcVar, value);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void zzp(com.google.android.gms.internal.mlkit_vision_face_bundled.zzvc r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzym r0 = r2.zzb()
            byte[] r1 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzvt.zzd
            r3.getClass()
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzym r1 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzym.DOUBLE
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzyn r1 = com.google.android.gms.internal.mlkit_vision_face_bundled.zzyn.INT
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzyn r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L43;
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L2b;
                case 7: goto L22;
                case 8: goto L19;
                default: goto L18;
            }
        L18:
            goto L48
        L19:
            boolean r0 = r3 instanceof com.google.android.gms.internal.mlkit_vision_face_bundled.zzws
            if (r0 != 0) goto L47
            boolean r0 = r3 instanceof com.google.android.gms.internal.mlkit_vision_face_bundled.zzvx
            if (r0 == 0) goto L48
            goto L47
        L22:
            boolean r0 = r3 instanceof java.lang.Integer
            if (r0 != 0) goto L47
            boolean r0 = r3 instanceof com.google.android.gms.internal.mlkit_vision_face_bundled.zzvp
            if (r0 == 0) goto L48
            goto L47
        L2b:
            boolean r0 = r3 instanceof com.google.android.gms.internal.mlkit_vision_face_bundled.zzul
            if (r0 != 0) goto L47
            boolean r0 = r3 instanceof byte[]
            if (r0 == 0) goto L48
            goto L47
        L34:
            boolean r0 = r3 instanceof java.lang.String
            goto L45
        L37:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L45
        L3a:
            boolean r0 = r3 instanceof java.lang.Double
            goto L45
        L3d:
            boolean r0 = r3 instanceof java.lang.Float
            goto L45
        L40:
            boolean r0 = r3 instanceof java.lang.Long
            goto L45
        L43:
            boolean r0 = r3 instanceof java.lang.Integer
        L45:
            if (r0 == 0) goto L48
        L47:
            return
        L48:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r2.zza()
            r1 = 202056002(0xc0b2142, float:1.0718179E-31)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzym r2 = r2.zzb()
            com.google.android.gms.internal.mlkit_vision_face_bundled.zzyn r2 = r2.zza()
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getName()
            java.lang.Object[] r2 = new java.lang.Object[]{r1, r2, r3}
            java.lang.String r3 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_face_bundled.zzvd.zzp(com.google.android.gms.internal.mlkit_vision_face_bundled.zzvc, java.lang.Object):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzvd) {
            return this.zza.equals(((zzvd) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzb() {
        int iZzo = 0;
        for (int i = 0; i < this.zza.zzb(); i++) {
            iZzo += zzo(this.zza.zzg(i));
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            iZzo += zzo((Map.Entry) it.next());
        }
        return iZzo;
    }

    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzvd clone() {
        zzvd zzvdVar = new zzvd();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry entryZzg = this.zza.zzg(i);
            zzvdVar.zzj((zzvc) entryZzg.getKey(), entryZzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzvdVar.zzj((zzvc) entry.getKey(), entry.getValue());
        }
        return zzvdVar;
    }

    public final Object zze(zzvc zzvcVar) {
        Object obj = this.zza.get(zzvcVar);
        if (!(obj instanceof zzvx)) {
            return obj;
        }
        throw null;
    }

    public final Iterator zzf() {
        return this.zza.entrySet().iterator();
    }

    public final void zzg(zzvc zzvcVar, Object obj) {
        List arrayList;
        zzp(zzvcVar, obj);
        Object objZze = zze(zzvcVar);
        if (objZze == null) {
            arrayList = new ArrayList();
            this.zza.put(zzvcVar, arrayList);
        } else {
            arrayList = (List) objZze;
        }
        arrayList.add(obj);
    }

    public final void zzh() {
        if (this.zzc) {
            return;
        }
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry entryZzg = this.zza.zzg(i);
            if (entryZzg.getValue() instanceof zzvn) {
                ((zzvn) entryZzg.getValue()).zzD();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzi(zzvd zzvdVar) {
        for (int i = 0; i < zzvdVar.zza.zzb(); i++) {
            zzm(zzvdVar.zza.zzg(i));
        }
        Iterator it = zzvdVar.zza.zzc().iterator();
        while (it.hasNext()) {
            zzm((Map.Entry) it.next());
        }
    }

    public final void zzj(zzvc zzvcVar, Object obj) {
        zzvcVar.zze();
        if (!(obj instanceof List)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll((List) obj);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            zzp(zzvcVar, arrayList.get(i));
        }
        this.zza.put(zzvcVar, arrayList);
    }

    public final boolean zzk() {
        return this.zzc;
    }

    public final boolean zzl() {
        for (int i = 0; i < this.zza.zzb(); i++) {
            if (!zzn(this.zza.zzg(i))) {
                return false;
            }
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            if (!zzn((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzvd(boolean z) {
        zzh();
        zzh();
    }
}
