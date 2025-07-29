package expo.modules.camera;

import androidx.camera.video.AudioStats;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Options.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b/\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005¢\u0006\u0002\u0010\u0012J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\u0017\u00102\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bHÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010 J\t\u00107\u001a\u00020\u000fHÆ\u0003J\u0082\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010<\u001a\u00020\u000fHÖ\u0001J\t\u0010=\u001a\u00020\tHÖ\u0001R*\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0019R\u001c\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0019R \u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010!\u0012\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010$R\u001c\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0014\u001a\u0004\b&\u0010\u0019R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0014\u001a\u0004\b(\u0010)R\u001c\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0014\u001a\u0004\b+\u0010\u0019R\u001c\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0014\u001a\u0004\b-\u0010\u0019¨\u0006>"}, d2 = {"Lexpo/modules/camera/PictureOptions;", "Lexpo/modules/kotlin/records/Record;", "quality", "", "base64", "", "exif", "additionalExif", "", "", "", "mirror", "skipProcessing", "fastMode", "id", "", "maxDownsampling", "shutterSound", "(DZZLjava/util/Map;ZZZLjava/lang/Integer;IZ)V", "getAdditionalExif$annotations", "()V", "getAdditionalExif", "()Ljava/util/Map;", "getBase64$annotations", "getBase64", "()Z", "getExif$annotations", "getExif", "getFastMode$annotations", "getFastMode", "getId$annotations", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxDownsampling$annotations", "getMaxDownsampling", "()I", "getMirror$annotations", "getMirror", "getQuality$annotations", "getQuality", "()D", "getShutterSound$annotations", "getShutterSound", "getSkipProcessing$annotations", "getSkipProcessing", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(DZZLjava/util/Map;ZZZLjava/lang/Integer;IZ)Lexpo/modules/camera/PictureOptions;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PictureOptions implements Record {
    private final Map<String, Object> additionalExif;
    private final boolean base64;
    private final boolean exif;
    private final boolean fastMode;
    private final Integer id;
    private final int maxDownsampling;
    private final boolean mirror;
    private final double quality;
    private final boolean shutterSound;
    private final boolean skipProcessing;

    public PictureOptions() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, false, false, null, false, false, false, null, 0, false, 1023, null);
    }

    @Field
    public static /* synthetic */ void getAdditionalExif$annotations() {
    }

    @Field
    public static /* synthetic */ void getBase64$annotations() {
    }

    @Field
    public static /* synthetic */ void getExif$annotations() {
    }

    @Field
    public static /* synthetic */ void getFastMode$annotations() {
    }

    @Field
    public static /* synthetic */ void getId$annotations() {
    }

    @Field
    public static /* synthetic */ void getMaxDownsampling$annotations() {
    }

    @Field
    public static /* synthetic */ void getMirror$annotations() {
    }

    @Field
    public static /* synthetic */ void getQuality$annotations() {
    }

    @Field
    public static /* synthetic */ void getShutterSound$annotations() {
    }

    @Field
    public static /* synthetic */ void getSkipProcessing$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final double getQuality() {
        return this.quality;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getShutterSound() {
        return this.shutterSound;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getBase64() {
        return this.base64;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getExif() {
        return this.exif;
    }

    public final Map<String, Object> component4() {
        return this.additionalExif;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getMirror() {
        return this.mirror;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getSkipProcessing() {
        return this.skipProcessing;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getFastMode() {
        return this.fastMode;
    }

    /* renamed from: component8, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    /* renamed from: component9, reason: from getter */
    public final int getMaxDownsampling() {
        return this.maxDownsampling;
    }

    public final PictureOptions copy(double quality, boolean base64, boolean exif, Map<String, ? extends Object> additionalExif, boolean mirror, boolean skipProcessing, boolean fastMode, Integer id, int maxDownsampling, boolean shutterSound) {
        return new PictureOptions(quality, base64, exif, additionalExif, mirror, skipProcessing, fastMode, id, maxDownsampling, shutterSound);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PictureOptions)) {
            return false;
        }
        PictureOptions pictureOptions = (PictureOptions) other;
        return Double.compare(this.quality, pictureOptions.quality) == 0 && this.base64 == pictureOptions.base64 && this.exif == pictureOptions.exif && Intrinsics.areEqual(this.additionalExif, pictureOptions.additionalExif) && this.mirror == pictureOptions.mirror && this.skipProcessing == pictureOptions.skipProcessing && this.fastMode == pictureOptions.fastMode && Intrinsics.areEqual(this.id, pictureOptions.id) && this.maxDownsampling == pictureOptions.maxDownsampling && this.shutterSound == pictureOptions.shutterSound;
    }

    public int hashCode() {
        int iHashCode = ((((Double.hashCode(this.quality) * 31) + Boolean.hashCode(this.base64)) * 31) + Boolean.hashCode(this.exif)) * 31;
        Map<String, Object> map = this.additionalExif;
        int iHashCode2 = (((((((iHashCode + (map == null ? 0 : map.hashCode())) * 31) + Boolean.hashCode(this.mirror)) * 31) + Boolean.hashCode(this.skipProcessing)) * 31) + Boolean.hashCode(this.fastMode)) * 31;
        Integer num = this.id;
        return ((((iHashCode2 + (num != null ? num.hashCode() : 0)) * 31) + Integer.hashCode(this.maxDownsampling)) * 31) + Boolean.hashCode(this.shutterSound);
    }

    public String toString() {
        return "PictureOptions(quality=" + this.quality + ", base64=" + this.base64 + ", exif=" + this.exif + ", additionalExif=" + this.additionalExif + ", mirror=" + this.mirror + ", skipProcessing=" + this.skipProcessing + ", fastMode=" + this.fastMode + ", id=" + this.id + ", maxDownsampling=" + this.maxDownsampling + ", shutterSound=" + this.shutterSound + ")";
    }

    public PictureOptions(double d, boolean z, boolean z2, Map<String, ? extends Object> map, boolean z3, boolean z4, boolean z5, Integer num, int i, boolean z6) {
        this.quality = d;
        this.base64 = z;
        this.exif = z2;
        this.additionalExif = map;
        this.mirror = z3;
        this.skipProcessing = z4;
        this.fastMode = z5;
        this.id = num;
        this.maxDownsampling = i;
        this.shutterSound = z6;
    }

    public /* synthetic */ PictureOptions(double d, boolean z, boolean z2, Map map, boolean z3, boolean z4, boolean z5, Integer num, int i, boolean z6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1.0d : d, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? null : map, (i2 & 16) != 0 ? false : z3, (i2 & 32) != 0 ? false : z4, (i2 & 64) == 0 ? z5 : false, (i2 & 128) == 0 ? num : null, (i2 & 256) != 0 ? 1 : i, (i2 & 512) == 0 ? z6 : true);
    }

    public final double getQuality() {
        return this.quality;
    }

    public final boolean getBase64() {
        return this.base64;
    }

    public final boolean getExif() {
        return this.exif;
    }

    public final Map<String, Object> getAdditionalExif() {
        return this.additionalExif;
    }

    public final boolean getMirror() {
        return this.mirror;
    }

    public final boolean getSkipProcessing() {
        return this.skipProcessing;
    }

    public final boolean getFastMode() {
        return this.fastMode;
    }

    public final Integer getId() {
        return this.id;
    }

    public final int getMaxDownsampling() {
        return this.maxDownsampling;
    }

    public final boolean getShutterSound() {
        return this.shutterSound;
    }
}
