package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.unit.Density;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: InlineDensity.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0081@\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\bB\u0011\b\u0002\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\t\u0092\u0001\u00020\n¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/text/modifiers/InlineDensity;", "", "density", "", "fontScale", "constructor-impl", "(FF)J", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/ui/unit/Density;)J", "packedValue", "", "(J)J", "getDensity-impl", "(J)F", "getFontScale-impl", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class InlineDensity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Unspecified = m1609constructorimpl(Float.NaN, Float.NaN);
    private final long packedValue;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ InlineDensity m1608boximpl(long j) {
        return new InlineDensity(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static long m1610constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1612equalsimpl(long j, Object obj) {
        return (obj instanceof InlineDensity) && j == ((InlineDensity) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1613equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1616hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m1612equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1616hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ InlineDensity(long j) {
        this.packedValue = j;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m1611constructorimpl(Density density) {
        return m1609constructorimpl(density.getDensity(), density.getFontScale());
    }

    public String toString() {
        return m1617toStringimpl(this.packedValue);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1617toStringimpl(long j) {
        return "InlineDensity(density=" + m1614getDensityimpl(j) + ", fontScale=" + m1615getFontScaleimpl(j) + ')';
    }

    /* compiled from: InlineDensity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text/modifiers/InlineDensity$Companion;", "", "()V", "Unspecified", "Landroidx/compose/foundation/text/modifiers/InlineDensity;", "getUnspecified-L26CHvs", "()J", "J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getUnspecified-L26CHvs, reason: not valid java name */
        public final long m1619getUnspecifiedL26CHvs() {
            return InlineDensity.Unspecified;
        }
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m1609constructorimpl(float f, float f2) {
        return m1610constructorimpl((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    /* renamed from: getDensity-impl, reason: not valid java name */
    public static final float m1614getDensityimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: getFontScale-impl, reason: not valid java name */
    public static final float m1615getFontScaleimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }
}
