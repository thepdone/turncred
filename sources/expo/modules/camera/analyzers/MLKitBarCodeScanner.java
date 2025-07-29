package expo.modules.camera.analyzers;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import expo.modules.interfaces.barcodescanner.BarCodeScannerResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: MLKitBarcodeAnalyzer.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lexpo/modules/camera/analyzers/MLKitBarCodeScanner;", "", "()V", "barCodeTypes", "", "", "barcodeScanner", "Lcom/google/mlkit/vision/barcode/BarcodeScanner;", "barcodeScannerOptions", "Lcom/google/mlkit/vision/barcode/BarcodeScannerOptions;", "areNewAndOldBarCodeTypesEqual", "", "newBarCodeTypes", "scan", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerResult;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSettings", "", "formats", "Companion", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MLKitBarCodeScanner {
    private static final String TAG = "MLKitBarCodeScanner";
    private List<Integer> barCodeTypes;
    private BarcodeScanner barcodeScanner;
    private BarcodeScannerOptions barcodeScannerOptions;

    public MLKitBarCodeScanner() {
        BarcodeScannerOptions barcodeScannerOptionsBuild = new BarcodeScannerOptions.Builder().setBarcodeFormats(0, new int[0]).build();
        Intrinsics.checkNotNullExpressionValue(barcodeScannerOptionsBuild, "build(...)");
        this.barcodeScannerOptions = barcodeScannerOptionsBuild;
        BarcodeScanner client = BarcodeScanning.getClient(barcodeScannerOptionsBuild);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
        this.barcodeScanner = client;
    }

    /* compiled from: MLKitBarcodeAnalyzer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.camera.analyzers.MLKitBarCodeScanner$scan$2", f = "MLKitBarcodeAnalyzer.kt", i = {0}, l = {28}, m = "invokeSuspend", n = {"inputImage"}, s = {"L$0"})
    /* renamed from: expo.modules.camera.analyzers.MLKitBarCodeScanner$scan$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends BarCodeScannerResult>>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        Object L$0;
        int label;
        final /* synthetic */ MLKitBarCodeScanner this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Bitmap bitmap, MLKitBarCodeScanner mLKitBarCodeScanner, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$bitmap = bitmap;
            this.this$0 = mLKitBarCodeScanner;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$bitmap, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends BarCodeScannerResult>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            InputImage inputImage;
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    InputImage inputImageFromBitmap = InputImage.fromBitmap(this.$bitmap, 0);
                    Intrinsics.checkNotNullExpressionValue(inputImageFromBitmap, "fromBitmap(...)");
                    Task<List<Barcode>> taskProcess = this.this$0.barcodeScanner.process(inputImageFromBitmap);
                    Intrinsics.checkNotNullExpressionValue(taskProcess, "process(...)");
                    this.L$0 = inputImageFromBitmap;
                    this.label = 1;
                    Object objAwait = MLKitBarcodeAnalyzerKt.await(taskProcess, this);
                    if (objAwait == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    inputImage = inputImageFromBitmap;
                    obj = objAwait;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    inputImage = (InputImage) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Intrinsics.checkNotNullExpressionValue(obj, "await(...)");
                List<Barcode> list = (List) obj;
                ArrayList arrayList = new ArrayList();
                if (list.isEmpty()) {
                    return arrayList;
                }
                for (Barcode barcode : list) {
                    String rawValue = barcode.getRawValue();
                    if (rawValue != null) {
                        str = rawValue;
                    } else {
                        byte[] rawBytes = barcode.getRawBytes();
                        if (rawBytes != null) {
                            str = new String(rawBytes, Charsets.UTF_8);
                        } else {
                            rawValue = null;
                            str = rawValue;
                        }
                    }
                    String displayValue = barcode.getValueType() == 1 ? str : barcode.getDisplayValue();
                    ArrayList arrayList2 = new ArrayList();
                    Point[] cornerPoints = barcode.getCornerPoints();
                    if (cornerPoints != null) {
                        for (Point point : cornerPoints) {
                            arrayList2.addAll(CollectionsKt.listOf((Object[]) new Integer[]{Boxing.boxInt(point.x), Boxing.boxInt(point.y)}));
                        }
                    }
                    arrayList.add(new BarCodeScannerResult(barcode.getFormat(), displayValue, str, arrayList2, inputImage.getHeight(), inputImage.getWidth()));
                }
                return arrayList;
            } catch (Exception e) {
                Log.e(MLKitBarCodeScanner.TAG, "Failed to detect barcode: " + e.getMessage());
                return CollectionsKt.emptyList();
            }
        }
    }

    public final Object scan(Bitmap bitmap, Continuation<? super List<? extends BarCodeScannerResult>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(bitmap, this, null), continuation);
    }

    public final void setSettings(List<Integer> formats) {
        Intrinsics.checkNotNullParameter(formats, "formats");
        if (areNewAndOldBarCodeTypesEqual(formats)) {
            return;
        }
        Iterator<T> it = formats.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = Integer.valueOf(((Number) next).intValue() | ((Number) it.next()).intValue());
        }
        int iIntValue = ((Number) next).intValue();
        this.barCodeTypes = formats;
        BarcodeScannerOptions barcodeScannerOptionsBuild = new BarcodeScannerOptions.Builder().setBarcodeFormats(iIntValue, new int[0]).build();
        Intrinsics.checkNotNullExpressionValue(barcodeScannerOptionsBuild, "build(...)");
        this.barcodeScannerOptions = barcodeScannerOptionsBuild;
        BarcodeScanner client = BarcodeScanning.getClient(barcodeScannerOptionsBuild);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
        this.barcodeScanner = client;
    }

    private final boolean areNewAndOldBarCodeTypesEqual(List<Integer> newBarCodeTypes) {
        List<Integer> list = this.barCodeTypes;
        if (list == null) {
            return false;
        }
        HashSet hashSet = CollectionsKt.toHashSet(list);
        HashSet hashSet2 = CollectionsKt.toHashSet(newBarCodeTypes);
        if (hashSet.size() != hashSet2.size()) {
            return false;
        }
        hashSet.removeAll(hashSet2);
        return hashSet.isEmpty();
    }
}
