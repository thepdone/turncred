package com.google.android.gms.internal.mlkit_vision_face_bundled;

import com.google.android.gms.internal.mlkit_vision_face_bundled.zztt;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zztu;
import java.io.IOException;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public abstract class zztu<MessageType extends zztu<MessageType, BuilderType>, BuilderType extends zztt<MessageType, BuilderType>> implements zzws {
    protected int zza = 0;

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzws
    public final zzul zzM() {
        try {
            int iZzu = zzu();
            zzul zzulVar = zzul.zzb;
            byte[] bArr = new byte[iZzu];
            zzut zzutVarZzy = zzut.zzy(bArr, 0, iZzu);
            zzL(zzutVarZzy);
            zzutVarZzy.zzz();
            return new zzui(bArr);
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    int zzp(zzxf zzxfVar) {
        throw null;
    }

    public final byte[] zzr() {
        try {
            int iZzu = zzu();
            byte[] bArr = new byte[iZzu];
            zzut zzutVarZzy = zzut.zzy(bArr, 0, iZzu);
            zzL(zzutVarZzy);
            zzutVarZzy.zzz();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
