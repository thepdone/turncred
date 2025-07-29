package expo.modules.medialibrary.albums.migration;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.kotlin.Promise;
import expo.modules.medialibrary.AlbumException;
import expo.modules.medialibrary.MediaLibraryUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MigrateAlbum.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lexpo/modules/medialibrary/albums/migration/MigrateAlbum;", "", "context", "Landroid/content/Context;", "assetFiles", "", "Lexpo/modules/medialibrary/MediaLibraryUtils$AssetFile;", "albumDirName", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Lexpo/modules/kotlin/Promise;)V", "execute", "", "expo-media-library_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MigrateAlbum {
    private final String albumDirName;
    private final List<MediaLibraryUtils.AssetFile> assetFiles;
    private final Context context;
    private final Promise promise;

    public MigrateAlbum(Context context, List<MediaLibraryUtils.AssetFile> assetFiles, String albumDirName, Promise promise) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetFiles, "assetFiles");
        Intrinsics.checkNotNullParameter(albumDirName, "albumDirName");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.context = context;
        this.assetFiles = assetFiles;
        this.albumDirName = albumDirName;
        this.promise = promise;
    }

    public final void execute() throws AlbumException {
        List<MediaLibraryUtils.AssetFile> list = this.assetFiles;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(MediaLibraryUtils.INSTANCE.getRelativePathForAssetType(((MediaLibraryUtils.AssetFile) it.next()).getMimeType(), false));
        }
        Set set = CollectionsKt.toSet(arrayList);
        if (set.size() > 1) {
            throw new AlbumException("The album contains incompatible file types.");
        }
        String str = set.iterator().next() + File.separator + this.albumDirName;
        ContentValues contentValues = new ContentValues();
        contentValues.put("relative_path", str);
        for (MediaLibraryUtils.AssetFile assetFile : this.assetFiles) {
            this.context.getContentResolver().update(ContentUris.withAppendedId(MediaLibraryUtils.INSTANCE.mimeTypeToExternalUri(assetFile.getMimeType()), Long.parseLong(assetFile.getAssetId())), contentValues, null);
        }
        this.promise.resolve((Object) null);
    }
}
