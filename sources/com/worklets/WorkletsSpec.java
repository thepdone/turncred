package com.worklets;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

/* loaded from: classes5.dex */
abstract class WorkletsSpec extends ReactContextBaseJavaModule {
    public abstract boolean install();

    WorkletsSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }
}
