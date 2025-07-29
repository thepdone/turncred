package expo.modules.localauthentication;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.tracing.Trace;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.EventListenerWithSenderAndPayload;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.events.OnActivityResultPayload;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.exception.UnexpectedException;
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
import io.sentry.ProfilingTraceData;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LocalAuthenticationModule.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#H\u0003J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020*H\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020*H\u0002J \u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u00010-2\n\b\u0002\u00102\u001a\u0004\u0018\u00010-H\u0002J\b\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u00020-H\u0002J\u0010\u00107\u001a\u00020\u00142\u0006\u0010.\u001a\u00020*H\u0002J\u0018\u00108\u001a\u00020%2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR#\u0010\u001c\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\f\u001a\u0004\b\u001f\u0010 R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lexpo/modules/localauthentication/LocalAuthenticationModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "authOptions", "Lexpo/modules/localauthentication/AuthOptions;", "authenticationCallback", "Landroidx/biometric/BiometricPrompt$AuthenticationCallback;", "biometricManager", "Landroidx/biometric/BiometricManager;", "getBiometricManager", "()Landroidx/biometric/BiometricManager;", "biometricManager$delegate", "Lkotlin/Lazy;", "biometricPrompt", "Landroidx/biometric/BiometricPrompt;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "isAuthenticating", "", "isDeviceSecure", "()Z", "isRetryingWithDeviceCredentials", "keyguardManager", "Landroid/app/KeyguardManager;", "getKeyguardManager", "()Landroid/app/KeyguardManager;", "packageManager", "Landroid/content/pm/PackageManager;", "kotlin.jvm.PlatformType", "getPackageManager", "()Landroid/content/pm/PackageManager;", "packageManager$delegate", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "authenticate", "", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "canAuthenticateUsingStrongBiometrics", "", "canAuthenticateUsingWeakBiometrics", "convertErrorCode", "", "code", "createResponse", "Landroid/os/Bundle;", "error", "warning", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "hasSystemFeature", "feature", "isBiometricUnavailable", "promptDeviceCredentialsFallback", "expo-local-authentication_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocalAuthenticationModule extends Module {
    private AuthOptions authOptions;
    private BiometricPrompt biometricPrompt;
    private boolean isAuthenticating;
    private boolean isRetryingWithDeviceCredentials;
    private Promise promise;

    /* renamed from: biometricManager$delegate, reason: from kotlin metadata */
    private final Lazy biometricManager = LazyKt.lazy(new Function0<BiometricManager>() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$biometricManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BiometricManager invoke() {
            return BiometricManager.from(this.this$0.getContext());
        }
    });

    /* renamed from: packageManager$delegate, reason: from kotlin metadata */
    private final Lazy packageManager = LazyKt.lazy(new Function0<PackageManager>() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$packageManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PackageManager invoke() {
            return this.this$0.getContext().getPackageManager();
        }
    });
    private final BiometricPrompt.AuthenticationCallback authenticationCallback = new BiometricPrompt.AuthenticationCallback() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$authenticationCallback$1
        @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.this$0.isAuthenticating = false;
            this.this$0.isRetryingWithDeviceCredentials = false;
            this.this$0.biometricPrompt = null;
            Promise promise = this.this$0.promise;
            if (promise != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("success", true);
                promise.resolve(bundle);
            }
            this.this$0.promise = null;
            this.this$0.authOptions = null;
        }

        @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationError(int errMsgId, CharSequence errString) {
            AuthOptions authOptions;
            Promise promise;
            Intrinsics.checkNotNullParameter(errString, "errString");
            if (!this.this$0.isBiometricUnavailable(errMsgId) || !this.this$0.isDeviceSecure() || this.this$0.isRetryingWithDeviceCredentials || (authOptions = this.this$0.authOptions) == null || authOptions.getDisableDeviceFallback() || (promise = this.this$0.promise) == null) {
                this.this$0.isAuthenticating = false;
                this.this$0.isRetryingWithDeviceCredentials = false;
                this.this$0.biometricPrompt = null;
                Promise promise2 = this.this$0.promise;
                if (promise2 != null) {
                    LocalAuthenticationModule localAuthenticationModule = this.this$0;
                    promise2.resolve(localAuthenticationModule.createResponse(localAuthenticationModule.convertErrorCode(errMsgId), errString.toString()));
                }
                this.this$0.promise = null;
                this.this$0.authOptions = null;
                return;
            }
            LocalAuthenticationModule localAuthenticationModule2 = this.this$0;
            localAuthenticationModule2.isRetryingWithDeviceCredentials = true;
            localAuthenticationModule2.promptDeviceCredentialsFallback(authOptions, promise);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isBiometricUnavailable(int code) {
        return code == 1 || code == 2 || code == 4 || code == 11 || code == 12;
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        AsyncFunctionComponent asyncFunctionComponent3;
        AsyncFunctionComponent asyncFunctionComponent4;
        AsyncFunctionComponent asyncFunctionComponent5;
        LocalAuthenticationModule localAuthenticationModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (localAuthenticationModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(localAuthenticationModule);
            moduleDefinitionBuilder.Name("ExpoLocalAuthentication");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[0];
            Function1<Object[], Set<? extends Integer>> function1 = new Function1<Object[], Set<? extends Integer>>() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$definition$lambda$8$$inlined$AsyncFunction$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Set<? extends Integer> invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    if (this.this$0.canAuthenticateUsingWeakBiometrics() != 12) {
                        LocalAuthenticationModuleKt.addIf(linkedHashSet, this.this$0.hasSystemFeature("android.hardware.fingerprint"), 1);
                        LocalAuthenticationModuleKt.addIf(linkedHashSet, this.this$0.hasSystemFeature("android.hardware.biometrics.face"), 2);
                        LocalAuthenticationModuleKt.addIf(linkedHashSet, this.this$0.hasSystemFeature("android.hardware.biometrics.iris"), 3);
                        LocalAuthenticationModuleKt.addIf(linkedHashSet, this.this$0.hasSystemFeature("com.samsung.android.bio.face"), 2);
                    }
                    return linkedHashSet;
                }
            };
            if (!Intrinsics.areEqual(Set.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Set.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Set.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Set.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Set.class, String.class)) {
                                asyncFunctionComponent = new StringAsyncFunctionComponent("supportedAuthenticationTypesAsync", anyTypeArr, function1);
                            } else {
                                asyncFunctionComponent = new AsyncFunctionComponent("supportedAuthenticationTypesAsync", anyTypeArr, function1);
                            }
                        } else {
                            asyncFunctionComponent = new FloatAsyncFunctionComponent("supportedAuthenticationTypesAsync", anyTypeArr, function1);
                        }
                    } else {
                        asyncFunctionComponent = new DoubleAsyncFunctionComponent("supportedAuthenticationTypesAsync", anyTypeArr, function1);
                    }
                } else {
                    asyncFunctionComponent = new BoolAsyncFunctionComponent("supportedAuthenticationTypesAsync", anyTypeArr, function1);
                }
            } else {
                asyncFunctionComponent = new IntAsyncFunctionComponent("supportedAuthenticationTypesAsync", anyTypeArr, function1);
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("supportedAuthenticationTypesAsync", asyncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr2 = new AnyType[0];
            Function1<Object[], Boolean> function12 = new Function1<Object[], Boolean>() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$definition$lambda$8$$inlined$AsyncFunction$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(this.this$0.canAuthenticateUsingWeakBiometrics() != 12);
                }
            };
            if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                asyncFunctionComponent2 = new StringAsyncFunctionComponent("hasHardwareAsync", anyTypeArr2, function12);
                            } else {
                                asyncFunctionComponent2 = new AsyncFunctionComponent("hasHardwareAsync", anyTypeArr2, function12);
                            }
                        } else {
                            asyncFunctionComponent2 = new FloatAsyncFunctionComponent("hasHardwareAsync", anyTypeArr2, function12);
                        }
                    } else {
                        asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("hasHardwareAsync", anyTypeArr2, function12);
                    }
                } else {
                    asyncFunctionComponent2 = new BoolAsyncFunctionComponent("hasHardwareAsync", anyTypeArr2, function12);
                }
            } else {
                asyncFunctionComponent2 = new IntAsyncFunctionComponent("hasHardwareAsync", anyTypeArr2, function12);
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("hasHardwareAsync", asyncFunctionComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr3 = new AnyType[0];
            Function1<Object[], Boolean> function13 = new Function1<Object[], Boolean>() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$definition$lambda$8$$inlined$AsyncFunction$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(this.this$0.canAuthenticateUsingWeakBiometrics() == 0);
                }
            };
            if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                asyncFunctionComponent3 = new StringAsyncFunctionComponent("isEnrolledAsync", anyTypeArr3, function13);
                            } else {
                                asyncFunctionComponent3 = new AsyncFunctionComponent("isEnrolledAsync", anyTypeArr3, function13);
                            }
                        } else {
                            asyncFunctionComponent3 = new FloatAsyncFunctionComponent("isEnrolledAsync", anyTypeArr3, function13);
                        }
                    } else {
                        asyncFunctionComponent3 = new DoubleAsyncFunctionComponent("isEnrolledAsync", anyTypeArr3, function13);
                    }
                } else {
                    asyncFunctionComponent3 = new BoolAsyncFunctionComponent("isEnrolledAsync", anyTypeArr3, function13);
                }
            } else {
                asyncFunctionComponent3 = new IntAsyncFunctionComponent("isEnrolledAsync", anyTypeArr3, function13);
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("isEnrolledAsync", asyncFunctionComponent3);
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr4 = new AnyType[0];
            Function1<Object[], Integer> function14 = new Function1<Object[], Integer>() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$definition$lambda$8$$inlined$AsyncFunction$4
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r2v3 */
                /* JADX WARN: Type inference failed for: r2v7 */
                /* JADX WARN: Type inference failed for: r2v8 */
                @Override // kotlin.jvm.functions.Function1
                public final Integer invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ?? IsDeviceSecure = this.this$0.isDeviceSecure();
                    if (this.this$0.canAuthenticateUsingWeakBiometrics() == 0) {
                        IsDeviceSecure = 2;
                    }
                    int i = IsDeviceSecure;
                    if (this.this$0.canAuthenticateUsingStrongBiometrics() == 0) {
                        i = 3;
                    }
                    return Integer.valueOf(i);
                }
            };
            if (!Intrinsics.areEqual(Integer.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Integer.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Integer.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Integer.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Integer.class, String.class)) {
                                asyncFunctionComponent4 = new StringAsyncFunctionComponent("getEnrolledLevelAsync", anyTypeArr4, function14);
                            } else {
                                asyncFunctionComponent4 = new AsyncFunctionComponent("getEnrolledLevelAsync", anyTypeArr4, function14);
                            }
                        } else {
                            asyncFunctionComponent4 = new FloatAsyncFunctionComponent("getEnrolledLevelAsync", anyTypeArr4, function14);
                        }
                    } else {
                        asyncFunctionComponent4 = new DoubleAsyncFunctionComponent("getEnrolledLevelAsync", anyTypeArr4, function14);
                    }
                } else {
                    asyncFunctionComponent4 = new BoolAsyncFunctionComponent("getEnrolledLevelAsync", anyTypeArr4, function14);
                }
            } else {
                asyncFunctionComponent4 = new IntAsyncFunctionComponent("getEnrolledLevelAsync", anyTypeArr4, function14);
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("getEnrolledLevelAsync", asyncFunctionComponent4);
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr5 = new AnyType[1];
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(AuthOptions.class), false));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(AuthOptions.class), false, new Function0<KType>() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$definition$lambda$8$$inlined$AsyncFunctionWithPromise$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(AuthOptions.class);
                    }
                }));
            }
            anyTypeArr5[0] = anyType;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("authenticateAsync", anyTypeArr5, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$definition$lambda$8$$inlined$AsyncFunctionWithPromise$2
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) throws Exceptions.MissingActivity {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    AuthOptions authOptions = (AuthOptions) objArr[0];
                    Activity throwingActivity = this.this$0.getAppContext().getThrowingActivity();
                    FragmentActivity fragmentActivity = throwingActivity instanceof FragmentActivity ? (FragmentActivity) throwingActivity : null;
                    if (fragmentActivity != null) {
                        if (this.this$0.getKeyguardManager().isDeviceSecure()) {
                            this.this$0.authOptions = authOptions;
                            BuildersKt__Builders_commonKt.launch$default(this.this$0.getAppContext().getMainQueue(), null, null, new LocalAuthenticationModule$definition$1$5$1(this.this$0, fragmentActivity, authOptions, promise, null), 3, null);
                            return;
                        } else {
                            promise.resolve(this.this$0.createResponse("not_enrolled", "KeyguardManager#isDeviceSecure() returned false"));
                            return;
                        }
                    }
                    promise.reject(new Exceptions.MissingActivity());
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws Exceptions.MissingActivity {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder6.getAsyncFunctions().put("authenticateAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder7 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr6 = new AnyType[0];
            Function1<Object[], Unit> function15 = new Function1<Object[], Unit>() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$definition$lambda$8$$inlined$AsyncFunction$5
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    BiometricPrompt biometricPrompt = this.this$0.biometricPrompt;
                    if (biometricPrompt != null) {
                        biometricPrompt.cancelAuthentication();
                    }
                    this.this$0.isAuthenticating = false;
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                asyncFunctionComponent5 = new StringAsyncFunctionComponent("cancelAuthenticate", anyTypeArr6, function15);
                            } else {
                                asyncFunctionComponent5 = new AsyncFunctionComponent("cancelAuthenticate", anyTypeArr6, function15);
                            }
                        } else {
                            asyncFunctionComponent5 = new FloatAsyncFunctionComponent("cancelAuthenticate", anyTypeArr6, function15);
                        }
                    } else {
                        asyncFunctionComponent5 = new DoubleAsyncFunctionComponent("cancelAuthenticate", anyTypeArr6, function15);
                    }
                } else {
                    asyncFunctionComponent5 = new BoolAsyncFunctionComponent("cancelAuthenticate", anyTypeArr6, function15);
                }
            } else {
                asyncFunctionComponent5 = new IntAsyncFunctionComponent("cancelAuthenticate", anyTypeArr6, function15);
            }
            moduleDefinitionBuilder7.getAsyncFunctions().put("cancelAuthenticate", asyncFunctionComponent5);
            asyncFunctionComponent5.runOnQueue(Queues.MAIN);
            moduleDefinitionBuilder.getEventListeners().put(EventName.ON_ACTIVITY_RESULT, new EventListenerWithSenderAndPayload(EventName.ON_ACTIVITY_RESULT, new Function2<Activity, OnActivityResultPayload, Unit>() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$definition$lambda$8$$inlined$OnActivityResult$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Activity activity, OnActivityResultPayload onActivityResultPayload) {
                    invoke2(activity, onActivityResultPayload);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Activity sender, OnActivityResultPayload payload) {
                    Fragment fragmentFindFragmentByTag;
                    Intrinsics.checkNotNullParameter(sender, "sender");
                    Intrinsics.checkNotNullParameter(payload, "payload");
                    int requestCode = payload.getRequestCode();
                    int resultCode = payload.getResultCode();
                    Intent data = payload.getData();
                    if (requestCode == 6) {
                        if (resultCode == -1) {
                            Promise promise = this.this$0.promise;
                            if (promise != null) {
                                promise.resolve(LocalAuthenticationModule.createResponse$default(this.this$0, null, null, 3, null));
                            }
                        } else {
                            Promise promise2 = this.this$0.promise;
                            if (promise2 != null) {
                                promise2.resolve(this.this$0.createResponse("user_cancel", "Device Credentials canceled"));
                            }
                        }
                        this.this$0.isAuthenticating = false;
                        this.this$0.isRetryingWithDeviceCredentials = false;
                        this.this$0.biometricPrompt = null;
                        this.this$0.promise = null;
                        this.this$0.authOptions = null;
                        return;
                    }
                    if (!(sender instanceof FragmentActivity) || (fragmentFindFragmentByTag = ((FragmentActivity) sender).getSupportFragmentManager().findFragmentByTag("androidx.biometric.BiometricFragment")) == null) {
                        return;
                    }
                    fragmentFindFragmentByTag.onActivityResult(requestCode & 65535, resultCode, data);
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() throws Exceptions.ReactContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KeyguardManager getKeyguardManager() {
        Object systemService = getContext().getSystemService("keyguard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
        return (KeyguardManager) systemService;
    }

    private final BiometricManager getBiometricManager() {
        return (BiometricManager) this.biometricManager.getValue();
    }

    private final PackageManager getPackageManager() {
        return (PackageManager) this.packageManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void authenticate(FragmentActivity fragmentActivity, AuthOptions options, Promise promise) {
        int nativeBiometricSecurityLevel;
        if (this.isAuthenticating) {
            Promise promise2 = this.promise;
            if (promise2 != null) {
                promise2.resolve(createResponse$default(this, "app_cancel", null, 2, null));
            }
            this.promise = promise;
            return;
        }
        String promptMessage = options.getPromptMessage();
        String cancelLabel = options.getCancelLabel();
        boolean requireConfirmation = options.getRequireConfirmation();
        if (options.getDisableDeviceFallback()) {
            nativeBiometricSecurityLevel = options.getBiometricsSecurityLevel().toNativeBiometricSecurityLevel();
        } else {
            nativeBiometricSecurityLevel = options.getBiometricsSecurityLevel().toNativeBiometricSecurityLevel() | 32768;
        }
        this.isAuthenticating = true;
        this.promise = promise;
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.biometricPrompt = new BiometricPrompt(fragmentActivity, executorServiceNewSingleThreadExecutor, this.authenticationCallback);
        BiometricPrompt.PromptInfo.Builder builder = new BiometricPrompt.PromptInfo.Builder();
        builder.setTitle(promptMessage);
        builder.setAllowedAuthenticators(nativeBiometricSecurityLevel);
        if (options.getDisableDeviceFallback()) {
            builder.setNegativeButtonText(cancelLabel);
        }
        builder.setConfirmationRequired(requireConfirmation);
        BiometricPrompt.PromptInfo promptInfoBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(promptInfoBuild, "build(...)");
        try {
            BiometricPrompt biometricPrompt = this.biometricPrompt;
            Intrinsics.checkNotNull(biometricPrompt);
            biometricPrompt.authenticate(promptInfoBuild);
        } catch (NullPointerException e) {
            promise.reject(new UnexpectedException("Canceled authentication due to an internal error", e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void promptDeviceCredentialsFallback(AuthOptions options, Promise promise) {
        FragmentActivity fragmentActivity = (FragmentActivity) getAppContext().getThrowingActivity();
        if (fragmentActivity == null) {
            promise.resolve(createResponse("not_available", "getCurrentActivity() returned null"));
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(getAppContext().getMainQueue(), null, null, new AnonymousClass1(options.getPromptMessage(), fragmentActivity, promise, options.getRequireConfirmation(), null), 3, null);
    }

    /* compiled from: LocalAuthenticationModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.localauthentication.LocalAuthenticationModule$promptDeviceCredentialsFallback$1", f = "LocalAuthenticationModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: expo.modules.localauthentication.LocalAuthenticationModule$promptDeviceCredentialsFallback$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FragmentActivity $fragmentActivity;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ String $promptMessage;
        final /* synthetic */ boolean $requireConfirmation;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, FragmentActivity fragmentActivity, Promise promise, boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$promptMessage = str;
            this.$fragmentActivity = fragmentActivity;
            this.$promise = promise;
            this.$requireConfirmation = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LocalAuthenticationModule.this.new AnonymousClass1(this.$promptMessage, this.$fragmentActivity, this.$promise, this.$requireConfirmation, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (Build.VERSION.SDK_INT < 30) {
                this.$fragmentActivity.startActivityForResult(LocalAuthenticationModule.this.getKeyguardManager().createConfirmDeviceCredentialIntent(this.$promptMessage, ""), 6);
                return Unit.INSTANCE;
            }
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
            Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
            BiometricPrompt biometricPrompt = new BiometricPrompt(this.$fragmentActivity, executorServiceNewSingleThreadExecutor, LocalAuthenticationModule.this.authenticationCallback);
            LocalAuthenticationModule.this.biometricPrompt = biometricPrompt;
            BiometricPrompt.PromptInfo.Builder builder = new BiometricPrompt.PromptInfo.Builder();
            String str = this.$promptMessage;
            boolean z = this.$requireConfirmation;
            builder.setTitle(str);
            builder.setAllowedAuthenticators(32768);
            builder.setConfirmationRequired(z);
            BiometricPrompt.PromptInfo promptInfoBuild = builder.build();
            Intrinsics.checkNotNullExpressionValue(promptInfoBuild, "build(...)");
            try {
                biometricPrompt.authenticate(promptInfoBuild);
            } catch (NullPointerException e) {
                this.$promise.reject(new UnexpectedException("Canceled authentication due to an internal error", e));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasSystemFeature(String feature) {
        return getPackageManager().hasSystemFeature(feature);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isDeviceSecure() {
        return getKeyguardManager().isDeviceSecure();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String convertErrorCode(int code) {
        switch (code) {
            case 1:
            case 11:
            case 12:
            case 14:
                return "not_available";
            case 2:
                return "unable_to_process";
            case 3:
                return ProfilingTraceData.TRUNCATION_REASON_TIMEOUT;
            case 4:
                return "no_space";
            case 5:
            case 10:
            case 13:
                return "user_cancel";
            case 6:
            case 8:
            default:
                return "unknown";
            case 7:
            case 9:
                return "lockout";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int canAuthenticateUsingWeakBiometrics() {
        return getBiometricManager().canAuthenticate(255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int canAuthenticateUsingStrongBiometrics() {
        return getBiometricManager().canAuthenticate(15);
    }

    static /* synthetic */ Bundle createResponse$default(LocalAuthenticationModule localAuthenticationModule, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return localAuthenticationModule.createResponse(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bundle createResponse(String error, String warning) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("success", error == null);
        if (error != null) {
            bundle.putString("error", error);
        }
        if (warning != null) {
            bundle.putString("warning", warning);
        }
        return bundle;
    }
}
