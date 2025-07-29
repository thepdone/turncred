package expo.modules.kotlin.jni.tests;

import com.facebook.jni.HybridData;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

/* compiled from: RuntimeHolder.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\t\u0010\t\u001a\u00020\nH\u0086 J\t\u0010\u000b\u001a\u00020\fH\u0086 J\b\u0010\r\u001a\u00020\bH\u0004J\t\u0010\u000e\u001a\u00020\u0004H\u0082 J\t\u0010\u000f\u001a\u00020\bH\u0082 R\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lexpo/modules/kotlin/jni/tests/RuntimeHolder;", "Ljava/lang/AutoCloseable;", "()V", "mHybridData", "Lcom/facebook/jni/HybridData;", "wasDeallocated", "Ljava/util/concurrent/atomic/AtomicBoolean;", "close", "", "createCallInvoker", "Lcom/facebook/react/turbomodule/core/CallInvokerHolderImpl;", "createRuntime", "", "finalize", "initHybrid", "release", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RuntimeHolder implements AutoCloseable {
    public static final int $stable = 8;
    private final HybridData mHybridData = initHybrid();
    private AtomicBoolean wasDeallocated = new AtomicBoolean(false);

    private final native HybridData initHybrid();

    private final native void release();

    public final native CallInvokerHolderImpl createCallInvoker();

    public final native long createRuntime();

    protected final void finalize() throws Throwable {
        close();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.wasDeallocated.compareAndSet(false, true)) {
            release();
            this.mHybridData.resetNative();
        }
    }
}
