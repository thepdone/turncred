package com.google.android.gms.internal.mlkit_vision_face_bundled;

import com.google.android.gms.internal.mlkit_vision_face_bundled.zzvh;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzvn;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public abstract class zzvn<MessageType extends zzvn<MessageType, BuilderType>, BuilderType extends zzvh<MessageType, BuilderType>> extends zztu<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzxx zzc = zzxx.zzc();

    protected static zzvs zzA() {
        return zzxc.zze();
    }

    static Object zzB(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static Object zzC(zzws zzwsVar, String str, Object[] objArr) {
        return new zzxd(zzwsVar, str, objArr);
    }

    protected static void zzF(Class cls, zzvn zzvnVar) {
        zzvnVar.zzE();
        zzb.put(cls, zzvnVar);
    }

    protected static final boolean zzH(zzvn zzvnVar, boolean z) {
        byte bByteValue = ((Byte) zzvnVar.zzf(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzk = zzxb.zza().zzb(zzvnVar.getClass()).zzk(zzvnVar);
        if (z) {
            zzvnVar.zzf(2, true != zZzk ? null : zzvnVar, null);
        }
        return zZzk;
    }

    private final int zzb(zzxf zzxfVar) {
        return zzxb.zza().zzb(getClass()).zza(this);
    }

    private static zzvn zzd(zzvn zzvnVar, byte[] bArr, int i, int i2, zzuy zzuyVar) throws zzvv {
        zzvn zzvnVarZzy = zzvnVar.zzy();
        try {
            zzxf zzxfVarZzb = zzxb.zza().zzb(zzvnVarZzy.getClass());
            zzxfVarZzb.zzh(zzvnVarZzy, bArr, 0, i2, new zzty(zzuyVar));
            zzxfVarZzb.zzf(zzvnVarZzy);
            return zzvnVarZzy;
        } catch (zzvv e) {
            e.zzf(zzvnVarZzy);
            throw e;
        } catch (zzxv e2) {
            zzvv zzvvVarZza = e2.zza();
            zzvvVarZza.zzf(zzvnVarZzy);
            throw zzvvVarZza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzvv) {
                throw ((zzvv) e3.getCause());
            }
            zzvv zzvvVar = new zzvv(e3);
            zzvvVar.zzf(zzvnVarZzy);
            throw zzvvVar;
        } catch (IndexOutOfBoundsException unused) {
            zzvv zzvvVarZzg = zzvv.zzg();
            zzvvVarZzg.zzf(zzvnVarZzy);
            throw zzvvVarZzg;
        }
    }

    public static zzvl zzw(zzws zzwsVar, zzws zzwsVar2, zzvq zzvqVar, int i, zzym zzymVar, boolean z, Class cls) {
        return new zzvl(zzwsVar, Collections.emptyList(), zzwsVar2, new zzvk(null, 202056002, zzymVar, true, false), cls);
    }

    static zzvn zzx(Class cls) throws ClassNotFoundException {
        Map map = zzb;
        zzvn zzvnVar = (zzvn) map.get(cls);
        if (zzvnVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzvnVar = (zzvn) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzvnVar == null) {
            zzvnVar = (zzvn) ((zzvn) zzyg.zze(cls)).zzf(6, null, null);
            if (zzvnVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzvnVar);
        }
        return zzvnVar;
    }

    protected static zzvn zzz(zzvn zzvnVar, byte[] bArr, zzuy zzuyVar) throws zzvv {
        zzvn zzvnVarZzd = zzd(zzvnVar, bArr, 0, bArr.length, zzuyVar);
        if (zzvnVarZzd == null || zzvnVarZzd.zzt()) {
            return zzvnVarZzd;
        }
        zzvv zzvvVarZza = new zzxv(zzvnVarZzd).zza();
        zzvvVarZza.zzf(zzvnVarZzd);
        throw zzvvVarZza;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzxb.zza().zzb(getClass()).zzj(this, (zzvn) obj);
    }

    public final int hashCode() {
        if (zzI()) {
            return zzs();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iZzs = zzs();
        this.zza = iZzs;
        return iZzs;
    }

    public final String toString() {
        return zzwu.zza(this, super.toString());
    }

    protected final void zzD() {
        zzxb.zza().zzb(getClass()).zzf(this);
        zzE();
    }

    final void zzE() {
        this.zzd &= Integer.MAX_VALUE;
    }

    final void zzG(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    final boolean zzI() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzws
    public final /* synthetic */ zzwr zzK() {
        return (zzvh) zzf(5, null, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzws
    public final void zzL(zzut zzutVar) throws IOException {
        zzxb.zza().zzb(getClass()).zzi(this, zzuu.zza(zzutVar));
    }

    protected abstract Object zzf(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zztu
    final int zzp(zzxf zzxfVar) {
        if (zzI()) {
            int iZza = zzxfVar.zza(this);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZza2 = zzxfVar.zza(this);
        if (iZza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
            return iZza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZza2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwt
    public final /* synthetic */ zzws zzq() {
        return (zzvn) zzf(6, null, null);
    }

    final int zzs() {
        return zzxb.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzwt
    public final boolean zzt() {
        return zzH(this, Boolean.TRUE.booleanValue());
    }

    protected final zzvh zzv() {
        return (zzvh) zzf(5, null, null);
    }

    final zzvn zzy() {
        return (zzvn) zzf(4, null, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzws
    public final int zzu() {
        int iZzb;
        if (zzI()) {
            iZzb = zzb(null);
            if (iZzb < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + iZzb);
            }
        } else {
            iZzb = this.zzd & Integer.MAX_VALUE;
            if (iZzb == Integer.MAX_VALUE) {
                iZzb = zzb(null);
                if (iZzb < 0) {
                    throw new IllegalStateException("serialized size must be non-negative, was " + iZzb);
                }
                this.zzd = (this.zzd & Integer.MIN_VALUE) | iZzb;
            }
        }
        return iZzb;
    }
}
