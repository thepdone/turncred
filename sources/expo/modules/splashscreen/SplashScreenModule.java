package expo.modules.splashscreen;

import androidx.tracing.Trace;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
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
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;

/* compiled from: SplashScreenModule.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lexpo/modules/splashscreen/SplashScreenModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "userControlledAutoHideEnabled", "", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-splash-screen_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SplashScreenModule extends Module {
    private boolean userControlledAutoHideEnabled;

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        SplashScreenModule splashScreenModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (splashScreenModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(splashScreenModule);
            moduleDefinitionBuilder.Name("ExpoSplashScreen");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[0];
            Function1<Object[], Boolean> function1 = new Function1<Object[], Boolean>() { // from class: expo.modules.splashscreen.SplashScreenModule$definition$lambda$7$$inlined$AsyncFunction$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    this.this$0.userControlledAutoHideEnabled = true;
                    SplashScreenManager.INSTANCE.setPreventAutoHideCalled(true);
                    return true;
                }
            };
            if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                asyncFunctionComponent = new StringAsyncFunctionComponent("preventAutoHideAsync", anyTypeArr, function1);
                            } else {
                                asyncFunctionComponent = new AsyncFunctionComponent("preventAutoHideAsync", anyTypeArr, function1);
                            }
                        } else {
                            asyncFunctionComponent = new FloatAsyncFunctionComponent("preventAutoHideAsync", anyTypeArr, function1);
                        }
                    } else {
                        asyncFunctionComponent = new DoubleAsyncFunctionComponent("preventAutoHideAsync", anyTypeArr, function1);
                    }
                } else {
                    asyncFunctionComponent = new BoolAsyncFunctionComponent("preventAutoHideAsync", anyTypeArr, function1);
                }
            } else {
                asyncFunctionComponent = new IntAsyncFunctionComponent("preventAutoHideAsync", anyTypeArr, function1);
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("preventAutoHideAsync", asyncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr2 = new AnyType[0];
            Function1<Object[], Unit> function12 = new Function1<Object[], Unit>() { // from class: expo.modules.splashscreen.SplashScreenModule$definition$lambda$7$$inlined$AsyncFunction$2
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    SplashScreenManager.INSTANCE.setPreventAutoHideCalled(true);
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                asyncFunctionComponent2 = new StringAsyncFunctionComponent("internalPreventAutoHideAsync", anyTypeArr2, function12);
                            } else {
                                asyncFunctionComponent2 = new AsyncFunctionComponent("internalPreventAutoHideAsync", anyTypeArr2, function12);
                            }
                        } else {
                            asyncFunctionComponent2 = new FloatAsyncFunctionComponent("internalPreventAutoHideAsync", anyTypeArr2, function12);
                        }
                    } else {
                        asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("internalPreventAutoHideAsync", anyTypeArr2, function12);
                    }
                } else {
                    asyncFunctionComponent2 = new BoolAsyncFunctionComponent("internalPreventAutoHideAsync", anyTypeArr2, function12);
                }
            } else {
                asyncFunctionComponent2 = new IntAsyncFunctionComponent("internalPreventAutoHideAsync", anyTypeArr2, function12);
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("internalPreventAutoHideAsync", asyncFunctionComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr3 = new AnyType[1];
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(SplashScreenOptions.class), false));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(SplashScreenOptions.class), false, new Function0<KType>() { // from class: expo.modules.splashscreen.SplashScreenModule$definition$lambda$7$$inlined$Function$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(SplashScreenOptions.class);
                    }
                }));
            }
            anyTypeArr3[0] = anyType;
            ReturnType returnType = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Job.class));
            if (returnType == null) {
                returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Job.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Job.class), returnType);
            }
            moduleDefinitionBuilder4.getSyncFunctions().put("setOptions", new SyncFunctionComponent("setOptions", anyTypeArr3, returnType, new Function1<Object[], Object>() { // from class: expo.modules.splashscreen.SplashScreenModule$definition$lambda$7$$inlined$Function$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    return BuildersKt__Builders_commonKt.launch$default(this.this$0.getAppContext().getMainQueue(), null, null, new SplashScreenModule$definition$1$3$1((SplashScreenOptions) objArr[0], null), 3, null);
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr4 = new AnyType[0];
            ReturnType returnType2 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
            if (returnType2 == null) {
                returnType2 = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType2);
            }
            moduleDefinitionBuilder5.getSyncFunctions().put("hide", new SyncFunctionComponent("hide", anyTypeArr4, returnType2, new Function1<Object[], Object>() { // from class: expo.modules.splashscreen.SplashScreenModule$definition$lambda$7$$inlined$FunctionWithoutArgs$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    SplashScreenManager.INSTANCE.hide();
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("hideAsync", new AsyncFunctionComponent("hideAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.splashscreen.SplashScreenModule$definition$lambda$7$$inlined$AsyncFunctionWithoutArgs$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    SplashScreenManager.INSTANCE.hide();
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("internalMaybeHideAsync", new AsyncFunctionComponent("internalMaybeHideAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.splashscreen.SplashScreenModule$definition$lambda$7$$inlined$AsyncFunctionWithoutArgs$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (!this.this$0.userControlledAutoHideEnabled) {
                        SplashScreenManager.INSTANCE.hide();
                    }
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.splashscreen.SplashScreenModule$definition$lambda$7$$inlined$OnDestroy$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    SplashScreenManager.INSTANCE.unregisterContentAppearedListener();
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
