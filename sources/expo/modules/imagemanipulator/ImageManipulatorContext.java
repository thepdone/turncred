package expo.modules.imagemanipulator;

import android.graphics.Bitmap;
import expo.modules.imagemanipulator.transformers.ImageTransformer;
import expo.modules.kotlin.RuntimeContext;
import expo.modules.kotlin.sharedobjects.SharedObject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageManipulatorContext.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u0000J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lexpo/modules/imagemanipulator/ImageManipulatorContext;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "runtimeContext", "Lexpo/modules/kotlin/RuntimeContext;", "task", "Lexpo/modules/imagemanipulator/ManipulatorTask;", "(Lexpo/modules/kotlin/RuntimeContext;Lexpo/modules/imagemanipulator/ManipulatorTask;)V", "addTransformer", "transformer", "Lexpo/modules/imagemanipulator/transformers/ImageTransformer;", "render", "Landroid/graphics/Bitmap;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reset", "sharedObjectDidRelease", "", "expo-image-manipulator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImageManipulatorContext extends SharedObject {
    private final ManipulatorTask task;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageManipulatorContext(RuntimeContext runtimeContext, ManipulatorTask task) {
        super(runtimeContext);
        Intrinsics.checkNotNullParameter(runtimeContext, "runtimeContext");
        Intrinsics.checkNotNullParameter(task, "task");
        this.task = task;
    }

    public final ImageManipulatorContext addTransformer(ImageTransformer transformer) {
        Intrinsics.checkNotNullParameter(transformer, "transformer");
        this.task.addTransformer(transformer);
        return this;
    }

    public final ImageManipulatorContext reset() {
        this.task.reset();
        return this;
    }

    public final Object render(Continuation<? super Bitmap> continuation) {
        return this.task.render(continuation);
    }

    @Override // expo.modules.kotlin.sharedobjects.SharedObject
    public void sharedObjectDidRelease() {
        this.task.cancel();
    }
}
