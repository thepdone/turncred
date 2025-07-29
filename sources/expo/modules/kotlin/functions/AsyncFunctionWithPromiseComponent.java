package expo.modules.kotlin.functions;

import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.types.AnyType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AsyncFunctionWithPromiseComponent.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012@\u0010\u0007\u001a<\u0012\u001d\u0012\u001b\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\f\b\n\u0012\b\b\u0002\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\n\u0012\b\b\u0002\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\b¢\u0006\u0002\u0010\u000fJ/\u0010\u0010\u001a\u00020\u000e2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0010¢\u0006\u0004\b\u0013\u0010\u0014RH\u0010\u0007\u001a<\u0012\u001d\u0012\u001b\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\f\b\n\u0012\b\b\u0002\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\n\u0012\b\b\u0002\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lexpo/modules/kotlin/functions/AsyncFunctionWithPromiseComponent;", "Lexpo/modules/kotlin/functions/AsyncFunction;", "name", "", "desiredArgsTypes", "", "Lexpo/modules/kotlin/types/AnyType;", "body", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "args", "Lexpo/modules/kotlin/Promise;", BaseJavaModule.METHOD_TYPE_PROMISE, "", "(Ljava/lang/String;[Lexpo/modules/kotlin/types/AnyType;Lkotlin/jvm/functions/Function2;)V", "callUserImplementation", "appContext", "Lexpo/modules/kotlin/AppContext;", "callUserImplementation$expo_modules_core_release", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;Lexpo/modules/kotlin/AppContext;)V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AsyncFunctionWithPromiseComponent extends AsyncFunction {
    public static final int $stable = 0;
    private final Function2<Object[], Promise, Unit> body;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AsyncFunctionWithPromiseComponent(String name, AnyType[] desiredArgsTypes, Function2<? super Object[], ? super Promise, Unit> body) {
        super(name, desiredArgsTypes);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desiredArgsTypes, "desiredArgsTypes");
        Intrinsics.checkNotNullParameter(body, "body");
        this.body = body;
    }

    @Override // expo.modules.kotlin.functions.AsyncFunction
    public void callUserImplementation$expo_modules_core_release(Object[] args, Promise promise, AppContext appContext) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.body.invoke(convertArgs(args, appContext), promise);
    }
}
