package com.facebook.imagepipeline.cache;

import androidx.camera.video.AudioStats;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.imagepipeline.cache.MemoryCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BitmapMemoryCacheTrimStrategy.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/facebook/imagepipeline/cache/BitmapMemoryCacheTrimStrategy;", "Lcom/facebook/imagepipeline/cache/MemoryCache$CacheTrimStrategy;", "()V", "getTrimRatio", "", "trimType", "Lcom/facebook/common/memory/MemoryTrimType;", "Companion", "imagepipeline-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BitmapMemoryCacheTrimStrategy implements MemoryCache.CacheTrimStrategy {
    private static final String TAG = "BitmapMemoryCacheTrimStrategy";

    /* compiled from: BitmapMemoryCacheTrimStrategy.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MemoryTrimType.values().length];
            try {
                iArr[MemoryTrimType.OnCloseToDalvikHeapLimit.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MemoryTrimType.OnAppBackgrounded.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MemoryTrimType.OnSystemMemoryCriticallyLowWhileAppInForeground.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MemoryTrimType.OnSystemLowMemoryWhileAppInForeground.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MemoryTrimType.OnSystemLowMemoryWhileAppInBackgroundLowSeverity.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy
    public double getTrimRatio(MemoryTrimType trimType) {
        Intrinsics.checkNotNullParameter(trimType, "trimType");
        int i = WhenMappings.$EnumSwitchMapping$0[trimType.ordinal()];
        if (i == 1) {
            return MemoryTrimType.OnCloseToDalvikHeapLimit.getSuggestedTrimRatio();
        }
        if (i == 2 || i == 3 || i == 4 || i == 5) {
            return 1.0d;
        }
        FLog.wtf(TAG, "unknown trim type: %s", trimType);
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }
}
