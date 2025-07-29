package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.TouchesHelper;

/* loaded from: classes3.dex */
public class ReactTextChangedEvent extends Event<ReactTextChangedEvent> {
    public static final String EVENT_NAME = "topChange";
    private int mEventCount;
    private String mText;

    @Deprecated
    public ReactTextChangedEvent(int i, String str, int i2) {
        this(-1, i, str, i2);
    }

    public ReactTextChangedEvent(int i, int i2, String str, int i3) {
        super(i, i2);
        this.mText = str;
        this.mEventCount = i3;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topChange";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("text", this.mText);
        writableMapCreateMap.putInt("eventCount", this.mEventCount);
        writableMapCreateMap.putInt(TouchesHelper.TARGET_KEY, getViewTag());
        return writableMapCreateMap;
    }
}
