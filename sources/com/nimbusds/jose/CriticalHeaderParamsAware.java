package com.nimbusds.jose;

import java.util.Set;

/* loaded from: classes5.dex */
public interface CriticalHeaderParamsAware {
    Set<String> getDeferredCriticalHeaderParams();

    Set<String> getProcessedCriticalHeaderParams();
}
