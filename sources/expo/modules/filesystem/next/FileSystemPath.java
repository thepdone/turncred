package expo.modules.filesystem.next;

import expo.modules.interfaces.filesystem.Permission;
import expo.modules.kotlin.sharedobjects.SharedObject;
import java.io.File;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileSystemPath.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0000J\u0010\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u0003J\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0000J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0000J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\tH&R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0015"}, d2 = {"Lexpo/modules/filesystem/next/FileSystemPath;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "setFile", "copy", "", "to", "delete", "fileOrDirectory", "getMoveOrCopyPath", "destination", "move", "validatePermission", "", "permission", "Lexpo/modules/interfaces/filesystem/Permission;", "validateType", "expo-file-system_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class FileSystemPath extends SharedObject {
    private File file;

    public abstract void validateType();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemPath(File file) {
        super(null, 1, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(file, "file");
        this.file = file;
    }

    public final File getFile() {
        return this.file;
    }

    public final void setFile(File file) {
        Intrinsics.checkNotNullParameter(file, "<set-?>");
        this.file = file;
    }

    public static /* synthetic */ void delete$default(FileSystemPath fileSystemPath, File file, int i, Object obj) throws UnableToDeleteException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }
        if ((i & 1) != 0) {
            file = fileSystemPath.file;
        }
        fileSystemPath.delete(file);
    }

    public final void delete(File fileOrDirectory) throws UnableToDeleteException {
        File[] fileArrListFiles;
        Intrinsics.checkNotNullParameter(fileOrDirectory, "fileOrDirectory");
        if (!fileOrDirectory.exists()) {
            throw new UnableToDeleteException("path '" + fileOrDirectory.getPath() + "' does not exist");
        }
        if (fileOrDirectory.isDirectory() && (fileArrListFiles = fileOrDirectory.listFiles()) != null) {
            for (File file : fileArrListFiles) {
                if (file.isDirectory()) {
                    Intrinsics.checkNotNull(file);
                    delete(file);
                } else if (!file.delete()) {
                    throw new UnableToDeleteException("failed to delete '" + file.getPath() + "'");
                }
            }
        }
        if (!fileOrDirectory.delete()) {
            throw new UnableToDeleteException("failed to delete '" + fileOrDirectory.getPath() + "'");
        }
    }

    public final File getMoveOrCopyPath(FileSystemPath destination) throws DestinationDoesNotExistException, CopyOrMoveDirectoryToFileException {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (destination instanceof FileSystemDirectory) {
            if (this instanceof FileSystemFile) {
                if (!((FileSystemDirectory) destination).getExists()) {
                    throw new DestinationDoesNotExistException();
                }
                return new File(destination.file, this.file.getName());
            }
            if (((FileSystemDirectory) destination).getExists()) {
                return new File(destination.file, this.file.getName());
            }
            File parentFile = destination.file.getParentFile();
            if (parentFile == null || !parentFile.exists()) {
                throw new DestinationDoesNotExistException();
            }
            return destination.file;
        }
        if (!(this instanceof FileSystemFile)) {
            throw new CopyOrMoveDirectoryToFileException();
        }
        File parentFile2 = destination.file.getParentFile();
        if (parentFile2 == null || !parentFile2.exists()) {
            throw new DestinationDoesNotExistException();
        }
        return destination.file;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean validatePermission(expo.modules.interfaces.filesystem.Permission r4) throws expo.modules.filesystem.next.InvalidPermissionException {
        /*
            r3 = this;
            java.lang.String r0 = "permission"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            expo.modules.kotlin.AppContext r0 = r3.getAppContext()
            if (r0 == 0) goto L29
            expo.modules.interfaces.filesystem.FilePermissionModuleInterface r0 = r0.getFilePermission()
            if (r0 == 0) goto L29
            expo.modules.kotlin.AppContext r1 = r3.getAppContext()
            if (r1 == 0) goto L1c
            android.content.Context r1 = r1.getReactContext()
            goto L1d
        L1c:
            r1 = 0
        L1d:
            java.io.File r2 = r3.file
            java.lang.String r2 = r2.getPath()
            java.util.EnumSet r0 = r0.getPathPermissions(r1, r2)
            if (r0 != 0) goto L2f
        L29:
            java.lang.Class<expo.modules.interfaces.filesystem.Permission> r0 = expo.modules.interfaces.filesystem.Permission.class
            java.util.EnumSet r0 = java.util.EnumSet.noneOf(r0)
        L2f:
            boolean r0 = r0.contains(r4)
            if (r0 == 0) goto L37
            r4 = 1
            return r4
        L37:
            expo.modules.filesystem.next.InvalidPermissionException r0 = new expo.modules.filesystem.next.InvalidPermissionException
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.next.FileSystemPath.validatePermission(expo.modules.interfaces.filesystem.Permission):boolean");
    }

    public final void copy(FileSystemPath to) throws InvalidPermissionException {
        Intrinsics.checkNotNullParameter(to, "to");
        validateType();
        to.validateType();
        validatePermission(Permission.READ);
        to.validatePermission(Permission.WRITE);
        FilesKt.copyRecursively$default(this.file, getMoveOrCopyPath(to), false, null, 6, null);
    }

    public final void move(FileSystemPath to) throws DestinationDoesNotExistException, CopyOrMoveDirectoryToFileException, InvalidPermissionException {
        Intrinsics.checkNotNullParameter(to, "to");
        validateType();
        to.validateType();
        validatePermission(Permission.WRITE);
        to.validatePermission(Permission.WRITE);
        File moveOrCopyPath = getMoveOrCopyPath(to);
        Path path = this.file.toPath();
        Intrinsics.checkNotNullExpressionValue(path, "toPath(...)");
        Path path2 = moveOrCopyPath.toPath();
        Intrinsics.checkNotNullExpressionValue(path2, "toPath(...)");
        Intrinsics.checkNotNullExpressionValue(Files.move(path, path2, (CopyOption[]) Arrays.copyOf(new CopyOption[0], 0)), "move(...)");
        this.file = moveOrCopyPath;
    }
}
