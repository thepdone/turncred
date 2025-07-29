package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzva extends zzuz {
    zzva() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzuz
    final int zza(Map.Entry entry) {
        return 202056002;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzuz
    final zzvd zzb(Object obj) {
        return ((zzvj) obj).zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzuz
    final zzvd zzc(Object obj) {
        return ((zzvj) obj).zzb();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzuz
    final Object zzd(zzuy zzuyVar, zzws zzwsVar, int i) {
        return zzuyVar.zzb(zzwsVar, i);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzuz
    final void zze(Object obj) {
        ((zzvj) obj).zzb.zzh();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzuz
    final void zzf(zzyo zzyoVar, Map.Entry entry) throws IOException {
        zzym zzymVar = zzym.DOUBLE;
        switch (r0.zzb) {
            case DOUBLE:
                zzxh.zzu(202056002, (List) entry.getValue(), zzyoVar, false);
                break;
            case FLOAT:
                zzxh.zzy(202056002, (List) entry.getValue(), zzyoVar, false);
                break;
            case INT64:
                zzxh.zzB(202056002, (List) entry.getValue(), zzyoVar, false);
                break;
            case UINT64:
                zzxh.zzJ(202056002, (List) entry.getValue(), zzyoVar, false);
                break;
            case INT32:
                zzxh.zzA(202056002, (List) entry.getValue(), zzyoVar, false);
                break;
            case FIXED64:
                zzxh.zzx(202056002, (List) entry.getValue(), zzyoVar, false);
                break;
            case FIXED32:
                zzxh.zzw(202056002, (List) entry.getValue(), zzyoVar, false);
                break;
            case BOOL:
                zzxh.zzs(202056002, (List) entry.getValue(), zzyoVar, false);
                break;
            case STRING:
                zzxh.zzH(202056002, (List) entry.getValue(), zzyoVar);
                break;
            case GROUP:
                List list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    zzxh.zzz(202056002, (List) entry.getValue(), zzyoVar, zzxb.zza().zzb(list.get(0).getClass()));
                    break;
                }
                break;
            case MESSAGE:
                List list2 = (List) entry.getValue();
                if (list2 != null && !list2.isEmpty()) {
                    zzxh.zzC(202056002, (List) entry.getValue(), zzyoVar, zzxb.zza().zzb(list2.get(0).getClass()));
                    break;
                }
                break;
            case BYTES:
                zzxh.zzt(202056002, (List) entry.getValue(), zzyoVar);
                break;
            case UINT32:
                zzxh.zzI(202056002, (List) entry.getValue(), zzyoVar, false);
                break;
            case ENUM:
                zzxh.zzA(202056002, (List) entry.getValue(), zzyoVar, false);
                break;
            case SFIXED32:
                zzxh.zzD(202056002, (List) entry.getValue(), zzyoVar, false);
                break;
            case SFIXED64:
                zzxh.zzE(202056002, (List) entry.getValue(), zzyoVar, false);
                break;
            case SINT32:
                zzxh.zzF(202056002, (List) entry.getValue(), zzyoVar, false);
                break;
            case SINT64:
                zzxh.zzG(202056002, (List) entry.getValue(), zzyoVar, false);
                break;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzuz
    final boolean zzg(zzws zzwsVar) {
        return zzwsVar instanceof zzvj;
    }
}
