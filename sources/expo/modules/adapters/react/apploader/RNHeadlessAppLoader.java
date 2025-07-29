package expo.modules.adapters.react.apploader;

import android.content.Context;
import android.os.Handler;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactHost;
import com.facebook.react.ReactInstanceEventListener;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.LifecycleState;
import expo.modules.apploader.HeadlessAppLoader;
import expo.modules.core.interfaces.Consumer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: RNHeadlessAppLoader.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0017J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J4\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/modules/adapters/react/apploader/RNHeadlessAppLoader;", "Lexpo/modules/apploader/HeadlessAppLoader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "invalidateApp", "", "appScopeKey", "", "isRunning", "loadApp", "", "params", "Lexpo/modules/apploader/HeadlessAppLoader$Params;", "alreadyRunning", "Ljava/lang/Runnable;", "callback", "Lexpo/modules/core/interfaces/Consumer;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RNHeadlessAppLoader implements HeadlessAppLoader {
    public static final int $stable = 8;
    private final Context context;

    public RNHeadlessAppLoader(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // expo.modules.apploader.HeadlessAppLoader
    public void loadApp(Context context, final HeadlessAppLoader.Params params, Runnable alreadyRunning, final Consumer<Boolean> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (params == null || params.getAppScopeKey() == null) {
            throw new IllegalArgumentException("Params must be set with appScopeKey!");
        }
        if (context.getApplicationContext() instanceof ReactApplication) {
            if (RNHeadlessAppLoaderKt.appRecords.containsKey(params.getAppScopeKey())) {
                if (alreadyRunning != null) {
                    alreadyRunning.run();
                    return;
                }
                return;
            } else {
                Object applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.facebook.react.ReactApplication");
                final ReactInstanceManager reactInstanceManager = ((ReactApplication) applicationContext).getReactNativeHost().getReactInstanceManager();
                reactInstanceManager.addReactInstanceEventListener(new ReactInstanceEventListener() { // from class: expo.modules.adapters.react.apploader.RNHeadlessAppLoader.loadApp.3
                    @Override // com.facebook.react.ReactInstanceEventListener
                    public void onReactContextInitialized(ReactContext context2) {
                        Intrinsics.checkNotNullParameter(context2, "context");
                        HeadlessAppLoaderNotifier.INSTANCE.notifyAppLoaded(params.getAppScopeKey());
                        reactInstanceManager.removeReactInstanceEventListener(this);
                        Map map = RNHeadlessAppLoaderKt.appRecords;
                        String appScopeKey = params.getAppScopeKey();
                        Intrinsics.checkNotNullExpressionValue(appScopeKey, "getAppScopeKey(...)");
                        map.put(appScopeKey, context2);
                        Consumer<Boolean> consumer = callback;
                        if (consumer != null) {
                            consumer.apply(true);
                        }
                    }
                });
                new Handler(context.getMainLooper()).post(new Runnable() { // from class: expo.modules.adapters.react.apploader.RNHeadlessAppLoader$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        reactInstanceManager.createReactContextInBackground();
                    }
                });
                return;
            }
        }
        throw new IllegalStateException("Your application must implement ReactApplication");
    }

    private static final void loadApp$lambda$0(ReactHost reactHost) {
        Intrinsics.checkNotNullParameter(reactHost, "$reactHost");
        reactHost.start();
    }

    @Override // expo.modules.apploader.HeadlessAppLoader
    public boolean invalidateApp(final String appScopeKey) {
        ReactContext reactContext;
        if (!RNHeadlessAppLoaderKt.appRecords.containsKey(appScopeKey) || RNHeadlessAppLoaderKt.appRecords.get(appScopeKey) == null || (reactContext = (ReactContext) RNHeadlessAppLoaderKt.appRecords.get(appScopeKey)) == null) {
            return false;
        }
        Object applicationContext = reactContext.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.facebook.react.ReactApplication");
        ReactNativeHost reactNativeHost = ((ReactApplication) applicationContext).getReactNativeHost();
        if (reactNativeHost.hasInstance()) {
            final ReactInstanceManager reactInstanceManager = reactNativeHost.getReactInstanceManager();
            Intrinsics.checkNotNullExpressionValue(reactInstanceManager, "getReactInstanceManager(...)");
            new Handler(reactContext.getMainLooper()).post(new Runnable() { // from class: expo.modules.adapters.react.apploader.RNHeadlessAppLoader$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    RNHeadlessAppLoader.invalidateApp$lambda$3(reactInstanceManager, appScopeKey);
                }
            });
        }
        return true;
    }

    private static final void invalidateApp$lambda$2(ReactHost reactHost, String str) {
        Intrinsics.checkNotNullParameter(reactHost, "$reactHost");
        if (reactHost.getLifecycleState() == LifecycleState.BEFORE_CREATE) {
            reactHost.destroy("Closing headless task app", null);
        }
        HeadlessAppLoaderNotifier.INSTANCE.notifyAppDestroyed(str);
        TypeIntrinsics.asMutableMap(RNHeadlessAppLoaderKt.appRecords).remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invalidateApp$lambda$3(ReactInstanceManager reactInstanceManager, String str) {
        Intrinsics.checkNotNullParameter(reactInstanceManager, "$reactInstanceManager");
        if (reactInstanceManager.getLifecycleState() == LifecycleState.BEFORE_CREATE) {
            reactInstanceManager.destroy();
        }
        HeadlessAppLoaderNotifier.INSTANCE.notifyAppDestroyed(str);
        TypeIntrinsics.asMutableMap(RNHeadlessAppLoaderKt.appRecords).remove(str);
    }

    @Override // expo.modules.apploader.HeadlessAppLoader
    public boolean isRunning(String appScopeKey) {
        ReactContext reactContext = (ReactContext) RNHeadlessAppLoaderKt.appRecords.get(appScopeKey);
        if (reactContext == null) {
            return false;
        }
        Object applicationContext = reactContext.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.facebook.react.ReactApplication");
        return ((ReactApplication) applicationContext).getReactNativeHost().getReactInstanceManager().hasStartedCreatingInitialContext();
    }
}
