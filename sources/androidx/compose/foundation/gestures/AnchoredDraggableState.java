package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.messaging.Constants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.TuplesKt;
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
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: AnchoredDraggable.kt */
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016*\u0001\u0018\b\u0007\u0018\u0000 p*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001pB\u008f\u0001\b\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011\u0012#\b\u0002\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u0007¢\u0006\u0002\u0010\u0015B\u007f\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011\u0012#\b\u0002\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u0007¢\u0006\u0002\u0010\u0016Jy\u0010P\u001a\u00020Q2\u0006\u0010K\u001a\u00028\u00002\b\b\u0002\u0010R\u001a\u00020S2W\u0010T\u001aS\b\u0001\u0012\u0004\u0012\u00020V\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(W\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(K\u0012\n\u0012\b\u0012\u0004\u0012\u00020Q0X\u0012\u0006\u0012\u0004\u0018\u00010\u00020U¢\u0006\u0002\bYH\u0086@¢\u0006\u0002\u0010ZJ\\\u0010P\u001a\u00020Q2\b\b\u0002\u0010R\u001a\u00020S2B\u0010T\u001a>\b\u0001\u0012\u0004\u0012\u00020V\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020Q0X\u0012\u0006\u0012\u0004\u0018\u00010\u00020[¢\u0006\u0002\bYH\u0086@¢\u0006\u0002\u0010\\J%\u0010]\u001a\u00028\u00002\u0006\u0010:\u001a\u00020\b2\u0006\u0010#\u001a\u00028\u00002\u0006\u0010^\u001a\u00020\bH\u0002¢\u0006\u0002\u0010_J\u000e\u0010`\u001a\u00020\b2\u0006\u0010a\u001a\u00020\bJ\u0015\u0010b\u001a\u00020\b2\u0006\u0010a\u001a\u00020\bH\u0000¢\u0006\u0002\bcJ\u001d\u0010?\u001a\u00020\b2\u0006\u0010d\u001a\u00028\u00002\u0006\u0010e\u001a\u00028\u0000H\u0007¢\u0006\u0002\u0010fJ\u0006\u0010g\u001a\u00020\bJ\u0016\u0010h\u001a\u00020\b2\u0006\u0010^\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010iJ\u0015\u0010j\u001a\u00020\u00142\u0006\u0010K\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010kJ#\u0010l\u001a\u00020Q2\f\u0010m\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\b\b\u0002\u0010n\u001a\u00028\u0000¢\u0006\u0002\u0010oR\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R7\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR/\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R+\u0010#\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010 \u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010-\u001a\u0004\u0018\u00018\u00002\b\u0010\u001a\u001a\u0004\u0018\u00018\u00008B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b0\u0010 \u001a\u0004\b.\u0010%\"\u0004\b/\u0010'R\u0011\u00101\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b1\u00102R+\u00103\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b4\u00105\"\u0004\b6\u00107R+\u0010:\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b=\u00109\u001a\u0004\b;\u00105\"\u0004\b<\u00107R/\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\b0\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\"R!\u0010?\u001a\u00020\b8GX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\bC\u0010D\u0012\u0004\b@\u0010A\u001a\u0004\bB\u00105R+\u0010E\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bH\u0010 \u001a\u0004\bF\u0010%\"\u0004\bG\u0010'R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u001b\u0010K\u001a\u00028\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010D\u001a\u0004\bL\u0010%R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010O¨\u0006q"}, d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableState;", ExifInterface.GPS_DIRECTION_TRUE, "", "initialValue", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "positionalThreshold", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "totalDistance", "velocityThreshold", "Lkotlin/Function0;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "confirmValueChange", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/foundation/gestures/DraggableAnchors;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;)V", "anchoredDragScope", "androidx/compose/foundation/gestures/AnchoredDraggableState$anchoredDragScope$1", "Landroidx/compose/foundation/gestures/AnchoredDraggableState$anchoredDragScope$1;", "<set-?>", "getAnchors", "()Landroidx/compose/foundation/gestures/DraggableAnchors;", "setAnchors", "(Landroidx/compose/foundation/gestures/DraggableAnchors;)V", "anchors$delegate", "Landroidx/compose/runtime/MutableState;", "getConfirmValueChange$foundation_release", "()Lkotlin/jvm/functions/Function1;", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "(Ljava/lang/Object;)V", "currentValue$delegate", "getDecayAnimationSpec", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "dragMutex", "Landroidx/compose/foundation/MutatorMutex;", "dragTarget", "getDragTarget", "setDragTarget", "dragTarget$delegate", "isAnimationRunning", "()Z", "lastVelocity", "getLastVelocity", "()F", "setLastVelocity", "(F)V", "lastVelocity$delegate", "Landroidx/compose/runtime/MutableFloatState;", "offset", "getOffset", "setOffset", "offset$delegate", "getPositionalThreshold$foundation_release", "progress", "getProgress$annotations", "()V", "getProgress", "progress$delegate", "Landroidx/compose/runtime/State;", "settledValue", "getSettledValue", "setSettledValue", "settledValue$delegate", "getSnapAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "targetValue", "getTargetValue", "targetValue$delegate", "getVelocityThreshold$foundation_release", "()Lkotlin/jvm/functions/Function0;", "anchoredDrag", "", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function4;", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "anchor", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function3;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeTarget", "velocity", "(FLjava/lang/Object;F)Ljava/lang/Object;", "dispatchRawDelta", "delta", "newOffsetForDelta", "newOffsetForDelta$foundation_release", Constants.MessagePayloadKeys.FROM, "to", "(Ljava/lang/Object;Ljava/lang/Object;)F", "requireOffset", "settle", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySnapTo", "(Ljava/lang/Object;)Z", "updateAnchors", "newAnchors", "newTarget", "(Landroidx/compose/foundation/gestures/DraggableAnchors;Ljava/lang/Object;)V", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnchoredDraggableState<T> {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AnchoredDraggableState$anchoredDragScope$1<T> anchoredDragScope;

    /* renamed from: anchors$delegate, reason: from kotlin metadata */
    private final MutableState anchors;
    private final Function1<T, Boolean> confirmValueChange;

    /* renamed from: currentValue$delegate, reason: from kotlin metadata */
    private final MutableState currentValue;
    private final DecayAnimationSpec<Float> decayAnimationSpec;
    private final MutatorMutex dragMutex;

    /* renamed from: dragTarget$delegate, reason: from kotlin metadata */
    private final MutableState dragTarget;

    /* renamed from: lastVelocity$delegate, reason: from kotlin metadata */
    private final MutableFloatState lastVelocity;

    /* renamed from: offset$delegate, reason: from kotlin metadata */
    private final MutableFloatState offset;
    private final Function1<Float, Float> positionalThreshold;

    /* renamed from: progress$delegate, reason: from kotlin metadata */
    private final State progress;

    /* renamed from: settledValue$delegate, reason: from kotlin metadata */
    private final MutableState settledValue;
    private final AnimationSpec<Float> snapAnimationSpec;

    /* renamed from: targetValue$delegate, reason: from kotlin metadata */
    private final State targetValue;
    private final Function0<Float> velocityThreshold;

    /* compiled from: AnchoredDraggable.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableState", f = "AnchoredDraggable.kt", i = {0}, l = {880}, m = "anchoredDrag", n = {"this"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3, reason: invalid class name */
    static final class AnonymousClass3 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AnchoredDraggableState<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(AnchoredDraggableState<T> anchoredDraggableState, Continuation<? super AnonymousClass3> continuation) {
            super(continuation);
            this.this$0 = anchoredDraggableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.anchoredDrag(null, null, null, this);
        }
    }

    @Deprecated(message = "Use the progress function to query the progress between two specified anchors.", replaceWith = @ReplaceWith(expression = "progress(state.settledValue, state.targetValue)", imports = {}))
    public static /* synthetic */ void getProgress$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchoredDraggableState(T t, Function1<? super Float, Float> function1, Function0<Float> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Function1<? super T, Boolean> function12) {
        this.positionalThreshold = function1;
        this.velocityThreshold = function0;
        this.snapAnimationSpec = animationSpec;
        this.decayAnimationSpec = decayAnimationSpec;
        this.confirmValueChange = function12;
        this.dragMutex = new MutatorMutex();
        this.currentValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.settledValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.targetValue = SnapshotStateKt.derivedStateOf(new Function0<T>(this) { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$targetValue$2
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                T t2 = (T) this.this$0.getDragTarget();
                if (t2 != null) {
                    return t2;
                }
                AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                if (!Float.isNaN(anchoredDraggableState.getOffset())) {
                    T tClosestAnchor = anchoredDraggableState.getAnchors().closestAnchor(anchoredDraggableState.getOffset());
                    return tClosestAnchor == null ? anchoredDraggableState.getCurrentValue() : tClosestAnchor;
                }
                return anchoredDraggableState.getCurrentValue();
            }
        });
        this.offset = PrimitiveSnapshotStateKt.mutableFloatStateOf(Float.NaN);
        this.progress = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Float>(this) { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState.progress.2
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                float fPositionOf = this.this$0.getAnchors().positionOf(this.this$0.getSettledValue());
                float fPositionOf2 = this.this$0.getAnchors().positionOf(this.this$0.getTargetValue()) - fPositionOf;
                float fAbs = Math.abs(fPositionOf2);
                float f = 1.0f;
                if (!Float.isNaN(fAbs) && fAbs > 1.0E-6f) {
                    float fRequireOffset = (this.this$0.requireOffset() - fPositionOf) / fPositionOf2;
                    if (fRequireOffset < 1.0E-6f) {
                        f = 0.0f;
                    } else if (fRequireOffset <= 0.999999f) {
                        f = fRequireOffset;
                    }
                }
                return Float.valueOf(f);
            }
        });
        this.lastVelocity = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.dragTarget = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.anchors = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AnchoredDraggableKt.emptyDraggableAnchors(), null, 2, null);
        this.anchoredDragScope = new AnchoredDraggableState$anchoredDragScope$1(this);
    }

    public final Function1<Float, Float> getPositionalThreshold$foundation_release() {
        return this.positionalThreshold;
    }

    public final Function0<Float> getVelocityThreshold$foundation_release() {
        return this.velocityThreshold;
    }

    public final AnimationSpec<Float> getSnapAnimationSpec() {
        return this.snapAnimationSpec;
    }

    public final DecayAnimationSpec<Float> getDecayAnimationSpec() {
        return this.decayAnimationSpec;
    }

    public /* synthetic */ AnchoredDraggableState(Object obj, Function1 function1, Function0 function0, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, function1, function0, animationSpec, decayAnimationSpec, (i & 32) != 0 ? new Function1<T, Boolean>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(T t) {
                return true;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj2) {
                return invoke((AnonymousClass1) obj2);
            }
        } : anonymousClass1);
    }

    public final Function1<T, Boolean> getConfirmValueChange$foundation_release() {
        return this.confirmValueChange;
    }

    public /* synthetic */ AnchoredDraggableState(Object obj, DraggableAnchors draggableAnchors, Function1 function1, Function0 function0, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, draggableAnchors, function1, function0, animationSpec, decayAnimationSpec, (i & 64) != 0 ? new Function1<T, Boolean>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(T t) {
                return true;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj2) {
                return invoke((AnonymousClass2) obj2);
            }
        } : function12);
    }

    public AnchoredDraggableState(T t, DraggableAnchors<T> draggableAnchors, Function1<? super Float, Float> function1, Function0<Float> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Function1<? super T, Boolean> function12) {
        this(t, function1, function0, animationSpec, decayAnimationSpec, function12);
        setAnchors(draggableAnchors);
        trySnapTo(t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentValue(T t) {
        this.currentValue.setValue(t);
    }

    public final T getCurrentValue() {
        return this.currentValue.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSettledValue(T t) {
        this.settledValue.setValue(t);
    }

    public final T getSettledValue() {
        return this.settledValue.getValue();
    }

    public final T getTargetValue() {
        return (T) this.targetValue.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setOffset(float f) {
        this.offset.setFloatValue(f);
    }

    public final float getOffset() {
        return this.offset.getFloatValue();
    }

    public final float requireOffset() {
        if (Float.isNaN(getOffset())) {
            throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?".toString());
        }
        return getOffset();
    }

    public final boolean isAnimationRunning() {
        return getDragTarget() != null;
    }

    public final float progress(T from, T to) {
        float fPositionOf = getAnchors().positionOf(from);
        float fPositionOf2 = getAnchors().positionOf(to);
        float fCoerceIn = (RangesKt.coerceIn(getOffset(), Math.min(fPositionOf, fPositionOf2), Math.max(fPositionOf, fPositionOf2)) - fPositionOf) / (fPositionOf2 - fPositionOf);
        if (Float.isNaN(fCoerceIn)) {
            return 1.0f;
        }
        if (fCoerceIn < 1.0E-6f) {
            return 0.0f;
        }
        if (fCoerceIn > 0.999999f) {
            return 1.0f;
        }
        return Math.abs(fCoerceIn);
    }

    public final float getProgress() {
        return ((Number) this.progress.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLastVelocity(float f) {
        this.lastVelocity.setFloatValue(f);
    }

    public final float getLastVelocity() {
        return this.lastVelocity.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T getDragTarget() {
        return this.dragTarget.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDragTarget(T t) {
        this.dragTarget.setValue(t);
    }

    private final void setAnchors(DraggableAnchors<T> draggableAnchors) {
        this.anchors.setValue(draggableAnchors);
    }

    public final DraggableAnchors<T> getAnchors() {
        return (DraggableAnchors) this.anchors.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateAnchors$default(AnchoredDraggableState anchoredDraggableState, DraggableAnchors draggableAnchors, Object obj, int i, Object obj2) {
        if ((i & 2) != 0 && (Float.isNaN(anchoredDraggableState.getOffset()) || (obj = draggableAnchors.closestAnchor(anchoredDraggableState.getOffset())) == null)) {
            obj = anchoredDraggableState.getTargetValue();
        }
        anchoredDraggableState.updateAnchors(draggableAnchors, obj);
    }

    public final void updateAnchors(DraggableAnchors<T> newAnchors, T newTarget) {
        if (Intrinsics.areEqual(getAnchors(), newAnchors)) {
            return;
        }
        setAnchors(newAnchors);
        if (trySnapTo(newTarget)) {
            return;
        }
        setDragTarget(newTarget);
    }

    public final Object settle(float f, Continuation<? super Float> continuation) {
        T currentValue = getCurrentValue();
        T tComputeTarget = computeTarget(requireOffset(), currentValue, f);
        if (this.confirmValueChange.invoke(tComputeTarget).booleanValue()) {
            return AnchoredDraggableKt.animateToWithDecay(this, tComputeTarget, f, continuation);
        }
        return AnchoredDraggableKt.animateToWithDecay(this, currentValue, f, continuation);
    }

    private final T computeTarget(float offset, T currentValue, float velocity) {
        DraggableAnchors<T> anchors = getAnchors();
        float fPositionOf = anchors.positionOf(currentValue);
        float fFloatValue = this.velocityThreshold.invoke().floatValue();
        if (fPositionOf == offset || Float.isNaN(fPositionOf)) {
            return currentValue;
        }
        if (Math.abs(velocity) >= Math.abs(fFloatValue)) {
            T tClosestAnchor = anchors.closestAnchor(offset, Math.signum(velocity) > 0.0f);
            Intrinsics.checkNotNull(tClosestAnchor);
            return tClosestAnchor;
        }
        T tClosestAnchor2 = anchors.closestAnchor(offset, offset - fPositionOf > 0.0f);
        Intrinsics.checkNotNull(tClosestAnchor2);
        return Math.abs(fPositionOf - offset) <= Math.abs(this.positionalThreshold.invoke(Float.valueOf(Math.abs(fPositionOf - anchors.positionOf(tClosestAnchor2)))).floatValue()) ? currentValue : tClosestAnchor2;
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState anchoredDraggableState, MutatePriority mutatePriority, Function3 function3, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(mutatePriority, function3, continuation);
    }

    /* compiled from: AnchoredDraggable.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2", f = "AnchoredDraggable.kt", i = {}, l = {835}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2, reason: invalid class name and case insensitive filesystem */
    static final class C02042 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> $block;
        int label;
        final /* synthetic */ AnchoredDraggableState<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C02042(AnchoredDraggableState<T> anchoredDraggableState, Function3<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super C02042> continuation) {
            super(1, continuation);
            this.this$0 = anchoredDraggableState;
            this.$block = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C02042(this.this$0, this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C02042) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: AnchoredDraggable.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "latestAnchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2$2", f = "AnchoredDraggable.kt", i = {}, l = {836}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2$2, reason: invalid class name and collision with other inner class name */
        static final class C00212 extends SuspendLambda implements Function2<DraggableAnchors<T>, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> $block;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C00212(Function3<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super Continuation<? super Unit>, ? extends Object> function3, AnchoredDraggableState<T> anchoredDraggableState, Continuation<? super C00212> continuation) {
                super(2, continuation);
                this.$block = function3;
                this.this$0 = anchoredDraggableState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00212 c00212 = new C00212(this.$block, this.this$0, continuation);
                c00212.L$0 = obj;
                return c00212;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(DraggableAnchors<T> draggableAnchors, Continuation<? super Unit> continuation) {
                return ((C00212) create(draggableAnchors, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    DraggableAnchors<T> draggableAnchors = (DraggableAnchors) this.L$0;
                    Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> function3 = this.$block;
                    AnchoredDraggableState$anchoredDragScope$1 anchoredDraggableState$anchoredDragScope$1 = ((AnchoredDraggableState) this.this$0).anchoredDragScope;
                    this.label = 1;
                    if (function3.invoke(anchoredDraggableState$anchoredDragScope$1, draggableAnchors, this) == coroutine_suspended) {
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
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                this.label = 1;
                if (AnchoredDraggableKt.restartable(new Function0<DraggableAnchors<T>>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState.anchoredDrag.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final DraggableAnchors<T> invoke() {
                        return anchoredDraggableState.getAnchors();
                    }
                }, new C00212(this.$block, this.this$0, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            T tClosestAnchor = this.this$0.getAnchors().closestAnchor(this.this$0.getOffset());
            if (tClosestAnchor != null) {
                if (Math.abs(this.this$0.getOffset() - this.this$0.getAnchors().positionOf(tClosestAnchor)) < 0.5f && this.this$0.getConfirmValueChange$foundation_release().invoke(tClosestAnchor).booleanValue()) {
                    this.this$0.setSettledValue(tClosestAnchor);
                    this.this$0.setCurrentValue(tClosestAnchor);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final Object anchoredDrag(MutatePriority mutatePriority, Function3<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object objMutate = this.dragMutex.mutate(mutatePriority, new C02042(this, function3, null), continuation);
        return objMutate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMutate : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object anchoredDrag(T r6, androidx.compose.foundation.MutatePriority r7, kotlin.jvm.functions.Function4<? super androidx.compose.foundation.gestures.AnchoredDragScope, ? super androidx.compose.foundation.gestures.DraggableAnchors<T>, ? super T, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.AnchoredDraggableState.AnonymousClass3
            if (r0 == 0) goto L14
            r0 = r9
            androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3 r0 = (androidx.compose.foundation.gestures.AnchoredDraggableState.AnonymousClass3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3 r0 = new androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3
            r0.<init>(r5, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.L$0
            androidx.compose.foundation.gestures.AnchoredDraggableState r6 = (androidx.compose.foundation.gestures.AnchoredDraggableState) r6
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L2f
            goto L5b
        L2f:
            r7 = move-exception
            goto L61
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            kotlin.ResultKt.throwOnFailure(r9)
            androidx.compose.foundation.gestures.DraggableAnchors r9 = r5.getAnchors()
            boolean r9 = r9.hasAnchorFor(r6)
            if (r9 == 0) goto L65
            androidx.compose.foundation.MutatorMutex r9 = r5.dragMutex     // Catch: java.lang.Throwable -> L5f
            androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4 r2 = new androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4     // Catch: java.lang.Throwable -> L5f
            r2.<init>(r5, r6, r8, r4)     // Catch: java.lang.Throwable -> L5f
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2     // Catch: java.lang.Throwable -> L5f
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L5f
            r0.label = r3     // Catch: java.lang.Throwable -> L5f
            java.lang.Object r6 = r9.mutate(r7, r2, r0)     // Catch: java.lang.Throwable -> L5f
            if (r6 != r1) goto L5a
            return r1
        L5a:
            r6 = r5
        L5b:
            r6.setDragTarget(r4)
            goto L79
        L5f:
            r7 = move-exception
            r6 = r5
        L61:
            r6.setDragTarget(r4)
            throw r7
        L65:
            kotlin.jvm.functions.Function1<T, java.lang.Boolean> r7 = r5.confirmValueChange
            java.lang.Object r7 = r7.invoke(r6)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L79
            r5.setSettledValue(r6)
            r5.setCurrentValue(r6)
        L79:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableState.anchoredDrag(java.lang.Object, androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function4, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState anchoredDraggableState, Object obj, MutatePriority mutatePriority, Function4 function4, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(obj, mutatePriority, function4, continuation);
    }

    /* compiled from: AnchoredDraggable.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4", f = "AnchoredDraggable.kt", i = {}, l = {882}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ T $targetValue;
        int label;
        final /* synthetic */ AnchoredDraggableState<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(AnchoredDraggableState<T> anchoredDraggableState, T t, Function4<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function4, Continuation<? super AnonymousClass4> continuation) {
            super(1, continuation);
            this.this$0 = anchoredDraggableState;
            this.$targetValue = t;
            this.$block = function4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass4(this.this$0, this.$targetValue, this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.setDragTarget(this.$targetValue);
                final AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                this.label = 1;
                if (AnchoredDraggableKt.restartable(new Function0<Pair<? extends DraggableAnchors<T>, ? extends T>>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState.anchoredDrag.4.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Pair<DraggableAnchors<T>, T> invoke() {
                        return TuplesKt.to(anchoredDraggableState.getAnchors(), anchoredDraggableState.getTargetValue());
                    }
                }, new AnonymousClass2(this.$block, this.this$0, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (this.this$0.getConfirmValueChange$foundation_release().invoke(this.$targetValue).booleanValue()) {
                ((AnchoredDraggableState) this.this$0).anchoredDragScope.dragTo(this.this$0.getAnchors().positionOf(this.$targetValue), this.this$0.getLastVelocity());
                this.this$0.setSettledValue(this.$targetValue);
                this.this$0.setCurrentValue(this.$targetValue);
            }
            return Unit.INSTANCE;
        }

        /* compiled from: AnchoredDraggable.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0018\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Landroidx/compose/foundation/gestures/DraggableAnchors;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4$2", f = "AnchoredDraggable.kt", i = {}, l = {885}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4$2, reason: invalid class name */
        static final class AnonymousClass2 extends SuspendLambda implements Function2<Pair<? extends DraggableAnchors<T>, ? extends T>, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> $block;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(Function4<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function4, AnchoredDraggableState<T> anchoredDraggableState, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$block = function4;
                this.this$0 = anchoredDraggableState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$block, this.this$0, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Pair<? extends DraggableAnchors<T>, ? extends T> pair, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Pair pair = (Pair) this.L$0;
                    DraggableAnchors draggableAnchors = (DraggableAnchors) pair.component1();
                    Object objComponent2 = pair.component2();
                    Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> function4 = this.$block;
                    AnchoredDraggableState$anchoredDragScope$1 anchoredDraggableState$anchoredDragScope$1 = ((AnchoredDraggableState) this.this$0).anchoredDragScope;
                    this.label = 1;
                    if (function4.invoke(anchoredDraggableState$anchoredDragScope$1, draggableAnchors, objComponent2, this) == coroutine_suspended) {
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
        }
    }

    public final float newOffsetForDelta$foundation_release(float delta) {
        return RangesKt.coerceIn((Float.isNaN(getOffset()) ? 0.0f : getOffset()) + delta, getAnchors().minAnchor(), getAnchors().maxAnchor());
    }

    public final float dispatchRawDelta(float delta) {
        float fNewOffsetForDelta$foundation_release = newOffsetForDelta$foundation_release(delta);
        float offset = Float.isNaN(getOffset()) ? 0.0f : getOffset();
        setOffset(fNewOffsetForDelta$foundation_release);
        return fNewOffsetForDelta$foundation_release - offset;
    }

    private final boolean trySnapTo(T targetValue) {
        MutatorMutex mutatorMutex = this.dragMutex;
        boolean zTryLock = mutatorMutex.tryLock();
        if (zTryLock) {
            try {
                AnchoredDraggableState$anchoredDragScope$1<T> anchoredDraggableState$anchoredDragScope$1 = this.anchoredDragScope;
                float fPositionOf = getAnchors().positionOf(targetValue);
                if (!Float.isNaN(fPositionOf)) {
                    AnchoredDragScope.dragTo$default(anchoredDraggableState$anchoredDragScope$1, fPositionOf, 0.0f, 2, null);
                    setDragTarget(null);
                }
                setCurrentValue(targetValue);
                setSettledValue(targetValue);
            } finally {
                mutatorMutex.unlock();
            }
        }
        return zTryLock;
    }

    /* compiled from: AnchoredDraggable.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0087\u0001\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t0\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00140\rH\u0007¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", ExifInterface.GPS_DIRECTION_TRUE, "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "positionalThreshold", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "distance", "velocityThreshold", "Lkotlin/Function0;", "confirmValueChange", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Saver Saver$default(Companion companion, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, Function1 function1, Function0 function0, Function1 function12, int i, Object obj) {
            if ((i & 16) != 0) {
                function12 = new Function1<T, Boolean>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$Saver$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(T t) {
                        return true;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Object obj2) {
                        return invoke((AnchoredDraggableState$Companion$Saver$1<T>) obj2);
                    }
                };
            }
            return companion.Saver(animationSpec, decayAnimationSpec, function1, function0, function12);
        }

        public final <T> Saver<AnchoredDraggableState<T>, T> Saver(final AnimationSpec<Float> snapAnimationSpec, final DecayAnimationSpec<Float> decayAnimationSpec, final Function1<? super Float, Float> positionalThreshold, final Function0<Float> velocityThreshold, final Function1<? super T, Boolean> confirmValueChange) {
            return SaverKt.Saver(new Function2<SaverScope, AnchoredDraggableState<T>, T>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$Saver$2
                @Override // kotlin.jvm.functions.Function2
                public final T invoke(SaverScope saverScope, AnchoredDraggableState<T> anchoredDraggableState) {
                    return anchoredDraggableState.getCurrentValue();
                }
            }, new Function1<T, AnchoredDraggableState<T>>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$Saver$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((AnchoredDraggableState$Companion$Saver$3<T>) obj);
                }

                @Override // kotlin.jvm.functions.Function1
                public final AnchoredDraggableState<T> invoke(T t) {
                    return new AnchoredDraggableState<>(t, positionalThreshold, velocityThreshold, snapAnimationSpec, decayAnimationSpec, confirmValueChange);
                }
            });
        }
    }
}
