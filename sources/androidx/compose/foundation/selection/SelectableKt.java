package androidx.compose.foundation.selection;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: Selectable.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aR\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fø\u0001\u0000¢\u0006\u0002\b\u000e\u001a>\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fø\u0001\u0000¢\u0006\u0002\b\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"selectable", "Landroidx/compose/ui/Modifier;", "selected", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", ViewProps.ENABLED, ViewProps.ROLE, "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "selectable-O2vRcR0", "selectable-XHw0xAI", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SelectableKt {
    /* renamed from: selectable-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1256selectableXHw0xAI$default(Modifier modifier, boolean z, boolean z2, Role role, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m1255selectableXHw0xAI(modifier, z, z2, role, function0);
    }

    /* renamed from: selectable-O2vRcR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1254selectableO2vRcR0$default(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z2, Role role, Function0 function0, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        boolean z3 = z2;
        if ((i & 16) != 0) {
            role = null;
        }
        return m1253selectableO2vRcR0(modifier, z, mutableInteractionSource, indication, z3, role, function0);
    }

    /* renamed from: selectable-XHw0xAI, reason: not valid java name */
    public static final Modifier m1255selectableXHw0xAI(Modifier modifier, final boolean z, final boolean z2, final Role role, final Function0<Unit> function0) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.selection.SelectableKt$selectable-XHw0xAI$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("selectable");
                inspectorInfo.getProperties().set("selected", Boolean.valueOf(z));
                inspectorInfo.getProperties().set(ViewProps.ENABLED, Boolean.valueOf(z2));
                inspectorInfo.getProperties().set(ViewProps.ROLE, role);
                inspectorInfo.getProperties().set("onClick", function0);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.selection.SelectableKt$selectable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                MutableInteractionSource mutableInteractionSource;
                composer.startReplaceGroup(-2124609672);
                ComposerKt.sourceInformation(composer, "C76@3365L7:Selectable.kt#gro6r2");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2124609672, i, -1, "androidx.compose.foundation.selection.selectable.<anonymous> (Selectable.kt:76)");
                }
                ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = composer.consume(localIndication);
                ComposerKt.sourceInformationMarkerEnd(composer);
                Indication indication = (Indication) objConsume;
                if (indication instanceof IndicationNodeFactory) {
                    composer.startReplaceGroup(-1412264498);
                    composer.endReplaceGroup();
                    mutableInteractionSource = null;
                } else {
                    composer.startReplaceGroup(-1412156525);
                    ComposerKt.sourceInformation(composer, "83@3729L39");
                    ComposerKt.sourceInformationMarkerStart(composer, -738284616, "CC(remember):Selectable.kt#9igjgp");
                    Object objRememberedValue = composer.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endReplaceGroup();
                }
                Modifier modifierM1253selectableO2vRcR0 = SelectableKt.m1253selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource, indication, z2, role, function0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierM1253selectableO2vRcR0;
            }
        });
    }

    /* renamed from: selectable-O2vRcR0, reason: not valid java name */
    public static final Modifier m1253selectableO2vRcR0(Modifier modifier, final boolean z, MutableInteractionSource mutableInteractionSource, final Indication indication, final boolean z2, final Role role, final Function0<Unit> function0) {
        SelectableElement selectableElementComposed$default;
        SelectableElement selectableElement;
        if (indication instanceof IndicationNodeFactory) {
            selectableElement = new SelectableElement(z, mutableInteractionSource, (IndicationNodeFactory) indication, z2, role, function0, null);
        } else {
            if (indication != null) {
                if (mutableInteractionSource != null) {
                    selectableElementComposed$default = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource, indication).then(new SelectableElement(z, mutableInteractionSource, null, z2, role, function0, null));
                } else {
                    selectableElementComposed$default = ComposedModifierKt.composed$default(Modifier.INSTANCE, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.selection.SelectableKt$selectable-O2vRcR0$$inlined$clickableWithIndicationIfNeeded$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                            return invoke(modifier2, composer, num.intValue());
                        }

                        public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                            composer.startReplaceGroup(-1525724089);
                            ComposerKt.sourceInformation(composer, "C375@17877L39:Clickable.kt#71ulvw");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1525724089, i, -1, "androidx.compose.foundation.clickableWithIndicationIfNeeded.<anonymous> (Clickable.kt:375)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composer, -442650590, "CC(remember):Clickable.kt#9igjgp");
                            Object objRememberedValue = composer.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer.updateRememberedValue(objRememberedValue);
                            }
                            MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            Modifier modifierThen = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource2, indication).then(new SelectableElement(z, mutableInteractionSource2, null, z2, role, function0, null));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer.endReplaceGroup();
                            return modifierThen;
                        }
                    }, 1, null);
                }
                return modifier.then(selectableElementComposed$default);
            }
            selectableElement = new SelectableElement(z, mutableInteractionSource, null, z2, role, function0, null);
        }
        selectableElementComposed$default = selectableElement;
        return modifier.then(selectableElementComposed$default);
    }
}
