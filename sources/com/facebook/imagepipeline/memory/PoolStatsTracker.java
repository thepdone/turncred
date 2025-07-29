package com.facebook.imagepipeline.memory;

import io.sentry.rrweb.RRWebVideoEvent;
import kotlin.Metadata;

/* compiled from: PoolStatsTracker.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H&J\u0014\u0010\r\u001a\u00020\u00032\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH&¨\u0006\u0011"}, d2 = {"Lcom/facebook/imagepipeline/memory/PoolStatsTracker;", "", "onAlloc", "", RRWebVideoEvent.JsonKeys.SIZE, "", "onFree", "sizeInBytes", "onHardCapReached", "onSoftCapReached", "onValueRelease", "onValueReuse", "bucketedSize", "setBasePool", "basePool", "Lcom/facebook/imagepipeline/memory/BasePool;", "Companion", "imagepipeline_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface PoolStatsTracker {
    public static final String BUCKETS_USED_PREFIX = "buckets_used_";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String FREE_BYTES = "free_bytes";
    public static final String FREE_COUNT = "free_count";
    public static final String HARD_CAP = "hard_cap";
    public static final String SOFT_CAP = "soft_cap";
    public static final String USED_BYTES = "used_bytes";
    public static final String USED_COUNT = "used_count";

    void onAlloc(int size);

    void onFree(int sizeInBytes);

    void onHardCapReached();

    void onSoftCapReached();

    void onValueRelease(int sizeInBytes);

    void onValueReuse(int bucketedSize);

    void setBasePool(BasePool<?> basePool);

    /* compiled from: PoolStatsTracker.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/facebook/imagepipeline/memory/PoolStatsTracker$Companion;", "", "()V", "BUCKETS_USED_PREFIX", "", "FREE_BYTES", "FREE_COUNT", "HARD_CAP", "SOFT_CAP", "USED_BYTES", "USED_COUNT", "imagepipeline_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String BUCKETS_USED_PREFIX = "buckets_used_";
        public static final String FREE_BYTES = "free_bytes";
        public static final String FREE_COUNT = "free_count";
        public static final String HARD_CAP = "hard_cap";
        public static final String SOFT_CAP = "soft_cap";
        public static final String USED_BYTES = "used_bytes";
        public static final String USED_COUNT = "used_count";

        private Companion() {
        }
    }
}
