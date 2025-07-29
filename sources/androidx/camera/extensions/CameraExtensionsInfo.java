package androidx.camera.extensions;

import androidx.lifecycle.LiveData;

/* loaded from: classes.dex */
public interface CameraExtensionsInfo {
    default LiveData<Integer> getCurrentExtensionMode() {
        return null;
    }

    default LiveData<Integer> getExtensionStrength() {
        return null;
    }

    default boolean isCurrentExtensionModeAvailable() {
        return false;
    }

    default boolean isExtensionStrengthAvailable() {
        return false;
    }
}
