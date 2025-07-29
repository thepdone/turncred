package expo.modules.imagemanipulator;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* compiled from: AsyncFunctionBuilder.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001*\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007H\u008a@¨\u0006\b"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "Lkotlinx/coroutines/CoroutineScope;", "<name for destructuring parameter 0>", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$5"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.imagemanipulator.ImageManipulatorModule$definition$lambda$13$lambda$12$$inlined$Coroutine$3", f = "ImageManipulatorModule.kt", i = {0, 0, 0}, l = {277}, m = "invokeSuspend", n = {"path", "resultBitmap", "base64String"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes5.dex */
public final class ImageManipulatorModule$definition$lambda$13$lambda$12$$inlined$Coroutine$3 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ImageManipulatorModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageManipulatorModule$definition$lambda$13$lambda$12$$inlined$Coroutine$3(Continuation continuation, ImageManipulatorModule imageManipulatorModule) {
        super(3, continuation);
        this.this$0 = imageManipulatorModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        ImageManipulatorModule$definition$lambda$13$lambda$12$$inlined$Coroutine$3 imageManipulatorModule$definition$lambda$13$lambda$12$$inlined$Coroutine$3 = new ImageManipulatorModule$definition$lambda$13$lambda$12$$inlined$Coroutine$3(continuation, this.this$0);
        imageManipulatorModule$definition$lambda$13$lambda$12$$inlined$Coroutine$3.L$0 = objArr;
        return imageManipulatorModule$definition$lambda$13$lambda$12$$inlined$Coroutine$3.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws ImageWriteFailedException, IOException {
        Ref.ObjectRef objectRef;
        String str;
        Bitmap bitmap;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object[] objArr = (Object[]) this.L$0;
            Object obj2 = objArr[0];
            ManipulateOptions manipulateOptions = (ManipulateOptions) objArr[1];
            ImageRef imageRef = (ImageRef) obj2;
            if (manipulateOptions == null) {
                manipulateOptions = new ManipulateOptions();
            }
            ManipulateOptions manipulateOptions2 = manipulateOptions;
            String strGenerateRandomOutputPath = FileUtils.INSTANCE.generateRandomOutputPath(this.this$0.getContext(), manipulateOptions2.getFormat());
            int compress = (int) (manipulateOptions2.getCompress() * 100);
            Bitmap ref = imageRef.getRef();
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(this.this$0.getAppContext().getBackgroundCoroutineScope(), null, null, new ImageManipulatorModule$definition$1$3$3$1(strGenerateRandomOutputPath, manipulateOptions2, ref, compress, objectRef2, null), 3, null);
            this.L$0 = strGenerateRandomOutputPath;
            this.L$1 = ref;
            this.L$2 = objectRef2;
            this.label = 1;
            if (deferredAsync$default.await(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
            str = strGenerateRandomOutputPath;
            bitmap = ref;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) this.L$2;
            bitmap = (Bitmap) this.L$1;
            str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return MapsKt.mapOf(TuplesKt.to(ShareConstants.MEDIA_URI, Uri.fromFile(new File(str)).toString()), TuplesKt.to("width", Boxing.boxInt(bitmap.getWidth())), TuplesKt.to("height", Boxing.boxInt(bitmap.getHeight())), TuplesKt.to("base64", objectRef.element));
    }
}
