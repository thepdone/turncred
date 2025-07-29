package expo.modules.image.blurhash;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.hermes.intl.Constants;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BlurhashModelLoader.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J.\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J?\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u0002H\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002H\u000e0\u0014H\u0002¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\u0019"}, d2 = {"Lexpo/modules/image/blurhash/BlurhashModelLoader;", "Lcom/bumptech/glide/load/model/ModelLoader;", "Lexpo/modules/image/blurhash/BlurhashModel;", "Landroid/graphics/Bitmap;", "()V", "buildLoadData", "Lcom/bumptech/glide/load/model/ModelLoader$LoadData;", "model", "width", "", "height", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lcom/bumptech/glide/load/Options;", "getPath", ExifInterface.GPS_DIRECTION_TRUE, ShareConstants.MEDIA_URI, "Landroid/net/Uri;", FirebaseAnalytics.Param.INDEX, Constants.COLLATION_DEFAULT, "converter", "Lkotlin/Function1;", "", "(Landroid/net/Uri;ILjava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "handles", "", "expo-image_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BlurhashModelLoader implements ModelLoader<BlurhashModel, Bitmap> {
    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(BlurhashModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Bitmap> buildLoadData(BlurhashModel model, int width, int height, Options options) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(options, "options");
        return new ModelLoader.LoadData<>(new ObjectKey(model), new BlurHashFetcher((String) getPath(model.getUri(), 0, null, new Function1<String, String>() { // from class: expo.modules.image.blurhash.BlurhashModelLoader$buildLoadData$blurhash$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it;
            }
        }), model.getWidth(), model.getHeight(), 1.0f));
    }

    private final <T> T getPath(Uri uri, int index, T t, Function1<? super String, ? extends T> converter) {
        List<String> pathSegments = uri.getPathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "getPathSegments(...)");
        String str = (String) CollectionsKt.getOrNull(pathSegments, index);
        return str == null ? t : converter.invoke(str);
    }
}
