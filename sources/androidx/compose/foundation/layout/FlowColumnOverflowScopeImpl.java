package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measured;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: FlowLayout.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0097\u0001J!\u0010\u0010\u001a\u00020\r*\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u0012H\u0097\u0001J\u0015\u0010\u0010\u001a\u00020\r*\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0097\u0001J\u0017\u0010\u0016\u001a\u00020\r*\u00020\r2\b\b\u0003\u0010\u0017\u001a\u00020\u0018H\u0097\u0001J\u001f\u0010\u0019\u001a\u00020\r*\u00020\r2\b\b\u0001\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0097\u0001R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/layout/FlowColumnOverflowScopeImpl;", "Landroidx/compose/foundation/layout/FlowColumnScope;", "Landroidx/compose/foundation/layout/FlowColumnOverflowScope;", "state", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "(Landroidx/compose/foundation/layout/FlowLayoutOverflowState;)V", "shownItemCount", "", "getShownItemCount", "()I", "totalItemCount", "getTotalItemCount", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "alignBy", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "alignmentLine", "Landroidx/compose/ui/layout/VerticalAlignmentLine;", "fillMaxColumnWidth", "fraction", "", "weight", "fill", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FlowColumnOverflowScopeImpl implements FlowColumnScope, FlowColumnOverflowScope {
    public static final int $stable = 0;
    private final /* synthetic */ FlowColumnScopeInstance $$delegate_0 = FlowColumnScopeInstance.INSTANCE;
    private final FlowLayoutOverflowState state;

    @Override // androidx.compose.foundation.layout.ColumnScope
    public Modifier align(Modifier modifier, Alignment.Horizontal horizontal) {
        return this.$$delegate_0.align(modifier, horizontal);
    }

    @Override // androidx.compose.foundation.layout.ColumnScope
    public Modifier alignBy(Modifier modifier, VerticalAlignmentLine verticalAlignmentLine) {
        return this.$$delegate_0.alignBy(modifier, verticalAlignmentLine);
    }

    @Override // androidx.compose.foundation.layout.ColumnScope
    public Modifier alignBy(Modifier modifier, Function1<? super Measured, Integer> function1) {
        return this.$$delegate_0.alignBy(modifier, function1);
    }

    @Override // androidx.compose.foundation.layout.FlowColumnScope
    public Modifier fillMaxColumnWidth(Modifier modifier, float f) {
        return this.$$delegate_0.fillMaxColumnWidth(modifier, f);
    }

    @Override // androidx.compose.foundation.layout.ColumnScope
    public Modifier weight(Modifier modifier, float f, boolean z) {
        return this.$$delegate_0.weight(modifier, f, z);
    }

    public FlowColumnOverflowScopeImpl(FlowLayoutOverflowState flowLayoutOverflowState) {
        this.state = flowLayoutOverflowState;
    }

    @Override // androidx.compose.foundation.layout.FlowColumnOverflowScope
    public int getTotalItemCount() {
        return this.state.getItemCount();
    }

    @Override // androidx.compose.foundation.layout.FlowColumnOverflowScope
    public int getShownItemCount() {
        return this.state.getNoOfItemsShown$foundation_layout_release();
    }
}
