package com.mrousavy.camera.core.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Size;
import com.mrousavy.camera.core.InvalidPathError;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/mrousavy/camera/core/utils/FileUtils;", "", "()V", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FileUtils {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: FileUtils.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"}, d2 = {"Lcom/mrousavy/camera/core/utils/FileUtils$Companion;", "", "()V", "getDirectory", "Ljava/io/File;", "path", "", "getImageSize", "Landroid/util/Size;", "imagePath", "writeBitmapTofile", "", "bitmap", "Landroid/graphics/Bitmap;", "file", "quality", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final File getDirectory(String path) throws InvalidPathError {
            if (path == null) {
                throw new InvalidPathError("null");
            }
            File file = new File(path);
            if (file.isDirectory()) {
                return file;
            }
            throw new InvalidPathError(path);
        }

        public final void writeBitmapTofile(Bitmap bitmap, File file, int quality) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            Intrinsics.checkNotNullParameter(file, "file");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, quality, fileOutputStream);
                CloseableKt.closeFinally(fileOutputStream, null);
            } finally {
            }
        }

        public final Size getImageSize(String imagePath) {
            Intrinsics.checkNotNullParameter(imagePath, "imagePath");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(imagePath, options);
            return new Size(options.outWidth, options.outHeight);
        }
    }
}
