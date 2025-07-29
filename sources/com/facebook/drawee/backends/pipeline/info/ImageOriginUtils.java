package com.facebook.drawee.backends.pipeline.info;

import com.google.android.gms.common.internal.ImagesContract;

/* loaded from: classes4.dex */
public class ImageOriginUtils {
    public static String toString(int i) {
        switch (i) {
            case 2:
                return "network";
            case 3:
                return "disk";
            case 4:
                return "memory_encoded";
            case 5:
                return "memory_bitmap";
            case 6:
                return "memory_bitmap_shortcut";
            case 7:
                return ImagesContract.LOCAL;
            default:
                return "unknown";
        }
    }

    public static int mapProducerNameToImageOrigin(String str) {
        str.hashCode();
        switch (str) {
            case "QualifiedResourceFetchProducer":
            case "LocalResourceFetchProducer":
            case "LocalFileFetchProducer":
            case "VideoThumbnailProducer":
            case "LocalAssetFetchProducer":
            case "DataFetchProducer":
            case "LocalContentUriThumbnailFetchProducer":
            case "LocalContentUriFetchProducer":
                return 7;
            case "BitmapMemoryCacheGetProducer":
            case "BitmapMemoryCacheProducer":
            case "PostprocessedBitmapMemoryCacheProducer":
                return 5;
            case "EncodedMemoryCacheProducer":
                return 4;
            case "NetworkFetchProducer":
                return 2;
            case "DiskCacheProducer":
            case "PartialDiskCacheProducer":
                return 3;
            default:
                return 1;
        }
    }

    private ImageOriginUtils() {
    }
}
