package com.facebook.drawee.drawable;

import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import javax.annotation.Nullable;

/* loaded from: classes4.dex */
public class DrawableProperties {
    private static final int UNSET = -1;
    private int mAlpha = -1;
    private boolean mIsSetColorFilter = false;

    @Nullable
    private ColorFilter mColorFilter = null;
    private int mDither = -1;
    private int mFilterBitmap = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.mIsSetColorFilter = colorFilter != null;
    }

    public void setDither(boolean z) {
        this.mDither = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.mFilterBitmap = z ? 1 : 0;
    }

    public void applyTo(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        int i = this.mAlpha;
        if (i != -1) {
            drawable.setAlpha(i);
        }
        if (this.mIsSetColorFilter) {
            drawable.setColorFilter(this.mColorFilter);
        }
        int i2 = this.mDither;
        if (i2 != -1) {
            drawable.setDither(i2 != 0);
        }
        int i3 = this.mFilterBitmap;
        if (i3 != -1) {
            drawable.setFilterBitmap(i3 != 0);
        }
    }
}
