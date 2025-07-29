package expo.modules.camera.common;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonEvents.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lexpo/modules/camera/common/CameraMountErrorEvent;", "Lexpo/modules/kotlin/records/Record;", "message", "", "(Ljava/lang/String;)V", "getMessage$annotations", "()V", "getMessage", "()Ljava/lang/String;", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraMountErrorEvent implements Record {
    private final String message;

    @Field
    public static /* synthetic */ void getMessage$annotations() {
    }

    public CameraMountErrorEvent(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.message = message;
    }

    public final String getMessage() {
        return this.message;
    }
}
