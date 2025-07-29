package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.BaseInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.IllegalViewOperationException;
import java.util.Map;

/* loaded from: classes4.dex */
abstract class AbstractLayoutAnimation {
    private static final Map<InterpolatorType, BaseInterpolator> INTERPOLATOR = MapBuilder.of(InterpolatorType.LINEAR, new LinearInterpolator(), InterpolatorType.EASE_IN, new AccelerateInterpolator(), InterpolatorType.EASE_OUT, new DecelerateInterpolator(), InterpolatorType.EASE_IN_EASE_OUT, new AccelerateDecelerateInterpolator());
    private static final boolean SLOWDOWN_ANIMATION_MODE = false;
    protected AnimatedPropertyType mAnimatedProperty;
    private int mDelayMs;
    protected int mDurationMs;
    private Interpolator mInterpolator;

    abstract Animation createAnimationImpl(View view, int i, int i2, int i3, int i4);

    abstract boolean isValid();

    AbstractLayoutAnimation() {
    }

    public void reset() {
        this.mAnimatedProperty = null;
        this.mDurationMs = 0;
        this.mDelayMs = 0;
        this.mInterpolator = null;
    }

    public void initializeFromConfig(ReadableMap readableMap, int i) {
        this.mAnimatedProperty = readableMap.hasKey("property") ? AnimatedPropertyType.fromString(readableMap.getString("property")) : null;
        if (readableMap.hasKey("duration")) {
            i = readableMap.getInt("duration");
        }
        this.mDurationMs = i;
        this.mDelayMs = readableMap.hasKey("delay") ? readableMap.getInt("delay") : 0;
        if (!readableMap.hasKey("type")) {
            throw new IllegalArgumentException("Missing interpolation type.");
        }
        this.mInterpolator = getInterpolator(InterpolatorType.fromString(readableMap.getString("type")), readableMap);
        if (!isValid()) {
            throw new IllegalViewOperationException("Invalid layout animation : " + readableMap);
        }
    }

    public final Animation createAnimation(View view, int i, int i2, int i3, int i4) {
        if (!isValid()) {
            return null;
        }
        Animation animationCreateAnimationImpl = createAnimationImpl(view, i, i2, i3, i4);
        if (animationCreateAnimationImpl != null) {
            animationCreateAnimationImpl.setDuration(this.mDurationMs);
            animationCreateAnimationImpl.setStartOffset(this.mDelayMs);
            animationCreateAnimationImpl.setInterpolator(this.mInterpolator);
        }
        return animationCreateAnimationImpl;
    }

    private static Interpolator getInterpolator(InterpolatorType interpolatorType, ReadableMap readableMap) {
        BaseInterpolator simpleSpringInterpolator;
        if (interpolatorType.equals(InterpolatorType.SPRING)) {
            simpleSpringInterpolator = new SimpleSpringInterpolator(SimpleSpringInterpolator.getSpringDamping(readableMap));
        } else {
            simpleSpringInterpolator = INTERPOLATOR.get(interpolatorType);
        }
        if (simpleSpringInterpolator != null) {
            return simpleSpringInterpolator;
        }
        throw new IllegalArgumentException("Missing interpolator for type : " + interpolatorType);
    }
}
