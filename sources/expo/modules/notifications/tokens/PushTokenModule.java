package expo.modules.notifications.tokens;

import android.os.Bundle;
import androidx.tracing.Trace;
import com.facebook.react.bridge.BaseJavaModule;
import com.google.firebase.messaging.FirebaseMessaging;
import expo.modules.core.interfaces.services.EventEmitter;
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
import expo.modules.notifications.ModuleNotFoundException;
import expo.modules.notifications.tokens.interfaces.PushTokenListener;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: PushTokenModule.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lexpo/modules/notifications/tokens/PushTokenModule;", "Lexpo/modules/kotlin/modules/Module;", "Lexpo/modules/notifications/tokens/interfaces/PushTokenListener;", "()V", "eventEmitter", "Lexpo/modules/core/interfaces/services/EventEmitter;", "tokenManager", "Lexpo/modules/notifications/tokens/interfaces/PushTokenManager;", "getTokenManager", "()Lexpo/modules/notifications/tokens/interfaces/PushTokenManager;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "getFirebaseMessagingInstance", "Lcom/google/firebase/messaging/FirebaseMessaging;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "onNewToken", "", "token", "", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PushTokenModule extends Module implements PushTokenListener {
    private EventEmitter eventEmitter;

    /* JADX INFO: Access modifiers changed from: private */
    public final expo.modules.notifications.tokens.interfaces.PushTokenManager getTokenManager() {
        return (expo.modules.notifications.tokens.interfaces.PushTokenManager) getAppContext().getLegacyModuleRegistry().getSingletonModule("PushTokenManager", expo.modules.notifications.tokens.interfaces.PushTokenManager.class);
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2;
        PushTokenModule pushTokenModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (pushTokenModule.getClass() + ".ModuleDefinition"));
        try {
            final ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(pushTokenModule);
            moduleDefinitionBuilder.Name("ExpoPushTokenManager");
            moduleDefinitionBuilder.Events("onDevicePushToken");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.notifications.tokens.PushTokenModule$definition$lambda$4$$inlined$OnCreate$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() throws ModuleNotFoundException {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() throws ModuleNotFoundException {
                    Object module;
                    PushTokenModule pushTokenModule2 = this.this$0;
                    try {
                        module = pushTokenModule2.getAppContext().getLegacyModuleRegistry().getModule(EventEmitter.class);
                    } catch (Exception unused) {
                        module = null;
                    }
                    EventEmitter eventEmitter = (EventEmitter) module;
                    if (eventEmitter != null) {
                        pushTokenModule2.eventEmitter = eventEmitter;
                        expo.modules.notifications.tokens.interfaces.PushTokenManager tokenManager = this.this$0.getTokenManager();
                        if (tokenManager != null) {
                            tokenManager.addListener(this.this$0);
                            return;
                        }
                        return;
                    }
                    throw new ModuleNotFoundException(Reflection.getOrCreateKotlinClass(EventEmitter.class));
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.notifications.tokens.PushTokenModule$definition$lambda$4$$inlined$OnDestroy$1
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
                    expo.modules.notifications.tokens.interfaces.PushTokenManager tokenManager = this.this$0.getTokenManager();
                    if (tokenManager != null) {
                        tokenManager.removeListener(this.this$0);
                    }
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("getDevicePushTokenAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.tokens.PushTokenModule$definition$lambda$4$$inlined$AsyncFunction$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        FirebaseMessaging firebaseMessagingInstance = this.this$0.getFirebaseMessagingInstance(promise);
                        if (firebaseMessagingInstance == null) {
                            return;
                        }
                        firebaseMessagingInstance.getToken().addOnCompleteListener(new PushTokenModule$definition$1$3$1(promise, moduleDefinitionBuilder, this.this$0));
                    }
                });
            } else {
                AnyType[] anyTypeArr = new AnyType[1];
                AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType == null) {
                    anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.notifications.tokens.PushTokenModule$definition$lambda$4$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Promise.class);
                        }
                    }));
                }
                anyTypeArr[0] = anyType;
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.notifications.tokens.PushTokenModule$definition$lambda$4$$inlined$AsyncFunction$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Promise promise = (Promise) objArr[0];
                        FirebaseMessaging firebaseMessagingInstance = this.this$0.getFirebaseMessagingInstance(promise);
                        if (firebaseMessagingInstance != null) {
                            firebaseMessagingInstance.getToken().addOnCompleteListener(new PushTokenModule$definition$1$3$1(promise, moduleDefinitionBuilder, this.this$0));
                        }
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent = new StringAsyncFunctionComponent("getDevicePushTokenAsync", anyTypeArr, function1);
                                } else {
                                    asyncFunctionComponent = new AsyncFunctionComponent("getDevicePushTokenAsync", anyTypeArr, function1);
                                }
                            } else {
                                asyncFunctionComponent = new FloatAsyncFunctionComponent("getDevicePushTokenAsync", anyTypeArr, function1);
                            }
                        } else {
                            asyncFunctionComponent = new DoubleAsyncFunctionComponent("getDevicePushTokenAsync", anyTypeArr, function1);
                        }
                    } else {
                        asyncFunctionComponent = new BoolAsyncFunctionComponent("getDevicePushTokenAsync", anyTypeArr, function1);
                    }
                } else {
                    asyncFunctionComponent = new IntAsyncFunctionComponent("getDevicePushTokenAsync", anyTypeArr, function1);
                }
                asyncFunctionWithPromiseComponent = asyncFunctionComponent;
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("getDevicePushTokenAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("unregisterForNotificationsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.tokens.PushTokenModule$definition$lambda$4$$inlined$AsyncFunction$4
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
                        FirebaseMessaging firebaseMessagingInstance = this.this$0.getFirebaseMessagingInstance(promise);
                        if (firebaseMessagingInstance == null) {
                            return;
                        }
                        firebaseMessagingInstance.deleteToken().addOnCompleteListener(new PushTokenModule$definition$1$4$1(promise));
                    }
                });
            } else {
                AnyType[] anyTypeArr2 = new AnyType[1];
                AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType2 == null) {
                    anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.notifications.tokens.PushTokenModule$definition$lambda$4$$inlined$AsyncFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Promise.class);
                        }
                    }));
                }
                anyTypeArr2[0] = anyType2;
                Function1<Object[], Unit> function12 = new Function1<Object[], Unit>() { // from class: expo.modules.notifications.tokens.PushTokenModule$definition$lambda$4$$inlined$AsyncFunction$6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Promise promise = (Promise) objArr[0];
                        FirebaseMessaging firebaseMessagingInstance = this.this$0.getFirebaseMessagingInstance(promise);
                        if (firebaseMessagingInstance != null) {
                            firebaseMessagingInstance.deleteToken().addOnCompleteListener(new PushTokenModule$definition$1$4$1(promise));
                        }
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent2 = new StringAsyncFunctionComponent("unregisterForNotificationsAsync", anyTypeArr2, function12);
                                } else {
                                    asyncFunctionComponent2 = new AsyncFunctionComponent("unregisterForNotificationsAsync", anyTypeArr2, function12);
                                }
                            } else {
                                asyncFunctionComponent2 = new FloatAsyncFunctionComponent("unregisterForNotificationsAsync", anyTypeArr2, function12);
                            }
                        } else {
                            asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("unregisterForNotificationsAsync", anyTypeArr2, function12);
                        }
                    } else {
                        asyncFunctionComponent2 = new BoolAsyncFunctionComponent("unregisterForNotificationsAsync", anyTypeArr2, function12);
                    }
                } else {
                    asyncFunctionComponent2 = new IntAsyncFunctionComponent("unregisterForNotificationsAsync", anyTypeArr2, function12);
                }
                asyncFunctionWithPromiseComponent2 = asyncFunctionComponent2;
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("unregisterForNotificationsAsync", asyncFunctionWithPromiseComponent2);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FirebaseMessaging getFirebaseMessagingInstance(Promise promise) {
        try {
            return FirebaseMessaging.getInstance();
        } catch (IllegalStateException e) {
            promise.reject("E_REGISTRATION_FAILED", "Make sure to complete the guide at https://docs.expo.dev/push-notifications/fcm-credentials/ : " + e.getMessage(), e);
            return null;
        }
    }

    @Override // expo.modules.notifications.tokens.interfaces.PushTokenListener
    public void onNewToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        EventEmitter eventEmitter = this.eventEmitter;
        if (eventEmitter != null) {
            Bundle bundle = new Bundle();
            bundle.putString("devicePushToken", token);
            eventEmitter.emit("onDevicePushToken", bundle);
        }
    }
}
