package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.react.uimanager.ViewProps;
import com.nimbusds.jose.jwk.gen.OctetSequenceKeyGenerator;
import io.sentry.protocol.Device;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyStaggeredGridMeasurePolicy.kt */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u007f\u0010\u0000\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\b\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a)\u0010\u001c\u001a\u00020\u0012*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010\u001f\u001a)\u0010 \u001a\u00020\u0012*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010\u001f\u001a!\u0010!\u001a\u00020\u0012*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010\"\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"rememberStaggeredGridMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "Lkotlin/ExtensionFunctionType;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", Device.JsonKeys.ORIENTATION, "Landroidx/compose/foundation/gestures/Orientation;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "rememberStaggeredGridMeasurePolicy-qKj4JfE", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;FFLkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "afterPadding", ViewProps.LAYOUT_DIRECTION, "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/unit/LayoutDirection;)F", "beforePadding", "startPadding", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/unit/LayoutDirection;)F", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyStaggeredGridMeasurePolicyKt {

    /* compiled from: LazyStaggeredGridMeasurePolicy.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: rememberStaggeredGridMeasurePolicy-qKj4JfE, reason: not valid java name */
    public static final Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> m1214rememberStaggeredGridMeasurePolicyqKj4JfE(final LazyStaggeredGridState lazyStaggeredGridState, final Function0<? extends LazyStaggeredGridItemProvider> function0, final PaddingValues paddingValues, final boolean z, final Orientation orientation, final float f, float f2, final CoroutineScope coroutineScope, final LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider, final GraphicsContext graphicsContext, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1630140849, "C(rememberStaggeredGridMeasurePolicy)P(9,4!1,7,6,5:c#ui.unit.Dp,2:c#ui.unit.Dp!1,8)50@2173L2923:LazyStaggeredGridMeasurePolicy.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1630140849, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridMeasurePolicy (LazyStaggeredGridMeasurePolicy.kt:50)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1650675918, "CC(remember):LazyStaggeredGridMeasurePolicy.kt#9igjgp");
        boolean zChanged = composer.changed(lazyStaggeredGridState) | ((((i & OctetSequenceKeyGenerator.MIN_KEY_SIZE_BITS) ^ 48) > 32 && composer.changed(function0)) || (i & 48) == 32) | ((((i & 896) ^ BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT) > 256 && composer.changed(paddingValues)) || (i & BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT) == 256) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(z)) || (i & 3072) == 2048) | ((((57344 & i) ^ 24576) > 16384 && composer.changed(orientation)) || (i & 24576) == 16384) | ((((458752 & i) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072 && composer.changed(f)) || (i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | ((((3670016 & i) ^ 1572864) > 1048576 && composer.changed(f2)) || (i & 1572864) == 1048576) | ((((234881024 & i) ^ 100663296) > 67108864 && composer.changed(lazyGridStaggeredGridSlotsProvider)) || (i & 100663296) == 67108864) | composer.changed(graphicsContext);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyStaggeredGridMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m1215invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                }

                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyStaggeredGridMeasureResult m1215invoke0kLqBqw(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
                    long jIntOffset;
                    ObservableScopeInvalidator.m1176attachToScopeimpl(lazyStaggeredGridState.m1220getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                    CheckScrollableContainerConstraintsKt.m585checkScrollableContainerConstraintsK40F9xA(j, orientation);
                    LazyStaggeredGridSlots lazyStaggeredGridSlotsMo1196invoke0kLqBqw = lazyGridStaggeredGridSlotsProvider.mo1196invoke0kLqBqw(lazyLayoutMeasureScope, j);
                    boolean z2 = orientation == Orientation.Vertical;
                    LazyStaggeredGridItemProvider lazyStaggeredGridItemProviderInvoke = function0.invoke();
                    int i2 = lazyLayoutMeasureScope.mo688roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.beforePadding(paddingValues, orientation, z, lazyLayoutMeasureScope.getLayoutDirection()));
                    int i3 = lazyLayoutMeasureScope.mo688roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.afterPadding(paddingValues, orientation, z, lazyLayoutMeasureScope.getLayoutDirection()));
                    int i4 = lazyLayoutMeasureScope.mo688roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.startPadding(paddingValues, orientation, lazyLayoutMeasureScope.getLayoutDirection()));
                    int iM4689getMaxHeightimpl = ((z2 ? Constraints.m4689getMaxHeightimpl(j) : Constraints.m4690getMaxWidthimpl(j)) - i2) - i3;
                    if (z2) {
                        jIntOffset = IntOffsetKt.IntOffset(i4, i2);
                    } else {
                        jIntOffset = IntOffsetKt.IntOffset(i2, i4);
                    }
                    long j2 = jIntOffset;
                    PaddingValues paddingValues2 = paddingValues;
                    int i5 = lazyLayoutMeasureScope.mo688roundToPx0680j_4(Dp.m4737constructorimpl(PaddingKt.calculateStartPadding(paddingValues2, lazyLayoutMeasureScope.getLayoutDirection()) + PaddingKt.calculateEndPadding(paddingValues2, lazyLayoutMeasureScope.getLayoutDirection())));
                    PaddingValues paddingValues3 = paddingValues;
                    boolean z3 = z2;
                    LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResultM1213measureStaggeredGridXtK8cYQ = LazyStaggeredGridMeasureKt.m1213measureStaggeredGridXtK8cYQ(lazyLayoutMeasureScope, lazyStaggeredGridState, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyStaggeredGridItemProviderInvoke, lazyStaggeredGridState.getPinnedItems(), lazyStaggeredGridState.getBeyondBoundsInfo()), lazyStaggeredGridItemProviderInvoke, lazyStaggeredGridSlotsMo1196invoke0kLqBqw, Constraints.m4681copyZbe2FdA$default(j, ConstraintsKt.m4707constrainWidthK40F9xA(j, i5), 0, ConstraintsKt.m4706constrainHeightK40F9xA(j, lazyLayoutMeasureScope.mo688roundToPx0680j_4(Dp.m4737constructorimpl(paddingValues3.getTop() + paddingValues3.getBottom()))), 0, 10, null), z3, z, j2, iM4689getMaxHeightimpl, lazyLayoutMeasureScope.mo688roundToPx0680j_4(f), i2, i3, coroutineScope, graphicsContext);
                    LazyStaggeredGridState.applyMeasureResult$foundation_release$default(lazyStaggeredGridState, lazyStaggeredGridMeasureResultM1213measureStaggeredGridXtK8cYQ, false, 2, null);
                    return lazyStaggeredGridMeasureResultM1213measureStaggeredGridXtK8cYQ;
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> function2 = (Function2) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float startPadding(PaddingValues paddingValues, Orientation orientation, LayoutDirection layoutDirection) {
        int i = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i == 1) {
            return PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
        }
        if (i == 2) {
            return paddingValues.getTop();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float beforePadding(PaddingValues paddingValues, Orientation orientation, boolean z, LayoutDirection layoutDirection) {
        int i = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i == 1) {
            return z ? paddingValues.getBottom() : paddingValues.getTop();
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (z) {
            return PaddingKt.calculateEndPadding(paddingValues, layoutDirection);
        }
        return PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float afterPadding(PaddingValues paddingValues, Orientation orientation, boolean z, LayoutDirection layoutDirection) {
        int i = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i == 1) {
            return z ? paddingValues.getTop() : paddingValues.getBottom();
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (z) {
            return PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
        }
        return PaddingKt.calculateEndPadding(paddingValues, layoutDirection);
    }
}
