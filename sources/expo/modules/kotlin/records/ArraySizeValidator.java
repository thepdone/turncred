package expo.modules.kotlin.records;

import expo.modules.kotlin.exception.ValidationException;
import io.sentry.protocol.MetricSummary;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FieldValidator.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0002\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lexpo/modules/kotlin/records/ArraySizeValidator;", "Lexpo/modules/kotlin/records/FieldValidator;", "", MetricSummary.JsonKeys.MIN, "", MetricSummary.JsonKeys.MAX, "(II)V", "validate", "", "value", "([Ljava/lang/Object;)V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ArraySizeValidator implements FieldValidator<Object[]> {
    public static final int $stable = 0;
    private final int max;
    private final int min;

    public ArraySizeValidator(int i, int i2) {
        this.min = i;
        this.max = i2;
    }

    @Override // expo.modules.kotlin.records.FieldValidator
    public void validate(Object[] value) throws ValidationException {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.length < this.min || value.length > this.max) {
            throw new ValidationException("Number of elements in the array should be between " + this.min + " and " + this.max + ", got " + value.length);
        }
    }
}
