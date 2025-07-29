package expo.modules.medialibrary;

import com.facebook.hermes.intl.Constants;
import expo.modules.contacts.Columns;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: MediaLibraryEnums.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lexpo/modules/medialibrary/SortBy;", "", "keyName", "", "mediaColumnName", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getKeyName", "()Ljava/lang/String;", "getMediaColumnName", "DEFAULT", "CREATION_TIME", "MODIFICATION_TIME", "MEDIA_TYPE", "WIDTH", "HEIGHT", "DURATION", "Companion", "expo-media-library_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SortBy {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SortBy[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String keyName;
    private final String mediaColumnName;
    public static final SortBy DEFAULT = new SortBy("DEFAULT", 0, Constants.COLLATION_DEFAULT, Columns.ID);
    public static final SortBy CREATION_TIME = new SortBy("CREATION_TIME", 1, "creationTime", "datetaken");
    public static final SortBy MODIFICATION_TIME = new SortBy("MODIFICATION_TIME", 2, "modificationTime", "date_modified");
    public static final SortBy MEDIA_TYPE = new SortBy("MEDIA_TYPE", 3, "mediaType", "media_type");
    public static final SortBy WIDTH = new SortBy("WIDTH", 4, "width", "width");
    public static final SortBy HEIGHT = new SortBy("HEIGHT", 5, "height", "height");
    public static final SortBy DURATION = new SortBy("DURATION", 6, "duration", "duration");

    private static final /* synthetic */ SortBy[] $values() {
        return new SortBy[]{DEFAULT, CREATION_TIME, MODIFICATION_TIME, MEDIA_TYPE, WIDTH, HEIGHT, DURATION};
    }

    public static EnumEntries<SortBy> getEntries() {
        return $ENTRIES;
    }

    public static SortBy valueOf(String str) {
        return (SortBy) Enum.valueOf(SortBy.class, str);
    }

    public static SortBy[] values() {
        return (SortBy[]) $VALUES.clone();
    }

    private SortBy(String str, int i, String str2, String str3) {
        this.keyName = str2;
        this.mediaColumnName = str3;
    }

    public final String getKeyName() {
        return this.keyName;
    }

    public final String getMediaColumnName() {
        return this.mediaColumnName;
    }

    static {
        SortBy[] sortByArr$values = $values();
        $VALUES = sortByArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(sortByArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: MediaLibraryEnums.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b¨\u0006\t"}, d2 = {"Lexpo/modules/medialibrary/SortBy$Companion;", "", "()V", "fromKeyName", "Lexpo/modules/medialibrary/SortBy;", "keyName", "", "getConstants", "", "expo-media-library_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, String> getConstants() {
            SortBy[] sortByArrValues = SortBy.values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(sortByArrValues.length), 16));
            for (SortBy sortBy : sortByArrValues) {
                Pair pair = new Pair(sortBy.getKeyName(), sortBy.getKeyName());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }

        public final SortBy fromKeyName(String keyName) {
            Intrinsics.checkNotNullParameter(keyName, "keyName");
            for (SortBy sortBy : SortBy.values()) {
                if (Intrinsics.areEqual(sortBy.getKeyName(), keyName)) {
                    return sortBy;
                }
            }
            return null;
        }
    }
}
