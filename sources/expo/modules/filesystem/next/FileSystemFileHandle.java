package expo.modules.filesystem.next;

import expo.modules.kotlin.sharedobjects.SharedRef;
import io.sentry.SentryEnvelopeItemHeader;
import io.sentry.rrweb.RRWebVideoEvent;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: FileSystemFileHandle.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0015R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\f¨\u0006\u001b"}, d2 = {"Lexpo/modules/filesystem/next/FileSystemFileHandle;", "Lexpo/modules/kotlin/sharedobjects/SharedRef;", "Ljava/nio/channels/FileChannel;", "Ljava/lang/AutoCloseable;", "file", "Lexpo/modules/filesystem/next/FileSystemFile;", "(Lexpo/modules/filesystem/next/FileSystemFile;)V", "fileChannel", "value", "", "offset", "getOffset", "()Ljava/lang/Long;", "setOffset", "(Ljava/lang/Long;)V", RRWebVideoEvent.JsonKeys.SIZE, "getSize", "close", "", "ensureIsOpen", "read", "", SentryEnvelopeItemHeader.JsonKeys.LENGTH, "", "sharedObjectDidRelease", "write", "data", "expo-file-system_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FileSystemFileHandle extends SharedRef<FileChannel> implements AutoCloseable {
    private final FileChannel fileChannel;

    /* JADX WARN: Illegal instructions before constructor call */
    public FileSystemFileHandle(FileSystemFile file) {
        Intrinsics.checkNotNullParameter(file, "file");
        FileChannel channel = new RandomAccessFile(file.getFile(), "rw").getChannel();
        Intrinsics.checkNotNullExpressionValue(channel, "getChannel(...)");
        super(channel, null, 2, null);
        this.fileChannel = getRef();
    }

    private final void ensureIsOpen() throws UnableToReadHandleException {
        if (!this.fileChannel.isOpen()) {
            throw new UnableToReadHandleException("file handle is closed");
        }
    }

    @Override // expo.modules.kotlin.sharedobjects.SharedObject
    public void sharedObjectDidRelease() {
        close();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.fileChannel.close();
    }

    public final byte[] read(int length) throws IOException, UnableToReadHandleException {
        ensureIsOpen();
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(RangesKt.coerceAtMost(length, (int) (this.fileChannel.size() - this.fileChannel.position())));
            this.fileChannel.read(byteBufferAllocate);
            byte[] bArrArray = byteBufferAllocate.array();
            Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
            return bArrArray;
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "unknown error";
            }
            throw new UnableToReadHandleException(message);
        }
    }

    public final void write(byte[] data) throws UnableToWriteHandleException, IOException, UnableToReadHandleException {
        Intrinsics.checkNotNullParameter(data, "data");
        ensureIsOpen();
        try {
            this.fileChannel.write(ByteBuffer.wrap(data));
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "unknown error";
            }
            throw new UnableToWriteHandleException(message);
        }
    }

    public final Long getOffset() {
        try {
            return Long.valueOf(this.fileChannel.position());
        } catch (Exception unused) {
            return null;
        }
    }

    public final void setOffset(Long l) throws IOException {
        if (l == null) {
            return;
        }
        this.fileChannel.position(l.longValue());
    }

    public final Long getSize() {
        try {
            return Long.valueOf(this.fileChannel.size());
        } catch (Exception unused) {
            return null;
        }
    }
}
