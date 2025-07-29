package expo.modules.kotlin.jni.decorators;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.NativeMap;
import expo.modules.kotlin.jni.Destructible;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JNIAsyncFunctionBody;
import expo.modules.kotlin.jni.JNIDeallocator;
import expo.modules.kotlin.jni.JNIFunctionBody;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JSDecoratorsBridgingObject.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0004J\t\u0010\n\u001a\u00020\u0006H\u0082 J<\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0086 ¢\u0006\u0002\u0010\u0016JR\u0010\u0017\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u001cH\u0086 ¢\u0006\u0002\u0010\u001dJ\u0011\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 H\u0086 J\u0019\u0010!\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u0000H\u0086 JV\u0010#\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u000f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\u0010&\u001a\u0004\u0018\u00010\u001c2\u0006\u0010'\u001a\u00020\u000f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\u0010)\u001a\u0004\u0018\u00010\u001cH\u0086 ¢\u0006\u0002\u0010*J<\u0010+\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u001cH\u0086 ¢\u0006\u0002\u0010,R\u0010\u0010\u0005\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lexpo/modules/kotlin/jni/decorators/JSDecoratorsBridgingObject;", "Lexpo/modules/kotlin/jni/Destructible;", "jniDeallocator", "Lexpo/modules/kotlin/jni/JNIDeallocator;", "(Lexpo/modules/kotlin/jni/JNIDeallocator;)V", "mHybridData", "Lcom/facebook/jni/HybridData;", "deallocate", "", "finalize", "initHybrid", "registerAsyncFunction", "name", "", "takesOwner", "", "enumerable", "desiredTypes", "", "Lexpo/modules/kotlin/jni/ExpectedType;", "body", "Lexpo/modules/kotlin/jni/JNIAsyncFunctionBody;", "(Ljava/lang/String;ZZ[Lexpo/modules/kotlin/jni/ExpectedType;Lexpo/modules/kotlin/jni/JNIAsyncFunctionBody;)V", "registerClass", "prototypeDecorator", "ownerClass", "Ljava/lang/Class;", "isSharedRef", "Lexpo/modules/kotlin/jni/JNIFunctionBody;", "(Ljava/lang/String;Lexpo/modules/kotlin/jni/decorators/JSDecoratorsBridgingObject;ZLjava/lang/Class;Z[Lexpo/modules/kotlin/jni/ExpectedType;Lexpo/modules/kotlin/jni/JNIFunctionBody;)V", "registerConstants", "constants", "Lcom/facebook/react/bridge/NativeMap;", "registerObject", "jsDecoratorsBridgingObject", "registerProperty", "getterTakesOwner", "getterExpectedType", "getter", "setterTakesOwner", "setterExpectedType", "setter", "(Ljava/lang/String;Z[Lexpo/modules/kotlin/jni/ExpectedType;Lexpo/modules/kotlin/jni/JNIFunctionBody;Z[Lexpo/modules/kotlin/jni/ExpectedType;Lexpo/modules/kotlin/jni/JNIFunctionBody;)V", "registerSyncFunction", "(Ljava/lang/String;ZZ[Lexpo/modules/kotlin/jni/ExpectedType;Lexpo/modules/kotlin/jni/JNIFunctionBody;)V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JSDecoratorsBridgingObject implements Destructible {
    public static final int $stable = 8;
    private final HybridData mHybridData;

    private final native HybridData initHybrid();

    public final native void registerAsyncFunction(String name, boolean takesOwner, boolean enumerable, ExpectedType[] desiredTypes, JNIAsyncFunctionBody body);

    public final native void registerClass(String name, JSDecoratorsBridgingObject prototypeDecorator, boolean takesOwner, Class<?> ownerClass, boolean isSharedRef, ExpectedType[] desiredTypes, JNIFunctionBody body);

    public final native void registerConstants(NativeMap constants);

    public final native void registerObject(String name, JSDecoratorsBridgingObject jsDecoratorsBridgingObject);

    public final native void registerProperty(String name, boolean getterTakesOwner, ExpectedType[] getterExpectedType, JNIFunctionBody getter, boolean setterTakesOwner, ExpectedType[] setterExpectedType, JNIFunctionBody setter);

    public final native void registerSyncFunction(String name, boolean takesOwner, boolean enumerable, ExpectedType[] desiredTypes, JNIFunctionBody body);

    public JSDecoratorsBridgingObject(JNIDeallocator jniDeallocator) {
        Intrinsics.checkNotNullParameter(jniDeallocator, "jniDeallocator");
        this.mHybridData = initHybrid();
        jniDeallocator.addReference(this);
    }

    @Override // expo.modules.kotlin.jni.Destructible
    public void deallocate() {
        this.mHybridData.resetNative();
    }

    protected final void finalize() throws Throwable {
        deallocate();
    }
}
