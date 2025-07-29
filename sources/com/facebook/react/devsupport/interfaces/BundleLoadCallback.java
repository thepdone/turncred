package com.facebook.react.devsupport.interfaces;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BundleLoadCallback.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/devsupport/interfaces/BundleLoadCallback;", "", "onError", "", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface BundleLoadCallback {
    default void onError(Exception cause) {
        Intrinsics.checkNotNullParameter(cause, "cause");
    }

    void onSuccess();
}
