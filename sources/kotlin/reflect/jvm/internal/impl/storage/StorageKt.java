package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* compiled from: storage.kt */
/* loaded from: classes5.dex */
public final class StorageKt {
    public static final <T> T getValue(NotNullLazyValue<? extends T> notNullLazyValue, Object obj, KProperty<?> p) {
        Intrinsics.checkNotNullParameter(notNullLazyValue, "<this>");
        Intrinsics.checkNotNullParameter(p, "p");
        return notNullLazyValue.invoke();
    }

    public static final <T> T getValue(NullableLazyValue<? extends T> nullableLazyValue, Object obj, KProperty<?> p) {
        Intrinsics.checkNotNullParameter(nullableLazyValue, "<this>");
        Intrinsics.checkNotNullParameter(p, "p");
        return nullableLazyValue.invoke();
    }
}
