package expo.modules.imagemanipulator;

import android.graphics.Bitmap;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ImageManipulatorArguments.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lexpo/modules/imagemanipulator/ImageFormat;", "", "Lexpo/modules/kotlin/types/Enumerable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "compressFormat", "Landroid/graphics/Bitmap$CompressFormat;", "getCompressFormat", "()Landroid/graphics/Bitmap$CompressFormat;", "fileExtension", "getFileExtension", "()Ljava/lang/String;", "getValue", "JPEG", "JPG", "PNG", "WEBP", "expo-image-manipulator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImageFormat implements Enumerable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ImageFormat[] $VALUES;
    public static final ImageFormat JPEG = new ImageFormat("JPEG", 0, "jpeg");
    public static final ImageFormat JPG = new ImageFormat("JPG", 1, "jpg");
    public static final ImageFormat PNG = new ImageFormat("PNG", 2, "png");
    public static final ImageFormat WEBP = new ImageFormat("WEBP", 3, "webp");
    private final String value;

    /* compiled from: ImageManipulatorArguments.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageFormat.values().length];
            try {
                iArr[ImageFormat.JPEG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageFormat.JPG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ImageFormat.PNG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ImageFormat.WEBP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ ImageFormat[] $values() {
        return new ImageFormat[]{JPEG, JPG, PNG, WEBP};
    }

    public static EnumEntries<ImageFormat> getEntries() {
        return $ENTRIES;
    }

    public static ImageFormat valueOf(String str) {
        return (ImageFormat) Enum.valueOf(ImageFormat.class, str);
    }

    public static ImageFormat[] values() {
        return (ImageFormat[]) $VALUES.clone();
    }

    private ImageFormat(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        ImageFormat[] imageFormatArr$values = $values();
        $VALUES = imageFormatArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(imageFormatArr$values);
    }

    public final String getFileExtension() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1 || i == 2) {
            return ".jpg";
        }
        if (i == 3) {
            return ".png";
        }
        if (i == 4) {
            return ".webp";
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Bitmap.CompressFormat getCompressFormat() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1 || i == 2) {
            return Bitmap.CompressFormat.JPEG;
        }
        if (i == 3) {
            return Bitmap.CompressFormat.PNG;
        }
        if (i == 4) {
            return Bitmap.CompressFormat.WEBP;
        }
        throw new NoWhenBranchMatchedException();
    }
}
