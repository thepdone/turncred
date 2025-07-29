package expo.modules.camera.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import androidx.camera.video.AudioStats;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraViewHelper.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0007J$\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012H\u0007¨\u0006\u0014"}, d2 = {"Lexpo/modules/camera/utils/CameraViewHelper;", "", "()V", "addExifData", "", "baseExif", "Landroidx/exifinterface/media/ExifInterface;", "additionalExif", "generateSimulatorPhoto", "", "width", "", "height", "getExifData", "Landroid/os/Bundle;", "exifInterface", "setExifData", "exifMap", "", "", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraViewHelper {
    public static final CameraViewHelper INSTANCE = new CameraViewHelper();

    private CameraViewHelper() {
    }

    @JvmStatic
    public static final Bundle getExifData(ExifInterface exifInterface) {
        Intrinsics.checkNotNullParameter(exifInterface, "exifInterface");
        Bundle bundle = new Bundle();
        for (String[] strArr : ExifTagsKt.getExifTags()) {
            String str = strArr[0];
            String str2 = strArr[1];
            if (exifInterface.getAttribute(str2) != null) {
                int iHashCode = str.hashCode();
                if (iHashCode != -1325958191) {
                    if (iHashCode != -891985903) {
                        if (iHashCode == 104431 && str.equals("int")) {
                            bundle.putInt(str2, exifInterface.getAttributeInt(str2, 0));
                        }
                    } else if (str.equals("string")) {
                        bundle.putString(str2, exifInterface.getAttribute(str2));
                    }
                } else if (str.equals("double")) {
                    bundle.putDouble(str2, exifInterface.getAttributeDouble(str2, AudioStats.AUDIO_AMPLITUDE_NONE));
                }
            }
        }
        double[] latLong = exifInterface.getLatLong();
        if (latLong != null) {
            bundle.putDouble(ExifInterface.TAG_GPS_LATITUDE, latLong[0]);
            bundle.putDouble(ExifInterface.TAG_GPS_LONGITUDE, latLong[1]);
            bundle.putDouble(ExifInterface.TAG_GPS_ALTITUDE, exifInterface.getAltitude(AudioStats.AUDIO_AMPLITUDE_NONE));
        }
        return bundle;
    }

    @JvmStatic
    public static final void setExifData(ExifInterface baseExif, Map<String, ? extends Object> exifMap) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(baseExif, "baseExif");
        Intrinsics.checkNotNullParameter(exifMap, "exifMap");
        for (String[] strArr : ExifTagsKt.getExifTags()) {
            String str = strArr[1];
            Object obj = exifMap.get(str);
            if (obj != null) {
                if (obj instanceof String) {
                    baseExif.setAttribute(str, (String) obj);
                } else if (obj instanceof Number) {
                    baseExif.setAttribute(str, new BigDecimal(String.valueOf(((Number) obj).doubleValue())).toPlainString());
                } else if (obj instanceof Boolean) {
                    baseExif.setAttribute(str, obj.toString());
                }
            }
        }
        if (exifMap.containsKey(ExifInterface.TAG_GPS_LATITUDE) && exifMap.containsKey(ExifInterface.TAG_GPS_LONGITUDE) && (exifMap.get(ExifInterface.TAG_GPS_LATITUDE) instanceof Number) && (exifMap.get(ExifInterface.TAG_GPS_LONGITUDE) instanceof Number)) {
            Object obj2 = exifMap.get(ExifInterface.TAG_GPS_LATITUDE);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Double");
            double dDoubleValue = ((Double) obj2).doubleValue();
            Object obj3 = exifMap.get(ExifInterface.TAG_GPS_LONGITUDE);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Double");
            baseExif.setLatLong(dDoubleValue, ((Double) obj3).doubleValue());
        }
        if (exifMap.containsKey(ExifInterface.TAG_GPS_ALTITUDE) && (exifMap.get(ExifInterface.TAG_GPS_ALTITUDE) instanceof Number)) {
            Object obj4 = exifMap.get(ExifInterface.TAG_GPS_ALTITUDE);
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Double");
            baseExif.setAltitude(((Double) obj4).doubleValue());
        }
    }

    @JvmStatic
    public static final void addExifData(ExifInterface baseExif, ExifInterface additionalExif) throws Throwable {
        Intrinsics.checkNotNullParameter(baseExif, "baseExif");
        Intrinsics.checkNotNullParameter(additionalExif, "additionalExif");
        for (String[] strArr : ExifTagsKt.getExifTags()) {
            String str = strArr[1];
            String attribute = additionalExif.getAttribute(str);
            if (attribute != null) {
                baseExif.setAttribute(str, attribute);
            }
        }
        baseExif.saveAttributes();
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
        Intrinsics.checkNotNull(byteArray);
        return byteArray;
    }
}
