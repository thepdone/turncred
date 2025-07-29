package com.swmansion.reanimated;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public class AndroidUIScheduler {
    private final ReactApplicationContext mContext;
    private final AtomicBoolean mActive = new AtomicBoolean(true);
    private final Runnable mUIThreadRunnable = new Runnable() { // from class: com.swmansion.reanimated.AndroidUIScheduler$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$0();
        }
    };
    private final HybridData mHybridData = initHybrid();

    private native HybridData initHybrid();

    public native void triggerUI();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        if (this.mActive.get()) {
            triggerUI();
        }
    }

    public AndroidUIScheduler(ReactApplicationContext reactApplicationContext) {
        this.mContext = reactApplicationContext;
    }

    private void scheduleTriggerOnUI() {
        UiThreadUtil.runOnUiThread(new GuardedRunnable(this.mContext.getExceptionHandler()) { // from class: com.swmansion.reanimated.AndroidUIScheduler.1
            @Override // com.facebook.react.bridge.GuardedRunnable
            public void runGuarded() {
                AndroidUIScheduler.this.mUIThreadRunnable.run();
            }
        });
    }

    public void deactivate() {
        this.mActive.set(false);
    }
}
