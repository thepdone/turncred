package expo.modules.backgroundfetch;

import androidx.tracing.Trace;
import expo.modules.interfaces.taskManager.TaskManagerInterface;
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
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* compiled from: BackgroundFetchModule.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Lexpo/modules/backgroundfetch/BackgroundFetchModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "_taskManager", "Lexpo/modules/interfaces/taskManager/TaskManagerInterface;", "get_taskManager", "()Lexpo/modules/interfaces/taskManager/TaskManagerInterface;", "_taskManager$delegate", "Lkotlin/Lazy;", "taskManager", "getTaskManager", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-background-fetch_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BackgroundFetchModule extends Module {

    /* renamed from: _taskManager$delegate, reason: from kotlin metadata */
    private final Lazy _taskManager = LazyKt.lazy(new Function0<TaskManagerInterface>() { // from class: expo.modules.backgroundfetch.BackgroundFetchModule$_taskManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TaskManagerInterface invoke() {
            Object module;
            try {
                module = this.this$0.getAppContext().getLegacyModuleRegistry().getModule(TaskManagerInterface.class);
            } catch (Exception unused) {
                module = null;
            }
            return (TaskManagerInterface) module;
        }
    });

    private final TaskManagerInterface get_taskManager() {
        return (TaskManagerInterface) this._taskManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TaskManagerInterface getTaskManager() throws TaskMangerInterfaceNotFoundException {
        TaskManagerInterface taskManagerInterface = get_taskManager();
        if (taskManagerInterface != null) {
            return taskManagerInterface;
        }
        throw new TaskMangerInterfaceNotFoundException();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        BackgroundFetchModule backgroundFetchModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (backgroundFetchModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(backgroundFetchModule);
            moduleDefinitionBuilder.Name("ExpoBackgroundFetch");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[2];
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.backgroundfetch.BackgroundFetchModule$definition$lambda$2$$inlined$AsyncFunction$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr[0] = anyType;
            AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Map.class), false));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Map.class), false, new Function0<KType>() { // from class: expo.modules.backgroundfetch.BackgroundFetchModule$definition$lambda$2$$inlined$AsyncFunction$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.nullableTypeOf(Object.class)));
                    }
                }));
            }
            anyTypeArr[1] = anyType2;
            Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.backgroundfetch.BackgroundFetchModule$definition$lambda$2$$inlined$AsyncFunction$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) throws Exception {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    Map<String, Object> map = (Map) objArr[1];
                    this.this$0.getTaskManager().registerTask((String) obj, BackgroundFetchTaskConsumer.class, map);
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                asyncFunctionComponent = new StringAsyncFunctionComponent("registerTaskAsync", anyTypeArr, function1);
                            } else {
                                asyncFunctionComponent = new AsyncFunctionComponent("registerTaskAsync", anyTypeArr, function1);
                            }
                        } else {
                            asyncFunctionComponent = new FloatAsyncFunctionComponent("registerTaskAsync", anyTypeArr, function1);
                        }
                    } else {
                        asyncFunctionComponent = new DoubleAsyncFunctionComponent("registerTaskAsync", anyTypeArr, function1);
                    }
                } else {
                    asyncFunctionComponent = new BoolAsyncFunctionComponent("registerTaskAsync", anyTypeArr, function1);
                }
            } else {
                asyncFunctionComponent = new IntAsyncFunctionComponent("registerTaskAsync", anyTypeArr, function1);
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("registerTaskAsync", asyncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("unregisterTaskAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.backgroundfetch.BackgroundFetchModule$definition$lambda$2$$inlined$AsyncFunction$4
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws Exception {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        this.this$0.getTaskManager().unregisterTask((String) promise, BackgroundFetchTaskConsumer.class);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws Exception {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr2 = new AnyType[1];
                AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                if (anyType3 == null) {
                    anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.backgroundfetch.BackgroundFetchModule$definition$lambda$2$$inlined$AsyncFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                }
                anyTypeArr2[0] = anyType3;
                Function1<Object[], Unit> function12 = new Function1<Object[], Unit>() { // from class: expo.modules.backgroundfetch.BackgroundFetchModule$definition$lambda$2$$inlined$AsyncFunction$6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) throws Exception {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        this.this$0.getTaskManager().unregisterTask((String) objArr[0], BackgroundFetchTaskConsumer.class);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent2 = new StringAsyncFunctionComponent("unregisterTaskAsync", anyTypeArr2, function12);
                                } else {
                                    asyncFunctionComponent2 = new AsyncFunctionComponent("unregisterTaskAsync", anyTypeArr2, function12);
                                }
                            } else {
                                asyncFunctionComponent2 = new FloatAsyncFunctionComponent("unregisterTaskAsync", anyTypeArr2, function12);
                            }
                        } else {
                            asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("unregisterTaskAsync", anyTypeArr2, function12);
                        }
                    } else {
                        asyncFunctionComponent2 = new BoolAsyncFunctionComponent("unregisterTaskAsync", anyTypeArr2, function12);
                    }
                } else {
                    asyncFunctionComponent2 = new IntAsyncFunctionComponent("unregisterTaskAsync", anyTypeArr2, function12);
                }
                asyncFunctionWithPromiseComponent = asyncFunctionComponent2;
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("unregisterTaskAsync", asyncFunctionWithPromiseComponent);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
