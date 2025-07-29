package expo.modules.fetch;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResponseSink.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u000fJ\u0006\u0010\u0010\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lexpo/modules/fetch/ResponseSink;", "", "()V", "bodyQueue", "", "", "<set-?>", "", "bodyUsed", "getBodyUsed", "()Z", "isFinalized", "appendBufferBody", "", "data", "appendBufferBody$expo_release", "finalize", "expo_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ResponseSink {
    private final List<byte[]> bodyQueue = new ArrayList();
    private boolean bodyUsed;
    private boolean isFinalized;

    public final boolean getBodyUsed() {
        return this.bodyUsed;
    }

    public final void appendBufferBody$expo_release(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.bodyUsed = true;
        this.bodyQueue.add(data);
    }

    public final byte[] finalize() {
        Iterator<T> it = this.bodyQueue.iterator();
        int length = 0;
        while (it.hasNext()) {
            length += ((byte[]) it.next()).length;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        Iterator<byte[]> it2 = this.bodyQueue.iterator();
        while (it2.hasNext()) {
            byteBufferAllocate.put(it2.next());
        }
        this.bodyQueue.clear();
        this.bodyUsed = true;
        this.isFinalized = true;
        byte[] bArrArray = byteBufferAllocate.array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
        return bArrArray;
    }
}
