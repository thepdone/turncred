package expo.modules.imagepicker;

import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.language.bm.Rule;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ImagePickerOptions.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lexpo/modules/imagepicker/MediaTypes;", "", "Lexpo/modules/kotlin/types/Enumerable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "toCameraIntentAction", "toFileExtension", "toMimeType", "IMAGES", "VIDEOS", Rule.ALL, "Companion", "expo-image-picker_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MediaTypes implements Enumerable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MediaTypes[] $VALUES;
    private static final String AllMimeType = "*/*";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final String ImageAllMimeType = "image/*";
    private static final String VideoAllMimeType = "video/*";
    private final String value;
    public static final MediaTypes IMAGES = new MediaTypes("IMAGES", 0, "Images");
    public static final MediaTypes VIDEOS = new MediaTypes("VIDEOS", 1, "Videos");
    public static final MediaTypes ALL = new MediaTypes(Rule.ALL, 2, "All");

    /* compiled from: ImagePickerOptions.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MediaTypes.values().length];
            try {
                iArr[MediaTypes.IMAGES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaTypes.VIDEOS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MediaTypes.ALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ MediaTypes[] $values() {
        return new MediaTypes[]{IMAGES, VIDEOS, ALL};
    }

    public static EnumEntries<MediaTypes> getEntries() {
        return $ENTRIES;
    }

    public static MediaTypes valueOf(String str) {
        return (MediaTypes) Enum.valueOf(MediaTypes.class, str);
    }

    public static MediaTypes[] values() {
        return (MediaTypes[]) $VALUES.clone();
    }

    private MediaTypes(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        MediaTypes[] mediaTypesArr$values = $values();
        $VALUES = mediaTypesArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(mediaTypesArr$values);
        INSTANCE = new Companion(null);
    }

    public final String toMimeType() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return ImageAllMimeType;
        }
        if (i == 2) {
            return VideoAllMimeType;
        }
        if (i == 3) {
            return AllMimeType;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String toFileExtension() {
        if (WhenMappings.$EnumSwitchMapping$0[ordinal()] == 2) {
            return ".mp4";
        }
        return ".jpeg";
    }

    public final String toCameraIntentAction() {
        if (WhenMappings.$EnumSwitchMapping$0[ordinal()] == 2) {
            return "android.media.action.VIDEO_CAPTURE";
        }
        return "android.media.action.IMAGE_CAPTURE";
    }

    /* compiled from: ImagePickerOptions.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lexpo/modules/imagepicker/MediaTypes$Companion;", "", "()V", "AllMimeType", "", "ImageAllMimeType", "VideoAllMimeType", "fromJSMediaTypesArray", "Lexpo/modules/imagepicker/MediaTypes;", "mediaTypes", "", "Lexpo/modules/imagepicker/JSMediaTypes;", "([Lexpo/modules/imagepicker/JSMediaTypes;)Lexpo/modules/imagepicker/MediaTypes;", "expo-image-picker_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MediaTypes fromJSMediaTypesArray(JSMediaTypes[] mediaTypes) {
            Intrinsics.checkNotNullParameter(mediaTypes, "mediaTypes");
            if (!ArraysKt.contains(mediaTypes, JSMediaTypes.VIDEOS)) {
                return MediaTypes.IMAGES;
            }
            if (ArraysKt.contains(mediaTypes, JSMediaTypes.VIDEOS) && !ArraysKt.contains(mediaTypes, JSMediaTypes.IMAGES)) {
                return MediaTypes.VIDEOS;
            }
            return MediaTypes.ALL;
        }
    }
}
