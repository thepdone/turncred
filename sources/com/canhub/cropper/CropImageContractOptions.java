package com.canhub.cropper;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.canhub.cropper.CropImageView;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.share.internal.ShareConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CropImageContractOptions.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u000fJ\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u000fJ\u0016\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0012J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u000fJ\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0012J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0012J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020)J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020)J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u0012J\u000e\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u00020)J\u000e\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u000fJ\u000e\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u00020\u0012J\u000e\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u00020)J\u000e\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020:J\u0010\u0010;\u001a\u00020\u00002\b\b\u0001\u0010<\u001a\u00020\u0012J\u0010\u0010=\u001a\u00020\u00002\b\u0010>\u001a\u0004\u0018\u00010\u0017J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020AJ\u000e\u0010B\u001a\u00020\u00002\u0006\u0010C\u001a\u00020\u000fJ\u000e\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u000fJ\u000e\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\u000fJ\u000e\u0010H\u001a\u00020\u00002\u0006\u0010I\u001a\u00020JJ\u000e\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u0012J\u000e\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020)J\u0016\u0010O\u001a\u00020\u00002\u0006\u0010P\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u000fJ\u000e\u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u00020)J\u0010\u0010T\u001a\u00020\u00002\b\u0010U\u001a\u0004\u0018\u00010VJ\u000e\u0010W\u001a\u00020\u00002\u0006\u0010X\u001a\u00020\u0012J\u0014\u0010Y\u001a\u00020\u00052\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\\0[J\u000e\u0010]\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\\J\u0016\u0010_\u001a\u00020\u00002\u0006\u0010`\u001a\u00020\u00122\u0006\u0010a\u001a\u00020\u0012J\u000e\u0010b\u001a\u00020\u00002\u0006\u0010c\u001a\u00020\u0012J\u0016\u0010d\u001a\u00020\u00002\u0006\u0010e\u001a\u00020\u00122\u0006\u0010f\u001a\u00020\u0012J\u0016\u0010g\u001a\u00020\u00002\u0006\u0010h\u001a\u00020\u00122\u0006\u0010i\u001a\u00020\u0012J\u000e\u0010j\u001a\u00020\u00002\u0006\u0010k\u001a\u00020\u000fJ\u000e\u0010l\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\u000fJ\u000e\u0010n\u001a\u00020\u00002\u0006\u0010o\u001a\u00020pJ\u000e\u0010q\u001a\u00020\u00002\u0006\u0010r\u001a\u00020\u0012J\u0010\u0010s\u001a\u00020\u00002\b\u0010t\u001a\u0004\u0018\u00010\u0003J\u0016\u0010u\u001a\u00020\u00002\u0006\u0010v\u001a\u00020\u00122\u0006\u0010w\u001a\u00020\u0012J\u001e\u0010u\u001a\u00020\u00002\u0006\u0010v\u001a\u00020\u00122\u0006\u0010w\u001a\u00020\u00122\u0006\u0010x\u001a\u00020yJ\u000e\u0010z\u001a\u00020\u00002\u0006\u0010{\u001a\u00020\u0012J\u000e\u0010|\u001a\u00020\u00002\u0006\u0010}\u001a\u00020~J\u000f\u0010\u007f\u001a\u00020\u00002\u0007\u0010\u0080\u0001\u001a\u00020\u000fJ\u0010\u0010\u0081\u0001\u001a\u00020\u00002\u0007\u0010\u0082\u0001\u001a\u00020\u000fJ\u0010\u0010\u0083\u0001\u001a\u00020\u00052\u0007\u0010\u0084\u0001\u001a\u00020\u000fJ\u0010\u0010\u0085\u0001\u001a\u00020\u00002\u0007\u0010\u0086\u0001\u001a\u00020\u000fJ\u0010\u0010\u0087\u0001\u001a\u00020\u00002\u0007\u0010\u0088\u0001\u001a\u00020)J\u0010\u0010\u0089\u0001\u001a\u00020\u00002\u0007\u0010\u008a\u0001\u001a\u00020)J\n\u0010\u008b\u0001\u001a\u00020\\HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u008c\u0001"}, d2 = {"Lcom/canhub/cropper/CropImageContractOptions;", "", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "cropImageOptions", "Lcom/canhub/cropper/CropImageOptions;", "(Landroid/net/Uri;Lcom/canhub/cropper/CropImageOptions;)V", "getCropImageOptions", "()Lcom/canhub/cropper/CropImageOptions;", "getUri", "()Landroid/net/Uri;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "setActivityMenuIconColor", "activityMenuIconColor", "setActivityTitle", "activityTitle", "", "setAllowCounterRotation", "allowCounterRotation", "setAllowFlipping", "allowFlipping", "setAllowRotation", "allowRotation", "setAspectRatio", "aspectRatioX", "aspectRatioY", "setAutoZoomEnabled", "autoZoomEnabled", "setBackgroundColor", ViewProps.BACKGROUND_COLOR, "setBorderCornerColor", "borderCornerColor", "setBorderCornerLength", "borderCornerLength", "", "setBorderCornerOffset", "borderCornerOffset", "setBorderCornerThickness", "borderCornerThickness", "setBorderLineColor", "borderLineColor", "setBorderLineThickness", "borderLineThickness", "setCenterMoveEnabled", "centerMoveEnabled", "setCircleCornerFillColor", "circleFillColorHexValue", "setCropCornerRadius", "cornerRadius", "setCropCornerShape", "cornerShape", "Lcom/canhub/cropper/CropImageView$CropCornerShape;", "setCropMenuCropButtonIcon", "drawableResource", "setCropMenuCropButtonTitle", "title", "setCropShape", "cropShape", "Lcom/canhub/cropper/CropImageView$CropShape;", "setFixAspectRatio", "fixAspectRatio", "setFlipHorizontally", "flipHorizontally", "setFlipVertically", "flipVertically", "setGuidelines", "guidelines", "Lcom/canhub/cropper/CropImageView$Guidelines;", "setGuidelinesColor", "guidelinesColor", "setGuidelinesThickness", "guidelinesThickness", "setImageSource", "includeGallery", "includeCamera", "setInitialCropWindowPaddingRatio", "initialCropWindowPaddingRatio", "setInitialCropWindowRectangle", "initialCropWindowRectangle", "Landroid/graphics/Rect;", "setInitialRotation", "initialRotation", "setIntentChooserPriorityList", "priorityAppPackages", "", "", "setIntentChooserTitle", "intentChooserTitle", "setMaxCropResultSize", "maxCropResultWidth", "maxCropResultHeight", "setMaxZoom", "maxZoom", "setMinCropResultSize", "minCropResultWidth", "minCropResultHeight", "setMinCropWindowSize", "minCropWindowWidth", "minCropWindowHeight", "setMultiTouchEnabled", "multiTouchEnabled", "setNoOutputImage", "noOutputImage", "setOutputCompressFormat", "outputCompressFormat", "Landroid/graphics/Bitmap$CompressFormat;", "setOutputCompressQuality", "outputCompressQuality", "setOutputUri", "outputUri", "setRequestedSize", "reqWidth", "reqHeight", "reqSizeOptions", "Lcom/canhub/cropper/CropImageView$RequestSizeOptions;", "setRotationDegrees", "rotationDegrees", "setScaleType", "scaleType", "Lcom/canhub/cropper/CropImageView$ScaleType;", "setShowCropLabel", "showCropLabel", "setShowCropOverlay", "showCropOverlay", "setShowIntentChooser", "showIntentChooser", "setSkipEditing", "skipEditing", "setSnapRadius", "snapRadius", "setTouchRadius", "touchRadius", InAppPurchaseConstants.METHOD_TO_STRING, "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CropImageContractOptions {
    private final CropImageOptions cropImageOptions;
    private final Uri uri;

    public static /* synthetic */ CropImageContractOptions copy$default(CropImageContractOptions cropImageContractOptions, Uri uri, CropImageOptions cropImageOptions, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = cropImageContractOptions.uri;
        }
        if ((i & 2) != 0) {
            cropImageOptions = cropImageContractOptions.cropImageOptions;
        }
        return cropImageContractOptions.copy(uri, cropImageOptions);
    }

    /* renamed from: component1, reason: from getter */
    public final Uri getUri() {
        return this.uri;
    }

    /* renamed from: component2, reason: from getter */
    public final CropImageOptions getCropImageOptions() {
        return this.cropImageOptions;
    }

    public final CropImageContractOptions copy(Uri uri, CropImageOptions cropImageOptions) {
        Intrinsics.checkNotNullParameter(cropImageOptions, "cropImageOptions");
        return new CropImageContractOptions(uri, cropImageOptions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CropImageContractOptions)) {
            return false;
        }
        CropImageContractOptions cropImageContractOptions = (CropImageContractOptions) other;
        return Intrinsics.areEqual(this.uri, cropImageContractOptions.uri) && Intrinsics.areEqual(this.cropImageOptions, cropImageContractOptions.cropImageOptions);
    }

    public int hashCode() {
        Uri uri = this.uri;
        return ((uri == null ? 0 : uri.hashCode()) * 31) + this.cropImageOptions.hashCode();
    }

    public String toString() {
        return "CropImageContractOptions(uri=" + this.uri + ", cropImageOptions=" + this.cropImageOptions + ")";
    }

    public CropImageContractOptions(Uri uri, CropImageOptions cropImageOptions) {
        Intrinsics.checkNotNullParameter(cropImageOptions, "cropImageOptions");
        this.uri = uri;
        this.cropImageOptions = cropImageOptions;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final CropImageOptions getCropImageOptions() {
        return this.cropImageOptions;
    }

    public final CropImageContractOptions setImageSource(boolean includeGallery, boolean includeCamera) {
        this.cropImageOptions.imageSourceIncludeGallery = includeGallery;
        this.cropImageOptions.imageSourceIncludeCamera = includeCamera;
        return this;
    }

    public final CropImageContractOptions setCropShape(CropImageView.CropShape cropShape) {
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        this.cropImageOptions.cropShape = cropShape;
        return this;
    }

    public final CropImageContractOptions setCropCornerShape(CropImageView.CropCornerShape cornerShape) {
        Intrinsics.checkNotNullParameter(cornerShape, "cornerShape");
        this.cropImageOptions.cornerShape = cornerShape;
        return this;
    }

    public final CropImageContractOptions setCircleCornerFillColor(int circleFillColorHexValue) {
        this.cropImageOptions.circleCornerFillColorHexValue = circleFillColorHexValue;
        return this;
    }

    public final CropImageContractOptions setCropCornerRadius(float cornerRadius) {
        this.cropImageOptions.cropCornerRadius = cornerRadius;
        return this;
    }

    public final CropImageContractOptions setSnapRadius(float snapRadius) {
        this.cropImageOptions.snapRadius = snapRadius;
        return this;
    }

    public final CropImageContractOptions setTouchRadius(float touchRadius) {
        this.cropImageOptions.touchRadius = touchRadius;
        return this;
    }

    public final CropImageContractOptions setGuidelines(CropImageView.Guidelines guidelines) {
        Intrinsics.checkNotNullParameter(guidelines, "guidelines");
        this.cropImageOptions.guidelines = guidelines;
        return this;
    }

    public final CropImageContractOptions setScaleType(CropImageView.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.cropImageOptions.scaleType = scaleType;
        return this;
    }

    public final CropImageContractOptions setShowCropOverlay(boolean showCropOverlay) {
        this.cropImageOptions.showCropOverlay = showCropOverlay;
        return this;
    }

    public final CropImageContractOptions setShowCropLabel(boolean showCropLabel) {
        this.cropImageOptions.showCropLabel = showCropLabel;
        return this;
    }

    public final CropImageContractOptions setAutoZoomEnabled(boolean autoZoomEnabled) {
        this.cropImageOptions.autoZoomEnabled = autoZoomEnabled;
        return this;
    }

    public final CropImageContractOptions setMultiTouchEnabled(boolean multiTouchEnabled) {
        this.cropImageOptions.multiTouchEnabled = multiTouchEnabled;
        return this;
    }

    public final CropImageContractOptions setCenterMoveEnabled(boolean centerMoveEnabled) {
        this.cropImageOptions.centerMoveEnabled = centerMoveEnabled;
        return this;
    }

    public final CropImageContractOptions setMaxZoom(int maxZoom) {
        this.cropImageOptions.maxZoom = maxZoom;
        return this;
    }

    public final CropImageContractOptions setInitialCropWindowPaddingRatio(float initialCropWindowPaddingRatio) {
        this.cropImageOptions.initialCropWindowPaddingRatio = initialCropWindowPaddingRatio;
        return this;
    }

    public final CropImageContractOptions setFixAspectRatio(boolean fixAspectRatio) {
        this.cropImageOptions.fixAspectRatio = fixAspectRatio;
        return this;
    }

    public final CropImageContractOptions setAspectRatio(int aspectRatioX, int aspectRatioY) {
        this.cropImageOptions.aspectRatioX = aspectRatioX;
        this.cropImageOptions.aspectRatioY = aspectRatioY;
        this.cropImageOptions.fixAspectRatio = true;
        return this;
    }

    public final CropImageContractOptions setBorderLineThickness(float borderLineThickness) {
        this.cropImageOptions.borderLineThickness = borderLineThickness;
        return this;
    }

    public final CropImageContractOptions setBorderLineColor(int borderLineColor) {
        this.cropImageOptions.borderLineColor = borderLineColor;
        return this;
    }

    public final CropImageContractOptions setBorderCornerThickness(float borderCornerThickness) {
        this.cropImageOptions.borderCornerThickness = borderCornerThickness;
        return this;
    }

    public final CropImageContractOptions setBorderCornerOffset(float borderCornerOffset) {
        this.cropImageOptions.borderCornerOffset = borderCornerOffset;
        return this;
    }

    public final CropImageContractOptions setBorderCornerLength(float borderCornerLength) {
        this.cropImageOptions.borderCornerLength = borderCornerLength;
        return this;
    }

    public final CropImageContractOptions setBorderCornerColor(int borderCornerColor) {
        this.cropImageOptions.borderCornerColor = borderCornerColor;
        return this;
    }

    public final CropImageContractOptions setGuidelinesThickness(float guidelinesThickness) {
        this.cropImageOptions.guidelinesThickness = guidelinesThickness;
        return this;
    }

    public final CropImageContractOptions setGuidelinesColor(int guidelinesColor) {
        this.cropImageOptions.guidelinesColor = guidelinesColor;
        return this;
    }

    public final CropImageContractOptions setBackgroundColor(int backgroundColor) {
        this.cropImageOptions.backgroundColor = backgroundColor;
        return this;
    }

    public final CropImageContractOptions setMinCropWindowSize(int minCropWindowWidth, int minCropWindowHeight) {
        this.cropImageOptions.minCropWindowWidth = minCropWindowWidth;
        this.cropImageOptions.minCropWindowHeight = minCropWindowHeight;
        return this;
    }

    public final CropImageContractOptions setMinCropResultSize(int minCropResultWidth, int minCropResultHeight) {
        this.cropImageOptions.minCropResultWidth = minCropResultWidth;
        this.cropImageOptions.minCropResultHeight = minCropResultHeight;
        return this;
    }

    public final CropImageContractOptions setMaxCropResultSize(int maxCropResultWidth, int maxCropResultHeight) {
        this.cropImageOptions.maxCropResultWidth = maxCropResultWidth;
        this.cropImageOptions.maxCropResultHeight = maxCropResultHeight;
        return this;
    }

    public final CropImageContractOptions setActivityTitle(CharSequence activityTitle) {
        Intrinsics.checkNotNullParameter(activityTitle, "activityTitle");
        this.cropImageOptions.activityTitle = activityTitle;
        return this;
    }

    public final CropImageContractOptions setActivityMenuIconColor(int activityMenuIconColor) {
        this.cropImageOptions.activityMenuIconColor = activityMenuIconColor;
        return this;
    }

    public final CropImageContractOptions setOutputUri(Uri outputUri) {
        this.cropImageOptions.customOutputUri = outputUri;
        return this;
    }

    public final CropImageContractOptions setOutputCompressFormat(Bitmap.CompressFormat outputCompressFormat) {
        Intrinsics.checkNotNullParameter(outputCompressFormat, "outputCompressFormat");
        this.cropImageOptions.outputCompressFormat = outputCompressFormat;
        return this;
    }

    public final CropImageContractOptions setOutputCompressQuality(int outputCompressQuality) {
        this.cropImageOptions.outputCompressQuality = outputCompressQuality;
        return this;
    }

    public final CropImageContractOptions setRequestedSize(int reqWidth, int reqHeight) {
        return setRequestedSize(reqWidth, reqHeight, CropImageView.RequestSizeOptions.RESIZE_INSIDE);
    }

    public final CropImageContractOptions setRequestedSize(int reqWidth, int reqHeight, CropImageView.RequestSizeOptions reqSizeOptions) {
        Intrinsics.checkNotNullParameter(reqSizeOptions, "reqSizeOptions");
        this.cropImageOptions.outputRequestWidth = reqWidth;
        this.cropImageOptions.outputRequestHeight = reqHeight;
        this.cropImageOptions.outputRequestSizeOptions = reqSizeOptions;
        return this;
    }

    public final CropImageContractOptions setNoOutputImage(boolean noOutputImage) {
        this.cropImageOptions.noOutputImage = noOutputImage;
        return this;
    }

    public final CropImageContractOptions setInitialCropWindowRectangle(Rect initialCropWindowRectangle) {
        this.cropImageOptions.initialCropWindowRectangle = initialCropWindowRectangle;
        return this;
    }

    public final CropImageContractOptions setInitialRotation(int initialRotation) {
        this.cropImageOptions.initialRotation = (initialRotation + CropImageOptions.DEGREES_360) % CropImageOptions.DEGREES_360;
        return this;
    }

    public final CropImageContractOptions setAllowRotation(boolean allowRotation) {
        this.cropImageOptions.allowRotation = allowRotation;
        return this;
    }

    public final CropImageContractOptions setAllowFlipping(boolean allowFlipping) {
        this.cropImageOptions.allowFlipping = allowFlipping;
        return this;
    }

    public final CropImageContractOptions setAllowCounterRotation(boolean allowCounterRotation) {
        this.cropImageOptions.allowCounterRotation = allowCounterRotation;
        return this;
    }

    public final CropImageContractOptions setRotationDegrees(int rotationDegrees) {
        this.cropImageOptions.rotationDegrees = (rotationDegrees + CropImageOptions.DEGREES_360) % CropImageOptions.DEGREES_360;
        return this;
    }

    public final CropImageContractOptions setFlipHorizontally(boolean flipHorizontally) {
        this.cropImageOptions.flipHorizontally = flipHorizontally;
        return this;
    }

    public final CropImageContractOptions setFlipVertically(boolean flipVertically) {
        this.cropImageOptions.flipVertically = flipVertically;
        return this;
    }

    public final CropImageContractOptions setCropMenuCropButtonTitle(CharSequence title) {
        this.cropImageOptions.cropMenuCropButtonTitle = title;
        return this;
    }

    public final CropImageContractOptions setCropMenuCropButtonIcon(int drawableResource) {
        this.cropImageOptions.cropMenuCropButtonIcon = drawableResource;
        return this;
    }

    public final CropImageContractOptions setSkipEditing(boolean skipEditing) {
        this.cropImageOptions.skipEditing = skipEditing;
        this.cropImageOptions.showCropOverlay = !skipEditing;
        return this;
    }

    public final CropImageOptions setShowIntentChooser(boolean showIntentChooser) {
        CropImageOptions cropImageOptions = this.cropImageOptions;
        cropImageOptions.showIntentChooser = showIntentChooser;
        return cropImageOptions;
    }

    public final CropImageOptions setIntentChooserTitle(String intentChooserTitle) {
        Intrinsics.checkNotNullParameter(intentChooserTitle, "intentChooserTitle");
        CropImageOptions cropImageOptions = this.cropImageOptions;
        cropImageOptions.intentChooserTitle = intentChooserTitle;
        return cropImageOptions;
    }

    public final CropImageOptions setIntentChooserPriorityList(List<String> priorityAppPackages) {
        Intrinsics.checkNotNullParameter(priorityAppPackages, "priorityAppPackages");
        CropImageOptions cropImageOptions = this.cropImageOptions;
        cropImageOptions.intentChooserPriorityList = priorityAppPackages;
        return cropImageOptions;
    }
}
