package expo.modules.imagepicker.exporters;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import androidx.camera.video.AudioStats;
import androidx.exifinterface.media.ExifInterface;
import expo.modules.imagepicker.FailedToReadFileException;
import expo.modules.imagepicker.ImagePickerConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.InterruptibleKt;

/* compiled from: ImageExporter.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0012"}, d2 = {"Lexpo/modules/imagepicker/exporters/ImageExportResult;", "", "width", "", "height", "imageFile", "Ljava/io/File;", "(IILjava/io/File;)V", "getHeight", "()I", "getWidth", "data", "Ljava/io/ByteArrayOutputStream;", "contentResolver", "Landroid/content/ContentResolver;", "(Landroid/content/ContentResolver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exif", "Landroid/os/Bundle;", "expo-image-picker_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class ImageExportResult {
    private final int height;
    private final File imageFile;
    private final int width;

    public Object data(ContentResolver contentResolver, Continuation<? super ByteArrayOutputStream> continuation) {
        return data$suspendImpl(this, contentResolver, continuation);
    }

    public Object exif(ContentResolver contentResolver, Continuation<? super Bundle> continuation) {
        return exif$suspendImpl(this, contentResolver, continuation);
    }

    public ImageExportResult(int i, int i2, File imageFile) {
        Intrinsics.checkNotNullParameter(imageFile, "imageFile");
        this.width = i;
        this.height = i2;
        this.imageFile = imageFile;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    static /* synthetic */ Object data$suspendImpl(final ImageExportResult imageExportResult, final ContentResolver contentResolver, Continuation<? super ByteArrayOutputStream> continuation) {
        return InterruptibleKt.runInterruptible$default(null, new Function0<ByteArrayOutputStream>() { // from class: expo.modules.imagepicker.exporters.ImageExportResult.data.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ByteArrayOutputStream invoke() throws FailedToReadFileException, FileNotFoundException {
                InputStream inputStreamOpenInputStream = contentResolver.openInputStream(Uri.fromFile(imageExportResult.imageFile));
                if (inputStreamOpenInputStream != null) {
                    ByteArrayOutputStream byteArrayOutputStream = inputStreamOpenInputStream;
                    try {
                        InputStream inputStream = byteArrayOutputStream;
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                            ByteStreamsKt.copyTo$default(inputStream, byteArrayOutputStream2, 0, 2, null);
                            CloseableKt.closeFinally(byteArrayOutputStream, null);
                            CloseableKt.closeFinally(byteArrayOutputStream, null);
                            return byteArrayOutputStream2;
                        } finally {
                        }
                    } finally {
                    }
                } else {
                    throw new FailedToReadFileException(imageExportResult.imageFile, null, 2, null);
                }
            }
        }, continuation, 1, null);
    }

    static /* synthetic */ Object exif$suspendImpl(final ImageExportResult imageExportResult, final ContentResolver contentResolver, Continuation<? super Bundle> continuation) {
        return InterruptibleKt.runInterruptible$default(null, new Function0<Bundle>() { // from class: expo.modules.imagepicker.exporters.ImageExportResult.exif.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Bundle invoke() throws FailedToReadFileException, FileNotFoundException {
                InputStream inputStreamOpenInputStream = contentResolver.openInputStream(Uri.fromFile(imageExportResult.imageFile));
                if (inputStreamOpenInputStream != null) {
                    InputStream inputStream = inputStreamOpenInputStream;
                    try {
                        Bundle bundle = new Bundle();
                        ExifInterface exifInterface = new ExifInterface(inputStream);
                        Iterable<Pair<String, String>> exif_tags = ImagePickerConstants.INSTANCE.getEXIF_TAGS();
                        ArrayList<Pair> arrayList = new ArrayList();
                        for (Pair<String, String> pair : exif_tags) {
                            if (exifInterface.getAttribute(pair.component2()) != null) {
                                arrayList.add(pair);
                            }
                        }
                        for (Pair pair2 : arrayList) {
                            String str = (String) pair2.component1();
                            String str2 = (String) pair2.component2();
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
                        double[] latLong = exifInterface.getLatLong();
                        if (latLong != null) {
                            bundle.putDouble(ExifInterface.TAG_GPS_LATITUDE, latLong[0]);
                            bundle.putDouble(ExifInterface.TAG_GPS_LONGITUDE, latLong[1]);
                            bundle.putDouble(ExifInterface.TAG_GPS_ALTITUDE, exifInterface.getAltitude(AudioStats.AUDIO_AMPLITUDE_NONE));
                        }
                        CloseableKt.closeFinally(inputStream, null);
                        return bundle;
                    } finally {
                    }
                } else {
                    throw new FailedToReadFileException(imageExportResult.imageFile, null, 2, null);
                }
            }
        }, continuation, 1, null);
    }
}
