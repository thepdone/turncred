package com.facebook.reactnative.androidsdk;

import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import java.util.Timer;
import java.util.TimerTask;

@ReactModule(name = FBProfileModule.NAME)
/* loaded from: classes3.dex */
public class FBProfileModule extends ReactContextBaseJavaModule {
    public static final String NAME = "FBProfile";
    private ProfileTracker mProfileTracker;

    public FBProfileModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void getCurrentProfile(final Callback callback) {
        if (Profile.getCurrentProfile() == null) {
            final Timer timer = new Timer();
            synchronized (timer) {
                timer.schedule(new TimerTask() { // from class: com.facebook.reactnative.androidsdk.FBProfileModule.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        timer.cancel();
                        callback.invoke(new Object[0]);
                    }
                }, 30000L);
                this.mProfileTracker = new ProfileTracker() { // from class: com.facebook.reactnative.androidsdk.FBProfileModule.2
                    @Override // com.facebook.ProfileTracker
                    protected void onCurrentProfileChanged(Profile profile, Profile profile2) {
                        timer.cancel();
                        FBProfileModule.this.mProfileTracker.stopTracking();
                        callback.invoke(Utility.profileToReactMap(profile2));
                    }
                };
            }
            return;
        }
        callback.invoke(Utility.profileToReactMap(Profile.getCurrentProfile()));
    }
}
