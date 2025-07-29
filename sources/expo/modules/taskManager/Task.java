package expo.modules.taskManager;

import android.os.Bundle;
import expo.modules.interfaces.taskManager.TaskConsumerInterface;
import expo.modules.interfaces.taskManager.TaskExecutionCallback;
import expo.modules.interfaces.taskManager.TaskInterface;
import expo.modules.interfaces.taskManager.TaskServiceInterface;
import java.util.Map;

/* loaded from: classes5.dex */
public class Task implements TaskInterface {
    private String mAppScopeKey;
    private String mAppUrl;
    private TaskConsumerInterface mConsumer;
    private String mName;
    private Map<String, Object> mOptions;
    private TaskServiceInterface mService;

    public Task(String str, String str2, String str3, TaskConsumerInterface taskConsumerInterface, Map<String, Object> map, TaskServiceInterface taskServiceInterface) {
        this.mName = str;
        this.mAppScopeKey = str2;
        this.mAppUrl = str3;
        this.mConsumer = taskConsumerInterface;
        this.mOptions = map;
        this.mService = taskServiceInterface;
    }

    @Override // expo.modules.interfaces.taskManager.TaskInterface
    public String getName() {
        return this.mName;
    }

    @Override // expo.modules.interfaces.taskManager.TaskInterface
    public String getAppScopeKey() {
        return this.mAppScopeKey;
    }

    @Override // expo.modules.interfaces.taskManager.TaskInterface
    public String getAppUrl() {
        return this.mAppUrl;
    }

    @Override // expo.modules.interfaces.taskManager.TaskInterface
    public TaskConsumerInterface getConsumer() {
        return this.mConsumer;
    }

    @Override // expo.modules.interfaces.taskManager.TaskInterface
    public Map<String, Object> getOptions() {
        return this.mOptions;
    }

    @Override // expo.modules.interfaces.taskManager.TaskInterface
    public Bundle getOptionsBundle() {
        return TaskManagerUtils.mapToBundle(this.mOptions);
    }

    @Override // expo.modules.interfaces.taskManager.TaskInterface
    public void execute(Bundle bundle, Error error) {
        execute(bundle, error, null);
    }

    @Override // expo.modules.interfaces.taskManager.TaskInterface
    public void execute(Bundle bundle, Error error, TaskExecutionCallback taskExecutionCallback) {
        this.mService.executeTask(this, bundle, error, taskExecutionCallback);
    }

    @Override // expo.modules.interfaces.taskManager.TaskInterface
    public void setOptions(Map<String, Object> map) {
        this.mOptions = map;
    }
}
