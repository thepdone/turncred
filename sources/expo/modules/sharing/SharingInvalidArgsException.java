package expo.modules.sharing;

import com.nimbusds.jose.jwk.JWKParameterNames;
import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharingExceptions.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/sharing/SharingInvalidArgsException;", "Lexpo/modules/kotlin/exception/CodedException;", "message", "", JWKParameterNames.RSA_EXPONENT, "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/String;Ljava/lang/Exception;)V", "expo-sharing_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SharingInvalidArgsException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharingInvalidArgsException(String str, Exception e) {
        super(str, e.getCause());
        Intrinsics.checkNotNullParameter(e, "e");
    }
}
