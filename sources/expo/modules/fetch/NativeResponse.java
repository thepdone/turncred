package expo.modules.fetch;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.facebook.internal.NativeProtocol;
import com.nimbusds.jose.jwk.JWKParameterNames;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.sharedobjects.SharedObject;
import io.sentry.protocol.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/* compiled from: NativeResponse.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\u0000\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020&H\u0016J\u0006\u0010+\u001a\u00020&J!\u0010,\u001a\u00020\t2\u0012\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0.\"\u00020\u001bH\u0002¢\u0006\u0002\u0010/J\u0018\u00100\u001a\u00020&2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\u0018\u00105\u001a\u00020&2\u0006\u00101\u001a\u0002022\u0006\u0010(\u001a\u00020)H\u0016J\u0006\u00106\u001a\u00020&J\u0010\u00107\u001a\u00020&2\u0006\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u0004\u0018\u00010;J(\u0010<\u001a\u00020&2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001b0>2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020&0#R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u000f\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000e2\u000e\u0010\f\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R&\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b8B@BX\u0082\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t0#j\u0002`$0\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lexpo/modules/fetch/NativeResponse;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "Lokhttp3/Callback;", "appContext", "Lexpo/modules/kotlin/AppContext;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lexpo/modules/kotlin/AppContext;Lkotlinx/coroutines/CoroutineScope;)V", "bodyUsed", "", "getBodyUsed", "()Z", "<set-?>", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "getError", "()Ljava/lang/Exception;", "Lexpo/modules/fetch/NativeResponseInit;", "responseInit", "getResponseInit", "()Lexpo/modules/fetch/NativeResponseInit;", "sink", "Lexpo/modules/fetch/ResponseSink;", "getSink", "()Lexpo/modules/fetch/ResponseSink;", "value", "Lexpo/modules/fetch/ResponseState;", "state", "getState", "()Lexpo/modules/fetch/ResponseState;", "setState", "(Lexpo/modules/fetch/ResponseState;)V", "stateChangeOnceListeners", "", "Lkotlin/Function1;", "Lexpo/modules/fetch/StateChangeListener;", "cancelStreaming", "", "createResponseInit", Response.TYPE, "Lokhttp3/Response;", "deallocate", "emitRequestCancelled", "isInvalidState", "validStates", "", "([Lexpo/modules/fetch/ResponseState;)Z", "onFailure", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", JWKParameterNames.RSA_EXPONENT, "Ljava/io/IOException;", "onResponse", "onStarted", "pumpResponseBodyStream", "stream", "Lokio/BufferedSource;", "startStreaming", "", "waitForStates", "states", "", "callback", "Companion", "expo_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NativeResponse extends SharedObject implements Callback {
    private static final String TAG = "NativeResponse";
    private final CoroutineScope coroutineScope;
    private Exception error;
    private NativeResponseInit responseInit;
    private final ResponseSink sink;
    private ResponseState state;
    private final List<Function1<ResponseState, Boolean>> stateChangeOnceListeners;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeResponse(AppContext appContext, CoroutineScope coroutineScope) {
        super(appContext);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.coroutineScope = coroutineScope;
        this.sink = new ResponseSink();
        this.state = ResponseState.INITIALIZED;
        this.stateChangeOnceListeners = new ArrayList();
    }

    public final ResponseSink getSink() {
        return this.sink;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ResponseState getState() {
        ResponseState responseState;
        synchronized (this) {
            responseState = this.state;
        }
        return responseState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setState(ResponseState responseState) {
        synchronized (this) {
            this.state = responseState;
            Unit unit = Unit.INSTANCE;
        }
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new NativeResponse$state$3(this, responseState, null), 3, null);
    }

    public final NativeResponseInit getResponseInit() {
        return this.responseInit;
    }

    public final Exception getError() {
        return this.error;
    }

    public final boolean getBodyUsed() {
        return this.sink.getBodyUsed();
    }

    @Override // expo.modules.kotlin.sharedobjects.SharedObject
    public void deallocate() {
        this.sink.finalize();
        super.deallocate();
    }

    public final void onStarted() {
        if (isInvalidState(ResponseState.INITIALIZED)) {
            return;
        }
        setState(ResponseState.STARTED);
    }

    public final byte[] startStreaming() {
        if (isInvalidState(ResponseState.RESPONSE_RECEIVED, ResponseState.BODY_COMPLETED)) {
            return null;
        }
        if (getState() == ResponseState.RESPONSE_RECEIVED) {
            setState(ResponseState.BODY_STREAMING_STARTED);
            emit("didReceiveResponseData", this.sink.finalize());
        } else if (getState() == ResponseState.BODY_COMPLETED) {
            return this.sink.finalize();
        }
        return null;
    }

    public final void cancelStreaming() {
        if (isInvalidState(ResponseState.BODY_STREAMING_STARTED)) {
            return;
        }
        setState(ResponseState.BODY_STREAMING_CANCELLED);
    }

    public final void emitRequestCancelled() {
        FetchRequestCancelledException fetchRequestCancelledException = new FetchRequestCancelledException();
        this.error = fetchRequestCancelledException;
        if (getState() == ResponseState.BODY_STREAMING_STARTED) {
            emit("didFailWithError", fetchRequestCancelledException);
        }
        setState(ResponseState.ERROR_RECEIVED);
    }

    public final void waitForStates(final List<? extends ResponseState> states, final Function1<? super ResponseState, Unit> callback) {
        Intrinsics.checkNotNullParameter(states, "states");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (states.contains(getState())) {
            callback.invoke(getState());
        } else {
            this.stateChangeOnceListeners.add(new Function1<ResponseState, Boolean>() { // from class: expo.modules.fetch.NativeResponse.waitForStates.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(ResponseState newState) {
                    Intrinsics.checkNotNullParameter(newState, "newState");
                    if (states.contains(newState)) {
                        callback.invoke(newState);
                        return true;
                    }
                    return false;
                }
            });
        }
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException e) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(e, "e");
        if (e.getMessage() == "Canceled" || isInvalidState(ResponseState.STARTED, ResponseState.RESPONSE_RECEIVED, ResponseState.BODY_STREAMING_STARTED, ResponseState.BODY_STREAMING_CANCELLED)) {
            return;
        }
        if (getState() == ResponseState.BODY_STREAMING_STARTED) {
            emit("didFailWithError", e);
        }
        this.error = e;
        setState(ResponseState.ERROR_RECEIVED);
        emit("readyForJSFinalization", new Object[0]);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, okhttp3.Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        this.responseInit = createResponseInit(response);
        setState(ResponseState.RESPONSE_RECEIVED);
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, Dispatchers.getIO(), null, new AnonymousClass1(response, this, null), 2, null);
    }

    /* compiled from: NativeResponse.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.fetch.NativeResponse$onResponse$1", f = "NativeResponse.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: expo.modules.fetch.NativeResponse$onResponse$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ okhttp3.Response $response;
        int label;
        final /* synthetic */ NativeResponse this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(okhttp3.Response response, NativeResponse nativeResponse, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$response = response;
            this.this$0 = nativeResponse;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$response, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            BufferedSource bodySource;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ResponseBody responseBodyBody = this.$response.body();
            if (responseBodyBody != null && (bodySource = responseBodyBody.getSource()) != null) {
                this.this$0.pumpResponseBodyStream(bodySource);
                this.$response.close();
                if (this.this$0.getState() == ResponseState.BODY_STREAMING_STARTED) {
                    this.this$0.emit(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETE_KEY, new Object[0]);
                }
                this.this$0.setState(ResponseState.BODY_COMPLETED);
                this.this$0.emit("readyForJSFinalization", new Object[0]);
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }

    private final boolean isInvalidState(ResponseState... validStates) {
        if (ArraysKt.contains(validStates, getState())) {
            return false;
        }
        Log.w(TAG, "Invalid state - currentState[" + getState().getIntValue() + "] validStates[" + ArraysKt.joinToString$default(validStates, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<ResponseState, CharSequence>() { // from class: expo.modules.fetch.NativeResponse$isInvalidState$validStatesString$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(ResponseState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return String.valueOf(it.getIntValue());
            }
        }, 30, (Object) null) + "]");
        return true;
    }

    private final NativeResponseInit createResponseInit(okhttp3.Response response) {
        int iCode = response.code();
        String strMessage = response.message();
        Headers headers = response.headers();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(headers, 10));
        for (Pair<? extends String, ? extends String> pair : headers) {
            arrayList.add(TuplesKt.to(pair.getFirst(), pair.getSecond()));
        }
        return new NativeResponseInit(arrayList, iCode, strMessage, response.request().url().getUrl(), response.isRedirect());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pumpResponseBodyStream(BufferedSource stream) {
        while (!stream.exhausted() && !isInvalidState(ResponseState.RESPONSE_RECEIVED, ResponseState.BODY_STREAMING_STARTED, ResponseState.BODY_STREAMING_CANCELLED)) {
            try {
                if (getState() == ResponseState.RESPONSE_RECEIVED) {
                    this.sink.appendBufferBody$expo_release(stream.getBuffer().readByteArray());
                } else if (getState() != ResponseState.BODY_STREAMING_STARTED) {
                    return;
                } else {
                    emit("didReceiveResponseData", stream.getBuffer().readByteArray());
                }
            } catch (IOException e) {
                this.error = e;
                if (getState() == ResponseState.BODY_STREAMING_STARTED) {
                    emit("didFailWithError", e);
                }
                setState(ResponseState.ERROR_RECEIVED);
                return;
            }
        }
    }
}
