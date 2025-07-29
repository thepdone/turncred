package expo.modules.fetch;

import android.content.Context;
import android.util.Log;
import androidx.tracing.Trace;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.network.CookieJarContainer;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.core.errors.ModuleDestroyedException;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.classcomponent.ClassComponentBuilder;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.exception.UnexpectedException;
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
import expo.modules.kotlin.objects.PropertyComponentBuilderWithThis;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeProvider;
import java.net.URL;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import okhttp3.CookieJar;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;

/* compiled from: ExpoFetchModule.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lexpo/modules/fetch/ExpoFetchModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "client", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "client$delegate", "Lkotlin/Lazy;", "cookieHandler", "Lcom/facebook/react/modules/network/ForwardingCookieHandler;", "getCookieHandler", "()Lcom/facebook/react/modules/network/ForwardingCookieHandler;", "cookieHandler$delegate", "cookieJarContainer", "Lcom/facebook/react/modules/network/CookieJarContainer;", "getCookieJarContainer", "()Lcom/facebook/react/modules/network/CookieJarContainer;", "cookieJarContainer$delegate", "moduleCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getModuleCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "moduleCoroutineScope$delegate", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "getReactContext", "()Lcom/facebook/react/bridge/ReactContext;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "Companion", "expo_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExpoFetchModule extends Module {
    private static final String TAG = "ExpoFetchModule";

    /* renamed from: client$delegate, reason: from kotlin metadata */
    private final Lazy client = LazyKt.lazy(new Function0<OkHttpClient>() { // from class: expo.modules.fetch.ExpoFetchModule$client$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final OkHttpClient invoke() {
            return OkHttpClientProvider.createClient(this.this$0.getReactContext()).newBuilder().addInterceptor(new OkHttpFileUrlInterceptor(this.this$0.getReactContext())).build();
        }
    });

    /* renamed from: cookieHandler$delegate, reason: from kotlin metadata */
    private final Lazy cookieHandler = LazyKt.lazy(new Function0<ForwardingCookieHandler>() { // from class: expo.modules.fetch.ExpoFetchModule$cookieHandler$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ForwardingCookieHandler invoke() {
            return new ForwardingCookieHandler(this.this$0.getReactContext());
        }
    });

    /* renamed from: cookieJarContainer$delegate, reason: from kotlin metadata */
    private final Lazy cookieJarContainer = LazyKt.lazy(new Function0<CookieJarContainer>() { // from class: expo.modules.fetch.ExpoFetchModule$cookieJarContainer$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CookieJarContainer invoke() {
            CookieJar cookieJar = this.this$0.getClient().cookieJar();
            Intrinsics.checkNotNull(cookieJar, "null cannot be cast to non-null type com.facebook.react.modules.network.CookieJarContainer");
            return (CookieJarContainer) cookieJar;
        }
    });

    /* renamed from: moduleCoroutineScope$delegate, reason: from kotlin metadata */
    private final Lazy moduleCoroutineScope = LazyKt.lazy(new Function0<CoroutineScope>() { // from class: expo.modules.fetch.ExpoFetchModule$moduleCoroutineScope$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final CoroutineScope invoke() {
            return CoroutineScopeKt.CoroutineScope(this.this$0.getAppContext().getModulesQueue().getCoroutineContext().plus(new CoroutineName("expo.modules.fetch.CoroutineScope")));
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final OkHttpClient getClient() {
        return (OkHttpClient) this.client.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ForwardingCookieHandler getCookieHandler() {
        return (ForwardingCookieHandler) this.cookieHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CookieJarContainer getCookieJarContainer() {
        return (CookieJarContainer) this.cookieJarContainer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReactContext getReactContext() throws Exceptions.ReactContextLost {
        Context reactContext = getAppContext().getReactContext();
        ReactContext reactContext2 = reactContext instanceof ReactContext ? (ReactContext) reactContext : null;
        if (reactContext2 != null) {
            return reactContext2;
        }
        throw new Exceptions.ReactContextLost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope getModuleCoroutineScope() {
        return (CoroutineScope) this.moduleCoroutineScope.getValue();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionWithPromiseComponent intAsyncFunctionComponent;
        ExpoFetchModule expoFetchModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (expoFetchModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(expoFetchModule);
            moduleDefinitionBuilder.Name("ExpoFetchModule");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$$inlined$OnCreate$1
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
                    this.this$0.getCookieJarContainer().setCookieJar(new JavaNetCookieJar(this.this$0.getCookieHandler()));
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$$inlined$OnDestroy$1
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
                    this.this$0.getCookieHandler().destroy();
                    this.this$0.getCookieJarContainer().removeCookieJar();
                    try {
                        CoroutineScopeKt.cancel(this.this$0.getModuleCoroutineScope(), new ModuleDestroyedException(null, 1, null));
                    } catch (IllegalStateException unused) {
                        Log.e(ExpoFetchModule.TAG, "The scope does not have a job in it");
                    }
                }
            }));
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(NativeResponse.class);
            String simpleName = JvmClassMappingKt.getJavaClass(orCreateKotlinClass).getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(NativeResponse.class), false));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeResponse.class), false, new Function0<KType>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$$inlined$Class$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(NativeResponse.class);
                    }
                }));
            }
            ClassComponentBuilder classComponentBuilder = new ClassComponentBuilder(simpleName, orCreateKotlinClass, anyType);
            AnyType[] anyTypeArr = new AnyType[0];
            ReturnType returnType = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
            if (returnType == null) {
                returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
            }
            classComponentBuilder.setConstructor(new SyncFunctionComponent("constructor", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$13$$inlined$Constructor$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new NativeResponse(this.this$0.getAppContext(), this.this$0.getModuleCoroutineScope());
                }
            }));
            ClassComponentBuilder classComponentBuilder2 = classComponentBuilder;
            if (Intrinsics.areEqual(NativeResponse.class, Promise.class)) {
                asyncFunctionComponent = new AsyncFunctionWithPromiseComponent("startStreaming", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$13$$inlined$AsyncFunction$1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        ((NativeResponse) promise).startStreaming();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr2 = new AnyType[1];
                AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(NativeResponse.class), false));
                if (anyType2 == null) {
                    anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeResponse.class), false, new Function0<KType>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$13$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(NativeResponse.class);
                        }
                    }));
                }
                anyTypeArr2[0] = anyType2;
                asyncFunctionComponent = new AsyncFunctionComponent("startStreaming", anyTypeArr2, new Function1<Object[], byte[]>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$13$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final byte[] invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        return ((NativeResponse) objArr[0]).startStreaming();
                    }
                });
            }
            classComponentBuilder2.getAsyncFunctions().put("startStreaming", asyncFunctionComponent);
            ClassComponentBuilder classComponentBuilder3 = classComponentBuilder;
            AnyType[] anyTypeArr3 = new AnyType[2];
            AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(NativeResponse.class), false));
            if (anyType3 == null) {
                anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeResponse.class), false, new Function0<KType>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$13$$inlined$AsyncFunction$4
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(NativeResponse.class);
                    }
                }));
            }
            anyTypeArr3[0] = anyType3;
            AnyType anyType4 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType4 == null) {
                anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$13$$inlined$AsyncFunction$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr3[1] = anyType4;
            Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$13$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    ((NativeResponse) obj).cancelStreaming();
                    return Unit.INSTANCE;
                }
            };
            classComponentBuilder3.getAsyncFunctions().put("cancelStreaming", Intrinsics.areEqual(Unit.class, Integer.TYPE) ? new IntAsyncFunctionComponent("cancelStreaming", anyTypeArr3, function1) : Intrinsics.areEqual(Unit.class, Boolean.TYPE) ? new BoolAsyncFunctionComponent("cancelStreaming", anyTypeArr3, function1) : Intrinsics.areEqual(Unit.class, Double.TYPE) ? new DoubleAsyncFunctionComponent("cancelStreaming", anyTypeArr3, function1) : Intrinsics.areEqual(Unit.class, Float.TYPE) ? new FloatAsyncFunctionComponent("cancelStreaming", anyTypeArr3, function1) : Intrinsics.areEqual(Unit.class, String.class) ? new StringAsyncFunctionComponent("cancelStreaming", anyTypeArr3, function1) : new AsyncFunctionComponent("cancelStreaming", anyTypeArr3, function1));
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis = new PropertyComponentBuilderWithThis(classComponentBuilder.getOwnerType().getKType(), "bodyUsed");
            AnyType[] anyTypeArr4 = {new AnyType(propertyComponentBuilderWithThis.getThisType())};
            ReturnType returnType2 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Boolean.class));
            if (returnType2 == null) {
                returnType2 = new ReturnType(Reflection.getOrCreateKotlinClass(Boolean.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Boolean.class), returnType2);
            }
            SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("get", anyTypeArr4, returnType2, new Function1<Object[], Object>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$13$$inlined$Property$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(((NativeResponse) it[0]).getBodyUsed());
                }
            });
            syncFunctionComponent.setOwnerType(propertyComponentBuilderWithThis.getThisType());
            syncFunctionComponent.setCanTakeOwner(true);
            propertyComponentBuilderWithThis.setGetter(syncFunctionComponent);
            classComponentBuilder.getProperties().put("bodyUsed", propertyComponentBuilderWithThis);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis2 = new PropertyComponentBuilderWithThis(classComponentBuilder.getOwnerType().getKType(), "_rawHeaders");
            AnyType[] anyTypeArr5 = {new AnyType(propertyComponentBuilderWithThis2.getThisType())};
            ReturnType returnType3 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(List.class));
            if (returnType3 == null) {
                returnType3 = new ReturnType(Reflection.getOrCreateKotlinClass(List.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(List.class), returnType3);
            }
            SyncFunctionComponent syncFunctionComponent2 = new SyncFunctionComponent("get", anyTypeArr5, returnType3, new Function1<Object[], Object>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$13$$inlined$Property$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    List<Pair<String, String>> headers;
                    Intrinsics.checkNotNullParameter(it, "it");
                    NativeResponseInit responseInit = ((NativeResponse) it[0]).getResponseInit();
                    return (responseInit == null || (headers = responseInit.getHeaders()) == null) ? CollectionsKt.emptyList() : headers;
                }
            });
            syncFunctionComponent2.setOwnerType(propertyComponentBuilderWithThis2.getThisType());
            syncFunctionComponent2.setCanTakeOwner(true);
            propertyComponentBuilderWithThis2.setGetter(syncFunctionComponent2);
            classComponentBuilder.getProperties().put("_rawHeaders", propertyComponentBuilderWithThis2);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis3 = new PropertyComponentBuilderWithThis(classComponentBuilder.getOwnerType().getKType(), "status");
            AnyType[] anyTypeArr6 = {new AnyType(propertyComponentBuilderWithThis3.getThisType())};
            ReturnType returnType4 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Integer.class));
            if (returnType4 == null) {
                returnType4 = new ReturnType(Reflection.getOrCreateKotlinClass(Integer.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Integer.class), returnType4);
            }
            SyncFunctionComponent syncFunctionComponent3 = new SyncFunctionComponent("get", anyTypeArr6, returnType4, new Function1<Object[], Object>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$13$$inlined$Property$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    NativeResponseInit responseInit = ((NativeResponse) it[0]).getResponseInit();
                    return Integer.valueOf(responseInit != null ? responseInit.getStatus() : -1);
                }
            });
            syncFunctionComponent3.setOwnerType(propertyComponentBuilderWithThis3.getThisType());
            syncFunctionComponent3.setCanTakeOwner(true);
            propertyComponentBuilderWithThis3.setGetter(syncFunctionComponent3);
            classComponentBuilder.getProperties().put("status", propertyComponentBuilderWithThis3);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis4 = new PropertyComponentBuilderWithThis(classComponentBuilder.getOwnerType().getKType(), "statusText");
            AnyType[] anyTypeArr7 = {new AnyType(propertyComponentBuilderWithThis4.getThisType())};
            ReturnType returnType5 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(String.class));
            if (returnType5 == null) {
                returnType5 = new ReturnType(Reflection.getOrCreateKotlinClass(String.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(String.class), returnType5);
            }
            SyncFunctionComponent syncFunctionComponent4 = new SyncFunctionComponent("get", anyTypeArr7, returnType5, new Function1<Object[], Object>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$13$$inlined$Property$4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String statusText;
                    Intrinsics.checkNotNullParameter(it, "it");
                    NativeResponseInit responseInit = ((NativeResponse) it[0]).getResponseInit();
                    return (responseInit == null || (statusText = responseInit.getStatusText()) == null) ? "" : statusText;
                }
            });
            syncFunctionComponent4.setOwnerType(propertyComponentBuilderWithThis4.getThisType());
            syncFunctionComponent4.setCanTakeOwner(true);
            propertyComponentBuilderWithThis4.setGetter(syncFunctionComponent4);
            classComponentBuilder.getProperties().put("statusText", propertyComponentBuilderWithThis4);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis5 = new PropertyComponentBuilderWithThis(classComponentBuilder.getOwnerType().getKType(), "url");
            AnyType[] anyTypeArr8 = {new AnyType(propertyComponentBuilderWithThis5.getThisType())};
            ReturnType returnType6 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(String.class));
            if (returnType6 == null) {
                returnType6 = new ReturnType(Reflection.getOrCreateKotlinClass(String.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(String.class), returnType6);
            }
            SyncFunctionComponent syncFunctionComponent5 = new SyncFunctionComponent("get", anyTypeArr8, returnType6, new Function1<Object[], Object>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$13$$inlined$Property$5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String url;
                    Intrinsics.checkNotNullParameter(it, "it");
                    NativeResponseInit responseInit = ((NativeResponse) it[0]).getResponseInit();
                    return (responseInit == null || (url = responseInit.getUrl()) == null) ? "" : url;
                }
            });
            syncFunctionComponent5.setOwnerType(propertyComponentBuilderWithThis5.getThisType());
            syncFunctionComponent5.setCanTakeOwner(true);
            propertyComponentBuilderWithThis5.setGetter(syncFunctionComponent5);
            classComponentBuilder.getProperties().put("url", propertyComponentBuilderWithThis5);
            PropertyComponentBuilderWithThis propertyComponentBuilderWithThis6 = new PropertyComponentBuilderWithThis(classComponentBuilder.getOwnerType().getKType(), "redirected");
            AnyType[] anyTypeArr9 = {new AnyType(propertyComponentBuilderWithThis6.getThisType())};
            ReturnType returnType7 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Boolean.class));
            if (returnType7 == null) {
                returnType7 = new ReturnType(Reflection.getOrCreateKotlinClass(Boolean.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Boolean.class), returnType7);
            }
            SyncFunctionComponent syncFunctionComponent6 = new SyncFunctionComponent("get", anyTypeArr9, returnType7, new Function1<Object[], Object>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$13$$inlined$Property$6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    NativeResponseInit responseInit = ((NativeResponse) it[0]).getResponseInit();
                    return Boolean.valueOf(responseInit != null ? responseInit.getRedirected() : false);
                }
            });
            syncFunctionComponent6.setOwnerType(propertyComponentBuilderWithThis6.getThisType());
            syncFunctionComponent6.setCanTakeOwner(true);
            propertyComponentBuilderWithThis6.setGetter(syncFunctionComponent6);
            classComponentBuilder.getProperties().put("redirected", propertyComponentBuilderWithThis6);
            ClassComponentBuilder classComponentBuilder4 = classComponentBuilder;
            AnyType[] anyTypeArr10 = new AnyType[1];
            AnyType anyType5 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(NativeResponse.class), false));
            if (anyType5 == null) {
                anyType5 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeResponse.class), false, new Function0<KType>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$13$$inlined$AsyncFunctionWithPromise$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(NativeResponse.class);
                    }
                }));
            }
            anyTypeArr10[0] = anyType5;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("arrayBuffer", anyTypeArr10, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$13$$inlined$AsyncFunctionWithPromise$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    final NativeResponse nativeResponse = (NativeResponse) objArr[0];
                    nativeResponse.waitForStates(CollectionsKt.listOf(ResponseState.BODY_COMPLETED), new Function1<ResponseState, Unit>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$1$3$10$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ResponseState responseState) {
                            invoke2(responseState);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ResponseState it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            promise.resolve(nativeResponse.getSink().finalize());
                        }
                    });
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            classComponentBuilder4.getAsyncFunctions().put("arrayBuffer", asyncFunctionWithPromiseComponent);
            ClassComponentBuilder classComponentBuilder5 = classComponentBuilder;
            AnyType[] anyTypeArr11 = new AnyType[1];
            AnyType anyType6 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(NativeResponse.class), false));
            if (anyType6 == null) {
                anyType6 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeResponse.class), false, new Function0<KType>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$13$$inlined$AsyncFunctionWithPromise$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(NativeResponse.class);
                    }
                }));
            }
            anyTypeArr11[0] = anyType6;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("text", anyTypeArr11, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$13$$inlined$AsyncFunctionWithPromise$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    final NativeResponse nativeResponse = (NativeResponse) objArr[0];
                    nativeResponse.waitForStates(CollectionsKt.listOf(ResponseState.BODY_COMPLETED), new Function1<ResponseState, Unit>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$1$3$11$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ResponseState responseState) {
                            invoke2(responseState);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ResponseState it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            promise.resolve(new String(nativeResponse.getSink().finalize(), Charsets.UTF_8));
                        }
                    });
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            classComponentBuilder5.getAsyncFunctions().put("text", asyncFunctionWithPromiseComponent2);
            moduleDefinitionBuilder.getClassData().add(classComponentBuilder.buildClass());
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(NativeRequest.class);
            String simpleName2 = JvmClassMappingKt.getJavaClass(orCreateKotlinClass2).getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName2, "getSimpleName(...)");
            AnyType anyType7 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(NativeRequest.class), false));
            if (anyType7 == null) {
                anyType7 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeRequest.class), false, new Function0<KType>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$$inlined$Class$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(NativeRequest.class);
                    }
                }));
            }
            ClassComponentBuilder classComponentBuilder6 = new ClassComponentBuilder(simpleName2, orCreateKotlinClass2, anyType7);
            AnyType[] anyTypeArr12 = new AnyType[1];
            AnyType anyType8 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(NativeResponse.class), false));
            if (anyType8 == null) {
                anyType8 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeResponse.class), false, new Function0<KType>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$17$$inlined$Constructor$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(NativeResponse.class);
                    }
                }));
            }
            anyTypeArr12[0] = anyType8;
            ReturnType returnType8 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
            if (returnType8 == null) {
                returnType8 = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType8);
            }
            classComponentBuilder6.setConstructor(new SyncFunctionComponent("constructor", anyTypeArr12, returnType8, new Function1<Object[], Object>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$17$$inlined$Constructor$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    return new NativeRequest(this.this$0.getAppContext(), (NativeResponse) objArr[0]);
                }
            }));
            ClassComponentBuilder classComponentBuilder7 = classComponentBuilder6;
            AnyType[] anyTypeArr13 = new AnyType[4];
            AnyType anyType9 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(NativeRequest.class), false));
            if (anyType9 == null) {
                anyType9 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeRequest.class), false, new Function0<KType>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$17$$inlined$AsyncFunctionWithPromise$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(NativeRequest.class);
                    }
                }));
            }
            anyTypeArr13[0] = anyType9;
            AnyType anyType10 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(URL.class), false));
            if (anyType10 == null) {
                anyType10 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(URL.class), false, new Function0<KType>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$17$$inlined$AsyncFunctionWithPromise$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(URL.class);
                    }
                }));
            }
            anyTypeArr13[1] = anyType10;
            AnyType anyType11 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(NativeRequestInit.class), false));
            if (anyType11 == null) {
                anyType11 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeRequestInit.class), false, new Function0<KType>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$17$$inlined$AsyncFunctionWithPromise$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(NativeRequestInit.class);
                    }
                }));
            }
            anyTypeArr13[2] = anyType11;
            AnyType anyType12 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(byte[].class), true));
            if (anyType12 == null) {
                anyType12 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(byte[].class), true, new Function0<KType>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$17$$inlined$AsyncFunctionWithPromise$4
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(byte[].class);
                    }
                }));
            }
            anyTypeArr13[3] = anyType12;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent(ViewProps.START, anyTypeArr13, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$17$$inlined$AsyncFunctionWithPromise$5
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    Object obj3 = objArr[2];
                    byte[] bArr = (byte[]) objArr[3];
                    final NativeRequest nativeRequest = (NativeRequest) obj;
                    nativeRequest.start(this.this$0.getClient(), (URL) obj2, (NativeRequestInit) obj3, bArr);
                    nativeRequest.getResponse().waitForStates(CollectionsKt.listOf((Object[]) new ResponseState[]{ResponseState.RESPONSE_RECEIVED, ResponseState.ERROR_RECEIVED}), new Function1<ResponseState, Unit>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$1$4$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ResponseState responseState) {
                            invoke2(responseState);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ResponseState state) {
                            FetchUnknownException fetchUnknownException;
                            Intrinsics.checkNotNullParameter(state, "state");
                            if (state == ResponseState.RESPONSE_RECEIVED) {
                                promise.resolve();
                                return;
                            }
                            if (state == ResponseState.ERROR_RECEIVED) {
                                Promise promise2 = promise;
                                Exception error = nativeRequest.getResponse().getError();
                                if (error == null) {
                                    fetchUnknownException = new FetchUnknownException();
                                } else {
                                    Exception exc = error;
                                    if (exc instanceof CodedException) {
                                        fetchUnknownException = (CodedException) exc;
                                    } else if (exc instanceof expo.modules.core.errors.CodedException) {
                                        String code = ((expo.modules.core.errors.CodedException) exc).getCode();
                                        Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                                        fetchUnknownException = new CodedException(code, exc.getMessage(), exc.getCause());
                                    } else {
                                        fetchUnknownException = new UnexpectedException(exc);
                                    }
                                }
                                promise2.reject(fetchUnknownException);
                            }
                        }
                    });
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            classComponentBuilder7.getAsyncFunctions().put(ViewProps.START, asyncFunctionWithPromiseComponent3);
            ClassComponentBuilder classComponentBuilder8 = classComponentBuilder6;
            if (Intrinsics.areEqual(NativeRequest.class, Promise.class)) {
                intAsyncFunctionComponent = new AsyncFunctionWithPromiseComponent("cancel", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$17$$inlined$AsyncFunction$1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        ((NativeRequest) promise).cancel();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr14 = new AnyType[1];
                AnyType anyType13 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(NativeRequest.class), false));
                if (anyType13 == null) {
                    anyType13 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(NativeRequest.class), false, new Function0<KType>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$17$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(NativeRequest.class);
                        }
                    }));
                }
                anyTypeArr14[0] = anyType13;
                Function1<Object[], Unit> function12 = new Function1<Object[], Unit>() { // from class: expo.modules.fetch.ExpoFetchModule$definition$lambda$18$lambda$17$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        ((NativeRequest) objArr[0]).cancel();
                        return Unit.INSTANCE;
                    }
                };
                intAsyncFunctionComponent = Intrinsics.areEqual(Unit.class, Integer.TYPE) ? new IntAsyncFunctionComponent("cancel", anyTypeArr14, function12) : Intrinsics.areEqual(Unit.class, Boolean.TYPE) ? new BoolAsyncFunctionComponent("cancel", anyTypeArr14, function12) : Intrinsics.areEqual(Unit.class, Double.TYPE) ? new DoubleAsyncFunctionComponent("cancel", anyTypeArr14, function12) : Intrinsics.areEqual(Unit.class, Float.TYPE) ? new FloatAsyncFunctionComponent("cancel", anyTypeArr14, function12) : Intrinsics.areEqual(Unit.class, String.class) ? new StringAsyncFunctionComponent("cancel", anyTypeArr14, function12) : new AsyncFunctionComponent("cancel", anyTypeArr14, function12);
            }
            classComponentBuilder8.getAsyncFunctions().put("cancel", intAsyncFunctionComponent);
            moduleDefinitionBuilder.getClassData().add(classComponentBuilder6.buildClass());
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
