package expo.modules.camera;

import android.os.Bundle;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CameraViewModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.camera.CameraViewModule$definition$1$7$17$1", f = "CameraViewModule.kt", i = {}, l = {280}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class CameraViewModule$definition$1$7$17$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $image;
    final /* synthetic */ PictureOptions $options;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ ExpoCameraView $view;
    int label;
    final /* synthetic */ CameraViewModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CameraViewModule$definition$1$7$17$1(byte[] bArr, Promise promise, PictureOptions pictureOptions, CameraViewModule cameraViewModule, ExpoCameraView expoCameraView, Continuation<? super CameraViewModule$definition$1$7$17$1> continuation) {
        super(2, continuation);
        this.$image = bArr;
        this.$promise = promise;
        this.$options = pictureOptions;
        this.this$0 = cameraViewModule;
        this.$view = expoCameraView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CameraViewModule$definition$1$7$17$1(this.$image, this.$promise, this.$options, this.this$0, this.$view, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CameraViewModule$definition$1$7$17$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            byte[] bArr = this.$image;
            Promise promise = this.$promise;
            PictureOptions pictureOptions = this.$options;
            File cacheDirectory = this.this$0.getCacheDirectory();
            final ExpoCameraView expoCameraView = this.$view;
            this.label = 1;
            if (new ResolveTakenPicture(bArr, promise, pictureOptions, false, cacheDirectory, new PictureSavedDelegate() { // from class: expo.modules.camera.CameraViewModule$definition$1$7$17$1.1
                @Override // expo.modules.camera.tasks.PictureSavedDelegate
                public final void onPictureSaved(Bundle response) {
                    Intrinsics.checkNotNullParameter(response, "response");
                    expoCameraView.onPictureSaved(response);
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
