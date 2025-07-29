package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imageutils.JfifUtil;
import expo.modules.contacts.Columns;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* loaded from: classes4.dex */
public class LocalContentUriThumbnailFetchProducer extends LocalFetchProducer implements ThumbnailProducer<EncodedImage> {
    private static final int NO_THUMBNAIL = 0;
    public static final String PRODUCER_NAME = "LocalContentUriThumbnailFetchProducer";
    private final ContentResolver mContentResolver;
    private static final Class<?> TAG = LocalContentUriThumbnailFetchProducer.class;
    private static final String[] PROJECTION = {Columns.ID, "_data"};
    private static final String[] THUMBNAIL_PROJECTION = {"_data"};
    private static final Rect MINI_THUMBNAIL_DIMENSIONS = new Rect(0, 0, 512, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT);
    private static final Rect MICRO_THUMBNAIL_DIMENSIONS = new Rect(0, 0, 96, 96);

    public LocalContentUriThumbnailFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.ThumbnailProducer
    public boolean canProvideImageForSize(@Nullable ResizeOptions resizeOptions) {
        Rect rect = MINI_THUMBNAIL_DIMENSIONS;
        return ThumbnailSizeChecker.isImageBigEnough(rect.width(), rect.height(), resizeOptions);
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    @Nullable
    protected EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException {
        Uri sourceUri = imageRequest.getSourceUri();
        if (UriUtil.isLocalCameraUri(sourceUri)) {
            return getCameraImage(sourceUri, imageRequest.getResizeOptions());
        }
        return null;
    }

    @Nullable
    private EncodedImage getCameraImage(Uri uri, @Nullable ResizeOptions resizeOptions) throws IOException {
        Cursor cursorQuery;
        EncodedImage thumbnail;
        if (resizeOptions == null || (cursorQuery = this.mContentResolver.query(uri, PROJECTION, null, null, null)) == null) {
            return null;
        }
        try {
            if (!cursorQuery.moveToFirst() || (thumbnail = getThumbnail(resizeOptions, cursorQuery.getLong(cursorQuery.getColumnIndex(Columns.ID)))) == null) {
                return null;
            }
            int columnIndex = cursorQuery.getColumnIndex("_data");
            if (columnIndex >= 0) {
                thumbnail.setRotationAngle(getRotationAngle(cursorQuery.getString(columnIndex)));
            }
            return thumbnail;
        } finally {
            cursorQuery.close();
        }
    }

    @Nullable
    private EncodedImage getThumbnail(ResizeOptions resizeOptions, long j) throws IOException {
        Cursor cursorQueryMiniThumbnail;
        int columnIndex;
        int thumbnailKind = getThumbnailKind(resizeOptions);
        if (thumbnailKind == 0 || (cursorQueryMiniThumbnail = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.mContentResolver, j, thumbnailKind, THUMBNAIL_PROJECTION)) == null) {
            return null;
        }
        try {
            if (cursorQueryMiniThumbnail.moveToFirst() && (columnIndex = cursorQueryMiniThumbnail.getColumnIndex("_data")) >= 0) {
                String str = (String) Preconditions.checkNotNull(cursorQueryMiniThumbnail.getString(columnIndex));
                if (new File(str).exists()) {
                    return getEncodedImage(new FileInputStream(str), getLength(str));
                }
            }
            return null;
        } finally {
            cursorQueryMiniThumbnail.close();
        }
    }

    private static int getThumbnailKind(ResizeOptions resizeOptions) {
        Rect rect = MICRO_THUMBNAIL_DIMENSIONS;
        if (ThumbnailSizeChecker.isImageBigEnough(rect.width(), rect.height(), resizeOptions)) {
            return 3;
        }
        Rect rect2 = MINI_THUMBNAIL_DIMENSIONS;
        return ThumbnailSizeChecker.isImageBigEnough(rect2.width(), rect2.height(), resizeOptions) ? 1 : 0;
    }

    private static int getLength(String str) {
        if (str == null) {
            return -1;
        }
        return (int) new File(str).length();
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    protected String getProducerName() {
        return PRODUCER_NAME;
    }

    private static int getRotationAngle(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        try {
            return JfifUtil.getAutoRotateAngleFromOrientation(new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1));
        } catch (IOException e) {
            FLog.e(TAG, e, "Unable to retrieve thumbnail rotation for %s", str);
            return 0;
        }
    }
}
