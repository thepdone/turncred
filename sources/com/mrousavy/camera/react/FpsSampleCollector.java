package com.mrousavy.camera.react;

import androidx.camera.video.AudioStats;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FpsSampleCollector.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/mrousavy/camera/react/FpsSampleCollector;", "", "callback", "Lcom/mrousavy/camera/react/FpsSampleCollector$Callback;", "(Lcom/mrousavy/camera/react/FpsSampleCollector$Callback;)V", "averageFps", "", "getAverageFps", "()D", "getCallback", "()Lcom/mrousavy/camera/react/FpsSampleCollector$Callback;", "timer", "Ljava/util/Timer;", "timestamps", "", "", "onTick", "", ViewProps.START, "stop", "Callback", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FpsSampleCollector {
    private final Callback callback;
    private Timer timer;
    private List<Long> timestamps;

    /* compiled from: FpsSampleCollector.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/mrousavy/camera/react/FpsSampleCollector$Callback;", "", "onAverageFpsChanged", "", "averageFps", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Callback {
        void onAverageFpsChanged(double averageFps);
    }

    public FpsSampleCollector(Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        this.timestamps = new ArrayList();
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final void start() {
        Timer timer = new Timer("VisionCamera FPS Sample Collector");
        this.timer = timer;
        timer.schedule(new TimerTask() { // from class: com.mrousavy.camera.react.FpsSampleCollector$start$$inlined$schedule$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                this.this$0.getCallback().onAverageFpsChanged(this.this$0.getAverageFps());
            }
        }, 1000L, 1000L);
    }

    public final void stop() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
        this.timer = null;
    }

    public final void onTick() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.timestamps.add(Long.valueOf(jCurrentTimeMillis));
        List<Long> list = this.timestamps;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (jCurrentTimeMillis - ((Number) obj).longValue() < 1000) {
                arrayList.add(obj);
            }
        }
        this.timestamps = CollectionsKt.toMutableList((Collection) arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double getAverageFps() {
        return (((Long) CollectionsKt.firstOrNull((List) this.timestamps)) == null || ((Long) CollectionsKt.lastOrNull((List) this.timestamps)) == null) ? AudioStats.AUDIO_AMPLITUDE_NONE : 1000.0d / ((r1.longValue() - r0.longValue()) / (this.timestamps.size() - 1));
    }
}
