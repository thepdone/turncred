package expo.modules.kotlin.functions;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.UtilsKt;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JNIAsyncFunctionBody;
import expo.modules.kotlin.jni.PromiseImpl;
import expo.modules.kotlin.jni.decorators.JSDecoratorsBridgingObject;
import expo.modules.kotlin.types.AnyType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SuspendFunctionComponent.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012H\u0010\u0007\u001aD\b\u0001\u0012\u0004\u0012\u00020\t\u0012\u001d\u0012\u001b\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\u0005¢\u0006\f\b\u000b\u0012\b\b\u0002\u0012\u0004\b\b(\f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\r\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fJ \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003H\u0016RR\u0010\u0007\u001aD\b\u0001\u0012\u0004\u0012\u00020\t\u0012\u001d\u0012\u001b\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\u0005¢\u0006\f\b\u000b\u0012\b\b\u0002\u0012\u0004\b\b(\f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\r\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\u0002\b\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u0018"}, d2 = {"Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;", "name", "", "desiredArgsTypes", "", "Lexpo/modules/kotlin/types/AnyType;", "body", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "", "Lkotlin/ParameterName;", "args", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;[Lexpo/modules/kotlin/types/AnyType;Lkotlin/jvm/functions/Function3;)V", "Lkotlin/jvm/functions/Function3;", "attachToJSObject", "", "appContext", "Lexpo/modules/kotlin/AppContext;", "jsObject", "Lexpo/modules/kotlin/jni/decorators/JSDecoratorsBridgingObject;", "moduleName", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SuspendFunctionComponent extends BaseAsyncFunctionComponent {
    public static final int $stable = 8;
    private final Function3<CoroutineScope, Object[], Continuation<Object>, Object> body;

    /* compiled from: SuspendFunctionComponent.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Queues.values().length];
            try {
                iArr[Queues.MAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Queues.DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SuspendFunctionComponent(String name, AnyType[] desiredArgsTypes, Function3<? super CoroutineScope, ? super Object[], ? super Continuation<Object>, ? extends Object> body) {
        super(name, desiredArgsTypes);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desiredArgsTypes, "desiredArgsTypes");
        Intrinsics.checkNotNullParameter(body, "body");
        this.body = body;
    }

    @Override // expo.modules.kotlin.functions.AnyFunction
    public void attachToJSObject(final AppContext appContext, JSDecoratorsBridgingObject jsObject, final String moduleName) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(jsObject, "jsObject");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        final WeakReference weakReferenceWeak = UtilsKt.weak(appContext);
        String name = getName();
        boolean takesOwner$expo_modules_core_release = getTakesOwner$expo_modules_core_release();
        boolean zIsEnumerable$expo_modules_core_release = getIsEnumerable();
        AnyType[] desiredArgsTypes = getDesiredArgsTypes();
        ArrayList arrayList = new ArrayList(desiredArgsTypes.length);
        for (AnyType anyType : desiredArgsTypes) {
            arrayList.add(anyType.getCppRequiredTypes());
        }
        jsObject.registerAsyncFunction(name, takesOwner$expo_modules_core_release, zIsEnumerable$expo_modules_core_release, (ExpectedType[]) arrayList.toArray(new ExpectedType[0]), new JNIAsyncFunctionBody() { // from class: expo.modules.kotlin.functions.SuspendFunctionComponent$$ExternalSyntheticLambda0
            @Override // expo.modules.kotlin.jni.JNIAsyncFunctionBody
            public final void invoke(Object[] objArr, PromiseImpl promiseImpl) {
                SuspendFunctionComponent.attachToJSObject$lambda$1(weakReferenceWeak, moduleName, this, appContext, objArr, promiseImpl);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void attachToJSObject$lambda$1(WeakReference appContextHolder, String moduleName, SuspendFunctionComponent this$0, AppContext appContext, Object[] args, PromiseImpl promiseImpl) {
        CoroutineScope mainQueue;
        Intrinsics.checkNotNullParameter(appContextHolder, "$appContextHolder");
        Intrinsics.checkNotNullParameter(moduleName, "$moduleName");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appContext, "$appContext");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(promiseImpl, "promiseImpl");
        int i = WhenMappings.$EnumSwitchMapping$0[this$0.getQueue().ordinal()];
        if (i == 1) {
            mainQueue = appContext.getMainQueue();
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            mainQueue = appContext.getModulesQueue();
        }
        BuildersKt__Builders_commonKt.launch$default(mainQueue, null, null, new SuspendFunctionComponent$attachToJSObject$2$1(promiseImpl, this$0, moduleName, args, appContext, null), 3, null);
    }
}
