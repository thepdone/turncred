package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import io.sentry.protocol.Device;
import io.sentry.rrweb.RRWebInteractionEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;

/* compiled from: DragGestureDetector.kt */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a5\u0010\r\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u000fH\u0082Hø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a!\u0010\u0013\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\f\u001aa\u0010\u0015\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u001726\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001aY\u0010!\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n26\u0010\"\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H\u0086@ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a!\u0010%\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b&\u0010\f\u001aM\u0010'\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010(\u001a\u0004\u0018\u00010)2\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001e0\u0019H\u0082Hø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001aY\u0010-\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n26\u0010\"\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110*¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H\u0086@ø\u0001\u0000¢\u0006\u0004\b.\u0010$\u001a!\u0010/\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b0\u0010\f\u001aa\u00101\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u001726\u0010\"\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H\u0080@ø\u0001\u0000¢\u0006\u0004\b2\u0010 \u001aY\u00103\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n26\u0010\"\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H\u0086@ø\u0001\u0000¢\u0006\u0004\b4\u0010$\u001a\u0080\u0001\u00105\u001a\u00020\u001e*\u0002062\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001e0\u000f2\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e092\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001e0926\u0010;\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110*¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e0\u0019H\u0086@¢\u0006\u0002\u0010=\u001aà\u0001\u00105\u001a\u00020\u001e*\u0002062K\u00107\u001aG\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(?\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110*¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\u001e0>2!\u00108\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001e0\u000f2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001e092\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u0010092\b\u0010C\u001a\u0004\u0018\u00010)26\u0010;\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110*¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e0\u0019H\u0080@¢\u0006\u0002\u0010D\u001a\u0080\u0001\u0010E\u001a\u00020\u001e*\u0002062\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001e0\u000f2\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e092\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001e0926\u0010;\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110*¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e0\u0019H\u0086@¢\u0006\u0002\u0010=\u001a\u0080\u0001\u0010F\u001a\u00020\u001e*\u0002062\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001e0\u000f2\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e092\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001e0926\u0010G\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e0\u0019H\u0086@¢\u0006\u0002\u0010=\u001a\u0080\u0001\u0010H\u001a\u00020\u001e*\u0002062\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001e0\u000f2\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e092\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001e0926\u0010I\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u001e0\u0019H\u0086@¢\u0006\u0002\u0010=\u001a3\u0010J\u001a\u00020\u0010*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u000fH\u0086@ø\u0001\u0000¢\u0006\u0004\bK\u0010\u0012\u001aS\u0010J\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u000f2\b\u0010(\u001a\u0004\u0018\u00010)2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u000fH\u0080Hø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a3\u0010O\u001a\u00020\u0010*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u000fH\u0086@ø\u0001\u0000¢\u0006\u0004\bP\u0010\u0012\u001a\u001e\u0010Q\u001a\u00020\u0010*\u00020R2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a\u001e\u0010U\u001a\u00020\u0005*\u00020V2\u0006\u0010\u0016\u001a\u00020\u0017H\u0000ø\u0001\u0000¢\u0006\u0004\bW\u0010X\u001a3\u0010Y\u001a\u00020\u0010*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u000fH\u0086@ø\u0001\u0000¢\u0006\u0004\bZ\u0010\u0012\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006["}, d2 = {"defaultTouchSlop", "Landroidx/compose/ui/unit/Dp;", "F", "mouseSlop", "mouseToTouchSlopRatio", "", "awaitDragOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "awaitDragOrCancellation-rnUCldI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrUp", "hasDragged", "Lkotlin/Function1;", "", "awaitDragOrUp-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalDragOrCancellation", "awaitHorizontalDragOrCancellation-rnUCldI", "awaitHorizontalPointerSlopOrCancellation", RRWebInteractionEvent.JsonKeys.POINTER_TYPE, "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalTouchSlopOrCancellation", "onTouchSlopReached", "awaitHorizontalTouchSlopOrCancellation-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLongPressOrCancellation", "awaitLongPressOrCancellation-rnUCldI", "awaitPointerSlopOrCancellation", Device.JsonKeys.ORIENTATION, "Landroidx/compose/foundation/gestures/Orientation;", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-pn7EDYM", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILandroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitTouchSlopOrCancellation", "awaitTouchSlopOrCancellation-jO51t88", "awaitVerticalDragOrCancellation", "awaitVerticalDragOrCancellation-rnUCldI", "awaitVerticalPointerSlopOrCancellation", "awaitVerticalPointerSlopOrCancellation-gDDlDlE", "awaitVerticalTouchSlopOrCancellation", "awaitVerticalTouchSlopOrCancellation-jO51t88", "detectDragGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDragStart", "onDragEnd", "Lkotlin/Function0;", "onDragCancel", "onDrag", "dragAmount", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function3;", "down", "slopTriggerChange", "overSlopOffset", "shouldAwaitTouchSlop", "orientationLock", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGesturesAfterLongPress", "detectHorizontalDragGestures", "onHorizontalDrag", "detectVerticalDragGestures", "onVerticalDrag", "drag", "drag-jO51t88", "motionConsumed", "drag-VnAYq1g", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "horizontalDrag", "horizontalDrag-jO51t88", "isPointerUp", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "verticalDrag", "verticalDrag-jO51t88", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DragGestureDetectorKt {
    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00eb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x015a -> B:61:0x0160). Please report as a decompilation issue!!! */
    /* renamed from: awaitTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m737awaitTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r18, long r19, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit> r21, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r22) {
        /*
            Method dump skipped, instructions count: 365
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m737awaitTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0049 -> B:18:0x004c). Please report as a decompilation issue!!! */
    /* renamed from: drag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m743dragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r4, long r5, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            if (r0 == 0) goto L14
            r0 = r8
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.L$1
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            kotlin.ResultKt.throwOnFailure(r8)
            r7 = r4
            r4 = r5
            goto L4c
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            kotlin.ResultKt.throwOnFailure(r8)
        L3f:
            r0.L$0 = r4
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r8 = m730awaitDragOrCancellationrnUCldI(r4, r5, r0)
            if (r8 != r1) goto L4c
            return r1
        L4c:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L56
            r4 = 0
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r4
        L56:
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r8)
            if (r5 == 0) goto L61
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r4
        L61:
            r7.invoke(r8)
            long r5 = r8.getId()
            goto L3f
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m743dragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00cb, code lost:
    
        if (androidx.compose.ui.input.pointer.PointerEventKt.positionChangedIgnoreConsumed(r11) != false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0092 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0068 -> B:22:0x006d). Please report as a decompilation issue!!! */
    /* renamed from: awaitDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m730awaitDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m730awaitDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object detectDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures.2
                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m748invokek4lQ0M(long j) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                    m748invokek4lQ0M(offset.getPackedValue());
                    return Unit.INSTANCE;
                }
            };
        }
        Function1 function12 = function1;
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures.3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function0;
        if ((i & 4) != 0) {
            function02 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures.4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        return detectDragGestures(pointerInputScope, function12, function03, function02, function2, continuation);
    }

    public static final Object detectDragGestures(PointerInputScope pointerInputScope, final Function1<? super Offset, Unit> function1, final Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object objDetectDragGestures = detectDragGestures(pointerInputScope, new Function3<PointerInputChange, PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, Offset offset) {
                m749invoke0AR0LA0(pointerInputChange, pointerInputChange2, offset.getPackedValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-0AR0LA0, reason: not valid java name */
            public final void m749invoke0AR0LA0(PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, long j) {
                function1.invoke(Offset.m2024boximpl(pointerInputChange2.getPosition()));
            }
        }, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures.6
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
                function0.invoke();
            }
        }, function02, new Function0<Boolean>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return true;
            }
        }, null, function2, continuation);
        return objDetectDragGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectDragGestures : Unit.INSTANCE;
    }

    public static final Object detectDragGestures(PointerInputScope pointerInputScope, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function3, Function1<? super PointerInputChange, Unit> function1, Function0<Unit> function0, Function0<Boolean> function02, Orientation orientation, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass9(function02, new Ref.LongRef(), orientation, function3, function2, function0, function1, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    /* compiled from: DragGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$9", f = "DragGestureDetector.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4}, l = {247, 253, 972, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, InputDeviceCompat.SOURCE_GAMEPAD}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "initialDown", "awaitTouchSlop", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv", "pointer$iv", "touchSlopDetector$iv", "touchSlop$iv", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv", "pointer$iv", "touchSlopDetector$iv", "dragEvent$iv", "touchSlop$iv", "$this$drag_u2dVnAYq1g$iv", "orientation$iv", "$this$awaitDragOrUp_u2djO51t88$iv$iv", "pointer$iv$iv"}, s = {"L$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "L$4", "L$5", "F$0", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "F$0", "L$0", "L$2", "L$3", "L$4"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$9, reason: invalid class name */
    static final class AnonymousClass9 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function1<PointerInputChange, Unit> $onDragEnd;
        final /* synthetic */ Function3<PointerInputChange, PointerInputChange, Offset, Unit> $onDragStart;
        final /* synthetic */ Orientation $orientationLock;
        final /* synthetic */ Ref.LongRef $overSlop;
        final /* synthetic */ Function0<Boolean> $shouldAwaitTouchSlop;
        float F$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass9(Function0<Boolean> function0, Ref.LongRef longRef, Orientation orientation, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function3, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Function0<Unit> function02, Function1<? super PointerInputChange, Unit> function1, Continuation<? super AnonymousClass9> continuation) {
            super(2, continuation);
            this.$shouldAwaitTouchSlop = function0;
            this.$overSlop = longRef;
            this.$orientationLock = orientation;
            this.$onDragStart = function3;
            this.$onDrag = function2;
            this.$onDragCancel = function02;
            this.$onDragEnd = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass9 anonymousClass9 = new AnonymousClass9(this.$shouldAwaitTouchSlop, this.$overSlop, this.$orientationLock, this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, continuation);
            anonymousClass9.L$0 = obj;
            return anonymousClass9;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass9) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:124:0x030d, code lost:
        
            if (((r5 != null ? r5 == androidx.compose.foundation.gestures.Orientation.Vertical ? androidx.compose.ui.geometry.Offset.m2036getYimpl(r7) : androidx.compose.ui.geometry.Offset.m2035getXimpl(r7) : androidx.compose.ui.geometry.Offset.m2033getDistanceimpl(r7)) == 0.0f) == false) goto L125;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0101, code lost:
        
            if (r2 == false) goto L82;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x025d, code lost:
        
            if (androidx.compose.foundation.gestures.DragGestureDetectorKt.m745isPointerUpDmW0f2w(r11.getCurrentEvent(), r2) != false) goto L85;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Path cross not found for [B:102:0x02c4, B:113:0x02ed], limit reached: 139 */
        /* JADX WARN: Removed duplicated region for block: B:100:0x02be  */
        /* JADX WARN: Removed duplicated region for block: B:132:0x0321  */
        /* JADX WARN: Removed duplicated region for block: B:136:0x0330  */
        /* JADX WARN: Removed duplicated region for block: B:141:0x02b5 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:145:0x017a A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0119  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x011d  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x014d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x015b  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0189  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0196  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x01bf  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0213  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0218  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0227  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0233  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x025f  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0289 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:92:0x0297  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x02bc  */
        /* JADX WARN: Type inference failed for: r9v0 */
        /* JADX WARN: Type inference failed for: r9v1 */
        /* JADX WARN: Type inference failed for: r9v2 */
        /* JADX WARN: Type inference failed for: r9v5, types: [androidx.compose.ui.input.pointer.PointerEventPass, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v6 */
        /* JADX WARN: Type inference failed for: r9v7 */
        /* JADX WARN: Type inference failed for: r9v8 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0119 -> B:76:0x0216). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0184 -> B:75:0x0215). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x01d4 -> B:76:0x0216). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0207 -> B:72:0x020d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x0287 -> B:90:0x028a). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                Method dump skipped, instructions count: 846
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.AnonymousClass9.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static /* synthetic */ Object detectDragGesturesAfterLongPress$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGesturesAfterLongPress.2
                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m750invokek4lQ0M(long j) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                    m750invokek4lQ0M(offset.getPackedValue());
                    return Unit.INSTANCE;
                }
            };
        }
        Function1 function12 = function1;
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGesturesAfterLongPress.3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function0;
        if ((i & 4) != 0) {
            function02 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGesturesAfterLongPress.4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        return detectDragGesturesAfterLongPress(pointerInputScope, function12, function03, function02, function2, continuation);
    }

    /* compiled from: DragGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5", f = "DragGestureDetector.kt", i = {0, 1, 2}, l = {323, 324, 329}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "$this$awaitEachGesture"}, s = {"L$0", "L$0", "L$0"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5, reason: invalid class name and case insensitive filesystem */
    static final class C02095 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function0<Unit> $onDragEnd;
        final /* synthetic */ Function1<Offset, Unit> $onDragStart;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C02095(Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super C02095> continuation) {
            super(2, continuation);
            this.$onDragStart = function1;
            this.$onDragEnd = function0;
            this.$onDragCancel = function02;
            this.$onDrag = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C02095 c02095 = new C02095(this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$onDrag, continuation);
            c02095.L$0 = obj;
            return c02095;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C02095) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0065 A[Catch: CancellationException -> 0x00c5, TryCatch #0 {CancellationException -> 0x00c5, blocks: (B:8:0x0015, B:31:0x008e, B:33:0x0096, B:35:0x00a5, B:37:0x00b1, B:38:0x00b4, B:39:0x00b7, B:40:0x00bd, B:13:0x0026, B:25:0x0061, B:27:0x0065, B:16:0x002e, B:22:0x004d, B:19:0x003a), top: B:46:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0096 A[Catch: CancellationException -> 0x00c5, TryCatch #0 {CancellationException -> 0x00c5, blocks: (B:8:0x0015, B:31:0x008e, B:33:0x0096, B:35:0x00a5, B:37:0x00b1, B:38:0x00b4, B:39:0x00b7, B:40:0x00bd, B:13:0x0026, B:25:0x0061, B:27:0x0065, B:16:0x002e, B:22:0x004d, B:19:0x003a), top: B:46:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00bd A[Catch: CancellationException -> 0x00c5, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x00c5, blocks: (B:8:0x0015, B:31:0x008e, B:33:0x0096, B:35:0x00a5, B:37:0x00b1, B:38:0x00b4, B:39:0x00b7, B:40:0x00bd, B:13:0x0026, B:25:0x0061, B:27:0x0065, B:16:0x002e, B:22:0x004d, B:19:0x003a), top: B:46:0x0009 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r11.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L32
                if (r1 == r4) goto L2a
                if (r1 == r3) goto L22
                if (r1 != r2) goto L1a
                java.lang.Object r0 = r11.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r0 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r0
                kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.util.concurrent.CancellationException -> Lc5
                goto L8e
            L1a:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L22:
                java.lang.Object r1 = r11.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.util.concurrent.CancellationException -> Lc5
                goto L61
            L2a:
                java.lang.Object r1 = r11.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.util.concurrent.CancellationException -> Lc5
                goto L4d
            L32:
                kotlin.ResultKt.throwOnFailure(r12)
                java.lang.Object r12 = r11.L$0
                r1 = r12
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                r8 = r11
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8     // Catch: java.util.concurrent.CancellationException -> Lc5
                r11.L$0 = r1     // Catch: java.util.concurrent.CancellationException -> Lc5
                r11.label = r4     // Catch: java.util.concurrent.CancellationException -> Lc5
                r6 = 0
                r7 = 0
                r9 = 2
                r10 = 0
                r5 = r1
                java.lang.Object r12 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r5, r6, r7, r8, r9, r10)     // Catch: java.util.concurrent.CancellationException -> Lc5
                if (r12 != r0) goto L4d
                return r0
            L4d:
                androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12     // Catch: java.util.concurrent.CancellationException -> Lc5
                long r4 = r12.getId()     // Catch: java.util.concurrent.CancellationException -> Lc5
                r12 = r11
                kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12     // Catch: java.util.concurrent.CancellationException -> Lc5
                r11.L$0 = r1     // Catch: java.util.concurrent.CancellationException -> Lc5
                r11.label = r3     // Catch: java.util.concurrent.CancellationException -> Lc5
                java.lang.Object r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m735awaitLongPressOrCancellationrnUCldI(r1, r4, r12)     // Catch: java.util.concurrent.CancellationException -> Lc5
                if (r12 != r0) goto L61
                return r0
            L61:
                androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12     // Catch: java.util.concurrent.CancellationException -> Lc5
                if (r12 == 0) goto Lc2
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r3 = r11.$onDragStart     // Catch: java.util.concurrent.CancellationException -> Lc5
                long r4 = r12.getPosition()     // Catch: java.util.concurrent.CancellationException -> Lc5
                androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m2024boximpl(r4)     // Catch: java.util.concurrent.CancellationException -> Lc5
                r3.invoke(r4)     // Catch: java.util.concurrent.CancellationException -> Lc5
                long r3 = r12.getId()     // Catch: java.util.concurrent.CancellationException -> Lc5
                androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1 r12 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1     // Catch: java.util.concurrent.CancellationException -> Lc5
                kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r5 = r11.$onDrag     // Catch: java.util.concurrent.CancellationException -> Lc5
                r12.<init>()     // Catch: java.util.concurrent.CancellationException -> Lc5
                kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12     // Catch: java.util.concurrent.CancellationException -> Lc5
                r5 = r11
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.util.concurrent.CancellationException -> Lc5
                r11.L$0 = r1     // Catch: java.util.concurrent.CancellationException -> Lc5
                r11.label = r2     // Catch: java.util.concurrent.CancellationException -> Lc5
                java.lang.Object r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m743dragjO51t88(r1, r3, r12, r5)     // Catch: java.util.concurrent.CancellationException -> Lc5
                if (r12 != r0) goto L8d
                return r0
            L8d:
                r0 = r1
            L8e:
                java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch: java.util.concurrent.CancellationException -> Lc5
                boolean r12 = r12.booleanValue()     // Catch: java.util.concurrent.CancellationException -> Lc5
                if (r12 == 0) goto Lbd
                androidx.compose.ui.input.pointer.PointerEvent r12 = r0.getCurrentEvent()     // Catch: java.util.concurrent.CancellationException -> Lc5
                java.util.List r12 = r12.getChanges()     // Catch: java.util.concurrent.CancellationException -> Lc5
                int r0 = r12.size()     // Catch: java.util.concurrent.CancellationException -> Lc5
                r1 = 0
            La3:
                if (r1 >= r0) goto Lb7
                java.lang.Object r2 = r12.get(r1)     // Catch: java.util.concurrent.CancellationException -> Lc5
                androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2     // Catch: java.util.concurrent.CancellationException -> Lc5
                boolean r3 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r2)     // Catch: java.util.concurrent.CancellationException -> Lc5
                if (r3 == 0) goto Lb4
                r2.consume()     // Catch: java.util.concurrent.CancellationException -> Lc5
            Lb4:
                int r1 = r1 + 1
                goto La3
            Lb7:
                kotlin.jvm.functions.Function0<kotlin.Unit> r12 = r11.$onDragEnd     // Catch: java.util.concurrent.CancellationException -> Lc5
                r12.invoke()     // Catch: java.util.concurrent.CancellationException -> Lc5
                goto Lc2
            Lbd:
                kotlin.jvm.functions.Function0<kotlin.Unit> r12 = r11.$onDragCancel     // Catch: java.util.concurrent.CancellationException -> Lc5
                r12.invoke()     // Catch: java.util.concurrent.CancellationException -> Lc5
            Lc2:
                kotlin.Unit r12 = kotlin.Unit.INSTANCE
                return r12
            Lc5:
                r12 = move-exception
                kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r11.$onDragCancel
                r0.invoke()
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.C02095.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final Object detectDragGesturesAfterLongPress(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C02095(function1, function0, function02, function2, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ec A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0167 -> B:61:0x016d). Please report as a decompilation issue!!! */
    /* renamed from: awaitVerticalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m740awaitVerticalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r18, long r19, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r21, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r22) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m740awaitVerticalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0163 -> B:61:0x0169). Please report as a decompilation issue!!! */
    /* renamed from: awaitVerticalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m739awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, int r22, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r23, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r24) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m739awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x010c, code lost:
    
        if ((r0 == 0.0f) == false) goto L58;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:35:0x00c3, B:46:0x00ec], limit reached: 72 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0084 -> B:23:0x008a). Please report as a decompilation issue!!! */
    /* renamed from: verticalDrag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m747verticalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r18, long r19, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r21, kotlin.coroutines.Continuation<? super java.lang.Boolean> r22) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m747verticalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d5, code lost:
    
        if ((androidx.compose.ui.geometry.Offset.m2036getYimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11)) == 0.0f ? 1 : 0) == 0) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0092 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0068 -> B:22:0x006d). Please report as a decompilation issue!!! */
    /* renamed from: awaitVerticalDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m738awaitVerticalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m738awaitVerticalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object detectVerticalDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectVerticalDragGestures.2
                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m752invokek4lQ0M(long j) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                    m752invokek4lQ0M(offset.getPackedValue());
                    return Unit.INSTANCE;
                }
            };
        }
        Function1 function12 = function1;
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectVerticalDragGestures.3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function0;
        if ((i & 4) != 0) {
            function02 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectVerticalDragGestures.4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        return detectVerticalDragGestures(pointerInputScope, function12, function03, function02, function2, continuation);
    }

    /* compiled from: DragGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5", f = "DragGestureDetector.kt", i = {0, 1, 1}, l = {479, 481, 489}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "overSlop"}, s = {"L$0", "L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5, reason: invalid class name and case insensitive filesystem */
    static final class C02175 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function0<Unit> $onDragEnd;
        final /* synthetic */ Function1<Offset, Unit> $onDragStart;
        final /* synthetic */ Function2<PointerInputChange, Float, Unit> $onVerticalDrag;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C02175(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Float, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super C02175> continuation) {
            super(2, continuation);
            this.$onDragStart = function1;
            this.$onVerticalDrag = function2;
            this.$onDragEnd = function0;
            this.$onDragCancel = function02;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C02175 c02175 = new C02175(this.$onDragStart, this.$onVerticalDrag, this.$onDragEnd, this.$onDragCancel, continuation);
            c02175.L$0 = obj;
            return c02175;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C02175) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00bb  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00c1  */
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
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L32
                if (r1 == r4) goto L2a
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                kotlin.ResultKt.throwOnFailure(r13)
                goto Lb3
            L16:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L1e:
                java.lang.Object r1 = r12.L$1
                kotlin.jvm.internal.Ref$FloatRef r1 = (kotlin.jvm.internal.Ref.FloatRef) r1
                java.lang.Object r3 = r12.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                kotlin.ResultKt.throwOnFailure(r13)
                goto L79
            L2a:
                java.lang.Object r1 = r12.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r13)
                goto L4f
            L32:
                kotlin.ResultKt.throwOnFailure(r13)
                java.lang.Object r13 = r12.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
                r8 = r12
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r12.L$0 = r13
                r12.label = r4
                r6 = 0
                r7 = 0
                r9 = 2
                r10 = 0
                r5 = r13
                java.lang.Object r1 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r5, r6, r7, r8, r9, r10)
                if (r1 != r0) goto L4c
                return r0
            L4c:
                r11 = r1
                r1 = r13
                r13 = r11
            L4f:
                androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                kotlin.jvm.internal.Ref$FloatRef r10 = new kotlin.jvm.internal.Ref$FloatRef
                r10.<init>()
                long r5 = r13.getId()
                int r7 = r13.getType()
                androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$drag$1 r13 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$drag$1
                r13.<init>()
                r8 = r13
                kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
                r9 = r12
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                r12.L$0 = r1
                r12.L$1 = r10
                r12.label = r3
                r4 = r1
                java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m739awaitVerticalPointerSlopOrCancellationgDDlDlE(r4, r5, r7, r8, r9)
                if (r13 != r0) goto L77
                return r0
            L77:
                r3 = r1
                r1 = r10
            L79:
                androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                if (r13 == 0) goto Lc6
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r4 = r12.$onDragStart
                long r5 = r13.getPosition()
                androidx.compose.ui.geometry.Offset r5 = androidx.compose.ui.geometry.Offset.m2024boximpl(r5)
                r4.invoke(r5)
                kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float, kotlin.Unit> r4 = r12.$onVerticalDrag
                float r1 = r1.element
                java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1)
                r4.invoke(r13, r1)
                long r4 = r13.getId()
                androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$1 r13 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$1
                kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float, kotlin.Unit> r1 = r12.$onVerticalDrag
                r13.<init>()
                kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
                r1 = r12
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r6 = 0
                r12.L$0 = r6
                r12.L$1 = r6
                r12.label = r2
                java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m747verticalDragjO51t88(r3, r4, r13, r1)
                if (r13 != r0) goto Lb3
                return r0
            Lb3:
                java.lang.Boolean r13 = (java.lang.Boolean) r13
                boolean r13 = r13.booleanValue()
                if (r13 == 0) goto Lc1
                kotlin.jvm.functions.Function0<kotlin.Unit> r13 = r12.$onDragEnd
                r13.invoke()
                goto Lc6
            Lc1:
                kotlin.jvm.functions.Function0<kotlin.Unit> r13 = r12.$onDragCancel
                r13.invoke()
            Lc6:
                kotlin.Unit r13 = kotlin.Unit.INSTANCE
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.C02175.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final Object detectVerticalDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C02175(function1, function2, function0, function02, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ec A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0167 -> B:61:0x016d). Please report as a decompilation issue!!! */
    /* renamed from: awaitHorizontalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m734awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r18, long r19, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r21, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r22) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m734awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0163 -> B:61:0x0169). Please report as a decompilation issue!!! */
    /* renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m733awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, int r22, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r23, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r24) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m733awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x010c, code lost:
    
        if ((r0 == 0.0f) == false) goto L58;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:35:0x00c3, B:46:0x00ec], limit reached: 72 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0084 -> B:23:0x008a). Please report as a decompilation issue!!! */
    /* renamed from: horizontalDrag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m744horizontalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r18, long r19, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r21, kotlin.coroutines.Continuation<? super java.lang.Boolean> r22) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m744horizontalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d5, code lost:
    
        if ((androidx.compose.ui.geometry.Offset.m2035getXimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11)) == 0.0f ? 1 : 0) == 0) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0092 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0068 -> B:22:0x006d). Please report as a decompilation issue!!! */
    /* renamed from: awaitHorizontalDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m732awaitHorizontalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m732awaitHorizontalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object detectHorizontalDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectHorizontalDragGestures.2
                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m751invokek4lQ0M(long j) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                    m751invokek4lQ0M(offset.getPackedValue());
                    return Unit.INSTANCE;
                }
            };
        }
        Function1 function12 = function1;
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectHorizontalDragGestures.3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function0;
        if ((i & 4) != 0) {
            function02 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt.detectHorizontalDragGestures.4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        return detectHorizontalDragGestures(pointerInputScope, function12, function03, function02, function2, continuation);
    }

    /* compiled from: DragGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5", f = "DragGestureDetector.kt", i = {0, 1, 1}, l = {627, 629, 640}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "overSlop"}, s = {"L$0", "L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5, reason: invalid class name and case insensitive filesystem */
    static final class C02135 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function0<Unit> $onDragEnd;
        final /* synthetic */ Function1<Offset, Unit> $onDragStart;
        final /* synthetic */ Function2<PointerInputChange, Float, Unit> $onHorizontalDrag;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C02135(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Float, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super C02135> continuation) {
            super(2, continuation);
            this.$onDragStart = function1;
            this.$onHorizontalDrag = function2;
            this.$onDragEnd = function0;
            this.$onDragCancel = function02;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C02135 c02135 = new C02135(this.$onDragStart, this.$onHorizontalDrag, this.$onDragEnd, this.$onDragCancel, continuation);
            c02135.L$0 = obj;
            return c02135;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C02135) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00bb  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00c1  */
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
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L32
                if (r1 == r4) goto L2a
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                kotlin.ResultKt.throwOnFailure(r13)
                goto Lb3
            L16:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L1e:
                java.lang.Object r1 = r12.L$1
                kotlin.jvm.internal.Ref$FloatRef r1 = (kotlin.jvm.internal.Ref.FloatRef) r1
                java.lang.Object r3 = r12.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                kotlin.ResultKt.throwOnFailure(r13)
                goto L79
            L2a:
                java.lang.Object r1 = r12.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r13)
                goto L4f
            L32:
                kotlin.ResultKt.throwOnFailure(r13)
                java.lang.Object r13 = r12.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
                r8 = r12
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r12.L$0 = r13
                r12.label = r4
                r6 = 0
                r7 = 0
                r9 = 2
                r10 = 0
                r5 = r13
                java.lang.Object r1 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r5, r6, r7, r8, r9, r10)
                if (r1 != r0) goto L4c
                return r0
            L4c:
                r11 = r1
                r1 = r13
                r13 = r11
            L4f:
                androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                kotlin.jvm.internal.Ref$FloatRef r10 = new kotlin.jvm.internal.Ref$FloatRef
                r10.<init>()
                long r5 = r13.getId()
                int r7 = r13.getType()
                androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$drag$1 r13 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$drag$1
                r13.<init>()
                r8 = r13
                kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
                r9 = r12
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                r12.L$0 = r1
                r12.L$1 = r10
                r12.label = r3
                r4 = r1
                java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m733awaitHorizontalPointerSlopOrCancellationgDDlDlE(r4, r5, r7, r8, r9)
                if (r13 != r0) goto L77
                return r0
            L77:
                r3 = r1
                r1 = r10
            L79:
                androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                if (r13 == 0) goto Lc6
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r4 = r12.$onDragStart
                long r5 = r13.getPosition()
                androidx.compose.ui.geometry.Offset r5 = androidx.compose.ui.geometry.Offset.m2024boximpl(r5)
                r4.invoke(r5)
                kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float, kotlin.Unit> r4 = r12.$onHorizontalDrag
                float r1 = r1.element
                java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1)
                r4.invoke(r13, r1)
                long r4 = r13.getId()
                androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1 r13 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$1
                kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float, kotlin.Unit> r1 = r12.$onHorizontalDrag
                r13.<init>()
                kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
                r1 = r12
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r6 = 0
                r12.L$0 = r6
                r12.L$1 = r6
                r12.label = r2
                java.lang.Object r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m744horizontalDragjO51t88(r3, r4, r13, r1)
                if (r13 != r0) goto Lb3
                return r0
            Lb3:
                java.lang.Boolean r13 = (java.lang.Boolean) r13
                boolean r13 = r13.booleanValue()
                if (r13 == 0) goto Lc1
                kotlin.jvm.functions.Function0<kotlin.Unit> r13 = r12.$onDragEnd
                r13.invoke()
                goto Lc6
            Lc1:
                kotlin.jvm.functions.Function0<kotlin.Unit> r13 = r12.$onDragCancel
                r13.invoke()
            Lc6:
                kotlin.Unit r13 = kotlin.Unit.INSTANCE
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.C02135.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final Object detectHorizontalDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C02135(function1, function2, function0, function02, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0114, code lost:
    
        if ((r0 == 0.0f) == false) goto L59;
     */
    /* JADX WARN: Path cross not found for [B:35:0x00ca, B:47:0x00f4], limit reached: 70 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x008e -> B:23:0x0094). Please report as a decompilation issue!!! */
    /* renamed from: drag-VnAYq1g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m741dragVnAYq1g(androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r22, androidx.compose.foundation.gestures.Orientation r23, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Boolean> r24, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r25) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m741dragVnAYq1g(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, androidx.compose.foundation.gestures.Orientation, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: drag-VnAYq1g$$forInline, reason: not valid java name */
    private static final Object m742dragVnAYq1g$$forInline(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Orientation orientation, Function1<? super PointerInputChange, Boolean> function12, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        PointerInputChange pointerInputChange3;
        long id = j;
        if (m745isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), id)) {
            return null;
        }
        while (true) {
            Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = id;
            while (true) {
                InlineMarker.mark(0);
                Object objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
                InlineMarker.mark(1);
                PointerEvent pointerEvent = (PointerEvent) objAwaitPointerEvent$default;
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        pointerInputChange = null;
                        break;
                    }
                    pointerInputChange = changes.get(i);
                    if (Boolean.valueOf(PointerId.m3466equalsimpl0(pointerInputChange.getId(), longRef.element)).booleanValue()) {
                        break;
                    }
                    i++;
                }
                pointerInputChange2 = pointerInputChange;
                if (pointerInputChange2 == null) {
                    pointerInputChange2 = null;
                    break;
                }
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    while (true) {
                        if (i >= size2) {
                            pointerInputChange3 = null;
                            break;
                        }
                        pointerInputChange3 = changes2.get(i);
                        if (Boolean.valueOf(pointerInputChange3.getPressed()).booleanValue()) {
                            break;
                        }
                        i++;
                    }
                    PointerInputChange pointerInputChange4 = pointerInputChange3;
                    if (pointerInputChange4 == null) {
                        break;
                    }
                    longRef.element = pointerInputChange4.getId();
                } else {
                    long jPositionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange2);
                    if (Boolean.valueOf(((orientation == null ? Offset.m2033getDistanceimpl(jPositionChangeIgnoreConsumed) : orientation == Orientation.Vertical ? Offset.m2036getYimpl(jPositionChangeIgnoreConsumed) : Offset.m2035getXimpl(jPositionChangeIgnoreConsumed)) == 0.0f ? 1 : 0) ^ 1).booleanValue()) {
                        break;
                    }
                }
            }
            if (pointerInputChange2 == null || function12.invoke(pointerInputChange2).booleanValue()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                return pointerInputChange2;
            }
            function1.invoke(pointerInputChange2);
            id = pointerInputChange2.getId();
        }
    }

    /* renamed from: awaitDragOrUp-jO51t88, reason: not valid java name */
    private static final Object m731awaitDragOrUpjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Boolean> function1, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = j;
        while (true) {
            int i = 0;
            InlineMarker.mark(0);
            PointerInputChange pointerInputChange2 = null;
            Object objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
            InlineMarker.mark(1);
            PointerEvent pointerEvent = (PointerEvent) objAwaitPointerEvent$default;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i2);
                if (Boolean.valueOf(PointerId.m3466equalsimpl0(pointerInputChange.getId(), longRef.element)).booleanValue()) {
                    break;
                }
                i2++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                while (true) {
                    if (i >= size2) {
                        break;
                    }
                    PointerInputChange pointerInputChange4 = changes2.get(i);
                    if (Boolean.valueOf(pointerInputChange4.getPressed()).booleanValue()) {
                        pointerInputChange2 = pointerInputChange4;
                        break;
                    }
                    i++;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange2;
                if (pointerInputChange5 == null) {
                    return pointerInputChange3;
                }
                longRef.element = pointerInputChange5.getId();
            } else if (function1.invoke(pointerInputChange3).booleanValue()) {
                return pointerInputChange3;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: awaitPointerSlopOrCancellation-pn7EDYM, reason: not valid java name */
    private static final Object m736awaitPointerSlopOrCancellationpn7EDYM(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Orientation orientation, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        Continuation<? super PointerEvent> continuation2;
        PointerInputChange pointerInputChange2;
        Continuation<? super PointerEvent> continuation3 = continuation;
        if (m745isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
            return null;
        }
        float fM746pointerSlopE8SPZFQ = m746pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = j;
        TouchSlopDetector touchSlopDetector = new TouchSlopDetector(orientation);
        while (true) {
            InlineMarker.mark(0);
            Object objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation3, 1, null);
            InlineMarker.mark(1);
            PointerEvent pointerEvent = (PointerEvent) objAwaitPointerEvent$default;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i2);
                if (Boolean.valueOf(PointerId.m3466equalsimpl0(pointerInputChange.getId(), longRef.element)).booleanValue()) {
                    break;
                }
                i2++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null || pointerInputChange3.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size2) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes2.get(i3);
                    if (Boolean.valueOf(pointerInputChange2.getPressed()).booleanValue()) {
                        break;
                    }
                    i3++;
                }
                PointerInputChange pointerInputChange4 = pointerInputChange2;
                if (pointerInputChange4 == null) {
                    return null;
                }
                longRef.element = pointerInputChange4.getId();
            } else {
                Offset offsetM825addPointerInputChangeGcwITfU = touchSlopDetector.m825addPointerInputChangeGcwITfU(pointerInputChange3, fM746pointerSlopE8SPZFQ);
                if (offsetM825addPointerInputChangeGcwITfU != null) {
                    function2.invoke(pointerInputChange3, offsetM825addPointerInputChangeGcwITfU);
                    if (pointerInputChange3.isConsumed()) {
                        return pointerInputChange3;
                    }
                    touchSlopDetector.reset();
                } else {
                    PointerEventPass pointerEventPass = PointerEventPass.Final;
                    InlineMarker.mark(0);
                    continuation2 = continuation;
                    awaitPointerEventScope.awaitPointerEvent(pointerEventPass, continuation2);
                    InlineMarker.mark(1);
                    if (pointerInputChange3.isConsumed()) {
                        return null;
                    }
                    continuation3 = continuation2;
                }
            }
            continuation2 = continuation;
            continuation3 = continuation2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r10v2, types: [T, androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v6, types: [androidx.compose.ui.input.pointer.PointerInputChange] */
    /* renamed from: awaitLongPressOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m735awaitLongPressOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r9, long r10, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1
            if (r0 == 0) goto L14
            r0 = r12
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1 r0 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1
            r0.<init>(r12)
        L19:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r9 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r0.L$0
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L9e
            goto La7
        L34:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3c:
            kotlin.ResultKt.throwOnFailure(r12)
            androidx.compose.ui.input.pointer.PointerEvent r12 = r9.getCurrentEvent()
            boolean r12 = m745isPointerUpDmW0f2w(r12, r10)
            if (r12 == 0) goto L4a
            return r4
        L4a:
            androidx.compose.ui.input.pointer.PointerEvent r12 = r9.getCurrentEvent()
            java.util.List r12 = r12.getChanges()
            int r2 = r12.size()
            r5 = 0
        L57:
            if (r5 >= r2) goto L6e
            java.lang.Object r6 = r12.get(r5)
            r7 = r6
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            long r7 = r7.getId()
            boolean r7 = androidx.compose.ui.input.pointer.PointerId.m3466equalsimpl0(r7, r10)
            if (r7 == 0) goto L6b
            goto L6f
        L6b:
            int r5 = r5 + 1
            goto L57
        L6e:
            r6 = r4
        L6f:
            r10 = r6
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            if (r10 != 0) goto L75
            return r4
        L75:
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef
            r11.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r12 = new kotlin.jvm.internal.Ref$ObjectRef
            r12.<init>()
            r12.element = r10
            androidx.compose.ui.platform.ViewConfiguration r2 = r9.getViewConfiguration()
            long r5 = r2.getLongPressTimeoutMillis()
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2 r2 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L9d
            r2.<init>(r12, r11, r4)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L9d
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L9d
            r0.L$0 = r10     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L9d
            r0.L$1 = r11     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L9d
            r0.label = r3     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L9d
            java.lang.Object r9 = r9.withTimeout(r5, r2, r0)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L9d
            if (r9 != r1) goto La7
            return r1
        L9d:
            r9 = r11
        L9e:
            T r9 = r9.element
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            if (r9 != 0) goto La6
            r4 = r10
            goto La7
        La6:
            r4 = r9
        La7:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m735awaitLongPressOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isPointerUp-DmW0f2w, reason: not valid java name */
    public static final boolean m745isPointerUpDmW0f2w(PointerEvent pointerEvent, long j) {
        PointerInputChange pointerInputChange;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes.get(i);
            if (PointerId.m3466equalsimpl0(pointerInputChange.getId(), j)) {
                break;
            }
            i++;
        }
        PointerInputChange pointerInputChange2 = pointerInputChange;
        if (pointerInputChange2 != null && pointerInputChange2.getPressed()) {
            z = true;
        }
        return true ^ z;
    }

    /* renamed from: pointerSlop-E8SPZFQ, reason: not valid java name */
    public static final float m746pointerSlopE8SPZFQ(ViewConfiguration viewConfiguration, int i) {
        return PointerType.m3556equalsimpl0(i, PointerType.INSTANCE.m3561getMouseT8wyACA()) ? viewConfiguration.getTouchSlop() * mouseToTouchSlopRatio : viewConfiguration.getTouchSlop();
    }

    static {
        float fM4737constructorimpl = Dp.m4737constructorimpl((float) 0.125d);
        mouseSlop = fM4737constructorimpl;
        float fM4737constructorimpl2 = Dp.m4737constructorimpl(18);
        defaultTouchSlop = fM4737constructorimpl2;
        mouseToTouchSlopRatio = fM4737constructorimpl / fM4737constructorimpl2;
    }
}
