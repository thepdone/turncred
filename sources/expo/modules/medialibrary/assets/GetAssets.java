package expo.modules.medialibrary.assets;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.kotlin.Promise;
import expo.modules.medialibrary.AssetQueryException;
import expo.modules.medialibrary.AssetsOptions;
import expo.modules.medialibrary.MediaLibraryConstantsKt;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetAssets.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lexpo/modules/medialibrary/assets/GetAssets;", "", "context", "Landroid/content/Context;", "assetOptions", "Lexpo/modules/medialibrary/AssetsOptions;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "(Landroid/content/Context;Lexpo/modules/medialibrary/AssetsOptions;Lexpo/modules/kotlin/Promise;)V", "execute", "", "expo-media-library_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetAssets {
    private final AssetsOptions assetOptions;
    private final Context context;
    private final Promise promise;

    public GetAssets(Context context, AssetsOptions assetOptions, Promise promise) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetOptions, "assetOptions");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.context = context;
        this.assetOptions = assetOptions;
        this.promise = promise;
    }

    public final void execute() {
        ContentResolver contentResolver = this.context.getContentResolver();
        try {
            GetAssetsQuery queryFromOptions = GetAssetsQueryKt.getQueryFromOptions(this.assetOptions);
            String selection = queryFromOptions.getSelection();
            String order = queryFromOptions.getOrder();
            double limit = queryFromOptions.getLimit();
            int offset = queryFromOptions.getOffset();
            Cursor cursorQuery = contentResolver.query(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), MediaLibraryConstantsKt.getASSET_PROJECTION(), selection, null, order);
            try {
                Cursor cursor = cursorQuery;
                if (cursor == null) {
                    throw new AssetQueryException();
                }
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                Intrinsics.checkNotNull(contentResolver);
                AssetUtilsKt.putAssetsInfo(contentResolver, cursor, arrayList, (int) limit, offset, false);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("assets", arrayList);
                bundle.putBoolean("hasNextPage", !cursor.isAfterLast());
                bundle.putString("endCursor", String.valueOf(cursor.getPosition()));
                bundle.putInt("totalCount", cursor.getCount());
                this.promise.resolve(bundle);
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
        } catch (IOException e) {
            this.promise.reject(MediaLibraryConstantsKt.ERROR_UNABLE_TO_LOAD, "Could not read file", e);
        } catch (IllegalArgumentException e2) {
            Promise promise = this.promise;
            String message = e2.getMessage();
            if (message == null) {
                message = "Invalid MediaType";
            }
            promise.reject(MediaLibraryConstantsKt.ERROR_UNABLE_TO_LOAD, message, e2);
        } catch (SecurityException e3) {
            this.promise.reject(MediaLibraryConstantsKt.ERROR_UNABLE_TO_LOAD_PERMISSION, "Could not get asset: need READ_EXTERNAL_STORAGE permission.", e3);
        } catch (UnsupportedOperationException e4) {
            e4.printStackTrace();
            this.promise.reject(MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS, e4.getMessage(), e4);
        }
    }
}
