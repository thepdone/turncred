package com.facebook.react.uimanager;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.TouchesHelper;

/* loaded from: classes4.dex */
public class OnLayoutEvent extends Event<OnLayoutEvent> {
    private static final Pools.SynchronizedPool<OnLayoutEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(20);
    private int mHeight;
    private int mWidth;
    private int mX;
    private int mY;

    @Deprecated
    public static OnLayoutEvent obtain(int i, int i2, int i3, int i4, int i5) {
        return obtain(-1, i, i2, i3, i4, i5);
    }

    public static OnLayoutEvent obtain(int i, int i2, int i3, int i4, int i5, int i6) {
        OnLayoutEvent onLayoutEventAcquire = EVENTS_POOL.acquire();
        if (onLayoutEventAcquire == null) {
            onLayoutEventAcquire = new OnLayoutEvent();
        }
        onLayoutEventAcquire.init(i, i2, i3, i4, i5, i6);
        return onLayoutEventAcquire;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void onDispose() {
        EVENTS_POOL.release(this);
    }

    private OnLayoutEvent() {
    }

    @Deprecated
    protected void init(int i, int i2, int i3, int i4, int i5) {
        init(-1, i, i2, i3, i4, i5);
    }

    protected void init(int i, int i2, int i3, int i4, int i5, int i6) {
        super.init(i, i2);
        this.mX = i3;
        this.mY = i4;
        this.mWidth = i5;
        this.mHeight = i6;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topLayout";
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* renamed from: getEventData */
    protected WritableMap getData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("x", PixelUtil.toDIPFromPixel(this.mX));
        writableMapCreateMap.putDouble("y", PixelUtil.toDIPFromPixel(this.mY));
        writableMapCreateMap.putDouble("width", PixelUtil.toDIPFromPixel(this.mWidth));
        writableMapCreateMap.putDouble("height", PixelUtil.toDIPFromPixel(this.mHeight));
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.putMap("layout", writableMapCreateMap);
        writableMapCreateMap2.putInt(TouchesHelper.TARGET_KEY, getViewTag());
        return writableMapCreateMap2;
    }
}
