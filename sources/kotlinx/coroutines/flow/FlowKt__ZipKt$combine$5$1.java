package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Zip.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
/* loaded from: classes2.dex */
public final class FlowKt__ZipKt$combine$5$1<T> implements Function0<T[]> {
    final /* synthetic */ Flow<T>[] $flows;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combine$5$1(Flow<? extends T>[] flowArr) {
        this.$flows = flowArr;
    }

    @Override // kotlin.jvm.functions.Function0
    public final T[] invoke() {
        int length = this.$flows.length;
        Intrinsics.reifiedOperationMarker(0, "T?");
        return (T[]) new Object[length];
    }
}
