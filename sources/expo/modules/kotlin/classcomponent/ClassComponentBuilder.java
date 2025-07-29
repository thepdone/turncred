package expo.modules.kotlin.classcomponent;

import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.ConcatIterator;
import expo.modules.kotlin.functions.AnyFunction;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.objects.ObjectDefinitionBuilder;
import expo.modules.kotlin.objects.ObjectDefinitionData;
import expo.modules.kotlin.objects.PropertyComponentBuilderWithThis;
import expo.modules.kotlin.objects.PropertyComponentBuilderWithThis$get$1$1;
import expo.modules.kotlin.sharedobjects.SharedObject;
import expo.modules.kotlin.sharedobjects.SharedRef;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClasses;

/* compiled from: ClassComponentBuilder.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u0015\u001a\u00020\f2\u000e\b\u0004\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086\bø\u0001\u0000J9\u0010\u0015\u001a\u00020\f\"\u0006\b\u0001\u0010\u0018\u0018\u00012#\b\u0004\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\bø\u0001\u0000JV\u0010\u0015\u001a\u00020\f\"\u0006\b\u0001\u0010\u0018\u0018\u0001\"\u0006\b\u0002\u0010\u001c\u0018\u000128\b\u0004\u0010\u0016\u001a2\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00028\u00000\u001dH\u0086\bø\u0001\u0000Js\u0010\u0015\u001a\u00020\f\"\u0006\b\u0001\u0010\u0018\u0018\u0001\"\u0006\b\u0002\u0010\u001c\u0018\u0001\"\u0006\b\u0003\u0010\u001f\u0018\u00012M\b\u0004\u0010\u0016\u001aG\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(!\u0012\u0004\u0012\u00028\u00000 H\u0086\bø\u0001\u0000J\u0090\u0001\u0010\u0015\u001a\u00020\f\"\u0006\b\u0001\u0010\u0018\u0018\u0001\"\u0006\b\u0002\u0010\u001c\u0018\u0001\"\u0006\b\u0003\u0010\u001f\u0018\u0001\"\u0006\b\u0004\u0010\"\u0018\u00012b\b\u0004\u0010\u0016\u001a\\\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b($\u0012\u0004\u0012\u00028\u00000#H\u0086\bø\u0001\u0000J\u00ad\u0001\u0010\u0015\u001a\u00020\f\"\u0006\b\u0001\u0010\u0018\u0018\u0001\"\u0006\b\u0002\u0010\u001c\u0018\u0001\"\u0006\b\u0003\u0010\u001f\u0018\u0001\"\u0006\b\u0004\u0010\"\u0018\u0001\"\u0006\b\u0005\u0010%\u0018\u00012w\b\u0004\u0010\u0016\u001aq\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H%¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b('\u0012\u0004\u0012\u00028\u00000&H\u0086\bø\u0001\u0000JÌ\u0001\u0010\u0015\u001a\u00020\f\"\u0006\b\u0001\u0010\u0018\u0018\u0001\"\u0006\b\u0002\u0010\u001c\u0018\u0001\"\u0006\b\u0003\u0010\u001f\u0018\u0001\"\u0006\b\u0004\u0010\"\u0018\u0001\"\u0006\b\u0005\u0010%\u0018\u0001\"\u0006\b\u0006\u0010(\u0018\u00012\u008d\u0001\b\u0004\u0010\u0016\u001a\u0086\u0001\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H%¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b('\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(*\u0012\u0004\u0012\u00028\u00000)H\u0086\bø\u0001\u0000Jé\u0001\u0010\u0015\u001a\u00020\f\"\u0006\b\u0001\u0010\u0018\u0018\u0001\"\u0006\b\u0002\u0010\u001c\u0018\u0001\"\u0006\b\u0003\u0010\u001f\u0018\u0001\"\u0006\b\u0004\u0010\"\u0018\u0001\"\u0006\b\u0005\u0010%\u0018\u0001\"\u0006\b\u0006\u0010(\u0018\u0001\"\u0006\b\u0007\u0010+\u0018\u00012¢\u0001\b\u0004\u0010\u0016\u001a\u009b\u0001\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H%¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b('\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(*\u0012\u0013\u0012\u0011H+¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(-\u0012\u0004\u0012\u00028\u00000,H\u0086\bø\u0001\u0000J\u0086\u0002\u0010\u0015\u001a\u00020\f\"\u0006\b\u0001\u0010\u0018\u0018\u0001\"\u0006\b\u0002\u0010\u001c\u0018\u0001\"\u0006\b\u0003\u0010\u001f\u0018\u0001\"\u0006\b\u0004\u0010\"\u0018\u0001\"\u0006\b\u0005\u0010%\u0018\u0001\"\u0006\b\u0006\u0010(\u0018\u0001\"\u0006\b\u0007\u0010+\u0018\u0001\"\u0006\b\b\u0010.\u0018\u00012·\u0001\b\u0004\u0010\u0016\u001a°\u0001\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b($\u0012\u0013\u0012\u0011H%¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b('\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(*\u0012\u0013\u0012\u0011H+¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(-\u0012\u0013\u0012\u0011H.¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(0\u0012\u0004\u0012\u00028\u00000/H\u0086\bø\u0001\u0000J\u0016\u00101\u001a\b\u0012\u0004\u0012\u00028\u0000022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016JG\u00101\u001a\b\u0012\u0004\u0012\u00028\u000002\"\u0006\b\u0001\u00103\u0018\u00012\u0006\u0010\u0004\u001a\u00020\u00052#\b\u0004\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u0004\u0012\u0004\b\b(4\u0012\u0004\u0012\u0002H30\u0019H\u0086\bø\u0001\u0000J\u0006\u00105\u001a\u000206R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00067"}, d2 = {"Lexpo/modules/kotlin/classcomponent/ClassComponentBuilder;", "SharedObjectType", "", "Lexpo/modules/kotlin/objects/ObjectDefinitionBuilder;", "name", "", "ownerClass", "Lkotlin/reflect/KClass;", "ownerType", "Lexpo/modules/kotlin/types/AnyType;", "(Ljava/lang/String;Lkotlin/reflect/KClass;Lexpo/modules/kotlin/types/AnyType;)V", "constructor", "Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "getConstructor", "()Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "setConstructor", "(Lexpo/modules/kotlin/functions/SyncFunctionComponent;)V", "getName", "()Ljava/lang/String;", "getOwnerType", "()Lexpo/modules/kotlin/types/AnyType;", "Constructor", "body", "Lkotlin/Function0;", "P0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "p0", "P1", "Lkotlin/Function2;", "p1", "P2", "Lkotlin/Function3;", "p2", "P3", "Lkotlin/Function4;", "p3", "P4", "Lkotlin/Function5;", "p4", "P5", "Lkotlin/Function6;", "p5", "P6", "Lkotlin/Function7;", "p6", "P7", "Lkotlin/Function8;", "p7", "Property", "Lexpo/modules/kotlin/objects/PropertyComponentBuilderWithThis;", ExifInterface.GPS_DIRECTION_TRUE, "owner", "buildClass", "Lexpo/modules/kotlin/classcomponent/ClassDefinitionData;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassComponentBuilder<SharedObjectType> extends ObjectDefinitionBuilder {
    public static final int $stable = 8;
    private SyncFunctionComponent constructor;
    private final String name;
    private final KClass<SharedObjectType> ownerClass;
    private final AnyType ownerType;

    public final String getName() {
        return this.name;
    }

    public final AnyType getOwnerType() {
        return this.ownerType;
    }

    public ClassComponentBuilder(String name, KClass<SharedObjectType> ownerClass, AnyType ownerType) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(ownerClass, "ownerClass");
        Intrinsics.checkNotNullParameter(ownerType, "ownerType");
        this.name = name;
        this.ownerClass = ownerClass;
        this.ownerType = ownerType;
    }

    public final SyncFunctionComponent getConstructor() {
        return this.constructor;
    }

    public final void setConstructor(SyncFunctionComponent syncFunctionComponent) {
        this.constructor = syncFunctionComponent;
    }

    public final ClassDefinitionData buildClass() {
        boolean zAreEqual = Intrinsics.areEqual(this.ownerClass, Reflection.getOrCreateKotlinClass(Unit.class));
        boolean z = !zAreEqual && KClasses.isSubclassOf(this.ownerClass, Reflection.getOrCreateKotlinClass(SharedObject.class));
        boolean z2 = !zAreEqual && KClasses.isSubclassOf(this.ownerClass, Reflection.getOrCreateKotlinClass(SharedRef.class));
        if (getEventsDefinition() != null && z) {
            for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("__expo_onStartListeningToEvent", C04861.INSTANCE), TuplesKt.to("__expo_onStopListeningToEvent", AnonymousClass2.INSTANCE)})) {
                String str = (String) pair.component1();
                final KFunction kFunction = (KFunction) pair.component2();
                AnyType[] anyTypeArr = new AnyType[2];
                anyTypeArr[0] = this.ownerType;
                AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                if (anyType == null) {
                    anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$buildClass$lambda$1$$inlined$toAnyType$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                }
                anyTypeArr[1] = anyType;
                ReturnType returnType = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
                if (returnType == null) {
                    returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                    ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType);
                }
                SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, anyTypeArr, returnType, new Function1<Object[], Unit>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$buildClass$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        ((Function2) kFunction).invoke(objArr[0], objArr[1]);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr) {
                        invoke2(objArr);
                        return Unit.INSTANCE;
                    }
                });
                syncFunctionComponent.enumerable(false);
                getSyncFunctions().put(str, syncFunctionComponent);
            }
        }
        ObjectDefinitionData objectDefinitionDataBuildObject = buildObject();
        ConcatIterator<AnyFunction> functions = objectDefinitionDataBuildObject.getFunctions();
        while (functions.hasNext()) {
            AnyFunction next = functions.next();
            next.setOwnerType(this.ownerType.getKType());
            next.setCanTakeOwner(true);
        }
        if (!zAreEqual && this.constructor == null && !z2) {
            throw new IllegalArgumentException("constructor cannot be null");
        }
        SyncFunctionComponent syncFunctionComponent2 = this.constructor;
        if (syncFunctionComponent2 == null) {
            AnyType[] anyTypeArr2 = new AnyType[0];
            ReturnType returnType2 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType2 == null) {
                returnType2 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType2);
            }
            syncFunctionComponent2 = new SyncFunctionComponent("constructor", anyTypeArr2, returnType2, new Function1<Object[], Unit>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$buildClass$constructor$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr) {
                    invoke2(objArr);
                    return Unit.INSTANCE;
                }
            });
        }
        syncFunctionComponent2.setCanTakeOwner(true);
        syncFunctionComponent2.setOwnerType(this.ownerType.getKType());
        return new ClassDefinitionData(this.name, syncFunctionComponent2, objectDefinitionDataBuildObject, z2);
    }

    /* compiled from: ClassComponentBuilder.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: expo.modules.kotlin.classcomponent.ClassComponentBuilder$buildClass$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C04861 extends FunctionReferenceImpl implements Function2<SharedObject, String, Unit> {
        public static final C04861 INSTANCE = new C04861();

        C04861() {
            super(2, SharedObject.class, "onStartListeningToEvent", "onStartListeningToEvent(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(SharedObject sharedObject, String str) {
            invoke2(sharedObject, str);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SharedObject p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            p0.onStartListeningToEvent(p1);
        }
    }

    /* compiled from: ClassComponentBuilder.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: expo.modules.kotlin.classcomponent.ClassComponentBuilder$buildClass$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function2<SharedObject, String, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(2, SharedObject.class, "onStopListeningToEvent", "onStopListeningToEvent(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(SharedObject sharedObject, String str) {
            invoke2(sharedObject, str);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SharedObject p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            p0.onStopListeningToEvent(p1);
        }
    }

    public final SyncFunctionComponent Constructor(final Function0<? extends SharedObjectType> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        AnyType[] anyTypeArr = new AnyType[0];
        ReturnType returnType = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.Constructor.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return body.invoke();
            }
        });
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0> SyncFunctionComponent Constructor(final Function1<? super P0, ? extends SharedObjectType> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P0");
        AnyType[] anyTypeArr = new AnyType[1];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$1 classComponentBuilder$Constructor$$inlined$toArgsArray$default$1 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$1));
        }
        anyTypeArr[0] = anyType;
        ReturnType returnType = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.Constructor.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                return body.invoke(objArr[0]);
            }
        });
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1> SyncFunctionComponent Constructor(final Function2<? super P0, ? super P1, ? extends SharedObjectType> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        AnyType[] anyTypeArr = new AnyType[2];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$2 classComponentBuilder$Constructor$$inlined$toArgsArray$default$2 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$2));
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$3 classComponentBuilder$Constructor$$inlined$toArgsArray$default$3 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$3));
        }
        anyTypeArr[1] = anyType2;
        ReturnType returnType = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.Constructor.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                return body.invoke(objArr[0], objArr[1]);
            }
        });
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1, P2> SyncFunctionComponent Constructor(final Function3<? super P0, ? super P1, ? super P2, ? extends SharedObjectType> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        AnyType[] anyTypeArr = new AnyType[3];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$4 classComponentBuilder$Constructor$$inlined$toArgsArray$default$4 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$4));
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$5 classComponentBuilder$Constructor$$inlined$toArgsArray$default$5 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$5));
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$6 classComponentBuilder$Constructor$$inlined$toArgsArray$default$6 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$6));
        }
        anyTypeArr[2] = anyType3;
        ReturnType returnType = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.Constructor.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                return body.invoke(objArr[0], objArr[1], objArr[2]);
            }
        });
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1, P2, P3> SyncFunctionComponent Constructor(final Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends SharedObjectType> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        AnyType[] anyTypeArr = new AnyType[4];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$7 classComponentBuilder$Constructor$$inlined$toArgsArray$default$7 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$7));
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$8 classComponentBuilder$Constructor$$inlined$toArgsArray$default$8 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$8));
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$9 classComponentBuilder$Constructor$$inlined$toArgsArray$default$9 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$9));
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$10 classComponentBuilder$Constructor$$inlined$toArgsArray$default$10 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$10));
        }
        anyTypeArr[3] = anyType4;
        ReturnType returnType = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.Constructor.9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                return body.invoke(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
        });
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1, P2, P3, P4> SyncFunctionComponent Constructor(final Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends SharedObjectType> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        AnyType[] anyTypeArr = new AnyType[5];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$11 classComponentBuilder$Constructor$$inlined$toArgsArray$default$11 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$11));
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$12 classComponentBuilder$Constructor$$inlined$toArgsArray$default$12 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$12
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$12));
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$13 classComponentBuilder$Constructor$$inlined$toArgsArray$default$13 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$13
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$13));
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$14 classComponentBuilder$Constructor$$inlined$toArgsArray$default$14 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$14));
        }
        anyTypeArr[3] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$15 classComponentBuilder$Constructor$$inlined$toArgsArray$default$15 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$15
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$15));
        }
        anyTypeArr[4] = anyType5;
        ReturnType returnType = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.Constructor.11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                return body.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            }
        });
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1, P2, P3, P4, P5> SyncFunctionComponent Constructor(final Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends SharedObjectType> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        Intrinsics.reifiedOperationMarker(4, "P5");
        AnyType[] anyTypeArr = new AnyType[6];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$16 classComponentBuilder$Constructor$$inlined$toArgsArray$default$16 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$16
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$16));
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$17 classComponentBuilder$Constructor$$inlined$toArgsArray$default$17 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$17
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$17));
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$18 classComponentBuilder$Constructor$$inlined$toArgsArray$default$18 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$18
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$18));
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$19 classComponentBuilder$Constructor$$inlined$toArgsArray$default$19 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$19
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$19));
        }
        anyTypeArr[3] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$20 classComponentBuilder$Constructor$$inlined$toArgsArray$default$20 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$20
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$20));
        }
        anyTypeArr[4] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$21 classComponentBuilder$Constructor$$inlined$toArgsArray$default$21 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$21
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$21));
        }
        anyTypeArr[5] = anyType6;
        ReturnType returnType = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.Constructor.13
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                return body.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
            }
        });
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1, P2, P3, P4, P5, P6> SyncFunctionComponent Constructor(final Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends SharedObjectType> body) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        Intrinsics.reifiedOperationMarker(4, "P5");
        Intrinsics.reifiedOperationMarker(4, "P6");
        AnyType[] anyTypeArr = new AnyType[7];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$22 classComponentBuilder$Constructor$$inlined$toArgsArray$default$22 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$22
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$22));
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$23 classComponentBuilder$Constructor$$inlined$toArgsArray$default$23 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$23
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$23));
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$24 classComponentBuilder$Constructor$$inlined$toArgsArray$default$24 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$24
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$24));
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$25 classComponentBuilder$Constructor$$inlined$toArgsArray$default$25 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$25
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            i = 3;
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$25));
        } else {
            i = 3;
        }
        anyTypeArr[i] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(i, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$26 classComponentBuilder$Constructor$$inlined$toArgsArray$default$26 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$26
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            i2 = 4;
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$26));
        } else {
            i2 = 4;
        }
        anyTypeArr[i2] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(i2, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$27 classComponentBuilder$Constructor$$inlined$toArgsArray$default$27 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$27
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$27));
        }
        anyTypeArr[5] = anyType6;
        AnyTypeProvider anyTypeProvider7 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeProvider7.getTypesMap().get(new Pair(orCreateKotlinClass13, false));
        if (anyType7 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$28 classComponentBuilder$Constructor$$inlined$toArgsArray$default$28 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$28
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            anyType7 = new AnyType(new LazyKType(orCreateKotlinClass14, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$28));
        }
        anyTypeArr[6] = anyType7;
        ReturnType returnType = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.Constructor.15
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                return body.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
            }
        });
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v1 expo.modules.kotlin.functions.SyncFunctionComponent, still in use, count: 2, list:
          (r1v1 expo.modules.kotlin.functions.SyncFunctionComponent) from 0x00a0: MOVE (r16v0 expo.modules.kotlin.functions.SyncFunctionComponent) = (r1v1 expo.modules.kotlin.functions.SyncFunctionComponent)
          (r1v1 expo.modules.kotlin.functions.SyncFunctionComponent) from 0x0090: MOVE (r16v2 expo.modules.kotlin.functions.SyncFunctionComponent) = (r1v1 expo.modules.kotlin.functions.SyncFunctionComponent)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    public final /* synthetic */ <P0, P1, P2, P3, P4, P5, P6, P7> expo.modules.kotlin.functions.SyncFunctionComponent Constructor(final kotlin.jvm.functions.Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends SharedObjectType> r18) {
        /*
            Method dump skipped, instructions count: 755
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.classcomponent.ClassComponentBuilder.Constructor(kotlin.jvm.functions.Function8):expo.modules.kotlin.functions.SyncFunctionComponent");
    }

    public final /* synthetic */ <T> PropertyComponentBuilderWithThis<SharedObjectType> Property(String name, Function1<? super SharedObjectType, ? extends T> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        PropertyComponentBuilderWithThis<SharedObjectType> propertyComponentBuilderWithThis = new PropertyComponentBuilderWithThis<>(getOwnerType().getKType(), name);
        AnyType[] anyTypeArr = {new AnyType(propertyComponentBuilderWithThis.getThisType())};
        Map<KClass<?>, ReturnType> types = ReturnTypeProvider.INSTANCE.getTypes();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        ReturnType returnType = types.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            Map<KClass<?>, ReturnType> types2 = ReturnTypeProvider.INSTANCE.getTypes();
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            types2.put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("get", anyTypeArr, returnType, new PropertyComponentBuilderWithThis$get$1$1(body));
        syncFunctionComponent.setOwnerType(propertyComponentBuilderWithThis.getThisType());
        syncFunctionComponent.setCanTakeOwner(true);
        propertyComponentBuilderWithThis.setGetter(syncFunctionComponent);
        getProperties().put(name, propertyComponentBuilderWithThis);
        return propertyComponentBuilderWithThis;
    }

    @Override // expo.modules.kotlin.objects.ObjectDefinitionBuilder
    public PropertyComponentBuilderWithThis<SharedObjectType> Property(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        PropertyComponentBuilderWithThis<SharedObjectType> propertyComponentBuilderWithThis = new PropertyComponentBuilderWithThis<>(this.ownerType.getKType(), name);
        getProperties().put(name, propertyComponentBuilderWithThis);
        return propertyComponentBuilderWithThis;
    }
}
