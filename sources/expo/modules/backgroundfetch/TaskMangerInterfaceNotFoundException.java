package expo.modules.backgroundfetch;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;

/* compiled from: BackgroundFetchModule.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/backgroundfetch/TaskMangerInterfaceNotFoundException;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-background-fetch_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TaskMangerInterfaceNotFoundException extends CodedException {
    public TaskMangerInterfaceNotFoundException() {
        super("TaskManagerInterface not found", null, 2, null);
    }
}
