package expo.modules.camera.analyzers;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: MLKitBarcodeAnalyzer.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"await", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/android/gms/tasks/Task;", "(Lcom/google/android/gms/tasks/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-camera_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MLKitBarcodeAnalyzerKt {
    public static final <T> Object await(Task<T> task, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final Function1<T, Unit> function1 = new Function1<T, Unit>() { // from class: expo.modules.camera.analyzers.MLKitBarcodeAnalyzerKt$await$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2((MLKitBarcodeAnalyzerKt$await$2$1<T>) obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(T t) {
                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m5937constructorimpl(t));
            }
        };
        task.addOnSuccessListener(new OnSuccessListener(function1) { // from class: expo.modules.camera.analyzers.MLKitBarcodeAnalyzerKt$sam$com_google_android_gms_tasks_OnSuccessListener$0
            private final /* synthetic */ Function1 function;

            {
                Intrinsics.checkNotNullParameter(function1, "function");
                this.function = function1;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final /* synthetic */ void onSuccess(Object obj) {
                this.function.invoke(obj);
            }
        });
        task.addOnFailureListener(new OnFailureListener() { // from class: expo.modules.camera.analyzers.MLKitBarcodeAnalyzerKt$await$2$2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                Continuation continuation2 = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m5937constructorimpl(ResultKt.createFailure(exception)));
            }
        });
        task.addOnCanceledListener(new OnCanceledListener() { // from class: expo.modules.camera.analyzers.MLKitBarcodeAnalyzerKt$await$2$3
            @Override // com.google.android.gms.tasks.OnCanceledListener
            public final void onCanceled() {
                CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuationImpl2, null, 1, null);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
