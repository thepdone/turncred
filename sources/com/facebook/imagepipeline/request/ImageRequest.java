package com.facebook.imagepipeline.request;

import android.net.Uri;
import android.os.Build;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Fn;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.memory.config.MemorySpikeConfig;
import com.facebook.memory.helper.HashCode;
import com.facebook.share.internal.ShareConstants;
import io.sentry.protocol.SentryThread;
import java.io.File;
import java.util.HashMap;
import javax.annotation.Nullable;

/* loaded from: classes4.dex */
public class ImageRequest {
    public static final Fn<ImageRequest, Uri> REQUEST_TO_URI_FN = new Fn<ImageRequest, Uri>() { // from class: com.facebook.imagepipeline.request.ImageRequest.1
        @Override // com.facebook.common.internal.Fn
        @Nullable
        public Uri apply(@Nullable ImageRequest imageRequest) {
            if (imageRequest != null) {
                return imageRequest.getSourceUri();
            }
            return null;
        }
    };
    private static boolean sCacheHashcode;
    private static boolean sUseCachedHashcodeInEquals;

    @Nullable
    private final BytesRange mBytesRange;
    private final CacheChoice mCacheChoice;
    protected int mCachesDisabled;

    @Nullable
    private final Boolean mDecodePrefetches;
    private final int mDelayMs;

    @Nullable
    private final String mDiskCacheId;
    private int mHashcode;
    private final ImageDecodeOptions mImageDecodeOptions;
    private final boolean mIsDiskCacheEnabled;
    private final boolean mIsMemoryCacheEnabled;
    private final boolean mLoadThumbnailOnly;
    private final boolean mLocalThumbnailPreviewsEnabled;
    private final RequestLevel mLowestPermittedRequestLevel;

    @Nullable
    private final Postprocessor mPostprocessor;
    private final boolean mProgressiveRenderingEnabled;

    @Nullable
    private final RequestListener mRequestListener;
    private final Priority mRequestPriority;

    @Nullable
    private final ResizeOptions mResizeOptions;

    @Nullable
    private final Boolean mResizingAllowedOverride;
    private final RotationOptions mRotationOptions;

    @Nullable
    private File mSourceFile;
    private final Uri mSourceUri;
    private final int mSourceUriType;

    public enum CacheChoice {
        SMALL,
        DEFAULT,
        DYNAMIC
    }

    public @interface CachesLocationsMasks {
        public static final int BITMAP_READ = 1;
        public static final int BITMAP_WRITE = 2;
        public static final int DISK_READ = 16;
        public static final int DISK_WRITE = 32;
        public static final int ENCODED_READ = 4;
        public static final int ENCODED_WRITE = 8;
    }

    @Nullable
    public static ImageRequest fromFile(@Nullable File file) {
        if (file == null) {
            return null;
        }
        return fromUri(UriUtil.getUriForFile(file));
    }

    @Nullable
    public static ImageRequest fromUri(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return ImageRequestBuilder.newBuilderWithSource(uri).build();
    }

    @Nullable
    public static ImageRequest fromUri(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return fromUri(Uri.parse(str));
    }

