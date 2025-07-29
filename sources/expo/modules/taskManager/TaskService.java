package expo.modules.taskManager;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.Log;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import expo.modules.apploader.AppLoaderProvider;
import expo.modules.apploader.HeadlessAppLoader;
import expo.modules.core.interfaces.Consumer;
import expo.modules.core.interfaces.SingletonModule;
import expo.modules.interfaces.taskManager.TaskConsumerInterface;
import expo.modules.interfaces.taskManager.TaskExecutionCallback;
import expo.modules.interfaces.taskManager.TaskInterface;
import expo.modules.interfaces.taskManager.TaskManagerInterface;
import expo.modules.interfaces.taskManager.TaskManagerUtilsInterface;
import expo.modules.interfaces.taskManager.TaskServiceInterface;
import expo.modules.taskManager.exceptions.InvalidConsumerClassException;
import expo.modules.taskManager.exceptions.TaskNotFoundException;
import expo.modules.taskManager.exceptions.TaskRegisteringFailedException;
import expo.modules.taskManager.repository.TasksAndEventsRepository;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class TaskService implements SingletonModule, TaskServiceInterface {
    private static final int MAX_TASK_EXECUTION_TIME_MS = 15000;
    private static final String SHARED_PREFERENCES_NAME = "TaskManagerModule";
    private static final String TAG = "TaskService";
    private WeakReference<Context> mContextRef;
    private TaskManagerUtilsInterface mTaskManagerUtils;
    private TasksAndEventsRepository mTasksAndEventsRepository;
    private static final Map<String, WeakReference<TaskManagerInterface>> sTaskManagers = new HashMap();
    private static final Map<String, WeakReference<TaskManagerInterface>> sHeadlessTaskManagers = new HashMap();
    private static final Map<String, List<String>> sEvents = new HashMap();
    private static final Map<String, TaskExecutionCallback> sTaskCallbacks = new HashMap();

    static /* synthetic */ void lambda$executeTask$0() {
    }

    public TaskService(Context context) throws ClassNotFoundException {
        this.mContextRef = new WeakReference<>(context);
        TasksAndEventsRepository tasksAndEventsRepositoryCreate = TasksAndEventsRepository.create(context);
        this.mTasksAndEventsRepository = tasksAndEventsRepositoryCreate;
        if (tasksAndEventsRepositoryCreate.tasksExist()) {
            return;
        }
        this.mTasksAndEventsRepository.createTasks();
        restoreTasks();
    }

    @Override // expo.modules.core.interfaces.SingletonModule
    public String getName() {
        return TAG;
    }

    @Override // expo.modules.interfaces.taskManager.TaskServiceInterface
    public boolean hasRegisteredTask(String str, String str2) {
        return getTask(str, str2) != null;
    }

    @Override // expo.modules.interfaces.taskManager.TaskServiceInterface
    public void registerTask(String str, String str2, String str3, Class cls, Map<String, Object> map) throws IllegalAccessException, InstantiationException, TaskRegisteringFailedException, IllegalArgumentException, InvocationTargetException {
        TaskInterface task = getTask(str, str2);
        Class clsUnversionedClassForClass = Utils.unversionedClassForClass(cls);
        if (task != null && clsUnversionedClassForClass != null && clsUnversionedClassForClass.isInstance(task.getConsumer())) {
            task.setOptions(map);
            task.getConsumer().setOptions(map);
        } else {
            internalRegisterTask(str, str2, str3, cls, map);
        }
        this.mTasksAndEventsRepository.persistTasksForAppScopeKey(getSharedPreferences(), str2);
    }

    @Override // expo.modules.interfaces.taskManager.TaskServiceInterface
    public void unregisterTask(String str, String str2, Class cls) throws TaskNotFoundException, InvalidConsumerClassException {
        TaskInterface task = getTask(str, str2);
        Class clsUnversionedClassForClass = Utils.unversionedClassForClass(cls);
        if (task == null) {
            throw new TaskNotFoundException(str, str2);
        }
        if (clsUnversionedClassForClass != null && !clsUnversionedClassForClass.isInstance(task.getConsumer())) {
            throw new InvalidConsumerClassException(str);
        }
        this.mTasksAndEventsRepository.removeTask(str2, str);
        Log.i(TAG, "Unregistering task '" + str + "' for app with scoping identifier '" + str2 + "'.");
        task.getConsumer().didUnregister();
        this.mTasksAndEventsRepository.persistTasksForAppScopeKey(getSharedPreferences(), str2);
    }

    @Override // expo.modules.interfaces.taskManager.TaskServiceInterface
    public void unregisterAllTasksForAppScopeKey(String str) {
        Map<String, TaskInterface> tasks = this.mTasksAndEventsRepository.getTasks(str);
        if (tasks != null) {
            Log.i(TAG, "Unregistering all tasks for app with scoping identifier '" + str + "'.");
            Iterator<TaskInterface> it = tasks.values().iterator();
            while (it.hasNext()) {
                it.next().getConsumer().didUnregister();
            }
            this.mTasksAndEventsRepository.removeTasks(str);
            removeAppFromConfig(str);
        }
    }

    @Override // expo.modules.interfaces.taskManager.TaskServiceInterface
    public boolean taskHasConsumerOfClass(String str, String str2, Class cls) {
        TaskInterface task = getTask(str, str2);
        return task != null && Utils.unversionedClassForClass(cls).isInstance(task.getConsumer());
    }

    @Override // expo.modules.interfaces.taskManager.TaskServiceInterface
    public Bundle getTaskOptions(String str, String str2) {
        TaskInterface task = getTask(str, str2);
        if (task != null) {
            return task.getOptionsBundle();
        }
        return null;
    }

    @Override // expo.modules.interfaces.taskManager.TaskServiceInterface
    public List<Bundle> getTasksForAppScopeKey(String str) {
        Map<String, TaskInterface> tasks = this.mTasksAndEventsRepository.getTasks(str);
        ArrayList arrayList = new ArrayList();
        if (tasks != null) {
            for (TaskInterface taskInterface : tasks.values()) {
                Bundle bundle = new Bundle();
                bundle.putString("taskName", taskInterface.getName());
                bundle.putString("taskType", taskInterface.getConsumer().taskType());
                bundle.putBundle(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, taskInterface.getOptionsBundle());
                arrayList.add(bundle);
            }
        }
        return arrayList;
    }

    @Override // expo.modules.interfaces.taskManager.TaskServiceInterface
    public List<TaskConsumerInterface> getTaskConsumers(String str) {
        Map<String, TaskInterface> tasks = this.mTasksAndEventsRepository.getTasks(str);
        ArrayList arrayList = new ArrayList();
        if (tasks != null) {
            Iterator<TaskInterface> it = tasks.values().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getConsumer());
            }
        }
        return arrayList;
    }

    @Override // expo.modules.interfaces.taskManager.TaskServiceInterface
    public void notifyTaskFinished(String str, final String str2, Map<String, Object> map) {
        String str3 = (String) map.get("eventId");
        Map<String, List<String>> map2 = sEvents;
        List<String> list = map2.get(str2);
        Log.i(TAG, "Finished task '" + str + "' with eventId '" + str3 + "'.");
        if (list != null) {
            list.remove(str3);
            if (list.size() == 0) {
                map2.remove(str2);
                new Handler().postDelayed(new Runnable() { // from class: expo.modules.taskManager.TaskService.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (TaskService.sEvents.containsKey(str2)) {
                            return;
                        }
                        TaskService.this.invalidateAppRecord(str2);
                    }
                }, 2000L);
            }
        }
        TaskExecutionCallback taskExecutionCallback = sTaskCallbacks.get(str3);
        if (taskExecutionCallback != null) {
            taskExecutionCallback.onFinished(map);
        }
    }

    @Override // expo.modules.interfaces.taskManager.TaskServiceInterface
    public void setTaskManager(TaskManagerInterface taskManagerInterface, String str, String str2) {
        if (taskManagerInterface == null) {
            sTaskManagers.remove(str);
            return;
        }
        boolean zIsStartedByHeadlessLoader = isStartedByHeadlessLoader(str);
        (zIsStartedByHeadlessLoader ? sHeadlessTaskManagers : sTaskManagers).put(str, new WeakReference<>(taskManagerInterface));
        List<Bundle> events = this.mTasksAndEventsRepository.getEvents(str);
        if (events != null) {
            Iterator<Bundle> it = events.iterator();
            while (it.hasNext()) {
                taskManagerInterface.executeTaskWithBody(it.next());
            }
        }
        this.mTasksAndEventsRepository.removeEvents(str);
        if (zIsStartedByHeadlessLoader) {
            return;
        }
        maybeUpdateAppUrlForAppScopeKey(str2, str);
    }

    @Override // expo.modules.interfaces.taskManager.TaskServiceInterface
    public boolean isStartedByHeadlessLoader(String str) {
        HeadlessAppLoader appLoader = getAppLoader();
        if (appLoader != null) {
            return appLoader.isRunning(str);
        }
        return false;
    }

    @Override // expo.modules.interfaces.taskManager.TaskServiceInterface
    public void handleIntent(Intent intent) {
        String action = intent.getAction();
        Uri data = intent.getData();
        if (!TaskBroadcastReceiver.INTENT_ACTION.equals(action)) {
            Log.i(TAG, "Handling intent with action '" + action + "'.");
            Iterator<String> it = this.mTasksAndEventsRepository.allAppScopeKeysWithTasks().iterator();
            while (it.hasNext()) {
                for (TaskConsumerInterface taskConsumerInterface : getTaskConsumers(it.next())) {
                    if (taskConsumerInterface.canReceiveCustomBroadcast(action)) {
                        taskConsumerInterface.didReceiveBroadcast(intent);
                    }
                }
            }
            return;
        }
        if (data == null) {
            return;
        }
        String queryParameter = data.getQueryParameter("appId");
        String queryParameter2 = data.getQueryParameter("taskName");
        TaskConsumerInterface taskConsumer = getTaskConsumer(queryParameter2, queryParameter);
        Log.i(TAG, "Handling intent with task name '" + queryParameter2 + "' and app scoping identifier '" + queryParameter + "'.");
        if (taskConsumer == null) {
            Log.w(TAG, "Task or consumer not found.");
            getTaskManagerUtils().cancelTaskIntent(this.mContextRef.get(), queryParameter, queryParameter2);
        } else {
            taskConsumer.didReceiveBroadcast(intent);
        }
    }

    @Override // expo.modules.interfaces.taskManager.TaskServiceInterface
    public boolean handleJob(JobService jobService, JobParameters jobParameters) {
        PersistableBundle extras = jobParameters.getExtras();
        String string = extras.getString("appId");
        String string2 = extras.getString("taskName");
        TaskConsumerInterface taskConsumer = getTaskConsumer(string2, string);
        if (taskConsumer == null) {
            Log.w(TAG, "Task or consumer not found.");
            return false;
        }
        Log.i(TAG, "Handling job with task name '" + string2 + "' for app with scoping identifier '" + string + "'.");
        boolean zDidExecuteJob = taskConsumer.didExecuteJob(jobService, jobParameters);
        if (zDidExecuteJob) {
            finishJobAfterTimeout(jobService, jobParameters, 15000L);
        }
        return zDidExecuteJob;
    }

    @Override // expo.modules.interfaces.taskManager.TaskServiceInterface
    public boolean cancelJob(JobService jobService, JobParameters jobParameters) {
        TaskConsumerInterface consumer;
        PersistableBundle extras = jobParameters.getExtras();
        String string = extras.getString("appId");
        String string2 = extras.getString("taskName");
        TaskInterface task = getTask(string2, string);
        if (task == null || TaskManagerUtils.notifyTaskJobCancelled(task) || (consumer = task.getConsumer()) == null) {
            return false;
        }
        Log.i(TAG, "Job for task '" + string2 + "' has been cancelled by the system.");
        return consumer.didCancelJob(jobService, jobParameters);
    }

    @Override // expo.modules.interfaces.taskManager.TaskServiceInterface
    public void executeTask(TaskInterface taskInterface, Bundle bundle, Error error, TaskExecutionCallback taskExecutionCallback) {
        ArrayList arrayList;
        TaskManagerInterface taskManager = getTaskManager(taskInterface.getAppScopeKey());
        Bundle bundleCreateExecutionEventBody = createExecutionEventBody(taskInterface, bundle, error);
        Bundle bundle2 = bundleCreateExecutionEventBody.getBundle("executionInfo");
        if (bundle2 == null) {
            return;
        }
        String string = bundle2.getString("eventId");
        final String appScopeKey = taskInterface.getAppScopeKey();
        if (taskExecutionCallback != null) {
            sTaskCallbacks.put(string, taskExecutionCallback);
        }
        Map<String, List<String>> map = sEvents;
        if (map.get(appScopeKey) == null) {
            arrayList = new ArrayList();
            arrayList.add(string);
            map.put(appScopeKey, arrayList);
        } else {
            arrayList = new ArrayList();
            arrayList.add(string);
        }
        if (taskManager != null) {
            taskManager.executeTaskWithBody(bundleCreateExecutionEventBody);
            return;
        }
        if (!this.mTasksAndEventsRepository.hasEvents(appScopeKey)) {
            this.mTasksAndEventsRepository.putEvents(appScopeKey, new ArrayList());
        }
        this.mTasksAndEventsRepository.putEventForAppScopeKey(appScopeKey, bundleCreateExecutionEventBody);
        try {
            try {
                getAppLoader().loadApp(this.mContextRef.get(), new HeadlessAppLoader.Params(appScopeKey, taskInterface.getAppUrl()), new Runnable() { // from class: expo.modules.taskManager.TaskService$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        TaskService.lambda$executeTask$0();
                    }
                }, new Consumer() { // from class: expo.modules.taskManager.TaskService$$ExternalSyntheticLambda1
                    @Override // expo.modules.core.interfaces.Consumer
                    public final void apply(Object obj) {
                        this.f$0.lambda$executeTask$1(appScopeKey, (Boolean) obj);
                    }
                });
            } catch (HeadlessAppLoader.AppConfigurationError unused) {
                unregisterTask(taskInterface.getName(), appScopeKey, null);
                arrayList.remove(string);
                this.mTasksAndEventsRepository.removeEvents(appScopeKey);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error occurred while unregistering invalid task.", e);
            arrayList.remove(string);
            this.mTasksAndEventsRepository.removeEvents(appScopeKey);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeTask$1(String str, Boolean bool) {
        if (bool.booleanValue()) {
            return;
        }
        sEvents.remove(str);
        this.mTasksAndEventsRepository.removeEvents(str);
        unregisterAllTasksForAppScopeKey(str);
    }

    private HeadlessAppLoader getAppLoader() {
        if (this.mContextRef.get() != null) {
            return AppLoaderProvider.getLoader("react-native-headless", this.mContextRef.get());
        }
        return null;
    }

    private void internalRegisterTask(String str, String str2, String str3, Class<TaskConsumerInterface> cls, Map<String, Object> map) throws IllegalAccessException, InstantiationException, TaskRegisteringFailedException, IllegalArgumentException, InvocationTargetException {
        Context context = this.mContextRef.get();
        if (context == null) {
            return;
        }
        try {
            TaskConsumerInterface taskConsumerInterfaceNewInstance = cls.getDeclaredConstructor(Context.class, TaskManagerUtilsInterface.class).newInstance(context, getTaskManagerUtils());
            Task task = new Task(str, str2, str3, taskConsumerInterfaceNewInstance, map, this);
            Map<String, TaskInterface> tasks = this.mTasksAndEventsRepository.hasTasks(str2) ? this.mTasksAndEventsRepository.getTasks(str2) : new HashMap<>();
            tasks.put(str, task);
            this.mTasksAndEventsRepository.putTasks(str2, tasks);
            Log.i(TAG, "Registered task with name '" + str + "' for app with scoping identifier '" + str2 + "'.");
            taskConsumerInterfaceNewInstance.didRegister(task);
        } catch (Exception e) {
            throw new TaskRegisteringFailedException(cls, e);
        }
    }

    private Bundle createExecutionEventBody(TaskInterface taskInterface, Bundle bundle, Error error) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = new Bundle();
        Bundle bundleErrorBundleForError = errorBundleForError(error);
        bundle3.putString("eventId", UUID.randomUUID().toString());
        bundle3.putString("taskName", taskInterface.getName());
        bundle2.putBundle("executionInfo", bundle3);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle2.putBundle("data", bundle);
        bundle2.putBundle("error", bundleErrorBundleForError);
        return bundle2;
    }

    private Bundle errorBundleForError(Error error) {
        if (error == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("message", error.getMessage());
        return bundle;
    }

    private TaskInterface getTask(String str, String str2) {
        Map<String, TaskInterface> tasks = this.mTasksAndEventsRepository.getTasks(str2);
        if (tasks != null) {
            return tasks.get(str);
        }
        return null;
    }

    private TaskConsumerInterface getTaskConsumer(String str, String str2) {
        TaskInterface task;
        if (str == null || str2 == null || (task = getTask(str, str2)) == null) {
            return null;
        }
        return task.getConsumer();
    }

    private TaskManagerUtilsInterface getTaskManagerUtils() {
        if (this.mTaskManagerUtils == null) {
            this.mTaskManagerUtils = new TaskManagerUtils();
        }
        return this.mTaskManagerUtils;
    }

    private SharedPreferences getSharedPreferences() {
        Context context = this.mContextRef.get();
        if (context != null) {
            return context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
        }
        return null;
    }

    private void maybeUpdateAppUrlForAppScopeKey(String str, String str2) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        Map<String, Object> mapJsonToMap = sharedPreferences != null ? Utils.jsonToMap(sharedPreferences.getString(str2, "")) : null;
        if (mapJsonToMap == null || mapJsonToMap.size() <= 0) {
            return;
        }
        String str3 = (String) mapJsonToMap.get("appUrl");
        if (str3 == null || !str3.equals(str)) {
            mapJsonToMap.put("appUrl", str);
            sharedPreferences.edit().putString(str2, new JSONObject(mapJsonToMap).toString()).apply();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void restoreTasks() throws ClassNotFoundException {
        for (Map.Entry<String, TasksAndEventsRepository.AppConfig> entry : this.mTasksAndEventsRepository.readPersistedTasks(getSharedPreferences()).entrySet()) {
            String key = entry.getKey();
            String str = entry.getValue().appUrl;
            Map<String, Object> map = entry.getValue().tasks;
            if (str != null && map != null && map.size() > 0) {
                for (String str2 : map.keySet()) {
                    HashMap map2 = (HashMap) map.get(str2);
                    String str3 = (String) map2.get("consumerClass");
                    try {
                        Class<?> cls = Class.forName(str3);
                        int consumerVersion = Utils.getConsumerVersion(cls);
                        int iIntValue = ((Integer) map2.get("consumerVersion")).intValue();
                        if (consumerVersion != iIntValue) {
                            Log.w(TAG, "Task consumer '" + str3 + "' has version '" + consumerVersion + "' that is not compatible with the saved version '" + iIntValue + "'.");
                        } else {
                            try {
                                internalRegisterTask(str2, key, str, cls, (HashMap) map2.get(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS));
                            } catch (TaskRegisteringFailedException e) {
                                Log.e(TAG, e.getMessage());
                            }
                        }
                    } catch (ClassNotFoundException | NullPointerException e2) {
                        Log.e(TAG, e2.getMessage());
                        e2.printStackTrace();
                    }
                }
            }
            this.mTasksAndEventsRepository.persistTasksForAppScopeKey(getSharedPreferences(), entry.getKey());
        }
    }

    private void removeAppFromConfig(String str) {
        getSharedPreferences().edit().remove(str).apply();
    }

    private TaskManagerInterface getTaskManager(String str) {
        WeakReference<TaskManagerInterface> weakReference = sTaskManagers.get(str);
        if ((weakReference == null ? null : weakReference.get()) == null) {
            weakReference = sHeadlessTaskManagers.get(str);
        }
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateAppRecord(String str) {
        if (getAppLoader() == null || !getAppLoader().invalidateApp(str)) {
            return;
        }
        sHeadlessTaskManagers.remove(str);
    }

    private void finishJobAfterTimeout(final JobService jobService, final JobParameters jobParameters, long j) {
        new Handler().postDelayed(new Runnable() { // from class: expo.modules.taskManager.TaskService.2
            @Override // java.lang.Runnable
            public void run() {
                jobService.jobFinished(jobParameters, false);
            }
        }, j);
    }
}
