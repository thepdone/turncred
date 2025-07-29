package androidx.biometric;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/* loaded from: classes.dex */
class PackageUtils {
    private PackageUtils() {
    }

    static boolean hasSystemFeatureFingerprint(Context context) {
        return (context == null || context.getPackageManager() == null || !Api23Impl.hasSystemFeatureFingerprint(context.getPackageManager())) ? false : true;
    }

    static boolean hasSystemFeatureFace(Context context) {
        return Build.VERSION.SDK_INT >= 29 && context != null && context.getPackageManager() != null && Api29Impl.hasSystemFeatureFace(context.getPackageManager());
    }

    static boolean hasSystemFeatureIris(Context context) {
        return Build.VERSION.SDK_INT >= 29 && context != null && context.getPackageManager() != null && Api29Impl.hasSystemFeatureIris(context.getPackageManager());
    }

    private static class Api23Impl {
        private Api23Impl() {
        }

        static boolean hasSystemFeatureFingerprint(PackageManager packageManager) {
            return packageManager.hasSystemFeature("android.hardware.fingerprint");
        }
    }

    private static class Api29Impl {
        private Api29Impl() {
        }

        static boolean hasSystemFeatureFace(PackageManager packageManager) {
            return packageManager.hasSystemFeature("android.hardware.biometrics.face");
        }

        static boolean hasSystemFeatureIris(PackageManager packageManager) {
            return packageManager.hasSystemFeature("android.hardware.biometrics.iris");
        }
    }
}
