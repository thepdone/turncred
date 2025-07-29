package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: DurationTypeConverter.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J'\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Lexpo/modules/kotlin/types/DurationTypeConverter;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "Lkotlin/time/Duration;", "isOptional", "", "(Z)V", "convertFromAny", "value", "", "context", "Lexpo/modules/kotlin/AppContext;", "convertFromAny-3nIYWDw", "(Ljava/lang/Object;Lexpo/modules/kotlin/AppContext;)J", "convertFromDynamic", "Lcom/facebook/react/bridge/Dynamic;", "convertFromDynamic-3nIYWDw", "(Lcom/facebook/react/bridge/Dynamic;Lexpo/modules/kotlin/AppContext;)J", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DurationTypeConverter extends DynamicAwareTypeConverters<Duration> {
    public static final int $stable = 0;

    @Override // expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    public DurationTypeConverter(boolean z) {
        super(z);
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public /* bridge */ /* synthetic */ Duration convertFromAny(Object obj, AppContext appContext) {
        return Duration.m7276boximpl(m5764convertFromAny3nIYWDw(obj, appContext));
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public /* bridge */ /* synthetic */ Duration convertFromDynamic(Dynamic dynamic, AppContext appContext) {
        return Duration.m7276boximpl(m5765convertFromDynamic3nIYWDw(dynamic, appContext));
    }

    /* renamed from: convertFromDynamic-3nIYWDw, reason: not valid java name */
    public long m5765convertFromDynamic3nIYWDw(Dynamic value, AppContext context) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.getType() != ReadableType.Number) {
            throw new IllegalArgumentException("Expected a number, but received " + value.getType());
        }
        return DurationKt.toDuration(value.asDouble(), DurationUnit.SECONDS);
    }

    /* renamed from: convertFromAny-3nIYWDw, reason: not valid java name */
    public long m5764convertFromAny3nIYWDw(Object value, AppContext context) {
        Intrinsics.checkNotNullParameter(value, "value");
        return DurationKt.toDuration(((Double) value).doubleValue(), DurationUnit.SECONDS);
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    /* renamed from: getCppRequiredTypes */
    public ExpectedType get$cppRequireType() {
        return new ExpectedType(CppType.DOUBLE);
    }
}
