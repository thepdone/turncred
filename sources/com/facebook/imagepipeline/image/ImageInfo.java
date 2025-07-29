package com.facebook.imagepipeline.image;

/* loaded from: classes4.dex */
public interface ImageInfo extends HasImageMetadata {
    int getHeight();

    QualityInfo getQualityInfo();

    default int getSizeInBytes() {
        return 0;
    }

    int getWidth();
}
