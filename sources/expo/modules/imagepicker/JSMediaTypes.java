package expo.modules.imagepicker;

import expo.modules.kotlin.types.Enumerable;
import io.sentry.protocol.DebugMeta;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ImagePickerOptions.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lexpo/modules/imagepicker/JSMediaTypes;", "", "Lexpo/modules/kotlin/types/Enumerable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "IMAGES", "VIDEOS", "LIVE_PHOTOS", "expo-image-picker_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JSMediaTypes implements Enumerable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ JSMediaTypes[] $VALUES;
    private final String value;
    public static final JSMediaTypes IMAGES = new JSMediaTypes("IMAGES", 0, DebugMeta.JsonKeys.IMAGES);
    public static final JSMediaTypes VIDEOS = new JSMediaTypes("VIDEOS", 1, "videos");
    public static final JSMediaTypes LIVE_PHOTOS = new JSMediaTypes("LIVE_PHOTOS", 2, "livePhotos");

    private static final /* synthetic */ JSMediaTypes[] $values() {
        return new JSMediaTypes[]{IMAGES, VIDEOS, LIVE_PHOTOS};
    }

    public static EnumEntries<JSMediaTypes> getEntries() {
        return $ENTRIES;
    }

    public static JSMediaTypes valueOf(String str) {
        return (JSMediaTypes) Enum.valueOf(JSMediaTypes.class, str);
    }

    public static JSMediaTypes[] values() {
        return (JSMediaTypes[]) $VALUES.clone();
    }

    private JSMediaTypes(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        JSMediaTypes[] jSMediaTypesArr$values = $values();
        $VALUES = jSMediaTypesArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(jSMediaTypesArr$values);
    }
}
