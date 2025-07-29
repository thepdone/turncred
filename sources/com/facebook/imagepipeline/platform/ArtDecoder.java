package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.util.Pools;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArtDecoder.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/facebook/imagepipeline/platform/ArtDecoder;", "Lcom/facebook/imagepipeline/platform/DefaultDecoder;", "bitmapPool", "Lcom/facebook/imagepipeline/memory/BitmapPool;", "decodeBuffers", "Landroidx/core/util/Pools$Pool;", "Ljava/nio/ByteBuffer;", "platformDecoderOptions", "Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions;", "(Lcom/facebook/imagepipeline/memory/BitmapPool;Landroidx/core/util/Pools$Pool;Lcom/facebook/imagepipeline/platform/PlatformDecoderOptions;)V", "getBitmapSize", "", "width", "height", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Landroid/graphics/BitmapFactory$Options;", "imagepipeline_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ArtDecoder extends DefaultDecoder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtDecoder(BitmapPool bitmapPool, Pools.Pool<ByteBuffer> decodeBuffers, PlatformDecoderOptions platformDecoderOptions) {
        super(bitmapPool, decodeBuffers, platformDecoderOptions);
        Intrinsics.checkNotNullParameter(bitmapPool, "bitmapPool");
        Intrinsics.checkNotNullParameter(decodeBuffers, "decodeBuffers");
        Intrinsics.checkNotNullParameter(platformDecoderOptions, "platformDecoderOptions");
    }

    @Override // com.facebook.imagepipeline.platform.DefaultDecoder
    public int getBitmapSize(int width, int height, BitmapFactory.Options options) {
        Intrinsics.checkNotNullParameter(options, "options");
        Bitmap.Config config = options.inPreferredConfig;
        if (config == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        return BitmapUtil.getSizeInByteForBitmap(width, height, config);
    }
}
