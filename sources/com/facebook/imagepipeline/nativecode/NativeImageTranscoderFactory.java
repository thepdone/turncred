package com.facebook.imagepipeline.nativecode;

import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeImageTranscoderFactory.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¨\u0006\n"}, d2 = {"Lcom/facebook/imagepipeline/nativecode/NativeImageTranscoderFactory;", "", "()V", "getNativeImageTranscoderFactory", "Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;", "maxBitmapSize", "", "useDownSamplingRatio", "", "ensureTranscoderLibraryLoaded", "imagepipeline-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NativeImageTranscoderFactory {
    public static final NativeImageTranscoderFactory INSTANCE = new NativeImageTranscoderFactory();

    private NativeImageTranscoderFactory() {
    }

    @JvmStatic
    public static final ImageTranscoderFactory getNativeImageTranscoderFactory(int maxBitmapSize, boolean useDownSamplingRatio, boolean ensureTranscoderLibraryLoaded) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objNewInstance = Class.forName("com.facebook.imagepipeline.nativecode.NativeJpegTranscoderFactory").getConstructor(Integer.TYPE, Boolean.TYPE, Boolean.TYPE).newInstance(Integer.valueOf(maxBitmapSize), Boolean.valueOf(useDownSamplingRatio), Boolean.valueOf(ensureTranscoderLibraryLoaded));
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type com.facebook.imagepipeline.transcoder.ImageTranscoderFactory");
            return (ImageTranscoderFactory) objNewInstance;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e2);
        } catch (IllegalArgumentException e3) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e3);
        } catch (InstantiationException e4) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e4);
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e5);
        } catch (SecurityException e6) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e6);
        } catch (InvocationTargetException e7) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e7);
        }
    }
}
