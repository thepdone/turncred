package com.mrousavy.camera.core.types;

import com.mrousavy.camera.core.InvalidTypeScriptUnionError;
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
/* compiled from: VideoFileType.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/mrousavy/camera/core/types/VideoFileType;", "", "Lcom/mrousavy/camera/core/types/JSUnionValue;", "unionValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getUnionValue", "()Ljava/lang/String;", "toExtension", "MOV", "MP4", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VideoFileType implements JSUnionValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VideoFileType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final VideoFileType MOV = new VideoFileType("MOV", 0, "mov");
    public static final VideoFileType MP4 = new VideoFileType("MP4", 1, RRWebVideoEvent.REPLAY_CONTAINER);
    private final String unionValue;

    /* compiled from: VideoFileType.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VideoFileType.values().length];
            try {
                iArr[VideoFileType.MOV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VideoFileType.MP4.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ VideoFileType[] $values() {
        return new VideoFileType[]{MOV, MP4};
    }

    public static EnumEntries<VideoFileType> getEntries() {
        return $ENTRIES;
    }

    public static VideoFileType valueOf(String str) {
        return (VideoFileType) Enum.valueOf(VideoFileType.class, str);
    }

    public static VideoFileType[] values() {
        return (VideoFileType[]) $VALUES.clone();
    }

    private VideoFileType(String str, int i, String str2) {
        this.unionValue = str2;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    static {
        VideoFileType[] videoFileTypeArr$values = $values();
        $VALUES = videoFileTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(videoFileTypeArr$values);
        INSTANCE = new Companion(null);
    }

    public final String toExtension() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return ".mov";
        }
        if (i == 2) {
            return ".mp4";
        }
        throw new NoWhenBranchMatchedException();
    }

    /* compiled from: VideoFileType.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/mrousavy/camera/core/types/VideoFileType$Companion;", "Lcom/mrousavy/camera/core/types/JSUnionValue$Companion;", "Lcom/mrousavy/camera/core/types/VideoFileType;", "()V", "fromUnionValue", "unionValue", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion implements JSUnionValue.Companion<VideoFileType> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mrousavy.camera.core.types.JSUnionValue.Companion
        public VideoFileType fromUnionValue(String unionValue) throws InvalidTypeScriptUnionError {
            if (Intrinsics.areEqual(unionValue, "mov")) {
                return VideoFileType.MOV;
            }
            if (Intrinsics.areEqual(unionValue, RRWebVideoEvent.REPLAY_CONTAINER)) {
                return VideoFileType.MP4;
            }
            if (unionValue == null) {
                unionValue = "(null)";
            }
            throw new InvalidTypeScriptUnionError("fileType", unionValue);
        }
    }
}
