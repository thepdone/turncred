package expo.modules.medialibrary;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.share.internal.ShareConstants;
import expo.modules.contacts.Columns;
import expo.modules.kotlin.Promise;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: MediaLibraryUtils.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u00010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J9\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\u0010\t\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ1\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\n\"\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0012J&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000fJ\u001a\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u001b2\u0006\u0010\u001c\u001a\u00020\bJ\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u001e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0014J\u0012\u0010#\u001a\u0004\u0018\u00010\b2\u0006\u0010$\u001a\u00020\bH\u0002J\u0018\u0010%\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010&\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\bJ\u0010\u0010(\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\bJ\u001d\u0010)\u001a\u00020\b2\u0010\u0010*\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\n¢\u0006\u0002\u0010+J\u0016\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u0016J\u0016\u0010/\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u0016¨\u00061"}, d2 = {"Lexpo/modules/medialibrary/MediaLibraryUtils;", "", "()V", "deleteAssets", "", "context", "Landroid/content/Context;", "selection", "", "selectionArgs", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;Lexpo/modules/kotlin/Promise;)V", "getAssetsById", "", "Lexpo/modules/medialibrary/MediaLibraryUtils$AssetFile;", "assetsId", "(Landroid/content/Context;[Ljava/lang/String;)Ljava/util/List;", "getAssetsUris", "Landroid/net/Uri;", "getEnvDirectoryForAssetType", "Ljava/io/File;", "mimeType", "useCameraDir", "", "getFileNameAndExtension", "Lkotlin/Pair;", "name", "getManifestPermissions", "", "getMimeType", "contentResolver", "Landroid/content/ContentResolver;", ShareConstants.MEDIA_URI, "getMimeTypeFromFileUrl", "url", "getRelativePathForAssetType", "hasManifestPermission", "permission", "mimeTypeToExternalUri", "queryPlaceholdersFor", "assetIds", "([Ljava/lang/String;)Ljava/lang/String;", "safeCopyFile", "src", "destDir", "safeMoveFile", "AssetFile", "expo-media-library_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MediaLibraryUtils {
    public static final MediaLibraryUtils INSTANCE = new MediaLibraryUtils();

    /* compiled from: MediaLibraryUtils.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lexpo/modules/medialibrary/MediaLibraryUtils$AssetFile;", "Ljava/io/File;", "pathname", "", "assetId", "mimeType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAssetId", "()Ljava/lang/String;", "getMimeType", "expo-media-library_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AssetFile extends File {
        private final String assetId;
        private final String mimeType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AssetFile(String pathname, String assetId, String mimeType) {
            super(pathname);
            Intrinsics.checkNotNullParameter(pathname, "pathname");
            Intrinsics.checkNotNullParameter(assetId, "assetId");
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            this.assetId = assetId;
            this.mimeType = mimeType;
        }

        public final String getAssetId() {
            return this.assetId;
        }

        public final String getMimeType() {
            return this.mimeType;
        }
    }

    private MediaLibraryUtils() {
    }

    public final Pair<String, String> getFileNameAndExtension(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer numValueOf = Integer.valueOf(StringsKt.lastIndexOf$default((CharSequence) name, ".", 0, false, 6, (Object) null));
        if (numValueOf.intValue() == -1) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : name.length();
        String strSubstring = name.substring(iIntValue);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String strSubstring2 = name.substring(0, iIntValue);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        return new Pair<>(strSubstring2, strSubstring);
    }

    public final File safeMoveFile(File src, File destDir) throws IOException {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(destDir, "destDir");
        File fileSafeCopyFile = safeCopyFile(src, destDir);
        src.delete();
        return fileSafeCopyFile;
    }

    public final File safeCopyFile(File src, File destDir) throws IOException {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(destDir, "destDir");
        File file = new File(destDir, src.getName());
        String name = src.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Pair<String, String> fileNameAndExtension = getFileNameAndExtension(name);
        String strComponent1 = fileNameAndExtension.component1();
        String strComponent2 = fileNameAndExtension.component2();
        int i = 0;
        while (file.exists()) {
            file = new File(destDir, strComponent1 + "_" + i + strComponent2);
            i++;
            if (i > 32767) {
                throw new IOException("File name suffix limit reached (32767)");
            }
        }
        FileChannel channel = new FileInputStream(src).getChannel();
        try {
            FileChannel fileChannel = channel;
            channel = new FileOutputStream(file).getChannel();
            try {
                if (fileChannel.transferTo(0L, fileChannel.size(), channel) != fileChannel.size()) {
                    file.delete();
                    throw new IOException("Could not save file to " + destDir + " Not enough space.");
                }
                CloseableKt.closeFinally(channel, null);
                CloseableKt.closeFinally(channel, null);
                return file;
            } finally {
            }
        } finally {
        }
    }

    public final void deleteAssets(Context context, String selection, String[] selectionArgs, Promise promise) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Cursor cursorQuery = context.getContentResolver().query(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), new String[]{Columns.ID, "_data"}, selection, selectionArgs, null);
            try {
                Cursor cursor = cursorQuery;
                if (cursor == null) {
                    throw new AssetFileException("Could not delete assets. Cursor is null.");
                }
                while (cursor.moveToNext()) {
                    if (Build.VERSION.SDK_INT >= 30) {
                        Uri uriWithAppendedId = ContentUris.withAppendedId(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), cursor.getLong(cursor.getColumnIndex(Columns.ID)));
                        Intrinsics.checkNotNullExpressionValue(uriWithAppendedId, "withAppendedId(...)");
                        if (context.getContentResolver().delete(uriWithAppendedId, null) == 0) {
                            throw new AssetFileException("Could not delete file.");
                        }
                    } else {
                        String string = cursor.getString(cursor.getColumnIndex("_data"));
                        if (new File(string).delete()) {
                            context.getContentResolver().delete(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), "_data=?", new String[]{string});
                        } else {
                            throw new AssetFileException("Could not delete file.");
                        }
                    }
                }
                promise.resolve(true);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorQuery, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursorQuery, th);
                    throw th2;
                }
            }
        } catch (SecurityException e) {
            promise.reject(MediaLibraryConstantsKt.ERROR_UNABLE_TO_SAVE_PERMISSION, "Could not delete asset: need WRITE_EXTERNAL_STORAGE permission.", e);
        } catch (Exception e2) {
            e2.printStackTrace();
            promise.reject(MediaLibraryConstantsKt.ERROR_UNABLE_TO_DELETE, "Could not delete file.", e2);
        }
    }

    public final String queryPlaceholdersFor(String[] assetIds) {
        Intrinsics.checkNotNullParameter(assetIds, "assetIds");
        String[] strArr = new String[assetIds.length];
        ArraysKt.fill$default(strArr, "?", 0, 0, 6, (Object) null);
        return ArraysKt.joinToString$default(strArr, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public final List<AssetFile> getAssetsById(Context context, String... assetsId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetsId, "assetsId");
        Cursor cursorQuery = context.getContentResolver().query(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), new String[]{Columns.ID, "_data", "bucket_id", "mime_type"}, "_id IN ( " + queryPlaceholdersFor(assetsId) + " )", assetsId, null);
        try {
            Cursor cursor = cursorQuery;
            if (cursor == null) {
                throw new AssetFileException("Could not get assets. Query returns null.");
            }
            if (cursor.getCount() != assetsId.length) {
                throw new AssetFileException("Could not get all of the requested assets");
            }
            ArrayList arrayList = new ArrayList();
            while (cursor.moveToNext()) {
                String string = cursor.getString(cursor.getColumnIndex("_data"));
                int columnIndex = cursor.getColumnIndex(Columns.ID);
                int columnIndex2 = cursor.getColumnIndex("mime_type");
                Intrinsics.checkNotNull(string);
                String string2 = cursor.getString(columnIndex);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                String string3 = cursor.getString(columnIndex2);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                AssetFile assetFile = new AssetFile(string, string2, string3);
                if (!assetFile.exists() || !assetFile.isFile()) {
                    throw new AssetFileException("Path " + string + " does not exist or isn't file.");
                }
                arrayList.add(assetFile);
            }
            CloseableKt.closeFinally(cursorQuery, null);
            return arrayList;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursorQuery, th);
                throw th2;
            }
        }
    }

    private final String getMimeTypeFromFileUrl(String url) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(url);
        if (fileExtensionFromUrl == null) {
            return null;
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    public final String getMimeType(ContentResolver contentResolver, Uri uri) {
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(uri, "uri");
        String type = contentResolver.getType(uri);
        if (type != null) {
            return type;
        }
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return getMimeTypeFromFileUrl(string);
    }

    public final List<Uri> getAssetsUris(Context context, List<String> assetsId) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNull(assetsId);
        Cursor cursorQuery = context.getContentResolver().query(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), new String[]{Columns.ID, "mime_type"}, "_id IN (" + TextUtils.join(",", assetsId) + " )", null, null);
        if (cursorQuery != null) {
            Cursor cursor = cursorQuery;
            try {
                Cursor cursor2 = cursor;
                while (cursor2.moveToNext()) {
                    Uri uriWithAppendedId = ContentUris.withAppendedId(INSTANCE.mimeTypeToExternalUri(cursor2.getString(cursor2.getColumnIndex("mime_type"))), cursor2.getLong(cursor2.getColumnIndex(Columns.ID)));
                    Intrinsics.checkNotNullExpressionValue(uriWithAppendedId, "withAppendedId(...)");
                    arrayList.add(uriWithAppendedId);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor, null);
            } finally {
            }
        }
        return arrayList;
    }

    public final Uri mimeTypeToExternalUri(String mimeType) {
        if (mimeType == null) {
            Uri EXTERNAL_CONTENT_URI = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            Intrinsics.checkNotNullExpressionValue(EXTERNAL_CONTENT_URI, "EXTERNAL_CONTENT_URI");
            return EXTERNAL_CONTENT_URI;
        }
        String str = mimeType;
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "image", false, 2, (Object) null)) {
            Uri EXTERNAL_CONTENT_URI2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            Intrinsics.checkNotNullExpressionValue(EXTERNAL_CONTENT_URI2, "EXTERNAL_CONTENT_URI");
            return EXTERNAL_CONTENT_URI2;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "video", false, 2, (Object) null)) {
            Uri EXTERNAL_CONTENT_URI3 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            Intrinsics.checkNotNullExpressionValue(EXTERNAL_CONTENT_URI3, "EXTERNAL_CONTENT_URI");
            return EXTERNAL_CONTENT_URI3;
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "audio", false, 2, (Object) null)) {
            Uri EXTERNAL_CONTENT_URI4 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            Intrinsics.checkNotNullExpressionValue(EXTERNAL_CONTENT_URI4, "EXTERNAL_CONTENT_URI");
            return EXTERNAL_CONTENT_URI4;
        }
        return MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI();
    }

    public final String getRelativePathForAssetType(String mimeType, boolean useCameraDir) {
        if ((mimeType != null && StringsKt.contains$default((CharSequence) mimeType, (CharSequence) "image", false, 2, (Object) null)) || (mimeType != null && StringsKt.contains$default((CharSequence) mimeType, (CharSequence) "video", false, 2, (Object) null))) {
            if (useCameraDir) {
                String DIRECTORY_DCIM = Environment.DIRECTORY_DCIM;
                Intrinsics.checkNotNullExpressionValue(DIRECTORY_DCIM, "DIRECTORY_DCIM");
                return DIRECTORY_DCIM;
            }
            String DIRECTORY_PICTURES = Environment.DIRECTORY_PICTURES;
            Intrinsics.checkNotNullExpressionValue(DIRECTORY_PICTURES, "DIRECTORY_PICTURES");
            return DIRECTORY_PICTURES;
        }
        if (mimeType != null && StringsKt.contains$default((CharSequence) mimeType, (CharSequence) "audio", false, 2, (Object) null)) {
            String DIRECTORY_MUSIC = Environment.DIRECTORY_MUSIC;
            Intrinsics.checkNotNullExpressionValue(DIRECTORY_MUSIC, "DIRECTORY_MUSIC");
            return DIRECTORY_MUSIC;
        }
        if (useCameraDir) {
            String DIRECTORY_DCIM2 = Environment.DIRECTORY_DCIM;
            Intrinsics.checkNotNullExpressionValue(DIRECTORY_DCIM2, "DIRECTORY_DCIM");
            return DIRECTORY_DCIM2;
        }
        String DIRECTORY_PICTURES2 = Environment.DIRECTORY_PICTURES;
        Intrinsics.checkNotNullExpressionValue(DIRECTORY_PICTURES2, "DIRECTORY_PICTURES");
        return DIRECTORY_PICTURES2;
    }

    @Deprecated(message = "It uses deprecated Android method under the hood. See implementation for details.")
    public final File getEnvDirectoryForAssetType(String mimeType, boolean useCameraDir) {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(getRelativePathForAssetType(mimeType, useCameraDir));
        Intrinsics.checkNotNullExpressionValue(externalStoragePublicDirectory, "getExternalStoragePublicDirectory(...)");
        return externalStoragePublicDirectory;
    }

    private final Set<String> getManifestPermissions(Context context) {
        Set<String> set;
        PackageManager packageManager = context.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
        try {
            String[] strArr = packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            return (strArr == null || (set = ArraysKt.toSet(strArr)) == null) ? SetsKt.emptySet() : set;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("expo-media-library", "Failed to list AndroidManifest.xml permissions");
            e.printStackTrace();
            return SetsKt.emptySet();
        }
    }

    public final boolean hasManifestPermission(Context context, String permission) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permission, "permission");
        return getManifestPermissions(context).contains(permission);
    }
}
