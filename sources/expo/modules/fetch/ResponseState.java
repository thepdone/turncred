package expo.modules.fetch;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ResponseState.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lexpo/modules/fetch/ResponseState;", "", "intValue", "", "(Ljava/lang/String;II)V", "getIntValue", "()I", "INITIALIZED", "STARTED", "RESPONSE_RECEIVED", "BODY_COMPLETED", "BODY_STREAMING_STARTED", "BODY_STREAMING_CANCELLED", "ERROR_RECEIVED", "expo_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ResponseState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ResponseState[] $VALUES;
    private final int intValue;
    public static final ResponseState INITIALIZED = new ResponseState("INITIALIZED", 0, 0);
    public static final ResponseState STARTED = new ResponseState("STARTED", 1, 1);
    public static final ResponseState RESPONSE_RECEIVED = new ResponseState("RESPONSE_RECEIVED", 2, 2);
    public static final ResponseState BODY_COMPLETED = new ResponseState("BODY_COMPLETED", 3, 3);
    public static final ResponseState BODY_STREAMING_STARTED = new ResponseState("BODY_STREAMING_STARTED", 4, 4);
    public static final ResponseState BODY_STREAMING_CANCELLED = new ResponseState("BODY_STREAMING_CANCELLED", 5, 5);
    public static final ResponseState ERROR_RECEIVED = new ResponseState("ERROR_RECEIVED", 6, 6);

    private static final /* synthetic */ ResponseState[] $values() {
        return new ResponseState[]{INITIALIZED, STARTED, RESPONSE_RECEIVED, BODY_COMPLETED, BODY_STREAMING_STARTED, BODY_STREAMING_CANCELLED, ERROR_RECEIVED};
    }

    public static EnumEntries<ResponseState> getEntries() {
        return $ENTRIES;
    }

    public static ResponseState valueOf(String str) {
        return (ResponseState) Enum.valueOf(ResponseState.class, str);
    }

    public static ResponseState[] values() {
        return (ResponseState[]) $VALUES.clone();
    }

    private ResponseState(String str, int i, int i2) {
        this.intValue = i2;
    }

    public final int getIntValue() {
        return this.intValue;
    }

    static {
        ResponseState[] responseStateArr$values = $values();
        $VALUES = responseStateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(responseStateArr$values);
    }
}
