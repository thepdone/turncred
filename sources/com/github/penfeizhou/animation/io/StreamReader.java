package com.github.penfeizhou.animation.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class StreamReader extends FilterInputStream implements Reader {
    private int position;

    @Override // com.github.penfeizhou.animation.io.Reader
    public InputStream toInputStream() throws IOException {
        return this;
    }

    public StreamReader(InputStream inputStream) throws IOException {
        super(inputStream);
        try {
            inputStream.reset();
        } catch (IOException unused) {
        }
    }

    @Override // com.github.penfeizhou.animation.io.Reader
    public byte peek() throws IOException {
        byte b = (byte) read();
        this.position++;
        return b;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, com.github.penfeizhou.animation.io.Reader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = super.read(bArr, i, i2);
        this.position += Math.max(0, i3);
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, com.github.penfeizhou.animation.io.Reader
    public synchronized void reset() throws IOException {
        super.reset();
        this.position = 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, com.github.penfeizhou.animation.io.Reader
    public long skip(long j) throws IOException {
        long j2 = j;
        while (j2 > 0) {
            long jSkip = super.skip(j2);
            if (jSkip > 0) {
                j2 -= jSkip;
            } else {
                if (super.read() == -1) {
                    break;
                }
                j2--;
            }
        }
        long j3 = j - j2;
        this.position = (int) (this.position + j3);
        return j3;
    }

    @Override // com.github.penfeizhou.animation.io.Reader
    public int position() {
        return this.position;
    }
}
