package com.swmansion.gesturehandler.core;

import android.view.VelocityTracker;
import androidx.camera.video.AudioStats;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Vector.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0000H\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0003R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/swmansion/gesturehandler/core/Vector;", "", "x", "", "y", "(DD)V", "magnitude", "getMagnitude", "()D", "unitX", "unitY", "getX", "getY", "computeSimilarity", "vector", "isSimilar", "", "threshold", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Vector {
    private static final double MINIMAL_RECOGNIZABLE_MAGNITUDE = 0.1d;
    private final double magnitude;
    private final double unitX;
    private final double unitY;
    private final double x;
    private final double y;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Vector VECTOR_LEFT = new Vector(-1.0d, AudioStats.AUDIO_AMPLITUDE_NONE);
    private static final Vector VECTOR_RIGHT = new Vector(1.0d, AudioStats.AUDIO_AMPLITUDE_NONE);
    private static final Vector VECTOR_UP = new Vector(AudioStats.AUDIO_AMPLITUDE_NONE, -1.0d);
    private static final Vector VECTOR_DOWN = new Vector(AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d);
    private static final Vector VECTOR_RIGHT_UP = new Vector(1.0d, -1.0d);
    private static final Vector VECTOR_RIGHT_DOWN = new Vector(1.0d, 1.0d);
    private static final Vector VECTOR_LEFT_UP = new Vector(-1.0d, -1.0d);
    private static final Vector VECTOR_LEFT_DOWN = new Vector(-1.0d, 1.0d);
    private static final Vector VECTOR_ZERO = new Vector(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);

    public Vector(double d, double d2) {
        this.x = d;
        this.y = d2;
        double dHypot = Math.hypot(d, d2);
        this.magnitude = dHypot;
        boolean z = dHypot > MINIMAL_RECOGNIZABLE_MAGNITUDE;
        double d3 = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.unitX = z ? d / dHypot : 0.0d;
        this.unitY = z ? d2 / dHypot : d3;
    }

    public final double getX() {
        return this.x;
    }

    public final double getY() {
        return this.y;
    }

    public final double getMagnitude() {
        return this.magnitude;
    }

    private final double computeSimilarity(Vector vector) {
        return (this.unitX * vector.unitX) + (this.unitY * vector.unitY);
    }

    public final boolean isSimilar(Vector vector, double threshold) {
        Intrinsics.checkNotNullParameter(vector, "vector");
        return computeSimilarity(vector) > threshold;
    }

    /* compiled from: Vector.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/swmansion/gesturehandler/core/Vector$Companion;", "", "()V", "MINIMAL_RECOGNIZABLE_MAGNITUDE", "", "VECTOR_DOWN", "Lcom/swmansion/gesturehandler/core/Vector;", "VECTOR_LEFT", "VECTOR_LEFT_DOWN", "VECTOR_LEFT_UP", "VECTOR_RIGHT", "VECTOR_RIGHT_DOWN", "VECTOR_RIGHT_UP", "VECTOR_UP", "VECTOR_ZERO", "fromDirection", "direction", "", "fromVelocity", "tracker", "Landroid/view/VelocityTracker;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Vector fromDirection(int direction) {
            switch (direction) {
                case 1:
                    return Vector.VECTOR_RIGHT;
                case 2:
                    return Vector.VECTOR_LEFT;
                case 3:
                case 7:
                default:
                    return Vector.VECTOR_ZERO;
                case 4:
                    return Vector.VECTOR_UP;
                case 5:
                    return Vector.VECTOR_RIGHT_UP;
                case 6:
                    return Vector.VECTOR_LEFT_UP;
                case 8:
                    return Vector.VECTOR_DOWN;
                case 9:
                    return Vector.VECTOR_RIGHT_DOWN;
                case 10:
                    return Vector.VECTOR_LEFT_DOWN;
            }
        }

        public final Vector fromVelocity(VelocityTracker tracker) {
            Intrinsics.checkNotNullParameter(tracker, "tracker");
            tracker.computeCurrentVelocity(1000);
            return new Vector(tracker.getXVelocity(), tracker.getYVelocity());
        }
    }
}
