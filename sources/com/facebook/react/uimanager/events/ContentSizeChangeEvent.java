package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.views.textinput.ReactContentSizeChangedEvent;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentSizeChangeEvent.kt */
@Deprecated(message = "Please define your own event for custom components")
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006B%\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/facebook/react/uimanager/events/ContentSizeChangeEvent;", "Lcom/facebook/react/uimanager/events/Event;", "viewTag", "", "width", "height", "(III)V", "surfaceId", "(IIII)V", "getEventData", "Lcom/facebook/react/bridge/WritableMap;", "getEventName", "", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ContentSizeChangeEvent extends Event<ContentSizeChangeEvent> {
    private final int height;
    private final int width;

    public ContentSizeChangeEvent(int i, int i2, int i3, int i4) {
        super(i, i2);
        this.width = i3;
        this.height = i4;
    }

    @Deprecated(message = "Please specify surfaceId explicitly in the constructor.", replaceWith = @ReplaceWith(expression = "constructor(surfaceId, viewTag, width, height)", imports = {}))
    public ContentSizeChangeEvent(int i, int i2, int i3) {
        this(-1, i, i2, i3);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return ReactContentSizeChangedEvent.EVENT_NAME;
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* renamed from: getEventData */
    protected WritableMap getData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("width", PixelUtil.toDIPFromPixel(this.width));
        writableMapCreateMap.putDouble("height", PixelUtil.toDIPFromPixel(this.height));
        Intrinsics.checkNotNull(writableMapCreateMap);
        return writableMapCreateMap;
    }
}
