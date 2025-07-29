package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public final class zzvz extends zztw implements RandomAccess, zzwa {

    @Deprecated
    public static final zzwa zza;
    private static final zzvz zzb;
    private final List zzc;

    static {
        zzvz zzvzVar = new zzvz(false);
        zzb = zzvzVar;
        zza = zzvzVar;
    }

    public zzvz() {
        this(10);
    }

    private static String zzi(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzul ? ((zzul) obj).zzm(zzvt.zzb) : zzvt.zzd((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zztw, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zza();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zztw, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        zza();
        if (collection instanceof zzwa) {
            collection = ((zzwa) collection).zzh();
        }
        boolean zAddAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zztw, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zza();
        this.zzc.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zztw, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        Object objRemove = this.zzc.remove(i);
        this.modCount++;
        return zzi(objRemove);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zztw, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        zza();
        return zzi(this.zzc.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzvs
    public final /* bridge */ /* synthetic */ zzvs zzd(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzc);
        return new zzvz(arrayList);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwa
    public final zzwa zze() {
        return zzc() ? new zzyb(this) : this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwa
    public final Object zzf(int i) {
        return this.zzc.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final String get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzul) {
            zzul zzulVar = (zzul) obj;
            String strZzm = zzulVar.zzm(zzvt.zzb);
            if (zzulVar.zzi()) {
                this.zzc.set(i, strZzm);
            }
            return strZzm;
        }
        byte[] bArr = (byte[]) obj;
        String strZzd = zzvt.zzd(bArr);
        if (zzyl.zzd(bArr)) {
            this.zzc.set(i, strZzd);
        }
        return strZzd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwa
    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public zzvz(int i) {
        ArrayList arrayList = new ArrayList(i);
        super(true);
        this.zzc = arrayList;
    }

    private zzvz(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzvz(boolean z) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zztw, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
