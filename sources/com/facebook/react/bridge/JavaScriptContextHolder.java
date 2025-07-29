package com.facebook.react.bridge;

/* loaded from: classes4.dex */
public class JavaScriptContextHolder {
    private long mContext;

    public JavaScriptContextHolder(long j) {
        this.mContext = j;
    }

    public long get() {
        return this.mContext;
    }

    public synchronized void clear() {
        this.mContext = 0L;
    }
}
