package expo.modules.localauthentication;

import androidx.exifinterface.media.ExifInterface;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalAuthenticationModule.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a+\u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u000b0\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\u000b¢\u0006\u0002\u0010\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"AUTHENTICATION_TYPE_FACIAL_RECOGNITION", "", "AUTHENTICATION_TYPE_FINGERPRINT", "AUTHENTICATION_TYPE_IRIS", "DEVICE_CREDENTIAL_FALLBACK_CODE", "SECURITY_LEVEL_BIOMETRIC_STRONG", "SECURITY_LEVEL_BIOMETRIC_WEAK", "SECURITY_LEVEL_NONE", "SECURITY_LEVEL_SECRET", "addIf", "", ExifInterface.GPS_DIRECTION_TRUE, "", "condition", "", "valueToAdd", "(Ljava/util/Set;ZLjava/lang/Object;)V", "expo-local-authentication_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocalAuthenticationModuleKt {
    private static final int AUTHENTICATION_TYPE_FACIAL_RECOGNITION = 2;
    private static final int AUTHENTICATION_TYPE_FINGERPRINT = 1;
    private static final int AUTHENTICATION_TYPE_IRIS = 3;
    private static final int DEVICE_CREDENTIAL_FALLBACK_CODE = 6;
    private static final int SECURITY_LEVEL_BIOMETRIC_STRONG = 3;
    private static final int SECURITY_LEVEL_BIOMETRIC_WEAK = 2;
    private static final int SECURITY_LEVEL_NONE = 0;
    private static final int SECURITY_LEVEL_SECRET = 1;

    public static final <T> void addIf(Set<T> set, boolean z, T t) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        if (z) {
            set.add(t);
        }
    }
}
