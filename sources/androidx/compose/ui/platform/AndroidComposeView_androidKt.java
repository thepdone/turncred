package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.text.input.PlatformTextInputService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidComposeView.android.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u001a2\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002\u001a\u000e\u0010\u0017\u001a\u0004\u0018\u00010\u0018*\u00020\u0015H\u0002\u001a\u001e\u0010\u0019\u001a\u00020\u001a*\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a.\u0010\u001d\u001a\u00020\u001a*\u00020\f2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"&\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"ONE_FRAME_120_HERTZ_IN_MILLISECONDS", "", "platformTextInputServiceInterceptor", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "getPlatformTextInputServiceInterceptor", "()Lkotlin/jvm/functions/Function1;", "setPlatformTextInputServiceInterceptor", "(Lkotlin/jvm/functions/Function1;)V", "dot", "", "m1", "Landroidx/compose/ui/graphics/Matrix;", "row", "", "m2", "column", "dot-p89u6pk", "([FI[FI)F", "containsDescendant", "", "Landroid/view/View;", "other", "getContentCaptureSessionCompat", "Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "preTransform", "", "preTransform-JiSxe2E", "([F[F)V", "preTranslate", "x", "y", "tmpMatrix", "preTranslate-cG2Xzmc", "([FFF[F)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidComposeView_androidKt {
    private static final long ONE_FRAME_120_HERTZ_IN_MILLISECONDS = 8;
    private static Function1<? super PlatformTextInputService, ? extends PlatformTextInputService> platformTextInputServiceInterceptor = new Function1<PlatformTextInputService, PlatformTextInputService>() { // from class: androidx.compose.ui.platform.AndroidComposeView_androidKt$platformTextInputServiceInterceptor$1
        @Override // kotlin.jvm.functions.Function1
        public final PlatformTextInputService invoke(PlatformTextInputService platformTextInputService) {
            return platformTextInputService;
        }
    };

    public static final Function1<PlatformTextInputService, PlatformTextInputService> getPlatformTextInputServiceInterceptor() {
        return platformTextInputServiceInterceptor;
    }

    public static final void setPlatformTextInputServiceInterceptor(Function1<? super PlatformTextInputService, ? extends PlatformTextInputService> function1) {
        platformTextInputServiceInterceptor = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: preTransform-JiSxe2E, reason: not valid java name */
    public static final void m3950preTransformJiSxe2E(float[] fArr, float[] fArr2) {
        float fM3949dotp89u6pk = m3949dotp89u6pk(fArr2, 0, fArr, 0);
        float fM3949dotp89u6pk2 = m3949dotp89u6pk(fArr2, 0, fArr, 1);
        float fM3949dotp89u6pk3 = m3949dotp89u6pk(fArr2, 0, fArr, 2);
        float fM3949dotp89u6pk4 = m3949dotp89u6pk(fArr2, 0, fArr, 3);
        float fM3949dotp89u6pk5 = m3949dotp89u6pk(fArr2, 1, fArr, 0);
        float fM3949dotp89u6pk6 = m3949dotp89u6pk(fArr2, 1, fArr, 1);
        float fM3949dotp89u6pk7 = m3949dotp89u6pk(fArr2, 1, fArr, 2);
        float fM3949dotp89u6pk8 = m3949dotp89u6pk(fArr2, 1, fArr, 3);
        float fM3949dotp89u6pk9 = m3949dotp89u6pk(fArr2, 2, fArr, 0);
        float fM3949dotp89u6pk10 = m3949dotp89u6pk(fArr2, 2, fArr, 1);
        float fM3949dotp89u6pk11 = m3949dotp89u6pk(fArr2, 2, fArr, 2);
        float fM3949dotp89u6pk12 = m3949dotp89u6pk(fArr2, 2, fArr, 3);
        float fM3949dotp89u6pk13 = m3949dotp89u6pk(fArr2, 3, fArr, 0);
        float fM3949dotp89u6pk14 = m3949dotp89u6pk(fArr2, 3, fArr, 1);
        float fM3949dotp89u6pk15 = m3949dotp89u6pk(fArr2, 3, fArr, 2);
        float fM3949dotp89u6pk16 = m3949dotp89u6pk(fArr2, 3, fArr, 3);
        fArr[0] = fM3949dotp89u6pk;
        fArr[1] = fM3949dotp89u6pk2;
        fArr[2] = fM3949dotp89u6pk3;
        fArr[3] = fM3949dotp89u6pk4;
        fArr[4] = fM3949dotp89u6pk5;
        fArr[5] = fM3949dotp89u6pk6;
        fArr[6] = fM3949dotp89u6pk7;
        fArr[7] = fM3949dotp89u6pk8;
        fArr[8] = fM3949dotp89u6pk9;
        fArr[9] = fM3949dotp89u6pk10;
        fArr[10] = fM3949dotp89u6pk11;
        fArr[11] = fM3949dotp89u6pk12;
        fArr[12] = fM3949dotp89u6pk13;
        fArr[13] = fM3949dotp89u6pk14;
        fArr[14] = fM3949dotp89u6pk15;
        fArr[15] = fM3949dotp89u6pk16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: preTranslate-cG2Xzmc, reason: not valid java name */
    public static final void m3951preTranslatecG2Xzmc(float[] fArr, float f, float f2, float[] fArr2) {
        Matrix.m2517resetimpl(fArr2);
        Matrix.m2528translateimpl$default(fArr2, f, f2, 0.0f, 4, null);
        m3950preTransformJiSxe2E(fArr, fArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean containsDescendant(View view, View view2) {
        if (Intrinsics.areEqual(view2, view)) {
            return false;
        }
        for (ViewParent parent = view2.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == view) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentCaptureSessionCompat getContentCaptureSessionCompat(View view) {
        ViewCompatShims.setImportantForContentCapture(view, 1);
        return ViewCompatShims.getContentCaptureSession(view);
    }

    /* renamed from: dot-p89u6pk, reason: not valid java name */
    private static final float m3949dotp89u6pk(float[] fArr, int i, float[] fArr2, int i2) {
        int i3 = i * 4;
        return (fArr[i3] * fArr2[i2]) + (fArr[i3 + 1] * fArr2[4 + i2]) + (fArr[i3 + 2] * fArr2[8 + i2]) + (fArr[i3 + 3] * fArr2[12 + i2]);
    }
}
