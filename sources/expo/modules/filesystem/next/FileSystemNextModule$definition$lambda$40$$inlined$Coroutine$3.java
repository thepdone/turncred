package expo.modules.filesystem.next;

import android.webkit.URLUtil;
import expo.modules.interfaces.filesystem.Permission;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: AsyncFunctionBuilder.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001*\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007H\u008a@¨\u0006\b"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "Lkotlinx/coroutines/CoroutineScope;", "<name for destructuring parameter 0>", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$5"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$$inlined$Coroutine$3", f = "FileSystemNextModule.kt", i = {0, 0, 0, 0, 0}, l = {275}, m = "invokeSuspend", n = {"to", "url", "client", "$this$await$iv", "$completion$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: classes5.dex */
public final class FileSystemNextModule$definition$lambda$40$$inlined$Coroutine$3 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    public FileSystemNextModule$definition$lambda$40$$inlined$Coroutine$3(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        FileSystemNextModule$definition$lambda$40$$inlined$Coroutine$3 fileSystemNextModule$definition$lambda$40$$inlined$Coroutine$3 = new FileSystemNextModule$definition$lambda$40$$inlined$Coroutine$3(continuation);
        fileSystemNextModule$definition$lambda$40$$inlined$Coroutine$3.L$0 = objArr;
        return fileSystemNextModule$definition$lambda$40$$inlined$Coroutine$3.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws UnableToDownloadException, MalformedURLException, DestinationAlreadyExistsException, InvalidPermissionException {
        URI uri;
        FileSystemPath fileSystemPath;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object[] objArr = (Object[]) this.L$0;
            Object obj2 = objArr[0];
            FileSystemNextModule$definition$lambda$40$$inlined$Coroutine$3 fileSystemNextModule$definition$lambda$40$$inlined$Coroutine$3 = this;
            FileSystemPath fileSystemPath2 = (FileSystemPath) objArr[1];
            URI uri2 = (URI) obj2;
            fileSystemPath2.validatePermission(Permission.WRITE);
            Request.Builder builder = new Request.Builder();
            URL url = uri2.toURL();
            Intrinsics.checkNotNullExpressionValue(url, "toURL(...)");
            Request requestBuild = builder.url(url).build();
            OkHttpClient okHttpClient = new OkHttpClient();
            this.L$0 = fileSystemPath2;
            this.L$1 = uri2;
            this.L$2 = okHttpClient;
            this.L$3 = requestBuild;
            this.L$4 = this;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(fileSystemNextModule$definition$lambda$40$$inlined$Coroutine$3), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            okHttpClient.newCall(requestBuild).enqueue(new Callback() { // from class: expo.modules.filesystem.next.FileSystemNextModule$definition$lambda$40$lambda$2$$inlined$await$1
                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    CancellableContinuation cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m5937constructorimpl(response));
                }

                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException e) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(e, "e");
                    if (cancellableContinuationImpl2.isCancelled()) {
                        return;
                    }
                    CancellableContinuation cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m5937constructorimpl(ResultKt.createFailure(e)));
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(fileSystemNextModule$definition$lambda$40$$inlined$Coroutine$3);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
            uri = uri2;
            fileSystemPath = fileSystemPath2;
            obj = result;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            uri = (URI) this.L$1;
            fileSystemPath = (FileSystemPath) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Response response = (Response) obj;
        if (!response.isSuccessful()) {
            throw new UnableToDownloadException("response has status: " + response.code());
        }
        File file = fileSystemPath instanceof FileSystemDirectory ? new File(fileSystemPath.getFile(), URLUtil.guessFileName(uri.toString(), response.headers().get("content-disposition"), response.headers().get("content-type"))) : fileSystemPath.getFile();
        if (file.exists()) {
            throw new DestinationAlreadyExistsException();
        }
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody == null) {
            throw new UnableToDownloadException("response body is null");
        }
        FileOutputStream fileOutputStreamByteStream = responseBodyBody.byteStream();
        try {
            InputStream inputStream = fileOutputStreamByteStream;
            fileOutputStreamByteStream = new FileOutputStream(file);
            try {
                ByteStreamsKt.copyTo$default(inputStream, fileOutputStreamByteStream, 0, 2, null);
                CloseableKt.closeFinally(fileOutputStreamByteStream, null);
                CloseableKt.closeFinally(fileOutputStreamByteStream, null);
                return file.getPath();
            } finally {
            }
        } finally {
        }
    }
}
