package androidx.compose.ui.input.pointer;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PointerEvent.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerEventType;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class PointerEventType {
    private final int value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Unknown = m3431constructorimpl(0);
    private static final int Press = m3431constructorimpl(1);
    private static final int Release = m3431constructorimpl(2);
    private static final int Move = m3431constructorimpl(3);
    private static final int Enter = m3431constructorimpl(4);
    private static final int Exit = m3431constructorimpl(5);
    private static final int Scroll = m3431constructorimpl(6);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PointerEventType m3430boximpl(int i) {
        return new PointerEventType(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m3431constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3432equalsimpl(int i, Object obj) {
        return (obj instanceof PointerEventType) && i == ((PointerEventType) obj).getValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3433equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3434hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m3432equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3434hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    /* compiled from: PointerEvent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerEventType$Companion;", "", "()V", ReactEditTextInputConnectionWrapper.ENTER_KEY_VALUE, "Landroidx/compose/ui/input/pointer/PointerEventType;", "getEnter-7fucELk", "()I", "I", "Exit", "getExit-7fucELk", "Move", "getMove-7fucELk", "Press", "getPress-7fucELk", "Release", "getRelease-7fucELk", "Scroll", "getScroll-7fucELk", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "getUnknown-7fucELk", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getUnknown-7fucELk, reason: not valid java name */
        public final int m3443getUnknown7fucELk() {
            return PointerEventType.Unknown;
        }

        /* renamed from: getPress-7fucELk, reason: not valid java name */
        public final int m3440getPress7fucELk() {
            return PointerEventType.Press;
        }

        /* renamed from: getRelease-7fucELk, reason: not valid java name */
        public final int m3441getRelease7fucELk() {
            return PointerEventType.Release;
        }

        /* renamed from: getMove-7fucELk, reason: not valid java name */
        public final int m3439getMove7fucELk() {
            return PointerEventType.Move;
        }

        /* renamed from: getEnter-7fucELk, reason: not valid java name */
        public final int m3437getEnter7fucELk() {
            return PointerEventType.Enter;
        }

        /* renamed from: getExit-7fucELk, reason: not valid java name */
        public final int m3438getExit7fucELk() {
            return PointerEventType.Exit;
        }

        /* renamed from: getScroll-7fucELk, reason: not valid java name */
        public final int m3442getScroll7fucELk() {
            return PointerEventType.Scroll;
        }
    }

    private /* synthetic */ PointerEventType(int i) {
        this.value = i;
    }

    public String toString() {
        return m3435toStringimpl(this.value);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3435toStringimpl(int i) {
        return m3433equalsimpl0(i, Press) ? "Press" : m3433equalsimpl0(i, Release) ? "Release" : m3433equalsimpl0(i, Move) ? "Move" : m3433equalsimpl0(i, Enter) ? ReactEditTextInputConnectionWrapper.ENTER_KEY_VALUE : m3433equalsimpl0(i, Exit) ? "Exit" : m3433equalsimpl0(i, Scroll) ? "Scroll" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }
}
