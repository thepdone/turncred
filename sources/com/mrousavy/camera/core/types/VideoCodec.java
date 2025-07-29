package com.mrousavy.camera.core.types;

import com.mrousavy.camera.core.types.JSUnionValue;
import io.sentry.rrweb.RRWebVideoEvent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: VideoCodec.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/mrousavy/camera/core/types/VideoCodec;", "", "Lcom/mrousavy/camera/core/types/JSUnionValue;", "unionValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getUnionValue", "()Ljava/lang/String;", "toVideoEncoder", "", "H264", "H265", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VideoCodec implements JSUnionValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VideoCodec[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final VideoCodec H264 = new VideoCodec("H264", 0, RRWebVideoEvent.REPLAY_ENCODING);
    public static final VideoCodec H265 = new VideoCodec("H265", 1, "h265");
    private final String unionValue;

    /* compiled from: VideoCodec.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VideoCodec.values().length];
            try {
                iArr[VideoCodec.H264.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VideoCodec.H265.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ VideoCodec[] $values() {
        return new VideoCodec[]{H264, H265};
    }

    public static EnumEntries<VideoCodec> getEntries() {
        return $ENTRIES;
    }

    public static VideoCodec valueOf(String str) {
        return (VideoCodec) Enum.valueOf(VideoCodec.class, str);
    }

    public static VideoCodec[] values() {
        return (VideoCodec[]) $VALUES.clone();
    }

    private VideoCodec(String str, int i, String str2) {
        this.unionValue = str2;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    static {
        VideoCodec[] videoCodecArr$values = $values();
        $VALUES = videoCodecArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(videoCodecArr$values);
        INSTANCE = new Companion(null);
    }

    public final int toVideoEncoder() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 5;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* compiled from: VideoCodec.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/mrousavy/camera/core/types/VideoCodec$Companion;", "Lcom/mrousavy/camera/core/types/JSUnionValue$Companion;", "Lcom/mrousavy/camera/core/types/VideoCodec;", "()V", "fromUnionValue", "unionValue", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion implements JSUnionValue.Companion<VideoCodec> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mrousavy.camera.core.types.JSUnionValue.Companion
        public VideoCodec fromUnionValue(String unionValue) {
            return Intrinsics.areEqual(unionValue, RRWebVideoEvent.REPLAY_ENCODING) ? VideoCodec.H264 : Intrinsics.areEqual(unionValue, "h265") ? VideoCodec.H265 : VideoCodec.H264;
        }
    }
}
