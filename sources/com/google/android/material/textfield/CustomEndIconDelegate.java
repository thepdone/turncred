package com.google.android.material.textfield;

/* loaded from: classes3.dex */
class CustomEndIconDelegate extends EndIconDelegate {
    CustomEndIconDelegate(TextInputLayout textInputLayout, int i) {
        super(textInputLayout, i);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void initialize() {
        this.textInputLayout.setEndIconDrawable(this.customEndIcon);
        this.textInputLayout.setEndIconOnClickListener(null);
        this.textInputLayout.setEndIconOnLongClickListener(null);
    }
}