    protected ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        RotationOptions rotationOptions;
        this.mCacheChoice = imageRequestBuilder.getCacheChoice();
        Uri sourceUri = imageRequestBuilder.getSourceUri();
        this.mSourceUri = sourceUri;
        this.mSourceUriType = getSourceUriType(sourceUri);
        this.mProgressiveRenderingEnabled = imageRequestBuilder.isProgressiveRenderingEnabled();
        this.mLocalThumbnailPreviewsEnabled = imageRequestBuilder.isLocalThumbnailPreviewsEnabled();
        this.mLoadThumbnailOnly = imageRequestBuilder.getLoadThumbnailOnly();
        this.mImageDecodeOptions = imageRequestBuilder.getImageDecodeOptions();
        this.mResizeOptions = imageRequestBuilder.getResizeOptions();
        if (imageRequestBuilder.getRotationOptions() == null) {
            rotationOptions = RotationOptions.autoRotate();
        } else {
            rotationOptions = imageRequestBuilder.getRotationOptions();
        }
        this.mRotationOptions = rotationOptions;
        this.mBytesRange = imageRequestBuilder.getBytesRange();
        this.mRequestPriority = imageRequestBuilder.getRequestPriority();
        this.mLowestPermittedRequestLevel = imageRequestBuilder.getLowestPermittedRequestLevel();
        boolean zIsDiskCacheEnabled = imageRequestBuilder.isDiskCacheEnabled();
        this.mIsDiskCacheEnabled = zIsDiskCacheEnabled;
        int cachesDisabled = imageRequestBuilder.getCachesDisabled();
        this.mCachesDisabled = zIsDiskCacheEnabled ? cachesDisabled : cachesDisabled | 48;
        this.mIsMemoryCacheEnabled = imageRequestBuilder.isMemoryCacheEnabled();
        this.mDecodePrefetches = imageRequestBuilder.shouldDecodePrefetches();
        this.mPostprocessor = imageRequestBuilder.getPostprocessor();
        this.mRequestListener = imageRequestBuilder.getRequestListener();
        this.mResizingAllowedOverride = imageRequestBuilder.getResizingAllowedOverride();
        this.mDelayMs = imageRequestBuilder.getDelayMs();
        this.mDiskCacheId = imageRequestBuilder.getDiskCacheId();
    }

    public CacheChoice getCacheChoice() {
        return this.mCacheChoice;
    }

    public Uri getSourceUri() {
        return this.mSourceUri;
    }

    public int getSourceUriType() {
        return this.mSourceUriType;
    }

    public int getPreferredWidth() {
        ResizeOptions resizeOptions = this.mResizeOptions;
        if (resizeOptions != null) {
            return resizeOptions.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        ResizeOptions resizeOptions = this.mResizeOptions;
        if (resizeOptions != null) {
            return resizeOptions.height;
        }
        return 2048;
    }

    @Nullable
    public ResizeOptions getResizeOptions() {
        return this.mResizeOptions;
    }

    public RotationOptions getRotationOptions() {
        return this.mRotationOptions;
    }

    @Deprecated
    public boolean getAutoRotateEnabled() {
        return this.mRotationOptions.useImageMetadata();
    }

    @Nullable
    public BytesRange getBytesRange() {
        return this.mBytesRange;
    }

    public ImageDecodeOptions getImageDecodeOptions() {
        return this.mImageDecodeOptions;
    }

    public boolean getProgressiveRenderingEnabled() {
        return this.mProgressiveRenderingEnabled;
    }

    public boolean getLocalThumbnailPreviewsEnabled() {
        return this.mLocalThumbnailPreviewsEnabled;
    }

    public boolean getLoadThumbnailOnlyForAndroidSdkAboveQ() {
        return Build.VERSION.SDK_INT >= 29 && this.mLoadThumbnailOnly;
    }

    public Priority getPriority() {
        return this.mRequestPriority;
    }

    public RequestLevel getLowestPermittedRequestLevel() {
        return this.mLowestPermittedRequestLevel;
    }

    public int getCachesDisabled() {
        return this.mCachesDisabled;
    }

    public boolean isDiskCacheEnabled() {
        return this.mIsDiskCacheEnabled;
    }

    public boolean isCacheEnabled(int i) {
        return (i & getCachesDisabled()) == 0;
    }

    public boolean isMemoryCacheEnabled() {
        return this.mIsMemoryCacheEnabled;
    }

    @Nullable
    public Boolean shouldDecodePrefetches() {
        return this.mDecodePrefetches;
    }

    @Nullable
    public Boolean getResizingAllowedOverride() {
        return this.mResizingAllowedOverride;
    }

    public int getDelayMs() {
        return this.mDelayMs;
    }

    public synchronized File getSourceFile() {
        if (this.mSourceFile == null) {
            Preconditions.checkNotNull(this.mSourceUri.getPath());
            this.mSourceFile = new File(this.mSourceUri.getPath());
        }
        return this.mSourceFile;
    }

    @Nullable
    public Postprocessor getPostprocessor() {
        return this.mPostprocessor;
    }

    @Nullable
    public RequestListener getRequestListener() {
        return this.mRequestListener;
    }

    @Nullable
    public String getDiskCacheId() {
        return this.mDiskCacheId;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ImageRequest)) {
            return false;
        }
        ImageRequest imageRequest = (ImageRequest) obj;
        if (sUseCachedHashcodeInEquals) {
            int i = this.mHashcode;
            int i2 = imageRequest.mHashcode;
            if (i != 0 && i2 != 0 && i != i2) {
                return false;
            }
        }
        if (this.mLocalThumbnailPreviewsEnabled != imageRequest.mLocalThumbnailPreviewsEnabled || this.mIsDiskCacheEnabled != imageRequest.mIsDiskCacheEnabled || this.mIsMemoryCacheEnabled != imageRequest.mIsMemoryCacheEnabled || !Objects.equal(this.mSourceUri, imageRequest.mSourceUri) || !Objects.equal(this.mCacheChoice, imageRequest.mCacheChoice) || !Objects.equal(this.mDiskCacheId, imageRequest.mDiskCacheId) || !Objects.equal(this.mSourceFile, imageRequest.mSourceFile) || !Objects.equal(this.mBytesRange, imageRequest.mBytesRange) || !Objects.equal(this.mImageDecodeOptions, imageRequest.mImageDecodeOptions) || !Objects.equal(this.mResizeOptions, imageRequest.mResizeOptions) || !Objects.equal(this.mRequestPriority, imageRequest.mRequestPriority) || !Objects.equal(this.mLowestPermittedRequestLevel, imageRequest.mLowestPermittedRequestLevel) || !Objects.equal(Integer.valueOf(this.mCachesDisabled), Integer.valueOf(imageRequest.mCachesDisabled)) || !Objects.equal(this.mDecodePrefetches, imageRequest.mDecodePrefetches) || !Objects.equal(this.mResizingAllowedOverride, imageRequest.mResizingAllowedOverride) || !Objects.equal(this.mRotationOptions, imageRequest.mRotationOptions) || this.mLoadThumbnailOnly != imageRequest.mLoadThumbnailOnly) {
            return false;
        }
        Postprocessor postprocessor = this.mPostprocessor;
        CacheKey postprocessorCacheKey = postprocessor != null ? postprocessor.getPostprocessorCacheKey() : null;
        Postprocessor postprocessor2 = imageRequest.mPostprocessor;
        return Objects.equal(postprocessorCacheKey, postprocessor2 != null ? postprocessor2.getPostprocessorCacheKey() : null) && this.mDelayMs == imageRequest.mDelayMs;
    }

    public int hashCode() {
        int iExtend;
        boolean z = sCacheHashcode;
        int i = z ? this.mHashcode : 0;
        if (i == 0) {
            Postprocessor postprocessor = this.mPostprocessor;
            CacheKey postprocessorCacheKey = postprocessor != null ? postprocessor.getPostprocessorCacheKey() : null;
            if (!MemorySpikeConfig.avoidObjectsHashCode()) {
                iExtend = Objects.hashCode(this.mCacheChoice, this.mDiskCacheId, this.mSourceUri, Boolean.valueOf(this.mLocalThumbnailPreviewsEnabled), this.mBytesRange, this.mRequestPriority, this.mLowestPermittedRequestLevel, Integer.valueOf(this.mCachesDisabled), Boolean.valueOf(this.mIsDiskCacheEnabled), Boolean.valueOf(this.mIsMemoryCacheEnabled), this.mImageDecodeOptions, this.mDecodePrefetches, this.mResizeOptions, this.mRotationOptions, postprocessorCacheKey, this.mResizingAllowedOverride, Integer.valueOf(this.mDelayMs), Boolean.valueOf(this.mLoadThumbnailOnly));
            } else {
                iExtend = HashCode.extend(HashCode.extend(HashCode.extend(HashCode.extend(HashCode.extend(HashCode.extend(HashCode.extend(HashCode.extend(HashCode.extend(HashCode.extend(HashCode.extend(HashCode.extend(HashCode.extend(HashCode.extend(HashCode.extend(HashCode.extend(HashCode.extend(0, this.mCacheChoice), this.mSourceUri), Boolean.valueOf(this.mLocalThumbnailPreviewsEnabled)), this.mBytesRange), this.mRequestPriority), this.mLowestPermittedRequestLevel), Integer.valueOf(this.mCachesDisabled)), Boolean.valueOf(this.mIsDiskCacheEnabled)), Boolean.valueOf(this.mIsMemoryCacheEnabled)), this.mImageDecodeOptions), this.mDecodePrefetches), this.mResizeOptions), this.mRotationOptions), postprocessorCacheKey), this.mResizingAllowedOverride), Integer.valueOf(this.mDelayMs)), Boolean.valueOf(this.mLoadThumbnailOnly));
            }
            i = iExtend;
            if (z) {
                this.mHashcode = i;
            }
        }
        return i;
    }

    public void recordHashCode(HashMap<String, Integer> map) {
        Postprocessor postprocessor = this.mPostprocessor;
        CacheKey postprocessorCacheKey = postprocessor != null ? postprocessor.getPostprocessorCacheKey() : null;
        map.put("ImageRequest", Integer.valueOf(hashCode()));
        map.put("ImageRequest.mSourceUri", Integer.valueOf(getHashCodeHelper(this.mSourceUri)));
        map.put("ImageRequest.mLocalThumbnailPreviewsEnabled", Integer.valueOf(getHashCodeHelper(Boolean.valueOf(this.mLocalThumbnailPreviewsEnabled))));
        map.put("ImageRequest.mBytesRange", Integer.valueOf(getHashCodeHelper(this.mBytesRange)));
        map.put("ImageRequest.mRequestPriority", Integer.valueOf(getHashCodeHelper(this.mRequestPriority)));
        map.put("ImageRequest.mLowestPermittedRequestLevel", Integer.valueOf(getHashCodeHelper(this.mLowestPermittedRequestLevel)));
        map.put("ImageRequest.mCachesDisabled", Integer.valueOf(getHashCodeHelper(Integer.valueOf(this.mCachesDisabled))));
        map.put("ImageRequest.mIsDiskCacheEnabled", Integer.valueOf(getHashCodeHelper(Boolean.valueOf(this.mIsDiskCacheEnabled))));
        map.put("ImageRequest.mIsMemoryCacheEnabled", Integer.valueOf(getHashCodeHelper(Boolean.valueOf(this.mIsMemoryCacheEnabled))));
        map.put("ImageRequest.mImageDecodeOptions", Integer.valueOf(getHashCodeHelper(this.mImageDecodeOptions)));
        map.put("ImageRequest.mDecodePrefetches", Integer.valueOf(getHashCodeHelper(this.mDecodePrefetches)));
        map.put("ImageRequest.mSoumResizeOptionsrceUri", Integer.valueOf(getHashCodeHelper(this.mResizeOptions)));
        map.put("ImageRequest.mRotationOptions", Integer.valueOf(getHashCodeHelper(this.mRotationOptions)));
        map.put("ImageRequest.postprocessorCacheKey", Integer.valueOf(getHashCodeHelper(postprocessorCacheKey)));
        map.put("ImageRequest.mResizingAllowedOverride", Integer.valueOf(getHashCodeHelper(this.mResizingAllowedOverride)));
        map.put("ImageRequest.mDelayMs", Integer.valueOf(getHashCodeHelper(Integer.valueOf(this.mDelayMs))));
        map.put("ImageRequest.mLoadThumbnailOnly", Integer.valueOf(getHashCodeHelper(Boolean.valueOf(this.mLoadThumbnailOnly))));
    }

    private static int getHashCodeHelper(@Nullable Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return Objects.toStringHelper(this).add(ShareConstants.MEDIA_URI, this.mSourceUri).add("cacheChoice", this.mCacheChoice).add("decodeOptions", this.mImageDecodeOptions).add("postprocessor", this.mPostprocessor).add(SentryThread.JsonKeys.PRIORITY, this.mRequestPriority).add("resizeOptions", this.mResizeOptions).add("rotationOptions", this.mRotationOptions).add("bytesRange", this.mBytesRange).add("resizingAllowedOverride", this.mResizingAllowedOverride).add("progressiveRenderingEnabled", this.mProgressiveRenderingEnabled).add("localThumbnailPreviewsEnabled", this.mLocalThumbnailPreviewsEnabled).add("loadThumbnailOnly", this.mLoadThumbnailOnly).add("lowestPermittedRequestLevel", this.mLowestPermittedRequestLevel).add("cachesDisabled", this.mCachesDisabled).add("isDiskCacheEnabled", this.mIsDiskCacheEnabled).add("isMemoryCacheEnabled", this.mIsMemoryCacheEnabled).add("decodePrefetches", this.mDecodePrefetches).add("delayMs", this.mDelayMs).toString();
    }

    public enum RequestLevel {
        FULL_FETCH(1),
        DISK_CACHE(2),
        ENCODED_MEMORY_CACHE(3),
        BITMAP_MEMORY_CACHE(4);

        private int mValue;

        RequestLevel(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }

        public static RequestLevel getMax(RequestLevel requestLevel, RequestLevel requestLevel2) {
            return requestLevel.getValue() > requestLevel2.getValue() ? requestLevel : requestLevel2;
        }
    }

    private static int getSourceUriType(@Nullable Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (UriUtil.isNetworkUri(uri)) {
            return 0;
        }
        if (uri.getPath() != null && UriUtil.isLocalFileUri(uri)) {
            return MediaUtils.isVideo(MediaUtils.extractMime(uri.getPath())) ? 2 : 3;
        }
        if (UriUtil.isLocalContentUri(uri)) {
            return 4;
        }
        if (UriUtil.isLocalAssetUri(uri)) {
            return 5;
        }
        if (UriUtil.isLocalResourceUri(uri)) {
            return 6;
        }
        if (UriUtil.isDataUri(uri)) {
            return 7;
        }
        return UriUtil.isQualifiedResourceUri(uri) ? 8 : -1;
    }

    public static void setUseCachedHashcodeInEquals(boolean z) {
        sUseCachedHashcodeInEquals = z;
    }

    public static void setCacheHashcode(boolean z) {
        sCacheHashcode = z;
    }
}
