package expo.modules.imagemanipulator;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* compiled from: ImageManipulatorArguments.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Lexpo/modules/imagemanipulator/ResizeOptions;", "Lexpo/modules/kotlin/records/Record;", "()V", "height", "", "getHeight$annotations", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "width", "getWidth$annotations", "getWidth", "expo-image-manipulator_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ResizeOptions implements Record {
    private final Integer height;
    private final Integer width;

    @Field
    public static /* synthetic */ void getHeight$annotations() {
    }

    @Field
    public static /* synthetic */ void getWidth$annotations() {
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final Integer getHeight() {
        return this.height;
    }
}
