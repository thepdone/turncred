package expo.modules.imagepicker;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.OperationCanceledException;
import androidx.core.content.ContextCompat;
import androidx.tracing.Trace;
import com.caverock.androidsvg.SVGParser;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.core.errors.ModuleNotFoundException;
import expo.modules.imagepicker.contracts.CameraContractOptions;
import expo.modules.imagepicker.contracts.CropImageContractOptions;
import expo.modules.imagepicker.contracts.ImageLibraryContractOptions;
import expo.modules.imagepicker.contracts.ImagePickerContractResult;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.interfaces.permissions.PermissionsResponseListener;
import expo.modules.interfaces.permissions.PermissionsStatus;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.UtilsKt;
import expo.modules.kotlin.activityresult.AppContextActivityResultLauncher;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SuspendFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: ImagePickerModule.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u000e\u0010\u001f\u001a\u00020 H\u0082@¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0002J\u001b\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010(\u001a\u00020\u0014H\u0002¢\u0006\u0002\u0010)J\u0018\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020\n2\u0006\u0010#\u001a\u00020$H\u0002J4\u0010,\u001a\u00020-2\u001c\u0010.\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n00\u0012\u0006\u0012\u0004\u0018\u00010-0/2\u0006\u0010#\u001a\u00020$H\u0082@¢\u0006\u0002\u00101J,\u00102\u001a\u0002032\u001c\u0010.\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n00\u0012\u0006\u0012\u0004\u0018\u00010-0/H\u0082@¢\u0006\u0002\u00104R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\bX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n0\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lexpo/modules/imagepicker/ImagePickerModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "cacheDirectory", "Ljava/io/File;", "getCacheDirectory", "()Ljava/io/File;", "cameraLauncher", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultLauncher;", "Lexpo/modules/imagepicker/contracts/CameraContractOptions;", "Lexpo/modules/imagepicker/contracts/ImagePickerContractResult;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "cropImageLauncher", "Lexpo/modules/imagepicker/contracts/CropImageContractOptions;", "imageLibraryLauncher", "Lexpo/modules/imagepicker/contracts/ImageLibraryContractOptions;", "isPickerOpen", "", "mediaHandler", "Lexpo/modules/imagepicker/MediaHandler;", "pendingMediaPickingResult", "Lexpo/modules/imagepicker/PendingMediaPickingResult;", "createPermissionsDecorator", "Lexpo/modules/interfaces/permissions/PermissionsResponseListener;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "ensureCameraPermissionsAreGranted", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureTargetActivityIsAvailable", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lexpo/modules/imagepicker/ImagePickerOptions;", "getMediaLibraryPermissions", "", "", "writeOnly", "(Z)[Ljava/lang/String;", "handleResultUponActivityDestruction", "result", "launchContract", "", "pickerLauncher", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;Lexpo/modules/imagepicker/ImagePickerOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchPicker", "Lexpo/modules/imagepicker/contracts/ImagePickerContractResult$Success;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-image-picker_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImagePickerModule extends Module {
    private AppContextActivityResultLauncher<CameraContractOptions, ImagePickerContractResult> cameraLauncher;
    private AppContextActivityResultLauncher<CropImageContractOptions, ImagePickerContractResult> cropImageLauncher;
    private AppContextActivityResultLauncher<ImageLibraryContractOptions, ImagePickerContractResult> imageLibraryLauncher;
    private boolean isPickerOpen;
    private final MediaHandler mediaHandler = new MediaHandler(this);
    private PendingMediaPickingResult pendingMediaPickingResult;

    /* compiled from: ImagePickerModule.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.imagepicker.ImagePickerModule", f = "ImagePickerModule.kt", i = {0, 0, 0, 1, 1, 1, 2}, l = {JfifUtil.MARKER_RST0, JfifUtil.MARKER_RST7, 219}, m = "launchContract", n = {"this", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "result", "this", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "result", "this"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0"})
    /* renamed from: expo.modules.imagepicker.ImagePickerModule$launchContract$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ImagePickerModule.this.launchContract(null, null, this);
        }
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2;
        ImagePickerModule imagePickerModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (imagePickerModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(imagePickerModule);
            moduleDefinitionBuilder.Name(ImagePickerConstants.TAG);
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[1];
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunctionWithPromise$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Boolean.TYPE);
                    }
                }));
            }
            anyTypeArr[0] = anyType;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent("requestMediaLibraryPermissionsAsync", anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunctionWithPromise$2
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws Exceptions.PermissionsModuleNotFound {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    boolean zBooleanValue = ((Boolean) objArr[0]).booleanValue();
                    Permissions permissions = this.this$0.getAppContext().getPermissions();
                    if (permissions != null) {
                        String[] mediaLibraryPermissions = this.this$0.getMediaLibraryPermissions(zBooleanValue);
                        permissions.askForPermissions(this.this$0.createPermissionsDecorator(promise), (String[]) Arrays.copyOf(mediaLibraryPermissions, mediaLibraryPermissions.length));
                        return;
                    }
                    throw new Exceptions.PermissionsModuleNotFound();
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws Exceptions.PermissionsModuleNotFound {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder2.getAsyncFunctions().put("requestMediaLibraryPermissionsAsync", asyncFunctionWithPromiseComponent3);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr2 = new AnyType[1];
            AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunctionWithPromise$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Boolean.TYPE);
                    }
                }));
            }
            anyTypeArr2[0] = anyType2;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent4 = new AsyncFunctionWithPromiseComponent("getMediaLibraryPermissionsAsync", anyTypeArr2, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunctionWithPromise$4
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws Exceptions.PermissionsModuleNotFound {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    boolean zBooleanValue = ((Boolean) objArr[0]).booleanValue();
                    Permissions permissions = this.this$0.getAppContext().getPermissions();
                    if (permissions != null) {
                        String[] mediaLibraryPermissions = this.this$0.getMediaLibraryPermissions(zBooleanValue);
                        permissions.getPermissions(this.this$0.createPermissionsDecorator(promise), (String[]) Arrays.copyOf(mediaLibraryPermissions, mediaLibraryPermissions.length));
                        return;
                    }
                    throw new Exceptions.PermissionsModuleNotFound();
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws Exceptions.PermissionsModuleNotFound {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder3.getAsyncFunctions().put("getMediaLibraryPermissionsAsync", asyncFunctionWithPromiseComponent4);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("requestCameraPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$1
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
                        Permissions.askForPermissionsWithPermissionsManager(this.this$0.getAppContext().getPermissions(), promise, "android.permission.CAMERA");
                    }
                });
            } else {
                AnyType[] anyTypeArr3 = new AnyType[1];
                AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType3 == null) {
                    anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Promise.class);
                        }
                    }));
                }
                anyTypeArr3[0] = anyType3;
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Permissions.askForPermissionsWithPermissionsManager(this.this$0.getAppContext().getPermissions(), (Promise) objArr[0], "android.permission.CAMERA");
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent = new StringAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr3, function1);
                                } else {
                                    asyncFunctionComponent = new AsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr3, function1);
                                }
                            } else {
                                asyncFunctionComponent = new FloatAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr3, function1);
                            }
                        } else {
                            asyncFunctionComponent = new DoubleAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr3, function1);
                        }
                    } else {
                        asyncFunctionComponent = new BoolAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr3, function1);
                    }
                } else {
                    asyncFunctionComponent = new IntAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr3, function1);
                }
                asyncFunctionWithPromiseComponent = asyncFunctionComponent;
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("requestCameraPermissionsAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("getCameraPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$4
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
                        Permissions.getPermissionsWithPermissionsManager(this.this$0.getAppContext().getPermissions(), promise, "android.permission.CAMERA");
                    }
                });
            } else {
                AnyType[] anyTypeArr4 = new AnyType[1];
                AnyType anyType4 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType4 == null) {
                    anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Promise.class);
                        }
                    }));
                }
                anyTypeArr4[0] = anyType4;
                Function1<Object[], Unit> function12 = new Function1<Object[], Unit>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Permissions.getPermissionsWithPermissionsManager(this.this$0.getAppContext().getPermissions(), (Promise) objArr[0], "android.permission.CAMERA");
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent2 = new StringAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr4, function12);
                                } else {
                                    asyncFunctionComponent2 = new AsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr4, function12);
                                }
                            } else {
                                asyncFunctionComponent2 = new FloatAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr4, function12);
                            }
                        } else {
                            asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr4, function12);
                        }
                    } else {
                        asyncFunctionComponent2 = new BoolAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr4, function12);
                    }
                } else {
                    asyncFunctionComponent2 = new IntAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr4, function12);
                }
                asyncFunctionWithPromiseComponent2 = asyncFunctionComponent2;
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("getCameraPermissionsAsync", asyncFunctionWithPromiseComponent2);
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction = moduleDefinitionBuilder.AsyncFunction("launchCameraAsync");
            String name = asyncFunctionBuilderAsyncFunction.getName();
            AnyType[] anyTypeArr5 = new AnyType[1];
            AnyType anyType5 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ImagePickerOptions.class), false));
            if (anyType5 == null) {
                anyType5 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ImagePickerOptions.class), false, new Function0<KType>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$Coroutine$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(ImagePickerOptions.class);
                    }
                }));
            }
            anyTypeArr5[0] = anyType5;
            asyncFunctionBuilderAsyncFunction.setAsyncFunctionComponent(new SuspendFunctionComponent(name, anyTypeArr5, new ImagePickerModule$definition$lambda$7$$inlined$Coroutine$2(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction2 = moduleDefinitionBuilder.AsyncFunction("launchImageLibraryAsync");
            String name2 = asyncFunctionBuilderAsyncFunction2.getName();
            AnyType[] anyTypeArr6 = new AnyType[1];
            AnyType anyType6 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ImagePickerOptions.class), false));
            if (anyType6 == null) {
                anyType6 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ImagePickerOptions.class), false, new Function0<KType>() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$Coroutine$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(ImagePickerOptions.class);
                    }
                }));
            }
            anyTypeArr6[0] = anyType6;
            asyncFunctionBuilderAsyncFunction2.setAsyncFunctionComponent(new SuspendFunctionComponent(name2, anyTypeArr6, new ImagePickerModule$definition$lambda$7$$inlined$Coroutine$4(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction3 = moduleDefinitionBuilder.AsyncFunction("getPendingResultAsync");
            SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(asyncFunctionBuilderAsyncFunction3.getName(), new AnyType[0], new ImagePickerModule$definition$lambda$7$$inlined$Coroutine$5(null, this));
            asyncFunctionBuilderAsyncFunction3.setAsyncFunctionComponent(suspendFunctionComponent);
            moduleDefinitionBuilder.RegisterActivityContracts(new ImagePickerModule$definition$1$8(this, null));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    public final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new IllegalArgumentException("React Application Context is null".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getCacheDirectory() {
        return getAppContext().getCacheDirectory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PermissionsResponseListener createPermissionsDecorator(final Promise promise) {
        final WeakReference weakReferenceWeak = UtilsKt.weak(getAppContext().getReactContext());
        return new PermissionsResponseListener() { // from class: expo.modules.imagepicker.ImagePickerModule$$ExternalSyntheticLambda0
            @Override // expo.modules.interfaces.permissions.PermissionsResponseListener
            public final void onResult(Map map) {
                ImagePickerModule.createPermissionsDecorator$lambda$14(promise, weakReferenceWeak, this, map);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createPermissionsDecorator$lambda$14(Promise promise, WeakReference weakContext, ImagePickerModule this$0, Map map) {
        boolean z;
        boolean z2;
        String status;
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(weakContext, "$weakContext");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(map);
        boolean z3 = false;
        if (map.isEmpty()) {
            z = true;
        } else {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                if (((PermissionsResponse) ((Map.Entry) it.next()).getValue()).getStatus() != PermissionsStatus.GRANTED) {
                    z = false;
                    break;
                }
            }
            z = true;
        }
        if (map.isEmpty()) {
            z2 = false;
            break;
        }
        if (!map.isEmpty()) {
            Iterator it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                if (((PermissionsResponse) ((Map.Entry) it2.next()).getValue()).getStatus() != PermissionsStatus.DENIED) {
                    z2 = false;
                    break;
                }
            }
        }
        z2 = true;
        if (map.isEmpty()) {
            z3 = true;
        } else {
            Iterator it3 = map.entrySet().iterator();
            while (it3.hasNext()) {
                if (!((PermissionsResponse) ((Map.Entry) it3.next()).getValue()).getCanAskAgain()) {
                    break;
                }
            }
            z3 = true;
        }
        Bundle bundle = new Bundle();
        bundle.putString(PermissionsResponse.EXPIRES_KEY, "never");
        if (z) {
            status = PermissionsStatus.GRANTED.getStatus();
        } else if (z2) {
            status = PermissionsStatus.DENIED.getStatus();
        } else {
            status = PermissionsStatus.UNDETERMINED.getStatus();
        }
        bundle.putString("status", status);
        bundle.putBoolean(PermissionsResponse.CAN_ASK_AGAIN_KEY, z3);
        bundle.putBoolean(PermissionsResponse.GRANTED_KEY, z);
        if (z) {
            bundle.putString("accessPrivileges", SVGParser.XML_STYLESHEET_ATTR_MEDIA_ALL);
            promise.resolve(bundle);
            return;
        }
        if (Build.VERSION.SDK_INT < 34) {
            bundle.putString("accessPrivileges", "none");
            promise.resolve(bundle);
            return;
        }
        Context context = (Context) weakContext.get();
        if (context == null) {
            promise.reject(new Exceptions.ReactContextLost());
            return;
        }
        if (ContextCompat.checkSelfPermission(context, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == 0) {
            bundle.putBoolean(PermissionsResponse.GRANTED_KEY, true);
            bundle.putBoolean(PermissionsResponse.CAN_ASK_AGAIN_KEY, true);
            bundle.putString("status", PermissionsStatus.GRANTED.getStatus());
            bundle.putString("accessPrivileges", "limited");
        } else {
            bundle.putString("accessPrivileges", "none");
        }
        promise.resolve(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0106 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r10v30, types: [expo.modules.imagepicker.ImagePickerModule] */
    /* JADX WARN: Type inference failed for: r10v38 */
    /* JADX WARN: Type inference failed for: r10v39 */
    /* JADX WARN: Type inference failed for: r10v6, types: [expo.modules.imagepicker.ImagePickerModule] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object launchContract(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super expo.modules.imagepicker.contracts.ImagePickerContractResult>, ? extends java.lang.Object> r10, expo.modules.imagepicker.ImagePickerOptions r11, kotlin.coroutines.Continuation<java.lang.Object> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.imagepicker.ImagePickerModule.launchContract(kotlin.jvm.functions.Function1, expo.modules.imagepicker.ImagePickerOptions, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: ImagePickerModule.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lexpo/modules/imagepicker/contracts/ImagePickerContractResult;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.imagepicker.ImagePickerModule$launchContract$2", f = "ImagePickerModule.kt", i = {}, l = {JfifUtil.MARKER_SOI}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: expo.modules.imagepicker.ImagePickerModule$launchContract$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super ImagePickerContractResult>, Object> {
        final /* synthetic */ ImagePickerOptions $options;
        final /* synthetic */ Ref.ObjectRef<ImagePickerContractResult.Success> $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref.ObjectRef<ImagePickerContractResult.Success> objectRef, ImagePickerOptions imagePickerOptions, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$result = objectRef;
            this.$options = imagePickerOptions;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ImagePickerModule.this.new AnonymousClass2(this.$result, this.$options, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super ImagePickerContractResult> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AppContextActivityResultLauncher appContextActivityResultLauncher = ImagePickerModule.this.cropImageLauncher;
                if (appContextActivityResultLauncher == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cropImageLauncher");
                    appContextActivityResultLauncher = null;
                }
                String string = this.$result.element.getData().get(0).getSecond().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                this.label = 1;
                obj = appContextActivityResultLauncher.launch((AppContextActivityResultLauncher) new CropImageContractOptions(string, this.$options), (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleResultUponActivityDestruction(ImagePickerContractResult result, ImagePickerOptions options) {
        if (result instanceof ImagePickerContractResult.Success) {
            this.pendingMediaPickingResult = new PendingMediaPickingResult(((ImagePickerContractResult.Success) result).getData(), options);
        }
    }

    /* compiled from: ImagePickerModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lexpo/modules/imagepicker/contracts/ImagePickerContractResult$Success;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.imagepicker.ImagePickerModule$launchPicker$2", f = "ImagePickerModule.kt", i = {}, l = {243}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: expo.modules.imagepicker.ImagePickerModule$launchPicker$2, reason: invalid class name and case insensitive filesystem */
    static final class C04792 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImagePickerContractResult.Success>, Object> {
        final /* synthetic */ Function1<Continuation<? super ImagePickerContractResult>, Object> $pickerLauncher;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C04792(Function1<? super Continuation<? super ImagePickerContractResult>, ? extends Object> function1, Continuation<? super C04792> continuation) {
            super(2, continuation);
            this.$pickerLauncher = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04792(this.$pickerLauncher, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImagePickerContractResult.Success> continuation) {
            return ((C04792) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws FailedToPickMediaException {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1<Continuation<? super ImagePickerContractResult>, Object> function1 = this.$pickerLauncher;
                this.label = 1;
                obj = function1.invoke(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ImagePickerContractResult imagePickerContractResult = (ImagePickerContractResult) obj;
            if (imagePickerContractResult instanceof ImagePickerContractResult.Success) {
                return (ImagePickerContractResult.Success) imagePickerContractResult;
            }
            if (imagePickerContractResult instanceof ImagePickerContractResult.Cancelled) {
                throw new OperationCanceledException();
            }
            if (imagePickerContractResult instanceof ImagePickerContractResult.Error) {
                throw new FailedToPickMediaException();
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object launchPicker(Function1<? super Continuation<? super ImagePickerContractResult>, ? extends Object> function1, Continuation<? super ImagePickerContractResult.Success> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C04792(function1, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String[] getMediaLibraryPermissions(boolean writeOnly) {
        if (Build.VERSION.SDK_INT < 33) {
            String[] strArr = new String[2];
            strArr[0] = "android.permission.WRITE_EXTERNAL_STORAGE";
            strArr[1] = !writeOnly ? "android.permission.READ_EXTERNAL_STORAGE" : null;
            return (String[]) CollectionsKt.listOfNotNull((Object[]) strArr).toArray(new String[0]);
        }
        return new String[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureTargetActivityIsAvailable(ImagePickerOptions options) throws MissingActivityToHandleIntent {
        Intent intent = new Intent(options.getNativeMediaTypes().toCameraIntentAction());
        if (intent.resolveActivity(getAppContext().getThrowingActivity().getApplication().getPackageManager()) == null) {
            throw new MissingActivityToHandleIntent(intent.getType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object ensureCameraPermissionsAreGranted(Continuation<? super Unit> continuation) throws ModuleNotFoundException {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        Permissions permissions = getAppContext().getPermissions();
        if (permissions == null) {
            throw new ModuleNotFoundException("Permissions");
        }
        PermissionsResponseListener permissionsResponseListener = new PermissionsResponseListener() { // from class: expo.modules.imagepicker.ImagePickerModule$ensureCameraPermissionsAreGranted$2$1
            @Override // expo.modules.interfaces.permissions.PermissionsResponseListener
            public final void onResult(Map<String, PermissionsResponse> map) {
                if (Build.VERSION.SDK_INT >= 29) {
                    PermissionsResponse permissionsResponse = map.get("android.permission.CAMERA");
                    if ((permissionsResponse != null ? permissionsResponse.getStatus() : null) == PermissionsStatus.GRANTED) {
                        CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl2;
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m5937constructorimpl(Unit.INSTANCE));
                        return;
                    } else {
                        CancellableContinuation<Unit> cancellableContinuation2 = cancellableContinuationImpl2;
                        Result.Companion companion2 = Result.INSTANCE;
                        cancellableContinuation2.resumeWith(Result.m5937constructorimpl(ResultKt.createFailure(new UserRejectedPermissionsException())));
                        return;
                    }
                }
                PermissionsResponse permissionsResponse2 = map.get("android.permission.WRITE_EXTERNAL_STORAGE");
                if ((permissionsResponse2 != null ? permissionsResponse2.getStatus() : null) == PermissionsStatus.GRANTED) {
                    PermissionsResponse permissionsResponse3 = map.get("android.permission.CAMERA");
                    if ((permissionsResponse3 != null ? permissionsResponse3.getStatus() : null) == PermissionsStatus.GRANTED) {
                        CancellableContinuation<Unit> cancellableContinuation3 = cancellableContinuationImpl2;
                        Result.Companion companion3 = Result.INSTANCE;
                        cancellableContinuation3.resumeWith(Result.m5937constructorimpl(Unit.INSTANCE));
                        return;
                    }
                }
                CancellableContinuation<Unit> cancellableContinuation4 = cancellableContinuationImpl2;
                Result.Companion companion4 = Result.INSTANCE;
                cancellableContinuation4.resumeWith(Result.m5937constructorimpl(ResultKt.createFailure(new UserRejectedPermissionsException())));
            }
        };
        String[] strArr = new String[2];
        strArr[0] = Build.VERSION.SDK_INT < 29 ? "android.permission.WRITE_EXTERNAL_STORAGE" : null;
        strArr[1] = "android.permission.CAMERA";
        String[] strArr2 = (String[]) CollectionsKt.listOfNotNull((Object[]) strArr).toArray(new String[0]);
        permissions.askForPermissions(permissionsResponseListener, (String[]) Arrays.copyOf(strArr2, strArr2.length));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }
}
