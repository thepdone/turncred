package com.facebook.react.uimanager;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.ReadableArray;
import kotlin.Metadata;

/* compiled from: ViewManagerDelegate.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u0003J)\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000bJ)\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Lcom/facebook/react/uimanager/ViewManagerDelegate;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "", "receiveCommand", "", ViewHierarchyConstants.VIEW_KEY, "commandName", "", "args", "Lcom/facebook/react/bridge/ReadableArray;", "(Landroid/view/View;Ljava/lang/String;Lcom/facebook/react/bridge/ReadableArray;)V", "setProperty", "propName", "value", "(Landroid/view/View;Ljava/lang/String;Ljava/lang/Object;)V", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ViewManagerDelegate<T extends View> {
    void receiveCommand(T view, String commandName, ReadableArray args);

    void setProperty(T view, String propName, Object value);
}
