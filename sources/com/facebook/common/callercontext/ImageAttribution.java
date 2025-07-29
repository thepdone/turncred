package com.facebook.common.callercontext;

import javax.annotation.Nullable;

/* loaded from: classes4.dex */
public interface ImageAttribution {
    String getCallingClassName();

    @Nullable
    ContextChain getContextChain();
}
