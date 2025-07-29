package com.canhub.cropper;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.content.FileProvider;
import com.canhub.cropper.CropException;
import com.canhub.cropper.CropImage;
import com.canhub.cropper.CropImageView;
import com.canhub.cropper.common.CommonValues;
import com.canhub.cropper.common.CommonVersionCheck;
import com.canhub.cropper.utils.GetFilePathFromUriKt;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CropImage.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u001a\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J$\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/canhub/cropper/CropImage;", "", "()V", "CAMERA_CAPTURE_PERMISSIONS_REQUEST_CODE", "", "CROP_IMAGE_ACTIVITY_REQUEST_CODE", "CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE", CropImage.CROP_IMAGE_EXTRA_BUNDLE, "", CropImage.CROP_IMAGE_EXTRA_OPTIONS, CropImage.CROP_IMAGE_EXTRA_RESULT, CropImage.CROP_IMAGE_EXTRA_SOURCE, "PICK_IMAGE_CHOOSER_REQUEST_CODE", "PICK_IMAGE_PERMISSIONS_REQUEST_CODE", "getCaptureImageOutputUriContent", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "getCaptureImageOutputUriFilePath", "uniqueName", "", "getPickImageResultUriContent", "data", "Landroid/content/Intent;", "getPickImageResultUriFilePath", "toOvalBitmap", "Landroid/graphics/Bitmap;", "bitmap", "ActivityResult", "CancelledResult", "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class CropImage {
    public static final int CAMERA_CAPTURE_PERMISSIONS_REQUEST_CODE = 2011;
    public static final int CROP_IMAGE_ACTIVITY_REQUEST_CODE = 203;
    public static final int CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE = 204;
    public static final String CROP_IMAGE_EXTRA_BUNDLE = "CROP_IMAGE_EXTRA_BUNDLE";
    public static final String CROP_IMAGE_EXTRA_OPTIONS = "CROP_IMAGE_EXTRA_OPTIONS";
    public static final String CROP_IMAGE_EXTRA_RESULT = "CROP_IMAGE_EXTRA_RESULT";
    public static final String CROP_IMAGE_EXTRA_SOURCE = "CROP_IMAGE_EXTRA_SOURCE";
    public static final CropImage INSTANCE = new CropImage();
    public static final int PICK_IMAGE_CHOOSER_REQUEST_CODE = 200;
    public static final int PICK_IMAGE_PERMISSIONS_REQUEST_CODE = 201;

    private CropImage() {
    }

    public final Bitmap toOvalBitmap(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawOval(new RectF(0.0f, 0.0f, width, height), paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        bitmap.recycle();
        Intrinsics.checkNotNullExpressionValue(output, "output");
        return output;
    }

    public final Uri getCaptureImageOutputUriContent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (CommonVersionCheck.INSTANCE.isAtLeastQ29()) {
            File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            try {
                String str = context.getPackageName() + CommonValues.authority;
                Intrinsics.checkNotNull(externalFilesDir);
                Uri uriForFile = FileProvider.getUriForFile(context, str, new File(externalFilesDir.getPath(), "pickImageResult.jpeg"));
                Intrinsics.checkNotNullExpressionValue(uriForFile, "{\n                FilePr…          )\n            }");
                return uriForFile;
            } catch (Exception unused) {
                Intrinsics.checkNotNull(externalFilesDir);
                Uri uriFromFile = Uri.fromFile(new File(externalFilesDir.getPath(), "pickImageResult.jpeg"));
                Intrinsics.checkNotNullExpressionValue(uriFromFile, "{\n                Uri.fr…ult.jpeg\"))\n            }");
                return uriFromFile;
            }
        }
        File externalCacheDir = context.getExternalCacheDir();
        Intrinsics.checkNotNull(externalCacheDir);
        Uri uriFromFile2 = Uri.fromFile(new File(externalCacheDir.getPath(), "pickImageResult.jpeg"));
        Intrinsics.checkNotNullExpressionValue(uriFromFile2, "fromFile(File(getImage!!… \"pickImageResult.jpeg\"))");
        return uriFromFile2;
    }

    public static /* synthetic */ String getCaptureImageOutputUriFilePath$default(CropImage cropImage, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return cropImage.getCaptureImageOutputUriFilePath(context, z);
    }

    public final String getCaptureImageOutputUriFilePath(Context context, boolean uniqueName) {
        Intrinsics.checkNotNullParameter(context, "context");
        return GetFilePathFromUriKt.getFilePathFromUri(context, getCaptureImageOutputUriContent(context), uniqueName);
    }

    @JvmStatic
    public static final Uri getPickImageResultUriContent(Context context, Intent data) {
        String action;
        Intrinsics.checkNotNullParameter(context, "context");
        Uri data2 = data != null ? data.getData() : null;
        return (data2 == null || ((action = data.getAction()) != null && Intrinsics.areEqual(action, "android.media.action.IMAGE_CAPTURE")) || data2 == null) ? INSTANCE.getCaptureImageOutputUriContent(context) : data2;
    }

    public static /* synthetic */ String getPickImageResultUriFilePath$default(Context context, Intent intent, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return getPickImageResultUriFilePath(context, intent, z);
    }

    @JvmStatic
    public static final String getPickImageResultUriFilePath(Context context, Intent data, boolean uniqueName) {
        Intrinsics.checkNotNullParameter(context, "context");
        return GetFilePathFromUriKt.getFilePathFromUri(context, getPickImageResultUriContent(context, data), uniqueName);
    }

    /* compiled from: CropImage.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aBY\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0002\u0010\u0011B\u000f\b\u0014\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u000eH\u0016¨\u0006\u001b"}, d2 = {"Lcom/canhub/cropper/CropImage$ActivityResult;", "Lcom/canhub/cropper/CropImageView$CropResult;", "Landroid/os/Parcelable;", "originalUri", "Landroid/net/Uri;", "uriContent", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "cropPoints", "", "cropRect", "Landroid/graphics/Rect;", ViewProps.ROTATION, "", "wholeImageRect", "sampleSize", "(Landroid/net/Uri;Landroid/net/Uri;Ljava/lang/Exception;[FLandroid/graphics/Rect;ILandroid/graphics/Rect;I)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "describeContents", "writeToParcel", "", "dest", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "Companion", "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class ActivityResult extends CropImageView.CropResult implements Parcelable {
        public static final Parcelable.Creator<ActivityResult> CREATOR = new Parcelable.Creator<ActivityResult>() { // from class: com.canhub.cropper.CropImage$ActivityResult$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CropImage.ActivityResult createFromParcel(Parcel in) {
                Intrinsics.checkNotNullParameter(in, "in");
                return new CropImage.ActivityResult(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CropImage.ActivityResult[] newArray(int size) {
                return new CropImage.ActivityResult[size];
            }
        };

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActivityResult(Uri uri, Uri uri2, Exception exc, float[] fArr, Rect rect, int i, Rect rect2, int i2) {
            super(null, uri, null, uri2, exc, fArr, rect, rect2, i, i2);
            Intrinsics.checkNotNull(fArr);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        protected ActivityResult(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            Uri uri = (Uri) in.readParcelable(Uri.class.getClassLoader());
            Uri uri2 = (Uri) in.readParcelable(Uri.class.getClassLoader());
            Exception exc = (Exception) in.readSerializable();
            float[] fArrCreateFloatArray = in.createFloatArray();
            Intrinsics.checkNotNull(fArrCreateFloatArray);
            super(null, uri, null, uri2, exc, fArrCreateFloatArray, (Rect) in.readParcelable(Rect.class.getClassLoader()), (Rect) in.readParcelable(Rect.class.getClassLoader()), in.readInt(), in.readInt());
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeParcelable(getOriginalUri(), flags);
            dest.writeParcelable(getUriContent(), flags);
            dest.writeSerializable(getError());
            dest.writeFloatArray(getCropPoints());
            dest.writeParcelable(getCropRect(), flags);
            dest.writeParcelable(getWholeImageRect(), flags);
            dest.writeInt(getRotation());
            dest.writeInt(getSampleSize());
        }
    }

    /* compiled from: CropImage.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/canhub/cropper/CropImage$CancelledResult;", "Lcom/canhub/cropper/CropImageView$CropResult;", "()V", "cropper_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CancelledResult extends CropImageView.CropResult {
        public static final CancelledResult INSTANCE = new CancelledResult();

        private CancelledResult() {
            super(null, null, null, null, new CropException.Cancellation(), new float[0], null, null, 0, 0);
        }
    }
}
