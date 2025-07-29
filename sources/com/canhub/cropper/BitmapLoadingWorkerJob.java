package com.canhub.cropper;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.canhub.cropper.BitmapUtils;
import com.canhub.cropper.utils.GetFilePathFromUriKt;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.share.internal.ShareConstants;
import com.facebook.soloader.Elf64;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

/* compiled from: BitmapLoadingWorkerJob.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0019\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00050\u00050\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/canhub/cropper/BitmapLoadingWorkerJob;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Landroid/content/Context;", "cropImageView", "Lcom/canhub/cropper/CropImageView;", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "(Landroid/content/Context;Lcom/canhub/cropper/CropImageView;Landroid/net/Uri;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "cropImageViewReference", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "currentJob", "Lkotlinx/coroutines/Job;", "height", "", "getUri", "()Landroid/net/Uri;", "width", "cancel", "", "onPostExecute", "result", "Lcom/canhub/cropper/BitmapLoadingWorkerJob$Result;", "(Lcom/canhub/cropper/BitmapLoadingWorkerJob$Result;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ViewProps.START, "Companion", "Result", "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class BitmapLoadingWorkerJob implements CoroutineScope {
    private final Context context;
    private final WeakReference<CropImageView> cropImageViewReference;
    private Job currentJob;
    private final int height;
    private final Uri uri;
    private final int width;

    public BitmapLoadingWorkerJob(Context context, CropImageView cropImageView, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cropImageView, "cropImageView");
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.context = context;
        this.uri = uri;
        this.cropImageViewReference = new WeakReference<>(cropImageView);
        this.currentJob = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        double d = cropImageView.getResources().getDisplayMetrics().density > 1.0f ? 1.0d / r3.density : 1.0d;
        this.width = (int) (r3.widthPixels * d);
        this.height = (int) (r3.heightPixels * d);
    }

    public final Uri getUri() {
        return this.uri;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return Dispatchers.getMain().plus(this.currentJob);
    }

    /* compiled from: BitmapLoadingWorkerJob.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.canhub.cropper.BitmapLoadingWorkerJob$start$1", f = "BitmapLoadingWorkerJob.kt", i = {}, l = {45, Elf64.Ehdr.E_SHENTSIZE}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.canhub.cropper.BitmapLoadingWorkerJob$start$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = BitmapLoadingWorkerJob.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
            } catch (Exception e) {
                this.label = 2;
                if (BitmapLoadingWorkerJob.this.onPostExecute(new Result(BitmapLoadingWorkerJob.this.getUri(), e), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    BitmapUtils.BitmapSampled bitmapSampledDecodeSampledBitmap = BitmapUtils.INSTANCE.decodeSampledBitmap(BitmapLoadingWorkerJob.this.context, BitmapLoadingWorkerJob.this.getUri(), BitmapLoadingWorkerJob.this.width, BitmapLoadingWorkerJob.this.height);
                    if (CoroutineScopeKt.isActive(coroutineScope)) {
                        BitmapUtils.RotateBitmapResult rotateBitmapResultOrientateBitmapByExif = BitmapUtils.INSTANCE.orientateBitmapByExif(bitmapSampledDecodeSampledBitmap.getBitmap(), BitmapLoadingWorkerJob.this.context, BitmapLoadingWorkerJob.this.getUri());
                        this.label = 1;
                        if (BitmapLoadingWorkerJob.this.onPostExecute(new Result(BitmapLoadingWorkerJob.this.getUri(), rotateBitmapResultOrientateBitmapByExif.getBitmap(), bitmapSampledDecodeSampledBitmap.getSampleSize(), rotateBitmapResultOrientateBitmapByExif.getDegrees(), rotateBitmapResultOrientateBitmapByExif.getFlipHorizontally(), rotateBitmapResultOrientateBitmapByExif.getFlipVertically()), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
            } else {
                if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void start() {
        this.currentJob = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getDefault(), null, new AnonymousClass1(null), 2, null);
    }

    /* compiled from: BitmapLoadingWorkerJob.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.canhub.cropper.BitmapLoadingWorkerJob$onPostExecute$2", f = "BitmapLoadingWorkerJob.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.canhub.cropper.BitmapLoadingWorkerJob$onPostExecute$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Result $result;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Result result, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$result = result;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = BitmapLoadingWorkerJob.this.new AnonymousClass2(this.$result, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CropImageView cropImageView;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            if (CoroutineScopeKt.isActive(coroutineScope) && (cropImageView = (CropImageView) BitmapLoadingWorkerJob.this.cropImageViewReference.get()) != null) {
                Result result = this.$result;
                booleanRef.element = true;
                cropImageView.onSetImageUriAsyncComplete(result);
            }
            if (!booleanRef.element && this.$result.getBitmap() != null) {
                this.$result.getBitmap().recycle();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object onPostExecute(Result result, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(result, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final void cancel() {
        Job.DefaultImpls.cancel$default(this.currentJob, (CancellationException) null, 1, (Object) null);
    }

    /* compiled from: BitmapLoadingWorkerJob.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B9\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fB\u001f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\r\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f¢\u0006\u0002\u0010\u0010J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\r\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006&"}, d2 = {"Lcom/canhub/cropper/BitmapLoadingWorkerJob$Result;", "", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "bitmap", "Landroid/graphics/Bitmap;", "loadSampleSize", "", "degreesRotated", "flipHorizontally", "", "flipVertically", "(Landroid/net/Uri;Landroid/graphics/Bitmap;IIZZ)V", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Landroid/net/Uri;Ljava/lang/Exception;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getDegreesRotated", "()I", "getError", "()Ljava/lang/Exception;", "getFlipHorizontally", "()Z", "setFlipHorizontally", "(Z)V", "getFlipVertically", "setFlipVertically", "getLoadSampleSize", "uriContent", "getUriContent", "()Landroid/net/Uri;", "getUriFilePath", "", "context", "Landroid/content/Context;", "uniqueName", "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Result {
        private final Bitmap bitmap;
        private final int degreesRotated;
        private final Exception error;
        private boolean flipHorizontally;
        private boolean flipVertically;
        private final int loadSampleSize;
        private final Uri uriContent;

        public final Uri getUriContent() {
            return this.uriContent;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final int getLoadSampleSize() {
            return this.loadSampleSize;
        }

        public final int getDegreesRotated() {
            return this.degreesRotated;
        }

        public final boolean getFlipHorizontally() {
            return this.flipHorizontally;
        }

        public final void setFlipHorizontally(boolean z) {
            this.flipHorizontally = z;
        }

        public final boolean getFlipVertically() {
            return this.flipVertically;
        }

        public final void setFlipVertically(boolean z) {
            this.flipVertically = z;
        }

        public final Exception getError() {
            return this.error;
        }

        public static /* synthetic */ String getUriFilePath$default(Result result, Context context, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return result.getUriFilePath(context, z);
        }

        public final String getUriFilePath(Context context, boolean uniqueName) {
            Intrinsics.checkNotNullParameter(context, "context");
            return GetFilePathFromUriKt.getFilePathFromUri(context, this.uriContent, uniqueName);
        }

        public Result(Uri uri, Bitmap bitmap, int i, int i2, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.uriContent = uri;
            this.bitmap = bitmap;
            this.loadSampleSize = i;
            this.degreesRotated = i2;
            this.flipHorizontally = z;
            this.flipVertically = z2;
            this.error = null;
        }

        public Result(Uri uri, Exception exc) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.uriContent = uri;
            this.bitmap = null;
            this.loadSampleSize = 0;
            this.degreesRotated = 0;
            this.error = exc;
        }
    }
}
