package com.facebook.react.views.text;

import com.facebook.common.logging.FLog;
import com.facebook.react.uimanager.PixelUtil;

/* loaded from: classes3.dex */
public class TextAttributes {
    public static final float DEFAULT_MAX_FONT_SIZE_MULTIPLIER = 0.0f;
    private boolean mAllowFontScaling = true;
    private float mFontSize = Float.NaN;
    private float mLineHeight = Float.NaN;
    private float mLetterSpacing = Float.NaN;
    private float mMaxFontSizeMultiplier = Float.NaN;
    private float mHeightOfTallestInlineViewOrImage = Float.NaN;
    private TextTransform mTextTransform = TextTransform.UNSET;

    public TextAttributes applyChild(TextAttributes textAttributes) {
        float f;
        float f2;
        TextAttributes textAttributes2 = new TextAttributes();
        textAttributes2.mAllowFontScaling = this.mAllowFontScaling;
        textAttributes2.mFontSize = !Float.isNaN(textAttributes.mFontSize) ? textAttributes.mFontSize : this.mFontSize;
        textAttributes2.mLineHeight = !Float.isNaN(textAttributes.mLineHeight) ? textAttributes.mLineHeight : this.mLineHeight;
        textAttributes2.mLetterSpacing = !Float.isNaN(textAttributes.mLetterSpacing) ? textAttributes.mLetterSpacing : this.mLetterSpacing;
        if (!Float.isNaN(textAttributes.mMaxFontSizeMultiplier)) {
            f = textAttributes.mMaxFontSizeMultiplier;
        } else {
            f = this.mMaxFontSizeMultiplier;
        }
        textAttributes2.mMaxFontSizeMultiplier = f;
        if (!Float.isNaN(textAttributes.mHeightOfTallestInlineViewOrImage)) {
            f2 = textAttributes.mHeightOfTallestInlineViewOrImage;
        } else {
            f2 = this.mHeightOfTallestInlineViewOrImage;
        }
        textAttributes2.mHeightOfTallestInlineViewOrImage = f2;
        textAttributes2.mTextTransform = textAttributes.mTextTransform != TextTransform.UNSET ? textAttributes.mTextTransform : this.mTextTransform;
        return textAttributes2;
    }

    public boolean getAllowFontScaling() {
        return this.mAllowFontScaling;
    }

    public void setAllowFontScaling(boolean z) {
        this.mAllowFontScaling = z;
    }

    public float getFontSize() {
        return this.mFontSize;
    }

    public void setFontSize(float f) {
        this.mFontSize = f;
    }

    public float getLineHeight() {
        return this.mLineHeight;
    }

    public void setLineHeight(float f) {
        this.mLineHeight = f;
    }

    public float getLetterSpacing() {
        return this.mLetterSpacing;
    }

    public void setLetterSpacing(float f) {
        this.mLetterSpacing = f;
    }

    public float getMaxFontSizeMultiplier() {
        return this.mMaxFontSizeMultiplier;
    }

    public void setMaxFontSizeMultiplier(float f) {
        if (f != 0.0f && f < 1.0f) {
            FLog.w("ReactNative", "maxFontSizeMultiplier must be NaN, 0, or >= 1");
            this.mMaxFontSizeMultiplier = Float.NaN;
        } else {
            this.mMaxFontSizeMultiplier = f;
        }
    }

    public float getHeightOfTallestInlineViewOrImage() {
        return this.mHeightOfTallestInlineViewOrImage;
    }

    public void setHeightOfTallestInlineViewOrImage(float f) {
        this.mHeightOfTallestInlineViewOrImage = f;
    }

    public TextTransform getTextTransform() {
        return this.mTextTransform;
    }

    public void setTextTransform(TextTransform textTransform) {
        this.mTextTransform = textTransform;
    }

    public int getEffectiveFontSize() {
        double dCeil;
        float f = !Float.isNaN(this.mFontSize) ? this.mFontSize : 14.0f;
        if (this.mAllowFontScaling) {
            dCeil = Math.ceil(PixelUtil.toPixelFromSP(f, getEffectiveMaxFontSizeMultiplier()));
        } else {
            dCeil = Math.ceil(PixelUtil.toPixelFromDIP(f));
        }
        return (int) dCeil;
    }

    public float getEffectiveLineHeight() {
        float pixelFromDIP;
        if (Float.isNaN(this.mLineHeight)) {
            return Float.NaN;
        }
        if (this.mAllowFontScaling) {
            pixelFromDIP = PixelUtil.toPixelFromSP(this.mLineHeight, getEffectiveMaxFontSizeMultiplier());
        } else {
            pixelFromDIP = PixelUtil.toPixelFromDIP(this.mLineHeight);
        }
        if (Float.isNaN(this.mHeightOfTallestInlineViewOrImage)) {
            return pixelFromDIP;
        }
        float f = this.mHeightOfTallestInlineViewOrImage;
        return f > pixelFromDIP ? f : pixelFromDIP;
    }

    public float getEffectiveLetterSpacing() {
        float pixelFromDIP;
        if (Float.isNaN(this.mLetterSpacing)) {
            return Float.NaN;
        }
        if (this.mAllowFontScaling) {
            pixelFromDIP = PixelUtil.toPixelFromSP(this.mLetterSpacing, getEffectiveMaxFontSizeMultiplier());
        } else {
            pixelFromDIP = PixelUtil.toPixelFromDIP(this.mLetterSpacing);
        }
        return pixelFromDIP / getEffectiveFontSize();
    }

    public float getEffectiveMaxFontSizeMultiplier() {
        if (Float.isNaN(this.mMaxFontSizeMultiplier)) {
            return 0.0f;
        }
        return this.mMaxFontSizeMultiplier;
    }

    public String toString() {
        return "TextAttributes {\n  getAllowFontScaling(): " + getAllowFontScaling() + "\n  getFontSize(): " + getFontSize() + "\n  getEffectiveFontSize(): " + getEffectiveFontSize() + "\n  getHeightOfTallestInlineViewOrImage(): " + getHeightOfTallestInlineViewOrImage() + "\n  getLetterSpacing(): " + getLetterSpacing() + "\n  getEffectiveLetterSpacing(): " + getEffectiveLetterSpacing() + "\n  getLineHeight(): " + getLineHeight() + "\n  getEffectiveLineHeight(): " + getEffectiveLineHeight() + "\n  getTextTransform(): " + getTextTransform() + "\n  getMaxFontSizeMultiplier(): " + getMaxFontSizeMultiplier() + "\n  getEffectiveMaxFontSizeMultiplier(): " + getEffectiveMaxFontSizeMultiplier() + "\n}";
    }
}
