package expo.modules.imagemanipulator;

import com.swmansion.reanimated.layoutReanimation.Snapshot;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* compiled from: ImageManipulatorArguments.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Lexpo/modules/imagemanipulator/CropRect;", "Lexpo/modules/kotlin/records/Record;", "()V", "height", "", "getHeight$annotations", "getHeight", "()D", Snapshot.ORIGIN_X, "getOriginX$annotations", "getOriginX", Snapshot.ORIGIN_Y, "getOriginY$annotations", "getOriginY", "width", "getWidth$annotations", "getWidth", "expo-image-manipulator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CropRect implements Record {
    private final double height;
    private final double originX;
    private final double originY;
    private final double width;

    @Field
    public static /* synthetic */ void getHeight$annotations() {
    }

    @Field
    public static /* synthetic */ void getOriginX$annotations() {
    }

    @Field
    public static /* synthetic */ void getOriginY$annotations() {
    }

    @Field
    public static /* synthetic */ void getWidth$annotations() {
    }

    public final double getOriginX() {
        return this.originX;
    }

    public final double getOriginY() {
        return this.originY;
    }

    public final double getWidth() {
        return this.width;
    }

    public final double getHeight() {
        return this.height;
    }
}
