package com.bumptech.glide.module;

import android.content.Context;
import com.bumptech.glide.GlideBuilder;

/* loaded from: classes4.dex */
public abstract class AppGlideModule extends LibraryGlideModule implements AppliesOptions {
    public void applyOptions(Context context, GlideBuilder glideBuilder) {
    }

    public boolean isManifestParsingEnabled() {
        return true;
    }
}
