package expo.modules.kotlin.types;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.AppContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypeConverter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000bJ\u001f\u0010\f\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000eJ\u001f\u0010\u000f\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\u0010"}, d2 = {"Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lexpo/modules/kotlin/types/NullAwareTypeConverter;", "isOptional", "", "(Z)V", "convertFromAny", "value", "context", "Lexpo/modules/kotlin/AppContext;", "(Ljava/lang/Object;Lexpo/modules/kotlin/AppContext;)Ljava/lang/Object;", "convertFromDynamic", "Lcom/facebook/react/bridge/Dynamic;", "(Lcom/facebook/react/bridge/Dynamic;Lexpo/modules/kotlin/AppContext;)Ljava/lang/Object;", "convertNonOptional", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class DynamicAwareTypeConverters<T> extends NullAwareTypeConverter<T> {
    public static final int $stable = 0;

    public abstract T convertFromAny(Object value, AppContext context);

    public abstract T convertFromDynamic(Dynamic value, AppContext context);

    public DynamicAwareTypeConverters(boolean z) {
        super(z);
    }

    @Override // expo.modules.kotlin.types.NullAwareTypeConverter
    public T convertNonOptional(Object value, AppContext context) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value instanceof Dynamic) {
            return convertFromDynamic((Dynamic) value, context);
        }
        return convertFromAny(value, context);
    }
}
