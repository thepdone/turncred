package androidx.compose.ui.platform;

import android.view.DragEvent;
import android.view.View;
import androidx.collection.ArraySet;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropManager;
import androidx.compose.ui.draganddrop.DragAndDropModifierNode;
import androidx.compose.ui.draganddrop.DragAndDropNode;
import androidx.compose.ui.draganddrop.DragAndDropTarget;
import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.core.app.NotificationCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: AndroidComposeView.android.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002Bc\u0012\\\u0010\u0003\u001aX\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012$\u0012\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\u0002\u0010\u0011J;\u0010\u001b\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0014H\u0016J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0014H\u0016R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000Rd\u0010\u0003\u001aX\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012$\u0012\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"Landroidx/compose/ui/platform/DragAndDropModifierOnDragListener;", "Landroid/view/View$OnDragListener;", "Landroidx/compose/ui/draganddrop/DragAndDropManager;", "startDrag", "Lkotlin/Function3;", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "Lkotlin/ParameterName;", "name", "transferData", "Landroidx/compose/ui/geometry/Size;", "decorationSize", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "drawDragDecoration", "", "(Lkotlin/jvm/functions/Function3;)V", "interestedNodes", "Landroidx/collection/ArraySet;", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "rootDragAndDropNode", "Landroidx/compose/ui/draganddrop/DragAndDropNode;", "drag", "drag-12SF9DM", "(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)Z", "isInterestedNode", "node", "onDrag", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", NotificationCompat.CATEGORY_EVENT, "Landroid/view/DragEvent;", "registerNodeInterest", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class DragAndDropModifierOnDragListener implements View.OnDragListener, DragAndDropManager {
    private final Function3<DragAndDropTransferData, Size, Function1<? super DrawScope, Unit>, Boolean> startDrag;
    private final DragAndDropNode rootDragAndDropNode = new DragAndDropNode(new Function1<DragAndDropEvent, DragAndDropTarget>() { // from class: androidx.compose.ui.platform.DragAndDropModifierOnDragListener$rootDragAndDropNode$1
        @Override // kotlin.jvm.functions.Function1
        public final DragAndDropTarget invoke(DragAndDropEvent dragAndDropEvent) {
            return null;
        }
    });
    private final ArraySet<DragAndDropModifierNode> interestedNodes = new ArraySet<>(0, 1, null);
    private final Modifier modifier = new ModifierNodeElement<DragAndDropNode>() { // from class: androidx.compose.ui.platform.DragAndDropModifierOnDragListener$modifier$1
        @Override // androidx.compose.ui.node.ModifierNodeElement
        public boolean equals(Object other) {
            return other == this;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void update(DragAndDropNode node) {
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        /* renamed from: create */
        public DragAndDropNode getNode() {
            return this.this$0.rootDragAndDropNode;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo inspectorInfo) {
            inspectorInfo.setName("RootDragAndDropNode");
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public int hashCode() {
            return this.this$0.rootDragAndDropNode.hashCode();
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    public DragAndDropModifierOnDragListener(Function3<? super DragAndDropTransferData, ? super Size, ? super Function1<? super DrawScope, Unit>, Boolean> function3) {
        this.startDrag = function3;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropManager
    public Modifier getModifier() {
        return this.modifier;
    }

    @Override // android.view.View.OnDragListener
    public boolean onDrag(View view, DragEvent event) {
        DragAndDropEvent dragAndDropEvent = new DragAndDropEvent(event);
        switch (event.getAction()) {
            case 1:
                boolean zAcceptDragAndDropTransfer = this.rootDragAndDropNode.acceptDragAndDropTransfer(dragAndDropEvent);
                Iterator<DragAndDropModifierNode> it = this.interestedNodes.iterator();
                while (it.hasNext()) {
                    it.next().onStarted(dragAndDropEvent);
                }
                break;
            case 2:
                this.rootDragAndDropNode.onMoved(dragAndDropEvent);
                break;
            case 4:
                this.rootDragAndDropNode.onEnded(dragAndDropEvent);
                break;
            case 5:
                this.rootDragAndDropNode.onEntered(dragAndDropEvent);
                break;
            case 6:
                this.rootDragAndDropNode.onExited(dragAndDropEvent);
                break;
        }
        return false;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropManager
    /* renamed from: drag-12SF9DM */
    public boolean mo1906drag12SF9DM(DragAndDropTransferData transferData, long decorationSize, Function1<? super DrawScope, Unit> drawDragDecoration) {
        return this.startDrag.invoke(transferData, Size.m2092boximpl(decorationSize), drawDragDecoration).booleanValue();
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropManager
    public void registerNodeInterest(DragAndDropModifierNode node) {
        this.interestedNodes.add(node);
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropManager
    public boolean isInterestedNode(DragAndDropModifierNode node) {
        return this.interestedNodes.contains(node);
    }
}
