package expo.modules.clipboard;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.InterruptibleKt;

/* compiled from: ClipboardImage.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0080@¢\u0006\u0002\u0010\u000b\u001a&\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0080@¢\u0006\u0002\u0010\u0010\u001a\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a&\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0080@¢\u0006\u0002\u0010\u0017\u001a\u0012\u0010\u0018\u001a\u00020\u0019*\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"JPEG_PREFIX", "", "PNG_PREFIX", "bitmapFromBase64String", "Landroid/graphics/Bitmap;", "base64Image", "bitmapFromContentUriAsync", "context", "Landroid/content/Context;", "imageUri", "Landroid/net/Uri;", "(Landroid/content/Context;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clipDataFromBase64Image", "Landroid/content/ClipData;", "clipboardCacheDir", "Ljava/io/File;", "(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImageFormatFromBase64", "Lexpo/modules/clipboard/ImageFormat;", "imageFromContentUri", "Lexpo/modules/clipboard/ImageResult;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lexpo/modules/clipboard/GetImageOptions;", "(Landroid/content/Context;Landroid/net/Uri;Lexpo/modules/clipboard/GetImageOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureExists", "", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-clipboard_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClipboardImageKt {
    public static final String JPEG_PREFIX = "/9j/";
    public static final String PNG_PREFIX = "iVBORw0K";

    /* compiled from: ClipboardImage.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageFormat.values().length];
            try {
                iArr[ImageFormat.PNG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageFormat.JPG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: ClipboardImage.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.clipboard.ClipboardImageKt", f = "ClipboardImage.kt", i = {}, l = {158}, m = "bitmapFromContentUriAsync", n = {}, s = {})
    /* renamed from: expo.modules.clipboard.ClipboardImageKt$bitmapFromContentUriAsync$1, reason: invalid class name */
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
            return ClipboardImageKt.bitmapFromContentUriAsync(null, null, this);
        }
    }

    /* compiled from: ClipboardImage.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.clipboard.ClipboardImageKt", f = "ClipboardImage.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2}, l = {130, 134, 137}, m = "clipDataFromBase64Image", n = {"context", "bitmap", "format", "context", "bitmap", "format", "file", "context", "file"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
    /* renamed from: expo.modules.clipboard.ClipboardImageKt$clipDataFromBase64Image$1, reason: invalid class name and case insensitive filesystem */
    static final class C04671 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C04671(Continuation<? super C04671> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ClipboardImageKt.clipDataFromBase64Image(null, null, null, this);
        }
    }

    /* compiled from: ClipboardImage.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.clipboard.ClipboardImageKt", f = "ClipboardImage.kt", i = {0, 1, 1, 1}, l = {77, JpegTranscoderUtils.DEFAULT_JPEG_QUALITY}, m = "imageFromContentUri", n = {SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "bitmap", "format", "outputStream"}, s = {"L$0", "L$0", "L$1", "L$2"})
    /* renamed from: expo.modules.clipboard.ClipboardImageKt$imageFromContentUri$1, reason: invalid class name and case insensitive filesystem */
    static final class C04691 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C04691(Continuation<? super C04691> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ClipboardImageKt.imageFromContentUri(null, null, null, this);
        }
    }

    public static final ImageFormat getImageFormatFromBase64(String base64Image) {
        Intrinsics.checkNotNullParameter(base64Image, "base64Image");
        String strSubstring = base64Image.substring(0, 8);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return StringsKt.startsWith$default(strSubstring, PNG_PREFIX, false, 2, (Object) null) ? ImageFormat.PNG : StringsKt.startsWith$default(strSubstring, JPEG_PREFIX, false, 2, (Object) null) ? ImageFormat.JPG : ImageFormat.JPG;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object imageFromContentUri(android.content.Context r6, android.net.Uri r7, expo.modules.clipboard.GetImageOptions r8, kotlin.coroutines.Continuation<? super expo.modules.clipboard.ImageResult> r9) {
        /*
            boolean r0 = r9 instanceof expo.modules.clipboard.ClipboardImageKt.C04691
            if (r0 == 0) goto L14
            r0 = r9
            expo.modules.clipboard.ClipboardImageKt$imageFromContentUri$1 r0 = (expo.modules.clipboard.ClipboardImageKt.C04691) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            expo.modules.clipboard.ClipboardImageKt$imageFromContentUri$1 r0 = new expo.modules.clipboard.ClipboardImageKt$imageFromContentUri$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r6 = r0.L$2
            java.io.ByteArrayOutputStream r6 = (java.io.ByteArrayOutputStream) r6
            java.lang.Object r7 = r0.L$1
            expo.modules.clipboard.ImageFormat r7 = (expo.modules.clipboard.ImageFormat) r7
            java.lang.Object r8 = r0.L$0
            android.graphics.Bitmap r8 = (android.graphics.Bitmap) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L88
        L39:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L41:
            java.lang.Object r6 = r0.L$0
            r8 = r6
            expo.modules.clipboard.GetImageOptions r8 = (expo.modules.clipboard.GetImageOptions) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L58
        L4a:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r9 = bitmapFromContentUriAsync(r6, r7, r0)
            if (r9 != r1) goto L58
            return r1
        L58:
            r6 = r9
            android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6
            expo.modules.clipboard.ImageFormat r7 = r8.getImageFormat()
            double r8 = r8.getJpegQuality()
            r2 = 100
            double r4 = (double) r2
            double r8 = r8 * r4
            int r8 = (int) r8
            java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream
            r9.<init>()
            android.graphics.Bitmap$CompressFormat r2 = r7.getCompressFormat()
            r4 = r9
            java.io.OutputStream r4 = (java.io.OutputStream) r4
            r6.compress(r2, r8, r4)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r9
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.YieldKt.yield(r0)
            if (r8 != r1) goto L86
            return r1
        L86:
            r8 = r6
            r6 = r9
        L88:
            byte[] r6 = r6.toByteArray()
            r9 = 0
            java.lang.String r6 = android.util.Base64.encodeToString(r6, r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r7 = r7.getMimeType()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "data:"
            r0.<init>(r1)
            java.lang.StringBuilder r7 = r0.append(r7)
            java.lang.String r0 = ";base64,"
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.String r7 = r7.toString()
            r9.<init>(r7)
            java.lang.StringBuilder r6 = r9.append(r6)
            expo.modules.clipboard.ImageResult r7 = new expo.modules.clipboard.ImageResult
            java.lang.String r6 = r6.toString()
            java.lang.String r9 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r9)
            int r9 = r8.getWidth()
            int r8 = r8.getHeight()
            r7.<init>(r6, r9, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.clipboard.ClipboardImageKt.imageFromContentUri(android.content.Context, android.net.Uri, expo.modules.clipboard.GetImageOptions, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00f6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object clipDataFromBase64Image(android.content.Context r9, java.lang.String r10, java.io.File r11, kotlin.coroutines.Continuation<? super android.content.ClipData> r12) throws expo.modules.clipboard.InvalidImageException {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.clipboard.ClipboardImageKt.clipDataFromBase64Image(android.content.Context, java.lang.String, java.io.File, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object bitmapFromContentUriAsync(final android.content.Context r4, final android.net.Uri r5, kotlin.coroutines.Continuation<? super android.graphics.Bitmap> r6) {
        /*
            boolean r0 = r6 instanceof expo.modules.clipboard.ClipboardImageKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r6
            expo.modules.clipboard.ClipboardImageKt$bitmapFromContentUriAsync$1 r0 = (expo.modules.clipboard.ClipboardImageKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            expo.modules.clipboard.ClipboardImageKt$bitmapFromContentUriAsync$1 r0 = new expo.modules.clipboard.ClipboardImageKt$bitmapFromContentUriAsync$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4b
        L2a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.CoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6
            expo.modules.clipboard.ClipboardImageKt$bitmapFromContentUriAsync$2 r2 = new expo.modules.clipboard.ClipboardImageKt$bitmapFromContentUriAsync$2
            r2.<init>()
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.InterruptibleKt.runInterruptible(r6, r2, r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            java.lang.String r4 = "runInterruptible(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.clipboard.ClipboardImageKt.bitmapFromContentUriAsync(android.content.Context, android.net.Uri, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Bitmap bitmapFromBase64String(String base64Image) throws InvalidImageException {
        Intrinsics.checkNotNullParameter(base64Image, "base64Image");
        try {
            byte[] bArrDecode = Base64.decode(base64Image, 0);
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
            if (bitmapDecodeByteArray != null) {
                return bitmapDecodeByteArray;
            }
            throw new RuntimeException("Failed to convert base64 into Bitmap");
        } catch (RuntimeException e) {
            throw new InvalidImageException(base64Image, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ensureExists(final File file, Continuation<? super Boolean> continuation) {
        return InterruptibleKt.runInterruptible(Dispatchers.getIO(), new Function0<Boolean>() { // from class: expo.modules.clipboard.ClipboardImageKt.ensureExists.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                return Boolean.valueOf(file.createNewFile());
            }
        }, continuation);
    }
}
