package androidx.compose.runtime.internal;

import kotlin.Metadata;

/* compiled from: FloatingPointEquality.android.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0080\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0080\b\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0005¨\u0006\b"}, d2 = {"isNan", "", "", "(D)Z", "", "(F)Z", "equalsWithNanFix", "other", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FloatingPointEquality_androidKt {
    public static final boolean equalsWithNanFix(double d, double d2) {
        return d == d2;
    }

    public static final boolean equalsWithNanFix(float f, float f2) {
        return f == f2;
    }

    public static final boolean isNan(float f) {
        return (Float.floatToRawIntBits(f) & Integer.MAX_VALUE) > 2139095040;
    }

    public static final boolean isNan(double d) {
        return (Double.doubleToRawLongBits(d) & Long.MAX_VALUE) > 9218868437227405312L;
    }
}
