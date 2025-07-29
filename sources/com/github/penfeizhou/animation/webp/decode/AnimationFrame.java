package com.github.penfeizhou.animation.webp.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.github.penfeizhou.animation.decode.Frame;
import com.github.penfeizhou.animation.webp.io.WebPReader;
import com.github.penfeizhou.animation.webp.io.WebPWriter;
import java.io.IOException;

/* loaded from: classes3.dex */
public class AnimationFrame extends Frame<WebPReader, WebPWriter> {
    final boolean blendingMethod;
    final boolean disposalMethod;
    final int imagePayloadOffset;
    final int imagePayloadSize;
    private final boolean useAlpha;
    private static final PorterDuffXfermode PORTERDUFF_XFERMODE_SRC_OVER = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
    private static final PorterDuffXfermode PORTERDUFF_XFERMODE_SRC = new PorterDuffXfermode(PorterDuff.Mode.SRC);

    public AnimationFrame(WebPReader webPReader, ANMFChunk aNMFChunk) {
        super(webPReader);
        this.frameWidth = aNMFChunk.frameWidth;
        this.frameHeight = aNMFChunk.frameHeight;
        this.frameX = aNMFChunk.frameX;
        this.frameY = aNMFChunk.frameY;
        this.frameDuration = aNMFChunk.frameDuration;
        if (this.frameDuration == 0) {
            this.frameDuration = 100;
        }
        this.blendingMethod = aNMFChunk.blendingMethod();
        this.disposalMethod = aNMFChunk.disposalMethod();
        this.imagePayloadOffset = aNMFChunk.offset + 24;
        this.imagePayloadSize = (aNMFChunk.payloadSize - 16) + (aNMFChunk.payloadSize & 1);
        this.useAlpha = aNMFChunk.alphChunk != null;
    }

    private int encode(WebPWriter webPWriter) {
        int i = 30 + this.imagePayloadSize;
        webPWriter.reset(i);
        webPWriter.putFourCC("RIFF");
        webPWriter.putUInt32(i);
        webPWriter.putFourCC("WEBP");
        webPWriter.putUInt32(VP8XChunk.ID);
        webPWriter.putUInt32(10);
        webPWriter.putByte((byte) (this.useAlpha ? 16 : 0));
        webPWriter.putUInt24(0);
        webPWriter.put1Based(this.frameWidth);
        webPWriter.put1Based(this.frameHeight);
        try {
            ((WebPReader) this.reader).reset();
            ((WebPReader) this.reader).skip(this.imagePayloadOffset);
            ((WebPReader) this.reader).read(webPWriter.toByteArray(), webPWriter.position(), this.imagePayloadSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override // com.github.penfeizhou.animation.decode.Frame
    public Bitmap draw(Canvas canvas, Paint paint, int i, Bitmap bitmap, WebPWriter webPWriter) {
        Bitmap bitmapDecodeByteArray;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = i;
        options.inMutable = true;
        options.inBitmap = bitmap;
        int iEncode = encode(webPWriter);
        byte[] byteArray = webPWriter.toByteArray();
        try {
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, iEncode, options);
        } catch (IllegalArgumentException unused) {
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = false;
            options2.inSampleSize = i;
            options2.inMutable = true;
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, iEncode, options2);
        }
        if (bitmapDecodeByteArray == null) {
            return bitmap;
        }
        if (this.blendingMethod) {
            paint.setXfermode(PORTERDUFF_XFERMODE_SRC);
        } else {
            paint.setXfermode(PORTERDUFF_XFERMODE_SRC_OVER);
        }
        this.srcRect.left = 0;
        this.srcRect.top = 0;
        this.srcRect.right = bitmapDecodeByteArray.getWidth();
        this.srcRect.bottom = bitmapDecodeByteArray.getHeight();
        float f = i;
        this.dstRect.left = (int) ((this.frameX * 2.0f) / f);
        this.dstRect.top = (int) ((this.frameY * 2.0f) / f);
        this.dstRect.right = (int) (((this.frameX * 2.0f) / f) + bitmapDecodeByteArray.getWidth());
        this.dstRect.bottom = (int) (((this.frameY * 2.0f) / f) + bitmapDecodeByteArray.getHeight());
        canvas.drawBitmap(bitmapDecodeByteArray, this.srcRect, this.dstRect, paint);
        return bitmapDecodeByteArray;
    }
}
