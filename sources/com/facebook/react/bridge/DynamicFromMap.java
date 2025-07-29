package com.facebook.react.bridge;

import androidx.core.util.Pools;
import java.util.Objects;

/* loaded from: classes4.dex */
class DynamicFromMap implements Dynamic {
    private static final ThreadLocal<Pools.SimplePool<DynamicFromMap>> sPool = new ThreadLocal<Pools.SimplePool<DynamicFromMap>>() { // from class: com.facebook.react.bridge.DynamicFromMap.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Pools.SimplePool<DynamicFromMap> initialValue() {
            return new Pools.SimplePool<>(10);
        }
    };
    private ReadableMap mMap;
    private String mName;

    private DynamicFromMap() {
    }

    public static DynamicFromMap create(ReadableMap readableMap, String str) {
        DynamicFromMap dynamicFromMapAcquire = sPool.get().acquire();
        if (dynamicFromMapAcquire == null) {
            dynamicFromMapAcquire = new DynamicFromMap();
        }
        dynamicFromMapAcquire.mMap = readableMap;
        dynamicFromMapAcquire.mName = str;
        return dynamicFromMapAcquire;
    }

    @Override // com.facebook.react.bridge.Dynamic
    public void recycle() {
        this.mMap = null;
        this.mName = null;
        sPool.get().release(this);
    }

    @Override // com.facebook.react.bridge.Dynamic
    public boolean isNull() {
        String str;
        ReadableMap readableMap = this.mMap;
        if (readableMap == null || (str = this.mName) == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableMap.isNull(str);
    }

    @Override // com.facebook.react.bridge.Dynamic
    public boolean asBoolean() {
        String str;
        ReadableMap readableMap = this.mMap;
        if (readableMap == null || (str = this.mName) == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableMap.getBoolean(str);
    }

    @Override // com.facebook.react.bridge.Dynamic
    public double asDouble() {
        String str;
        ReadableMap readableMap = this.mMap;
        if (readableMap == null || (str = this.mName) == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableMap.getDouble(str);
    }

    @Override // com.facebook.react.bridge.Dynamic
    public int asInt() {
        String str;
        ReadableMap readableMap = this.mMap;
        if (readableMap == null || (str = this.mName) == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableMap.getInt(str);
    }

    @Override // com.facebook.react.bridge.Dynamic
    public String asString() {
        String str;
        ReadableMap readableMap = this.mMap;
        if (readableMap == null || (str = this.mName) == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableMap.getString(str);
    }

    @Override // com.facebook.react.bridge.Dynamic
    public ReadableArray asArray() {
        String str;
        ReadableMap readableMap = this.mMap;
        if (readableMap == null || (str = this.mName) == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableMap.getArray(str);
    }

    @Override // com.facebook.react.bridge.Dynamic
    public ReadableMap asMap() {
        String str;
        ReadableMap readableMap = this.mMap;
        if (readableMap == null || (str = this.mName) == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return (ReadableMap) Objects.requireNonNull(readableMap.getMap(str));
    }

    @Override // com.facebook.react.bridge.Dynamic
    public ReadableType getType() {
        String str;
        ReadableMap readableMap = this.mMap;
        if (readableMap == null || (str = this.mName) == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableMap.getType(str);
    }
}
