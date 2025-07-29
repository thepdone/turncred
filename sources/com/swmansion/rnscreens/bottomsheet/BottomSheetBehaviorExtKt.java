package com.swmansion.rnscreens.bottomsheet;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomSheetBehaviorExt.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\u001a=\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\b\u001aW\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\u0010\u000f\u001aK\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"useSingleDetent", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "height", "", "forceExpandedState", "", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;Ljava/lang/Integer;Z)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "useThreeDetents", "state", "firstHeight", "halfExpandedRatio", "", "expandedOffsetFromTop", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "useTwoDetents", "secondHeight", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "react-native-screens_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BottomSheetBehaviorExtKt {
    public static /* synthetic */ BottomSheetBehavior useSingleDetent$default(BottomSheetBehavior bottomSheetBehavior, Integer num, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return useSingleDetent(bottomSheetBehavior, num, z);
    }

    public static final <T extends View> BottomSheetBehavior<T> useSingleDetent(BottomSheetBehavior<T> bottomSheetBehavior, Integer num, boolean z) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "<this>");
        bottomSheetBehavior.setSkipCollapsed(true);
        bottomSheetBehavior.setFitToContents(true);
        if (z) {
            bottomSheetBehavior.setState(3);
        }
        if (num != null) {
            num.intValue();
            bottomSheetBehavior.setMaxHeight(num.intValue());
        }
        return bottomSheetBehavior;
    }

    public static /* synthetic */ BottomSheetBehavior useTwoDetents$default(BottomSheetBehavior bottomSheetBehavior, Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            num3 = null;
        }
        return useTwoDetents(bottomSheetBehavior, num, num2, num3);
    }

    public static final <T extends View> BottomSheetBehavior<T> useTwoDetents(BottomSheetBehavior<T> bottomSheetBehavior, Integer num, Integer num2, Integer num3) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "<this>");
        bottomSheetBehavior.setSkipCollapsed(false);
        bottomSheetBehavior.setFitToContents(true);
        if (num != null) {
            num.intValue();
            bottomSheetBehavior.setState(num.intValue());
        }
        if (num2 != null) {
            num2.intValue();
            bottomSheetBehavior.setPeekHeight(num2.intValue());
        }
        if (num3 != null) {
            num3.intValue();
            bottomSheetBehavior.setMaxHeight(num3.intValue());
        }
        return bottomSheetBehavior;
    }

    public static /* synthetic */ BottomSheetBehavior useThreeDetents$default(BottomSheetBehavior bottomSheetBehavior, Integer num, Integer num2, Float f, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            f = null;
        }
        if ((i & 8) != 0) {
            num3 = null;
        }
        return useThreeDetents(bottomSheetBehavior, num, num2, f, num3);
    }

    public static final <T extends View> BottomSheetBehavior<T> useThreeDetents(BottomSheetBehavior<T> bottomSheetBehavior, Integer num, Integer num2, Float f, Integer num3) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "<this>");
        bottomSheetBehavior.setSkipCollapsed(false);
        bottomSheetBehavior.setFitToContents(false);
        if (num != null) {
            num.intValue();
            bottomSheetBehavior.setState(num.intValue());
        }
        if (num2 != null) {
            num2.intValue();
            bottomSheetBehavior.setPeekHeight(num2.intValue());
        }
        if (f != null) {
            f.floatValue();
            bottomSheetBehavior.setHalfExpandedRatio(f.floatValue());
        }
        if (num3 != null) {
            num3.intValue();
            bottomSheetBehavior.setExpandedOffset(num3.intValue());
        }
        return bottomSheetBehavior;
    }
}
