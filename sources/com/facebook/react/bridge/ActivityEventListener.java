package com.facebook.react.bridge;

import android.app.Activity;
import android.content.Intent;

/* loaded from: classes4.dex */
public interface ActivityEventListener {
    void onActivityResult(Activity activity, int i, int i2, Intent intent);

    void onNewIntent(Intent intent);

    default void onUserLeaveHint(Activity activity) {
    }
}
