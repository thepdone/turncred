package expo.modules.notifications.notifications.handling;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.tracing.Trace;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.core.ModuleRegistry;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventEmitter;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.notifications.NotificationWasAlreadyHandledException;
import expo.modules.notifications.notifications.interfaces.NotificationListener;
import expo.modules.notifications.notifications.interfaces.NotificationManager;
import expo.modules.notifications.notifications.model.Notification;
import expo.modules.notifications.notifications.model.NotificationBehavior;
import expo.modules.notifications.service.NotificationsService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: NotificationsHandler.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lexpo/modules/notifications/notifications/handling/NotificationsHandler;", "Lexpo/modules/kotlin/modules/Module;", "Lexpo/modules/notifications/notifications/interfaces/NotificationListener;", "()V", "handler", "Landroid/os/Handler;", "moduleRegistry", "Lexpo/modules/core/ModuleRegistry;", "notificationManager", "Lexpo/modules/notifications/notifications/interfaces/NotificationManager;", "notificationsHandlerThread", "Landroid/os/HandlerThread;", "tasksMap", "", "", "Lexpo/modules/notifications/notifications/handling/SingleNotificationHandlerTask;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "handleNotificationAsync", "", "identifier", "behavior", "Lexpo/modules/notifications/notifications/handling/NotificationBehaviourRecord;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "onNotificationReceived", NotificationsService.NOTIFICATION_KEY, "Lexpo/modules/notifications/notifications/model/Notification;", "onTaskFinished", "task", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class NotificationsHandler extends Module implements NotificationListener {
    private Handler handler;
    private ModuleRegistry moduleRegistry;
    private NotificationManager notificationManager;
    private HandlerThread notificationsHandlerThread;
    private final Map<String, SingleNotificationHandlerTask> tasksMap = new LinkedHashMap();

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        NotificationsHandler notificationsHandler = this;
        Trace.beginSection("[ExpoModulesCore] " + (notificationsHandler.getClass() + ".ModuleDefinition"));
        try {
            final ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(notificationsHandler);
            moduleDefinitionBuilder.Name("ExpoNotificationsHandlerModule");
            moduleDefinitionBuilder.Events("onHandleNotification", "onHandleNotificationTimeout");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.notifications.notifications.handling.NotificationsHandler$definition$lambda$3$$inlined$OnCreate$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    NotificationsHandler notificationsHandler2 = this.this$0;
                    notificationsHandler2.moduleRegistry = notificationsHandler2.getAppContext().getLegacyModuleRegistry();
                    NotificationsHandler notificationsHandler3 = this.this$0;
                    ModuleRegistry moduleRegistry = notificationsHandler3.moduleRegistry;
                    HandlerThread handlerThread = null;
                    if (moduleRegistry == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("moduleRegistry");
                        moduleRegistry = null;
                    }
                    Object singletonModule = moduleRegistry.getSingletonModule("NotificationManager", NotificationManager.class);
                    if (singletonModule != null) {
                        notificationsHandler3.notificationManager = (NotificationManager) singletonModule;
                        NotificationManager notificationManager = this.this$0.notificationManager;
                        if (notificationManager == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
                            notificationManager = null;
                        }
                        notificationManager.addListener(this.this$0);
                        this.this$0.notificationsHandlerThread = new HandlerThread("NotificationsHandlerThread - " + moduleDefinitionBuilder.getClass());
                        HandlerThread handlerThread2 = this.this$0.notificationsHandlerThread;
                        if (handlerThread2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("notificationsHandlerThread");
                            handlerThread2 = null;
                        }
                        handlerThread2.start();
                        NotificationsHandler notificationsHandler4 = this.this$0;
                        HandlerThread handlerThread3 = this.this$0.notificationsHandlerThread;
                        if (handlerThread3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("notificationsHandlerThread");
                        } else {
                            handlerThread = handlerThread3;
                        }
                        notificationsHandler4.handler = new Handler(handlerThread.getLooper());
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.notifications.notifications.handling.NotificationsHandler$definition$lambda$3$$inlined$OnDestroy$1
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
                    NotificationManager notificationManager = this.this$0.notificationManager;
                    HandlerThread handlerThread = null;
                    if (notificationManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
                        notificationManager = null;
                    }
                    notificationManager.removeListener(this.this$0);
                    Iterator it = this.this$0.tasksMap.values().iterator();
                    while (it.hasNext()) {
                        ((SingleNotificationHandlerTask) it.next()).stop();
                    }
                    HandlerThread handlerThread2 = this.this$0.notificationsHandlerThread;
                    if (handlerThread2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("notificationsHandlerThread");
                    } else {
                        handlerThread = handlerThread2;
                    }
                    handlerThread.quit();
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[2];
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.handling.NotificationsHandler$definition$lambda$3$$inlined$AsyncFunctionWithPromise$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr[0] = anyType;
            AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(NotificationBehaviourRecord.class), false));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NotificationBehaviourRecord.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.handling.NotificationsHandler$definition$lambda$3$$inlined$AsyncFunctionWithPromise$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(NotificationBehaviourRecord.class);
                    }
                }));
            }
            anyTypeArr[1] = anyType2;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("handleNotificationAsync", anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.notifications.handling.NotificationsHandler$definition$lambda$3$$inlined$AsyncFunctionWithPromise$3
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws NotificationWasAlreadyHandledException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    NotificationBehaviourRecord notificationBehaviourRecord = (NotificationBehaviourRecord) objArr[1];
                    this.$receiver$inlined.handleNotificationAsync((String) obj, notificationBehaviourRecord, promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws NotificationWasAlreadyHandledException {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder2.getAsyncFunctions().put("handleNotificationAsync", asyncFunctionWithPromiseComponent);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleNotificationAsync(String identifier, NotificationBehaviourRecord behavior, Promise promise) throws NotificationWasAlreadyHandledException {
        SingleNotificationHandlerTask singleNotificationHandlerTask = this.tasksMap.get(identifier);
        if (singleNotificationHandlerTask == null) {
            throw new NotificationWasAlreadyHandledException(identifier);
        }
        singleNotificationHandlerTask.processNotificationWithBehavior(new NotificationBehavior(behavior.getShouldShowAlert(), behavior.getShouldPlaySound(), behavior.getShouldSetBadge(), behavior.getPriority()), promise);
    }

    @Override // expo.modules.notifications.notifications.interfaces.NotificationListener
    public void onNotificationReceived(Notification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        Context reactContext = getAppContext().getReactContext();
        if (reactContext == null) {
            return;
        }
        EventEmitter eventEmitter = getAppContext().eventEmitter(this);
        Handler handler = this.handler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("handler");
            handler = null;
        }
        SingleNotificationHandlerTask singleNotificationHandlerTask = new SingleNotificationHandlerTask(reactContext, eventEmitter, handler, notification, this);
        Map<String, SingleNotificationHandlerTask> map = this.tasksMap;
        String identifier = singleNotificationHandlerTask.getIdentifier();
        Intrinsics.checkNotNullExpressionValue(identifier, "getIdentifier(...)");
        map.put(identifier, singleNotificationHandlerTask);
        singleNotificationHandlerTask.start();
    }

    public final void onTaskFinished(SingleNotificationHandlerTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.tasksMap.remove(task.getIdentifier());
    }
}
