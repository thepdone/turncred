package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzbt {
    static int zza(Set set) {
        Iterator it = set.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }
}
