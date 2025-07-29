package expo.modules.backgroundfetch;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import expo.modules.core.interfaces.LifecycleEventListener;
import expo.modules.interfaces.taskManager.TaskConsumer;
import expo.modules.interfaces.taskManager.TaskConsumerInterface;
import expo.modules.interfaces.taskManager.TaskExecutionCallback;
import expo.modules.interfaces.taskManager.TaskInterface;
import expo.modules.interfaces.taskManager.TaskManagerUtilsInterface;
import java.util.Map;

/* loaded from: classes5.dex */
public class BackgroundFetchTaskConsumer extends TaskConsumer implements TaskConsumerInterface, LifecycleEventListener {
    private static final int DEFAULT_INTERVAL_MS = 600000;
    private static final String TAG = "BackgroundFetchTaskConsumer";
    private PendingIntent mPendingIntent;
    private TaskInterface mTask;

    public BackgroundFetchTaskConsumer(Context context, TaskManagerUtilsInterface taskManagerUtilsInterface) {
        super(context, taskManagerUtilsInterface);
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumerInterface
    public String taskType() {
        return "backgroundFetch";
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumer, expo.modules.interfaces.taskManager.TaskConsumerInterface
    public boolean canReceiveCustomBroadcast(String str) {
        return "android.intent.action.BOOT_COMPLETED".equals(str) || "android.intent.action.MY_PACKAGE_REPLACED".equals(str);
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumerInterface
    public void didRegister(TaskInterface taskInterface) {
        this.mTask = taskInterface;
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumerInterface
    public void didUnregister() {
        stopAlarm();
        getTaskManagerUtils().cancelTaskIntent(getContext(), this.mTask.getAppScopeKey(), this.mTask.getName());
        this.mTask = null;
        this.mPendingIntent = null;
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumer, expo.modules.interfaces.taskManager.TaskConsumerInterface
    public void didReceiveBroadcast(Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.BOOT_COMPLETED".equals(action)) {
            Map<String, Object> options = this.mTask.getOptions();
            if (options.containsKey("startOnBoot") && ((Boolean) options.get("startOnBoot")).booleanValue()) {
                startAlarm();
                return;
            }
            return;
        }
        if ("android.intent.action.MY_PACKAGE_REPLACED".equals(action)) {
            startAlarm();
            return;
        }
        Context context = getContext();
        TaskManagerUtilsInterface taskManagerUtils = getTaskManagerUtils();
        if (context != null) {
            taskManagerUtils.executeTask(this.mTask, null, null);
        }
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumer, expo.modules.interfaces.taskManager.TaskConsumerInterface
    public boolean didExecuteJob(final JobService jobService, final JobParameters jobParameters) {
        this.mTask.execute(null, null, new TaskExecutionCallback() { // from class: expo.modules.backgroundfetch.BackgroundFetchTaskConsumer.1
            @Override // expo.modules.interfaces.taskManager.TaskExecutionCallback
            public void onFinished(Map<String, Object> map) {
                jobService.jobFinished(jobParameters, false);
            }
        });
        return true;
    }

    private AlarmManager getAlarmManager() {
        Context context = getContext();
        if (context != null) {
            return (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        }
        return null;
    }

    private int getIntervalMs() {
        TaskInterface taskInterface = this.mTask;
        Map<String, Object> options = taskInterface != null ? taskInterface.getOptions() : null;
        return (options == null || !options.containsKey("minimumInterval")) ? DEFAULT_INTERVAL_MS : ((Number) options.get("minimumInterval")).intValue() * 1000;
    }

    private void startAlarm() {
        Context context = getContext();
        AlarmManager alarmManager = getAlarmManager();
        if (alarmManager == null) {
            return;
        }
        int intervalMs = getIntervalMs();
        PendingIntent pendingIntentCreateTaskIntent = getTaskManagerUtils().createTaskIntent(context, this.mTask);
        this.mPendingIntent = pendingIntentCreateTaskIntent;
        alarmManager.cancel(pendingIntentCreateTaskIntent);
        Log.i(TAG, "Starting an alarm for task '" + this.mTask.getName() + "'.");
        long j = intervalMs;
        alarmManager.setInexactRepeating(2, SystemClock.elapsedRealtime() + j, j, this.mPendingIntent);
    }

    private void stopAlarm() {
        AlarmManager alarmManager = getAlarmManager();
        if (alarmManager == null || this.mPendingIntent == null) {
            return;
        }
        Log.i(TAG, "Stopping an alarm for task '" + this.mTask.getName() + "'.");
        alarmManager.cancel(this.mPendingIntent);
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostResume() {
        stopAlarm();
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostPause() {
        startAlarm();
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostDestroy() {
        Map<String, Object> options = this.mTask.getOptions();
        if (!options.containsKey("stopOnTerminate") || ((Boolean) options.get("stopOnTerminate")).booleanValue()) {
            stopAlarm();
        }
    }
}
