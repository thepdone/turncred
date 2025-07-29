package com.facebook.imagepipeline.core;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.callercontext.CallerContextVerifier;
import com.facebook.common.executors.SerialExecutorService;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.bitmaps.HoneycombBitmapCreator;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheTrimStrategy;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.CountingLruBitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultEncodedMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.cache.NativeMemoryCacheTrimStrategy;
import com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker;
import com.facebook.imagepipeline.core.ImagePipelineExperiments;
import com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker;
import com.facebook.imagepipeline.debug.NoOpCloseableReferenceLeakTracker;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoderConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.memory.PoolConfig;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.producers.CustomProducerSequenceFactory;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImagePipelineConfig.kt */
@Metadata(d1 = {"\u0000 \u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u0099\u00012\u00020\u0001:\u0006\u0098\u0001\u0099\u0001\u009a\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\"\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010$\u001a\u0004\u0018\u00010%X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020-X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020201X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u000206X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\"\u00109\u001a\u0010\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<\u0018\u00010:X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u001bR\"\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020C\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\nR\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u001bR\u0014\u0010G\u001a\u00020\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u001fR\u0016\u0010I\u001a\u0004\u0018\u00010JX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0014\u0010M\u001a\u00020NX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0014\u0010Q\u001a\u00020RX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0014\u0010U\u001a\u00020VX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u000e\u0010Y\u001a\u00020ZX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010[\u001a\u00020\\X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u0016\u0010_\u001a\u0004\u0018\u00010`X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010bR\u0016\u0010c\u001a\u0004\u0018\u00010dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u0016\u0010g\u001a\u0004\u0018\u00010hX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010jR \u0010k\u001a\u0004\u0018\u00010Z8VX\u0096\u0004¢\u0006\u0010\n\u0002\u0010p\u0012\u0004\bl\u0010m\u001a\u0004\bn\u0010oR\u0014\u0010q\u001a\u00020@X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010rR\u001a\u0010s\u001a\b\u0012\u0004\u0012\u00020@0\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010\u001bR\u0014\u0010t\u001a\u00020@X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010rR\u0014\u0010u\u001a\u00020<X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010wR\u001c\u0010x\u001a\u00020Z8VX\u0096\u0004¢\u0006\u000e\n\u0000\u0012\u0004\by\u0010m\u001a\u0004\bz\u0010{R\u0014\u0010|\u001a\u00020}X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b~\u0010\u007fR\u001c\u0010\u0080\u0001\u001a\u0007\u0012\u0002\b\u00030\u0081\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001a\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0018\u0010\u0088\u0001\u001a\u00030\u0089\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0018\u0010\u008c\u0001\u001a\u00030\u008d\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001d\u0010\u0090\u0001\u001a\t\u0012\u0005\u0012\u00030\u0091\u000101X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0092\u0001\u00104R\u001d\u0010\u0093\u0001\u001a\t\u0012\u0005\u0012\u00030\u0094\u000101X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0095\u0001\u00104R\u0016\u0010\u0096\u0001\u001a\u00020<X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0097\u0001\u0010w¨\u0006\u009b\u0001"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineConfig;", "Lcom/facebook/imagepipeline/core/ImagePipelineConfigInterface;", "builder", "Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;", "(Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;)V", "bitmapCacheOverride", "Lcom/facebook/imagepipeline/cache/MemoryCache;", "Lcom/facebook/cache/common/CacheKey;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "getBitmapCacheOverride", "()Lcom/facebook/imagepipeline/cache/MemoryCache;", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "getBitmapConfig", "()Landroid/graphics/Bitmap$Config;", "bitmapMemoryCacheEntryStateObserver", "Lcom/facebook/imagepipeline/cache/CountingMemoryCache$EntryStateObserver;", "getBitmapMemoryCacheEntryStateObserver", "()Lcom/facebook/imagepipeline/cache/CountingMemoryCache$EntryStateObserver;", "bitmapMemoryCacheFactory", "Lcom/facebook/imagepipeline/cache/BitmapMemoryCacheFactory;", "getBitmapMemoryCacheFactory", "()Lcom/facebook/imagepipeline/cache/BitmapMemoryCacheFactory;", "bitmapMemoryCacheParamsSupplier", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/imagepipeline/cache/MemoryCacheParams;", "getBitmapMemoryCacheParamsSupplier", "()Lcom/facebook/common/internal/Supplier;", "bitmapMemoryCacheTrimStrategy", "Lcom/facebook/imagepipeline/cache/MemoryCache$CacheTrimStrategy;", "getBitmapMemoryCacheTrimStrategy", "()Lcom/facebook/imagepipeline/cache/MemoryCache$CacheTrimStrategy;", "cacheKeyFactory", "Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "getCacheKeyFactory", "()Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "callerContextVerifier", "Lcom/facebook/callercontext/CallerContextVerifier;", "getCallerContextVerifier", "()Lcom/facebook/callercontext/CallerContextVerifier;", "closeableReferenceLeakTracker", "Lcom/facebook/imagepipeline/debug/CloseableReferenceLeakTracker;", "getCloseableReferenceLeakTracker", "()Lcom/facebook/imagepipeline/debug/CloseableReferenceLeakTracker;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "customProducerSequenceFactories", "", "Lcom/facebook/imagepipeline/producers/CustomProducerSequenceFactory;", "getCustomProducerSequenceFactories", "()Ljava/util/Set;", "downsampleMode", "Lcom/facebook/imagepipeline/core/DownsampleMode;", "getDownsampleMode", "()Lcom/facebook/imagepipeline/core/DownsampleMode;", "dynamicDiskCacheConfigMap", "", "", "Lcom/facebook/cache/disk/DiskCacheConfig;", "getDynamicDiskCacheConfigMap", "()Ljava/util/Map;", "enableEncodedImageColorSpaceUsage", "", "getEnableEncodedImageColorSpaceUsage", "encodedMemoryCacheOverride", "Lcom/facebook/common/memory/PooledByteBuffer;", "getEncodedMemoryCacheOverride", "encodedMemoryCacheParamsSupplier", "getEncodedMemoryCacheParamsSupplier", "encodedMemoryCacheTrimStrategy", "getEncodedMemoryCacheTrimStrategy", "executorServiceForAnimatedImages", "Lcom/facebook/common/executors/SerialExecutorService;", "getExecutorServiceForAnimatedImages", "()Lcom/facebook/common/executors/SerialExecutorService;", "executorSupplier", "Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "getExecutorSupplier", "()Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "experiments", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments;", "getExperiments", "()Lcom/facebook/imagepipeline/core/ImagePipelineExperiments;", "fileCacheFactory", "Lcom/facebook/imagepipeline/core/FileCacheFactory;", "getFileCacheFactory", "()Lcom/facebook/imagepipeline/core/FileCacheFactory;", "httpNetworkTimeout", "", "imageCacheStatsTracker", "Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;", "getImageCacheStatsTracker", "()Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;", "imageDecoder", "Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "getImageDecoder", "()Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "imageDecoderConfig", "Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig;", "getImageDecoderConfig", "()Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig;", "imageTranscoderFactory", "Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;", "getImageTranscoderFactory", "()Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;", "imageTranscoderType", "getImageTranscoderType$annotations", "()V", "getImageTranscoderType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "isDiskCacheEnabled", "()Z", "isPrefetchEnabledSupplier", "isResizeAndRotateEnabledForNetwork", "mainDiskCacheConfig", "getMainDiskCacheConfig", "()Lcom/facebook/cache/disk/DiskCacheConfig;", "memoryChunkType", "getMemoryChunkType$annotations", "getMemoryChunkType", "()I", "memoryTrimmableRegistry", "Lcom/facebook/common/memory/MemoryTrimmableRegistry;", "getMemoryTrimmableRegistry", "()Lcom/facebook/common/memory/MemoryTrimmableRegistry;", "networkFetcher", "Lcom/facebook/imagepipeline/producers/NetworkFetcher;", "getNetworkFetcher", "()Lcom/facebook/imagepipeline/producers/NetworkFetcher;", "platformBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "getPlatformBitmapFactory", "()Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "poolFactory", "Lcom/facebook/imagepipeline/memory/PoolFactory;", "getPoolFactory", "()Lcom/facebook/imagepipeline/memory/PoolFactory;", "progressiveJpegConfig", "Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "getProgressiveJpegConfig", "()Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "requestListener2s", "Lcom/facebook/imagepipeline/listener/RequestListener2;", "getRequestListener2s", "requestListeners", "Lcom/facebook/imagepipeline/listener/RequestListener;", "getRequestListeners", "smallImageDiskCacheConfig", "getSmallImageDiskCacheConfig", "Builder", "Companion", "DefaultImageRequestConfig", "imagepipeline_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ImagePipelineConfig implements ImagePipelineConfigInterface {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static DefaultImageRequestConfig defaultImageRequestConfig = new DefaultImageRequestConfig();
    private final MemoryCache<CacheKey, CloseableImage> bitmapCacheOverride;
    private final Bitmap.Config bitmapConfig;
    private final CountingMemoryCache.EntryStateObserver<CacheKey> bitmapMemoryCacheEntryStateObserver;
    private final BitmapMemoryCacheFactory bitmapMemoryCacheFactory;
    private final Supplier<MemoryCacheParams> bitmapMemoryCacheParamsSupplier;
    private final MemoryCache.CacheTrimStrategy bitmapMemoryCacheTrimStrategy;
    private final CacheKeyFactory cacheKeyFactory;
    private final CallerContextVerifier callerContextVerifier;
    private final CloseableReferenceLeakTracker closeableReferenceLeakTracker;
    private final Context context;
    private final Set<CustomProducerSequenceFactory> customProducerSequenceFactories;
    private final DownsampleMode downsampleMode;
    private final Map<String, DiskCacheConfig> dynamicDiskCacheConfigMap;
    private final Supplier<Boolean> enableEncodedImageColorSpaceUsage;
    private final MemoryCache<CacheKey, PooledByteBuffer> encodedMemoryCacheOverride;
    private final Supplier<MemoryCacheParams> encodedMemoryCacheParamsSupplier;
    private final MemoryCache.CacheTrimStrategy encodedMemoryCacheTrimStrategy;
    private final SerialExecutorService executorServiceForAnimatedImages;
    private final ExecutorSupplier executorSupplier;
    private final ImagePipelineExperiments experiments;
    private final FileCacheFactory fileCacheFactory;
    private final int httpNetworkTimeout;
    private final ImageCacheStatsTracker imageCacheStatsTracker;
    private final ImageDecoder imageDecoder;
    private final ImageDecoderConfig imageDecoderConfig;
    private final ImageTranscoderFactory imageTranscoderFactory;
    private final Integer imageTranscoderType;
    private final boolean isDiskCacheEnabled;
    private final Supplier<Boolean> isPrefetchEnabledSupplier;
    private final boolean isResizeAndRotateEnabledForNetwork;
    private final DiskCacheConfig mainDiskCacheConfig;
    private final int memoryChunkType;
    private final MemoryTrimmableRegistry memoryTrimmableRegistry;
    private final NetworkFetcher<?> networkFetcher;
    private final PlatformBitmapFactory platformBitmapFactory;
    private final PoolFactory poolFactory;
    private final ProgressiveJpegConfig progressiveJpegConfig;
    private final Set<RequestListener2> requestListener2s;
    private final Set<RequestListener> requestListeners;
    private final DiskCacheConfig smallImageDiskCacheConfig;

    public /* synthetic */ ImagePipelineConfig(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public static final DefaultImageRequestConfig getDefaultImageRequestConfig() {
        return INSTANCE.getDefaultImageRequestConfig();
    }

    public static /* synthetic */ void getImageTranscoderType$annotations() {
    }

    public static /* synthetic */ void getMemoryChunkType$annotations() {
    }

    @JvmStatic
    public static final Builder newBuilder(Context context) {
        return INSTANCE.newBuilder(context);
    }

    @JvmStatic
    public static final void resetDefaultRequestConfig() {
        INSTANCE.resetDefaultRequestConfig();
    }

    private ImagePipelineConfig(Builder builder) {
        HttpUrlConnectionNetworkFetcher networkFetcher;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipelineConfig()");
        }
        this.experiments = builder.getExperimentsBuilder().build();
        DefaultBitmapMemoryCacheParamsSupplier bitmapMemoryCacheParamsSupplier = builder.getBitmapMemoryCacheParamsSupplier();
        if (bitmapMemoryCacheParamsSupplier == null) {
            Object systemService = builder.getContext().getSystemService("activity");
            if (systemService != null) {
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
                bitmapMemoryCacheParamsSupplier = new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) systemService);
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        this.bitmapMemoryCacheParamsSupplier = bitmapMemoryCacheParamsSupplier;
        BitmapMemoryCacheTrimStrategy bitmapMemoryCacheTrimStrategy = builder.getBitmapMemoryCacheTrimStrategy();
        this.bitmapMemoryCacheTrimStrategy = bitmapMemoryCacheTrimStrategy == null ? new BitmapMemoryCacheTrimStrategy() : bitmapMemoryCacheTrimStrategy;
        NativeMemoryCacheTrimStrategy encodedMemoryCacheTrimStrategy = builder.getEncodedMemoryCacheTrimStrategy();
        this.encodedMemoryCacheTrimStrategy = encodedMemoryCacheTrimStrategy == null ? new NativeMemoryCacheTrimStrategy() : encodedMemoryCacheTrimStrategy;
        this.bitmapMemoryCacheEntryStateObserver = builder.getBitmapMemoryCacheEntryStateObserver();
        Bitmap.Config bitmapConfig = builder.getBitmapConfig();
        this.bitmapConfig = bitmapConfig == null ? Bitmap.Config.ARGB_8888 : bitmapConfig;
        DefaultCacheKeyFactory cacheKeyFactory = builder.getCacheKeyFactory();
        if (cacheKeyFactory == null) {
            DefaultCacheKeyFactory defaultCacheKeyFactory = DefaultCacheKeyFactory.getInstance();
            Intrinsics.checkNotNullExpressionValue(defaultCacheKeyFactory, "getInstance()");
            cacheKeyFactory = defaultCacheKeyFactory;
        }
        this.cacheKeyFactory = cacheKeyFactory;
        Context context = builder.getContext();
        if (context == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        this.context = context;
        DiskStorageCacheFactory fileCacheFactory = builder.getFileCacheFactory();
        this.fileCacheFactory = fileCacheFactory == null ? new DiskStorageCacheFactory(new DynamicDefaultDiskStorageFactory()) : fileCacheFactory;
        this.downsampleMode = builder.getDownsampleMode();
        DefaultEncodedMemoryCacheParamsSupplier encodedMemoryCacheParamsSupplier = builder.getEncodedMemoryCacheParamsSupplier();
        this.encodedMemoryCacheParamsSupplier = encodedMemoryCacheParamsSupplier == null ? new DefaultEncodedMemoryCacheParamsSupplier() : encodedMemoryCacheParamsSupplier;
        NoOpImageCacheStatsTracker imageCacheStatsTracker = builder.getImageCacheStatsTracker();
        if (imageCacheStatsTracker == null) {
            NoOpImageCacheStatsTracker noOpImageCacheStatsTracker = NoOpImageCacheStatsTracker.getInstance();
            Intrinsics.checkNotNullExpressionValue(noOpImageCacheStatsTracker, "getInstance()");
            imageCacheStatsTracker = noOpImageCacheStatsTracker;
        }
        this.imageCacheStatsTracker = imageCacheStatsTracker;
        this.imageDecoder = builder.getImageDecoder();
        Supplier<Boolean> BOOLEAN_FALSE = builder.getEnableEncodedImageColorSpaceUsage();
        if (BOOLEAN_FALSE == null) {
            BOOLEAN_FALSE = Suppliers.BOOLEAN_FALSE;
            Intrinsics.checkNotNullExpressionValue(BOOLEAN_FALSE, "BOOLEAN_FALSE");
        }
        this.enableEncodedImageColorSpaceUsage = BOOLEAN_FALSE;
        Companion companion = INSTANCE;
        this.imageTranscoderFactory = companion.getImageTranscoderFactory(builder);
        this.imageTranscoderType = builder.getImageTranscoderType();
        Supplier<Boolean> BOOLEAN_TRUE = builder.isPrefetchEnabledSupplier();
        if (BOOLEAN_TRUE == null) {
            BOOLEAN_TRUE = Suppliers.BOOLEAN_TRUE;
            Intrinsics.checkNotNullExpressionValue(BOOLEAN_TRUE, "BOOLEAN_TRUE");
        }
        this.isPrefetchEnabledSupplier = BOOLEAN_TRUE;
        DiskCacheConfig mainDiskCacheConfig = builder.getMainDiskCacheConfig();
        this.mainDiskCacheConfig = mainDiskCacheConfig == null ? companion.getDefaultMainDiskCacheConfig(builder.getContext()) : mainDiskCacheConfig;
        NoOpMemoryTrimmableRegistry memoryTrimmableRegistry = builder.getMemoryTrimmableRegistry();
        if (memoryTrimmableRegistry == null) {
            NoOpMemoryTrimmableRegistry noOpMemoryTrimmableRegistry = NoOpMemoryTrimmableRegistry.getInstance();
            Intrinsics.checkNotNullExpressionValue(noOpMemoryTrimmableRegistry, "getInstance()");
            memoryTrimmableRegistry = noOpMemoryTrimmableRegistry;
        }
        this.memoryTrimmableRegistry = memoryTrimmableRegistry;
        this.memoryChunkType = companion.getMemoryChunkType(builder, getExperiments());
        int httpConnectionTimeout = builder.getHttpConnectionTimeout() < 0 ? HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT : builder.getHttpConnectionTimeout();
        this.httpNetworkTimeout = httpConnectionTimeout;
        FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
        if (!FrescoSystrace.isTracing()) {
            networkFetcher = builder.getNetworkFetcher();
            if (networkFetcher == null) {
                networkFetcher = new HttpUrlConnectionNetworkFetcher(httpConnectionTimeout);
            }
        } else {
            FrescoSystrace.beginSection("ImagePipelineConfig->mNetworkFetcher");
            try {
                networkFetcher = builder.getNetworkFetcher();
                networkFetcher = networkFetcher == null ? new HttpUrlConnectionNetworkFetcher(httpConnectionTimeout) : networkFetcher;
            } finally {
                FrescoSystrace.endSection();
            }
        }
        this.networkFetcher = networkFetcher;
        this.platformBitmapFactory = builder.getPlatformBitmapFactory();
        PoolFactory poolFactory = builder.getPoolFactory();
        this.poolFactory = poolFactory == null ? new PoolFactory(PoolConfig.newBuilder().build()) : poolFactory;
        SimpleProgressiveJpegConfig progressiveJpegConfig = builder.getProgressiveJpegConfig();
        this.progressiveJpegConfig = progressiveJpegConfig == null ? new SimpleProgressiveJpegConfig() : progressiveJpegConfig;
        Set<RequestListener> requestListeners = builder.getRequestListeners();
        this.requestListeners = requestListeners == null ? SetsKt.emptySet() : requestListeners;
        Set<RequestListener2> requestListener2s = builder.getRequestListener2s();
        this.requestListener2s = requestListener2s == null ? SetsKt.emptySet() : requestListener2s;
        Set<CustomProducerSequenceFactory> customProducerSequenceFactories = builder.getCustomProducerSequenceFactories();
        this.customProducerSequenceFactories = customProducerSequenceFactories == null ? SetsKt.emptySet() : customProducerSequenceFactories;
        this.isResizeAndRotateEnabledForNetwork = builder.getResizeAndRotateEnabledForNetwork();
        DiskCacheConfig smallImageDiskCacheConfig = builder.getSmallImageDiskCacheConfig();
        this.smallImageDiskCacheConfig = smallImageDiskCacheConfig == null ? getMainDiskCacheConfig() : smallImageDiskCacheConfig;
        this.imageDecoderConfig = builder.getImageDecoderConfig();
        int flexByteArrayPoolMaxNumThreads = getPoolFactory().getFlexByteArrayPoolMaxNumThreads();
        DefaultExecutorSupplier executorSupplier = builder.getExecutorSupplier();
        this.executorSupplier = executorSupplier == null ? new DefaultExecutorSupplier(flexByteArrayPoolMaxNumThreads) : executorSupplier;
        this.isDiskCacheEnabled = builder.getDiskCacheEnabled();
        this.callerContextVerifier = builder.getCallerContextVerifier();
        this.closeableReferenceLeakTracker = builder.getCloseableReferenceLeakTracker();
        this.bitmapCacheOverride = builder.getBitmapMemoryCache();
        CountingLruBitmapMemoryCacheFactory bitmapMemoryCacheFactory = builder.getBitmapMemoryCacheFactory();
        this.bitmapMemoryCacheFactory = bitmapMemoryCacheFactory == null ? new CountingLruBitmapMemoryCacheFactory() : bitmapMemoryCacheFactory;
        this.encodedMemoryCacheOverride = builder.getEncodedMemoryCache();
        this.executorServiceForAnimatedImages = builder.getSerialExecutorServiceForAnimatedImages();
        this.dynamicDiskCacheConfigMap = builder.getDynamicDiskCacheConfigMap();
        WebpBitmapFactory webpBitmapFactory = getExperiments().getWebpBitmapFactory();
        if (webpBitmapFactory != null) {
            companion.setWebpBitmapFactory(webpBitmapFactory, getExperiments(), new HoneycombBitmapCreator(getPoolFactory()));
        }
        if (FrescoSystrace.isTracing()) {
        }
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public Bitmap.Config getBitmapConfig() {
        return this.bitmapConfig;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public Supplier<MemoryCacheParams> getBitmapMemoryCacheParamsSupplier() {
        return this.bitmapMemoryCacheParamsSupplier;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public MemoryCache.CacheTrimStrategy getBitmapMemoryCacheTrimStrategy() {
        return this.bitmapMemoryCacheTrimStrategy;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public MemoryCache.CacheTrimStrategy getEncodedMemoryCacheTrimStrategy() {
        return this.encodedMemoryCacheTrimStrategy;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public CountingMemoryCache.EntryStateObserver<CacheKey> getBitmapMemoryCacheEntryStateObserver() {
        return this.bitmapMemoryCacheEntryStateObserver;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public CacheKeyFactory getCacheKeyFactory() {
        return this.cacheKeyFactory;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public Context getContext() {
        return this.context;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public DownsampleMode getDownsampleMode() {
        return this.downsampleMode;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public FileCacheFactory getFileCacheFactory() {
        return this.fileCacheFactory;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public Supplier<MemoryCacheParams> getEncodedMemoryCacheParamsSupplier() {
        return this.encodedMemoryCacheParamsSupplier;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public ExecutorSupplier getExecutorSupplier() {
        return this.executorSupplier;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public ImageCacheStatsTracker getImageCacheStatsTracker() {
        return this.imageCacheStatsTracker;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public ImageDecoder getImageDecoder() {
        return this.imageDecoder;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public ImageTranscoderFactory getImageTranscoderFactory() {
        return this.imageTranscoderFactory;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public Supplier<Boolean> getEnableEncodedImageColorSpaceUsage() {
        return this.enableEncodedImageColorSpaceUsage;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public Integer getImageTranscoderType() {
        return this.imageTranscoderType;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public Supplier<Boolean> isPrefetchEnabledSupplier() {
        return this.isPrefetchEnabledSupplier;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public DiskCacheConfig getMainDiskCacheConfig() {
        return this.mainDiskCacheConfig;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
        return this.memoryTrimmableRegistry;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public int getMemoryChunkType() {
        return this.memoryChunkType;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public NetworkFetcher<?> getNetworkFetcher() {
        return this.networkFetcher;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public PlatformBitmapFactory getPlatformBitmapFactory() {
        return this.platformBitmapFactory;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public PoolFactory getPoolFactory() {
        return this.poolFactory;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public ProgressiveJpegConfig getProgressiveJpegConfig() {
        return this.progressiveJpegConfig;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public Set<RequestListener> getRequestListeners() {
        return this.requestListeners;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public Set<RequestListener2> getRequestListener2s() {
        return this.requestListener2s;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public Set<CustomProducerSequenceFactory> getCustomProducerSequenceFactories() {
        return this.customProducerSequenceFactories;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    /* renamed from: isResizeAndRotateEnabledForNetwork, reason: from getter */
    public boolean getIsResizeAndRotateEnabledForNetwork() {
        return this.isResizeAndRotateEnabledForNetwork;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public DiskCacheConfig getSmallImageDiskCacheConfig() {
        return this.smallImageDiskCacheConfig;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public ImageDecoderConfig getImageDecoderConfig() {
        return this.imageDecoderConfig;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public ImagePipelineExperiments getExperiments() {
        return this.experiments;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    /* renamed from: isDiskCacheEnabled, reason: from getter */
    public boolean getIsDiskCacheEnabled() {
        return this.isDiskCacheEnabled;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public CallerContextVerifier getCallerContextVerifier() {
        return this.callerContextVerifier;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public CloseableReferenceLeakTracker getCloseableReferenceLeakTracker() {
        return this.closeableReferenceLeakTracker;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public MemoryCache<CacheKey, CloseableImage> getBitmapCacheOverride() {
        return this.bitmapCacheOverride;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public MemoryCache<CacheKey, PooledByteBuffer> getEncodedMemoryCacheOverride() {
        return this.encodedMemoryCacheOverride;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public SerialExecutorService getExecutorServiceForAnimatedImages() {
        return this.executorServiceForAnimatedImages;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public BitmapMemoryCacheFactory getBitmapMemoryCacheFactory() {
        return this.bitmapMemoryCacheFactory;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public Map<String, DiskCacheConfig> getDynamicDiskCacheConfigMap() {
        return this.dynamicDiskCacheConfigMap;
    }

    /* compiled from: ImagePipelineConfig.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineConfig$DefaultImageRequestConfig;", "", "()V", "isProgressiveRenderingEnabled", "", "()Z", "setProgressiveRenderingEnabled", "(Z)V", "imagepipeline_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImageRequestConfig {
        private boolean isProgressiveRenderingEnabled;

        /* renamed from: isProgressiveRenderingEnabled, reason: from getter */
        public final boolean getIsProgressiveRenderingEnabled() {
            return this.isProgressiveRenderingEnabled;
        }

        public final void setProgressiveRenderingEnabled(boolean z) {
            this.isProgressiveRenderingEnabled = z;
        }
    }

    /* compiled from: ImagePipelineConfig.kt */
    @Metadata(d1 = {"\u0000¢\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b.\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u009d\u0001\u001a\u00030\u009e\u0001J\u0007\u0010\u009f\u0001\u001a\u00020PJ\u0007\u0010 \u0001\u001a\u000204J\u0007\u0010¡\u0001\u001a\u000204J\u001d\u0010¢\u0001\u001a\u00020\u00002\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nJ\u0017\u0010£\u0001\u001a\u00020\u00002\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0010J\u0011\u0010¤\u0001\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0017\u0010¥\u0001\u001a\u00020\u00002\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018J\u0012\u0010¦\u0001\u001a\u00020\u00002\t\u0010§\u0001\u001a\u0004\u0018\u00010\u001dJ\u0012\u0010¨\u0001\u001a\u00020\u00002\t\u0010©\u0001\u001a\u0004\u0018\u00010\u0006J\u0011\u0010ª\u0001\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010!J\u0011\u0010«\u0001\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010%J\u000f\u0010¬\u0001\u001a\u00020\u00002\u0006\u0010*\u001a\u00020)J\u0017\u0010\u00ad\u0001\u001a\u00020\u00002\u000e\u00101\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/J\u000f\u0010®\u0001\u001a\u00020\u00002\u0006\u00105\u001a\u000204J\u0012\u0010¯\u0001\u001a\u00020\u00002\u0007\u0010°\u0001\u001a\u000204H\u0007J\u000f\u0010±\u0001\u001a\u00020\u00002\u0006\u00109\u001a\u000208J\u001b\u0010²\u0001\u001a\u00020\u00002\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>0<J\u0017\u0010³\u0001\u001a\u00020\u00002\u000e\u0010B\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u0018J\u001d\u0010´\u0001\u001a\u00020\u00002\u0014\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020D\u0018\u00010\nJ\u0017\u0010µ\u0001\u001a\u00020\u00002\u000e\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018J\u0012\u0010¶\u0001\u001a\u00020\u00002\t\u0010§\u0001\u001a\u0004\u0018\u00010\u001dJ\u0013\u0010·\u0001\u001a\u00020\u00002\n\u0010¸\u0001\u001a\u0005\u0018\u00010\u0097\u0001J\u0011\u0010¹\u0001\u001a\u00020\u00002\b\u0010L\u001a\u0004\u0018\u00010KJ\u0011\u0010º\u0001\u001a\u00020\u00002\b\u0010T\u001a\u0004\u0018\u00010SJ\u0010\u0010»\u0001\u001a\u00020\u00002\u0007\u0010¼\u0001\u001a\u00020WJ\u0011\u0010½\u0001\u001a\u00020\u00002\b\u0010\\\u001a\u0004\u0018\u00010[J\u0011\u0010¾\u0001\u001a\u00020\u00002\b\u0010`\u001a\u0004\u0018\u00010_J\u0011\u0010¿\u0001\u001a\u00020\u00002\b\u0010d\u001a\u0004\u0018\u00010cJ\u0011\u0010À\u0001\u001a\u00020\u00002\b\u0010h\u001a\u0004\u0018\u00010gJ\u000e\u0010p\u001a\u00020\u00002\u0006\u0010k\u001a\u00020WJ\u0017\u0010Á\u0001\u001a\u00020\u00002\u000e\u0010s\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u0018J\u0011\u0010Â\u0001\u001a\u00020\u00002\b\u0010t\u001a\u0004\u0018\u00010>J\u000e\u0010z\u001a\u00020\u00002\u0006\u0010w\u001a\u00020WJ\u0011\u0010Ã\u0001\u001a\u00020\u00002\b\u0010|\u001a\u0004\u0018\u00010{J\u0016\u0010Ä\u0001\u001a\u00020\u00002\r\u0010\u0080\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u007fJ\u0013\u0010Å\u0001\u001a\u00020\u00002\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u0001J\u0013\u0010Æ\u0001\u001a\u00020\u00002\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u0001J\u0013\u0010Ç\u0001\u001a\u00020\u00002\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u0001J\u0019\u0010È\u0001\u001a\u00020\u00002\u0010\u0010\u0093\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u008f\u0001\u0018\u00010/J\u0019\u0010É\u0001\u001a\u00020\u00002\u0010\u0010\u0093\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0092\u0001\u0018\u00010/J\u0010\u0010Ê\u0001\u001a\u00020\u00002\u0007\u0010\u0095\u0001\u001a\u000204J\u0012\u0010Ë\u0001\u001a\u00020\u00002\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010>R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR:\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n2\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR.\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00102\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u0014@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R.\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0005\u001a\u0004\u0018\u00010\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u0005\u001a\u0004\u0018\u00010!@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\"\u0010&\u001a\u0004\u0018\u00010%2\b\u0010\u0005\u001a\u0004\u0018\u00010%@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001e\u0010*\u001a\u00020)2\u0006\u0010\u0005\u001a\u00020)@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R.\u00101\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001e\u00105\u001a\u0002042\u0006\u0010\u0005\u001a\u000204@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001e\u00109\u001a\u0002082\u0006\u0010\u0005\u001a\u000208@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R:\u0010?\u001a\u0010\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>\u0018\u00010<2\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>\u0018\u00010<@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR.\u0010B\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u00182\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u001cR:\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020D\u0018\u00010\n2\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020D\u0018\u00010\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u000fR.\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u001cR\"\u0010I\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0005\u001a\u0004\u0018\u00010\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010 R\"\u0010L\u001a\u0004\u0018\u00010K2\b\u0010\u0005\u001a\u0004\u0018\u00010K@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0011\u0010O\u001a\u00020P¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\"\u0010T\u001a\u0004\u0018\u00010S2\b\u0010\u0005\u001a\u0004\u0018\u00010S@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u001e\u0010X\u001a\u00020W2\u0006\u0010\u0005\u001a\u00020W@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\"\u0010\\\u001a\u0004\u0018\u00010[2\b\u0010\u0005\u001a\u0004\u0018\u00010[@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\"\u0010`\u001a\u0004\u0018\u00010_2\b\u0010\u0005\u001a\u0004\u0018\u00010_@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\ba\u0010bR\"\u0010d\u001a\u0004\u0018\u00010c2\b\u0010\u0005\u001a\u0004\u0018\u00010c@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\"\u0010h\u001a\u0004\u0018\u00010g2\b\u0010\u0005\u001a\u0004\u0018\u00010g@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bi\u0010jR$\u0010k\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u0016\n\u0002\u0010r\u0012\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR.\u0010s\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u00182\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bs\u0010\u001cR\"\u0010t\u001a\u0004\u0018\u00010>2\b\u0010\u0005\u001a\u0004\u0018\u00010>@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR$\u0010w\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u0016\n\u0002\u0010r\u0012\u0004\bx\u0010m\u001a\u0004\by\u0010o\"\u0004\bz\u0010qR\"\u0010|\u001a\u0004\u0018\u00010{2\b\u0010\u0005\u001a\u0004\u0018\u00010{@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b}\u0010~R-\u0010\u0080\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u007f2\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u007f@BX\u0086\u000e¢\u0006\n\n\u0000\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R'\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u00012\t\u0010\u0005\u001a\u0005\u0018\u00010\u0083\u0001@BX\u0086\u000e¢\u0006\n\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R'\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00012\t\u0010\u0005\u001a\u0005\u0018\u00010\u0087\u0001@BX\u0086\u000e¢\u0006\n\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R'\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u00012\t\u0010\u0005\u001a\u0005\u0018\u00010\u008b\u0001@BX\u0086\u000e¢\u0006\n\n\u0000\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R2\u0010\u0090\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u008f\u0001\u0018\u00010/2\u000f\u0010\u0005\u001a\u000b\u0012\u0005\u0012\u00030\u008f\u0001\u0018\u00010/@BX\u0086\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0091\u0001\u00103R2\u0010\u0093\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0092\u0001\u0018\u00010/2\u000f\u0010\u0005\u001a\u000b\u0012\u0005\u0012\u00030\u0092\u0001\u0018\u00010/@BX\u0086\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0094\u0001\u00103R \u0010\u0095\u0001\u001a\u0002042\u0006\u0010\u0005\u001a\u000204@BX\u0086\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0096\u0001\u00107R'\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0097\u00012\t\u0010\u0005\u001a\u0005\u0018\u00010\u0097\u0001@BX\u0086\u000e¢\u0006\n\n\u0000\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R$\u0010\u009b\u0001\u001a\u0004\u0018\u00010>2\b\u0010\u0005\u001a\u0004\u0018\u00010>@BX\u0086\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u009c\u0001\u0010v¨\u0006Ì\u0001"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "<set-?>", "Landroid/graphics/Bitmap$Config;", "bitmapConfig", "getBitmapConfig", "()Landroid/graphics/Bitmap$Config;", "Lcom/facebook/imagepipeline/cache/MemoryCache;", "Lcom/facebook/cache/common/CacheKey;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "bitmapMemoryCache", "getBitmapMemoryCache", "()Lcom/facebook/imagepipeline/cache/MemoryCache;", "Lcom/facebook/imagepipeline/cache/CountingMemoryCache$EntryStateObserver;", "bitmapMemoryCacheEntryStateObserver", "getBitmapMemoryCacheEntryStateObserver", "()Lcom/facebook/imagepipeline/cache/CountingMemoryCache$EntryStateObserver;", "Lcom/facebook/imagepipeline/cache/BitmapMemoryCacheFactory;", "bitmapMemoryCacheFactory", "getBitmapMemoryCacheFactory", "()Lcom/facebook/imagepipeline/cache/BitmapMemoryCacheFactory;", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/imagepipeline/cache/MemoryCacheParams;", "bitmapMemoryCacheParamsSupplier", "getBitmapMemoryCacheParamsSupplier", "()Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/imagepipeline/cache/MemoryCache$CacheTrimStrategy;", "bitmapMemoryCacheTrimStrategy", "getBitmapMemoryCacheTrimStrategy", "()Lcom/facebook/imagepipeline/cache/MemoryCache$CacheTrimStrategy;", "Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "cacheKeyFactory", "getCacheKeyFactory", "()Lcom/facebook/imagepipeline/cache/CacheKeyFactory;", "Lcom/facebook/callercontext/CallerContextVerifier;", "callerContextVerifier", "getCallerContextVerifier", "()Lcom/facebook/callercontext/CallerContextVerifier;", "Lcom/facebook/imagepipeline/debug/CloseableReferenceLeakTracker;", "closeableReferenceLeakTracker", "getCloseableReferenceLeakTracker", "()Lcom/facebook/imagepipeline/debug/CloseableReferenceLeakTracker;", "getContext", "()Landroid/content/Context;", "", "Lcom/facebook/imagepipeline/producers/CustomProducerSequenceFactory;", "customProducerSequenceFactories", "getCustomProducerSequenceFactories", "()Ljava/util/Set;", "", "diskCacheEnabled", "getDiskCacheEnabled", "()Z", "Lcom/facebook/imagepipeline/core/DownsampleMode;", "downsampleMode", "getDownsampleMode", "()Lcom/facebook/imagepipeline/core/DownsampleMode;", "", "", "Lcom/facebook/cache/disk/DiskCacheConfig;", "dynamicDiskCacheConfigMap", "getDynamicDiskCacheConfigMap", "()Ljava/util/Map;", "enableEncodedImageColorSpaceUsage", "getEnableEncodedImageColorSpaceUsage", "Lcom/facebook/common/memory/PooledByteBuffer;", "encodedMemoryCache", "getEncodedMemoryCache", "encodedMemoryCacheParamsSupplier", "getEncodedMemoryCacheParamsSupplier", "encodedMemoryCacheTrimStrategy", "getEncodedMemoryCacheTrimStrategy", "Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "executorSupplier", "getExecutorSupplier", "()Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "experimentsBuilder", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$Builder;", "getExperimentsBuilder", "()Lcom/facebook/imagepipeline/core/ImagePipelineExperiments$Builder;", "Lcom/facebook/imagepipeline/core/FileCacheFactory;", "fileCacheFactory", "getFileCacheFactory", "()Lcom/facebook/imagepipeline/core/FileCacheFactory;", "", "httpConnectionTimeout", "getHttpConnectionTimeout", "()I", "Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;", "imageCacheStatsTracker", "getImageCacheStatsTracker", "()Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;", "Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "imageDecoder", "getImageDecoder", "()Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig;", "imageDecoderConfig", "getImageDecoderConfig", "()Lcom/facebook/imagepipeline/decoder/ImageDecoderConfig;", "Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;", "imageTranscoderFactory", "getImageTranscoderFactory", "()Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;", "imageTranscoderType", "getImageTranscoderType$annotations", "()V", "getImageTranscoderType", "()Ljava/lang/Integer;", "setImageTranscoderType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "isPrefetchEnabledSupplier", "mainDiskCacheConfig", "getMainDiskCacheConfig", "()Lcom/facebook/cache/disk/DiskCacheConfig;", "memoryChunkType", "getMemoryChunkType$annotations", "getMemoryChunkType", "setMemoryChunkType", "Lcom/facebook/common/memory/MemoryTrimmableRegistry;", "memoryTrimmableRegistry", "getMemoryTrimmableRegistry", "()Lcom/facebook/common/memory/MemoryTrimmableRegistry;", "Lcom/facebook/imagepipeline/producers/NetworkFetcher;", "networkFetcher", "getNetworkFetcher", "()Lcom/facebook/imagepipeline/producers/NetworkFetcher;", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "platformBitmapFactory", "getPlatformBitmapFactory", "()Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "Lcom/facebook/imagepipeline/memory/PoolFactory;", "poolFactory", "getPoolFactory", "()Lcom/facebook/imagepipeline/memory/PoolFactory;", "Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "progressiveJpegConfig", "getProgressiveJpegConfig", "()Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "Lcom/facebook/imagepipeline/listener/RequestListener2;", "requestListener2s", "getRequestListener2s", "Lcom/facebook/imagepipeline/listener/RequestListener;", "requestListeners", "getRequestListeners", "resizeAndRotateEnabledForNetwork", "getResizeAndRotateEnabledForNetwork", "Lcom/facebook/common/executors/SerialExecutorService;", "serialExecutorServiceForAnimatedImages", "getSerialExecutorServiceForAnimatedImages", "()Lcom/facebook/common/executors/SerialExecutorService;", "smallImageDiskCacheConfig", "getSmallImageDiskCacheConfig", "build", "Lcom/facebook/imagepipeline/core/ImagePipelineConfig;", "experiment", "isDiskCacheEnabled", "isDownsampleEnabled", "setBitmapMemoryCache", "setBitmapMemoryCacheEntryStateObserver", "setBitmapMemoryCacheFactory", "setBitmapMemoryCacheParamsSupplier", "setBitmapMemoryCacheTrimStrategy", "trimStrategy", "setBitmapsConfig", "config", "setCacheKeyFactory", "setCallerContextVerifier", "setCloseableReferenceLeakTracker", "setCustomFetchSequenceFactories", "setDiskCacheEnabled", "setDownsampleEnabled", "downsampleEnabled", "setDownsampleMode", "setDynamicDiskCacheConfigMap", "setEnableEncodedImageColorSpaceUsage", "setEncodedMemoryCache", "setEncodedMemoryCacheParamsSupplier", "setEncodedMemoryCacheTrimStrategy", "setExecutorServiceForAnimatedImages", "serialExecutorService", "setExecutorSupplier", "setFileCacheFactory", "setHttpConnectionTimeout", "httpConnectionTimeoutMs", "setImageCacheStatsTracker", "setImageDecoder", "setImageDecoderConfig", "setImageTranscoderFactory", "setIsPrefetchEnabledSupplier", "setMainDiskCacheConfig", "setMemoryTrimmableRegistry", "setNetworkFetcher", "setPlatformBitmapFactory", "setPoolFactory", "setProgressiveJpegConfig", "setRequestListener2s", "setRequestListeners", "setResizeAndRotateEnabledForNetwork", "setSmallImageDiskCacheConfig", "imagepipeline_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private Bitmap.Config bitmapConfig;
        private MemoryCache<CacheKey, CloseableImage> bitmapMemoryCache;
        private CountingMemoryCache.EntryStateObserver<CacheKey> bitmapMemoryCacheEntryStateObserver;
        private BitmapMemoryCacheFactory bitmapMemoryCacheFactory;
        private Supplier<MemoryCacheParams> bitmapMemoryCacheParamsSupplier;
        private MemoryCache.CacheTrimStrategy bitmapMemoryCacheTrimStrategy;
        private CacheKeyFactory cacheKeyFactory;
        private CallerContextVerifier callerContextVerifier;
        private CloseableReferenceLeakTracker closeableReferenceLeakTracker;
        private final Context context;
        private Set<? extends CustomProducerSequenceFactory> customProducerSequenceFactories;
        private boolean diskCacheEnabled;
        private DownsampleMode downsampleMode;
        private Map<String, ? extends DiskCacheConfig> dynamicDiskCacheConfigMap;
        private Supplier<Boolean> enableEncodedImageColorSpaceUsage;
        private MemoryCache<CacheKey, PooledByteBuffer> encodedMemoryCache;
        private Supplier<MemoryCacheParams> encodedMemoryCacheParamsSupplier;
        private MemoryCache.CacheTrimStrategy encodedMemoryCacheTrimStrategy;
        private ExecutorSupplier executorSupplier;
        private final ImagePipelineExperiments.Builder experimentsBuilder;
        private FileCacheFactory fileCacheFactory;
        private int httpConnectionTimeout;
        private ImageCacheStatsTracker imageCacheStatsTracker;
        private ImageDecoder imageDecoder;
        private ImageDecoderConfig imageDecoderConfig;
        private ImageTranscoderFactory imageTranscoderFactory;
        private Integer imageTranscoderType;
        private Supplier<Boolean> isPrefetchEnabledSupplier;
        private DiskCacheConfig mainDiskCacheConfig;
        private Integer memoryChunkType;
        private MemoryTrimmableRegistry memoryTrimmableRegistry;
        private NetworkFetcher<?> networkFetcher;
        private PlatformBitmapFactory platformBitmapFactory;
        private PoolFactory poolFactory;
        private ProgressiveJpegConfig progressiveJpegConfig;
        private Set<? extends RequestListener2> requestListener2s;
        private Set<? extends RequestListener> requestListeners;
        private boolean resizeAndRotateEnabledForNetwork;
        private SerialExecutorService serialExecutorServiceForAnimatedImages;
        private DiskCacheConfig smallImageDiskCacheConfig;

        public static /* synthetic */ void getImageTranscoderType$annotations() {
        }

        public static /* synthetic */ void getMemoryChunkType$annotations() {
        }

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.downsampleMode = DownsampleMode.AUTO;
            this.resizeAndRotateEnabledForNetwork = true;
            this.httpConnectionTimeout = -1;
            this.experimentsBuilder = new ImagePipelineExperiments.Builder(this);
            this.diskCacheEnabled = true;
            this.closeableReferenceLeakTracker = new NoOpCloseableReferenceLeakTracker();
            this.context = context;
        }

        public final Bitmap.Config getBitmapConfig() {
            return this.bitmapConfig;
        }

        public final Supplier<MemoryCacheParams> getBitmapMemoryCacheParamsSupplier() {
            return this.bitmapMemoryCacheParamsSupplier;
        }

        public final CountingMemoryCache.EntryStateObserver<CacheKey> getBitmapMemoryCacheEntryStateObserver() {
            return this.bitmapMemoryCacheEntryStateObserver;
        }

        public final MemoryCache.CacheTrimStrategy getBitmapMemoryCacheTrimStrategy() {
            return this.bitmapMemoryCacheTrimStrategy;
        }

        public final MemoryCache.CacheTrimStrategy getEncodedMemoryCacheTrimStrategy() {
            return this.encodedMemoryCacheTrimStrategy;
        }

        public final CacheKeyFactory getCacheKeyFactory() {
            return this.cacheKeyFactory;
        }

        public final Context getContext() {
            return this.context;
        }

        public final DownsampleMode getDownsampleMode() {
            return this.downsampleMode;
        }

        public final Supplier<MemoryCacheParams> getEncodedMemoryCacheParamsSupplier() {
            return this.encodedMemoryCacheParamsSupplier;
        }

        public final ExecutorSupplier getExecutorSupplier() {
            return this.executorSupplier;
        }

        public final ImageCacheStatsTracker getImageCacheStatsTracker() {
            return this.imageCacheStatsTracker;
        }

        public final ImageDecoder getImageDecoder() {
            return this.imageDecoder;
        }

        public final Supplier<Boolean> getEnableEncodedImageColorSpaceUsage() {
            return this.enableEncodedImageColorSpaceUsage;
        }

        public final ImageTranscoderFactory getImageTranscoderFactory() {
            return this.imageTranscoderFactory;
        }

        public final Integer getImageTranscoderType() {
            return this.imageTranscoderType;
        }

        public final void setImageTranscoderType(Integer num) {
            this.imageTranscoderType = num;
        }

        public final Supplier<Boolean> isPrefetchEnabledSupplier() {
            return this.isPrefetchEnabledSupplier;
        }

        public final DiskCacheConfig getMainDiskCacheConfig() {
            return this.mainDiskCacheConfig;
        }

        public final MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
            return this.memoryTrimmableRegistry;
        }

        public final Integer getMemoryChunkType() {
            return this.memoryChunkType;
        }

        public final void setMemoryChunkType(Integer num) {
            this.memoryChunkType = num;
        }

        public final NetworkFetcher<?> getNetworkFetcher() {
            return this.networkFetcher;
        }

        public final PlatformBitmapFactory getPlatformBitmapFactory() {
            return this.platformBitmapFactory;
        }

        public final PoolFactory getPoolFactory() {
            return this.poolFactory;
        }

        public final ProgressiveJpegConfig getProgressiveJpegConfig() {
            return this.progressiveJpegConfig;
        }

        public final Set<RequestListener> getRequestListeners() {
            return this.requestListeners;
        }

        public final Set<RequestListener2> getRequestListener2s() {
            return this.requestListener2s;
        }

        public final Set<CustomProducerSequenceFactory> getCustomProducerSequenceFactories() {
            return this.customProducerSequenceFactories;
        }

        public final boolean getResizeAndRotateEnabledForNetwork() {
            return this.resizeAndRotateEnabledForNetwork;
        }

        public final DiskCacheConfig getSmallImageDiskCacheConfig() {
            return this.smallImageDiskCacheConfig;
        }

        public final FileCacheFactory getFileCacheFactory() {
            return this.fileCacheFactory;
        }

        public final ImageDecoderConfig getImageDecoderConfig() {
            return this.imageDecoderConfig;
        }

        public final int getHttpConnectionTimeout() {
            return this.httpConnectionTimeout;
        }

        public final ImagePipelineExperiments.Builder getExperimentsBuilder() {
            return this.experimentsBuilder;
        }

        public final boolean getDiskCacheEnabled() {
            return this.diskCacheEnabled;
        }

        public final CallerContextVerifier getCallerContextVerifier() {
            return this.callerContextVerifier;
        }

        public final CloseableReferenceLeakTracker getCloseableReferenceLeakTracker() {
            return this.closeableReferenceLeakTracker;
        }

        public final MemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache() {
            return this.bitmapMemoryCache;
        }

        public final MemoryCache<CacheKey, PooledByteBuffer> getEncodedMemoryCache() {
            return this.encodedMemoryCache;
        }

        public final SerialExecutorService getSerialExecutorServiceForAnimatedImages() {
            return this.serialExecutorServiceForAnimatedImages;
        }

        public final BitmapMemoryCacheFactory getBitmapMemoryCacheFactory() {
            return this.bitmapMemoryCacheFactory;
        }

        public final Map<String, DiskCacheConfig> getDynamicDiskCacheConfigMap() {
            return this.dynamicDiskCacheConfigMap;
        }

        public final Builder setBitmapsConfig(Bitmap.Config config) {
            this.bitmapConfig = config;
            return this;
        }

        public final Builder setBitmapMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> bitmapMemoryCacheParamsSupplier) {
            if (bitmapMemoryCacheParamsSupplier == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            this.bitmapMemoryCacheParamsSupplier = bitmapMemoryCacheParamsSupplier;
            return this;
        }

        public final Builder setBitmapMemoryCacheEntryStateObserver(CountingMemoryCache.EntryStateObserver<CacheKey> bitmapMemoryCacheEntryStateObserver) {
            this.bitmapMemoryCacheEntryStateObserver = bitmapMemoryCacheEntryStateObserver;
            return this;
        }

        public final Builder setBitmapMemoryCacheTrimStrategy(MemoryCache.CacheTrimStrategy trimStrategy) {
            this.bitmapMemoryCacheTrimStrategy = trimStrategy;
            return this;
        }

        public final Builder setEncodedMemoryCacheTrimStrategy(MemoryCache.CacheTrimStrategy trimStrategy) {
            this.encodedMemoryCacheTrimStrategy = trimStrategy;
            return this;
        }

        public final Builder setCacheKeyFactory(CacheKeyFactory cacheKeyFactory) {
            this.cacheKeyFactory = cacheKeyFactory;
            return this;
        }

        public final Builder setHttpConnectionTimeout(int httpConnectionTimeoutMs) {
            this.httpConnectionTimeout = httpConnectionTimeoutMs;
            return this;
        }

        public final Builder setFileCacheFactory(FileCacheFactory fileCacheFactory) {
            this.fileCacheFactory = fileCacheFactory;
            return this;
        }

        public final boolean isDownsampleEnabled() {
            return this.downsampleMode == DownsampleMode.ALWAYS;
        }

        public final Builder setDownsampleMode(DownsampleMode downsampleMode) {
            Intrinsics.checkNotNullParameter(downsampleMode, "downsampleMode");
            this.downsampleMode = downsampleMode;
            return this;
        }

        @Deprecated(message = "Use the new setDownsampleMode() method")
        public final Builder setDownsampleEnabled(boolean downsampleEnabled) {
            if (downsampleEnabled) {
                setDownsampleMode(DownsampleMode.ALWAYS);
            } else {
                setDownsampleMode(DownsampleMode.AUTO);
            }
            return this;
        }

        public final boolean isDiskCacheEnabled() {
            return this.diskCacheEnabled;
        }

        public final Builder setDiskCacheEnabled(boolean diskCacheEnabled) {
            this.diskCacheEnabled = diskCacheEnabled;
            return this;
        }

        public final Builder setEncodedMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> encodedMemoryCacheParamsSupplier) {
            if (encodedMemoryCacheParamsSupplier == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            this.encodedMemoryCacheParamsSupplier = encodedMemoryCacheParamsSupplier;
            return this;
        }

        public final Builder setExecutorSupplier(ExecutorSupplier executorSupplier) {
            this.executorSupplier = executorSupplier;
            return this;
        }

        public final Builder setImageCacheStatsTracker(ImageCacheStatsTracker imageCacheStatsTracker) {
            this.imageCacheStatsTracker = imageCacheStatsTracker;
            return this;
        }

        public final Builder setImageDecoder(ImageDecoder imageDecoder) {
            this.imageDecoder = imageDecoder;
            return this;
        }

        public final Builder setEnableEncodedImageColorSpaceUsage(Supplier<Boolean> enableEncodedImageColorSpaceUsage) {
            this.enableEncodedImageColorSpaceUsage = enableEncodedImageColorSpaceUsage;
            return this;
        }

        public final Builder setImageTranscoderType(int imageTranscoderType) {
            this.imageTranscoderType = Integer.valueOf(imageTranscoderType);
            return this;
        }

        public final Builder setImageTranscoderFactory(ImageTranscoderFactory imageTranscoderFactory) {
            this.imageTranscoderFactory = imageTranscoderFactory;
            return this;
        }

        public final Builder setIsPrefetchEnabledSupplier(Supplier<Boolean> isPrefetchEnabledSupplier) {
            this.isPrefetchEnabledSupplier = isPrefetchEnabledSupplier;
            return this;
        }

        public final Builder setMainDiskCacheConfig(DiskCacheConfig mainDiskCacheConfig) {
            this.mainDiskCacheConfig = mainDiskCacheConfig;
            return this;
        }

        public final Builder setMemoryTrimmableRegistry(MemoryTrimmableRegistry memoryTrimmableRegistry) {
            this.memoryTrimmableRegistry = memoryTrimmableRegistry;
            return this;
        }

        public final Builder setMemoryChunkType(int memoryChunkType) {
            this.memoryChunkType = Integer.valueOf(memoryChunkType);
            return this;
        }

        public final Builder setNetworkFetcher(NetworkFetcher<?> networkFetcher) {
            this.networkFetcher = networkFetcher;
            return this;
        }

        public final Builder setPlatformBitmapFactory(PlatformBitmapFactory platformBitmapFactory) {
            this.platformBitmapFactory = platformBitmapFactory;
            return this;
        }

        public final Builder setPoolFactory(PoolFactory poolFactory) {
            this.poolFactory = poolFactory;
            return this;
        }

        public final Builder setProgressiveJpegConfig(ProgressiveJpegConfig progressiveJpegConfig) {
            this.progressiveJpegConfig = progressiveJpegConfig;
            return this;
        }

        public final Builder setRequestListeners(Set<? extends RequestListener> requestListeners) {
            this.requestListeners = requestListeners;
            return this;
        }

        public final Builder setRequestListener2s(Set<? extends RequestListener2> requestListeners) {
            this.requestListener2s = requestListeners;
            return this;
        }

        public final Builder setCustomFetchSequenceFactories(Set<? extends CustomProducerSequenceFactory> customProducerSequenceFactories) {
            this.customProducerSequenceFactories = customProducerSequenceFactories;
            return this;
        }

        public final Builder setResizeAndRotateEnabledForNetwork(boolean resizeAndRotateEnabledForNetwork) {
            this.resizeAndRotateEnabledForNetwork = resizeAndRotateEnabledForNetwork;
            return this;
        }

        public final Builder setSmallImageDiskCacheConfig(DiskCacheConfig smallImageDiskCacheConfig) {
            this.smallImageDiskCacheConfig = smallImageDiskCacheConfig;
            return this;
        }

        public final Builder setImageDecoderConfig(ImageDecoderConfig imageDecoderConfig) {
            this.imageDecoderConfig = imageDecoderConfig;
            return this;
        }

        public final Builder setCallerContextVerifier(CallerContextVerifier callerContextVerifier) {
            this.callerContextVerifier = callerContextVerifier;
            return this;
        }

        public final Builder setCloseableReferenceLeakTracker(CloseableReferenceLeakTracker closeableReferenceLeakTracker) {
            Intrinsics.checkNotNullParameter(closeableReferenceLeakTracker, "closeableReferenceLeakTracker");
            this.closeableReferenceLeakTracker = closeableReferenceLeakTracker;
            return this;
        }

        public final Builder setBitmapMemoryCache(MemoryCache<CacheKey, CloseableImage> bitmapMemoryCache) {
            this.bitmapMemoryCache = bitmapMemoryCache;
            return this;
        }

        public final Builder setEncodedMemoryCache(MemoryCache<CacheKey, PooledByteBuffer> encodedMemoryCache) {
            this.encodedMemoryCache = encodedMemoryCache;
            return this;
        }

        public final Builder setExecutorServiceForAnimatedImages(SerialExecutorService serialExecutorService) {
            this.serialExecutorServiceForAnimatedImages = serialExecutorService;
            return this;
        }

        public final Builder setBitmapMemoryCacheFactory(BitmapMemoryCacheFactory bitmapMemoryCacheFactory) {
            this.bitmapMemoryCacheFactory = bitmapMemoryCacheFactory;
            return this;
        }

        public final Builder setDynamicDiskCacheConfigMap(Map<String, ? extends DiskCacheConfig> dynamicDiskCacheConfigMap) {
            Intrinsics.checkNotNullParameter(dynamicDiskCacheConfigMap, "dynamicDiskCacheConfigMap");
            this.dynamicDiskCacheConfigMap = dynamicDiskCacheConfigMap;
            return this;
        }

        /* renamed from: experiment, reason: from getter */
        public final ImagePipelineExperiments.Builder getExperimentsBuilder() {
            return this.experimentsBuilder;
        }

        public final ImagePipelineConfig build() {
            return new ImagePipelineConfig(this, null);
        }
    }

    /* compiled from: ImagePipelineConfig.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0007J\"\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002R&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Companion;", "", "()V", "<set-?>", "Lcom/facebook/imagepipeline/core/ImagePipelineConfig$DefaultImageRequestConfig;", "defaultImageRequestConfig", "getDefaultImageRequestConfig$annotations", "getDefaultImageRequestConfig", "()Lcom/facebook/imagepipeline/core/ImagePipelineConfig$DefaultImageRequestConfig;", "getDefaultMainDiskCacheConfig", "Lcom/facebook/cache/disk/DiskCacheConfig;", "context", "Landroid/content/Context;", "getImageTranscoderFactory", "Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;", "builder", "Lcom/facebook/imagepipeline/core/ImagePipelineConfig$Builder;", "getMemoryChunkType", "", "imagePipelineExperiments", "Lcom/facebook/imagepipeline/core/ImagePipelineExperiments;", InAppPurchaseConstants.METHOD_NEW_BUILDER, "resetDefaultRequestConfig", "", "setWebpBitmapFactory", "webpBitmapFactory", "Lcom/facebook/common/webp/WebpBitmapFactory;", "bitmapCreator", "Lcom/facebook/common/webp/BitmapCreator;", "imagepipeline_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getDefaultImageRequestConfig$annotations() {
        }

        private Companion() {
        }

        public final DefaultImageRequestConfig getDefaultImageRequestConfig() {
            return ImagePipelineConfig.defaultImageRequestConfig;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setWebpBitmapFactory(WebpBitmapFactory webpBitmapFactory, ImagePipelineExperiments imagePipelineExperiments, BitmapCreator bitmapCreator) {
            WebpSupportStatus.sWebpBitmapFactory = webpBitmapFactory;
            WebpBitmapFactory.WebpErrorLogger webpErrorLogger = imagePipelineExperiments.getWebpErrorLogger();
            if (webpErrorLogger != null) {
                webpBitmapFactory.setWebpErrorLogger(webpErrorLogger);
            }
            if (bitmapCreator != null) {
                webpBitmapFactory.setBitmapCreator(bitmapCreator);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DiskCacheConfig getDefaultMainDiskCacheConfig(Context context) {
            DiskCacheConfig diskCacheConfigBuild;
            FrescoSystrace frescoSystrace = FrescoSystrace.INSTANCE;
            if (!FrescoSystrace.isTracing()) {
                diskCacheConfigBuild = DiskCacheConfig.newBuilder(context).build();
            } else {
                FrescoSystrace.beginSection("DiskCacheConfig.getDefaultMainDiskCacheConfig");
                try {
                    diskCacheConfigBuild = DiskCacheConfig.newBuilder(context).build();
                } finally {
                    FrescoSystrace.endSection();
                }
            }
            Intrinsics.checkNotNullExpressionValue(diskCacheConfigBuild, "traceSection(\"DiskCacheC…ontext).build()\n        }");
            return diskCacheConfigBuild;
        }

        @JvmStatic
        public final void resetDefaultRequestConfig() {
            ImagePipelineConfig.defaultImageRequestConfig = new DefaultImageRequestConfig();
        }

        @JvmStatic
        public final Builder newBuilder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Builder(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ImageTranscoderFactory getImageTranscoderFactory(Builder builder) {
            if (builder.getImageTranscoderFactory() == null || builder.getImageTranscoderType() == null) {
                return builder.getImageTranscoderFactory();
            }
            throw new IllegalStateException("You can't define a custom ImageTranscoderFactory and provide an ImageTranscoderType".toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getMemoryChunkType(Builder builder, ImagePipelineExperiments imagePipelineExperiments) {
            Integer memoryChunkType = builder.getMemoryChunkType();
            if (memoryChunkType != null) {
                return memoryChunkType.intValue();
            }
            if (imagePipelineExperiments.getMemoryType() == 2 && Build.VERSION.SDK_INT >= 27) {
                return 2;
            }
            if (imagePipelineExperiments.getMemoryType() == 1) {
                return 1;
            }
            imagePipelineExperiments.getMemoryType();
            return 0;
        }
    }
}
