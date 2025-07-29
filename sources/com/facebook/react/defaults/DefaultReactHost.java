package com.facebook.react.defaults;

import android.content.Context;
import com.facebook.react.ReactHost;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.defaults.DefaultTurboModuleManagerDelegate;
import com.facebook.react.fabric.ComponentFactory;
import com.facebook.react.runtime.JSCInstance;
import com.facebook.react.runtime.JSRuntimeFactory;
import com.facebook.react.runtime.ReactHostImpl;
import com.facebook.react.runtime.cxxreactpackage.CxxReactPackage;
import com.facebook.react.runtime.hermes.HermesInstance;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.codepush.react.CodePushConstants;
import com.nimbusds.jose.jwk.gen.OctetSequenceKeyGenerator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DefaultReactHost.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007Jn\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u001a\b\u0002\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00150\u000bH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/react/defaults/DefaultReactHost;", "", "()V", "reactHost", "Lcom/facebook/react/ReactHost;", "getDefaultReactHost", "context", "Landroid/content/Context;", "reactNativeHost", "Lcom/facebook/react/ReactNativeHost;", "packageList", "", "Lcom/facebook/react/ReactPackage;", "jsMainModulePath", "", "jsBundleAssetPath", "jsBundleFilePath", "isHermesEnabled", "", "useDevSupport", "cxxReactPackageProviders", "Lkotlin/Function1;", "Lcom/facebook/react/bridge/ReactContext;", "Lcom/facebook/react/runtime/cxxreactpackage/CxxReactPackage;", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultReactHost {
    public static final DefaultReactHost INSTANCE = new DefaultReactHost();
    private static ReactHost reactHost;

    private DefaultReactHost() {
    }

    public static /* synthetic */ ReactHost getDefaultReactHost$default(Context context, List list, String str, String str2, String str3, boolean z, boolean z2, List list2, int i, Object obj) {
        int i2 = i & 4;
        String str4 = FirebaseAnalytics.Param.INDEX;
        String str5 = i2 != 0 ? FirebaseAnalytics.Param.INDEX : str;
        if ((i & 8) == 0) {
            str4 = str2;
        }
        return getDefaultReactHost(context, list, str5, str4, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? true : z, (i & 64) != 0 ? ReactBuildConfig.DEBUG : z2, (i & 128) != 0 ? CollectionsKt.emptyList() : list2);
    }

    @JvmStatic
    public static final ReactHost getDefaultReactHost(Context context, List<? extends ReactPackage> packageList, String jsMainModulePath, String jsBundleAssetPath, String jsBundleFilePath, boolean isHermesEnabled, boolean useDevSupport, List<? extends Function1<? super ReactContext, ? extends CxxReactPackage>> cxxReactPackageProviders) {
        JSBundleLoader jSBundleLoaderCreateAssetLoader;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(packageList, "packageList");
        Intrinsics.checkNotNullParameter(jsMainModulePath, "jsMainModulePath");
        Intrinsics.checkNotNullParameter(jsBundleAssetPath, "jsBundleAssetPath");
        Intrinsics.checkNotNullParameter(cxxReactPackageProviders, "cxxReactPackageProviders");
        if (reactHost == null) {
            if (jsBundleFilePath != null) {
                if (StringsKt.startsWith$default(jsBundleFilePath, CodePushConstants.ASSETS_BUNDLE_PREFIX, false, 2, (Object) null)) {
                    jSBundleLoaderCreateAssetLoader = JSBundleLoader.createAssetLoader(context, jsBundleFilePath, true);
                } else {
                    jSBundleLoaderCreateAssetLoader = JSBundleLoader.createFileLoader(jsBundleFilePath);
                }
            } else {
                jSBundleLoaderCreateAssetLoader = JSBundleLoader.createAssetLoader(context, CodePushConstants.ASSETS_BUNDLE_PREFIX + jsBundleAssetPath, true);
            }
            JSBundleLoader jSBundleLoader = jSBundleLoaderCreateAssetLoader;
            JSRuntimeFactory hermesInstance = isHermesEnabled ? new HermesInstance() : new JSCInstance();
            DefaultTurboModuleManagerDelegate.Builder builder = new DefaultTurboModuleManagerDelegate.Builder();
            Iterator<T> it = cxxReactPackageProviders.iterator();
            while (it.hasNext()) {
                builder.addCxxReactPackage((Function1<? super ReactApplicationContext, ? extends CxxReactPackage>) it.next());
            }
            Intrinsics.checkNotNull(jSBundleLoader);
            DefaultReactHostDelegate defaultReactHostDelegate = new DefaultReactHostDelegate(jsMainModulePath, jSBundleLoader, packageList, hermesInstance, null, null, null, builder, OctetSequenceKeyGenerator.MIN_KEY_SIZE_BITS, null);
            ComponentFactory componentFactory = new ComponentFactory();
            DefaultComponentsRegistry.register(componentFactory);
            reactHost = new ReactHostImpl(context, defaultReactHostDelegate, componentFactory, true, useDevSupport);
        }
        ReactHost reactHost2 = reactHost;
        Intrinsics.checkNotNull(reactHost2, "null cannot be cast to non-null type com.facebook.react.ReactHost");
        return reactHost2;
    }

    @JvmStatic
    public static final ReactHost getDefaultReactHost(Context context, ReactNativeHost reactNativeHost) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reactNativeHost, "reactNativeHost");
        if (!(reactNativeHost instanceof DefaultReactNativeHost)) {
            throw new IllegalArgumentException("You can call getDefaultReactHost only with instances of DefaultReactNativeHost".toString());
        }
        return ((DefaultReactNativeHost) reactNativeHost).toReactHost$ReactAndroid_release(context);
    }
}
