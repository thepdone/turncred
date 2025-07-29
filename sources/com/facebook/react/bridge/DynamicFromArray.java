package com.facebook.react.bridge;

import androidx.core.util.Pools;

/* loaded from: classes4.dex */
class DynamicFromArray implements Dynamic {
    private static final Pools.SimplePool<DynamicFromArray> sPool = new Pools.SimplePool<>(10);
    private ReadableArray mArray;
    private int mIndex = -1;

    private DynamicFromArray() {
    }

    public static DynamicFromArray create(ReadableArray readableArray, int i) {
        DynamicFromArray dynamicFromArrayAcquire = sPool.acquire();
        if (dynamicFromArrayAcquire == null) {
            dynamicFromArrayAcquire = new DynamicFromArray();
        }
        dynamicFromArrayAcquire.mArray = readableArray;
        dynamicFromArrayAcquire.mIndex = i;
        return dynamicFromArrayAcquire;
    }

    @Override // com.facebook.react.bridge.Dynamic
    public void recycle() {
        this.mArray = null;
        this.mIndex = -1;
        sPool.release(this);
    }

    @Override // com.facebook.react.bridge.Dynamic
    public boolean isNull() {
        ReadableArray readableArray = this.mArray;
        if (readableArray == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableArray.isNull(this.mIndex);
    }

    @Override // com.facebook.react.bridge.Dynamic
    public boolean asBoolean() {
        ReadableArray readableArray = this.mArray;
        if (readableArray == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableArray.getBoolean(this.mIndex);
    }

    @Override // com.facebook.react.bridge.Dynamic
    public double asDouble() {
        ReadableArray readableArray = this.mArray;
        if (readableArray == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableArray.getDouble(this.mIndex);
    }

    @Override // com.facebook.react.bridge.Dynamic
    public int asInt() {
        ReadableArray readableArray = this.mArray;
        if (readableArray == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableArray.getInt(this.mIndex);
    }

    @Override // com.facebook.react.bridge.Dynamic
    public String asString() {
        ReadableArray readableArray = this.mArray;
        if (readableArray == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableArray.getString(this.mIndex);
    }

    @Override // com.facebook.react.bridge.Dynamic
    public ReadableArray asArray() {
        ReadableArray readableArray = this.mArray;
        if (readableArray == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableArray.getArray(this.mIndex);
    }

    @Override // com.facebook.react.bridge.Dynamic
    public ReadableMap asMap() {
        ReadableArray readableArray = this.mArray;
        if (readableArray == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableArray.getMap(this.mIndex);
    }

    @Override // com.facebook.react.bridge.Dynamic
    public ReadableType getType() {
        ReadableArray readableArray = this.mArray;
        if (readableArray == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableArray.getType(this.mIndex);
    }
}
