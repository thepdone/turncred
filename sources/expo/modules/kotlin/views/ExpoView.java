package expo.modules.kotlin.views;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import expo.modules.kotlin.AppContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExpoView.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u000eH\u0007J\b\u0010\u0012\u001a\u00020\u000eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lexpo/modules/kotlin/views/ExpoView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "getAppContext", "()Lexpo/modules/kotlin/AppContext;", "shouldUseAndroidLayout", "", "getShouldUseAndroidLayout", "()Z", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "measureAndLayout", "requestLayout", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ExpoView extends LinearLayout {
    public static final int $stable = 8;
    private final AppContext appContext;
    private final boolean shouldUseAndroidLayout;

    public final AppContext getAppContext() {
        return this.appContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoView(Context context, AppContext appContext) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContext = appContext;
    }

    public boolean getShouldUseAndroidLayout() {
        return this.shouldUseAndroidLayout;
    }

    public final void measureAndLayout() {
        measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        layout(getLeft(), getTop(), getRight(), getBottom());
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        if (getShouldUseAndroidLayout()) {
            post(new Runnable() { // from class: expo.modules.kotlin.views.ExpoView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ExpoView.requestLayout$lambda$0(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestLayout$lambda$0(ExpoView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.measureAndLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getClipToPadding()) {
            BackgroundStyleApplicator.clipToPaddingBox(this, canvas);
            super.dispatchDraw(canvas);
        }
    }
}
