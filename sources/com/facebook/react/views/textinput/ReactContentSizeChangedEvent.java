package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.TouchesHelper;

/* loaded from: classes3.dex */
public class ReactContentSizeChangedEvent extends Event<ReactTextChangedEvent> {
    public static final String EVENT_NAME = "topContentSizeChange";
    private float mContentHeight;
    private float mContentWidth;

    @Deprecated
    public ReactContentSizeChangedEvent(int i, float f, float f2) {
        this(-1, i, f, f2);
    }

    public ReactContentSizeChangedEvent(int i, int i2, float f, float f2) {
        super(i, i2);
        this.mContentWidth = f;
        this.mContentHeight = f2;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* renamed from: getEventData */
    protected WritableMap getData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putDouble("width", this.mContentWidth);
        writableMapCreateMap2.putDouble("height", this.mContentHeight);
        writableMapCreateMap.putMap("contentSize", writableMapCreateMap2);
        writableMapCreateMap.putInt(TouchesHelper.TARGET_KEY, getViewTag());
        return writableMapCreateMap;
    }
}
