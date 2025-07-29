package com.facebook.react.modules.common;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModuleDataCleaner.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/react/modules/common/ModuleDataCleaner;", "", "()V", "cleanDataFromModules", "", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "Cleanable", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ModuleDataCleaner {
    public static final ModuleDataCleaner INSTANCE = new ModuleDataCleaner();

    /* compiled from: ModuleDataCleaner.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Lcom/facebook/react/modules/common/ModuleDataCleaner$Cleanable;", "", "clearSensitiveData", "", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Cleanable {
        void clearSensitiveData();
    }

    private ModuleDataCleaner() {
    }

    @JvmStatic
    public static final void cleanDataFromModules(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Collection<NativeModule> nativeModules = reactContext.getNativeModules();
        Intrinsics.checkNotNullExpressionValue(nativeModules, "getNativeModules(...)");
        for (NativeModule nativeModule : nativeModules) {
            if (nativeModule instanceof Cleanable) {
                FLog.d("ReactNative", "Cleaning data from " + nativeModule.getName());
                ((Cleanable) nativeModule).clearSensitiveData();
            }
        }
    }
}
