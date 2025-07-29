package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jose.util.cache.CachedObject;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes5.dex */
abstract class AbstractCachingJWKSetSource<C extends SecurityContext> extends JWKSetSourceWrapper<C> {
    private volatile CachedObject<JWKSet> cachedJWKSet;
    private final long timeToLive;

    AbstractCachingJWKSetSource(JWKSetSource<C> jWKSetSource, long j) {
        super(jWKSetSource);
        this.timeToLive = j;
    }

    CachedObject<JWKSet> getCachedJWKSet() {
        return this.cachedJWKSet;
    }

    void setCachedJWKSet(CachedObject<JWKSet> cachedObject) {
        this.cachedJWKSet = cachedObject;
    }

    CachedObject<JWKSet> getCachedJWKSetIfValid(long j) {
        CachedObject<JWKSet> cachedJWKSet = getCachedJWKSet();
        if (cachedJWKSet == null || !cachedJWKSet.isValid(j)) {
            return null;
        }
        return cachedJWKSet;
    }

    public long getTimeToLive() {
        return this.timeToLive;
    }

    CachedObject<JWKSet> cacheJWKSet(JWKSet jWKSet, long j) {
        CachedObject<JWKSet> cachedObject = new CachedObject<>(jWKSet, currentTimeMillis(), CachedObject.computeExpirationTime(j, getTimeToLive()));
        setCachedJWKSet(cachedObject);
        return cachedObject;
    }

    long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
