package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;

/* loaded from: classes3.dex */
abstract class EndIconDelegate {
    Context context;
    final int customEndIcon;
    CheckableImageButton endIconView;
    TextInputLayout textInputLayout;

    abstract void initialize();

    boolean isBoxBackgroundModeSupported(int i) {
        return true;
    }

    void onSuffixVisibilityChanged(boolean z) {
    }

    boolean shouldTintIconOnError() {
        return false;
    }

    EndIconDelegate(TextInputLayout textInputLayout, int i) {
        this.textInputLayout = textInputLayout;
        this.context = textInputLayout.getContext();
        this.endIconView = textInputLayout.getEndIconView();
        this.customEndIcon = i;
    }
}
