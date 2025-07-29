package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* compiled from: com.google.mlkit:face-detection@@16.1.6 */
/* loaded from: classes3.dex */
public enum zzve {
    DOUBLE(0, 1, zzvw.DOUBLE),
    FLOAT(1, 1, zzvw.FLOAT),
    INT64(2, 1, zzvw.LONG),
    UINT64(3, 1, zzvw.LONG),
    INT32(4, 1, zzvw.INT),
    FIXED64(5, 1, zzvw.LONG),
    FIXED32(6, 1, zzvw.INT),
    BOOL(7, 1, zzvw.BOOLEAN),
    STRING(8, 1, zzvw.STRING),
    MESSAGE(9, 1, zzvw.MESSAGE),
    BYTES(10, 1, zzvw.BYTE_STRING),
    UINT32(11, 1, zzvw.INT),
    ENUM(12, 1, zzvw.ENUM),
    SFIXED32(13, 1, zzvw.INT),
    SFIXED64(14, 1, zzvw.LONG),
    SINT32(15, 1, zzvw.INT),
    SINT64(16, 1, zzvw.LONG),
    GROUP(17, 1, zzvw.MESSAGE),
    DOUBLE_LIST(18, 2, zzvw.DOUBLE),
    FLOAT_LIST(19, 2, zzvw.FLOAT),
    INT64_LIST(20, 2, zzvw.LONG),
    UINT64_LIST(21, 2, zzvw.LONG),
    INT32_LIST(22, 2, zzvw.INT),
    FIXED64_LIST(23, 2, zzvw.LONG),
    FIXED32_LIST(24, 2, zzvw.INT),
    BOOL_LIST(25, 2, zzvw.BOOLEAN),
    STRING_LIST(26, 2, zzvw.STRING),
    MESSAGE_LIST(27, 2, zzvw.MESSAGE),
    BYTES_LIST(28, 2, zzvw.BYTE_STRING),
    UINT32_LIST(29, 2, zzvw.INT),
    ENUM_LIST(30, 2, zzvw.ENUM),
    SFIXED32_LIST(31, 2, zzvw.INT),
    SFIXED64_LIST(32, 2, zzvw.LONG),
    SINT32_LIST(33, 2, zzvw.INT),
    SINT64_LIST(34, 2, zzvw.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzvw.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzvw.FLOAT),
    INT64_LIST_PACKED(37, 3, zzvw.LONG),
    UINT64_LIST_PACKED(38, 3, zzvw.LONG),
    INT32_LIST_PACKED(39, 3, zzvw.INT),
    FIXED64_LIST_PACKED(40, 3, zzvw.LONG),
    FIXED32_LIST_PACKED(41, 3, zzvw.INT),
    BOOL_LIST_PACKED(42, 3, zzvw.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzvw.INT),
    ENUM_LIST_PACKED(44, 3, zzvw.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzvw.INT),
    SFIXED64_LIST_PACKED(46, 3, zzvw.LONG),
    SINT32_LIST_PACKED(47, 3, zzvw.INT),
    SINT64_LIST_PACKED(48, 3, zzvw.LONG),
    GROUP_LIST(49, 2, zzvw.MESSAGE),
    MAP(50, 4, zzvw.VOID);

    private static final zzve[] zzZ;
    private final zzvw zzab;
    private final int zzac;
    private final Class zzad;

    static {
        zzve[] zzveVarArrValues = values();
        zzZ = new zzve[zzveVarArrValues.length];
        for (zzve zzveVar : zzveVarArrValues) {
            zzZ[zzveVar.zzac] = zzveVar;
        }
    }

    zzve(int i, int i2, zzvw zzvwVar) {
        this.zzac = i;
        this.zzab = zzvwVar;
        int i3 = i2 - 1;
        if (i3 == 1 || i3 == 3) {
            this.zzad = zzvwVar.zza();
        } else {
            this.zzad = null;
        }
        if (i2 == 1) {
            zzvw zzvwVar2 = zzvw.VOID;
            zzvwVar.ordinal();
        }
    }

    public final int zza() {
        return this.zzac;
    }
}
