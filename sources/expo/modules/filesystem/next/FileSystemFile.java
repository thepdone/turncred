package expo.modules.filesystem.next;

import android.net.Uri;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import expo.modules.interfaces.filesystem.Permission;
import expo.modules.kotlin.typedarray.TypedArray;
import io.sentry.rrweb.RRWebVideoEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.HexExtensionsKt;
import kotlin.text.HexFormat;
import kotlin.text.StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: FileSystemFile.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0015\u001a\u00020\nJ\u0006\u0010\u0016\u001a\u00020\nJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\nJ\u0006\u0010\u001c\u001a\u00020\u001aJ\b\u0010\u001d\u001a\u00020\u001aH\u0016J\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\nR\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\n8F¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000e¨\u0006!"}, d2 = {"Lexpo/modules/filesystem/next/FileSystemFile;", "Lexpo/modules/filesystem/next/FileSystemPath;", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "exists", "", "getExists", "()Z", "md5", "", "getMd5$annotations", "()V", "getMd5", "()Ljava/lang/String;", RRWebVideoEvent.JsonKeys.SIZE, "", "getSize", "()Ljava/lang/Long;", "type", "getType", "asString", "base64", "bytes", "", "create", "", "text", "validatePath", "validateType", "write", "content", "Lexpo/modules/kotlin/typedarray/TypedArray;", "expo-file-system_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FileSystemFile extends FileSystemPath {
    public static /* synthetic */ void getMd5$annotations() {
    }

    public final void validatePath() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemFile(File file) {
        super(file);
        Intrinsics.checkNotNullParameter(file, "file");
    }

    @Override // expo.modules.filesystem.next.FileSystemPath
    public void validateType() throws InvalidTypeFileException {
        validatePermission(Permission.READ);
        if (getFile().exists() && getFile().isDirectory()) {
            throw new InvalidTypeFileException();
        }
    }

    public final boolean getExists() {
        validatePermission(Permission.READ);
        return getFile().isFile();
    }

    public final void create() throws InvalidTypeFileException, IOException {
        validateType();
        validatePermission(Permission.WRITE);
        getFile().createNewFile();
    }

    public final void write(String content) throws InvalidTypeFileException, IOException {
        Intrinsics.checkNotNullParameter(content, "content");
        validateType();
        validatePermission(Permission.WRITE);
        if (!getExists()) {
            create();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(getFile());
        try {
            byte[] bytes = content.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            fileOutputStream.write(bytes);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } finally {
        }
    }

    public final void write(TypedArray content) throws InvalidTypeFileException, IOException {
        Intrinsics.checkNotNullParameter(content, "content");
        validateType();
        validatePermission(Permission.WRITE);
        if (!getExists()) {
            create();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(getFile());
        try {
            fileOutputStream.getChannel().write(content.toDirectBuffer());
            CloseableKt.closeFinally(fileOutputStream, null);
        } finally {
        }
    }

    public final String asString() {
        String string = Uri.fromFile(getFile()).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return StringsKt.endsWith$default(string, "/", false, 2, (Object) null) ? StringsKt.dropLast(string, 1) : string;
    }

    public final String text() throws InvalidTypeFileException {
        validateType();
        validatePermission(Permission.READ);
        return FilesKt.readText$default(getFile(), null, 1, null);
    }

    public final String base64() throws InvalidTypeFileException {
        validateType();
        validatePermission(Permission.READ);
        String strEncodeToString = Base64.encodeToString(FilesKt.readBytes(getFile()), 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }

    public final byte[] bytes() throws InvalidTypeFileException {
        validateType();
        validatePermission(Permission.READ);
        return FilesKt.readBytes(getFile());
    }

    public final String getMd5() {
        validatePermission(Permission.READ);
        byte[] bArrDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(FilesKt.readBytes(getFile()));
        Intrinsics.checkNotNull(bArrDigest);
        return HexExtensionsKt.toHexString$default(bArrDigest, (HexFormat) null, 1, (Object) null);
    }

    public final Long getSize() {
        if (getFile().exists()) {
            return Long.valueOf(getFile().length());
        }
        return null;
    }

    public final String getType() {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(getFile().getPath());
        if (fileExtensionFromUrl == null) {
            return null;
        }
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String lowerCase = fileExtensionFromUrl.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return singleton.getMimeTypeFromExtension(lowerCase);
    }
}
