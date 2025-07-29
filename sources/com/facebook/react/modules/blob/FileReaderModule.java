package com.facebook.react.modules.blob;

import android.util.Base64;
import com.facebook.fbreact.specs.NativeFileReaderModuleSpec;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import io.sentry.rrweb.RRWebVideoEvent;

@ReactModule(name = NativeFileReaderModuleSpec.NAME)
/* loaded from: classes4.dex */
public class FileReaderModule extends NativeFileReaderModuleSpec {
    private static final String ERROR_INVALID_BLOB = "ERROR_INVALID_BLOB";

    public FileReaderModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private BlobModule getBlobModule(String str) {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            return (BlobModule) reactApplicationContextIfActiveOrWarn.getNativeModule(BlobModule.class);
        }
        return null;
    }

    @Override // com.facebook.fbreact.specs.NativeFileReaderModuleSpec
    public void readAsText(ReadableMap readableMap, String str, Promise promise) {
        BlobModule blobModule = getBlobModule("readAsText");
        if (blobModule == null) {
            promise.reject(new IllegalStateException("Could not get BlobModule from ReactApplicationContext"));
            return;
        }
        if (readableMap == null) {
            promise.reject(ERROR_INVALID_BLOB, "The specified blob is null");
            return;
        }
        byte[] bArrResolve = blobModule.resolve(readableMap.getString("blobId"), readableMap.getInt("offset"), readableMap.getInt(RRWebVideoEvent.JsonKeys.SIZE));
        if (bArrResolve == null) {
            promise.reject(ERROR_INVALID_BLOB, "The specified blob is invalid");
            return;
        }
        try {
            promise.resolve(new String(bArrResolve, str));
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeFileReaderModuleSpec
    public void readAsDataURL(ReadableMap readableMap, Promise promise) {
        BlobModule blobModule = getBlobModule("readAsDataURL");
        if (blobModule == null) {
            promise.reject(new IllegalStateException("Could not get BlobModule from ReactApplicationContext"));
            return;
        }
        if (readableMap == null) {
            promise.reject(ERROR_INVALID_BLOB, "The specified blob is null");
            return;
        }
        byte[] bArrResolve = blobModule.resolve(readableMap.getString("blobId"), readableMap.getInt("offset"), readableMap.getInt(RRWebVideoEvent.JsonKeys.SIZE));
        if (bArrResolve == null) {
            promise.reject(ERROR_INVALID_BLOB, "The specified blob is invalid");
            return;
        }
        try {
            StringBuilder sb = new StringBuilder("data:");
            if (!readableMap.hasKey("type") || readableMap.getString("type").isEmpty()) {
                sb.append("application/octet-stream");
            } else {
                sb.append(readableMap.getString("type"));
            }
            sb.append(";base64,");
            sb.append(Base64.encodeToString(bArrResolve, 2));
            promise.resolve(sb.toString());
        } catch (Exception e) {
            promise.reject(e);
        }
    }
}
