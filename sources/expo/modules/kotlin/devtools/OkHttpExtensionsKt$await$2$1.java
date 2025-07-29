package expo.modules.kotlin.devtools;

import androidx.core.app.NotificationCompat;
import com.nimbusds.jose.jwk.JWKParameterNames;
import io.sentry.protocol.Response;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import okhttp3.Call;
import okhttp3.Callback;

/* compiled from: OkHttpExtensions.kt */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"expo/modules/kotlin/devtools/OkHttpExtensionsKt$await$2$1", "Lokhttp3/Callback;", "onFailure", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", JWKParameterNames.RSA_EXPONENT, "Ljava/io/IOException;", "onResponse", Response.TYPE, "Lokhttp3/Response;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 176)
/* loaded from: classes5.dex */
public final class OkHttpExtensionsKt$await$2$1 implements Callback {
    final /* synthetic */ CancellableContinuation<okhttp3.Response> $callback;

    /* JADX WARN: Multi-variable type inference failed */
    public OkHttpExtensionsKt$await$2$1(CancellableContinuation<? super okhttp3.Response> cancellableContinuation) {
        this.$callback = cancellableContinuation;
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, okhttp3.Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        CancellableContinuation<okhttp3.Response> cancellableContinuation = this.$callback;
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m5937constructorimpl(response));
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException e) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(e, "e");
        if (this.$callback.isCancelled()) {
            return;
        }
        CancellableContinuation<okhttp3.Response> cancellableContinuation = this.$callback;
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m5937constructorimpl(ResultKt.createFailure(e)));
    }
}
