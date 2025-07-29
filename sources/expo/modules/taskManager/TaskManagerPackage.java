package expo.modules.taskManager;

import android.content.Context;
import expo.modules.core.BasePackage;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.SingletonModule;
import expo.modules.interfaces.taskManager.TaskServiceInterface;
import expo.modules.interfaces.taskManager.TaskServiceProviderInterface;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class TaskManagerPackage extends BasePackage implements TaskServiceProviderInterface {
    static TaskServiceInterface mTaskService;

    @Override // expo.modules.interfaces.taskManager.TaskServiceProviderInterface
    public TaskServiceInterface getTaskServiceImpl(Context context) {
        if (mTaskService == null) {
            mTaskService = new TaskService(context);
        }
        return mTaskService;
    }

    @Override // expo.modules.core.BasePackage, expo.modules.core.interfaces.Package
    public List<InternalModule> createInternalModules(Context context) {
        return Collections.singletonList(new TaskManagerInternalModule(context));
    }

    @Override // expo.modules.core.BasePackage, expo.modules.core.interfaces.Package
    public List<SingletonModule> createSingletonModules(Context context) {
        return Collections.singletonList(getTaskServiceImpl(context));
    }
}
