package expo.modules.kotlin.functions;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.FunctionCallException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JNIFunctionBody;
import expo.modules.kotlin.jni.decorators.JSDecoratorsBridgingObject;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.ReturnType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SyncFunctionComponent.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BR\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012-\u0010\t\u001a)\u0012\u001d\u0012\u001b\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\u0005¢\u0006\f\b\f\u0012\b\b\u0002\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n¢\u0006\u0002\u0010\u000eJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J)\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0002\b\u001aR5\u0010\t\u001a)\u0012\u001d\u0012\u001b\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\u0005¢\u0006\f\b\f\u0012\b\b\u0002\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "Lexpo/modules/kotlin/functions/AnyFunction;", "name", "", "argTypes", "", "Lexpo/modules/kotlin/types/AnyType;", "returnType", "Lexpo/modules/kotlin/types/ReturnType;", "body", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "args", "(Ljava/lang/String;[Lexpo/modules/kotlin/types/AnyType;Lexpo/modules/kotlin/types/ReturnType;Lkotlin/jvm/functions/Function1;)V", "attachToJSObject", "", "appContext", "Lexpo/modules/kotlin/AppContext;", "jsObject", "Lexpo/modules/kotlin/jni/decorators/JSDecoratorsBridgingObject;", "moduleName", "callUserImplementation", "([Ljava/lang/Object;Lexpo/modules/kotlin/AppContext;)Ljava/lang/Object;", "getJNIFunctionBody", "Lexpo/modules/kotlin/jni/JNIFunctionBody;", "getJNIFunctionBody$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SyncFunctionComponent extends AnyFunction {
    public static final int $stable = 8;
    private final Function1<Object[], Object> body;
    private final ReturnType returnType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SyncFunctionComponent(String name, AnyType[] argTypes, ReturnType returnType, Function1<? super Object[], ? extends Object> body) {
        super(name, argTypes);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(argTypes, "argTypes");
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        Intrinsics.checkNotNullParameter(body, "body");
        this.returnType = returnType;
        this.body = body;
    }

    public static /* synthetic */ Object callUserImplementation$default(SyncFunctionComponent syncFunctionComponent, Object[] objArr, AppContext appContext, int i, Object obj) {
        if ((i & 2) != 0) {
            appContext = null;
        }
        return syncFunctionComponent.callUserImplementation(objArr, appContext);
    }

    public final Object callUserImplementation(Object[] args, AppContext appContext) {
        Intrinsics.checkNotNullParameter(args, "args");
        return this.body.invoke(convertArgs(args, appContext));
    }

    public final JNIFunctionBody getJNIFunctionBody$expo_modules_core_release(final String moduleName, final AppContext appContext) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        return new JNIFunctionBody() { // from class: expo.modules.kotlin.functions.SyncFunctionComponent$$ExternalSyntheticLambda0
            @Override // expo.modules.kotlin.jni.JNIFunctionBody
            public final Object invoke(Object[] objArr) {
                return SyncFunctionComponent.getJNIFunctionBody$lambda$2(this.f$0, moduleName, appContext, objArr);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getJNIFunctionBody$lambda$2(SyncFunctionComponent this$0, String moduleName, AppContext appContext, Object[] args) throws FunctionCallException {
        UnexpectedException unexpectedException;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(moduleName, "$moduleName");
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            return this$0.returnType.convertToJS(this$0.callUserImplementation(args, appContext));
        } catch (Throwable th) {
            if (th instanceof CodedException) {
                unexpectedException = (CodedException) th;
            } else if (th instanceof expo.modules.core.errors.CodedException) {
                String code = ((expo.modules.core.errors.CodedException) th).getCode();
                Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                unexpectedException = new CodedException(code, th.getMessage(), th.getCause());
            } else {
                unexpectedException = new UnexpectedException(th);
            }
            throw new FunctionCallException(this$0.getName(), moduleName, unexpectedException);
        }
    }

    @Override // expo.modules.kotlin.functions.AnyFunction
    public void attachToJSObject(AppContext appContext, JSDecoratorsBridgingObject jsObject, String moduleName) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(jsObject, "jsObject");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        jsObject.registerSyncFunction(getName(), getTakesOwner$expo_modules_core_release(), getIsEnumerable(), (ExpectedType[]) getCppRequiredTypes$expo_modules_core_release().toArray(new ExpectedType[0]), getJNIFunctionBody$expo_modules_core_release(moduleName, appContext));
    }
}
