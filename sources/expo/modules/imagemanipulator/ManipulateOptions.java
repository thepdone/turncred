package expo.modules.imagemanipulator;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* compiled from: ImageManipulatorArguments.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lexpo/modules/imagemanipulator/ManipulateOptions;", "Lexpo/modules/kotlin/records/Record;", "()V", "base64", "", "getBase64$annotations", "getBase64", "()Z", "compress", "", "getCompress$annotations", "getCompress", "()D", "format", "Lexpo/modules/imagemanipulator/ImageFormat;", "getFormat$annotations", "getFormat", "()Lexpo/modules/imagemanipulator/ImageFormat;", "expo-image-manipulator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ManipulateOptions implements Record {
    private final boolean base64;
    private final double compress = 1.0d;
    private final ImageFormat format = ImageFormat.JPEG;

    @Field
    public static /* synthetic */ void getBase64$annotations() {
    }

    @Field
    public static /* synthetic */ void getCompress$annotations() {
    }

    @Field
    public static /* synthetic */ void getFormat$annotations() {
    }

    public final boolean getBase64() {
        return this.base64;
    }

    public final double getCompress() {
        return this.compress;
    }

    public final ImageFormat getFormat() {
        return this.format;
    }
}
