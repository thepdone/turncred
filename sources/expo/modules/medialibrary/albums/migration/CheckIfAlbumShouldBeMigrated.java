package expo.modules.medialibrary.albums.migration;

import android.content.Context;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.kotlin.Promise;
import expo.modules.medialibrary.AlbumNotFound;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CheckIfAlbumShouldBeMigrated.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lexpo/modules/medialibrary/albums/migration/CheckIfAlbumShouldBeMigrated;", "", "context", "Landroid/content/Context;", "albumId", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "(Landroid/content/Context;Ljava/lang/String;Lexpo/modules/kotlin/Promise;)V", "execute", "", "expo-media-library_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CheckIfAlbumShouldBeMigrated {
    private final String albumId;
    private final Context context;
    private final Promise promise;

    public CheckIfAlbumShouldBeMigrated(Context context, String albumId, Promise promise) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.context = context;
        this.albumId = albumId;
        this.promise = promise;
    }

    public final void execute() throws AlbumNotFound {
        if (CheckIfAlbumShouldBeMigratedKt.getAlbumDirectory(this.context, this.albumId) == null) {
            throw new AlbumNotFound();
        }
        this.promise.resolve(!r0.canWrite());
    }
}
