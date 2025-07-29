package com.facebook.react.viewmanagers;

import android.view.View;

/* loaded from: classes4.dex */
public interface RNSSearchBarManagerInterface<T extends View> {
    void blur(T t);

    void cancelSearch(T t);

    void clearText(T t);

    void focus(T t);

    void setAutoCapitalize(T t, String str);

    void setBarTintColor(T t, Integer num);

    void setCancelButtonText(T t, String str);

    void setDisableBackButtonOverride(T t, boolean z);

    void setHeaderIconColor(T t, Integer num);

    void setHideNavigationBar(T t, boolean z);

    void setHideWhenScrolling(T t, boolean z);

    void setHintTextColor(T t, Integer num);

    void setInputType(T t, String str);

    void setObscureBackground(T t, boolean z);

    void setPlaceholder(T t, String str);

    void setPlacement(T t, String str);

    void setShouldShowHintSearchIcon(T t, boolean z);

    void setText(T t, String str);

    void setTextColor(T t, Integer num);

    void setTintColor(T t, Integer num);

    void toggleCancelButton(T t, boolean z);
}
