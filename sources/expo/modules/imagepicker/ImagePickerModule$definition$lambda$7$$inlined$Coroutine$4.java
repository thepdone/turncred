package expo.modules.imagepicker;

import expo.modules.imagepicker.contracts.ImageLibraryContractOptions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AsyncFunctionBuilder.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001*\u00020\u00042\u0010\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0006H\u008a@¨\u0006\u0007"}, d2 = {"<anonymous>", "", "R", "P0", "Lkotlinx/coroutines/CoroutineScope;", "<name for destructuring parameter 0>", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$3"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$Coroutine$4", f = "ImagePickerModule.kt", i = {}, l = {271}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class ImagePickerModule$definition$lambda$7$$inlined$Coroutine$4 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ImagePickerModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePickerModule$definition$lambda$7$$inlined$Coroutine$4(Continuation continuation, ImagePickerModule imagePickerModule) {
        super(3, continuation);
        this.this$0 = imagePickerModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        ImagePickerModule$definition$lambda$7$$inlined$Coroutine$4 imagePickerModule$definition$lambda$7$$inlined$Coroutine$4 = new ImagePickerModule$definition$lambda$7$$inlined$Coroutine$4(continuation, this.this$0);
        imagePickerModule$definition$lambda$7$$inlined$Coroutine$4.L$0 = objArr;
        return imagePickerModule$definition$lambda$7$$inlined$Coroutine$4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ImagePickerOptions imagePickerOptions = (ImagePickerOptions) ((Object[]) this.L$0)[0];
            ImageLibraryContractOptions imageLibraryContractOptions = imagePickerOptions.toImageLibraryContractOptions();
            ImagePickerModule imagePickerModule = this.this$0;
            ImagePickerModule$definition$1$6$1 imagePickerModule$definition$1$6$1 = new ImagePickerModule$definition$1$6$1(this.this$0, imageLibraryContractOptions, null);
            this.label = 1;
            obj = imagePickerModule.launchContract(imagePickerModule$definition$1$6$1, imagePickerOptions, this);
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
