package expo.modules.medialibrary.albums;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.contacts.Columns;
import expo.modules.kotlin.Promise;
import expo.modules.medialibrary.AlbumException;
import expo.modules.medialibrary.MediaLibraryConstantsKt;
import expo.modules.medialibrary.MediaLibraryUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AlbumUtils.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0006\"\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0007\u001a3\u0010\b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"getAssetsInAlbums", "", "", "context", "Landroid/content/Context;", "albumIds", "", "(Landroid/content/Context;[Ljava/lang/String;)Ljava/util/List;", "queryAlbum", "", "selection", "selectionArgs", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;Lexpo/modules/kotlin/Promise;)V", "expo-media-library_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AlbumUtilsKt {
    public static final void queryAlbum(Context context, String selection, String[] strArr, Promise promise) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(selection, "selection");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Cursor cursorQuery = context.getContentResolver().query(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), new String[]{"bucket_id", "bucket_display_name"}, selection, strArr, "bucket_display_name");
            try {
                Cursor cursor = cursorQuery;
                if (cursor == null) {
                    throw new AlbumException("Could not get album. Query is incorrect.");
                }
                if (!cursor.moveToNext()) {
                    promise.resolve((Object) null);
                    CloseableKt.closeFinally(cursorQuery, null);
                    return;
                }
                int columnIndex = cursor.getColumnIndex("bucket_id");
                int columnIndex2 = cursor.getColumnIndex("bucket_display_name");
                Bundle bundle = new Bundle();
                bundle.putString("id", cursor.getString(columnIndex));
                bundle.putString("title", cursor.getString(columnIndex2));
                bundle.putInt("assetCount", cursor.getCount());
                promise.resolve(bundle);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorQuery, null);
            } finally {
            }
        } catch (IllegalArgumentException e) {
            promise.reject(MediaLibraryConstantsKt.ERROR_UNABLE_TO_LOAD, "Could not get album.", e);
        } catch (SecurityException e2) {
            promise.reject(MediaLibraryConstantsKt.ERROR_UNABLE_TO_LOAD_PERMISSION, "Could not get albums: need READ_EXTERNAL_STORAGE permission.", e2);
        }
    }

    public static final List<String> getAssetsInAlbums(Context context, String... albumIds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(albumIds, "albumIds");
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = context.getContentResolver().query(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), new String[]{Columns.ID}, "bucket_id IN (" + MediaLibraryUtils.INSTANCE.queryPlaceholdersFor(albumIds) + " )", albumIds, null);
        try {
            Cursor cursor = cursorQuery;
            if (cursor == null) {
                CloseableKt.closeFinally(cursorQuery, null);
                return arrayList;
            }
            while (cursor.moveToNext()) {
                String string = cursor.getString(cursor.getColumnIndex(Columns.ID));
                Intrinsics.checkNotNull(string);
                arrayList.add(string);
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(cursorQuery, null);
            return arrayList;
        } finally {
        }
    }
}
