package expo.modules.kotlin.types;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Either.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lexpo/modules/kotlin/types/ConvertedValue;", "Lexpo/modules/kotlin/types/DeferredValue;", "convertedValue", "", "(Ljava/lang/Object;)V", "getConvertedValue", "()Ljava/lang/Object;", "component1", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConvertedValue extends DeferredValue {
    public static final int $stable = 8;
    private final Object convertedValue;

    public static /* synthetic */ ConvertedValue copy$default(ConvertedValue convertedValue, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = convertedValue.convertedValue;
        }
        return convertedValue.copy(obj);
    }

    /* renamed from: component1, reason: from getter */
    public final Object getConvertedValue() {
        return this.convertedValue;
    }

    public final ConvertedValue copy(Object convertedValue) {
        Intrinsics.checkNotNullParameter(convertedValue, "convertedValue");
        return new ConvertedValue(convertedValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ConvertedValue) && Intrinsics.areEqual(this.convertedValue, ((ConvertedValue) other).convertedValue);
    }

    public int hashCode() {
        return this.convertedValue.hashCode();
    }

    public String toString() {
        return "ConvertedValue(convertedValue=" + this.convertedValue + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConvertedValue(Object convertedValue) {
        super(null);
        Intrinsics.checkNotNullParameter(convertedValue, "convertedValue");
        this.convertedValue = convertedValue;
    }

    public final Object getConvertedValue() {
        return this.convertedValue;
    }
}
