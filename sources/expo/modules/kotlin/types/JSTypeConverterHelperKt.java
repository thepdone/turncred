package expo.modules.kotlin.types;

import android.net.Uri;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.JSTypeConverter;
import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.KCallablesJvm;

/* compiled from: JSTypeConverterHelper.kt */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0018\n\u0002\u0010\u0013\n\u0002\u0010\u0010\n\u0002\u0010\u0014\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\t\u001a\u0012\u0010\b\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\u0012\u0010\b\u001a\u00020\u0005*\u00020\r2\u0006\u0010\u000b\u001a\u00020\f\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u000e\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u000f\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0010\u001a#\u0010\b\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110\u00122\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\u0013\u001a\u0012\u0010\b\u001a\u00020\u0002*\u00020\u00142\u0006\u0010\u000b\u001a\u00020\f\u001a\u0012\u0010\b\u001a\u00020\u0002*\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f\u001a\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004*\u0006\u0012\u0002\b\u00030\u0016\u001a\u0012\u0010\b\u001a\u00020\u0002*\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f\u001a\u0012\u0010\b\u001a\u00020\u0002*\u00020\u00182\u0006\u0010\u000b\u001a\u00020\f\u001a\u001a\u0010\b\u001a\u00020\u0002*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00192\u0006\u0010\u000b\u001a\u00020\f\u001a\u001e\u0010\b\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110\u001a2\u0006\u0010\u000b\u001a\u00020\f\u001a*\u0010\b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u001b\"\u0004\b\u0001\u0010\u001c*\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001c0\u001d2\u0006\u0010\u000b\u001a\u00020\f\u001a\u0018\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001d*\u00020\n\u001a\u0018\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001d*\u00020\r\u001a\u001e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001a\"\u0004\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110\u001a\u001a0\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001d\"\u0004\b\u0000\u0010\u001b\"\u0004\b\u0001\u0010\u001c*\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001c0\u001d¨\u0006\u001f"}, d2 = {"putGeneric", "", "Lcom/facebook/react/bridge/WritableArray;", "value", "", "Lcom/facebook/react/bridge/WritableMap;", SDKConstants.PARAM_KEY, "", "toJSValue", "Landroid/net/Uri;", "Landroid/os/Bundle;", "containerProvider", "Lexpo/modules/kotlin/types/JSTypeConverter$ContainerProvider;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/File;", "Ljava/net/URI;", "Ljava/net/URL;", ExifInterface.GPS_DIRECTION_TRUE, "", "([Ljava/lang/Object;Lexpo/modules/kotlin/types/JSTypeConverter$ContainerProvider;)Lcom/facebook/react/bridge/WritableArray;", "", "", "", "", "", "Lkotlin/Pair;", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "toJSValueExperimental", "expo-modules-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JSTypeConverterHelperKt {
    public static final Map<String, Object> toJSValueExperimental(Record record) {
        Object next;
        Intrinsics.checkNotNullParameter(record, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Collection<KProperty1> memberProperties = KClasses.getMemberProperties(JvmClassMappingKt.getKotlinClass(record.getClass()));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(memberProperties, 10));
        for (KProperty1 kProperty1 : memberProperties) {
            Iterator<T> it = kProperty1.getAnnotations().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((Annotation) next) instanceof Field) {
                    break;
                }
            }
            Field field = (Field) next;
            if (field != null) {
                String strKey = field.key();
                String name = Intrinsics.areEqual(strKey, "") ? null : strKey;
                if (name == null) {
                    name = kProperty1.getName();
                }
                KCallablesJvm.setAccessible(kProperty1, true);
                linkedHashMap.put(name, JSTypeConverter.convertToJSValue$default(JSTypeConverter.INSTANCE, kProperty1.get(record), null, true, 2, null));
            }
            arrayList.add(Unit.INSTANCE);
        }
        return linkedHashMap;
    }

    public static final WritableMap toJSValue(Record record, JSTypeConverter.ContainerProvider containerProvider) {
        Object next;
        Intrinsics.checkNotNullParameter(record, "<this>");
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        WritableMap writableMapCreateMap = containerProvider.createMap();
        Collection<KProperty1> memberProperties = KClasses.getMemberProperties(JvmClassMappingKt.getKotlinClass(record.getClass()));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(memberProperties, 10));
        for (KProperty1 kProperty1 : memberProperties) {
            Iterator<T> it = kProperty1.getAnnotations().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((Annotation) next) instanceof Field) {
                    break;
                }
            }
            Field field = (Field) next;
            if (field != null) {
                String strKey = field.key();
                String name = Intrinsics.areEqual(strKey, "") ? null : strKey;
                if (name == null) {
                    name = kProperty1.getName();
                }
                KCallablesJvm.setAccessible(kProperty1, true);
                putGeneric(writableMapCreateMap, name, JSTypeConverter.INSTANCE.legacyConvertToJSValue(kProperty1.get(record), containerProvider));
            }
            arrayList.add(Unit.INSTANCE);
        }
        return writableMapCreateMap;
    }

    public static final Map<String, Object> toJSValueExperimental(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : bundle.keySet()) {
            Object objConvertToJSValue$default = JSTypeConverter.convertToJSValue$default(JSTypeConverter.INSTANCE, bundle.get(str), null, true, 2, null);
            Intrinsics.checkNotNull(str);
            linkedHashMap.put(str, objConvertToJSValue$default);
        }
        return linkedHashMap;
    }

    public static final WritableMap toJSValue(Bundle bundle, JSTypeConverter.ContainerProvider containerProvider) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        WritableMap writableMapCreateMap = containerProvider.createMap();
        for (String str : bundle.keySet()) {
            Object objLegacyConvertToJSValue = JSTypeConverter.INSTANCE.legacyConvertToJSValue(bundle.get(str), containerProvider);
            Intrinsics.checkNotNull(str);
            putGeneric(writableMapCreateMap, str, objLegacyConvertToJSValue);
        }
        return writableMapCreateMap;
    }

    public static final <K, V> WritableMap toJSValue(Map<K, ? extends V> map, JSTypeConverter.ContainerProvider containerProvider) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        WritableMap writableMapCreateMap = containerProvider.createMap();
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            K key = entry.getKey();
            putGeneric(writableMapCreateMap, String.valueOf(key), JSTypeConverter.INSTANCE.legacyConvertToJSValue(entry.getValue(), containerProvider));
        }
        return writableMapCreateMap;
    }

    public static final <T> Collection<Object> toJSValueExperimental(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Collection<? extends T> collection2 = collection;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection2, 10));
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            arrayList.add(JSTypeConverter.convertToJSValue$default(JSTypeConverter.INSTANCE, it.next(), null, true, 2, null));
        }
        return arrayList;
    }

    public static final <T> WritableArray toJSValue(Collection<? extends T> collection, JSTypeConverter.ContainerProvider containerProvider) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        WritableArray writableArrayCreateArray = containerProvider.createArray();
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            putGeneric(writableArrayCreateArray, JSTypeConverter.INSTANCE.legacyConvertToJSValue(it.next(), containerProvider));
        }
        return writableArrayCreateArray;
    }

    public static final <T> WritableArray toJSValue(T[] tArr, JSTypeConverter.ContainerProvider containerProvider) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        WritableArray writableArrayCreateArray = containerProvider.createArray();
        for (T t : tArr) {
            putGeneric(writableArrayCreateArray, JSTypeConverter.INSTANCE.legacyConvertToJSValue(t, containerProvider));
        }
        return writableArrayCreateArray;
    }

    public static final WritableArray toJSValue(int[] iArr, JSTypeConverter.ContainerProvider containerProvider) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        WritableArray writableArrayCreateArray = containerProvider.createArray();
        for (int i : iArr) {
            writableArrayCreateArray.pushInt(i);
        }
        return writableArrayCreateArray;
    }

    public static final WritableArray toJSValue(float[] fArr, JSTypeConverter.ContainerProvider containerProvider) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        WritableArray writableArrayCreateArray = containerProvider.createArray();
        for (float f : fArr) {
            writableArrayCreateArray.pushDouble(f);
        }
        return writableArrayCreateArray;
    }

    public static final WritableArray toJSValue(double[] dArr, JSTypeConverter.ContainerProvider containerProvider) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        WritableArray writableArrayCreateArray = containerProvider.createArray();
        for (double d : dArr) {
            writableArrayCreateArray.pushDouble(d);
        }
        return writableArrayCreateArray;
    }

    public static final WritableArray toJSValue(boolean[] zArr, JSTypeConverter.ContainerProvider containerProvider) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        WritableArray writableArrayCreateArray = containerProvider.createArray();
        for (boolean z : zArr) {
            writableArrayCreateArray.pushBoolean(z);
        }
        return writableArrayCreateArray;
    }

    public static final Object toJSValue(Enum<?> r4) {
        Object next;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        KFunction primaryConstructor = KClasses.getPrimaryConstructor(Reflection.getOrCreateKotlinClass(r4.getClass()));
        if (primaryConstructor == null) {
            throw new IllegalArgumentException("Cannot convert enum without the primary constructor to js value".toString());
        }
        if (primaryConstructor.getParameters().isEmpty()) {
            return r4.name();
        }
        if (primaryConstructor.getParameters().size() == 1) {
            String name = ((KParameter) CollectionsKt.first((List) primaryConstructor.getParameters())).getName();
            Intrinsics.checkNotNull(name);
            Iterator it = KClasses.getDeclaredMemberProperties(Reflection.getOrCreateKotlinClass(r4.getClass())).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(((KProperty1) next).getName(), name)) {
                    break;
                }
            }
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.reflect.KProperty1<kotlin.Enum<*>, *>");
            return ((KProperty1) next).get(r4);
        }
        throw new IllegalStateException("Enum '" + r4.getClass() + "' cannot be used as return type (incompatible with JS)");
    }

    public static final String toJSValue(URL url) {
        Intrinsics.checkNotNullParameter(url, "<this>");
        String string = url.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final String toJSValue(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final String toJSValue(URI uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final String toJSValue(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }

    public static final WritableArray toJSValue(Pair<?, ?> pair, JSTypeConverter.ContainerProvider containerProvider) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        WritableArray writableArrayCreateArray = containerProvider.createArray();
        Object objLegacyConvertToJSValue = JSTypeConverter.INSTANCE.legacyConvertToJSValue(pair.getFirst(), containerProvider);
        Object objLegacyConvertToJSValue2 = JSTypeConverter.INSTANCE.legacyConvertToJSValue(pair.getSecond(), containerProvider);
        putGeneric(writableArrayCreateArray, objLegacyConvertToJSValue);
        putGeneric(writableArrayCreateArray, objLegacyConvertToJSValue2);
        return writableArrayCreateArray;
    }

    public static final void putGeneric(WritableMap writableMap, String key, Object obj) {
        Intrinsics.checkNotNullParameter(writableMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (obj == null ? true : obj instanceof Unit) {
            writableMap.putNull(key);
            return;
        }
        if (obj instanceof ReadableArray) {
            writableMap.putArray(key, (ReadableArray) obj);
            return;
        }
        if (obj instanceof ReadableMap) {
            writableMap.putMap(key, (ReadableMap) obj);
            return;
        }
        if (obj instanceof String) {
            writableMap.putString(key, (String) obj);
            return;
        }
        if (obj instanceof Integer) {
            writableMap.putInt(key, ((Number) obj).intValue());
        } else if (obj instanceof Number) {
            writableMap.putDouble(key, ((Number) obj).doubleValue());
        } else {
            if (!(obj instanceof Boolean)) {
                throw new IllegalArgumentException("Could not put '" + obj.getClass() + "' to WritableMap");
            }
            writableMap.putBoolean(key, ((Boolean) obj).booleanValue());
        }
    }

    public static final void putGeneric(WritableArray writableArray, Object obj) {
        Intrinsics.checkNotNullParameter(writableArray, "<this>");
        if (obj == null ? true : obj instanceof Unit) {
            writableArray.pushNull();
            return;
        }
        if (obj instanceof ReadableArray) {
            writableArray.pushArray((ReadableArray) obj);
            return;
        }
        if (obj instanceof ReadableMap) {
            writableArray.pushMap((ReadableMap) obj);
            return;
        }
        if (obj instanceof String) {
            writableArray.pushString((String) obj);
            return;
        }
        if (obj instanceof Integer) {
            writableArray.pushInt(((Number) obj).intValue());
        } else if (obj instanceof Number) {
            writableArray.pushDouble(((Number) obj).doubleValue());
        } else {
            if (!(obj instanceof Boolean)) {
                throw new IllegalArgumentException("Could not put '" + obj.getClass() + "' to WritableArray");
            }
            writableArray.pushBoolean(((Boolean) obj).booleanValue());
        }
    }

    public static final <K, V> Map<String, Object> toJSValueExperimental(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            arrayList.add(TuplesKt.to(String.valueOf(entry.getKey()), JSTypeConverter.convertToJSValue$default(JSTypeConverter.INSTANCE, entry.getValue(), null, true, 2, null)));
        }
        return MapsKt.toMap(arrayList);
    }
}
