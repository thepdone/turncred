package com.facebook.react.common;

import androidx.core.util.Pools;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.sentry.rrweb.RRWebVideoEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClearableSynchronizedPool.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000f\u0010\u000b\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/react/common/ClearableSynchronizedPool;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/core/util/Pools$Pool;", SDKConstants.PARAM_CONTEXT_MAX_SIZE, "", "(I)V", "pool", "", "[Ljava/lang/Object;", RRWebVideoEvent.JsonKeys.SIZE, "acquire", "()Ljava/lang/Object;", "clear", "", "release", "", "instance", "(Ljava/lang/Object;)Z", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ClearableSynchronizedPool<T> implements Pools.Pool<T> {
    private final Object[] pool;
    private int size;

    public ClearableSynchronizedPool(int i) {
        this.pool = new Object[i];
    }

    @Override // androidx.core.util.Pools.Pool
    public synchronized T acquire() {
        int i = this.size;
        if (i == 0) {
            return null;
        }
        int i2 = i - 1;
        this.size = i2;
        T t = (T) this.pool[i2];
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of com.facebook.react.common.ClearableSynchronizedPool");
        this.pool[i2] = null;
        return t;
    }

    @Override // androidx.core.util.Pools.Pool
    public synchronized boolean release(T instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        int i = this.size;
        Object[] objArr = this.pool;
        if (i == objArr.length) {
            return false;
        }
        objArr[i] = instance;
        this.size = i + 1;
        return true;
    }

    public final synchronized void clear() {
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            this.pool[i2] = null;
        }
        this.size = 0;
    }
}
