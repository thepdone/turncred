package com.swmansion.rnscreens.utils;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScreenDummyLayoutHelper.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/swmansion/rnscreens/utils/CacheEntry;", "", "cacheKey", "Lcom/swmansion/rnscreens/utils/CacheKey;", "headerHeight", "", "(Lcom/swmansion/rnscreens/utils/CacheKey;F)V", "getCacheKey", "()Lcom/swmansion/rnscreens/utils/CacheKey;", "getHeaderHeight", "()F", "hasKey", "", SDKConstants.PARAM_KEY, "Companion", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
final class CacheEntry {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CacheEntry EMPTY = new CacheEntry(new CacheKey(Integer.MIN_VALUE, false), 0.0f);
    private final CacheKey cacheKey;
    private final float headerHeight;

    public CacheEntry(CacheKey cacheKey, float f) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        this.cacheKey = cacheKey;
        this.headerHeight = f;
    }

    public final CacheKey getCacheKey() {
        return this.cacheKey;
    }

    public final float getHeaderHeight() {
        return this.headerHeight;
    }

    public final boolean hasKey(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.cacheKey.getFontSize() != Integer.MIN_VALUE && Intrinsics.areEqual(this.cacheKey, key);
    }

    /* compiled from: ScreenDummyLayoutHelper.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/swmansion/rnscreens/utils/CacheEntry$Companion;", "", "()V", "EMPTY", "Lcom/swmansion/rnscreens/utils/CacheEntry;", "getEMPTY", "()Lcom/swmansion/rnscreens/utils/CacheEntry;", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CacheEntry getEMPTY() {
            return CacheEntry.EMPTY;
        }
    }
}
