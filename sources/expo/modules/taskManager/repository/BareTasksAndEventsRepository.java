package expo.modules.taskManager.repository;

import android.content.SharedPreferences;
import android.os.Bundle;
import expo.modules.interfaces.taskManager.TaskInterface;
import expo.modules.taskManager.repository.TasksAndEventsRepository;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes5.dex */
public class BareTasksAndEventsRepository implements TasksAndEventsRepository {
    private static Map<String, List<Bundle>> sEvents = new HashMap();
    private static Map<String, Map<String, TaskInterface>> sTasks;
    private final TasksPersistence tasksPersistence;

    public BareTasksAndEventsRepository(TasksPersistence tasksPersistence) {
        this.tasksPersistence = tasksPersistence;
    }

    @Override // expo.modules.taskManager.repository.TasksAndEventsRepository
    public void putEvents(String str, List<Bundle> list) {
        sEvents.put(str, list);
    }

    @Override // expo.modules.taskManager.repository.TasksAndEventsRepository
    public void putEventForAppScopeKey(String str, Bundle bundle) {
        sEvents.get(str).add(bundle);
    }

    @Override // expo.modules.taskManager.repository.TasksAndEventsRepository
    public boolean hasEvents(String str) {
        return sEvents.containsKey(str);
    }

    @Override // expo.modules.taskManager.repository.TasksAndEventsRepository
    public void removeEvents(String str) {
        sEvents.remove(str);
    }

    @Override // expo.modules.taskManager.repository.TasksAndEventsRepository
    public List<Bundle> getEvents(String str) {
        LinkedList linkedList = new LinkedList();
        Iterator<List<Bundle>> it = sEvents.values().iterator();
        while (it.hasNext()) {
            linkedList.addAll(it.next());
        }
        return linkedList;
    }

    @Override // expo.modules.taskManager.repository.TasksAndEventsRepository
    public boolean tasksExist() {
        return sTasks != null;
    }

    @Override // expo.modules.taskManager.repository.TasksAndEventsRepository
    public void createTasks() {
        sTasks = new HashMap();
    }

    @Override // expo.modules.taskManager.repository.TasksAndEventsRepository
    public Set<String> allAppScopeKeysWithTasks() {
        return sTasks.keySet();
    }

    @Override // expo.modules.taskManager.repository.TasksAndEventsRepository
    public Map<String, TaskInterface> getTasks(String str) {
        HashMap map = new HashMap();
        Iterator<Map<String, TaskInterface>> it = sTasks.values().iterator();
        while (it.hasNext()) {
            map.putAll(it.next());
        }
        return map;
    }

    @Override // expo.modules.taskManager.repository.TasksAndEventsRepository
    public boolean hasTasks(String str) {
        return sTasks.containsKey(str);
    }

    @Override // expo.modules.taskManager.repository.TasksAndEventsRepository
    public void putTasks(String str, Map<String, TaskInterface> map) {
        sTasks.put(str, map);
    }

    @Override // expo.modules.taskManager.repository.TasksAndEventsRepository
    public void removeTasks(String str) {
        sTasks.remove(str);
    }

    @Override // expo.modules.taskManager.repository.TasksAndEventsRepository
    public void removeTask(String str, String str2) {
        if (sTasks.containsKey(str)) {
            ((Map) Objects.requireNonNull(sTasks.get(str))).remove(str2);
        }
    }

    @Override // expo.modules.taskManager.repository.TasksAndEventsRepository
    public void persistTasksForAppScopeKey(SharedPreferences sharedPreferences, String str) {
        this.tasksPersistence.clearTaskPersistence(sharedPreferences, str);
        this.tasksPersistence.persistTasksForAppScopeKey(sharedPreferences, str, getTasks(str));
    }

    @Override // expo.modules.taskManager.repository.TasksAndEventsRepository
    public Map<String, TasksAndEventsRepository.AppConfig> readPersistedTasks(SharedPreferences sharedPreferences) {
        return this.tasksPersistence.readPersistedTasks(sharedPreferences);
    }
}
