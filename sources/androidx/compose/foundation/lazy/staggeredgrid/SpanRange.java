package androidx.compose.foundation.lazy.staggeredgrid;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.react.uimanager.ViewProps;
import io.sentry.rrweb.RRWebVideoEvent;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* compiled from: LazyStaggeredGridMeasure.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0081@\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0019\u0010\fJ\u0010\u0010\u001a\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0012\u0010\n\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0012\u0010\u0011\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\f\u0088\u0001\u0007¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "", "lane", "", "span", "constructor-impl", "(II)J", "packedValue", "", "(J)J", ViewProps.END, "getEnd-impl", "(J)I", "getPackedValue", "()J", RRWebVideoEvent.JsonKeys.SIZE, "getSize-impl", ViewProps.START, "getStart-impl", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(J)Ljava/lang/String;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class SpanRange {
    private final long packedValue;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SpanRange m1222boximpl(long j) {
        return new SpanRange(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static long m1224constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1225equalsimpl(long j, Object obj) {
        return (obj instanceof SpanRange) && j == ((SpanRange) obj).m1232unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1226equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getEnd-impl, reason: not valid java name */
    public static final int m1227getEndimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* renamed from: getSize-impl, reason: not valid java name */
    public static final int m1228getSizeimpl(long j) {
        return ((int) (4294967295L & j)) - ((int) (j >> 32));
    }

    /* renamed from: getStart-impl, reason: not valid java name */
    public static final int m1229getStartimpl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1230hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1231toStringimpl(long j) {
        return "SpanRange(packedValue=" + j + ')';
    }

    public boolean equals(Object obj) {
        return m1225equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1230hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m1231toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m1232unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ SpanRange(long j) {
        this.packedValue = j;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m1223constructorimpl(int i, int i2) {
        return m1224constructorimpl(((i2 + i) & 4294967295L) | (i << 32));
    }
}
