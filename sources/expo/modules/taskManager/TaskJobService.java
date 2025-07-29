package expo.modules.taskManager;

import android.app.job.JobParameters;
import android.app.job.JobService;

/* loaded from: classes5.dex */
public class TaskJobService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        return new TaskService(getApplicationContext()).handleJob(this, jobParameters);
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return new TaskService(getApplicationContext()).cancelJob(this, jobParameters);
    }
}
