package expo.modules.kotlin.jni;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.jni.HybridData;
import expo.modules.kotlin.jni.decorators.JSDecoratorsBridgingObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JavaScriptModuleObject.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0011\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086 J\b\u0010\u0013\u001a\u00020\u000fH\u0004J\t\u0010\u0014\u001a\u00020\u000bH\u0082 J\b\u0010\u0015\u001a\u00020\u0005H\u0016R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0010\u0010\n\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "Lexpo/modules/kotlin/jni/Destructible;", "jniDeallocator", "Lexpo/modules/kotlin/jni/JNIDeallocator;", "name", "", "(Lexpo/modules/kotlin/jni/JNIDeallocator;Ljava/lang/String;)V", "isValid", "", "()Z", "mHybridData", "Lcom/facebook/jni/HybridData;", "getName", "()Ljava/lang/String;", "deallocate", "", "decorate", "decorator", "Lexpo/modules/kotlin/jni/decorators/JSDecoratorsBridgingObject;", "finalize", "initHybrid", InAppPurchaseConstants.METHOD_TO_STRING, "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JavaScriptModuleObject implements Destructible {
    public static final int $stable = 8;
    private final HybridData mHybridData;
    private final String name;

    private final native HybridData initHybrid();

    public final native void decorate(JSDecoratorsBridgingObject decorator);

    public JavaScriptModuleObject(JNIDeallocator jniDeallocator, String name) {
        Intrinsics.checkNotNullParameter(jniDeallocator, "jniDeallocator");
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.mHybridData = initHybrid();
        jniDeallocator.addReference(this);
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isValid() {
        return this.mHybridData.isValid();
    }

    protected final void finalize() throws Throwable {
        deallocate();
    }

    @Override // expo.modules.kotlin.jni.Destructible
    public void deallocate() {
        this.mHybridData.resetNative();
    }

    public String toString() {
        return "JavaScriptModuleObject_" + this.name;
    }
}
