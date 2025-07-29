package expo.modules.imagepicker;

import android.net.Uri;
import com.facebook.imagepipeline.common.RotationOptions;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AsyncFunctionBuilder.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0005H\u008a@¨\u0006\u0006"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;", "it", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$Coroutine$5", f = "ImagePickerModule.kt", i = {}, l = {RotationOptions.ROTATE_270}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class ImagePickerModule$definition$lambda$7$$inlined$Coroutine$5 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    int label;
    final /* synthetic */ ImagePickerModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePickerModule$definition$lambda$7$$inlined$Coroutine$5(Continuation continuation, ImagePickerModule imagePickerModule) {
        super(3, continuation);
        this.this$0 = imagePickerModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        return new ImagePickerModule$definition$lambda$7$$inlined$Coroutine$5(continuation, this.this$0).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException, SecurityException, FailedToCreateFileException, IllegalArgumentException, FailedToDeduceTypeException, FailedToExtractVideoMetadataException {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PendingMediaPickingResult pendingMediaPickingResult = this.this$0.pendingMediaPickingResult;
            if (pendingMediaPickingResult == null) {
                return null;
            }
            List<Pair<MediaType, Uri>> listComponent1 = pendingMediaPickingResult.component1();
            ImagePickerOptions options = pendingMediaPickingResult.getOptions();
            this.this$0.pendingMediaPickingResult = null;
            MediaHandler mediaHandler = this.this$0.mediaHandler;
            this.label = 1;
            obj = mediaHandler.readExtras$expo_image_picker_release(listComponent1, options, this);
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
