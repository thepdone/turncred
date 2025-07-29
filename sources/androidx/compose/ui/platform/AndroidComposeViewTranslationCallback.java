package androidx.compose.ui.platform;

import android.view.View;
import android.view.translation.ViewTranslationCallback;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidComposeView.android.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewTranslationCallback;", "Landroid/view/translation/ViewTranslationCallback;", "()V", "onClearTranslation", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "onHideTranslation", "onShowTranslation", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class AndroidComposeViewTranslationCallback implements ViewTranslationCallback {
    public static final AndroidComposeViewTranslationCallback INSTANCE = new AndroidComposeViewTranslationCallback();

    private AndroidComposeViewTranslationCallback() {
    }

    @Override // android.view.translation.ViewTranslationCallback
    public boolean onShowTranslation(View view) {
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.compose.ui.platform.AndroidComposeView");
        ((AndroidComposeView) view).getContentCaptureManager().onShowTranslation$ui_release();
        return true;
    }

    @Override // android.view.translation.ViewTranslationCallback
    public boolean onHideTranslation(View view) {
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.compose.ui.platform.AndroidComposeView");
        ((AndroidComposeView) view).getContentCaptureManager().onHideTranslation$ui_release();
        return true;
    }

    @Override // android.view.translation.ViewTranslationCallback
    public boolean onClearTranslation(View view) {
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.compose.ui.platform.AndroidComposeView");
        ((AndroidComposeView) view).getContentCaptureManager().onClearTranslation$ui_release();
        return true;
    }
}
