package expo.modules.camera;

import android.os.Bundle;
import expo.modules.camera.records.CameraType;
import expo.modules.camera.tasks.PictureSavedDelegate;
import expo.modules.camera.tasks.ResolveTakenPicture;
import expo.modules.kotlin.Promise;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ExpoCameraView.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.camera.ExpoCameraView$takePicture$1$onCaptureSuccess$1$1", f = "ExpoCameraView.kt", i = {}, l = {296}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class ExpoCameraView$takePicture$1$onCaptureSuccess$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $data;
    final /* synthetic */ File $it;
    final /* synthetic */ PictureOptions $options;
    final /* synthetic */ Promise $promise;
    int label;
    final /* synthetic */ ExpoCameraView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExpoCameraView$takePicture$1$onCaptureSuccess$1$1(ExpoCameraView expoCameraView, byte[] bArr, Promise promise, PictureOptions pictureOptions, File file, Continuation<? super ExpoCameraView$takePicture$1$onCaptureSuccess$1$1> continuation) {
        super(2, continuation);
        this.this$0 = expoCameraView;
        this.$data = bArr;
        this.$promise = promise;
        this.$options = pictureOptions;
        this.$it = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExpoCameraView$takePicture$1$onCaptureSuccess$1$1(this.this$0, this.$data, this.$promise, this.$options, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ExpoCameraView$takePicture$1$onCaptureSuccess$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            boolean z = this.this$0.getMirror() && this.this$0.getLensFacing() == CameraType.FRONT;
            byte[] bArr = this.$data;
            Promise promise = this.$promise;
            PictureOptions pictureOptions = this.$options;
            File file = this.$it;
            final ExpoCameraView expoCameraView = this.this$0;
            this.label = 1;
            if (new ResolveTakenPicture(bArr, promise, pictureOptions, z, file, new PictureSavedDelegate() { // from class: expo.modules.camera.ExpoCameraView$takePicture$1$onCaptureSuccess$1$1$$ExternalSyntheticLambda0
                @Override // expo.modules.camera.tasks.PictureSavedDelegate
                public final void onPictureSaved(Bundle bundle) {
                    expoCameraView.onPictureSaved(bundle);
                }
            }).resolve(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
