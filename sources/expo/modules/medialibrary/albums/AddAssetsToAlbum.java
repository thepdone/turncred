package expo.modules.medialibrary.albums;

import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.kotlin.Promise;
import expo.modules.medialibrary.AlbumException;
import expo.modules.medialibrary.MediaLibraryConstantsKt;
import expo.modules.medialibrary.MediaLibraryException;
import expo.modules.medialibrary.MediaLibraryUtils;
import expo.modules.medialibrary.PermissionsException;
import expo.modules.medialibrary.albums.AssetFileStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AddAssetsToAlbum.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010\u0014\u001a\u00020\u0015R\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lexpo/modules/medialibrary/albums/AddAssetsToAlbum;", "", "context", "Landroid/content/Context;", "assetIds", "", "", "albumId", "copyToAlbum", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;ZLexpo/modules/kotlin/Promise;)V", "album", "Ljava/io/File;", "getAlbum", "()Ljava/io/File;", "[Ljava/lang/String;", "strategy", "Lexpo/modules/medialibrary/albums/AssetFileStrategy;", "execute", "", "expo-media-library_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddAssetsToAlbum {
    private final String albumId;
    private final String[] assetIds;
    private final Context context;
    private final Promise promise;
    private final AssetFileStrategy strategy;

    public AddAssetsToAlbum(Context context, String[] assetIds, String albumId, boolean z, Promise promise) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetIds, "assetIds");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.context = context;
        this.assetIds = assetIds;
        this.albumId = albumId;
        this.promise = promise;
        AssetFileStrategy.Companion companion = AssetFileStrategy.INSTANCE;
        this.strategy = z ? companion.getCopyStrategy() : companion.getMoveStrategy();
    }

    private final File getAlbum() {
        Cursor cursorQuery = this.context.getContentResolver().query(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), new String[]{"_data"}, "bucket_id=?", new String[]{this.albumId}, null);
        try {
            Cursor cursor = cursorQuery;
            if (cursor == null) {
                throw new AlbumException("Could not get album. Query returns null.");
            }
            if (cursor.getCount() == 0) {
                throw new AlbumException("No album with id: " + this.albumId);
            }
            cursor.moveToNext();
            File file = new File(cursor.getString(cursor.getColumnIndex("_data")));
            if (!file.isFile() && !file.isDirectory()) {
                throw new MediaLibraryException();
            }
            String parent = file.getParent();
            Intrinsics.checkNotNull(parent);
            File file2 = new File(parent);
            CloseableKt.closeFinally(cursorQuery, null);
            return file2;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursorQuery, th);
                throw th2;
            }
        }
    }

    public final void execute() throws PermissionsException {
        MediaLibraryUtils mediaLibraryUtils = MediaLibraryUtils.INSTANCE;
        Context context = this.context;
        String[] strArr = this.assetIds;
        List<MediaLibraryUtils.AssetFile> assetsById = mediaLibraryUtils.getAssetsById(context, (String[]) Arrays.copyOf(strArr, strArr.length));
        if (Build.VERSION.SDK_INT >= 30 && !getAlbum().canWrite()) {
            throw new PermissionsException("The application doesn't have permission to write to the album's directory. For more information, check out https://expo.fyi/android-r.");
        }
        List<MediaLibraryUtils.AssetFile> list = assetsById;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.strategy.apply((MediaLibraryUtils.AssetFile) it.next(), getAlbum(), this.context).getPath());
        }
        ArrayList arrayList2 = arrayList;
        final AtomicInteger atomicInteger = new AtomicInteger(arrayList2.size());
        MediaScannerConnection.scanFile(this.context, (String[]) arrayList2.toArray(new String[0]), null, new MediaScannerConnection.OnScanCompletedListener() { // from class: expo.modules.medialibrary.albums.AddAssetsToAlbum$$ExternalSyntheticLambda0
            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public final void onScanCompleted(String str, Uri uri) {
                AddAssetsToAlbum.execute$lambda$2(atomicInteger, this, str, uri);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execute$lambda$2(AtomicInteger atomicInteger, AddAssetsToAlbum this$0, String str, Uri uri) {
        Intrinsics.checkNotNullParameter(atomicInteger, "$atomicInteger");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (atomicInteger.decrementAndGet() == 0) {
            this$0.promise.resolve(true);
        }
    }
}
