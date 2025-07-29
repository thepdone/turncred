package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoreTextField.kt */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010|\u001a\u00020\u001bJx\u0010}\u001a\u00020L2\u0006\u0010v\u001a\u00020w2\u0006\u0010~\u001a\u00020w2\u0007\u0010\u007f\u001a\u00030\u0080\u00012\u0007\u0010\u0081\u0001\u001a\u00020\u001b2\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020L0J2\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u0006\u0010Y\u001a\u00020Zø\u0001\u0000¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R1\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00148F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R+\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u001b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u0013\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R+\u0010,\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u001b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0013\u001a\u0004\b,\u0010\u001e\"\u0004\b-\u0010 R\u001e\u0010/\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R(\u00105\u001a\u0004\u0018\u00010\n2\b\u00104\u001a\u0004\u0018\u00010\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109R(\u0010;\u001a\u0004\u0018\u00010:2\b\u00104\u001a\u0004\u0018\u00010:8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0016\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010:0AX\u0082\u0004¢\u0006\u0002\n\u0000R1\u0010C\u001a\u00020B2\u0006\u0010\u000b\u001a\u00020B8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bH\u0010\u0013\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001d\u0010I\u001a\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020L0J¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u001d\u0010O\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020L0J¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010NR\u001a\u0010R\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020L0JX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010S\u001a\u00020T¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\"\u0010Y\u001a\u00020ZX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010]\u001a\u0004\b[\u0010\u000f\"\u0004\b\\\u0010\u0011R1\u0010^\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\ba\u0010\u0013\u001a\u0004\b_\u0010\u000f\"\u0004\b`\u0010\u0011R+\u0010b\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u001b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\be\u0010\u0013\u001a\u0004\bc\u0010\u001e\"\u0004\bd\u0010 R+\u0010f\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u001b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bi\u0010\u0013\u001a\u0004\bg\u0010\u001e\"\u0004\bh\u0010 R+\u0010j\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u001b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bm\u0010\u0013\u001a\u0004\bk\u0010\u001e\"\u0004\bl\u0010 R+\u0010n\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u001b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bq\u0010\u0013\u001a\u0004\bo\u0010\u001e\"\u0004\bp\u0010 R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u001c\u0010v\u001a\u0004\u0018\u00010wX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u008c\u0001"}, d2 = {"Landroidx/compose/foundation/text/LegacyTextFieldState;", "", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "(Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/runtime/RecomposeScope;Landroidx/compose/ui/platform/SoftwareKeyboardController;)V", "_layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "<set-?>", "Landroidx/compose/ui/text/TextRange;", "deletionPreviewHighlightRange", "getDeletionPreviewHighlightRange-d9O1mEE", "()J", "setDeletionPreviewHighlightRange-5zc-tL8", "(J)V", "deletionPreviewHighlightRange$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/HandleState;", "handleState", "getHandleState", "()Landroidx/compose/foundation/text/HandleState;", "setHandleState", "(Landroidx/compose/foundation/text/HandleState;)V", "handleState$delegate", "", "hasFocus", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasFocus$delegate", "highlightPaint", "Landroidx/compose/ui/graphics/Paint;", "getHighlightPaint", "()Landroidx/compose/ui/graphics/Paint;", "inputSession", "Landroidx/compose/ui/text/input/TextInputSession;", "getInputSession", "()Landroidx/compose/ui/text/input/TextInputSession;", "setInputSession", "(Landroidx/compose/ui/text/input/TextInputSession;)V", "isInTouchMode", "setInTouchMode", "isInTouchMode$delegate", "isLayoutResultStale", "keyboardActionRunner", "Landroidx/compose/foundation/text/KeyboardActionRunner;", "getKeyboardController", "()Landroidx/compose/ui/platform/SoftwareKeyboardController;", "value", "layoutCoordinates", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "layoutResult", "getLayoutResult", "()Landroidx/compose/foundation/text/TextLayoutResultProxy;", "setLayoutResult", "(Landroidx/compose/foundation/text/TextLayoutResultProxy;)V", "layoutResultState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/unit/Dp;", "minHeightForSingleLineField", "getMinHeightForSingleLineField-D9Ej5fM", "()F", "setMinHeightForSingleLineField-0680j_4", "(F)V", "minHeightForSingleLineField$delegate", "onImeActionPerformed", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/ImeAction;", "", "getOnImeActionPerformed", "()Lkotlin/jvm/functions/Function1;", "onValueChange", "Landroidx/compose/ui/text/input/TextFieldValue;", "getOnValueChange", "onValueChangeOriginal", "processor", "Landroidx/compose/ui/text/input/EditProcessor;", "getProcessor", "()Landroidx/compose/ui/text/input/EditProcessor;", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "selectionBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "getSelectionBackgroundColor-0d7_KjU", "setSelectionBackgroundColor-8_81llA", "J", "selectionPreviewHighlightRange", "getSelectionPreviewHighlightRange-d9O1mEE", "setSelectionPreviewHighlightRange-5zc-tL8", "selectionPreviewHighlightRange$delegate", "showCursorHandle", "getShowCursorHandle", "setShowCursorHandle", "showCursorHandle$delegate", "showFloatingToolbar", "getShowFloatingToolbar", "setShowFloatingToolbar", "showFloatingToolbar$delegate", "showSelectionHandleEnd", "getShowSelectionHandleEnd", "setShowSelectionHandleEnd", "showSelectionHandleEnd$delegate", "showSelectionHandleStart", "getShowSelectionHandleStart", "setShowSelectionHandleStart", "showSelectionHandleStart$delegate", "getTextDelegate", "()Landroidx/compose/foundation/text/TextDelegate;", "setTextDelegate", "(Landroidx/compose/foundation/text/TextDelegate;)V", "untransformedText", "Landroidx/compose/ui/text/AnnotatedString;", "getUntransformedText", "()Landroidx/compose/ui/text/AnnotatedString;", "setUntransformedText", "(Landroidx/compose/ui/text/AnnotatedString;)V", "hasHighlight", "update", "visualText", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "softWrap", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "update-fnh65Uc", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/ui/focus/FocusManager;J)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LegacyTextFieldState {
    public static final int $stable = 8;
    private LayoutCoordinates _layoutCoordinates;
    private TextInputSession inputSession;
    private final KeyboardActionRunner keyboardActionRunner;
    private final SoftwareKeyboardController keyboardController;
    private final RecomposeScope recomposeScope;
    private TextDelegate textDelegate;
    private AnnotatedString untransformedText;
    private final EditProcessor processor = new EditProcessor();

    /* renamed from: hasFocus$delegate, reason: from kotlin metadata */
    private final MutableState hasFocus = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    /* renamed from: minHeightForSingleLineField$delegate, reason: from kotlin metadata */
    private final MutableState minHeightForSingleLineField = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Dp.m4735boximpl(Dp.m4737constructorimpl(0)), null, 2, null);
    private final MutableState<TextLayoutResultProxy> layoutResultState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    /* renamed from: handleState$delegate, reason: from kotlin metadata */
    private final MutableState handleState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(HandleState.None, null, 2, null);

    /* renamed from: showFloatingToolbar$delegate, reason: from kotlin metadata */
    private final MutableState showFloatingToolbar = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    /* renamed from: showSelectionHandleStart$delegate, reason: from kotlin metadata */
    private final MutableState showSelectionHandleStart = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    /* renamed from: showSelectionHandleEnd$delegate, reason: from kotlin metadata */
    private final MutableState showSelectionHandleEnd = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    /* renamed from: showCursorHandle$delegate, reason: from kotlin metadata */
    private final MutableState showCursorHandle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    private boolean isLayoutResultStale = true;

    /* renamed from: isInTouchMode$delegate, reason: from kotlin metadata */
    private final MutableState isInTouchMode = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
    private Function1<? super TextFieldValue, Unit> onValueChangeOriginal = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.LegacyTextFieldState$onValueChangeOriginal$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextFieldValue textFieldValue) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
            invoke2(textFieldValue);
            return Unit.INSTANCE;
        }
    };
    private final Function1<TextFieldValue, Unit> onValueChange = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.LegacyTextFieldState$onValueChange$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
            invoke2(textFieldValue);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextFieldValue textFieldValue) {
            String text = textFieldValue.getText();
            AnnotatedString untransformedText = this.this$0.getUntransformedText();
            if (!Intrinsics.areEqual(text, untransformedText != null ? untransformedText.getText() : null)) {
                this.this$0.setHandleState(HandleState.None);
            }
            this.this$0.m1342setSelectionPreviewHighlightRange5zctL8(TextRange.INSTANCE.m4227getZerod9O1mEE());
            this.this$0.m1339setDeletionPreviewHighlightRange5zctL8(TextRange.INSTANCE.m4227getZerod9O1mEE());
            this.this$0.onValueChangeOriginal.invoke(textFieldValue);
            this.this$0.getRecomposeScope().invalidate();
        }
    };
    private final Function1<ImeAction, Unit> onImeActionPerformed = new Function1<ImeAction, Unit>() { // from class: androidx.compose.foundation.text.LegacyTextFieldState$onImeActionPerformed$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ImeAction imeAction) {
            m1344invokeKlQnJC8(imeAction.getValue());
            return Unit.INSTANCE;
        }

        /* renamed from: invoke-KlQnJC8, reason: not valid java name */
        public final void m1344invokeKlQnJC8(int i) {
            this.this$0.keyboardActionRunner.m1320runActionKlQnJC8(i);
        }
    };
    private final Paint highlightPaint = AndroidPaint_androidKt.Paint();
    private long selectionBackgroundColor = Color.INSTANCE.m2312getUnspecified0d7_KjU();

    /* renamed from: selectionPreviewHighlightRange$delegate, reason: from kotlin metadata */
    private final MutableState selectionPreviewHighlightRange = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TextRange.m4210boximpl(TextRange.INSTANCE.m4227getZerod9O1mEE()), null, 2, null);

    /* renamed from: deletionPreviewHighlightRange$delegate, reason: from kotlin metadata */
    private final MutableState deletionPreviewHighlightRange = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TextRange.m4210boximpl(TextRange.INSTANCE.m4227getZerod9O1mEE()), null, 2, null);

    public LegacyTextFieldState(TextDelegate textDelegate, RecomposeScope recomposeScope, SoftwareKeyboardController softwareKeyboardController) {
        this.textDelegate = textDelegate;
        this.recomposeScope = recomposeScope;
        this.keyboardController = softwareKeyboardController;
        this.keyboardActionRunner = new KeyboardActionRunner(softwareKeyboardController);
    }

    public final TextDelegate getTextDelegate() {
        return this.textDelegate;
    }

    public final void setTextDelegate(TextDelegate textDelegate) {
        this.textDelegate = textDelegate;
    }

    public final RecomposeScope getRecomposeScope() {
        return this.recomposeScope;
    }

    public final SoftwareKeyboardController getKeyboardController() {
        return this.keyboardController;
    }

    public final EditProcessor getProcessor() {
        return this.processor;
    }

    public final TextInputSession getInputSession() {
        return this.inputSession;
    }

    public final void setInputSession(TextInputSession textInputSession) {
        this.inputSession = textInputSession;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus.getValue()).booleanValue();
    }

    public final void setHasFocus(boolean z) {
        this.hasFocus.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getMinHeightForSingleLineField-D9Ej5fM, reason: not valid java name */
    public final float m1336getMinHeightForSingleLineFieldD9Ej5fM() {
        return ((Dp) this.minHeightForSingleLineField.getValue()).m4751unboximpl();
    }

    /* renamed from: setMinHeightForSingleLineField-0680j_4, reason: not valid java name */
    public final void m1340setMinHeightForSingleLineField0680j_4(float f) {
        this.minHeightForSingleLineField.setValue(Dp.m4735boximpl(f));
    }

    public final LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates layoutCoordinates = this._layoutCoordinates;
        if (layoutCoordinates == null || !layoutCoordinates.isAttached()) {
            return null;
        }
        return layoutCoordinates;
    }

    public final void setLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        this._layoutCoordinates = layoutCoordinates;
    }

    public final TextLayoutResultProxy getLayoutResult() {
        return this.layoutResultState.getValue();
    }

    public final void setLayoutResult(TextLayoutResultProxy textLayoutResultProxy) {
        this.layoutResultState.setValue(textLayoutResultProxy);
        this.isLayoutResultStale = false;
    }

    public final AnnotatedString getUntransformedText() {
        return this.untransformedText;
    }

    public final void setUntransformedText(AnnotatedString annotatedString) {
        this.untransformedText = annotatedString;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final HandleState getHandleState() {
        return (HandleState) this.handleState.getValue();
    }

    public final void setHandleState(HandleState handleState) {
        this.handleState.setValue(handleState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getShowFloatingToolbar() {
        return ((Boolean) this.showFloatingToolbar.getValue()).booleanValue();
    }

    public final void setShowFloatingToolbar(boolean z) {
        this.showFloatingToolbar.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getShowSelectionHandleStart() {
        return ((Boolean) this.showSelectionHandleStart.getValue()).booleanValue();
    }

    public final void setShowSelectionHandleStart(boolean z) {
        this.showSelectionHandleStart.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getShowSelectionHandleEnd() {
        return ((Boolean) this.showSelectionHandleEnd.getValue()).booleanValue();
    }

    public final void setShowSelectionHandleEnd(boolean z) {
        this.showSelectionHandleEnd.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getShowCursorHandle() {
        return ((Boolean) this.showCursorHandle.getValue()).booleanValue();
    }

    public final void setShowCursorHandle(boolean z) {
        this.showCursorHandle.setValue(Boolean.valueOf(z));
    }

    /* renamed from: isLayoutResultStale, reason: from getter */
    public final boolean getIsLayoutResultStale() {
        return this.isLayoutResultStale;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isInTouchMode() {
        return ((Boolean) this.isInTouchMode.getValue()).booleanValue();
    }

    public final void setInTouchMode(boolean z) {
        this.isInTouchMode.setValue(Boolean.valueOf(z));
    }

    public final Function1<TextFieldValue, Unit> getOnValueChange() {
        return this.onValueChange;
    }

    public final Function1<ImeAction, Unit> getOnImeActionPerformed() {
        return this.onImeActionPerformed;
    }

    public final Paint getHighlightPaint() {
        return this.highlightPaint;
    }

    /* renamed from: getSelectionBackgroundColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectionBackgroundColor() {
        return this.selectionBackgroundColor;
    }

    /* renamed from: setSelectionBackgroundColor-8_81llA, reason: not valid java name */
    public final void m1341setSelectionBackgroundColor8_81llA(long j) {
        this.selectionBackgroundColor = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getSelectionPreviewHighlightRange-d9O1mEE, reason: not valid java name */
    public final long m1338getSelectionPreviewHighlightRanged9O1mEE() {
        return ((TextRange) this.selectionPreviewHighlightRange.getValue()).getPackedValue();
    }

    /* renamed from: setSelectionPreviewHighlightRange-5zc-tL8, reason: not valid java name */
    public final void m1342setSelectionPreviewHighlightRange5zctL8(long j) {
        this.selectionPreviewHighlightRange.setValue(TextRange.m4210boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getDeletionPreviewHighlightRange-d9O1mEE, reason: not valid java name */
    public final long m1335getDeletionPreviewHighlightRanged9O1mEE() {
        return ((TextRange) this.deletionPreviewHighlightRange.getValue()).getPackedValue();
    }

    /* renamed from: setDeletionPreviewHighlightRange-5zc-tL8, reason: not valid java name */
    public final void m1339setDeletionPreviewHighlightRange5zctL8(long j) {
        this.deletionPreviewHighlightRange.setValue(TextRange.m4210boximpl(j));
    }

    public final boolean hasHighlight() {
        return (TextRange.m4216getCollapsedimpl(m1338getSelectionPreviewHighlightRanged9O1mEE()) && TextRange.m4216getCollapsedimpl(m1335getDeletionPreviewHighlightRanged9O1mEE())) ? false : true;
    }

    /* renamed from: update-fnh65Uc, reason: not valid java name */
    public final void m1343updatefnh65Uc(AnnotatedString untransformedText, AnnotatedString visualText, TextStyle textStyle, boolean softWrap, Density density, FontFamily.Resolver fontFamilyResolver, Function1<? super TextFieldValue, Unit> onValueChange, KeyboardActions keyboardActions, FocusManager focusManager, long selectionBackgroundColor) {
        this.onValueChangeOriginal = onValueChange;
        this.selectionBackgroundColor = selectionBackgroundColor;
        KeyboardActionRunner keyboardActionRunner = this.keyboardActionRunner;
        keyboardActionRunner.setKeyboardActions(keyboardActions);
        keyboardActionRunner.setFocusManager(focusManager);
        this.untransformedText = untransformedText;
        TextDelegate textDelegateM1377updateTextDelegaterm0N8CA = TextDelegateKt.m1377updateTextDelegaterm0N8CA(this.textDelegate, visualText, textStyle, density, fontFamilyResolver, (448 & 32) != 0 ? true : softWrap, (448 & 64) != 0 ? TextOverflow.INSTANCE.m4675getClipgIe3tQ8() : 0, (448 & 128) != 0 ? Integer.MAX_VALUE : 0, (448 & 256) != 0 ? 1 : 0, CollectionsKt.emptyList());
        if (this.textDelegate != textDelegateM1377updateTextDelegaterm0N8CA) {
            this.isLayoutResultStale = true;
        }
        this.textDelegate = textDelegateM1377updateTextDelegaterm0N8CA;
    }
}
