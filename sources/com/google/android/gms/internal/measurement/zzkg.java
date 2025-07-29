package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import com.google.android.gms.internal.measurement.zzkg.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
public abstract class zzkg<MessageType extends zzkg<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzio<MessageType, BuilderType> {
    private static Map<Class<?>, zzkg<?, ?>> zzc = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzmx zzb = zzmx.zzc();

    /* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
    public static abstract class zza<MessageType extends zzkg<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzin<MessageType, BuilderType> {
        protected MessageType zza;
        private final MessageType zzb;

        @Override // com.google.android.gms.internal.measurement.zzin
        /* renamed from: zzag */
        public final /* synthetic */ zzin clone() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.measurement.zzin
        /* renamed from: zza */
        public final /* synthetic */ zzin zzb(zzjk zzjkVar, zzjt zzjtVar) throws IOException {
            return (zza) zzb(zzjkVar, zzjtVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzin
        public final /* synthetic */ zzin zza(byte[] bArr, int i, int i2) throws zzkp {
            return zzb(bArr, 0, i2, zzjt.zza);
        }

        @Override // com.google.android.gms.internal.measurement.zzin
        public final /* synthetic */ zzin zza(byte[] bArr, int i, int i2, zzjt zzjtVar) throws zzkp {
            return zzb(bArr, 0, i2, zzjtVar);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb.equals(messagetype)) {
                return this;
            }
            if (!this.zza.zzcq()) {
                zzan();
            }
            zza(this.zza, messagetype);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.google.android.gms.internal.measurement.zzin
        /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
        public final BuilderType zzb(zzjk zzjkVar, zzjt zzjtVar) throws IOException {
            if (!this.zza.zzcq()) {
                zzan();
            }
            try {
                zzma.zza().zza((zzma) this.zza).zza(this.zza, zzjl.zza(zzjkVar), zzjtVar);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzjt zzjtVar) throws zzkp {
            if (!this.zza.zzcq()) {
                zzan();
            }
            try {
                zzma.zza().zza((zzma) this.zza).zza(this.zza, bArr, 0, i2, new zzit(zzjtVar));
                return this;
            } catch (zzkp e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            } catch (IndexOutOfBoundsException unused) {
                throw zzkp.zzi();
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzlp
        /* renamed from: zzah, reason: merged with bridge method [inline-methods] */
        public final MessageType zzaj() {
            MessageType messagetype = (MessageType) zzak();
            if (messagetype.j_()) {
                return messagetype;
            }
            throw new zzmv(messagetype);
        }

        @Override // com.google.android.gms.internal.measurement.zzlp
        /* renamed from: zzai, reason: merged with bridge method [inline-methods] */
        public MessageType zzak() {
            if (!this.zza.zzcq()) {
                return this.zza;
            }
            this.zza.zzco();
            return this.zza;
        }

        @Override // com.google.android.gms.internal.measurement.zzlo
        public final /* synthetic */ zzlm zzal() {
            return this.zzb;
        }

        @Override // com.google.android.gms.internal.measurement.zzin
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zzaVar = (zza) this.zzb.zza(zzf.zze, null, null);
            zzaVar.zza = (MessageType) zzak();
            return zzaVar;
        }

        protected zza(MessageType messagetype) {
            this.zzb = messagetype;
            if (messagetype.zzcq()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.zza = (MessageType) messagetype.zzci();
        }

        protected final void zzam() {
            if (this.zza.zzcq()) {
                return;
            }
            zzan();
        }

        protected void zzan() {
            MessageType messagetype = (MessageType) this.zzb.zzci();
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        private static <MessageType> void zza(MessageType messagetype, MessageType messagetype2) {
            zzma.zza().zza((zzma) messagetype).zza(messagetype, messagetype2);
        }

        @Override // com.google.android.gms.internal.measurement.zzlo
        public final boolean j_() {
            return zzkg.zza((zzkg) this.zza, false);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
    public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType> extends zzkg<MessageType, BuilderType> implements zzlo {
        protected zzjw<zze> zzc = zzjw.zzb();

        final zzjw<zze> zza() {
            if (this.zzc.zzf()) {
                this.zzc = (zzjw) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
    protected static class zzc<T extends zzkg<T, ?>> extends zzip<T> {
        public zzc(T t) {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
    public static class zzd<ContainingType extends zzlm, Type> extends zzjr<ContainingType, Type> {
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
    static final class zze implements zzjy<zze> {
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzjy
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzjy
        public final zzlp zza(zzlp zzlpVar, zzlm zzlmVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzjy
        public final zzlv zza(zzlv zzlvVar, zzlv zzlvVar2) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzjy
        public final zzng zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzjy
        public final zznj zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzjy
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzjy
        public final boolean zze() {
            throw new NoSuchMethodError();
        }
    }

    private final int zza() {
        return zzma.zza().zza((zzma) this).zzb(this);
    }

    static /* synthetic */ boolean zza(zzkg zzkgVar, boolean z) {
        return zzb(zzkgVar, false);
    }

    protected abstract Object zza(int i, Object obj, Object obj2);

    private final int zzb(zzme<?> zzmeVar) {
        if (zzmeVar == null) {
            return zzma.zza().zza((zzma) this).zza(this);
        }
        return zzmeVar.zza(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    final int zzcc() {
        return this.zzd & Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final int zzcf() {
        return zza((zzme) null);
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
    public enum zzf {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzh = {1, 2, 3, 4, 5, 6, 7};

        public static int[] zza() {
            return (int[]) zzh.clone();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    final int zza(zzme zzmeVar) {
        if (zzcq()) {
            int iZzb = zzb(zzmeVar);
            if (iZzb >= 0) {
                return iZzb;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZzb);
        }
        if (zzcc() != Integer.MAX_VALUE) {
            return zzcc();
        }
        int iZzb2 = zzb(zzmeVar);
        zzc(iZzb2);
        return iZzb2;
    }

    public int hashCode() {
        if (zzcq()) {
            return zza();
        }
        if (this.zza == 0) {
            this.zza = zza();
        }
        return this.zza;
    }

    protected final <MessageType extends zzkg<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzcg() {
        return (BuilderType) zza(zzf.zze, (Object) null, (Object) null);
    }

    protected final <MessageType extends zzkg<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zza(MessageType messagetype) {
        return (BuilderType) zzcg().zza((zza) messagetype);
    }

    public final BuilderType zzch() {
        return (BuilderType) ((zza) zza(zzf.zze, (Object) null, (Object) null)).zza((zza) this);
    }

    static <T extends zzkg<?, ?>> T zza(Class<T> cls) throws ClassNotFoundException {
        zzkg<?, ?> zzkgVar = zzc.get(cls);
        if (zzkgVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzkgVar = zzc.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzkgVar == null) {
            zzkgVar = (T) ((zzkg) zzmz.zza(cls)).zza(zzf.zzf, (Object) null, (Object) null);
            if (zzkgVar == null) {
                throw new IllegalStateException();
            }
            zzc.put(cls, zzkgVar);
        }
        return (T) zzkgVar;
    }

    final MessageType zzci() {
        return (MessageType) zza(zzf.zzd, (Object) null, (Object) null);
    }

    protected static zzkk zzcj() {
        return zzkh.zzd();
    }

    protected static zzkn zzck() {
        return zzlb.zzd();
    }

    protected static zzkn zza(zzkn zzknVar) {
        return zzknVar.zza(zzknVar.size() << 1);
    }

    protected static <E> zzkm<E> zzcl() {
        return zzmd.zzd();
    }

    protected static <E> zzkm<E> zza(zzkm<E> zzkmVar) {
        return zzkmVar.zza(zzkmVar.size() << 1);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final /* synthetic */ zzlp zzcm() {
        return (zza) zza(zzf.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final /* synthetic */ zzlp zzcn() {
        return ((zza) zza(zzf.zze, (Object) null, (Object) null)).zza((zza) this);
    }

    @Override // com.google.android.gms.internal.measurement.zzlo
    public final /* synthetic */ zzlm zzal() {
        return (zzkg) zza(zzf.zzf, (Object) null, (Object) null);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
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

    protected static Object zza(zzlm zzlmVar, String str, Object[] objArr) {
        return new zzmc(zzlmVar, str, objArr);
    }

    public String toString() {
        return zzlr.zza(this, super.toString());
    }

    protected final void zzco() {
        zzma.zza().zza((zzma) this).zzd(this);
        zzcp();
    }

    final void zzcp() {
        this.zzd &= Integer.MAX_VALUE;
    }

    protected static <T extends zzkg<?, ?>> void zza(Class<T> cls, T t) {
        t.zzcp();
        zzc.put(cls, t);
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    final void zzc(int i) {
        if (i < 0) {
            throw new IllegalStateException("serialized size must be non-negative, was " + i);
        }
        this.zzd = (i & Integer.MAX_VALUE) | (this.zzd & Integer.MIN_VALUE);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zza(zzjn zzjnVar) throws IOException {
        zzma.zza().zza((zzma) this).zza((zzme) this, (zznl) zzjp.zza(zzjnVar));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzma.zza().zza((zzma) this).zzb(this, (zzkg) obj);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzlo
    public final boolean j_() {
        return zzb(this, true);
    }

    private static final <T extends zzkg<T, ?>> boolean zzb(T t, boolean z) {
        byte bByteValue = ((Byte) t.zza(zzf.zza, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZze = zzma.zza().zza((zzma) t).zze(t);
        if (z) {
            t.zza(zzf.zzb, zZze ? t : null, null);
        }
        return zZze;
    }

    final boolean zzcq() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }
}
