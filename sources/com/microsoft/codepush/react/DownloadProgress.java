package com.microsoft.codepush.react;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;

/* loaded from: classes5.dex */
class DownloadProgress {
    private long mReceivedBytes;
    private long mTotalBytes;

    public DownloadProgress(long j, long j2) {
        this.mTotalBytes = j;
        this.mReceivedBytes = j2;
    }

    public WritableMap createWritableMap() {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        long j = this.mTotalBytes;
        if (j < 2147483647L) {
            writableNativeMap.putInt("totalBytes", (int) j);
            writableNativeMap.putInt("receivedBytes", (int) this.mReceivedBytes);
        } else {
            writableNativeMap.putDouble("totalBytes", j);
            writableNativeMap.putDouble("receivedBytes", this.mReceivedBytes);
        }
        return writableNativeMap;
    }

    public boolean isCompleted() {
        return this.mTotalBytes == this.mReceivedBytes;
    }
}
