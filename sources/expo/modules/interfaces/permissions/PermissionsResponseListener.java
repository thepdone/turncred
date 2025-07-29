package expo.modules.interfaces.permissions;

import java.util.Map;

@FunctionalInterface
/* loaded from: classes5.dex */
public interface PermissionsResponseListener {
    void onResult(Map<String, PermissionsResponse> map);
}
