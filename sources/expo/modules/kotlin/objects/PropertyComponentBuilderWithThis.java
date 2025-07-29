package expo.modules.kotlin.objects;

import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: PropertyComponentBuilder.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J0\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0006\b\u0001\u0010\u000b\u0018\u00012\u0014\b\u0004\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u000b0\rH\u0086\bø\u0001\u0000JT\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0006\b\u0001\u0010\u000f\u0018\u000128\b\u0004\u0010\f\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0011\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0011\u0012\b\b\u0005\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u0010H\u0086\bø\u0001\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"Lexpo/modules/kotlin/objects/PropertyComponentBuilderWithThis;", "ThisType", "Lexpo/modules/kotlin/objects/PropertyComponentBuilder;", "thisType", "Lkotlin/reflect/KType;", "name", "", "(Lkotlin/reflect/KType;Ljava/lang/String;)V", "getThisType", "()Lkotlin/reflect/KType;", "get", "R", "body", "Lkotlin/Function1;", "set", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "self", "newValue", "", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PropertyComponentBuilderWithThis<ThisType> extends PropertyComponentBuilder {
    public static final int $stable = 8;
    private final KType thisType;

    public final KType getThisType() {
        return this.thisType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PropertyComponentBuilderWithThis(KType thisType, String name) {
        super(name);
        Intrinsics.checkNotNullParameter(thisType, "thisType");
        Intrinsics.checkNotNullParameter(name, "name");
        this.thisType = thisType;
    }

    public final /* synthetic */ <R> PropertyComponentBuilderWithThis<ThisType> get(Function1<? super ThisType, ? extends R> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        AnyType[] anyTypeArr = {new AnyType(getThisType())};
        Map<KClass<?>, ReturnType> types = ReturnTypeProvider.INSTANCE.getTypes();
        Intrinsics.reifiedOperationMarker(4, "R");
        ReturnType returnType = types.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            Intrinsics.reifiedOperationMarker(4, "R");
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            Map<KClass<?>, ReturnType> types2 = ReturnTypeProvider.INSTANCE.getTypes();
            Intrinsics.reifiedOperationMarker(4, "R");
            types2.put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("get", anyTypeArr, returnType, new PropertyComponentBuilderWithThis$get$1$1(body));
        syncFunctionComponent.setOwnerType(getThisType());
        syncFunctionComponent.setCanTakeOwner(true);
        setGetter(syncFunctionComponent);
        return this;
    }

    public final /* synthetic */ <T> PropertyComponentBuilderWithThis<ThisType> set(final Function2<? super ThisType, ? super T, Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        AnyType[] anyTypeArr = new AnyType[2];
        anyTypeArr[0] = new AnyType(getThisType());
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            Intrinsics.needClassReification();
            PropertyComponentBuilderWithThis$set$$inlined$apply$lambda$1 propertyComponentBuilderWithThis$set$$inlined$apply$lambda$1 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.PropertyComponentBuilderWithThis$set$$inlined$apply$lambda$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, propertyComponentBuilderWithThis$set$$inlined$apply$lambda$1));
        }
        anyTypeArr[1] = anyType;
        ReturnType returnType = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
        if (returnType == null) {
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
            ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType);
        }
        Intrinsics.needClassReification();
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("set", anyTypeArr, returnType, new Function1<Object[], Unit>() { // from class: expo.modules.kotlin.objects.PropertyComponentBuilderWithThis$set$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function2<ThisType, T, Unit> function2 = body;
                Object obj = it[0];
                Object obj2 = it[1];
                Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                function2.invoke(obj, obj2);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr) {
                invoke2(objArr);
                return Unit.INSTANCE;
            }
        });
        syncFunctionComponent.setOwnerType(getThisType());
        syncFunctionComponent.setCanTakeOwner(true);
        setSetter(syncFunctionComponent);
        return this;
    }
}
