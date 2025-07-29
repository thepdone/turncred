package androidx.compose.ui.text.input;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ImeAction.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/input/ImeAction;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes4.dex */
public final class ImeAction {
    private final int value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Unspecified = m4385constructorimpl(-1);
    private static final int Default = m4385constructorimpl(1);
    private static final int None = m4385constructorimpl(0);
    private static final int Go = m4385constructorimpl(2);
    private static final int Search = m4385constructorimpl(3);
    private static final int Send = m4385constructorimpl(4);
    private static final int Previous = m4385constructorimpl(5);
    private static final int Next = m4385constructorimpl(6);
    private static final int Done = m4385constructorimpl(7);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ImeAction m4384boximpl(int i) {
        return new ImeAction(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m4385constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4386equalsimpl(int i, Object obj) {
        return (obj instanceof ImeAction) && i == ((ImeAction) obj).getValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4387equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4388hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m4386equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4388hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    private /* synthetic */ ImeAction(int i) {
        this.value = i;
    }

    public String toString() {
        return m4389toStringimpl(this.value);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4389toStringimpl(int i) {
        return m4387equalsimpl0(i, Unspecified) ? "Unspecified" : m4387equalsimpl0(i, None) ? "None" : m4387equalsimpl0(i, Default) ? "Default" : m4387equalsimpl0(i, Go) ? "Go" : m4387equalsimpl0(i, Search) ? "Search" : m4387equalsimpl0(i, Send) ? "Send" : m4387equalsimpl0(i, Previous) ? "Previous" : m4387equalsimpl0(i, Next) ? "Next" : m4387equalsimpl0(i, Done) ? "Done" : "Invalid";
    }

    /* compiled from: ImeAction.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007R$\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007R$\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0007R$\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0007R$\u0010\u0015\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u0007R$\u0010\u0018\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\u0007R$\u0010\u001b\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u001c\u0010\u0002\u001a\u0004\b\u001d\u0010\u0007R$\u0010\u001e\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/compose/ui/text/input/ImeAction$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/input/ImeAction;", "getDefault-eUduSuo$annotations", "getDefault-eUduSuo", "()I", "I", "Done", "getDone-eUduSuo$annotations", "getDone-eUduSuo", "Go", "getGo-eUduSuo$annotations", "getGo-eUduSuo", "Next", "getNext-eUduSuo$annotations", "getNext-eUduSuo", "None", "getNone-eUduSuo$annotations", "getNone-eUduSuo", "Previous", "getPrevious-eUduSuo$annotations", "getPrevious-eUduSuo", "Search", "getSearch-eUduSuo$annotations", "getSearch-eUduSuo", "Send", "getSend-eUduSuo$annotations", "getSend-eUduSuo", "Unspecified", "getUnspecified-eUduSuo$annotations", "getUnspecified-eUduSuo", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getDefault-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m4391getDefaulteUduSuo$annotations() {
        }

        /* renamed from: getDone-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m4392getDoneeUduSuo$annotations() {
        }

        /* renamed from: getGo-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m4393getGoeUduSuo$annotations() {
        }

        /* renamed from: getNext-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m4394getNexteUduSuo$annotations() {
        }

        /* renamed from: getNone-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m4395getNoneeUduSuo$annotations() {
        }

        /* renamed from: getPrevious-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m4396getPreviouseUduSuo$annotations() {
        }

        /* renamed from: getSearch-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m4397getSearcheUduSuo$annotations() {
        }

        /* renamed from: getSend-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m4398getSendeUduSuo$annotations() {
        }

        /* renamed from: getUnspecified-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m4399getUnspecifiedeUduSuo$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getUnspecified-eUduSuo, reason: not valid java name */
        public final int m4408getUnspecifiedeUduSuo() {
            return ImeAction.Unspecified;
        }

        /* renamed from: getDefault-eUduSuo, reason: not valid java name */
        public final int m4400getDefaulteUduSuo() {
            return ImeAction.Default;
        }

        /* renamed from: getNone-eUduSuo, reason: not valid java name */
        public final int m4404getNoneeUduSuo() {
            return ImeAction.None;
        }

        /* renamed from: getGo-eUduSuo, reason: not valid java name */
        public final int m4402getGoeUduSuo() {
            return ImeAction.Go;
        }

        /* renamed from: getSearch-eUduSuo, reason: not valid java name */
        public final int m4406getSearcheUduSuo() {
            return ImeAction.Search;
        }

        /* renamed from: getSend-eUduSuo, reason: not valid java name */
        public final int m4407getSendeUduSuo() {
            return ImeAction.Send;
        }

        /* renamed from: getPrevious-eUduSuo, reason: not valid java name */
        public final int m4405getPreviouseUduSuo() {
            return ImeAction.Previous;
        }

        /* renamed from: getNext-eUduSuo, reason: not valid java name */
        public final int m4403getNexteUduSuo() {
            return ImeAction.Next;
        }

        /* renamed from: getDone-eUduSuo, reason: not valid java name */
        public final int m4401getDoneeUduSuo() {
            return ImeAction.Done;
        }
    }
}
