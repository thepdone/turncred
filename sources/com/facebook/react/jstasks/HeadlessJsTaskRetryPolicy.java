package com.facebook.react.jstasks;

import javax.annotation.CheckReturnValue;

/* loaded from: classes4.dex */
public interface HeadlessJsTaskRetryPolicy {
    boolean canRetry();

    HeadlessJsTaskRetryPolicy copy();

    int getDelay();

    @CheckReturnValue
    HeadlessJsTaskRetryPolicy update();
}
