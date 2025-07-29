package com.facebook.react.modules.network;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* loaded from: classes4.dex */
public class ProgressResponseBody extends ResponseBody {
    private BufferedSource mBufferedSource;
    private final ProgressListener mProgressListener;
    private final ResponseBody mResponseBody;
    private long mTotalBytesRead = 0;

    public ProgressResponseBody(ResponseBody responseBody, ProgressListener progressListener) {
        this.mResponseBody = responseBody;
        this.mProgressListener = progressListener;
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: contentType */
    public MediaType get$contentType() {
        return this.mResponseBody.get$contentType();
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: contentLength */
    public long getContentLength() {
        return this.mResponseBody.getContentLength();
    }

    public long totalBytesRead() {
        return this.mTotalBytesRead;
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: source */
    public BufferedSource getSource() {
        if (this.mBufferedSource == null) {
            this.mBufferedSource = Okio.buffer(source(this.mResponseBody.getSource()));
        }
        return this.mBufferedSource;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.facebook.react.modules.network.ProgressResponseBody.1
            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                long j2 = super.read(buffer, j);
                ProgressResponseBody.this.mTotalBytesRead += j2 != -1 ? j2 : 0L;
                ProgressResponseBody.this.mProgressListener.onProgress(ProgressResponseBody.this.mTotalBytesRead, ProgressResponseBody.this.mResponseBody.getContentLength(), j2 == -1);
                return j2;
            }
        };
    }
}
