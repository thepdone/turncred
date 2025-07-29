package com.bumptech.glide;

import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.AppGlideModule;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes4.dex */
abstract class GeneratedAppGlideModule extends AppGlideModule {
    RequestManagerRetriever.RequestManagerFactory getRequestManagerFactory() {
        return null;
    }

    GeneratedAppGlideModule() {
    }

    Set<Class<?>> getExcludedModuleClasses() {
        return new HashSet();
    }
}
