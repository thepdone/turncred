package expo.modules.imagemanipulator;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileUtils.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/imagemanipulator/FileUtils;", "", "()V", "ensureDirExists", "Ljava/io/File;", "dir", "generateRandomOutputPath", "", "context", "Landroid/content/Context;", "imageFormat", "Lexpo/modules/imagemanipulator/ImageFormat;", "expo-image-manipulator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FileUtils {
    public static final FileUtils INSTANCE = new FileUtils();

    private FileUtils() {
    }

    public final String generateRandomOutputPath(Context context, ImageFormat imageFormat) throws ImageWriteFailedException, IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageFormat, "imageFormat");
        File file = new File(context.getCacheDir() + File.separator + "ImageManipulator");
        ensureDirExists(file);
        return file + File.separator + UUID.randomUUID() + imageFormat.getFileExtension();
    }

    private final File ensureDirExists(File dir) throws ImageWriteFailedException, IOException {
        if (dir.isDirectory() || dir.mkdirs()) {
            return dir;
        }
        String path = dir.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        throw new ImageWriteFailedException(path);
    }
}
