package androidx.compose.foundation.lazy.staggeredgrid;

import io.sentry.protocol.Device;
import kotlin.Metadata;

/* compiled from: LazyStaggeredGrid.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0089\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"LazyStaggeredGrid", "", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", Device.JsonKeys.ORIENTATION, "Landroidx/compose/foundation/gestures/Orientation;", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyStaggeredGrid-LJWHXA8", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZFFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyStaggeredGridKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:174:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0105  */
    /* renamed from: LazyStaggeredGrid-LJWHXA8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1203LazyStaggeredGridLJWHXA8(final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r30, final androidx.compose.foundation.gestures.Orientation r31, final androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider r32, androidx.compose.ui.Modifier r33, androidx.compose.foundation.layout.PaddingValues r34, boolean r35, androidx.compose.foundation.gestures.FlingBehavior r36, boolean r37, float r38, float r39, final kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope, kotlin.Unit> r40, androidx.compose.runtime.Composer r41, final int r42, final int r43, final int r44) {
        /*
            Method dump skipped, instructions count: 935
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt.m1203LazyStaggeredGridLJWHXA8(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState, androidx.compose.foundation.gestures.Orientation, androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider, androidx.compose.ui.Modifier, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, float, float, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
