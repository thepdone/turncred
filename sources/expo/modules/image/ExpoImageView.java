package expo.modules.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.RequestManager;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.image.enums.ContentFit;
import expo.modules.image.records.ContentPosition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExpoImageView.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010!\u001a\u00020\"J?\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020+H\u0016J0\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020&H\u0014J\b\u00102\u001a\u0004\u0018\u00010\u0013J\u0019\u00103\u001a\u00020\"2\b\u00104\u001a\u0004\u0018\u00010&H\u0000¢\u0006\u0004\b5\u00106R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\t\"\u0004\b\u001f\u0010\u000bR\u000e\u0010 \u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lexpo/modules/image/ExpoImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "Lexpo/modules/image/enums/ContentFit;", "contentFit", "getContentFit$expo_image_release", "()Lexpo/modules/image/enums/ContentFit;", "setContentFit$expo_image_release", "(Lexpo/modules/image/enums/ContentFit;)V", "Lexpo/modules/image/records/ContentPosition;", "contentPosition", "getContentPosition$expo_image_release", "()Lexpo/modules/image/records/ContentPosition;", "setContentPosition$expo_image_release", "(Lexpo/modules/image/records/ContentPosition;)V", "currentTarget", "Lexpo/modules/image/ImageViewWrapperTarget;", "getCurrentTarget", "()Lexpo/modules/image/ImageViewWrapperTarget;", "setCurrentTarget", "(Lexpo/modules/image/ImageViewWrapperTarget;)V", "isPlaceholder", "", "()Z", "setPlaceholder", "(Z)V", "placeholderContentFit", "getPlaceholderContentFit$expo_image_release", "setPlaceholderContentFit$expo_image_release", "transformationMatrixChanged", "applyTransformationMatrix", "", "drawable", "Landroid/graphics/drawable/Drawable;", "sourceWidth", "", "sourceHeight", "(Landroid/graphics/drawable/Drawable;Lexpo/modules/image/enums/ContentFit;Lexpo/modules/image/records/ContentPosition;Ljava/lang/Integer;Ljava/lang/Integer;)V", "draw", "canvas", "Landroid/graphics/Canvas;", ViewProps.ON_LAYOUT, "changed", "left", "top", ViewProps.RIGHT, ViewProps.BOTTOM, "recycleView", "setTintColor", ViewProps.COLOR, "setTintColor$expo_image_release", "(Ljava/lang/Integer;)V", "expo-image_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExpoImageView extends AppCompatImageView {
    private ContentFit contentFit;
    private ContentPosition contentPosition;
    private ImageViewWrapperTarget currentTarget;
    private boolean isPlaceholder;
    private ContentFit placeholderContentFit;
    private boolean transformationMatrixChanged;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoImageView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setClipToOutline(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.contentFit = ContentFit.Cover;
        this.placeholderContentFit = ContentFit.ScaleDown;
        this.contentPosition = ContentPosition.INSTANCE.getCenter();
    }

    public final ImageViewWrapperTarget getCurrentTarget() {
        return this.currentTarget;
    }

    public final void setCurrentTarget(ImageViewWrapperTarget imageViewWrapperTarget) {
        this.currentTarget = imageViewWrapperTarget;
    }

    /* renamed from: isPlaceholder, reason: from getter */
    public final boolean getIsPlaceholder() {
        return this.isPlaceholder;
    }

    public final void setPlaceholder(boolean z) {
        this.isPlaceholder = z;
    }

    public final ImageViewWrapperTarget recycleView() {
        setImageDrawable(null);
        ImageViewWrapperTarget imageViewWrapperTarget = this.currentTarget;
        if (imageViewWrapperTarget != null) {
            imageViewWrapperTarget.setUsed(false);
        } else {
            imageViewWrapperTarget = null;
        }
        this.currentTarget = null;
        setVisibility(8);
        this.isPlaceholder = false;
        return imageViewWrapperTarget;
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        applyTransformationMatrix();
    }

    public final void applyTransformationMatrix() {
        if (getDrawable() == null) {
            return;
        }
        if (this.isPlaceholder) {
            Drawable drawable = getDrawable();
            ContentFit contentFit = this.placeholderContentFit;
            ImageViewWrapperTarget imageViewWrapperTarget = this.currentTarget;
            Integer numValueOf = imageViewWrapperTarget != null ? Integer.valueOf(imageViewWrapperTarget.getPlaceholderHeight()) : null;
            ImageViewWrapperTarget imageViewWrapperTarget2 = this.currentTarget;
            Integer numValueOf2 = imageViewWrapperTarget2 != null ? Integer.valueOf(imageViewWrapperTarget2.getPlaceholderWidth()) : null;
            Intrinsics.checkNotNull(drawable);
            applyTransformationMatrix$default(this, drawable, contentFit, null, numValueOf2, numValueOf, 4, null);
            return;
        }
        Drawable drawable2 = getDrawable();
        Intrinsics.checkNotNullExpressionValue(drawable2, "getDrawable(...)");
        applyTransformationMatrix$default(this, drawable2, this.contentFit, this.contentPosition, null, null, 24, null);
    }

    static /* synthetic */ void applyTransformationMatrix$default(ExpoImageView expoImageView, Drawable drawable, ContentFit contentFit, ContentPosition contentPosition, Integer num, Integer num2, int i, Object obj) {
        if ((i & 4) != 0) {
            contentPosition = ContentPosition.INSTANCE.getCenter();
        }
        ContentPosition contentPosition2 = contentPosition;
        if ((i & 8) != 0) {
            ImageViewWrapperTarget imageViewWrapperTarget = expoImageView.currentTarget;
            num = imageViewWrapperTarget != null ? Integer.valueOf(imageViewWrapperTarget.getSourceWidth()) : null;
        }
        Integer num3 = num;
        if ((i & 16) != 0) {
            ImageViewWrapperTarget imageViewWrapperTarget2 = expoImageView.currentTarget;
            num2 = imageViewWrapperTarget2 != null ? Integer.valueOf(imageViewWrapperTarget2.getSourceHeight()) : null;
        }
        expoImageView.applyTransformationMatrix(drawable, contentFit, contentPosition2, num3, num2);
    }

    private final void applyTransformationMatrix(Drawable drawable, ContentFit contentFit, ContentPosition contentPosition, Integer sourceWidth, Integer sourceHeight) {
        RectF rectF = new RectF(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        RectF rectF2 = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        Matrix matrix$expo_image_release = contentFit.toMatrix$expo_image_release(rectF, rectF2, sourceWidth != null ? sourceWidth.intValue() : -1, sourceHeight != null ? sourceHeight.intValue() : -1);
        matrix$expo_image_release.mapRect(rectF);
        contentPosition.apply$expo_image_release(matrix$expo_image_release, rectF, rectF2);
        setImageMatrix(matrix$expo_image_release);
    }

    /* renamed from: getContentFit$expo_image_release, reason: from getter */
    public final ContentFit getContentFit() {
        return this.contentFit;
    }

    public final void setContentFit$expo_image_release(ContentFit value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.contentFit = value;
        this.transformationMatrixChanged = true;
    }

    /* renamed from: getPlaceholderContentFit$expo_image_release, reason: from getter */
    public final ContentFit getPlaceholderContentFit() {
        return this.placeholderContentFit;
    }

    public final void setPlaceholderContentFit$expo_image_release(ContentFit value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.placeholderContentFit = value;
        this.transformationMatrixChanged = true;
    }

    /* renamed from: getContentPosition$expo_image_release, reason: from getter */
    public final ContentPosition getContentPosition() {
        return this.contentPosition;
    }

    public final void setContentPosition$expo_image_release(ContentPosition value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.contentPosition = value;
        this.transformationMatrixChanged = true;
    }

    public final void setTintColor$expo_image_release(Integer color) {
        Unit unit;
        if (color != null) {
            setColorFilter(color.intValue(), PorterDuff.Mode.SRC_IN);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            clearColorFilter();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Bitmap bitmap;
        RequestManager requestManager;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Drawable drawable = getDrawable();
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null && bitmap.isRecycled()) {
            Log.e("ExpoImage", "Trying to use a recycled bitmap");
            ImageViewWrapperTarget imageViewWrapperTargetRecycleView = recycleView();
            if (imageViewWrapperTargetRecycleView != null) {
                ViewParent parent = getParent();
                ExpoImageViewWrapper expoImageViewWrapper = parent instanceof ExpoImageViewWrapper ? (ExpoImageViewWrapper) parent : null;
                if (expoImageViewWrapper != null && (requestManager = expoImageViewWrapper.getRequestManager()) != null) {
                    imageViewWrapperTargetRecycleView.clear(requestManager);
                }
            }
        }
        super.draw(canvas);
    }
}
