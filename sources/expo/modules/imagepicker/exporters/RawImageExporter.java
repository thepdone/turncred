package expo.modules.imagepicker.exporters;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: RawImageExporter.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/imagepicker/exporters/RawImageExporter;", "Lexpo/modules/imagepicker/exporters/ImageExporter;", "()V", "exportAsync", "Lexpo/modules/imagepicker/exporters/ImageExportResult;", "source", "Landroid/net/Uri;", "output", "Ljava/io/File;", "contentResolver", "Landroid/content/ContentResolver;", "(Landroid/net/Uri;Ljava/io/File;Landroid/content/ContentResolver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-image-picker_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RawImageExporter implements ImageExporter {

    /* compiled from: RawImageExporter.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.imagepicker.exporters.RawImageExporter", f = "RawImageExporter.kt", i = {0}, l = {14}, m = "exportAsync", n = {"output"}, s = {"L$0"})
    /* renamed from: expo.modules.imagepicker.exporters.RawImageExporter$exportAsync$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RawImageExporter.this.exportAsync(null, null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // expo.modules.imagepicker.exporters.ImageExporter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object exportAsync(android.net.Uri r5, java.io.File r6, android.content.ContentResolver r7, kotlin.coroutines.Continuation<? super expo.modules.imagepicker.exporters.ImageExportResult> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof expo.modules.imagepicker.exporters.RawImageExporter.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            expo.modules.imagepicker.exporters.RawImageExporter$exportAsync$1 r0 = (expo.modules.imagepicker.exporters.RawImageExporter.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            expo.modules.imagepicker.exporters.RawImageExporter$exportAsync$1 r0 = new expo.modules.imagepicker.exporters.RawImageExporter$exportAsync$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r5 = r0.L$0
            r6 = r5
            java.io.File r6 = (java.io.File) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L45
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r5 = expo.modules.imagepicker.ImagePickerUtilsKt.copyFile(r5, r6, r7, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            expo.modules.imagepicker.exporters.DimensionsExporter r5 = new expo.modules.imagepicker.exporters.DimensionsExporter
            r5.<init>(r6)
            expo.modules.imagepicker.exporters.ImageExportResult r7 = new expo.modules.imagepicker.exporters.ImageExportResult
            int r8 = r5.getWidth()
            int r5 = r5.getHeight()
            r7.<init>(r8, r5, r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.imagepicker.exporters.RawImageExporter.exportAsync(android.net.Uri, java.io.File, android.content.ContentResolver, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
