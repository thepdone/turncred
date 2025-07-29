package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.unit.Density;
import com.facebook.react.uimanager.ViewProps;
import io.sentry.protocol.Device;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: Scrollable.kt */
@Metadata(d1 = {"\u0000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\r\u001a^\u0010\u000f\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007\u001aH\u0010\u000f\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007\u001a\u001f\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020 H\u0082@ø\u0001\u0000¢\u0006\u0004\b#\u0010$\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006%"}, d2 = {"CanDragCalculation", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "DefaultScrollMotionDurationScale", "Landroidx/compose/ui/MotionDurationScale;", "getDefaultScrollMotionDurationScale", "()Landroidx/compose/ui/MotionDurationScale;", "DefaultScrollMotionDurationScaleFactor", "", "NoOpScrollScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "UnityDensity", "androidx/compose/foundation/gestures/ScrollableKt$UnityDensity$1", "Landroidx/compose/foundation/gestures/ScrollableKt$UnityDensity$1;", "scrollable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", Device.JsonKeys.ORIENTATION, "Landroidx/compose/foundation/gestures/Orientation;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", ViewProps.ENABLED, "reverseDirection", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "semanticsScrollBy", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "offset", "semanticsScrollBy-d-4ec7I", "(Landroidx/compose/foundation/gestures/ScrollingLogic;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScrollableKt {
    private static final float DefaultScrollMotionDurationScaleFactor = 1.0f;
    private static final Function1<PointerInputChange, Boolean> CanDragCalculation = new Function1<PointerInputChange, Boolean>() { // from class: androidx.compose.foundation.gestures.ScrollableKt$CanDragCalculation$1
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(PointerInputChange pointerInputChange) {
            return Boolean.valueOf(!PointerType.m3556equalsimpl0(pointerInputChange.getType(), PointerType.INSTANCE.m3561getMouseT8wyACA()));
        }
    };
    private static final ScrollScope NoOpScrollScope = new ScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollableKt$NoOpScrollScope$1
        @Override // androidx.compose.foundation.gestures.ScrollScope
        public float scrollBy(float pixels) {
            return pixels;
        }
    };
    private static final MotionDurationScale DefaultScrollMotionDurationScale = new MotionDurationScale() { // from class: androidx.compose.foundation.gestures.ScrollableKt$DefaultScrollMotionDurationScale$1
        @Override // androidx.compose.ui.MotionDurationScale
        public float getScaleFactor() {
            return 1.0f;
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) MotionDurationScale.DefaultImpls.fold(this, r, function2);
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
            return (E) MotionDurationScale.DefaultImpls.get(this, key);
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
            return MotionDurationScale.DefaultImpls.minusKey(this, key);
        }

        @Override // kotlin.coroutines.CoroutineContext
        public CoroutineContext plus(CoroutineContext coroutineContext) {
            return MotionDurationScale.DefaultImpls.plus(this, coroutineContext);
        }
    };
    private static final ScrollableKt$UnityDensity$1 UnityDensity = new Density() { // from class: androidx.compose.foundation.gestures.ScrollableKt$UnityDensity$1
        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return 1.0f;
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float getFontScale() {
            return 1.0f;
        }
    };

    public static /* synthetic */ Modifier scrollable$default(Modifier modifier, ScrollableState scrollableState, Orientation orientation, boolean z, boolean z2, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            z2 = false;
        }
        return scrollable(modifier, scrollableState, orientation, z3, z2, (i & 16) != 0 ? null : flingBehavior, (i & 32) != 0 ? null : mutableInteractionSource);
    }

    public static final Modifier scrollable(Modifier modifier, ScrollableState scrollableState, Orientation orientation, boolean z, boolean z2, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource) {
        return scrollable$default(modifier, scrollableState, orientation, null, z, z2, flingBehavior, mutableInteractionSource, null, 128, null);
    }

    public static /* synthetic */ Modifier scrollable$default(Modifier modifier, ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean z, boolean z2, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec, int i, Object obj) {
        return scrollable(modifier, scrollableState, orientation, overscrollEffect, (i & 8) != 0 ? true : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? null : flingBehavior, (i & 64) != 0 ? null : mutableInteractionSource, (i & 128) != 0 ? null : bringIntoViewSpec);
    }

    public static final Modifier scrollable(Modifier modifier, ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean z, boolean z2, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec) {
        return modifier.then(new ScrollableElement(scrollableState, orientation, overscrollEffect, z, z2, flingBehavior, mutableInteractionSource, bringIntoViewSpec));
    }

    public static final MotionDurationScale getDefaultScrollMotionDurationScale() {
        return DefaultScrollMotionDurationScale;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* renamed from: semanticsScrollBy-d-4ec7I, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m802semanticsScrollByd4ec7I(androidx.compose.foundation.gestures.ScrollingLogic r11, long r12, kotlin.coroutines.Continuation<? super androidx.compose.ui.geometry.Offset> r14) {
        /*
            boolean r0 = r14 instanceof androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1
            if (r0 == 0) goto L14
            r0 = r14
            androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1 r0 = (androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1 r0 = new androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1
            r0.<init>(r14)
        L19:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r11 = r0.L$1
            kotlin.jvm.internal.Ref$FloatRef r11 = (kotlin.jvm.internal.Ref.FloatRef) r11
            java.lang.Object r12 = r0.L$0
            androidx.compose.foundation.gestures.ScrollingLogic r12 = (androidx.compose.foundation.gestures.ScrollingLogic) r12
            kotlin.ResultKt.throwOnFailure(r14)
            r14 = r11
            r11 = r12
            goto L5f
        L34:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3c:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlin.jvm.internal.Ref$FloatRef r14 = new kotlin.jvm.internal.Ref$FloatRef
            r14.<init>()
            androidx.compose.foundation.MutatePriority r2 = androidx.compose.foundation.MutatePriority.Default
            androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2 r10 = new androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2
            r9 = 0
            r4 = r10
            r5 = r11
            r6 = r12
            r8 = r14
            r4.<init>(r5, r6, r8, r9)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r0.L$0 = r11
            r0.L$1 = r14
            r0.label = r3
            java.lang.Object r12 = r11.scroll(r2, r10, r0)
            if (r12 != r1) goto L5f
            return r1
        L5f:
            float r12 = r14.element
            long r11 = r11.m820toOffsettuRUvjQ(r12)
            androidx.compose.ui.geometry.Offset r11 = androidx.compose.ui.geometry.Offset.m2024boximpl(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.m802semanticsScrollByd4ec7I(androidx.compose.foundation.gestures.ScrollingLogic, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
