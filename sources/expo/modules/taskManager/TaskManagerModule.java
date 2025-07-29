package expo.modules.taskManager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.tracing.Trace;
import expo.modules.core.errors.ModuleNotFoundException;
import expo.modules.interfaces.taskManager.TaskManagerInterface;
import expo.modules.interfaces.taskManager.TaskServiceInterface;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
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
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* compiled from: TaskManagerModule.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0016"}, d2 = {"Lexpo/modules/taskManager/TaskManagerModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "_taskService", "Lexpo/modules/interfaces/taskManager/TaskServiceInterface;", "get_taskService", "()Lexpo/modules/interfaces/taskManager/TaskServiceInterface;", "_taskService$delegate", "Lkotlin/Lazy;", "appScopeKey", "", "getAppScopeKey", "()Ljava/lang/String;", "taskManagerInternal", "Lexpo/modules/interfaces/taskManager/TaskManagerInterface;", "getTaskManagerInternal", "()Lexpo/modules/interfaces/taskManager/TaskManagerInterface;", "taskManagerInternal$delegate", "taskService", "getTaskService", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-task-manager_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TaskManagerModule extends Module {

    /* renamed from: _taskService$delegate, reason: from kotlin metadata */
    private final Lazy _taskService = LazyKt.lazy(new Function0<TaskServiceInterface>() { // from class: expo.modules.taskManager.TaskManagerModule$_taskService$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TaskServiceInterface invoke() {
            return (TaskServiceInterface) this.this$0.getAppContext().getLegacyModuleRegistry().getSingletonModule("TaskService", TaskServiceInterface.class);
        }
    });

    /* renamed from: taskManagerInternal$delegate, reason: from kotlin metadata */
    private final Lazy taskManagerInternal = LazyKt.lazy(new Function0<TaskManagerInterface>() { // from class: expo.modules.taskManager.TaskManagerModule$taskManagerInternal$2
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

    private final TaskServiceInterface get_taskService() {
        return (TaskServiceInterface) this._taskService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TaskServiceInterface getTaskService() throws ModuleNotFoundException {
        TaskServiceInterface taskServiceInterface = get_taskService();
        if (taskServiceInterface != null) {
            return taskServiceInterface;
        }
        throw new ModuleNotFoundException(TaskServiceInterface.class.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TaskManagerInterface getTaskManagerInternal() {
        return (TaskManagerInterface) this.taskManagerInternal.getValue();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        AsyncFunctionComponent asyncFunctionComponent3;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        AsyncFunctionComponent asyncFunctionComponent4;
        AsyncFunctionComponent asyncFunctionComponent5;
        AsyncFunctionComponent asyncFunctionComponent6;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2;
        AsyncFunctionComponent asyncFunctionComponent7;
        TaskManagerModule taskManagerModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (taskManagerModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(taskManagerModule);
            moduleDefinitionBuilder.Name("ExpoTaskManager");
            moduleDefinitionBuilder.Events(TaskManagerInterface.EVENT_NAME);
            moduleDefinitionBuilder.Constants(TuplesKt.to("EVENT_NAME", TaskManagerInterface.EVENT_NAME));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.taskManager.TaskManagerModule$definition$lambda$8$$inlined$OnCreate$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Object module;
                    final WeakReference weakReference = new WeakReference(this.this$0);
                    final Function2<String, Bundle, Unit> function2 = new Function2<String, Bundle, Unit>() { // from class: expo.modules.taskManager.TaskManagerModule$definition$1$1$emitEvent$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
                            invoke2(str, bundle);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String name, Bundle body) {
                            Intrinsics.checkNotNullParameter(name, "name");
                            Intrinsics.checkNotNullParameter(body, "body");
                            try {
                                TaskManagerModule taskManagerModule2 = weakReference.get();
                                if (taskManagerModule2 != null) {
                                    taskManagerModule2.sendEvent(name, body);
                                }
                            } catch (Throwable th) {
                                Log.e("ExpoTaskManager", "Failed to emit event " + name + " using the module's event emitter: " + th.getMessage());
                            }
                        }
                    };
                    try {
                        module = this.this$0.getAppContext().getLegacyModuleRegistry().getModule(TaskManagerInterface.class);
                    } catch (Exception unused) {
                        module = null;
                    }
                    TaskManagerInternalModule taskManagerInternalModule = module instanceof TaskManagerInternalModule ? (TaskManagerInternalModule) module : null;
                    if (taskManagerInternalModule != null) {
                        taskManagerInternalModule.setEmitEventWrapper(new EmitEventWrapper(function2) { // from class: expo.modules.taskManager.TaskManagerModule$sam$expo_modules_taskManager_EmitEventWrapper$0
                            private final /* synthetic */ Function2 function;

                            {
                                Intrinsics.checkNotNullParameter(function2, "function");
                                this.function = function2;
                            }

                            @Override // expo.modules.taskManager.EmitEventWrapper
                            public final /* synthetic */ void emit(String str, Bundle bundle) {
                                this.function.invoke(str, bundle);
                            }
                        });
                    }
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[0];
            Function1<Object[], Boolean> function1 = new Function1<Object[], Boolean>() { // from class: expo.modules.taskManager.TaskManagerModule$definition$lambda$8$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
            if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                asyncFunctionComponent = new StringAsyncFunctionComponent("isAvailableAsync", anyTypeArr, function1);
                            } else {
                                asyncFunctionComponent = new AsyncFunctionComponent("isAvailableAsync", anyTypeArr, function1);
                            }
                        } else {
                            asyncFunctionComponent = new FloatAsyncFunctionComponent("isAvailableAsync", anyTypeArr, function1);
                        }
                    } else {
                        asyncFunctionComponent = new DoubleAsyncFunctionComponent("isAvailableAsync", anyTypeArr, function1);
                    }
                } else {
                    asyncFunctionComponent = new BoolAsyncFunctionComponent("isAvailableAsync", anyTypeArr, function1);
                }
            } else {
                asyncFunctionComponent = new IntAsyncFunctionComponent("isAvailableAsync", anyTypeArr, function1);
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("isAvailableAsync", asyncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr2 = new AnyType[2];
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.taskManager.TaskManagerModule$definition$lambda$8$$inlined$AsyncFunction$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr2[0] = anyType;
            AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Map.class), false));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Map.class), false, new Function0<KType>() { // from class: expo.modules.taskManager.TaskManagerModule$definition$lambda$8$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.nullableTypeOf(Object.class)));
                    }
                }));
            }
            anyTypeArr2[1] = anyType2;
            Function1<Object[], Unit> function12 = new Function1<Object[], Unit>() { // from class: expo.modules.taskManager.TaskManagerModule$definition$lambda$8$$inlined$AsyncFunction$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) throws ModuleNotFoundException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    Map<String, Object> map = (Map) objArr[1];
                    this.this$0.getTaskService().notifyTaskFinished((String) obj, this.this$0.getAppScopeKey(), map);
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                asyncFunctionComponent2 = new StringAsyncFunctionComponent("notifyTaskFinishedAsync", anyTypeArr2, function12);
                            } else {
                                asyncFunctionComponent2 = new AsyncFunctionComponent("notifyTaskFinishedAsync", anyTypeArr2, function12);
                            }
                        } else {
                            asyncFunctionComponent2 = new FloatAsyncFunctionComponent("notifyTaskFinishedAsync", anyTypeArr2, function12);
                        }
                    } else {
                        asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("notifyTaskFinishedAsync", anyTypeArr2, function12);
                    }
                } else {
                    asyncFunctionComponent2 = new BoolAsyncFunctionComponent("notifyTaskFinishedAsync", anyTypeArr2, function12);
                }
            } else {
                asyncFunctionComponent2 = new IntAsyncFunctionComponent("notifyTaskFinishedAsync", anyTypeArr2, function12);
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("notifyTaskFinishedAsync", asyncFunctionComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("isTaskRegisteredAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.taskManager.TaskManagerModule$definition$lambda$8$$inlined$AsyncFunction$5
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws ModuleNotFoundException {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        this.this$0.getTaskService().hasRegisteredTask((String) promise, this.this$0.getAppScopeKey());
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws ModuleNotFoundException {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr3 = new AnyType[1];
                AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                if (anyType3 == null) {
                    anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.taskManager.TaskManagerModule$definition$lambda$8$$inlined$AsyncFunction$6
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                }
                anyTypeArr3[0] = anyType3;
                Function1<Object[], Boolean> function13 = new Function1<Object[], Boolean>() { // from class: expo.modules.taskManager.TaskManagerModule$definition$lambda$8$$inlined$AsyncFunction$7
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        return Boolean.valueOf(this.this$0.getTaskService().hasRegisteredTask((String) objArr[0], this.this$0.getAppScopeKey()));
                    }
                };
                if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                    asyncFunctionComponent3 = new StringAsyncFunctionComponent("isTaskRegisteredAsync", anyTypeArr3, function13);
                                } else {
                                    asyncFunctionComponent3 = new AsyncFunctionComponent("isTaskRegisteredAsync", anyTypeArr3, function13);
                                }
                            } else {
                                asyncFunctionComponent3 = new FloatAsyncFunctionComponent("isTaskRegisteredAsync", anyTypeArr3, function13);
                            }
                        } else {
                            asyncFunctionComponent3 = new DoubleAsyncFunctionComponent("isTaskRegisteredAsync", anyTypeArr3, function13);
                        }
                    } else {
                        asyncFunctionComponent3 = new BoolAsyncFunctionComponent("isTaskRegisteredAsync", anyTypeArr3, function13);
                    }
                } else {
                    asyncFunctionComponent3 = new IntAsyncFunctionComponent("isTaskRegisteredAsync", anyTypeArr3, function13);
                }
                asyncFunctionWithPromiseComponent = asyncFunctionComponent3;
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("isTaskRegisteredAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionComponent4 = new AsyncFunctionWithPromiseComponent("getTaskOptionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.taskManager.TaskManagerModule$definition$lambda$8$$inlined$AsyncFunction$8
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws ModuleNotFoundException {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        this.this$0.getTaskService().getTaskOptions((String) promise, this.this$0.getAppScopeKey());
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws ModuleNotFoundException {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr4 = new AnyType[1];
                AnyType anyType4 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                if (anyType4 == null) {
                    anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.taskManager.TaskManagerModule$definition$lambda$8$$inlined$AsyncFunction$9
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                }
                anyTypeArr4[0] = anyType4;
                asyncFunctionComponent4 = new AsyncFunctionComponent("getTaskOptionsAsync", anyTypeArr4, new Function1<Object[], Bundle>() { // from class: expo.modules.taskManager.TaskManagerModule$definition$lambda$8$$inlined$AsyncFunction$10
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Bundle invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        return this.this$0.getTaskService().getTaskOptions((String) objArr[0], this.this$0.getAppScopeKey());
                    }
                });
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("getTaskOptionsAsync", asyncFunctionComponent4);
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr5 = new AnyType[0];
            Function1<Object[], List<? extends Bundle>> function14 = new Function1<Object[], List<? extends Bundle>>() { // from class: expo.modules.taskManager.TaskManagerModule$definition$lambda$8$$inlined$AsyncFunction$11
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final List<? extends Bundle> invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    List<Bundle> tasksForAppScopeKey = this.this$0.getTaskService().getTasksForAppScopeKey(this.this$0.getAppScopeKey());
                    Intrinsics.checkNotNullExpressionValue(tasksForAppScopeKey, "getTasksForAppScopeKey(...)");
                    return tasksForAppScopeKey;
                }
            };
            if (!Intrinsics.areEqual(List.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(List.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(List.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(List.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(List.class, String.class)) {
                                asyncFunctionComponent5 = new StringAsyncFunctionComponent("getRegisteredTasksAsync", anyTypeArr5, function14);
                            } else {
                                asyncFunctionComponent5 = new AsyncFunctionComponent("getRegisteredTasksAsync", anyTypeArr5, function14);
                            }
                        } else {
                            asyncFunctionComponent5 = new FloatAsyncFunctionComponent("getRegisteredTasksAsync", anyTypeArr5, function14);
                        }
                    } else {
                        asyncFunctionComponent5 = new DoubleAsyncFunctionComponent("getRegisteredTasksAsync", anyTypeArr5, function14);
                    }
                } else {
                    asyncFunctionComponent5 = new BoolAsyncFunctionComponent("getRegisteredTasksAsync", anyTypeArr5, function14);
                }
            } else {
                asyncFunctionComponent5 = new IntAsyncFunctionComponent("getRegisteredTasksAsync", anyTypeArr5, function14);
            }
            moduleDefinitionBuilder6.getAsyncFunctions().put("getRegisteredTasksAsync", asyncFunctionComponent5);
            ModuleDefinitionBuilder moduleDefinitionBuilder7 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("unregisterTaskAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.taskManager.TaskManagerModule$definition$lambda$8$$inlined$AsyncFunction$12
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws Exception {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        this.this$0.getTaskService().unregisterTask((String) promise, this.this$0.getAppScopeKey(), null);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws Exception {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr6 = new AnyType[1];
                AnyType anyType5 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                if (anyType5 == null) {
                    anyType5 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.taskManager.TaskManagerModule$definition$lambda$8$$inlined$AsyncFunction$13
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                }
                anyTypeArr6[0] = anyType5;
                Function1<Object[], Unit> function15 = new Function1<Object[], Unit>() { // from class: expo.modules.taskManager.TaskManagerModule$definition$lambda$8$$inlined$AsyncFunction$14
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) throws Exception {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        this.this$0.getTaskService().unregisterTask((String) objArr[0], this.this$0.getAppScopeKey(), null);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent6 = new StringAsyncFunctionComponent("unregisterTaskAsync", anyTypeArr6, function15);
                                } else {
                                    asyncFunctionComponent6 = new AsyncFunctionComponent("unregisterTaskAsync", anyTypeArr6, function15);
                                }
                            } else {
                                asyncFunctionComponent6 = new FloatAsyncFunctionComponent("unregisterTaskAsync", anyTypeArr6, function15);
                            }
                        } else {
                            asyncFunctionComponent6 = new DoubleAsyncFunctionComponent("unregisterTaskAsync", anyTypeArr6, function15);
                        }
                    } else {
                        asyncFunctionComponent6 = new BoolAsyncFunctionComponent("unregisterTaskAsync", anyTypeArr6, function15);
                    }
                } else {
                    asyncFunctionComponent6 = new IntAsyncFunctionComponent("unregisterTaskAsync", anyTypeArr6, function15);
                }
                asyncFunctionWithPromiseComponent2 = asyncFunctionComponent6;
            }
            moduleDefinitionBuilder7.getAsyncFunctions().put("unregisterTaskAsync", asyncFunctionWithPromiseComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder8 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr7 = new AnyType[0];
            Function1<Object[], Unit> function16 = new Function1<Object[], Unit>() { // from class: expo.modules.taskManager.TaskManagerModule$definition$lambda$8$$inlined$AsyncFunction$15
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    this.this$0.getTaskService().unregisterAllTasksForAppScopeKey(this.this$0.getAppScopeKey());
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                asyncFunctionComponent7 = new StringAsyncFunctionComponent("unregisterAllTasksAsync", anyTypeArr7, function16);
                            } else {
                                asyncFunctionComponent7 = new AsyncFunctionComponent("unregisterAllTasksAsync", anyTypeArr7, function16);
                            }
                        } else {
                            asyncFunctionComponent7 = new FloatAsyncFunctionComponent("unregisterAllTasksAsync", anyTypeArr7, function16);
                        }
                    } else {
                        asyncFunctionComponent7 = new DoubleAsyncFunctionComponent("unregisterAllTasksAsync", anyTypeArr7, function16);
                    }
                } else {
                    asyncFunctionComponent7 = new BoolAsyncFunctionComponent("unregisterAllTasksAsync", anyTypeArr7, function16);
                }
            } else {
                asyncFunctionComponent7 = new IntAsyncFunctionComponent("unregisterAllTasksAsync", anyTypeArr7, function16);
            }
            moduleDefinitionBuilder8.getAsyncFunctions().put("unregisterAllTasksAsync", asyncFunctionComponent7);
            moduleDefinitionBuilder.OnStartObserving(new Function0<Unit>() { // from class: expo.modules.taskManager.TaskManagerModule$definition$1$9
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Handler handler = new Handler(Looper.getMainLooper());
                    final TaskManagerModule taskManagerModule2 = this.this$0;
                    handler.postDelayed(new Runnable() { // from class: expo.modules.taskManager.TaskManagerModule$definition$1$9.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            TaskManagerInterface taskManagerInternal = taskManagerModule2.getTaskManagerInternal();
                            if (taskManagerInternal != null) {
                                taskManagerInternal.flushQueuedEvents();
                            }
                        }
                    }, 1000L);
                }
            });
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getAppScopeKey() throws ModuleNotFoundException {
        TaskManagerInterface taskManagerInternal = getTaskManagerInternal();
        if (taskManagerInternal == null) {
            throw new ModuleNotFoundException(TaskManagerInterface.class.toString());
        }
        String appScopeKey = taskManagerInternal.getAppScopeKey();
        Intrinsics.checkNotNullExpressionValue(appScopeKey, "getAppScopeKey(...)");
        return appScopeKey;
    }
}
