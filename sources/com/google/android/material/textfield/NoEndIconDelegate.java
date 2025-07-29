package com.google.android.material.textfield;

import android.graphics.drawable.Drawable;

/* loaded from: classes3.dex */
class NoEndIconDelegate extends EndIconDelegate {
    NoEndIconDelegate(TextInputLayout textInputLayout) {
        super(textInputLayout, 0);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void initialize() {
        this.textInputLayout.setEndIconOnClickListener(null);
        this.textInputLayout.setEndIconDrawable((Drawable) null);
        this.textInputLayout.setEndIconContentDescription((CharSequence) null);
    }
}
