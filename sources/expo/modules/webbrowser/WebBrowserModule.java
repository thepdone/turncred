package expo.modules.webbrowser;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.os.BundleKt;
import androidx.tracing.Trace;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
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
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: WebBrowserModule.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lexpo/modules/webbrowser/WebBrowserModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "connectionHelper", "Lexpo/modules/webbrowser/CustomTabsConnectionHelper;", "getConnectionHelper$expo_web_browser_release", "()Lexpo/modules/webbrowser/CustomTabsConnectionHelper;", "setConnectionHelper$expo_web_browser_release", "(Lexpo/modules/webbrowser/CustomTabsConnectionHelper;)V", "customTabsResolver", "Lexpo/modules/webbrowser/CustomTabsActivitiesHelper;", "getCustomTabsResolver$expo_web_browser_release", "()Lexpo/modules/webbrowser/CustomTabsActivitiesHelper;", "setCustomTabsResolver$expo_web_browser_release", "(Lexpo/modules/webbrowser/CustomTabsActivitiesHelper;)V", "createCustomTabsIntent", "Landroid/content/Intent;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lexpo/modules/webbrowser/OpenBrowserOptions;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "givenOrPreferredPackageName", "", "packageName", "expo-web-browser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WebBrowserModule extends Module {
    public CustomTabsConnectionHelper connectionHelper;
    public CustomTabsActivitiesHelper customTabsResolver;

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2;
        AsyncFunctionComponent asyncFunctionComponent3;
        AsyncFunctionComponent asyncFunctionComponent4;
        AsyncFunctionComponent asyncFunctionComponent5;
        WebBrowserModule webBrowserModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (webBrowserModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(webBrowserModule);
            moduleDefinitionBuilder.Name("ExpoWebBrowser");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$OnCreate$1
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
                    this.this$0.setCustomTabsResolver$expo_web_browser_release(new CustomTabsActivitiesHelper(this.this$0.getAppContext().getActivityProvider()));
                    WebBrowserModule webBrowserModule2 = this.this$0;
                    Context reactContext = webBrowserModule2.getAppContext().getReactContext();
                    if (reactContext != null) {
                        webBrowserModule2.setConnectionHelper$expo_web_browser_release(new CustomTabsConnectionHelper(reactContext));
                        return;
                    }
                    throw new IllegalArgumentException("Cannot initialize WebBrowser, ReactContext is null".toString());
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_DESTROYS, new BasicEventListener(EventName.ACTIVITY_DESTROYS, new Function0<Unit>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$OnActivityDestroys$1
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
                    this.this$0.getConnectionHelper$expo_web_browser_release().destroy();
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("warmUpAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$1
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws NoPreferredPackageFound {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        String strGivenOrPreferredPackageName = this.this$0.givenOrPreferredPackageName((String) promise);
                        this.this$0.getConnectionHelper$expo_web_browser_release().warmUp(strGivenOrPreferredPackageName);
                        BundleKt.bundleOf(TuplesKt.to("servicePackage", strGivenOrPreferredPackageName));
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws NoPreferredPackageFound {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr = new AnyType[1];
                AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
                if (anyType == null) {
                    anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
                        }
                    }));
                }
                anyTypeArr[0] = anyType;
                Function1<Object[], Bundle> function1 = new Function1<Object[], Bundle>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Bundle invoke(Object[] objArr) throws NoPreferredPackageFound {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        String strGivenOrPreferredPackageName = this.this$0.givenOrPreferredPackageName((String) objArr[0]);
                        this.this$0.getConnectionHelper$expo_web_browser_release().warmUp(strGivenOrPreferredPackageName);
                        return BundleKt.bundleOf(TuplesKt.to("servicePackage", strGivenOrPreferredPackageName));
                    }
                };
                if (!Intrinsics.areEqual(Bundle.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Bundle.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Bundle.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Bundle.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Bundle.class, String.class)) {
                                    asyncFunctionComponent = new StringAsyncFunctionComponent("warmUpAsync", anyTypeArr, function1);
                                } else {
                                    asyncFunctionComponent = new AsyncFunctionComponent("warmUpAsync", anyTypeArr, function1);
                                }
                            } else {
                                asyncFunctionComponent = new FloatAsyncFunctionComponent("warmUpAsync", anyTypeArr, function1);
                            }
                        } else {
                            asyncFunctionComponent = new DoubleAsyncFunctionComponent("warmUpAsync", anyTypeArr, function1);
                        }
                    } else {
                        asyncFunctionComponent = new BoolAsyncFunctionComponent("warmUpAsync", anyTypeArr, function1);
                    }
                } else {
                    asyncFunctionComponent = new IntAsyncFunctionComponent("warmUpAsync", anyTypeArr, function1);
                }
                asyncFunctionWithPromiseComponent = asyncFunctionComponent;
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("warmUpAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("coolDownAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$4
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws NoPreferredPackageFound {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        String strGivenOrPreferredPackageName = this.this$0.givenOrPreferredPackageName((String) promise);
                        if (this.this$0.getConnectionHelper$expo_web_browser_release().coolDown(strGivenOrPreferredPackageName)) {
                            BundleKt.bundleOf(TuplesKt.to("servicePackage", strGivenOrPreferredPackageName));
                        } else {
                            new Bundle();
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws NoPreferredPackageFound {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr2 = new AnyType[1];
                AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
                if (anyType2 == null) {
                    anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(String.class);
                        }
                    }));
                }
                anyTypeArr2[0] = anyType2;
                Function1<Object[], Bundle> function12 = new Function1<Object[], Bundle>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Bundle invoke(Object[] objArr) throws NoPreferredPackageFound {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        String strGivenOrPreferredPackageName = this.this$0.givenOrPreferredPackageName((String) objArr[0]);
                        if (this.this$0.getConnectionHelper$expo_web_browser_release().coolDown(strGivenOrPreferredPackageName)) {
                            return BundleKt.bundleOf(TuplesKt.to("servicePackage", strGivenOrPreferredPackageName));
                        }
                        return new Bundle();
                    }
                };
                if (!Intrinsics.areEqual(Bundle.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Bundle.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Bundle.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Bundle.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Bundle.class, String.class)) {
                                    asyncFunctionComponent2 = new StringAsyncFunctionComponent("coolDownAsync", anyTypeArr2, function12);
                                } else {
                                    asyncFunctionComponent2 = new AsyncFunctionComponent("coolDownAsync", anyTypeArr2, function12);
                                }
                            } else {
                                asyncFunctionComponent2 = new FloatAsyncFunctionComponent("coolDownAsync", anyTypeArr2, function12);
                            }
                        } else {
                            asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("coolDownAsync", anyTypeArr2, function12);
                        }
                    } else {
                        asyncFunctionComponent2 = new BoolAsyncFunctionComponent("coolDownAsync", anyTypeArr2, function12);
                    }
                } else {
                    asyncFunctionComponent2 = new IntAsyncFunctionComponent("coolDownAsync", anyTypeArr2, function12);
                }
                asyncFunctionWithPromiseComponent2 = asyncFunctionComponent2;
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("coolDownAsync", asyncFunctionWithPromiseComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr3 = new AnyType[2];
            AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType3 == null) {
                anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$7
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr3[0] = anyType3;
            AnyType anyType4 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType4 == null) {
                anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$8
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(String.class);
                    }
                }));
            }
            anyTypeArr3[1] = anyType4;
            Function1<Object[], Bundle> function13 = new Function1<Object[], Bundle>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$9
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Bundle invoke(Object[] objArr) throws NoPreferredPackageFound {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    String strGivenOrPreferredPackageName = this.this$0.givenOrPreferredPackageName((String) objArr[1]);
                    CustomTabsConnectionHelper connectionHelper$expo_web_browser_release = this.this$0.getConnectionHelper$expo_web_browser_release();
                    Uri uri = Uri.parse((String) obj);
                    Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
                    connectionHelper$expo_web_browser_release.mayInitWithUrl(strGivenOrPreferredPackageName, uri);
                    return BundleKt.bundleOf(TuplesKt.to("servicePackage", strGivenOrPreferredPackageName));
                }
            };
            if (!Intrinsics.areEqual(Bundle.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Bundle.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Bundle.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Bundle.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Bundle.class, String.class)) {
                                asyncFunctionComponent3 = new StringAsyncFunctionComponent("mayInitWithUrlAsync", anyTypeArr3, function13);
                            } else {
                                asyncFunctionComponent3 = new AsyncFunctionComponent("mayInitWithUrlAsync", anyTypeArr3, function13);
                            }
                        } else {
                            asyncFunctionComponent3 = new FloatAsyncFunctionComponent("mayInitWithUrlAsync", anyTypeArr3, function13);
                        }
                    } else {
                        asyncFunctionComponent3 = new DoubleAsyncFunctionComponent("mayInitWithUrlAsync", anyTypeArr3, function13);
                    }
                } else {
                    asyncFunctionComponent3 = new BoolAsyncFunctionComponent("mayInitWithUrlAsync", anyTypeArr3, function13);
                }
            } else {
                asyncFunctionComponent3 = new IntAsyncFunctionComponent("mayInitWithUrlAsync", anyTypeArr3, function13);
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("mayInitWithUrlAsync", asyncFunctionComponent3);
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr4 = new AnyType[0];
            Function1<Object[], Bundle> function14 = new Function1<Object[], Bundle>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$10
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Bundle invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ArrayList<String> customTabsResolvingActivities = this.this$0.getCustomTabsResolver$expo_web_browser_release().getCustomTabsResolvingActivities();
                    ArrayList<String> customTabsResolvingServices = this.this$0.getCustomTabsResolver$expo_web_browser_release().getCustomTabsResolvingServices();
                    String preferredCustomTabsResolvingActivity = this.this$0.getCustomTabsResolver$expo_web_browser_release().getPreferredCustomTabsResolvingActivity(customTabsResolvingActivities);
                    String defaultCustomTabsResolvingActivity = this.this$0.getCustomTabsResolver$expo_web_browser_release().getDefaultCustomTabsResolvingActivity();
                    if (!CollectionsKt.contains(customTabsResolvingActivities, defaultCustomTabsResolvingActivity)) {
                        defaultCustomTabsResolvingActivity = null;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("browserPackages", customTabsResolvingActivities);
                    bundle.putStringArrayList("servicePackages", customTabsResolvingServices);
                    bundle.putString("preferredBrowserPackage", preferredCustomTabsResolvingActivity);
                    bundle.putString("defaultBrowserPackage", defaultCustomTabsResolvingActivity);
                    return bundle;
                }
            };
            if (!Intrinsics.areEqual(Bundle.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Bundle.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Bundle.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Bundle.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Bundle.class, String.class)) {
                                asyncFunctionComponent4 = new StringAsyncFunctionComponent("getCustomTabsSupportingBrowsersAsync", anyTypeArr4, function14);
                            } else {
                                asyncFunctionComponent4 = new AsyncFunctionComponent("getCustomTabsSupportingBrowsersAsync", anyTypeArr4, function14);
                            }
                        } else {
                            asyncFunctionComponent4 = new FloatAsyncFunctionComponent("getCustomTabsSupportingBrowsersAsync", anyTypeArr4, function14);
                        }
                    } else {
                        asyncFunctionComponent4 = new DoubleAsyncFunctionComponent("getCustomTabsSupportingBrowsersAsync", anyTypeArr4, function14);
                    }
                } else {
                    asyncFunctionComponent4 = new BoolAsyncFunctionComponent("getCustomTabsSupportingBrowsersAsync", anyTypeArr4, function14);
                }
            } else {
                asyncFunctionComponent4 = new IntAsyncFunctionComponent("getCustomTabsSupportingBrowsersAsync", anyTypeArr4, function14);
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("getCustomTabsSupportingBrowsersAsync", asyncFunctionComponent4);
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr5 = new AnyType[2];
            AnyType anyType5 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType5 == null) {
                anyType5 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$11
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr5[0] = anyType5;
            AnyType anyType6 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(OpenBrowserOptions.class), false));
            if (anyType6 == null) {
                anyType6 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(OpenBrowserOptions.class), false, new Function0<KType>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$12
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(OpenBrowserOptions.class);
                    }
                }));
            }
            anyTypeArr5[1] = anyType6;
            Function1<Object[], Bundle> function15 = new Function1<Object[], Bundle>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$13
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Bundle invoke(Object[] objArr) throws NoMatchingActivityException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    Intent intentCreateCustomTabsIntent = this.this$0.createCustomTabsIntent((OpenBrowserOptions) objArr[1]);
                    intentCreateCustomTabsIntent.setData(Uri.parse((String) obj));
                    if (!this.this$0.getCustomTabsResolver$expo_web_browser_release().canResolveIntent(intentCreateCustomTabsIntent)) {
                        throw new NoMatchingActivityException();
                    }
                    this.this$0.getCustomTabsResolver$expo_web_browser_release().startCustomTabs(intentCreateCustomTabsIntent);
                    return BundleKt.bundleOf(TuplesKt.to("type", "opened"));
                }
            };
            if (!Intrinsics.areEqual(Bundle.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Bundle.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Bundle.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Bundle.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Bundle.class, String.class)) {
                                asyncFunctionComponent5 = new StringAsyncFunctionComponent("openBrowserAsync", anyTypeArr5, function15);
                            } else {
                                asyncFunctionComponent5 = new AsyncFunctionComponent("openBrowserAsync", anyTypeArr5, function15);
                            }
                        } else {
                            asyncFunctionComponent5 = new FloatAsyncFunctionComponent("openBrowserAsync", anyTypeArr5, function15);
                        }
                    } else {
                        asyncFunctionComponent5 = new DoubleAsyncFunctionComponent("openBrowserAsync", anyTypeArr5, function15);
                    }
                } else {
                    asyncFunctionComponent5 = new BoolAsyncFunctionComponent("openBrowserAsync", anyTypeArr5, function15);
                }
            } else {
                asyncFunctionComponent5 = new IntAsyncFunctionComponent("openBrowserAsync", anyTypeArr5, function15);
            }
            moduleDefinitionBuilder6.getAsyncFunctions().put("openBrowserAsync", asyncFunctionComponent5);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    public final CustomTabsActivitiesHelper getCustomTabsResolver$expo_web_browser_release() {
        CustomTabsActivitiesHelper customTabsActivitiesHelper = this.customTabsResolver;
        if (customTabsActivitiesHelper != null) {
            return customTabsActivitiesHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("customTabsResolver");
        return null;
    }

    public final void setCustomTabsResolver$expo_web_browser_release(CustomTabsActivitiesHelper customTabsActivitiesHelper) {
        Intrinsics.checkNotNullParameter(customTabsActivitiesHelper, "<set-?>");
        this.customTabsResolver = customTabsActivitiesHelper;
    }

    public final CustomTabsConnectionHelper getConnectionHelper$expo_web_browser_release() {
        CustomTabsConnectionHelper customTabsConnectionHelper = this.connectionHelper;
        if (customTabsConnectionHelper != null) {
            return customTabsConnectionHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("connectionHelper");
        return null;
    }

    public final void setConnectionHelper$expo_web_browser_release(CustomTabsConnectionHelper customTabsConnectionHelper) {
        Intrinsics.checkNotNullParameter(customTabsConnectionHelper, "<set-?>");
        this.connectionHelper = customTabsConnectionHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Intent createCustomTabsIntent(OpenBrowserOptions options) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        Integer toolbarColor = options.getToolbarColor();
        if (toolbarColor != null) {
            builder.setToolbarColor(toolbarColor.intValue());
        }
        Integer secondaryToolbarColor = options.getSecondaryToolbarColor();
        if (secondaryToolbarColor != null) {
            builder.setSecondaryToolbarColor(secondaryToolbarColor.intValue());
        }
        builder.setShowTitle(options.getShowTitle());
        if (options.getEnableDefaultShareMenuItem()) {
            builder.addDefaultShareMenuItem();
        }
        Intent intent = builder.build().intent;
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        intent.putExtra(CustomTabsIntent.EXTRA_ENABLE_URLBAR_HIDING, options.getEnableBarCollapsing());
        String browserPackage = options.getBrowserPackage();
        if (!TextUtils.isEmpty(browserPackage)) {
            intent.setPackage(browserPackage);
        }
        if (options.getShouldCreateTask()) {
            intent.addFlags(268435456);
            if (!options.getShowInRecents()) {
                intent.addFlags(8388608);
                intent.addFlags(1073741824);
            }
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String givenOrPreferredPackageName(java.lang.String r3) throws expo.modules.webbrowser.NoPreferredPackageFound {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto Ld
            r1 = r3
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch: expo.modules.webbrowser.PackageManagerNotFoundException -> L19 expo.modules.core.errors.CurrentActivityNotFoundException -> L1f
            int r1 = r1.length()     // Catch: expo.modules.webbrowser.PackageManagerNotFoundException -> L19 expo.modules.core.errors.CurrentActivityNotFoundException -> L1f
            if (r1 <= 0) goto Ld
            goto Le
        Ld:
            r3 = r0
        Le:
            if (r3 != 0) goto L25
            expo.modules.webbrowser.CustomTabsActivitiesHelper r3 = r2.getCustomTabsResolver$expo_web_browser_release()     // Catch: expo.modules.webbrowser.PackageManagerNotFoundException -> L19 expo.modules.core.errors.CurrentActivityNotFoundException -> L1f
            java.lang.String r3 = r3.getPreferredCustomTabsResolvingActivity(r0)     // Catch: expo.modules.webbrowser.PackageManagerNotFoundException -> L19 expo.modules.core.errors.CurrentActivityNotFoundException -> L1f
            goto L25
        L19:
            expo.modules.webbrowser.NoPreferredPackageFound r3 = new expo.modules.webbrowser.NoPreferredPackageFound
            r3.<init>()
            throw r3
        L1f:
            expo.modules.webbrowser.NoPreferredPackageFound r3 = new expo.modules.webbrowser.NoPreferredPackageFound
            r3.<init>()
            throw r3
        L25:
            if (r3 == 0) goto L34
            r1 = r3
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 <= 0) goto L31
            r0 = r3
        L31:
            if (r0 == 0) goto L34
            return r0
        L34:
            expo.modules.webbrowser.NoPreferredPackageFound r3 = new expo.modules.webbrowser.NoPreferredPackageFound
            r3.<init>()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.webbrowser.WebBrowserModule.givenOrPreferredPackageName(java.lang.String):java.lang.String");
    }
}
