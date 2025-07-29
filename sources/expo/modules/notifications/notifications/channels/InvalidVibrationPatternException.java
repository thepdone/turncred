package expo.modules.notifications.notifications.channels;

import expo.modules.core.errors.CodedRuntimeException;

/* loaded from: classes5.dex */
public class InvalidVibrationPatternException extends CodedRuntimeException {
    public InvalidVibrationPatternException(int i, Object obj) {
        super("Invalid value in vibration pattern, expected all elements to be numbers, got: " + obj + " under " + i);
    }

    @Override // expo.modules.core.errors.CodedRuntimeException, expo.modules.core.interfaces.CodedThrowable
    public String getCode() {
        return "ERR_INVALID_VIBRATION_PATTERN";
    }
}
