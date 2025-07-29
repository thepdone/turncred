package expo.modules.image;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Exceptions.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/image/ImageLoadFailed;", "Lexpo/modules/kotlin/exception/CodedException;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;)V", "expo-image_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImageLoadFailed extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageLoadFailed(Exception exception) {
        super("Failed to load the image: " + exception.getMessage(), null, 2, null);
        Intrinsics.checkNotNullParameter(exception, "exception");
    }
}
