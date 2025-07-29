package androidx.compose.ui.graphics.layer;

import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.lang.reflect.Method;
import kotlin.Metadata;

/* compiled from: GraphicsViewLayer.android.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/compose/ui/graphics/layer/OutlineUtils;", "", "()V", "hasRetrievedMethod", "", "rebuildOutlineMethod", "Ljava/lang/reflect/Method;", "rebuildOutline", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class OutlineUtils {
    public static final OutlineUtils INSTANCE = new OutlineUtils();
    private static boolean hasRetrievedMethod;
    private static Method rebuildOutlineMethod;

    private OutlineUtils() {
    }

    public final boolean rebuildOutline(View view) {
        view.invalidateOutline();
        return true;
    }
}
