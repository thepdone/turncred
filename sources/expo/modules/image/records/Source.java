package expo.modules.image.records;

import android.content.Context;
import com.bumptech.glide.request.RequestOptions;
import expo.modules.image.GlideModelProvider;
import kotlin.Metadata;

/* compiled from: SourceMap.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005\u0082\u0001\u0002\u0016\u0017¨\u0006\u0018"}, d2 = {"Lexpo/modules/image/records/Source;", "", "height", "", "getHeight", "()I", "pixelCount", "", "getPixelCount", "()D", "scale", "getScale", "width", "getWidth", "createGlideModelProvider", "Lexpo/modules/image/GlideModelProvider;", "context", "Landroid/content/Context;", "createGlideOptions", "Lcom/bumptech/glide/request/RequestOptions;", "usesPlaceholderContentFit", "", "Lexpo/modules/image/records/DecodedSource;", "Lexpo/modules/image/records/SourceMap;", "expo-image_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface Source {
    GlideModelProvider createGlideModelProvider(Context context);

    RequestOptions createGlideOptions(Context context);

    int getHeight();

    double getPixelCount();

    double getScale();

    int getWidth();

    boolean usesPlaceholderContentFit();

    /* compiled from: SourceMap.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean usesPlaceholderContentFit(Source source) {
            return true;
        }

        public static double getPixelCount(Source source) {
            return source.getWidth() * source.getHeight() * source.getScale() * source.getScale();
        }
    }
}
