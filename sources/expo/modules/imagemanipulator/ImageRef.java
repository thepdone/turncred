package expo.modules.imagemanipulator;

import android.graphics.Bitmap;
import expo.modules.kotlin.RuntimeContext;
import expo.modules.kotlin.sharedobjects.SharedRef;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageRef.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lexpo/modules/imagemanipulator/ImageRef;", "Lexpo/modules/kotlin/sharedobjects/SharedRef;", "Landroid/graphics/Bitmap;", "bitmap", "runtimeContext", "Lexpo/modules/kotlin/RuntimeContext;", "(Landroid/graphics/Bitmap;Lexpo/modules/kotlin/RuntimeContext;)V", "nativeRefType", "", "getNativeRefType", "()Ljava/lang/String;", "getAdditionalMemoryPressure", "", "expo-image-manipulator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImageRef extends SharedRef<Bitmap> {
    private final String nativeRefType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageRef(Bitmap bitmap, RuntimeContext runtimeContext) {
        super(bitmap, runtimeContext);
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(runtimeContext, "runtimeContext");
        this.nativeRefType = "image";
    }

    @Override // expo.modules.kotlin.sharedobjects.SharedRef
    public String getNativeRefType() {
        return this.nativeRefType;
    }

    @Override // expo.modules.kotlin.sharedobjects.SharedObject
    public int getAdditionalMemoryPressure() {
        return getRef().getAllocationByteCount();
    }
}
