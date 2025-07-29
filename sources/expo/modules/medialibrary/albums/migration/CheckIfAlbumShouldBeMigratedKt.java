package expo.modules.medialibrary.albums.migration;

import android.content.Context;
import android.database.Cursor;
import expo.modules.medialibrary.MediaLibraryConstantsKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CheckIfAlbumShouldBeMigrated.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¨\u0006\u0006"}, d2 = {"getAlbumDirectory", "Ljava/io/File;", "context", "Landroid/content/Context;", "albumId", "", "expo-media-library_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CheckIfAlbumShouldBeMigratedKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final File getAlbumDirectory(Context context, String str) {
        Cursor cursorQuery = context.getContentResolver().query(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), new String[]{"_data"}, "media_type != 0 AND bucket_id=?", new String[]{str}, null);
        try {
            Cursor cursor = cursorQuery;
            if (cursor != null && cursor.moveToNext()) {
                File file = new File(cursor.getString(cursor.getColumnIndex("_data")));
                if (file.isFile()) {
                    String parent = file.getParent();
                    if (parent == null) {
                        CloseableKt.closeFinally(cursorQuery, null);
                        return null;
                    }
                    Intrinsics.checkNotNull(parent);
                    File file2 = new File(parent);
                    CloseableKt.closeFinally(cursorQuery, null);
                    return file2;
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(cursorQuery, null);
            return null;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursorQuery, th);
                throw th2;
            }
        }
    }
}
