package com.google.android.gms.internal.mlkit_vision_face_bundled;

import androidx.camera.video.AudioStats;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public enum zzvw {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzul.class, zzul.class, zzul.zzb),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);

    private final Class zzl;
    private final Class zzm;
    private final Object zzn;

    zzvw(Class cls, Class cls2, Object obj) {
        this.zzl = cls;
        this.zzm = cls2;
        this.zzn = obj;
    }

    public final Class zza() {
        return this.zzm;
    }
}
