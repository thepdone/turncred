package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public abstract class zzbm extends zzbf implements Set {

    @CheckForNull
    private transient zzbj zza;

    zzbm() {
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return zzbt.zza(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzbf, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzd */
    public abstract zzbu iterator();

    public final zzbj zzf() {
        zzbj zzbjVar = this.zza;
        if (zzbjVar != null) {
            return zzbjVar;
        }
        zzbj zzbjVarZzg = zzg();
        this.zza = zzbjVarZzg;
        return zzbjVarZzg;
    }

    zzbj zzg() {
        Object[] array = toArray();
        int i = zzbj.zzd;
        return zzbj.zzg(array, array.length);
    }
}
