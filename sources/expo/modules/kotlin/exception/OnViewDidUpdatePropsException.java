package expo.modules.kotlin.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: CodedException.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/kotlin/exception/OnViewDidUpdatePropsException;", "Lexpo/modules/kotlin/exception/DecoratedException;", "viewType", "Lkotlin/reflect/KClass;", "cause", "Lexpo/modules/kotlin/exception/CodedException;", "(Lkotlin/reflect/KClass;Lexpo/modules/kotlin/exception/CodedException;)V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OnViewDidUpdatePropsException extends DecoratedException {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnViewDidUpdatePropsException(KClass<?> viewType, CodedException cause) {
        super("Error occurred when invoking 'onViewDidUpdateProps' on '" + viewType.getSimpleName() + "'", cause);
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
