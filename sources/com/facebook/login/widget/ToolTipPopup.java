package com.facebook.login.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.R;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ToolTipPopup.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0003\u001e\u001f B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\fJ\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u001b\u001a\u00020\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0018\u00010\u000eR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/facebook/login/widget/ToolTipPopup;", "", "text", "", "anchor", "Landroid/view/View;", "(Ljava/lang/String;Landroid/view/View;)V", "anchorViewRef", "Ljava/lang/ref/WeakReference;", "context", "Landroid/content/Context;", "nuxDisplayTime", "", "popupContent", "Lcom/facebook/login/widget/ToolTipPopup$PopupContentView;", "popupWindow", "Landroid/widget/PopupWindow;", "scrollListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/facebook/login/widget/ToolTipPopup$Style;", "dismiss", "", "registerObserver", "setNuxDisplayTime", "displayTime", "setStyle", "show", "unregisterObserver", "updateArrows", "Companion", "PopupContentView", "Style", "facebook-login_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ToolTipPopup {
    public static final long DEFAULT_POPUP_DISPLAY_TIME = 6000;
    private final WeakReference<View> anchorViewRef;
    private final Context context;
    private long nuxDisplayTime;
    private PopupContentView popupContent;
    private PopupWindow popupWindow;
    private final ViewTreeObserver.OnScrollChangedListener scrollListener;
    private Style style;
    private final String text;

    /* compiled from: ToolTipPopup.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/login/widget/ToolTipPopup$Style;", "", "(Ljava/lang/String;I)V", "BLUE", "BLACK", "facebook-login_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Style {
        BLUE,
        BLACK
    }

    public ToolTipPopup(String text, View anchor) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        this.text = text;
        this.anchorViewRef = new WeakReference<>(anchor);
        Context context = anchor.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "anchor.context");
        this.context = context;
        this.style = Style.BLUE;
        this.nuxDisplayTime = 6000L;
        this.scrollListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.facebook.login.widget.ToolTipPopup$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                ToolTipPopup.scrollListener$lambda$1(this.f$0);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scrollListener$lambda$1(ToolTipPopup this$0) {
        PopupWindow popupWindow;
        if (CrashShieldHandler.isObjectCrashing(ToolTipPopup.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.anchorViewRef.get() == null || (popupWindow = this$0.popupWindow) == null || !popupWindow.isShowing()) {
                return;
            }
            if (popupWindow.isAboveAnchor()) {
                PopupContentView popupContentView = this$0.popupContent;
                if (popupContentView != null) {
                    popupContentView.showBottomArrow();
                    return;
                }
                return;
            }
            PopupContentView popupContentView2 = this$0.popupContent;
            if (popupContentView2 != null) {
                popupContentView2.showTopArrow();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ToolTipPopup.class);
        }
    }

    public final void setStyle(Style style) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(style, "style");
            this.style = style;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void show() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (this.anchorViewRef.get() != null) {
                PopupContentView popupContentView = new PopupContentView(this, this.context);
                this.popupContent = popupContentView;
                View viewFindViewById = popupContentView.findViewById(R.id.com_facebook_tooltip_bubble_view_text_body);
                Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
                ((TextView) viewFindViewById).setText(this.text);
                if (this.style == Style.BLUE) {
                    popupContentView.getBodyFrame().setBackgroundResource(R.drawable.com_facebook_tooltip_blue_background);
                    popupContentView.getBottomArrow().setImageResource(R.drawable.com_facebook_tooltip_blue_bottomnub);
                    popupContentView.getTopArrow().setImageResource(R.drawable.com_facebook_tooltip_blue_topnub);
                    popupContentView.getXOut().setImageResource(R.drawable.com_facebook_tooltip_blue_xout);
                } else {
                    popupContentView.getBodyFrame().setBackgroundResource(R.drawable.com_facebook_tooltip_black_background);
                    popupContentView.getBottomArrow().setImageResource(R.drawable.com_facebook_tooltip_black_bottomnub);
                    popupContentView.getTopArrow().setImageResource(R.drawable.com_facebook_tooltip_black_topnub);
                    popupContentView.getXOut().setImageResource(R.drawable.com_facebook_tooltip_black_xout);
                }
                Context context = this.context;
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                View decorView = ((Activity) context).getWindow().getDecorView();
                Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
                int width = decorView.getWidth();
                int height = decorView.getHeight();
                registerObserver();
                popupContentView.measure(View.MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE));
                PopupWindow popupWindow = new PopupWindow(popupContentView, popupContentView.getMeasuredWidth(), popupContentView.getMeasuredHeight());
                this.popupWindow = popupWindow;
                popupWindow.showAsDropDown(this.anchorViewRef.get());
                updateArrows();
                if (this.nuxDisplayTime > 0) {
                    popupContentView.postDelayed(new Runnable() { // from class: com.facebook.login.widget.ToolTipPopup$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            ToolTipPopup.show$lambda$2(this.f$0);
                        }
                    }, this.nuxDisplayTime);
                }
                popupWindow.setTouchable(true);
                popupContentView.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.login.widget.ToolTipPopup$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ToolTipPopup.show$lambda$3(this.f$0, view);
                    }
                });
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$2(ToolTipPopup this$0) {
        if (CrashShieldHandler.isObjectCrashing(ToolTipPopup.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.dismiss();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ToolTipPopup.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$3(ToolTipPopup this$0, View view) {
        if (CrashShieldHandler.isObjectCrashing(ToolTipPopup.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.dismiss();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ToolTipPopup.class);
        }
    }

    public final void setNuxDisplayTime(long displayTime) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.nuxDisplayTime = displayTime;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void updateArrows() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            PopupWindow popupWindow = this.popupWindow;
            if (popupWindow == null || !popupWindow.isShowing()) {
                return;
            }
            if (popupWindow.isAboveAnchor()) {
                PopupContentView popupContentView = this.popupContent;
                if (popupContentView != null) {
                    popupContentView.showBottomArrow();
                    return;
                }
                return;
            }
            PopupContentView popupContentView2 = this.popupContent;
            if (popupContentView2 != null) {
                popupContentView2.showTopArrow();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void dismiss() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            unregisterObserver();
            PopupWindow popupWindow = this.popupWindow;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void registerObserver() {
        ViewTreeObserver viewTreeObserver;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            unregisterObserver();
            View view = this.anchorViewRef.get();
            if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null) {
                return;
            }
            viewTreeObserver.addOnScrollChangedListener(this.scrollListener);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void unregisterObserver() {
        ViewTreeObserver viewTreeObserver;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            View view = this.anchorViewRef.get();
            if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null) {
                return;
            }
            viewTreeObserver.removeOnScrollChangedListener(this.scrollListener);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* compiled from: ToolTipPopup.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/facebook/login/widget/ToolTipPopup$PopupContentView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Lcom/facebook/login/widget/ToolTipPopup;Landroid/content/Context;)V", "bodyFrame", "Landroid/view/View;", "getBodyFrame", "()Landroid/view/View;", "bottomArrow", "Landroid/widget/ImageView;", "getBottomArrow", "()Landroid/widget/ImageView;", "topArrow", "getTopArrow", "xOut", "getXOut", "showBottomArrow", "", "showTopArrow", "facebook-login_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class PopupContentView extends FrameLayout {
        private final View bodyFrame;
        private final ImageView bottomArrow;
        final /* synthetic */ ToolTipPopup this$0;
        private final ImageView topArrow;
        private final ImageView xOut;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PopupContentView(ToolTipPopup toolTipPopup, Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = toolTipPopup;
            LayoutInflater.from(context).inflate(R.layout.com_facebook_tooltip_bubble, this);
            View viewFindViewById = findViewById(R.id.com_facebook_tooltip_bubble_view_top_pointer);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.ImageView");
            this.topArrow = (ImageView) viewFindViewById;
            View viewFindViewById2 = findViewById(R.id.com_facebook_tooltip_bubble_view_bottom_pointer);
            Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.ImageView");
            this.bottomArrow = (ImageView) viewFindViewById2;
            View viewFindViewById3 = findViewById(R.id.com_facebook_body_frame);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(R.id.com_facebook_body_frame)");
            this.bodyFrame = viewFindViewById3;
            View viewFindViewById4 = findViewById(R.id.com_facebook_button_xout);
            Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.ImageView");
            this.xOut = (ImageView) viewFindViewById4;
        }

        public final ImageView getTopArrow() {
            return this.topArrow;
        }

        public final ImageView getBottomArrow() {
            return this.bottomArrow;
        }

        public final View getBodyFrame() {
            return this.bodyFrame;
        }

        public final ImageView getXOut() {
            return this.xOut;
        }

        public final void showTopArrow() {
            this.topArrow.setVisibility(0);
            this.bottomArrow.setVisibility(4);
        }

        public final void showBottomArrow() {
            this.topArrow.setVisibility(4);
            this.bottomArrow.setVisibility(0);
        }
    }
}
