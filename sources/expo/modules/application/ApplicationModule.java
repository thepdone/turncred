package expo.modules.application;

import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import androidx.tracing.Trace;
import com.android.installreferrer.api.InstallReferrerClient;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
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
import expo.modules.kotlin.objects.PropertyComponentBuilder;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: ApplicationModule.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0006R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0006¨\u0006\u001a"}, d2 = {"Lexpo/modules/application/ApplicationModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "applicationName", "", "getApplicationName", "()Ljava/lang/String;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "packageManager", "Landroid/content/pm/PackageManager;", "kotlin.jvm.PlatformType", "getPackageManager", "()Landroid/content/pm/PackageManager;", "packageName", "getPackageName", "versionCode", "", "getVersionCode", "()I", "versionName", "getVersionName", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-application_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ApplicationModule extends Module {
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
        AsyncFunctionComponent asyncFunctionComponent2;
        AsyncFunctionComponent asyncFunctionComponent3;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        ApplicationModule applicationModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (applicationModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(applicationModule);
            moduleDefinitionBuilder.Name("ExpoApplication");
            moduleDefinitionBuilder.Constants(new Function0<Map<String, ? extends Object>>() { // from class: expo.modules.application.ApplicationModule$definition$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Map<String, ? extends Object> invoke() {
                    return MapsKt.mapOf(TuplesKt.to("applicationName", this.this$0.getApplicationName()), TuplesKt.to("applicationId", this.this$0.getPackageName()), TuplesKt.to("nativeApplicationVersion", this.this$0.getVersionName()), TuplesKt.to("nativeBuildVersion", String.valueOf(this.this$0.getVersionCode())));
                }
            });
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            PropertyComponentBuilder propertyComponentBuilder = new PropertyComponentBuilder("androidId");
            AnyType[] anyTypeArr = new AnyType[0];
            ReturnType returnType = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(String.class));
            if (returnType == null) {
                returnType = new ReturnType(Reflection.getOrCreateKotlinClass(String.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(String.class), returnType);
            }
            propertyComponentBuilder.setGetter(new SyncFunctionComponent("get", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.application.ApplicationModule$definition$lambda$4$$inlined$Property$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Settings.Secure.getString(this.this$0.getContext().getContentResolver(), "android_id");
                }
            }));
            moduleDefinitionBuilder2.getProperties().put("androidId", propertyComponentBuilder);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr2 = new AnyType[0];
            Function1<Object[], Double> function1 = new Function1<Object[], Double>() { // from class: expo.modules.application.ApplicationModule$definition$lambda$4$$inlined$AsyncFunction$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Double invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    PackageManager packageManager = this.this$0.getContext().getPackageManager();
                    String packageName = this.this$0.getContext().getPackageName();
                    Intrinsics.checkNotNull(packageManager);
                    Intrinsics.checkNotNull(packageName);
                    return Double.valueOf(ApplicationModuleKt.getPackageInfoCompat(packageManager, packageName, 0).firstInstallTime);
                }
            };
            if (!Intrinsics.areEqual(Double.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Double.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Double.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Double.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Double.class, String.class)) {
                                asyncFunctionComponent = new StringAsyncFunctionComponent("getInstallationTimeAsync", anyTypeArr2, function1);
                            } else {
                                asyncFunctionComponent = new AsyncFunctionComponent("getInstallationTimeAsync", anyTypeArr2, function1);
                            }
                        } else {
                            asyncFunctionComponent = new FloatAsyncFunctionComponent("getInstallationTimeAsync", anyTypeArr2, function1);
                        }
                    } else {
                        asyncFunctionComponent = new DoubleAsyncFunctionComponent("getInstallationTimeAsync", anyTypeArr2, function1);
                    }
                } else {
                    asyncFunctionComponent = new BoolAsyncFunctionComponent("getInstallationTimeAsync", anyTypeArr2, function1);
                }
            } else {
                asyncFunctionComponent = new IntAsyncFunctionComponent("getInstallationTimeAsync", anyTypeArr2, function1);
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("getInstallationTimeAsync", asyncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr3 = new AnyType[0];
            Function1<Object[], Double> function12 = new Function1<Object[], Double>() { // from class: expo.modules.application.ApplicationModule$definition$lambda$4$$inlined$AsyncFunction$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Double invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    PackageManager packageManager = this.this$0.getContext().getPackageManager();
                    String packageName = this.this$0.getContext().getPackageName();
                    Intrinsics.checkNotNull(packageManager);
                    Intrinsics.checkNotNull(packageName);
                    return Double.valueOf(ApplicationModuleKt.getPackageInfoCompat(packageManager, packageName, 0).lastUpdateTime);
                }
            };
            if (!Intrinsics.areEqual(Double.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Double.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Double.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Double.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Double.class, String.class)) {
                                asyncFunctionComponent2 = new StringAsyncFunctionComponent("getLastUpdateTimeAsync", anyTypeArr3, function12);
                            } else {
                                asyncFunctionComponent2 = new AsyncFunctionComponent("getLastUpdateTimeAsync", anyTypeArr3, function12);
                            }
                        } else {
                            asyncFunctionComponent2 = new FloatAsyncFunctionComponent("getLastUpdateTimeAsync", anyTypeArr3, function12);
                        }
                    } else {
                        asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("getLastUpdateTimeAsync", anyTypeArr3, function12);
                    }
                } else {
                    asyncFunctionComponent2 = new BoolAsyncFunctionComponent("getLastUpdateTimeAsync", anyTypeArr3, function12);
                }
            } else {
                asyncFunctionComponent2 = new IntAsyncFunctionComponent("getLastUpdateTimeAsync", anyTypeArr3, function12);
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("getLastUpdateTimeAsync", asyncFunctionComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("getInstallReferrerAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.application.ApplicationModule$definition$lambda$4$$inlined$AsyncFunction$3
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
                        StringBuilder sb = new StringBuilder();
                        InstallReferrerClient installReferrerClientBuild = InstallReferrerClient.newBuilder(this.this$0.getContext()).build();
                        installReferrerClientBuild.startConnection(new ApplicationModule$definition$1$5$1(installReferrerClientBuild, sb, promise));
                    }
                });
            } else {
                AnyType[] anyTypeArr4 = new AnyType[1];
                AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType == null) {
                    anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.application.ApplicationModule$definition$lambda$4$$inlined$AsyncFunction$4
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Promise.class);
                        }
                    }));
                }
                anyTypeArr4[0] = anyType;
                Function1<Object[], Unit> function13 = new Function1<Object[], Unit>() { // from class: expo.modules.application.ApplicationModule$definition$lambda$4$$inlined$AsyncFunction$5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Promise promise = (Promise) objArr[0];
                        StringBuilder sb = new StringBuilder();
                        InstallReferrerClient installReferrerClientBuild = InstallReferrerClient.newBuilder(this.this$0.getContext()).build();
                        installReferrerClientBuild.startConnection(new ApplicationModule$definition$1$5$1(installReferrerClientBuild, sb, promise));
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent3 = new StringAsyncFunctionComponent("getInstallReferrerAsync", anyTypeArr4, function13);
                                } else {
                                    asyncFunctionComponent3 = new AsyncFunctionComponent("getInstallReferrerAsync", anyTypeArr4, function13);
                                }
                            } else {
                                asyncFunctionComponent3 = new FloatAsyncFunctionComponent("getInstallReferrerAsync", anyTypeArr4, function13);
                            }
                        } else {
                            asyncFunctionComponent3 = new DoubleAsyncFunctionComponent("getInstallReferrerAsync", anyTypeArr4, function13);
                        }
                    } else {
                        asyncFunctionComponent3 = new BoolAsyncFunctionComponent("getInstallReferrerAsync", anyTypeArr4, function13);
                    }
                } else {
                    asyncFunctionComponent3 = new IntAsyncFunctionComponent("getInstallReferrerAsync", anyTypeArr4, function13);
                }
                asyncFunctionWithPromiseComponent = asyncFunctionComponent3;
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("getInstallReferrerAsync", asyncFunctionWithPromiseComponent);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getApplicationName() {
        return getContext().getApplicationInfo().loadLabel(getContext().getPackageManager()).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPackageName() {
        return getContext().getPackageName();
    }

    private final PackageManager getPackageManager() {
        return getContext().getPackageManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getVersionName() {
        PackageManager packageManager = getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "<get-packageManager>(...)");
        String packageName = getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "<get-packageName>(...)");
        return ApplicationModuleKt.getPackageInfoCompat(packageManager, packageName, 0).versionName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getVersionCode() {
        PackageManager packageManager = getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "<get-packageManager>(...)");
        String packageName = getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "<get-packageName>(...)");
        return (int) ApplicationModuleKt.getLongVersionCode(ApplicationModuleKt.getPackageInfoCompat(packageManager, packageName, 0));
    }
}
