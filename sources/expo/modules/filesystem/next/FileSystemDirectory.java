package expo.modules.filesystem.next;

import android.net.Uri;
import expo.modules.interfaces.filesystem.Permission;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FileSystemDirectory.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00100\u000f0\u000eJ\u0006\u0010\u0011\u001a\u00020\fJ\b\u0010\u0012\u001a\u00020\fH\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lexpo/modules/filesystem/next/FileSystemDirectory;", "Lexpo/modules/filesystem/next/FileSystemPath;", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "exists", "", "getExists", "()Z", "asString", "", "create", "", "listAsRecords", "", "", "", "validatePath", "validateType", "expo-file-system_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FileSystemDirectory extends FileSystemPath {
    public final void validatePath() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemDirectory(File file) {
        super(file);
        Intrinsics.checkNotNullParameter(file, "file");
    }

    @Override // expo.modules.filesystem.next.FileSystemPath
    public void validateType() throws InvalidTypeFolderException {
        if (getFile().exists() && !getFile().isDirectory()) {
            throw new InvalidTypeFolderException();
        }
    }

    public final boolean getExists() {
        validatePermission(Permission.READ);
        return getFile().isDirectory();
    }

    public final void create() throws InvalidTypeFolderException {
        validateType();
        validatePermission(Permission.WRITE);
        getFile().mkdir();
    }

    public final List<Map<String, Object>> listAsRecords() throws InvalidTypeFolderException {
        validateType();
        validatePermission(Permission.READ);
        File[] fileArrListFiles = getFile().listFiles();
        if (fileArrListFiles == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(fileArrListFiles.length);
        for (File file : fileArrListFiles) {
            arrayList.add(MapsKt.mapOf(TuplesKt.to("isDirectory", Boolean.valueOf(file.isDirectory())), TuplesKt.to("path", file.getPath())));
        }
        return arrayList;
    }

    public final String asString() {
        String string = Uri.fromFile(getFile()).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return StringsKt.endsWith$default(string, "/", false, 2, (Object) null) ? string : string + "/";
    }
}
