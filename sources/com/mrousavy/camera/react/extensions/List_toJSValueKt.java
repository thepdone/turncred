package com.mrousavy.camera.react.extensions;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.mrousavy.camera.core.types.JSUnionValue;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: List+toJSValue.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"toJSValue", "Lcom/facebook/react/bridge/ReadableArray;", "", "Lcom/mrousavy/camera/core/types/JSUnionValue;", "react-native-vision-camera_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class List_toJSValueKt {
    public static final ReadableArray toJSValue(List<? extends JSUnionValue> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            writableArrayCreateArray.pushString(((JSUnionValue) it.next()).getUnionValue());
        }
        Intrinsics.checkNotNull(writableArrayCreateArray);
        return writableArrayCreateArray;
    }
}
