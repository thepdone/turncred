package expo.modules.camera.utils;

import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileSystemUtils.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\u001e\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t¨\u0006\f"}, d2 = {"Lexpo/modules/camera/utils/FileSystemUtils;", "", "()V", "ensureDirExists", "Ljava/io/File;", "dir", "generateOutputFile", "internalDirectory", "dirName", "", ShareConstants.MEDIA_EXTENSION, "generateOutputPath", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FileSystemUtils {
    public static final FileSystemUtils INSTANCE = new FileSystemUtils();

    private FileSystemUtils() {
    }

    public final File ensureDirExists(File dir) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        if (dir.isDirectory() || dir.mkdirs()) {
            return dir;
        }
        throw new IOException("Couldn't create directory '" + dir + "'");
    }

    public final String generateOutputPath(File internalDirectory, String dirName, String extension) throws IOException {
        Intrinsics.checkNotNullParameter(internalDirectory, "internalDirectory");
        Intrinsics.checkNotNullParameter(dirName, "dirName");
        Intrinsics.checkNotNullParameter(extension, "extension");
        File file = new File(internalDirectory.toString() + File.separator + dirName);
        ensureDirExists(file);
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return file.toString() + File.separator + string + extension;
    }

    public final File generateOutputFile(File internalDirectory, String dirName, String extension) throws IOException {
        Intrinsics.checkNotNullParameter(internalDirectory, "internalDirectory");
        Intrinsics.checkNotNullParameter(dirName, "dirName");
        Intrinsics.checkNotNullParameter(extension, "extension");
        File file = new File(internalDirectory.toString() + File.separator + dirName);
        ensureDirExists(file);
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return new File(file.toString() + File.separator + string + extension);
    }
}
