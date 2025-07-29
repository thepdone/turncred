package com.mrousavy.camera.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraError.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/mrousavy/camera/core/InvalidTypeScriptUnionError;", "Lcom/mrousavy/camera/core/CameraError;", "unionName", "", "unionValue", "(Ljava/lang/String;Ljava/lang/String;)V", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InvalidTypeScriptUnionError extends CameraError {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidTypeScriptUnionError(String unionName, String str) {
        super("parameter", "invalid-parameter", "The given value for " + unionName + " could not be parsed! (Received: " + str + ")", null, 8, null);
        Intrinsics.checkNotNullParameter(unionName, "unionName");
    }
}
