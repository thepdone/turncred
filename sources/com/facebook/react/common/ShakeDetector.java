package com.facebook.react.common;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShakeDetector.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001$B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0002J\u0018\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\fH\u0002J\b\u0010 \u001a\u00020\u0015H\u0002J\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0010J\u0006\u0010#\u001a\u00020\u0015R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/facebook/react/common/ShakeDetector;", "Landroid/hardware/SensorEventListener;", "shakeListener", "Lcom/facebook/react/common/ShakeDetector$ShakeListener;", "minNumShakes", "", "(Lcom/facebook/react/common/ShakeDetector$ShakeListener;I)V", "accelerationX", "", "accelerationY", "accelerationZ", "lastShakeTimestamp", "", "lastTimestamp", "numShakes", "sensorManager", "Landroid/hardware/SensorManager;", "atLeastRequiredForce", "", "a", "maybeDispatchShake", "", "currentTimestamp", "onAccuracyChanged", "sensor", "Landroid/hardware/Sensor;", ContextChain.TAG_INFRA, "onSensorChanged", "sensorEvent", "Landroid/hardware/SensorEvent;", "recordShake", "timestamp", "reset", ViewProps.START, "manager", "stop", "ShakeListener", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ShakeDetector implements SensorEventListener {
    private float accelerationX;
    private float accelerationY;
    private float accelerationZ;
    private long lastShakeTimestamp;
    private long lastTimestamp;
    private final int minNumShakes;
    private int numShakes;
    private SensorManager sensorManager;
    private final ShakeListener shakeListener;

    /* compiled from: ShakeDetector.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Lcom/facebook/react/common/ShakeDetector$ShakeListener;", "", "onShake", "", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface ShakeListener {
        void onShake();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShakeDetector(ShakeListener shakeListener) {
        this(shakeListener, 0, 2, null);
        Intrinsics.checkNotNullParameter(shakeListener, "shakeListener");
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        Intrinsics.checkNotNullParameter(sensor, "sensor");
    }

    public ShakeDetector(ShakeListener shakeListener, int i) {
        Intrinsics.checkNotNullParameter(shakeListener, "shakeListener");
        this.shakeListener = shakeListener;
        this.minNumShakes = i;
    }

    public /* synthetic */ ShakeDetector(ShakeListener shakeListener, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(shakeListener, (i2 & 2) != 0 ? 1 : i);
    }

    public final void start(SensorManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Sensor defaultSensor = manager.getDefaultSensor(1);
        if (defaultSensor == null) {
            return;
        }
        this.sensorManager = manager;
        this.lastTimestamp = -1L;
        manager.registerListener(this, defaultSensor, 2);
        this.lastShakeTimestamp = 0L;
        reset();
    }

    public final void stop() {
        SensorManager sensorManager = this.sensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        this.sensorManager = null;
    }

    private final void reset() {
        this.numShakes = 0;
        this.accelerationX = 0.0f;
        this.accelerationY = 0.0f;
        this.accelerationZ = 0.0f;
    }

    private final boolean atLeastRequiredForce(float a2) {
        return Math.abs(a2) > 13.042845f;
    }

    private final void recordShake(long timestamp) {
        this.lastShakeTimestamp = timestamp;
        this.numShakes++;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Intrinsics.checkNotNullParameter(sensorEvent, "sensorEvent");
        if (sensorEvent.timestamp - this.lastTimestamp < ShakeDetectorKt.MIN_TIME_BETWEEN_SAMPLES_NS) {
            return;
        }
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2] - 9.80665f;
        this.lastTimestamp = sensorEvent.timestamp;
        if (atLeastRequiredForce(f) && this.accelerationX * f <= 0.0f) {
            recordShake(sensorEvent.timestamp);
            this.accelerationX = f;
        } else if (atLeastRequiredForce(f2) && this.accelerationY * f2 <= 0.0f) {
            recordShake(sensorEvent.timestamp);
            this.accelerationY = f2;
        } else if (atLeastRequiredForce(f3) && this.accelerationZ * f3 <= 0.0f) {
            recordShake(sensorEvent.timestamp);
            this.accelerationZ = f3;
        }
        maybeDispatchShake(sensorEvent.timestamp);
    }

    private final void maybeDispatchShake(long currentTimestamp) {
        if (this.numShakes >= this.minNumShakes * 8) {
            reset();
            this.shakeListener.onShake();
        }
        if (currentTimestamp - this.lastShakeTimestamp > ShakeDetectorKt.SHAKING_WINDOW_NS) {
            reset();
        }
    }
}
