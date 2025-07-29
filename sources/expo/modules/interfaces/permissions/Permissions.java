package expo.modules.interfaces.permissions;

import expo.modules.core.Promise;
import expo.modules.medialibrary.MediaLibraryConstantsKt;

/* loaded from: classes5.dex */
public interface Permissions {
    void askForPermissions(PermissionsResponseListener permissionsResponseListener, String... strArr);

    void askForPermissionsWithPromise(Promise promise, String... strArr);

    void getPermissions(PermissionsResponseListener permissionsResponseListener, String... strArr);

    void getPermissionsWithPromise(Promise promise, String... strArr);

    boolean hasGrantedPermissions(String... strArr);

    boolean isPermissionPresentInManifest(String str);

    static void getPermissionsWithPermissionsManager(Permissions permissions, Promise promise, String... strArr) {
        if (permissions == null) {
            promise.reject(MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS, "Permissions module is null. Are you sure all the installed Expo modules are properly linked?");
        } else {
            permissions.getPermissionsWithPromise(promise, strArr);
        }
    }

    static void getPermissionsWithPermissionsManager(Permissions permissions, final expo.modules.kotlin.Promise promise, String... strArr) {
        getPermissionsWithPermissionsManager(permissions, new Promise() { // from class: expo.modules.interfaces.permissions.Permissions.1
            @Override // expo.modules.core.Promise
            public void resolve(Object obj) {
                promise.resolve(obj);
            }

            @Override // expo.modules.core.Promise
            public void reject(String str, String str2, Throwable th) {
                promise.reject(str, str2, th);
            }
        }, strArr);
    }

    static void askForPermissionsWithPermissionsManager(Permissions permissions, Promise promise, String... strArr) {
        if (permissions == null) {
            promise.reject(MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS, "Permissions module is null. Are you sure all the installed Expo modules are properly linked?");
        } else {
            permissions.askForPermissionsWithPromise(promise, strArr);
        }
    }

    static void askForPermissionsWithPermissionsManager(Permissions permissions, final expo.modules.kotlin.Promise promise, String... strArr) {
        askForPermissionsWithPermissionsManager(permissions, new Promise() { // from class: expo.modules.interfaces.permissions.Permissions.2
            @Override // expo.modules.core.Promise
            public void resolve(Object obj) {
                promise.resolve(obj);
            }

            @Override // expo.modules.core.Promise
            public void reject(String str, String str2, Throwable th) {
                promise.reject(str, str2, th);
            }
        }, strArr);
    }
}
