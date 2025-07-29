package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyGridMeasure.kt */
@Metadata(d1 = {"\u0000¦\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\u001aA\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nH\u0083\b\u001a\u008c\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002\u001a¸\u0002\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020-2\u0006\u0010.\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020423\u00105\u001a/\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020+090\u00010\n2/\u0010:\u001a+\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020=0\n¢\u0006\u0002\b>\u0012\u0004\u0012\u00020?0;H\u0000ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a+\u0010B\u001a\u00020=\"\u0004\b\u0000\u0010C*\b\u0012\u0004\u0012\u0002HC0\r2\f\u0010D\u001a\b\u0012\u0004\u0012\u0002HC0EH\u0002¢\u0006\u0002\u0010F\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006G"}, d2 = {"calculateExtraItems", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "pinnedItems", "", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", ViewProps.FILTER, "Lkotlin/Function1;", "", "calculateItemsOffsets", "", "lines", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "itemsBefore", "itemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "firstLineScrollOffset", "isVertical", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "measureLazyGrid", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "itemsCount", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenLines", "firstVisibleLineIndex", "firstVisibleLineScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "slotsPerLine", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "prefetchInfoRetriever", "Lkotlin/ParameterName;", "name", "line", "Lkotlin/Pair;", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyGrid-OZKpZRA", "(ILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "addAllFromArray", ExifInterface.GPS_DIRECTION_TRUE, "arr", "", "(Ljava/util/List;[Ljava/lang/Object;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridMeasureKt {
    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* renamed from: measureLazyGrid-OZKpZRA, reason: not valid java name */
    public static final LazyGridMeasureResult m1143measureLazyGridOZKpZRA(int i, LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density, LazyLayoutItemAnimator<LazyGridMeasuredItem> lazyLayoutItemAnimator, int i8, List<Integer> list, CoroutineScope coroutineScope, final MutableState<Unit> mutableState, GraphicsContext graphicsContext, Function1<? super Integer, ? extends List<Pair<Integer, Constraints>>> function1, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        boolean z3;
        int i9;
        int i10;
        int i11;
        int index;
        int i12;
        LazyGridMeasuredLine lazyGridMeasuredLine;
        int iM4707constrainWidthK40F9xA;
        int iM4689getMaxHeightimpl;
        int iM4706constrainHeightK40F9xA;
        int i13;
        List<LazyGridMeasuredItem> list2;
        int i14;
        int i15;
        int i16;
        int i17;
        float f2;
        int i18;
        int i19;
        int i20;
        LazyGridMeasuredItem[] items;
        LazyGridMeasuredItem lazyGridMeasuredItem;
        int i21;
        int i22;
        if (i3 < 0) {
            throw new IllegalArgumentException("negative beforeContentPadding".toString());
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("negative afterContentPadding".toString());
        }
        if (i <= 0) {
            int iM4692getMinWidthimpl = Constraints.m4692getMinWidthimpl(j);
            int iM4691getMinHeightimpl = Constraints.m4691getMinHeightimpl(j);
            lazyLayoutItemAnimator.onMeasured(0, iM4692getMinWidthimpl, iM4691getMinHeightimpl, new ArrayList(), lazyGridMeasuredItemProvider.getKeyIndexMap(), lazyGridMeasuredItemProvider, z, false, i8, false, 0, 0, coroutineScope, graphicsContext);
            long jM1167getMinSizeToFitDisappearingItemsYbymL2g = lazyLayoutItemAnimator.m1167getMinSizeToFitDisappearingItemsYbymL2g();
            if (!IntSize.m4905equalsimpl0(jM1167getMinSizeToFitDisappearingItemsYbymL2g, IntSize.INSTANCE.m4912getZeroYbymL2g())) {
                iM4692getMinWidthimpl = ConstraintsKt.m4707constrainWidthK40F9xA(j, IntSize.m4907getWidthimpl(jM1167getMinSizeToFitDisappearingItemsYbymL2g));
                iM4691getMinHeightimpl = ConstraintsKt.m4706constrainHeightK40F9xA(j, IntSize.m4906getHeightimpl(jM1167getMinSizeToFitDisappearingItemsYbymL2g));
            }
            return new LazyGridMeasureResult(null, 0, false, 0.0f, function3.invoke(Integer.valueOf(iM4692getMinWidthimpl), Integer.valueOf(iM4691getMinHeightimpl), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }), false, coroutineScope, density, i8, function1, CollectionsKt.emptyList(), -i3, i2 + i4, 0, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
        }
        int iRound = Math.round(f);
        int i23 = i7 - iRound;
        if (i6 == 0 && i23 < 0) {
            iRound += i23;
            i23 = 0;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i24 = -i3;
        int i25 = (i5 < 0 ? i5 : 0) + i24;
        int mainAxisSizeWithSpacings = i23 + i25;
        int i26 = i6;
        while (mainAxisSizeWithSpacings < 0 && i26 > 0) {
            i26--;
            LazyGridMeasuredLine andMeasure = lazyGridMeasuredLineProvider.getAndMeasure(i26);
            arrayDeque.add(0, andMeasure);
            mainAxisSizeWithSpacings += andMeasure.getMainAxisSizeWithSpacings();
        }
        if (mainAxisSizeWithSpacings < i25) {
            iRound += mainAxisSizeWithSpacings;
            mainAxisSizeWithSpacings = i25;
        }
        int i27 = mainAxisSizeWithSpacings - i25;
        int i28 = i2 + i4;
        int i29 = i26;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(i28, 0);
        int i30 = i29;
        int mainAxisSizeWithSpacings2 = i27;
        int i31 = i24;
        int mainAxisSizeWithSpacings3 = -i27;
        int i32 = 0;
        boolean z4 = false;
        while (true) {
            z3 = true;
            if (i32 >= arrayDeque.size()) {
                break;
            }
            if (mainAxisSizeWithSpacings3 >= iCoerceAtLeast) {
                arrayDeque.remove(i32);
                z4 = true;
            } else {
                i30++;
                mainAxisSizeWithSpacings3 += ((LazyGridMeasuredLine) arrayDeque.get(i32)).getMainAxisSizeWithSpacings();
                i32++;
            }
        }
        int mainAxisSizeWithSpacings4 = mainAxisSizeWithSpacings3;
        boolean z5 = z4;
        int i33 = i30;
        int i34 = i29;
        while (i33 < i && (mainAxisSizeWithSpacings4 < iCoerceAtLeast || mainAxisSizeWithSpacings4 <= 0 || arrayDeque.isEmpty())) {
            int i35 = iCoerceAtLeast;
            LazyGridMeasuredLine andMeasure2 = lazyGridMeasuredLineProvider.getAndMeasure(i33);
            if (andMeasure2.isEmpty()) {
                break;
            }
            mainAxisSizeWithSpacings4 += andMeasure2.getMainAxisSizeWithSpacings();
            if (mainAxisSizeWithSpacings4 <= i25) {
                i21 = i25;
                i22 = i34;
                if (((LazyGridMeasuredItem) ArraysKt.last(andMeasure2.getItems())).getIndex() != i - 1) {
                    mainAxisSizeWithSpacings2 -= andMeasure2.getMainAxisSizeWithSpacings();
                    i34 = i33 + 1;
                    z5 = true;
                }
                i33++;
                iCoerceAtLeast = i35;
                i25 = i21;
            } else {
                i21 = i25;
                i22 = i34;
            }
            arrayDeque.add(andMeasure2);
            i34 = i22;
            i33++;
            iCoerceAtLeast = i35;
            i25 = i21;
        }
        int i36 = i34;
        if (mainAxisSizeWithSpacings4 < i2) {
            int i37 = i2 - mainAxisSizeWithSpacings4;
            int i38 = mainAxisSizeWithSpacings4 + i37;
            int i39 = i36;
            int mainAxisSizeWithSpacings5 = mainAxisSizeWithSpacings2 - i37;
            while (mainAxisSizeWithSpacings5 < i3 && i39 > 0) {
                int i40 = i39 - 1;
                LazyGridMeasuredLine andMeasure3 = lazyGridMeasuredLineProvider.getAndMeasure(i40);
                arrayDeque.add(0, andMeasure3);
                mainAxisSizeWithSpacings5 += andMeasure3.getMainAxisSizeWithSpacings();
                i39 = i40;
            }
            iRound += i37;
            if (mainAxisSizeWithSpacings5 < 0) {
                iRound += mainAxisSizeWithSpacings5;
                i9 = i38 + mainAxisSizeWithSpacings5;
                i10 = 0;
            } else {
                i9 = i38;
                i10 = mainAxisSizeWithSpacings5;
            }
        } else {
            i9 = mainAxisSizeWithSpacings4;
            i10 = mainAxisSizeWithSpacings2;
        }
        float f3 = (MathKt.getSign(Math.round(f)) != MathKt.getSign(iRound) || Math.abs(Math.round(f)) < Math.abs(iRound)) ? f : iRound;
        if (i10 < 0) {
            throw new IllegalArgumentException("negative initial offset".toString());
        }
        int i41 = -i10;
        LazyGridMeasuredLine lazyGridMeasuredLine2 = (LazyGridMeasuredLine) arrayDeque.first();
        LazyGridMeasuredItem lazyGridMeasuredItem2 = (LazyGridMeasuredItem) ArraysKt.firstOrNull(lazyGridMeasuredLine2.getItems());
        int index2 = lazyGridMeasuredItem2 != null ? lazyGridMeasuredItem2.getIndex() : 0;
        LazyGridMeasuredLine lazyGridMeasuredLine3 = (LazyGridMeasuredLine) arrayDeque.lastOrNull();
        if (lazyGridMeasuredLine3 == null || (items = lazyGridMeasuredLine3.getItems()) == null || (lazyGridMeasuredItem = (LazyGridMeasuredItem) ArraysKt.lastOrNull(items)) == null) {
            i11 = i41;
            index = 0;
        } else {
            index = lazyGridMeasuredItem.getIndex();
            i11 = i41;
        }
        int size = list.size();
        ArrayList arrayListEmptyList = null;
        List listEmptyList = null;
        int i42 = 0;
        while (i42 < size) {
            int i43 = size;
            int iIntValue = list.get(i42).intValue();
            if (iIntValue < 0 || iIntValue >= index2) {
                i15 = i43;
                i16 = index;
                i17 = index2;
                f2 = f3;
                i18 = i28;
                i19 = i31;
                i20 = i10;
            } else {
                float f4 = f3;
                int iSpanOf = lazyGridMeasuredLineProvider.spanOf(iIntValue);
                i16 = index;
                i17 = index2;
                i15 = i43;
                f2 = f4;
                i18 = i28;
                i19 = i31;
                i20 = i10;
                LazyGridMeasuredItem lazyGridMeasuredItemMo1116getAndMeasurehBUhpc = lazyGridMeasuredItemProvider.mo1116getAndMeasurehBUhpc(iIntValue, 0, iSpanOf, lazyGridMeasuredLineProvider.m1147childConstraintsJhjzzOo$foundation_release(0, iSpanOf));
                ArrayList arrayList = listEmptyList == null ? new ArrayList() : listEmptyList;
                arrayList.add(lazyGridMeasuredItemMo1116getAndMeasurehBUhpc);
                listEmptyList = arrayList;
            }
            i42++;
            index = i16;
            i10 = i20;
            size = i15;
            index2 = i17;
            f3 = f2;
            i31 = i19;
            i28 = i18;
        }
        int i44 = index;
        int i45 = index2;
        float f5 = f3;
        int i46 = i28;
        int i47 = i31;
        int i48 = i10;
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        List list3 = listEmptyList;
        int size2 = list.size();
        int i49 = 0;
        while (i49 < size2) {
            int iIntValue2 = list.get(i49).intValue();
            if (i44 + 1 > iIntValue2 || iIntValue2 >= i) {
                i14 = i49;
            } else {
                int iSpanOf2 = lazyGridMeasuredLineProvider.spanOf(iIntValue2);
                i14 = i49;
                LazyGridMeasuredItem lazyGridMeasuredItemMo1116getAndMeasurehBUhpc2 = lazyGridMeasuredItemProvider.mo1116getAndMeasurehBUhpc(iIntValue2, 0, iSpanOf2, lazyGridMeasuredLineProvider.m1147childConstraintsJhjzzOo$foundation_release(0, iSpanOf2));
                if (arrayListEmptyList == null) {
                    arrayListEmptyList = new ArrayList();
                }
                List list4 = arrayListEmptyList;
                list4.add(lazyGridMeasuredItemMo1116getAndMeasurehBUhpc2);
                arrayListEmptyList = list4;
            }
            i49 = i14 + 1;
        }
        if (arrayListEmptyList == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        List list5 = arrayListEmptyList;
        if (i3 > 0 || i5 < 0) {
            int size3 = arrayDeque.size();
            int i50 = i48;
            int i51 = 0;
            while (i51 < size3) {
                int mainAxisSizeWithSpacings6 = ((LazyGridMeasuredLine) arrayDeque.get(i51)).getMainAxisSizeWithSpacings();
                if (i50 == 0 || mainAxisSizeWithSpacings6 > i50 || i51 == CollectionsKt.getLastIndex(arrayDeque)) {
                    break;
                }
                i50 -= mainAxisSizeWithSpacings6;
                i51++;
                lazyGridMeasuredLine2 = (LazyGridMeasuredLine) arrayDeque.get(i51);
            }
            i12 = i50;
            lazyGridMeasuredLine = lazyGridMeasuredLine2;
        } else {
            lazyGridMeasuredLine = lazyGridMeasuredLine2;
            i12 = i48;
        }
        if (z) {
            iM4707constrainWidthK40F9xA = Constraints.m4690getMaxWidthimpl(j);
        } else {
            iM4707constrainWidthK40F9xA = ConstraintsKt.m4707constrainWidthK40F9xA(j, i9);
        }
        int i52 = iM4707constrainWidthK40F9xA;
        if (z) {
            iM4689getMaxHeightimpl = ConstraintsKt.m4706constrainHeightK40F9xA(j, i9);
        } else {
            iM4689getMaxHeightimpl = Constraints.m4689getMaxHeightimpl(j);
        }
        int i53 = iM4689getMaxHeightimpl;
        int i54 = i9;
        final List<LazyGridMeasuredItem> listCalculateItemsOffsets = calculateItemsOffsets(arrayDeque, list3, list5, i52, i53, i54, i2, i11, z, vertical, horizontal, z2, density);
        lazyLayoutItemAnimator.onMeasured((int) f5, i52, i53, listCalculateItemsOffsets, lazyGridMeasuredItemProvider.getKeyIndexMap(), lazyGridMeasuredItemProvider, z, false, i8, false, i12, i54, coroutineScope, graphicsContext);
        long jM1167getMinSizeToFitDisappearingItemsYbymL2g2 = lazyLayoutItemAnimator.m1167getMinSizeToFitDisappearingItemsYbymL2g();
        if (IntSize.m4905equalsimpl0(jM1167getMinSizeToFitDisappearingItemsYbymL2g2, IntSize.INSTANCE.m4912getZeroYbymL2g())) {
            iM4706constrainHeightK40F9xA = i53;
            i13 = i52;
        } else {
            int i55 = z ? i53 : i52;
            int iM4707constrainWidthK40F9xA2 = ConstraintsKt.m4707constrainWidthK40F9xA(j, Math.max(i52, IntSize.m4907getWidthimpl(jM1167getMinSizeToFitDisappearingItemsYbymL2g2)));
            iM4706constrainHeightK40F9xA = ConstraintsKt.m4706constrainHeightK40F9xA(j, Math.max(i53, IntSize.m4906getHeightimpl(jM1167getMinSizeToFitDisappearingItemsYbymL2g2)));
            int i56 = z ? iM4706constrainHeightK40F9xA : iM4707constrainWidthK40F9xA2;
            if (i56 != i55) {
                int size4 = listCalculateItemsOffsets.size();
                for (int i57 = 0; i57 < size4; i57++) {
                    listCalculateItemsOffsets.get(i57).updateMainAxisLayoutSize(i56);
                }
            }
            i13 = iM4707constrainWidthK40F9xA2;
        }
        if (i44 == i - 1 && i54 <= i2) {
            z3 = false;
        }
        MeasureResult measureResultInvoke = function3.invoke(Integer.valueOf(i13), Integer.valueOf(iM4706constrainHeightK40F9xA), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$6
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
                List<LazyGridMeasuredItem> list6 = listCalculateItemsOffsets;
                int size5 = list6.size();
                for (int i58 = 0; i58 < size5; i58++) {
                    list6.get(i58).place(placementScope);
                }
                ObservableScopeInvalidator.m1176attachToScopeimpl(mutableState);
            }
        });
        if (list3.isEmpty() && list5.isEmpty()) {
            list2 = listCalculateItemsOffsets;
        } else {
            ArrayList arrayList2 = new ArrayList(listCalculateItemsOffsets.size());
            int size5 = listCalculateItemsOffsets.size();
            int i58 = 0;
            while (i58 < size5) {
                LazyGridMeasuredItem lazyGridMeasuredItem3 = listCalculateItemsOffsets.get(i58);
                int index3 = lazyGridMeasuredItem3.getIndex();
                int i59 = i45;
                if (i59 <= index3 && index3 <= i44) {
                    arrayList2.add(lazyGridMeasuredItem3);
                }
                i58++;
                i45 = i59;
            }
            list2 = arrayList2;
        }
        return new LazyGridMeasureResult(lazyGridMeasuredLine, i12, z3, f5, measureResultInvoke, z5, coroutineScope, density, i8, function1, list2, i47, i46, i, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
    }

    private static final List<LazyGridMeasuredItem> calculateItemsOffsets(List<LazyGridMeasuredLine> list, List<LazyGridMeasuredItem> list2, List<LazyGridMeasuredItem> list3, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        int i6 = z ? i2 : i;
        boolean z3 = i3 < Math.min(i6, i4);
        if (z3 && i5 != 0) {
            throw new IllegalStateException("non-zero firstLineScrollOffset".toString());
        }
        int size = list.size();
        int length = 0;
        for (int i7 = 0; i7 < size; i7++) {
            length += list.get(i7).getItems().length;
        }
        ArrayList arrayList = new ArrayList(length);
        if (z3) {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("no items".toString());
            }
            int size2 = list.size();
            int[] iArr = new int[size2];
            for (int i8 = 0; i8 < size2; i8++) {
                iArr[i8] = list.get(calculateItemsOffsets$reverseAware(i8, z2, size2)).getMainAxisSize();
            }
            int[] iArr2 = new int[size2];
            for (int i9 = 0; i9 < size2; i9++) {
                iArr2[i9] = 0;
            }
            if (z) {
                if (vertical == null) {
                    throw new IllegalArgumentException("null verticalArrangement".toString());
                }
                vertical.arrange(density, i6, iArr, iArr2);
            } else {
                if (horizontal == null) {
                    throw new IllegalArgumentException("null horizontalArrangement".toString());
                }
                horizontal.arrange(density, i6, iArr, LayoutDirection.Ltr, iArr2);
            }
            IntRange indices = ArraysKt.getIndices(iArr2);
            if (z2) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int mainAxisSize = iArr2[first];
                    LazyGridMeasuredLine lazyGridMeasuredLine = list.get(calculateItemsOffsets$reverseAware(first, z2, size2));
                    if (z2) {
                        mainAxisSize = (i6 - mainAxisSize) - lazyGridMeasuredLine.getMainAxisSize();
                    }
                    addAllFromArray(arrayList, lazyGridMeasuredLine.position(mainAxisSize, i, i2));
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int size3 = list2.size() - 1;
            if (size3 >= 0) {
                int mainAxisSizeWithSpacings = i5;
                while (true) {
                    int i10 = size3 - 1;
                    LazyGridMeasuredItem lazyGridMeasuredItem = list2.get(size3);
                    mainAxisSizeWithSpacings -= lazyGridMeasuredItem.getMainAxisSizeWithSpacings();
                    lazyGridMeasuredItem.position(mainAxisSizeWithSpacings, 0, i, i2);
                    arrayList.add(lazyGridMeasuredItem);
                    if (i10 < 0) {
                        break;
                    }
                    size3 = i10;
                }
            }
            int size4 = list.size();
            int mainAxisSizeWithSpacings2 = i5;
            for (int i11 = 0; i11 < size4; i11++) {
                LazyGridMeasuredLine lazyGridMeasuredLine2 = list.get(i11);
                addAllFromArray(arrayList, lazyGridMeasuredLine2.position(mainAxisSizeWithSpacings2, i, i2));
                mainAxisSizeWithSpacings2 += lazyGridMeasuredLine2.getMainAxisSizeWithSpacings();
            }
            int size5 = list3.size();
            for (int i12 = 0; i12 < size5; i12++) {
                LazyGridMeasuredItem lazyGridMeasuredItem2 = list3.get(i12);
                lazyGridMeasuredItem2.position(mainAxisSizeWithSpacings2, 0, i, i2);
                arrayList.add(lazyGridMeasuredItem2);
                mainAxisSizeWithSpacings2 += lazyGridMeasuredItem2.getMainAxisSizeWithSpacings();
            }
        }
        return arrayList;
    }

    private static final <T> void addAllFromArray(List<T> list, T[] tArr) {
        for (T t : tArr) {
            list.add(t);
        }
    }

    private static final List<LazyGridMeasuredItem> calculateExtraItems(List<Integer> list, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider, Function1<? super Integer, Boolean> function1) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            int iIntValue = list.get(i).intValue();
            if (function1.invoke(Integer.valueOf(iIntValue)).booleanValue()) {
                int iSpanOf = lazyGridMeasuredLineProvider.spanOf(iIntValue);
                LazyGridMeasuredItem lazyGridMeasuredItemMo1116getAndMeasurehBUhpc = lazyGridMeasuredItemProvider.mo1116getAndMeasurehBUhpc(iIntValue, 0, iSpanOf, lazyGridMeasuredLineProvider.m1147childConstraintsJhjzzOo$foundation_release(0, iSpanOf));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(lazyGridMeasuredItemMo1116getAndMeasurehBUhpc);
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }
}
