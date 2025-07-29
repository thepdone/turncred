package expo.modules.kotlin.sharedobjects;

import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.IncorrectRefTypeException;
import expo.modules.kotlin.exception.InvalidSharedObjectTypeException;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.sharedobjects.SharedRef;
import expo.modules.kotlin.types.NullAwareTypeConverter;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.full.KClasses;

/* compiled from: SharedObjectTypeConverter.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00022\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002J\u001f\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001b"}, d2 = {"Lexpo/modules/kotlin/sharedobjects/SharedRefTypeConverter;", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/sharedobjects/SharedRef;", "Lexpo/modules/kotlin/types/NullAwareTypeConverter;", "type", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KType;)V", "sharedObjectTypeConverter", "Lexpo/modules/kotlin/sharedobjects/SharedObjectTypeConverter;", "sharedRefType", "getSharedRefType", "()Lkotlin/reflect/KType;", "sharedRefType$delegate", "Lkotlin/Lazy;", "getType", "checkInnerRef", "sharedRef", "convertNonOptional", "value", "", "context", "Lexpo/modules/kotlin/AppContext;", "(Ljava/lang/Object;Lexpo/modules/kotlin/AppContext;)Lexpo/modules/kotlin/sharedobjects/SharedRef;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SharedRefTypeConverter<T extends SharedRef<?>> extends NullAwareTypeConverter<T> {
    public static final int $stable = 8;
    private final SharedObjectTypeConverter<T> sharedObjectTypeConverter;

    /* renamed from: sharedRefType$delegate, reason: from kotlin metadata */
    private final Lazy sharedRefType;
    private final KType type;

    public final KType getType() {
        return this.type;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedRefTypeConverter(KType type) {
        super(type.getIsMarkedNullable());
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.sharedObjectTypeConverter = new SharedObjectTypeConverter<>(type);
        this.sharedRefType = LazyKt.lazy(new Function0<KType>(this) { // from class: expo.modules.kotlin.sharedobjects.SharedRefTypeConverter$sharedRefType$2
            final /* synthetic */ SharedRefTypeConverter<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final KType invoke() {
                List<KTypeProjection> arguments;
                KClassifier classifier = this.this$0.getType().getClassifier();
                KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
                KType type2 = this.this$0.getType();
                while (kClass != null) {
                    if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(SharedRef.class))) {
                        KTypeProjection kTypeProjection = (type2 == null || (arguments = type2.getArguments()) == null) ? null : (KTypeProjection) CollectionsKt.first((List) arguments);
                        if (Intrinsics.areEqual(kTypeProjection, KTypeProjection.INSTANCE.getSTAR())) {
                            return null;
                        }
                        KType type3 = kTypeProjection != null ? kTypeProjection.getType() : null;
                        SharedRefTypeConverter<T> sharedRefTypeConverter = this.this$0;
                        if (type3 != null) {
                            return type3;
                        }
                        throw new IllegalArgumentException(("The " + sharedRefTypeConverter.getSharedRefType() + " type should contain the type of the inner ref").toString());
                    }
                    type2 = (KType) CollectionsKt.firstOrNull((List) kClass.getSupertypes());
                    KClassifier classifier2 = type2 != null ? type2.getClassifier() : null;
                    kClass = classifier2 instanceof KClass ? (KClass) classifier2 : null;
                }
                return null;
            }
        });
    }

    public final KType getSharedRefType() {
        return (KType) this.sharedRefType.getValue();
    }

    @Override // expo.modules.kotlin.types.NullAwareTypeConverter
    public T convertNonOptional(Object value, AppContext context) throws InvalidSharedObjectTypeException {
        Intrinsics.checkNotNullParameter(value, "value");
        T tConvert = this.sharedObjectTypeConverter.convert(value, context);
        if (tConvert == null) {
            throw new InvalidSharedObjectTypeException(this.type);
        }
        T t = (T) checkInnerRef(tConvert);
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of expo.modules.kotlin.sharedobjects.SharedRefTypeConverter");
        return t;
    }

    private final SharedRef<?> checkInnerRef(SharedRef<?> sharedRef) throws IncorrectRefTypeException {
        Object ref = sharedRef.getRef();
        if (ref == null) {
            return sharedRef;
        }
        KType sharedRefType = getSharedRefType();
        KClassifier classifier = sharedRefType != null ? sharedRefType.getClassifier() : null;
        KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
        if (kClass == null || KClasses.isSuperclassOf(kClass, JvmClassMappingKt.getKotlinClass(ref.getClass()))) {
            return sharedRef;
        }
        throw new IncorrectRefTypeException(this.type, sharedRef.getClass());
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    /* renamed from: getCppRequiredTypes */
    public ExpectedType get$cppRequireType() {
        return this.sharedObjectTypeConverter.get$cppRequireType();
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return this.sharedObjectTypeConverter.isTrivial();
    }
}
