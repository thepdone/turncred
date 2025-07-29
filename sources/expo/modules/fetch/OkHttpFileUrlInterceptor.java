package expo.modules.fetch;

import android.content.Context;
import androidx.webkit.internal.AssetHelper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;

/* compiled from: OkHttpFileUrlInterceptor.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lexpo/modules/fetch/OkHttpFileUrlInterceptor;", "Lokhttp3/Interceptor;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "Ljava/lang/ref/WeakReference;", "createAssetResponseBody", "Lokhttp3/ResponseBody;", "fileName", "", "createFileNotFoundResponse", "Lokhttp3/Response;", "request", "Lokhttp3/Request;", "createMediaType", "Lokhttp3/MediaType;", "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "restoreFileUrl", "url", "Lokhttp3/HttpUrl;", "Companion", "expo_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OkHttpFileUrlInterceptor implements Interceptor {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final WeakReference<Context> context;

    public OkHttpFileUrlInterceptor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = new WeakReference<>(context);
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws FetchAndroidContextLostException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        String strRestoreFileUrl = restoreFileUrl(request.url());
        if (!StringsKt.startsWith$default(strRestoreFileUrl, "file://", false, 2, (Object) null)) {
            return chain.proceed(request);
        }
        if (StringsKt.startsWith$default(strRestoreFileUrl, "file:///android_asset/", false, 2, (Object) null)) {
            String strRemovePrefix = StringsKt.removePrefix(strRestoreFileUrl, (CharSequence) "file:///android_asset/");
            Context context = this.context.get();
            if (context == null) {
                throw new FetchAndroidContextLostException();
            }
            try {
                return new Response.Builder().request(request).protocol(Protocol.HTTP_1_1).code(200).message("OK").body(createAssetResponseBody(context, strRemovePrefix)).build();
            } catch (IOException unused) {
                return createFileNotFoundResponse(request);
            }
        }
        String strSubstring = strRestoreFileUrl.substring(7);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        File file = new File(strSubstring);
        if (!file.exists()) {
            return createFileNotFoundResponse(request);
        }
        ResponseBody.Companion companion = ResponseBody.INSTANCE;
        BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(file));
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return new Response.Builder().request(request).protocol(Protocol.HTTP_1_1).code(200).message("OK").body(companion.create(bufferedSourceBuffer, createMediaType(name), file.length())).build();
    }

    private final String restoreFileUrl(HttpUrl url) {
        return StringsKt.replaceFirst$default(url.getUrl(), "http://filesystem.local", "file://", false, 4, (Object) null);
    }

    private final Response createFileNotFoundResponse(Request request) {
        return new Response.Builder().request(request).protocol(Protocol.HTTP_1_1).code(404).message("File not found").body(ResponseBody.INSTANCE.create("File not found", MediaType.INSTANCE.get(AssetHelper.DEFAULT_MIME_TYPE))).build();
    }

    private final MediaType createMediaType(String fileName) {
        String strGuessContentTypeFromName = URLConnection.guessContentTypeFromName(fileName);
        if (strGuessContentTypeFromName == null) {
            strGuessContentTypeFromName = "application/octet-stream";
        }
        MediaType mediaType = MediaType.INSTANCE.parse(strGuessContentTypeFromName);
        return mediaType == null ? MediaType.INSTANCE.get("application/octet-stream") : mediaType;
    }

    public final ResponseBody createAssetResponseBody(Context context, String fileName) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        InputStream inputStreamOpen = context.getAssets().open(fileName);
        Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
        return ResponseBody.Companion.create$default(ResponseBody.INSTANCE, Okio.buffer(Okio.source(inputStreamOpen)), createMediaType(fileName), 0L, 2, null);
    }

    /* compiled from: OkHttpFileUrlInterceptor.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lexpo/modules/fetch/OkHttpFileUrlInterceptor$Companion;", "", "()V", "handleFileUrl", "Ljava/net/URL;", "url", "expo_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final URL handleFileUrl(URL url) {
            Intrinsics.checkNotNullParameter(url, "url");
            if (!Intrinsics.areEqual(url.getProtocol(), "file")) {
                return url;
            }
            return new URL("http://filesystem.local" + url.getPath());
        }
    }
}
