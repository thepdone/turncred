package com.google.android.gms.internal.mlkit_vision_face_bundled;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzsp implements zzsm {
    final List zza;

    public zzsp(Context context, zzso zzsoVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzsoVar.zzc()) {
            arrayList.add(new zztb(context, zzsoVar));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzsm
    public final void zza(zzsl zzslVar) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzsm) it.next()).zza(zzslVar);
        }
    }
}
