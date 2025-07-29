package androidx.compose.ui.hapticfeedback;

import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;

/* compiled from: PlatformHapticFeedback.android.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/hapticfeedback/PlatformHapticFeedback;", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "(Landroid/view/View;)V", "performHapticFeedback", "", "hapticFeedbackType", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "performHapticFeedback-CdsT49E", "(I)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PlatformHapticFeedback implements HapticFeedback {
    public static final int $stable = 8;
    private final View view;

    public PlatformHapticFeedback(View view) {
        this.view = view;
    }

    @Override // androidx.compose.ui.hapticfeedback.HapticFeedback
    /* renamed from: performHapticFeedback-CdsT49E */
    public void mo3005performHapticFeedbackCdsT49E(int hapticFeedbackType) {
        if (HapticFeedbackType.m3009equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m3013getLongPress5zf0vsI())) {
            this.view.performHapticFeedback(0);
        } else if (HapticFeedbackType.m3009equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m3014getTextHandleMove5zf0vsI())) {
            this.view.performHapticFeedback(9);
        }
    }
}
