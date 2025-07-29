package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.gestures.snapping.SnapPositionKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.sentry.protocol.Device;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PagerMeasure.kt */
@Metadata(d1 = {"\u0000¬\u0001\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aH\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002\u001aH\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0015H\u0002\u001a@\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0015H\u0002\u001a\u0017\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0082\b\u001a\u008c\u0001\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e*\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006H\u0002\u001aj\u0010\u0014\u001a\u00020\u0004*\u00020\u001f2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010(\u001a\u00020)2\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\u0006\u0010*\u001a\u00020+2\u0006\u0010/\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001añ\u0001\u0010?\u001a\u00020@*\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u00103\u001a\u0002042\u0006\u0010A\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u0002022\u0006\u0010(\u001a\u00020)2\b\u00109\u001a\u0004\u0018\u00010:2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u0010*\u001a\u00020+2\u0006\u00105\u001a\u0002062\u0006\u0010/\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2/\u0010I\u001a+\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020\u00190\u0015¢\u0006\u0002\bL\u0012\u0004\u0012\u00020M0JH\u0000ø\u0001\u0000¢\u0006\u0004\bN\u0010O\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006P"}, d2 = {"MaxPageOffset", "", "MinPageOffset", "calculateNewCurrentPage", "Landroidx/compose/foundation/pager/MeasuredPage;", "viewportSize", "", "visiblePagesInfo", "", "beforeContentPadding", "afterContentPadding", "itemSize", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageCount", "createPagesAfterList", "currentLastPage", "pagesCount", "beyondViewportPageCount", "pinnedPages", "getAndMeasure", "Lkotlin/Function1;", "createPagesBeforeList", "currentFirstPage", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "calculatePagesOffsets", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "pages", "extraPagesBefore", "extraPagesAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "pagesScrollOffset", Device.JsonKeys.ORIENTATION, "Landroidx/compose/foundation/gestures/Orientation;", "reverseLayout", "", "density", "Landroidx/compose/ui/unit/Density;", "spaceBetweenPages", "pageAvailableSize", FirebaseAnalytics.Param.INDEX, "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "pagerItemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "visualPageOffset", "Landroidx/compose/ui/unit/IntOffset;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", ViewProps.LAYOUT_DIRECTION, "Landroidx/compose/ui/unit/LayoutDirection;", "getAndMeasure-SGf7dI0", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJLandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;JLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZI)Landroidx/compose/foundation/pager/MeasuredPage;", "measurePager", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "mainAxisAvailableSize", "currentPage", "currentPageOffset", "constraints", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measurePager-bmk8ZPk", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;ILandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;IIIIIIJLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Horizontal;ZJIILjava/util/List;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/runtime/MutableState;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/pager/PagerMeasureResult;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PagerMeasureKt {
    public static final float MaxPageOffset = 0.5f;
    public static final float MinPageOffset = -0.5f;

    private static final int calculatePagesOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    private static final void debugLog(Function0<String> function0) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: measurePager-bmk8ZPk, reason: not valid java name */
    public static final PagerMeasureResult m1244measurePagerbmk8ZPk(final LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, final PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, long j, final Orientation orientation, final Alignment.Vertical vertical, final Alignment.Horizontal horizontal, final boolean z, final long j2, final int i8, int i9, List<Integer> list, SnapPosition snapPosition, final MutableState<Unit> mutableState, CoroutineScope coroutineScope, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        MeasuredPage measuredPage;
        int i15;
        long j3;
        int i16;
        List<MeasuredPage> list2;
        ArrayList arrayListEmptyList;
        ArrayList arrayListEmptyList2;
        if (i3 < 0) {
            throw new IllegalArgumentException("negative beforeContentPadding".toString());
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("negative afterContentPadding".toString());
        }
        int i17 = 0;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(i8 + i5, 0);
        if (i <= 0) {
            return new PagerMeasureResult(CollectionsKt.emptyList(), i8, i5, i4, orientation, -i3, i2 + i4, false, i9, null, null, 0.0f, 0, false, snapPosition, function3.invoke(Integer.valueOf(Constraints.m4692getMinWidthimpl(j)), Integer.valueOf(Constraints.m4691getMinHeightimpl(j)), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }), false, null, null, coroutineScope, 393216, null);
        }
        final long jConstraints$default = ConstraintsKt.Constraints$default(0, orientation == Orientation.Vertical ? Constraints.m4690getMaxWidthimpl(j) : i8, 0, orientation != Orientation.Vertical ? Constraints.m4689getMaxHeightimpl(j) : i8, 5, null);
        int i18 = i6;
        int i19 = i7;
        while (i18 > 0 && i19 > 0) {
            i18--;
            i19 -= iCoerceAtLeast;
        }
        int i20 = i19 * (-1);
        if (i18 >= i) {
            i18 = i - 1;
            i20 = 0;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i21 = -i3;
        int i22 = (i5 < 0 ? i5 : 0) + i21;
        int i23 = i20 + i22;
        int iMax = 0;
        while (i23 < 0 && i18 > 0) {
            int i24 = i18 - 1;
            ArrayDeque arrayDeque2 = arrayDeque;
            int i25 = i17;
            int i26 = iCoerceAtLeast;
            MeasuredPage measuredPageM1243getAndMeasureSGf7dI0 = m1243getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i24, jConstraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8);
            arrayDeque2.add(i25, measuredPageM1243getAndMeasureSGf7dI0);
            iMax = Math.max(iMax, measuredPageM1243getAndMeasureSGf7dI0.getCrossAxisSize());
            i23 += i26;
            i18 = i24;
            i22 = i22;
            arrayDeque = arrayDeque2;
            i17 = i25;
            iCoerceAtLeast = i26;
            i21 = i21;
        }
        int i27 = i23;
        int i28 = i21;
        int i29 = i22;
        ArrayDeque arrayDeque3 = arrayDeque;
        int i30 = i17;
        int i31 = iCoerceAtLeast;
        int i32 = (i27 < i29 ? i29 : i27) - i29;
        int i33 = i2 + i4;
        int iCoerceAtLeast2 = RangesKt.coerceAtLeast(i33, i30);
        int i34 = -i32;
        int i35 = i30;
        int i36 = i35;
        int i37 = i18;
        while (i35 < arrayDeque3.size()) {
            if (i34 >= iCoerceAtLeast2) {
                arrayDeque3.remove(i35);
                i36 = 1;
            } else {
                i37++;
                i34 += i31;
                i35++;
            }
        }
        int i38 = i18;
        int i39 = i32;
        int i40 = i36;
        int i41 = i37;
        int i42 = i34;
        while (i41 < i && (i42 < iCoerceAtLeast2 || i42 <= 0 || arrayDeque3.isEmpty())) {
            int i43 = i33;
            int i44 = i41;
            int i45 = i38;
            int i46 = iCoerceAtLeast2;
            int i47 = i42;
            int i48 = i31;
            MeasuredPage measuredPageM1243getAndMeasureSGf7dI02 = m1243getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i41, jConstraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8);
            int i49 = i - 1;
            i42 = (i44 == i49 ? i8 : i48) + i47;
            if (i42 > i29 || i44 == i49) {
                iMax = Math.max(iMax, measuredPageM1243getAndMeasureSGf7dI02.getCrossAxisSize());
                arrayDeque3.add(measuredPageM1243getAndMeasureSGf7dI02);
                i38 = i45;
            } else {
                i39 -= i48;
                i38 = i44 + 1;
                i40 = 1;
            }
            i41 = i44 + 1;
            i33 = i43;
            i31 = i48;
            iCoerceAtLeast2 = i46;
        }
        int i50 = i38;
        int i51 = i33;
        int i52 = i41;
        int i53 = i42;
        int i54 = i31;
        if (i53 < i2) {
            int i55 = i2 - i53;
            int i56 = i39 - i55;
            int i57 = i55 + i53;
            int i58 = i3;
            i14 = i50;
            int i59 = i54;
            int i60 = i56;
            while (i60 < i58 && i14 > 0) {
                i14--;
                int i61 = i59;
                MeasuredPage measuredPageM1243getAndMeasureSGf7dI03 = m1243getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i14, jConstraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8);
                arrayDeque3.add(0, measuredPageM1243getAndMeasureSGf7dI03);
                iMax = Math.max(iMax, measuredPageM1243getAndMeasureSGf7dI03.getCrossAxisSize());
                i60 += i61;
                i58 = i3;
                i59 = i61;
            }
            i10 = i59;
            i11 = 0;
            if (i60 < 0) {
                i12 = i57 + i60;
                i13 = 0;
            } else {
                i13 = i60;
                i12 = i57;
            }
        } else {
            i10 = i54;
            i11 = 0;
            i12 = i53;
            i13 = i39;
            i14 = i50;
        }
        if (i13 < 0) {
            throw new IllegalArgumentException("invalid currentFirstPageScrollOffset".toString());
        }
        int i62 = -i13;
        MeasuredPage measuredPage2 = (MeasuredPage) arrayDeque3.first();
        if (i3 > 0 || i5 < 0) {
            int size = arrayDeque3.size();
            int i63 = i13;
            int i64 = i11;
            while (i64 < size && i63 != 0 && i10 <= i63 && i64 != CollectionsKt.getLastIndex(arrayDeque3)) {
                i63 -= i10;
                i64++;
                measuredPage2 = (MeasuredPage) arrayDeque3.get(i64);
            }
            measuredPage = measuredPage2;
            i15 = i63;
        } else {
            i15 = i13;
            measuredPage = measuredPage2;
        }
        MeasuredPage measuredPage3 = measuredPage;
        int i65 = i11;
        List<MeasuredPage> listCreatePagesBeforeList = createPagesBeforeList(i14, i9, list, new Function1<Integer, MeasuredPage>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesBefore$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MeasuredPage invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final MeasuredPage invoke(int i66) {
                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                return PagerMeasureKt.m1243getAndMeasureSGf7dI0(lazyLayoutMeasureScope2, i66, jConstraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope2.getLayoutDirection(), z, i8);
            }
        });
        int size2 = listCreatePagesBeforeList.size();
        for (int i66 = i65; i66 < size2; i66++) {
            iMax = Math.max(iMax, listCreatePagesBeforeList.get(i66).getCrossAxisSize());
        }
        int i67 = iMax;
        int i68 = i10;
        List<MeasuredPage> listCreatePagesAfterList = createPagesAfterList(((MeasuredPage) arrayDeque3.last()).getIndex(), i, i9, list, new Function1<Integer, MeasuredPage>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesAfter$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MeasuredPage invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final MeasuredPage invoke(int i69) {
                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                return PagerMeasureKt.m1243getAndMeasureSGf7dI0(lazyLayoutMeasureScope2, i69, jConstraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope2.getLayoutDirection(), z, i8);
            }
        });
        int size3 = listCreatePagesAfterList.size();
        int iMax2 = i67;
        for (int i69 = i65; i69 < size3; i69++) {
            iMax2 = Math.max(iMax2, listCreatePagesAfterList.get(i69).getCrossAxisSize());
        }
        int i70 = (Intrinsics.areEqual(measuredPage3, arrayDeque3.first()) && listCreatePagesBeforeList.isEmpty() && listCreatePagesAfterList.isEmpty()) ? 1 : i65;
        if (orientation == Orientation.Vertical) {
            j3 = j;
            i16 = iMax2;
        } else {
            j3 = j;
            i16 = i12;
        }
        int iM4707constrainWidthK40F9xA = ConstraintsKt.m4707constrainWidthK40F9xA(j3, i16);
        if (orientation == Orientation.Vertical) {
            iMax2 = i12;
        }
        int iM4706constrainHeightK40F9xA = ConstraintsKt.m4706constrainHeightK40F9xA(j3, iMax2);
        final List<MeasuredPage> listCalculatePagesOffsets = calculatePagesOffsets(lazyLayoutMeasureScope, arrayDeque3, listCreatePagesBeforeList, listCreatePagesAfterList, iM4707constrainWidthK40F9xA, iM4706constrainHeightK40F9xA, i12, i2, i62, orientation, z, lazyLayoutMeasureScope, i5, i8);
        if (i70 != 0) {
            list2 = listCalculatePagesOffsets;
        } else {
            ArrayList arrayList = new ArrayList(listCalculatePagesOffsets.size());
            int size4 = listCalculatePagesOffsets.size();
            for (int i71 = i65; i71 < size4; i71++) {
                MeasuredPage measuredPage4 = listCalculatePagesOffsets.get(i71);
                MeasuredPage measuredPage5 = measuredPage4;
                if (measuredPage5.getIndex() >= ((MeasuredPage) arrayDeque3.first()).getIndex() && measuredPage5.getIndex() <= ((MeasuredPage) arrayDeque3.last()).getIndex()) {
                    arrayList.add(measuredPage4);
                }
            }
            list2 = arrayList;
        }
        if (listCreatePagesBeforeList.isEmpty()) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else {
            ArrayList arrayList2 = new ArrayList(listCalculatePagesOffsets.size());
            int size5 = listCalculatePagesOffsets.size();
            for (int i72 = i65; i72 < size5; i72++) {
                MeasuredPage measuredPage6 = listCalculatePagesOffsets.get(i72);
                if (measuredPage6.getIndex() < ((MeasuredPage) arrayDeque3.first()).getIndex()) {
                    arrayList2.add(measuredPage6);
                }
            }
            arrayListEmptyList = arrayList2;
        }
        List list3 = arrayListEmptyList;
        if (listCreatePagesAfterList.isEmpty()) {
            arrayListEmptyList2 = CollectionsKt.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(listCalculatePagesOffsets.size());
            int size6 = listCalculatePagesOffsets.size();
            for (int i73 = i65; i73 < size6; i73++) {
                MeasuredPage measuredPage7 = listCalculatePagesOffsets.get(i73);
                if (measuredPage7.getIndex() > ((MeasuredPage) arrayDeque3.last()).getIndex()) {
                    arrayList3.add(measuredPage7);
                }
            }
            arrayListEmptyList2 = arrayList3;
        }
        List list4 = arrayListEmptyList2;
        int i74 = i12;
        MeasuredPage measuredPageCalculateNewCurrentPage = calculateNewCurrentPage(orientation == Orientation.Vertical ? iM4706constrainHeightK40F9xA : iM4707constrainWidthK40F9xA, list2, i3, i4, i68, snapPosition, i);
        return new PagerMeasureResult(list2, i8, i5, i4, orientation, i28, i51, z, i9, measuredPage3, measuredPageCalculateNewCurrentPage, i68 == 0 ? 0.0f : RangesKt.coerceIn((snapPosition.position(i2, i8, i3, i4, measuredPageCalculateNewCurrentPage != null ? measuredPageCalculateNewCurrentPage.getIndex() : i65, i) - (measuredPageCalculateNewCurrentPage != null ? measuredPageCalculateNewCurrentPage.getOffset() : i65)) / i68, -0.5f, 0.5f), i15, (i52 < i || i74 > i2) ? 1 : i65, snapPosition, function3.invoke(Integer.valueOf(iM4707constrainWidthK40F9xA), Integer.valueOf(iM4706constrainHeightK40F9xA), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                List<MeasuredPage> list5 = listCalculatePagesOffsets;
                int size7 = list5.size();
                for (int i75 = 0; i75 < size7; i75++) {
                    list5.get(i75).place(placementScope);
                }
                ObservableScopeInvalidator.m1176attachToScopeimpl(mutableState);
            }
        }), i40, list3, list4, coroutineScope);
    }

    private static final List<MeasuredPage> createPagesAfterList(int i, int i2, int i3, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        int iMin = Math.min(i3 + i, i2 - 1);
        int i4 = i + 1;
        ArrayList arrayList = null;
        if (i4 <= iMin) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(i4)));
                if (i4 == iMin) {
                    break;
                }
                i4++;
            }
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            int iIntValue = list.get(i5).intValue();
            if (iMin + 1 <= iIntValue && iIntValue < i2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(iIntValue)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<MeasuredPage> createPagesBeforeList(int i, int i2, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        int iMax = Math.max(0, i - i2);
        int i3 = i - 1;
        ArrayList arrayList = null;
        if (iMax <= i3) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(i3)));
                if (i3 == iMax) {
                    break;
                }
                i3--;
            }
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            int iIntValue = list.get(i4).intValue();
            if (iIntValue < iMax) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(iIntValue)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAndMeasure-SGf7dI0, reason: not valid java name */
    public static final MeasuredPage m1243getAndMeasureSGf7dI0(LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, long j, PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, long j2, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z, int i2) {
        return new MeasuredPage(i, i2, lazyLayoutMeasureScope.mo1173measure0kLqBqw(i, j), j2, pagerLazyLayoutItemProvider.getKey(i), orientation, horizontal, vertical, layoutDirection, z, null);
    }

    private static final List<MeasuredPage> calculatePagesOffsets(LazyLayoutMeasureScope lazyLayoutMeasureScope, List<MeasuredPage> list, List<MeasuredPage> list2, List<MeasuredPage> list3, int i, int i2, int i3, int i4, int i5, Orientation orientation, boolean z, Density density, int i6, int i7) {
        int i8;
        int i9;
        int i10 = i5;
        int i11 = i7 + i6;
        if (orientation == Orientation.Vertical) {
            i8 = i4;
            i9 = i2;
        } else {
            i8 = i4;
            i9 = i;
        }
        boolean z2 = i3 < Math.min(i9, i8);
        if (z2 && i10 != 0) {
            throw new IllegalStateException(("non-zero pagesScrollOffset=" + i10).toString());
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
        if (z2) {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("No extra pages".toString());
            }
            int size = list.size();
            int[] iArr = new int[size];
            for (int i12 = 0; i12 < size; i12++) {
                iArr[i12] = i7;
            }
            int[] iArr2 = new int[size];
            for (int i13 = 0; i13 < size; i13++) {
                iArr2[i13] = 0;
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalM885spacedBy0680j_4 = Arrangement.Absolute.INSTANCE.m885spacedBy0680j_4(lazyLayoutMeasureScope.mo691toDpu2uoSUM(i6));
            if (orientation == Orientation.Vertical) {
                horizontalOrVerticalM885spacedBy0680j_4.arrange(density, i9, iArr, iArr2);
            } else {
                horizontalOrVerticalM885spacedBy0680j_4.arrange(density, i9, iArr, LayoutDirection.Ltr, iArr2);
            }
            IntRange indices = ArraysKt.getIndices(iArr2);
            if (z) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int size2 = iArr2[first];
                    MeasuredPage measuredPage = list.get(calculatePagesOffsets$reverseAware(first, z, size));
                    if (z) {
                        size2 = (i9 - size2) - measuredPage.getSize();
                    }
                    measuredPage.position(size2, i, i2);
                    arrayList.add(measuredPage);
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int size3 = list2.size();
            int i14 = i10;
            for (int i15 = 0; i15 < size3; i15++) {
                MeasuredPage measuredPage2 = list2.get(i15);
                i14 -= i11;
                measuredPage2.position(i14, i, i2);
                arrayList.add(measuredPage2);
            }
            int size4 = list.size();
            for (int i16 = 0; i16 < size4; i16++) {
                MeasuredPage measuredPage3 = list.get(i16);
                measuredPage3.position(i10, i, i2);
                arrayList.add(measuredPage3);
                i10 += i11;
            }
            int size5 = list3.size();
            for (int i17 = 0; i17 < size5; i17++) {
                MeasuredPage measuredPage4 = list3.get(i17);
                measuredPage4.position(i10, i, i2);
                arrayList.add(measuredPage4);
                i10 += i11;
            }
        }
        return arrayList;
    }

    private static final MeasuredPage calculateNewCurrentPage(int i, List<MeasuredPage> list, int i2, int i3, int i4, SnapPosition snapPosition, int i5) {
        MeasuredPage measuredPage;
        if (list.isEmpty()) {
            measuredPage = null;
        } else {
            MeasuredPage measuredPage2 = list.get(0);
            MeasuredPage measuredPage3 = measuredPage2;
            float f = -Math.abs(SnapPositionKt.calculateDistanceToDesiredSnapPosition(i, i2, i3, i4, measuredPage3.getOffset(), measuredPage3.getIndex(), snapPosition, i5));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i6 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    MeasuredPage measuredPage4 = list.get(i6);
                    MeasuredPage measuredPage5 = measuredPage4;
                    float f2 = -Math.abs(SnapPositionKt.calculateDistanceToDesiredSnapPosition(i, i2, i3, i4, measuredPage5.getOffset(), measuredPage5.getIndex(), snapPosition, i5));
                    if (Float.compare(f, f2) < 0) {
                        measuredPage2 = measuredPage4;
                        f = f2;
                    }
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
            measuredPage = measuredPage2;
        }
        return measuredPage;
    }
}
