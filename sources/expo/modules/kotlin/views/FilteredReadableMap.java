package expo.modules.kotlin.views;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import expo.modules.kotlin.Filter;
import expo.modules.kotlin.FilteredIterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FilteredReadableMap.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J\b\u0010 \u001a\u00020!H\u0016J\u0015\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0#H\u0096\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lexpo/modules/kotlin/views/FilteredReadableMap;", "Lcom/facebook/react/bridge/ReadableMap;", "backingMap", "filteredKeys", "", "", "(Lcom/facebook/react/bridge/ReadableMap;Ljava/util/List;)V", "entryIterator", "Lexpo/modules/kotlin/FilteredIterator;", "", "", "getEntryIterator", "()Lexpo/modules/kotlin/FilteredIterator;", "getArray", "Lcom/facebook/react/bridge/ReadableArray;", "name", "getBoolean", "", "getDouble", "", "getDynamic", "Lcom/facebook/react/bridge/Dynamic;", "getInt", "", "getLong", "", "getMap", "getString", "getType", "Lcom/facebook/react/bridge/ReadableType;", "hasKey", "isNull", "keySetIterator", "Lcom/facebook/react/bridge/ReadableMapKeySetIterator;", "toHashMap", "Ljava/util/HashMap;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FilteredReadableMap implements ReadableMap {
    public static final int $stable = 8;
    private final ReadableMap backingMap;
    private final FilteredIterator<Map.Entry<String, Object>> entryIterator;
    private final List<String> filteredKeys;

    @Override // com.facebook.react.bridge.ReadableMap
    public ReadableArray getArray(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.getArray(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public boolean getBoolean(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.getBoolean(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public double getDouble(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.getDouble(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public Dynamic getDynamic(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.getDynamic(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public int getInt(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.getInt(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public long getLong(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.getLong(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public ReadableMap getMap(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.getMap(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public String getString(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.getString(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public ReadableType getType(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.getType(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public boolean hasKey(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.hasKey(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public boolean isNull(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.isNull(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public HashMap<String, Object> toHashMap() {
        return this.backingMap.toHashMap();
    }

    public FilteredReadableMap(ReadableMap backingMap, List<String> filteredKeys) {
        Intrinsics.checkNotNullParameter(backingMap, "backingMap");
        Intrinsics.checkNotNullParameter(filteredKeys, "filteredKeys");
        this.backingMap = backingMap;
        this.filteredKeys = filteredKeys;
        this.entryIterator = new FilteredIterator<>(backingMap.getEntryIterator(), new Filter() { // from class: expo.modules.kotlin.views.FilteredReadableMap$$ExternalSyntheticLambda1
            @Override // expo.modules.kotlin.Filter
            public final boolean apply(Object obj) {
                return FilteredReadableMap.entryIterator$lambda$0(this.f$0, (Map.Entry) obj);
            }
        });
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public FilteredIterator<Map.Entry<String, Object>> getEntryIterator() {
        return this.entryIterator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean entryIterator$lambda$0(FilteredReadableMap this$0, Map.Entry it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        return !this$0.filteredKeys.contains(it.getKey());
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public ReadableMapKeySetIterator keySetIterator() {
        return new FilteredReadableMapKeySetIterator(this.backingMap.keySetIterator(), new Filter() { // from class: expo.modules.kotlin.views.FilteredReadableMap$$ExternalSyntheticLambda0
            @Override // expo.modules.kotlin.Filter
            public final boolean apply(Object obj) {
                return FilteredReadableMap.keySetIterator$lambda$1(this.f$0, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean keySetIterator$lambda$1(FilteredReadableMap this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        return !this$0.filteredKeys.contains(it);
    }
}
