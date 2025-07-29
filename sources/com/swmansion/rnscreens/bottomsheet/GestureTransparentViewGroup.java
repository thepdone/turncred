package com.swmansion.rnscreens.bottomsheet;

import android.content.Context;
import android.widget.FrameLayout;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GestureTransparentViewGroup.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u00012\u00020\u0002:\u0001\bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/swmansion/rnscreens/bottomsheet/GestureTransparentViewGroup;", "Landroid/widget/FrameLayout;", "Lcom/facebook/react/uimanager/ReactPointerEventsView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getPointerEvents", "Lcom/facebook/react/uimanager/PointerEvents;", "Companion", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GestureTransparentViewGroup extends FrameLayout implements ReactPointerEventsView {
    public static final String TAG = "GestureTransparentFrameLayout";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GestureTransparentViewGroup(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.facebook.react.uimanager.ReactPointerEventsView
    public PointerEvents getPointerEvents() {
        return PointerEvents.BOX_NONE;
    }
}
