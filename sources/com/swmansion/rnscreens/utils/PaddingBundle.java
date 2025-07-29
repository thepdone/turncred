package com.swmansion.rnscreens.utils;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* compiled from: PaddingBundle.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/swmansion/rnscreens/utils/PaddingBundle;", "", ViewProps.PADDING_START, "", ViewProps.PADDING_END, "(FF)V", "getPaddingEnd", "()F", "getPaddingStart", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaddingBundle {
    private final float paddingEnd;
    private final float paddingStart;

    public static /* synthetic */ PaddingBundle copy$default(PaddingBundle paddingBundle, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = paddingBundle.paddingStart;
        }
        if ((i & 2) != 0) {
            f2 = paddingBundle.paddingEnd;
        }
        return paddingBundle.copy(f, f2);
    }

    /* renamed from: component1, reason: from getter */
    public final float getPaddingStart() {
        return this.paddingStart;
    }

    /* renamed from: component2, reason: from getter */
    public final float getPaddingEnd() {
        return this.paddingEnd;
    }

    public final PaddingBundle copy(float paddingStart, float paddingEnd) {
        return new PaddingBundle(paddingStart, paddingEnd);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaddingBundle)) {
            return false;
        }
        PaddingBundle paddingBundle = (PaddingBundle) other;
        return Float.compare(this.paddingStart, paddingBundle.paddingStart) == 0 && Float.compare(this.paddingEnd, paddingBundle.paddingEnd) == 0;
    }

    public int hashCode() {
        return (Float.hashCode(this.paddingStart) * 31) + Float.hashCode(this.paddingEnd);
    }

    public String toString() {
        return "PaddingBundle(paddingStart=" + this.paddingStart + ", paddingEnd=" + this.paddingEnd + ")";
    }

    public PaddingBundle(float f, float f2) {
        this.paddingStart = f;
        this.paddingEnd = f2;
    }

    public final float getPaddingStart() {
        return this.paddingStart;
    }

    public final float getPaddingEnd() {
        return this.paddingEnd;
    }
}
