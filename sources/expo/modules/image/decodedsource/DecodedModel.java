package expo.modules.image.decodedsource;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DecodedModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/image/decodedsource/DecodedModel;", "", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "expo-image_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DecodedModel {
    private final Drawable drawable;

    public DecodedModel(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.drawable = drawable;
    }

    public final Drawable getDrawable() {
        return this.drawable;
    }
}
