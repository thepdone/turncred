package expo.modules.notifications.notifications.categories;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.tracing.Trace;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.core.errors.InvalidArgumentException;
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
import expo.modules.notifications.ModuleNotFoundException;
import expo.modules.notifications.UtilsKt;
import expo.modules.notifications.notifications.categories.NotificationActionRecord;
import expo.modules.notifications.notifications.categories.serializers.NotificationsCategoriesSerializer;
import expo.modules.notifications.notifications.model.NotificationAction;
import expo.modules.notifications.notifications.model.NotificationCategory;
import expo.modules.notifications.notifications.model.TextInputNotificationAction;
import expo.modules.notifications.service.NotificationsService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
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
import kotlin.reflect.KTypeProjection;

/* compiled from: ExpoNotificationCategoriesModule.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JF\u0010\r\u001a\u00020\u000e2<\u0010\u000f\u001a8\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0010j\u0002`\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001e\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0014J>\u0010%\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0!2\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010*\u0018\u00010)2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006+"}, d2 = {"Lexpo/modules/notifications/notifications/categories/ExpoNotificationCategoriesModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "serializer", "Lexpo/modules/notifications/notifications/categories/serializers/NotificationsCategoriesSerializer;", "getSerializer", "()Lexpo/modules/notifications/notifications/categories/serializers/NotificationsCategoriesSerializer;", "serializer$delegate", "Lkotlin/Lazy;", "createResultReceiver", "Landroid/os/ResultReceiver;", "body", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "resultCode", "Landroid/os/Bundle;", "resultData", "", "Lexpo/modules/notifications/ResultReceiverBody;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "deleteNotificationCategoryAsync", "identifier", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "serializeCategories", "", "categories", "", "Lexpo/modules/notifications/notifications/model/NotificationCategory;", "setNotificationCategoryAsync", "actionArguments", "Lexpo/modules/notifications/notifications/categories/NotificationActionRecord;", "categoryOptions", "", "", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class ExpoNotificationCategoriesModule extends Module {

    /* renamed from: serializer$delegate, reason: from kotlin metadata */
    private final Lazy serializer = LazyKt.lazy(new Function0<NotificationsCategoriesSerializer>() { // from class: expo.modules.notifications.notifications.categories.ExpoNotificationCategoriesModule$serializer$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NotificationsCategoriesSerializer invoke() throws ModuleNotFoundException {
            Object module;
            try {
                module = this.this$0.getAppContext().getLegacyModuleRegistry().getModule(NotificationsCategoriesSerializer.class);
            } catch (Exception unused) {
                module = null;
            }
            NotificationsCategoriesSerializer notificationsCategoriesSerializer = (NotificationsCategoriesSerializer) module;
            if (notificationsCategoriesSerializer != null) {
                return notificationsCategoriesSerializer;
            }
            throw new ModuleNotFoundException(Reflection.getOrCreateKotlinClass(NotificationsCategoriesSerializer.class));
        }
    });

    protected final NotificationsCategoriesSerializer getSerializer() {
        return (NotificationsCategoriesSerializer) this.serializer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() throws Exceptions.ReactContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        ExpoNotificationCategoriesModule expoNotificationCategoriesModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (expoNotificationCategoriesModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(expoNotificationCategoriesModule);
            moduleDefinitionBuilder.Name("ExpoNotificationCategoriesModule");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("getNotificationCategoriesAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.notifications.categories.ExpoNotificationCategoriesModule$definition$lambda$2$$inlined$AsyncFunction$1
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
                        NotificationsService.INSTANCE.getCategories(this.this$0.getContext(), this.this$0.createResultReceiver(new ExpoNotificationCategoriesModule$definition$1$1$1(promise, this.this$0)));
                    }
                });
            } else {
                AnyType[] anyTypeArr = new AnyType[1];
                AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType == null) {
                    anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.categories.ExpoNotificationCategoriesModule$definition$lambda$2$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Promise.class);
                        }
                    }));
                }
                anyTypeArr[0] = anyType;
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.notifications.notifications.categories.ExpoNotificationCategoriesModule$definition$lambda$2$$inlined$AsyncFunction$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        NotificationsService.INSTANCE.getCategories(this.this$0.getContext(), this.this$0.createResultReceiver(new ExpoNotificationCategoriesModule$definition$1$1$1((Promise) objArr[0], this.this$0)));
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent = new StringAsyncFunctionComponent("getNotificationCategoriesAsync", anyTypeArr, function1);
                                } else {
                                    asyncFunctionComponent = new AsyncFunctionComponent("getNotificationCategoriesAsync", anyTypeArr, function1);
                                }
                            } else {
                                asyncFunctionComponent = new FloatAsyncFunctionComponent("getNotificationCategoriesAsync", anyTypeArr, function1);
                            }
                        } else {
                            asyncFunctionComponent = new DoubleAsyncFunctionComponent("getNotificationCategoriesAsync", anyTypeArr, function1);
                        }
                    } else {
                        asyncFunctionComponent = new BoolAsyncFunctionComponent("getNotificationCategoriesAsync", anyTypeArr, function1);
                    }
                } else {
                    asyncFunctionComponent = new IntAsyncFunctionComponent("getNotificationCategoriesAsync", anyTypeArr, function1);
                }
                asyncFunctionWithPromiseComponent = asyncFunctionComponent;
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("getNotificationCategoriesAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr2 = new AnyType[3];
            AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.categories.ExpoNotificationCategoriesModule$definition$lambda$2$$inlined$AsyncFunctionWithPromise$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr2[0] = anyType2;
            AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(List.class), false));
            if (anyType3 == null) {
                anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.categories.ExpoNotificationCategoriesModule$definition$lambda$2$$inlined$AsyncFunctionWithPromise$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(NotificationActionRecord.class)));
                    }
                }));
            }
            anyTypeArr2[1] = anyType3;
            AnyType anyType4 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Map.class), true));
            if (anyType4 == null) {
                anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Map.class), true, new Function0<KType>() { // from class: expo.modules.notifications.notifications.categories.ExpoNotificationCategoriesModule$definition$lambda$2$$inlined$AsyncFunctionWithPromise$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.nullableTypeOf(Object.class)));
                    }
                }));
            }
            anyTypeArr2[2] = anyType4;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("setNotificationCategoryAsync", anyTypeArr2, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.notifications.categories.ExpoNotificationCategoriesModule$definition$lambda$2$$inlined$AsyncFunctionWithPromise$4
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    Map<String, ? extends Object> map = (Map) objArr[2];
                    ExpoNotificationCategoriesModule expoNotificationCategoriesModule2 = this.$receiver$inlined;
                    expoNotificationCategoriesModule2.setNotificationCategoryAsync((String) obj, (List) obj2, map, promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder3.getAsyncFunctions().put("setNotificationCategoryAsync", asyncFunctionWithPromiseComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr3 = new AnyType[1];
            AnyType anyType5 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType5 == null) {
                anyType5 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.categories.ExpoNotificationCategoriesModule$definition$lambda$2$$inlined$AsyncFunctionWithPromise$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr3[0] = anyType5;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent("deleteNotificationCategoryAsync", anyTypeArr3, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.notifications.categories.ExpoNotificationCategoriesModule$definition$lambda$2$$inlined$AsyncFunctionWithPromise$6
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    this.$receiver$inlined.deleteNotificationCategoryAsync((String) objArr[0], promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder4.getAsyncFunctions().put("deleteNotificationCategoryAsync", asyncFunctionWithPromiseComponent3);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ResultReceiver createResultReceiver(Function2<? super Integer, ? super Bundle, Unit> body) {
        return UtilsKt.createDefaultResultReceiver(null, body);
    }

    public void setNotificationCategoryAsync(String identifier, List<NotificationActionRecord> actionArguments, Map<String, ? extends Object> categoryOptions, final Promise promise) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(actionArguments, "actionArguments");
        Intrinsics.checkNotNullParameter(promise, "promise");
        ArrayList arrayList = new ArrayList();
        for (NotificationActionRecord notificationActionRecord : actionArguments) {
            NotificationActionRecord.TextInput textInput = notificationActionRecord.getTextInput();
            if (textInput != null) {
                arrayList.add(new TextInputNotificationAction(notificationActionRecord.getIdentifier(), notificationActionRecord.getButtonTitle(), notificationActionRecord.getOptions().getOpensAppToForeground(), textInput.getPlaceholder()));
            } else {
                arrayList.add(new NotificationAction(notificationActionRecord.getIdentifier(), notificationActionRecord.getButtonTitle(), notificationActionRecord.getOptions().getOpensAppToForeground()));
            }
        }
        if (arrayList.isEmpty()) {
            throw new InvalidArgumentException("Invalid arguments provided for notification category. Must provide at least one action.");
        }
        NotificationsService.INSTANCE.setCategory(getContext(), new NotificationCategory(identifier, arrayList), createResultReceiver(new Function2<Integer, Bundle, Unit>() { // from class: expo.modules.notifications.notifications.categories.ExpoNotificationCategoriesModule.setNotificationCategoryAsync.1
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
                NotificationCategory notificationCategory = bundle != null ? (NotificationCategory) bundle.getParcelable(NotificationsService.NOTIFICATION_CATEGORY_KEY) : null;
                if (i == 0 && notificationCategory != null) {
                    promise.resolve(this.getSerializer().toBundle(notificationCategory));
                } else {
                    promise.reject("ERR_CATEGORY_SET_FAILED", "The provided category could not be set.", null);
                }
            }
        }));
    }

    public void deleteNotificationCategoryAsync(String identifier, final Promise promise) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(promise, "promise");
        NotificationsService.INSTANCE.deleteCategory(getContext(), identifier, createResultReceiver(new Function2<Integer, Bundle, Unit>() { // from class: expo.modules.notifications.notifications.categories.ExpoNotificationCategoriesModule.deleteNotificationCategoryAsync.1
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
                    promise.resolve(bundle != null ? Boolean.valueOf(bundle.getBoolean("succeeded")) : null);
                } else {
                    promise.reject("ERR_CATEGORY_DELETE_FAILED", "The category could not be deleted.", null);
                }
            }
        }));
    }

    protected List<Bundle> serializeCategories(Collection<? extends NotificationCategory> categories) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        Collection<? extends NotificationCategory> collection = categories;
        NotificationsCategoriesSerializer serializer = getSerializer();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(serializer.toBundle((NotificationCategory) it.next()));
        }
        return arrayList;
    }
}
