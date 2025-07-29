package expo.modules.taskManager;

import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.util.Log;
import androidx.collection.ArraySet;
import expo.modules.interfaces.taskManager.TaskExecutionCallback;
import expo.modules.interfaces.taskManager.TaskInterface;
import expo.modules.interfaces.taskManager.TaskManagerUtilsInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public class TaskManagerUtils implements TaskManagerUtilsInterface {
    private static final int DEFAULT_OVERRIDE_DEADLINE = 60000;
    private static final String EXTRAS_REQUIRED_KEY = "expo.modules.taskManager";
    private static final int PENDING_INTENT_REQUEST_CODE = 5055;
    private static final String TAG = "TaskManagerUtils";
    private static final Set<TaskInterface> sTasksReschedulingJob = new ArraySet();

    @Override // expo.modules.interfaces.taskManager.TaskManagerUtilsInterface
    public PendingIntent createTaskIntent(Context context, TaskInterface taskInterface) {
        return createTaskIntent(context, taskInterface, 134217728);
    }

    @Override // expo.modules.interfaces.taskManager.TaskManagerUtilsInterface
    public void cancelTaskIntent(Context context, String str, String str2) {
        PendingIntent pendingIntentCreateTaskIntent = createTaskIntent(context, str, str2, 536870912);
        if (pendingIntentCreateTaskIntent != null) {
            pendingIntentCreateTaskIntent.cancel();
        }
    }

    @Override // expo.modules.interfaces.taskManager.TaskManagerUtilsInterface
    public void scheduleJob(Context context, TaskInterface taskInterface, List<PersistableBundle> list) {
        if (taskInterface == null) {
            Log.e(TAG, "Trying to schedule job for null task!");
        } else {
            updateOrScheduleJob(context, taskInterface, list);
        }
    }

    @Override // expo.modules.interfaces.taskManager.TaskManagerUtilsInterface
    public void executeTask(TaskInterface taskInterface, Bundle bundle, TaskExecutionCallback taskExecutionCallback) {
        if (taskInterface == null) {
            Log.e(TAG, "Trying to execute a null task!");
        } else {
            taskInterface.execute(bundle, null, taskExecutionCallback);
        }
    }

    @Override // expo.modules.interfaces.taskManager.TaskManagerUtilsInterface
    public void cancelScheduledJob(Context context, int i) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(i);
        } else {
            Log.e(getClass().getName(), "Job scheduler not found!");
        }
    }

    @Override // expo.modules.interfaces.taskManager.TaskManagerUtilsInterface
    public List<PersistableBundle> extractDataFromJobParams(JobParameters jobParameters) {
        PersistableBundle extras = jobParameters.getExtras();
        ArrayList arrayList = new ArrayList();
        int i = extras.getInt("dataSize", 0);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(extras.getPersistableBundle(String.valueOf(i2)));
        }
        return arrayList;
    }

    static boolean notifyTaskJobCancelled(TaskInterface taskInterface) {
        Set<TaskInterface> set = sTasksReschedulingJob;
        boolean zContains = set.contains(taskInterface);
        if (zContains) {
            set.remove(taskInterface);
        }
        return zContains;
    }

    private void updateOrScheduleJob(Context context, TaskInterface taskInterface, List<PersistableBundle> list) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler == null) {
            Log.e(getClass().getName(), "Job scheduler not found!");
            return;
        }
        List<JobInfo> allPendingJobs = jobScheduler.getAllPendingJobs();
        Collections.sort(allPendingJobs, new Comparator<JobInfo>() { // from class: expo.modules.taskManager.TaskManagerUtils.1
            @Override // java.util.Comparator
            public int compare(JobInfo jobInfo, JobInfo jobInfo2) {
                return Integer.compare(jobInfo.getId(), jobInfo2.getId());
            }
        });
        int i = 0;
        for (JobInfo jobInfo : allPendingJobs) {
            int id = jobInfo.getId();
            if (isJobInfoRelatedToTask(jobInfo, taskInterface)) {
                JobInfo jobInfoCreateJobInfoByAddingData = createJobInfoByAddingData(jobInfo, list);
                sTasksReschedulingJob.add(taskInterface);
                try {
                    jobScheduler.cancel(id);
                    jobScheduler.schedule(jobInfoCreateJobInfoByAddingData);
                    return;
                } catch (IllegalStateException e) {
                    Log.e(getClass().getName(), "Unable to reschedule a job: " + e.getMessage());
                    return;
                }
            }
            if (i == id) {
                i++;
            }
        }
        try {
            jobScheduler.schedule(createJobInfo(context, taskInterface, i, list));
        } catch (IllegalStateException e2) {
            Log.e(getClass().getName(), "Unable to schedule a new job: " + e2.getMessage());
        }
    }

    private JobInfo createJobInfoByAddingData(JobInfo jobInfo, List<PersistableBundle> list) {
        PersistableBundle extras = jobInfo.getExtras();
        int i = extras.getInt("dataSize", 0);
        if (list != null) {
            extras.putInt("dataSize", list.size() + i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                extras.putPersistableBundle(String.valueOf(i + i2), list.get(i2));
            }
        }
        return createJobInfo(jobInfo.getId(), jobInfo.getService(), extras);
    }

    private PendingIntent createTaskIntent(Context context, String str, String str2, int i) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent(TaskBroadcastReceiver.INTENT_ACTION, null, context, TaskBroadcastReceiver.class);
        intent.setData(new Uri.Builder().appendQueryParameter("appId", str).appendQueryParameter("taskName", str2).build());
        return PendingIntent.getBroadcast(context, PENDING_INTENT_REQUEST_CODE, intent, (Build.VERSION.SDK_INT >= 31 ? 33554432 : 0) | i);
    }

    private PendingIntent createTaskIntent(Context context, TaskInterface taskInterface, int i) {
        return createTaskIntent(context, taskInterface.getAppScopeKey(), taskInterface.getName(), i);
    }

    private JobInfo createJobInfo(int i, ComponentName componentName, PersistableBundle persistableBundle) {
        return new JobInfo.Builder(i, componentName).setExtras(persistableBundle).setMinimumLatency(0L).setOverrideDeadline(60000L).build();
    }

    private JobInfo createJobInfo(Context context, TaskInterface taskInterface, int i, List<PersistableBundle> list) {
        return createJobInfo(i, new ComponentName(context, (Class<?>) TaskJobService.class), createExtrasForTask(taskInterface, list));
    }

    private PersistableBundle createExtrasForTask(TaskInterface taskInterface, List<PersistableBundle> list) {
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("expo.modules.taskManager", 1);
        persistableBundle.putString("appId", taskInterface.getAppScopeKey());
        persistableBundle.putString("taskName", taskInterface.getName());
        if (list != null) {
            persistableBundle.putInt("dataSize", list.size());
            for (int i = 0; i < list.size(); i++) {
                persistableBundle.putPersistableBundle(String.valueOf(i), list.get(i));
            }
        } else {
            persistableBundle.putInt("dataSize", 0);
        }
        return persistableBundle;
    }

    private boolean isJobInfoRelatedToTask(JobInfo jobInfo, TaskInterface taskInterface) {
        PersistableBundle extras = jobInfo.getExtras();
        return extras.containsKey("expo.modules.taskManager") && taskInterface.getAppScopeKey().equals(extras.getString("appId", "")) && taskInterface.getName().equals(extras.getString("taskName", ""));
    }

    static Bundle mapToBundle(Map<String, Object> map) {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            if (value instanceof Double) {
                bundle.putDouble(key, ((Double) value).doubleValue());
            } else if (value instanceof Integer) {
                bundle.putInt(key, ((Integer) value).intValue());
            } else if (value instanceof String) {
                bundle.putString(key, (String) value);
            } else if (value instanceof Boolean) {
                bundle.putBoolean(key, ((Boolean) value).booleanValue());
            } else if (value instanceof List) {
                List list = (List) value;
                Object obj = list.get(0);
                if (obj == null || (obj instanceof Double)) {
                    bundle.putDoubleArray(key, listToDoubleArray(list));
                } else if (obj instanceof Integer) {
                    bundle.putIntArray(key, listToIntArray(list));
                } else if (obj instanceof String) {
                    bundle.putStringArray(key, listToStringArray(list));
                } else if (obj instanceof Map) {
                    bundle.putParcelableArrayList(key, listToParcelableArrayList(list));
                }
            } else if (value instanceof Map) {
                bundle.putBundle(key, mapToBundle((Map) value));
            }
        }
        return bundle;
    }

    private static double[] listToDoubleArray(List<Object> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            dArr[i] = ((Double) list.get(i)).doubleValue();
        }
        return dArr;
    }

    private static int[] listToIntArray(List<Object> list) {
        int[] iArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            iArr[i] = ((Integer) list.get(i)).intValue();
        }
        return iArr;
    }

    private static String[] listToStringArray(List<Object> list) {
        String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strArr[i] = list.get(i).toString();
        }
        return strArr;
    }

    private static ArrayList<Parcelable> listToParcelableArrayList(List<Object> list) {
        ArrayList<Parcelable> arrayList = new ArrayList<>();
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(mapToBundle((Map) it.next()));
        }
        return arrayList;
    }
}
