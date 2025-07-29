package com.facebook.react.runtime;

import com.facebook.jni.HybridData;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JSRuntimeFactory.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/react/runtime/JSRuntimeFactory;", "", "mHybridData", "Lcom/facebook/jni/HybridData;", "(Lcom/facebook/jni/HybridData;)V", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class JSRuntimeFactory {
    private static final Companion Companion = new Companion(null);
    private final HybridData mHybridData;

    /* compiled from: JSRuntimeFactory.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/facebook/react/runtime/JSRuntimeFactory$Companion;", "", "()V", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public JSRuntimeFactory(HybridData mHybridData) {
        Intrinsics.checkNotNullParameter(mHybridData, "mHybridData");
        this.mHybridData = mHybridData;
    }

    static {
        SoLoader.loadLibrary("rninstance");
    }
}
