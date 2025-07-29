package com.facebook.react.devsupport;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.common.logging.FLog;
import com.facebook.react.R;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.devsupport.interfaces.DevLoadingViewManager;
import com.facebook.react.uimanager.ViewProps;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: DefaultDevLoadingViewImplementation.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J+\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0019R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/facebook/react/devsupport/DefaultDevLoadingViewImplementation;", "Lcom/facebook/react/devsupport/interfaces/DevLoadingViewManager;", "reactInstanceDevHelper", "Lcom/facebook/react/devsupport/ReactInstanceDevHelper;", "(Lcom/facebook/react/devsupport/ReactInstanceDevHelper;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "devLoadingPopup", "Landroid/widget/PopupWindow;", "devLoadingView", "Landroid/widget/TextView;", "hide", "", "hideInternal", "showInternal", "message", "", "showMessage", "updateProgress", "status", "done", "", "total", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultDevLoadingViewImplementation implements DevLoadingViewManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean isEnabled = true;
    private PopupWindow devLoadingPopup;
    private TextView devLoadingView;
    private final ReactInstanceDevHelper reactInstanceDevHelper;

    public DefaultDevLoadingViewImplementation(ReactInstanceDevHelper reactInstanceDevHelper) {
        Intrinsics.checkNotNullParameter(reactInstanceDevHelper, "reactInstanceDevHelper");
        this.reactInstanceDevHelper = reactInstanceDevHelper;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevLoadingViewManager
    public void showMessage(final String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (isEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.DefaultDevLoadingViewImplementation$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultDevLoadingViewImplementation.showMessage$lambda$0(this.f$0, message);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMessage$lambda$0(DefaultDevLoadingViewImplementation this$0, String message) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(message, "$message");
        this$0.showInternal(message);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevLoadingViewManager
    public void updateProgress(final String status, final Integer done, final Integer total) {
        if (isEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.DefaultDevLoadingViewImplementation$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultDevLoadingViewImplementation.updateProgress$lambda$1(done, total, this, status);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateProgress$lambda$1(Integer num, Integer num2, DefaultDevLoadingViewImplementation this$0, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (num != null && num2 != null && num2.intValue() > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            str2 = String.format(Locale.getDefault(), " %.1f%%", Arrays.copyOf(new Object[]{Float.valueOf((num.intValue() / num2.intValue()) * 100)}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        } else {
            str2 = "";
        }
        TextView textView = this$0.devLoadingView;
        if (textView == null) {
            return;
        }
        if (str == null) {
            str = "Loading";
        }
        textView.setText(str + str2 + "…");
    }

    @Override // com.facebook.react.devsupport.interfaces.DevLoadingViewManager
    public void hide() {
        if (isEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.DefaultDevLoadingViewImplementation$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultDevLoadingViewImplementation.hide$lambda$2(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hide$lambda$2(DefaultDevLoadingViewImplementation this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hideInternal();
    }

    private final void showInternal(String message) {
        PopupWindow popupWindow = this.devLoadingPopup;
        if (popupWindow == null || !popupWindow.isShowing()) {
            Activity currentActivity = this.reactInstanceDevHelper.getCurrentActivity();
            if (currentActivity == null) {
                FLog.e("ReactNative", "Unable to display loading message because react activity isn't available");
                return;
            }
            try {
                Rect rect = new Rect();
                currentActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int i = rect.top;
                Object systemService = currentActivity.getSystemService("layout_inflater");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
                View viewInflate = ((LayoutInflater) systemService).inflate(R.layout.dev_loading_view, (ViewGroup) null);
                Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView = (TextView) viewInflate;
                textView.setText(message);
                PopupWindow popupWindow2 = new PopupWindow(textView, -1, -2);
                popupWindow2.setTouchable(false);
                popupWindow2.showAtLocation(currentActivity.getWindow().getDecorView(), 0, 0, i);
                this.devLoadingView = textView;
                this.devLoadingPopup = popupWindow2;
            } catch (WindowManager.BadTokenException unused) {
                FLog.e("ReactNative", "Unable to display loading message because react activity isn't active, message: " + message);
            }
        }
    }

    private final void hideInternal() {
        PopupWindow popupWindow = this.devLoadingPopup;
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
            this.devLoadingPopup = null;
            this.devLoadingView = null;
        }
    }

    private final Context getContext() {
        return this.reactInstanceDevHelper.getCurrentActivity();
    }

    /* compiled from: DefaultDevLoadingViewImplementation.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/react/devsupport/DefaultDevLoadingViewImplementation$Companion;", "", "()V", "isEnabled", "", "setDevLoadingEnabled", "", ViewProps.ENABLED, "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void setDevLoadingEnabled(boolean enabled) {
            DefaultDevLoadingViewImplementation.isEnabled = enabled;
        }
    }
}
