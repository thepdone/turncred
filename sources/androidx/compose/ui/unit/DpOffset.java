package androidx.compose.ui.unit;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Dp.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 %2\u00020\u0001:\u0001%B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010\u001eJ\u000f\u0010!\u001a\u00020\"H\u0017¢\u0006\u0004\b#\u0010$R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u00020\t8FX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\u00020\t8FX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\f\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, d2 = {"Landroidx/compose/ui/unit/DpOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "x", "Landroidx/compose/ui/unit/Dp;", "getX-D9Ej5fM$annotations", "getX-D9Ej5fM", "(J)F", "y", "getY-D9Ej5fM$annotations", "getY-D9Ej5fM", "copy", "copy-tPigGR8", "(JFF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "minus", "minus-CB-Mgk4", "(JJ)J", "plus", "plus-CB-Mgk4", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes4.dex */
public final class DpOffset {
    private final long packedValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m4793constructorimpl(0);
    private static final long Unspecified = m4793constructorimpl(androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpOffset m4792boximpl(long j) {
        return new DpOffset(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m4793constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4796equalsimpl(long j, Object obj) {
        return (obj instanceof DpOffset) && j == ((DpOffset) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4797equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* renamed from: getX-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m4799getXD9Ej5fM$annotations() {
    }

    /* renamed from: getY-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m4801getYD9Ej5fM$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4802hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m4796equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m4802hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ DpOffset(long j) {
        this.packedValue = j;
    }

    /* renamed from: copy-tPigGR8$default, reason: not valid java name */
    public static /* synthetic */ long m4795copytPigGR8$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m4798getXD9Ej5fM(j);
        }
        if ((i & 2) != 0) {
            f2 = m4800getYD9Ej5fM(j);
        }
        return m4794copytPigGR8(j, f, f2);
    }

    /* renamed from: minus-CB-Mgk4, reason: not valid java name */
    public static final long m4803minusCBMgk4(long j, long j2) {
        float fM4737constructorimpl = Dp.m4737constructorimpl(m4798getXD9Ej5fM(j) - m4798getXD9Ej5fM(j2));
        float fM4737constructorimpl2 = Dp.m4737constructorimpl(m4800getYD9Ej5fM(j) - m4800getYD9Ej5fM(j2));
        return m4793constructorimpl((Float.floatToRawIntBits(fM4737constructorimpl) << 32) | (4294967295L & Float.floatToRawIntBits(fM4737constructorimpl2)));
    }

    /* renamed from: plus-CB-Mgk4, reason: not valid java name */
    public static final long m4804plusCBMgk4(long j, long j2) {
        float fM4737constructorimpl = Dp.m4737constructorimpl(m4798getXD9Ej5fM(j) + m4798getXD9Ej5fM(j2));
        float fM4737constructorimpl2 = Dp.m4737constructorimpl(m4800getYD9Ej5fM(j) + m4800getYD9Ej5fM(j2));
        return m4793constructorimpl((Float.floatToRawIntBits(fM4737constructorimpl) << 32) | (4294967295L & Float.floatToRawIntBits(fM4737constructorimpl2)));
    }

    public String toString() {
        return m4805toStringimpl(this.packedValue);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4805toStringimpl(long j) {
        if (j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
            return "(" + ((Object) Dp.m4748toStringimpl(m4798getXD9Ej5fM(j))) + ", " + ((Object) Dp.m4748toStringimpl(m4800getYD9Ej5fM(j))) + ')';
        }
        return "DpOffset.Unspecified";
    }

    /* compiled from: Dp.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/ui/unit/DpOffset$Companion;", "", "()V", "Unspecified", "Landroidx/compose/ui/unit/DpOffset;", "getUnspecified-RKDOV3M", "()J", "J", "Zero", "getZero-RKDOV3M", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getZero-RKDOV3M, reason: not valid java name */
        public final long m4808getZeroRKDOV3M() {
            return DpOffset.Zero;
        }

        /* renamed from: getUnspecified-RKDOV3M, reason: not valid java name */
        public final long m4807getUnspecifiedRKDOV3M() {
            return DpOffset.Unspecified;
        }
    }

    /* renamed from: getX-D9Ej5fM, reason: not valid java name */
    public static final float m4798getXD9Ej5fM(long j) {
        return Dp.m4737constructorimpl(Float.intBitsToFloat((int) (j >> 32)));
    }

    /* renamed from: getY-D9Ej5fM, reason: not valid java name */
    public static final float m4800getYD9Ej5fM(long j) {
        return Dp.m4737constructorimpl(Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    /* renamed from: copy-tPigGR8, reason: not valid java name */
    public static final long m4794copytPigGR8(long j, float f, float f2) {
        return m4793constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L));
    }
}
