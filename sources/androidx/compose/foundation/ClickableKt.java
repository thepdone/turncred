package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ScrollableContainerNode;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import com.facebook.react.uimanager.ViewProps;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Clickable.kt */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001ax\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007ø\u0001\u0000¢\u0006\u0002\b\u0012\u001aV\u0010\u0013\u001a\u00020\u0014*\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003ø\u0001\u0000¢\u0006\u0002\b\u0017\u001aB\u0010\u0013\u001a\u00020\u0014*\u00020\u00142\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003ø\u0001\u0000¢\u0006\u0002\b\u0018\u001aA\u0010\u0019\u001a\u00020\u0014*\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u001e\b\u0004\u0010\u001a\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00140\u001bH\u0080\b\u001a\u0088\u0001\u0010\u001c\u001a\u00020\u0014*\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\b\u001d\u001at\u0010\u001c\u001a\u00020\u0014*\u00020\u00142\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\b\u001e\u001a\u009e\u0001\u0010\u001f\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000ø\u0001\u0000¢\u0006\u0002\b)\u001a\f\u0010*\u001a\u00020\u000e*\u00020+H\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006,"}, d2 = {"CombinedClickableNode", "Landroidx/compose/foundation/CombinedClickableNode;", "onClick", "Lkotlin/Function0;", "", "onLongClickLabel", "", "onLongClick", "onDoubleClick", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", ViewProps.ENABLED, "", "onClickLabel", ViewProps.ROLE, "Landroidx/compose/ui/semantics/Role;", "CombinedClickableNode-nSzSaCc", "clickable", "Landroidx/compose/ui/Modifier;", "indication", "Landroidx/compose/foundation/Indication;", "clickable-O2vRcR0", "clickable-XHw0xAI", "clickableWithIndicationIfNeeded", "createClickable", "Lkotlin/Function2;", "combinedClickable", "combinedClickable-XVZzFYc", "combinedClickable-cJG_KMw", "genericClickableWithoutGesture", "indicationScope", "Lkotlinx/coroutines/CoroutineScope;", "currentKeyPressInteractions", "", "Landroidx/compose/ui/input/key/Key;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "keyClickOffset", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/geometry/Offset;", "genericClickableWithoutGesture-Kqv-Bsg", "hasScrollableContainer", "Landroidx/compose/ui/node/TraversableNode;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ClickableKt {
    /* renamed from: clickable-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m590clickableXHw0xAI$default(Modifier modifier, boolean z, String str, Role role, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m589clickableXHw0xAI(modifier, z, str, role, function0);
    }

    /* renamed from: clickable-O2vRcR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m588clickableO2vRcR0$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return m587clickableO2vRcR0(modifier, mutableInteractionSource, indication, z, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : role, function0);
    }

    public static final Modifier clickableWithIndicationIfNeeded(Modifier modifier, MutableInteractionSource mutableInteractionSource, final Indication indication, final Function2<? super MutableInteractionSource, ? super IndicationNodeFactory, ? extends Modifier> function2) {
        Modifier modifierComposed$default;
        if (indication instanceof IndicationNodeFactory) {
            modifierComposed$default = function2.invoke(mutableInteractionSource, indication);
        } else if (indication == null) {
            modifierComposed$default = function2.invoke(mutableInteractionSource, null);
        } else if (mutableInteractionSource != null) {
            modifierComposed$default = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource, indication).then(function2.invoke(mutableInteractionSource, null));
        } else {
            modifierComposed$default = ComposedModifierKt.composed$default(Modifier.INSTANCE, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt.clickableWithIndicationIfNeeded.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    Modifier modifierThen = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource2, indication).then(function2.invoke(mutableInteractionSource2, null));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer.endReplaceGroup();
                    return modifierThen;
                }
            }, 1, null);
        }
        return modifier.then(modifierComposed$default);
    }

    private static final Modifier genericClickableWithoutGesture_Kqv_Bsg$detectPressAndClickFromKey(Modifier modifier, final boolean z, final Map<Key, PressInteraction.Press> map, final State<Offset> state, final CoroutineScope coroutineScope, final Function0<Unit> function0, final MutableInteractionSource mutableInteractionSource) {
        return KeyInputModifierKt.onKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m597invokeZmokQxo(keyEvent.m3331unboximpl());
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Boolean m597invokeZmokQxo(android.view.KeyEvent r11) {
                /*
                    r10 = this;
                    boolean r0 = r1
                    r1 = 1
                    r2 = 0
                    r3 = 0
                    if (r0 == 0) goto L4f
                    boolean r0 = androidx.compose.foundation.Clickable_androidKt.m604isPressZmokQxo(r11)
                    if (r0 == 0) goto L4f
                    java.util.Map<androidx.compose.ui.input.key.Key, androidx.compose.foundation.interaction.PressInteraction$Press> r0 = r2
                    long r4 = androidx.compose.ui.input.key.KeyEvent_androidKt.m3342getKeyZmokQxo(r11)
                    androidx.compose.ui.input.key.Key r4 = androidx.compose.ui.input.key.Key.m3031boximpl(r4)
                    boolean r0 = r0.containsKey(r4)
                    if (r0 != 0) goto L84
                    androidx.compose.foundation.interaction.PressInteraction$Press r0 = new androidx.compose.foundation.interaction.PressInteraction$Press
                    androidx.compose.runtime.State<androidx.compose.ui.geometry.Offset> r2 = r3
                    java.lang.Object r2 = r2.getValue()
                    androidx.compose.ui.geometry.Offset r2 = (androidx.compose.ui.geometry.Offset) r2
                    long r4 = r2.getPackedValue()
                    r0.<init>(r4, r3)
                    java.util.Map<androidx.compose.ui.input.key.Key, androidx.compose.foundation.interaction.PressInteraction$Press> r2 = r2
                    long r4 = androidx.compose.ui.input.key.KeyEvent_androidKt.m3342getKeyZmokQxo(r11)
                    androidx.compose.ui.input.key.Key r11 = androidx.compose.ui.input.key.Key.m3031boximpl(r4)
                    r2.put(r11, r0)
                    kotlinx.coroutines.CoroutineScope r4 = r4
                    androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$1 r11 = new androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$1
                    androidx.compose.foundation.interaction.MutableInteractionSource r2 = r6
                    r11.<init>(r2, r0, r3)
                    r7 = r11
                    kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
                    r8 = 3
                    r9 = 0
                    r5 = 0
                    r6 = 0
                    kotlinx.coroutines.BuildersKt.launch$default(r4, r5, r6, r7, r8, r9)
                    goto L85
                L4f:
                    boolean r0 = r1
                    if (r0 == 0) goto L84
                    boolean r0 = androidx.compose.foundation.Clickable_androidKt.m602isClickZmokQxo(r11)
                    if (r0 == 0) goto L84
                    java.util.Map<androidx.compose.ui.input.key.Key, androidx.compose.foundation.interaction.PressInteraction$Press> r0 = r2
                    long r4 = androidx.compose.ui.input.key.KeyEvent_androidKt.m3342getKeyZmokQxo(r11)
                    androidx.compose.ui.input.key.Key r11 = androidx.compose.ui.input.key.Key.m3031boximpl(r4)
                    java.lang.Object r11 = r0.remove(r11)
                    androidx.compose.foundation.interaction.PressInteraction$Press r11 = (androidx.compose.foundation.interaction.PressInteraction.Press) r11
                    if (r11 == 0) goto L7e
                    kotlinx.coroutines.CoroutineScope r4 = r4
                    androidx.compose.foundation.interaction.MutableInteractionSource r0 = r6
                    androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$2$1 r2 = new androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$2$1
                    r2.<init>(r0, r11, r3)
                    r7 = r2
                    kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
                    r8 = 3
                    r9 = 0
                    r5 = 0
                    r6 = 0
                    kotlinx.coroutines.BuildersKt.launch$default(r4, r5, r6, r7, r8, r9)
                L7e:
                    kotlin.jvm.functions.Function0<kotlin.Unit> r11 = r5
                    r11.invoke()
                    goto L85
                L84:
                    r1 = r2
                L85:
                    java.lang.Boolean r11 = java.lang.Boolean.valueOf(r1)
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1.m597invokeZmokQxo(android.view.KeyEvent):java.lang.Boolean");
            }

            /* compiled from: Clickable.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$1", f = "Clickable.kt", i = {}, l = {434}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ MutableInteractionSource $interactionSource;
                final /* synthetic */ PressInteraction.Press $press;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(MutableInteractionSource mutableInteractionSource, PressInteraction.Press press, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$interactionSource = mutableInteractionSource;
                    this.$press = press;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$interactionSource, this.$press, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (this.$interactionSource.emit(this.$press, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }
        });
    }

    /* renamed from: genericClickableWithoutGesture-Kqv-Bsg, reason: not valid java name */
    public static final Modifier m595genericClickableWithoutGestureKqvBsg(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, CoroutineScope coroutineScope, Map<Key, PressInteraction.Press> map, State<Offset> state, boolean z, String str, Role role, String str2, Function0<Unit> function0, Function0<Unit> function02) {
        return modifier.then(FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(genericClickableWithoutGesture_Kqv_Bsg$detectPressAndClickFromKey(new ClickableSemanticsElement(z, role, str2, function0, str, function02, null), z, map, state, coroutineScope, function02, mutableInteractionSource), mutableInteractionSource, indication), mutableInteractionSource, z), z, mutableInteractionSource));
    }

    /* renamed from: CombinedClickableNode-nSzSaCc, reason: not valid java name */
    public static final CombinedClickableNode m586CombinedClickableNodenSzSaCc(Function0<Unit> function0, String str, Function0<Unit> function02, Function0<Unit> function03, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z, String str2, Role role) {
        return new CombinedClickableNodeImpl(function0, str, function02, function03, mutableInteractionSource, indicationNodeFactory, z, str2, role, null);
    }

    public static final boolean hasScrollableContainer(TraversableNode traversableNode) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        TraversableNodeKt.traverseAncestors(traversableNode, ScrollableContainerNode.INSTANCE, new Function1<TraversableNode, Boolean>() { // from class: androidx.compose.foundation.ClickableKt.hasScrollableContainer.1
            {
                super(1);
            }

            /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Boolean invoke(androidx.compose.ui.node.TraversableNode r4) {
                /*
                    r3 = this;
                    kotlin.jvm.internal.Ref$BooleanRef r0 = r1
                    boolean r1 = r0.element
                    r2 = 1
                    if (r1 != 0) goto L17
                    java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.foundation.gestures.ScrollableContainerNode"
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r1)
                    androidx.compose.foundation.gestures.ScrollableContainerNode r4 = (androidx.compose.foundation.gestures.ScrollableContainerNode) r4
                    boolean r4 = r4.getEnabled()
                    if (r4 == 0) goto L15
                    goto L17
                L15:
                    r4 = 0
                    goto L18
                L17:
                    r4 = r2
                L18:
                    r0.element = r4
                    kotlin.jvm.internal.Ref$BooleanRef r4 = r1
                    boolean r4 = r4.element
                    r4 = r4 ^ r2
                    java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ClickableKt.C01911.invoke(androidx.compose.ui.node.TraversableNode):java.lang.Boolean");
            }
        });
        return booleanRef.element;
    }

    /* renamed from: clickable-XHw0xAI, reason: not valid java name */
    public static final Modifier m589clickableXHw0xAI(Modifier modifier, final boolean z, final String str, final Role role, final Function0<Unit> function0) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$clickable-XHw0xAI$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("clickable");
                inspectorInfo.getProperties().set(ViewProps.ENABLED, Boolean.valueOf(z));
                inspectorInfo.getProperties().set("onClickLabel", str);
                inspectorInfo.getProperties().set(ViewProps.ROLE, role);
                inspectorInfo.getProperties().set("onClick", function0);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$clickable$2
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
                composer.startReplaceGroup(-756081143);
                ComposerKt.sourceInformation(composer, "C112@5124L7:Clickable.kt#71ulvw");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-756081143, i, -1, "androidx.compose.foundation.clickable.<anonymous> (Clickable.kt:112)");
                }
                ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = composer.consume(localIndication);
                ComposerKt.sourceInformationMarkerEnd(composer);
                Indication indication = (Indication) objConsume;
                if (indication instanceof IndicationNodeFactory) {
                    composer.startReplaceGroup(617140216);
                    composer.endReplaceGroup();
                    mutableInteractionSource = null;
                } else {
                    composer.startReplaceGroup(617248189);
                    ComposerKt.sourceInformation(composer, "119@5488L39");
                    ComposerKt.sourceInformationMarkerStart(composer, 1266842702, "CC(remember):Clickable.kt#9igjgp");
                    Object objRememberedValue = composer.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endReplaceGroup();
                }
                Modifier modifierM587clickableO2vRcR0 = ClickableKt.m587clickableO2vRcR0(Modifier.INSTANCE, mutableInteractionSource, indication, z, str, role, function0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierM587clickableO2vRcR0;
            }
        });
    }

    /* renamed from: clickable-O2vRcR0, reason: not valid java name */
    public static final Modifier m587clickableO2vRcR0(Modifier modifier, MutableInteractionSource mutableInteractionSource, final Indication indication, final boolean z, final String str, final Role role, final Function0<Unit> function0) {
        ClickableElement clickableElementComposed$default;
        ClickableElement clickableElement;
        if (indication instanceof IndicationNodeFactory) {
            clickableElement = new ClickableElement(mutableInteractionSource, (IndicationNodeFactory) indication, z, str, role, function0, null);
        } else {
            if (indication != null) {
                if (mutableInteractionSource != null) {
                    clickableElementComposed$default = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource, indication).then(new ClickableElement(mutableInteractionSource, null, z, str, role, function0, null));
                } else {
                    clickableElementComposed$default = ComposedModifierKt.composed$default(Modifier.INSTANCE, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$clickable-O2vRcR0$$inlined$clickableWithIndicationIfNeeded$1
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
                            Modifier modifierThen = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource2, indication).then(new ClickableElement(mutableInteractionSource2, null, z, str, role, function0, null));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer.endReplaceGroup();
                            return modifierThen;
                        }
                    }, 1, null);
                }
                return modifier.then(clickableElementComposed$default);
            }
            clickableElement = new ClickableElement(mutableInteractionSource, null, z, str, role, function0, null);
        }
        clickableElementComposed$default = clickableElement;
        return modifier.then(clickableElementComposed$default);
    }

    /* renamed from: combinedClickable-cJG_KMw, reason: not valid java name */
    public static final Modifier m593combinedClickablecJG_KMw(Modifier modifier, final boolean z, final String str, final Role role, final String str2, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable-cJG_KMw$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("combinedClickable");
                inspectorInfo.getProperties().set(ViewProps.ENABLED, Boolean.valueOf(z));
                inspectorInfo.getProperties().set("onClickLabel", str);
                inspectorInfo.getProperties().set(ViewProps.ROLE, role);
                inspectorInfo.getProperties().set("onClick", function03);
                inspectorInfo.getProperties().set("onDoubleClick", function02);
                inspectorInfo.getProperties().set("onLongClick", function0);
                inspectorInfo.getProperties().set("onLongClickLabel", str2);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$2
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
                composer.startReplaceGroup(1969174843);
                ComposerKt.sourceInformation(composer, "C252@11777L7:Clickable.kt#71ulvw");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1969174843, i, -1, "androidx.compose.foundation.combinedClickable.<anonymous> (Clickable.kt:252)");
                }
                ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = composer.consume(localIndication);
                ComposerKt.sourceInformationMarkerEnd(composer);
                Indication indication = (Indication) objConsume;
                if (indication instanceof IndicationNodeFactory) {
                    composer.startReplaceGroup(-1726989699);
                    composer.endReplaceGroup();
                    mutableInteractionSource = null;
                } else {
                    composer.startReplaceGroup(-1726881726);
                    ComposerKt.sourceInformation(composer, "259@12141L39");
                    ComposerKt.sourceInformationMarkerStart(composer, -1995363031, "CC(remember):Clickable.kt#9igjgp");
                    Object objRememberedValue = composer.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endReplaceGroup();
                }
                Modifier modifierM591combinedClickableXVZzFYc = ClickableKt.m591combinedClickableXVZzFYc(Modifier.INSTANCE, mutableInteractionSource, indication, z, str, role, str2, function0, function02, function03);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierM591combinedClickableXVZzFYc;
            }
        });
    }

    /* renamed from: combinedClickable-XVZzFYc, reason: not valid java name */
    public static final Modifier m591combinedClickableXVZzFYc(Modifier modifier, MutableInteractionSource mutableInteractionSource, final Indication indication, final boolean z, final String str, final Role role, final String str2, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03) {
        CombinedClickableElement combinedClickableElementComposed$default;
        CombinedClickableElement combinedClickableElement;
        if (indication instanceof IndicationNodeFactory) {
            combinedClickableElement = new CombinedClickableElement(mutableInteractionSource, (IndicationNodeFactory) indication, z, str, role, function03, str2, function0, function02, null);
        } else {
            if (indication != null) {
                if (mutableInteractionSource != null) {
                    combinedClickableElementComposed$default = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource, indication).then(new CombinedClickableElement(mutableInteractionSource, null, z, str, role, function03, str2, function0, function02, null));
                } else {
                    combinedClickableElementComposed$default = ComposedModifierKt.composed$default(Modifier.INSTANCE, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable-XVZzFYc$$inlined$clickableWithIndicationIfNeeded$1
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
                            Modifier modifierThen = IndicationKt.indication(Modifier.INSTANCE, mutableInteractionSource2, indication).then(new CombinedClickableElement(mutableInteractionSource2, null, z, str, role, function03, str2, function0, function02, null));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer.endReplaceGroup();
                            return modifierThen;
                        }
                    }, 1, null);
                }
                return modifier.then(combinedClickableElementComposed$default);
            }
            combinedClickableElement = new CombinedClickableElement(mutableInteractionSource, null, z, str, role, function03, str2, function0, function02, null);
        }
        combinedClickableElementComposed$default = combinedClickableElement;
        return modifier.then(combinedClickableElementComposed$default);
    }
}
