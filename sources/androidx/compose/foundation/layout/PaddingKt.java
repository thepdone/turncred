package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.caverock.androidsvg.SVGParser;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Padding.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a&\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a:\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a>\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0019\u0010\u0016\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0019\u0010\u001a\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0014\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0001H\u0007\u001a\u001e\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a*\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a>\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0015\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"PaddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", SVGParser.XML_STYLESHEET_ATTR_MEDIA_ALL, "Landroidx/compose/ui/unit/Dp;", "PaddingValues-0680j_4", "(F)Landroidx/compose/foundation/layout/PaddingValues;", "horizontal", "vertical", "PaddingValues-YgX7TsA", "(FF)Landroidx/compose/foundation/layout/PaddingValues;", ViewProps.START, "top", ViewProps.END, ViewProps.BOTTOM, "PaddingValues-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "absolutePadding", "Landroidx/compose/ui/Modifier;", "left", ViewProps.RIGHT, "absolutePadding-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "calculateEndPadding", ViewProps.LAYOUT_DIRECTION, "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateStartPadding", ViewProps.PADDING, "paddingValues", "padding-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "padding-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "padding-qDBjuR0", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PaddingKt {
    /* renamed from: padding-qDBjuR0, reason: not valid java name */
    public static final Modifier m1005paddingqDBjuR0(Modifier modifier, final float f, final float f2, final float f3, final float f4) {
        return modifier.then(new PaddingElement(f, f2, f3, f4, true, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt.padding.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName(ViewProps.PADDING);
                inspectorInfo.getProperties().set(ViewProps.START, Dp.m4735boximpl(f));
                inspectorInfo.getProperties().set("top", Dp.m4735boximpl(f2));
                inspectorInfo.getProperties().set(ViewProps.END, Dp.m4735boximpl(f3));
                inspectorInfo.getProperties().set(ViewProps.BOTTOM, Dp.m4735boximpl(f4));
            }
        }, null));
    }

    /* renamed from: padding-VpY3zN4, reason: not valid java name */
    public static final Modifier m1003paddingVpY3zN4(Modifier modifier, final float f, final float f2) {
        return modifier.then(new PaddingElement(f, f2, f, f2, true, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt.padding.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName(ViewProps.PADDING);
                inspectorInfo.getProperties().set("horizontal", Dp.m4735boximpl(f));
                inspectorInfo.getProperties().set("vertical", Dp.m4735boximpl(f2));
            }
        }, null));
    }

    /* renamed from: padding-3ABfNKs, reason: not valid java name */
    public static final Modifier m1002padding3ABfNKs(Modifier modifier, final float f) {
        return modifier.then(new PaddingElement(f, f, f, f, true, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt.padding.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName(ViewProps.PADDING);
                inspectorInfo.setValue(Dp.m4735boximpl(f));
            }
        }, null));
    }

    public static final Modifier padding(Modifier modifier, final PaddingValues paddingValues) {
        return modifier.then(new PaddingValuesElement(paddingValues, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt.padding.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName(ViewProps.PADDING);
                inspectorInfo.getProperties().set("paddingValues", paddingValues);
            }
        }));
    }

    /* renamed from: absolutePadding-qDBjuR0, reason: not valid java name */
    public static final Modifier m1000absolutePaddingqDBjuR0(Modifier modifier, final float f, final float f2, final float f3, final float f4) {
        return modifier.then(new PaddingElement(f, f2, f3, f4, false, new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt$absolutePadding$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("absolutePadding");
                inspectorInfo.getProperties().set("left", Dp.m4735boximpl(f));
                inspectorInfo.getProperties().set("top", Dp.m4735boximpl(f2));
                inspectorInfo.getProperties().set(ViewProps.RIGHT, Dp.m4735boximpl(f3));
                inspectorInfo.getProperties().set(ViewProps.BOTTOM, Dp.m4735boximpl(f4));
            }
        }, null));
    }

    public static final float calculateStartPadding(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        if (layoutDirection == LayoutDirection.Ltr) {
            return paddingValues.mo953calculateLeftPaddingu2uoSUM(layoutDirection);
        }
        return paddingValues.mo954calculateRightPaddingu2uoSUM(layoutDirection);
    }

    public static final float calculateEndPadding(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        if (layoutDirection == LayoutDirection.Ltr) {
            return paddingValues.mo954calculateRightPaddingu2uoSUM(layoutDirection);
        }
        return paddingValues.mo953calculateLeftPaddingu2uoSUM(layoutDirection);
    }

    /* renamed from: PaddingValues-0680j_4, reason: not valid java name */
    public static final PaddingValues m995PaddingValues0680j_4(float f) {
        return new PaddingValuesImpl(f, f, f, f, null);
    }

    /* renamed from: PaddingValues-YgX7TsA, reason: not valid java name */
    public static final PaddingValues m996PaddingValuesYgX7TsA(float f, float f2) {
        return new PaddingValuesImpl(f, f2, f, f2, null);
    }

    /* renamed from: PaddingValues-a9UjIt4, reason: not valid java name */
    public static final PaddingValues m998PaddingValuesa9UjIt4(float f, float f2, float f3, float f4) {
        return new PaddingValuesImpl(f, f2, f3, f4, null);
    }

    /* renamed from: padding-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1006paddingqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m4737constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m4737constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f3 = Dp.m4737constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m4737constructorimpl(0);
        }
        return m1005paddingqDBjuR0(modifier, f, f2, f3, f4);
    }

    /* renamed from: padding-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1004paddingVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m4737constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m4737constructorimpl(0);
        }
        return m1003paddingVpY3zN4(modifier, f, f2);
    }

    /* renamed from: absolutePadding-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1001absolutePaddingqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m4737constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m4737constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f3 = Dp.m4737constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m4737constructorimpl(0);
        }
        return m1000absolutePaddingqDBjuR0(modifier, f, f2, f3, f4);
    }

    /* renamed from: PaddingValues-YgX7TsA$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m997PaddingValuesYgX7TsA$default(float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m4737constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m4737constructorimpl(0);
        }
        return m996PaddingValuesYgX7TsA(f, f2);
    }

    /* renamed from: PaddingValues-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m999PaddingValuesa9UjIt4$default(float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m4737constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m4737constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f3 = Dp.m4737constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m4737constructorimpl(0);
        }
        return m998PaddingValuesa9UjIt4(f, f2, f3, f4);
    }
}
