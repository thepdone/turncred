package com.facebook.react.views.imagehelper;

import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultiSourceHelper.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\u000e"}, d2 = {"Lcom/facebook/react/views/imagehelper/MultiSourceHelper;", "", "()V", "getBestSourceForSize", "Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;", "width", "", "height", "sources", "", "Lcom/facebook/react/views/imagehelper/ImageSource;", "multiplier", "", "MultiSourceResult", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MultiSourceHelper {
    public static final MultiSourceHelper INSTANCE = new MultiSourceHelper();

    private MultiSourceHelper() {
    }

    @JvmStatic
    public static final MultiSourceResult getBestSourceForSize(int width, int height, List<? extends ImageSource> sources) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        return getBestSourceForSize(width, height, sources, 1.0d);
    }

    @JvmStatic
    public static final MultiSourceResult getBestSourceForSize(int width, int height, List<? extends ImageSource> sources, double multiplier) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        if (sources.isEmpty()) {
            return new MultiSourceResult(null, null);
        }
        if (sources.size() == 1) {
            return new MultiSourceResult(sources.get(0), null);
        }
        if (width <= 0 || height <= 0) {
            return new MultiSourceResult(null, null);
        }
        ImagePipeline imagePipeline = ImagePipelineFactory.getInstance().getImagePipeline();
        Intrinsics.checkNotNullExpressionValue(imagePipeline, "getImagePipeline(...)");
        double d = width * height * multiplier;
        double d2 = Double.MAX_VALUE;
        double d3 = Double.MAX_VALUE;
        ImageSource imageSource = null;
        ImageSource imageSource2 = null;
        for (ImageSource imageSource3 : sources) {
            double dAbs = Math.abs(1.0d - (imageSource3.getSize() / d));
            if (dAbs < d2) {
                imageSource2 = imageSource3;
                d2 = dAbs;
            }
            if (dAbs < d3 && (imagePipeline.isInBitmapMemoryCache(imageSource3.getUri()) || imagePipeline.isInDiskCacheSync(imageSource3.getUri()))) {
                imageSource = imageSource3;
                d3 = dAbs;
            }
        }
        return new MultiSourceResult(imageSource2, (imageSource == null || imageSource2 == null || !Intrinsics.areEqual(imageSource.getSource(), imageSource2.getSource())) ? imageSource : null);
    }

    /* compiled from: MultiSourceHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/react/views/imagehelper/MultiSourceHelper$MultiSourceResult;", "", "bestResult", "Lcom/facebook/react/views/imagehelper/ImageSource;", "bestResultInCache", "(Lcom/facebook/react/views/imagehelper/ImageSource;Lcom/facebook/react/views/imagehelper/ImageSource;)V", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class MultiSourceResult {
        public final ImageSource bestResult;
        public final ImageSource bestResultInCache;

        public MultiSourceResult(ImageSource imageSource, ImageSource imageSource2) {
            this.bestResult = imageSource;
            this.bestResultInCache = imageSource2;
        }
    }
}
