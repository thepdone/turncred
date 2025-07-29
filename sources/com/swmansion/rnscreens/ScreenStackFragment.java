package com.swmansion.rnscreens;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.ScreenStackHeaderSubview;
import com.swmansion.rnscreens.bottomsheet.BottomSheetBehaviorExtKt;
import com.swmansion.rnscreens.bottomsheet.SheetUtils;
import com.swmansion.rnscreens.bottomsheet.SheetUtilsKt;
import com.swmansion.rnscreens.ext.ViewExtKt;
import com.swmansion.rnscreens.utils.DeviceUtils;
import io.sentry.protocol.Request;
import io.sentry.rrweb.RRWebVideoEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScreenStackFragment.kt */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012*\u0002\n\u0012\u0018\u00002\u00020\u00012\u00020\u0002:\u0002`aB\u000f\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0007\b\u0016¢\u0006\u0002\u0010\u0006J\u0010\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\u0004H\u0002J\b\u00103\u001a\u00020\u000fH\u0016J+\u00104\u001a\b\u0012\u0004\u0012\u00020\u0004052\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0004052\b\b\u0002\u00107\u001a\u000208H\u0000¢\u0006\u0002\b9J\u0013\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000405H\u0000¢\u0006\u0002\b;J\b\u0010<\u001a\u00020\"H\u0016J\n\u0010=\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010>\u001a\u00020\"H\u0002J\b\u0010?\u001a\u00020\"H\u0016J\"\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020CH\u0016J\u0018\u0010F\u001a\u00020\"2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0016J$\u0010K\u001a\u00020\u00152\u0006\u0010I\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010N2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\u0010\u0010Q\u001a\u00020\"2\u0006\u0010G\u001a\u00020HH\u0016J\r\u0010R\u001a\u00020\"H\u0000¢\u0006\u0002\bSJ\b\u0010T\u001a\u00020\"H\u0016J\b\u0010U\u001a\u00020\"H\u0016J\b\u0010V\u001a\u00020\"H\u0016J\u0010\u0010W\u001a\u00020\"2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u0010X\u001a\u00020\"2\u0006\u0010Y\u001a\u00020\u000fH\u0016J\u0010\u0010Z\u001a\u00020\"2\u0006\u0010[\u001a\u00020\u000fH\u0016J\b\u0010\\\u001a\u00020\u000fH\u0002J\u000f\u0010]\u001a\u0004\u0018\u00010CH\u0002¢\u0006\u0002\u0010^J\u0010\u0010_\u001a\u00020\"2\u0006\u0010G\u001a\u00020HH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR7\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\"\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u001c\u0010!\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackFragment;", "Lcom/swmansion/rnscreens/ScreenFragment;", "Lcom/swmansion/rnscreens/ScreenStackFragmentWrapper;", "screenView", "Lcom/swmansion/rnscreens/Screen;", "(Lcom/swmansion/rnscreens/Screen;)V", "()V", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "bottomSheetStateCallback", "com/swmansion/rnscreens/ScreenStackFragment$bottomSheetStateCallback$1", "Lcom/swmansion/rnscreens/ScreenStackFragment$bottomSheetStateCallback$1;", "coordinatorLayout", "Lcom/swmansion/rnscreens/ScreenStackFragment$ScreensCoordinatorLayout;", "isToolbarShadowHidden", "", "isToolbarTranslucent", "keyboardSheetCallback", "com/swmansion/rnscreens/ScreenStackFragment$keyboardSheetCallback$1", "Lcom/swmansion/rnscreens/ScreenStackFragment$keyboardSheetCallback$1;", "lastFocusedChild", "Landroid/view/View;", "nativeDismissalObserver", "Lcom/swmansion/rnscreens/NativeDismissalObserver;", "getNativeDismissalObserver", "()Lcom/swmansion/rnscreens/NativeDismissalObserver;", "setNativeDismissalObserver", "(Lcom/swmansion/rnscreens/NativeDismissalObserver;)V", "onSearchViewCreate", "Lkotlin/Function1;", "Lcom/swmansion/rnscreens/CustomSearchView;", "Lkotlin/ParameterName;", "name", "searchView", "", "getOnSearchViewCreate", "()Lkotlin/jvm/functions/Function1;", "setOnSearchViewCreate", "(Lkotlin/jvm/functions/Function1;)V", "screenStack", "Lcom/swmansion/rnscreens/ScreenStack;", "getScreenStack", "()Lcom/swmansion/rnscreens/ScreenStack;", "getSearchView", "()Lcom/swmansion/rnscreens/CustomSearchView;", "setSearchView", "(Lcom/swmansion/rnscreens/CustomSearchView;)V", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "attachShapeToScreen", "screen", "canNavigateBack", "configureBottomSheetBehaviour", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "behavior", "keyboardState", "Lcom/swmansion/rnscreens/KeyboardState;", "configureBottomSheetBehaviour$react_native_screens_release", "createAndConfigureBottomSheetBehaviour", "createAndConfigureBottomSheetBehaviour$react_native_screens_release", "dismissFromContainer", "findLastFocusedChild", "notifyViewAppearTransitionEnd", "onContainerUpdate", "onCreateAnimation", "Landroid/view/animation/Animation;", "transit", "", "enter", "nextAnim", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/LayoutInflater;", RRWebVideoEvent.JsonKeys.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPrepareOptionsMenu", "onSheetCornerRadiusChange", "onSheetCornerRadiusChange$react_native_screens_release", "onStop", "onViewAnimationEnd", "removeToolbar", "setToolbar", "setToolbarShadowHidden", ViewProps.HIDDEN, "setToolbarTranslucent", "translucent", "shouldShowSearchBar", "tryResolveContainerHeight", "()Ljava/lang/Integer;", "updateToolbarMenu", "ScreensAnimation", "ScreensCoordinatorLayout", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ScreenStackFragment extends ScreenFragment implements ScreenStackFragmentWrapper {
    private AppBarLayout appBarLayout;
    private final ScreenStackFragment$bottomSheetStateCallback$1 bottomSheetStateCallback;
    private ScreensCoordinatorLayout coordinatorLayout;
    private boolean isToolbarShadowHidden;
    private boolean isToolbarTranslucent;
    private final ScreenStackFragment$keyboardSheetCallback$1 keyboardSheetCallback;
    private View lastFocusedChild;
    private NativeDismissalObserver nativeDismissalObserver;
    private Function1<? super CustomSearchView, Unit> onSearchViewCreate;
    private CustomSearchView searchView;
    private Toolbar toolbar;

    public final NativeDismissalObserver getNativeDismissalObserver() {
        return this.nativeDismissalObserver;
    }

    public final void setNativeDismissalObserver(NativeDismissalObserver nativeDismissalObserver) {
        this.nativeDismissalObserver = nativeDismissalObserver;
    }

    public final CustomSearchView getSearchView() {
        return this.searchView;
    }

    public final void setSearchView(CustomSearchView customSearchView) {
        this.searchView = customSearchView;
    }

    public final Function1<CustomSearchView, Unit> getOnSearchViewCreate() {
        return this.onSearchViewCreate;
    }

    public final void setOnSearchViewCreate(Function1<? super CustomSearchView, Unit> function1) {
        this.onSearchViewCreate = function1;
    }

    private final ScreenStack getScreenStack() {
        ScreenContainer container = getScreen().getContainer();
        if (!(container instanceof ScreenStack)) {
            throw new IllegalStateException("ScreenStackFragment added into a non-stack container".toString());
        }
        return (ScreenStack) container;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.swmansion.rnscreens.ScreenStackFragment$bottomSheetStateCallback$1] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.swmansion.rnscreens.ScreenStackFragment$keyboardSheetCallback$1] */
    public ScreenStackFragment(Screen screenView) {
        super(screenView);
        Intrinsics.checkNotNullParameter(screenView, "screenView");
        this.bottomSheetStateCallback = new BottomSheetBehavior.BottomSheetCallback() { // from class: com.swmansion.rnscreens.ScreenStackFragment$bottomSheetStateCallback$1
            private int lastStableState;

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View bottomSheet, float slideOffset) {
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            }

            {
                this.lastStableState = SheetUtils.INSTANCE.sheetStateFromDetentIndex(this.this$0.getScreen().getSheetInitialDetentIndex(), this.this$0.getScreen().getSheetDetents().size());
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View bottomSheet, int newState) {
                NativeDismissalObserver nativeDismissalObserver;
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                if (SheetUtils.INSTANCE.isStateStable(newState)) {
                    this.lastStableState = newState;
                    this.this$0.getScreen().notifySheetDetentChange$react_native_screens_release(SheetUtils.INSTANCE.detentIndexFromSheetState(this.lastStableState, this.this$0.getScreen().getSheetDetents().size()), true);
                } else if (newState == 1) {
                    this.this$0.getScreen().notifySheetDetentChange$react_native_screens_release(SheetUtils.INSTANCE.detentIndexFromSheetState(this.lastStableState, this.this$0.getScreen().getSheetDetents().size()), false);
                }
                if (newState != 5 || (nativeDismissalObserver = this.this$0.getNativeDismissalObserver()) == null) {
                    return;
                }
                nativeDismissalObserver.onNativeDismiss(this.this$0);
            }
        };
        this.keyboardSheetCallback = new BottomSheetBehavior.BottomSheetCallback() { // from class: com.swmansion.rnscreens.ScreenStackFragment$keyboardSheetCallback$1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View bottomSheet, float slideOffset) {
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View bottomSheet, int newState) {
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                if (newState == 4 && WindowInsetsCompat.toWindowInsetsCompat(bottomSheet.getRootWindowInsets()).isVisible(WindowInsetsCompat.Type.ime())) {
                    bottomSheet.requestFocus();
                    ((InputMethodManager) this.this$0.requireContext().getSystemService(InputMethodManager.class)).hideSoftInputFromWindow(bottomSheet.getWindowToken(), 0);
                }
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.swmansion.rnscreens.ScreenStackFragment$bottomSheetStateCallback$1] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.swmansion.rnscreens.ScreenStackFragment$keyboardSheetCallback$1] */
    public ScreenStackFragment() {
        this.bottomSheetStateCallback = new BottomSheetBehavior.BottomSheetCallback() { // from class: com.swmansion.rnscreens.ScreenStackFragment$bottomSheetStateCallback$1
            private int lastStableState;

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View bottomSheet, float slideOffset) {
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            }

            {
                this.lastStableState = SheetUtils.INSTANCE.sheetStateFromDetentIndex(this.this$0.getScreen().getSheetInitialDetentIndex(), this.this$0.getScreen().getSheetDetents().size());
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View bottomSheet, int newState) {
                NativeDismissalObserver nativeDismissalObserver;
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                if (SheetUtils.INSTANCE.isStateStable(newState)) {
                    this.lastStableState = newState;
                    this.this$0.getScreen().notifySheetDetentChange$react_native_screens_release(SheetUtils.INSTANCE.detentIndexFromSheetState(this.lastStableState, this.this$0.getScreen().getSheetDetents().size()), true);
                } else if (newState == 1) {
                    this.this$0.getScreen().notifySheetDetentChange$react_native_screens_release(SheetUtils.INSTANCE.detentIndexFromSheetState(this.lastStableState, this.this$0.getScreen().getSheetDetents().size()), false);
                }
                if (newState != 5 || (nativeDismissalObserver = this.this$0.getNativeDismissalObserver()) == null) {
                    return;
                }
                nativeDismissalObserver.onNativeDismiss(this.this$0);
            }
        };
        this.keyboardSheetCallback = new BottomSheetBehavior.BottomSheetCallback() { // from class: com.swmansion.rnscreens.ScreenStackFragment$keyboardSheetCallback$1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View bottomSheet, float slideOffset) {
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View bottomSheet, int newState) {
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                if (newState == 4 && WindowInsetsCompat.toWindowInsetsCompat(bottomSheet.getRootWindowInsets()).isVisible(WindowInsetsCompat.Type.ime())) {
                    bottomSheet.requestFocus();
                    ((InputMethodManager) this.this$0.requireContext().getSystemService(InputMethodManager.class)).hideSoftInputFromWindow(bottomSheet.getWindowToken(), 0);
                }
            }
        };
        throw new IllegalStateException("ScreenStack fragments should never be restored. Follow instructions from https://github.com/software-mansion/react-native-screens/issues/17#issuecomment-424704067 to properly configure your main activity.");
    }

    @Override // com.swmansion.rnscreens.ScreenStackFragmentWrapper
    public void removeToolbar() {
        Toolbar toolbar;
        AppBarLayout appBarLayout = this.appBarLayout;
        if (appBarLayout != null && (toolbar = this.toolbar) != null && toolbar.getParent() == appBarLayout) {
            appBarLayout.removeView(toolbar);
        }
        this.toolbar = null;
    }

    @Override // com.swmansion.rnscreens.ScreenStackFragmentWrapper
    public void setToolbar(Toolbar toolbar) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        AppBarLayout appBarLayout = this.appBarLayout;
        if (appBarLayout != null) {
            appBarLayout.addView(toolbar);
        }
        AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(-1, -2);
        layoutParams.setScrollFlags(0);
        toolbar.setLayoutParams(layoutParams);
        this.toolbar = toolbar;
    }

    @Override // com.swmansion.rnscreens.ScreenStackFragmentWrapper
    public void setToolbarShadowHidden(boolean hidden) {
        if (this.isToolbarShadowHidden != hidden) {
            AppBarLayout appBarLayout = this.appBarLayout;
            if (appBarLayout != null) {
                appBarLayout.setElevation(hidden ? 0.0f : PixelUtil.toPixelFromDIP(4.0f));
            }
            AppBarLayout appBarLayout2 = this.appBarLayout;
            if (appBarLayout2 != null) {
                appBarLayout2.setStateListAnimator(null);
            }
            this.isToolbarShadowHidden = hidden;
        }
    }

    @Override // com.swmansion.rnscreens.ScreenStackFragmentWrapper
    public void setToolbarTranslucent(boolean translucent) {
        if (this.isToolbarTranslucent != translucent) {
            ViewGroup.LayoutParams layoutParams = getScreen().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            ((CoordinatorLayout.LayoutParams) layoutParams).setBehavior(translucent ? null : new AppBarLayout.ScrollingViewBehavior());
            this.isToolbarTranslucent = translucent;
        }
    }

    @Override // com.swmansion.rnscreens.ScreenFragment, com.swmansion.rnscreens.ScreenFragmentWrapper
    public void onContainerUpdate() {
        super.onContainerUpdate();
        ScreenStackHeaderConfig headerConfig = getScreen().getHeaderConfig();
        if (headerConfig != null) {
            headerConfig.onUpdate();
        }
    }

    @Override // com.swmansion.rnscreens.ScreenFragment, com.swmansion.rnscreens.ScreenFragmentWrapper
    public void onViewAnimationEnd() {
        super.onViewAnimationEnd();
        notifyViewAppearTransitionEnd();
    }

    private final void notifyViewAppearTransitionEnd() {
        View view = getView();
        ViewParent parent = view != null ? view.getParent() : null;
        if (parent instanceof ScreenStack) {
            ((ScreenStack) parent).onViewAppearTransitionEnd();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (getScreen().getStackPresentation() != Screen.StackPresentation.FORM_SHEET) {
            return null;
        }
        if (enter) {
            return AnimationUtils.loadAnimation(getContext(), R.anim.rns_slide_in_from_bottom);
        }
        return AnimationUtils.loadAnimation(getContext(), R.anim.rns_slide_out_to_bottom);
    }

    public final void onSheetCornerRadiusChange$react_native_screens_release() {
        getScreen().onSheetCornerRadiusChange$react_native_screens_release();
    }

    @Override // com.swmansion.rnscreens.ScreenFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) throws Resources.NotFoundException {
        AppBarLayout.ScrollingViewBehavior scrollingViewBehavior;
        AppBarLayout appBarLayout;
        AppBarLayout appBarLayout2;
        AppBarLayout appBarLayout3;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.coordinatorLayout = new ScreensCoordinatorLayout(contextRequireContext, this);
        Screen screen = getScreen();
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -1);
        ScreensCoordinatorLayout screensCoordinatorLayout = null;
        if (SheetUtilsKt.usesFormSheetPresentation(getScreen())) {
            scrollingViewBehavior = createAndConfigureBottomSheetBehaviour$react_native_screens_release();
        } else {
            scrollingViewBehavior = this.isToolbarTranslucent ? null : new AppBarLayout.ScrollingViewBehavior();
        }
        layoutParams.setBehavior(scrollingViewBehavior);
        screen.setLayoutParams(layoutParams);
        if (SheetUtilsKt.usesFormSheetPresentation(getScreen())) {
            getScreen().setClipToOutline(true);
            attachShapeToScreen(getScreen());
            getScreen().setElevation(getScreen().getSheetElevation());
        }
        ScreensCoordinatorLayout screensCoordinatorLayout2 = this.coordinatorLayout;
        if (screensCoordinatorLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
            screensCoordinatorLayout2 = null;
        }
        screensCoordinatorLayout2.addView(ViewExtKt.recycle(getScreen()));
        if (!SheetUtilsKt.usesFormSheetPresentation(getScreen())) {
            Context context = getContext();
            if (context != null) {
                appBarLayout = new AppBarLayout(context);
                appBarLayout.setBackgroundColor(0);
                appBarLayout.setLayoutParams(new AppBarLayout.LayoutParams(-1, -2));
            } else {
                appBarLayout = null;
            }
            this.appBarLayout = appBarLayout;
            ScreensCoordinatorLayout screensCoordinatorLayout3 = this.coordinatorLayout;
            if (screensCoordinatorLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
                screensCoordinatorLayout3 = null;
            }
            screensCoordinatorLayout3.addView(this.appBarLayout);
            if (this.isToolbarShadowHidden && (appBarLayout3 = this.appBarLayout) != null) {
                appBarLayout3.setTargetElevation(0.0f);
            }
            Toolbar toolbar = this.toolbar;
            if (toolbar != null && (appBarLayout2 = this.appBarLayout) != null) {
                appBarLayout2.addView(ViewExtKt.recycle(toolbar));
            }
            setHasOptionsMenu(true);
        }
        ScreensCoordinatorLayout screensCoordinatorLayout4 = this.coordinatorLayout;
        if (screensCoordinatorLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
        } else {
            screensCoordinatorLayout = screensCoordinatorLayout4;
        }
        return screensCoordinatorLayout;
    }

    private final Integer tryResolveContainerHeight() {
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        Resources resources;
        DisplayMetrics displayMetrics;
        if (getScreen().getContainer() != null) {
            return Integer.valueOf(getScreenStack().getHeight());
        }
        Context context = getContext();
        if (context != null && (resources = context.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            return Integer.valueOf(displayMetrics.heightPixels);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            Context context2 = getContext();
            Object systemService = context2 != null ? context2.getSystemService("window") : null;
            WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
            if (windowManager != null && (currentWindowMetrics = windowManager.getCurrentWindowMetrics()) != null && (bounds = currentWindowMetrics.getBounds()) != null) {
                return Integer.valueOf(bounds.height());
            }
        }
        return null;
    }

    public static /* synthetic */ BottomSheetBehavior configureBottomSheetBehaviour$react_native_screens_release$default(ScreenStackFragment screenStackFragment, BottomSheetBehavior bottomSheetBehavior, KeyboardState keyboardState, int i, Object obj) {
        if ((i & 2) != 0) {
            keyboardState = KeyboardNotVisible.INSTANCE;
        }
        return screenStackFragment.configureBottomSheetBehaviour$react_native_screens_release(bottomSheetBehavior, keyboardState);
    }

    public final BottomSheetBehavior<Screen> configureBottomSheetBehaviour$react_native_screens_release(BottomSheetBehavior<Screen> behavior, KeyboardState keyboardState) {
        int maxHeight;
        Integer numValueOf;
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        Intrinsics.checkNotNullParameter(keyboardState, "keyboardState");
        if (tryResolveContainerHeight() == null) {
            throw new IllegalStateException("[RNScreens] Failed to find window height during bottom sheet behaviour configuration".toString());
        }
        behavior.setHideable(true);
        behavior.setDraggable(true);
        behavior.addBottomSheetCallback(this.bottomSheetStateCallback);
        ScreenFooter footer = getScreen().getFooter();
        if (footer != null) {
            footer.registerWithSheetBehavior(behavior);
        }
        if (keyboardState instanceof KeyboardNotVisible) {
            int size = getScreen().getSheetDetents().size();
            if (size != 1) {
                if (size == 2) {
                    return BottomSheetBehaviorExtKt.useTwoDetents(behavior, Integer.valueOf(SheetUtils.INSTANCE.sheetStateFromDetentIndex(getScreen().getSheetInitialDetentIndex(), getScreen().getSheetDetents().size())), Integer.valueOf((int) (getScreen().getSheetDetents().get(0).doubleValue() * r1.intValue())), Integer.valueOf((int) (getScreen().getSheetDetents().get(1).doubleValue() * r1.intValue())));
                }
                if (size == 3) {
                    return BottomSheetBehaviorExtKt.useThreeDetents(behavior, Integer.valueOf(SheetUtils.INSTANCE.sheetStateFromDetentIndex(getScreen().getSheetInitialDetentIndex(), getScreen().getSheetDetents().size())), Integer.valueOf((int) (getScreen().getSheetDetents().get(0).doubleValue() * r1.intValue())), Float.valueOf((float) (getScreen().getSheetDetents().get(1).doubleValue() / getScreen().getSheetDetents().get(2).doubleValue())), Integer.valueOf((int) ((1 - getScreen().getSheetDetents().get(2).doubleValue()) * r1.intValue())));
                }
                throw new IllegalStateException("[RNScreens] Invalid detent count " + getScreen().getSheetDetents().size() + ". Expected at most 3.");
            }
            if (SheetUtilsKt.isSheetFitToContents(getScreen())) {
                ScreenContentWrapper screenContentWrapper = getScreen().getContentWrapper().get();
                numValueOf = screenContentWrapper != null ? Integer.valueOf(screenContentWrapper.getHeight()) : null;
            } else {
                numValueOf = Integer.valueOf((int) (((Number) CollectionsKt.first((List) getScreen().getSheetDetents())).doubleValue() * r1.intValue()));
            }
            BottomSheetBehaviorExtKt.useSingleDetent$default(behavior, numValueOf, false, 2, null);
        } else if (keyboardState instanceof KeyboardVisible) {
            KeyboardVisible keyboardVisible = (KeyboardVisible) keyboardState;
            if (behavior.getMaxHeight() - keyboardVisible.getHeight() > 1) {
                maxHeight = behavior.getMaxHeight() - keyboardVisible.getHeight();
            } else {
                maxHeight = behavior.getMaxHeight();
            }
            int i = maxHeight;
            int size2 = getScreen().getSheetDetents().size();
            if (size2 == 1) {
                BottomSheetBehaviorExtKt.useSingleDetent$default(behavior, Integer.valueOf(i), false, 2, null);
                behavior.addBottomSheetCallback(this.keyboardSheetCallback);
            } else if (size2 == 2) {
                BottomSheetBehaviorExtKt.useTwoDetents$default(behavior, 3, null, Integer.valueOf(i), 2, null);
                behavior.addBottomSheetCallback(this.keyboardSheetCallback);
            } else if (size2 == 3) {
                BottomSheetBehaviorExtKt.useThreeDetents$default(behavior, 3, null, null, null, 14, null);
                behavior.setMaxHeight(i);
                behavior.addBottomSheetCallback(this.keyboardSheetCallback);
            } else {
                throw new IllegalStateException("[RNScreens] Invalid detent count " + getScreen().getSheetDetents().size() + ". Expected at most 3.");
            }
        } else {
            if (keyboardState instanceof KeyboardDidHide) {
                behavior.removeBottomSheetCallback(this.keyboardSheetCallback);
                int size3 = getScreen().getSheetDetents().size();
                if (size3 == 1) {
                    return BottomSheetBehaviorExtKt.useSingleDetent(behavior, Integer.valueOf((int) (((Number) CollectionsKt.first((List) getScreen().getSheetDetents())).doubleValue() * r1.intValue())), false);
                }
                if (size3 == 2) {
                    return BottomSheetBehaviorExtKt.useTwoDetents$default(behavior, null, Integer.valueOf((int) (getScreen().getSheetDetents().get(0).doubleValue() * r1.intValue())), Integer.valueOf((int) (getScreen().getSheetDetents().get(1).doubleValue() * r1.intValue())), 1, null);
                }
                if (size3 == 3) {
                    return BottomSheetBehaviorExtKt.useThreeDetents$default(behavior, null, Integer.valueOf((int) (getScreen().getSheetDetents().get(0).doubleValue() * r1.intValue())), Float.valueOf((float) (getScreen().getSheetDetents().get(1).doubleValue() / getScreen().getSheetDetents().get(2).doubleValue())), Integer.valueOf((int) ((1 - getScreen().getSheetDetents().get(2).doubleValue()) * r1.intValue())), 1, null);
                }
                throw new IllegalStateException("[RNScreens] Invalid detent count " + getScreen().getSheetDetents().size() + ". Expected at most 3.");
            }
            throw new NoWhenBranchMatchedException();
        }
        return behavior;
    }

    public final BottomSheetBehavior<Screen> createAndConfigureBottomSheetBehaviour$react_native_screens_release() {
        return configureBottomSheetBehaviour$react_native_screens_release$default(this, new BottomSheetBehavior(), null, 2, null);
    }

    private final void attachShapeToScreen(Screen screen) {
        ColorStateList tintList;
        float pixelFromDIP = PixelUtil.toPixelFromDIP(screen.getSheetCornerRadius());
        ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder();
        builder.setTopLeftCorner(0, pixelFromDIP);
        builder.setTopRightCorner(0, pixelFromDIP);
        ShapeAppearanceModel shapeAppearanceModelBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(shapeAppearanceModelBuild, "build(...)");
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModelBuild);
        Drawable background = screen.getBackground();
        Integer numValueOf = null;
        ColorDrawable colorDrawable = background instanceof ColorDrawable ? (ColorDrawable) background : null;
        if (colorDrawable != null) {
            numValueOf = Integer.valueOf(colorDrawable.getColor());
        } else {
            Drawable background2 = screen.getBackground();
            MaterialShapeDrawable materialShapeDrawable2 = background2 instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) background2 : null;
            if (materialShapeDrawable2 != null && (tintList = materialShapeDrawable2.getTintList()) != null) {
                numValueOf = Integer.valueOf(tintList.getDefaultColor());
            }
        }
        materialShapeDrawable.setTint(numValueOf != null ? numValueOf.intValue() : 0);
        screen.setBackground(materialShapeDrawable);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        if (DeviceUtils.INSTANCE.isPlatformAndroidTV(getContext())) {
            this.lastFocusedChild = findLastFocusedChild();
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        ScreenStackHeaderConfig headerConfig;
        Intrinsics.checkNotNullParameter(menu, "menu");
        if (!getScreen().isTransparent() || ((headerConfig = getScreen().getHeaderConfig()) != null && !headerConfig.getIsHeaderHidden())) {
            updateToolbarMenu(menu);
        }
        super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        updateToolbarMenu(menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private final boolean shouldShowSearchBar() {
        ScreenStackHeaderConfig headerConfig = getScreen().getHeaderConfig();
        int configSubviewsCount = headerConfig != null ? headerConfig.getConfigSubviewsCount() : 0;
        if (headerConfig != null && configSubviewsCount > 0) {
            for (int i = 0; i < configSubviewsCount; i++) {
                if (headerConfig.getConfigSubview(i).getType() == ScreenStackHeaderSubview.Type.SEARCH_BAR) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void updateToolbarMenu(Menu menu) {
        menu.clear();
        if (shouldShowSearchBar()) {
            Context context = getContext();
            if (this.searchView == null && context != null) {
                CustomSearchView customSearchView = new CustomSearchView(context, this);
                this.searchView = customSearchView;
                Function1<? super CustomSearchView, Unit> function1 = this.onSearchViewCreate;
                if (function1 != null) {
                    function1.invoke(customSearchView);
                }
            }
            MenuItem menuItemAdd = menu.add("");
            menuItemAdd.setShowAsAction(2);
            menuItemAdd.setActionView(this.searchView);
        }
    }

    private final View findLastFocusedChild() {
        Screen screen = getScreen();
        while (screen != null) {
            if (screen.isFocused()) {
                return screen;
            }
            screen = screen instanceof ViewGroup ? ((ViewGroup) screen).getFocusedChild() : null;
        }
        return null;
    }

    @Override // com.swmansion.rnscreens.ScreenStackFragmentWrapper
    public boolean canNavigateBack() {
        ScreenContainer container = getScreen().getContainer();
        if (!(container instanceof ScreenStack)) {
            throw new IllegalStateException("ScreenStackFragment added into a non-stack container".toString());
        }
        if (!Intrinsics.areEqual(((ScreenStack) container).getRootScreen(), getScreen())) {
            return true;
        }
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof ScreenStackFragment) {
            return ((ScreenStackFragment) parentFragment).canNavigateBack();
        }
        return false;
    }

    @Override // com.swmansion.rnscreens.ScreenStackFragmentWrapper
    public void dismissFromContainer() {
        getScreenStack().dismiss(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScreenStackFragment.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackFragment$ScreensCoordinatorLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "Lcom/facebook/react/uimanager/ReactPointerEventsView;", "context", "Landroid/content/Context;", Request.JsonKeys.FRAGMENT, "Lcom/swmansion/rnscreens/ScreenStackFragment;", "(Landroid/content/Context;Lcom/swmansion/rnscreens/ScreenStackFragment;)V", "animationListener", "Landroid/view/animation/Animation$AnimationListener;", "clearFocus", "", "getPointerEvents", "Lcom/facebook/react/uimanager/PointerEvents;", "onApplyWindowInsets", "Landroid/view/WindowInsets;", "insets", "startAnimation", "animation", "Landroid/view/animation/Animation;", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    static final class ScreensCoordinatorLayout extends CoordinatorLayout implements ReactPointerEventsView {
        private final Animation.AnimationListener animationListener;
        private final ScreenStackFragment fragment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScreensCoordinatorLayout(Context context, ScreenStackFragment fragment) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.fragment = fragment;
            this.animationListener = new Animation.AnimationListener() { // from class: com.swmansion.rnscreens.ScreenStackFragment$ScreensCoordinatorLayout$animationListener$1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    this.this$0.fragment.onViewAnimationStart();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    this.this$0.fragment.onViewAnimationEnd();
                }
            };
        }

        @Override // android.view.View
        public WindowInsets onApplyWindowInsets(WindowInsets insets) {
            WindowInsets windowInsetsOnApplyWindowInsets = super.onApplyWindowInsets(insets);
            Intrinsics.checkNotNullExpressionValue(windowInsetsOnApplyWindowInsets, "onApplyWindowInsets(...)");
            return windowInsetsOnApplyWindowInsets;
        }

        @Override // android.view.View
        public void startAnimation(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            ScreensAnimation screensAnimation = new ScreensAnimation(this.fragment);
            screensAnimation.setDuration(animation.getDuration());
            if ((animation instanceof AnimationSet) && !this.fragment.isRemoving()) {
                AnimationSet animationSet = (AnimationSet) animation;
                animationSet.addAnimation(screensAnimation);
                animationSet.setAnimationListener(this.animationListener);
                super.startAnimation(animationSet);
                return;
            }
            AnimationSet animationSet2 = new AnimationSet(true);
            animationSet2.addAnimation(animation);
            animationSet2.addAnimation(screensAnimation);
            animationSet2.setAnimationListener(this.animationListener);
            super.startAnimation(animationSet2);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void clearFocus() {
            if (getVisibility() != 4) {
                super.clearFocus();
            }
        }

        @Override // com.facebook.react.uimanager.ReactPointerEventsView
        public PointerEvents getPointerEvents() {
            return PointerEvents.BOX_NONE;
        }
    }

    /* compiled from: ScreenStackFragment.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackFragment$ScreensAnimation;", "Landroid/view/animation/Animation;", "mFragment", "Lcom/swmansion/rnscreens/ScreenFragment;", "(Lcom/swmansion/rnscreens/ScreenFragment;)V", "applyTransformation", "", "interpolatedTime", "", JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT, "Landroid/view/animation/Transformation;", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class ScreensAnimation extends Animation {
        private final ScreenFragment mFragment;

        public ScreensAnimation(ScreenFragment mFragment) {
            Intrinsics.checkNotNullParameter(mFragment, "mFragment");
            this.mFragment = mFragment;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            Intrinsics.checkNotNullParameter(t, "t");
            super.applyTransformation(interpolatedTime, t);
            this.mFragment.dispatchTransitionProgressEvent(interpolatedTime, !r3.isResumed());
        }
    }
}
