package androidx.compose.foundation.text;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: TextFieldScroll.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002\u001a4\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0000\u001a*\u0010\u0017\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\nH\u0000¨\u0006\u001b"}, d2 = {"getCursorRectInScroller", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/Density;", "cursorOffset", "", "transformedText", "Landroidx/compose/ui/text/input/TransformedText;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "rtl", "", "textFieldWidth", "textFieldScroll", "Landroidx/compose/ui/Modifier;", "scrollerPosition", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "textLayoutResultProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "textFieldScrollable", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", ViewProps.ENABLED, "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldScrollKt {

    /* compiled from: TextFieldScroll.kt */
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

    public static /* synthetic */ Modifier textFieldScrollable$default(Modifier modifier, TextFieldScrollerPosition textFieldScrollerPosition, MutableInteractionSource mutableInteractionSource, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            mutableInteractionSource = null;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        return textFieldScrollable(modifier, textFieldScrollerPosition, mutableInteractionSource, z);
    }

    public static final Modifier textFieldScroll(Modifier modifier, TextFieldScrollerPosition textFieldScrollerPosition, TextFieldValue textFieldValue, VisualTransformation visualTransformation, Function0<TextLayoutResultProxy> function0) {
        VerticalScrollLayoutModifier verticalScrollLayoutModifier;
        Orientation orientation = textFieldScrollerPosition.getOrientation();
        int iM1403getOffsetToFollow5zctL8 = textFieldScrollerPosition.m1403getOffsetToFollow5zctL8(textFieldValue.getSelection());
        textFieldScrollerPosition.m1405setPreviousSelection5zctL8(textFieldValue.getSelection());
        TransformedText transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation, textFieldValue.getAnnotatedString());
        int i = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i == 1) {
            verticalScrollLayoutModifier = new VerticalScrollLayoutModifier(textFieldScrollerPosition, iM1403getOffsetToFollow5zctL8, transformedTextFilterWithValidation, function0);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            verticalScrollLayoutModifier = new HorizontalScrollLayoutModifier(textFieldScrollerPosition, iM1403getOffsetToFollow5zctL8, transformedTextFilterWithValidation, function0);
        }
        return ClipKt.clipToBounds(modifier).then(verticalScrollLayoutModifier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect getCursorRectInScroller(Density density, int i, TransformedText transformedText, TextLayoutResult textLayoutResult, boolean z, int i2) {
        Rect zero;
        float left;
        float left2;
        if (textLayoutResult == null || (zero = textLayoutResult.getCursorRect(transformedText.getOffsetMapping().originalToTransformed(i))) == null) {
            zero = Rect.INSTANCE.getZero();
        }
        Rect rect = zero;
        int iMo688roundToPx0680j_4 = density.mo688roundToPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
        if (z) {
            left = (i2 - rect.getLeft()) - iMo688roundToPx0680j_4;
        } else {
            left = rect.getLeft();
        }
        float f = left;
        if (z) {
            left2 = i2 - rect.getLeft();
        } else {
            left2 = rect.getLeft() + iMo688roundToPx0680j_4;
        }
        return Rect.copy$default(rect, f, 0.0f, left2, 0.0f, 10, null);
    }

    public static final Modifier textFieldScrollable(Modifier modifier, final TextFieldScrollerPosition textFieldScrollerPosition, final MutableInteractionSource mutableInteractionSource, final boolean z) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("textFieldScrollable");
                inspectorInfo.getProperties().set("scrollerPosition", textFieldScrollerPosition);
                inspectorInfo.getProperties().set("interactionSource", mutableInteractionSource);
                inspectorInfo.getProperties().set(ViewProps.ENABLED, Boolean.valueOf(z));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.TextFieldScrollKt.textFieldScrollable.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                composer.startReplaceGroup(805428266);
                ComposerKt.sourceInformation(composer, "C68@2918L7,70@3087L388,70@3063L412,83@3627L352:TextFieldScroll.kt#423gt5");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(805428266, i, -1, "androidx.compose.foundation.text.textFieldScrollable.<anonymous> (TextFieldScroll.kt:68)");
                }
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = composer.consume(localLayoutDirection);
                ComposerKt.sourceInformationMarkerEnd(composer);
                boolean z2 = textFieldScrollerPosition.getOrientation() == Orientation.Vertical || !(objConsume == LayoutDirection.Rtl);
                ComposerKt.sourceInformationMarkerStart(composer, 754563504, "CC(remember):TextFieldScroll.kt#9igjgp");
                boolean zChanged = composer.changed(textFieldScrollerPosition);
                final TextFieldScrollerPosition textFieldScrollerPosition2 = textFieldScrollerPosition;
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (Function1) new Function1<Float, Float>() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$scrollableState$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Float invoke(Float f) {
                            return invoke(f.floatValue());
                        }

                        public final Float invoke(float f) {
                            float offset = textFieldScrollerPosition2.getOffset() + f;
                            if (offset > textFieldScrollerPosition2.getMaximum()) {
                                f = textFieldScrollerPosition2.getMaximum() - textFieldScrollerPosition2.getOffset();
                            } else if (offset < 0.0f) {
                                f = -textFieldScrollerPosition2.getOffset();
                            }
                            TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition2;
                            textFieldScrollerPosition3.setOffset(textFieldScrollerPosition3.getOffset() + f);
                            return Float.valueOf(f);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                final ScrollableState scrollableStateRememberScrollableState = ScrollableStateKt.rememberScrollableState((Function1) objRememberedValue, composer, 0);
                ComposerKt.sourceInformationMarkerStart(composer, 754580748, "CC(remember):TextFieldScroll.kt#9igjgp");
                boolean zChanged2 = composer.changed(scrollableStateRememberScrollableState) | composer.changed(textFieldScrollerPosition);
                final TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition;
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new ScrollableState(textFieldScrollerPosition3) { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1

                        /* renamed from: canScrollBackward$delegate, reason: from kotlin metadata */
                        private final State canScrollBackward;

                        /* renamed from: canScrollForward$delegate, reason: from kotlin metadata */
                        private final State canScrollForward;

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public float dispatchRawDelta(float delta) {
                            return this.$$delegate_0.dispatchRawDelta(delta);
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public boolean getLastScrolledBackward() {
                            return this.$$delegate_0.getLastScrolledBackward();
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public boolean getLastScrolledForward() {
                            return this.$$delegate_0.getLastScrolledForward();
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public boolean isScrollInProgress() {
                            return this.$$delegate_0.isScrollInProgress();
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
                            return this.$$delegate_0.scroll(mutatePriority, function2, continuation);
                        }

                        {
                            this.canScrollForward = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1$canScrollForward$2
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    return Boolean.valueOf(textFieldScrollerPosition3.getOffset() < textFieldScrollerPosition3.getMaximum());
                                }
                            });
                            this.canScrollBackward = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1$canScrollBackward$2
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    return Boolean.valueOf(textFieldScrollerPosition3.getOffset() > 0.0f);
                                }
                            });
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public boolean getCanScrollForward() {
                            return ((Boolean) this.canScrollForward.getValue()).booleanValue();
                        }

                        @Override // androidx.compose.foundation.gestures.ScrollableState
                        public boolean getCanScrollBackward() {
                            return ((Boolean) this.canScrollBackward.getValue()).booleanValue();
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1 textFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1 = (TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier modifierScrollable$default = ScrollableKt.scrollable$default(Modifier.INSTANCE, textFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1, textFieldScrollerPosition.getOrientation(), z && textFieldScrollerPosition.getMaximum() != 0.0f, z2, null, mutableInteractionSource, 16, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierScrollable$default;
            }
        });
    }
}
