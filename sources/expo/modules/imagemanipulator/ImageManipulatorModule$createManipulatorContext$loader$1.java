package expo.modules.imagemanipulator;

import android.graphics.Bitmap;
import android.net.Uri;
import expo.modules.interfaces.imageloader.ImageLoaderInterface;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.UnexpectedException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: ImageManipulatorModule.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.imagemanipulator.ImageManipulatorModule$createManipulatorContext$loader$1", f = "ImageManipulatorModule.kt", i = {0}, l = {150}, m = "invokeSuspend", n = {"imageLoader"}, s = {"L$0"})
/* loaded from: classes5.dex */
final class ImageManipulatorModule$createManipulatorContext$loader$1 extends SuspendLambda implements Function1<Continuation<? super Bitmap>, Object> {
    final /* synthetic */ Uri $url;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ImageManipulatorModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ImageManipulatorModule$createManipulatorContext$loader$1(ImageManipulatorModule imageManipulatorModule, Uri uri, Continuation<? super ImageManipulatorModule$createManipulatorContext$loader$1> continuation) {
        super(1, continuation);
        this.this$0 = imageManipulatorModule;
        this.$url = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ImageManipulatorModule$createManipulatorContext$loader$1(this.this$0, this.$url, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Bitmap> continuation) {
        return ((ImageManipulatorModule$createManipulatorContext$loader$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws ImageLoaderNotFoundException {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ImageLoaderInterface imageLoader = this.this$0.getAppContext().getImageLoader();
            if (imageLoader == null) {
                throw new ImageLoaderNotFoundException();
            }
            final Uri uri = this.$url;
            this.L$0 = imageLoader;
            this.L$1 = uri;
            this.label = 1;
            ImageManipulatorModule$createManipulatorContext$loader$1 imageManipulatorModule$createManipulatorContext$loader$1 = this;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(imageManipulatorModule$createManipulatorContext$loader$1), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            imageLoader.loadImageForManipulationFromURL(uri.toString(), new ImageLoaderInterface.ResultListener() { // from class: expo.modules.imagemanipulator.ImageManipulatorModule$createManipulatorContext$loader$1$1$1
                @Override // expo.modules.interfaces.imageloader.ImageLoaderInterface.ResultListener
                public void onSuccess(Bitmap bitmap) {
                    Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                    CancellableContinuation<Bitmap> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m5937constructorimpl(bitmap));
                }

                @Override // expo.modules.interfaces.imageloader.ImageLoaderInterface.ResultListener
                public void onFailure(Throwable cause) {
                    UnexpectedException unexpectedException;
                    CancellableContinuation<Bitmap> cancellableContinuation = cancellableContinuationImpl2;
                    String string = uri.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    if (cause == null) {
                        unexpectedException = new UnexpectedException("Unknown error");
                    } else if (cause instanceof CodedException) {
                        unexpectedException = (CodedException) cause;
                    } else if (cause instanceof expo.modules.core.errors.CodedException) {
                        String code = ((expo.modules.core.errors.CodedException) cause).getCode();
                        Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                        unexpectedException = new CodedException(code, cause.getMessage(), cause.getCause());
                    } else {
                        unexpectedException = new UnexpectedException(cause);
                    }
                    ImageLoadingFailedException imageLoadingFailedException = new ImageLoadingFailedException(string, unexpectedException);
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m5937constructorimpl(ResultKt.createFailure(imageLoadingFailedException)));
                }
            });
            obj = cancellableContinuationImpl.getResult();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(imageManipulatorModule$createManipulatorContext$loader$1);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
