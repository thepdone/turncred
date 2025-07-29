package expo.modules.kotlin.defaultmodules;

import android.app.Activity;
import androidx.tracing.Trace;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactDelegate;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.KModuleEventEmitterWrapperKt;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeProvider;
import expo.modules.kotlin.uuidv5.InvalidNamespaceException;
import expo.modules.kotlin.uuidv5.Uuidv5Kt;
import expo.modules.kotlin.views.CallbacksDefinition;
import expo.modules.kotlin.views.ViewManagerDefinition;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KType;

/* compiled from: CoreModule.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lexpo/modules/kotlin/defaultmodules/CoreModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CoreModule extends Module {
    public static final int $stable = 0;

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        CoreModule coreModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (coreModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(coreModule);
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[0];
            ReturnType returnType = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
            if (returnType == null) {
                returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
            }
            moduleDefinitionBuilder2.getSyncFunctions().put("uuidv4", new SyncFunctionComponent("uuidv4", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$6$$inlined$FunctionWithoutArgs$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return UUID.randomUUID().toString();
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr2 = new AnyType[2];
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$6$$inlined$Function$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr2[0] = anyType;
            AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$6$$inlined$Function$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr2[1] = anyType2;
            ReturnType returnType2 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(String.class));
            if (returnType2 == null) {
                returnType2 = new ReturnType(Reflection.getOrCreateKotlinClass(String.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(String.class), returnType2);
            }
            moduleDefinitionBuilder3.getSyncFunctions().put("uuidv5", new SyncFunctionComponent("uuidv5", anyTypeArr2, returnType2, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$6$$inlined$Function$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) throws InvalidNamespaceException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    String str = (String) objArr[1];
                    String str2 = (String) obj;
                    try {
                        UUID uuidFromString = UUID.fromString(str);
                        Intrinsics.checkNotNull(uuidFromString);
                        return Uuidv5Kt.uuidv5(uuidFromString, str2).toString();
                    } catch (IllegalArgumentException unused) {
                        throw new InvalidNamespaceException(str);
                    }
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr3 = new AnyType[1];
            AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType3 == null) {
                anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$6$$inlined$Function$4
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr3[0] = anyType3;
            ReturnType returnType3 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Map.class));
            if (returnType3 == null) {
                returnType3 = new ReturnType(Reflection.getOrCreateKotlinClass(Map.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Map.class), returnType3);
            }
            moduleDefinitionBuilder4.getSyncFunctions().put("getViewConfig", new SyncFunctionComponent("getViewConfig", anyTypeArr3, returnType3, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$6$$inlined$Function$5
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    ViewManagerDefinition viewManagerDefinition;
                    String[] names;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    ModuleHolder<?> moduleHolder = this.this$0.getRuntimeContext().getRegistry().getModuleHolder((String) objArr[0]);
                    LinkedHashMap linkedHashMap = null;
                    if (moduleHolder == null || (viewManagerDefinition = moduleHolder.getDefinition().getViewManagerDefinition()) == null) {
                        return null;
                    }
                    Set<String> setKeySet = viewManagerDefinition.getProps$expo_modules_core_release().keySet();
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setKeySet, 10)), 16));
                    for (Object obj : setKeySet) {
                        linkedHashMap2.put(obj, true);
                    }
                    LinkedHashMap linkedHashMap3 = linkedHashMap2;
                    CallbacksDefinition callbacksDefinition = viewManagerDefinition.getCallbacksDefinition();
                    if (callbacksDefinition != null && (names = callbacksDefinition.getNames()) != null) {
                        linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(names.length), 16));
                        for (String str : names) {
                            Pair pair = TuplesKt.to(KModuleEventEmitterWrapperKt.normalizeEventName(str), MapsKt.mapOf(TuplesKt.to("registrationName", str)));
                            linkedHashMap.put(pair.getFirst(), pair.getSecond());
                        }
                    }
                    return MapsKt.mapOf(TuplesKt.to("validAttributes", linkedHashMap3), TuplesKt.to("directEventTypes", linkedHashMap));
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("reloadAppAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$6$$inlined$AsyncFunction$1
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws Exceptions.MissingActivity {
                        ReactDelegate reactDelegate;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Activity throwingActivity = this.this$0.getAppContext().getThrowingActivity();
                        ReactActivity reactActivity = throwingActivity instanceof ReactActivity ? (ReactActivity) throwingActivity : null;
                        if (reactActivity == null || (reactDelegate = reactActivity.getReactDelegate()) == null) {
                            return;
                        }
                        Intrinsics.checkNotNull(reactDelegate);
                        reactDelegate.reload();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws Exceptions.MissingActivity {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr4 = new AnyType[1];
                AnyType anyType4 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                if (anyType4 == null) {
                    anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$6$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                }
                anyTypeArr4[0] = anyType4;
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.kotlin.defaultmodules.CoreModule$definition$lambda$6$$inlined$AsyncFunction$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) throws Exceptions.MissingActivity {
                        ReactDelegate reactDelegate;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Activity throwingActivity = this.this$0.getAppContext().getThrowingActivity();
                        ReactActivity reactActivity = throwingActivity instanceof ReactActivity ? (ReactActivity) throwingActivity : null;
                        if (reactActivity != null && (reactDelegate = reactActivity.getReactDelegate()) != null) {
                            Intrinsics.checkNotNull(reactDelegate);
                            reactDelegate.reload();
                        }
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent = new StringAsyncFunctionComponent("reloadAppAsync", anyTypeArr4, function1);
                                } else {
                                    asyncFunctionComponent = new AsyncFunctionComponent("reloadAppAsync", anyTypeArr4, function1);
                                }
                            } else {
                                asyncFunctionComponent = new FloatAsyncFunctionComponent("reloadAppAsync", anyTypeArr4, function1);
                            }
                        } else {
                            asyncFunctionComponent = new DoubleAsyncFunctionComponent("reloadAppAsync", anyTypeArr4, function1);
                        }
                    } else {
                        asyncFunctionComponent = new BoolAsyncFunctionComponent("reloadAppAsync", anyTypeArr4, function1);
                    }
                } else {
                    asyncFunctionComponent = new IntAsyncFunctionComponent("reloadAppAsync", anyTypeArr4, function1);
                }
                asyncFunctionWithPromiseComponent = asyncFunctionComponent;
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("reloadAppAsync", asyncFunctionWithPromiseComponent);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
