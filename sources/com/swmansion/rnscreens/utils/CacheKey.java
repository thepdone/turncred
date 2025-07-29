package com.swmansion.rnscreens.utils;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* compiled from: ScreenDummyLayoutHelper.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/swmansion/rnscreens/utils/CacheKey;", "", ViewProps.FONT_SIZE, "", "isTitleEmpty", "", "(IZ)V", "getFontSize", "()I", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* data */ class CacheKey {
    private final int fontSize;
    private final boolean isTitleEmpty;

    public static /* synthetic */ CacheKey copy$default(CacheKey cacheKey, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = cacheKey.fontSize;
        }
        if ((i2 & 2) != 0) {
            z = cacheKey.isTitleEmpty;
        }
        return cacheKey.copy(i, z);
    }

    /* renamed from: component1, reason: from getter */
    public final int getFontSize() {
        return this.fontSize;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsTitleEmpty() {
        return this.isTitleEmpty;
    }

    public final CacheKey copy(int fontSize, boolean isTitleEmpty) {
        return new CacheKey(fontSize, isTitleEmpty);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CacheKey)) {
            return false;
        }
        CacheKey cacheKey = (CacheKey) other;
        return this.fontSize == cacheKey.fontSize && this.isTitleEmpty == cacheKey.isTitleEmpty;
    }

    public int hashCode() {
        return (Integer.hashCode(this.fontSize) * 31) + Boolean.hashCode(this.isTitleEmpty);
    }

    public String toString() {
        return "CacheKey(fontSize=" + this.fontSize + ", isTitleEmpty=" + this.isTitleEmpty + ")";
    }

    public CacheKey(int i, boolean z) {
        this.fontSize = i;
        this.isTitleEmpty = z;
    }

    public final int getFontSize() {
        return this.fontSize;
    }

    public final boolean isTitleEmpty() {
        return this.isTitleEmpty;
    }
}
