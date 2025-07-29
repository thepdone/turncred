package io.sentry;

/* loaded from: classes5.dex */
public class SpanOptions {
    private boolean trimStart = false;
    private boolean trimEnd = false;
    private boolean isIdle = false;

    public boolean isTrimStart() {
        return this.trimStart;
    }

    public boolean isTrimEnd() {
        return this.trimEnd;
    }

    public boolean isIdle() {
        return this.isIdle;
    }

    public void setTrimStart(boolean z) {
        this.trimStart = z;
    }

    public void setTrimEnd(boolean z) {
        this.trimEnd = z;
    }

    public void setIdle(boolean z) {
        this.isIdle = z;
    }
}
