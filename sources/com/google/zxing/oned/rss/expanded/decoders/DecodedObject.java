package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes5.dex */
abstract class DecodedObject {
    private final int newPosition;

    DecodedObject(int i) {
        this.newPosition = i;
    }

    final int getNewPosition() {
        return this.newPosition;
    }
}
