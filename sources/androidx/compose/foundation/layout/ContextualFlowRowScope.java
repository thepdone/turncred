package androidx.compose.foundation.layout;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* compiled from: ContextualFlowLayout.kt */
@LayoutScopeMarker
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0018\u0010\b\u001a\u00020\tX¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u00020\tX¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/layout/ContextualFlowRowScope;", "Landroidx/compose/foundation/layout/FlowRowScope;", "indexInLine", "", "getIndexInLine", "()I", "lineIndex", "getLineIndex", ViewProps.MAX_HEIGHT, "Landroidx/compose/ui/unit/Dp;", "getMaxHeight-D9Ej5fM", "()F", "maxWidthInLine", "getMaxWidthInLine-D9Ej5fM", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ContextualFlowRowScope extends FlowRowScope {
    int getIndexInLine();

    int getLineIndex();

    /* renamed from: getMaxHeight-D9Ej5fM, reason: not valid java name */
    float mo922getMaxHeightD9Ej5fM();

    /* renamed from: getMaxWidthInLine-D9Ej5fM, reason: not valid java name */
    float mo923getMaxWidthInLineD9Ej5fM();
}
