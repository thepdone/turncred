package expo.modules.image;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import expo.modules.image.records.ImageLoadOptions;
import expo.modules.image.records.SourceMap;
import expo.modules.kotlin.AppContext;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageLoadTask.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lexpo/modules/image/ImageLoadTask;", "", "appContext", "Lexpo/modules/kotlin/AppContext;", "source", "Lexpo/modules/image/records/SourceMap;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lexpo/modules/image/records/ImageLoadOptions;", "(Lexpo/modules/kotlin/AppContext;Lexpo/modules/image/records/SourceMap;Lexpo/modules/image/records/ImageLoadOptions;)V", "load", "Lexpo/modules/image/Image;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-image_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class ImageLoadTask {
    private final AppContext appContext;
    private final ImageLoadOptions options;
    private final SourceMap source;

    /* compiled from: ImageLoadTask.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.image.ImageLoadTask", f = "ImageLoadTask.kt", i = {}, l = {24}, m = "load", n = {}, s = {})
    /* renamed from: expo.modules.image.ImageLoadTask$load$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ImageLoadTask.this.load(this);
        }
    }

    public ImageLoadTask(AppContext appContext, SourceMap source, ImageLoadOptions options) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(options, "options");
        this.appContext = appContext;
        this.source = source;
        this.options = options;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object load(kotlin.coroutines.Continuation<? super expo.modules.image.Image> r8) throws expo.modules.image.ImageLoadFailed, expo.modules.kotlin.exception.Exceptions.ReactContextLost {
        /*
            r7 = this;
            boolean r0 = r8 instanceof expo.modules.image.ImageLoadTask.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            expo.modules.image.ImageLoadTask$load$1 r0 = (expo.modules.image.ImageLoadTask.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            expo.modules.image.ImageLoadTask$load$1 r0 = new expo.modules.image.ImageLoadTask$load$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L2a
            goto L64
        L2a:
            r8 = move-exception
            goto L6f
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L34:
            kotlin.ResultKt.throwOnFailure(r8)
            expo.modules.kotlin.AppContext r8 = r7.appContext
            android.content.Context r8 = r8.getReactContext()
            if (r8 == 0) goto L75
            expo.modules.image.records.SourceMap r2 = r7.source
            expo.modules.image.GlideModelProvider r2 = r2.createGlideModelProvider(r8)
            r4 = 0
            if (r2 == 0) goto L4d
            java.lang.Object r2 = r2.getGlideModel()
            goto L4e
        L4d:
            r2 = r4
        L4e:
            kotlinx.coroutines.CoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> L2a
            kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5     // Catch: java.lang.Exception -> L2a
            expo.modules.image.ImageLoadTask$load$bitmap$1 r6 = new expo.modules.image.ImageLoadTask$load$bitmap$1     // Catch: java.lang.Exception -> L2a
            r6.<init>(r8, r2, r7, r4)     // Catch: java.lang.Exception -> L2a
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch: java.lang.Exception -> L2a
            r0.label = r3     // Catch: java.lang.Exception -> L2a
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r5, r6, r0)     // Catch: java.lang.Exception -> L2a
            if (r8 != r1) goto L64
            return r1
        L64:
            android.graphics.drawable.Drawable r8 = (android.graphics.drawable.Drawable) r8     // Catch: java.lang.Exception -> L2a
            expo.modules.image.Image r0 = new expo.modules.image.Image     // Catch: java.lang.Exception -> L2a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)     // Catch: java.lang.Exception -> L2a
            r0.<init>(r8)     // Catch: java.lang.Exception -> L2a
            return r0
        L6f:
            expo.modules.image.ImageLoadFailed r0 = new expo.modules.image.ImageLoadFailed
            r0.<init>(r8)
            throw r0
        L75:
            expo.modules.kotlin.exception.Exceptions$ReactContextLost r8 = new expo.modules.kotlin.exception.Exceptions$ReactContextLost
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.image.ImageLoadTask.load(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
