package com.facebook.react.modules.debug;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DidJSUpdateUiDuringFrameDetector.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u0006\u0010\u0006\u001a\u00020\u0004H\u0002\u001a0\u0010\u0007\u001a\u00020\u00042\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002\u001a0\u0010\t\u001a\u00020\n2\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¨\u0006\u000b"}, d2 = {"cleanUp", "", "eventArray", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", SDKConstants.PARAM_END_TIME, "getLastEventBetweenTimestamps", "startTime", "hasEventBetweenTimestamps", "", "ReactAndroid_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DidJSUpdateUiDuringFrameDetectorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasEventBetweenTimestamps(ArrayList<Long> arrayList, long j, long j2) {
        ArrayList<Long> arrayList2 = arrayList;
        if ((arrayList2 instanceof Collection) && arrayList2.isEmpty()) {
            return false;
        }
        Iterator<T> it = arrayList2.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            if (j <= jLongValue && jLongValue < j2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long getLastEventBetweenTimestamps(ArrayList<Long> arrayList, long j, long j2) {
        Iterator<Long> it = arrayList.iterator();
        long jLongValue = -1;
        while (it.hasNext()) {
            Long next = it.next();
            Intrinsics.checkNotNull(next);
            long jLongValue2 = next.longValue();
            if (j <= jLongValue2 && jLongValue2 < j2) {
                jLongValue = next.longValue();
            } else if (next.longValue() >= j2) {
                break;
            }
        }
        return jLongValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cleanUp(ArrayList<Long> arrayList, long j) {
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Long l = arrayList.get(i2);
            Intrinsics.checkNotNullExpressionValue(l, "get(...)");
            if (l.longValue() < j) {
                i++;
            }
        }
        if (i > 0) {
            int i3 = size - i;
            for (int i4 = 0; i4 < i3; i4++) {
                arrayList.set(i4, arrayList.get(i4 + i));
            }
            CollectionsKt.dropLast(arrayList, i);
        }
    }
}
