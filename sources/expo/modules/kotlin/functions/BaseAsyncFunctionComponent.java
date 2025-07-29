package expo.modules.kotlin.functions;

import expo.modules.kotlin.types.AnyType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseAsyncFunctionComponent.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tR\u001a\u0010\b\u001a\u00020\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;", "Lexpo/modules/kotlin/functions/AnyFunction;", "name", "", "desiredArgsTypes", "", "Lexpo/modules/kotlin/types/AnyType;", "(Ljava/lang/String;[Lexpo/modules/kotlin/types/AnyType;)V", "queue", "Lexpo/modules/kotlin/functions/Queues;", "getQueue", "()Lexpo/modules/kotlin/functions/Queues;", "setQueue", "(Lexpo/modules/kotlin/functions/Queues;)V", "runOnQueue", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseAsyncFunctionComponent extends AnyFunction {
    public static final int $stable = 8;
    private Queues queue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseAsyncFunctionComponent(String name, AnyType[] desiredArgsTypes) {
        super(name, desiredArgsTypes);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desiredArgsTypes, "desiredArgsTypes");
        this.queue = Queues.DEFAULT;
    }

    protected final Queues getQueue() {
        return this.queue;
    }

    protected final void setQueue(Queues queues) {
        Intrinsics.checkNotNullParameter(queues, "<set-?>");
        this.queue = queues;
    }

    public final BaseAsyncFunctionComponent runOnQueue(Queues queue) {
        Intrinsics.checkNotNullParameter(queue, "queue");
        this.queue = queue;
        return this;
    }
}
