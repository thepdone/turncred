package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import com.facebook.react.uimanager.ViewProps;
import io.sentry.protocol.MetricSummary;
import io.sentry.rrweb.RRWebVideoEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Size.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u000b\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0016\u0010\u0012\u001a\u00020\f*\u00020\f2\b\b\u0003\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u0016\u0010\u0015\u001a\u00020\f*\u00020\f2\b\b\u0003\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u0016\u0010\u0016\u001a\u00020\f*\u00020\f2\b\b\u0003\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u001e\u0010\u0017\u001a\u00020\f*\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a*\u0010\u001a\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0011\u001a\u001e\u0010\u001e\u001a\u00020\f*\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0019\u001a*\u0010 \u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0011\u001a\u001e\u0010\"\u001a\u00020\f*\u00020\f2\u0006\u0010#\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010\u0019\u001a&\u0010\"\u001a\u00020\f*\u00020\f2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0011\u001a\u001e\u0010\"\u001a\u00020\f*\u00020\f2\u0006\u0010#\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a>\u0010*\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u001e\u0010/\u001a\u00020\f*\u00020\f2\u0006\u0010%\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0019\u001a*\u00101\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0011\u001a\u001e\u0010#\u001a\u00020\f*\u00020\f2\u0006\u0010#\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0019\u001a&\u0010#\u001a\u00020\f*\u00020\f2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0011\u001a\u001e\u0010#\u001a\u00020\f*\u00020\f2\u0006\u0010#\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0004\b5\u0010)\u001a>\u00106\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020\u000e2\b\b\u0002\u0010,\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b7\u0010.\u001a\u001e\u0010%\u001a\u00020\f*\u00020\f2\u0006\u0010%\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b8\u0010\u0019\u001a*\u00109\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b:\u0010\u0011\u001a \u0010;\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020?H\u0007\u001a \u0010@\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010<\u001a\u00020A2\b\b\u0002\u0010>\u001a\u00020?H\u0007\u001a \u0010B\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010<\u001a\u00020C2\b\b\u0002\u0010>\u001a\u00020?H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006D"}, d2 = {"FillWholeMaxHeight", "Landroidx/compose/foundation/layout/FillElement;", "FillWholeMaxSize", "FillWholeMaxWidth", "WrapContentHeightCenter", "Landroidx/compose/foundation/layout/WrapContentElement;", "WrapContentHeightTop", "WrapContentSizeCenter", "WrapContentSizeTopStart", "WrapContentWidthCenter", "WrapContentWidthStart", "defaultMinSize", "Landroidx/compose/ui/Modifier;", ViewProps.MIN_WIDTH, "Landroidx/compose/ui/unit/Dp;", ViewProps.MIN_HEIGHT, "defaultMinSize-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "fillMaxHeight", "fraction", "", "fillMaxSize", "fillMaxWidth", "height", "height-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "heightIn", MetricSummary.JsonKeys.MIN, MetricSummary.JsonKeys.MAX, "heightIn-VpY3zN4", "requiredHeight", "requiredHeight-3ABfNKs", "requiredHeightIn", "requiredHeightIn-VpY3zN4", "requiredSize", RRWebVideoEvent.JsonKeys.SIZE, "requiredSize-3ABfNKs", "width", "requiredSize-VpY3zN4", "Landroidx/compose/ui/unit/DpSize;", "requiredSize-6HolHcs", "(Landroidx/compose/ui/Modifier;J)Landroidx/compose/ui/Modifier;", "requiredSizeIn", ViewProps.MAX_WIDTH, ViewProps.MAX_HEIGHT, "requiredSizeIn-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "requiredWidth", "requiredWidth-3ABfNKs", "requiredWidthIn", "requiredWidthIn-VpY3zN4", "size-3ABfNKs", "size-VpY3zN4", "size-6HolHcs", "sizeIn", "sizeIn-qDBjuR0", "width-3ABfNKs", "widthIn", "widthIn-VpY3zN4", "wrapContentHeight", "align", "Landroidx/compose/ui/Alignment$Vertical;", "unbounded", "", "wrapContentSize", "Landroidx/compose/ui/Alignment;", "wrapContentWidth", "Landroidx/compose/ui/Alignment$Horizontal;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SizeKt {
    private static final FillElement FillWholeMaxWidth = FillElement.INSTANCE.width(1.0f);
    private static final FillElement FillWholeMaxHeight = FillElement.INSTANCE.height(1.0f);
    private static final FillElement FillWholeMaxSize = FillElement.INSTANCE.size(1.0f);
    private static final WrapContentElement WrapContentWidthCenter = WrapContentElement.INSTANCE.width(Alignment.INSTANCE.getCenterHorizontally(), false);
    private static final WrapContentElement WrapContentWidthStart = WrapContentElement.INSTANCE.width(Alignment.INSTANCE.getStart(), false);
    private static final WrapContentElement WrapContentHeightCenter = WrapContentElement.INSTANCE.height(Alignment.INSTANCE.getCenterVertically(), false);
    private static final WrapContentElement WrapContentHeightTop = WrapContentElement.INSTANCE.height(Alignment.INSTANCE.getTop(), false);
    private static final WrapContentElement WrapContentSizeCenter = WrapContentElement.INSTANCE.size(Alignment.INSTANCE.getCenter(), false);
    private static final WrapContentElement WrapContentSizeTopStart = WrapContentElement.INSTANCE.size(Alignment.INSTANCE.getTopStart(), false);

    /* renamed from: width-3ABfNKs, reason: not valid java name */
    public static final Modifier m1052width3ABfNKs(Modifier modifier, final float f) {
        return modifier.then(new SizeElement(f, 0.0f, f, 0.0f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$width-3ABfNKs$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("width");
                inspectorInfo.setValue(Dp.m4735boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 10, null));
    }

    /* renamed from: height-3ABfNKs, reason: not valid java name */
    public static final Modifier m1033height3ABfNKs(Modifier modifier, final float f) {
        return modifier.then(new SizeElement(0.0f, f, 0.0f, f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$height-3ABfNKs$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("height");
                inspectorInfo.setValue(Dp.m4735boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 5, null));
    }

    /* renamed from: size-6HolHcs, reason: not valid java name */
    public static final Modifier m1048size6HolHcs(Modifier modifier, long j) {
        return m1049sizeVpY3zN4(modifier, DpSize.m4835getWidthD9Ej5fM(j), DpSize.m4833getHeightD9Ej5fM(j));
    }

    /* renamed from: widthIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1054widthInVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.INSTANCE.m4757getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.INSTANCE.m4757getUnspecifiedD9Ej5fM();
        }
        return m1053widthInVpY3zN4(modifier, f, f2);
    }

    /* renamed from: widthIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m1053widthInVpY3zN4(Modifier modifier, final float f, final float f2) {
        return modifier.then(new SizeElement(f, 0.0f, f2, 0.0f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$widthIn-VpY3zN4$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("widthIn");
                inspectorInfo.getProperties().set(MetricSummary.JsonKeys.MIN, Dp.m4735boximpl(f));
                inspectorInfo.getProperties().set(MetricSummary.JsonKeys.MAX, Dp.m4735boximpl(f2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 10, null));
    }

    /* renamed from: heightIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1035heightInVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.INSTANCE.m4757getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.INSTANCE.m4757getUnspecifiedD9Ej5fM();
        }
        return m1034heightInVpY3zN4(modifier, f, f2);
    }

    /* renamed from: heightIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m1034heightInVpY3zN4(Modifier modifier, final float f, final float f2) {
        return modifier.then(new SizeElement(0.0f, f, 0.0f, f2, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$heightIn-VpY3zN4$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("heightIn");
                inspectorInfo.getProperties().set(MetricSummary.JsonKeys.MIN, Dp.m4735boximpl(f));
                inspectorInfo.getProperties().set(MetricSummary.JsonKeys.MAX, Dp.m4735boximpl(f2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 5, null));
    }

    /* renamed from: sizeIn-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1051sizeInqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.INSTANCE.m4757getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.INSTANCE.m4757getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f3 = Dp.INSTANCE.m4757getUnspecifiedD9Ej5fM();
        }
        if ((i & 8) != 0) {
            f4 = Dp.INSTANCE.m4757getUnspecifiedD9Ej5fM();
        }
        return m1050sizeInqDBjuR0(modifier, f, f2, f3, f4);
    }

    /* renamed from: sizeIn-qDBjuR0, reason: not valid java name */
    public static final Modifier m1050sizeInqDBjuR0(Modifier modifier, final float f, final float f2, final float f3, final float f4) {
        return modifier.then(new SizeElement(f, f2, f3, f4, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$sizeIn-qDBjuR0$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("sizeIn");
                inspectorInfo.getProperties().set(ViewProps.MIN_WIDTH, Dp.m4735boximpl(f));
                inspectorInfo.getProperties().set(ViewProps.MIN_HEIGHT, Dp.m4735boximpl(f2));
                inspectorInfo.getProperties().set(ViewProps.MAX_WIDTH, Dp.m4735boximpl(f3));
                inspectorInfo.getProperties().set(ViewProps.MAX_HEIGHT, Dp.m4735boximpl(f4));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* renamed from: requiredWidth-3ABfNKs, reason: not valid java name */
    public static final Modifier m1044requiredWidth3ABfNKs(Modifier modifier, final float f) {
        return modifier.then(new SizeElement(f, 0.0f, f, 0.0f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredWidth-3ABfNKs$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("requiredWidth");
                inspectorInfo.setValue(Dp.m4735boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 10, null));
    }

    /* renamed from: requiredHeight-3ABfNKs, reason: not valid java name */
    public static final Modifier m1036requiredHeight3ABfNKs(Modifier modifier, final float f) {
        return modifier.then(new SizeElement(0.0f, f, 0.0f, f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredHeight-3ABfNKs$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("requiredHeight");
                inspectorInfo.setValue(Dp.m4735boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 5, null));
    }

    /* renamed from: requiredSize-6HolHcs, reason: not valid java name */
    public static final Modifier m1040requiredSize6HolHcs(Modifier modifier, long j) {
        return m1041requiredSizeVpY3zN4(modifier, DpSize.m4835getWidthD9Ej5fM(j), DpSize.m4833getHeightD9Ej5fM(j));
    }

    /* renamed from: requiredWidthIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1046requiredWidthInVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.INSTANCE.m4757getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.INSTANCE.m4757getUnspecifiedD9Ej5fM();
        }
        return m1045requiredWidthInVpY3zN4(modifier, f, f2);
    }

    /* renamed from: requiredWidthIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m1045requiredWidthInVpY3zN4(Modifier modifier, final float f, final float f2) {
        return modifier.then(new SizeElement(f, 0.0f, f2, 0.0f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredWidthIn-VpY3zN4$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("requiredWidthIn");
                inspectorInfo.getProperties().set(MetricSummary.JsonKeys.MIN, Dp.m4735boximpl(f));
                inspectorInfo.getProperties().set(MetricSummary.JsonKeys.MAX, Dp.m4735boximpl(f2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 10, null));
    }

    /* renamed from: requiredHeightIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1038requiredHeightInVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.INSTANCE.m4757getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.INSTANCE.m4757getUnspecifiedD9Ej5fM();
        }
        return m1037requiredHeightInVpY3zN4(modifier, f, f2);
    }

    /* renamed from: requiredHeightIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m1037requiredHeightInVpY3zN4(Modifier modifier, final float f, final float f2) {
        return modifier.then(new SizeElement(0.0f, f, 0.0f, f2, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredHeightIn-VpY3zN4$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("requiredHeightIn");
                inspectorInfo.getProperties().set(MetricSummary.JsonKeys.MIN, Dp.m4735boximpl(f));
                inspectorInfo.getProperties().set(MetricSummary.JsonKeys.MAX, Dp.m4735boximpl(f2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 5, null));
    }

    /* renamed from: requiredSizeIn-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1043requiredSizeInqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.INSTANCE.m4757getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.INSTANCE.m4757getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f3 = Dp.INSTANCE.m4757getUnspecifiedD9Ej5fM();
        }
        if ((i & 8) != 0) {
            f4 = Dp.INSTANCE.m4757getUnspecifiedD9Ej5fM();
        }
        return m1042requiredSizeInqDBjuR0(modifier, f, f2, f3, f4);
    }

    /* renamed from: requiredSizeIn-qDBjuR0, reason: not valid java name */
    public static final Modifier m1042requiredSizeInqDBjuR0(Modifier modifier, final float f, final float f2, final float f3, final float f4) {
        return modifier.then(new SizeElement(f, f2, f3, f4, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredSizeIn-qDBjuR0$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("requiredSizeIn");
                inspectorInfo.getProperties().set(ViewProps.MIN_WIDTH, Dp.m4735boximpl(f));
                inspectorInfo.getProperties().set(ViewProps.MIN_HEIGHT, Dp.m4735boximpl(f2));
                inspectorInfo.getProperties().set(ViewProps.MAX_WIDTH, Dp.m4735boximpl(f3));
                inspectorInfo.getProperties().set(ViewProps.MAX_HEIGHT, Dp.m4735boximpl(f4));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    public static /* synthetic */ Modifier fillMaxWidth$default(Modifier modifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return fillMaxWidth(modifier, f);
    }

    public static final Modifier fillMaxWidth(Modifier modifier, float f) {
        return modifier.then(f == 1.0f ? FillWholeMaxWidth : FillElement.INSTANCE.width(f));
    }

    public static /* synthetic */ Modifier fillMaxHeight$default(Modifier modifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return fillMaxHeight(modifier, f);
    }

    public static final Modifier fillMaxHeight(Modifier modifier, float f) {
        return modifier.then(f == 1.0f ? FillWholeMaxHeight : FillElement.INSTANCE.height(f));
    }

    public static /* synthetic */ Modifier fillMaxSize$default(Modifier modifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return fillMaxSize(modifier, f);
    }

    public static final Modifier fillMaxSize(Modifier modifier, float f) {
        return modifier.then(f == 1.0f ? FillWholeMaxSize : FillElement.INSTANCE.size(f));
    }

    public static /* synthetic */ Modifier wrapContentWidth$default(Modifier modifier, Alignment.Horizontal horizontal, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            horizontal = Alignment.INSTANCE.getCenterHorizontally();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return wrapContentWidth(modifier, horizontal, z);
    }

    public static final Modifier wrapContentWidth(Modifier modifier, Alignment.Horizontal horizontal, boolean z) {
        WrapContentElement wrapContentElementWidth;
        if (Intrinsics.areEqual(horizontal, Alignment.INSTANCE.getCenterHorizontally()) && !z) {
            wrapContentElementWidth = WrapContentWidthCenter;
        } else if (Intrinsics.areEqual(horizontal, Alignment.INSTANCE.getStart()) && !z) {
            wrapContentElementWidth = WrapContentWidthStart;
        } else {
            wrapContentElementWidth = WrapContentElement.INSTANCE.width(horizontal, z);
        }
        return modifier.then(wrapContentElementWidth);
    }

    public static /* synthetic */ Modifier wrapContentHeight$default(Modifier modifier, Alignment.Vertical vertical, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            vertical = Alignment.INSTANCE.getCenterVertically();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return wrapContentHeight(modifier, vertical, z);
    }

    public static final Modifier wrapContentHeight(Modifier modifier, Alignment.Vertical vertical, boolean z) {
        WrapContentElement wrapContentElementHeight;
        if (Intrinsics.areEqual(vertical, Alignment.INSTANCE.getCenterVertically()) && !z) {
            wrapContentElementHeight = WrapContentHeightCenter;
        } else if (Intrinsics.areEqual(vertical, Alignment.INSTANCE.getTop()) && !z) {
            wrapContentElementHeight = WrapContentHeightTop;
        } else {
            wrapContentElementHeight = WrapContentElement.INSTANCE.height(vertical, z);
        }
        return modifier.then(wrapContentElementHeight);
    }

    public static /* synthetic */ Modifier wrapContentSize$default(Modifier modifier, Alignment alignment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            alignment = Alignment.INSTANCE.getCenter();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return wrapContentSize(modifier, alignment, z);
    }

    public static final Modifier wrapContentSize(Modifier modifier, Alignment alignment, boolean z) {
        WrapContentElement size;
        if (Intrinsics.areEqual(alignment, Alignment.INSTANCE.getCenter()) && !z) {
            size = WrapContentSizeCenter;
        } else if (Intrinsics.areEqual(alignment, Alignment.INSTANCE.getTopStart()) && !z) {
            size = WrapContentSizeTopStart;
        } else {
            size = WrapContentElement.INSTANCE.size(alignment, z);
        }
        return modifier.then(size);
    }

    /* renamed from: defaultMinSize-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1032defaultMinSizeVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.INSTANCE.m4757getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.INSTANCE.m4757getUnspecifiedD9Ej5fM();
        }
        return m1031defaultMinSizeVpY3zN4(modifier, f, f2);
    }

    /* renamed from: defaultMinSize-VpY3zN4, reason: not valid java name */
    public static final Modifier m1031defaultMinSizeVpY3zN4(Modifier modifier, float f, float f2) {
        return modifier.then(new UnspecifiedConstraintsElement(f, f2, null));
    }

    /* renamed from: size-3ABfNKs, reason: not valid java name */
    public static final Modifier m1047size3ABfNKs(Modifier modifier, final float f) {
        return modifier.then(new SizeElement(f, f, f, f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$size-3ABfNKs$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName(RRWebVideoEvent.JsonKeys.SIZE);
                inspectorInfo.setValue(Dp.m4735boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* renamed from: size-VpY3zN4, reason: not valid java name */
    public static final Modifier m1049sizeVpY3zN4(Modifier modifier, final float f, final float f2) {
        return modifier.then(new SizeElement(f, f2, f, f2, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$size-VpY3zN4$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName(RRWebVideoEvent.JsonKeys.SIZE);
                inspectorInfo.getProperties().set("width", Dp.m4735boximpl(f));
                inspectorInfo.getProperties().set("height", Dp.m4735boximpl(f2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* renamed from: requiredSize-3ABfNKs, reason: not valid java name */
    public static final Modifier m1039requiredSize3ABfNKs(Modifier modifier, final float f) {
        return modifier.then(new SizeElement(f, f, f, f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredSize-3ABfNKs$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("requiredSize");
                inspectorInfo.setValue(Dp.m4735boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* renamed from: requiredSize-VpY3zN4, reason: not valid java name */
    public static final Modifier m1041requiredSizeVpY3zN4(Modifier modifier, final float f, final float f2) {
        return modifier.then(new SizeElement(f, f2, f, f2, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.SizeKt$requiredSize-VpY3zN4$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("requiredSize");
                inspectorInfo.getProperties().set("width", Dp.m4735boximpl(f));
                inspectorInfo.getProperties().set("height", Dp.m4735boximpl(f2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }
}
