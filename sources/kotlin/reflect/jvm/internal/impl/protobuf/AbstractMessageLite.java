package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* loaded from: classes5.dex */
public abstract class AbstractMessageLite implements MessageLite {
    protected int memoizedHashCode = 0;

    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(outputStream, CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeRawVarint32Size(serializedSize) + serializedSize));
        codedOutputStreamNewInstance.writeRawVarint32(serializedSize);
        writeTo(codedOutputStreamNewInstance);
        codedOutputStreamNewInstance.flush();
    }

    UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    public static abstract class Builder<BuilderType extends Builder> implements MessageLite.Builder {
        @Override // 
        /* renamed from: clone */
        public abstract BuilderType mo7214clone();

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public abstract BuilderType mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        static final class LimitedInputStream extends FilterInputStream {
            private int limit;

            LimitedInputStream(InputStream inputStream, int i) {
                super(inputStream);
                this.limit = i;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.limit);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.limit <= 0) {
                    return -1;
                }
                int i = super.read();
                if (i >= 0) {
                    this.limit--;
                }
                return i;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                int i3 = this.limit;
                if (i3 <= 0) {
                    return -1;
                }
                int i4 = super.read(bArr, i, Math.min(i2, i3));
                if (i4 >= 0) {
                    this.limit -= i4;
                }
                return i4;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j) throws IOException {
                long jSkip = super.skip(Math.min(j, this.limit));
                if (jSkip >= 0) {
                    this.limit = (int) (this.limit - jSkip);
                }
                return jSkip;
            }
        }

        protected static UninitializedMessageException newUninitializedMessageException(MessageLite messageLite) {
            return new UninitializedMessageException(messageLite);
        }
    }
}
