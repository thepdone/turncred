package com.facebook.fresco.animation.drawable;

import android.os.SystemClock;
import com.facebook.fresco.animation.frame.FrameScheduler;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimationFrameScheduler.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010!\u001a\u00020\u0010J\u0006\u0010\"\u001a\u00020\u001bJ\u0006\u0010#\u001a\u00020\u0006J\u0006\u0010$\u001a\u00020\u0006J\b\u0010%\u001a\u00020\u0006H\u0002J\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020\u001bJ\u0006\u0010)\u001a\u00020'J\u0006\u0010*\u001a\u00020'R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/facebook/fresco/animation/drawable/AnimationFrameScheduler;", "", "frameScheduler", "Lcom/facebook/fresco/animation/frame/FrameScheduler;", "(Lcom/facebook/fresco/animation/frame/FrameScheduler;)V", "expectedRenderTimeMs", "", "frameSchedulingDelayMs", "getFrameSchedulingDelayMs", "()J", "setFrameSchedulingDelayMs", "(J)V", "frameSchedulingOffsetMs", "getFrameSchedulingOffsetMs", "setFrameSchedulingOffsetMs", "framesDropped", "", "lastDrawnFrameNumber", "getLastDrawnFrameNumber", "()I", "setLastDrawnFrameNumber", "(I)V", "lastFrameAnimationTimeDifferenceMs", "lastFrameAnimationTimeMs", "pauseTimeMs", "pausedLastDrawnFrameNumber", "running", "", "getRunning", "()Z", "setRunning", "(Z)V", "startMs", "frameToDraw", "infinite", "loopDuration", "nextRenderTime", "now", "onFrameDropped", "", "shouldRepeatAnimation", ViewProps.START, "stop", "animated-drawable_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AnimationFrameScheduler {
    private long expectedRenderTimeMs;
    private final FrameScheduler frameScheduler;
    private long frameSchedulingDelayMs;
    private long frameSchedulingOffsetMs;
    private int framesDropped;
    private int lastDrawnFrameNumber;
    private long lastFrameAnimationTimeDifferenceMs;
    private long lastFrameAnimationTimeMs;
    private long pauseTimeMs;
    private int pausedLastDrawnFrameNumber;
    private boolean running;
    private long startMs;

    public AnimationFrameScheduler(FrameScheduler frameScheduler) {
        Intrinsics.checkNotNullParameter(frameScheduler, "frameScheduler");
        this.frameScheduler = frameScheduler;
        this.frameSchedulingDelayMs = 8L;
        this.lastDrawnFrameNumber = -1;
        this.pausedLastDrawnFrameNumber = -1;
    }

    public final boolean getRunning() {
        return this.running;
    }

    public final void setRunning(boolean z) {
        this.running = z;
    }

    public final long getFrameSchedulingDelayMs() {
        return this.frameSchedulingDelayMs;
    }

    public final void setFrameSchedulingDelayMs(long j) {
        this.frameSchedulingDelayMs = j;
    }

    public final long getFrameSchedulingOffsetMs() {
        return this.frameSchedulingOffsetMs;
    }

    public final void setFrameSchedulingOffsetMs(long j) {
        this.frameSchedulingOffsetMs = j;
    }

    public final int getLastDrawnFrameNumber() {
        return this.lastDrawnFrameNumber;
    }

    public final void setLastDrawnFrameNumber(int i) {
        this.lastDrawnFrameNumber = i;
    }

    private final long now() {
        return SystemClock.uptimeMillis();
    }

    public final void start() {
        if (this.running) {
            return;
        }
        long jNow = now();
        long j = jNow - this.pauseTimeMs;
        this.startMs = j;
        this.expectedRenderTimeMs = j;
        this.lastFrameAnimationTimeMs = jNow - this.lastFrameAnimationTimeDifferenceMs;
        this.lastDrawnFrameNumber = this.pausedLastDrawnFrameNumber;
        this.running = true;
    }

    public final void stop() {
        if (this.running) {
            long jNow = now();
            this.pauseTimeMs = jNow - this.startMs;
            this.lastFrameAnimationTimeDifferenceMs = jNow - this.lastFrameAnimationTimeMs;
            this.startMs = 0L;
            this.expectedRenderTimeMs = 0L;
            this.lastFrameAnimationTimeMs = -1L;
            this.lastDrawnFrameNumber = -1;
            this.running = false;
        }
    }

    public final int frameToDraw() {
        long jMax;
        long jNow = now();
        if (this.running) {
            jMax = (jNow - this.startMs) + this.frameSchedulingOffsetMs;
        } else {
            jMax = Math.max(this.lastFrameAnimationTimeMs, 0L);
        }
        int frameNumberToRender = this.frameScheduler.getFrameNumberToRender(jMax, this.lastFrameAnimationTimeMs);
        this.lastFrameAnimationTimeMs = jMax;
        return frameNumberToRender;
    }

    public final long nextRenderTime() {
        if (!this.running) {
            return -1L;
        }
        long targetRenderTimeForNextFrameMs = this.frameScheduler.getTargetRenderTimeForNextFrameMs(now() - this.startMs);
        if (targetRenderTimeForNextFrameMs != -1) {
            long j = targetRenderTimeForNextFrameMs + this.frameSchedulingDelayMs;
            this.expectedRenderTimeMs = this.startMs + j;
            return j;
        }
        this.running = false;
        return -1L;
    }

    public final boolean shouldRepeatAnimation() {
        return this.lastDrawnFrameNumber != -1 && now() >= this.expectedRenderTimeMs;
    }

    public final void onFrameDropped() {
        this.framesDropped++;
    }

    public final boolean infinite() {
        return this.frameScheduler.isInfiniteAnimation();
    }

    public final long loopDuration() {
        return this.frameScheduler.getLoopDurationMs();
    }
}
