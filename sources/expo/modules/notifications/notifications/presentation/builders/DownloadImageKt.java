package expo.modules.notifications.notifications.presentation.builders;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DownloadImage.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a,\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"downloadImage", "Landroid/graphics/Bitmap;", "imageUrl", "Landroid/net/Uri;", "connectTimeout", "", "readTimeout", "(Landroid/net/Uri;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-notifications_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DownloadImageKt {

    /* compiled from: DownloadImage.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.notifications.notifications.presentation.builders.DownloadImageKt", f = "DownloadImage.kt", i = {}, l = {13}, m = "downloadImage", n = {}, s = {})
    /* renamed from: expo.modules.notifications.notifications.presentation.builders.DownloadImageKt$downloadImage$1, reason: invalid class name */
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
            return DownloadImageKt.downloadImage(null, 0L, 0L, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object downloadImage(android.net.Uri r14, long r15, long r17, kotlin.coroutines.Continuation<? super android.graphics.Bitmap> r19) {
        /*
            r0 = r19
            boolean r1 = r0 instanceof expo.modules.notifications.notifications.presentation.builders.DownloadImageKt.AnonymousClass1
            if (r1 == 0) goto L16
            r1 = r0
            expo.modules.notifications.notifications.presentation.builders.DownloadImageKt$downloadImage$1 r1 = (expo.modules.notifications.notifications.presentation.builders.DownloadImageKt.AnonymousClass1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L16
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L1b
        L16:
            expo.modules.notifications.notifications.presentation.builders.DownloadImageKt$downloadImage$1 r1 = new expo.modules.notifications.notifications.presentation.builders.DownloadImageKt$downloadImage$1
            r1.<init>(r0)
        L1b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L34
            if (r3 != r4) goto L2c
            kotlin.ResultKt.throwOnFailure(r0)     // Catch: java.lang.Throwable -> L58
            goto L51
        L2c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L34:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L58
            long r12 = r15 + r17
            expo.modules.notifications.notifications.presentation.builders.DownloadImageKt$downloadImage$2$1 r0 = new expo.modules.notifications.notifications.presentation.builders.DownloadImageKt$downloadImage$2$1     // Catch: java.lang.Throwable -> L58
            r11 = 0
            r5 = r0
            r6 = r14
            r7 = r15
            r9 = r17
            r5.<init>(r6, r7, r9, r11)     // Catch: java.lang.Throwable -> L58
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0     // Catch: java.lang.Throwable -> L58
            r1.label = r4     // Catch: java.lang.Throwable -> L58
            java.lang.Object r0 = kotlinx.coroutines.TimeoutKt.withTimeout(r12, r0, r1)     // Catch: java.lang.Throwable -> L58
            if (r0 != r2) goto L51
            return r2
        L51:
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0     // Catch: java.lang.Throwable -> L58
            java.lang.Object r0 = kotlin.Result.m5937constructorimpl(r0)     // Catch: java.lang.Throwable -> L58
            goto L63
        L58:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m5937constructorimpl(r0)
        L63:
            boolean r1 = kotlin.Result.m5943isFailureimpl(r0)
            if (r1 == 0) goto L6a
            r0 = 0
        L6a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.notifications.notifications.presentation.builders.DownloadImageKt.downloadImage(android.net.Uri, long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
