package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: LongPressGestureHandler.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0016J&\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\"2\u0006\u0010#\u001a\u00020\u001d2\b\b\u0002\u0010$\u001a\u00020%H\u0002J\u0018\u0010&\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u001dH\u0014J\b\u0010(\u001a\u00020\u001bH\u0014J\u0018\u0010)\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006H\u0014J\b\u0010+\u001a\u00020\u001bH\u0016J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\bJ\u000e\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/swmansion/gesturehandler/core/LongPressGestureHandler;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "currentPointers", "", "defaultMaxDistSq", "", "duration", "getDuration", "()I", "handler", "Landroid/os/Handler;", "maxDistSq", "minDurationMs", "", "getMinDurationMs", "()J", "setMinDurationMs", "(J)V", "numberOfPointersRequired", "previousTime", "startTime", "startX", "startY", "dispatchHandlerUpdate", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "dispatchStateChange", "newState", "prevState", "getAverageCoords", "Lkotlin/Pair;", "ev", "excludePointer", "", "onHandle", "sourceEvent", "onReset", "onStateChange", "previousState", "resetConfig", "setMaxDist", "maxDist", "setNumberOfPointers", "numberOfPointers", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LongPressGestureHandler extends GestureHandler<LongPressGestureHandler> {
    private static final float DEFAULT_MAX_DIST_DP = 10.0f;
    private static final long DEFAULT_MIN_DURATION_MS = 500;
    private int currentPointers;
    private final float defaultMaxDistSq;
    private Handler handler;
    private float maxDistSq;
    private long minDurationMs;
    private int numberOfPointersRequired;
    private long previousTime;
    private long startTime;
    private float startX;
    private float startY;

    public LongPressGestureHandler(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.minDurationMs = DEFAULT_MIN_DURATION_MS;
        setShouldCancelWhenOutside(true);
        float f = context.getResources().getDisplayMetrics().density * DEFAULT_MAX_DIST_DP;
        float f2 = f * f;
        this.defaultMaxDistSq = f2;
        this.maxDistSq = f2;
        this.numberOfPointersRequired = 1;
    }

    public final long getMinDurationMs() {
        return this.minDurationMs;
    }

    public final void setMinDurationMs(long j) {
        this.minDurationMs = j;
    }

    public final int getDuration() {
        return (int) (this.previousTime - this.startTime);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void resetConfig() {
        super.resetConfig();
        this.minDurationMs = DEFAULT_MIN_DURATION_MS;
        this.maxDistSq = this.defaultMaxDistSq;
    }

    public final LongPressGestureHandler setMaxDist(float maxDist) {
        this.maxDistSq = maxDist * maxDist;
        return this;
    }

    public final LongPressGestureHandler setNumberOfPointers(int numberOfPointers) {
        this.numberOfPointersRequired = numberOfPointers;
        return this;
    }

    static /* synthetic */ Pair getAverageCoords$default(LongPressGestureHandler longPressGestureHandler, MotionEvent motionEvent, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return longPressGestureHandler.getAverageCoords(motionEvent, z);
    }

    private final Pair<Float, Float> getAverageCoords(MotionEvent ev, boolean excludePointer) {
        if (!excludePointer) {
            IntRange intRangeUntil = RangesKt.until(0, ev.getPointerCount());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator<Integer> it = intRangeUntil.iterator();
            while (it.hasNext()) {
                arrayList.add(Float.valueOf(ev.getX(((IntIterator) it).nextInt())));
            }
            float fAverageOfFloat = (float) CollectionsKt.averageOfFloat(arrayList);
            IntRange intRangeUntil2 = RangesKt.until(0, ev.getPointerCount());
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil2, 10));
            Iterator<Integer> it2 = intRangeUntil2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Float.valueOf(ev.getY(((IntIterator) it2).nextInt())));
            }
            return new Pair<>(Float.valueOf(fAverageOfFloat), Float.valueOf((float) CollectionsKt.averageOfFloat(arrayList2)));
        }
        int pointerCount = ev.getPointerCount();
        float x = 0.0f;
        float y = 0.0f;
        for (int i = 0; i < pointerCount; i++) {
            if (i != ev.getActionIndex()) {
                x += ev.getX(i);
                y += ev.getY(i);
            }
        }
        return new Pair<>(Float.valueOf(x / (ev.getPointerCount() - 1)), Float.valueOf(y / (ev.getPointerCount() - 1)));
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onHandle(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (shouldActivateWithMouse(sourceEvent)) {
            if (getState() == 0) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                this.previousTime = jUptimeMillis;
                this.startTime = jUptimeMillis;
                begin();
                Pair averageCoords$default = getAverageCoords$default(this, sourceEvent, false, 2, null);
                float fFloatValue = ((Number) averageCoords$default.component1()).floatValue();
                float fFloatValue2 = ((Number) averageCoords$default.component2()).floatValue();
                this.startX = fFloatValue;
                this.startY = fFloatValue2;
                this.currentPointers++;
            }
            if (sourceEvent.getActionMasked() == 5) {
                this.currentPointers++;
                Pair averageCoords$default2 = getAverageCoords$default(this, sourceEvent, false, 2, null);
                float fFloatValue3 = ((Number) averageCoords$default2.component1()).floatValue();
                float fFloatValue4 = ((Number) averageCoords$default2.component2()).floatValue();
                this.startX = fFloatValue3;
                this.startY = fFloatValue4;
                if (this.currentPointers > this.numberOfPointersRequired) {
                    fail();
                    this.currentPointers = 0;
                }
            }
            if (getState() == 2 && this.currentPointers == this.numberOfPointersRequired && (sourceEvent.getActionMasked() == 0 || sourceEvent.getActionMasked() == 5)) {
                Handler handler = new Handler(Looper.getMainLooper());
                this.handler = handler;
                long j = this.minDurationMs;
                if (j > 0) {
                    Intrinsics.checkNotNull(handler);
                    handler.postDelayed(new Runnable() { // from class: com.swmansion.gesturehandler.core.LongPressGestureHandler$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            LongPressGestureHandler.onHandle$lambda$2(this.f$0);
                        }
                    }, this.minDurationMs);
                } else if (j == 0) {
                    activate();
                }
            }
            if (sourceEvent.getActionMasked() == 1 || sourceEvent.getActionMasked() == 12) {
                this.currentPointers--;
                Handler handler2 = this.handler;
                if (handler2 != null) {
                    handler2.removeCallbacksAndMessages(null);
                    this.handler = null;
                }
                if (getState() == 4) {
                    end();
                    return;
                } else {
                    fail();
                    return;
                }
            }
            if (sourceEvent.getActionMasked() == 6) {
                int i = this.currentPointers - 1;
                this.currentPointers = i;
                if (i < this.numberOfPointersRequired && getState() != 4) {
                    fail();
                    this.currentPointers = 0;
                    return;
                }
                Pair<Float, Float> averageCoords = getAverageCoords(sourceEvent, true);
                float fFloatValue5 = averageCoords.component1().floatValue();
                float fFloatValue6 = averageCoords.component2().floatValue();
                this.startX = fFloatValue5;
                this.startY = fFloatValue6;
                return;
            }
            Pair averageCoords$default3 = getAverageCoords$default(this, sourceEvent, false, 2, null);
            float fFloatValue7 = ((Number) averageCoords$default3.component1()).floatValue();
            float fFloatValue8 = ((Number) averageCoords$default3.component2()).floatValue();
            float f = fFloatValue7 - this.startX;
            float f2 = fFloatValue8 - this.startY;
            if ((f * f) + (f2 * f2) > this.maxDistSq) {
                if (getState() == 4) {
                    cancel();
                } else {
                    fail();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onHandle$lambda$2(LongPressGestureHandler this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.activate();
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onStateChange(int newState, int previousState) {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.handler = null;
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void dispatchStateChange(int newState, int prevState) {
        this.previousTime = SystemClock.uptimeMillis();
        super.dispatchStateChange(newState, prevState);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void dispatchHandlerUpdate(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.previousTime = SystemClock.uptimeMillis();
        super.dispatchHandlerUpdate(event);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onReset() {
        super.onReset();
        this.currentPointers = 0;
    }
}
