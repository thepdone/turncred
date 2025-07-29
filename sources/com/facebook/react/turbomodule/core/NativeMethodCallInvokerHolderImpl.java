package com.facebook.react.turbomodule.core;

import com.facebook.jni.HybridData;
import com.facebook.react.common.annotations.FrameworkAPI;
import com.facebook.react.internal.turbomodule.core.NativeModuleSoLoader;
import com.facebook.react.turbomodule.core.interfaces.NativeMethodCallInvokerHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NativeMethodCallInvokerHolderImpl.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/react/turbomodule/core/NativeMethodCallInvokerHolderImpl;", "Lcom/facebook/react/turbomodule/core/interfaces/NativeMethodCallInvokerHolder;", "mHybridData", "Lcom/facebook/jni/HybridData;", "(Lcom/facebook/jni/HybridData;)V", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@FrameworkAPI
/* loaded from: classes4.dex */
public final class NativeMethodCallInvokerHolderImpl implements NativeMethodCallInvokerHolder {
    private static final Companion Companion = new Companion(null);
    private final HybridData mHybridData;

    private NativeMethodCallInvokerHolderImpl(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    /* compiled from: NativeMethodCallInvokerHolderImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/facebook/react/turbomodule/core/NativeMethodCallInvokerHolderImpl$Companion;", "", "()V", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        NativeModuleSoLoader.INSTANCE.maybeLoadSoLibrary();
    }
}
