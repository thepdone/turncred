package expo.modules.kotlin.jni;

import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

/* compiled from: ExpectedType.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001b\b\u0016\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\u0012\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0003\"\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\nH\u0007J\b\u0010\r\u001a\u00020\u0007H\u0007J\u0015\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0003H\u0007¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000H\u0086\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0013"}, d2 = {"Lexpo/modules/kotlin/jni/ExpectedType;", "", "expectedTypes", "", "Lexpo/modules/kotlin/jni/CppType;", "([Lexpo/modules/kotlin/jni/CppType;)V", "innerPossibleTypes", "Lexpo/modules/kotlin/jni/SingleType;", "([Lexpo/modules/kotlin/jni/SingleType;)V", "innerCombinedTypes", "", "[Lexpo/modules/kotlin/jni/SingleType;", "getCombinedTypes", "getFirstType", "getPossibleTypes", "()[Lexpo/modules/kotlin/jni/SingleType;", "plus", "other", "Companion", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExpectedType {
    private final int innerCombinedTypes;
    private final SingleType[] innerPossibleTypes;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public ExpectedType(SingleType... innerPossibleTypes) {
        Intrinsics.checkNotNullParameter(innerPossibleTypes, "innerPossibleTypes");
        this.innerPossibleTypes = innerPossibleTypes;
        int cppType = 0;
        for (SingleType singleType : innerPossibleTypes) {
            cppType |= singleType.getCppType();
        }
        this.innerCombinedTypes = cppType;
    }

    /* renamed from: getCombinedTypes, reason: from getter */
    public final int getInnerCombinedTypes() {
        return this.innerCombinedTypes;
    }

    /* renamed from: getPossibleTypes, reason: from getter */
    public final SingleType[] getInnerPossibleTypes() {
        return this.innerPossibleTypes;
    }

    public final SingleType getFirstType() {
        return (SingleType) ArraysKt.first(this.innerPossibleTypes);
    }

    public final ExpectedType plus(ExpectedType other) {
        Intrinsics.checkNotNullParameter(other, "other");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.addSpread(this.innerPossibleTypes);
        spreadBuilder.addSpread(other.innerPossibleTypes);
        return new ExpectedType((SingleType[]) spreadBuilder.toArray(new SingleType[spreadBuilder.size()]));
    }

    /* compiled from: ExpectedType.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¨\u0006\u000b"}, d2 = {"Lexpo/modules/kotlin/jni/ExpectedType$Companion;", "", "()V", "forEnum", "Lexpo/modules/kotlin/jni/ExpectedType;", "forList", "parameterType", "Lexpo/modules/kotlin/jni/CppType;", "forMap", "valueType", "forPrimitiveArray", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ExpectedType forPrimitiveArray(CppType parameterType) {
            Intrinsics.checkNotNullParameter(parameterType, "parameterType");
            return new ExpectedType(new SingleType(CppType.PRIMITIVE_ARRAY, new ExpectedType[]{new ExpectedType(parameterType)}));
        }

        public final ExpectedType forPrimitiveArray(ExpectedType parameterType) {
            Intrinsics.checkNotNullParameter(parameterType, "parameterType");
            return new ExpectedType(new SingleType(CppType.PRIMITIVE_ARRAY, new ExpectedType[]{parameterType}));
        }

        public final ExpectedType forEnum() {
            return new ExpectedType(CppType.STRING, CppType.INT);
        }

        public final ExpectedType forList(CppType parameterType) {
            Intrinsics.checkNotNullParameter(parameterType, "parameterType");
            return new ExpectedType(new SingleType(CppType.LIST, new ExpectedType[]{new ExpectedType(parameterType)}));
        }

        public final ExpectedType forList(ExpectedType parameterType) {
            Intrinsics.checkNotNullParameter(parameterType, "parameterType");
            return new ExpectedType(new SingleType(CppType.LIST, new ExpectedType[]{parameterType}));
        }

        public final ExpectedType forMap(CppType valueType) {
            Intrinsics.checkNotNullParameter(valueType, "valueType");
            return new ExpectedType(new SingleType(CppType.MAP, new ExpectedType[]{new ExpectedType(valueType)}));
        }

        public final ExpectedType forMap(ExpectedType valueType) {
            Intrinsics.checkNotNullParameter(valueType, "valueType");
            return new ExpectedType(new SingleType(CppType.MAP, new ExpectedType[]{valueType}));
        }
    }

    public ExpectedType(CppType... expectedTypes) {
        Intrinsics.checkNotNullParameter(expectedTypes, "expectedTypes");
        ArrayList arrayList = new ArrayList(expectedTypes.length);
        for (CppType cppType : expectedTypes) {
            arrayList.add(new SingleType(cppType, null, 2, 0 == true ? 1 : 0));
        }
        SingleType[] singleTypeArr = (SingleType[]) arrayList.toArray(new SingleType[0]);
        this((SingleType[]) Arrays.copyOf(singleTypeArr, singleTypeArr.length));
    }
}
