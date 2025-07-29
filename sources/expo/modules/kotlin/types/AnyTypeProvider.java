package expo.modules.kotlin.types;

import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import expo.modules.core.arguments.ReadableArguments;
import expo.modules.kotlin.jni.JavaScriptObject;
import expo.modules.kotlin.jni.JavaScriptValue;
import expo.modules.kotlin.typedarray.BigInt64Array;
import expo.modules.kotlin.typedarray.BigUint64Array;
import expo.modules.kotlin.typedarray.Float32Array;
import expo.modules.kotlin.typedarray.Float64Array;
import expo.modules.kotlin.typedarray.Int16Array;
import expo.modules.kotlin.typedarray.Int32Array;
import expo.modules.kotlin.typedarray.Int8Array;
import expo.modules.kotlin.typedarray.TypedArray;
import expo.modules.kotlin.typedarray.Uint16Array;
import expo.modules.kotlin.typedarray.Uint32Array;
import expo.modules.kotlin.typedarray.Uint8Array;
import expo.modules.kotlin.typedarray.Uint8ClampedArray;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: AnyType.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\f\u001a\u0004\u0018\u00010\b\"\u0006\b\u0000\u0010\r\u0018\u0001H\u0086\bR8\u0010\u0003\u001a\u001e\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0004\u0012\u00020\b0\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lexpo/modules/kotlin/types/AnyTypeProvider;", "", "()V", "typesMap", "", "Lkotlin/Pair;", "Lkotlin/reflect/KClass;", "", "Lexpo/modules/kotlin/types/AnyType;", "getTypesMap$annotations", "getTypesMap", "()Ljava/util/Map;", "cachedAnyType", ExifInterface.GPS_DIRECTION_TRUE, "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AnyTypeProvider {
    public static final int $stable;
    public static final AnyTypeProvider INSTANCE = new AnyTypeProvider();
    private static final Map<Pair<KClass<?>, Boolean>, AnyType> typesMap;

    public static /* synthetic */ void getTypesMap$annotations() {
    }

    private AnyTypeProvider() {
    }

    static {
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        for (KClass kClass : CollectionsKt.listOf((Object[]) new KClass[]{Reflection.getOrCreateKotlinClass(Integer.TYPE), Reflection.getOrCreateKotlinClass(Float.TYPE), Reflection.getOrCreateKotlinClass(Double.TYPE), Reflection.getOrCreateKotlinClass(Long.TYPE), Reflection.getOrCreateKotlinClass(Boolean.TYPE), Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(byte[].class), Reflection.getOrCreateKotlinClass(long[].class), Reflection.getOrCreateKotlinClass(int[].class), Reflection.getOrCreateKotlinClass(boolean[].class), Reflection.getOrCreateKotlinClass(float[].class), Reflection.getOrCreateKotlinClass(double[].class), Reflection.getOrCreateKotlinClass(JavaScriptValue.class), Reflection.getOrCreateKotlinClass(JavaScriptObject.class), Reflection.getOrCreateKotlinClass(TypedArray.class), Reflection.getOrCreateKotlinClass(Int8Array.class), Reflection.getOrCreateKotlinClass(Int16Array.class), Reflection.getOrCreateKotlinClass(Int32Array.class), Reflection.getOrCreateKotlinClass(Uint8Array.class), Reflection.getOrCreateKotlinClass(Uint8ClampedArray.class), Reflection.getOrCreateKotlinClass(Uint16Array.class), Reflection.getOrCreateKotlinClass(Uint32Array.class), Reflection.getOrCreateKotlinClass(Float32Array.class), Reflection.getOrCreateKotlinClass(Float64Array.class), Reflection.getOrCreateKotlinClass(BigInt64Array.class), Reflection.getOrCreateKotlinClass(BigUint64Array.class), Reflection.getOrCreateKotlinClass(ReadableArray.class), Reflection.getOrCreateKotlinClass(ReadableMap.class), Reflection.getOrCreateKotlinClass(URL.class), Reflection.getOrCreateKotlinClass(Uri.class), Reflection.getOrCreateKotlinClass(URI.class), Reflection.getOrCreateKotlinClass(File.class), Reflection.getOrCreateKotlinClass(Object.class), Reflection.getOrCreateKotlinClass(Unit.class), Reflection.getOrCreateKotlinClass(ReadableArguments.class)})) {
            mapCreateMapBuilder.put(TuplesKt.to(kClass, false), new AnyType(new EmptyKType(kClass, false)));
            mapCreateMapBuilder.put(TuplesKt.to(kClass, true), new AnyType(new EmptyKType(kClass, true)));
        }
        typesMap = MapsKt.build(mapCreateMapBuilder);
        $stable = 8;
    }

    public final Map<Pair<KClass<?>, Boolean>, AnyType> getTypesMap() {
        return typesMap;
    }

    public final /* synthetic */ <T> AnyType cachedAnyType() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        return getTypesMap().get(new Pair(orCreateKotlinClass, false));
    }
}
