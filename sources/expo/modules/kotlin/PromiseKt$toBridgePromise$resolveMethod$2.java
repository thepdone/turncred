package expo.modules.kotlin;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: Promise.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class PromiseKt$toBridgePromise$resolveMethod$2 extends FunctionReferenceImpl implements Function1<Object, Unit> {
    PromiseKt$toBridgePromise$resolveMethod$2(Object obj) {
        super(1, obj, Promise.class, "resolve", "resolve(Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke2(obj);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object obj) {
        ((Promise) this.receiver).resolve(obj);
    }
}
