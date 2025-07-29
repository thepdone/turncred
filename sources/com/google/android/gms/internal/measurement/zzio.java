package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzin;
import com.google.android.gms.internal.measurement.zzio;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
public abstract class zzio<MessageType extends zzio<MessageType, BuilderType>, BuilderType extends zzin<MessageType, BuilderType>> implements zzlm {
    protected int zza = 0;

    int zzcc() {
        throw new UnsupportedOperationException();
    }

    int zza(zzme zzmeVar) {
        int iZzcc = zzcc();
        if (iZzcc != -1) {
            return iZzcc;
        }
        int iZza = zzmeVar.zza(this);
        zzc(iZza);
        return iZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final zziy zzcd() {
        try {
            zzjd zzjdVarZzc = zziy.zzc(zzcf());
            zza(zzjdVarZzc.zzb());
            return zzjdVarZzc.zza();
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzin.zza(iterable, list);
    }

    void zzc(int i) {
        throw new UnsupportedOperationException();
    }

    public final byte[] zzce() {
        try {
            byte[] bArr = new byte[zzcf()];
            zzjn zzjnVarZzb = zzjn.zzb(bArr);
            zza(zzjnVarZzb);
            zzjnVarZzb.zzb();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
