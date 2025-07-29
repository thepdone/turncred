package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public enum zzym {
    DOUBLE(zzyn.DOUBLE, 1),
    FLOAT(zzyn.FLOAT, 5),
    INT64(zzyn.LONG, 0),
    UINT64(zzyn.LONG, 0),
    INT32(zzyn.INT, 0),
    FIXED64(zzyn.LONG, 1),
    FIXED32(zzyn.INT, 5),
    BOOL(zzyn.BOOLEAN, 0),
    STRING(zzyn.STRING, 2),
    GROUP(zzyn.MESSAGE, 3),
    MESSAGE(zzyn.MESSAGE, 2),
    BYTES(zzyn.BYTE_STRING, 2),
    UINT32(zzyn.INT, 0),
    ENUM(zzyn.ENUM, 0),
    SFIXED32(zzyn.INT, 5),
    SFIXED64(zzyn.LONG, 1),
    SINT32(zzyn.INT, 0),
    SINT64(zzyn.LONG, 0);

    private final zzyn zzt;

    zzym(zzyn zzynVar, int i) {
        this.zzt = zzynVar;
    }

    public final zzyn zza() {
        return this.zzt;
    }
}
