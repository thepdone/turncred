package expo.modules.taskManager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.LifecycleEventListener;
import expo.modules.core.interfaces.services.UIManager;
import expo.modules.interfaces.constants.ConstantsInterface;
import expo.modules.interfaces.taskManager.TaskConsumerInterface;
import expo.modules.interfaces.taskManager.TaskManagerInterface;
import expo.modules.interfaces.taskManager.TaskServiceInterface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class TaskManagerInternalModule implements InternalModule, TaskManagerInterface, LifecycleEventListener {
    private ConstantsInterface mConstants;
    private WeakReference<Context> mContextRef;
    private EmitEventWrapper mEmitEventWrapper;
    private List<Bundle> mEventsQueue = new ArrayList();
    private TaskServiceInterface mTaskService;
    private UIManager mUIManager;

    public TaskManagerInternalModule(Context context) {
        this.mContextRef = new WeakReference<>(context);
    }

    @Override // expo.modules.core.interfaces.InternalModule
    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(TaskManagerInterface.class);
    }

    public void setEmitEventWrapper(EmitEventWrapper emitEventWrapper) {
        this.mEmitEventWrapper = emitEventWrapper;
    }

    @Override // expo.modules.core.interfaces.RegistryLifecycleListener
    public void onCreate(ModuleRegistry moduleRegistry) {
        this.mUIManager = (UIManager) moduleRegistry.getModule(UIManager.class);
        this.mConstants = (ConstantsInterface) moduleRegistry.getModule(ConstantsInterface.class);
        TaskServiceInterface taskServiceInterface = (TaskServiceInterface) moduleRegistry.getSingletonModule("TaskService", TaskServiceInterface.class);
        this.mTaskService = taskServiceInterface;
        taskServiceInterface.setTaskManager(this, getAppScopeKey(), getAppUrl());
        this.mUIManager.registerLifecycleEventListener(this);
    }

    @Override // expo.modules.core.interfaces.RegistryLifecycleListener
    public void onDestroy() {
        this.mUIManager.unregisterLifecycleEventListener(this);
        this.mTaskService.setTaskManager(null, getAppScopeKey(), getAppUrl());
    }

    @Override // expo.modules.interfaces.taskManager.TaskManagerInterface
    public void registerTask(String str, Class cls, Map<String, Object> map) throws Exception {
        checkTaskService();
        this.mTaskService.registerTask(str, getAppScopeKey(), getAppUrl(), cls, map);
    }

    @Override // expo.modules.interfaces.taskManager.TaskManagerInterface
    public void unregisterTask(String str, Class cls) throws Exception {
        checkTaskService();
        this.mTaskService.unregisterTask(str, getAppScopeKey(), cls);
    }

    @Override // expo.modules.interfaces.taskManager.TaskManagerInterface
    public synchronized void executeTaskWithBody(Bundle bundle) {
        List<Bundle> list = this.mEventsQueue;
        if (list != null) {
            list.add(bundle);
        } else {
            emitEvent(bundle);
        }
    }

    @Override // expo.modules.interfaces.taskManager.TaskManagerInterface
    public boolean taskHasConsumerOfClass(String str, Class cls) {
        TaskServiceInterface taskServiceInterface = this.mTaskService;
        if (taskServiceInterface == null) {
            return false;
        }
        return taskServiceInterface.taskHasConsumerOfClass(str, getAppScopeKey(), cls);
    }

    @Override // expo.modules.interfaces.taskManager.TaskManagerInterface
    public synchronized void flushQueuedEvents() {
        List<Bundle> list = this.mEventsQueue;
        if (list != null) {
            Iterator<Bundle> it = list.iterator();
            while (it.hasNext()) {
                emitEvent(it.next());
            }
            this.mEventsQueue = null;
        }
    }

    @Override // expo.modules.interfaces.taskManager.TaskManagerInterface
    public String getAppScopeKey() {
        ConstantsInterface constantsInterface = this.mConstants;
        if (constantsInterface != null) {
            return constantsInterface.getAppScopeKey();
        }
        return null;
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostResume() {
        if (isRunningInHeadlessMode()) {
            return;
        }
        for (TaskConsumerInterface taskConsumerInterface : this.mTaskService.getTaskConsumers(getAppScopeKey())) {
            if (taskConsumerInterface instanceof LifecycleEventListener) {
                ((LifecycleEventListener) taskConsumerInterface).onHostResume();
            }
        }
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostPause() {
        if (isRunningInHeadlessMode()) {
            return;
        }
        for (TaskConsumerInterface taskConsumerInterface : this.mTaskService.getTaskConsumers(getAppScopeKey())) {
            if (taskConsumerInterface instanceof LifecycleEventListener) {
                ((LifecycleEventListener) taskConsumerInterface).onHostPause();
            }
        }
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostDestroy() {
        if (isRunningInHeadlessMode()) {
            return;
        }
        for (TaskConsumerInterface taskConsumerInterface : this.mTaskService.getTaskConsumers(getAppScopeKey())) {
            if (taskConsumerInterface instanceof LifecycleEventListener) {
                ((LifecycleEventListener) taskConsumerInterface).onHostDestroy();
            }
        }
    }

    private boolean isRunningInHeadlessMode() {
        return this.mTaskService.isStartedByHeadlessLoader(getAppScopeKey());
    }

    private String getAppUrl() {
        String str;
        ConstantsInterface constantsInterface = this.mConstants;
        if (constantsInterface != null && (str = (String) constantsInterface.getConstants().get("experienceUrl")) != null) {
            return str;
        }
        Context context = this.mContextRef.get();
        if (context != null) {
            return context.getPackageName();
        }
        return null;
    }

    private void checkTaskService() throws IllegalStateException {
        if (this.mTaskService == null) {
            throw new IllegalStateException("Unable to find TaskService singleton module in module registry.");
        }
    }

    private void emitEvent(Bundle bundle) {
        EmitEventWrapper emitEventWrapper = this.mEmitEventWrapper;
        if (emitEventWrapper != null) {
            emitEventWrapper.emit(TaskManagerInterface.EVENT_NAME, bundle);
        } else {
            Log.e("ExpoTaskManager", "EmitEventWrapper is not set. Failed to emit the TaskManager Event.");
        }
    }
}
