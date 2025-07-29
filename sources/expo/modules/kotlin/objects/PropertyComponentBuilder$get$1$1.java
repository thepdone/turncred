package expo.modules.kotlin.objects;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: PropertyComponentBuilder.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "R", "it", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 176)
/* loaded from: classes5.dex */
final class PropertyComponentBuilder$get$1$1 extends Lambda implements Function1<Object[], Object> {
    final /* synthetic */ Function0<R> $body;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PropertyComponentBuilder$get$1$1(Function0<? extends R> function0) {
        super(1);
        this.$body = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object[] it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this.$body.invoke();
    }
}
