package androidx.collection;

import com.caverock.androidsvg.SVGParser;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.sentry.rrweb.RRWebVideoEvent;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.language.bm.Languages;

/* compiled from: LongIntMap.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J&\u0010\u0015\u001a\u00020\u00162\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160\u0018H\u0086\bø\u0001\u0000J\u0006\u0010\u001a\u001a\u00020\u0016J&\u0010\u001a\u001a\u00020\u00162\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160\u0018H\u0086\bø\u0001\u0000J\u0011\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0019H\u0086\u0002J\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0004J\u0006\u0010 \u001a\u00020\u0004J&\u0010 \u001a\u00020\u00042\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160\u0018H\u0086\bø\u0001\u0000J\u0013\u0010!\u001a\u00020\u00162\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0019H\u0001JD\u0010$\u001a\u00020%26\u0010&\u001a2\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020%0\u0018H\u0086\bø\u0001\u0000J/\u0010)\u001a\u00020%2!\u0010&\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020%0*H\u0081\bø\u0001\u0000J/\u0010,\u001a\u00020%2!\u0010&\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020%0*H\u0086\bø\u0001\u0000J/\u0010-\u001a\u00020%2!\u0010&\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020%0*H\u0086\bø\u0001\u0000J\u0011\u0010.\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0019H\u0086\u0002J\u0016\u0010/\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u0004J\"\u00101\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00192\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000402H\u0086\bø\u0001\u0000J\b\u00103\u001a\u00020\u0004H\u0016J\u0006\u00104\u001a\u00020\u0016J\u0006\u00105\u001a\u00020\u0016J:\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u0002092\b\b\u0002\u0010;\u001a\u0002092\b\b\u0002\u0010<\u001a\u00020\u00042\b\b\u0002\u0010=\u001a\u000209H\u0007Jx\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u0002092\b\b\u0002\u0010;\u001a\u0002092\b\b\u0002\u0010<\u001a\u00020\u00042\b\b\u0002\u0010=\u001a\u00020928\b\u0004\u0010>\u001a2\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u0002090\u0018H\u0087\bø\u0001\u0000J\u0006\u0010?\u001a\u00020\u0016J\b\u0010@\u001a\u000207H\u0016R\u0018\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0018\u0010\u0006\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u00020\f8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0002R\u0018\u0010\u000e\u001a\u00020\f8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0002R\u0011\u0010\u0010\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\nR\u0018\u0010\u0012\u001a\u00020\u00138\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0002\u0082\u0001\u0001A\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006B"}, d2 = {"Landroidx/collection/LongIntMap;", "", "()V", "_capacity", "", "get_capacity$collection$annotations", "_size", "get_size$collection$annotations", "capacity", "getCapacity", "()I", "keys", "", "getKeys$annotations", "metadata", "getMetadata$annotations", RRWebVideoEvent.JsonKeys.SIZE, "getSize", "values", "", "getValues$annotations", SVGParser.XML_STYLESHEET_ATTR_MEDIA_ALL, "", "predicate", "Lkotlin/Function2;", "", Languages.ANY, "contains", SDKConstants.PARAM_KEY, "containsKey", "containsValue", "value", "count", "equals", "other", "findKeyIndex", "forEach", "", "block", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function1;", FirebaseAnalytics.Param.INDEX, "forEachKey", "forEachValue", "get", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", ViewProps.TRANSFORM, "none", InAppPurchaseConstants.METHOD_TO_STRING, "Landroidx/collection/MutableLongIntMap;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LongIntMap {
    public int _capacity;
    public int _size;
    public long[] keys;
    public long[] metadata;
    public int[] values;

    public /* synthetic */ LongIntMap(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ void getKeys$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }

    public static /* synthetic */ void get_capacity$collection$annotations() {
    }

    public static /* synthetic */ void get_size$collection$annotations() {
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final String joinToString(CharSequence separator) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, 30, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, 28, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, 24, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i, null, 16, null);
    }

    private LongIntMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = LongSetKt.getEmptyLongArray();
        this.values = IntSetKt.getEmptyIntArray();
    }

    /* renamed from: getCapacity, reason: from getter */
    public final int get_capacity() {
        return this._capacity;
    }

    /* renamed from: getSize, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public final boolean any() {
        return this._size != 0;
    }

    public final boolean none() {
        return this._size == 0;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final int get(long key) {
        int iFindKeyIndex = findKeyIndex(key);
        if (iFindKeyIndex < 0) {
            throw new NoSuchElementException("Cannot find value for key " + key);
        }
        return this.values[iFindKeyIndex];
    }

    public final int getOrDefault(long key, int defaultValue) {
        int iFindKeyIndex = findKeyIndex(key);
        return iFindKeyIndex >= 0 ? this.values[iFindKeyIndex] : defaultValue;
    }

    public final int getOrElse(long key, Function0<Integer> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int iFindKeyIndex = findKeyIndex(key);
        if (iFindKeyIndex < 0) {
            return defaultValue.invoke().intValue();
        }
        return this.values[iFindKeyIndex];
    }

    public final void forEachIndexed(Function1<? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
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
                        block.invoke(Integer.valueOf((i << 3) + i3));
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

    public final void forEach(Function2<? super Long, ? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        long[] jArr = this.keys;
        int[] iArr = this.values;
        long[] jArr2 = this.metadata;
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
                        block.invoke(Long.valueOf(jArr[i4]), Integer.valueOf(iArr[i4]));
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

    public final void forEachKey(Function1<? super Long, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        long[] jArr = this.keys;
        long[] jArr2 = this.metadata;
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
                        block.invoke(Long.valueOf(jArr[(i << 3) + i3]));
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

    public final void forEachValue(Function1<? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int[] iArr = this.values;
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
                        block.invoke(Integer.valueOf(iArr[(i << 3) + i3]));
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

    public final int count() {
        return get_size();
    }

    public final boolean contains(long key) {
        return findKeyIndex(key) >= 0;
    }

    public final boolean containsKey(long key) {
        return findKeyIndex(key) >= 0;
    }

    public static /* synthetic */ String joinToString$default(LongIntMap longIntMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i2 & 1) != 0) {
        }
        if ((i2 & 2) != 0) {
        }
        CharSequence charSequence5 = charSequence2;
        if ((i2 & 4) != 0) {
        }
        CharSequence charSequence6 = charSequence3;
        if ((i2 & 8) != 0) {
            i = -1;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
        }
        return longIntMap.joinToString(charSequence, charSequence5, charSequence6, i3, charSequence4);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated) {
        long[] jArr;
        long[] jArr2;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        long[] jArr3 = this.keys;
        int[] iArr = this.values;
        long[] jArr4 = this.metadata;
        int length = jArr4.length - 2;
        if (length >= 0) {
            int i3 = 0;
            int i4 = 0;
            loop0: while (true) {
                long j = jArr4[i3];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i3 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            int i8 = (i3 << 3) + i7;
                            jArr2 = jArr4;
                            i = length;
                            long j2 = jArr3[i8];
                            int i9 = iArr[i8];
                            if (i4 == limit) {
                                sb.append(truncated);
                                break loop0;
                            }
                            if (i4 != 0) {
                                sb.append(separator);
                            }
                            sb.append(j2);
                            sb.append('=');
                            sb.append(i9);
                            i4++;
                            i2 = 8;
                        } else {
                            jArr2 = jArr4;
                            i = length;
                            i2 = i5;
                        }
                        j >>= i2;
                        i7++;
                        i5 = i2;
                        jArr4 = jArr2;
                        length = i;
                    }
                    jArr = jArr4;
                    int i10 = length;
                    if (i6 != i5) {
                        break;
                    }
                    length = i10;
                } else {
                    jArr = jArr4;
                }
                if (i3 == length) {
                    break;
                }
                i3++;
                jArr4 = jArr;
            }
            sb.append(postfix);
        } else {
            sb.append(postfix);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String joinToString$default(LongIntMap longIntMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function2 transform, int i2, Object obj) {
        long[] jArr;
        long[] jArr2;
        int i3;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        CharSequence separator = (i2 & 1) != 0 ? ", " : charSequence;
        CharSequence prefix = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence postfix = (i2 & 4) != 0 ? "" : charSequence3;
        int i4 = (i2 & 8) != 0 ? -1 : i;
        CharSequence truncated = (i2 & 16) != 0 ? "..." : charSequence4;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        Intrinsics.checkNotNullParameter(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        long[] jArr3 = longIntMap.keys;
        int[] iArr = longIntMap.values;
        long[] jArr4 = longIntMap.metadata;
        int length = jArr4.length - 2;
        if (length >= 0) {
            int i5 = 0;
            int i6 = 0;
            loop0: while (true) {
                long j = jArr4[i5];
                int i7 = i5;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i8 = 8;
                    int i9 = 8 - ((~(i7 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j & 255) < 128) {
                            int i11 = (i7 << 3) + i10;
                            long j2 = jArr3[i11];
                            int i12 = iArr[i11];
                            if (i6 == i4) {
                                sb.append(truncated);
                                break loop0;
                            }
                            if (i6 != 0) {
                                sb.append(separator);
                            }
                            Long lValueOf = Long.valueOf(j2);
                            jArr2 = jArr4;
                            sb.append((CharSequence) transform.invoke(lValueOf, Integer.valueOf(i12)));
                            i6++;
                            i3 = 8;
                        } else {
                            jArr2 = jArr4;
                            i3 = i8;
                        }
                        j >>= i3;
                        i10++;
                        i8 = i3;
                        jArr4 = jArr2;
                    }
                    jArr = jArr4;
                    if (i9 != i8) {
                        break;
                    }
                } else {
                    jArr = jArr4;
                }
                if (i7 == length) {
                    break;
                }
                i5 = i7 + 1;
                jArr4 = jArr;
            }
            sb.append(postfix);
        } else {
            sb.append(postfix);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x009a A[PHI: r12
  0x009a: PHI (r12v2 int) = (r12v1 int), (r12v3 int) binds: [B:6:0x004c, B:19:0x0098] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String joinToString(java.lang.CharSequence r22, java.lang.CharSequence r23, java.lang.CharSequence r24, int r25, java.lang.CharSequence r26, kotlin.jvm.functions.Function2<? super java.lang.Long, ? super java.lang.Integer, ? extends java.lang.CharSequence> r27) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r26
            r5 = r27
            java.lang.String r6 = "separator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r6)
            java.lang.String r6 = "prefix"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r6)
            java.lang.String r6 = "postfix"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r6)
            java.lang.String r6 = "truncated"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r6)
            java.lang.String r6 = "transform"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            long[] r2 = r0.keys
            int[] r7 = r0.values
            long[] r8 = r0.metadata
            int r9 = r8.length
            int r9 = r9 + (-2)
            if (r9 < 0) goto La4
            r11 = 0
            r12 = 0
        L3a:
            r13 = r8[r11]
            r15 = r11
            long r10 = ~r13
            r16 = 7
            long r10 = r10 << r16
            long r10 = r10 & r13
            r16 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r16
            int r10 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r10 == 0) goto L9a
            int r11 = r15 - r9
            int r10 = ~r11
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r11 = 0
        L58:
            if (r11 >= r10) goto L96
            r17 = 255(0xff, double:1.26E-321)
            long r17 = r13 & r17
            r19 = 128(0x80, double:6.32E-322)
            int r17 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r17 >= 0) goto L8c
            int r17 = r15 << 3
            int r17 = r17 + r11
            r18 = r2[r17]
            r17 = r7[r17]
            r0 = r25
            if (r12 != r0) goto L74
            r6.append(r4)
            goto La7
        L74:
            if (r12 == 0) goto L79
            r6.append(r1)
        L79:
            java.lang.Long r0 = java.lang.Long.valueOf(r18)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            java.lang.Object r0 = r5.invoke(r0, r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6.append(r0)
            int r12 = r12 + 1
        L8c:
            r0 = 8
            long r13 = r13 >> r0
            int r11 = r11 + 1
            r0 = r21
            r1 = r22
            goto L58
        L96:
            r0 = 8
            if (r10 != r0) goto La4
        L9a:
            r10 = r15
            if (r10 == r9) goto La4
            int r11 = r10 + 1
            r0 = r21
            r1 = r22
            goto L3a
        La4:
            r6.append(r3)
        La7:
            java.lang.String r0 = r6.toString()
            java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongIntMap.joinToString(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, int, java.lang.CharSequence, kotlin.jvm.functions.Function2):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = 1
            if (r1 != r0) goto L8
            return r2
        L8:
            boolean r3 = r1 instanceof androidx.collection.LongIntMap
            r4 = 0
            if (r3 != 0) goto Le
            return r4
        Le:
            androidx.collection.LongIntMap r1 = (androidx.collection.LongIntMap) r1
            int r3 = r1.get_size()
            int r5 = r18.get_size()
            if (r3 == r5) goto L1b
            return r4
        L1b:
            long[] r3 = r0.keys
            int[] r5 = r0.values
            long[] r6 = r0.metadata
            int r7 = r6.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L6a
            r8 = r4
        L27:
            r9 = r6[r8]
            long r11 = ~r9
            r13 = 7
            long r11 = r11 << r13
            long r11 = r11 & r9
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 == 0) goto L65
            int r11 = r8 - r7
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = r4
        L41:
            if (r13 >= r11) goto L63
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 128(0x80, double:6.32E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L5e
            int r14 = r8 << 3
            int r14 = r14 + r13
            r15 = r13
            r12 = r3[r14]
            r14 = r5[r14]
            int r12 = r1.get(r12)
            if (r14 == r12) goto L5b
            return r4
        L5b:
            r12 = 8
            goto L5f
        L5e:
            r15 = r13
        L5f:
            long r9 = r9 >> r12
            int r13 = r15 + 1
            goto L41
        L63:
            if (r11 != r12) goto L6a
        L65:
            if (r8 == r7) goto L6a
            int r8 = r8 + 1
            goto L27
        L6a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongIntMap.equals(java.lang.Object):boolean");
    }

    public String toString() {
        int i;
        int i2;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        long[] jArr = this.keys;
        int[] iArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                long j = jArr2[i3];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8 - ((~(i3 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((255 & j) < 128) {
                            int i7 = (i3 << 3) + i6;
                            i2 = i3;
                            long j2 = jArr[i7];
                            int i8 = iArr[i7];
                            sb.append(j2);
                            sb.append("=");
                            sb.append(i8);
                            i4++;
                            if (i4 < this._size) {
                                sb.append(", ");
                            }
                        } else {
                            i2 = i3;
                        }
                        j >>= 8;
                        i6++;
                        i3 = i2;
                    }
                    int i9 = i3;
                    if (i5 != 8) {
                        break;
                    }
                    i = i9;
                } else {
                    i = i3;
                }
                if (i == length) {
                    break;
                }
                i3 = i + 1;
            }
        }
        String string = sb.append('}').toString();
        Intrinsics.checkNotNullExpressionValue(string, "s.append('}').toString()");
        return string;
    }

    public final boolean all(Function2<? super Long, ? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        long[] jArr = this.keys;
        int[] iArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return true;
        }
        int i = 0;
        while (true) {
            long j = jArr2[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        if (!predicate.invoke(Long.valueOf(jArr[i4]), Integer.valueOf(iArr[i4])).booleanValue()) {
                            return false;
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return true;
                }
            }
            if (i == length) {
                return true;
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean any(kotlin.jvm.functions.Function2<? super java.lang.Long, ? super java.lang.Integer, java.lang.Boolean> r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.lang.String r2 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            long[] r2 = r0.keys
            int[] r3 = r0.values
            long[] r4 = r0.metadata
            int r5 = r4.length
            int r5 = r5 + (-2)
            r6 = 0
            if (r5 < 0) goto L63
            r7 = r6
        L16:
            r8 = r4[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L5e
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r6
        L30:
            if (r12 >= r10) goto L5c
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.32E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L58
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r2[r13]
            r13 = r3[r13]
            java.lang.Long r14 = java.lang.Long.valueOf(r14)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            java.lang.Object r13 = r1.invoke(r14, r13)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L58
            r1 = 1
            return r1
        L58:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L30
        L5c:
            if (r10 != r11) goto L63
        L5e:
            if (r7 == r5) goto L63
            int r7 = r7 + 1
            goto L16
        L63:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongIntMap.any(kotlin.jvm.functions.Function2):boolean");
    }

    public final int count(Function2<? super Long, ? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        long[] jArr = this.keys;
        int[] iArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        int i = 0;
        if (length >= 0) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                long j = jArr2[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((255 & j) < 128) {
                            int i6 = (i2 << 3) + i5;
                            if (predicate.invoke(Long.valueOf(jArr[i6]), Integer.valueOf(iArr[i6])).booleanValue()) {
                                i3++;
                            }
                        }
                        j >>= 8;
                    }
                    if (i4 != 8) {
                        return i3;
                    }
                }
                if (i2 == length) {
                    i = i3;
                    break;
                }
                i2++;
            }
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean containsValue(int r15) {
        /*
            r14 = this;
            int[] r0 = r14.values
            long[] r1 = r14.metadata
            int r2 = r1.length
            int r2 = r2 + (-2)
            r3 = 0
            if (r2 < 0) goto L44
            r4 = r3
        Lb:
            r5 = r1[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L3f
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L25:
            if (r9 >= r7) goto L3d
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.32E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L39
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r0[r10]
            if (r15 != r10) goto L39
            r15 = 1
            return r15
        L39:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L25
        L3d:
            if (r7 != r8) goto L44
        L3f:
            if (r4 == r2) goto L44
            int r4 = r4 + 1
            goto Lb
        L44:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongIntMap.containsValue(int):boolean");
    }

    public int hashCode() {
        long[] jArr = this.keys;
        int[] iArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        int i = 0;
        if (length >= 0) {
            int i2 = 0;
            int iHashCode = 0;
            while (true) {
                long j = jArr2[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i2 << 3) + i4;
                            long j2 = jArr[i5];
                            iHashCode += Integer.hashCode(iArr[i5]) ^ Long.hashCode(j2);
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        return iHashCode;
                    }
                }
                if (i2 == length) {
                    i = iHashCode;
                    break;
                }
                i2++;
            }
        }
        return i;
    }

    public final int findKeyIndex(long key) {
        int iHashCode = Long.hashCode(key) * ScatterMapKt.MurmurHashC1;
        int i = iHashCode ^ (iHashCode << 16);
        int i2 = i & 127;
        int i3 = this._capacity;
        int i4 = (i >>> 7) & i3;
        int i5 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i6 = i4 >> 3;
            int i7 = (i4 & 7) << 3;
            long j = ((jArr[i6 + 1] << (64 - i7)) & ((-i7) >> 63)) | (jArr[i6] >>> i7);
            long j2 = (i2 * ScatterMapKt.BitmaskLsb) ^ j;
            for (long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j3 != 0; j3 &= j3 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i4) & i3;
                if (this.keys[iNumberOfTrailingZeros] == key) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((j & ((~j) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i5 += 8;
            i4 = (i4 + i5) & i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0097 A[PHI: r12
  0x0097: PHI (r12v2 int) = (r12v1 int), (r12v3 int) binds: [B:6:0x0049, B:19:0x0095] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String joinToString(java.lang.CharSequence r22, java.lang.CharSequence r23, java.lang.CharSequence r24, int r25, kotlin.jvm.functions.Function2<? super java.lang.Long, ? super java.lang.Integer, ? extends java.lang.CharSequence> r26) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r26
            java.lang.String r5 = "separator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r5)
            java.lang.String r5 = "prefix"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r5)
            java.lang.String r5 = "postfix"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r5)
            java.lang.String r5 = "transform"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            java.lang.String r5 = "..."
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            long[] r2 = r0.keys
            int[] r7 = r0.values
            long[] r8 = r0.metadata
            int r9 = r8.length
            int r9 = r9 + (-2)
            if (r9 < 0) goto La1
            r11 = 0
            r12 = 0
        L37:
            r13 = r8[r11]
            r15 = r11
            long r10 = ~r13
            r16 = 7
            long r10 = r10 << r16
            long r10 = r10 & r13
            r16 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r16
            int r10 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r10 == 0) goto L97
            int r11 = r15 - r9
            int r10 = ~r11
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r11 = 0
        L55:
            if (r11 >= r10) goto L93
            r17 = 255(0xff, double:1.26E-321)
            long r17 = r13 & r17
            r19 = 128(0x80, double:6.32E-322)
            int r17 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r17 >= 0) goto L89
            int r17 = r15 << 3
            int r17 = r17 + r11
            r18 = r2[r17]
            r17 = r7[r17]
            r0 = r25
            if (r12 != r0) goto L71
            r6.append(r5)
            goto La4
        L71:
            if (r12 == 0) goto L76
            r6.append(r1)
        L76:
            java.lang.Long r0 = java.lang.Long.valueOf(r18)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            java.lang.Object r0 = r4.invoke(r0, r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6.append(r0)
            int r12 = r12 + 1
        L89:
            r0 = 8
            long r13 = r13 >> r0
            int r11 = r11 + 1
            r0 = r21
            r1 = r22
            goto L55
        L93:
            r0 = 8
            if (r10 != r0) goto La1
        L97:
            r10 = r15
            if (r10 == r9) goto La1
            int r11 = r10 + 1
            r0 = r21
            r1 = r22
            goto L37
        La1:
            r6.append(r3)
        La4:
            java.lang.String r0 = r6.toString()
            java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongIntMap.joinToString(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, int, kotlin.jvm.functions.Function2):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0096 A[PHI: r12
  0x0096: PHI (r12v2 int) = (r12v1 int), (r12v3 int) binds: [B:6:0x0049, B:19:0x0094] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String joinToString(java.lang.CharSequence r22, java.lang.CharSequence r23, java.lang.CharSequence r24, kotlin.jvm.functions.Function2<? super java.lang.Long, ? super java.lang.Integer, ? extends java.lang.CharSequence> r25) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            java.lang.String r5 = "separator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r5)
            java.lang.String r5 = "prefix"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r5)
            java.lang.String r5 = "postfix"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r5)
            java.lang.String r5 = "transform"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            java.lang.String r5 = "..."
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            long[] r2 = r0.keys
            int[] r7 = r0.values
            long[] r8 = r0.metadata
            int r9 = r8.length
            int r9 = r9 + (-2)
            if (r9 < 0) goto La0
            r11 = 0
            r12 = 0
        L37:
            r13 = r8[r11]
            r15 = r11
            long r10 = ~r13
            r16 = 7
            long r10 = r10 << r16
            long r10 = r10 & r13
            r16 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r16
            int r10 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r10 == 0) goto L96
            int r11 = r15 - r9
            int r10 = ~r11
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r11 = 0
        L55:
            if (r11 >= r10) goto L92
            r17 = 255(0xff, double:1.26E-321)
            long r17 = r13 & r17
            r19 = 128(0x80, double:6.32E-322)
            int r17 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r17 >= 0) goto L88
            int r17 = r15 << 3
            int r17 = r17 + r11
            r18 = r2[r17]
            r17 = r7[r17]
            r0 = -1
            if (r12 != r0) goto L70
            r6.append(r5)
            goto La3
        L70:
            if (r12 == 0) goto L75
            r6.append(r1)
        L75:
            java.lang.Long r0 = java.lang.Long.valueOf(r18)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            java.lang.Object r0 = r4.invoke(r0, r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6.append(r0)
            int r12 = r12 + 1
        L88:
            r0 = 8
            long r13 = r13 >> r0
            int r11 = r11 + 1
            r0 = r21
            r1 = r22
            goto L55
        L92:
            r0 = 8
            if (r10 != r0) goto La0
        L96:
            r10 = r15
            if (r10 == r9) goto La0
            int r11 = r10 + 1
            r0 = r21
            r1 = r22
            goto L37
        La0:
            r6.append(r3)
        La3:
            java.lang.String r0 = r6.toString()
            java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongIntMap.joinToString(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, kotlin.jvm.functions.Function2):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0093 A[PHI: r12
  0x0093: PHI (r12v2 int) = (r12v1 int), (r12v3 int) binds: [B:6:0x0046, B:19:0x0091] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String joinToString(java.lang.CharSequence r22, java.lang.CharSequence r23, kotlin.jvm.functions.Function2<? super java.lang.Long, ? super java.lang.Integer, ? extends java.lang.CharSequence> r24) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            java.lang.String r4 = "separator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "prefix"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            java.lang.String r4 = "transform"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            java.lang.String r4 = ""
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.String r5 = "..."
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            long[] r2 = r0.keys
            int[] r7 = r0.values
            long[] r8 = r0.metadata
            int r9 = r8.length
            int r9 = r9 + (-2)
            if (r9 < 0) goto L9d
            r11 = 0
            r12 = 0
        L34:
            r13 = r8[r11]
            r15 = r11
            long r10 = ~r13
            r16 = 7
            long r10 = r10 << r16
            long r10 = r10 & r13
            r16 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r16
            int r10 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r10 == 0) goto L93
            int r11 = r15 - r9
            int r10 = ~r11
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r11 = 0
        L52:
            if (r11 >= r10) goto L8f
            r17 = 255(0xff, double:1.26E-321)
            long r17 = r13 & r17
            r19 = 128(0x80, double:6.32E-322)
            int r17 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r17 >= 0) goto L85
            int r17 = r15 << 3
            int r17 = r17 + r11
            r18 = r2[r17]
            r17 = r7[r17]
            r0 = -1
            if (r12 != r0) goto L6d
            r6.append(r5)
            goto La0
        L6d:
            if (r12 == 0) goto L72
            r6.append(r1)
        L72:
            java.lang.Long r0 = java.lang.Long.valueOf(r18)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            java.lang.Object r0 = r3.invoke(r0, r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6.append(r0)
            int r12 = r12 + 1
        L85:
            r0 = 8
            long r13 = r13 >> r0
            int r11 = r11 + 1
            r0 = r21
            r1 = r22
            goto L52
        L8f:
            r0 = 8
            if (r10 != r0) goto L9d
        L93:
            r10 = r15
            if (r10 == r9) goto L9d
            int r11 = r10 + 1
            r0 = r21
            r1 = r22
            goto L34
        L9d:
            r6.append(r4)
        La0:
            java.lang.String r0 = r6.toString()
            java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongIntMap.joinToString(java.lang.CharSequence, java.lang.CharSequence, kotlin.jvm.functions.Function2):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0090 A[PHI: r12
  0x0090: PHI (r12v2 int) = (r12v1 int), (r12v3 int) binds: [B:6:0x0043, B:20:0x008e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String joinToString(java.lang.CharSequence r23, kotlin.jvm.functions.Function2<? super java.lang.Long, ? super java.lang.Integer, ? extends java.lang.CharSequence> r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            java.lang.String r3 = "separator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "transform"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            java.lang.String r3 = ""
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.String r5 = "..."
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            long[] r4 = r0.keys
            int[] r7 = r0.values
            long[] r8 = r0.metadata
            int r9 = r8.length
            int r9 = r9 + (-2)
            if (r9 < 0) goto L99
            r11 = 0
            r12 = 0
        L30:
            r13 = r8[r11]
            r16 = r11
            long r10 = ~r13
            r17 = 7
            long r10 = r10 << r17
            long r10 = r10 & r13
            r17 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r17
            int r10 = (r10 > r17 ? 1 : (r10 == r17 ? 0 : -1))
            if (r10 == 0) goto L90
            int r11 = r16 - r9
            int r10 = ~r11
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r15 = 0
        L4f:
            if (r15 >= r10) goto L8d
            r18 = 255(0xff, double:1.26E-321)
            long r18 = r13 & r18
            r20 = 128(0x80, double:6.32E-322)
            int r18 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r18 >= 0) goto L85
            int r18 = r16 << 3
            int r18 = r18 + r15
            r19 = r4[r18]
            r18 = r7[r18]
            r11 = -1
            if (r12 != r11) goto L6a
            r6.append(r5)
            goto L9c
        L6a:
            if (r12 == 0) goto L6f
            r6.append(r1)
        L6f:
            java.lang.Long r11 = java.lang.Long.valueOf(r19)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r18)
            java.lang.Object r0 = r2.invoke(r11, r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6.append(r0)
            int r12 = r12 + 1
            r0 = 8
            goto L86
        L85:
            r0 = r11
        L86:
            long r13 = r13 >> r0
            int r15 = r15 + 1
            r11 = r0
            r0 = r22
            goto L4f
        L8d:
            r0 = r11
            if (r10 != r0) goto L99
        L90:
            r10 = r16
            if (r10 == r9) goto L99
            int r11 = r10 + 1
            r0 = r22
            goto L30
        L99:
            r6.append(r3)
        L9c:
            java.lang.String r0 = r6.toString()
            java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongIntMap.joinToString(java.lang.CharSequence, kotlin.jvm.functions.Function2):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008d A[PHI: r12
  0x008d: PHI (r12v2 int) = (r12v1 int), (r12v3 int) binds: [B:6:0x0040, B:20:0x008b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String joinToString(kotlin.jvm.functions.Function2<? super java.lang.Long, ? super java.lang.Integer, ? extends java.lang.CharSequence> r23) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            java.lang.String r2 = "transform"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = ", "
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.String r3 = ""
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.String r5 = "..."
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            long[] r4 = r0.keys
            int[] r7 = r0.values
            long[] r8 = r0.metadata
            int r9 = r8.length
            int r9 = r9 + (-2)
            if (r9 < 0) goto L96
            r11 = 0
            r12 = 0
        L2d:
            r13 = r8[r11]
            r16 = r11
            long r10 = ~r13
            r17 = 7
            long r10 = r10 << r17
            long r10 = r10 & r13
            r17 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r17
            int r10 = (r10 > r17 ? 1 : (r10 == r17 ? 0 : -1))
            if (r10 == 0) goto L8d
            int r11 = r16 - r9
            int r10 = ~r11
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r15 = 0
        L4c:
            if (r15 >= r10) goto L8a
            r18 = 255(0xff, double:1.26E-321)
            long r18 = r13 & r18
            r20 = 128(0x80, double:6.32E-322)
            int r18 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r18 >= 0) goto L82
            int r18 = r16 << 3
            int r18 = r18 + r15
            r19 = r4[r18]
            r18 = r7[r18]
            r11 = -1
            if (r12 != r11) goto L67
            r6.append(r5)
            goto L99
        L67:
            if (r12 == 0) goto L6c
            r6.append(r2)
        L6c:
            java.lang.Long r11 = java.lang.Long.valueOf(r19)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r18)
            java.lang.Object r0 = r1.invoke(r11, r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6.append(r0)
            int r12 = r12 + 1
            r0 = 8
            goto L83
        L82:
            r0 = r11
        L83:
            long r13 = r13 >> r0
            int r15 = r15 + 1
            r11 = r0
            r0 = r22
            goto L4c
        L8a:
            r0 = r11
            if (r10 != r0) goto L96
        L8d:
            r10 = r16
            if (r10 == r9) goto L96
            int r11 = r10 + 1
            r0 = r22
            goto L2d
        L96:
            r6.append(r3)
        L99:
            java.lang.String r0 = r6.toString()
            java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongIntMap.joinToString(kotlin.jvm.functions.Function2):java.lang.String");
    }
}
