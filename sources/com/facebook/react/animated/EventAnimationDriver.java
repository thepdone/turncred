package com.facebook.react.animated;

import androidx.camera.video.AudioStats;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UnexpectedNativeTypeException;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTModernEventEmitter;
import com.facebook.react.uimanager.events.TouchEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EventAnimationDriver.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ*\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016JB\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J \u0010\u0016\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/facebook/react/animated/EventAnimationDriver;", "Lcom/facebook/react/uimanager/events/RCTModernEventEmitter;", "eventName", "", "viewTag", "", "eventPath", "", "valueNode", "Lcom/facebook/react/animated/ValueAnimatedNode;", "(Ljava/lang/String;ILjava/util/List;Lcom/facebook/react/animated/ValueAnimatedNode;)V", "receiveEvent", "", "surfaceId", "targetTag", NotificationCompat.CATEGORY_EVENT, "Lcom/facebook/react/bridge/WritableMap;", "canCoalesceEvent", "", "customCoalesceKey", "category", "targetReactTag", "receiveTouches", "touchEvent", "Lcom/facebook/react/uimanager/events/TouchEvent;", "touches", "Lcom/facebook/react/bridge/WritableArray;", "changedIndices", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EventAnimationDriver implements RCTModernEventEmitter {
    public String eventName;
    private final List<String> eventPath;
    public ValueAnimatedNode valueNode;
    public int viewTag;

    public EventAnimationDriver(String eventName, int i, List<String> eventPath, ValueAnimatedNode valueNode) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventPath, "eventPath");
        Intrinsics.checkNotNullParameter(valueNode, "valueNode");
        this.eventName = eventName;
        this.viewTag = i;
        this.eventPath = eventPath;
        this.valueNode = valueNode;
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    public void receiveEvent(int targetReactTag, String eventName, WritableMap event) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        receiveEvent(-1, targetReactTag, eventName, event);
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    public void receiveEvent(int surfaceId, int targetTag, String eventName, WritableMap event) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        receiveEvent(surfaceId, targetTag, eventName, false, 0, event, 2);
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    public void receiveTouches(String eventName, WritableArray touches, WritableArray changedIndices) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(touches, "touches");
        Intrinsics.checkNotNullParameter(changedIndices, "changedIndices");
        throw new UnsupportedOperationException("receiveTouches is not support by native animated events");
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    public void receiveTouches(TouchEvent touchEvent) {
        Intrinsics.checkNotNullParameter(touchEvent, "touchEvent");
        throw new UnsupportedOperationException("receiveTouches is not support by native animated events");
    }

    @Override // com.facebook.react.uimanager.events.RCTModernEventEmitter
    public void receiveEvent(int surfaceId, int targetTag, String eventName, boolean canCoalesceEvent, int customCoalesceKey, WritableMap event, int category) throws NumberFormatException {
        ReadableMap map;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (event == null) {
            throw new IllegalArgumentException("Native animated events must have event data.".toString());
        }
        WritableMap writableMap = event;
        int size = this.eventPath.size() - 1;
        ReadableArray array = null;
        for (int i = 0; i < size; i++) {
            if (writableMap != null) {
                String str = this.eventPath.get(i);
                ReadableType type = writableMap.getType(str);
                if (type == ReadableType.Map) {
                    map = writableMap.getMap(str);
                    writableMap = map;
                    array = null;
                } else if (type == ReadableType.Array) {
                    array = writableMap.getArray(str);
                    writableMap = null;
                } else {
                    throw new UnexpectedNativeTypeException("Unexpected type " + type + " for key '" + str + "'");
                }
            } else {
                int i2 = Integer.parseInt(this.eventPath.get(i));
                ReadableType type2 = array != null ? array.getType(i2) : null;
                if (type2 == ReadableType.Map) {
                    map = array != null ? array.getMap(i2) : null;
                    writableMap = map;
                    array = null;
                } else if (type2 == ReadableType.Array) {
                    array = array != null ? array.getArray(i2) : null;
                    writableMap = null;
                } else {
                    throw new UnexpectedNativeTypeException("Unexpected type " + type2 + " for index '" + i2 + "'");
                }
            }
        }
        String str2 = this.eventPath.get(r3.size() - 1);
        if (writableMap != null) {
            this.valueNode.nodeValue = writableMap.getDouble(str2);
            return;
        }
        this.valueNode.nodeValue = array != null ? array.getDouble(Integer.parseInt(str2)) : AudioStats.AUDIO_AMPLITUDE_NONE;
    }
}
