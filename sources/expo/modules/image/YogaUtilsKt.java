package expo.modules.image;

import com.facebook.yoga.YogaConstants;
import io.sentry.protocol.SentryThread;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: YogaUtils.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a3\u0010\u0003\u001a\u00020\u0001*\u00020\u00012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0086\bø\u0001\u0000\u001a\u0012\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {"makeYogaUndefinedIfNegative", "", "value", "ifYogaDefinedUse", "transformFun", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", SentryThread.JsonKeys.CURRENT, "ifYogaUndefinedUse", "expo-image_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class YogaUtilsKt {
    public static final float ifYogaUndefinedUse(float f, float f2) {
        return YogaConstants.isUndefined(f) ? f2 : f;
    }

    public static final float ifYogaDefinedUse(float f, Function1<? super Float, Float> transformFun) {
        Intrinsics.checkNotNullParameter(transformFun, "transformFun");
        return YogaConstants.isUndefined(f) ? f : transformFun.invoke(Float.valueOf(f)).floatValue();
    }

    public static final float makeYogaUndefinedIfNegative(float f) {
        if (YogaConstants.isUndefined(f) || f >= 0.0f) {
            return f;
        }
        return Float.NaN;
    }
}
