package expo.modules.imagemanipulator;

import android.graphics.Bitmap;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import expo.modules.imagemanipulator.transformers.ImageTransformer;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.UnexpectedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageManipulatorContext.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0005HÂ\u0003J!\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\r\u001a\u00020\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lexpo/modules/imagemanipulator/ManipulatorResult;", "", "value", "Landroid/graphics/Bitmap;", "error", "Lexpo/modules/kotlin/exception/CodedException;", "(Landroid/graphics/Bitmap;Lexpo/modules/kotlin/exception/CodedException;)V", "component1", "component2", "copy", "equals", "", "other", "get", "hashCode", "", "map", "transformer", "Lexpo/modules/imagemanipulator/transformers/ImageTransformer;", InAppPurchaseConstants.METHOD_TO_STRING, "", "expo-image-manipulator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ManipulatorResult {
    private final CodedException error;
    private final Bitmap value;

    /* renamed from: component1, reason: from getter */
    private final Bitmap getValue() {
        return this.value;
    }

    /* renamed from: component2, reason: from getter */
    private final CodedException getError() {
        return this.error;
    }

    public static /* synthetic */ ManipulatorResult copy$default(ManipulatorResult manipulatorResult, Bitmap bitmap, CodedException codedException, int i, Object obj) {
        if ((i & 1) != 0) {
            bitmap = manipulatorResult.value;
        }
        if ((i & 2) != 0) {
            codedException = manipulatorResult.error;
        }
        return manipulatorResult.copy(bitmap, codedException);
    }

    public final ManipulatorResult copy(Bitmap value, CodedException error) {
        return new ManipulatorResult(value, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ManipulatorResult)) {
            return false;
        }
        ManipulatorResult manipulatorResult = (ManipulatorResult) other;
        return Intrinsics.areEqual(this.value, manipulatorResult.value) && Intrinsics.areEqual(this.error, manipulatorResult.error);
    }

    public int hashCode() {
        Bitmap bitmap = this.value;
        int iHashCode = (bitmap == null ? 0 : bitmap.hashCode()) * 31;
        CodedException codedException = this.error;
        return iHashCode + (codedException != null ? codedException.hashCode() : 0);
    }

    public String toString() {
        return "ManipulatorResult(value=" + this.value + ", error=" + this.error + ")";
    }

    public ManipulatorResult(Bitmap bitmap, CodedException codedException) {
        this.value = bitmap;
        this.error = codedException;
    }

    public final ManipulatorResult map(ImageTransformer transformer) {
        UnexpectedException unexpectedException;
        Intrinsics.checkNotNullParameter(transformer, "transformer");
        CodedException codedException = this.error;
        if (codedException != null) {
            return new ManipulatorResult(null, codedException);
        }
        try {
            Bitmap bitmap = this.value;
            if (bitmap != null) {
                return new ManipulatorResult(transformer.transform(bitmap), null);
            }
            throw new IllegalArgumentException("The result doesn't have a value or error".toString());
        } catch (Throwable th) {
            if (th instanceof CodedException) {
                unexpectedException = (CodedException) th;
            } else if (th instanceof expo.modules.core.errors.CodedException) {
                String code = ((expo.modules.core.errors.CodedException) th).getCode();
                Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                unexpectedException = new CodedException(code, th.getMessage(), th.getCause());
            } else {
                unexpectedException = new UnexpectedException(th);
            }
            return new ManipulatorResult(null, unexpectedException);
        }
    }

    public final Bitmap get() throws CodedException {
        CodedException codedException = this.error;
        if (codedException != null) {
            throw codedException;
        }
        Bitmap bitmap = this.value;
        if (bitmap != null) {
            return bitmap;
        }
        throw new IllegalArgumentException("The result doesn't have a value or error".toString());
    }
}
