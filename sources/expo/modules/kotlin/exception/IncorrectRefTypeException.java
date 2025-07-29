package expo.modules.kotlin.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

/* compiled from: CodedException.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/kotlin/exception/IncorrectRefTypeException;", "Lexpo/modules/kotlin/exception/CodedException;", "desiredType", "Lkotlin/reflect/KType;", "receivedClass", "Ljava/lang/Class;", "(Lkotlin/reflect/KType;Ljava/lang/Class;)V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IncorrectRefTypeException extends CodedException {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IncorrectRefTypeException(KType desiredType, Class<?> receivedClass) {
        super("Cannot convert received '" + receivedClass + "' to the '" + desiredType + "', because of the inner ref type mismatch", null, 2, null);
        Intrinsics.checkNotNullParameter(desiredType, "desiredType");
        Intrinsics.checkNotNullParameter(receivedClass, "receivedClass");
    }
}
