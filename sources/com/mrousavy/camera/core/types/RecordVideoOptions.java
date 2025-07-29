package com.mrousavy.camera.core.types;

import android.content.Context;
import com.facebook.react.bridge.ReadableMap;
import com.mrousavy.camera.core.utils.FileUtils;
import com.mrousavy.camera.core.utils.OutputFile;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecordVideoOptions.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/mrousavy/camera/core/types/RecordVideoOptions;", "", "file", "Lcom/mrousavy/camera/core/utils/OutputFile;", "videoCodec", "Lcom/mrousavy/camera/core/types/VideoCodec;", "(Lcom/mrousavy/camera/core/utils/OutputFile;Lcom/mrousavy/camera/core/types/VideoCodec;)V", "getFile", "()Lcom/mrousavy/camera/core/utils/OutputFile;", "getVideoCodec", "()Lcom/mrousavy/camera/core/types/VideoCodec;", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecordVideoOptions {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final OutputFile file;
    private final VideoCodec videoCodec;

    public RecordVideoOptions(OutputFile file, VideoCodec videoCodec) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(videoCodec, "videoCodec");
        this.file = file;
        this.videoCodec = videoCodec;
    }

    public final OutputFile getFile() {
        return this.file;
    }

    public final VideoCodec getVideoCodec() {
        return this.videoCodec;
    }

    /* compiled from: RecordVideoOptions.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/mrousavy/camera/core/types/RecordVideoOptions$Companion;", "", "()V", "fromJSValue", "Lcom/mrousavy/camera/core/types/RecordVideoOptions;", "context", "Landroid/content/Context;", "map", "Lcom/facebook/react/bridge/ReadableMap;", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RecordVideoOptions fromJSValue(Context context, ReadableMap map) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(map, "map");
            File directory = map.hasKey("path") ? FileUtils.INSTANCE.getDirectory(map.getString("path")) : context.getCacheDir();
            VideoFileType videoFileTypeFromUnionValue = map.hasKey("fileType") ? VideoFileType.INSTANCE.fromUnionValue(map.getString("fileType")) : VideoFileType.MOV;
            VideoCodec videoCodecFromUnionValue = map.hasKey("videoCodec") ? VideoCodec.INSTANCE.fromUnionValue(map.getString("videoCodec")) : VideoCodec.H264;
            Intrinsics.checkNotNull(directory);
            return new RecordVideoOptions(new OutputFile(context, directory, videoFileTypeFromUnionValue.toExtension()), videoCodecFromUnionValue);
        }
    }
}
