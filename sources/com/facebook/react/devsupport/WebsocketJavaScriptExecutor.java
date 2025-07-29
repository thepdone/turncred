package com.facebook.react.devsupport;

import android.os.Handler;
import android.os.Looper;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.react.devsupport.JSDebuggerWebSocketClient;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class WebsocketJavaScriptExecutor implements JavaJSExecutor {
    private static final int CONNECT_RETRY_COUNT = 3;
    private static final long CONNECT_TIMEOUT_MS = 5000;
    private final HashMap<String, String> mInjectedObjects = new HashMap<>();
    private JSDebuggerWebSocketClient mWebSocketClient;

    public interface JSExecutorConnectCallback {
        void onFailure(Throwable th);

        void onSuccess();
    }

    public static class WebsocketExecutorTimeoutException extends Exception {
        public WebsocketExecutorTimeoutException(String str) {
            super(str);
        }
    }

    private static class JSExecutorCallbackFuture implements JSDebuggerWebSocketClient.JSDebuggerCallback {
        private Throwable mCause;
        private String mResponse;
        private final Semaphore mSemaphore;

        private JSExecutorCallbackFuture() {
            this.mSemaphore = new Semaphore(0);
        }

        @Override // com.facebook.react.devsupport.JSDebuggerWebSocketClient.JSDebuggerCallback
        public void onSuccess(String str) {
            this.mResponse = str;
            this.mSemaphore.release();
        }

        @Override // com.facebook.react.devsupport.JSDebuggerWebSocketClient.JSDebuggerCallback
        public void onFailure(Throwable th) {
            this.mCause = th;
            this.mSemaphore.release();
        }

        public String get() throws Throwable {
            this.mSemaphore.acquire();
            Throwable th = this.mCause;
            if (th != null) {
                throw th;
            }
            return this.mResponse;
        }
    }

    public void connect(final String str, final JSExecutorConnectCallback jSExecutorConnectCallback) {
        final AtomicInteger atomicInteger = new AtomicInteger(3);
        connectInternal(str, new JSExecutorConnectCallback() { // from class: com.facebook.react.devsupport.WebsocketJavaScriptExecutor.1
            @Override // com.facebook.react.devsupport.WebsocketJavaScriptExecutor.JSExecutorConnectCallback
            public void onSuccess() {
                jSExecutorConnectCallback.onSuccess();
            }

            @Override // com.facebook.react.devsupport.WebsocketJavaScriptExecutor.JSExecutorConnectCallback
            public void onFailure(Throwable th) {
                if (atomicInteger.decrementAndGet() <= 0) {
                    jSExecutorConnectCallback.onFailure(th);
                } else {
                    WebsocketJavaScriptExecutor.this.connectInternal(str, this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectInternal(String str, final JSExecutorConnectCallback jSExecutorConnectCallback) {
        final JSDebuggerWebSocketClient jSDebuggerWebSocketClient = new JSDebuggerWebSocketClient();
        final Handler handler = new Handler(Looper.getMainLooper());
        jSDebuggerWebSocketClient.connect(str, new JSDebuggerWebSocketClient.JSDebuggerCallback() { // from class: com.facebook.react.devsupport.WebsocketJavaScriptExecutor.2
            private boolean didSendResult = false;

            @Override // com.facebook.react.devsupport.JSDebuggerWebSocketClient.JSDebuggerCallback
            public void onSuccess(String str2) throws IOException {
                jSDebuggerWebSocketClient.prepareJSRuntime(new JSDebuggerWebSocketClient.JSDebuggerCallback() { // from class: com.facebook.react.devsupport.WebsocketJavaScriptExecutor.2.1
                    @Override // com.facebook.react.devsupport.JSDebuggerWebSocketClient.JSDebuggerCallback
                    public void onSuccess(String str3) {
                        handler.removeCallbacksAndMessages(null);
                        WebsocketJavaScriptExecutor.this.mWebSocketClient = jSDebuggerWebSocketClient;
                        if (AnonymousClass2.this.didSendResult) {
                            return;
                        }
                        jSExecutorConnectCallback.onSuccess();
                        AnonymousClass2.this.didSendResult = true;
                    }

                    @Override // com.facebook.react.devsupport.JSDebuggerWebSocketClient.JSDebuggerCallback
                    public void onFailure(Throwable th) {
                        handler.removeCallbacksAndMessages(null);
                        if (AnonymousClass2.this.didSendResult) {
                            return;
                        }
                        jSExecutorConnectCallback.onFailure(th);
                        AnonymousClass2.this.didSendResult = true;
                    }
                });
            }

            @Override // com.facebook.react.devsupport.JSDebuggerWebSocketClient.JSDebuggerCallback
            public void onFailure(Throwable th) {
                handler.removeCallbacksAndMessages(null);
                if (this.didSendResult) {
                    return;
                }
                jSExecutorConnectCallback.onFailure(th);
                this.didSendResult = true;
            }
        });
        handler.postDelayed(new Runnable() { // from class: com.facebook.react.devsupport.WebsocketJavaScriptExecutor.3
            @Override // java.lang.Runnable
            public void run() {
                jSDebuggerWebSocketClient.closeQuietly();
                jSExecutorConnectCallback.onFailure(new WebsocketExecutorTimeoutException("Timeout while connecting to remote debugger"));
            }
        }, 5000L);
    }

    @Override // com.facebook.react.bridge.JavaJSExecutor
    public void close() {
        JSDebuggerWebSocketClient jSDebuggerWebSocketClient = this.mWebSocketClient;
        if (jSDebuggerWebSocketClient != null) {
            jSDebuggerWebSocketClient.closeQuietly();
        }
    }

    @Override // com.facebook.react.bridge.JavaJSExecutor
    public void loadBundle(String str) throws JavaJSExecutor.ProxyExecutorException, IOException {
        JSExecutorCallbackFuture jSExecutorCallbackFuture = new JSExecutorCallbackFuture();
        ((JSDebuggerWebSocketClient) Assertions.assertNotNull(this.mWebSocketClient)).loadBundle(str, this.mInjectedObjects, jSExecutorCallbackFuture);
        try {
            jSExecutorCallbackFuture.get();
        } catch (Throwable th) {
            throw new JavaJSExecutor.ProxyExecutorException(th);
        }
    }

    @Override // com.facebook.react.bridge.JavaJSExecutor
    public String executeJSCall(String str, String str2) throws JavaJSExecutor.ProxyExecutorException, IOException {
        JSExecutorCallbackFuture jSExecutorCallbackFuture = new JSExecutorCallbackFuture();
        ((JSDebuggerWebSocketClient) Assertions.assertNotNull(this.mWebSocketClient)).executeJSCall(str, str2, jSExecutorCallbackFuture);
        try {
            return jSExecutorCallbackFuture.get();
        } catch (Throwable th) {
            throw new JavaJSExecutor.ProxyExecutorException(th);
        }
    }

    @Override // com.facebook.react.bridge.JavaJSExecutor
    public void setGlobalVariable(String str, String str2) {
        this.mInjectedObjects.put(str, str2);
    }
}
