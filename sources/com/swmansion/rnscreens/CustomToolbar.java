package com.swmansion.rnscreens;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.widget.Toolbar;
import com.facebook.react.modules.core.ChoreographerCompat;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.nimbusds.jose.jwk.JWKParameterNames;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomToolbar.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J0\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0014J\b\u0010\u0015\u001a\u00020\u000eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/swmansion/rnscreens/CustomToolbar;", "Landroidx/appcompat/widget/Toolbar;", "context", "Landroid/content/Context;", "config", "Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;", "(Landroid/content/Context;Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;)V", "getConfig", "()Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;", "isLayoutEnqueued", "", "layoutCallback", "Lcom/facebook/react/modules/core/ChoreographerCompat$FrameCallback;", ViewProps.ON_LAYOUT, "", "changed", "l", "", JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT, JWKParameterNames.RSA_OTHER_PRIMES__PRIME_FACTOR, "b", "requestLayout", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class CustomToolbar extends Toolbar {
    private final ScreenStackHeaderConfig config;
    private boolean isLayoutEnqueued;
    private final ChoreographerCompat.FrameCallback layoutCallback;

    public final ScreenStackHeaderConfig getConfig() {
        return this.config;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomToolbar(Context context, ScreenStackHeaderConfig config) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.layoutCallback = new ChoreographerCompat.FrameCallback() { // from class: com.swmansion.rnscreens.CustomToolbar$layoutCallback$1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long frameTimeNanos) {
                this.this$0.isLayoutEnqueued = false;
                CustomToolbar customToolbar = this.this$0;
                customToolbar.measure(View.MeasureSpec.makeMeasureSpec(customToolbar.getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.this$0.getHeight(), Integer.MIN_VALUE));
                CustomToolbar customToolbar2 = this.this$0;
                customToolbar2.layout(customToolbar2.getLeft(), this.this$0.getTop(), this.this$0.getRight(), this.this$0.getBottom());
            }
        };
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        Window window;
        WindowManager.LayoutParams attributes;
        super.requestLayout();
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        Activity currentActivity = ((ThemedReactContext) context).getCurrentActivity();
        Integer numValueOf = (currentActivity == null || (window = currentActivity.getWindow()) == null || (attributes = window.getAttributes()) == null) ? null : Integer.valueOf(attributes.softInputMode);
        if (Build.VERSION.SDK_INT > 29 || numValueOf == null || numValueOf.intValue() != 32 || this.isLayoutEnqueued || this.layoutCallback == null) {
            return;
        }
        this.isLayoutEnqueued = true;
        ReactChoreographer.INSTANCE.getInstance().postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.layoutCallback);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        this.config.updatePaddingsFabric(getNavigationIcon() != null ? getContentInsetStartWithNavigation() : getContentInsetStart(), getContentInsetEnd());
    }
}
