package com.facebook.drawee.debug.listener;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import javax.annotation.Nullable;

/* loaded from: classes4.dex */
public class ImageLoadingTimeControllerListener extends BaseControllerListener {

    @Nullable
    private ImageLoadingTimeListener mImageLoadingTimeListener;
    private long mRequestSubmitTimeMs = -1;
    private long mFinalImageSetTimeMs = -1;

    public ImageLoadingTimeControllerListener(@Nullable ImageLoadingTimeListener imageLoadingTimeListener) {
        this.mImageLoadingTimeListener = imageLoadingTimeListener;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onSubmit(String str, Object obj) {
        this.mRequestSubmitTimeMs = System.currentTimeMillis();
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.mFinalImageSetTimeMs = jCurrentTimeMillis;
        ImageLoadingTimeListener imageLoadingTimeListener = this.mImageLoadingTimeListener;
        if (imageLoadingTimeListener != null) {
            imageLoadingTimeListener.onFinalImageSet(jCurrentTimeMillis - this.mRequestSubmitTimeMs);
        }
    }
}
