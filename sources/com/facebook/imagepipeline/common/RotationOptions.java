package com.facebook.imagepipeline.common;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.common.util.HashCodeUtil;
import com.facebook.react.uimanager.ViewProps;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: RotationOptions.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0003\u0012\u0013\u0014B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\n\u001a\u00020\u0005J\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0006\u0010\u000e\u001a\u00020\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/facebook/imagepipeline/common/RotationOptions;", "", ViewProps.ROTATION, "", "deferUntilRendered", "", "(IZ)V", "forcedAngle", "getForcedAngle", "()I", "canDeferUntilRendered", "equals", "other", "hashCode", "rotationEnabled", InAppPurchaseConstants.METHOD_TO_STRING, "", "useImageMetadata", "Companion", "Rotation", "RotationAngle", "imagepipeline-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RotationOptions {
    private static final int DISABLE_ROTATION = -2;
    public static final int NO_ROTATION = 0;
    public static final int ROTATE_180 = 180;
    public static final int ROTATE_270 = 270;
    public static final int ROTATE_90 = 90;
    private static final int USE_EXIF_ROTATION_ANGLE = -1;
    private final boolean deferUntilRendered;
    private final int rotation;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final RotationOptions ROTATION_OPTIONS_AUTO_ROTATE = new RotationOptions(-1, false);
    private static final RotationOptions ROTATION_OPTIONS_DISABLE_ROTATION = new RotationOptions(-2, false);
    private static final RotationOptions ROTATION_OPTIONS_ROTATE_AT_RENDER_TIME = new RotationOptions(-1, true);

    /* compiled from: RotationOptions.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0083\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/facebook/imagepipeline/common/RotationOptions$Rotation;", "", "imagepipeline-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    private @interface Rotation {
    }

    /* compiled from: RotationOptions.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/facebook/imagepipeline/common/RotationOptions$RotationAngle;", "", "imagepipeline-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface RotationAngle {
    }

    public /* synthetic */ RotationOptions(int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z);
    }

    @JvmStatic
    public static final RotationOptions autoRotate() {
        return INSTANCE.autoRotate();
    }

    @JvmStatic
    public static final RotationOptions autoRotateAtRenderTime() {
        return INSTANCE.autoRotateAtRenderTime();
    }

    @JvmStatic
    public static final RotationOptions disableRotation() {
        return INSTANCE.disableRotation();
    }

    @JvmStatic
    public static final RotationOptions forceRotation(int i) {
        return INSTANCE.forceRotation(i);
    }

    private RotationOptions(int i, boolean z) {
        this.rotation = i;
        this.deferUntilRendered = z;
    }

    public final boolean useImageMetadata() {
        return this.rotation == -1;
    }

    public final boolean rotationEnabled() {
        return this.rotation != -2;
    }

    public final int getForcedAngle() {
        if (useImageMetadata()) {
            throw new IllegalStateException("Rotation is set to use EXIF".toString());
        }
        return this.rotation;
    }

    /* renamed from: canDeferUntilRendered, reason: from getter */
    public final boolean getDeferUntilRendered() {
        return this.deferUntilRendered;
    }

    public int hashCode() {
        return HashCodeUtil.hashCode(Integer.valueOf(this.rotation), Boolean.valueOf(this.deferUntilRendered));
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof RotationOptions)) {
            return false;
        }
        RotationOptions rotationOptions = (RotationOptions) other;
        return this.rotation == rotationOptions.rotation && this.deferUntilRendered == rotationOptions.deferUntilRendered;
    }

    public String toString() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(null, "%d defer:%b", Arrays.copyOf(new Object[]{Integer.valueOf(this.rotation), Boolean.valueOf(this.deferUntilRendered)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        return str;
    }

    /* compiled from: RotationOptions.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\nH\u0007J\b\u0010\u000f\u001a\u00020\nH\u0007J\b\u0010\u0010\u001a\u00020\nH\u0007J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/imagepipeline/common/RotationOptions$Companion;", "", "()V", "DISABLE_ROTATION", "", "NO_ROTATION", "ROTATE_180", "ROTATE_270", "ROTATE_90", "ROTATION_OPTIONS_AUTO_ROTATE", "Lcom/facebook/imagepipeline/common/RotationOptions;", "ROTATION_OPTIONS_DISABLE_ROTATION", "ROTATION_OPTIONS_ROTATE_AT_RENDER_TIME", "USE_EXIF_ROTATION_ANGLE", "autoRotate", "autoRotateAtRenderTime", "disableRotation", "forceRotation", "angle", "imagepipeline-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final RotationOptions autoRotate() {
            return RotationOptions.ROTATION_OPTIONS_AUTO_ROTATE;
        }

        @JvmStatic
        public final RotationOptions disableRotation() {
            return RotationOptions.ROTATION_OPTIONS_DISABLE_ROTATION;
        }

        @JvmStatic
        public final RotationOptions autoRotateAtRenderTime() {
            return RotationOptions.ROTATION_OPTIONS_ROTATE_AT_RENDER_TIME;
        }

        @JvmStatic
        public final RotationOptions forceRotation(int angle) {
            return new RotationOptions(angle, false, null);
        }
    }
}
