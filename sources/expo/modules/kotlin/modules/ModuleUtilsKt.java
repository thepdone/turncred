package expo.modules.kotlin.modules;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;

/* compiled from: ModuleUtils.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\u001a)\u0010\u0000\u001a\u00020\u0001\"\u0012\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u0000¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"convertEnumToString", "", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/types/Enumerable;", "", "enumValue", "(Ljava/lang/Enum;)Ljava/lang/String;", "expo-modules-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ModuleUtilsKt {
    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Enum<TT;>;:Lexpo/modules/kotlin/types/Enumerable;>(TT;)Ljava/lang/String; */
    public static final String convertEnumToString(Enum enumValue) {
        List<KParameter> parameters;
        Object next;
        Intrinsics.checkNotNullParameter(enumValue, "enumValue");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(enumValue.getClass());
        KFunction primaryConstructor = KClasses.getPrimaryConstructor(orCreateKotlinClass);
        if (primaryConstructor != null && (parameters = primaryConstructor.getParameters()) != null && parameters.size() == 1) {
            String name = ((KParameter) CollectionsKt.first((List) primaryConstructor.getParameters())).getName();
            Iterator it = KClasses.getDeclaredMemberProperties(orCreateKotlinClass).iterator();
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
            KProperty1 kProperty1 = (KProperty1) next;
            if (kProperty1 == null) {
                throw new IllegalArgumentException(("Cannot find a property for " + name + " parameter").toString());
            }
            if (!Intrinsics.areEqual(kProperty1.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(String.class))) {
                throw new IllegalArgumentException("The enum parameter has to be a string.".toString());
            }
            return (String) kProperty1.get(enumValue);
        }
        return enumValue.name();
    }
}
