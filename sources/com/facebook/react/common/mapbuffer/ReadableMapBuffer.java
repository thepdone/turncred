package com.facebook.react.common.mapbuffer;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.jni.HybridData;
import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.uimanager.ViewProps;
import com.nimbusds.jose.jwk.gen.OctetSequenceKeyGenerator;
import io.sentry.protocol.SentryThread;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import kotlin.text.Typography;

/* compiled from: ReadableMapBuffer.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 D2\u00020\u0001:\u0002DEB\u000f\b\u0013\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0017\b\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\tH\u0016J\u0013\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010&\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00000(2\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010+\u001a\u00020,2\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0018\u0010-\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010.\u001a\u00020,H\u0002J\b\u0010/\u001a\u00020\tH\u0016J\t\u00100\u001a\u00020\u0006H\u0082 J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001702H\u0096\u0002J\u0010\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u00020\tH\u0002J\u0010\u00105\u001a\u00020,2\u0006\u0010#\u001a\u00020\tH\u0002J\u0010\u00106\u001a\u00020\u001f2\u0006\u00104\u001a\u00020\tH\u0002J\b\u00107\u001a\u000208H\u0002J\u0010\u00109\u001a\u00020\t2\u0006\u00104\u001a\u00020\tH\u0002J\u0010\u0010:\u001a\u00020%2\u0006\u00104\u001a\u00020\tH\u0002J\u0016\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00000(2\u0006\u0010<\u001a\u00020\tH\u0002J\u0010\u0010=\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\tH\u0002J\u0010\u0010>\u001a\u00020*2\u0006\u00104\u001a\u00020\tH\u0002J\u001d\u0010?\u001a\u00020@2\u0006\u00104\u001a\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bA\u0010BJ\b\u0010C\u001a\u00020*H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u000e\u0010\u0012\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006F"}, d2 = {"Lcom/facebook/react/common/mapbuffer/ReadableMapBuffer;", "Lcom/facebook/react/common/mapbuffer/MapBuffer;", "hybridData", "Lcom/facebook/jni/HybridData;", "(Lcom/facebook/jni/HybridData;)V", "buffer", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)V", "offset", "", "(Ljava/nio/ByteBuffer;I)V", "<set-?>", "count", "getCount", "()I", "mHybridData", "offsetForDynamicData", "getOffsetForDynamicData", "offsetToMapBuffer", "contains", "", SDKConstants.PARAM_KEY, "entryAt", "Lcom/facebook/react/common/mapbuffer/MapBuffer$Entry;", "equals", "other", "", "getBoolean", "getBucketIndexForKey", "intKey", "getDouble", "", "getInt", "getKeyOffset", "getKeyOffsetForBucketIndex", "bucketIndex", "getLong", "", "getMapBuffer", "getMapBufferList", "", "getString", "", "getType", "Lcom/facebook/react/common/mapbuffer/MapBuffer$DataType;", "getTypedValueOffsetForKey", "expected", "hashCode", "importByteBuffer", "iterator", "", "readBooleanValue", "bufferPosition", "readDataType", "readDoubleValue", "readHeader", "", "readIntValue", "readLongValue", "readMapBufferListValue", ViewProps.POSITION, "readMapBufferValue", "readStringValue", "readUnsignedShort", "Lkotlin/UShort;", "readUnsignedShort-BwKQO78", "(I)S", InAppPurchaseConstants.METHOD_TO_STRING, "Companion", "MapBufferEntry", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ReadableMapBuffer implements MapBuffer {
    private static final int ALIGNMENT = 254;
    private static final int BUCKET_SIZE = 12;
    private static final int HEADER_SIZE = 8;
    private static final int TYPE_OFFSET = 2;
    private static final int VALUE_OFFSET = 4;
    private final ByteBuffer buffer;
    private int count;
    private final HybridData mHybridData;
    private final int offsetToMapBuffer;

    private final native ByteBuffer importByteBuffer();

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public int getCount() {
        return this.count;
    }

    private ReadableMapBuffer(HybridData hybridData) {
        this.mHybridData = hybridData;
        this.buffer = importByteBuffer();
        this.offsetToMapBuffer = 0;
        readHeader();
    }

    private ReadableMapBuffer(ByteBuffer byteBuffer) {
        this.mHybridData = null;
        this.buffer = byteBuffer;
        this.offsetToMapBuffer = 0;
        readHeader();
    }

    private ReadableMapBuffer(ByteBuffer byteBuffer, int i) {
        this.mHybridData = null;
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(i);
        Intrinsics.checkNotNullExpressionValue(byteBufferDuplicate, "apply(...)");
        this.buffer = byteBufferDuplicate;
        this.offsetToMapBuffer = i;
        readHeader();
    }

    private final void readHeader() {
        if (this.buffer.getShort() != ALIGNMENT) {
            this.buffer.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.count = m5320readUnsignedShortBwKQO78(this.buffer.position()) & UShort.MAX_VALUE;
    }

    private final int getOffsetForDynamicData() {
        return getKeyOffsetForBucketIndex(getCount());
    }

    private final int getBucketIndexForKey(int intKey) {
        IntRange kEY_RANGE$ReactAndroid_release = MapBuffer.INSTANCE.getKEY_RANGE$ReactAndroid_release();
        int first = kEY_RANGE$ReactAndroid_release.getFirst();
        if (intKey <= kEY_RANGE$ReactAndroid_release.getLast() && first <= intKey) {
            short sM6218constructorimpl = UShort.m6218constructorimpl((short) intKey);
            int count = getCount() - 1;
            int i = 0;
            while (i <= count) {
                int i2 = (i + count) >>> 1;
                int iM5320readUnsignedShortBwKQO78 = m5320readUnsignedShortBwKQO78(getKeyOffsetForBucketIndex(i2)) & UShort.MAX_VALUE;
                int i3 = 65535 & sM6218constructorimpl;
                if (Intrinsics.compare(iM5320readUnsignedShortBwKQO78, i3) < 0) {
                    i = i2 + 1;
                } else {
                    if (Intrinsics.compare(iM5320readUnsignedShortBwKQO78, i3) <= 0) {
                        return i2;
                    }
                    count = i2 - 1;
                }
            }
        }
        return -1;
    }

    private final MapBuffer.DataType readDataType(int bucketIndex) {
        return MapBuffer.DataType.values()[m5320readUnsignedShortBwKQO78(getKeyOffsetForBucketIndex(bucketIndex) + 2) & UShort.MAX_VALUE];
    }

    private final int getTypedValueOffsetForKey(int key, MapBuffer.DataType expected) {
        int bucketIndexForKey = getBucketIndexForKey(key);
        if (bucketIndexForKey == -1) {
            throw new IllegalArgumentException(("Key not found: " + key).toString());
        }
        MapBuffer.DataType dataType = readDataType(bucketIndexForKey);
        if (dataType != expected) {
            throw new IllegalStateException(("Expected " + expected + " for key: " + key + ", found " + dataType + " instead.").toString());
        }
        return getKeyOffsetForBucketIndex(bucketIndexForKey) + 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: readUnsignedShort-BwKQO78, reason: not valid java name */
    public final short m5320readUnsignedShortBwKQO78(int bufferPosition) {
        return UShort.m6218constructorimpl(this.buffer.getShort(bufferPosition));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double readDoubleValue(int bufferPosition) {
        return this.buffer.getDouble(bufferPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int readIntValue(int bufferPosition) {
        return this.buffer.getInt(bufferPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long readLongValue(int bufferPosition) {
        return this.buffer.getLong(bufferPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean readBooleanValue(int bufferPosition) {
        return readIntValue(bufferPosition) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String readStringValue(int bufferPosition) {
        int offsetForDynamicData = getOffsetForDynamicData() + this.buffer.getInt(bufferPosition);
        int i = this.buffer.getInt(offsetForDynamicData);
        byte[] bArr = new byte[i];
        this.buffer.position(offsetForDynamicData + 4);
        this.buffer.get(bArr, 0, i);
        return new String(bArr, Charsets.UTF_8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReadableMapBuffer readMapBufferValue(int position) {
        return new ReadableMapBuffer(this.buffer, getOffsetForDynamicData() + this.buffer.getInt(position) + 4);
    }

    private final List<ReadableMapBuffer> readMapBufferListValue(int position) {
        ArrayList arrayList = new ArrayList();
        int offsetForDynamicData = getOffsetForDynamicData() + this.buffer.getInt(position);
        int i = this.buffer.getInt(offsetForDynamicData);
        int i2 = offsetForDynamicData + 4;
        int i3 = 0;
        while (i3 < i) {
            int i4 = this.buffer.getInt(i2 + i3);
            int i5 = i3 + 4;
            arrayList.add(new ReadableMapBuffer(this.buffer, i2 + i5));
            i3 = i5 + i4;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getKeyOffsetForBucketIndex(int bucketIndex) {
        return this.offsetToMapBuffer + 8 + (bucketIndex * 12);
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public boolean contains(int key) {
        return getBucketIndexForKey(key) != -1;
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public int getKeyOffset(int key) {
        return getBucketIndexForKey(key);
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public MapBuffer.Entry entryAt(int offset) {
        return new MapBufferEntry(getKeyOffsetForBucketIndex(offset));
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public MapBuffer.DataType getType(int key) {
        int bucketIndexForKey = getBucketIndexForKey(key);
        if (bucketIndexForKey == -1) {
            throw new IllegalArgumentException(("Key not found: " + key).toString());
        }
        return readDataType(bucketIndexForKey);
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public int getInt(int key) {
        return readIntValue(getTypedValueOffsetForKey(key, MapBuffer.DataType.INT));
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public long getLong(int key) {
        return readLongValue(getTypedValueOffsetForKey(key, MapBuffer.DataType.LONG));
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public double getDouble(int key) {
        return readDoubleValue(getTypedValueOffsetForKey(key, MapBuffer.DataType.DOUBLE));
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public String getString(int key) {
        return readStringValue(getTypedValueOffsetForKey(key, MapBuffer.DataType.STRING));
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public boolean getBoolean(int key) {
        return readBooleanValue(getTypedValueOffsetForKey(key, MapBuffer.DataType.BOOL));
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public ReadableMapBuffer getMapBuffer(int key) {
        return readMapBufferValue(getTypedValueOffsetForKey(key, MapBuffer.DataType.MAP));
    }

    @Override // com.facebook.react.common.mapbuffer.MapBuffer
    public List<ReadableMapBuffer> getMapBufferList(int key) {
        return readMapBufferListValue(getTypedValueOffsetForKey(key, MapBuffer.DataType.MAP));
    }

    public int hashCode() {
        this.buffer.rewind();
        return this.buffer.hashCode();
    }

    public boolean equals(Object other) {
        if (!(other instanceof ReadableMapBuffer)) {
            return false;
        }
        ByteBuffer byteBuffer = this.buffer;
        ByteBuffer byteBuffer2 = ((ReadableMapBuffer) other).buffer;
        if (byteBuffer == byteBuffer2) {
            return true;
        }
        byteBuffer.rewind();
        byteBuffer2.rewind();
        return Intrinsics.areEqual(byteBuffer, byteBuffer2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        CollectionsKt.joinTo(this, sb, (OctetSequenceKeyGenerator.MIN_KEY_SIZE_BITS & 2) != 0 ? ", " : null, (OctetSequenceKeyGenerator.MIN_KEY_SIZE_BITS & 4) != 0 ? "" : null, (OctetSequenceKeyGenerator.MIN_KEY_SIZE_BITS & 8) != 0 ? "" : null, (OctetSequenceKeyGenerator.MIN_KEY_SIZE_BITS & 16) != 0 ? -1 : 0, (OctetSequenceKeyGenerator.MIN_KEY_SIZE_BITS & 32) != 0 ? "..." : null, (OctetSequenceKeyGenerator.MIN_KEY_SIZE_BITS & 64) != 0 ? null : new Function1<MapBuffer.Entry, CharSequence>() { // from class: com.facebook.react.common.mapbuffer.ReadableMapBuffer.toString.1

            /* compiled from: ReadableMapBuffer.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.facebook.react.common.mapbuffer.ReadableMapBuffer$toString$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[MapBuffer.DataType.values().length];
                    try {
                        iArr[MapBuffer.DataType.BOOL.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[MapBuffer.DataType.INT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[MapBuffer.DataType.LONG.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[MapBuffer.DataType.DOUBLE.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[MapBuffer.DataType.STRING.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[MapBuffer.DataType.MAP.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(MapBuffer.Entry entry) {
                Intrinsics.checkNotNullParameter(entry, "entry");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(entry.getKey());
                sb2.append('=');
                switch (WhenMappings.$EnumSwitchMapping$0[entry.getType().ordinal()]) {
                    case 1:
                        sb2.append(entry.getBooleanValue());
                        break;
                    case 2:
                        sb2.append(entry.getIntValue());
                        break;
                    case 3:
                        sb2.append(entry.getLongValue());
                        break;
                    case 4:
                        sb2.append(entry.getDoubleValue());
                        break;
                    case 5:
                        sb2.append(Typography.quote);
                        sb2.append(entry.getStringValue());
                        sb2.append(Typography.quote);
                        break;
                    case 6:
                        sb2.append(entry.getMapBufferValue().toString());
                        break;
                }
                return sb2;
            }
        });
        sb.append('}');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* compiled from: ReadableMapBuffer.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u000b\u001a\u00020\fH\u0096\u0002J\t\u0010\r\u001a\u00020\u0002H\u0096\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000e"}, d2 = {"com/facebook/react/common/mapbuffer/ReadableMapBuffer$iterator$1", "", "Lcom/facebook/react/common/mapbuffer/MapBuffer$Entry;", SentryThread.JsonKeys.CURRENT, "", "getCurrent", "()I", "setCurrent", "(I)V", "last", "getLast", "hasNext", "", "next", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.facebook.react.common.mapbuffer.ReadableMapBuffer$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<MapBuffer.Entry>, KMappedMarker {
        private int current;
        private final int last;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        AnonymousClass1() {
            this.last = ReadableMapBuffer.this.getCount() - 1;
        }

        public final int getCurrent() {
            return this.current;
        }

        public final void setCurrent(int i) {
            this.current = i;
        }

        public final int getLast() {
            return this.last;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.current <= this.last;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public MapBuffer.Entry next() {
            ReadableMapBuffer readableMapBuffer = ReadableMapBuffer.this;
            int i = this.current;
            this.current = i + 1;
            return readableMapBuffer.new MapBufferEntry(readableMapBuffer.getKeyOffsetForBucketIndex(i));
        }
    }

    @Override // java.lang.Iterable
    public Iterator<MapBuffer.Entry> iterator() {
        return new AnonymousClass1();
    }

    /* compiled from: ReadableMapBuffer.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001fH\u0002R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/facebook/react/common/mapbuffer/ReadableMapBuffer$MapBufferEntry;", "Lcom/facebook/react/common/mapbuffer/MapBuffer$Entry;", "bucketOffset", "", "(Lcom/facebook/react/common/mapbuffer/ReadableMapBuffer;I)V", "booleanValue", "", "getBooleanValue", "()Z", "doubleValue", "", "getDoubleValue", "()D", "intValue", "getIntValue", "()I", SDKConstants.PARAM_KEY, "getKey", "longValue", "", "getLongValue", "()J", "mapBufferValue", "Lcom/facebook/react/common/mapbuffer/MapBuffer;", "getMapBufferValue", "()Lcom/facebook/react/common/mapbuffer/MapBuffer;", "stringValue", "", "getStringValue", "()Ljava/lang/String;", "type", "Lcom/facebook/react/common/mapbuffer/MapBuffer$DataType;", "getType", "()Lcom/facebook/react/common/mapbuffer/MapBuffer$DataType;", "assertType", "", "expected", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class MapBufferEntry implements MapBuffer.Entry {
        private final int bucketOffset;

        public MapBufferEntry(int i) {
            this.bucketOffset = i;
        }

        private final void assertType(MapBuffer.DataType expected) {
            MapBuffer.DataType type = getType();
            if (expected == type) {
                return;
            }
            throw new IllegalStateException(("Expected " + expected + " for key: " + getKey() + " found " + type + " instead.").toString());
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public int getKey() {
            return ReadableMapBuffer.this.m5320readUnsignedShortBwKQO78(this.bucketOffset) & UShort.MAX_VALUE;
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public MapBuffer.DataType getType() {
            return MapBuffer.DataType.values()[ReadableMapBuffer.this.m5320readUnsignedShortBwKQO78(this.bucketOffset + 2) & UShort.MAX_VALUE];
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public double getDoubleValue() {
            assertType(MapBuffer.DataType.DOUBLE);
            return ReadableMapBuffer.this.readDoubleValue(this.bucketOffset + 4);
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public int getIntValue() {
            assertType(MapBuffer.DataType.INT);
            return ReadableMapBuffer.this.readIntValue(this.bucketOffset + 4);
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public long getLongValue() {
            assertType(MapBuffer.DataType.LONG);
            return ReadableMapBuffer.this.readLongValue(this.bucketOffset + 4);
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public boolean getBooleanValue() {
            assertType(MapBuffer.DataType.BOOL);
            return ReadableMapBuffer.this.readBooleanValue(this.bucketOffset + 4);
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public String getStringValue() {
            assertType(MapBuffer.DataType.STRING);
            return ReadableMapBuffer.this.readStringValue(this.bucketOffset + 4);
        }

        @Override // com.facebook.react.common.mapbuffer.MapBuffer.Entry
        public MapBuffer getMapBufferValue() {
            assertType(MapBuffer.DataType.MAP);
            return ReadableMapBuffer.this.readMapBufferValue(this.bucketOffset + 4);
        }
    }

    static {
        MapBufferSoLoader.staticInit();
    }
}
