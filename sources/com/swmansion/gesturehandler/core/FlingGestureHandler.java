package com.swmansion.gesturehandler.core;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.core.app.NotificationCompat;
import com.swmansion.gesturehandler.core.Vector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FlingGestureHandler.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0014J\u0018\u0010 \u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001dH\u0014J\b\u0010\"\u001a\u00020\u0017H\u0014J\b\u0010#\u001a\u00020\u0017H\u0016J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/swmansion/gesturehandler/core/FlingGestureHandler;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "()V", "direction", "", "getDirection", "()I", "setDirection", "(I)V", "failDelayed", "Ljava/lang/Runnable;", "handler", "Landroid/os/Handler;", "maxDurationMs", "", "maxNumberOfPointersSimultaneously", "minVelocity", "numberOfPointersRequired", "getNumberOfPointersRequired", "setNumberOfPointersRequired", "velocityTracker", "Landroid/view/VelocityTracker;", "activate", "", "force", "", "addVelocityMovement", "tracker", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "endFling", "onCancel", "onHandle", "sourceEvent", "onReset", "resetConfig", "startFling", "tryEndFling", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlingGestureHandler extends GestureHandler<FlingGestureHandler> {
    private static final int DEFAULT_DIRECTION = 1;
    private static final long DEFAULT_MAX_DURATION_MS = 800;
    private static final long DEFAULT_MIN_VELOCITY = 2000;
    private static final int DEFAULT_NUMBER_OF_TOUCHES_REQUIRED = 1;
    private Handler handler;
    private int maxNumberOfPointersSimultaneously;
    private VelocityTracker velocityTracker;
    private static final double DEFAULT_ALIGNMENT_CONE = 30.0d;
    private static final double MAX_AXIAL_DEVIATION = GestureUtils.INSTANCE.coneToDeviation(DEFAULT_ALIGNMENT_CONE);
    private static final double MAX_DIAGONAL_DEVIATION = GestureUtils.INSTANCE.coneToDeviation(60.0d);
    private int numberOfPointersRequired = 1;
    private int direction = 1;
    private final long maxDurationMs = DEFAULT_MAX_DURATION_MS;
    private final long minVelocity = DEFAULT_MIN_VELOCITY;
    private final Runnable failDelayed = new Runnable() { // from class: com.swmansion.gesturehandler.core.FlingGestureHandler$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            FlingGestureHandler.failDelayed$lambda$0(this.f$0);
        }
    };

    public final int getNumberOfPointersRequired() {
        return this.numberOfPointersRequired;
    }

    public final void setNumberOfPointersRequired(int i) {
        this.numberOfPointersRequired = i;
    }

    public final int getDirection() {
        return this.direction;
    }

    public final void setDirection(int i) {
        this.direction = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void failDelayed$lambda$0(FlingGestureHandler this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.fail();
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void resetConfig() {
        super.resetConfig();
        this.numberOfPointersRequired = 1;
        this.direction = 1;
    }

    private final void startFling(MotionEvent event) {
        this.velocityTracker = VelocityTracker.obtain();
        begin();
        this.maxNumberOfPointersSimultaneously = 1;
        Handler handler = this.handler;
        if (handler == null) {
            this.handler = new Handler(Looper.getMainLooper());
        } else {
            Intrinsics.checkNotNull(handler);
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.handler;
        Intrinsics.checkNotNull(handler2);
        handler2.postDelayed(this.failDelayed, this.maxDurationMs);
    }

    private final boolean tryEndFling(MotionEvent event) {
        boolean z;
        boolean z2;
        addVelocityMovement(this.velocityTracker, event);
        Vector.Companion companion = Vector.INSTANCE;
        VelocityTracker velocityTracker = this.velocityTracker;
        Intrinsics.checkNotNull(velocityTracker);
        Vector vectorFromVelocity = companion.fromVelocity(velocityTracker);
        Integer[] numArr = {2, 1, 4, 8};
        ArrayList arrayList = new ArrayList(4);
        for (int i = 0; i < 4; i++) {
            arrayList.add(Boolean.valueOf(tryEndFling$getVelocityAlignment(this, vectorFromVelocity, numArr[i].intValue(), MAX_AXIAL_DEVIATION)));
        }
        ArrayList arrayList2 = arrayList;
        Integer[] numArr2 = {5, 9, 6, 10};
        ArrayList arrayList3 = new ArrayList(4);
        for (int i2 = 0; i2 < 4; i2++) {
            arrayList3.add(Boolean.valueOf(tryEndFling$getVelocityAlignment(this, vectorFromVelocity, numArr2[i2].intValue(), MAX_DIAGONAL_DEVIATION)));
        }
        ArrayList arrayList4 = arrayList3;
        ArrayList arrayList5 = arrayList2;
        if ((arrayList5 instanceof Collection) && arrayList5.isEmpty()) {
            z = false;
        } else {
            Iterator it = arrayList5.iterator();
            while (it.hasNext()) {
                if (((Boolean) it.next()).booleanValue()) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        ArrayList arrayList6 = arrayList4;
        if ((arrayList6 instanceof Collection) && arrayList6.isEmpty()) {
            z2 = false;
        } else {
            Iterator it2 = arrayList6.iterator();
            while (it2.hasNext()) {
                if (((Boolean) it2.next()).booleanValue()) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        boolean z3 = z | z2;
        boolean z4 = vectorFromVelocity.getMagnitude() > ((double) this.minVelocity);
        if (this.maxNumberOfPointersSimultaneously != this.numberOfPointersRequired || !z3 || !z4) {
            return false;
        }
        Handler handler = this.handler;
        Intrinsics.checkNotNull(handler);
        handler.removeCallbacksAndMessages(null);
        activate();
        return true;
    }

    private static final boolean tryEndFling$getVelocityAlignment(FlingGestureHandler flingGestureHandler, Vector vector, int i, double d) {
        return (flingGestureHandler.direction & i) == i && vector.isSimilar(Vector.INSTANCE.fromDirection(i), d);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public void activate(boolean force) {
        super.activate(force);
        end();
    }

    private final void endFling(MotionEvent event) {
        if (tryEndFling(event)) {
            return;
        }
        fail();
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onHandle(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (shouldActivateWithMouse(sourceEvent)) {
            int state = getState();
            if (state == 0) {
                startFling(sourceEvent);
            }
            if (state == 2) {
                tryEndFling(sourceEvent);
                if (sourceEvent.getPointerCount() > this.maxNumberOfPointersSimultaneously) {
                    this.maxNumberOfPointersSimultaneously = sourceEvent.getPointerCount();
                }
                if (sourceEvent.getActionMasked() == 1) {
                    endFling(sourceEvent);
                }
            }
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onCancel() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    protected void onReset() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.velocityTracker = null;
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    private final void addVelocityMovement(VelocityTracker tracker, MotionEvent event) {
        float rawX = event.getRawX() - event.getX();
        float rawY = event.getRawY() - event.getY();
        event.offsetLocation(rawX, rawY);
        Intrinsics.checkNotNull(tracker);
        tracker.addMovement(event);
        event.offsetLocation(-rawX, -rawY);
    }
}
