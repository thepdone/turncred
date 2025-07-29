package androidx.compose.ui.text.font;

import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FontSynthesis.android.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"synthesizeTypeface", "", "Landroidx/compose/ui/text/font/FontSynthesis;", "typeface", "font", "Landroidx/compose/ui/text/font/Font;", "requestedWeight", "Landroidx/compose/ui/text/font/FontWeight;", "requestedStyle", "Landroidx/compose/ui/text/font/FontStyle;", "synthesizeTypeface-FxwP2eA", "(ILjava/lang/Object;Landroidx/compose/ui/text/font/Font;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/lang/Object;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FontSynthesis_androidKt {
    /* renamed from: synthesizeTypeface-FxwP2eA, reason: not valid java name */
    public static final Object m4353synthesizeTypefaceFxwP2eA(int i, Object obj, Font font, FontWeight fontWeight, int i2) {
        int weight;
        boolean zM4332equalsimpl0;
        if (!(obj instanceof android.graphics.Typeface)) {
            return obj;
        }
        boolean z = FontSynthesis.m4346isWeightOnimpl$ui_text_release(i) && !Intrinsics.areEqual(font.getWeight(), fontWeight) && fontWeight.compareTo(AndroidFontUtils_androidKt.getAndroidBold(FontWeight.INSTANCE)) >= 0 && font.getWeight().compareTo(AndroidFontUtils_androidKt.getAndroidBold(FontWeight.INSTANCE)) < 0;
        boolean z2 = FontSynthesis.m4345isStyleOnimpl$ui_text_release(i) && !FontStyle.m4332equalsimpl0(i2, font.getStyle());
        if (!z2 && !z) {
            return obj;
        }
        if (Build.VERSION.SDK_INT < 28) {
            return android.graphics.Typeface.create((android.graphics.Typeface) obj, AndroidFontUtils_androidKt.getAndroidTypefaceStyle(z, z2 && FontStyle.m4332equalsimpl0(i2, FontStyle.INSTANCE.m4338getItalic_LCdwA())));
        }
        if (z) {
            weight = fontWeight.getWeight();
        } else {
            weight = font.getWeight().getWeight();
        }
        if (z2) {
            zM4332equalsimpl0 = FontStyle.m4332equalsimpl0(i2, FontStyle.INSTANCE.m4338getItalic_LCdwA());
        } else {
            zM4332equalsimpl0 = FontStyle.m4332equalsimpl0(font.getStyle(), FontStyle.INSTANCE.m4338getItalic_LCdwA());
        }
        return TypefaceHelperMethodsApi28.INSTANCE.create((android.graphics.Typeface) obj, weight, zM4332equalsimpl0);
    }
}
