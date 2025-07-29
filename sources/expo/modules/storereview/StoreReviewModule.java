package expo.modules.storereview;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.tracing.Trace;
import com.facebook.react.bridge.BaseJavaModule;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: StoreReviewModule.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lexpo/modules/storereview/StoreReviewModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "isPlayStoreInstalled", "", "requestReview", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "expo-store-review_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StoreReviewModule extends Module {
    private final Context getContext() throws Exceptions.ReactContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        StoreReviewModule storeReviewModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (storeReviewModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(storeReviewModule);
            moduleDefinitionBuilder.Name("ExpoStoreReview");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[0];
            Function1<Object[], Boolean> function1 = new Function1<Object[], Boolean>() { // from class: expo.modules.storereview.StoreReviewModule$definition$lambda$2$$inlined$AsyncFunction$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(this.this$0.isPlayStoreInstalled());
                }
            };
            if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                asyncFunctionComponent = new StringAsyncFunctionComponent("isAvailableAsync", anyTypeArr, function1);
                            } else {
                                asyncFunctionComponent = new AsyncFunctionComponent("isAvailableAsync", anyTypeArr, function1);
                            }
                        } else {
                            asyncFunctionComponent = new FloatAsyncFunctionComponent("isAvailableAsync", anyTypeArr, function1);
                        }
                    } else {
                        asyncFunctionComponent = new DoubleAsyncFunctionComponent("isAvailableAsync", anyTypeArr, function1);
                    }
                } else {
                    asyncFunctionComponent = new BoolAsyncFunctionComponent("isAvailableAsync", anyTypeArr, function1);
                }
            } else {
                asyncFunctionComponent = new IntAsyncFunctionComponent("isAvailableAsync", anyTypeArr, function1);
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("isAvailableAsync", asyncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("requestReview", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.storereview.StoreReviewModule$definition$lambda$2$$inlined$AsyncFunction$2
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        this.this$0.requestReview(promise);
                    }
                });
            } else {
                AnyType[] anyTypeArr2 = new AnyType[1];
                AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType == null) {
                    anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.storereview.StoreReviewModule$definition$lambda$2$$inlined$AsyncFunction$3
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Promise.class);
                        }
                    }));
                }
                anyTypeArr2[0] = anyType;
                Function1<Object[], Unit> function12 = new Function1<Object[], Unit>() { // from class: expo.modules.storereview.StoreReviewModule$definition$lambda$2$$inlined$AsyncFunction$4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        this.this$0.requestReview((Promise) objArr[0]);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent2 = new StringAsyncFunctionComponent("requestReview", anyTypeArr2, function12);
                                } else {
                                    asyncFunctionComponent2 = new AsyncFunctionComponent("requestReview", anyTypeArr2, function12);
                                }
                            } else {
                                asyncFunctionComponent2 = new FloatAsyncFunctionComponent("requestReview", anyTypeArr2, function12);
                            }
                        } else {
                            asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("requestReview", anyTypeArr2, function12);
                        }
                    } else {
                        asyncFunctionComponent2 = new BoolAsyncFunctionComponent("requestReview", anyTypeArr2, function12);
                    }
                } else {
                    asyncFunctionComponent2 = new IntAsyncFunctionComponent("requestReview", anyTypeArr2, function12);
                }
                asyncFunctionWithPromiseComponent = asyncFunctionComponent2;
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("requestReview", asyncFunctionWithPromiseComponent);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestReview(final Promise promise) {
        final ReviewManager reviewManagerCreate = ReviewManagerFactory.create(getContext());
        Intrinsics.checkNotNullExpressionValue(reviewManagerCreate, "create(...)");
        Task<ReviewInfo> taskRequestReviewFlow = reviewManagerCreate.requestReviewFlow();
        Intrinsics.checkNotNullExpressionValue(taskRequestReviewFlow, "requestReviewFlow(...)");
        taskRequestReviewFlow.addOnCompleteListener(new OnCompleteListener() { // from class: expo.modules.storereview.StoreReviewModule$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                StoreReviewModule.requestReview$lambda$5(promise, reviewManagerCreate, this, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestReview$lambda$5(final Promise promise, ReviewManager manager, StoreReviewModule this$0, Task task) {
        Task<Void> taskAddOnCompleteListener;
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(manager, "$manager");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            ReviewInfo reviewInfo = (ReviewInfo) task.getResult();
            if (reviewInfo != null) {
                Task<Void> taskLaunchReviewFlow = manager.launchReviewFlow(this$0.getAppContext().getThrowingActivity(), reviewInfo);
                Intrinsics.checkNotNullExpressionValue(taskLaunchReviewFlow, "launchReviewFlow(...)");
                taskAddOnCompleteListener = taskLaunchReviewFlow.addOnCompleteListener(new OnCompleteListener() { // from class: expo.modules.storereview.StoreReviewModule$$ExternalSyntheticLambda1
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task2) {
                        StoreReviewModule.requestReview$lambda$5$lambda$4$lambda$3(promise, task2);
                    }
                });
            } else {
                taskAddOnCompleteListener = null;
            }
            if (taskAddOnCompleteListener == null) {
                promise.reject(new RMTaskException());
                return;
            }
            return;
        }
        promise.reject(new RMUnsuccessfulTaskException());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestReview$lambda$5$lambda$4$lambda$3(Promise promise, Task result) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.isSuccessful()) {
            promise.resolve((Object) null);
        } else {
            promise.reject(new RMTaskException());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPlayStoreInstalled() throws PackageManager.NameNotFoundException {
        try {
            getContext().getPackageManager().getPackageInfo("com.android.vending", 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
