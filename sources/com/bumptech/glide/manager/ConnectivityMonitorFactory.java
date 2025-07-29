package com.bumptech.glide.manager;

import android.content.Context;
import com.bumptech.glide.manager.ConnectivityMonitor;

/* loaded from: classes4.dex */
public interface ConnectivityMonitorFactory {
    ConnectivityMonitor build(Context context, ConnectivityMonitor.ConnectivityListener connectivityListener);
}
