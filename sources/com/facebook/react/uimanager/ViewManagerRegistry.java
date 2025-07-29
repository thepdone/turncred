package com.facebook.react.uimanager;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class ViewManagerRegistry implements ComponentCallbacks2 {
    private final ViewManagerResolver mViewManagerResolver;
    private final Map<String, ViewManager> mViewManagers;

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    public ViewManagerRegistry(ViewManagerResolver viewManagerResolver) {
        this.mViewManagers = MapBuilder.newHashMap();
        this.mViewManagerResolver = viewManagerResolver;
    }

    public ViewManagerRegistry(List<ViewManager> list) {
        HashMap mapNewHashMap = MapBuilder.newHashMap();
        for (ViewManager viewManager : list) {
            mapNewHashMap.put(viewManager.getName(), viewManager);
        }
        this.mViewManagers = mapNewHashMap;
        this.mViewManagerResolver = null;
    }

    public ViewManagerRegistry(Map<String, ViewManager> map) {
        this.mViewManagers = map == null ? MapBuilder.newHashMap() : map;
        this.mViewManagerResolver = null;
    }

    public synchronized ViewManager get(String str) {
        ViewManager viewManager = this.mViewManagers.get(str);
        if (viewManager != null) {
            return viewManager;
        }
        String str2 = "RCT" + str;
        ViewManager viewManager2 = this.mViewManagers.get(str2);
        if (viewManager2 != null) {
            return viewManager2;
        }
        if (this.mViewManagerResolver != null) {
            ViewManager viewManagerFromResolver = getViewManagerFromResolver(str);
            if (viewManagerFromResolver != null) {
                return viewManagerFromResolver;
            }
            ViewManager viewManagerFromResolver2 = getViewManagerFromResolver(str2);
            if (viewManagerFromResolver2 != null) {
                return viewManagerFromResolver2;
            }
            throw new IllegalViewOperationException("ViewManagerResolver returned null for either " + str + " or " + str2 + ", existing names are: " + this.mViewManagerResolver.getViewManagerNames());
        }
        throw new IllegalViewOperationException("No ViewManager found for class " + str);
    }

    private ViewManager getViewManagerFromResolver(String str) {
        ViewManager viewManager = this.mViewManagerResolver.getViewManager(str);
        if (viewManager != null) {
            this.mViewManagers.put(str, viewManager);
        }
        return viewManager;
    }

    synchronized ViewManager getViewManagerIfExists(String str) {
        ViewManager viewManager = this.mViewManagers.get(str);
        if (viewManager != null) {
            return viewManager;
        }
        if (this.mViewManagerResolver == null) {
            return null;
        }
        return getViewManagerFromResolver(str);
    }

    public void onSurfaceStopped(final int i) {
        final ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.mViewManagers.values());
        }
        Runnable runnable = new Runnable() { // from class: com.facebook.react.uimanager.ViewManagerRegistry$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ViewManagerRegistry.lambda$onSurfaceStopped$0(arrayList, i);
            }
        };
        if (UiThreadUtil.isOnUiThread()) {
            runnable.run();
        } else {
            UiThreadUtil.runOnUiThread(runnable);
        }
    }

    static /* synthetic */ void lambda$onSurfaceStopped$0(List list, int i) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ViewManager) it.next()).onSurfaceStopped(i);
        }
    }

    public void invalidate() {
        final ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.mViewManagers.values());
        }
        Runnable runnable = new Runnable() { // from class: com.facebook.react.uimanager.ViewManagerRegistry$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ViewManagerRegistry.lambda$invalidate$1(arrayList);
            }
        };
        if (UiThreadUtil.isOnUiThread()) {
            runnable.run();
        } else {
            UiThreadUtil.runOnUiThread(runnable);
        }
    }

    static /* synthetic */ void lambda$invalidate$1(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ViewManager) it.next()).invalidate();
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        final ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.mViewManagers.values());
        }
        Runnable runnable = new Runnable() { // from class: com.facebook.react.uimanager.ViewManagerRegistry.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ViewManager) it.next()).trimMemory();
                }
            }
        };
        if (UiThreadUtil.isOnUiThread()) {
            runnable.run();
        } else {
            UiThreadUtil.runOnUiThread(runnable);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        onTrimMemory(0);
    }
}
