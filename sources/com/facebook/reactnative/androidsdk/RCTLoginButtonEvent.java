package com.facebook.reactnative.androidsdk;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

/* loaded from: classes3.dex */
public class RCTLoginButtonEvent extends Event<RCTLoginButtonEvent> {
    public static final String EVENT_NAME = "topChange";
    private final WritableMap mEvent;

    public RCTLoginButtonEvent(int i, int i2, WritableMap writableMap) {
        super(i, i2);
        this.mEvent = writableMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topChange";
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        return this.mEvent;
    }
}
