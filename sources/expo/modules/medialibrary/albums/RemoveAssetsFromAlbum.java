package expo.modules.medialibrary.albums;

import android.content.Context;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.kotlin.Promise;
import expo.modules.medialibrary.MediaLibraryUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RemoveAssetsFromAlbum.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lexpo/modules/medialibrary/albums/RemoveAssetsFromAlbum;", "", "context", "Landroid/content/Context;", "assetIds", "", "", "albumId", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;Lexpo/modules/kotlin/Promise;)V", "[Ljava/lang/String;", "execute", "", "expo-media-library_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RemoveAssetsFromAlbum {
    private final String albumId;
    private final String[] assetIds;
    private final Context context;
    private final Promise promise;

    public RemoveAssetsFromAlbum(Context context, String[] assetIds, String albumId, Promise promise) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetIds, "assetIds");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.context = context;
        this.assetIds = assetIds;
        this.albumId = albumId;
        this.promise = promise;
    }

    public final void execute() {
        MediaLibraryUtils.INSTANCE.deleteAssets(this.context, "bucket_id=? AND _id IN (" + ArraysKt.joinToString$default(this.assetIds, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + " )", new String[]{this.albumId}, this.promise);
    }
}
