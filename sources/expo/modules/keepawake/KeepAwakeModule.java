package expo.modules.keepawake;

import androidx.tracing.Trace;
import expo.modules.core.errors.CurrentActivityNotFoundException;
import expo.modules.core.interfaces.services.KeepAwakeManager;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: KeepAwakeModule.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lexpo/modules/keepawake/KeepAwakeModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "keepAwakeManager", "Lexpo/modules/core/interfaces/services/KeepAwakeManager;", "getKeepAwakeManager", "()Lexpo/modules/core/interfaces/services/KeepAwakeManager;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-keep-awake_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KeepAwakeModule extends Module {
    /* JADX INFO: Access modifiers changed from: private */
    public final KeepAwakeManager getKeepAwakeManager() throws MissingModuleException {
        Object module;
        try {
            module = getAppContext().getLegacyModuleRegistry().getModule(KeepAwakeManager.class);
        } catch (Exception unused) {
            module = null;
        }
        KeepAwakeManager keepAwakeManager = (KeepAwakeManager) module;
        if (keepAwakeManager != null) {
            return keepAwakeManager;
        }
        throw new MissingModuleException("KeepAwakeManager");
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        KeepAwakeModule keepAwakeModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (keepAwakeModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(keepAwakeModule);
            moduleDefinitionBuilder.Name("ExpoKeepAwake");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[1];
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr[0] = anyType;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("activate", anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$2
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    try {
                        this.this$0.getKeepAwakeManager().activate((String) objArr[0], new Runnable() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$1$1$1
                            @Override // java.lang.Runnable
                            public final void run() {
                                promise.resolve(true);
                            }
                        });
                    } catch (CurrentActivityNotFoundException unused) {
                        promise.reject(new ActivateKeepAwakeException());
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder2.getAsyncFunctions().put("activate", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr2 = new AnyType[1];
            AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr2[0] = anyType2;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("deactivate", anyTypeArr2, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$4
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    try {
                        this.this$0.getKeepAwakeManager().deactivate((String) objArr[0], new Runnable() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$1$2$1
                            @Override // java.lang.Runnable
                            public final void run() {
                                promise.resolve(true);
                            }
                        });
                    } catch (CurrentActivityNotFoundException unused) {
                        promise.reject(new DeactivateKeepAwakeException());
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder3.getAsyncFunctions().put("deactivate", asyncFunctionWithPromiseComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr3 = new AnyType[0];
            Function1<Object[], Boolean> function1 = new Function1<Object[], Boolean>() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$lambda$3$$inlined$AsyncFunction$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(this.this$0.getKeepAwakeManager().isActivated());
                }
            };
            if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                asyncFunctionComponent = new StringAsyncFunctionComponent("isActivated", anyTypeArr3, function1);
                            } else {
                                asyncFunctionComponent = new AsyncFunctionComponent("isActivated", anyTypeArr3, function1);
                            }
                        } else {
                            asyncFunctionComponent = new FloatAsyncFunctionComponent("isActivated", anyTypeArr3, function1);
                        }
                    } else {
                        asyncFunctionComponent = new DoubleAsyncFunctionComponent("isActivated", anyTypeArr3, function1);
                    }
                } else {
                    asyncFunctionComponent = new BoolAsyncFunctionComponent("isActivated", anyTypeArr3, function1);
                }
            } else {
                asyncFunctionComponent = new IntAsyncFunctionComponent("isActivated", anyTypeArr3, function1);
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("isActivated", asyncFunctionComponent);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
