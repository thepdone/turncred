package expo.modules.kotlin.views;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ComposeProps;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExpoComposeView.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0014J\u001e\u0010\u001e\u001a\u00020\u001a2\u0011\u0010\u001f\u001a\r\u0012\u0004\u0012\u00020\u001a0 ¢\u0006\u0002\b!¢\u0006\u0002\u0010\"R!\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00018\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Lexpo/modules/kotlin/views/ExpoComposeView;", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/views/ComposeProps;", "Lexpo/modules/kotlin/views/ExpoView;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "layout", "Landroidx/compose/ui/platform/ComposeView;", "getLayout$annotations", "()V", "getLayout", "()Landroidx/compose/ui/platform/ComposeView;", "layout$delegate", "Lkotlin/Lazy;", "props", "getProps", "()Lexpo/modules/kotlin/views/ComposeProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "shouldUseAndroidLayout", "", "getShouldUseAndroidLayout", "()Z", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "setContent", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;)V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ExpoComposeView<T extends ComposeProps> extends ExpoView {
    public static final int $stable = 8;

    /* renamed from: layout$delegate, reason: from kotlin metadata */
    private final Lazy layout;
    private final T props;
    private final boolean shouldUseAndroidLayout;

    public static /* synthetic */ void getLayout$annotations() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoComposeView(final Context context, AppContext appContext) {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.shouldUseAndroidLayout = true;
        this.layout = LazyKt.lazy(new Function0<ComposeView>() { // from class: expo.modules.kotlin.views.ExpoComposeView$layout$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ComposeView invoke() {
                ComposeView composeView = new ComposeView(context, null, 0, 6, null);
                ExpoComposeView<T> expoComposeView = this;
                composeView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
                expoComposeView.addView(composeView);
                return composeView;
            }
        });
    }

    public T getProps() {
        return this.props;
    }

    @Override // expo.modules.kotlin.views.ExpoView
    public boolean getShouldUseAndroidLayout() {
        return this.shouldUseAndroidLayout;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!isAttachedToWindow()) {
            setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public final ComposeView getLayout() {
        return (ComposeView) this.layout.getValue();
    }

    public final void setContent(final Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        getLayout().setContent(ComposableLambdaKt.composableLambdaInstance(739263013, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.kotlin.views.ExpoComposeView.setContent.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                if ((i & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(739263013, i, -1, "expo.modules.kotlin.views.ExpoComposeView.setContent.<anonymous> (ExpoComposeView.kt:41)");
                }
                content.invoke(composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }
}
