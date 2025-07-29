package expo.modules.kotlin.types.io;

import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.types.DynamicAwareTypeConverters;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileTypeConverter.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"Lexpo/modules/kotlin/types/io/FileTypeConverter;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "Ljava/io/File;", "isOptional", "", "(Z)V", "convertFromAny", "value", "", "context", "Lexpo/modules/kotlin/AppContext;", "convertFromDynamic", "Lcom/facebook/react/bridge/Dynamic;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FileTypeConverter extends DynamicAwareTypeConverters<File> {
    public static final int $stable = 0;

    @Override // expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    public FileTypeConverter(boolean z) {
        super(z);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public File convertFromDynamic(Dynamic value, AppContext context) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new File(value.asString());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public File convertFromAny(Object value, AppContext context) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new File((String) value);
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    public ExpectedType getCppRequiredTypes() {
        return new ExpectedType(CppType.STRING);
    }
}
