package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.TouchesHelper;

/* loaded from: classes3.dex */
class ReactTextInputBlurEvent extends Event<ReactTextInputBlurEvent> {
    private static final String EVENT_NAME = "topBlur";

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return false;
    }

    @Deprecated
    public ReactTextInputBlurEvent(int i) {
        this(-1, i);
    }

    public ReactTextInputBlurEvent(int i, int i2) {
        super(i, i2);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt(TouchesHelper.TARGET_KEY, getViewTag());
        return writableMapCreateMap;
    }
}
