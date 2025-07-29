package expo.modules.camera;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import androidx.camera.video.Recording;
import androidx.tracing.Trace;
import expo.modules.camera.CameraExceptions;
import expo.modules.camera.analyzers.MLKitBarCodeScanner;
import expo.modules.camera.records.BarcodeSettings;
import expo.modules.camera.records.BarcodeType;
import expo.modules.camera.records.CameraMode;
import expo.modules.camera.records.CameraRatio;
import expo.modules.camera.records.CameraType;
import expo.modules.camera.records.FlashMode;
import expo.modules.camera.records.FocusMode;
import expo.modules.camera.records.VideoQuality;
import expo.modules.core.errors.ModuleDestroyedException;
import expo.modules.core.utilities.EmulatorUtilities;
import expo.modules.interfaces.imageloader.ImageLoaderInterface;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.Queues;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.views.AnyViewProp;
import expo.modules.kotlin.views.ConcreteViewProp;
import expo.modules.kotlin.views.ViewDefinitionBuilder;
import expo.modules.kotlin.views.decorators.CSSPropsKt;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: CameraViewModule.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lexpo/modules/camera/CameraViewModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "cacheDirectory", "Ljava/io/File;", "getCacheDirectory", "()Ljava/io/File;", "moduleScope", "Lkotlinx/coroutines/CoroutineScope;", "permissionsManager", "Lexpo/modules/interfaces/permissions/Permissions;", "getPermissionsManager", "()Lexpo/modules/interfaces/permissions/Permissions;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "Companion", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraViewModule extends Module {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "CameraViewModule";
    private final CoroutineScope moduleScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2;
        AsyncFunctionComponent asyncFunctionComponent3;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent3;
        AsyncFunctionComponent asyncFunctionComponent4;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent4;
        AsyncFunctionComponent asyncFunctionComponent5;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent5;
        AsyncFunctionComponent asyncFunctionComponent6;
        AsyncFunctionComponent asyncFunctionComponent7;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent6;
        AsyncFunctionComponent asyncFunctionComponent8;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent7;
        CameraViewModule cameraViewModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (cameraViewModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(cameraViewModule);
            moduleDefinitionBuilder.Name("ExpoCamera");
            moduleDefinitionBuilder.Events("onModernBarcodeScanned");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("requestCameraPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$$inlined$AsyncFunction$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Permissions.askForPermissionsWithPermissionsManager(this.this$0.getPermissionsManager(), promise, "android.permission.CAMERA");
                    }
                });
            } else {
                AnyType[] anyTypeArr = new AnyType[1];
                AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType == null) {
                    anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Promise.class);
                        }
                    }));
                }
                anyTypeArr[0] = anyType;
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$$inlined$AsyncFunction$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Permissions.askForPermissionsWithPermissionsManager(this.this$0.getPermissionsManager(), (Promise) objArr[0], "android.permission.CAMERA");
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent = new StringAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr, function1);
                                } else {
                                    asyncFunctionComponent = new AsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr, function1);
                                }
                            } else {
                                asyncFunctionComponent = new FloatAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr, function1);
                            }
                        } else {
                            asyncFunctionComponent = new DoubleAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr, function1);
                        }
                    } else {
                        asyncFunctionComponent = new BoolAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr, function1);
                    }
                } else {
                    asyncFunctionComponent = new IntAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr, function1);
                }
                asyncFunctionWithPromiseComponent = asyncFunctionComponent;
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("requestCameraPermissionsAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("requestMicrophonePermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$$inlined$AsyncFunction$4
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Permissions.askForPermissionsWithPermissionsManager(this.this$0.getPermissionsManager(), promise, "android.permission.RECORD_AUDIO");
                    }
                });
            } else {
                AnyType[] anyTypeArr2 = new AnyType[1];
                AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType2 == null) {
                    anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$$inlined$AsyncFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Promise.class);
                        }
                    }));
                }
                anyTypeArr2[0] = anyType2;
                Function1<Object[], Unit> function12 = new Function1<Object[], Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$$inlined$AsyncFunction$6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Permissions.askForPermissionsWithPermissionsManager(this.this$0.getPermissionsManager(), (Promise) objArr[0], "android.permission.RECORD_AUDIO");
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent2 = new StringAsyncFunctionComponent("requestMicrophonePermissionsAsync", anyTypeArr2, function12);
                                } else {
                                    asyncFunctionComponent2 = new AsyncFunctionComponent("requestMicrophonePermissionsAsync", anyTypeArr2, function12);
                                }
                            } else {
                                asyncFunctionComponent2 = new FloatAsyncFunctionComponent("requestMicrophonePermissionsAsync", anyTypeArr2, function12);
                            }
                        } else {
                            asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("requestMicrophonePermissionsAsync", anyTypeArr2, function12);
                        }
                    } else {
                        asyncFunctionComponent2 = new BoolAsyncFunctionComponent("requestMicrophonePermissionsAsync", anyTypeArr2, function12);
                    }
                } else {
                    asyncFunctionComponent2 = new IntAsyncFunctionComponent("requestMicrophonePermissionsAsync", anyTypeArr2, function12);
                }
                asyncFunctionWithPromiseComponent2 = asyncFunctionComponent2;
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("requestMicrophonePermissionsAsync", asyncFunctionWithPromiseComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent("getCameraPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$$inlined$AsyncFunction$7
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Permissions.getPermissionsWithPermissionsManager(this.this$0.getPermissionsManager(), promise, "android.permission.CAMERA");
                    }
                });
            } else {
                AnyType[] anyTypeArr3 = new AnyType[1];
                AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType3 == null) {
                    anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$$inlined$AsyncFunction$8
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Promise.class);
                        }
                    }));
                }
                anyTypeArr3[0] = anyType3;
                Function1<Object[], Unit> function13 = new Function1<Object[], Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$$inlined$AsyncFunction$9
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Permissions.getPermissionsWithPermissionsManager(this.this$0.getPermissionsManager(), (Promise) objArr[0], "android.permission.CAMERA");
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent3 = new StringAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr3, function13);
                                } else {
                                    asyncFunctionComponent3 = new AsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr3, function13);
                                }
                            } else {
                                asyncFunctionComponent3 = new FloatAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr3, function13);
                            }
                        } else {
                            asyncFunctionComponent3 = new DoubleAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr3, function13);
                        }
                    } else {
                        asyncFunctionComponent3 = new BoolAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr3, function13);
                    }
                } else {
                    asyncFunctionComponent3 = new IntAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr3, function13);
                }
                asyncFunctionWithPromiseComponent3 = asyncFunctionComponent3;
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("getCameraPermissionsAsync", asyncFunctionWithPromiseComponent3);
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent4 = new AsyncFunctionWithPromiseComponent("getMicrophonePermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$$inlined$AsyncFunction$10
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Permissions.getPermissionsWithPermissionsManager(this.this$0.getPermissionsManager(), promise, "android.permission.RECORD_AUDIO");
                    }
                });
            } else {
                AnyType[] anyTypeArr4 = new AnyType[1];
                AnyType anyType4 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType4 == null) {
                    anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$$inlined$AsyncFunction$11
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Promise.class);
                        }
                    }));
                }
                anyTypeArr4[0] = anyType4;
                Function1<Object[], Unit> function14 = new Function1<Object[], Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$$inlined$AsyncFunction$12
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Permissions.getPermissionsWithPermissionsManager(this.this$0.getPermissionsManager(), (Promise) objArr[0], "android.permission.RECORD_AUDIO");
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent4 = new StringAsyncFunctionComponent("getMicrophonePermissionsAsync", anyTypeArr4, function14);
                                } else {
                                    asyncFunctionComponent4 = new AsyncFunctionComponent("getMicrophonePermissionsAsync", anyTypeArr4, function14);
                                }
                            } else {
                                asyncFunctionComponent4 = new FloatAsyncFunctionComponent("getMicrophonePermissionsAsync", anyTypeArr4, function14);
                            }
                        } else {
                            asyncFunctionComponent4 = new DoubleAsyncFunctionComponent("getMicrophonePermissionsAsync", anyTypeArr4, function14);
                        }
                    } else {
                        asyncFunctionComponent4 = new BoolAsyncFunctionComponent("getMicrophonePermissionsAsync", anyTypeArr4, function14);
                    }
                } else {
                    asyncFunctionComponent4 = new IntAsyncFunctionComponent("getMicrophonePermissionsAsync", anyTypeArr4, function14);
                }
                asyncFunctionWithPromiseComponent4 = asyncFunctionComponent4;
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("getMicrophonePermissionsAsync", asyncFunctionWithPromiseComponent4);
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr5 = new AnyType[2];
            AnyType anyType5 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType5 == null) {
                anyType5 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$$inlined$AsyncFunctionWithPromise$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr5[0] = anyType5;
            AnyType anyType6 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(List.class), false));
            if (anyType6 == null) {
                anyType6 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$$inlined$AsyncFunctionWithPromise$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(BarcodeType.class)));
                    }
                }));
            }
            anyTypeArr5[1] = anyType6;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent8 = new AsyncFunctionWithPromiseComponent("scanFromURLAsync", anyTypeArr5, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$$inlined$AsyncFunctionWithPromise$3
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, final Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    final List list = (List) objArr[1];
                    final String str = (String) obj;
                    ImageLoaderInterface imageLoader = this.this$0.getAppContext().getImageLoader();
                    if (imageLoader != null) {
                        final CameraViewModule cameraViewModule2 = this.this$0;
                        imageLoader.loadImageForManipulationFromURL(str, new ImageLoaderInterface.ResultListener() { // from class: expo.modules.camera.CameraViewModule$definition$1$5$1
                            @Override // expo.modules.interfaces.imageloader.ImageLoaderInterface.ResultListener
                            public void onSuccess(Bitmap bitmap) {
                                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                                MLKitBarCodeScanner mLKitBarCodeScanner = new MLKitBarCodeScanner();
                                List<BarcodeType> list2 = list;
                                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                                Iterator<T> it = list2.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(Integer.valueOf(((BarcodeType) it.next()).mapToBarcode()));
                                }
                                ArrayList arrayList2 = arrayList;
                                mLKitBarCodeScanner.setSettings(arrayList2);
                                BuildersKt__Builders_commonKt.launch$default(cameraViewModule2.moduleScope, null, null, new CameraViewModule$definition$1$5$1$onSuccess$1(mLKitBarCodeScanner, bitmap, promise, arrayList2, null), 3, null);
                            }

                            @Override // expo.modules.interfaces.imageloader.ImageLoaderInterface.ResultListener
                            public void onFailure(Throwable cause) {
                                promise.reject(new CameraExceptions.ImageRetrievalException(str));
                            }
                        });
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder6.getAsyncFunctions().put("scanFromURLAsync", asyncFunctionWithPromiseComponent8);
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$$inlined$OnDestroy$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    try {
                        CoroutineScopeKt.cancel(this.this$0.moduleScope, new ModuleDestroyedException(null, 1, null));
                    } catch (IllegalStateException unused) {
                        Log.e(CameraViewModule.TAG, "The scope does not have a job in it");
                    }
                }
            }));
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ExpoCameraView.class);
            if (moduleDefinitionBuilder.getViewManagerDefinition() != null) {
                throw new IllegalArgumentException("The module definition may have exported only one view manager.".toString());
            }
            final ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(orCreateKotlinClass, new LazyKType(Reflection.getOrCreateKotlinClass(ExpoCameraView.class), false, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$$inlined$View$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ExpoCameraView.class);
                }
            }, 2, null));
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder);
            viewDefinitionBuilder.EventsWithArray(CameraViewModuleKt.getCameraEvents());
            Function2<ExpoCameraView, CameraType, Unit> function2 = new Function2<ExpoCameraView, CameraType, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$7$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, CameraType cameraType) {
                    invoke2(expoCameraView, cameraType);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, CameraType cameraType) {
                    Unit unit;
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (cameraType != null) {
                        if (view.getLensFacing() != cameraType) {
                            view.setLensFacing(cameraType);
                        }
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit != null || view.getLensFacing() == CameraType.BACK) {
                        return;
                    }
                    view.setLensFacing(CameraType.BACK);
                }
            };
            Map<String, AnyViewProp> props = viewDefinitionBuilder.getProps();
            AnyType anyType7 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(CameraType.class), true));
            if (anyType7 == null) {
                anyType7 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(CameraType.class), true, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$Prop$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(CameraType.class);
                    }
                }));
            }
            props.put("facing", new ConcreteViewProp("facing", anyType7, function2));
            Function2<ExpoCameraView, FlashMode, Unit> function22 = new Function2<ExpoCameraView, FlashMode, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$7$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, FlashMode flashMode) {
                    invoke2(expoCameraView, flashMode);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, FlashMode flashMode) {
                    Unit unit;
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (flashMode != null) {
                        if (view.getFlashMode() != flashMode) {
                            view.setFlashMode(flashMode);
                        }
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit != null || view.getFlashMode() == FlashMode.OFF) {
                        return;
                    }
                    view.setFlashMode(FlashMode.OFF);
                }
            };
            Map<String, AnyViewProp> props2 = viewDefinitionBuilder.getProps();
            AnyType anyType8 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FlashMode.class), true));
            if (anyType8 == null) {
                anyType8 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FlashMode.class), true, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$Prop$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(FlashMode.class);
                    }
                }));
            }
            props2.put("flashMode", new ConcreteViewProp("flashMode", anyType8, function22));
            Function2<ExpoCameraView, Boolean, Unit> function23 = new Function2<ExpoCameraView, Boolean, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$7$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Boolean bool) {
                    invoke2(expoCameraView, bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, Boolean bool) {
                    Unit unit;
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (bool != null) {
                        boolean zBooleanValue = bool.booleanValue();
                        if (view.getEnableTorch() != zBooleanValue) {
                            view.setEnableTorch(zBooleanValue);
                        }
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null && view.getEnableTorch()) {
                        view.setEnableTorch(false);
                    }
                }
            };
            Map<String, AnyViewProp> props3 = viewDefinitionBuilder.getProps();
            AnyType anyType9 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), true));
            if (anyType9 == null) {
                anyType9 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), true, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$Prop$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(Boolean.class);
                    }
                }));
            }
            props3.put("enableTorch", new ConcreteViewProp("enableTorch", anyType9, function23));
            CameraViewModule$definition$1$7$4 cameraViewModule$definition$1$7$4 = new Function2<ExpoCameraView, Boolean, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$7$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Boolean bool) {
                    invoke2(expoCameraView, bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, Boolean bool) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setAnimateShutter(bool != null ? bool.booleanValue() : true);
                }
            };
            Map<String, AnyViewProp> props4 = viewDefinitionBuilder.getProps();
            AnyType anyType10 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), true));
            if (anyType10 == null) {
                anyType10 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), true, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$Prop$4
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(Boolean.class);
                    }
                }));
            }
            props4.put("animateShutter", new ConcreteViewProp("animateShutter", anyType10, cameraViewModule$definition$1$7$4));
            Function2<ExpoCameraView, Float, Unit> function24 = new Function2<ExpoCameraView, Float, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$7$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Float f) {
                    invoke2(expoCameraView, f);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, Float f) {
                    Unit unit;
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (f != null) {
                        float fFloatValue = f.floatValue();
                        if (view.getZoom() != fFloatValue) {
                            view.setZoom(fFloatValue);
                        }
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit != null || view.getZoom() == 0.0f) {
                        return;
                    }
                    view.setZoom(0.0f);
                }
            };
            Map<String, AnyViewProp> props5 = viewDefinitionBuilder.getProps();
            AnyType anyType11 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Float.class), true));
            if (anyType11 == null) {
                anyType11 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Float.class), true, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$Prop$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(Float.class);
                    }
                }));
            }
            props5.put("zoom", new ConcreteViewProp("zoom", anyType11, function24));
            Function2<ExpoCameraView, CameraMode, Unit> function25 = new Function2<ExpoCameraView, CameraMode, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$7$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, CameraMode cameraMode) {
                    invoke2(expoCameraView, cameraMode);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, CameraMode cameraMode) {
                    Unit unit;
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (cameraMode != null) {
                        if (view.getCameraMode() != cameraMode) {
                            view.setCameraMode(cameraMode);
                        }
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit != null || view.getCameraMode() == CameraMode.PICTURE) {
                        return;
                    }
                    view.setCameraMode(CameraMode.PICTURE);
                }
            };
            Map<String, AnyViewProp> props6 = viewDefinitionBuilder.getProps();
            AnyType anyType12 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(CameraMode.class), true));
            if (anyType12 == null) {
                anyType12 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(CameraMode.class), true, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$Prop$6
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(CameraMode.class);
                    }
                }));
            }
            props6.put("mode", new ConcreteViewProp("mode", anyType12, function25));
            CameraViewModule$definition$1$7$7 cameraViewModule$definition$1$7$7 = new Function2<ExpoCameraView, Boolean, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$7$7
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Boolean bool) {
                    invoke2(expoCameraView, bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, Boolean bool) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setMute(bool != null ? bool.booleanValue() : false);
                }
            };
            Map<String, AnyViewProp> props7 = viewDefinitionBuilder.getProps();
            AnyType anyType13 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), true));
            if (anyType13 == null) {
                anyType13 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), true, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$Prop$7
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(Boolean.class);
                    }
                }));
            }
            props7.put("mute", new ConcreteViewProp("mute", anyType13, cameraViewModule$definition$1$7$7));
            Function2<ExpoCameraView, VideoQuality, Unit> function26 = new Function2<ExpoCameraView, VideoQuality, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$7$8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, VideoQuality videoQuality) {
                    invoke2(expoCameraView, videoQuality);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, VideoQuality videoQuality) {
                    Unit unit;
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (videoQuality != null) {
                        if (view.getVideoQuality() != videoQuality) {
                            view.setVideoQuality(videoQuality);
                        }
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit != null || view.getVideoQuality() == VideoQuality.VIDEO1080P) {
                        return;
                    }
                    view.setVideoQuality(VideoQuality.VIDEO1080P);
                }
            };
            Map<String, AnyViewProp> props8 = viewDefinitionBuilder.getProps();
            AnyType anyType14 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(VideoQuality.class), true));
            if (anyType14 == null) {
                anyType14 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(VideoQuality.class), true, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$Prop$8
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(VideoQuality.class);
                    }
                }));
            }
            props8.put("videoQuality", new ConcreteViewProp("videoQuality", anyType14, function26));
            CameraViewModule$definition$1$7$9 cameraViewModule$definition$1$7$9 = new Function2<ExpoCameraView, BarcodeSettings, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$7$9
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, BarcodeSettings barcodeSettings) {
                    invoke2(expoCameraView, barcodeSettings);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, BarcodeSettings barcodeSettings) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (barcodeSettings != null) {
                        view.setBarcodeScannerSettings(barcodeSettings);
                    }
                }
            };
            Map<String, AnyViewProp> props9 = viewDefinitionBuilder.getProps();
            AnyType anyType15 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(BarcodeSettings.class), true));
            if (anyType15 == null) {
                anyType15 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(BarcodeSettings.class), true, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$Prop$9
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(BarcodeSettings.class);
                    }
                }));
            }
            props9.put("barcodeScannerSettings", new ConcreteViewProp("barcodeScannerSettings", anyType15, cameraViewModule$definition$1$7$9));
            CameraViewModule$definition$1$7$10 cameraViewModule$definition$1$7$10 = new Function2<ExpoCameraView, Boolean, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$7$10
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Boolean bool) {
                    invoke2(expoCameraView, bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, Boolean bool) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (bool != null) {
                        bool.booleanValue();
                        view.setShouldScanBarcodes(bool.booleanValue());
                    }
                }
            };
            Map<String, AnyViewProp> props10 = viewDefinitionBuilder.getProps();
            AnyType anyType16 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), true));
            if (anyType16 == null) {
                anyType16 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), true, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$Prop$10
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(Boolean.class);
                    }
                }));
            }
            props10.put("barcodeScannerEnabled", new ConcreteViewProp("barcodeScannerEnabled", anyType16, cameraViewModule$definition$1$7$10));
            Function2<ExpoCameraView, String, Unit> function27 = new Function2<ExpoCameraView, String, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$7$11
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, String str) {
                    invoke2(expoCameraView, str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, String str) {
                    Unit unit;
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (str != null) {
                        if (!Intrinsics.areEqual(view.getPictureSize(), str)) {
                            view.setPictureSize(str);
                        }
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit != null || view.getPictureSize().length() <= 0) {
                        return;
                    }
                    view.setPictureSize("");
                }
            };
            Map<String, AnyViewProp> props11 = viewDefinitionBuilder.getProps();
            AnyType anyType17 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType17 == null) {
                anyType17 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$Prop$11
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(String.class);
                    }
                }));
            }
            props11.put("pictureSize", new ConcreteViewProp("pictureSize", anyType17, function27));
            Function2<ExpoCameraView, FocusMode, Unit> function28 = new Function2<ExpoCameraView, FocusMode, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$7$12
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, FocusMode focusMode) {
                    invoke2(expoCameraView, focusMode);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, FocusMode focusMode) {
                    Unit unit;
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (focusMode != null) {
                        if (view.getAutoFocus() != focusMode) {
                            view.setAutoFocus(focusMode);
                        }
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit != null || view.getAutoFocus() == FocusMode.OFF) {
                        return;
                    }
                    view.setAutoFocus(FocusMode.OFF);
                }
            };
            Map<String, AnyViewProp> props12 = viewDefinitionBuilder.getProps();
            AnyType anyType18 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(FocusMode.class), true));
            if (anyType18 == null) {
                anyType18 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(FocusMode.class), true, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$Prop$12
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(FocusMode.class);
                    }
                }));
            }
            props12.put("autoFocus", new ConcreteViewProp("autoFocus", anyType18, function28));
            Function2<ExpoCameraView, CameraRatio, Unit> function29 = new Function2<ExpoCameraView, CameraRatio, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$7$13
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, CameraRatio cameraRatio) {
                    invoke2(expoCameraView, cameraRatio);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, CameraRatio cameraRatio) {
                    Unit unit;
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (cameraRatio != null) {
                        if (view.getRatio() != cameraRatio) {
                            view.setRatio(cameraRatio);
                        }
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit != null || view.getRatio() == null) {
                        return;
                    }
                    view.setRatio(null);
                }
            };
            Map<String, AnyViewProp> props13 = viewDefinitionBuilder.getProps();
            AnyType anyType19 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(CameraRatio.class), true));
            if (anyType19 == null) {
                anyType19 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(CameraRatio.class), true, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$Prop$13
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(CameraRatio.class);
                    }
                }));
            }
            props13.put("ratio", new ConcreteViewProp("ratio", anyType19, function29));
            Function2<ExpoCameraView, Boolean, Unit> function210 = new Function2<ExpoCameraView, Boolean, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$7$14
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Boolean bool) {
                    invoke2(expoCameraView, bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, Boolean bool) {
                    Unit unit;
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (bool != null) {
                        boolean zBooleanValue = bool.booleanValue();
                        if (view.getMirror() != zBooleanValue) {
                            view.setMirror(zBooleanValue);
                        }
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null && view.getMirror()) {
                        view.setMirror(false);
                    }
                }
            };
            Map<String, AnyViewProp> props14 = viewDefinitionBuilder.getProps();
            AnyType anyType20 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), true));
            if (anyType20 == null) {
                anyType20 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), true, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$Prop$14
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(Boolean.class);
                    }
                }));
            }
            props14.put("mirror", new ConcreteViewProp("mirror", anyType20, function210));
            Function2<ExpoCameraView, Integer, Unit> function211 = new Function2<ExpoCameraView, Integer, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$1$7$15
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ExpoCameraView expoCameraView, Integer num) {
                    invoke2(expoCameraView, num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ExpoCameraView view, Integer num) {
                    Unit unit;
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (num != null) {
                        int iIntValue = num.intValue();
                        Integer videoEncodingBitrate = view.getVideoEncodingBitrate();
                        if (videoEncodingBitrate == null || videoEncodingBitrate.intValue() != iIntValue) {
                            view.setVideoEncodingBitrate(Integer.valueOf(iIntValue));
                        }
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit != null || view.getVideoEncodingBitrate() == null) {
                        return;
                    }
                    view.setVideoEncodingBitrate(null);
                }
            };
            Map<String, AnyViewProp> props15 = viewDefinitionBuilder.getProps();
            AnyType anyType21 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), true));
            if (anyType21 == null) {
                anyType21 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), true, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$Prop$15
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(Integer.class);
                    }
                }));
            }
            props15.put("videoBitrate", new ConcreteViewProp("videoBitrate", anyType21, function211));
            viewDefinitionBuilder.setOnViewDidUpdateProps(new Function1<View, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$OnViewDidUpdateProps$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ((ExpoCameraView) it).createCamera();
                }
            });
            AnyType[] anyTypeArr6 = new AnyType[2];
            AnyType anyType22 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ExpoCameraView.class), false));
            if (anyType22 == null) {
                anyType22 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ExpoCameraView.class), false, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$AsyncFunctionWithPromise$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(ExpoCameraView.class);
                    }
                }));
            }
            anyTypeArr6[0] = anyType22;
            AnyType anyType23 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(PictureOptions.class), false));
            if (anyType23 == null) {
                anyType23 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(PictureOptions.class), false, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$AsyncFunctionWithPromise$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(PictureOptions.class);
                    }
                }));
            }
            anyTypeArr6[1] = anyType23;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent9 = new AsyncFunctionWithPromiseComponent("takePicture", anyTypeArr6, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$AsyncFunctionWithPromise$3
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    PictureOptions pictureOptions = (PictureOptions) objArr[1];
                    ExpoCameraView expoCameraView = (ExpoCameraView) obj;
                    if (!EmulatorUtilities.INSTANCE.isRunningOnEmulator()) {
                        expoCameraView.takePicture(pictureOptions, promise, this.this$0.getCacheDirectory());
                    } else {
                        BuildersKt__Builders_commonKt.launch$default(this.this$0.moduleScope, null, null, new CameraViewModule$definition$1$7$17$1(CameraViewHelper.INSTANCE.generateSimulatorPhoto(expoCameraView.getWidth(), expoCameraView.getHeight()), promise, pictureOptions, this.this$0, expoCameraView, null), 3, null);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            viewDefinitionBuilder.getAsyncFunctions().put("takePicture", asyncFunctionWithPromiseComponent9);
            asyncFunctionWithPromiseComponent9.runOnQueue(Queues.MAIN);
            if (ExpoCameraView.class == Promise.class) {
                asyncFunctionWithPromiseComponent5 = new AsyncFunctionWithPromiseComponent("getAvailablePictureSizes", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$AsyncFunction$1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        ((ExpoCameraView) promise).getAvailablePictureSizes();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr7 = new AnyType[1];
                AnyType anyType24 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ExpoCameraView.class), false));
                if (anyType24 == null) {
                    anyType24 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ExpoCameraView.class), false, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(ExpoCameraView.class);
                        }
                    }));
                }
                anyTypeArr7[0] = anyType24;
                Function1<Object[], List<? extends String>> function15 = new Function1<Object[], List<? extends String>>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final List<? extends String> invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        return ((ExpoCameraView) objArr[0]).getAvailablePictureSizes();
                    }
                };
                if (!Intrinsics.areEqual(List.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(List.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(List.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(List.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(List.class, String.class)) {
                                    asyncFunctionComponent5 = new StringAsyncFunctionComponent("getAvailablePictureSizes", anyTypeArr7, function15);
                                } else {
                                    asyncFunctionComponent5 = new AsyncFunctionComponent("getAvailablePictureSizes", anyTypeArr7, function15);
                                }
                            } else {
                                asyncFunctionComponent5 = new FloatAsyncFunctionComponent("getAvailablePictureSizes", anyTypeArr7, function15);
                            }
                        } else {
                            asyncFunctionComponent5 = new DoubleAsyncFunctionComponent("getAvailablePictureSizes", anyTypeArr7, function15);
                        }
                    } else {
                        asyncFunctionComponent5 = new BoolAsyncFunctionComponent("getAvailablePictureSizes", anyTypeArr7, function15);
                    }
                } else {
                    asyncFunctionComponent5 = new IntAsyncFunctionComponent("getAvailablePictureSizes", anyTypeArr7, function15);
                }
                asyncFunctionWithPromiseComponent5 = asyncFunctionComponent5;
            }
            viewDefinitionBuilder.getAsyncFunctions().put("getAvailablePictureSizes", asyncFunctionWithPromiseComponent5);
            AnyType[] anyTypeArr8 = new AnyType[2];
            AnyType anyType25 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ExpoCameraView.class), false));
            if (anyType25 == null) {
                anyType25 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ExpoCameraView.class), false, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$AsyncFunctionWithPromise$4
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(ExpoCameraView.class);
                    }
                }));
            }
            anyTypeArr8[0] = anyType25;
            AnyType anyType26 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(RecordingOptions.class), false));
            if (anyType26 == null) {
                anyType26 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(RecordingOptions.class), false, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$AsyncFunctionWithPromise$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(RecordingOptions.class);
                    }
                }));
            }
            anyTypeArr8[1] = anyType26;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent10 = new AsyncFunctionWithPromiseComponent("record", anyTypeArr8, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$AsyncFunctionWithPromise$6
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws Exceptions.MissingPermissions {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    RecordingOptions recordingOptions = (RecordingOptions) objArr[1];
                    ExpoCameraView expoCameraView = (ExpoCameraView) obj;
                    if (expoCameraView.getMute() || this.this$0.getPermissionsManager().hasGrantedPermissions("android.permission.RECORD_AUDIO")) {
                        expoCameraView.record(recordingOptions, promise, this.this$0.getCacheDirectory());
                        return;
                    }
                    throw new Exceptions.MissingPermissions("android.permission.RECORD_AUDIO");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws Exceptions.MissingPermissions {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            viewDefinitionBuilder.getAsyncFunctions().put("record", asyncFunctionWithPromiseComponent10);
            asyncFunctionWithPromiseComponent10.runOnQueue(Queues.MAIN);
            if (ExpoCameraView.class == Promise.class) {
                asyncFunctionComponent6 = new AsyncFunctionWithPromiseComponent("stopRecording", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$AsyncFunction$4
                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Recording activeRecording = ((ExpoCameraView) promise).getActiveRecording();
                        if (activeRecording != null) {
                            activeRecording.close();
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr9 = new AnyType[1];
                AnyType anyType27 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ExpoCameraView.class), false));
                if (anyType27 == null) {
                    anyType27 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ExpoCameraView.class), false, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$AsyncFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(ExpoCameraView.class);
                        }
                    }));
                }
                anyTypeArr9[0] = anyType27;
                asyncFunctionComponent6 = new AsyncFunctionComponent("stopRecording", anyTypeArr9, new Function1<Object[], Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$AsyncFunction$6
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Recording activeRecording = ((ExpoCameraView) objArr[0]).getActiveRecording();
                        if (activeRecording == null) {
                            return null;
                        }
                        activeRecording.close();
                        return Unit.INSTANCE;
                    }
                });
            }
            viewDefinitionBuilder.getAsyncFunctions().put("stopRecording", asyncFunctionComponent6);
            asyncFunctionComponent6.runOnQueue(Queues.MAIN);
            if (ExpoCameraView.class == Promise.class) {
                asyncFunctionWithPromiseComponent6 = new AsyncFunctionWithPromiseComponent("resumePreview", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$AsyncFunction$7
                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        ((ExpoCameraView) promise).resumePreview();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr10 = new AnyType[1];
                AnyType anyType28 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ExpoCameraView.class), false));
                if (anyType28 == null) {
                    anyType28 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ExpoCameraView.class), false, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$AsyncFunction$8
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(ExpoCameraView.class);
                        }
                    }));
                }
                anyTypeArr10[0] = anyType28;
                Function1<Object[], Unit> function16 = new Function1<Object[], Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$AsyncFunction$9
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        ((ExpoCameraView) objArr[0]).resumePreview();
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent7 = new StringAsyncFunctionComponent("resumePreview", anyTypeArr10, function16);
                                } else {
                                    asyncFunctionComponent7 = new AsyncFunctionComponent("resumePreview", anyTypeArr10, function16);
                                }
                            } else {
                                asyncFunctionComponent7 = new FloatAsyncFunctionComponent("resumePreview", anyTypeArr10, function16);
                            }
                        } else {
                            asyncFunctionComponent7 = new DoubleAsyncFunctionComponent("resumePreview", anyTypeArr10, function16);
                        }
                    } else {
                        asyncFunctionComponent7 = new BoolAsyncFunctionComponent("resumePreview", anyTypeArr10, function16);
                    }
                } else {
                    asyncFunctionComponent7 = new IntAsyncFunctionComponent("resumePreview", anyTypeArr10, function16);
                }
                asyncFunctionWithPromiseComponent6 = asyncFunctionComponent7;
            }
            viewDefinitionBuilder.getAsyncFunctions().put("resumePreview", asyncFunctionWithPromiseComponent6);
            if (ExpoCameraView.class == Promise.class) {
                asyncFunctionWithPromiseComponent7 = new AsyncFunctionWithPromiseComponent("pausePreview", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$AsyncFunction$10
                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        ((ExpoCameraView) promise).pausePreview();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr11 = new AnyType[1];
                AnyType anyType29 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ExpoCameraView.class), false));
                if (anyType29 == null) {
                    anyType29 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ExpoCameraView.class), false, new Function0<KType>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$AsyncFunction$11
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(ExpoCameraView.class);
                        }
                    }));
                }
                anyTypeArr11[0] = anyType29;
                Function1<Object[], Unit> function17 = new Function1<Object[], Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$AsyncFunction$12
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        ((ExpoCameraView) objArr[0]).pausePreview();
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent8 = new StringAsyncFunctionComponent("pausePreview", anyTypeArr11, function17);
                                } else {
                                    asyncFunctionComponent8 = new AsyncFunctionComponent("pausePreview", anyTypeArr11, function17);
                                }
                            } else {
                                asyncFunctionComponent8 = new FloatAsyncFunctionComponent("pausePreview", anyTypeArr11, function17);
                            }
                        } else {
                            asyncFunctionComponent8 = new DoubleAsyncFunctionComponent("pausePreview", anyTypeArr11, function17);
                        }
                    } else {
                        asyncFunctionComponent8 = new BoolAsyncFunctionComponent("pausePreview", anyTypeArr11, function17);
                    }
                } else {
                    asyncFunctionComponent8 = new IntAsyncFunctionComponent("pausePreview", anyTypeArr11, function17);
                }
                asyncFunctionWithPromiseComponent7 = asyncFunctionComponent8;
            }
            viewDefinitionBuilder.getAsyncFunctions().put("pausePreview", asyncFunctionWithPromiseComponent7);
            viewDefinitionBuilder.setOnViewDestroys(new Function1<View, Unit>() { // from class: expo.modules.camera.CameraViewModule$definition$lambda$15$lambda$14$$inlined$OnViewDestroys$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ExpoCameraView expoCameraView = (ExpoCameraView) it;
                    expoCameraView.getOrientationEventListener().disable();
                    expoCameraView.cancelCoroutineScope();
                    expoCameraView.releaseCamera();
                }
            });
            moduleDefinitionBuilder.setViewManagerDefinition(viewDefinitionBuilder.build());
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getCacheDirectory() {
        return getAppContext().getCacheDirectory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Permissions getPermissionsManager() throws Exceptions.PermissionsModuleNotFound {
        Permissions permissions = getAppContext().getPermissions();
        if (permissions != null) {
            return permissions;
        }
        throw new Exceptions.PermissionsModuleNotFound();
    }

    /* compiled from: CameraViewModule.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/camera/CameraViewModule$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG$expo_camera_release", "()Ljava/lang/String;", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG$expo_camera_release() {
            return CameraViewModule.TAG;
        }
    }
}
