package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.VelocityKt;
import androidx.core.app.NotificationCompat;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

/* compiled from: Draggable.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B5\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0006\u0010\u001e\u001a\u00020\u001fJM\u0010 \u001a\u00020\u001f2=\u0010!\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001f0\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0'\u0012\u0006\u0012\u0004\u0018\u00010(0\"H¦@¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\u001dH\u0002J\b\u0010+\u001a\u00020\u001fH\u0016J\b\u0010,\u001a\u00020\u001fH\u0016J\u001a\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/H&ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u001a\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u000204H&ø\u0001\u0000¢\u0006\u0004\b5\u00101J*\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0016ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u000e\u0010?\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010@J\u0016\u0010A\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020CH\u0082@¢\u0006\u0002\u0010DJ\u0016\u0010E\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020FH\u0082@¢\u0006\u0002\u0010GJ\b\u0010H\u001a\u00020\u0007H&J\b\u0010I\u001a\u00020\u001fH\u0002JH\u0010J\u001a\u00020\u001f2\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010K\u001a\u00020\u0007R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\n@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006L"}, d2 = {"Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "canDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", ViewProps.ENABLED, "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "orientationLock", "Landroidx/compose/foundation/gestures/Orientation;", "(Lkotlin/jvm/functions/Function1;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/Orientation;)V", "_canDrag", "<set-?>", "getCanDrag", "()Lkotlin/jvm/functions/Function1;", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/DragEvent;", "dragInteraction", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "getEnabled", "()Z", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isListeningForEvents", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "disposeInteractionSource", "", "drag", "forEachDelta", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", "name", "dragDelta", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initializePointerInputNode", "onCancelPointerInput", "onDetach", "onDragStarted", "startedPosition", "Landroidx/compose/ui/geometry/Offset;", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped", "velocity", "Landroidx/compose/ui/unit/Velocity;", "onDragStopped-TH1AsA0", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "processDragCancel", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStart", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "(Landroidx/compose/foundation/gestures/DragEvent$DragStarted;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStop", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "(Landroidx/compose/foundation/gestures/DragEvent$DragStopped;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startDragImmediately", "startListeningForEvents", "update", "shouldResetPointerInputHandling", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class DragGestureNode extends DelegatingNode implements PointerInputModifierNode, CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    private final Function1<PointerInputChange, Boolean> _canDrag = new Function1<PointerInputChange, Boolean>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$_canDrag$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(PointerInputChange pointerInputChange) {
            return this.this$0.getCanDrag().invoke(pointerInputChange);
        }
    };
    private Function1<? super PointerInputChange, Boolean> canDrag;
    private Channel<DragEvent> channel;
    private DragInteraction.Start dragInteraction;
    private boolean enabled;
    private MutableInteractionSource interactionSource;
    private boolean isListeningForEvents;
    private Orientation orientationLock;
    private SuspendingPointerInputModifierNode pointerInputNode;

    /* compiled from: Draggable.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode", f = "Draggable.kt", i = {0}, l = {566}, m = "processDragCancel", n = {"this"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1, reason: invalid class name and case insensitive filesystem */
    static final class C02181 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02181(Continuation<? super C02181> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureNode.this.processDragCancel(this);
        }
    }

    /* compiled from: Draggable.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode", f = "Draggable.kt", i = {0, 0, 1, 1, 1}, l = {548, 551}, m = "processDragStart", n = {"this", NotificationCompat.CATEGORY_EVENT, "this", NotificationCompat.CATEGORY_EVENT, "interaction"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1, reason: invalid class name and case insensitive filesystem */
    static final class C02191 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C02191(Continuation<? super C02191> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureNode.this.processDragStart(null, this);
        }
    }

    /* compiled from: Draggable.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode", f = "Draggable.kt", i = {0, 0}, l = {558}, m = "processDragStop", n = {"this", NotificationCompat.CATEGORY_EVENT}, s = {"L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1, reason: invalid class name and case insensitive filesystem */
    static final class C02201 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02201(Continuation<? super C02201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureNode.this.processDragStop(null, this);
        }
    }

    public abstract Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation);

    /* renamed from: onDragStarted-k-4lQ0M */
    public abstract void mo711onDragStartedk4lQ0M(long startedPosition);

    /* renamed from: onDragStopped-TH1AsA0 */
    public abstract void mo712onDragStoppedTH1AsA0(long velocity);

    /* renamed from: startDragImmediately */
    public abstract boolean getStartDragImmediately();

    public DragGestureNode(Function1<? super PointerInputChange, Boolean> function1, boolean z, MutableInteractionSource mutableInteractionSource, Orientation orientation) {
        this.orientationLock = orientation;
        this.canDrag = function1;
        this.enabled = z;
        this.interactionSource = mutableInteractionSource;
    }

    protected final Function1<PointerInputChange, Boolean> getCanDrag() {
        return this.canDrag;
    }

    protected final boolean getEnabled() {
        return this.enabled;
    }

    protected final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startListeningForEvents() {
        this.isListeningForEvents = true;
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C02211(null), 3, null);
    }

    /* compiled from: Draggable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1", f = "Draggable.kt", i = {0, 0, 1, 1, 2, 2, 3, 4, 5}, l = {431, 433, 435, 442, 444, 447}, m = "invokeSuspend", n = {"$this$launch", NotificationCompat.CATEGORY_EVENT, "$this$launch", NotificationCompat.CATEGORY_EVENT, "$this$launch", NotificationCompat.CATEGORY_EVENT, "$this$launch", "$this$launch", "$this$launch"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$0"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1, reason: invalid class name and case insensitive filesystem */
    static final class C02211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        C02211(Continuation<? super C02211> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C02211 c02211 = DragGestureNode.this.new C02211(continuation);
            c02211.L$0 = obj;
            return c02211;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02211) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(7:34|35|(1:37)|14|57|38|(2:43|(2:45|(1:47)))(2:40|(1:42))) */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0104, code lost:
        
            r1 = r4;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00c8 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00cf A[Catch: CancellationException -> 0x0104, TryCatch #1 {CancellationException -> 0x0104, blocks: (B:38:0x00c9, B:40:0x00cf, B:43:0x00eb, B:45:0x00f1), top: B:57:0x00c9 }] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00eb A[Catch: CancellationException -> 0x0104, TryCatch #1 {CancellationException -> 0x0104, blocks: (B:38:0x00c9, B:40:0x00cf, B:43:0x00eb, B:45:0x00f1), top: B:57:0x00c9 }] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0117 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0118  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0090 -> B:19:0x005e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00e8 -> B:19:0x005e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00ef -> B:19:0x005e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0101 -> B:19:0x005e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0115 -> B:11:0x0027). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                Method dump skipped, instructions count: 302
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.C02211.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: Draggable.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u0003H\u008a@"}, d2 = {"<anonymous>", "", "processDelta", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", "name", "dragDelta"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1", f = "Draggable.kt", i = {0}, l = {438}, m = "invokeSuspend", n = {"processDelta"}, s = {"L$0"})
        /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00251 extends SuspendLambda implements Function2<Function1<? super DragEvent.DragDelta, ? extends Unit>, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<DragEvent> $event;
            /* synthetic */ Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ DragGestureNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00251(Ref.ObjectRef<DragEvent> objectRef, DragGestureNode dragGestureNode, Continuation<? super C00251> continuation) {
                super(2, continuation);
                this.$event = objectRef;
                this.this$0 = dragGestureNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00251 c00251 = new C00251(this.$event, this.this$0, continuation);
                c00251.L$0 = obj;
                return c00251;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Function1<? super DragEvent.DragDelta, ? extends Unit> function1, Continuation<? super Unit> continuation) {
                return invoke2((Function1<? super DragEvent.DragDelta, Unit>) function1, continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Function1<? super DragEvent.DragDelta, Unit> function1, Continuation<? super Unit> continuation) {
                return ((C00251) create(function1, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0051 -> B:25:0x0066). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0060 -> B:24:0x0063). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                /*
                    r5 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r5.label
                    r2 = 1
                    if (r1 == 0) goto L1f
                    if (r1 != r2) goto L17
                    java.lang.Object r1 = r5.L$1
                    kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
                    java.lang.Object r3 = r5.L$0
                    kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
                    kotlin.ResultKt.throwOnFailure(r6)
                    goto L63
                L17:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r0)
                    throw r6
                L1f:
                    kotlin.ResultKt.throwOnFailure(r6)
                    java.lang.Object r6 = r5.L$0
                    kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
                    r3 = r6
                L27:
                    kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r6 = r5.$event
                    T r6 = r6.element
                    boolean r6 = r6 instanceof androidx.compose.foundation.gestures.DragEvent.DragStopped
                    if (r6 != 0) goto L69
                    kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r6 = r5.$event
                    T r6 = r6.element
                    boolean r6 = r6 instanceof androidx.compose.foundation.gestures.DragEvent.DragCancelled
                    if (r6 != 0) goto L69
                    kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r6 = r5.$event
                    T r6 = r6.element
                    boolean r1 = r6 instanceof androidx.compose.foundation.gestures.DragEvent.DragDelta
                    r4 = 0
                    if (r1 == 0) goto L43
                    androidx.compose.foundation.gestures.DragEvent$DragDelta r6 = (androidx.compose.foundation.gestures.DragEvent.DragDelta) r6
                    goto L44
                L43:
                    r6 = r4
                L44:
                    if (r6 == 0) goto L49
                    r3.invoke(r6)
                L49:
                    kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r1 = r5.$event
                    androidx.compose.foundation.gestures.DragGestureNode r6 = r5.this$0
                    kotlinx.coroutines.channels.Channel r6 = androidx.compose.foundation.gestures.DragGestureNode.access$getChannel$p(r6)
                    if (r6 == 0) goto L66
                    r4 = r5
                    kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                    r5.L$0 = r3
                    r5.L$1 = r1
                    r5.label = r2
                    java.lang.Object r6 = r6.receive(r4)
                    if (r6 != r0) goto L63
                    return r0
                L63:
                    r4 = r6
                    androidx.compose.foundation.gestures.DragEvent r4 = (androidx.compose.foundation.gestures.DragEvent) r4
                L66:
                    r1.element = r4
                    goto L27
                L69:
                    kotlin.Unit r6 = kotlin.Unit.INSTANCE
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.C02211.C00251.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.isListeningForEvents = false;
        disposeInteractionSource();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY */
    public void mo530onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        if (this.enabled && this.pointerInputNode == null) {
            this.pointerInputNode = (SuspendingPointerInputModifierNode) delegate(initializePointerInputNode());
        }
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.mo530onPointerEventH0pRuoY(pointerEvent, pass, bounds);
        }
    }

    /* compiled from: Draggable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1", f = "Draggable.kt", i = {}, l = {524}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = DragGestureNode.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                final VelocityTracker velocityTracker = new VelocityTracker();
                final DragGestureNode dragGestureNode = DragGestureNode.this;
                Function3<PointerInputChange, PointerInputChange, Offset, Unit> function3 = new Function3<PointerInputChange, PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDragStart$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, Offset offset) {
                        m754invoke0AR0LA0(pointerInputChange, pointerInputChange2, offset.getPackedValue());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke-0AR0LA0, reason: not valid java name */
                    public final void m754invoke0AR0LA0(PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, long j) {
                        if (dragGestureNode.getCanDrag().invoke(pointerInputChange).booleanValue()) {
                            if (!dragGestureNode.isListeningForEvents) {
                                if (dragGestureNode.channel == null) {
                                    dragGestureNode.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
                                }
                                dragGestureNode.startListeningForEvents();
                            }
                            VelocityTrackerKt.addPointerInputChange(velocityTracker, pointerInputChange);
                            long jM2039minusMKHz9U = Offset.m2039minusMKHz9U(pointerInputChange2.getPosition(), j);
                            Channel channel = dragGestureNode.channel;
                            if (channel != null) {
                                ChannelResult.m7471boximpl(channel.mo7456trySendJP2dKIU(new DragEvent.DragStarted(jM2039minusMKHz9U, null)));
                            }
                        }
                    }
                };
                final DragGestureNode dragGestureNode2 = DragGestureNode.this;
                Function1<PointerInputChange, Unit> function1 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDragEnd$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange) {
                        invoke2(pointerInputChange);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PointerInputChange pointerInputChange) {
                        VelocityTrackerKt.addPointerInputChange(velocityTracker, pointerInputChange);
                        float maximumFlingVelocity = ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(dragGestureNode2, CompositionLocalsKt.getLocalViewConfiguration())).getMaximumFlingVelocity();
                        long jM3584calculateVelocityAH228Gc = velocityTracker.m3584calculateVelocityAH228Gc(VelocityKt.Velocity(maximumFlingVelocity, maximumFlingVelocity));
                        velocityTracker.resetTracking();
                        Channel channel = dragGestureNode2.channel;
                        if (channel != null) {
                            ChannelResult.m7471boximpl(channel.mo7456trySendJP2dKIU(new DragEvent.DragStopped(DraggableKt.m769toValidVelocityTH1AsA0(jM3584calculateVelocityAH228Gc), null)));
                        }
                    }
                };
                final DragGestureNode dragGestureNode3 = DragGestureNode.this;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDragCancel$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Channel channel = dragGestureNode3.channel;
                        if (channel != null) {
                            ChannelResult.m7471boximpl(channel.mo7456trySendJP2dKIU(DragEvent.DragCancelled.INSTANCE));
                        }
                    }
                };
                final DragGestureNode dragGestureNode4 = DragGestureNode.this;
                Function0<Boolean> function02 = new Function0<Boolean>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$shouldAwaitTouchSlop$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return Boolean.valueOf(!dragGestureNode4.getStartDragImmediately());
                    }
                };
                final DragGestureNode dragGestureNode5 = DragGestureNode.this;
                Function2<PointerInputChange, Offset, Unit> function2 = new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDrag$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                        m753invokeUv8p0NA(pointerInputChange, offset.getPackedValue());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
                    public final void m753invokeUv8p0NA(PointerInputChange pointerInputChange, long j) {
                        VelocityTrackerKt.addPointerInputChange(velocityTracker, pointerInputChange);
                        Channel channel = dragGestureNode5.channel;
                        if (channel != null) {
                            ChannelResult.m7471boximpl(channel.mo7456trySendJP2dKIU(new DragEvent.DragDelta(j, null)));
                        }
                    }
                };
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(new C00241(DragGestureNode.this, pointerInputScope, function3, function1, function0, function02, function2, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* compiled from: Draggable.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1", f = "Draggable.kt", i = {0}, l = {526}, m = "invokeSuspend", n = {"$this$coroutineScope"}, s = {"L$0"})
        /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $$this$SuspendingPointerInputModifierNode;
            final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
            final /* synthetic */ Function0<Unit> $onDragCancel;
            final /* synthetic */ Function1<PointerInputChange, Unit> $onDragEnd;
            final /* synthetic */ Function3<PointerInputChange, PointerInputChange, Offset, Unit> $onDragStart;
            final /* synthetic */ Function0<Boolean> $shouldAwaitTouchSlop;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ DragGestureNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C00241(DragGestureNode dragGestureNode, PointerInputScope pointerInputScope, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function3, Function1<? super PointerInputChange, Unit> function1, Function0<Unit> function0, Function0<Boolean> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super C00241> continuation) {
                super(2, continuation);
                this.this$0 = dragGestureNode;
                this.$$this$SuspendingPointerInputModifierNode = pointerInputScope;
                this.$onDragStart = function3;
                this.$onDragEnd = function1;
                this.$onDragCancel = function0;
                this.$shouldAwaitTouchSlop = function02;
                this.$onDrag = function2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00241 c00241 = new C00241(this.this$0, this.$$this$SuspendingPointerInputModifierNode, this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$shouldAwaitTouchSlop, this.$onDrag, continuation);
                c00241.L$0 = obj;
                return c00241;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00241) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r13) {
                /*
                    r12 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r12.label
                    r2 = 1
                    if (r1 == 0) goto L1d
                    if (r1 != r2) goto L15
                    java.lang.Object r0 = r12.L$0
                    kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
                    kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.util.concurrent.CancellationException -> L13
                    goto L5f
                L13:
                    r13 = move-exception
                    goto L48
                L15:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r0)
                    throw r13
                L1d:
                    kotlin.ResultKt.throwOnFailure(r13)
                    java.lang.Object r13 = r12.L$0
                    kotlinx.coroutines.CoroutineScope r13 = (kotlinx.coroutines.CoroutineScope) r13
                    androidx.compose.foundation.gestures.DragGestureNode r1 = r12.this$0     // Catch: java.util.concurrent.CancellationException -> L44
                    androidx.compose.foundation.gestures.Orientation r8 = androidx.compose.foundation.gestures.DragGestureNode.access$getOrientationLock$p(r1)     // Catch: java.util.concurrent.CancellationException -> L44
                    androidx.compose.ui.input.pointer.PointerInputScope r3 = r12.$$this$SuspendingPointerInputModifierNode     // Catch: java.util.concurrent.CancellationException -> L44
                    kotlin.jvm.functions.Function3<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r4 = r12.$onDragStart     // Catch: java.util.concurrent.CancellationException -> L44
                    kotlin.jvm.functions.Function1<androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r5 = r12.$onDragEnd     // Catch: java.util.concurrent.CancellationException -> L44
                    kotlin.jvm.functions.Function0<kotlin.Unit> r6 = r12.$onDragCancel     // Catch: java.util.concurrent.CancellationException -> L44
                    kotlin.jvm.functions.Function0<java.lang.Boolean> r7 = r12.$shouldAwaitTouchSlop     // Catch: java.util.concurrent.CancellationException -> L44
                    kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r9 = r12.$onDrag     // Catch: java.util.concurrent.CancellationException -> L44
                    r10 = r12
                    kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10     // Catch: java.util.concurrent.CancellationException -> L44
                    r12.L$0 = r13     // Catch: java.util.concurrent.CancellationException -> L44
                    r12.label = r2     // Catch: java.util.concurrent.CancellationException -> L44
                    java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.util.concurrent.CancellationException -> L44
                    if (r13 != r0) goto L5f
                    return r0
                L44:
                    r0 = move-exception
                    r11 = r0
                    r0 = r13
                    r13 = r11
                L48:
                    androidx.compose.foundation.gestures.DragGestureNode r1 = r12.this$0
                    kotlinx.coroutines.channels.Channel r1 = androidx.compose.foundation.gestures.DragGestureNode.access$getChannel$p(r1)
                    if (r1 == 0) goto L59
                    androidx.compose.foundation.gestures.DragEvent$DragCancelled r2 = androidx.compose.foundation.gestures.DragEvent.DragCancelled.INSTANCE
                    java.lang.Object r1 = r1.mo7456trySendJP2dKIU(r2)
                    kotlinx.coroutines.channels.ChannelResult.m7471boximpl(r1)
                L59:
                    boolean r0 = kotlinx.coroutines.CoroutineScopeKt.isActive(r0)
                    if (r0 == 0) goto L62
                L5f:
                    kotlin.Unit r13 = kotlin.Unit.INSTANCE
                    return r13
                L62:
                    throw r13
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.AnonymousClass1.C00241.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }

    private final SuspendingPointerInputModifierNode initializePointerInputNode() {
        return SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new AnonymousClass1(null));
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.onCancelPointerInput();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processDragStart(androidx.compose.foundation.gestures.DragEvent.DragStarted r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.DragGestureNode.C02191
            if (r0 == 0) goto L14
            r0 = r8
            androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1 r0 = (androidx.compose.foundation.gestures.DragGestureNode.C02191) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1 r0 = new androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r7 = r0.L$2
            androidx.compose.foundation.interaction.DragInteraction$Start r7 = (androidx.compose.foundation.interaction.DragInteraction.Start) r7
            java.lang.Object r1 = r0.L$1
            androidx.compose.foundation.gestures.DragEvent$DragStarted r1 = (androidx.compose.foundation.gestures.DragEvent.DragStarted) r1
            java.lang.Object r0 = r0.L$0
            androidx.compose.foundation.gestures.DragGestureNode r0 = (androidx.compose.foundation.gestures.DragGestureNode) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L8b
        L39:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L41:
            java.lang.Object r7 = r0.L$1
            androidx.compose.foundation.gestures.DragEvent$DragStarted r7 = (androidx.compose.foundation.gestures.DragEvent.DragStarted) r7
            java.lang.Object r2 = r0.L$0
            androidx.compose.foundation.gestures.DragGestureNode r2 = (androidx.compose.foundation.gestures.DragGestureNode) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6d
        L4d:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.compose.foundation.interaction.DragInteraction$Start r8 = r6.dragInteraction
            if (r8 == 0) goto L6c
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r6.interactionSource
            if (r2 == 0) goto L6c
            androidx.compose.foundation.interaction.DragInteraction$Cancel r5 = new androidx.compose.foundation.interaction.DragInteraction$Cancel
            r5.<init>(r8)
            androidx.compose.foundation.interaction.Interaction r5 = (androidx.compose.foundation.interaction.Interaction) r5
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r2.emit(r5, r0)
            if (r8 != r1) goto L6c
            return r1
        L6c:
            r2 = r6
        L6d:
            androidx.compose.foundation.interaction.DragInteraction$Start r8 = new androidx.compose.foundation.interaction.DragInteraction$Start
            r8.<init>()
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = r2.interactionSource
            if (r4 == 0) goto L8e
            r5 = r8
            androidx.compose.foundation.interaction.Interaction r5 = (androidx.compose.foundation.interaction.Interaction) r5
            r0.L$0 = r2
            r0.L$1 = r7
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r0 = r4.emit(r5, r0)
            if (r0 != r1) goto L88
            return r1
        L88:
            r1 = r7
            r7 = r8
            r0 = r2
        L8b:
            r8 = r7
            r2 = r0
            r7 = r1
        L8e:
            r2.dragInteraction = r8
            long r7 = r7.getStartPoint()
            r2.mo711onDragStartedk4lQ0M(r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.processDragStart(androidx.compose.foundation.gestures.DragEvent$DragStarted, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processDragStop(androidx.compose.foundation.gestures.DragEvent.DragStopped r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.compose.foundation.gestures.DragGestureNode.C02201
            if (r0 == 0) goto L14
            r0 = r7
            androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1 r0 = (androidx.compose.foundation.gestures.DragGestureNode.C02201) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1 r0 = new androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.L$1
            androidx.compose.foundation.gestures.DragEvent$DragStopped r6 = (androidx.compose.foundation.gestures.DragEvent.DragStopped) r6
            java.lang.Object r0 = r0.L$0
            androidx.compose.foundation.gestures.DragGestureNode r0 = (androidx.compose.foundation.gestures.DragGestureNode) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5a
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.compose.foundation.interaction.DragInteraction$Start r7 = r5.dragInteraction
            if (r7 == 0) goto L5e
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r5.interactionSource
            if (r2 == 0) goto L59
            androidx.compose.foundation.interaction.DragInteraction$Stop r4 = new androidx.compose.foundation.interaction.DragInteraction$Stop
            r4.<init>(r7)
            androidx.compose.foundation.interaction.Interaction r4 = (androidx.compose.foundation.interaction.Interaction) r4
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r2.emit(r4, r0)
            if (r7 != r1) goto L59
            return r1
        L59:
            r0 = r5
        L5a:
            r7 = 0
            r0.dragInteraction = r7
            goto L5f
        L5e:
            r0 = r5
        L5f:
            long r6 = r6.getVelocity()
            r0.mo712onDragStoppedTH1AsA0(r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.processDragStop(androidx.compose.foundation.gestures.DragEvent$DragStopped, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processDragCancel(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.compose.foundation.gestures.DragGestureNode.C02181
            if (r0 == 0) goto L14
            r0 = r6
            androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1 r0 = (androidx.compose.foundation.gestures.DragGestureNode.C02181) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1 r0 = new androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            androidx.compose.foundation.gestures.DragGestureNode r0 = (androidx.compose.foundation.gestures.DragGestureNode) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L54
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.compose.foundation.interaction.DragInteraction$Start r6 = r5.dragInteraction
            if (r6 == 0) goto L58
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r5.interactionSource
            if (r2 == 0) goto L53
            androidx.compose.foundation.interaction.DragInteraction$Cancel r4 = new androidx.compose.foundation.interaction.DragInteraction$Cancel
            r4.<init>(r6)
            androidx.compose.foundation.interaction.Interaction r4 = (androidx.compose.foundation.interaction.Interaction) r4
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r2.emit(r4, r0)
            if (r6 != r1) goto L53
            return r1
        L53:
            r0 = r5
        L54:
            r6 = 0
            r0.dragInteraction = r6
            goto L59
        L58:
            r0 = r5
        L59:
            androidx.compose.ui.unit.Velocity$Companion r6 = androidx.compose.ui.unit.Velocity.INSTANCE
            long r1 = r6.m4985getZero9UxMQ8M()
            r0.mo712onDragStoppedTH1AsA0(r1)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.processDragCancel(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void disposeInteractionSource() {
        DragInteraction.Start start = this.dragInteraction;
        if (start != null) {
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            if (mutableInteractionSource != null) {
                mutableInteractionSource.tryEmit(new DragInteraction.Cancel(start));
            }
            this.dragInteraction = null;
        }
    }

    public static /* synthetic */ void update$default(DragGestureNode dragGestureNode, Function1 function1, boolean z, MutableInteractionSource mutableInteractionSource, Orientation orientation, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
        }
        if ((i & 1) != 0) {
            function1 = dragGestureNode.canDrag;
        }
        if ((i & 2) != 0) {
            z = dragGestureNode.enabled;
        }
        boolean z3 = z;
        if ((i & 4) != 0) {
            mutableInteractionSource = dragGestureNode.interactionSource;
        }
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        if ((i & 8) != 0) {
            orientation = dragGestureNode.orientationLock;
        }
        Orientation orientation2 = orientation;
        if ((i & 16) != 0) {
            z2 = false;
        }
        dragGestureNode.update(function1, z3, mutableInteractionSource2, orientation2, z2);
    }

    public final void update(Function1<? super PointerInputChange, Boolean> canDrag, boolean enabled, MutableInteractionSource interactionSource, Orientation orientationLock, boolean shouldResetPointerInputHandling) {
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode;
        this.canDrag = canDrag;
        boolean z = true;
        if (this.enabled != enabled) {
            this.enabled = enabled;
            if (!enabled) {
                disposeInteractionSource();
                SuspendingPointerInputModifierNode suspendingPointerInputModifierNode2 = this.pointerInputNode;
                if (suspendingPointerInputModifierNode2 != null) {
                    undelegate(suspendingPointerInputModifierNode2);
                }
                this.pointerInputNode = null;
            }
            shouldResetPointerInputHandling = true;
        }
        if (!Intrinsics.areEqual(this.interactionSource, interactionSource)) {
            disposeInteractionSource();
            this.interactionSource = interactionSource;
        }
        if (this.orientationLock != orientationLock) {
            this.orientationLock = orientationLock;
        } else {
            z = shouldResetPointerInputHandling;
        }
        if (!z || (suspendingPointerInputModifierNode = this.pointerInputNode) == null) {
            return;
        }
        suspendingPointerInputModifierNode.resetPointerInputHandler();
    }
}
