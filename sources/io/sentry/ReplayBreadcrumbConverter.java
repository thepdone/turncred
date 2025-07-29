package io.sentry;

import io.sentry.rrweb.RRWebEvent;

/* loaded from: classes5.dex */
public interface ReplayBreadcrumbConverter {
    RRWebEvent convert(Breadcrumb breadcrumb);
}
