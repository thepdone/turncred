package expo.modules.notifications.notifications.presentation;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.tracing.Trace;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.core.arguments.ReadableArguments;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
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
import expo.modules.notifications.UtilsKt;
import expo.modules.notifications.notifications.ArgumentsNotificationContentBuilder;
import expo.modules.notifications.notifications.NotificationSerializer;
import expo.modules.notifications.notifications.interfaces.INotificationContent;
import expo.modules.notifications.notifications.interfaces.NotificationTrigger;
import expo.modules.notifications.notifications.model.Notification;
import expo.modules.notifications.notifications.model.NotificationContent;
import expo.modules.notifications.notifications.model.NotificationRequest;
import expo.modules.notifications.service.NotificationsService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: ExpoNotificationPresentationModule.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014JF\u0010\u000f\u001a\u00020\u00102<\u0010\u0011\u001a8\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00190\u0012j\u0002`\u001aH\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0018\u0010 \u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0014R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006&"}, d2 = {"Lexpo/modules/notifications/notifications/presentation/ExpoNotificationPresentationModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "createNotificationRequest", "Lexpo/modules/notifications/notifications/model/NotificationRequest;", "identifier", "", "content", "Lexpo/modules/notifications/notifications/interfaces/INotificationContent;", "trigger", "Lexpo/modules/notifications/notifications/interfaces/NotificationTrigger;", "createResultReceiver", "Landroid/os/ResultReceiver;", "body", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "resultCode", "Landroid/os/Bundle;", "resultData", "", "Lexpo/modules/notifications/ResultReceiverBody;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "dismissAllNotificationsAsync", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "dismissNotificationAsync", "serializeNotifications", "", NotificationsService.NOTIFICATIONS_KEY, "", "Lexpo/modules/notifications/notifications/model/Notification;", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class ExpoNotificationPresentationModule extends Module {
    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() throws Exceptions.ReactContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    protected final ResultReceiver createResultReceiver(Function2<? super Integer, ? super Bundle, Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return UtilsKt.createDefaultResultReceiver(null, body);
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2;
        ExpoNotificationPresentationModule expoNotificationPresentationModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (expoNotificationPresentationModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(expoNotificationPresentationModule);
            moduleDefinitionBuilder.Name("ExpoNotificationPresenter");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[2];
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.presentation.ExpoNotificationPresentationModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr[0] = anyType;
            AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.presentation.ExpoNotificationPresentationModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(ReadableArguments.class);
                    }
                }));
            }
            anyTypeArr[1] = anyType2;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent("presentNotificationAsync", anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.notifications.presentation.ExpoNotificationPresentationModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$3
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    final String str = (String) obj;
                    NotificationContent notificationContentBuild = new ArgumentsNotificationContentBuilder(this.this$0.getContext()).setPayload((ReadableArguments) objArr[1]).build();
                    ExpoNotificationPresentationModule expoNotificationPresentationModule2 = this.this$0;
                    Intrinsics.checkNotNull(notificationContentBuild);
                    NotificationsService.INSTANCE.present(this.this$0.getContext(), new Notification(expoNotificationPresentationModule2.createNotificationRequest(str, notificationContentBuild, null)), null, this.this$0.createResultReceiver(new Function2<Integer, Bundle, Unit>() { // from class: expo.modules.notifications.notifications.presentation.ExpoNotificationPresentationModule$definition$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Bundle bundle) {
                            invoke(num.intValue(), bundle);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i, Bundle bundle) {
                            if (i == 0) {
                                promise.resolve(str);
                            } else {
                                Serializable serializable = bundle != null ? bundle.getSerializable("exception") : null;
                                promise.reject("ERR_NOTIFICATION_PRESENTATION_FAILED", "Notification could not be presented.", serializable instanceof Exception ? (Exception) serializable : null);
                            }
                        }
                    }));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder2.getAsyncFunctions().put("presentNotificationAsync", asyncFunctionWithPromiseComponent3);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("getPresentedNotificationsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.notifications.presentation.ExpoNotificationPresentationModule$definition$lambda$3$$inlined$AsyncFunction$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        NotificationsService.INSTANCE.getAllPresented(this.this$0.getContext(), this.this$0.createResultReceiver(new ExpoNotificationPresentationModule$definition$1$2$1(promise, this.this$0)));
                    }
                });
            } else {
                AnyType[] anyTypeArr2 = new AnyType[1];
                AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType3 == null) {
                    anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.presentation.ExpoNotificationPresentationModule$definition$lambda$3$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Promise.class);
                        }
                    }));
                }
                anyTypeArr2[0] = anyType3;
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.notifications.notifications.presentation.ExpoNotificationPresentationModule$definition$lambda$3$$inlined$AsyncFunction$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        NotificationsService.INSTANCE.getAllPresented(this.this$0.getContext(), this.this$0.createResultReceiver(new ExpoNotificationPresentationModule$definition$1$2$1((Promise) objArr[0], this.this$0)));
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent = new StringAsyncFunctionComponent("getPresentedNotificationsAsync", anyTypeArr2, function1);
                                } else {
                                    asyncFunctionComponent = new AsyncFunctionComponent("getPresentedNotificationsAsync", anyTypeArr2, function1);
                                }
                            } else {
                                asyncFunctionComponent = new FloatAsyncFunctionComponent("getPresentedNotificationsAsync", anyTypeArr2, function1);
                            }
                        } else {
                            asyncFunctionComponent = new DoubleAsyncFunctionComponent("getPresentedNotificationsAsync", anyTypeArr2, function1);
                        }
                    } else {
                        asyncFunctionComponent = new BoolAsyncFunctionComponent("getPresentedNotificationsAsync", anyTypeArr2, function1);
                    }
                } else {
                    asyncFunctionComponent = new IntAsyncFunctionComponent("getPresentedNotificationsAsync", anyTypeArr2, function1);
                }
                asyncFunctionWithPromiseComponent = asyncFunctionComponent;
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("getPresentedNotificationsAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr3 = new AnyType[1];
            AnyType anyType4 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType4 == null) {
                anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.presentation.ExpoNotificationPresentationModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$4
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr3[0] = anyType4;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent4 = new AsyncFunctionWithPromiseComponent("dismissNotificationAsync", anyTypeArr3, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.notifications.presentation.ExpoNotificationPresentationModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$5
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    this.$receiver$inlined.dismissNotificationAsync((String) objArr[0], promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder4.getAsyncFunctions().put("dismissNotificationAsync", asyncFunctionWithPromiseComponent4);
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("dismissAllNotificationsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.notifications.presentation.ExpoNotificationPresentationModule$definition$lambda$3$$inlined$AsyncFunction$4
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        this.$receiver$inlined.dismissAllNotificationsAsync(promise);
                    }
                });
            } else {
                AnyType[] anyTypeArr4 = new AnyType[1];
                AnyType anyType5 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType5 == null) {
                    anyType5 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.presentation.ExpoNotificationPresentationModule$definition$lambda$3$$inlined$AsyncFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Promise.class);
                        }
                    }));
                }
                anyTypeArr4[0] = anyType5;
                Function1<Object[], Unit> function12 = new Function1<Object[], Unit>() { // from class: expo.modules.notifications.notifications.presentation.ExpoNotificationPresentationModule$definition$lambda$3$$inlined$AsyncFunction$6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        this.$receiver$inlined.dismissAllNotificationsAsync((Promise) objArr[0]);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent2 = new StringAsyncFunctionComponent("dismissAllNotificationsAsync", anyTypeArr4, function12);
                                } else {
                                    asyncFunctionComponent2 = new AsyncFunctionComponent("dismissAllNotificationsAsync", anyTypeArr4, function12);
                                }
                            } else {
                                asyncFunctionComponent2 = new FloatAsyncFunctionComponent("dismissAllNotificationsAsync", anyTypeArr4, function12);
                            }
                        } else {
                            asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("dismissAllNotificationsAsync", anyTypeArr4, function12);
                        }
                    } else {
                        asyncFunctionComponent2 = new BoolAsyncFunctionComponent("dismissAllNotificationsAsync", anyTypeArr4, function12);
                    }
                } else {
                    asyncFunctionComponent2 = new IntAsyncFunctionComponent("dismissAllNotificationsAsync", anyTypeArr4, function12);
                }
                asyncFunctionWithPromiseComponent2 = asyncFunctionComponent2;
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("dismissAllNotificationsAsync", asyncFunctionWithPromiseComponent2);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    protected void dismissNotificationAsync(String identifier, final Promise promise) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(promise, "promise");
        NotificationsService.INSTANCE.dismiss(getContext(), new String[]{identifier}, createResultReceiver(new Function2<Integer, Bundle, Unit>() { // from class: expo.modules.notifications.notifications.presentation.ExpoNotificationPresentationModule.dismissNotificationAsync.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Bundle bundle) {
                invoke(num.intValue(), bundle);
                return Unit.INSTANCE;
            }

            public final void invoke(int i, Bundle bundle) {
                if (i == 0) {
                    promise.resolve((Object) null);
                } else {
                    Serializable serializable = bundle != null ? bundle.getSerializable("exception") : null;
                    promise.reject("ERR_NOTIFICATION_DISMISSAL_FAILED", "Notification could not be dismissed.", serializable instanceof Exception ? (Exception) serializable : null);
                }
            }
        }));
    }

    protected void dismissAllNotificationsAsync(final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        NotificationsService.INSTANCE.dismissAll(getContext(), createResultReceiver(new Function2<Integer, Bundle, Unit>() { // from class: expo.modules.notifications.notifications.presentation.ExpoNotificationPresentationModule.dismissAllNotificationsAsync.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Bundle bundle) {
                invoke(num.intValue(), bundle);
                return Unit.INSTANCE;
            }

            public final void invoke(int i, Bundle bundle) {
                if (i == 0) {
                    promise.resolve((Object) null);
                } else {
                    Serializable serializable = bundle != null ? bundle.getSerializable("exception") : null;
                    promise.reject("ERR_NOTIFICATIONS_DISMISSAL_FAILED", "Notifications could not be dismissed.", serializable instanceof Exception ? (Exception) serializable : null);
                }
            }
        }));
    }

    protected NotificationRequest createNotificationRequest(String identifier, INotificationContent content, NotificationTrigger trigger) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(content, "content");
        return new NotificationRequest(identifier, content, null);
    }

    protected List<Bundle> serializeNotifications(Collection<? extends Notification> notifications) {
        Intrinsics.checkNotNullParameter(notifications, "notifications");
        Collection<? extends Notification> collection = notifications;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(NotificationSerializer.toBundle((Notification) it.next()));
        }
        return arrayList;
    }
}
