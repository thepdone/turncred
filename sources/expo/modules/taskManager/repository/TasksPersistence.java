package expo.modules.taskManager.repository;

import android.content.SharedPreferences;
import expo.modules.interfaces.taskManager.TaskInterface;
import expo.modules.taskManager.Utils;
import expo.modules.taskManager.repository.TasksAndEventsRepository;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class TasksPersistence {
    public void clearTaskPersistence(SharedPreferences sharedPreferences, String str) {
        for (String str2 : sharedPreferences.getAll().keySet()) {
            if (!str.equals(str2)) {
                sharedPreferences.edit().remove(str2).apply();
            }
        }
    }

    public void persistTasksForAppScopeKey(SharedPreferences sharedPreferences, String str, Map<String, TaskInterface> map) {
        if (sharedPreferences == null) {
            return;
        }
        if (map == null || map.size() == 0) {
            sharedPreferences.edit().remove(str).apply();
            return;
        }
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        String appUrl = null;
        for (TaskInterface taskInterface : map.values()) {
            map3.put(taskInterface.getName(), Utils.exportTaskToMap(taskInterface));
            appUrl = taskInterface.getAppUrl();
        }
        map2.put("appUrl", appUrl);
        map2.put("tasks", map3);
        sharedPreferences.edit().putString(str, new JSONObject(map2).toString()).apply();
    }

    public Map<String, TasksAndEventsRepository.AppConfig> readPersistedTasks(SharedPreferences sharedPreferences) {
        HashMap map = new HashMap();
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            Map<String, Object> mapJsonToMap = Utils.jsonToMap(entry.getValue().toString());
            String str = (String) mapJsonToMap.get("appUrl");
            HashMap map2 = (HashMap) mapJsonToMap.get("tasks");
            if (str != null && map2 != null && map2.size() > 0) {
                HashMap map3 = new HashMap();
                for (String str2 : map2.keySet()) {
                    map3.put(str2, map2.get(str2));
                }
                TasksAndEventsRepository.AppConfig appConfig = new TasksAndEventsRepository.AppConfig();
                appConfig.appUrl = str;
                appConfig.tasks = map3;
                map.put(entry.getKey(), appConfig);
            }
        }
        return map;
    }
}
