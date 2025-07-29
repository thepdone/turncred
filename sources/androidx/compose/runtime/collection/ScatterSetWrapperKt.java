package androidx.compose.runtime.collection;

import androidx.collection.ScatterSet;
import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ScatterSetWrapper.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a'\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005H\u0080\b\u001a1\u0010\u0006\u001a\u00020\u0007\"\b\b\u0000\u0010\b*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00070\u0005H\u0080\b\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0002\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\nH\u0000¨\u0006\u000b"}, d2 = {"fastAny", "", "", "", "block", "Lkotlin/Function1;", "fastForEach", "", ExifInterface.GPS_DIRECTION_TRUE, "wrapIntoSet", "Landroidx/collection/ScatterSet;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScatterSetWrapperKt {
    public static final <T> Set<T> wrapIntoSet(ScatterSet<T> scatterSet) {
        return new ScatterSetWrapper(scatterSet);
    }

    public static final <T> void fastForEach(Set<? extends T> set, Function1<? super T, Unit> function1) {
        if (set instanceof ScatterSetWrapper) {
            ScatterSet<T> set$runtime_release = ((ScatterSetWrapper) set).getSet$runtime_release();
            Object[] objArr = set$runtime_release.elements;
            long[] jArr = set$runtime_release.metadata;
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
                            function1.invoke(objArr[(i << 3) + i3]);
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
        } else {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                function1.invoke(it.next());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean fastAny(java.util.Set<? extends java.lang.Object> r14, kotlin.jvm.functions.Function1<java.lang.Object, java.lang.Boolean> r15) {
        /*
            boolean r0 = r14 instanceof androidx.compose.runtime.collection.ScatterSetWrapper
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L58
            androidx.compose.runtime.collection.ScatterSetWrapper r14 = (androidx.compose.runtime.collection.ScatterSetWrapper) r14
            androidx.collection.ScatterSet r14 = r14.getSet$runtime_release()
            java.lang.Object[] r0 = r14.elements
            long[] r14 = r14.metadata
            int r3 = r14.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L67
            r4 = r2
        L16:
            r5 = r14[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L53
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r2
        L30:
            if (r9 >= r7) goto L51
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.32E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L4d
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r0[r10]
            java.lang.Object r10 = r15.invoke(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L4d
            goto L83
        L4d:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L30
        L51:
            if (r7 != r8) goto L67
        L53:
            if (r4 == r3) goto L67
            int r4 = r4 + 1
            goto L16
        L58:
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            boolean r0 = r14 instanceof java.util.Collection
            if (r0 == 0) goto L69
            r0 = r14
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L69
        L67:
            r1 = r2
            goto L83
        L69:
            java.util.Iterator r14 = r14.iterator()
        L6d:
            boolean r0 = r14.hasNext()
            if (r0 == 0) goto L67
            java.lang.Object r0 = r14.next()
            java.lang.Object r0 = r15.invoke(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L6d
        L83:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.ScatterSetWrapperKt.fastAny(java.util.Set, kotlin.jvm.functions.Function1):boolean");
    }
}
