package com.swmansion.rnscreens.bottomsheet;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactCompoundViewGroup;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.ViewProps;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.swmansion.rnscreens.ext.NumericExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DimmingView.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001eB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J0\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0014J\u0012\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0016R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/swmansion/rnscreens/bottomsheet/DimmingView;", "Landroid/view/ViewGroup;", "Lcom/facebook/react/uimanager/ReactCompoundViewGroup;", "Lcom/facebook/react/uimanager/ReactPointerEventsView;", "context", "Landroid/content/Context;", "initialAlpha", "", "(Landroid/content/Context;F)V", "blockGestures", "", "getBlockGestures", "()Z", "getPointerEvents", "Lcom/facebook/react/uimanager/PointerEvents;", "interceptsTouchEvent", "x", "y", ViewProps.ON_LAYOUT, "", "changed", "l", "", JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT, JWKParameterNames.RSA_OTHER_PRIMES__PRIME_FACTOR, "b", "onTouchEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "reactTagForTouch", "Companion", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DimmingView extends ViewGroup implements ReactCompoundViewGroup, ReactPointerEventsView {
    public static final String TAG = "DimmingView";

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    public /* synthetic */ DimmingView(Context context, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? 0.6f : f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DimmingView(Context context, float f) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        setAlpha(f);
    }

    private final boolean getBlockGestures() {
        return !NumericExtKt.equalWithRespectToEps$default(getAlpha(), 0.0f, 0.0f, 2, null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (getBlockGestures()) {
            callOnClick();
        }
        return getBlockGestures();
    }

    @Override // com.facebook.react.uimanager.ReactCompoundView
    public int reactTagForTouch(float x, float y) {
        throw new IllegalStateException("[RNScreens] DimmingView should never be asked for the view tag!");
    }

    @Override // com.facebook.react.uimanager.ReactCompoundViewGroup
    public boolean interceptsTouchEvent(float x, float y) {
        return getBlockGestures();
    }

    @Override // com.facebook.react.uimanager.ReactPointerEventsView
    public PointerEvents getPointerEvents() {
        return getBlockGestures() ? PointerEvents.AUTO : PointerEvents.NONE;
    }
}
