package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.InputTransformationKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasicSecureTextField.kt */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aÊ\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u001328\b\u0002\u0010\u0014\u001a2\u0012\u0004\u0012\u00020\u0016\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0015¢\u0006\u0002\b\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a \u0010(\u001a\u00020\u00052\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00050\u0017¢\u0006\u0002\b*H\u0003¢\u0006\u0002\u0010+\u001a\u001a\u0010,\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\r2\b\u0010-\u001a\u0004\u0018\u00010\rH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006."}, d2 = {"DefaultObfuscationCharacter", "", "LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS", "", "BasicSecureTextField", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", ViewProps.ENABLED, "", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "Lkotlin/ExtensionFunctionType;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "textObfuscationMode", "Landroidx/compose/foundation/text/input/TextObfuscationMode;", "textObfuscationCharacter", "BasicSecureTextField-Jb9bMDk", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/TextFieldDecorator;ICLandroidx/compose/runtime/Composer;III)V", "DisableCutCopy", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "then", "next", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BasicSecureTextFieldKt {
    private static final char DefaultObfuscationCharacter = 8226;
    private static final long LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS = 1500;

    /* JADX WARN: Removed duplicated region for block: B:100:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:231:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0127  */
    /* renamed from: BasicSecureTextField-Jb9bMDk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1290BasicSecureTextFieldJb9bMDk(final androidx.compose.foundation.text.input.TextFieldState r36, androidx.compose.ui.Modifier r37, boolean r38, androidx.compose.foundation.text.input.InputTransformation r39, androidx.compose.ui.text.TextStyle r40, androidx.compose.foundation.text.KeyboardOptions r41, androidx.compose.foundation.text.input.KeyboardActionHandler r42, kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super kotlin.jvm.functions.Function0<androidx.compose.ui.text.TextLayoutResult>, kotlin.Unit> r43, androidx.compose.foundation.interaction.MutableInteractionSource r44, androidx.compose.ui.graphics.Brush r45, androidx.compose.foundation.text.input.TextFieldDecorator r46, int r47, char r48, androidx.compose.runtime.Composer r49, final int r50, final int r51, final int r52) {
        /*
            Method dump skipped, instructions count: 953
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicSecureTextFieldKt.m1290BasicSecureTextFieldJb9bMDk(androidx.compose.foundation.text.input.TextFieldState, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.text.input.InputTransformation, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.input.KeyboardActionHandler, kotlin.jvm.functions.Function2, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, androidx.compose.foundation.text.input.TextFieldDecorator, int, char, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int BasicSecureTextField_Jb9bMDk$lambda$4$lambda$3(State state, int i, int i2) {
        return ((Character) state.getValue()).charValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InputTransformation then(InputTransformation inputTransformation, InputTransformation inputTransformation2) {
        return inputTransformation == null ? inputTransformation2 : inputTransformation2 == null ? inputTransformation : InputTransformationKt.then(inputTransformation, inputTransformation2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DisableCutCopy(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1085555050);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DisableCutCopy)311@13911L7,312@13949L680,331@14706L361,331@14634L433:BasicSecureTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1085555050, i2, -1, "androidx.compose.foundation.text.DisableCutCopy (BasicSecureTextField.kt:310)");
            }
            ProvidableCompositionLocal<TextToolbar> localTextToolbar = CompositionLocalsKt.getLocalTextToolbar();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localTextToolbar);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final TextToolbar textToolbar = (TextToolbar) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1202776994, "CC(remember):BasicSecureTextField.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(textToolbar);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new TextToolbar() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1
                    private final /* synthetic */ TextToolbar $$delegate_0;

                    @Override // androidx.compose.ui.platform.TextToolbar
                    public TextToolbarStatus getStatus() {
                        return this.$$delegate_0.getStatus();
                    }

                    @Override // androidx.compose.ui.platform.TextToolbar
                    public void hide() {
                        this.$$delegate_0.hide();
                    }

                    {
                        this.$$delegate_0 = this.$currentToolbar;
                    }

                    @Override // androidx.compose.ui.platform.TextToolbar
                    public void showMenu(Rect rect, Function0<Unit> onCopyRequested, Function0<Unit> onPasteRequested, Function0<Unit> onCutRequested, Function0<Unit> onSelectAllRequested) {
                        this.$currentToolbar.showMenu(rect, null, onPasteRequested, null, onSelectAllRequested);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalTextToolbar().provides((BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1) objRememberedValue), ComposableLambdaKt.rememberComposableLambda(-1448819882, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt.DisableCutCopy.1
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

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C332@14716L345:BasicSecureTextField.kt#423gt5");
                    if ((i3 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1448819882, i3, -1, "androidx.compose.foundation.text.DisableCutCopy.<anonymous> (BasicSecureTextField.kt:332)");
                        }
                        Modifier modifierOnPreviewKeyEvent = KeyInputModifierKt.onPreviewKeyEvent(Modifier.INSTANCE, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt.DisableCutCopy.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                return m1291invokeZmokQxo(keyEvent.m3331unboximpl());
                            }

                            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
                            public final Boolean m1291invokeZmokQxo(android.view.KeyEvent keyEvent) {
                                KeyCommand keyCommandMo1318mapZmokQxo = KeyMapping_androidKt.getPlatformDefaultKeyMapping().mo1318mapZmokQxo(keyEvent);
                                return Boolean.valueOf(keyCommandMo1318mapZmokQxo == KeyCommand.COPY || keyCommandMo1318mapZmokQxo == KeyCommand.CUT);
                            }
                        });
                        Function2<Composer, Integer, Unit> function22 = function2;
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierOnPreviewKeyEvent);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM1769constructorimpl = Updater.m1769constructorimpl(composer2);
                        Updater.m1776setimpl(composerM1769constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m1776setimpl(composerM1769constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM1769constructorimpl.getInserting() || !Intrinsics.areEqual(composerM1769constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM1769constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM1769constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m1776setimpl(composerM1769constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1177942586, "C338@15042L9:BasicSecureTextField.kt#423gt5");
                        function22.invoke(composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt.DisableCutCopy.2
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

                public final void invoke(Composer composer2, int i3) {
                    BasicSecureTextFieldKt.DisableCutCopy(function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
