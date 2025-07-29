package com.facebook.react.modules.network;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.net.SocketTimeoutException;

/* loaded from: classes4.dex */
public class ResponseUtil {
    public static void onDataSend(ReactApplicationContext reactApplicationContext, int i, long j, long j2) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        writableArrayCreateArray.pushInt(i);
        writableArrayCreateArray.pushInt((int) j);
        writableArrayCreateArray.pushInt((int) j2);
        if (reactApplicationContext != null) {
            reactApplicationContext.emitDeviceEvent("didSendNetworkData", writableArrayCreateArray);
        }
    }

    public static void onIncrementalDataReceived(ReactApplicationContext reactApplicationContext, int i, String str, long j, long j2) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        writableArrayCreateArray.pushInt(i);
        writableArrayCreateArray.pushString(str);
        writableArrayCreateArray.pushInt((int) j);
        writableArrayCreateArray.pushInt((int) j2);
        if (reactApplicationContext != null) {
            reactApplicationContext.emitDeviceEvent("didReceiveNetworkIncrementalData", writableArrayCreateArray);
        }
    }

    public static void onDataReceivedProgress(ReactApplicationContext reactApplicationContext, int i, long j, long j2) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        writableArrayCreateArray.pushInt(i);
        writableArrayCreateArray.pushInt((int) j);
        writableArrayCreateArray.pushInt((int) j2);
        if (reactApplicationContext != null) {
            reactApplicationContext.emitDeviceEvent("didReceiveNetworkDataProgress", writableArrayCreateArray);
        }
    }

    public static void onDataReceived(ReactApplicationContext reactApplicationContext, int i, String str) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        writableArrayCreateArray.pushInt(i);
        writableArrayCreateArray.pushString(str);
        if (reactApplicationContext != null) {
            reactApplicationContext.emitDeviceEvent("didReceiveNetworkData", writableArrayCreateArray);
        }
    }

    public static void onDataReceived(ReactApplicationContext reactApplicationContext, int i, WritableMap writableMap) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        writableArrayCreateArray.pushInt(i);
        writableArrayCreateArray.pushMap(writableMap);
        if (reactApplicationContext != null) {
            reactApplicationContext.emitDeviceEvent("didReceiveNetworkData", writableArrayCreateArray);
        }
    }

    public static void onRequestError(ReactApplicationContext reactApplicationContext, int i, String str, Throwable th) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        writableArrayCreateArray.pushInt(i);
        writableArrayCreateArray.pushString(str);
        if (th != null && th.getClass() == SocketTimeoutException.class) {
            writableArrayCreateArray.pushBoolean(true);
        }
        if (reactApplicationContext != null) {
            reactApplicationContext.emitDeviceEvent("didCompleteNetworkResponse", writableArrayCreateArray);
        }
    }

    public static void onRequestSuccess(ReactApplicationContext reactApplicationContext, int i) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        writableArrayCreateArray.pushInt(i);
        writableArrayCreateArray.pushNull();
        if (reactApplicationContext != null) {
            reactApplicationContext.emitDeviceEvent("didCompleteNetworkResponse", writableArrayCreateArray);
        }
    }

    public static void onResponseReceived(ReactApplicationContext reactApplicationContext, int i, int i2, WritableMap writableMap, String str) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        writableArrayCreateArray.pushInt(i);
        writableArrayCreateArray.pushInt(i2);
        writableArrayCreateArray.pushMap(writableMap);
        writableArrayCreateArray.pushString(str);
        if (reactApplicationContext != null) {
            reactApplicationContext.emitDeviceEvent("didReceiveNetworkResponse", writableArrayCreateArray);
        }
    }
}
