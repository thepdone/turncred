package expo.modules.kotlin.activityresult;

import androidx.activity.result.ActivityResultCallback;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* compiled from: AppContextActivityResultLauncher.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0016\u0010\n\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010\fJ#\u0010\n\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fH&¢\u0006\u0002\u0010\u0010R\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lexpo/modules/kotlin/activityresult/AppContextActivityResultLauncher;", "I", "Ljava/io/Serializable;", "O", "", "()V", "contract", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "getContract", "()Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "launch", "input", "(Ljava/io/Serializable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Landroidx/activity/result/ActivityResultCallback;", "(Ljava/io/Serializable;Landroidx/activity/result/ActivityResultCallback;)V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class AppContextActivityResultLauncher<I extends Serializable, O> {
    public static final int $stable = 0;

    public abstract AppContextActivityResultContract<I, O> getContract();

    public abstract void launch(I input, ActivityResultCallback<O> callback);

    public final Object launch(I i, Continuation<? super O> continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        launch((AppContextActivityResultLauncher<I, O>) i, new ActivityResultCallback() { // from class: expo.modules.kotlin.activityresult.AppContextActivityResultLauncher$launch$2$1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(O o) {
                Continuation<O> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m5937constructorimpl(o));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
