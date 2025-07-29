package expo.modules.camera;

import android.graphics.Bitmap;
import expo.modules.camera.analyzers.BarCodeScannerResultSerializer;
import expo.modules.camera.analyzers.MLKitBarCodeScanner;
import expo.modules.interfaces.barcodescanner.BarCodeScannerResult;
import expo.modules.kotlin.Promise;
import java.util.ArrayList;
import java.util.Collection;
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
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CameraViewModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.camera.CameraViewModule$definition$1$5$1$onSuccess$1", f = "CameraViewModule.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class CameraViewModule$definition$1$5$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ List<Integer> $formats;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ MLKitBarCodeScanner $scanner;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CameraViewModule$definition$1$5$1$onSuccess$1(MLKitBarCodeScanner mLKitBarCodeScanner, Bitmap bitmap, Promise promise, List<Integer> list, Continuation<? super CameraViewModule$definition$1$5$1$onSuccess$1> continuation) {
        super(2, continuation);
        this.$scanner = mLKitBarCodeScanner;
        this.$bitmap = bitmap;
        this.$promise = promise;
        this.$formats = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CameraViewModule$definition$1$5$1$onSuccess$1(this.$scanner, this.$bitmap, this.$promise, this.$formats, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CameraViewModule$definition$1$5$1$onSuccess$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.$scanner.scan(this.$bitmap, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        List<Integer> list = this.$formats;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (Iterable) obj) {
            if (list.contains(Boxing.boxInt(((BarCodeScannerResult) obj2).getType()))) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(BarCodeScannerResultSerializer.INSTANCE.toBundle((BarCodeScannerResult) it.next(), 1.0f));
        }
        this.$promise.resolve((Collection<? extends Object>) arrayList3);
        return Unit.INSTANCE;
    }
}
