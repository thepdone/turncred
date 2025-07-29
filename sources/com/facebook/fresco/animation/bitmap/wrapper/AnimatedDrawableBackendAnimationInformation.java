package com.facebook.fresco.animation.bitmap.wrapper;

import com.facebook.fresco.animation.backend.AnimationInformation;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;

/* loaded from: classes4.dex */
public class AnimatedDrawableBackendAnimationInformation implements AnimationInformation {
    private final AnimatedDrawableBackend mAnimatedDrawableBackend;

    public AnimatedDrawableBackendAnimationInformation(AnimatedDrawableBackend animatedDrawableBackend) {
        this.mAnimatedDrawableBackend = animatedDrawableBackend;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        return this.mAnimatedDrawableBackend.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int i) {
        return this.mAnimatedDrawableBackend.getDurationMsForFrame(i);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        return this.mAnimatedDrawableBackend.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopDurationMs() {
        return this.mAnimatedDrawableBackend.getDurationMs();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int width() {
        return this.mAnimatedDrawableBackend.getWidth();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int height() {
        return this.mAnimatedDrawableBackend.getHeight();
    }
}
