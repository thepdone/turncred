package com.github.penfeizhou.animation.gif.decode;

import com.github.penfeizhou.animation.gif.io.GifReader;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.IOException;

/* loaded from: classes3.dex */
public class ImageDescriptor implements Block {
    private byte flag;
    public int frameHeight;
    public int frameWidth;
    public int frameX;
    public int frameY;
    public int imageDataOffset;
    public ColorTable localColorTable;
    public int lzwMinimumCodeSize;

    @Override // com.github.penfeizhou.animation.gif.decode.Block
    public int size() {
        return 0;
    }

    @Override // com.github.penfeizhou.animation.gif.decode.Block
    public void receive(GifReader gifReader) throws IOException {
        this.frameX = gifReader.readUInt16();
        this.frameY = gifReader.readUInt16();
        this.frameWidth = gifReader.readUInt16();
        this.frameHeight = gifReader.readUInt16();
        this.flag = gifReader.peek();
        if (localColorTableFlag()) {
            ColorTable colorTable = new ColorTable(localColorTableSize());
            this.localColorTable = colorTable;
            colorTable.receive(gifReader);
        }
        this.lzwMinimumCodeSize = gifReader.peek() & 255;
        this.imageDataOffset = gifReader.position();
        while (true) {
            if (gifReader.peek() == 0) {
                return;
            } else {
                gifReader.skip(r0 & 255);
            }
        }
    }

    public boolean localColorTableFlag() {
        return (this.flag & 128) == 128;
    }

    public boolean interlaceFlag() {
        return (this.flag & SignedBytes.MAX_POWER_OF_TWO) == 64;
    }

    public boolean sortFlag() {
        return (this.flag & 32) == 32;
    }

    public int localColorTableSize() {
        return 2 << (this.flag & Ascii.SI);
    }
}
