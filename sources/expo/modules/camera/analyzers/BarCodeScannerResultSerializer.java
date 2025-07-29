package expo.modules.camera.analyzers;

import android.os.Bundle;
import android.util.Pair;
import expo.modules.interfaces.barcodescanner.BarCodeScannerResult;
import io.sentry.rrweb.RRWebVideoEvent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BarcodeScannerResultSerializer.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JB\u0010\u0003\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0004\u0012\u00020\u00060\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0002J\u0016\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u0018"}, d2 = {"Lexpo/modules/camera/analyzers/BarCodeScannerResultSerializer;", "", "()V", "getCornerPointsAndBoundingBox", "Landroid/util/Pair;", "Ljava/util/ArrayList;", "Landroid/os/Bundle;", "Lkotlin/collections/ArrayList;", "cornerPoints", "", "", "boundingBox", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerResult$BoundingBox;", "density", "", "getPoint", "x", "y", "getSize", "width", "height", "toBundle", "result", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerResult;", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BarCodeScannerResultSerializer {
    public static final BarCodeScannerResultSerializer INSTANCE = new BarCodeScannerResultSerializer();

    private BarCodeScannerResultSerializer() {
    }

    public final Bundle toBundle(BarCodeScannerResult result, float density) {
        Intrinsics.checkNotNullParameter(result, "result");
        Bundle bundle = new Bundle();
        bundle.putString("data", result.getValue());
        bundle.putString("raw", result.getRaw());
        bundle.putInt("type", result.getType());
        BarCodeScannerResultSerializer barCodeScannerResultSerializer = INSTANCE;
        List<Integer> cornerPoints = result.getCornerPoints();
        Intrinsics.checkNotNullExpressionValue(cornerPoints, "getCornerPoints(...)");
        BarCodeScannerResult.BoundingBox boundingBox = result.getBoundingBox();
        Intrinsics.checkNotNullExpressionValue(boundingBox, "getBoundingBox(...)");
        Pair<ArrayList<Bundle>, Bundle> cornerPointsAndBoundingBox = barCodeScannerResultSerializer.getCornerPointsAndBoundingBox(cornerPoints, boundingBox, density);
        bundle.putParcelableArrayList("cornerPoints", (ArrayList) cornerPointsAndBoundingBox.first);
        bundle.putBundle("bounds", (Bundle) cornerPointsAndBoundingBox.second);
        return bundle;
    }

    private final Pair<ArrayList<Bundle>, Bundle> getCornerPointsAndBoundingBox(List<Integer> cornerPoints, BarCodeScannerResult.BoundingBox boundingBox, float density) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, cornerPoints.size() - 1, 2);
        if (progressionLastElement >= 0) {
            while (true) {
                arrayList.add(getPoint(cornerPoints.get(i).intValue() / density, cornerPoints.get(i + 1).intValue() / density));
                if (i == progressionLastElement) {
                    break;
                }
                i += 2;
            }
        }
        Bundle bundle = new Bundle();
        BarCodeScannerResultSerializer barCodeScannerResultSerializer = INSTANCE;
        bundle.putParcelable("origin", barCodeScannerResultSerializer.getPoint(boundingBox.getX() / density, boundingBox.getY() / density));
        bundle.putParcelable(RRWebVideoEvent.JsonKeys.SIZE, barCodeScannerResultSerializer.getSize(boundingBox.getWidth() / density, boundingBox.getHeight() / density));
        return new Pair<>(arrayList, bundle);
    }

    private final Bundle getSize(float width, float height) {
        Bundle bundle = new Bundle();
        bundle.putFloat("width", width);
        bundle.putFloat("height", height);
        return bundle;
    }

    private final Bundle getPoint(float x, float y) {
        Bundle bundle = new Bundle();
        bundle.putFloat("x", x);
        bundle.putFloat("y", y);
        return bundle;
    }
}
