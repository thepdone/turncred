package androidx.compose.ui.text.platform.style;

import android.graphics.Shader;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.text.platform.AndroidTextPaint_androidKt;
import io.sentry.protocol.ViewHierarchyNode;
import io.sentry.rrweb.RRWebVideoEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: ShaderBrushSpan.android.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R1\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "Landroid/text/style/CharacterStyle;", "Landroid/text/style/UpdateAppearance;", "shaderBrush", "Landroidx/compose/ui/graphics/ShaderBrush;", ViewHierarchyNode.JsonKeys.ALPHA, "", "(Landroidx/compose/ui/graphics/ShaderBrush;F)V", "getAlpha", "()F", "getShaderBrush", "()Landroidx/compose/ui/graphics/ShaderBrush;", "shaderState", "Landroidx/compose/runtime/State;", "Landroid/graphics/Shader;", "<set-?>", "Landroidx/compose/ui/geometry/Size;", RRWebVideoEvent.JsonKeys.SIZE, "getSize-NH-jbRc", "()J", "setSize-uvyYCjk", "(J)V", "size$delegate", "Landroidx/compose/runtime/MutableState;", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ShaderBrushSpan extends CharacterStyle implements UpdateAppearance {
    public static final int $stable = 0;
    private final float alpha;
    private final ShaderBrush shaderBrush;

    /* renamed from: size$delegate, reason: from kotlin metadata */
    private final MutableState size = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m2092boximpl(Size.INSTANCE.m2112getUnspecifiedNHjbRc()), null, 2, null);
    private final State<Shader> shaderState = SnapshotStateKt.derivedStateOf(new Function0<Shader>() { // from class: androidx.compose.ui.text.platform.style.ShaderBrushSpan$shaderState$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Shader invoke() {
            if (this.this$0.m4508getSizeNHjbRc() == InlineClassHelperKt.UnspecifiedPackedFloats || Size.m2106isEmptyimpl(this.this$0.m4508getSizeNHjbRc())) {
                return null;
            }
            return this.this$0.getShaderBrush().mo2245createShaderuvyYCjk(this.this$0.m4508getSizeNHjbRc());
        }
    });

    public final ShaderBrush getShaderBrush() {
        return this.shaderBrush;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public ShaderBrushSpan(ShaderBrush shaderBrush, float f) {
        this.shaderBrush = shaderBrush;
        this.alpha = f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getSize-NH-jbRc, reason: not valid java name */
    public final long m4508getSizeNHjbRc() {
        return ((Size) this.size.getValue()).getPackedValue();
    }

    /* renamed from: setSize-uvyYCjk, reason: not valid java name */
    public final void m4509setSizeuvyYCjk(long j) {
        this.size.setValue(Size.m2092boximpl(j));
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        AndroidTextPaint_androidKt.setAlpha(textPaint, this.alpha);
        textPaint.setShader(this.shaderState.getValue());
    }
}
