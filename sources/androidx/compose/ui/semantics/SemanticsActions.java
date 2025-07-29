package androidx.compose.ui.semantics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: SemanticsProperties.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R#\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR#\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR#\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR#\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\tR#\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\tR/\u0010\u0018\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\tR/\u0010\u001d\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001a\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\tR)\u0010 \u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\tR,\u0010#\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\tR#\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\tR#\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\tR#\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\tR#\u0010+\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\tR#\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\tR#\u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\tR#\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\tR#\u00103\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\tR.\u00105\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u0002\u001a\u0004\b7\u0010\tR#\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\tRM\u0010:\u001a>\u0012:\u00128\u00124\u00122\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\u00070;0\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\tRB\u0010A\u001a3\u0012/\u0012-\b\u0001\u0012\u0013\u0012\u00110B¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(C\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0D\u0012\u0006\u0012\u0004\u0018\u00010\u00010;0\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\tR)\u0010F\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\tR8\u0010I\u001a)\u0012%\u0012#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\tR5\u0010L\u001a&\u0012\"\u0012 \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070M0\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\tR)\u0010O\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\tR)\u0010Q\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\tR)\u0010S\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\t¨\u0006U"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsActions;", "", "()V", "ClearTextSubstitution", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/compose/ui/semantics/AccessibilityAction;", "Lkotlin/Function0;", "", "getClearTextSubstitution", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Collapse", "getCollapse", "CopyText", "getCopyText", "CustomActions", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "getCustomActions", "CutText", "getCutText", "Dismiss", "getDismiss", "Expand", "getExpand", "GetScrollViewportLength", "Lkotlin/Function1;", "", "", "getGetScrollViewportLength", "GetTextLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "getGetTextLayoutResult", "InsertTextAtCursor", "Landroidx/compose/ui/text/AnnotatedString;", "getInsertTextAtCursor", "OnAutofillText", "getOnAutofillText$ui_release", "OnClick", "getOnClick", "OnImeAction", "getOnImeAction", "OnLongClick", "getOnLongClick", "PageDown", "getPageDown", "PageLeft", "getPageLeft", "PageRight", "getPageRight", "PageUp", "getPageUp", "PasteText", "getPasteText", "PerformImeAction", "getPerformImeAction$annotations", "getPerformImeAction", "RequestFocus", "getRequestFocus", "ScrollBy", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "x", "y", "getScrollBy", "ScrollByOffset", "Landroidx/compose/ui/geometry/Offset;", "offset", "Lkotlin/coroutines/Continuation;", "getScrollByOffset", "ScrollToIndex", "", "getScrollToIndex", "SetProgress", "progress", "getSetProgress", "SetSelection", "Lkotlin/Function3;", "getSetSelection", "SetText", "getSetText", "SetTextSubstitution", "getSetTextSubstitution", "ShowTextSubstitution", "getShowTextSubstitution", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SemanticsActions {
    public static final SemanticsActions INSTANCE = new SemanticsActions();
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<List<TextLayoutResult>, Boolean>>> GetTextLayoutResult = SemanticsPropertiesKt.AccessibilityKey("GetTextLayoutResult", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> OnClick = SemanticsPropertiesKt.AccessibilityKey("OnClick", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> OnLongClick = SemanticsPropertiesKt.AccessibilityKey("OnLongClick", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function2<Float, Float, Boolean>>> ScrollBy = SemanticsPropertiesKt.AccessibilityKey("ScrollBy", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<Function2<Offset, Continuation<? super Offset>, Object>> ScrollByOffset = new SemanticsPropertyKey<>("ScrollByOffset", null, 2, null);
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<Integer, Boolean>>> ScrollToIndex = SemanticsPropertiesKt.AccessibilityKey("ScrollToIndex", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> OnAutofillText = SemanticsPropertiesKt.AccessibilityKey("OnAutofillText", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<Float, Boolean>>> SetProgress = SemanticsPropertiesKt.AccessibilityKey("SetProgress", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function3<Integer, Integer, Boolean, Boolean>>> SetSelection = SemanticsPropertiesKt.AccessibilityKey("SetSelection", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> SetText = SemanticsPropertiesKt.AccessibilityKey("SetText", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> SetTextSubstitution = SemanticsPropertiesKt.AccessibilityKey("SetTextSubstitution", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<Boolean, Boolean>>> ShowTextSubstitution = SemanticsPropertiesKt.AccessibilityKey("ShowTextSubstitution", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> ClearTextSubstitution = SemanticsPropertiesKt.AccessibilityKey("ClearTextSubstitution", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> InsertTextAtCursor = SemanticsPropertiesKt.AccessibilityKey("InsertTextAtCursor", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> OnImeAction = SemanticsPropertiesKt.AccessibilityKey("PerformImeAction", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PerformImeAction = SemanticsPropertiesKt.AccessibilityKey("PerformImeAction", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> CopyText = SemanticsPropertiesKt.AccessibilityKey("CopyText", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> CutText = SemanticsPropertiesKt.AccessibilityKey("CutText", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PasteText = SemanticsPropertiesKt.AccessibilityKey("PasteText", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> Expand = SemanticsPropertiesKt.AccessibilityKey("Expand", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> Collapse = SemanticsPropertiesKt.AccessibilityKey("Collapse", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> Dismiss = SemanticsPropertiesKt.AccessibilityKey("Dismiss", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> RequestFocus = SemanticsPropertiesKt.AccessibilityKey("RequestFocus", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<List<CustomAccessibilityAction>> CustomActions = SemanticsPropertiesKt.AccessibilityKey("CustomActions");
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PageUp = SemanticsPropertiesKt.AccessibilityKey("PageUp", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PageLeft = SemanticsPropertiesKt.AccessibilityKey("PageLeft", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PageDown = SemanticsPropertiesKt.AccessibilityKey("PageDown", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PageRight = SemanticsPropertiesKt.AccessibilityKey("PageRight", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<List<Float>, Boolean>>> GetScrollViewportLength = SemanticsPropertiesKt.AccessibilityKey("GetScrollViewportLength", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    public static final int $stable = 8;

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `SemanticsActions.OnImeAction` instead.", replaceWith = @ReplaceWith(expression = "OnImeAction", imports = {"androidx.compose.ui.semantics.SemanticsActions.OnImeAction"}))
    public static /* synthetic */ void getPerformImeAction$annotations() {
    }

    private SemanticsActions() {
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function1<List<TextLayoutResult>, Boolean>>> getGetTextLayoutResult() {
        return GetTextLayoutResult;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getOnClick() {
        return OnClick;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getOnLongClick() {
        return OnLongClick;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function2<Float, Float, Boolean>>> getScrollBy() {
        return ScrollBy;
    }

    public final SemanticsPropertyKey<Function2<Offset, Continuation<? super Offset>, Object>> getScrollByOffset() {
        return ScrollByOffset;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function1<Integer, Boolean>>> getScrollToIndex() {
        return ScrollToIndex;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> getOnAutofillText$ui_release() {
        return OnAutofillText;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function1<Float, Boolean>>> getSetProgress() {
        return SetProgress;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function3<Integer, Integer, Boolean, Boolean>>> getSetSelection() {
        return SetSelection;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> getSetText() {
        return SetText;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> getSetTextSubstitution() {
        return SetTextSubstitution;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function1<Boolean, Boolean>>> getShowTextSubstitution() {
        return ShowTextSubstitution;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getClearTextSubstitution() {
        return ClearTextSubstitution;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> getInsertTextAtCursor() {
        return InsertTextAtCursor;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getOnImeAction() {
        return OnImeAction;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPerformImeAction() {
        return PerformImeAction;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getCopyText() {
        return CopyText;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getCutText() {
        return CutText;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPasteText() {
        return PasteText;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getExpand() {
        return Expand;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getCollapse() {
        return Collapse;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getDismiss() {
        return Dismiss;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getRequestFocus() {
        return RequestFocus;
    }

    public final SemanticsPropertyKey<List<CustomAccessibilityAction>> getCustomActions() {
        return CustomActions;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPageUp() {
        return PageUp;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPageLeft() {
        return PageLeft;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPageDown() {
        return PageDown;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPageRight() {
        return PageRight;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function1<List<Float>, Boolean>>> getGetScrollViewportLength() {
        return GetScrollViewportLength;
    }
}
