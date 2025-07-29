package com.mrousavy.camera.core.utils;

import android.media.CamcorderProfile;
import android.media.EncoderProfiles;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import io.sentry.rrweb.RRWebVideoEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* compiled from: CamcorderProfileUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/mrousavy/camera/core/utils/CamcorderProfileUtils;", "", "()V", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CamcorderProfileUtils {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "CamcorderProfileUtils";

    /* compiled from: CamcorderProfileUtils.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001d\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\t¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u0004J\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/mrousavy/camera/core/utils/CamcorderProfileUtils$Companion;", "", "()V", "TAG", "", "findClosestCamcorderProfileQuality", "", "cameraId", "resolution", "Landroid/util/Size;", "allowLargerSize", "", "getMaximumFps", RRWebVideoEvent.JsonKeys.SIZE, "(Ljava/lang/String;Landroid/util/Size;)Ljava/lang/Integer;", "getMaximumVideoSize", "getRecommendedBitRate", "videoSize", "getResolutionForCamcorderProfileQuality", "camcorderProfile", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final int getResolutionForCamcorderProfileQuality(int camcorderProfile) {
            switch (camcorderProfile) {
                case 2:
                    return 25344;
                case 3:
                    return 101376;
                case 4:
                    return 345600;
                case 5:
                    return 921600;
                case 6:
                    return 2073600;
                case 7:
                    return 76800;
                case 8:
                    return 8294400;
                case 9:
                    return 307200;
                case 10:
                    return 8847360;
                case 11:
                    return 3686400;
                case 12:
                    return 2211840;
                case 13:
                    return 33177600;
                default:
                    throw new Error("Invalid CamcorderProfile \"" + camcorderProfile + "\"!");
            }
        }

        private final int findClosestCamcorderProfileQuality(String cameraId, Size resolution, boolean allowLargerSize) {
            boolean zHasProfile;
            int width = resolution.getWidth() * resolution.getHeight();
            Integer intOrNull = StringsKt.toIntOrNull(cameraId);
            IntRange intRange = new IntRange(2, 13);
            ArrayList arrayList = new ArrayList();
            for (Integer num : intRange) {
                int iIntValue = num.intValue();
                if (intOrNull != null) {
                    zHasProfile = CamcorderProfile.hasProfile(intOrNull.intValue(), iIntValue);
                } else {
                    zHasProfile = CamcorderProfile.hasProfile(iIntValue);
                }
                if (zHasProfile) {
                    arrayList.add(num);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (!allowLargerSize) {
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : arrayList2) {
                    if (CamcorderProfileUtils.INSTANCE.getResolutionForCamcorderProfileQuality(((Number) obj).intValue()) <= width) {
                        arrayList3.add(obj);
                    }
                }
                arrayList2 = arrayList3;
            }
            Iterator it = arrayList2.iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            Object next = it.next();
            if (it.hasNext()) {
                int iAbs = Math.abs(CamcorderProfileUtils.INSTANCE.getResolutionForCamcorderProfileQuality(((Number) next).intValue()) - width);
                do {
                    Object next2 = it.next();
                    int iAbs2 = Math.abs(CamcorderProfileUtils.INSTANCE.getResolutionForCamcorderProfileQuality(((Number) next2).intValue()) - width);
                    if (iAbs > iAbs2) {
                        next = next2;
                        iAbs = iAbs2;
                    }
                } while (it.hasNext());
            }
            return ((Number) next).intValue();
        }

        public final Size getMaximumVideoSize(String cameraId) {
            EncoderProfiles all;
            Object next;
            Intrinsics.checkNotNullParameter(cameraId, "cameraId");
            try {
                if (Build.VERSION.SDK_INT >= 31 && (all = CamcorderProfile.getAll(cameraId, 1)) != null) {
                    List<EncoderProfiles.VideoProfile> videoProfiles = all.getVideoProfiles();
                    Intrinsics.checkNotNullExpressionValue(videoProfiles, "getVideoProfiles(...)");
                    Iterator it = CollectionsKt.filterNotNull(videoProfiles).iterator();
                    if (it.hasNext()) {
                        next = it.next();
                        if (it.hasNext()) {
                            EncoderProfiles.VideoProfile videoProfile = (EncoderProfiles.VideoProfile) next;
                            int width = videoProfile.getWidth() * videoProfile.getHeight();
                            do {
                                Object next2 = it.next();
                                EncoderProfiles.VideoProfile videoProfile2 = (EncoderProfiles.VideoProfile) next2;
                                int width2 = videoProfile2.getWidth() * videoProfile2.getHeight();
                                if (width < width2) {
                                    next = next2;
                                    width = width2;
                                }
                            } while (it.hasNext());
                        }
                    } else {
                        next = null;
                    }
                    EncoderProfiles.VideoProfile videoProfile3 = (EncoderProfiles.VideoProfile) next;
                    if (videoProfile3 != null) {
                        return new Size(videoProfile3.getWidth(), videoProfile3.getHeight());
                    }
                }
                Integer intOrNull = StringsKt.toIntOrNull(cameraId);
                if (intOrNull == null) {
                    return null;
                }
                CamcorderProfile camcorderProfile = CamcorderProfile.get(intOrNull.intValue(), 1);
                return new Size(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
            } catch (Throwable th) {
                Log.e(CamcorderProfileUtils.TAG, "Failed to get maximum video size for Camera ID " + cameraId + "! " + th.getMessage(), th);
                return null;
            }
        }

        public final Integer getMaximumFps(String cameraId, Size size) {
            EncoderProfiles all;
            Intrinsics.checkNotNullParameter(cameraId, "cameraId");
            Intrinsics.checkNotNullParameter(size, "size");
            try {
                int iFindClosestCamcorderProfileQuality = findClosestCamcorderProfileQuality(cameraId, size, false);
                if (Build.VERSION.SDK_INT >= 31 && (all = CamcorderProfile.getAll(cameraId, iFindClosestCamcorderProfileQuality)) != null) {
                    List<EncoderProfiles.VideoProfile> videoProfiles = all.getVideoProfiles();
                    Intrinsics.checkNotNullExpressionValue(videoProfiles, "getVideoProfiles(...)");
                    Iterator<T> it = videoProfiles.iterator();
                    if (!it.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Integer numValueOf = Integer.valueOf(((EncoderProfiles.VideoProfile) it.next()).getFrameRate());
                    while (it.hasNext()) {
                        Integer numValueOf2 = Integer.valueOf(((EncoderProfiles.VideoProfile) it.next()).getFrameRate());
                        if (numValueOf.compareTo(numValueOf2) < 0) {
                            numValueOf = numValueOf2;
                        }
                    }
                    return numValueOf;
                }
                Integer intOrNull = StringsKt.toIntOrNull(cameraId);
                if (intOrNull != null) {
                    return Integer.valueOf(CamcorderProfile.get(intOrNull.intValue(), iFindClosestCamcorderProfileQuality).videoFrameRate);
                }
                return null;
            } catch (Throwable th) {
                Log.e(CamcorderProfileUtils.TAG, "Failed to get maximum FPS for Camera ID " + cameraId + "! " + th.getMessage(), th);
                return null;
            }
        }

        public final Integer getRecommendedBitRate(String cameraId, Size videoSize) {
            EncoderProfiles all;
            Intrinsics.checkNotNullParameter(cameraId, "cameraId");
            Intrinsics.checkNotNullParameter(videoSize, "videoSize");
            try {
                int iFindClosestCamcorderProfileQuality = findClosestCamcorderProfileQuality(cameraId, videoSize, true);
                if (Build.VERSION.SDK_INT >= 31 && (all = CamcorderProfile.getAll(cameraId, iFindClosestCamcorderProfileQuality)) != null) {
                    List<EncoderProfiles.VideoProfile> videoProfiles = all.getVideoProfiles();
                    Intrinsics.checkNotNullExpressionValue(videoProfiles, "getVideoProfiles(...)");
                    Iterator<T> it = videoProfiles.iterator();
                    if (!it.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Integer numValueOf = Integer.valueOf(((EncoderProfiles.VideoProfile) it.next()).getBitrate());
                    while (it.hasNext()) {
                        Integer numValueOf2 = Integer.valueOf(((EncoderProfiles.VideoProfile) it.next()).getBitrate());
                        if (numValueOf.compareTo(numValueOf2) < 0) {
                            numValueOf = numValueOf2;
                        }
                    }
                    return numValueOf;
                }
                Integer intOrNull = StringsKt.toIntOrNull(cameraId);
                if (intOrNull != null) {
                    return Integer.valueOf(CamcorderProfile.get(intOrNull.intValue(), iFindClosestCamcorderProfileQuality).videoBitRate);
                }
                return null;
            } catch (Throwable th) {
                Log.e(CamcorderProfileUtils.TAG, "Failed to get recommended video bit-rate for Camera ID " + cameraId + "! " + th.getMessage(), th);
                return null;
            }
        }
    }
}
