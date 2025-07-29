package com.facebook.react.views.text.internal.span;

import android.content.res.AssetManager;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.text.ReactTypefaceUtils;
import io.sentry.protocol.Device;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomStyleSpan.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0017H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/facebook/react/views/text/internal/span/CustomStyleSpan;", "Landroid/text/style/MetricAffectingSpan;", "Lcom/facebook/react/views/text/internal/span/ReactSpan;", "privateStyle", "", "privateWeight", "fontFeatureSettings", "", ViewProps.FONT_FAMILY, "assetManager", "Landroid/content/res/AssetManager;", "(IILjava/lang/String;Ljava/lang/String;Landroid/content/res/AssetManager;)V", "getFontFamily", "()Ljava/lang/String;", "getFontFeatureSettings", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "getStyle", "()I", "weight", "getWeight", "updateDrawState", "", "ds", "Landroid/text/TextPaint;", "updateMeasureState", "paint", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CustomStyleSpan extends MetricAffectingSpan implements ReactSpan {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AssetManager assetManager;
    private final String fontFamily;
    private final String fontFeatureSettings;
    private final int privateStyle;
    private final int privateWeight;

    public final String getFontFeatureSettings() {
        return this.fontFeatureSettings;
    }

    public final String getFontFamily() {
        return this.fontFamily;
    }

    public CustomStyleSpan(int i, int i2, String str, String str2, AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        this.privateStyle = i;
        this.privateWeight = i2;
        this.fontFeatureSettings = str;
        this.fontFamily = str2;
        this.assetManager = assetManager;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        Intrinsics.checkNotNullParameter(ds, "ds");
        INSTANCE.apply(ds, this.privateStyle, this.privateWeight, this.fontFeatureSettings, this.fontFamily, this.assetManager);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        INSTANCE.apply(paint, this.privateStyle, this.privateWeight, this.fontFeatureSettings, this.fontFamily, this.assetManager);
    }

    public final int getStyle() {
        int i = this.privateStyle;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    public final int getWeight() {
        int i = this.privateWeight;
        if (i == -1) {
            return 400;
        }
        return i;
    }

    /* compiled from: CustomStyleSpan.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u000f"}, d2 = {"Lcom/facebook/react/views/text/internal/span/CustomStyleSpan$Companion;", "", "()V", "apply", "", "paint", "Landroid/graphics/Paint;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "weight", "fontFeatureSettingsParam", "", Device.JsonKeys.FAMILY, "assetManager", "Landroid/content/res/AssetManager;", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void apply(Paint paint, int style, int weight, String fontFeatureSettingsParam, String family, AssetManager assetManager) {
            Typeface typefaceApplyStyles = ReactTypefaceUtils.applyStyles(paint.getTypeface(), style, weight, family, assetManager);
            Intrinsics.checkNotNullExpressionValue(typefaceApplyStyles, "applyStyles(...)");
            paint.setFontFeatureSettings(fontFeatureSettingsParam);
            paint.setTypeface(typefaceApplyStyles);
            paint.setSubpixelText(true);
        }
    }
}
