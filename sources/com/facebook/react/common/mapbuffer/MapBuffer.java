package com.facebook.react.common.mapbuffer;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;

/* compiled from: MapBuffer.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001a\u001b\u001cJ\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0004H&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H&J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H&J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0004H&J\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004H&J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00000\u00152\u0006\u0010\t\u001a\u00020\u0004H&J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u0004H&J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\u0004H&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001dÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/common/mapbuffer/MapBuffer;", "", "Lcom/facebook/react/common/mapbuffer/MapBuffer$Entry;", "count", "", "getCount", "()I", "contains", "", SDKConstants.PARAM_KEY, "entryAt", "offset", "getBoolean", "getDouble", "", "getInt", "getKeyOffset", "getLong", "", "getMapBuffer", "getMapBufferList", "", "getString", "", "getType", "Lcom/facebook/react/common/mapbuffer/MapBuffer$DataType;", "Companion", "DataType", "Entry", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface MapBuffer extends Iterable<Entry>, KMappedMarker {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: MapBuffer.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006 À\u0006\u0001"}, d2 = {"Lcom/facebook/react/common/mapbuffer/MapBuffer$Entry;", "", "booleanValue", "", "getBooleanValue", "()Z", "doubleValue", "", "getDoubleValue", "()D", "intValue", "", "getIntValue", "()I", SDKConstants.PARAM_KEY, "getKey", "longValue", "", "getLongValue", "()J", "mapBufferValue", "Lcom/facebook/react/common/mapbuffer/MapBuffer;", "getMapBufferValue", "()Lcom/facebook/react/common/mapbuffer/MapBuffer;", "stringValue", "", "getStringValue", "()Ljava/lang/String;", "type", "Lcom/facebook/react/common/mapbuffer/MapBuffer$DataType;", "getType", "()Lcom/facebook/react/common/mapbuffer/MapBuffer$DataType;", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Entry {
        boolean getBooleanValue();

        double getDoubleValue();

        int getIntValue();

        int getKey();

        long getLongValue();

        MapBuffer getMapBufferValue();

        String getStringValue();

        DataType getType();
    }

    boolean contains(int key);

    Entry entryAt(int offset);

    boolean getBoolean(int key);

    int getCount();

    double getDouble(int key);

    int getInt(int key);

    int getKeyOffset(int key);

    long getLong(int key);

    MapBuffer getMapBuffer(int key);

    List<MapBuffer> getMapBufferList(int key);

    String getString(int key);

    DataType getType(int key);

    /* compiled from: MapBuffer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/react/common/mapbuffer/MapBuffer$Companion;", "", "()V", "KEY_RANGE", "Lkotlin/ranges/IntRange;", "getKEY_RANGE$ReactAndroid_release", "()Lkotlin/ranges/IntRange;", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final IntRange KEY_RANGE = new IntRange(0, 65535);

        private Companion() {
        }

        public final IntRange getKEY_RANGE$ReactAndroid_release() {
            return KEY_RANGE;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: MapBuffer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/facebook/react/common/mapbuffer/MapBuffer$DataType;", "", "(Ljava/lang/String;I)V", "BOOL", "INT", "DOUBLE", "STRING", "MAP", "LONG", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DataType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DataType[] $VALUES;
        public static final DataType BOOL = new DataType("BOOL", 0);
        public static final DataType INT = new DataType("INT", 1);
        public static final DataType DOUBLE = new DataType("DOUBLE", 2);
        public static final DataType STRING = new DataType("STRING", 3);
        public static final DataType MAP = new DataType("MAP", 4);
        public static final DataType LONG = new DataType("LONG", 5);

        private static final /* synthetic */ DataType[] $values() {
            return new DataType[]{BOOL, INT, DOUBLE, STRING, MAP, LONG};
        }

        public static EnumEntries<DataType> getEntries() {
            return $ENTRIES;
        }

        public static DataType valueOf(String str) {
            return (DataType) Enum.valueOf(DataType.class, str);
        }

        public static DataType[] values() {
            return (DataType[]) $VALUES.clone();
        }

        private DataType(String str, int i) {
        }

        static {
            DataType[] dataTypeArr$values = $values();
            $VALUES = dataTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(dataTypeArr$values);
        }
    }
}
