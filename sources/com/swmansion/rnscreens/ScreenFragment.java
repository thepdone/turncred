package com.swmansion.rnscreens;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.rnscreens.bottomsheet.DimmingFragment;
import com.swmansion.rnscreens.events.HeaderBackButtonClickedEvent;
import com.swmansion.rnscreens.events.ScreenAppearEvent;
import com.swmansion.rnscreens.events.ScreenDisappearEvent;
import com.swmansion.rnscreens.events.ScreenDismissedEvent;
import com.swmansion.rnscreens.events.ScreenTransitionProgressEvent;
import com.swmansion.rnscreens.events.ScreenWillAppearEvent;
import com.swmansion.rnscreens.events.ScreenWillDisappearEvent;
import com.swmansion.rnscreens.ext.ViewExtKt;
import io.sentry.protocol.Request;
import io.sentry.protocol.ViewHierarchyNode;
import io.sentry.rrweb.RRWebVideoEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScreenFragment.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0003ABCB\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\fH\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u001cH\u0016J\u0018\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0002H\u0016J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010%\u001a\u00020\u001cH\u0002J\b\u0010&\u001a\u00020\u001cH\u0002J\b\u0010'\u001a\u00020\u001cH\u0002J\b\u0010(\u001a\u00020\u001cH\u0002J\u0018\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\bH\u0016J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\bH\u0002J\b\u0010.\u001a\u00020\u001cH\u0016J&\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\b\u0010\u001d\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00106\u001a\u00020\u001cH\u0016J\b\u00107\u001a\u00020\u001cH\u0016J\b\u00108\u001a\u00020\u001cH\u0016J\b\u00109\u001a\u00020\u001cH\u0016J\u0010\u0010:\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\fH\u0016J\n\u0010;\u001a\u0004\u0018\u00010<H\u0016J\n\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0010\u0010?\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010@\u001a\u00020\u001cH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u00020\u0005X\u0096.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0006R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/swmansion/rnscreens/ScreenFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/swmansion/rnscreens/ScreenFragmentWrapper;", "()V", "screenView", "Lcom/swmansion/rnscreens/Screen;", "(Lcom/swmansion/rnscreens/Screen;)V", "canDispatchAppear", "", "canDispatchWillAppear", "childScreenContainers", "", "Lcom/swmansion/rnscreens/ScreenContainer;", "getChildScreenContainers", "()Ljava/util/List;", Request.JsonKeys.FRAGMENT, "getFragment", "()Landroidx/fragment/app/Fragment;", "isTransitioning", "screen", "getScreen$annotations", "getScreen", "()Lcom/swmansion/rnscreens/Screen;", "setScreen", "shouldUpdateOnResume", "transitionProgress", "", "addChildScreenContainer", "", RRWebVideoEvent.JsonKeys.CONTAINER, "canDispatchLifecycleEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/swmansion/rnscreens/ScreenFragment$ScreenLifecycleEvent;", "dispatchHeaderBackButtonClickedEvent", "dispatchLifecycleEvent", "fragmentWrapper", "dispatchLifecycleEventInChildContainers", "dispatchOnAppear", "dispatchOnDisappear", "dispatchOnWillAppear", "dispatchOnWillDisappear", "dispatchTransitionProgressEvent", ViewHierarchyNode.JsonKeys.ALPHA, "closing", "dispatchViewAnimationEvent", "animationEnd", "onContainerUpdate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onViewAnimationEnd", "onViewAnimationStart", "removeChildScreenContainer", "tryGetActivity", "Landroid/app/Activity;", "tryGetContext", "Lcom/facebook/react/bridge/ReactContext;", "updateLastEventDispatched", "updateWindowTraits", "Companion", "ScreenLifecycleEvent", "ScreensFrameLayout", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class ScreenFragment extends Fragment implements ScreenFragmentWrapper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "ScreenFragment";
    private boolean canDispatchAppear;
    private boolean canDispatchWillAppear;
    private final List<ScreenContainer> childScreenContainers;
    private boolean isTransitioning;
    public Screen screen;
    private boolean shouldUpdateOnResume;
    private float transitionProgress;

    /* compiled from: ScreenFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScreenLifecycleEvent.values().length];
            try {
                iArr[ScreenLifecycleEvent.WILL_APPEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScreenLifecycleEvent.DID_APPEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScreenLifecycleEvent.WILL_DISAPPEAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ScreenLifecycleEvent.DID_DISAPPEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getScreen$annotations() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: ScreenFragment.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/swmansion/rnscreens/ScreenFragment$ScreenLifecycleEvent;", "", "(Ljava/lang/String;I)V", "DID_APPEAR", "WILL_APPEAR", "DID_DISAPPEAR", "WILL_DISAPPEAR", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ScreenLifecycleEvent {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ScreenLifecycleEvent[] $VALUES;
        public static final ScreenLifecycleEvent DID_APPEAR = new ScreenLifecycleEvent("DID_APPEAR", 0);
        public static final ScreenLifecycleEvent WILL_APPEAR = new ScreenLifecycleEvent("WILL_APPEAR", 1);
        public static final ScreenLifecycleEvent DID_DISAPPEAR = new ScreenLifecycleEvent("DID_DISAPPEAR", 2);
        public static final ScreenLifecycleEvent WILL_DISAPPEAR = new ScreenLifecycleEvent("WILL_DISAPPEAR", 3);

        private static final /* synthetic */ ScreenLifecycleEvent[] $values() {
            return new ScreenLifecycleEvent[]{DID_APPEAR, WILL_APPEAR, DID_DISAPPEAR, WILL_DISAPPEAR};
        }

        public static EnumEntries<ScreenLifecycleEvent> getEntries() {
            return $ENTRIES;
        }

        public static ScreenLifecycleEvent valueOf(String str) {
            return (ScreenLifecycleEvent) Enum.valueOf(ScreenLifecycleEvent.class, str);
        }

        public static ScreenLifecycleEvent[] values() {
            return (ScreenLifecycleEvent[]) $VALUES.clone();
        }

        private ScreenLifecycleEvent(String str, int i) {
        }

        static {
            ScreenLifecycleEvent[] screenLifecycleEventArr$values = $values();
            $VALUES = screenLifecycleEventArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(screenLifecycleEventArr$values);
        }
    }

    @Override // com.swmansion.rnscreens.FragmentHolder
    public Fragment getFragment() {
        return this;
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public Screen getScreen() {
        Screen screen = this.screen;
        if (screen != null) {
            return screen;
        }
        Intrinsics.throwUninitializedPropertyAccessException("screen");
        return null;
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public void setScreen(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "<set-?>");
        this.screen = screen;
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public List<ScreenContainer> getChildScreenContainers() {
        return this.childScreenContainers;
    }

    public ScreenFragment() {
        this.childScreenContainers = new ArrayList();
        this.transitionProgress = -1.0f;
        this.canDispatchWillAppear = true;
        this.canDispatchAppear = true;
        throw new IllegalStateException("Screen fragments should never be restored. Follow instructions from https://github.com/software-mansion/react-native-screens/issues/17#issuecomment-424704067 to properly configure your main activity.");
    }

    public ScreenFragment(Screen screenView) {
        Intrinsics.checkNotNullParameter(screenView, "screenView");
        this.childScreenContainers = new ArrayList();
        this.transitionProgress = -1.0f;
        this.canDispatchWillAppear = true;
        this.canDispatchAppear = true;
        setScreen(screenView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.shouldUpdateOnResume) {
            this.shouldUpdateOnResume = false;
            ScreenWindowTraits.INSTANCE.trySetWindowTraits$react_native_screens_release(getScreen(), tryGetActivity(), tryGetContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ScreensFrameLayout screensFrameLayout;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        getScreen().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Context context = getContext();
        if (context != null) {
            screensFrameLayout = new ScreensFrameLayout(context);
            screensFrameLayout.addView(ViewExtKt.recycle(getScreen()));
        } else {
            screensFrameLayout = null;
        }
        return screensFrameLayout;
    }

    /* compiled from: ScreenFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/swmansion/rnscreens/ScreenFragment$ScreensFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "clearFocus", "", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class ScreensFrameLayout extends FrameLayout {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScreensFrameLayout(Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        @Override // android.view.ViewGroup, android.view.View
        public void clearFocus() {
            if (getVisibility() != 4) {
                super.clearFocus();
            }
        }
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public void onContainerUpdate() {
        updateWindowTraits();
    }

    private final void updateWindowTraits() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            this.shouldUpdateOnResume = true;
        } else {
            ScreenWindowTraits.INSTANCE.trySetWindowTraits$react_native_screens_release(getScreen(), activity, tryGetContext());
        }
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public Activity tryGetActivity() {
        Fragment fragment;
        FragmentActivity activity;
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            return activity2;
        }
        Context context = getScreen().getContext();
        if (context instanceof ReactContext) {
            ReactContext reactContext = (ReactContext) context;
            if (reactContext.getCurrentActivity() != null) {
                return reactContext.getCurrentActivity();
            }
        }
        for (ScreenContainer container = getScreen().getContainer(); container != null; container = container.getParent()) {
            if ((container instanceof Screen) && (fragment = ((Screen) container).getFragment()) != null && (activity = fragment.getActivity()) != null) {
                return activity;
            }
        }
        return null;
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public ReactContext tryGetContext() {
        if (getContext() instanceof ReactContext) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            return (ReactContext) context;
        }
        if (getScreen().getContext() instanceof ReactContext) {
            Context context2 = getScreen().getContext();
            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            return (ReactContext) context2;
        }
        for (ScreenContainer container = getScreen().getContainer(); container != null; container = container.getParent()) {
            if (container instanceof Screen) {
                Screen screen = (Screen) container;
                if (screen.getContext() instanceof ReactContext) {
                    Context context3 = screen.getContext();
                    Intrinsics.checkNotNull(context3, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                    return (ReactContext) context3;
                }
            }
        }
        return null;
    }

    @Override // com.swmansion.rnscreens.ScreenEventDispatcher
    public boolean canDispatchLifecycleEvent(ScreenLifecycleEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            return this.canDispatchWillAppear;
        }
        if (i == 2) {
            return this.canDispatchAppear;
        }
        if (i != 3) {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            if (!this.canDispatchAppear) {
                return true;
            }
        } else if (!this.canDispatchWillAppear) {
            return true;
        }
        return false;
    }

    @Override // com.swmansion.rnscreens.ScreenEventDispatcher
    public void updateLastEventDispatched(ScreenLifecycleEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            this.canDispatchWillAppear = false;
            return;
        }
        if (i == 2) {
            this.canDispatchAppear = false;
        } else if (i == 3) {
            this.canDispatchWillAppear = true;
        } else {
            if (i != 4) {
                return;
            }
            this.canDispatchAppear = true;
        }
    }

    private final void dispatchOnWillAppear() {
        dispatchLifecycleEvent(ScreenLifecycleEvent.WILL_APPEAR, this);
        dispatchTransitionProgressEvent(0.0f, false);
    }

    private final void dispatchOnAppear() {
        dispatchLifecycleEvent(ScreenLifecycleEvent.DID_APPEAR, this);
        dispatchTransitionProgressEvent(1.0f, false);
    }

    private final void dispatchOnWillDisappear() {
        dispatchLifecycleEvent(ScreenLifecycleEvent.WILL_DISAPPEAR, this);
        dispatchTransitionProgressEvent(0.0f, true);
    }

    private final void dispatchOnDisappear() {
        dispatchLifecycleEvent(ScreenLifecycleEvent.DID_DISAPPEAR, this);
        dispatchTransitionProgressEvent(1.0f, true);
    }

    @Override // com.swmansion.rnscreens.ScreenEventDispatcher
    public void dispatchLifecycleEvent(ScreenLifecycleEvent event, ScreenFragmentWrapper fragmentWrapper) {
        ScreenWillAppearEvent screenWillAppearEvent;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(fragmentWrapper, "fragmentWrapper");
        Fragment fragment = fragmentWrapper.getFragment();
        if (fragment instanceof ScreenStackFragment) {
            ScreenStackFragment screenStackFragment = (ScreenStackFragment) fragment;
            if (screenStackFragment.canDispatchLifecycleEvent(event)) {
                Screen screen = screenStackFragment.getScreen();
                fragmentWrapper.updateLastEventDispatched(event);
                int surfaceId = UIManagerHelper.getSurfaceId(screen);
                int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
                if (i == 1) {
                    screenWillAppearEvent = new ScreenWillAppearEvent(surfaceId, screen.getId());
                } else if (i == 2) {
                    screenWillAppearEvent = new ScreenAppearEvent(surfaceId, screen.getId());
                } else if (i == 3) {
                    screenWillAppearEvent = new ScreenWillDisappearEvent(surfaceId, screen.getId());
                } else {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    screenWillAppearEvent = new ScreenDisappearEvent(surfaceId, screen.getId());
                }
                Context context = getScreen().getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, getScreen().getId());
                if (eventDispatcherForReactTag != null) {
                    eventDispatcherForReactTag.dispatchEvent(screenWillAppearEvent);
                }
                fragmentWrapper.dispatchLifecycleEventInChildContainers(event);
            }
        }
    }

    @Override // com.swmansion.rnscreens.ScreenEventDispatcher
    public void dispatchLifecycleEventInChildContainers(ScreenLifecycleEvent event) {
        ScreenFragmentWrapper fragmentWrapper;
        Intrinsics.checkNotNullParameter(event, "event");
        List<ScreenContainer> childScreenContainers = getChildScreenContainers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : childScreenContainers) {
            if (((ScreenContainer) obj).getScreenCount() > 0) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Screen topScreen = ((ScreenContainer) it.next()).getTopScreen();
            if (topScreen != null && (fragmentWrapper = topScreen.getFragmentWrapper()) != null) {
                dispatchLifecycleEvent(event, fragmentWrapper);
            }
        }
    }

    @Override // com.swmansion.rnscreens.ScreenEventDispatcher
    public void dispatchHeaderBackButtonClickedEvent() {
        Context context = getScreen().getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        int surfaceId = UIManagerHelper.getSurfaceId(reactContext);
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, getScreen().getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new HeaderBackButtonClickedEvent(surfaceId, getScreen().getId()));
        }
    }

    @Override // com.swmansion.rnscreens.ScreenEventDispatcher
    public void dispatchTransitionProgressEvent(float alpha, boolean closing) {
        if (!(this instanceof ScreenStackFragment) || this.transitionProgress == alpha) {
            return;
        }
        float fMax = Math.max(0.0f, Math.min(1.0f, alpha));
        this.transitionProgress = fMax;
        short coalescingKey = INSTANCE.getCoalescingKey(fMax);
        ScreenContainer container = getScreen().getContainer();
        boolean goingForward = container instanceof ScreenStack ? ((ScreenStack) container).getGoingForward() : false;
        Context context = getScreen().getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, getScreen().getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new ScreenTransitionProgressEvent(UIManagerHelper.getSurfaceId(reactContext), getScreen().getId(), this.transitionProgress, closing, goingForward, coalescingKey));
        }
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public void addChildScreenContainer(ScreenContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        getChildScreenContainers().add(container);
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public void removeChildScreenContainer(ScreenContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        getChildScreenContainers().remove(container);
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public void onViewAnimationStart() {
        dispatchViewAnimationEvent(false);
    }

    @Override // com.swmansion.rnscreens.ScreenFragmentWrapper
    public void onViewAnimationEnd() {
        dispatchViewAnimationEvent(true);
    }

    private final void dispatchViewAnimationEvent(final boolean animationEnd) {
        Fragment parentFragment;
        this.isTransitioning = !animationEnd;
        if (getParentFragment() instanceof DimmingFragment) {
            Fragment parentFragment2 = getParentFragment();
            parentFragment = parentFragment2 != null ? parentFragment2.getParentFragment() : null;
        } else {
            parentFragment = getParentFragment();
        }
        if (parentFragment == null || ((parentFragment instanceof ScreenFragment) && !((ScreenFragment) parentFragment).isTransitioning)) {
            if (isResumed()) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.swmansion.rnscreens.ScreenFragment$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ScreenFragment.dispatchViewAnimationEvent$lambda$8(animationEnd, this);
                    }
                });
            } else if (animationEnd) {
                dispatchOnDisappear();
            } else {
                dispatchOnWillDisappear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchViewAnimationEvent$lambda$8(boolean z, ScreenFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z) {
            this$0.dispatchOnAppear();
        } else {
            this$0.dispatchOnWillAppear();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ScreenContainer container = getScreen().getContainer();
        if (container == null || !container.hasScreen(getScreen().getFragmentWrapper())) {
            Context context = getScreen().getContext();
            if (context instanceof ReactContext) {
                int surfaceId = UIManagerHelper.getSurfaceId(context);
                EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) context, getScreen().getId());
                if (eventDispatcherForReactTag != null) {
                    eventDispatcherForReactTag.dispatchEvent(new ScreenDismissedEvent(surfaceId, getScreen().getId()));
                }
            }
        }
        getChildScreenContainers().clear();
    }

    /* compiled from: ScreenFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/swmansion/rnscreens/ScreenFragment$Companion;", "", "()V", "TAG", "", "getCoalescingKey", "", "progress", "", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final short getCoalescingKey(float progress) {
            return (short) (progress == 0.0f ? 1 : progress == 1.0f ? 2 : 3);
        }

        private Companion() {
        }
    }
}
