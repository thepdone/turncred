package expo.modules.camera.records;

import androidx.camera.video.Quality;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: CameraRecords.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lexpo/modules/camera/records/VideoQuality;", "", "Lexpo/modules/kotlin/types/Enumerable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "mapToQuality", "Landroidx/camera/video/Quality;", "VIDEO2160P", "VIDEO1080P", "VIDEO720P", "VIDEO480P", "VIDEO4X3", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VideoQuality implements Enumerable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VideoQuality[] $VALUES;
    private final String value;
    public static final VideoQuality VIDEO2160P = new VideoQuality("VIDEO2160P", 0, "2160p");
    public static final VideoQuality VIDEO1080P = new VideoQuality("VIDEO1080P", 1, "1080p");
    public static final VideoQuality VIDEO720P = new VideoQuality("VIDEO720P", 2, "720p");
    public static final VideoQuality VIDEO480P = new VideoQuality("VIDEO480P", 3, "480p");
    public static final VideoQuality VIDEO4X3 = new VideoQuality("VIDEO4X3", 4, "4:3");

    /* compiled from: CameraRecords.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VideoQuality.values().length];
            try {
                iArr[VideoQuality.VIDEO2160P.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VideoQuality.VIDEO1080P.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VideoQuality.VIDEO720P.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VideoQuality.VIDEO480P.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[VideoQuality.VIDEO4X3.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ VideoQuality[] $values() {
        return new VideoQuality[]{VIDEO2160P, VIDEO1080P, VIDEO720P, VIDEO480P, VIDEO4X3};
    }

    public static EnumEntries<VideoQuality> getEntries() {
        return $ENTRIES;
    }

    public static VideoQuality valueOf(String str) {
        return (VideoQuality) Enum.valueOf(VideoQuality.class, str);
    }

    public static VideoQuality[] values() {
        return (VideoQuality[]) $VALUES.clone();
    }

    private VideoQuality(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        VideoQuality[] videoQualityArr$values = $values();
        $VALUES = videoQualityArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(videoQualityArr$values);
    }

    public final Quality mapToQuality() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            Quality UHD = Quality.UHD;
            Intrinsics.checkNotNullExpressionValue(UHD, "UHD");
            return UHD;
        }
        if (i == 2) {
            Quality FHD = Quality.FHD;
            Intrinsics.checkNotNullExpressionValue(FHD, "FHD");
            return FHD;
        }
        if (i == 3) {
            Quality HD = Quality.HD;
            Intrinsics.checkNotNullExpressionValue(HD, "HD");
            return HD;
        }
        if (i == 4) {
            Quality SD = Quality.SD;
            Intrinsics.checkNotNullExpressionValue(SD, "SD");
            return SD;
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        Quality LOWEST = Quality.LOWEST;
        Intrinsics.checkNotNullExpressionValue(LOWEST, "LOWEST");
        return LOWEST;
    }
}
