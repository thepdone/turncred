package cl.json.social;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.os.Build;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;

/* loaded from: classes4.dex */
public class TargetChosenReceiver extends BroadcastReceiver {
    private static final String EXTRA_RECEIVER_TOKEN = "receiver_token";
    private static final Object LOCK = new Object();
    private static Promise callback;
    private static TargetChosenReceiver sLastRegisteredReceiver;
    private static String sTargetChosenReceiveAction;

    public static boolean isSupported() {
        return true;
    }

    public static void registerCallbacks(Promise promise) {
        callback = promise;
    }

    public static IntentSender getSharingSenderIntent(ReactContext reactContext) {
        synchronized (LOCK) {
            if (sTargetChosenReceiveAction == null) {
                sTargetChosenReceiveAction = reactContext.getPackageName() + "/" + TargetChosenReceiver.class.getName() + "_ACTION";
            }
            Context applicationContext = reactContext.getApplicationContext();
            TargetChosenReceiver targetChosenReceiver = sLastRegisteredReceiver;
            if (targetChosenReceiver != null) {
                applicationContext.unregisterReceiver(targetChosenReceiver);
            }
            sLastRegisteredReceiver = new TargetChosenReceiver();
            if (Build.VERSION.SDK_INT >= 34 && applicationContext.getApplicationInfo().targetSdkVersion >= 34) {
                applicationContext.registerReceiver(sLastRegisteredReceiver, new IntentFilter(sTargetChosenReceiveAction), 2);
            } else {
                applicationContext.registerReceiver(sLastRegisteredReceiver, new IntentFilter(sTargetChosenReceiveAction));
            }
        }
        Intent intent = new Intent(sTargetChosenReceiveAction);
        intent.setPackage(reactContext.getPackageName());
        intent.setClass(reactContext.getApplicationContext(), TargetChosenReceiver.class);
        intent.putExtra(EXTRA_RECEIVER_TOKEN, sLastRegisteredReceiver.hashCode());
        return PendingIntent.getBroadcast(reactContext, 0, intent, 1409286144).getIntentSender();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        synchronized (LOCK) {
            if (sLastRegisteredReceiver != this) {
                return;
            }
            context.getApplicationContext().unregisterReceiver(sLastRegisteredReceiver);
            sLastRegisteredReceiver = null;
            if (intent.hasExtra(EXTRA_RECEIVER_TOKEN) && intent.getIntExtra(EXTRA_RECEIVER_TOKEN, 0) == hashCode()) {
                ComponentName componentName = (ComponentName) intent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT");
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putBoolean("success", true);
                if (componentName != null) {
                    writableMapCreateMap.putString("message", componentName.flattenToString());
                } else {
                    writableMapCreateMap.putString("message", "OK");
                }
                callbackResolve(writableMapCreateMap);
            }
        }
    }

    public static void callbackResolve(Object obj) {
        Promise promise = callback;
        if (promise != null) {
            promise.resolve(obj);
        }
        callback = null;
    }

    public static void callbackReject(String str) {
        Promise promise = callback;
        if (promise != null) {
            promise.reject(str);
        }
        callback = null;
    }
}
