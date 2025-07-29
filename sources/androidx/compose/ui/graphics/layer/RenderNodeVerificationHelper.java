package androidx.compose.ui.graphics.layer;

import android.graphics.RenderNode;
import androidx.compose.ui.graphics.RenderEffect;
import com.facebook.react.uimanager.events.TouchesHelper;
import kotlin.Metadata;

/* compiled from: GraphicsLayerV29.android.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/graphics/layer/RenderNodeVerificationHelper;", "", "()V", "setRenderEffect", "", "renderNode", "Landroid/graphics/RenderNode;", TouchesHelper.TARGET_KEY, "Landroidx/compose/ui/graphics/RenderEffect;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RenderNodeVerificationHelper {
    public static final RenderNodeVerificationHelper INSTANCE = new RenderNodeVerificationHelper();

    private RenderNodeVerificationHelper() {
    }

    public final void setRenderEffect(RenderNode renderNode, RenderEffect target) {
        renderNode.setRenderEffect(target != null ? target.asAndroidRenderEffect() : null);
    }
}
