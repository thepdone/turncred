package com.canhub.cropper;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.canhub.cropper.BitmapUtils;
import com.canhub.cropper.CropImageView;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
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

/* compiled from: BitmapCroppingWorkerJob.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001/B©\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u000e\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u001fJ\u0006\u0010(\u001a\u00020)J\u0019\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020,H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010-J\u0006\u0010.\u001a\u00020)R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'\u0082\u0002\u0004\n\u0002\b\u0019¨\u00060"}, d2 = {"Lcom/canhub/cropper/BitmapCroppingWorkerJob;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Landroid/content/Context;", "cropImageViewReference", "Ljava/lang/ref/WeakReference;", "Lcom/canhub/cropper/CropImageView;", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "bitmap", "Landroid/graphics/Bitmap;", "cropPoints", "", "degreesRotated", "", "orgWidth", "orgHeight", "fixAspectRatio", "", "aspectRatioX", "aspectRatioY", "reqWidth", "reqHeight", "flipHorizontally", "flipVertically", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lcom/canhub/cropper/CropImageView$RequestSizeOptions;", "saveCompressFormat", "Landroid/graphics/Bitmap$CompressFormat;", "saveCompressQuality", "customOutputUri", "(Landroid/content/Context;Ljava/lang/ref/WeakReference;Landroid/net/Uri;Landroid/graphics/Bitmap;[FIIIZIIIIZZLcom/canhub/cropper/CropImageView$RequestSizeOptions;Landroid/graphics/Bitmap$CompressFormat;ILandroid/net/Uri;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "job", "Lkotlinx/coroutines/Job;", "getUri", "()Landroid/net/Uri;", "cancel", "", "onPostExecute", "result", "Lcom/canhub/cropper/BitmapCroppingWorkerJob$Result;", "(Lcom/canhub/cropper/BitmapCroppingWorkerJob$Result;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ViewProps.START, "Result", "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class BitmapCroppingWorkerJob implements CoroutineScope {
    private final int aspectRatioX;
    private final int aspectRatioY;
    private final Bitmap bitmap;
    private final Context context;
    private final WeakReference<CropImageView> cropImageViewReference;
    private final float[] cropPoints;
    private final Uri customOutputUri;
    private final int degreesRotated;
    private final boolean fixAspectRatio;
    private final boolean flipHorizontally;
    private final boolean flipVertically;
    private Job job;
    private final CropImageView.RequestSizeOptions options;
    private final int orgHeight;
    private final int orgWidth;
    private final int reqHeight;
    private final int reqWidth;
    private final Bitmap.CompressFormat saveCompressFormat;
    private final int saveCompressQuality;
    private final Uri uri;

    public BitmapCroppingWorkerJob(Context context, WeakReference<CropImageView> cropImageViewReference, Uri uri, Bitmap bitmap, float[] cropPoints, int i, int i2, int i3, boolean z, int i4, int i5, int i6, int i7, boolean z2, boolean z3, CropImageView.RequestSizeOptions options, Bitmap.CompressFormat saveCompressFormat, int i8, Uri uri2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cropImageViewReference, "cropImageViewReference");
        Intrinsics.checkNotNullParameter(cropPoints, "cropPoints");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(saveCompressFormat, "saveCompressFormat");
        this.context = context;
        this.cropImageViewReference = cropImageViewReference;
        this.uri = uri;
        this.bitmap = bitmap;
        this.cropPoints = cropPoints;
        this.degreesRotated = i;
        this.orgWidth = i2;
        this.orgHeight = i3;
        this.fixAspectRatio = z;
        this.aspectRatioX = i4;
        this.aspectRatioY = i5;
        this.reqWidth = i6;
        this.reqHeight = i7;
        this.flipHorizontally = z2;
        this.flipVertically = z3;
        this.options = options;
        this.saveCompressFormat = saveCompressFormat;
        this.saveCompressQuality = i8;
        this.customOutputUri = uri2;
        this.job = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
    }

    public final Uri getUri() {
        return this.uri;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return Dispatchers.getMain().plus(this.job);
    }

    /* compiled from: BitmapCroppingWorkerJob.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.canhub.cropper.BitmapCroppingWorkerJob$start$1", f = "BitmapCroppingWorkerJob.kt", i = {}, l = {77, 102}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.canhub.cropper.BitmapCroppingWorkerJob$start$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = BitmapCroppingWorkerJob.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            BitmapUtils.BitmapSampled bitmapSampledCropBitmapObjectHandleOOM;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
            } catch (Exception e) {
                this.label = 2;
                if (BitmapCroppingWorkerJob.this.onPostExecute(new Result(e, false), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (CoroutineScopeKt.isActive(coroutineScope)) {
                if (BitmapCroppingWorkerJob.this.getUri() == null) {
                    if (BitmapCroppingWorkerJob.this.bitmap == null) {
                        this.label = 1;
                        if (BitmapCroppingWorkerJob.this.onPostExecute(new Result((Bitmap) null, 1), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    bitmapSampledCropBitmapObjectHandleOOM = BitmapUtils.INSTANCE.cropBitmapObjectHandleOOM(BitmapCroppingWorkerJob.this.bitmap, BitmapCroppingWorkerJob.this.cropPoints, BitmapCroppingWorkerJob.this.degreesRotated, BitmapCroppingWorkerJob.this.fixAspectRatio, BitmapCroppingWorkerJob.this.aspectRatioX, BitmapCroppingWorkerJob.this.aspectRatioY, BitmapCroppingWorkerJob.this.flipHorizontally, BitmapCroppingWorkerJob.this.flipVertically);
                } else {
                    bitmapSampledCropBitmapObjectHandleOOM = BitmapUtils.INSTANCE.cropBitmap(BitmapCroppingWorkerJob.this.context, BitmapCroppingWorkerJob.this.getUri(), BitmapCroppingWorkerJob.this.cropPoints, BitmapCroppingWorkerJob.this.degreesRotated, BitmapCroppingWorkerJob.this.orgWidth, BitmapCroppingWorkerJob.this.orgHeight, BitmapCroppingWorkerJob.this.fixAspectRatio, BitmapCroppingWorkerJob.this.aspectRatioX, BitmapCroppingWorkerJob.this.aspectRatioY, BitmapCroppingWorkerJob.this.reqWidth, BitmapCroppingWorkerJob.this.reqHeight, BitmapCroppingWorkerJob.this.flipHorizontally, BitmapCroppingWorkerJob.this.flipVertically);
                }
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), null, new C00891(BitmapCroppingWorkerJob.this, BitmapUtils.INSTANCE.resizeBitmap(bitmapSampledCropBitmapObjectHandleOOM.getBitmap(), BitmapCroppingWorkerJob.this.reqWidth, BitmapCroppingWorkerJob.this.reqHeight, BitmapCroppingWorkerJob.this.options), bitmapSampledCropBitmapObjectHandleOOM, null), 2, null);
            }
            return Unit.INSTANCE;
        }

        /* compiled from: BitmapCroppingWorkerJob.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.canhub.cropper.BitmapCroppingWorkerJob$start$1$1", f = "BitmapCroppingWorkerJob.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.canhub.cropper.BitmapCroppingWorkerJob$start$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ BitmapUtils.BitmapSampled $bitmapSampled;
            final /* synthetic */ Bitmap $resizedBitmap;
            int label;
            final /* synthetic */ BitmapCroppingWorkerJob this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00891(BitmapCroppingWorkerJob bitmapCroppingWorkerJob, Bitmap bitmap, BitmapUtils.BitmapSampled bitmapSampled, Continuation<? super C00891> continuation) {
                super(2, continuation);
                this.this$0 = bitmapCroppingWorkerJob;
                this.$resizedBitmap = bitmap;
                this.$bitmapSampled = bitmapSampled;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00891(this.this$0, this.$resizedBitmap, this.$bitmapSampled, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00891) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws IOException {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Uri uriWriteBitmapToUri = BitmapUtils.INSTANCE.writeBitmapToUri(this.this$0.context, this.$resizedBitmap, this.this$0.saveCompressFormat, this.this$0.saveCompressQuality, this.this$0.customOutputUri);
                    this.$resizedBitmap.recycle();
                    this.label = 1;
                    if (this.this$0.onPostExecute(new Result(uriWriteBitmapToUri, this.$bitmapSampled.getSampleSize()), this) == coroutine_suspended) {
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
    }

    public final void start() {
        this.job = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getDefault(), null, new AnonymousClass1(null), 2, null);
    }

    /* compiled from: BitmapCroppingWorkerJob.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.canhub.cropper.BitmapCroppingWorkerJob$onPostExecute$2", f = "BitmapCroppingWorkerJob.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.canhub.cropper.BitmapCroppingWorkerJob$onPostExecute$2, reason: invalid class name */
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
            AnonymousClass2 anonymousClass2 = BitmapCroppingWorkerJob.this.new AnonymousClass2(this.$result, continuation);
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
            if (CoroutineScopeKt.isActive(coroutineScope) && (cropImageView = (CropImageView) BitmapCroppingWorkerJob.this.cropImageViewReference.get()) != null) {
                Result result = this.$result;
                booleanRef.element = true;
                cropImageView.onImageCroppingAsyncComplete(result);
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
        Job.DefaultImpls.cancel$default(this.job, (CancellationException) null, 1, (Object) null);
    }

    /* compiled from: BitmapCroppingWorkerJob.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tB\u0019\b\u0016\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/canhub/cropper/BitmapCroppingWorkerJob$Result;", "", "bitmap", "Landroid/graphics/Bitmap;", "sampleSize", "", "(Landroid/graphics/Bitmap;I)V", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "(Landroid/net/Uri;I)V", "error", "Ljava/lang/Exception;", "isSave", "", "(Ljava/lang/Exception;Z)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getError", "()Ljava/lang/Exception;", "()Z", "getSampleSize", "()I", "getUri", "()Landroid/net/Uri;", "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Result {
        private final Bitmap bitmap;
        private final Exception error;
        private final boolean isSave;
        private final int sampleSize;
        private final Uri uri;

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final Uri getUri() {
            return this.uri;
        }

        public final Exception getError() {
            return this.error;
        }

        /* renamed from: isSave, reason: from getter */
        public final boolean getIsSave() {
            return this.isSave;
        }

        public final int getSampleSize() {
            return this.sampleSize;
        }

        public Result(Bitmap bitmap, int i) {
            this.bitmap = bitmap;
            this.uri = null;
            this.error = null;
            this.isSave = false;
            this.sampleSize = i;
        }

        public Result(Uri uri, int i) {
            this.bitmap = null;
            this.uri = uri;
            this.error = null;
            this.isSave = true;
            this.sampleSize = i;
        }

        public Result(Exception exc, boolean z) {
            this.bitmap = null;
            this.uri = null;
            this.error = exc;
            this.isSave = z;
            this.sampleSize = 1;
        }
    }
}
