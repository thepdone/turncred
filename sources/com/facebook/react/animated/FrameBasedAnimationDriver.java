package com.facebook.react.animated;

import androidx.camera.video.AudioStats;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.build.ReactBuildConfig;
import io.sentry.protocol.SentryStackTrace;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FrameBasedAnimationDriver.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/facebook/react/animated/FrameBasedAnimationDriver;", "Lcom/facebook/react/animated/AnimationDriver;", "config", "Lcom/facebook/react/bridge/ReadableMap;", "(Lcom/facebook/react/bridge/ReadableMap;)V", "currentLoop", "", SentryStackTrace.JsonKeys.FRAMES, "", "fromValue", "", "iterations", "logCount", "startFrameTimeNanos", "", "toValue", "resetConfig", "", "runAnimationStep", "frameTimeNanos", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FrameBasedAnimationDriver extends AnimationDriver {
    private static final double FRAME_TIME_MILLIS = 16.666666666666668d;
    private int currentLoop;
    private double[] frames;
    private double fromValue;
    private int iterations;
    private int logCount;
    private long startFrameTimeNanos;
    private double toValue;

    public FrameBasedAnimationDriver(ReadableMap config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.startFrameTimeNanos = -1L;
        this.frames = new double[0];
        this.iterations = 1;
        this.currentLoop = 1;
        resetConfig(config);
    }

    @Override // com.facebook.react.animated.AnimationDriver
    public void resetConfig(ReadableMap config) {
        int size;
        Intrinsics.checkNotNullParameter(config, "config");
        ReadableArray array = config.getArray(SentryStackTrace.JsonKeys.FRAMES);
        if (array != null && this.frames.length != (size = array.size())) {
            double[] dArr = new double[size];
            for (int i = 0; i < size; i++) {
                dArr[i] = array.getDouble(i);
            }
            this.frames = dArr;
        }
        this.toValue = (config.hasKey("toValue") && config.getType("toValue") == ReadableType.Number) ? config.getDouble("toValue") : AudioStats.AUDIO_AMPLITUDE_NONE;
        int i2 = (config.hasKey("iterations") && config.getType("iterations") == ReadableType.Number) ? config.getInt("iterations") : 1;
        this.iterations = i2;
        this.currentLoop = 1;
        this.hasFinished = i2 == 0;
        this.startFrameTimeNanos = -1L;
    }

    @Override // com.facebook.react.animated.AnimationDriver
    public void runAnimationStep(long frameTimeNanos) {
        double d;
        ValueAnimatedNode valueAnimatedNode = this.animatedValue;
        if (valueAnimatedNode == null) {
            throw new IllegalArgumentException("Animated value should not be null".toString());
        }
        if (this.startFrameTimeNanos < 0) {
            this.startFrameTimeNanos = frameTimeNanos;
            if (this.currentLoop == 1) {
                this.fromValue = valueAnimatedNode.nodeValue;
            }
        }
        int iRound = (int) Math.round(((frameTimeNanos - this.startFrameTimeNanos) / 1000000) / FRAME_TIME_MILLIS);
        if (iRound < 0) {
            String str = "Calculated frame index should never be lower than 0. Called with frameTimeNanos " + frameTimeNanos + " and mStartFrameTimeNanos " + this.startFrameTimeNanos;
            if (ReactBuildConfig.DEBUG) {
                throw new IllegalStateException(str.toString());
            }
            if (this.logCount < 100) {
                FLog.w("ReactNative", str);
                this.logCount++;
                return;
            }
            return;
        }
        if (this.hasFinished) {
            return;
        }
        double[] dArr = this.frames;
        if (iRound >= dArr.length - 1) {
            int i = this.iterations;
            if (i == -1 || this.currentLoop < i) {
                double d2 = this.fromValue;
                d = d2 + (dArr[dArr.length - 1] * (this.toValue - d2));
                this.startFrameTimeNanos = -1L;
                this.currentLoop++;
            } else {
                d = this.toValue;
                this.hasFinished = true;
            }
        } else {
            double d3 = this.fromValue;
            d = d3 + (dArr[iRound] * (this.toValue - d3));
        }
        valueAnimatedNode.nodeValue = d;
    }
}
