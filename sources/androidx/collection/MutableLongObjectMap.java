package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LongObjectMap.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0006\u0010\t\u001a\u00020\bJ\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J'\u0010\u0010\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\bH\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0011\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0086\nJ\u0011\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001bH\u0086\nJ\u0011\u0010\u0018\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0086\nJ\u0011\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001cH\u0086\nJ\u0017\u0010\u001d\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\nJ\u001d\u0010\u001f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00028\u0000¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0015\u0010#\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010$J\u001b\u0010#\u001a\u00020%2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00028\u0000¢\u0006\u0002\u0010&J&\u0010'\u001a\u00020\b2\u0018\u0010(\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020%0)H\u0086\bø\u0001\u0000J\u0017\u0010*\u001a\u0004\u0018\u00018\u00002\u0006\u0010+\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u0004H\u0002J\u001e\u0010/\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u00100J\u0006\u00101\u001a\u00020\u0004J\u0019\u00102\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\rH\u0082\bR\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00063"}, d2 = {"Landroidx/collection/MutableLongObjectMap;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/collection/LongObjectMap;", "initialCapacity", "", "(I)V", "growthLimit", "adjustStorage", "", "clear", "dropDeletes", "findAbsoluteInsertIndex", SDKConstants.PARAM_KEY, "", "findFirstAvailableSlot", "hash1", "getOrPut", "defaultValue", "Lkotlin/Function0;", "(JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "keys", "Landroidx/collection/LongList;", "Landroidx/collection/LongSet;", "", "plusAssign", Constants.MessagePayloadKeys.FROM, "put", "value", "(JLjava/lang/Object;)Ljava/lang/Object;", "putAll", "remove", "(J)Ljava/lang/Object;", "", "(JLjava/lang/Object;)Z", "removeIf", "predicate", "Lkotlin/Function2;", "removeValueAt", FirebaseAnalytics.Param.INDEX, "(I)Ljava/lang/Object;", "resizeStorage", "newCapacity", "set", "(JLjava/lang/Object;)V", "trim", "writeMetadata", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableLongObjectMap<V> extends LongObjectMap<V> {
    private int growthLimit;

    public MutableLongObjectMap() {
        this(0, 1, null);
    }

    public /* synthetic */ MutableLongObjectMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    public MutableLongObjectMap(int i) {
        super(null);
        if (!(i >= 0)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
        }
        initializeStorage(ScatterMapKt.unloadedCapacity(i));
    }

    private final void initializeStorage(int initialCapacity) {
        int iMax = initialCapacity > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(initialCapacity)) : 0;
        this._capacity = iMax;
        initializeMetadata(iMax);
        this.keys = new long[iMax];
        this.values = new Object[iMax];
    }

    private final void initializeMetadata(int capacity) {
        long[] jArr;
        if (capacity == 0) {
            jArr = ScatterMapKt.EmptyGroup;
        } else {
            jArr = new long[((capacity + 15) & (-8)) >> 3];
            ArraysKt.fill$default(jArr, -9187201950435737472L, 0, 0, 6, (Object) null);
        }
        this.metadata = jArr;
        long[] jArr2 = this.metadata;
        int i = capacity >> 3;
        long j = 255 << ((capacity & 7) << 3);
        jArr2[i] = (jArr2[i] & (~j)) | j;
        initializeGrowth();
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(get_capacity()) - this._size;
    }

    public final V getOrPut(long key, Function0<? extends V> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        V v = get(key);
        if (v != null) {
            return v;
        }
        V vInvoke = defaultValue.invoke();
        set(key, vInvoke);
        return vInvoke;
    }

    public final void set(long key, V value) {
        int iFindAbsoluteInsertIndex = findAbsoluteInsertIndex(key);
        this.keys[iFindAbsoluteInsertIndex] = key;
        this.values[iFindAbsoluteInsertIndex] = value;
    }

    public final V put(long key, V value) {
        int iFindAbsoluteInsertIndex = findAbsoluteInsertIndex(key);
        V v = (V) this.values[iFindAbsoluteInsertIndex];
        this.keys[iFindAbsoluteInsertIndex] = key;
        this.values[iFindAbsoluteInsertIndex] = value;
        return v;
    }

    public final void plusAssign(LongObjectMap<V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        putAll(from);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0068, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x006a, code lost:
    
        r12 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final V remove(long r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r0
            androidx.collection.LongObjectMap r1 = (androidx.collection.LongObjectMap) r1
            int r2 = java.lang.Long.hashCode(r17)
            r3 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r2 = r2 * r3
            int r3 = r2 << 16
            r2 = r2 ^ r3
            r3 = r2 & 127(0x7f, float:1.78E-43)
            int r4 = r1._capacity
            int r2 = r2 >>> 7
            r2 = r2 & r4
            r5 = 0
        L18:
            long[] r6 = r1.metadata
            int r7 = r2 >> 3
            r8 = r2 & 7
            int r8 = r8 << 3
            r9 = r6[r7]
            long r9 = r9 >>> r8
            int r7 = r7 + 1
            r11 = r6[r7]
            int r6 = 64 - r8
            long r6 = r11 << r6
            long r11 = (long) r8
            long r11 = -r11
            r8 = 63
            long r11 = r11 >> r8
            long r6 = r6 & r11
            long r6 = r6 | r9
            long r8 = (long) r3
            r10 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r8 = r8 * r10
            long r8 = r8 ^ r6
            long r10 = r8 - r10
            long r8 = ~r8
            long r8 = r8 & r10
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
        L44:
            r12 = 0
            int r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r14 == 0) goto L61
            int r12 = java.lang.Long.numberOfTrailingZeros(r8)
            int r12 = r12 >> 3
            int r12 = r12 + r2
            r12 = r12 & r4
            long[] r13 = r1.keys
            r14 = r13[r12]
            int r13 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r13 != 0) goto L5b
            goto L6b
        L5b:
            r12 = 1
            long r12 = r8 - r12
            long r8 = r8 & r12
            goto L44
        L61:
            long r8 = ~r6
            r14 = 6
            long r8 = r8 << r14
            long r6 = r6 & r8
            long r6 = r6 & r10
            int r6 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r6 == 0) goto L74
            r12 = -1
        L6b:
            if (r12 < 0) goto L72
            java.lang.Object r1 = r0.removeValueAt(r12)
            return r1
        L72:
            r1 = 0
            return r1
        L74:
            int r5 = r5 + 8
            int r2 = r2 + r5
            r2 = r2 & r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableLongObjectMap.remove(long):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0069, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x006b, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean remove(long r19, V r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r0
            androidx.collection.LongObjectMap r1 = (androidx.collection.LongObjectMap) r1
            int r2 = java.lang.Long.hashCode(r19)
            r3 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r2 = r2 * r3
            int r3 = r2 << 16
            r2 = r2 ^ r3
            r3 = r2 & 127(0x7f, float:1.78E-43)
            int r4 = r1._capacity
            int r2 = r2 >>> 7
            r2 = r2 & r4
            r5 = 0
            r6 = r5
        L19:
            long[] r7 = r1.metadata
            int r8 = r2 >> 3
            r9 = r2 & 7
            int r9 = r9 << 3
            r10 = r7[r8]
            long r10 = r10 >>> r9
            r12 = 1
            int r8 = r8 + r12
            r13 = r7[r8]
            int r7 = 64 - r9
            long r7 = r13 << r7
            long r13 = (long) r9
            long r13 = -r13
            r9 = 63
            long r13 = r13 >> r9
            long r7 = r7 & r13
            long r7 = r7 | r10
            long r9 = (long) r3
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r13
            long r9 = r9 ^ r7
            long r13 = r9 - r13
            long r9 = ~r9
            long r9 = r9 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r13
        L45:
            r15 = 0
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L62
            int r11 = java.lang.Long.numberOfTrailingZeros(r9)
            int r11 = r11 >> 3
            int r11 = r11 + r2
            r11 = r11 & r4
            long[] r15 = r1.keys
            r16 = r15[r11]
            int r15 = (r16 > r19 ? 1 : (r16 == r19 ? 0 : -1))
            if (r15 != 0) goto L5c
            goto L6c
        L5c:
            r15 = 1
            long r15 = r9 - r15
            long r9 = r9 & r15
            goto L45
        L62:
            long r9 = ~r7
            r11 = 6
            long r9 = r9 << r11
            long r7 = r7 & r9
            long r7 = r7 & r13
            int r7 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r7 == 0) goto L7f
            r11 = -1
        L6c:
            if (r11 < 0) goto L7e
            java.lang.Object[] r1 = r0.values
            r1 = r1[r11]
            r7 = r21
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r7)
            if (r1 == 0) goto L7e
            r0.removeValueAt(r11)
            return r12
        L7e:
            return r5
        L7f:
            r7 = r21
            int r6 = r6 + 8
            int r2 = r2 + r6
            r2 = r2 & r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableLongObjectMap.remove(long, java.lang.Object):boolean");
    }

    public final void removeIf(Function2<? super Long, ? super V, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        if (predicate.invoke(Long.valueOf(this.keys[i4]), this.values[i4]).booleanValue()) {
                            removeValueAt(i4);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void minusAssign(long key) {
        remove(key);
    }

    public final void minusAssign(long[] keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        for (long j : keys) {
            remove(j);
        }
    }

    public final V removeValueAt(int index) {
        this._size--;
        long[] jArr = this.metadata;
        int i = this._capacity;
        int i2 = index >> 3;
        int i3 = (index & 7) << 3;
        long j = (jArr[i2] & (~(255 << i3))) | (254 << i3);
        jArr[i2] = j;
        jArr[(((index - 7) & i) + (i & 7)) >> 3] = j;
        V v = (V) this.values[index];
        this.values[index] = null;
        return v;
    }

    public final void clear() {
        this._size = 0;
        if (this.metadata != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(this.metadata, -9187201950435737472L, 0, 0, 6, (Object) null);
            long[] jArr = this.metadata;
            int i = this._capacity;
            int i2 = i >> 3;
            long j = 255 << ((i & 7) << 3);
            jArr[i2] = (jArr[i2] & (~j)) | j;
        }
        ArraysKt.fill(this.values, (Object) null, 0, this._capacity);
        initializeGrowth();
    }

    private final int findFirstAvailableSlot(int hash1) {
        int i = this._capacity;
        int i2 = hash1 & i;
        int i3 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i4 = i2 >> 3;
            int i5 = (i2 & 7) << 3;
            long j = ((jArr[i4 + 1] << (64 - i5)) & ((-i5) >> 63)) | (jArr[i4] >>> i5);
            long j2 = j & ((~j) << 7) & (-9187201950435737472L);
            if (j2 != 0) {
                return (i2 + (Long.numberOfTrailingZeros(j2) >> 3)) & i;
            }
            i3 += 8;
            i2 = (i2 + i3) & i;
        }
    }

    public final int trim() {
        int i = this._capacity;
        int iNormalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (iNormalizeCapacity >= i) {
            return 0;
        }
        resizeStorage(iNormalizeCapacity);
        return i - this._capacity;
    }

    private final void adjustStorage() {
        if (this._capacity > 8 && Long.compareUnsigned(ULong.m6111constructorimpl(ULong.m6111constructorimpl(this._size) * 32), ULong.m6111constructorimpl(ULong.m6111constructorimpl(this._capacity) * 25)) <= 0) {
            dropDeletes();
        } else {
            resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
        }
    }

    private final void dropDeletes() {
        long[] jArr;
        int i;
        int i2;
        long[] jArr2 = this.metadata;
        int i3 = this._capacity;
        long[] jArr3 = this.keys;
        Object[] objArr = this.values;
        ScatterMapKt.convertMetadataForCleanup(jArr2, i3);
        char c = 0;
        int i4 = 0;
        int iFindEmptySlot = -1;
        while (i4 != i3) {
            int i5 = i4 >> 3;
            int i6 = (i4 & 7) << 3;
            long j = (jArr2[i5] >> i6) & 255;
            if (j == 128) {
                iFindEmptySlot = i4;
                i4++;
            } else {
                if (j == 254) {
                    int iHashCode = Long.hashCode(jArr3[i4]) * ScatterMapKt.MurmurHashC1;
                    int i7 = (iHashCode ^ (iHashCode << 16)) >>> 7;
                    int iFindFirstAvailableSlot = findFirstAvailableSlot(i7);
                    int i8 = i7 & i3;
                    if (((iFindFirstAvailableSlot - i8) & i3) / 8 == ((i4 - i8) & i3) / 8) {
                        jArr2[i5] = ((r10 & 127) << i6) | ((~(255 << i6)) & jArr2[i5]);
                        jArr2[ArraysKt.getLastIndex(jArr2)] = (jArr2[c] & 72057594037927935L) | Long.MIN_VALUE;
                    } else {
                        int i9 = iFindFirstAvailableSlot >> 3;
                        long j2 = jArr2[i9];
                        int i10 = (iFindFirstAvailableSlot & 7) << 3;
                        if (((j2 >> i10) & 255) == 128) {
                            int i11 = i4;
                            jArr = jArr3;
                            jArr2[i9] = (j2 & (~(255 << i10))) | ((r10 & 127) << i10);
                            jArr2[i5] = (jArr2[i5] & (~(255 << i6))) | (128 << i6);
                            jArr[iFindFirstAvailableSlot] = jArr[i11];
                            jArr[i11] = 0;
                            objArr[iFindFirstAvailableSlot] = objArr[i11];
                            objArr[i11] = null;
                            i2 = i11;
                            iFindEmptySlot = i2;
                            i = i3;
                        } else {
                            int i12 = i3;
                            jArr = jArr3;
                            int i13 = i4;
                            jArr2[i9] = ((r10 & 127) << i10) | (j2 & (~(255 << i10)));
                            if (iFindEmptySlot == -1) {
                                i = i12;
                                iFindEmptySlot = ScatterMapKt.findEmptySlot(jArr2, i13 + 1, i);
                            } else {
                                i = i12;
                            }
                            jArr[iFindEmptySlot] = jArr[iFindFirstAvailableSlot];
                            jArr[iFindFirstAvailableSlot] = jArr[i13];
                            jArr[i13] = jArr[iFindEmptySlot];
                            objArr[iFindEmptySlot] = objArr[iFindFirstAvailableSlot];
                            objArr[iFindFirstAvailableSlot] = objArr[i13];
                            objArr[i13] = objArr[iFindEmptySlot];
                            i2 = i13 - 1;
                        }
                        c = 0;
                        jArr2[ArraysKt.getLastIndex(jArr2)] = (jArr2[0] & 72057594037927935L) | Long.MIN_VALUE;
                        i4 = i2 + 1;
                        i3 = i;
                        jArr3 = jArr;
                    }
                }
                i4++;
            }
        }
        initializeGrowth();
    }

    private final void resizeStorage(int newCapacity) {
        long[] jArr;
        MutableLongObjectMap<V> mutableLongObjectMap = this;
        long[] jArr2 = mutableLongObjectMap.metadata;
        long[] jArr3 = mutableLongObjectMap.keys;
        Object[] objArr = mutableLongObjectMap.values;
        int i = mutableLongObjectMap._capacity;
        initializeStorage(newCapacity);
        long[] jArr4 = mutableLongObjectMap.metadata;
        long[] jArr5 = mutableLongObjectMap.keys;
        Object[] objArr2 = mutableLongObjectMap.values;
        int i2 = mutableLongObjectMap._capacity;
        int i3 = 0;
        while (i3 < i) {
            if (((jArr2[i3 >> 3] >> ((i3 & 7) << 3)) & 255) < 128) {
                long j = jArr3[i3];
                int iHashCode = Long.hashCode(j) * ScatterMapKt.MurmurHashC1;
                int i4 = iHashCode ^ (iHashCode << 16);
                int iFindFirstAvailableSlot = mutableLongObjectMap.findFirstAvailableSlot(i4 >>> 7);
                long j2 = i4 & 127;
                int i5 = iFindFirstAvailableSlot >> 3;
                int i6 = (iFindFirstAvailableSlot & 7) << 3;
                jArr = jArr2;
                long j3 = (jArr4[i5] & (~(255 << i6))) | (j2 << i6);
                jArr4[i5] = j3;
                jArr4[(((iFindFirstAvailableSlot - 7) & i2) + (i2 & 7)) >> 3] = j3;
                jArr5[iFindFirstAvailableSlot] = j;
                objArr2[iFindFirstAvailableSlot] = objArr[i3];
            } else {
                jArr = jArr2;
            }
            i3++;
            mutableLongObjectMap = this;
            jArr2 = jArr;
        }
    }

    private final void writeMetadata(int index, long value) {
        long[] jArr = this.metadata;
        int i = index >> 3;
        int i2 = (index & 7) << 3;
        jArr[i] = (jArr[i] & (~(255 << i2))) | (value << i2);
        int i3 = this._capacity;
        int i4 = ((index - 7) & i3) + (i3 & 7);
        int i5 = i4 >> 3;
        int i6 = (i4 & 7) << 3;
        jArr[i5] = (value << i6) | (jArr[i5] & (~(255 << i6)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(LongObjectMap<V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        long[] jArr = from.keys;
        Object[] objArr = from.values;
        long[] jArr2 = from.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr2[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        set(jArr[i4], objArr[i4]);
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void minusAssign(LongSet keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        long[] jArr = keys.elements;
        long[] jArr2 = keys.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr2[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        remove(jArr[(i << 3) + i3]);
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void minusAssign(LongList keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        long[] jArr = keys.content;
        int i = keys._size;
        for (int i2 = 0; i2 < i; i2++) {
            remove(jArr[i2]);
        }
    }

    private final int findAbsoluteInsertIndex(long key) {
        int iHashCode = Long.hashCode(key) * ScatterMapKt.MurmurHashC1;
        int i = iHashCode ^ (iHashCode << 16);
        int i2 = i >>> 7;
        int i3 = i & 127;
        int i4 = this._capacity;
        int i5 = i2 & i4;
        int i6 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i7 = i5 >> 3;
            int i8 = (i5 & 7) << 3;
            long j = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j2 = i3;
            int i9 = i6;
            long j3 = j ^ (j2 * ScatterMapKt.BitmaskLsb);
            for (long j4 = (~j3) & (j3 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j4 != 0; j4 &= j4 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j4) >> 3) + i5) & i4;
                if (this.keys[iNumberOfTrailingZeros] == key) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j) << 6) & j & (-9187201950435737472L)) != 0) {
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i2);
                if (this.growthLimit == 0 && ((this.metadata[iFindFirstAvailableSlot >> 3] >> ((iFindFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    iFindFirstAvailableSlot = findFirstAvailableSlot(i2);
                }
                this._size++;
                int i10 = iFindFirstAvailableSlot >> 3;
                int i11 = (iFindFirstAvailableSlot & 7) << 3;
                this.growthLimit -= ((this.metadata[i10] >> i11) & 255) == 128 ? 1 : 0;
                long[] jArr2 = this.metadata;
                int i12 = this._capacity;
                long j5 = ((~(255 << i11)) & jArr2[i10]) | (j2 << i11);
                jArr2[i10] = j5;
                jArr2[(((iFindFirstAvailableSlot - 7) & i12) + (i12 & 7)) >> 3] = j5;
                return iFindFirstAvailableSlot;
            }
            i6 = i9 + 8;
            i5 = (i5 + i6) & i4;
        }
    }
}
