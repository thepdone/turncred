package androidx.compose.ui.node;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.layout.MeasurePolicy;
import kotlin.Metadata;

/* compiled from: IntrinsicsPolicy.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012J\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR+\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/node/IntrinsicsPolicy;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "policy", "Landroidx/compose/ui/layout/MeasurePolicy;", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/layout/MeasurePolicy;)V", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "<set-?>", "measurePolicyState", "getMeasurePolicyState", "()Landroidx/compose/ui/layout/MeasurePolicy;", "setMeasurePolicyState", "(Landroidx/compose/ui/layout/MeasurePolicy;)V", "measurePolicyState$delegate", "Landroidx/compose/runtime/MutableState;", "maxIntrinsicHeight", "", "width", "maxIntrinsicWidth", "height", "maxLookaheadIntrinsicHeight", "maxLookaheadIntrinsicWidth", "minIntrinsicHeight", "minIntrinsicWidth", "minLookaheadIntrinsicHeight", "minLookaheadIntrinsicWidth", "updateFrom", "", "measurePolicy", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IntrinsicsPolicy {
    public static final int $stable = 8;
    private final LayoutNode layoutNode;

    /* renamed from: measurePolicyState$delegate, reason: from kotlin metadata */
    private final MutableState measurePolicyState;

    public IntrinsicsPolicy(LayoutNode layoutNode, MeasurePolicy measurePolicy) {
        this.layoutNode = layoutNode;
        this.measurePolicyState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(measurePolicy, null, 2, null);
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    private final MeasurePolicy getMeasurePolicyState() {
        return (MeasurePolicy) this.measurePolicyState.getValue();
    }

    private final void setMeasurePolicyState(MeasurePolicy measurePolicy) {
        this.measurePolicyState.setValue(measurePolicy);
    }

    public final void updateFrom(MeasurePolicy measurePolicy) {
        setMeasurePolicyState(measurePolicy);
    }

    public final int minIntrinsicWidth(int height) {
        return getMeasurePolicyState().minIntrinsicWidth(this.layoutNode.getOuterCoordinator$ui_release(), this.layoutNode.getChildMeasurables$ui_release(), height);
    }

    public final int minIntrinsicHeight(int width) {
        return getMeasurePolicyState().minIntrinsicHeight(this.layoutNode.getOuterCoordinator$ui_release(), this.layoutNode.getChildMeasurables$ui_release(), width);
    }

    public final int maxIntrinsicWidth(int height) {
        return getMeasurePolicyState().maxIntrinsicWidth(this.layoutNode.getOuterCoordinator$ui_release(), this.layoutNode.getChildMeasurables$ui_release(), height);
    }

    public final int maxIntrinsicHeight(int width) {
        return getMeasurePolicyState().maxIntrinsicHeight(this.layoutNode.getOuterCoordinator$ui_release(), this.layoutNode.getChildMeasurables$ui_release(), width);
    }

    public final int minLookaheadIntrinsicWidth(int height) {
        return getMeasurePolicyState().minIntrinsicWidth(this.layoutNode.getOuterCoordinator$ui_release(), this.layoutNode.getChildLookaheadMeasurables$ui_release(), height);
    }

    public final int minLookaheadIntrinsicHeight(int width) {
        return getMeasurePolicyState().minIntrinsicHeight(this.layoutNode.getOuterCoordinator$ui_release(), this.layoutNode.getChildLookaheadMeasurables$ui_release(), width);
    }

    public final int maxLookaheadIntrinsicWidth(int height) {
        return getMeasurePolicyState().maxIntrinsicWidth(this.layoutNode.getOuterCoordinator$ui_release(), this.layoutNode.getChildLookaheadMeasurables$ui_release(), height);
    }

    public final int maxLookaheadIntrinsicHeight(int width) {
        return getMeasurePolicyState().maxIntrinsicHeight(this.layoutNode.getOuterCoordinator$ui_release(), this.layoutNode.getChildLookaheadMeasurables$ui_release(), width);
    }
}
