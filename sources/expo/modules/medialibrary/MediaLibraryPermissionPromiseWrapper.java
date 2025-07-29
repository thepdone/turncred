package expo.modules.medialibrary;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.interfaces.permissions.PermissionsStatus;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.CodedException;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MediaLibraryPermissionPromiseWrapper.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0001\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lexpo/modules/medialibrary/MediaLibraryPermissionPromiseWrapper;", "Lexpo/modules/kotlin/Promise;", "granularPermissions", "", "Lexpo/modules/medialibrary/GranularPermission;", BaseJavaModule.METHOD_TYPE_PROMISE, "contextHolder", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "(Ljava/util/List;Lexpo/modules/kotlin/Promise;Ljava/lang/ref/WeakReference;)V", "addOnlySelectedInfoToPermissionsBundle", "Landroid/os/Bundle;", "permissionsBundle", "reject", "", "code", "", "message", "cause", "", "resolve", "value", "", "Companion", "expo-media-library_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MediaLibraryPermissionPromiseWrapper implements Promise {
    public static final String ACCESS_PRIVILEGES_PERMISSION_KEY = "accessPrivileges";
    private final WeakReference<Context> contextHolder;
    private final List<GranularPermission> granularPermissions;
    private final Promise promise;

    /* JADX WARN: Multi-variable type inference failed */
    public MediaLibraryPermissionPromiseWrapper(List<? extends GranularPermission> granularPermissions, Promise promise, WeakReference<Context> contextHolder) {
        Intrinsics.checkNotNullParameter(granularPermissions, "granularPermissions");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(contextHolder, "contextHolder");
        this.granularPermissions = granularPermissions;
        this.promise = promise;
        this.contextHolder = contextHolder;
    }

    @Override // expo.modules.kotlin.Promise
    public void reject(CodedException codedException) {
        Promise.DefaultImpls.reject(this, codedException);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve() {
        Promise.DefaultImpls.resolve(this);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(double d) {
        Promise.DefaultImpls.resolve(this, d);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(float f) {
        Promise.DefaultImpls.resolve((Promise) this, f);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(int i) {
        Promise.DefaultImpls.resolve((Promise) this, i);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(String str) {
        Promise.DefaultImpls.resolve(this, str);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(Collection<? extends Object> collection) {
        Promise.DefaultImpls.resolve(this, collection);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(Map<String, ? extends Object> map) {
        Promise.DefaultImpls.resolve(this, map);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(boolean z) {
        Promise.DefaultImpls.resolve(this, z);
    }

    @Override // expo.modules.kotlin.Promise
    public void resolve(Object value) {
        if (!(value instanceof Bundle)) {
            this.promise.resolve(value);
        } else {
            this.promise.resolve(addOnlySelectedInfoToPermissionsBundle((Bundle) value, this.granularPermissions));
        }
    }

    @Override // expo.modules.kotlin.Promise
    public void reject(String code, String message, Throwable cause) {
        Intrinsics.checkNotNullParameter(code, "code");
        this.promise.reject(code, message, cause);
    }

    private final Bundle addOnlySelectedInfoToPermissionsBundle(Bundle permissionsBundle, List<? extends GranularPermission> granularPermissions) {
        AccessPrivileges accessPrivileges;
        Context context = this.contextHolder.get();
        if (context == null) {
            return permissionsBundle;
        }
        boolean z = permissionsBundle.getBoolean(PermissionsResponse.GRANTED_KEY);
        if (Build.VERSION.SDK_INT < 34) {
            if (z) {
                accessPrivileges = AccessPrivileges.ALL;
            } else {
                accessPrivileges = AccessPrivileges.NONE;
            }
            permissionsBundle.putString("accessPrivileges", accessPrivileges.getValue());
            return permissionsBundle;
        }
        if (z) {
            permissionsBundle.putString("accessPrivileges", AccessPrivileges.ALL.getValue());
            return permissionsBundle;
        }
        boolean zContains = granularPermissions.contains(GranularPermission.AUDIO);
        boolean z2 = ContextCompat.checkSelfPermission(context, "android.permission.READ_MEDIA_AUDIO") == 0;
        boolean z3 = ContextCompat.checkSelfPermission(context, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == 0;
        if ((!zContains || z2) && z3) {
            permissionsBundle.putBoolean(PermissionsResponse.GRANTED_KEY, true);
            permissionsBundle.putBoolean(PermissionsResponse.CAN_ASK_AGAIN_KEY, true);
            permissionsBundle.putString("status", PermissionsStatus.GRANTED.getStatus());
            permissionsBundle.putString("accessPrivileges", AccessPrivileges.LIMITED.getValue());
        } else {
            permissionsBundle.putString("accessPrivileges", AccessPrivileges.NONE.getValue());
        }
        return permissionsBundle;
    }
}
