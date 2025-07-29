package kotlin.collections;

import androidx.constraintlayout.widget.ConstraintLayout;
import io.sentry.protocol.MetricSummary;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: _UCollections.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\u0005\u001a\u0017\u0010\f\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0007¢\u0006\u0002\u0010\u0015\u001a\u0017\u0010\u0016\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\n0\u000eH\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {MetricSummary.JsonKeys.SUM, "Lkotlin/UInt;", "", "Lkotlin/UByte;", "sumOfUByte", "(Ljava/lang/Iterable;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Ljava/lang/Iterable;)J", "Lkotlin/UShort;", "sumOfUShort", "toUByteArray", "Lkotlin/UByteArray;", "", "(Ljava/util/Collection;)[B", "toUIntArray", "Lkotlin/UIntArray;", "(Ljava/util/Collection;)[I", "toULongArray", "Lkotlin/ULongArray;", "(Ljava/util/Collection;)[J", "toUShortArray", "Lkotlin/UShortArray;", "(Ljava/util/Collection;)[S", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX, xs = "kotlin/collections/UCollectionsKt")
/* loaded from: classes5.dex */
class UCollectionsKt___UCollectionsKt {
    public static final byte[] toUByteArray(Collection<UByte> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        byte[] bArrM6007constructorimpl = UByteArray.m6007constructorimpl(collection.size());
        Iterator<UByte> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            UByteArray.m6018setVurrAj0(bArrM6007constructorimpl, i, it.next().getData());
            i++;
        }
        return bArrM6007constructorimpl;
    }

    public static final int[] toUIntArray(Collection<UInt> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        int[] iArrM6086constructorimpl = UIntArray.m6086constructorimpl(collection.size());
        Iterator<UInt> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            UIntArray.m6097setVXSXFK8(iArrM6086constructorimpl, i, it.next().getData());
            i++;
        }
        return iArrM6086constructorimpl;
    }

    public static final long[] toULongArray(Collection<ULong> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        long[] jArrM6165constructorimpl = ULongArray.m6165constructorimpl(collection.size());
        Iterator<ULong> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            ULongArray.m6176setk8EXiF4(jArrM6165constructorimpl, i, it.next().getData());
            i++;
        }
        return jArrM6165constructorimpl;
    }

    public static final short[] toUShortArray(Collection<UShort> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        short[] sArrM6270constructorimpl = UShortArray.m6270constructorimpl(collection.size());
        Iterator<UShort> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            UShortArray.m6281set01HTLdE(sArrM6270constructorimpl, i, it.next().getData());
            i++;
        }
        return sArrM6270constructorimpl;
    }

    public static final int sumOfUInt(Iterable<UInt> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<UInt> it = iterable.iterator();
        int iM6032constructorimpl = 0;
        while (it.hasNext()) {
            iM6032constructorimpl = UInt.m6032constructorimpl(iM6032constructorimpl + it.next().getData());
        }
        return iM6032constructorimpl;
    }

    public static final long sumOfULong(Iterable<ULong> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<ULong> it = iterable.iterator();
        long jM6111constructorimpl = 0;
        while (it.hasNext()) {
            jM6111constructorimpl = ULong.m6111constructorimpl(jM6111constructorimpl + it.next().getData());
        }
        return jM6111constructorimpl;
    }

    public static final int sumOfUByte(Iterable<UByte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<UByte> it = iterable.iterator();
        int iM6032constructorimpl = 0;
        while (it.hasNext()) {
            iM6032constructorimpl = UInt.m6032constructorimpl(iM6032constructorimpl + UInt.m6032constructorimpl(it.next().getData() & 255));
        }
        return iM6032constructorimpl;
    }

    public static final int sumOfUShort(Iterable<UShort> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<UShort> it = iterable.iterator();
        int iM6032constructorimpl = 0;
        while (it.hasNext()) {
            iM6032constructorimpl = UInt.m6032constructorimpl(iM6032constructorimpl + UInt.m6032constructorimpl(it.next().getData() & UShort.MAX_VALUE));
        }
        return iM6032constructorimpl;
    }
}
