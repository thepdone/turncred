package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.view.Surface;
import kotlin.Metadata;

/* compiled from: LayerManager.android.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/graphics/layer/LockHardwareCanvasHelper;", "", "()V", "lockHardwareCanvas", "Landroid/graphics/Canvas;", "surface", "Landroid/view/Surface;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class LockHardwareCanvasHelper {
    public static final LockHardwareCanvasHelper INSTANCE = new LockHardwareCanvasHelper();

    private LockHardwareCanvasHelper() {
    }

    public final Canvas lockHardwareCanvas(Surface surface) {
        return surface.lockHardwareCanvas();
    }
}
