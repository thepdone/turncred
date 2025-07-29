package expo.modules.notifications.notifications.channels;

import android.app.NotificationChannel;
import android.os.Bundle;
import androidx.tracing.Trace;
import expo.modules.core.arguments.ReadableArguments;
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
import expo.modules.notifications.notifications.channels.managers.NotificationsChannelManager;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import expo.modules.notifications.notifications.enums.NotificationImportance;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
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

/* compiled from: NotificationChannelManagerModule.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lexpo/modules/notifications/notifications/channels/NotificationChannelManagerModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "channelManager", "Lexpo/modules/notifications/notifications/channels/managers/NotificationsChannelManager;", "channelSerializer", "Lexpo/modules/notifications/notifications/channels/serializers/NotificationsChannelSerializer;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "getImportanceFromOptions", "", "channelOptions", "Lexpo/modules/core/arguments/ReadableArguments;", "getNameFromOptions", "", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class NotificationChannelManagerModule extends Module {
    private NotificationsChannelManager channelManager;
    private NotificationsChannelSerializer channelSerializer;

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        AsyncFunctionComponent asyncFunctionComponent3;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        NotificationChannelManagerModule notificationChannelManagerModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (notificationChannelManagerModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(notificationChannelManagerModule);
            moduleDefinitionBuilder.Name("ExpoNotificationChannelManager");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelManagerModule$definition$lambda$5$$inlined$OnCreate$1
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
                    try {
                        module = this.this$0.getAppContext().getLegacyModuleRegistry().getModule(NotificationsChannelsProvider.class);
                    } catch (Exception unused) {
                        module = null;
                    }
                    NotificationsChannelsProvider notificationsChannelsProvider = (NotificationsChannelsProvider) module;
                    if (notificationsChannelsProvider == null) {
                        throw new ModuleNotFoundException(Reflection.getOrCreateKotlinClass(NotificationsChannelsProvider.class));
                    }
                    this.this$0.channelManager = notificationsChannelsProvider.getChannelManager();
                    this.this$0.channelSerializer = notificationsChannelsProvider.getChannelSerializer();
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[0];
            Function1<Object[], List<? extends Bundle>> function1 = new Function1<Object[], List<? extends Bundle>>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelManagerModule$definition$lambda$5$$inlined$AsyncFunction$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final List<? extends Bundle> invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    NotificationsChannelManager notificationsChannelManager = this.this$0.channelManager;
                    NotificationsChannelSerializer notificationsChannelSerializer = null;
                    if (notificationsChannelManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("channelManager");
                        notificationsChannelManager = null;
                    }
                    List<NotificationChannel> notificationChannels = notificationsChannelManager.getNotificationChannels();
                    Intrinsics.checkNotNullExpressionValue(notificationChannels, "getNotificationChannels(...)");
                    List<NotificationChannel> list = notificationChannels;
                    NotificationsChannelSerializer notificationsChannelSerializer2 = this.this$0.channelSerializer;
                    if (notificationsChannelSerializer2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("channelSerializer");
                    } else {
                        notificationsChannelSerializer = notificationsChannelSerializer2;
                    }
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator<T> it2 = list.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(notificationsChannelSerializer.toBundle((NotificationChannel) it2.next()));
                    }
                    return arrayList;
                }
            };
            if (!Intrinsics.areEqual(List.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(List.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(List.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(List.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(List.class, String.class)) {
                                asyncFunctionComponent = new StringAsyncFunctionComponent("getNotificationChannelsAsync", anyTypeArr, function1);
                            } else {
                                asyncFunctionComponent = new AsyncFunctionComponent("getNotificationChannelsAsync", anyTypeArr, function1);
                            }
                        } else {
                            asyncFunctionComponent = new FloatAsyncFunctionComponent("getNotificationChannelsAsync", anyTypeArr, function1);
                        }
                    } else {
                        asyncFunctionComponent = new DoubleAsyncFunctionComponent("getNotificationChannelsAsync", anyTypeArr, function1);
                    }
                } else {
                    asyncFunctionComponent = new BoolAsyncFunctionComponent("getNotificationChannelsAsync", anyTypeArr, function1);
                }
            } else {
                asyncFunctionComponent = new IntAsyncFunctionComponent("getNotificationChannelsAsync", anyTypeArr, function1);
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("getNotificationChannelsAsync", asyncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionComponent2 = new AsyncFunctionWithPromiseComponent("getNotificationChannelAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelManagerModule$definition$lambda$5$$inlined$AsyncFunction$2
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        String str = (String) promise;
                        NotificationsChannelManager notificationsChannelManager = this.this$0.channelManager;
                        NotificationsChannelSerializer notificationsChannelSerializer = null;
                        if (notificationsChannelManager == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("channelManager");
                            notificationsChannelManager = null;
                        }
                        NotificationChannel notificationChannel = notificationsChannelManager.getNotificationChannel(str);
                        NotificationsChannelSerializer notificationsChannelSerializer2 = this.this$0.channelSerializer;
                        if (notificationsChannelSerializer2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("channelSerializer");
                        } else {
                            notificationsChannelSerializer = notificationsChannelSerializer2;
                        }
                        notificationsChannelSerializer.toBundle(notificationChannel);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr2 = new AnyType[1];
                AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                if (anyType == null) {
                    anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelManagerModule$definition$lambda$5$$inlined$AsyncFunction$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                }
                anyTypeArr2[0] = anyType;
                asyncFunctionComponent2 = new AsyncFunctionComponent("getNotificationChannelAsync", anyTypeArr2, new Function1<Object[], Bundle>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelManagerModule$definition$lambda$5$$inlined$AsyncFunction$4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Bundle invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        String str = (String) objArr[0];
                        NotificationsChannelManager notificationsChannelManager = this.this$0.channelManager;
                        NotificationsChannelSerializer notificationsChannelSerializer = null;
                        if (notificationsChannelManager == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("channelManager");
                            notificationsChannelManager = null;
                        }
                        NotificationChannel notificationChannel = notificationsChannelManager.getNotificationChannel(str);
                        NotificationsChannelSerializer notificationsChannelSerializer2 = this.this$0.channelSerializer;
                        if (notificationsChannelSerializer2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("channelSerializer");
                        } else {
                            notificationsChannelSerializer = notificationsChannelSerializer2;
                        }
                        return notificationsChannelSerializer.toBundle(notificationChannel);
                    }
                });
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("getNotificationChannelAsync", asyncFunctionComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr3 = new AnyType[2];
            AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelManagerModule$definition$lambda$5$$inlined$AsyncFunction$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr3[0] = anyType2;
            AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false));
            if (anyType3 == null) {
                anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelManagerModule$definition$lambda$5$$inlined$AsyncFunction$6
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(ReadableArguments.class);
                    }
                }));
            }
            anyTypeArr3[1] = anyType3;
            moduleDefinitionBuilder4.getAsyncFunctions().put("setNotificationChannelAsync", new AsyncFunctionComponent("setNotificationChannelAsync", anyTypeArr3, new Function1<Object[], Bundle>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelManagerModule$definition$lambda$5$$inlined$AsyncFunction$7
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Bundle invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    ReadableArguments readableArguments = (ReadableArguments) objArr[1];
                    String str = (String) obj;
                    NotificationsChannelManager notificationsChannelManager = this.this$0.channelManager;
                    NotificationsChannelSerializer notificationsChannelSerializer = null;
                    if (notificationsChannelManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("channelManager");
                        notificationsChannelManager = null;
                    }
                    NotificationChannel notificationChannelCreateNotificationChannel = notificationsChannelManager.createNotificationChannel(str, this.this$0.getNameFromOptions(readableArguments), this.this$0.getImportanceFromOptions(readableArguments), readableArguments);
                    NotificationsChannelSerializer notificationsChannelSerializer2 = this.this$0.channelSerializer;
                    if (notificationsChannelSerializer2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("channelSerializer");
                    } else {
                        notificationsChannelSerializer = notificationsChannelSerializer2;
                    }
                    return notificationsChannelSerializer.toBundle(notificationChannelCreateNotificationChannel);
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("deleteNotificationChannelAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelManagerModule$definition$lambda$5$$inlined$AsyncFunction$8
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        String str = (String) promise;
                        NotificationsChannelManager notificationsChannelManager = this.this$0.channelManager;
                        if (notificationsChannelManager == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("channelManager");
                            notificationsChannelManager = null;
                        }
                        notificationsChannelManager.deleteNotificationChannel(str);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr4 = new AnyType[1];
                AnyType anyType4 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                if (anyType4 == null) {
                    anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelManagerModule$definition$lambda$5$$inlined$AsyncFunction$9
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }));
                }
                anyTypeArr4[0] = anyType4;
                Function1<Object[], Unit> function12 = new Function1<Object[], Unit>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelManagerModule$definition$lambda$5$$inlined$AsyncFunction$10
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        String str = (String) objArr[0];
                        NotificationsChannelManager notificationsChannelManager = this.this$0.channelManager;
                        if (notificationsChannelManager == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("channelManager");
                            notificationsChannelManager = null;
                        }
                        notificationsChannelManager.deleteNotificationChannel(str);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent3 = new StringAsyncFunctionComponent("deleteNotificationChannelAsync", anyTypeArr4, function12);
                                } else {
                                    asyncFunctionComponent3 = new AsyncFunctionComponent("deleteNotificationChannelAsync", anyTypeArr4, function12);
                                }
                            } else {
                                asyncFunctionComponent3 = new FloatAsyncFunctionComponent("deleteNotificationChannelAsync", anyTypeArr4, function12);
                            }
                        } else {
                            asyncFunctionComponent3 = new DoubleAsyncFunctionComponent("deleteNotificationChannelAsync", anyTypeArr4, function12);
                        }
                    } else {
                        asyncFunctionComponent3 = new BoolAsyncFunctionComponent("deleteNotificationChannelAsync", anyTypeArr4, function12);
                    }
                } else {
                    asyncFunctionComponent3 = new IntAsyncFunctionComponent("deleteNotificationChannelAsync", anyTypeArr4, function12);
                }
                asyncFunctionWithPromiseComponent = asyncFunctionComponent3;
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("deleteNotificationChannelAsync", asyncFunctionWithPromiseComponent);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CharSequence getNameFromOptions(ReadableArguments channelOptions) {
        String string = channelOptions.getString("name");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getImportanceFromOptions(ReadableArguments channelOptions) {
        return ((NotificationImportance) Objects.requireNonNull(NotificationImportance.fromEnumValue(channelOptions.getInt(NotificationsChannelSerializer.IMPORTANCE_KEY, NotificationImportance.DEFAULT.getEnumValue())))).getNativeValue();
    }
}
