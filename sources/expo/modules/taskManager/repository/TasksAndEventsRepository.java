package expo.modules.taskManager.repository;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import expo.modules.interfaces.taskManager.TaskInterface;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public interface TasksAndEventsRepository {

    public static class AppConfig {
        public String appUrl;
        public Map<String, Object> tasks;
    }

    Set<String> allAppScopeKeysWithTasks();

    void createTasks();

    List<Bundle> getEvents(String str);

    Map<String, TaskInterface> getTasks(String str);

    boolean hasEvents(String str);

    boolean hasTasks(String str);

    void persistTasksForAppScopeKey(SharedPreferences sharedPreferences, String str);

    void putEventForAppScopeKey(String str, Bundle bundle);

    void putEvents(String str, List<Bundle> list);

    void putTasks(String str, Map<String, TaskInterface> map);

    Map<String, AppConfig> readPersistedTasks(SharedPreferences sharedPreferences);

    void removeEvents(String str);

    void removeTask(String str, String str2);

    void removeTasks(String str);

    boolean tasksExist();

    static TasksAndEventsRepository create(Context context) {
        boolean z;
        try {
            z = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("expo.modules.taskManager.oneAppId");
        } catch (PackageManager.NameNotFoundException unused) {
            z = false;
        }
        if (z) {
            return new BareTasksAndEventsRepository(new TasksPersistence());
        }
        return new ManagedTasksAndEventsRepository(new TasksPersistence());
    }
}
