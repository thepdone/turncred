package com.facebook.fresco.animation.bitmap.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import javax.annotation.Nullable;

/* loaded from: classes4.dex */
public class AnimationFrameCacheKey implements CacheKey {
    private static final String URI_PREFIX = "anim://";
    private final String mAnimationUriString;
    private final boolean mDeepEquals;

    @Override // com.facebook.cache.common.CacheKey
    public boolean isResourceIdForDebugging() {
        return false;
    }

    public AnimationFrameCacheKey(int i) {
        this(i, false);
    }

    public AnimationFrameCacheKey(int i, boolean z) {
        this.mAnimationUriString = URI_PREFIX + i;
        this.mDeepEquals = z;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean containsUri(Uri uri) {
        return uri.toString().startsWith(this.mAnimationUriString);
    }

    @Override // com.facebook.cache.common.CacheKey
    public String getUriString() {
        return this.mAnimationUriString;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(@Nullable Object obj) {
        if (!this.mDeepEquals) {
            return super.equals(obj);
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.mAnimationUriString.equals(((AnimationFrameCacheKey) obj).mAnimationUriString);
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        if (!this.mDeepEquals) {
            return super.hashCode();
        }
        return this.mAnimationUriString.hashCode();
    }
}
