package expo.modules.kotlin.devtools;

import androidx.collection.ArrayMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: OkHttpExtensions.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086H¢\u0006\u0002\u0010\u0005\u001a\u0016\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\t¨\u0006\n"}, d2 = {"await", "Lokhttp3/Response;", "Lokhttp3/Request;", "okHttpClient", "Lokhttp3/OkHttpClient;", "(Lokhttp3/Request;Lokhttp3/OkHttpClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSingleMap", "", "", "Lokhttp3/Headers;", "expo-modules-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OkHttpExtensionsKt {
    public static final Map<String, String> toSingleMap(Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        ArrayMap arrayMap = new ArrayMap();
        for (String str : headers.names()) {
            arrayMap.put(str, headers.get(str));
        }
        return arrayMap;
    }

    private static final Object await$$forInline(Request request, OkHttpClient okHttpClient, Continuation<? super Response> continuation) {
        InlineMarker.mark(0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        okHttpClient.newCall(request).enqueue(new OkHttpExtensionsKt$await$2$1(cancellableContinuationImpl));
        Unit unit = Unit.INSTANCE;
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return result;
    }

    public static final Object await(Request request, OkHttpClient okHttpClient, Continuation<? super Response> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        okHttpClient.newCall(request).enqueue(new OkHttpExtensionsKt$await$2$1(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
