package com.facebook.react.views.textinput;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

/* loaded from: classes3.dex */
class ReactTextInputKeyPressEvent extends Event<ReactTextInputKeyPressEvent> {
    public static final String EVENT_NAME = "topKeyPress";
    private String mKey;

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return false;
    }

    @Deprecated
    ReactTextInputKeyPressEvent(int i, String str) {
        this(-1, i, str);
    }

    ReactTextInputKeyPressEvent(int i, int i2, String str) {
        super(i, i2);
        this.mKey = str;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(SDKConstants.PARAM_KEY, this.mKey);
        return writableMapCreateMap;
    }
}
