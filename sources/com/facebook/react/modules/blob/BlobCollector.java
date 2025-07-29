package com.facebook.react.modules.blob;

import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactContext;
import com.facebook.soloader.SoLoader;

/* loaded from: classes4.dex */
class BlobCollector {
    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeInstall(Object obj, long j);

    BlobCollector() {
    }

    static {
        SoLoader.loadLibrary("reactnativeblob");
    }

    static void install(final ReactContext reactContext, final BlobModule blobModule) {
        reactContext.runOnJSQueueThread(new Runnable() { // from class: com.facebook.react.modules.blob.BlobCollector.1
            @Override // java.lang.Runnable
            public void run() {
                JavaScriptContextHolder javaScriptContextHolder = reactContext.getJavaScriptContextHolder();
                if (javaScriptContextHolder == null || javaScriptContextHolder.get() == 0) {
                    return;
                }
                BlobCollector.nativeInstall(blobModule, javaScriptContextHolder.get());
            }
        });
    }
}
