package com.facebook.binaryresource;

import io.sentry.rrweb.RRWebVideoEvent;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteArrayBinaryResource.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/binaryresource/ByteArrayBinaryResource;", "Lcom/facebook/binaryresource/BinaryResource;", "bytes", "", "([B)V", "openStream", "Ljava/io/InputStream;", "read", RRWebVideoEvent.JsonKeys.SIZE, "", "imagepipeline-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ByteArrayBinaryResource implements BinaryResource {
    private final byte[] bytes;

    public ByteArrayBinaryResource(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.bytes = bytes;
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public long size() {
        return this.bytes.length;
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public InputStream openStream() throws IOException {
        return new ByteArrayInputStream(this.bytes);
    }

    @Override // com.facebook.binaryresource.BinaryResource
    /* renamed from: read, reason: from getter */
    public byte[] getBytes() {
        return this.bytes;
    }
}
