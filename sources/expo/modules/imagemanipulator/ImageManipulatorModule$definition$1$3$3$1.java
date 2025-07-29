package expo.modules.imagemanipulator;

import android.graphics.Bitmap;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ImageManipulatorModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.imagemanipulator.ImageManipulatorModule$definition$1$3$3$1", f = "ImageManipulatorModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class ImageManipulatorModule$definition$1$3$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $base64String;
    final /* synthetic */ int $compression;
    final /* synthetic */ ManipulateOptions $options;
    final /* synthetic */ String $path;
    final /* synthetic */ Bitmap $resultBitmap;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ImageManipulatorModule$definition$1$3$3$1(String str, ManipulateOptions manipulateOptions, Bitmap bitmap, int i, Ref.ObjectRef<String> objectRef, Continuation<? super ImageManipulatorModule$definition$1$3$3$1> continuation) {
        super(2, continuation);
        this.$path = str;
        this.$options = manipulateOptions;
        this.$resultBitmap = bitmap;
        this.$compression = i;
        this.$base64String = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImageManipulatorModule$definition$1$3$3$1(this.$path, this.$options, this.$resultBitmap, this.$compression, this.$base64String, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ImageManipulatorModule$definition$1$3$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.String] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ByteArrayOutputStream fileOutputStream = new FileOutputStream(this.$path);
        ManipulateOptions manipulateOptions = this.$options;
        Bitmap bitmap = this.$resultBitmap;
        int i = this.$compression;
        Ref.ObjectRef<String> objectRef = this.$base64String;
        try {
            Bitmap.CompressFormat compressFormat = manipulateOptions.getFormat().getCompressFormat();
            bitmap.compress(compressFormat, i, fileOutputStream);
            if (manipulateOptions.getBase64()) {
                fileOutputStream = new ByteArrayOutputStream();
                try {
                    ByteArrayOutputStream byteArrayOutputStream = fileOutputStream;
                    bitmap.compress(compressFormat, i, byteArrayOutputStream);
                    objectRef.element = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileOutputStream, null);
                } finally {
                }
            }
            Unit unit2 = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
            return Unit.INSTANCE;
        } finally {
        }
    }
}
