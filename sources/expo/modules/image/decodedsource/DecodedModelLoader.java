package expo.modules.image.decodedsource;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DecodedModelLoader.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J.\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\u000f"}, d2 = {"Lexpo/modules/image/decodedsource/DecodedModelLoader;", "Lcom/bumptech/glide/load/model/ModelLoader;", "Lexpo/modules/image/decodedsource/DecodedModel;", "Landroid/graphics/drawable/Drawable;", "()V", "buildLoadData", "Lcom/bumptech/glide/load/model/ModelLoader$LoadData;", "model", "width", "", "height", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lcom/bumptech/glide/load/Options;", "handles", "", "expo-image_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DecodedModelLoader implements ModelLoader<DecodedModel, Drawable> {
    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(DecodedModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Drawable> buildLoadData(DecodedModel model, int width, int height, Options options) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(options, "options");
        return new ModelLoader.LoadData<>(new ObjectKey(model), new DecodedFetcher(model.getDrawable()));
    }
}
