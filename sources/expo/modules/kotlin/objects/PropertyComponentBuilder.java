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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: PropertyComponentBuilder.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\u0011J$\u0010\u0012\u001a\u00020\u0000\"\u0006\b\u0000\u0010\u0013\u0018\u00012\u000e\b\u0004\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0015H\u0086\bø\u0001\u0000J9\u0010\u0016\u001a\u00020\u0000\"\u0006\b\u0000\u0010\u0017\u0018\u00012#\b\u0004\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u0011H\u0017¢\u0006\f\b\u0019\u0012\b\b\u0002\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0018H\u0086\bø\u0001\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001c"}, d2 = {"Lexpo/modules/kotlin/objects/PropertyComponentBuilder;", "", "name", "", "(Ljava/lang/String;)V", "getter", "Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "getGetter", "()Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "setGetter", "(Lexpo/modules/kotlin/functions/SyncFunctionComponent;)V", "getName", "()Ljava/lang/String;", "setter", "getSetter", "setSetter", "build", "Lexpo/modules/kotlin/objects/PropertyComponent;", "get", "R", "body", "Lkotlin/Function0;", "set", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "newValue", "", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class PropertyComponentBuilder {
    public static final int $stable = 8;
    private SyncFunctionComponent getter;
    private final String name;
    private SyncFunctionComponent setter;

    public PropertyComponentBuilder(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    public final String getName() {
        return this.name;
    }

    public final SyncFunctionComponent getGetter() {
        return this.getter;
    }

    public final void setGetter(SyncFunctionComponent syncFunctionComponent) {
        this.getter = syncFunctionComponent;
    }

    public final SyncFunctionComponent getSetter() {
        return this.setter;
    }

    public final void setSetter(SyncFunctionComponent syncFunctionComponent) {
        this.setter = syncFunctionComponent;
    }

    public final /* synthetic */ <R> PropertyComponentBuilder get(Function0<? extends R> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        AnyType[] anyTypeArr = new AnyType[0];
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
        setGetter(new SyncFunctionComponent("get", anyTypeArr, returnType, new PropertyComponentBuilder$get$1$1(body)));
        return this;
    }

    public final /* synthetic */ <T> PropertyComponentBuilder set(final Function1<? super T, Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        AnyType[] anyTypeArr = new AnyType[1];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            Intrinsics.needClassReification();
            PropertyComponentBuilder$set$$inlined$apply$lambda$1 propertyComponentBuilder$set$$inlined$apply$lambda$1 = new Function0<KType>() { // from class: expo.modules.kotlin.objects.PropertyComponentBuilder$set$$inlined$apply$lambda$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, propertyComponentBuilder$set$$inlined$apply$lambda$1));
        }
        anyTypeArr[0] = anyType;
        ReturnType returnType = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
        if (returnType == null) {
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
            ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType);
        }
        Intrinsics.needClassReification();
        setSetter(new SyncFunctionComponent("set", anyTypeArr, returnType, new Function1<Object[], Unit>() { // from class: expo.modules.kotlin.objects.PropertyComponentBuilder$set$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr) {
                invoke2(objArr);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function1<T, Unit> function1 = body;
                Object obj = it[0];
                Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                function1.invoke(obj);
            }
        }));
        return this;
    }

    public final PropertyComponent build() {
        return new PropertyComponent(this.name, this.getter, this.setter);
    }
}
