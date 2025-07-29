package com.swmansion.rnscreens.bottomsheet;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.UIManagerModuleConstants;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.swmansion.rnscreens.InsetsObserverProxy;
import com.swmansion.rnscreens.KeyboardDidHide;
import com.swmansion.rnscreens.KeyboardNotVisible;
import com.swmansion.rnscreens.KeyboardState;
import com.swmansion.rnscreens.KeyboardVisible;
import com.swmansion.rnscreens.NativeDismissalObserver;
import com.swmansion.rnscreens.R;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.ScreenContainer;
import com.swmansion.rnscreens.ScreenFragment;
import com.swmansion.rnscreens.ScreenFragmentWrapper;
import com.swmansion.rnscreens.ScreenStack;
import com.swmansion.rnscreens.ScreenStackFragment;
import com.swmansion.rnscreens.ScreenStackFragmentWrapper;
import com.swmansion.rnscreens.bottomsheet.DimmingFragment;
import com.swmansion.rnscreens.events.ScreenDismissedEvent;
import io.sentry.protocol.Request;
import io.sentry.protocol.ViewHierarchyNode;
import io.sentry.rrweb.RRWebVideoEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: DimmingFragment.kt */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 u2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0002tuB\r\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010-\u001a\u00020.2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u001fH\u0016J\b\u00103\u001a\u00020.H\u0002J\b\u00104\u001a\u00020.H\u0016J\u0012\u00105\u001a\u00020.2\b\b\u0002\u00106\u001a\u00020\u001fH\u0002J\b\u00107\u001a\u00020.H\u0016J\u0018\u00108\u001a\u00020.2\u0006\u00100\u001a\u0002012\u0006\u00109\u001a\u00020\bH\u0016J\u0010\u0010:\u001a\u00020.2\u0006\u00100\u001a\u000201H\u0016J\u0018\u0010;\u001a\u00020.2\u0006\u0010<\u001a\u00020#2\u0006\u0010=\u001a\u00020\u001fH\u0016J\b\u0010>\u001a\u00020.H\u0002J\b\u0010?\u001a\u00020.H\u0002J\b\u0010@\u001a\u00020.H\u0002J\u0012\u0010A\u001a\u00020.2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u0012\u0010D\u001a\u00020.2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u0012\u0010E\u001a\u00020.2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u0018\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020GH\u0016J\b\u0010K\u001a\u00020.H\u0016J\"\u0010L\u001a\u0004\u0018\u00010C2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u001f2\u0006\u0010P\u001a\u00020NH\u0016J$\u0010Q\u001a\u00020I2\u0006\u0010R\u001a\u00020S2\b\u0010\u000f\u001a\u0004\u0018\u00010T2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\u0010\u0010W\u001a\u00020.2\u0006\u0010X\u001a\u00020\u0003H\u0016J\b\u0010Y\u001a\u00020.H\u0016J\b\u0010Z\u001a\u00020.H\u0016J\b\u0010[\u001a\u00020.H\u0016J\u0018\u0010\\\u001a\u00020.2\u0006\u0010]\u001a\u00020^2\u0006\u00100\u001a\u00020_H\u0016J\b\u0010`\u001a\u00020.H\u0016J\b\u0010a\u001a\u00020.H\u0016J\u001a\u0010b\u001a\u00020.2\u0006\u0010c\u001a\u00020I2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\b\u0010d\u001a\u00020.H\u0002J\u0010\u0010e\u001a\u00020.2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010f\u001a\u00020.H\u0016J\b\u0010g\u001a\u00020IH\u0002J\u0010\u0010h\u001a\u00020.2\u0006\u0010i\u001a\u00020jH\u0016J\u0010\u0010k\u001a\u00020.2\u0006\u0010l\u001a\u00020\u001fH\u0016J\u0010\u0010m\u001a\u00020.2\u0006\u0010n\u001a\u00020\u001fH\u0016J\n\u0010o\u001a\u0004\u0018\u00010pH\u0016J\n\u0010q\u001a\u0004\u0018\u00010rH\u0016J\u0010\u0010s\u001a\u00020.2\u0006\u00100\u001a\u000201H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R$\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020'8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006v"}, d2 = {"Lcom/swmansion/rnscreens/bottomsheet/DimmingFragment;", "Landroidx/fragment/app/Fragment;", "Landroidx/lifecycle/LifecycleEventObserver;", "Lcom/swmansion/rnscreens/ScreenStackFragmentWrapper;", "Landroid/view/animation/Animation$AnimationListener;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "Lcom/swmansion/rnscreens/NativeDismissalObserver;", "nestedFragment", "Lcom/swmansion/rnscreens/ScreenFragmentWrapper;", "(Lcom/swmansion/rnscreens/ScreenFragmentWrapper;)V", "childScreenContainers", "", "Lcom/swmansion/rnscreens/ScreenContainer;", "getChildScreenContainers", "()Ljava/util/List;", RRWebVideoEvent.JsonKeys.CONTAINER, "Lcom/swmansion/rnscreens/ScreenStack;", "getContainer", "()Lcom/swmansion/rnscreens/ScreenStack;", "containerView", "Lcom/swmansion/rnscreens/bottomsheet/GestureTransparentViewGroup;", "dimmingView", "Lcom/swmansion/rnscreens/bottomsheet/DimmingView;", "dimmingViewCallback", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", Request.JsonKeys.FRAGMENT, "getFragment", "()Landroidx/fragment/app/Fragment;", "insetsProxy", "Lcom/swmansion/rnscreens/InsetsObserverProxy;", "isKeyboardVisible", "", "keyboardState", "Lcom/swmansion/rnscreens/KeyboardState;", "maxAlpha", "", "getNestedFragment", "()Lcom/swmansion/rnscreens/ScreenFragmentWrapper;", "value", "Lcom/swmansion/rnscreens/Screen;", "screen", "getScreen", "()Lcom/swmansion/rnscreens/Screen;", "setScreen", "(Lcom/swmansion/rnscreens/Screen;)V", "addChildScreenContainer", "", "canDispatchLifecycleEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/swmansion/rnscreens/ScreenFragment$ScreenLifecycleEvent;", "canNavigateBack", "cleanRegisteredCallbacks", "dismissFromContainer", "dismissSelf", "emitDismissedEvent", "dispatchHeaderBackButtonClickedEvent", "dispatchLifecycleEvent", "fragmentWrapper", "dispatchLifecycleEventInChildContainers", "dispatchTransitionProgressEvent", ViewHierarchyNode.JsonKeys.ALPHA, "closing", "initContainerView", "initDimmingView", "initViewHierarchy", "onAnimationEnd", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "onApplyWindowInsets", "Landroidx/core/view/WindowInsetsCompat;", "v", "Landroid/view/View;", "insets", "onContainerUpdate", "onCreateAnimation", "transit", "", "enter", "nextAnim", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onNativeDismiss", UIManagerModuleConstants.ACTION_DISMISSED, "onPause", "onResume", "onStart", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/Lifecycle$Event;", "onViewAnimationEnd", "onViewAnimationStart", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "presentNestedFragment", "removeChildScreenContainer", "removeToolbar", "requireDecorView", "setToolbar", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "setToolbarShadowHidden", ViewProps.HIDDEN, "setToolbarTranslucent", "translucent", "tryGetActivity", "Landroid/app/Activity;", "tryGetContext", "Lcom/facebook/react/bridge/ReactContext;", "updateLastEventDispatched", "AnimateDimmingViewCallback", "Companion", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DimmingFragment extends Fragment implements LifecycleEventObserver, ScreenStackFragmentWrapper, Animation.AnimationListener, OnApplyWindowInsetsListener, NativeDismissalObserver {
    public static final String TAG = "DimmingFragment";
    private final List<ScreenContainer> childScreenContainers;
    private GestureTransparentViewGroup containerView;
    private DimmingView dimmingView;
    private BottomSheetBehavior.BottomSheetCallback dimmingViewCallback;
    private final InsetsObserverProxy insetsProxy;
    private boolean isKeyboardVisible;
    private KeyboardState keyboardState;
    private final float maxAlpha;
    private final ScreenFragmentWrapper nestedFragment;

    /* compiled from: DimmingFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.swmansion.rnscreens.ScreenStackFragmentWrapper
    public boolean canNavigateBack() {
        return true;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // com.swmansion.rnscreens.ScreenStackFragmentWrapper
    public void removeToolbar() {
    }

    @Override // com.swmansion.rnscreens.ScreenStackFragmentWrapper
    public void setToolbar(Toolbar toolbar) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
    }

    @Override // com.swmansion.rnscreens.ScreenStackFragmentWrapper
    public void setToolbarShadowHidden(boolean hidden) {
    }

    @Override // com.swmansion.rnscreens.ScreenStackFragmentWrapper
    public void setToolbarTranslucent(boolean translucent) {
    }

    public final ScreenFragmentWrapper getNestedFragment() {
        return this.nestedFragment;
    }

    public DimmingFragment(ScreenFragmentWrapper nestedFragment) {
        Intrinsics.checkNotNullParameter(nestedFragment, "nestedFragment");
        this.nestedFragment = nestedFragment;
        this.maxAlpha = 0.15f;
        this.keyboardState = KeyboardNotVisible.INSTANCE;
        this.insetsProxy = InsetsObserverProxy.INSTANCE;
        boolean z = nestedFragment.getFragment() instanceof ScreenStackFragment;
        Fragment fragment = nestedFragment.getFragment();
        Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.swmansion.rnscreens.ScreenStackFragment");
        ScreenStackFragment screenStackFragment = (ScreenStackFragment) fragment;
        screenStackFragment.getLifecycle().addObserver(this);
        screenStackFragment.setNativeDismissalObserver(this);
        this.childScreenContainers = nestedFragment.getChildScreenContainers();
    }

    private final ScreenStack getContainer() {
        ScreenContainer container = getScreen().getContainer();
        if (container instanceof ScreenStack) {
            return (ScreenStack) container;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DimmingFragment.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0017H\u0016R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/swmansion/rnscreens/bottomsheet/DimmingFragment$AnimateDimmingViewCallback;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "screen", "Lcom/swmansion/rnscreens/Screen;", "viewToAnimate", "Landroid/view/View;", "maxAlpha", "", "(Lcom/swmansion/rnscreens/Screen;Landroid/view/View;F)V", "animator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "firstDimmedOffset", "intervalLength", "largestUndimmedOffset", "getMaxAlpha", "()F", "getScreen", "()Lcom/swmansion/rnscreens/Screen;", "getViewToAnimate", "()Landroid/view/View;", "computeOffsetFromDetentIndex", FirebaseAnalytics.Param.INDEX, "", "onSlide", "", "bottomSheet", "slideOffset", "onStateChanged", "newState", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    static final class AnimateDimmingViewCallback extends BottomSheetBehavior.BottomSheetCallback {
        private final ValueAnimator animator;
        private float firstDimmedOffset;
        private float intervalLength;
        private float largestUndimmedOffset;
        private final float maxAlpha;
        private final Screen screen;
        private final View viewToAnimate;

        public final Screen getScreen() {
            return this.screen;
        }

        public final View getViewToAnimate() {
            return this.viewToAnimate;
        }

        public final float getMaxAlpha() {
            return this.maxAlpha;
        }

        public AnimateDimmingViewCallback(Screen screen, View viewToAnimate, float f) {
            Intrinsics.checkNotNullParameter(screen, "screen");
            Intrinsics.checkNotNullParameter(viewToAnimate, "viewToAnimate");
            this.screen = screen;
            this.viewToAnimate = viewToAnimate;
            this.maxAlpha = f;
            this.largestUndimmedOffset = computeOffsetFromDetentIndex(screen.getSheetLargestUndimmedDetentIndex());
            float fComputeOffsetFromDetentIndex = computeOffsetFromDetentIndex(RangesKt.coerceIn(screen.getSheetLargestUndimmedDetentIndex() + 1, 0, screen.getSheetDetents().size() - 1));
            this.firstDimmedOffset = fComputeOffsetFromDetentIndex;
            this.intervalLength = fComputeOffsetFromDetentIndex - this.largestUndimmedOffset;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, f);
            valueAnimatorOfFloat.setDuration(1L);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.swmansion.rnscreens.bottomsheet.DimmingFragment$AnimateDimmingViewCallback$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    DimmingFragment.AnimateDimmingViewCallback.animator$lambda$1$lambda$0(this.f$0, valueAnimator);
                }
            });
            this.animator = valueAnimatorOfFloat;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void animator$lambda$1$lambda$0(AnimateDimmingViewCallback this$0, ValueAnimator it) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(it, "it");
            View view = this$0.viewToAnimate;
            Object animatedValue = it.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            view.setAlpha(((Float) animatedValue).floatValue());
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View bottomSheet, int newState) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (newState == 1 || newState == 2) {
                this.largestUndimmedOffset = computeOffsetFromDetentIndex(this.screen.getSheetLargestUndimmedDetentIndex());
                float fComputeOffsetFromDetentIndex = computeOffsetFromDetentIndex(RangesKt.coerceIn(this.screen.getSheetLargestUndimmedDetentIndex() + 1, 0, this.screen.getSheetDetents().size() - 1));
                this.firstDimmedOffset = fComputeOffsetFromDetentIndex;
                this.intervalLength = fComputeOffsetFromDetentIndex - this.largestUndimmedOffset;
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View bottomSheet, float slideOffset) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            float f = this.largestUndimmedOffset;
            if (f >= slideOffset || slideOffset >= this.firstDimmedOffset) {
                return;
            }
            this.animator.setCurrentFraction((slideOffset - f) / this.intervalLength);
        }

        private final float computeOffsetFromDetentIndex(int index) {
            int size = this.screen.getSheetDetents().size();
            if (size != 1) {
                if (size != 2) {
                    if (size == 3 && index != -1) {
                        if (index != 0) {
                            if (index == 1) {
                                BottomSheetBehavior<Screen> sheetBehavior = this.screen.getSheetBehavior();
                                Intrinsics.checkNotNull(sheetBehavior);
                                return sheetBehavior.getHalfExpandedRatio();
                            }
                            if (index == 2) {
                                return 1.0f;
                            }
                        }
                        return 0.0f;
                    }
                } else if (index != -1) {
                    if (index != 0) {
                        if (index == 1) {
                            return 1.0f;
                        }
                    }
                    return 0.0f;
                }
            } else if (index != -1 && index == 0) {
                return 1.0f;
            }
            return -1.0f;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return AnimationUtils.loadAnimation(getContext(), enter ? R.anim.rns_fade_in : R.anim.rns_fade_out);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        initViewHierarchy();
        GestureTransparentViewGroup gestureTransparentViewGroup = this.containerView;
        if (gestureTransparentViewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            gestureTransparentViewGroup = null;
        }
        return gestureTransparentViewGroup;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        DimmingView dimmingView = null;
        if (getScreen().getSheetInitialDetentIndex() <= getScreen().getSheetLargestUndimmedDetentIndex()) {
            DimmingView dimmingView2 = this.dimmingView;
            if (dimmingView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dimmingView");
            } else {
                dimmingView = dimmingView2;
            }
            dimmingView.setAlpha(0.0f);
            return;
        }
        DimmingView dimmingView3 = this.dimmingView;
        if (dimmingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dimmingView");
        } else {
            dimmingView = dimmingView3;
        }
        dimmingView.setAlpha(this.maxAlpha);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.insetsProxy.registerOnView(requireDecorView());
        presentNestedFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        this.insetsProxy.addOnApplyWindowInsetsListener(this);
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.insetsProxy.removeOnApplyWindowInsetsListener(this);
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        BottomSheetBehavior<Screen> sheetBehavior;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (WhenMappings.$EnumSwitchMapping$0[event.ordinal()] != 1 || (sheetBehavior = this.nestedFragment.getScreen().getSheetBehavior()) == null) {
            return;
        }
        Screen screen = this.nestedFragment.getScreen();
        DimmingView dimmingView = this.dimmingView;
        if (dimmingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dimmingView");
            dimmingView = null;
        }
        AnimateDimmingViewCallback animateDimmingViewCallback = new AnimateDimmingViewCallback(screen, dimmingView, this.maxAlpha);
        this.dimmingViewCallback = animateDimmingViewCallback;
        Intrinsics.checkNotNull(animateDimmingViewCallback);
        sheetBehavior.addBottomSheetCallback(animateDimmingViewCallback);
    }

    private final void presentNestedFragment() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction()");
        fragmentTransactionBeginTransaction.setReorderingAllowed(true);
        fragmentTransactionBeginTransaction.add(requireView().getId(), this.nestedFragment.getFragment(), (String) null);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    private final void cleanRegisteredCallbacks() {
        BottomSheetBehavior<Screen> sheetBehavior;
        BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = this.dimmingViewCallback;
        if (bottomSheetCallback != null && (sheetBehavior = this.nestedFragment.getScreen().getSheetBehavior()) != null) {
            sheetBehavior.removeBottomSheetCallback(bottomSheetCallback);
        }
        DimmingView dimmingView = this.dimmingView;
        if (dimmingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dimmingView");
            dimmingView = null;
        }
        dimmingView.setOnClickListener(null);
        this.nestedFragment.getFragment().getLifecycle().removeObserver(this);
        this.insetsProxy.removeOnApplyWindowInsetsListener(this);
    }

    static /* synthetic */ void dismissSelf$default(DimmingFragment dimmingFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        dimmingFragment.dismissSelf(z);
    }

    private final void dismissSelf(boolean emitDismissedEvent) {
        if (isRemoving()) {
            return;
        }
        if (emitDismissedEvent) {
            ReactContext reactContext = this.nestedFragment.getScreen().getReactContext();
            int surfaceId = UIManagerHelper.getSurfaceId(reactContext);
            EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, getScreen().getId());
            if (eventDispatcherForReactTag != null) {
                eventDispatcherForReactTag.dispatchEvent(new ScreenDismissedEvent(surfaceId, getScreen().getId()));
            }
        }
        cleanRegisteredCallbacks();
        dismissFromContainer();
    }

    private final void initViewHierarchy() {
        initContainerView();
        initDimmingView();
        GestureTransparentViewGroup gestureTransparentViewGroup = this.containerView;
        DimmingView dimmingView = null;
        if (gestureTransparentViewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            gestureTransparentViewGroup = null;
        }
        DimmingView dimmingView2 = this.dimmingView;
        if (dimmingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dimmingView");
        } else {
            dimmingView = dimmingView2;
        }
        gestureTransparentViewGroup.addView(dimmingView);
    }

    private final void initContainerView() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        GestureTransparentViewGroup gestureTransparentViewGroup = new GestureTransparentViewGroup(contextRequireContext);
        gestureTransparentViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        gestureTransparentViewGroup.setBackgroundColor(0);
        gestureTransparentViewGroup.setId(View.generateViewId());
        this.containerView = gestureTransparentViewGroup;
    }

    private final void initDimmingView() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        DimmingView dimmingView = new DimmingView(contextRequireContext, this.maxAlpha);
        dimmingView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        dimmingView.setOnClickListener(new View.OnClickListener() { // from class: com.swmansion.rnscreens.bottomsheet.DimmingFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DimmingFragment.initDimmingView$lambda$6$lambda$5(this.f$0, view);
            }
        });
        this.dimmingView = dimmingView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDimmingView$lambda$6$lambda$5(DimmingFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getScreen().getSheetClosesOnTouchOutside()) {
            this$0.dismissSelf(true);
        }
    }

    private final View requireDecorView() {
        Activity currentActivity = getScreen().getReactContext().getCurrentActivity();
        if (currentActivity == null) {
            throw new IllegalStateException("[RNScreens] Attempt to access activity on detached context".toString());
        }
        View decorView = currentActivity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        return decorView;
    }

    @Override // com.swmansion.rnscreens.ScreenStackFragmentWrapper
    public void dismissFromContainer() {
        ScreenStack container = getContainer();
        if (container != null) {
            container.dismiss(this);
        }
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public Screen getScreen() {
        return this.nestedFragment.getScreen();
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public void setScreen(Screen value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.nestedFragment.setScreen(value);
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public List<ScreenContainer> getChildScreenContainers() {
        return this.childScreenContainers;
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public void addChildScreenContainer(ScreenContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.nestedFragment.addChildScreenContainer(container);
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public void removeChildScreenContainer(ScreenContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.nestedFragment.removeChildScreenContainer(container);
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public void onContainerUpdate() {
        this.nestedFragment.onContainerUpdate();
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public void onViewAnimationStart() {
        this.nestedFragment.onViewAnimationStart();
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public void onViewAnimationEnd() {
        this.nestedFragment.onViewAnimationEnd();
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public Activity tryGetActivity() {
        return getActivity();
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public ReactContext tryGetContext() {
        Context context = getContext();
        if (context instanceof ReactContext) {
            return (ReactContext) context;
        }
        return null;
    }

    @Override // com.swmansion.rnscreens.FragmentHolder
    public Fragment getFragment() {
        return this;
    }

    @Override // com.swmansion.rnscreens.ScreenEventDispatcher
    public boolean canDispatchLifecycleEvent(ScreenFragment.ScreenLifecycleEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.swmansion.rnscreens.ScreenEventDispatcher
    public void updateLastEventDispatched(ScreenFragment.ScreenLifecycleEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.swmansion.rnscreens.ScreenEventDispatcher
    public void dispatchLifecycleEvent(ScreenFragment.ScreenLifecycleEvent event, ScreenFragmentWrapper fragmentWrapper) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(fragmentWrapper, "fragmentWrapper");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.swmansion.rnscreens.ScreenEventDispatcher
    public void dispatchLifecycleEventInChildContainers(ScreenFragment.ScreenLifecycleEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.swmansion.rnscreens.ScreenEventDispatcher
    public void dispatchHeaderBackButtonClickedEvent() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.swmansion.rnscreens.ScreenEventDispatcher
    public void dispatchTransitionProgressEvent(float alpha, boolean closing) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        dismissFromContainer();
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        boolean zIsVisible = insets.isVisible(WindowInsetsCompat.Type.ime());
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.ime());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        if (zIsVisible) {
            this.isKeyboardVisible = true;
            this.keyboardState = new KeyboardVisible(insets2.bottom);
            BottomSheetBehavior<Screen> sheetBehavior = getScreen().getSheetBehavior();
            if (sheetBehavior != null) {
                ScreenFragmentWrapper screenFragmentWrapper = this.nestedFragment;
                Intrinsics.checkNotNull(screenFragmentWrapper, "null cannot be cast to non-null type com.swmansion.rnscreens.ScreenStackFragment");
                ((ScreenStackFragment) screenFragmentWrapper).configureBottomSheetBehaviour$react_native_screens_release(sheetBehavior, new KeyboardVisible(insets2.bottom));
            }
            if (isRemoving()) {
                return insets;
            }
            Insets insets3 = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            Intrinsics.checkNotNullExpressionValue(insets3, "getInsets(...)");
            WindowInsetsCompat windowInsetsCompatBuild = new WindowInsetsCompat.Builder(insets).setInsets(WindowInsetsCompat.Type.navigationBars(), Insets.of(insets3.left, insets3.top, insets3.right, 0)).build();
            Intrinsics.checkNotNullExpressionValue(windowInsetsCompatBuild, "build(...)");
            return windowInsetsCompatBuild;
        }
        if (isRemoving()) {
            Insets insets4 = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            Intrinsics.checkNotNullExpressionValue(insets4, "getInsets(...)");
            WindowInsetsCompat windowInsetsCompatBuild2 = new WindowInsetsCompat.Builder(insets).setInsets(WindowInsetsCompat.Type.navigationBars(), Insets.of(insets4.left, insets4.top, insets4.right, 0)).build();
            Intrinsics.checkNotNullExpressionValue(windowInsetsCompatBuild2, "build(...)");
            return windowInsetsCompatBuild2;
        }
        BottomSheetBehavior<Screen> sheetBehavior2 = getScreen().getSheetBehavior();
        if (sheetBehavior2 != null) {
            if (this.isKeyboardVisible) {
                ScreenFragmentWrapper screenFragmentWrapper2 = this.nestedFragment;
                Intrinsics.checkNotNull(screenFragmentWrapper2, "null cannot be cast to non-null type com.swmansion.rnscreens.ScreenStackFragment");
                ((ScreenStackFragment) screenFragmentWrapper2).configureBottomSheetBehaviour$react_native_screens_release(sheetBehavior2, KeyboardDidHide.INSTANCE);
            } else if (!Intrinsics.areEqual(this.keyboardState, KeyboardNotVisible.INSTANCE)) {
                ScreenFragmentWrapper screenFragmentWrapper3 = this.nestedFragment;
                Intrinsics.checkNotNull(screenFragmentWrapper3, "null cannot be cast to non-null type com.swmansion.rnscreens.ScreenStackFragment");
                ((ScreenStackFragment) screenFragmentWrapper3).configureBottomSheetBehaviour$react_native_screens_release(sheetBehavior2, KeyboardNotVisible.INSTANCE);
            }
        }
        this.keyboardState = KeyboardNotVisible.INSTANCE;
        this.isKeyboardVisible = false;
        Insets insets5 = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
        Intrinsics.checkNotNullExpressionValue(insets5, "getInsets(...)");
        WindowInsetsCompat windowInsetsCompatBuild3 = new WindowInsetsCompat.Builder(insets).setInsets(WindowInsetsCompat.Type.navigationBars(), Insets.of(insets5.left, insets5.top, insets5.right, 0)).build();
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompatBuild3, "build(...)");
        return windowInsetsCompatBuild3;
    }

    @Override // com.swmansion.rnscreens.NativeDismissalObserver
    public void onNativeDismiss(ScreenStackFragmentWrapper dismissed) {
        Intrinsics.checkNotNullParameter(dismissed, "dismissed");
        dismissSelf(true);
    }
}
