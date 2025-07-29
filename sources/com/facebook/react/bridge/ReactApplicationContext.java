package com.facebook.react.bridge;

import android.content.Context;

/* loaded from: classes4.dex */
public abstract class ReactApplicationContext extends ReactContext {
    public ReactApplicationContext(Context context) {
        super(context.getApplicationContext());
    }
}
