package expo.modules.imagepicker.exporters;

import android.graphics.BitmapFactory;
import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DimensionsExporter.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\t\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lexpo/modules/imagepicker/exporters/DimensionsExporter;", "", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "height", "", "getHeight", "()I", "isRotatedLandscape", "", "()Z", "isRotatedLandscape$delegate", "Lkotlin/Lazy;", "metadata", "Landroid/graphics/BitmapFactory$Options;", "getMetadata", "()Landroid/graphics/BitmapFactory$Options;", "metadata$delegate", "width", "getWidth", "expo-image-picker_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DimensionsExporter {
    private final File file;

    /* renamed from: isRotatedLandscape$delegate, reason: from kotlin metadata */
    private final Lazy isRotatedLandscape;

    /* renamed from: metadata$delegate, reason: from kotlin metadata */
    private final Lazy metadata;

    public DimensionsExporter(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.file = file;
        this.isRotatedLandscape = LazyKt.lazy(new Function0<Boolean>() { // from class: expo.modules.imagepicker.exporters.DimensionsExporter.isRotatedLandscape.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                int attributeInt = new ExifInterface(DimensionsExporter.this.file.getAbsolutePath()).getAttributeInt(ExifInterface.TAG_ORIENTATION, 0);
                return Boolean.valueOf(attributeInt == 6 || attributeInt == 8 || attributeInt == 5 || attributeInt == 7);
            }
        });
        this.metadata = LazyKt.lazy(new Function0<BitmapFactory.Options>() { // from class: expo.modules.imagepicker.exporters.DimensionsExporter$metadata$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BitmapFactory.Options invoke() {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(this.this$0.file.getAbsolutePath(), options);
                return options;
            }
        });
    }

    private final boolean isRotatedLandscape() {
        return ((Boolean) this.isRotatedLandscape.getValue()).booleanValue();
    }

    private final BitmapFactory.Options getMetadata() {
        return (BitmapFactory.Options) this.metadata.getValue();
    }

    public final int getWidth() {
        return isRotatedLandscape() ? getMetadata().outHeight : getMetadata().outWidth;
    }

    public final int getHeight() {
        return isRotatedLandscape() ? getMetadata().outWidth : getMetadata().outHeight;
    }
}
