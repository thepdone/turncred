package expo.modules.medialibrary.albums;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.kotlin.Promise;
import expo.modules.medialibrary.AlbumException;
import expo.modules.medialibrary.AssetFileException;
import expo.modules.medialibrary.MediaLibraryConstantsKt;
import expo.modules.medialibrary.MediaLibraryUtils;
import expo.modules.medialibrary.albums.AssetFileStrategy;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CreateAlbum.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lexpo/modules/medialibrary/albums/CreateAlbum;", "", "context", "Landroid/content/Context;", "albumName", "", "assetId", "copyAsset", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLexpo/modules/kotlin/Promise;)V", "mStrategy", "Lexpo/modules/medialibrary/albums/AssetFileStrategy;", "createAlbum", "Ljava/io/File;", "mimeType", "execute", "", "expo-media-library_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CreateAlbum {
    private final String albumName;
    private final String assetId;
    private final Context context;
    private final AssetFileStrategy mStrategy;
    private final Promise promise;

    public CreateAlbum(Context context, String albumName, String assetId, boolean z, Promise promise) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(albumName, "albumName");
        Intrinsics.checkNotNullParameter(assetId, "assetId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.context = context;
        this.albumName = albumName;
        this.assetId = assetId;
        this.promise = promise;
        AssetFileStrategy.Companion companion = AssetFileStrategy.INSTANCE;
        this.mStrategy = z ? companion.getCopyStrategy() : companion.getMoveStrategy();
    }

    private final File createAlbum(String mimeType) throws AlbumException, AssetFileException {
        File envDirectoryForAssetType = MediaLibraryUtils.INSTANCE.getEnvDirectoryForAssetType(mimeType, false);
        if (envDirectoryForAssetType == null) {
            throw new AssetFileException("Could not guess asset type.");
        }
        File file = new File(envDirectoryForAssetType.getPath(), this.albumName);
        if (!file.exists() && !file.mkdirs()) {
            file = null;
        }
        if (file != null) {
            return file;
        }
        throw new AlbumException("Could not create album directory.");
    }

    public final void execute() {
        try {
            MediaLibraryUtils.AssetFile assetFile = MediaLibraryUtils.INSTANCE.getAssetsById(this.context, this.assetId).get(0);
            MediaScannerConnection.scanFile(this.context, new String[]{this.mStrategy.apply(assetFile, createAlbum(assetFile.getMimeType()), this.context).getPath()}, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: expo.modules.medialibrary.albums.CreateAlbum$$ExternalSyntheticLambda0
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public final void onScanCompleted(String str, Uri uri) throws AlbumException {
                    CreateAlbum.execute$lambda$3(this.f$0, str, uri);
                }
            });
        } catch (IOException e) {
            this.promise.reject(MediaLibraryConstantsKt.ERROR_UNABLE_TO_LOAD, "Could not read file or parse EXIF tags", e);
        } catch (SecurityException e2) {
            this.promise.reject(MediaLibraryConstantsKt.ERROR_UNABLE_TO_LOAD_PERMISSION, "Could not create album: need WRITE_EXTERNAL_STORAGE permission.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execute$lambda$3(CreateAlbum this$0, String path, Uri uri) throws AlbumException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(path, "path");
        if (uri == null) {
            throw new AlbumException("Could not add image to album.");
        }
        AlbumUtilsKt.queryAlbum(this$0.context, "_data=?", new String[]{path}, this$0.promise);
    }
}
