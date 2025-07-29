package expo.modules.medialibrary.assets;

import android.content.Context;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.kotlin.Promise;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetAssetInfo.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lexpo/modules/medialibrary/assets/GetAssetInfo;", "", "context", "Landroid/content/Context;", "assetId", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "(Landroid/content/Context;Ljava/lang/String;Lexpo/modules/kotlin/Promise;)V", "execute", "", "expo-media-library_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetAssetInfo {
    private final String assetId;
    private final Context context;
    private final Promise promise;

    public GetAssetInfo(Context context, String assetId, Promise promise) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetId, "assetId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.context = context;
        this.assetId = assetId;
        this.promise = promise;
    }

    public final void execute() {
        AssetUtilsKt.queryAssetInfo(this.context, "_id=?", new String[]{this.assetId}, true, this.promise);
    }
}
