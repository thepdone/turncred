package androidx.camera.core.processing.util;

import android.opengl.EGLSurface;

/* loaded from: classes.dex */
public abstract class OutputSurface {
    public abstract EGLSurface getEglSurface();

    public abstract int getHeight();

    public abstract int getWidth();

    public static OutputSurface of(EGLSurface eGLSurface, int i, int i2) {
        return new AutoValue_OutputSurface(eGLSurface, i, i2);
    }
}
