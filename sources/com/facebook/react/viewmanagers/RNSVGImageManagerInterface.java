package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

/* loaded from: classes4.dex */
public interface RNSVGImageManagerInterface<T extends View> {
    void setAlign(T t, String str);

    void setClipPath(T t, String str);

    void setClipRule(T t, int i);

    void setColor(T t, Integer num);

    void setDisplay(T t, String str);

    void setFill(T t, Dynamic dynamic);

    void setFillOpacity(T t, float f);

    void setFillRule(T t, int i);

    void setFilter(T t, String str);

    void setHeight(T t, Dynamic dynamic);

    void setMarkerEnd(T t, String str);

    void setMarkerMid(T t, String str);

    void setMarkerStart(T t, String str);

    void setMask(T t, String str);

    void setMatrix(T t, ReadableArray readableArray);

    void setMeetOrSlice(T t, int i);

    void setName(T t, String str);

    void setOpacity(T t, float f);

    void setPointerEvents(T t, String str);

    void setPropList(T t, ReadableArray readableArray);

    void setResponsible(T t, boolean z);

    void setSrc(T t, ReadableMap readableMap);

    void setStroke(T t, Dynamic dynamic);

    void setStrokeDasharray(T t, Dynamic dynamic);

    void setStrokeDashoffset(T t, float f);

    void setStrokeLinecap(T t, int i);

    void setStrokeLinejoin(T t, int i);

    void setStrokeMiterlimit(T t, float f);

    void setStrokeOpacity(T t, float f);

    void setStrokeWidth(T t, Dynamic dynamic);

    void setVectorEffect(T t, int i);

    void setWidth(T t, Dynamic dynamic);

    void setX(T t, Dynamic dynamic);

    void setY(T t, Dynamic dynamic);
}
