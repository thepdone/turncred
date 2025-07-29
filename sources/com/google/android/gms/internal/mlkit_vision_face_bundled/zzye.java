package com.google.android.gms.internal.mlkit_vision_face_bundled;

import sun.misc.Unsafe;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
final class zzye extends zzyf {
    zzye(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyf
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyf
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.mlkit_vision_face_bundled.zzyg.zzi(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.mlkit_vision_face_bundled.zzyg.zzj(java.lang.Object, long, boolean):void */
    /* JADX WARN: Method inline failed with exception
    java.lang.ArrayIndexOutOfBoundsException: arraycopy: length -1 is negative
    	at java.base/java.lang.System.arraycopy(Native Method)
    	at java.base/java.util.ArrayList.shiftTailOverGap(ArrayList.java:778)
    	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1721)
    	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1690)
    	at jadx.core.dex.instructions.args.SSAVar.removeUse(SSAVar.java:139)
    	at jadx.core.utils.InsnRemover.unbindArgUsage(InsnRemover.java:170)
    	at jadx.core.dex.nodes.InsnNode.replaceArg(InsnNode.java:137)
    	at jadx.core.dex.regions.conditions.IfCondition.replaceArg(IfCondition.java:270)
    	at jadx.core.dex.instructions.mods.TernaryInsn.replaceArg(TernaryInsn.java:67)
    	at jadx.core.dex.nodes.InsnNode.replaceArg(InsnNode.java:141)
    	at jadx.core.dex.visitors.InlineMethods.replaceRegs(InlineMethods.java:127)
    	at jadx.core.dex.visitors.InlineMethods.inlineMethod(InlineMethods.java:86)
    	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:78)
    	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:50)
     */
    /* JADX WARN: Unknown register number '(r5v0 boolean)' in method call: com.google.android.gms.internal.mlkit_vision_face_bundled.zzyg.zzj(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyf
    public final void zzc(Object obj, long j, boolean z) {
        if (zzyg.zzb) {
            zzyg.zzi(obj, j, z);
        } else {
            zzyg.zzj(obj, j, z);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyf
    public final void zzd(Object obj, long j, byte b) {
        if (zzyg.zzb) {
            zzyg.zzD(obj, j, b);
        } else {
            zzyg.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyf
    public final void zze(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyf
    public final void zzf(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzyf
    public final boolean zzg(Object obj, long j) {
        return zzyg.zzb ? zzyg.zzt(obj, j) : zzyg.zzu(obj, j);
    }
}
