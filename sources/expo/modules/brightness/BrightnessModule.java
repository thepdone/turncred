package expo.modules.brightness;

import android.app.Activity;
import android.provider.Settings;
import android.view.WindowManager;
import androidx.tracing.Trace;
import expo.modules.core.errors.InvalidArgumentException;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.kotlin.Promise;
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
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.reflect.KType;

/* compiled from: BrightnessModule.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lexpo/modules/brightness/BrightnessModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "brightnessModeJSToNative", "", "jsValue", "brightnessModeNativeToJS", "nativeValue", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "getSystemBrightness", "", "expo-brightness_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BrightnessModule extends Module {
    /* JADX INFO: Access modifiers changed from: private */
    public final int brightnessModeNativeToJS(int nativeValue) {
        if (nativeValue != 0) {
            return nativeValue != 1 ? 0 : 1;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Activity getCurrentActivity() {
        return getAppContext().getThrowingActivity();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2;
        AsyncFunctionComponent asyncFunctionComponent3;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent3;
        AsyncFunctionComponent asyncFunctionComponent4;
        AsyncFunctionComponent asyncFunctionComponent5;
        AsyncFunctionComponent asyncFunctionComponent6;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent4;
        AsyncFunctionComponent asyncFunctionComponent7;
        AsyncFunctionComponent asyncFunctionComponent8;
        AsyncFunctionComponent asyncFunctionComponent9;
        AsyncFunctionComponent asyncFunctionComponent10;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent5;
        BrightnessModule brightnessModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (brightnessModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(brightnessModule);
            moduleDefinitionBuilder.Name("ExpoBrightness");
            moduleDefinitionBuilder.Events(BrightnessModuleKt.brightnessChangeEvent);
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("requestPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.brightness.BrightnessModule$definition$lambda$10$$inlined$AsyncFunction$1
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
                        Permissions.askForPermissionsWithPermissionsManager(this.this$0.getAppContext().getPermissions(), promise, "android.permission.WRITE_SETTINGS");
                    }
                });
            } else {
                AnyType[] anyTypeArr = new AnyType[1];
                AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType == null) {
                    anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.brightness.BrightnessModule$definition$lambda$10$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Promise.class);
                        }
                    }));
                }
                anyTypeArr[0] = anyType;
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.brightness.BrightnessModule$definition$lambda$10$$inlined$AsyncFunction$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Permissions.askForPermissionsWithPermissionsManager(this.this$0.getAppContext().getPermissions(), (Promise) objArr[0], "android.permission.WRITE_SETTINGS");
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent = new StringAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr, function1);
                                } else {
                                    asyncFunctionComponent = new AsyncFunctionComponent("requestPermissionsAsync", anyTypeArr, function1);
                                }
                            } else {
                                asyncFunctionComponent = new FloatAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr, function1);
                            }
                        } else {
                            asyncFunctionComponent = new DoubleAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr, function1);
                        }
                    } else {
                        asyncFunctionComponent = new BoolAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr, function1);
                    }
                } else {
                    asyncFunctionComponent = new IntAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr, function1);
                }
                asyncFunctionWithPromiseComponent = asyncFunctionComponent;
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("requestPermissionsAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("getPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.brightness.BrightnessModule$definition$lambda$10$$inlined$AsyncFunction$4
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
                        Permissions.getPermissionsWithPermissionsManager(this.this$0.getAppContext().getPermissions(), promise, "android.permission.WRITE_SETTINGS");
                    }
                });
            } else {
                AnyType[] anyTypeArr2 = new AnyType[1];
                AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), false));
                if (anyType2 == null) {
                    anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.brightness.BrightnessModule$definition$lambda$10$$inlined$AsyncFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Promise.class);
                        }
                    }));
                }
                anyTypeArr2[0] = anyType2;
                Function1<Object[], Unit> function12 = new Function1<Object[], Unit>() { // from class: expo.modules.brightness.BrightnessModule$definition$lambda$10$$inlined$AsyncFunction$6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Permissions.getPermissionsWithPermissionsManager(this.this$0.getAppContext().getPermissions(), (Promise) objArr[0], "android.permission.WRITE_SETTINGS");
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent2 = new StringAsyncFunctionComponent("getPermissionsAsync", anyTypeArr2, function12);
                                } else {
                                    asyncFunctionComponent2 = new AsyncFunctionComponent("getPermissionsAsync", anyTypeArr2, function12);
                                }
                            } else {
                                asyncFunctionComponent2 = new FloatAsyncFunctionComponent("getPermissionsAsync", anyTypeArr2, function12);
                            }
                        } else {
                            asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("getPermissionsAsync", anyTypeArr2, function12);
                        }
                    } else {
                        asyncFunctionComponent2 = new BoolAsyncFunctionComponent("getPermissionsAsync", anyTypeArr2, function12);
                    }
                } else {
                    asyncFunctionComponent2 = new IntAsyncFunctionComponent("getPermissionsAsync", anyTypeArr2, function12);
                }
                asyncFunctionWithPromiseComponent2 = asyncFunctionComponent2;
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("getPermissionsAsync", asyncFunctionWithPromiseComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Float.class, Promise.class)) {
                asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent("setBrightnessAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.brightness.BrightnessModule$definition$lambda$10$$inlined$AsyncFunction$7
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        float fFloatValue = ((Float) promise).floatValue();
                        WindowManager.LayoutParams attributes = this.this$0.getCurrentActivity().getWindow().getAttributes();
                        attributes.screenBrightness = fFloatValue;
                        this.this$0.getCurrentActivity().getWindow().setAttributes(attributes);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr3 = new AnyType[1];
                AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Float.class), false));
                if (anyType3 == null) {
                    anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Float.class), false, new Function0<KType>() { // from class: expo.modules.brightness.BrightnessModule$definition$lambda$10$$inlined$AsyncFunction$8
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Float.TYPE);
                        }
                    }));
                }
                anyTypeArr3[0] = anyType3;
                Function1<Object[], Unit> function13 = new Function1<Object[], Unit>() { // from class: expo.modules.brightness.BrightnessModule$definition$lambda$10$$inlined$AsyncFunction$9
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        float fFloatValue = ((Number) objArr[0]).floatValue();
                        WindowManager.LayoutParams attributes = this.this$0.getCurrentActivity().getWindow().getAttributes();
                        attributes.screenBrightness = fFloatValue;
                        this.this$0.getCurrentActivity().getWindow().setAttributes(attributes);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent3 = new StringAsyncFunctionComponent("setBrightnessAsync", anyTypeArr3, function13);
                                } else {
                                    asyncFunctionComponent3 = new AsyncFunctionComponent("setBrightnessAsync", anyTypeArr3, function13);
                                }
                            } else {
                                asyncFunctionComponent3 = new FloatAsyncFunctionComponent("setBrightnessAsync", anyTypeArr3, function13);
                            }
                        } else {
                            asyncFunctionComponent3 = new DoubleAsyncFunctionComponent("setBrightnessAsync", anyTypeArr3, function13);
                        }
                    } else {
                        asyncFunctionComponent3 = new BoolAsyncFunctionComponent("setBrightnessAsync", anyTypeArr3, function13);
                    }
                } else {
                    asyncFunctionComponent3 = new IntAsyncFunctionComponent("setBrightnessAsync", anyTypeArr3, function13);
                }
                asyncFunctionWithPromiseComponent3 = asyncFunctionComponent3;
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("setBrightnessAsync", asyncFunctionWithPromiseComponent3);
            asyncFunctionWithPromiseComponent3.runOnQueue(Queues.MAIN);
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr4 = new AnyType[0];
            Function1<Object[], Float> function14 = new Function1<Object[], Float>() { // from class: expo.modules.brightness.BrightnessModule$definition$lambda$10$$inlined$AsyncFunction$10
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Float invoke(Object[] it) {
                    float systemBrightness;
                    Intrinsics.checkNotNullParameter(it, "it");
                    WindowManager.LayoutParams attributes = this.this$0.getCurrentActivity().getWindow().getAttributes();
                    if (attributes.screenBrightness == -1.0f) {
                        systemBrightness = this.this$0.getSystemBrightness();
                    } else {
                        systemBrightness = attributes.screenBrightness;
                    }
                    return Float.valueOf(systemBrightness);
                }
            };
            if (!Intrinsics.areEqual(Float.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Float.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Float.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Float.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Float.class, String.class)) {
                                asyncFunctionComponent4 = new StringAsyncFunctionComponent("getBrightnessAsync", anyTypeArr4, function14);
                            } else {
                                asyncFunctionComponent4 = new AsyncFunctionComponent("getBrightnessAsync", anyTypeArr4, function14);
                            }
                        } else {
                            asyncFunctionComponent4 = new FloatAsyncFunctionComponent("getBrightnessAsync", anyTypeArr4, function14);
                        }
                    } else {
                        asyncFunctionComponent4 = new DoubleAsyncFunctionComponent("getBrightnessAsync", anyTypeArr4, function14);
                    }
                } else {
                    asyncFunctionComponent4 = new BoolAsyncFunctionComponent("getBrightnessAsync", anyTypeArr4, function14);
                }
            } else {
                asyncFunctionComponent4 = new IntAsyncFunctionComponent("getBrightnessAsync", anyTypeArr4, function14);
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("getBrightnessAsync", asyncFunctionComponent4);
            asyncFunctionComponent4.runOnQueue(Queues.MAIN);
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr5 = new AnyType[0];
            Function1<Object[], Float> function15 = new Function1<Object[], Float>() { // from class: expo.modules.brightness.BrightnessModule$definition$lambda$10$$inlined$AsyncFunction$11
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Float invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Float.valueOf(this.this$0.getSystemBrightness());
                }
            };
            if (!Intrinsics.areEqual(Float.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Float.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Float.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Float.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Float.class, String.class)) {
                                asyncFunctionComponent5 = new StringAsyncFunctionComponent("getSystemBrightnessAsync", anyTypeArr5, function15);
                            } else {
                                asyncFunctionComponent5 = new AsyncFunctionComponent("getSystemBrightnessAsync", anyTypeArr5, function15);
                            }
                        } else {
                            asyncFunctionComponent5 = new FloatAsyncFunctionComponent("getSystemBrightnessAsync", anyTypeArr5, function15);
                        }
                    } else {
                        asyncFunctionComponent5 = new DoubleAsyncFunctionComponent("getSystemBrightnessAsync", anyTypeArr5, function15);
                    }
                } else {
                    asyncFunctionComponent5 = new BoolAsyncFunctionComponent("getSystemBrightnessAsync", anyTypeArr5, function15);
                }
            } else {
                asyncFunctionComponent5 = new IntAsyncFunctionComponent("getSystemBrightnessAsync", anyTypeArr5, function15);
            }
            moduleDefinitionBuilder6.getAsyncFunctions().put("getSystemBrightnessAsync", asyncFunctionComponent5);
            ModuleDefinitionBuilder moduleDefinitionBuilder7 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Float.class, Promise.class)) {
                asyncFunctionWithPromiseComponent4 = new AsyncFunctionWithPromiseComponent("setSystemBrightnessAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.brightness.BrightnessModule$definition$lambda$10$$inlined$AsyncFunction$12
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws BrightnessPermissionsException {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        float fFloatValue = ((Float) promise).floatValue();
                        if (!Settings.System.canWrite(this.this$0.getCurrentActivity())) {
                            throw new BrightnessPermissionsException();
                        }
                        Settings.System.putInt(this.this$0.getCurrentActivity().getContentResolver(), "screen_brightness_mode", 0);
                        Settings.System.putInt(this.this$0.getCurrentActivity().getContentResolver(), "screen_brightness", MathKt.roundToInt(fFloatValue * 255));
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws BrightnessPermissionsException {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr6 = new AnyType[1];
                AnyType anyType4 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Float.class), false));
                if (anyType4 == null) {
                    anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Float.class), false, new Function0<KType>() { // from class: expo.modules.brightness.BrightnessModule$definition$lambda$10$$inlined$AsyncFunction$13
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Float.TYPE);
                        }
                    }));
                }
                anyTypeArr6[0] = anyType4;
                Function1<Object[], Boolean> function16 = new Function1<Object[], Boolean>() { // from class: expo.modules.brightness.BrightnessModule$definition$lambda$10$$inlined$AsyncFunction$14
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(Object[] objArr) throws BrightnessPermissionsException {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        float fFloatValue = ((Number) objArr[0]).floatValue();
                        if (!Settings.System.canWrite(this.this$0.getCurrentActivity())) {
                            throw new BrightnessPermissionsException();
                        }
                        Settings.System.putInt(this.this$0.getCurrentActivity().getContentResolver(), "screen_brightness_mode", 0);
                        return Boolean.valueOf(Settings.System.putInt(this.this$0.getCurrentActivity().getContentResolver(), "screen_brightness", MathKt.roundToInt(fFloatValue * 255)));
                    }
                };
                if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                    asyncFunctionComponent6 = new StringAsyncFunctionComponent("setSystemBrightnessAsync", anyTypeArr6, function16);
                                } else {
                                    asyncFunctionComponent6 = new AsyncFunctionComponent("setSystemBrightnessAsync", anyTypeArr6, function16);
                                }
                            } else {
                                asyncFunctionComponent6 = new FloatAsyncFunctionComponent("setSystemBrightnessAsync", anyTypeArr6, function16);
                            }
                        } else {
                            asyncFunctionComponent6 = new DoubleAsyncFunctionComponent("setSystemBrightnessAsync", anyTypeArr6, function16);
                        }
                    } else {
                        asyncFunctionComponent6 = new BoolAsyncFunctionComponent("setSystemBrightnessAsync", anyTypeArr6, function16);
                    }
                } else {
                    asyncFunctionComponent6 = new IntAsyncFunctionComponent("setSystemBrightnessAsync", anyTypeArr6, function16);
                }
                asyncFunctionWithPromiseComponent4 = asyncFunctionComponent6;
            }
            moduleDefinitionBuilder7.getAsyncFunctions().put("setSystemBrightnessAsync", asyncFunctionWithPromiseComponent4);
            ModuleDefinitionBuilder moduleDefinitionBuilder8 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr7 = new AnyType[0];
            Function1<Object[], Unit> function17 = new Function1<Object[], Unit>() { // from class: expo.modules.brightness.BrightnessModule$definition$lambda$10$$inlined$AsyncFunction$15
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    WindowManager.LayoutParams attributes = this.this$0.getCurrentActivity().getWindow().getAttributes();
                    attributes.screenBrightness = -1.0f;
                    this.this$0.getCurrentActivity().getWindow().setAttributes(attributes);
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                asyncFunctionComponent7 = new StringAsyncFunctionComponent("restoreSystemBrightnessAsync", anyTypeArr7, function17);
                            } else {
                                asyncFunctionComponent7 = new AsyncFunctionComponent("restoreSystemBrightnessAsync", anyTypeArr7, function17);
                            }
                        } else {
                            asyncFunctionComponent7 = new FloatAsyncFunctionComponent("restoreSystemBrightnessAsync", anyTypeArr7, function17);
                        }
                    } else {
                        asyncFunctionComponent7 = new DoubleAsyncFunctionComponent("restoreSystemBrightnessAsync", anyTypeArr7, function17);
                    }
                } else {
                    asyncFunctionComponent7 = new BoolAsyncFunctionComponent("restoreSystemBrightnessAsync", anyTypeArr7, function17);
                }
            } else {
                asyncFunctionComponent7 = new IntAsyncFunctionComponent("restoreSystemBrightnessAsync", anyTypeArr7, function17);
            }
            moduleDefinitionBuilder8.getAsyncFunctions().put("restoreSystemBrightnessAsync", asyncFunctionComponent7);
            asyncFunctionComponent7.runOnQueue(Queues.MAIN);
            ModuleDefinitionBuilder moduleDefinitionBuilder9 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr8 = new AnyType[0];
            Function1<Object[], Boolean> function18 = new Function1<Object[], Boolean>() { // from class: expo.modules.brightness.BrightnessModule$definition$lambda$10$$inlined$AsyncFunction$16
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(this.this$0.getCurrentActivity().getWindow().getAttributes().screenBrightness == -1.0f);
                }
            };
            if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                asyncFunctionComponent8 = new StringAsyncFunctionComponent("isUsingSystemBrightnessAsync", anyTypeArr8, function18);
                            } else {
                                asyncFunctionComponent8 = new AsyncFunctionComponent("isUsingSystemBrightnessAsync", anyTypeArr8, function18);
                            }
                        } else {
                            asyncFunctionComponent8 = new FloatAsyncFunctionComponent("isUsingSystemBrightnessAsync", anyTypeArr8, function18);
                        }
                    } else {
                        asyncFunctionComponent8 = new DoubleAsyncFunctionComponent("isUsingSystemBrightnessAsync", anyTypeArr8, function18);
                    }
                } else {
                    asyncFunctionComponent8 = new BoolAsyncFunctionComponent("isUsingSystemBrightnessAsync", anyTypeArr8, function18);
                }
            } else {
                asyncFunctionComponent8 = new IntAsyncFunctionComponent("isUsingSystemBrightnessAsync", anyTypeArr8, function18);
            }
            moduleDefinitionBuilder9.getAsyncFunctions().put("isUsingSystemBrightnessAsync", asyncFunctionComponent8);
            asyncFunctionComponent8.runOnQueue(Queues.MAIN);
            ModuleDefinitionBuilder moduleDefinitionBuilder10 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr9 = new AnyType[0];
            Function1<Object[], Integer> function19 = new Function1<Object[], Integer>() { // from class: expo.modules.brightness.BrightnessModule$definition$lambda$10$$inlined$AsyncFunction$17
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Integer invoke(Object[] it) throws Settings.SettingNotFoundException {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Integer.valueOf(this.this$0.brightnessModeNativeToJS(Settings.System.getInt(this.this$0.getCurrentActivity().getContentResolver(), "screen_brightness_mode")));
                }
            };
            if (!Intrinsics.areEqual(Integer.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Integer.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Integer.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Integer.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Integer.class, String.class)) {
                                asyncFunctionComponent9 = new StringAsyncFunctionComponent("getSystemBrightnessModeAsync", anyTypeArr9, function19);
                            } else {
                                asyncFunctionComponent9 = new AsyncFunctionComponent("getSystemBrightnessModeAsync", anyTypeArr9, function19);
                            }
                        } else {
                            asyncFunctionComponent9 = new FloatAsyncFunctionComponent("getSystemBrightnessModeAsync", anyTypeArr9, function19);
                        }
                    } else {
                        asyncFunctionComponent9 = new DoubleAsyncFunctionComponent("getSystemBrightnessModeAsync", anyTypeArr9, function19);
                    }
                } else {
                    asyncFunctionComponent9 = new BoolAsyncFunctionComponent("getSystemBrightnessModeAsync", anyTypeArr9, function19);
                }
            } else {
                asyncFunctionComponent9 = new IntAsyncFunctionComponent("getSystemBrightnessModeAsync", anyTypeArr9, function19);
            }
            moduleDefinitionBuilder10.getAsyncFunctions().put("getSystemBrightnessModeAsync", asyncFunctionComponent9);
            ModuleDefinitionBuilder moduleDefinitionBuilder11 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Integer.class, Promise.class)) {
                asyncFunctionWithPromiseComponent5 = new AsyncFunctionWithPromiseComponent("setSystemBrightnessModeAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.brightness.BrightnessModule$definition$lambda$10$$inlined$AsyncFunction$18
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws BrightnessPermissionsException {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        int iIntValue = ((Integer) promise).intValue();
                        if (!Settings.System.canWrite(this.this$0.getCurrentActivity())) {
                            throw new BrightnessPermissionsException();
                        }
                        Settings.System.putInt(this.this$0.getCurrentActivity().getContentResolver(), "screen_brightness_mode", this.this$0.brightnessModeJSToNative(iIntValue));
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws BrightnessPermissionsException {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr10 = new AnyType[1];
                AnyType anyType5 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
                if (anyType5 == null) {
                    anyType5 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.brightness.BrightnessModule$definition$lambda$10$$inlined$AsyncFunction$19
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Integer.TYPE);
                        }
                    }));
                }
                anyTypeArr10[0] = anyType5;
                Function1<Object[], Boolean> function110 = new Function1<Object[], Boolean>() { // from class: expo.modules.brightness.BrightnessModule$definition$lambda$10$$inlined$AsyncFunction$20
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(Object[] objArr) throws BrightnessPermissionsException {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        int iIntValue = ((Number) objArr[0]).intValue();
                        if (!Settings.System.canWrite(this.this$0.getCurrentActivity())) {
                            throw new BrightnessPermissionsException();
                        }
                        return Boolean.valueOf(Settings.System.putInt(this.this$0.getCurrentActivity().getContentResolver(), "screen_brightness_mode", this.this$0.brightnessModeJSToNative(iIntValue)));
                    }
                };
                if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                    asyncFunctionComponent10 = new StringAsyncFunctionComponent("setSystemBrightnessModeAsync", anyTypeArr10, function110);
                                } else {
                                    asyncFunctionComponent10 = new AsyncFunctionComponent("setSystemBrightnessModeAsync", anyTypeArr10, function110);
                                }
                            } else {
                                asyncFunctionComponent10 = new FloatAsyncFunctionComponent("setSystemBrightnessModeAsync", anyTypeArr10, function110);
                            }
                        } else {
                            asyncFunctionComponent10 = new DoubleAsyncFunctionComponent("setSystemBrightnessModeAsync", anyTypeArr10, function110);
                        }
                    } else {
                        asyncFunctionComponent10 = new BoolAsyncFunctionComponent("setSystemBrightnessModeAsync", anyTypeArr10, function110);
                    }
                } else {
                    asyncFunctionComponent10 = new IntAsyncFunctionComponent("setSystemBrightnessModeAsync", anyTypeArr10, function110);
                }
                asyncFunctionWithPromiseComponent5 = asyncFunctionComponent10;
            }
            moduleDefinitionBuilder11.getAsyncFunctions().put("setSystemBrightnessModeAsync", asyncFunctionWithPromiseComponent5);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getSystemBrightness() {
        float f;
        float f2;
        if (Settings.System.getInt(getCurrentActivity().getContentResolver(), "screen_brightness_mode") == 1) {
            f = Settings.System.getFloat(getCurrentActivity().getContentResolver(), "screen_auto_brightness_adj") + 1.0f;
            f2 = 2;
        } else {
            String string = Settings.System.getString(getCurrentActivity().getContentResolver(), "screen_brightness");
            Intrinsics.checkNotNull(string);
            f = Integer.parseInt(string);
            f2 = 255.0f;
        }
        return f / f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int brightnessModeJSToNative(int jsValue) throws InvalidArgumentException {
        if (jsValue == 1) {
            return 1;
        }
        if (jsValue == 2) {
            return 0;
        }
        throw new InvalidArgumentException("Unsupported brightness mode " + jsValue);
    }
}
