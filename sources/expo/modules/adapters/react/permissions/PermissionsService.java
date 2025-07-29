package expo.modules.adapters.react.permissions;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.Promise;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.LifecycleEventListener;
import expo.modules.core.interfaces.services.UIManager;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.interfaces.permissions.PermissionsResponseListener;
import expo.modules.interfaces.permissions.PermissionsStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionsService.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010\u0019\u001a\u00020\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0002\u0010\u001cJ%\u0010\u001d\u001a\u00020\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e2\u0006\u0010\u001e\u001a\u00020\fH\u0014¢\u0006\u0002\u0010\u001fJ)\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\f2\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000fH\u0016¢\u0006\u0002\u0010\"J)\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%2\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000fH\u0016¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020\u001aH\u0002J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000fH\u0002J\b\u0010*\u001a\u00020+H\u0002J#\u0010,\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u001e\u001a\u00020\fH\u0004¢\u0006\u0002\u0010\u001fJ\u0010\u0010-\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000fH\u0002J\u0016\u0010.\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u000201000/H\u0016J\u0010\u00102\u001a\u0002032\u0006\u0010)\u001a\u00020\u000fH\u0002J\u0010\u00104\u001a\u0002032\u0006\u0010)\u001a\u00020\u000fH\u0014J\u0018\u00105\u001a\u0002062\u0006\u0010)\u001a\u00020\u000f2\u0006\u00107\u001a\u000203H\u0002J)\u00108\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\f2\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000fH\u0016¢\u0006\u0002\u0010\"J)\u00109\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%2\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000fH\u0016¢\u0006\u0002\u0010&J!\u0010:\u001a\u00020\u00182\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000fH\u0016¢\u0006\u0002\u0010;J\b\u0010<\u001a\u00020\u0018H\u0002J\u0010\u0010=\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000fH\u0002J\u0010\u0010>\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000fH\u0016J\u0010\u0010?\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020\u001aH\u0016J\b\u0010C\u001a\u00020\u001aH\u0016J\b\u0010D\u001a\u00020\u001aH\u0016J1\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002060F2\u000e\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e2\u0006\u0010H\u001a\u00020IH\u0002¢\u0006\u0002\u0010JR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0014\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\f0\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lexpo/modules/adapters/react/permissions/PermissionsService;", "Lexpo/modules/core/interfaces/InternalModule;", "Lexpo/modules/interfaces/permissions/Permissions;", "Lexpo/modules/core/interfaces/LifecycleEventListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mActivityProvider", "Lexpo/modules/core/interfaces/ActivityProvider;", "mAskAsyncListener", "Lexpo/modules/interfaces/permissions/PermissionsResponseListener;", "mAskAsyncRequestedPermissions", "", "", "[Ljava/lang/String;", "mAskedPermissionsCache", "Landroid/content/SharedPreferences;", "mCurrentPermissionListener", "mPendingPermissionCalls", "Ljava/util/Queue;", "Lkotlin/Pair;", "mWriteSettingsPermissionBeingAsked", "", "addToAskedPermissionsCache", "", "permissions", "([Ljava/lang/String;)V", "askForManifestPermissions", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "([Ljava/lang/String;Lexpo/modules/interfaces/permissions/PermissionsResponseListener;)V", "askForPermissions", "responseListener", "(Lexpo/modules/interfaces/permissions/PermissionsResponseListener;[Ljava/lang/String;)V", "askForPermissionsWithPromise", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/core/Promise;", "(Lexpo/modules/core/Promise;[Ljava/lang/String;)V", "askForWriteSettingsPermissionFirst", PermissionsResponse.CAN_ASK_AGAIN_KEY, "permission", "createListenerWithPendingPermissionsRequest", "Lcom/facebook/react/modules/core/PermissionListener;", "delegateRequestToActivity", "didAsk", "getExportedInterfaces", "", "Ljava/lang/Class;", "", "getManifestPermission", "", "getManifestPermissionFromContext", "getPermissionResponseFromNativeResponse", "Lexpo/modules/interfaces/permissions/PermissionsResponse;", "result", "getPermissions", "getPermissionsWithPromise", "hasGrantedPermissions", "([Ljava/lang/String;)Z", "hasWriteSettingsPermission", "isPermissionGranted", "isPermissionPresentInManifest", "onCreate", "moduleRegistry", "Lexpo/modules/core/ModuleRegistry;", "onHostDestroy", "onHostPause", "onHostResume", "parseNativeResult", "", "permissionsString", "grantResults", "", "([Ljava/lang/String;[I)Ljava/util/Map;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class PermissionsService implements InternalModule, Permissions, LifecycleEventListener {
    public static final int $stable = 8;
    private final Context context;
    private ActivityProvider mActivityProvider;
    private PermissionsResponseListener mAskAsyncListener;
    private String[] mAskAsyncRequestedPermissions;
    private SharedPreferences mAskedPermissionsCache;
    private PermissionsResponseListener mCurrentPermissionListener;
    private final Queue<Pair<String[], PermissionsResponseListener>> mPendingPermissionCalls;
    private boolean mWriteSettingsPermissionBeingAsked;

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostPause() {
    }

    public PermissionsService(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mPendingPermissionCalls = new LinkedList();
    }

    public final Context getContext() {
        return this.context;
    }

    private final boolean didAsk(String permission) {
        SharedPreferences sharedPreferences = this.mAskedPermissionsCache;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAskedPermissionsCache");
            sharedPreferences = null;
        }
        return sharedPreferences.getBoolean(permission, false);
    }

    private final void addToAskedPermissionsCache(String[] permissions) {
        SharedPreferences sharedPreferences = this.mAskedPermissionsCache;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAskedPermissionsCache");
            sharedPreferences = null;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        for (String str : permissions) {
            editorEdit.putBoolean(str, true);
        }
        editorEdit.apply();
    }

    @Override // expo.modules.core.interfaces.InternalModule
    public List<Class<? extends Object>> getExportedInterfaces() {
        return CollectionsKt.listOf(Permissions.class);
    }

    @Override // expo.modules.core.interfaces.RegistryLifecycleListener
    public void onCreate(ModuleRegistry moduleRegistry) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(moduleRegistry, "moduleRegistry");
        ActivityProvider activityProvider = (ActivityProvider) moduleRegistry.getModule(ActivityProvider.class);
        if (activityProvider == null) {
            throw new IllegalStateException("Couldn't find implementation for ActivityProvider.");
        }
        this.mActivityProvider = activityProvider;
        ((UIManager) moduleRegistry.getModule(UIManager.class)).registerLifecycleEventListener(this);
        SharedPreferences sharedPreferences = this.context.getApplicationContext().getSharedPreferences("expo.modules.permissions.asked", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.mAskedPermissionsCache = sharedPreferences;
    }

    @Override // expo.modules.interfaces.permissions.Permissions
    public void getPermissionsWithPromise(final Promise promise, String... permissions) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        getPermissions(new PermissionsResponseListener() { // from class: expo.modules.adapters.react.permissions.PermissionsService$$ExternalSyntheticLambda3
            @Override // expo.modules.interfaces.permissions.PermissionsResponseListener
            public final void onResult(Map map) {
                PermissionsService.getPermissionsWithPromise$lambda$6(promise, map);
            }
        }, (String[]) Arrays.copyOf(permissions, permissions.length));
    }

    @Override // expo.modules.interfaces.permissions.Permissions
    public void askForPermissionsWithPromise(final Promise promise, final String... permissions) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        askForPermissions(new PermissionsResponseListener() { // from class: expo.modules.adapters.react.permissions.PermissionsService$$ExternalSyntheticLambda0
            @Override // expo.modules.interfaces.permissions.PermissionsResponseListener
            public final void onResult(Map map) {
                PermissionsService.askForPermissionsWithPromise$lambda$7(this.f$0, promise, permissions, map);
            }
        }, (String[]) Arrays.copyOf(permissions, permissions.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void askForPermissionsWithPromise$lambda$7(PermissionsService this$0, Promise promise, String[] permissions, Map map) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(permissions, "$permissions");
        this$0.getPermissionsWithPromise(promise, (String[]) Arrays.copyOf(permissions, permissions.length));
    }

    @Override // expo.modules.interfaces.permissions.Permissions
    public void askForPermissions(final PermissionsResponseListener responseListener, String... permissions) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(responseListener, "responseListener");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        if (permissions.length == 0) {
            responseListener.onResult(new LinkedHashMap());
            return;
        }
        if (ArraysKt.contains(permissions, "android.permission.WRITE_SETTINGS")) {
            List mutableList = ArraysKt.toMutableList(permissions);
            mutableList.remove("android.permission.WRITE_SETTINGS");
            String[] strArr = (String[]) mutableList.toArray(new String[0]);
            PermissionsResponseListener permissionsResponseListener = new PermissionsResponseListener() { // from class: expo.modules.adapters.react.permissions.PermissionsService$$ExternalSyntheticLambda1
                @Override // expo.modules.interfaces.permissions.PermissionsResponseListener
                public final void onResult(Map map) {
                    PermissionsService.askForPermissions$lambda$10(this.f$0, responseListener, map);
                }
            };
            if (!hasWriteSettingsPermission()) {
                if (this.mAskAsyncListener != null) {
                    throw new IllegalStateException("Another permissions request is in progress. Await the old request and then try again.");
                }
                this.mAskAsyncListener = permissionsResponseListener;
                this.mAskAsyncRequestedPermissions = strArr;
                addToAskedPermissionsCache(new String[]{"android.permission.WRITE_SETTINGS"});
                askForWriteSettingsPermissionFirst();
                return;
            }
            if (strArr.length == 0) {
                permissionsResponseListener.onResult(new LinkedHashMap());
                return;
            } else {
                askForManifestPermissions(strArr, permissionsResponseListener);
                return;
            }
        }
        askForManifestPermissions(permissions, responseListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void askForPermissions$lambda$10(PermissionsService this$0, PermissionsResponseListener responseListener, Map map) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(responseListener, "$responseListener");
        int i = this$0.hasWriteSettingsPermission() ? 0 : -1;
        Intrinsics.checkNotNull(map);
        map.put("android.permission.WRITE_SETTINGS", this$0.getPermissionResponseFromNativeResponse("android.permission.WRITE_SETTINGS", i));
        responseListener.onResult(map);
    }

    @Override // expo.modules.interfaces.permissions.Permissions
    public boolean isPermissionPresentInManifest(String permission) throws PackageManager.NameNotFoundException {
        Intrinsics.checkNotNullParameter(permission, "permission");
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 4096);
            if (packageInfo != null) {
                String[] strArr = packageInfo.requestedPermissions;
                Intrinsics.checkNotNull(strArr);
                return ArraysKt.contains(strArr, permission);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    private final boolean isPermissionGranted(String permission) {
        return Intrinsics.areEqual(permission, "android.permission.WRITE_SETTINGS") ? hasWriteSettingsPermission() : getManifestPermission(permission) == 0;
    }

    private final int getManifestPermission(String permission) {
        Activity currentActivity;
        ActivityProvider activityProvider = this.mActivityProvider;
        if (activityProvider != null && (currentActivity = activityProvider.getCurrentActivity()) != null && (currentActivity instanceof PermissionAwareActivity)) {
            return ContextCompat.checkSelfPermission(currentActivity, permission);
        }
        return getManifestPermissionFromContext(permission);
    }

    protected int getManifestPermissionFromContext(String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        return ContextCompat.checkSelfPermission(this.context, permission);
    }

    private final boolean canAskAgain(String permission) {
        Activity currentActivity;
        ActivityProvider activityProvider = this.mActivityProvider;
        return (activityProvider == null || (currentActivity = activityProvider.getCurrentActivity()) == null || !ActivityCompat.shouldShowRequestPermissionRationale(currentActivity, permission)) ? false : true;
    }

    private final Map<String, PermissionsResponse> parseNativeResult(String[] permissionsString, int[] grantResults) {
        HashMap map = new HashMap();
        for (Pair pair : ArraysKt.zip(grantResults, (Object[]) permissionsString)) {
            int iIntValue = ((Number) pair.component1()).intValue();
            String str = (String) pair.component2();
            map.put(str, getPermissionResponseFromNativeResponse(str, iIntValue));
        }
        return map;
    }

    private final PermissionsResponse getPermissionResponseFromNativeResponse(String permission, int result) {
        PermissionsStatus permissionsStatus;
        if (result == 0) {
            permissionsStatus = PermissionsStatus.GRANTED;
        } else {
            permissionsStatus = didAsk(permission) ? PermissionsStatus.DENIED : PermissionsStatus.UNDETERMINED;
        }
        return new PermissionsResponse(permissionsStatus, permissionsStatus == PermissionsStatus.DENIED ? canAskAgain(permission) : true);
    }

    protected void askForManifestPermissions(String[] permissions, PermissionsResponseListener listener) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(listener, "listener");
        delegateRequestToActivity((String[]) Arrays.copyOf(permissions, permissions.length), listener);
    }

    protected final void delegateRequestToActivity(String[] permissions, PermissionsResponseListener listener) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(listener, "listener");
        addToAskedPermissionsCache(permissions);
        ActivityProvider activityProvider = this.mActivityProvider;
        ComponentCallbacks2 currentActivity = activityProvider != null ? activityProvider.getCurrentActivity() : null;
        if (currentActivity instanceof PermissionAwareActivity) {
            synchronized (this) {
                if (this.mCurrentPermissionListener != null) {
                    Boolean.valueOf(this.mPendingPermissionCalls.add(TuplesKt.to(permissions, listener)));
                } else {
                    this.mCurrentPermissionListener = listener;
                    ((PermissionAwareActivity) currentActivity).requestPermissions(permissions, 13, createListenerWithPendingPermissionsRequest());
                    Unit unit = Unit.INSTANCE;
                }
            }
            return;
        }
        int length = permissions.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = -1;
        }
        listener.onResult(parseNativeResult(permissions, iArr));
    }

    private final PermissionListener createListenerWithPendingPermissionsRequest() {
        return new PermissionListener() { // from class: expo.modules.adapters.react.permissions.PermissionsService$$ExternalSyntheticLambda2
            @Override // com.facebook.react.modules.core.PermissionListener
            public final boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                return PermissionsService.createListenerWithPendingPermissionsRequest$lambda$21(this.f$0, i, strArr, iArr);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean createListenerWithPendingPermissionsRequest$lambda$21(PermissionsService this$0, int i, String[] receivePermissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(receivePermissions, "receivePermissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (i != 13) {
            return false;
        }
        synchronized (this$0) {
            PermissionsResponseListener permissionsResponseListener = this$0.mCurrentPermissionListener;
            if (permissionsResponseListener == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            permissionsResponseListener.onResult(this$0.parseNativeResult(receivePermissions, grantResults));
            this$0.mCurrentPermissionListener = null;
            Pair<String[], PermissionsResponseListener> pairPoll = this$0.mPendingPermissionCalls.poll();
            if (pairPoll != null) {
                Intrinsics.checkNotNull(pairPoll);
                ActivityProvider activityProvider = this$0.mActivityProvider;
                Object currentActivity = activityProvider != null ? activityProvider.getCurrentActivity() : null;
                PermissionAwareActivity permissionAwareActivity = currentActivity instanceof PermissionAwareActivity ? (PermissionAwareActivity) currentActivity : null;
                if (permissionAwareActivity == null) {
                    PermissionsResponseListener second = pairPoll.getSecond();
                    String[] first = pairPoll.getFirst();
                    int length = pairPoll.getFirst().length;
                    int[] iArr = new int[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr[i2] = -1;
                    }
                    second.onResult(this$0.parseNativeResult(first, iArr));
                    Iterator<T> it = this$0.mPendingPermissionCalls.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        PermissionsResponseListener permissionsResponseListener2 = (PermissionsResponseListener) pair.getSecond();
                        String[] strArr = (String[]) pair.getFirst();
                        int length2 = ((Object[]) pair.getFirst()).length;
                        int[] iArr2 = new int[length2];
                        for (int i3 = 0; i3 < length2; i3++) {
                            iArr2[i3] = -1;
                        }
                        permissionsResponseListener2.onResult(this$0.parseNativeResult(strArr, iArr2));
                    }
                    this$0.mPendingPermissionCalls.clear();
                } else {
                    this$0.mCurrentPermissionListener = pairPoll.getSecond();
                    permissionAwareActivity.requestPermissions(pairPoll.getFirst(), 13, this$0.createListenerWithPendingPermissionsRequest());
                    return false;
                }
            }
            return true;
        }
    }

    private final void askForWriteSettingsPermissionFirst() {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + this.context.getPackageName()));
        intent.addFlags(268435456);
        this.mWriteSettingsPermissionBeingAsked = true;
        this.context.startActivity(intent);
    }

    private final boolean hasWriteSettingsPermission() {
        return Settings.System.canWrite(this.context.getApplicationContext());
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostResume() {
        if (this.mWriteSettingsPermissionBeingAsked) {
            this.mWriteSettingsPermissionBeingAsked = false;
            PermissionsResponseListener permissionsResponseListener = this.mAskAsyncListener;
            Intrinsics.checkNotNull(permissionsResponseListener);
            String[] strArr = this.mAskAsyncRequestedPermissions;
            Intrinsics.checkNotNull(strArr);
            this.mAskAsyncListener = null;
            this.mAskAsyncRequestedPermissions = null;
            if (!(strArr.length == 0)) {
                askForManifestPermissions(strArr, permissionsResponseListener);
            } else {
                permissionsResponseListener.onResult(new LinkedHashMap());
            }
        }
    }

    @Override // expo.modules.interfaces.permissions.Permissions
    public void getPermissions(PermissionsResponseListener responseListener, String... permissions) {
        Intrinsics.checkNotNullParameter(responseListener, "responseListener");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        ArrayList arrayList = new ArrayList(permissions.length);
        for (String str : permissions) {
            arrayList.add(Integer.valueOf(isPermissionGranted(str) ? 0 : -1));
        }
        responseListener.onResult(parseNativeResult(permissions, CollectionsKt.toIntArray(arrayList)));
    }

    @Override // expo.modules.interfaces.permissions.Permissions
    public boolean hasGrantedPermissions(String... permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        for (String str : permissions) {
            if (!isPermissionGranted(str)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPermissionsWithPromise$lambda$6(Promise promise, Map permissionsMap) {
        boolean z;
        boolean z2;
        String status;
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(permissionsMap, "permissionsMap");
        boolean z3 = false;
        if (permissionsMap.isEmpty()) {
            z = true;
        } else {
            Iterator it = permissionsMap.entrySet().iterator();
            while (it.hasNext()) {
                if (((PermissionsResponse) ((Map.Entry) it.next()).getValue()).getStatus() != PermissionsStatus.GRANTED) {
                    z = false;
                    break;
                }
            }
            z = true;
        }
        if (permissionsMap.isEmpty()) {
            z2 = false;
            break;
        }
        if (!permissionsMap.isEmpty()) {
            Iterator it2 = permissionsMap.entrySet().iterator();
            while (it2.hasNext()) {
                if (((PermissionsResponse) ((Map.Entry) it2.next()).getValue()).getStatus() != PermissionsStatus.DENIED) {
                    z2 = false;
                    break;
                }
            }
        }
        z2 = true;
        if (permissionsMap.isEmpty()) {
            z3 = true;
        } else {
            Iterator it3 = permissionsMap.entrySet().iterator();
            while (it3.hasNext()) {
                if (!((PermissionsResponse) ((Map.Entry) it3.next()).getValue()).getCanAskAgain()) {
                    break;
                }
            }
            z3 = true;
        }
        Bundle bundle = new Bundle();
        bundle.putString(PermissionsResponse.EXPIRES_KEY, "never");
        if (z) {
            status = PermissionsStatus.GRANTED.getStatus();
        } else if (z2) {
            status = PermissionsStatus.DENIED.getStatus();
        } else {
            status = PermissionsStatus.UNDETERMINED.getStatus();
        }
        bundle.putString("status", status);
        bundle.putBoolean(PermissionsResponse.CAN_ASK_AGAIN_KEY, z3);
        bundle.putBoolean(PermissionsResponse.GRANTED_KEY, z);
        promise.resolve(bundle);
    }
}
