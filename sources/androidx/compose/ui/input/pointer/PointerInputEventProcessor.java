package androidx.compose.ui.input.pointer;

import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;

/* compiled from: PointerInputEventProcessor.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J-\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "hitPathTracker", "Landroidx/compose/ui/input/pointer/HitPathTracker;", "hitResult", "Landroidx/compose/ui/node/HitTestResult;", "isProcessing", "", "pointerInputChangeEventProducer", "Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "clearPreviouslyHitModifierNodes", "", "process", "Landroidx/compose/ui/input/pointer/ProcessResult;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "isInBounds", "process-BIzXfog", "(Landroidx/compose/ui/input/pointer/PointerInputEvent;Landroidx/compose/ui/input/pointer/PositionCalculator;Z)I", "processCancel", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PointerInputEventProcessor {
    public static final int $stable = 8;
    private final HitPathTracker hitPathTracker;
    private boolean isProcessing;
    private final LayoutNode root;
    private final PointerInputChangeEventProducer pointerInputChangeEventProducer = new PointerInputChangeEventProducer();
    private final HitTestResult hitResult = new HitTestResult();

    public PointerInputEventProcessor(LayoutNode layoutNode) {
        this.root = layoutNode;
        this.hitPathTracker = new HitPathTracker(layoutNode.getCoordinates());
    }

    public final LayoutNode getRoot() {
        return this.root;
    }

    /* renamed from: process-BIzXfog$default, reason: not valid java name */
    public static /* synthetic */ int m3505processBIzXfog$default(PointerInputEventProcessor pointerInputEventProcessor, PointerInputEvent pointerInputEvent, PositionCalculator positionCalculator, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return pointerInputEventProcessor.m3506processBIzXfog(pointerInputEvent, positionCalculator, z);
    }

    /* renamed from: process-BIzXfog, reason: not valid java name */
    public final int m3506processBIzXfog(PointerInputEvent pointerEvent, PositionCalculator positionCalculator, boolean isInBounds) {
        boolean z;
        if (this.isProcessing) {
            return PointerInputEventProcessorKt.ProcessResult(false, false);
        }
        boolean z2 = true;
        try {
            this.isProcessing = true;
            InternalPointerEvent internalPointerEventProduce = this.pointerInputChangeEventProducer.produce(pointerEvent, positionCalculator);
            int size = internalPointerEventProduce.getChanges().size();
            for (int i = 0; i < size; i++) {
                PointerInputChange pointerInputChangeValueAt = internalPointerEventProduce.getChanges().valueAt(i);
                if (!pointerInputChangeValueAt.getPressed() && !pointerInputChangeValueAt.getPreviousPressed()) {
                }
                z = false;
                break;
            }
            z = true;
            int size2 = internalPointerEventProduce.getChanges().size();
            for (int i2 = 0; i2 < size2; i2++) {
                PointerInputChange pointerInputChangeValueAt2 = internalPointerEventProduce.getChanges().valueAt(i2);
                if (z || PointerEventKt.changedToDownIgnoreConsumed(pointerInputChangeValueAt2)) {
                    LayoutNode.m3761hitTestM_7yMNQ$ui_release$default(this.root, pointerInputChangeValueAt2.getPosition(), this.hitResult, PointerType.m3556equalsimpl0(pointerInputChangeValueAt2.getType(), PointerType.INSTANCE.m3563getTouchT8wyACA()), false, 8, null);
                    if (!this.hitResult.isEmpty()) {
                        this.hitPathTracker.m3412addHitPathQJqDSyo(pointerInputChangeValueAt2.getId(), this.hitResult, PointerEventKt.changedToDownIgnoreConsumed(pointerInputChangeValueAt2));
                        this.hitResult.clear();
                    }
                }
            }
            this.hitPathTracker.removeDetachedPointerInputNodes();
            boolean zDispatchChanges = this.hitPathTracker.dispatchChanges(internalPointerEventProduce, isInBounds);
            if (internalPointerEventProduce.getSuppressMovementConsumption()) {
                z2 = false;
            } else {
                int size3 = internalPointerEventProduce.getChanges().size();
                for (int i3 = 0; i3 < size3; i3++) {
                    PointerInputChange pointerInputChangeValueAt3 = internalPointerEventProduce.getChanges().valueAt(i3);
                    if (PointerEventKt.positionChangedIgnoreConsumed(pointerInputChangeValueAt3) && pointerInputChangeValueAt3.isConsumed()) {
                        break;
                    }
                }
                z2 = false;
            }
            return PointerInputEventProcessorKt.ProcessResult(zDispatchChanges, z2);
        } finally {
            this.isProcessing = false;
        }
    }

    public final void processCancel() {
        if (this.isProcessing) {
            return;
        }
        this.pointerInputChangeEventProducer.clear();
        this.hitPathTracker.processCancel();
    }

    public final void clearPreviouslyHitModifierNodes() {
        this.hitPathTracker.clearPreviouslyHitModifierNodeCache();
    }
}
