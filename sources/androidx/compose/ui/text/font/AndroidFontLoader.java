package androidx.compose.ui.text.font;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.soloader.Elf64;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidFontLoader.android.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\n \t*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/font/AndroidFontLoader;", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cacheKey", "", "getCacheKey", "()Ljava/lang/Object;", "kotlin.jvm.PlatformType", "awaitLoad", "Landroid/graphics/Typeface;", "font", "Landroidx/compose/ui/text/font/Font;", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBlocking", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AndroidFontLoader implements PlatformFontLoader {
    public static final int $stable = 8;
    private final Object cacheKey;
    private final Context context;

    /* compiled from: AndroidFontLoader.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.text.font.AndroidFontLoader", f = "AndroidFontLoader.android.kt", i = {1, 1}, l = {57, Elf64.Ehdr.E_SHENTSIZE}, m = "awaitLoad", n = {"this", "font"}, s = {"L$0", "L$1"})
    /* renamed from: androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidFontLoader.this.awaitLoad(null, this);
        }
    }

    public AndroidFontLoader(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public android.graphics.Typeface loadBlocking(Font font) throws Resources.NotFoundException {
        Object objM5937constructorimpl;
        android.graphics.Typeface typefaceLoad;
        if (font instanceof AndroidFont) {
            AndroidFont androidFont = (AndroidFont) font;
            return androidFont.getTypefaceLoader().loadBlocking(this.context, androidFont);
        }
        if (!(font instanceof ResourceFont)) {
            return null;
        }
        int loadingStrategy = font.getLoadingStrategy();
        if (FontLoadingStrategy.m4319equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m4324getBlockingPKNRLFQ())) {
            typefaceLoad = AndroidFontLoader_androidKt.load((ResourceFont) font, this.context);
        } else if (FontLoadingStrategy.m4319equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m4325getOptionalLocalPKNRLFQ())) {
            try {
                Result.Companion companion = Result.INSTANCE;
                AndroidFontLoader androidFontLoader = this;
                objM5937constructorimpl = Result.m5937constructorimpl(AndroidFontLoader_androidKt.load((ResourceFont) font, this.context));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM5937constructorimpl = Result.m5937constructorimpl(ResultKt.createFailure(th));
            }
            typefaceLoad = (android.graphics.Typeface) (Result.m5943isFailureimpl(objM5937constructorimpl) ? null : objM5937constructorimpl);
        } else {
            if (FontLoadingStrategy.m4319equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m4323getAsyncPKNRLFQ())) {
                throw new UnsupportedOperationException("Unsupported Async font load path");
            }
            throw new IllegalArgumentException("Unknown loading type " + ((Object) FontLoadingStrategy.m4321toStringimpl(font.getLoadingStrategy())));
        }
        return PlatformTypefaces_androidKt.setFontVariationSettings(typefaceLoad, ((ResourceFont) font).getVariationSettings(), this.context);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object awaitLoad(androidx.compose.ui.text.font.Font r6, kotlin.coroutines.Continuation<? super android.graphics.Typeface> r7) throws android.content.res.Resources.NotFoundException {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.compose.ui.text.font.AndroidFontLoader.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r7
            androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1 r0 = (androidx.compose.ui.text.font.AndroidFontLoader.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1 r0 = new androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r6 = r0.L$1
            androidx.compose.ui.text.font.Font r6 = (androidx.compose.ui.text.font.Font) r6
            java.lang.Object r0 = r0.L$0
            androidx.compose.ui.text.font.AndroidFontLoader r0 = (androidx.compose.ui.text.font.AndroidFontLoader) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L71
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L59
        L41:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = r6 instanceof androidx.compose.ui.text.font.AndroidFont
            if (r7 == 0) goto L5a
            androidx.compose.ui.text.font.AndroidFont r6 = (androidx.compose.ui.text.font.AndroidFont) r6
            androidx.compose.ui.text.font.AndroidFont$TypefaceLoader r7 = r6.getTypefaceLoader()
            android.content.Context r2 = r5.context
            r0.label = r4
            java.lang.Object r7 = r7.awaitLoad(r2, r6, r0)
            if (r7 != r1) goto L59
            return r1
        L59:
            return r7
        L5a:
            boolean r7 = r6 instanceof androidx.compose.ui.text.font.ResourceFont
            if (r7 == 0) goto L80
            r7 = r6
            androidx.compose.ui.text.font.ResourceFont r7 = (androidx.compose.ui.text.font.ResourceFont) r7
            android.content.Context r2 = r5.context
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = androidx.compose.ui.text.font.AndroidFontLoader_androidKt.access$loadAsync(r7, r2, r0)
            if (r7 != r1) goto L70
            return r1
        L70:
            r0 = r5
        L71:
            android.graphics.Typeface r7 = (android.graphics.Typeface) r7
            androidx.compose.ui.text.font.ResourceFont r6 = (androidx.compose.ui.text.font.ResourceFont) r6
            androidx.compose.ui.text.font.FontVariation$Settings r6 = r6.getVariationSettings()
            android.content.Context r0 = r0.context
            android.graphics.Typeface r6 = androidx.compose.ui.text.font.PlatformTypefaces_androidKt.setFontVariationSettings(r7, r6, r0)
            return r6
        L80:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unknown font type: "
            r0.<init>(r1)
            java.lang.StringBuilder r6 = r0.append(r6)
            java.lang.String r6 = r6.toString()
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AndroidFontLoader.awaitLoad(androidx.compose.ui.text.font.Font, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public Object getCacheKey() {
        return this.cacheKey;
    }
}
