package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.Comparator;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzud implements Comparator {
    zzud() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzul zzulVar = (zzul) obj;
        zzul zzulVar2 = (zzul) obj2;
        zzuc zzucVar = new zzuc(zzulVar);
        zzuc zzucVar2 = new zzuc(zzulVar2);
        while (zzucVar.hasNext() && zzucVar2.hasNext()) {
            int iCompareTo = Integer.valueOf(zzucVar.zza() & 255).compareTo(Integer.valueOf(zzucVar2.zza() & 255));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return Integer.valueOf(zzulVar.zzd()).compareTo(Integer.valueOf(zzulVar2.zzd()));
    }
}
