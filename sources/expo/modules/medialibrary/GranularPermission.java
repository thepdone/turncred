package expo.modules.medialibrary;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: MediaLibraryEnums.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\u0004H\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/medialibrary/GranularPermission;", "", "Lexpo/modules/kotlin/types/Enumerable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "toManifestPermission", "AUDIO", "PHOTO", ShareConstants.VIDEO_URL, "expo-media-library_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GranularPermission implements Enumerable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GranularPermission[] $VALUES;
    public static final GranularPermission AUDIO = new GranularPermission("AUDIO", 0, "audio");
    public static final GranularPermission PHOTO = new GranularPermission("PHOTO", 1, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
    public static final GranularPermission VIDEO = new GranularPermission(ShareConstants.VIDEO_URL, 2, "video");
    private final String value;

    /* compiled from: MediaLibraryEnums.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GranularPermission.values().length];
            try {
                iArr[GranularPermission.AUDIO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GranularPermission.PHOTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GranularPermission.VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ GranularPermission[] $values() {
        return new GranularPermission[]{AUDIO, PHOTO, VIDEO};
    }

    public static EnumEntries<GranularPermission> getEntries() {
        return $ENTRIES;
    }

    public static GranularPermission valueOf(String str) {
        return (GranularPermission) Enum.valueOf(GranularPermission.class, str);
    }

    public static GranularPermission[] values() {
        return (GranularPermission[]) $VALUES.clone();
    }

    private GranularPermission(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        GranularPermission[] granularPermissionArr$values = $values();
        $VALUES = granularPermissionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(granularPermissionArr$values);
    }

    public final String toManifestPermission() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return "android.permission.READ_MEDIA_AUDIO";
        }
        if (i == 2) {
            return "android.permission.READ_MEDIA_IMAGES";
        }
        if (i == 3) {
            return "android.permission.READ_MEDIA_VIDEO";
        }
        throw new NoWhenBranchMatchedException();
    }
}
