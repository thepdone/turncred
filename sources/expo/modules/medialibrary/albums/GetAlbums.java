package expo.modules.medialibrary.albums;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.kotlin.Promise;
import expo.modules.medialibrary.AlbumException;
import expo.modules.medialibrary.MediaLibraryConstantsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetAlbums.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\tB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lexpo/modules/medialibrary/albums/GetAlbums;", "", "context", "Landroid/content/Context;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "(Landroid/content/Context;Lexpo/modules/kotlin/Promise;)V", "execute", "", "Album", "expo-media-library_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class GetAlbums {
    private final Context context;
    private final Promise promise;

    public GetAlbums(Context context, Promise promise) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.context = context;
        this.promise = promise;
    }

    public final void execute() {
        String[] strArr = {"bucket_id", "bucket_display_name"};
        HashMap map = new HashMap();
        try {
            Cursor cursorQuery = this.context.getContentResolver().query(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), strArr, "media_type != 0", null, "bucket_display_name");
            try {
                Cursor cursor = cursorQuery;
                if (cursor == null) {
                    throw new AlbumException("Could not get albums. Query returns null");
                }
                int columnIndex = cursor.getColumnIndex("bucket_id");
                int columnIndex2 = cursor.getColumnIndex("bucket_display_name");
                while (cursor.moveToNext()) {
                    String string = cursor.getString(columnIndex);
                    if (cursor.getType(columnIndex2) != 0) {
                        Album album = (Album) map.get(string);
                        if (album == null) {
                            Intrinsics.checkNotNull(string);
                            String string2 = cursor.getString(columnIndex2);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                            album = new Album(string, string2, 0, 4, null);
                            map.put(string, album);
                        }
                        Intrinsics.checkNotNull(album);
                        album.setCount(album.getCount() + 1);
                    }
                }
                Promise promise = this.promise;
                Collection collectionValues = map.values();
                Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
                Collection collection = collectionValues;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Album) it.next()).toBundle());
                }
                promise.resolve((Collection<? extends Object>) arrayList);
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
            this.promise.reject(MediaLibraryConstantsKt.ERROR_UNABLE_TO_LOAD_PERMISSION, "Could not get albums: need READ_EXTERNAL_STORAGE permission.", e);
        } catch (RuntimeException e2) {
            this.promise.reject(MediaLibraryConstantsKt.ERROR_UNABLE_TO_LOAD, "Could not get albums.", e2);
        }
    }

    /* compiled from: GetAlbums.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lexpo/modules/medialibrary/albums/GetAlbums$Album;", "", "id", "", "title", "count", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getCount", "()I", "setCount", "(I)V", "toBundle", "Landroid/os/Bundle;", "expo-media-library_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Album {
        private int count;
        private final String id;
        private final String title;

        public Album(String id, String title, int i) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(title, "title");
            this.id = id;
            this.title = title;
            this.count = i;
        }

        public /* synthetic */ Album(String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i2 & 4) != 0 ? 0 : i);
        }

        public final int getCount() {
            return this.count;
        }

        public final void setCount(int i) {
            this.count = i;
        }

        public final Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putString("id", this.id);
            bundle.putString("title", this.title);
            bundle.putParcelable("type", null);
            bundle.putInt("assetCount", this.count);
            return bundle;
        }
    }
}
