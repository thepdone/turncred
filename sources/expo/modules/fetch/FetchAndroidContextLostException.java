package expo.modules.fetch;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;

/* compiled from: FetchExceptions.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/fetch/FetchAndroidContextLostException;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FetchAndroidContextLostException extends CodedException {
    public FetchAndroidContextLostException() {
        super("The Android context has been lost", null, 2, null);
    }
}
