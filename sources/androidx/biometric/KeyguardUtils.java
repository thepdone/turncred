package androidx.biometric;

import android.app.KeyguardManager;
import android.content.Context;

/* loaded from: classes.dex */
class KeyguardUtils {
    private KeyguardUtils() {
    }

    static KeyguardManager getKeyguardManager(Context context) {
        return Api23Impl.getKeyguardManager(context);
    }

    static boolean isDeviceSecuredWithCredential(Context context) {
        KeyguardManager keyguardManager = getKeyguardManager(context);
        if (keyguardManager == null) {
            return false;
        }
        return Api23Impl.isDeviceSecure(keyguardManager);
    }

    private static class Api23Impl {
        private Api23Impl() {
        }

        static KeyguardManager getKeyguardManager(Context context) {
            return (KeyguardManager) context.getSystemService(KeyguardManager.class);
        }

        static boolean isDeviceSecure(KeyguardManager keyguardManager) {
            return keyguardManager.isDeviceSecure();
        }
    }

    private static class Api16Impl {
        private Api16Impl() {
        }

        static boolean isKeyguardSecure(KeyguardManager keyguardManager) {
            return keyguardManager.isKeyguardSecure();
        }
    }
}
