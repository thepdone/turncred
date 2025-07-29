package com.google.android.gms.internal.mlkit_vision_face_bundled;

import com.google.android.gms.internal.mlkit_vision_face_bundled.zzvh;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzvn;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public class zzvh<MessageType extends zzvn<MessageType, BuilderType>, BuilderType extends zzvh<MessageType, BuilderType>> extends zztt<MessageType, BuilderType> {
    protected zzvn zza;
    private final zzvn zzb;

    protected zzvh(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzI()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = messagetype.zzy();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zztt
    /* renamed from: zzm, reason: merged with bridge method [inline-methods] */
    public final zzvh clone() {
        zzvh zzvhVar = (zzvh) this.zzb.zzf(5, null, null);
        zzvhVar.zza = zzp();
        return zzvhVar;
    }

    public final MessageType zzn() {
        MessageType messagetype = (MessageType) zzp();
        if (messagetype.zzt()) {
            return messagetype;
        }
        throw new zzxv(messagetype);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwr
    /* renamed from: zzo, reason: merged with bridge method [inline-methods] */
    public MessageType zzp() {
        if (!this.zza.zzI()) {
            return (MessageType) this.zza;
        }
        this.zza.zzD();
        return (MessageType) this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwt
    public final /* bridge */ /* synthetic */ zzws zzq() {
        throw null;
    }

    protected final void zzr() {
        if (this.zza.zzI()) {
            return;
        }
        zzs();
    }

    protected void zzs() {
        zzvn zzvnVarZzy = this.zzb.zzy();
        zzxb.zza().zzb(zzvnVarZzy.getClass()).zzg(zzvnVarZzy, this.zza);
        this.zza = zzvnVarZzy;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwt
    public final boolean zzt() {
        return zzvn.zzH(this.zza, false);
    }
}
