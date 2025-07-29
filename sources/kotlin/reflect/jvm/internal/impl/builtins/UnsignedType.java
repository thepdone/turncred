package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: UnsignedType.kt */
/* loaded from: classes5.dex */
public final class UnsignedType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UnsignedType[] $VALUES;
    public static final UnsignedType UBYTE;
    public static final UnsignedType UINT;
    public static final UnsignedType ULONG;
    public static final UnsignedType USHORT;
    private final ClassId arrayClassId;
    private final ClassId classId;
    private final Name typeName;

    private static final /* synthetic */ UnsignedType[] $values() {
        return new UnsignedType[]{UBYTE, USHORT, UINT, ULONG};
    }

    public static UnsignedType valueOf(String str) {
        return (UnsignedType) Enum.valueOf(UnsignedType.class, str);
    }

    public static UnsignedType[] values() {
        return (UnsignedType[]) $VALUES.clone();
    }

    private UnsignedType(String str, int i, ClassId classId) {
        this.classId = classId;
        Name shortClassName = classId.getShortClassName();
        Intrinsics.checkNotNullExpressionValue(shortClassName, "getShortClassName(...)");
        this.typeName = shortClassName;
        this.arrayClassId = new ClassId(classId.getPackageFqName(), Name.identifier(shortClassName.asString() + "Array"));
    }

    public final ClassId getClassId() {
        return this.classId;
    }

    static {
        ClassId classIdFromString = ClassId.fromString("kotlin/UByte");
        Intrinsics.checkNotNullExpressionValue(classIdFromString, "fromString(...)");
        UBYTE = new UnsignedType("UBYTE", 0, classIdFromString);
        ClassId classIdFromString2 = ClassId.fromString("kotlin/UShort");
        Intrinsics.checkNotNullExpressionValue(classIdFromString2, "fromString(...)");
        USHORT = new UnsignedType("USHORT", 1, classIdFromString2);
        ClassId classIdFromString3 = ClassId.fromString("kotlin/UInt");
        Intrinsics.checkNotNullExpressionValue(classIdFromString3, "fromString(...)");
        UINT = new UnsignedType("UINT", 2, classIdFromString3);
        ClassId classIdFromString4 = ClassId.fromString("kotlin/ULong");
        Intrinsics.checkNotNullExpressionValue(classIdFromString4, "fromString(...)");
        ULONG = new UnsignedType("ULONG", 3, classIdFromString4);
        UnsignedType[] unsignedTypeArr$values = $values();
        $VALUES = unsignedTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(unsignedTypeArr$values);
    }

    public final Name getTypeName() {
        return this.typeName;
    }

    public final ClassId getArrayClassId() {
        return this.arrayClassId;
    }
}
