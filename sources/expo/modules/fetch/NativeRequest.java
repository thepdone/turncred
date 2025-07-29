package expo.modules.fetch;

import com.facebook.react.uimanager.ViewProps;
import com.google.common.net.HttpHeaders;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.sharedobjects.SharedObject;
import io.sentry.protocol.Response;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/* compiled from: NativeRequest.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lexpo/modules/fetch/NativeRequest;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "appContext", "Lexpo/modules/kotlin/AppContext;", Response.TYPE, "Lexpo/modules/fetch/NativeResponse;", "(Lexpo/modules/kotlin/AppContext;Lexpo/modules/fetch/NativeResponse;)V", "requestHolder", "Lexpo/modules/fetch/RequestHolder;", "getResponse$expo_release", "()Lexpo/modules/fetch/NativeResponse;", "task", "Lokhttp3/Call;", "cancel", "", ViewProps.START, "client", "Lokhttp3/OkHttpClient;", "url", "Ljava/net/URL;", "requestInit", "Lexpo/modules/fetch/NativeRequestInit;", "requestBody", "", "expo_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NativeRequest extends SharedObject {
    private final RequestHolder requestHolder;
    private final NativeResponse response;
    private Call task;

    /* renamed from: getResponse$expo_release, reason: from getter */
    public final NativeResponse getResponse() {
        return this.response;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeRequest(AppContext appContext, NativeResponse response) {
        super(appContext);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(response, "response");
        this.response = response;
        this.requestHolder = new RequestHolder(null);
    }

    public final void start(OkHttpClient client, URL url, NativeRequestInit requestInit, byte[] requestBody) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(requestInit, "requestInit");
        if (requestInit.getCredentials() != NativeRequestCredentials.INCLUDE) {
            client = client.newBuilder().cookieJar(CookieJar.NO_COOKIES).build();
        }
        Headers headers = RequestUtilsKt.toHeaders(requestInit.getHeaders());
        String str = headers.get(HttpHeaders.CONTENT_TYPE);
        Request requestBuild = new Request.Builder().headers(headers).method(requestInit.getMethod(), requestBody != null ? RequestBody.Companion.create$default(RequestBody.INSTANCE, requestBody, str != null ? MediaType.INSTANCE.parse(str) : null, 0, 0, 6, (Object) null) : null).url(OkHttpFileUrlInterceptor.INSTANCE.handleFileUrl(url)).build();
        this.requestHolder.setRequest(requestBuild);
        Call callNewCall = client.newCall(requestBuild);
        this.task = callNewCall;
        if (callNewCall != null) {
            callNewCall.enqueue(this.response);
        }
        this.response.onStarted();
    }

    public final void cancel() {
        Call call = this.task;
        if (call == null) {
            return;
        }
        call.cancel();
        this.response.emitRequestCancelled();
    }
}
