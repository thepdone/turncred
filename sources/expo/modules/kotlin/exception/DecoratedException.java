package expo.modules.kotlin.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CodedException.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/kotlin/exception/DecoratedException;", "Lexpo/modules/kotlin/exception/CodedException;", "message", "", "cause", "(Ljava/lang/String;Lexpo/modules/kotlin/exception/CodedException;)V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class DecoratedException extends CodedException {
    public static final int $stable = 0;

    /* JADX WARN: Illegal instructions before constructor call */
    public DecoratedException(String message, CodedException cause) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(cause, "cause");
        String code = cause.getCode();
        String strLineSeparator = System.lineSeparator();
        String localizedMessage = cause.getLocalizedMessage();
        super(code, message + strLineSeparator + "→ Caused by: " + (localizedMessage == null ? cause : localizedMessage), cause);
    }
}
