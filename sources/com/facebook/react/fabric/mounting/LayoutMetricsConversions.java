package com.facebook.react.fabric.mounting;

import android.view.View;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.yoga.YogaMeasureMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: LayoutMetricsConversions.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcom/facebook/react/fabric/mounting/LayoutMetricsConversions;", "", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface LayoutMetricsConversions {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @JvmStatic
    static float getMaxSize(int i) {
        return INSTANCE.getMaxSize(i);
    }

    @JvmStatic
    static float getMinSize(int i) {
        return INSTANCE.getMinSize(i);
    }

    @JvmStatic
    static YogaMeasureMode getYogaMeasureMode(float f, float f2) {
        return INSTANCE.getYogaMeasureMode(f, f2);
    }

    @JvmStatic
    static float getYogaSize(float f, float f2) {
        return INSTANCE.getYogaSize(f, f2);
    }

    /* compiled from: LayoutMetricsConversions.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0007¨\u0006\r"}, d2 = {"Lcom/facebook/react/fabric/mounting/LayoutMetricsConversions$Companion;", "", "()V", "getMaxSize", "", "viewMeasureSpec", "", "getMinSize", "getYogaMeasureMode", "Lcom/facebook/yoga/YogaMeasureMode;", SDKConstants.PARAM_CONTEXT_MIN_SIZE, SDKConstants.PARAM_CONTEXT_MAX_SIZE, "getYogaSize", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @JvmStatic
        public final float getMinSize(int viewMeasureSpec) {
            int mode = View.MeasureSpec.getMode(viewMeasureSpec);
            int size = View.MeasureSpec.getSize(viewMeasureSpec);
            if (mode == 1073741824) {
                return size;
            }
            return 0.0f;
        }

        @JvmStatic
        public final float getMaxSize(int viewMeasureSpec) {
            int mode = View.MeasureSpec.getMode(viewMeasureSpec);
            int size = View.MeasureSpec.getSize(viewMeasureSpec);
            if (mode == 0) {
                return Float.POSITIVE_INFINITY;
            }
            return size;
        }

        @JvmStatic
        public final float getYogaSize(float minSize, float maxSize) {
            if (minSize == maxSize) {
                return PixelUtil.INSTANCE.dpToPx(maxSize);
            }
            if (Float.isInfinite(maxSize)) {
                return Float.POSITIVE_INFINITY;
            }
            return PixelUtil.INSTANCE.dpToPx(maxSize);
        }

        @JvmStatic
        public final YogaMeasureMode getYogaMeasureMode(float minSize, float maxSize) {
            if (minSize == maxSize) {
                return YogaMeasureMode.EXACTLY;
            }
            if (Float.isInfinite(maxSize)) {
                return YogaMeasureMode.UNDEFINED;
            }
            return YogaMeasureMode.AT_MOST;
        }
    }
}
