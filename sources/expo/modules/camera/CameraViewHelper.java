package expo.modules.camera;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.canhub.cropper.CropImageOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.camera.records.CameraType;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraViewHelper.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lexpo/modules/camera/CameraViewHelper;", "", "()V", "generateSimulatorPhoto", "", "width", "", "height", "getCorrectCameraRotation", ViewProps.ROTATION, "facing", "Lexpo/modules/camera/records/CameraType;", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraViewHelper {
    public static final CameraViewHelper INSTANCE = new CameraViewHelper();

    private CameraViewHelper() {
    }

    @JvmStatic
    public static final int getCorrectCameraRotation(int rotation, CameraType facing) {
        Intrinsics.checkNotNullParameter(facing, "facing");
        if (facing == CameraType.FRONT) {
            return (rotation + RotationOptions.ROTATE_270) % CropImageOptions.DEGREES_360;
        }
        return ((-rotation) + 450) % CropImageOptions.DEGREES_360;
    }

    public final byte[] generateSimulatorPhoto(int width, int height) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        float f = width;
        float f2 = height;
        canvas.drawRect(0.0f, 0.0f, f, f2, paint);
        Paint paint2 = new Paint();
        paint2.setColor(InputDeviceCompat.SOURCE_ANY);
        paint2.setTextSize(35.0f);
        canvas.drawText(new SimpleDateFormat("dd.MM.yy HH:mm:ss", Locale.US).format(Calendar.getInstance().getTime()), f * 0.1f, f2 * 0.9f, paint2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }
}
