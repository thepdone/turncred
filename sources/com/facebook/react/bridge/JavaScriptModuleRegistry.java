package com.facebook.react.bridge;

import com.facebook.react.common.build.ReactBuildConfig;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes4.dex */
public final class JavaScriptModuleRegistry {
    private final HashMap<Class<? extends JavaScriptModule>, JavaScriptModule> mModuleInstances = new HashMap<>();

    public synchronized <T extends JavaScriptModule> T getJavaScriptModule(CatalystInstance catalystInstance, Class<T> cls) {
        T t = (T) this.mModuleInstances.get(cls);
        if (t != null) {
            return t;
        }
        T t2 = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new JavaScriptModuleInvocationHandler(catalystInstance, cls));
        this.mModuleInstances.put(cls, t2);
        return t2;
    }

    private static class JavaScriptModuleInvocationHandler implements InvocationHandler {
        private final CatalystInstance mCatalystInstance;
        private final Class<? extends JavaScriptModule> mModuleInterface;
        private String mName;

        public JavaScriptModuleInvocationHandler(CatalystInstance catalystInstance, Class<? extends JavaScriptModule> cls) throws SecurityException {
            this.mCatalystInstance = catalystInstance;
            this.mModuleInterface = cls;
            if (ReactBuildConfig.DEBUG) {
                HashSet hashSet = new HashSet();
                for (Method method : cls.getDeclaredMethods()) {
                    if (!hashSet.add(method.getName())) {
                        throw new AssertionError("Method overloading is unsupported: " + this.mModuleInterface.getName() + "#" + method.getName());
                    }
                }
            }
        }

        private String getJSModuleName() {
            if (this.mName == null) {
                this.mName = JavaScriptModuleRegistry.getJSModuleName(this.mModuleInterface);
            }
            return this.mName;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            this.mCatalystInstance.callFunction(getJSModuleName(), method.getName(), objArr != null ? Arguments.fromJavaArgs(objArr) : new WritableNativeArray());
            return null;
        }
    }

    public static String getJSModuleName(Class<? extends JavaScriptModule> cls) {
        String simpleName = cls.getSimpleName();
        int iLastIndexOf = simpleName.lastIndexOf(36);
        return iLastIndexOf != -1 ? simpleName.substring(iLastIndexOf + 1) : simpleName;
    }
}
