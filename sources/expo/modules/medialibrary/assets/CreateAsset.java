package expo.modules.medialibrary.assets;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.share.internal.ShareConstants;
import expo.modules.kotlin.Promise;
import expo.modules.medialibrary.AssetException;
import expo.modules.medialibrary.AssetFileException;
import expo.modules.medialibrary.ContentEntryException;
import expo.modules.medialibrary.MediaLibraryConstantsKt;
import expo.modules.medialibrary.MediaLibraryUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CreateAsset.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0003J\n\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0003J\u0006\u0010\u0014\u001a\u00020\u0012J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u000eH\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lexpo/modules/medialibrary/assets/CreateAsset;", "", "context", "Landroid/content/Context;", ShareConstants.MEDIA_URI, "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "resolveWithAdditionalData", "", "(Landroid/content/Context;Ljava/lang/String;Lexpo/modules/kotlin/Promise;Z)V", "isFileExtensionPresent", "()Z", "mUri", "Landroid/net/Uri;", "createAssetFileLegacy", "Ljava/io/File;", "createAssetUsingContentResolver", "", "createContentResolverAssetEntry", "execute", "normalizeAssetUri", "writeFileContentsToAsset", "localFile", "assetUri", "expo-media-library_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CreateAsset {
    private final Context context;
    private final Uri mUri;
    private final Promise promise;
    private final boolean resolveWithAdditionalData;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CreateAsset(Context context, String uri, Promise promise) {
        this(context, uri, promise, false, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(promise, "promise");
    }

    public CreateAsset(Context context, String uri, Promise promise, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.context = context;
        this.promise = promise;
        this.resolveWithAdditionalData = z;
        this.mUri = normalizeAssetUri(uri);
    }

    public /* synthetic */ CreateAsset(Context context, String str, Promise promise, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, promise, (i & 8) != 0 ? true : z);
    }

    private final Uri normalizeAssetUri(String uri) {
        if (StringsKt.startsWith$default(uri, "/", false, 2, (Object) null)) {
            Uri uriFromFile = Uri.fromFile(new File(uri));
            Intrinsics.checkNotNull(uriFromFile);
            return uriFromFile;
        }
        Uri uri2 = Uri.parse(uri);
        Intrinsics.checkNotNull(uri2);
        return uri2;
    }

    private final boolean isFileExtensionPresent() {
        String lastPathSegment = this.mUri.getLastPathSegment();
        if (lastPathSegment != null) {
            return StringsKt.contains$default((CharSequence) lastPathSegment, (CharSequence) ".", false, 2, (Object) null);
        }
        return false;
    }

    private final Uri createContentResolverAssetEntry() {
        ContentResolver contentResolver = this.context.getContentResolver();
        MediaLibraryUtils mediaLibraryUtils = MediaLibraryUtils.INSTANCE;
        Intrinsics.checkNotNull(contentResolver);
        String mimeType = mediaLibraryUtils.getMimeType(contentResolver, this.mUri);
        String lastPathSegment = this.mUri.getLastPathSegment();
        String relativePathForAssetType = MediaLibraryUtils.INSTANCE.getRelativePathForAssetType(mimeType, true);
        Uri uriMimeTypeToExternalUri = MediaLibraryUtils.INSTANCE.mimeTypeToExternalUri(mimeType);
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", lastPathSegment);
        contentValues.put("mime_type", mimeType);
        contentValues.put("relative_path", relativePathForAssetType);
        contentValues.put("is_pending", (Integer) 1);
        return contentResolver.insert(uriMimeTypeToExternalUri, contentValues);
    }

    private final void writeFileContentsToAsset(File localFile, Uri assetUri) throws IOException {
        ContentResolver contentResolver = this.context.getContentResolver();
        FileChannel channel = new FileInputStream(localFile).getChannel();
        try {
            FileChannel fileChannel = channel;
            OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(assetUri);
            Intrinsics.checkNotNull(outputStreamOpenOutputStream, "null cannot be cast to non-null type java.io.FileOutputStream");
            channel = ((FileOutputStream) outputStreamOpenOutputStream).getChannel();
            try {
                if (fileChannel.transferTo(0L, fileChannel.size(), channel) != fileChannel.size()) {
                    contentResolver.delete(assetUri, null, null);
                    throw new IOException("Could not save file to " + assetUri + " Not enough space.");
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(channel, null);
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(channel, null);
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_pending", (Integer) 0);
                contentResolver.update(assetUri, contentValues, null, null);
            } finally {
            }
        } finally {
        }
    }

    private final void createAssetUsingContentResolver() throws IOException, ContentEntryException {
        Uri uriCreateContentResolverAssetEntry = createContentResolverAssetEntry();
        if (uriCreateContentResolverAssetEntry == null) {
            throw new ContentEntryException();
        }
        String path = this.mUri.getPath();
        Intrinsics.checkNotNull(path);
        writeFileContentsToAsset(new File(path), uriCreateContentResolverAssetEntry);
        if (this.resolveWithAdditionalData) {
            AssetUtilsKt.queryAssetInfo(this.context, "_id=?", new String[]{String.valueOf(ContentUris.parseId(uriCreateContentResolverAssetEntry))}, false, this.promise);
        } else {
            this.promise.resolve((Object) null);
        }
    }

    private final File createAssetFileLegacy() throws IOException, AssetFileException {
        String path = this.mUri.getPath();
        Intrinsics.checkNotNull(path);
        File file = new File(path);
        MediaLibraryUtils mediaLibraryUtils = MediaLibraryUtils.INSTANCE;
        MediaLibraryUtils mediaLibraryUtils2 = MediaLibraryUtils.INSTANCE;
        ContentResolver contentResolver = this.context.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        File envDirectoryForAssetType = mediaLibraryUtils.getEnvDirectoryForAssetType(mediaLibraryUtils2.getMimeType(contentResolver, this.mUri), true);
        if (envDirectoryForAssetType == null) {
            throw new AssetFileException("Could not guess file type.");
        }
        File fileSafeCopyFile = MediaLibraryUtils.INSTANCE.safeCopyFile(file, envDirectoryForAssetType);
        if (envDirectoryForAssetType.exists() && fileSafeCopyFile.isFile()) {
            return fileSafeCopyFile;
        }
        throw new AssetFileException("Could not create asset record. Related file does not exist.");
    }

    public final void execute() throws AssetFileException {
        if (!isFileExtensionPresent()) {
            throw new AssetFileException("Could not get the file's extension.");
        }
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                createAssetUsingContentResolver();
            } else {
                MediaScannerConnection.scanFile(this.context, new String[]{createAssetFileLegacy().getPath()}, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: expo.modules.medialibrary.assets.CreateAsset$$ExternalSyntheticLambda0
                    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                    public final void onScanCompleted(String str, Uri uri) throws AssetException {
                        CreateAsset.execute$lambda$6(this.f$0, str, uri);
                    }
                });
            }
        } catch (IOException e) {
            this.promise.reject(MediaLibraryConstantsKt.ERROR_IO_EXCEPTION, "Unable to copy file into external storage.", e);
        } catch (SecurityException e2) {
            this.promise.reject(MediaLibraryConstantsKt.ERROR_UNABLE_TO_LOAD_PERMISSION, "Could not get asset: need READ_EXTERNAL_STORAGE permission.", e2);
        } catch (Exception e3) {
            this.promise.reject(MediaLibraryConstantsKt.ERROR_UNABLE_TO_SAVE, "Could not create asset.", e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execute$lambda$6(CreateAsset this$0, String path, Uri uri) throws AssetException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(path, "path");
        if (uri == null) {
            throw new AssetException();
        }
        if (this$0.resolveWithAdditionalData) {
            AssetUtilsKt.queryAssetInfo(this$0.context, "_data=?", new String[]{path}, false, this$0.promise);
        } else {
            this$0.promise.resolve((Object) null);
        }
    }
}
