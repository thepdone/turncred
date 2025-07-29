package expo.modules.medialibrary.albums;

import android.content.Context;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.medialibrary.MediaLibraryUtils;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeleteAlbums.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lexpo/modules/medialibrary/albums/DeleteAlbums;", "", "context", "Landroid/content/Context;", "albumIds", "", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "(Landroid/content/Context;Ljava/util/List;Lexpo/modules/kotlin/Promise;)V", "mAlbumIds", "", "[Ljava/lang/String;", "execute", "", "expo-media-library_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeleteAlbums {
    private final Context context;
    private final String[] mAlbumIds;
    private final Promise promise;

    public DeleteAlbums(Context context, List<String> albumIds, Promise promise) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(albumIds, "albumIds");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.context = context;
        this.promise = promise;
        this.mAlbumIds = (String[]) albumIds.toArray(new String[0]);
    }

    public final void execute() {
        String str = "bucket_id IN (" + MediaLibraryUtils.INSTANCE.queryPlaceholdersFor(this.mAlbumIds) + ")";
        final String str2 = "bucket_id IN (" + MediaLibraryUtils.INSTANCE.queryPlaceholdersFor(this.mAlbumIds) + ")";
        final String[] strArr = this.mAlbumIds;
        MediaLibraryUtils.INSTANCE.deleteAssets(this.context, str, strArr, new Promise() { // from class: expo.modules.medialibrary.albums.DeleteAlbums$execute$promiseOverride$1
            @Override // expo.modules.kotlin.Promise
            public void reject(CodedException codedException) {
                Promise.DefaultImpls.reject(this, codedException);
            }

            @Override // expo.modules.kotlin.Promise
            public void resolve() {
                Promise.DefaultImpls.resolve(this);
            }

            @Override // expo.modules.kotlin.Promise
            public void resolve(double d) {
                Promise.DefaultImpls.resolve(this, d);
            }

            @Override // expo.modules.kotlin.Promise
            public void resolve(float f) {
                Promise.DefaultImpls.resolve((Promise) this, f);
            }

            @Override // expo.modules.kotlin.Promise
            public void resolve(int i) {
                Promise.DefaultImpls.resolve((Promise) this, i);
            }

            @Override // expo.modules.kotlin.Promise
            public void resolve(String str3) {
                Promise.DefaultImpls.resolve(this, str3);
            }

            @Override // expo.modules.kotlin.Promise
            public void resolve(Collection<? extends Object> collection) {
                Promise.DefaultImpls.resolve(this, collection);
            }

            @Override // expo.modules.kotlin.Promise
            public void resolve(Map<String, ? extends Object> map) {
                Promise.DefaultImpls.resolve(this, map);
            }

            @Override // expo.modules.kotlin.Promise
            public void resolve(boolean z) {
                Promise.DefaultImpls.resolve(this, z);
            }

            @Override // expo.modules.kotlin.Promise
            public void resolve(Object value) {
                MediaLibraryUtils.INSTANCE.deleteAssets(this.this$0.context, str2, strArr, this.this$0.promise);
            }

            @Override // expo.modules.kotlin.Promise
            public void reject(String code, String message, Throwable cause) {
                Intrinsics.checkNotNullParameter(code, "code");
                this.this$0.promise.reject(code, message, cause);
            }
        });
    }
}
