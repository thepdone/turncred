package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import io.sentry.rrweb.RRWebVideoEvent;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MemoryPooledByteBufferOutputStream.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0018B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0005H\u0007J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0005H\u0016R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/facebook/imagepipeline/memory/MemoryPooledByteBufferOutputStream;", "Lcom/facebook/common/memory/PooledByteBufferOutputStream;", "pool", "Lcom/facebook/imagepipeline/memory/MemoryChunkPool;", "initialCapacity", "", "(Lcom/facebook/imagepipeline/memory/MemoryChunkPool;I)V", "bufRef", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/memory/MemoryChunk;", "count", "close", "", "ensureValid", "realloc", "newLength", RRWebVideoEvent.JsonKeys.SIZE, "toByteBuffer", "Lcom/facebook/imagepipeline/memory/MemoryPooledByteBuffer;", "write", "buffer", "", "offset", "oneByte", "InvalidStreamException", "imagepipeline_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MemoryPooledByteBufferOutputStream extends PooledByteBufferOutputStream {
    private CloseableReference<MemoryChunk> bufRef;
    private int count;
    private final MemoryChunkPool pool;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MemoryPooledByteBufferOutputStream(MemoryChunkPool pool) {
        this(pool, 0, 2, null);
        Intrinsics.checkNotNullParameter(pool, "pool");
    }

    public /* synthetic */ MemoryPooledByteBufferOutputStream(MemoryChunkPool memoryChunkPool, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(memoryChunkPool, (i2 & 2) != 0 ? memoryChunkPool.getMinBufferSize() : i);
    }

    public MemoryPooledByteBufferOutputStream(MemoryChunkPool pool, int i) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        if (i <= 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.pool = pool;
        this.count = 0;
        this.bufRef = CloseableReference.of(pool.get(i), pool);
    }

    @Override // com.facebook.common.memory.PooledByteBufferOutputStream
    public MemoryPooledByteBuffer toByteBuffer() {
        ensureValid();
        CloseableReference<MemoryChunk> closeableReference = this.bufRef;
        if (closeableReference != null) {
            return new MemoryPooledByteBuffer(closeableReference, this.count);
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // com.facebook.common.memory.PooledByteBufferOutputStream
    /* renamed from: size, reason: from getter */
    public int getCount() {
        return this.count;
    }

    @Override // java.io.OutputStream
    public void write(int oneByte) throws IOException {
        write(new byte[]{(byte) oneByte});
    }

    @Override // java.io.OutputStream
    public void write(byte[] buffer, int offset, int count) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (offset < 0 || count < 0 || offset + count > buffer.length) {
            throw new ArrayIndexOutOfBoundsException("length=" + buffer.length + "; regionStart=" + offset + "; regionLength=" + count);
        }
        ensureValid();
        realloc(this.count + count);
        CloseableReference<MemoryChunk> closeableReference = this.bufRef;
        if (closeableReference == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        closeableReference.get().write(this.count, buffer, offset, count);
        this.count += count;
    }

    @Override // com.facebook.common.memory.PooledByteBufferOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        CloseableReference.closeSafely(this.bufRef);
        this.bufRef = null;
        this.count = -1;
        super.close();
    }

    public final void realloc(int newLength) {
        ensureValid();
        CloseableReference<MemoryChunk> closeableReference = this.bufRef;
        if (closeableReference == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Intrinsics.checkNotNull(closeableReference);
        if (newLength <= closeableReference.get().getSize()) {
            return;
        }
        MemoryChunk memoryChunk = this.pool.get(newLength);
        Intrinsics.checkNotNullExpressionValue(memoryChunk, "this.pool[newLength]");
        MemoryChunk memoryChunk2 = memoryChunk;
        CloseableReference<MemoryChunk> closeableReference2 = this.bufRef;
        if (closeableReference2 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Intrinsics.checkNotNull(closeableReference2);
        closeableReference2.get().copy(0, memoryChunk2, 0, this.count);
        CloseableReference<MemoryChunk> closeableReference3 = this.bufRef;
        Intrinsics.checkNotNull(closeableReference3);
        closeableReference3.close();
        this.bufRef = CloseableReference.of(memoryChunk2, this.pool);
    }

    private final void ensureValid() {
        if (!CloseableReference.isValid(this.bufRef)) {
            throw new InvalidStreamException();
        }
    }

    /* compiled from: MemoryPooledByteBufferOutputStream.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/facebook/imagepipeline/memory/MemoryPooledByteBufferOutputStream$InvalidStreamException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "()V", "imagepipeline_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }
}
