package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.Event;

/* loaded from: classes3.dex */
class ReactTextInputSelectionEvent extends Event<ReactTextInputSelectionEvent> {
    private static final String EVENT_NAME = "topSelectionChange";
    private int mSelectionEnd;
    private int mSelectionStart;

    @Deprecated
    public ReactTextInputSelectionEvent(int i, int i2, int i3) {
        this(-1, i, i2, i3);
    }

    public ReactTextInputSelectionEvent(int i, int i2, int i3, int i4) {
        super(i, i2);
        this.mSelectionStart = i3;
        this.mSelectionEnd = i4;
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
        writableMapCreateMap2.putInt(ViewProps.END, this.mSelectionEnd);
        writableMapCreateMap2.putInt(ViewProps.START, this.mSelectionStart);
        writableMapCreateMap.putMap("selection", writableMapCreateMap2);
        return writableMapCreateMap;
    }
}
