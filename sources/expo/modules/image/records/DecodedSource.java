package expo.modules.image.records;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import expo.modules.image.DecodedModelProvider;
import expo.modules.image.GlideModelProvider;
import expo.modules.image.records.Source;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SourceMap.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u0017"}, d2 = {"Lexpo/modules/image/records/DecodedSource;", "Lexpo/modules/image/records/Source;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "height", "", "getHeight", "()I", "scale", "", "getScale", "()D", "width", "getWidth", "createGlideModelProvider", "Lexpo/modules/image/GlideModelProvider;", "context", "Landroid/content/Context;", "createGlideOptions", "Lcom/bumptech/glide/request/RequestOptions;", "expo-image_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DecodedSource implements Source {
    private final Drawable drawable;
    private final int height;
    private final double scale;
    private final int width;

    public DecodedSource(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.drawable = drawable;
        this.width = drawable.getIntrinsicWidth();
        this.height = drawable.getIntrinsicHeight();
        this.scale = 1.0d;
    }

    @Override // expo.modules.image.records.Source
    public double getPixelCount() {
        return Source.DefaultImpls.getPixelCount(this);
    }

    @Override // expo.modules.image.records.Source
    public boolean usesPlaceholderContentFit() {
        return Source.DefaultImpls.usesPlaceholderContentFit(this);
    }

    public final Drawable getDrawable() {
        return this.drawable;
    }

    @Override // expo.modules.image.records.Source
    public GlideModelProvider createGlideModelProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new DecodedModelProvider(this.drawable);
    }

    @Override // expo.modules.image.records.Source
    public int getWidth() {
        return this.width;
    }

    @Override // expo.modules.image.records.Source
    public int getHeight() {
        return this.height;
    }

    @Override // expo.modules.image.records.Source
    public double getScale() {
        return this.scale;
    }

    @Override // expo.modules.image.records.Source
    public RequestOptions createGlideOptions(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        RequestOptions requestOptionsDiskCacheStrategy = new RequestOptions().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE);
        Intrinsics.checkNotNullExpressionValue(requestOptionsDiskCacheStrategy, "diskCacheStrategy(...)");
        return requestOptionsDiskCacheStrategy;
    }
}
