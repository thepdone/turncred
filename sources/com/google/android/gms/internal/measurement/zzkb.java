package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.2.0 */
/* loaded from: classes3.dex */
public enum zzkb {
    DOUBLE(0, zzkd.SCALAR, zzkr.DOUBLE),
    FLOAT(1, zzkd.SCALAR, zzkr.FLOAT),
    INT64(2, zzkd.SCALAR, zzkr.LONG),
    UINT64(3, zzkd.SCALAR, zzkr.LONG),
    INT32(4, zzkd.SCALAR, zzkr.INT),
    FIXED64(5, zzkd.SCALAR, zzkr.LONG),
    FIXED32(6, zzkd.SCALAR, zzkr.INT),
    BOOL(7, zzkd.SCALAR, zzkr.BOOLEAN),
    STRING(8, zzkd.SCALAR, zzkr.STRING),
    MESSAGE(9, zzkd.SCALAR, zzkr.MESSAGE),
    BYTES(10, zzkd.SCALAR, zzkr.BYTE_STRING),
    UINT32(11, zzkd.SCALAR, zzkr.INT),
    ENUM(12, zzkd.SCALAR, zzkr.ENUM),
    SFIXED32(13, zzkd.SCALAR, zzkr.INT),
    SFIXED64(14, zzkd.SCALAR, zzkr.LONG),
    SINT32(15, zzkd.SCALAR, zzkr.INT),
    SINT64(16, zzkd.SCALAR, zzkr.LONG),
    GROUP(17, zzkd.SCALAR, zzkr.MESSAGE),
    DOUBLE_LIST(18, zzkd.VECTOR, zzkr.DOUBLE),
    FLOAT_LIST(19, zzkd.VECTOR, zzkr.FLOAT),
    INT64_LIST(20, zzkd.VECTOR, zzkr.LONG),
    UINT64_LIST(21, zzkd.VECTOR, zzkr.LONG),
    INT32_LIST(22, zzkd.VECTOR, zzkr.INT),
    FIXED64_LIST(23, zzkd.VECTOR, zzkr.LONG),
    FIXED32_LIST(24, zzkd.VECTOR, zzkr.INT),
    BOOL_LIST(25, zzkd.VECTOR, zzkr.BOOLEAN),
    STRING_LIST(26, zzkd.VECTOR, zzkr.STRING),
    MESSAGE_LIST(27, zzkd.VECTOR, zzkr.MESSAGE),
    BYTES_LIST(28, zzkd.VECTOR, zzkr.BYTE_STRING),
    UINT32_LIST(29, zzkd.VECTOR, zzkr.INT),
    ENUM_LIST(30, zzkd.VECTOR, zzkr.ENUM),
    SFIXED32_LIST(31, zzkd.VECTOR, zzkr.INT),
    SFIXED64_LIST(32, zzkd.VECTOR, zzkr.LONG),
    SINT32_LIST(33, zzkd.VECTOR, zzkr.INT),
    SINT64_LIST(34, zzkd.VECTOR, zzkr.LONG),
    DOUBLE_LIST_PACKED(35, zzkd.PACKED_VECTOR, zzkr.DOUBLE),
    FLOAT_LIST_PACKED(36, zzkd.PACKED_VECTOR, zzkr.FLOAT),
    INT64_LIST_PACKED(37, zzkd.PACKED_VECTOR, zzkr.LONG),
    UINT64_LIST_PACKED(38, zzkd.PACKED_VECTOR, zzkr.LONG),
    INT32_LIST_PACKED(39, zzkd.PACKED_VECTOR, zzkr.INT),
    FIXED64_LIST_PACKED(40, zzkd.PACKED_VECTOR, zzkr.LONG),
    FIXED32_LIST_PACKED(41, zzkd.PACKED_VECTOR, zzkr.INT),
    BOOL_LIST_PACKED(42, zzkd.PACKED_VECTOR, zzkr.BOOLEAN),
    UINT32_LIST_PACKED(43, zzkd.PACKED_VECTOR, zzkr.INT),
    ENUM_LIST_PACKED(44, zzkd.PACKED_VECTOR, zzkr.ENUM),
    SFIXED32_LIST_PACKED(45, zzkd.PACKED_VECTOR, zzkr.INT),
    SFIXED64_LIST_PACKED(46, zzkd.PACKED_VECTOR, zzkr.LONG),
    SINT32_LIST_PACKED(47, zzkd.PACKED_VECTOR, zzkr.INT),
    SINT64_LIST_PACKED(48, zzkd.PACKED_VECTOR, zzkr.LONG),
    GROUP_LIST(49, zzkd.VECTOR, zzkr.MESSAGE),
    MAP(50, zzkd.MAP, zzkr.VOID);

    private static final zzkb[] zzaz;
    private final int zzbb;

    public final int zza() {
        return this.zzbb;
    }

    static {
        zzkb[] zzkbVarArrValues = values();
        zzaz = new zzkb[zzkbVarArrValues.length];
        for (zzkb zzkbVar : zzkbVarArrValues) {
            zzaz[zzkbVar.zzbb] = zzkbVar;
        }
    }

    zzkb(int i, zzkd zzkdVar, zzkr zzkrVar) {
        this.zzbb = i;
        int iOrdinal = zzkdVar.ordinal();
        if (iOrdinal == 1 || iOrdinal == 3) {
            zzkrVar.zza();
        }
        if (zzkdVar == zzkd.SCALAR) {
            int i2 = zzka.zza[zzkrVar.ordinal()];
        }
    }
}
