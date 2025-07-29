package kotlin.reflect.jvm.internal.impl.types;

import com.nimbusds.jose.jwk.gen.OctetSequenceKeyGenerator;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.text.StringsKt;

/* compiled from: KotlinType.kt */
/* loaded from: classes5.dex */
public abstract class SimpleType extends UnwrappedType implements SimpleTypeMarker, TypeArgumentListMarker {
    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public abstract SimpleType makeNullableAsSpecified(boolean z);

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public abstract SimpleType replaceAttributes(TypeAttributes typeAttributes);

    public SimpleType() {
        super(null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<AnnotationDescriptor> it = getAnnotations().iterator();
        while (it.hasNext()) {
            StringsKt.append(sb, "[", DescriptorRenderer.renderAnnotation$default(DescriptorRenderer.DEBUG_TEXT, it.next(), null, 2, null), "] ");
        }
        sb.append(getConstructor());
        if (!getArguments().isEmpty()) {
            CollectionsKt.joinTo(getArguments(), sb, (OctetSequenceKeyGenerator.MIN_KEY_SIZE_BITS & 2) != 0 ? ", " : ", ", (OctetSequenceKeyGenerator.MIN_KEY_SIZE_BITS & 4) != 0 ? "" : "<", (OctetSequenceKeyGenerator.MIN_KEY_SIZE_BITS & 8) != 0 ? "" : ">", (OctetSequenceKeyGenerator.MIN_KEY_SIZE_BITS & 16) != 0 ? -1 : 0, (OctetSequenceKeyGenerator.MIN_KEY_SIZE_BITS & 32) != 0 ? "..." : null, (OctetSequenceKeyGenerator.MIN_KEY_SIZE_BITS & 64) != 0 ? null : null);
        }
        if (isMarkedNullable()) {
            sb.append("?");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
