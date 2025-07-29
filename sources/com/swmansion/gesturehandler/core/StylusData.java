package com.swmansion.gesturehandler.core;

import android.view.MotionEvent;
import androidx.camera.video.AudioStats;
import androidx.core.app.NotificationCompat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StylusData.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/swmansion/gesturehandler/core/StylusData;", "", "tiltX", "", "tiltY", "altitudeAngle", "azimuthAngle", "pressure", "(DDDDD)V", "getAltitudeAngle", "()D", "getAzimuthAngle", "getPressure", "getTiltX", "getTiltY", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toReadableMap", "Lcom/facebook/react/bridge/ReadableMap;", InAppPurchaseConstants.METHOD_TO_STRING, "", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class StylusData {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final double altitudeAngle;
    private final double azimuthAngle;
    private final double pressure;
    private final double tiltX;
    private final double tiltY;

    public StylusData() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 31, null);
    }

    /* renamed from: component1, reason: from getter */
    public final double getTiltX() {
        return this.tiltX;
    }

    /* renamed from: component2, reason: from getter */
    public final double getTiltY() {
        return this.tiltY;
    }

    /* renamed from: component3, reason: from getter */
    public final double getAltitudeAngle() {
        return this.altitudeAngle;
    }

    /* renamed from: component4, reason: from getter */
    public final double getAzimuthAngle() {
        return this.azimuthAngle;
    }

    /* renamed from: component5, reason: from getter */
    public final double getPressure() {
        return this.pressure;
    }

    public final StylusData copy(double tiltX, double tiltY, double altitudeAngle, double azimuthAngle, double pressure) {
        return new StylusData(tiltX, tiltY, altitudeAngle, azimuthAngle, pressure);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StylusData)) {
            return false;
        }
        StylusData stylusData = (StylusData) other;
        return Double.compare(this.tiltX, stylusData.tiltX) == 0 && Double.compare(this.tiltY, stylusData.tiltY) == 0 && Double.compare(this.altitudeAngle, stylusData.altitudeAngle) == 0 && Double.compare(this.azimuthAngle, stylusData.azimuthAngle) == 0 && Double.compare(this.pressure, stylusData.pressure) == 0;
    }

    public int hashCode() {
        return (((((((Double.hashCode(this.tiltX) * 31) + Double.hashCode(this.tiltY)) * 31) + Double.hashCode(this.altitudeAngle)) * 31) + Double.hashCode(this.azimuthAngle)) * 31) + Double.hashCode(this.pressure);
    }

    public String toString() {
        return "StylusData(tiltX=" + this.tiltX + ", tiltY=" + this.tiltY + ", altitudeAngle=" + this.altitudeAngle + ", azimuthAngle=" + this.azimuthAngle + ", pressure=" + this.pressure + ")";
    }

    public StylusData(double d, double d2, double d3, double d4, double d5) {
        this.tiltX = d;
        this.tiltY = d2;
        this.altitudeAngle = d3;
        this.azimuthAngle = d4;
        this.pressure = d5;
    }

    public /* synthetic */ StylusData(double d, double d2, double d3, double d4, double d5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0d : d, (i & 2) != 0 ? 0.0d : d2, (i & 4) != 0 ? 0.0d : d3, (i & 8) == 0 ? d4 : AudioStats.AUDIO_AMPLITUDE_NONE, (i & 16) != 0 ? -1.0d : d5);
    }

    public final double getTiltX() {
        return this.tiltX;
    }

    public final double getTiltY() {
        return this.tiltY;
    }

    public final double getAltitudeAngle() {
        return this.altitudeAngle;
    }

    public final double getAzimuthAngle() {
        return this.azimuthAngle;
    }

    public final double getPressure() {
        return this.pressure;
    }

    public final ReadableMap toReadableMap() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("tiltX", this.tiltX);
        writableMapCreateMap.putDouble("tiltY", this.tiltY);
        writableMapCreateMap.putDouble("altitudeAngle", this.altitudeAngle);
        writableMapCreateMap.putDouble("azimuthAngle", this.azimuthAngle);
        writableMapCreateMap.putDouble("pressure", this.pressure);
        Intrinsics.checkNotNull(writableMapCreateMap);
        return writableMapCreateMap;
    }

    /* compiled from: StylusData.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J$\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¨\u0006\f"}, d2 = {"Lcom/swmansion/gesturehandler/core/StylusData$Companion;", "", "()V", "fromEvent", "Lcom/swmansion/gesturehandler/core/StylusData;", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "spherical2tilt", "Lkotlin/Pair;", "", "altitudeAngle", "azimuthAngle", "react-native-gesture-handler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final Pair<Double, Double> spherical2tilt(double altitudeAngle, double azimuthAngle) {
            double dAtan;
            double dAtan2;
            if (altitudeAngle < 1.0E-9d) {
                dAtan = 1.5707963267948966d;
                double d = AudioStats.AUDIO_AMPLITUDE_NONE;
                double d2 = (azimuthAngle < 1.0E-9d || Math.abs(azimuthAngle - 6.283185307179586d) < 1.0E-9d) ? 1.5707963267948966d : 0.0d;
                double d3 = azimuthAngle - 1.5707963267948966d;
                if (Math.abs(d3) < 1.0E-9d) {
                    d = 1.5707963267948966d;
                }
                double d4 = azimuthAngle - 3.141592653589793d;
                dAtan2 = -1.5707963267948966d;
                if (Math.abs(d4) < 1.0E-9d) {
                    d2 = -1.5707963267948966d;
                }
                double d5 = azimuthAngle - 4.71238898038469d;
                if (Math.abs(d5) < 1.0E-9d) {
                    d = -1.5707963267948966d;
                }
                if (azimuthAngle > 1.0E-9d && Math.abs(d3) < 1.0E-9d) {
                    d = 1.5707963267948966d;
                    d2 = 1.5707963267948966d;
                }
                if (Math.abs(d3) > 1.0E-9d && Math.abs(d4) < 1.0E-9d) {
                    d = 1.5707963267948966d;
                    d2 = -1.5707963267948966d;
                }
                if (Math.abs(d4) > 1.0E-9d && Math.abs(d5) < 1.0E-9d) {
                    d = -1.5707963267948966d;
                    d2 = -1.5707963267948966d;
                }
                if (Math.abs(d5) <= 1.0E-9d || Math.abs(azimuthAngle - 6.283185307179586d) >= 1.0E-9d) {
                    dAtan2 = d;
                    dAtan = d2;
                }
            } else {
                double dTan = Math.tan(altitudeAngle);
                dAtan = Math.atan(Math.cos(azimuthAngle) / dTan);
                dAtan2 = Math.atan(Math.sin(azimuthAngle) / dTan);
            }
            return new Pair<>(Double.valueOf(Math.rint(dAtan * 57.29577951308232d)), Double.valueOf(Math.rint(dAtan2 * 57.29577951308232d)));
        }

        public final StylusData fromEvent(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            double axisValue = 1.5707963267948966d - event.getAxisValue(25);
            double pressure = event.getPressure(0);
            double orientation = (event.getOrientation(0) + 1.5707963267948966d) % 6.283185307179586d;
            if (orientation != AudioStats.AUDIO_AMPLITUDE_NONE && Math.signum(orientation) != Math.signum(6.283185307179586d)) {
                orientation += 6.283185307179586d;
            }
            double d = orientation;
            Pair<Double, Double> pairSpherical2tilt = spherical2tilt(axisValue, d);
            return new StylusData(pairSpherical2tilt.getFirst().doubleValue(), pairSpherical2tilt.getSecond().doubleValue(), axisValue, d, pressure);
        }
    }
}
