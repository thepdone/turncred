package com.swmansion.rnscreens;

import androidx.appcompat.widget.Toolbar;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* compiled from: ScreenStackFragmentWrapper.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0003H&¨\u0006\u000e"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackFragmentWrapper;", "Lcom/swmansion/rnscreens/ScreenFragmentWrapper;", "canNavigateBack", "", "dismissFromContainer", "", "removeToolbar", "setToolbar", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "setToolbarShadowHidden", ViewProps.HIDDEN, "setToolbarTranslucent", "translucent", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ScreenStackFragmentWrapper extends ScreenFragmentWrapper {
    boolean canNavigateBack();

    void dismissFromContainer();

    void removeToolbar();

    void setToolbar(Toolbar toolbar);

    void setToolbarShadowHidden(boolean hidden);

    void setToolbarTranslucent(boolean translucent);
}
