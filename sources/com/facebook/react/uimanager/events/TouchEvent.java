package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import androidx.core.util.Pools;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.uimanager.events.TouchEventType;
import io.sentry.Session;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TouchEvent.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001)B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0006\u0010\u001d\u001a\u00020\u0006J\u0006\u0010\u001e\u001a\u00020\bJJ\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001a2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\u0013H\u0016J\b\u0010(\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006*"}, d2 = {"Lcom/facebook/react/uimanager/events/TouchEvent;", "Lcom/facebook/react/uimanager/events/Event;", "()V", "coalescingKey", "", "motionEvent", "Landroid/view/MotionEvent;", "touchEventType", "Lcom/facebook/react/uimanager/events/TouchEventType;", "<set-?>", "", "viewX", "getViewX", "()F", "viewY", "getViewY", "canCoalesce", "", "dispatch", "", "rctEventEmitter", "Lcom/facebook/react/uimanager/events/RCTEventEmitter;", "dispatchModern", "Lcom/facebook/react/uimanager/events/RCTModernEventEmitter;", "getCoalescingKey", "getEventCategory", "", "getEventName", "", "getMotionEvent", "getTouchEventType", Session.JsonKeys.INIT, "surfaceId", "viewTag", "motionEventToCopy", "gestureStartTime", "", "touchEventCoalescingKeyHelper", "Lcom/facebook/react/uimanager/events/TouchEventCoalescingKeyHelper;", "onDispose", "verifyMotionEvent", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TouchEvent extends Event<TouchEvent> {
    private static final int TOUCH_EVENTS_POOL_SIZE = 3;
    public static final long UNSET = Long.MIN_VALUE;
    private short coalescingKey;
    private MotionEvent motionEvent;
    private TouchEventType touchEventType;
    private float viewX;
    private float viewY;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "TouchEvent";
    private static final Pools.SynchronizedPool<TouchEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(3);

    /* compiled from: TouchEvent.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TouchEventType.values().length];
            try {
                iArr[TouchEventType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TouchEventType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TouchEventType.CANCEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TouchEventType.MOVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ TouchEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final TouchEvent obtain(int i, int i2, TouchEventType touchEventType, MotionEvent motionEvent, long j, float f, float f2, TouchEventCoalescingKeyHelper touchEventCoalescingKeyHelper) {
        return INSTANCE.obtain(i, i2, touchEventType, motionEvent, j, f, f2, touchEventCoalescingKeyHelper);
    }

    @Deprecated(message = "Please use the other overload of the obtain method, which explicitly provides surfaceId", replaceWith = @ReplaceWith(expression = "obtain(surfaceId, ...)", imports = {}))
    @JvmStatic
    public static final TouchEvent obtain(int i, TouchEventType touchEventType, MotionEvent motionEvent, long j, float f, float f2, TouchEventCoalescingKeyHelper touchEventCoalescingKeyHelper) {
        return INSTANCE.obtain(i, touchEventType, motionEvent, j, f, f2, touchEventCoalescingKeyHelper);
    }

    private TouchEvent() {
    }

    public final float getViewX() {
        return this.viewX;
    }

    public final float getViewY() {
        return this.viewY;
    }

    public final MotionEvent getMotionEvent() {
        Object objAssertNotNull = Assertions.assertNotNull(this.motionEvent);
        Intrinsics.checkNotNullExpressionValue(objAssertNotNull, "assertNotNull(...)");
        return (MotionEvent) objAssertNotNull;
    }

    public final TouchEventType getTouchEventType() {
        Object objAssertNotNull = Assertions.assertNotNull(this.touchEventType);
        Intrinsics.checkNotNullExpressionValue(objAssertNotNull, "assertNotNull(...)");
        return (TouchEventType) objAssertNotNull;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void init(int surfaceId, int viewTag, TouchEventType touchEventType, MotionEvent motionEventToCopy, long gestureStartTime, float viewX, float viewY, TouchEventCoalescingKeyHelper touchEventCoalescingKeyHelper) {
        super.init(surfaceId, viewTag, motionEventToCopy.getEventTime());
        short coalescingKey = 0;
        SoftAssertions.assertCondition(gestureStartTime != Long.MIN_VALUE, "Gesture start time must be initialized");
        int action = motionEventToCopy.getAction() & 255;
        if (action == 0) {
            touchEventCoalescingKeyHelper.addCoalescingKey(gestureStartTime);
        } else if (action == 1) {
            touchEventCoalescingKeyHelper.removeCoalescingKey(gestureStartTime);
        } else if (action == 2) {
            coalescingKey = touchEventCoalescingKeyHelper.getCoalescingKey(gestureStartTime);
        } else if (action == 3) {
            touchEventCoalescingKeyHelper.removeCoalescingKey(gestureStartTime);
        } else if (action == 5 || action == 6) {
            touchEventCoalescingKeyHelper.incrementCoalescingKey(gestureStartTime);
        } else {
            throw new RuntimeException("Unhandled MotionEvent action: " + action);
        }
        this.motionEvent = MotionEvent.obtain(motionEventToCopy);
        this.touchEventType = touchEventType;
        this.coalescingKey = coalescingKey;
        this.viewX = viewX;
        this.viewY = viewY;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void onDispose() {
        MotionEvent motionEvent = this.motionEvent;
        if (motionEvent != null) {
            motionEvent.recycle();
        }
        this.motionEvent = null;
        try {
            EVENTS_POOL.release(this);
        } catch (IllegalStateException e) {
            ReactSoftExceptionLogger.logSoftException(TAG, e);
        }
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        TouchEventType.Companion companion = TouchEventType.INSTANCE;
        Object objAssertNotNull = Assertions.assertNotNull(this.touchEventType);
        Intrinsics.checkNotNullExpressionValue(objAssertNotNull, "assertNotNull(...)");
        return companion.getJSEventName((TouchEventType) objAssertNotNull);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        TouchEventType touchEventType = (TouchEventType) Assertions.assertNotNull(this.touchEventType);
        int i = touchEventType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[touchEventType.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return false;
        }
        if (i == 4) {
            return true;
        }
        throw new RuntimeException("Unknown touch event type: " + this.touchEventType);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return this.coalescingKey;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
        if (verifyMotionEvent()) {
            TouchesHelper.sendTouchesLegacy(rctEventEmitter, this);
        }
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void dispatchModern(RCTModernEventEmitter rctEventEmitter) {
        Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
        if (verifyMotionEvent()) {
            rctEventEmitter.receiveTouches(this);
        }
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected int getEventCategory() {
        TouchEventType touchEventType = this.touchEventType;
        if (touchEventType == null) {
            return 2;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[touchEventType.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2 || i == 3) {
            return 1;
        }
        if (i == 4) {
            return 4;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final boolean verifyMotionEvent() {
        if (this.motionEvent != null) {
            return true;
        }
        ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Cannot dispatch a TouchEvent that has no MotionEvent; the TouchEvent has been recycled"));
        return false;
    }

    /* compiled from: TouchEvent.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0007JL\u0010\r\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/facebook/react/uimanager/events/TouchEvent$Companion;", "", "()V", "EVENTS_POOL", "Landroidx/core/util/Pools$SynchronizedPool;", "Lcom/facebook/react/uimanager/events/TouchEvent;", "TAG", "", "kotlin.jvm.PlatformType", "TOUCH_EVENTS_POOL_SIZE", "", "UNSET", "", "obtain", "viewTag", "touchEventType", "Lcom/facebook/react/uimanager/events/TouchEventType;", "motionEventToCopy", "Landroid/view/MotionEvent;", "gestureStartTime", "viewX", "", "viewY", "touchEventCoalescingKeyHelper", "Lcom/facebook/react/uimanager/events/TouchEventCoalescingKeyHelper;", "surfaceId", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Deprecated(message = "Please use the other overload of the obtain method, which explicitly provides surfaceId", replaceWith = @ReplaceWith(expression = "obtain(surfaceId, ...)", imports = {}))
        @JvmStatic
        public final TouchEvent obtain(int viewTag, TouchEventType touchEventType, MotionEvent motionEventToCopy, long gestureStartTime, float viewX, float viewY, TouchEventCoalescingKeyHelper touchEventCoalescingKeyHelper) {
            Intrinsics.checkNotNullParameter(touchEventCoalescingKeyHelper, "touchEventCoalescingKeyHelper");
            return obtain(-1, viewTag, touchEventType, (MotionEvent) Assertions.assertNotNull(motionEventToCopy), gestureStartTime, viewX, viewY, touchEventCoalescingKeyHelper);
        }

        @JvmStatic
        public final TouchEvent obtain(int surfaceId, int viewTag, TouchEventType touchEventType, MotionEvent motionEventToCopy, long gestureStartTime, float viewX, float viewY, TouchEventCoalescingKeyHelper touchEventCoalescingKeyHelper) {
            Intrinsics.checkNotNullParameter(touchEventCoalescingKeyHelper, "touchEventCoalescingKeyHelper");
            TouchEvent touchEvent = (TouchEvent) TouchEvent.EVENTS_POOL.acquire();
            if (touchEvent == null) {
                touchEvent = new TouchEvent(null);
            }
            Object objAssertNotNull = Assertions.assertNotNull(motionEventToCopy);
            Intrinsics.checkNotNullExpressionValue(objAssertNotNull, "assertNotNull(...)");
            touchEvent.init(surfaceId, viewTag, touchEventType, (MotionEvent) objAssertNotNull, gestureStartTime, viewX, viewY, touchEventCoalescingKeyHelper);
            return touchEvent;
        }
    }
}
