package com.mrousavy.camera.core.types;

import android.util.Size;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import io.sentry.rrweb.RRWebVideoEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Video.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/mrousavy/camera/core/types/Video;", "", "path", "", "durationMs", "", RRWebVideoEvent.JsonKeys.SIZE, "Landroid/util/Size;", "(Ljava/lang/String;JLandroid/util/Size;)V", "getDurationMs", "()J", "getPath", "()Ljava/lang/String;", "getSize", "()Landroid/util/Size;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Video {
    private final long durationMs;
    private final String path;
    private final Size size;

    public static /* synthetic */ Video copy$default(Video video, String str, long j, Size size, int i, Object obj) {
        if ((i & 1) != 0) {
            str = video.path;
        }
        if ((i & 2) != 0) {
            j = video.durationMs;
        }
        if ((i & 4) != 0) {
            size = video.size;
        }
        return video.copy(str, j, size);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDurationMs() {
        return this.durationMs;
    }

    /* renamed from: component3, reason: from getter */
    public final Size getSize() {
        return this.size;
    }

    public final Video copy(String path, long durationMs, Size size) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(size, "size");
        return new Video(path, durationMs, size);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Video)) {
            return false;
        }
        Video video = (Video) other;
        return Intrinsics.areEqual(this.path, video.path) && this.durationMs == video.durationMs && Intrinsics.areEqual(this.size, video.size);
    }

    public int hashCode() {
        return (((this.path.hashCode() * 31) + Long.hashCode(this.durationMs)) * 31) + this.size.hashCode();
    }

    public String toString() {
        return "Video(path=" + this.path + ", durationMs=" + this.durationMs + ", size=" + this.size + ")";
    }

    public Video(String path, long j, Size size) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(size, "size");
        this.path = path;
        this.durationMs = j;
        this.size = size;
    }

    public final long getDurationMs() {
        return this.durationMs;
    }

    public final String getPath() {
        return this.path;
    }

    public final Size getSize() {
        return this.size;
    }
}
