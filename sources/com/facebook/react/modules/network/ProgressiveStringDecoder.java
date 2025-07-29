package com.facebook.react.modules.network;

import com.facebook.common.logging.FLog;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/* loaded from: classes4.dex */
class ProgressiveStringDecoder {
    private static final String EMPTY_STRING = "";
    private final CharsetDecoder mDecoder;
    private byte[] remainder = null;

    public ProgressiveStringDecoder(Charset charset) {
        this.mDecoder = charset.newDecoder();
    }

    public String decodeNext(byte[] bArr, int i) throws CharacterCodingException {
        byte[] bArr2 = this.remainder;
        if (bArr2 != null) {
            byte[] bArr3 = new byte[bArr2.length + i];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            System.arraycopy(bArr, 0, bArr3, this.remainder.length, i);
            i += this.remainder.length;
            bArr = bArr3;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, 0, i);
        boolean z = false;
        int i2 = 0;
        CharBuffer charBufferDecode = null;
        while (!z && i2 < 4) {
            try {
                charBufferDecode = this.mDecoder.decode(byteBufferWrap);
                z = true;
            } catch (CharacterCodingException unused) {
                i2++;
                byteBufferWrap = ByteBuffer.wrap(bArr, 0, i - i2);
            }
        }
        if (z && i2 > 0) {
            byte[] bArr4 = new byte[i2];
            this.remainder = bArr4;
            System.arraycopy(bArr, i - i2, bArr4, 0, i2);
        } else {
            this.remainder = null;
        }
        if (!z) {
            FLog.w("ReactNative", "failed to decode string from byte array");
            return "";
        }
        return new String(charBufferDecode.array(), 0, charBufferDecode.length());
    }
}
