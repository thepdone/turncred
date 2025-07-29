package androidx.compose.animation.core;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* compiled from: ArcSpline.jvm.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0080\b\u001a\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0080\b¨\u0006\t"}, d2 = {"binarySearch", "", "array", "", ViewProps.POSITION, "", "toRadians", "", "value", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ArcSpline_jvmKt {
    public static final double toRadians(double d) {
        return Math.toRadians(d);
    }

    public static final int binarySearch(float[] fArr, float f) {
        return ArraysKt.binarySearch$default(fArr, f, 0, 0, 6, (Object) null);
    }
}
