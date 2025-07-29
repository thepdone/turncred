package androidx.compose.foundation.gestures;

import androidx.collection.ObjectFloatMap;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.react.uimanager.ViewProps;
import io.sentry.rrweb.RRWebVideoEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnchoredDraggable.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0017\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u001f\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J@\u0010\u0014\u001a\u00020\u001526\u0010\u0016\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00150\u0017H\u0016J\u0015\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\fH\u0016J\b\u0010 \u001a\u00020\fH\u0016J\u0015\u0010!\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020$H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006%"}, d2 = {"Landroidx/compose/foundation/gestures/MapDraggableAnchors;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/DraggableAnchors;", "anchors", "Landroidx/collection/ObjectFloatMap;", "(Landroidx/collection/ObjectFloatMap;)V", RRWebVideoEvent.JsonKeys.SIZE, "", "getSize", "()I", "closestAnchor", ViewProps.POSITION, "", "(F)Ljava/lang/Object;", "searchUpwards", "", "(FZ)Ljava/lang/Object;", "equals", "other", "", "forEach", "", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "anchor", "hasAnchorFor", "value", "(Ljava/lang/Object;)Z", "hashCode", "maxAnchor", "minAnchor", "positionOf", "(Ljava/lang/Object;)F", InAppPurchaseConstants.METHOD_TO_STRING, "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class MapDraggableAnchors<T> implements DraggableAnchors<T> {
    private final ObjectFloatMap<T> anchors;

    public MapDraggableAnchors(ObjectFloatMap<T> objectFloatMap) {
        this.anchors = objectFloatMap;
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public float positionOf(T value) {
        return this.anchors.getOrDefault(value, Float.NaN);
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public boolean hasAnchorFor(T value) {
        return this.anchors.containsKey(value);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0052 A[PHI: r5 r6
  0x0052: PHI (r5v3 T) = (r5v2 T), (r5v4 T) binds: [B:6:0x0022, B:15:0x0050] A[DONT_GENERATE, DONT_INLINE]
  0x0052: PHI (r6v2 float) = (r6v1 float), (r6v3 float) binds: [B:6:0x0022, B:15:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public T closestAnchor(float r19) {
        /*
            r18 = this;
            r0 = r18
            androidx.collection.ObjectFloatMap<T> r1 = r0.anchors
            java.lang.Object[] r2 = r1.keys
            float[] r3 = r1.values
            long[] r1 = r1.metadata
            int r4 = r1.length
            int r4 = r4 + (-2)
            r5 = 0
            if (r4 < 0) goto L57
            r6 = 2139095040(0x7f800000, float:Infinity)
            r7 = 0
            r8 = r7
        L14:
            r9 = r1[r8]
            long r11 = ~r9
            r13 = 7
            long r11 = r11 << r13
            long r11 = r11 & r9
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 == 0) goto L52
            int r11 = r8 - r4
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = r7
        L2e:
            if (r13 >= r11) goto L50
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 128(0x80, double:6.32E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L4c
            int r14 = r8 << 3
            int r14 = r14 + r13
            r15 = r2[r14]
            r14 = r3[r14]
            float r14 = r19 - r14
            float r14 = java.lang.Math.abs(r14)
            int r16 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r16 > 0) goto L4c
            r6 = r14
            r5 = r15
        L4c:
            long r9 = r9 >> r12
            int r13 = r13 + 1
            goto L2e
        L50:
            if (r11 != r12) goto L57
        L52:
            if (r8 == r4) goto L57
            int r8 = r8 + 1
            goto L14
        L57:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.MapDraggableAnchors.closestAnchor(float):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005c A[PHI: r5 r9
  0x005c: PHI (r5v3 T) = (r5v2 T), (r5v4 T) binds: [B:6:0x0023, B:22:0x005a] A[DONT_GENERATE, DONT_INLINE]
  0x005c: PHI (r9v2 float) = (r9v1 float), (r9v3 float) binds: [B:6:0x0023, B:22:0x005a] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public T closestAnchor(float r20, boolean r21) {
        /*
            r19 = this;
            r0 = r19
            androidx.collection.ObjectFloatMap<T> r1 = r0.anchors
            java.lang.Object[] r2 = r1.keys
            float[] r3 = r1.values
            long[] r1 = r1.metadata
            int r4 = r1.length
            int r4 = r4 + (-2)
            r5 = 0
            if (r4 < 0) goto L61
            r6 = 2139095040(0x7f800000, float:Infinity)
            r7 = 0
            r9 = r6
            r8 = r7
        L15:
            r10 = r1[r8]
            long r12 = ~r10
            r14 = 7
            long r12 = r12 << r14
            long r12 = r12 & r10
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r12 = r12 & r14
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 == 0) goto L5c
            int r12 = r8 - r4
            int r12 = ~r12
            int r12 = r12 >>> 31
            r13 = 8
            int r12 = 8 - r12
            r14 = r7
        L2f:
            if (r14 >= r12) goto L5a
            r15 = 255(0xff, double:1.26E-321)
            long r15 = r15 & r10
            r17 = 128(0x80, double:6.32E-322)
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L56
            int r15 = r8 << 3
            int r15 = r15 + r14
            r16 = r2[r15]
            r15 = r3[r15]
            if (r21 == 0) goto L46
            float r15 = r15 - r20
            goto L48
        L46:
            float r15 = r20 - r15
        L48:
            r17 = 0
            int r17 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r17 >= 0) goto L4f
            r15 = r6
        L4f:
            int r17 = (r15 > r9 ? 1 : (r15 == r9 ? 0 : -1))
            if (r17 > 0) goto L56
            r9 = r15
            r5 = r16
        L56:
            long r10 = r10 >> r13
            int r14 = r14 + 1
            goto L2f
        L5a:
            if (r12 != r13) goto L61
        L5c:
            if (r8 == r4) goto L61
            int r8 = r8 + 1
            goto L15
        L61:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.MapDraggableAnchors.closestAnchor(float, boolean):java.lang.Object");
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public float minAnchor() {
        return AnchoredDraggableKt.minValueOrNaN(this.anchors);
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public float maxAnchor() {
        return AnchoredDraggableKt.maxValueOrNaN(this.anchors);
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public int getSize() {
        return this.anchors.get_size();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MapDraggableAnchors) {
            return Intrinsics.areEqual(this.anchors, ((MapDraggableAnchors) other).anchors);
        }
        return false;
    }

    public int hashCode() {
        return this.anchors.hashCode() * 31;
    }

    public String toString() {
        return "MapDraggableAnchors(" + this.anchors + ')';
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public void forEach(Function2<? super T, ? super Float, Unit> block) {
        ObjectFloatMap<T> objectFloatMap = this.anchors;
        Object[] objArr = objectFloatMap.keys;
        float[] fArr = objectFloatMap.values;
        long[] jArr = objectFloatMap.metadata;
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
                        block.invoke(objArr[i4], Float.valueOf(fArr[i4]));
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
}
