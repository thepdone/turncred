package expo.modules.medialibrary.assets;

import android.content.Context;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.kotlin.Promise;
import expo.modules.medialibrary.MediaLibraryUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeleteAssets.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u000b\u001a\u00020\fR\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lexpo/modules/medialibrary/assets/DeleteAssets;", "", "context", "Landroid/content/Context;", "assetIds", "", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "(Landroid/content/Context;[Ljava/lang/String;Lexpo/modules/kotlin/Promise;)V", "[Ljava/lang/String;", "execute", "", "expo-media-library_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeleteAssets {
    private final String[] assetIds;
    private final Context context;
    private final Promise promise;

    public DeleteAssets(Context context, String[] assetIds, Promise promise) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetIds, "assetIds");
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.context = context;
        this.assetIds = assetIds;
        this.promise = promise;
    }

    public final void execute() {
        MediaLibraryUtils.INSTANCE.deleteAssets(this.context, "_id IN (" + ArraysKt.joinToString$default(this.assetIds, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + " )", null, this.promise);
    }
}
