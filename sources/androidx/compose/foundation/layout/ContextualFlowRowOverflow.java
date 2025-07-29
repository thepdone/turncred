package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.nimbusds.jose.jwk.gen.OctetSequenceKeyGenerator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: FlowLayoutOverflow.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0087\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00120\b\u0002\u0010\u0007\u001a*\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000f\u0018\u00010\b\u00120\b\u0002\u0010\u0010\u001a*\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000f\u0018\u00010\b¢\u0006\u0002\u0010\u0011¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/layout/ContextualFlowRowOverflow;", "Landroidx/compose/foundation/layout/FlowLayoutOverflow;", "type", "Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "minLinesToShowCollapse", "", "minCrossAxisSizeToShowCollapse", "seeMoreGetter", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "Lkotlin/ParameterName;", "name", "state", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "collapseGetter", "(Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;IILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Companion", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ContextualFlowRowOverflow extends FlowLayoutOverflow {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ContextualFlowRowOverflow Visible = new ContextualFlowRowOverflow(FlowLayoutOverflow.OverflowType.Visible, 0, 0, null, null, 30, null);
    private static final ContextualFlowRowOverflow Clip = new ContextualFlowRowOverflow(FlowLayoutOverflow.OverflowType.Clip, 0, 0, null, null, 30, null);

    public /* synthetic */ ContextualFlowRowOverflow(FlowLayoutOverflow.OverflowType overflowType, int i, int i2, Function1 function1, Function1 function12, DefaultConstructorMarker defaultConstructorMarker) {
        this(overflowType, i, i2, function1, function12);
    }

    /* synthetic */ ContextualFlowRowOverflow(FlowLayoutOverflow.OverflowType overflowType, int i, int i2, Function1 function1, Function1 function12, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(overflowType, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? null : function1, (i3 & 16) != 0 ? null : function12);
    }

    private ContextualFlowRowOverflow(FlowLayoutOverflow.OverflowType overflowType, int i, int i2, Function1<? super FlowLayoutOverflowState, ? extends Function2<? super Composer, ? super Integer, Unit>> function1, Function1<? super FlowLayoutOverflowState, ? extends Function2<? super Composer, ? super Integer, Unit>> function12) {
        super(overflowType, i, i2, function1, function12, null);
    }

    /* compiled from: FlowLayoutOverflow.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u000b\u001a\u00020\u00042\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0012Jb\u0010\u0013\u001a\u00020\u00042\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0003\u001a\u00020\u00048GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/layout/ContextualFlowRowOverflow$Companion;", "", "()V", "Clip", "Landroidx/compose/foundation/layout/ContextualFlowRowOverflow;", "getClip$annotations", "getClip", "()Landroidx/compose/foundation/layout/ContextualFlowRowOverflow;", "Visible", "getVisible$annotations", "getVisible", "expandIndicator", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ContextualFlowRowOverflowScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/layout/ContextualFlowRowOverflow;", "expandOrCollapseIndicator", "collapseIndicator", "minRowsToShowCollapse", "", "minHeightToShowCollapse", "Landroidx/compose/ui/unit/Dp;", "expandOrCollapseIndicator--jt2gSs", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;IFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/layout/ContextualFlowRowOverflow;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getClip$annotations() {
        }

        public static /* synthetic */ void getVisible$annotations() {
        }

        private Companion() {
        }

        public final ContextualFlowRowOverflow getVisible() {
            return ContextualFlowRowOverflow.Visible;
        }

        public final ContextualFlowRowOverflow getClip() {
            return ContextualFlowRowOverflow.Clip;
        }

        public final ContextualFlowRowOverflow expandIndicator(final Function3<? super ContextualFlowRowOverflowScope, ? super Composer, ? super Integer, Unit> content) {
            return new ContextualFlowRowOverflow(FlowLayoutOverflow.OverflowType.ExpandIndicator, 0, 0, new Function1<FlowLayoutOverflowState, Function2<? super Composer, ? super Integer, ? extends Unit>>() { // from class: androidx.compose.foundation.layout.ContextualFlowRowOverflow$Companion$expandIndicator$seeMoreGetter$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Function2<Composer, Integer, Unit> invoke(final FlowLayoutOverflowState flowLayoutOverflowState) {
                    final Function3<ContextualFlowRowOverflowScope, Composer, Integer, Unit> function3 = content;
                    return ComposableLambdaKt.composableLambdaInstance(1850548683, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowRowOverflow$Companion$expandIndicator$seeMoreGetter$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer, int i) {
                            ComposerKt.sourceInformation(composer, "C415@17942L9:FlowLayoutOverflow.kt#2w3rfo");
                            if ((i & 3) != 2 || !composer.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1850548683, i, -1, "androidx.compose.foundation.layout.ContextualFlowRowOverflow.Companion.expandIndicator.<anonymous>.<anonymous> (FlowLayoutOverflow.kt:414)");
                                }
                                function3.invoke(new ContextualFlowRowOverflowScopeImpl(flowLayoutOverflowState), composer, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer.skipToGroupEnd();
                        }
                    });
                }
            }, null, 22, null);
        }

        /* renamed from: expandOrCollapseIndicator--jt2gSs, reason: not valid java name */
        public final ContextualFlowRowOverflow m921expandOrCollapseIndicatorjt2gSs(final Function3<? super ContextualFlowRowOverflowScope, ? super Composer, ? super Integer, Unit> function3, final Function3<? super ContextualFlowRowOverflowScope, ? super Composer, ? super Integer, Unit> function32, int i, float f, Composer composer, int i2, int i3) {
            ComposerKt.sourceInformationMarkerStart(composer, 1435293820, "C(expandOrCollapseIndicator)P(1!1,3,2:c#ui.unit.Dp)*458@20145L7,461@20241L1109:FlowLayoutOverflow.kt#2w3rfo");
            boolean z = true;
            int i4 = (i3 & 4) != 0 ? 1 : i;
            float fM4737constructorimpl = (i3 & 8) != 0 ? Dp.m4737constructorimpl(0) : f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1435293820, i2, -1, "androidx.compose.foundation.layout.ContextualFlowRowOverflow.Companion.expandOrCollapseIndicator (FlowLayoutOverflow.kt:457)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer);
            int iMo688roundToPx0680j_4 = ((Density) objConsume).mo688roundToPx0680j_4(fM4737constructorimpl);
            ComposerKt.sourceInformationMarkerStart(composer, 172958269, "CC(remember):FlowLayoutOverflow.kt#9igjgp");
            boolean zChanged = ((((i2 & 896) ^ BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT) > 256 && composer.changed(i4)) || (i2 & BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT) == 256) | composer.changed(iMo688roundToPx0680j_4) | ((((i2 & 14) ^ 6) > 4 && composer.changed(function3)) || (i2 & 6) == 4);
            if ((((i2 & OctetSequenceKeyGenerator.MIN_KEY_SIZE_BITS) ^ 48) <= 32 || !composer.changed(function32)) && (i2 & 48) != 32) {
                z = false;
            }
            boolean z2 = zChanged | z;
            Object objRememberedValue = composer.rememberedValue();
            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new ContextualFlowRowOverflow(FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator, i4, iMo688roundToPx0680j_4, new Function1<FlowLayoutOverflowState, Function2<? super Composer, ? super Integer, ? extends Unit>>() { // from class: androidx.compose.foundation.layout.ContextualFlowRowOverflow$Companion$expandOrCollapseIndicator$1$seeMoreGetter$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Function2<Composer, Integer, Unit> invoke(final FlowLayoutOverflowState flowLayoutOverflowState) {
                        final Function3<ContextualFlowRowOverflowScope, Composer, Integer, Unit> function33 = function3;
                        return ComposableLambdaKt.composableLambdaInstance(897838875, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowRowOverflow$Companion$expandOrCollapseIndicator$1$seeMoreGetter$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i5) {
                                ComposerKt.sourceInformation(composer2, "C470@20630L17:FlowLayoutOverflow.kt#2w3rfo");
                                if ((i5 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(897838875, i5, -1, "androidx.compose.foundation.layout.ContextualFlowRowOverflow.Companion.expandOrCollapseIndicator.<anonymous>.<anonymous>.<anonymous> (FlowLayoutOverflow.kt:469)");
                                    }
                                    function33.invoke(new ContextualFlowRowOverflowScopeImpl(flowLayoutOverflowState), composer2, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        });
                    }
                }, new Function1<FlowLayoutOverflowState, Function2<? super Composer, ? super Integer, ? extends Unit>>() { // from class: androidx.compose.foundation.layout.ContextualFlowRowOverflow$Companion$expandOrCollapseIndicator$1$collapseGetter$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Function2<Composer, Integer, Unit> invoke(final FlowLayoutOverflowState flowLayoutOverflowState) {
                        final Function3<ContextualFlowRowOverflowScope, Composer, Integer, Unit> function33 = function32;
                        return ComposableLambdaKt.composableLambdaInstance(307858874, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.ContextualFlowRowOverflow$Companion$expandOrCollapseIndicator$1$collapseGetter$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i5) {
                                ComposerKt.sourceInformation(composer2, "C477@20904L19:FlowLayoutOverflow.kt#2w3rfo");
                                if ((i5 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(307858874, i5, -1, "androidx.compose.foundation.layout.ContextualFlowRowOverflow.Companion.expandOrCollapseIndicator.<anonymous>.<anonymous>.<anonymous> (FlowLayoutOverflow.kt:476)");
                                    }
                                    function33.invoke(new ContextualFlowRowOverflowScopeImpl(flowLayoutOverflowState), composer2, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        });
                    }
                }, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            ContextualFlowRowOverflow contextualFlowRowOverflow = (ContextualFlowRowOverflow) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return contextualFlowRowOverflow;
        }
    }
}
