package expo.modules.crypto;

import android.util.Base64;
import androidx.tracing.Trace;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import expo.modules.crypto.DigestOptions;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.typedarray.TypedArray;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeProvider;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;

/* compiled from: CryptoModule.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0010H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001b"}, d2 = {"Lexpo/modules/crypto/CryptoModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "secureRandom", "Ljava/security/SecureRandom;", "getSecureRandom", "()Ljava/security/SecureRandom;", "secureRandom$delegate", "Lkotlin/Lazy;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "digest", "", "algorithm", "Lexpo/modules/crypto/DigestAlgorithm;", "output", "Lexpo/modules/kotlin/typedarray/TypedArray;", "data", "digestString", "", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lexpo/modules/crypto/DigestOptions;", "getRandomBase64String", "randomByteCount", "", "getRandomValues", "typedArray", "expo-crypto_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CryptoModule extends Module {

    /* renamed from: secureRandom$delegate, reason: from kotlin metadata */
    private final Lazy secureRandom = LazyKt.lazy(new Function0<SecureRandom>() { // from class: expo.modules.crypto.CryptoModule$secureRandom$2
        @Override // kotlin.jvm.functions.Function0
        public final SecureRandom invoke() {
            return new SecureRandom();
        }
    });

    /* compiled from: CryptoModule.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DigestOptions.Encoding.values().length];
            try {
                iArr[DigestOptions.Encoding.BASE64.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DigestOptions.Encoding.HEX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final SecureRandom getSecureRandom() {
        return (SecureRandom) this.secureRandom.getValue();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        CryptoModule cryptoModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (cryptoModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(cryptoModule);
            moduleDefinitionBuilder.Name("ExpoCrypto");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[3];
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DigestAlgorithm.class), false));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DigestAlgorithm.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$Function$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(DigestAlgorithm.class);
                    }
                }));
            }
            anyTypeArr[0] = anyType;
            AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$Function$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr[1] = anyType2;
            AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DigestOptions.class), false));
            if (anyType3 == null) {
                anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DigestOptions.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$Function$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(DigestOptions.class);
                    }
                }));
            }
            anyTypeArr[2] = anyType3;
            ReturnType returnType = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(String.class));
            if (returnType == null) {
                returnType = new ReturnType(Reflection.getOrCreateKotlinClass(String.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(String.class), returnType);
            }
            moduleDefinitionBuilder2.getSyncFunctions().put("digestString", new SyncFunctionComponent("digestString", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$Function$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    DigestOptions digestOptions = (DigestOptions) objArr[2];
                    DigestAlgorithm digestAlgorithm = (DigestAlgorithm) obj;
                    return this.$receiver$inlined.digestString(digestAlgorithm, (String) obj2, digestOptions);
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr2 = new AnyType[3];
            AnyType anyType4 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DigestAlgorithm.class), false));
            if (anyType4 == null) {
                anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DigestAlgorithm.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$AsyncFunction$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(DigestAlgorithm.class);
                    }
                }));
            }
            anyTypeArr2[0] = anyType4;
            AnyType anyType5 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType5 == null) {
                anyType5 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$AsyncFunction$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr2[1] = anyType5;
            AnyType anyType6 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DigestOptions.class), false));
            if (anyType6 == null) {
                anyType6 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DigestOptions.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(DigestOptions.class);
                    }
                }));
            }
            anyTypeArr2[2] = anyType6;
            Function1<Object[], String> function1 = new Function1<Object[], String>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$AsyncFunction$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final String invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    DigestOptions digestOptions = (DigestOptions) objArr[2];
                    DigestAlgorithm digestAlgorithm = (DigestAlgorithm) obj;
                    return this.$receiver$inlined.digestString(digestAlgorithm, (String) obj2, digestOptions);
                }
            };
            if (!Intrinsics.areEqual(String.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(String.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(String.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(String.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(String.class, String.class)) {
                                asyncFunctionComponent = new StringAsyncFunctionComponent("digestStringAsync", anyTypeArr2, function1);
                            } else {
                                asyncFunctionComponent = new AsyncFunctionComponent("digestStringAsync", anyTypeArr2, function1);
                            }
                        } else {
                            asyncFunctionComponent = new FloatAsyncFunctionComponent("digestStringAsync", anyTypeArr2, function1);
                        }
                    } else {
                        asyncFunctionComponent = new DoubleAsyncFunctionComponent("digestStringAsync", anyTypeArr2, function1);
                    }
                } else {
                    asyncFunctionComponent = new BoolAsyncFunctionComponent("digestStringAsync", anyTypeArr2, function1);
                }
            } else {
                asyncFunctionComponent = new IntAsyncFunctionComponent("digestStringAsync", anyTypeArr2, function1);
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("digestStringAsync", asyncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr3 = new AnyType[1];
            AnyType anyType7 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
            if (anyType7 == null) {
                anyType7 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$Function$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Integer.TYPE);
                    }
                }));
            }
            anyTypeArr3[0] = anyType7;
            ReturnType returnType2 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(String.class));
            if (returnType2 == null) {
                returnType2 = new ReturnType(Reflection.getOrCreateKotlinClass(String.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(String.class), returnType2);
            }
            moduleDefinitionBuilder4.getSyncFunctions().put("getRandomBase64String", new SyncFunctionComponent("getRandomBase64String", anyTypeArr3, returnType2, new Function1<Object[], Object>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$Function$6
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    return this.$receiver$inlined.getRandomBase64String(((Number) objArr[0]).intValue());
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Integer.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("getRandomBase64StringAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$AsyncFunction$5
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        this.$receiver$inlined.getRandomBase64String(((Integer) promise).intValue());
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr4 = new AnyType[1];
                AnyType anyType8 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
                if (anyType8 == null) {
                    anyType8 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$AsyncFunction$6
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Integer.TYPE);
                        }
                    }));
                }
                anyTypeArr4[0] = anyType8;
                Function1<Object[], String> function12 = new Function1<Object[], String>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$AsyncFunction$7
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        return this.$receiver$inlined.getRandomBase64String(((Number) objArr[0]).intValue());
                    }
                };
                if (!Intrinsics.areEqual(String.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(String.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(String.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(String.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(String.class, String.class)) {
                                    asyncFunctionComponent2 = new StringAsyncFunctionComponent("getRandomBase64StringAsync", anyTypeArr4, function12);
                                } else {
                                    asyncFunctionComponent2 = new AsyncFunctionComponent("getRandomBase64StringAsync", anyTypeArr4, function12);
                                }
                            } else {
                                asyncFunctionComponent2 = new FloatAsyncFunctionComponent("getRandomBase64StringAsync", anyTypeArr4, function12);
                            }
                        } else {
                            asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("getRandomBase64StringAsync", anyTypeArr4, function12);
                        }
                    } else {
                        asyncFunctionComponent2 = new BoolAsyncFunctionComponent("getRandomBase64StringAsync", anyTypeArr4, function12);
                    }
                } else {
                    asyncFunctionComponent2 = new IntAsyncFunctionComponent("getRandomBase64StringAsync", anyTypeArr4, function12);
                }
                asyncFunctionWithPromiseComponent = asyncFunctionComponent2;
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("getRandomBase64StringAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr5 = new AnyType[1];
            AnyType anyType9 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(TypedArray.class), false));
            if (anyType9 == null) {
                anyType9 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(TypedArray.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$Function$7
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(TypedArray.class);
                    }
                }));
            }
            anyTypeArr5[0] = anyType9;
            ReturnType returnType3 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType3 == null) {
                returnType3 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType3);
            }
            moduleDefinitionBuilder6.getSyncFunctions().put("getRandomValues", new SyncFunctionComponent("getRandomValues", anyTypeArr5, returnType3, new Function1<Object[], Object>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$Function$8
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    this.$receiver$inlined.getRandomValues((TypedArray) objArr[0]);
                    return Unit.INSTANCE;
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder7 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr6 = new AnyType[3];
            AnyType anyType10 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DigestAlgorithm.class), false));
            if (anyType10 == null) {
                anyType10 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DigestAlgorithm.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$Function$9
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(DigestAlgorithm.class);
                    }
                }));
            }
            anyTypeArr6[0] = anyType10;
            AnyType anyType11 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(TypedArray.class), false));
            if (anyType11 == null) {
                anyType11 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(TypedArray.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$Function$10
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(TypedArray.class);
                    }
                }));
            }
            anyTypeArr6[1] = anyType11;
            AnyType anyType12 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(TypedArray.class), false));
            if (anyType12 == null) {
                anyType12 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(TypedArray.class), false, new Function0<KType>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$Function$11
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(TypedArray.class);
                    }
                }));
            }
            anyTypeArr6[2] = anyType12;
            ReturnType returnType4 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType4 == null) {
                returnType4 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType4);
            }
            moduleDefinitionBuilder7.getSyncFunctions().put("digest", new SyncFunctionComponent("digest", anyTypeArr6, returnType4, new Function1<Object[], Object>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$Function$12
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) throws NoSuchAlgorithmException {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    TypedArray typedArray = (TypedArray) objArr[2];
                    CryptoModule cryptoModule2 = this.$receiver$inlined;
                    cryptoModule2.digest((DigestAlgorithm) obj, (TypedArray) obj2, typedArray);
                    return Unit.INSTANCE;
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder8 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr7 = new AnyType[0];
            ReturnType returnType5 = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
            if (returnType5 == null) {
                returnType5 = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType5);
            }
            moduleDefinitionBuilder8.getSyncFunctions().put("randomUUID", new SyncFunctionComponent("randomUUID", anyTypeArr7, returnType5, new Function1<Object[], Object>() { // from class: expo.modules.crypto.CryptoModule$definition$lambda$6$$inlined$FunctionWithoutArgs$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return UUID.randomUUID().toString();
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getRandomBase64String(int randomByteCount) {
        byte[] bArr = new byte[randomByteCount];
        getSecureRandom().nextBytes(bArr);
        String strEncodeToString = Base64.encodeToString(bArr, 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String digestString(DigestAlgorithm algorithm, String data, DigestOptions options) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm.getValue());
        byte[] bytes = data.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        messageDigest.update(bytes);
        byte[] bArrDigest = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
        int i = WhenMappings.$EnumSwitchMapping$0[options.getEncoding().ordinal()];
        if (i != 1) {
            if (i == 2) {
                return ArraysKt.joinToString$default(bArrDigest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Byte, CharSequence>() { // from class: expo.modules.crypto.CryptoModule.digestString.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ CharSequence invoke(Byte b) {
                        return invoke(b.byteValue());
                    }

                    public final CharSequence invoke(byte b) {
                        String string = Integer.toString((b & 255) + 256, CharsKt.checkRadix(16));
                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                        String strSubstring = string.substring(1);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        return strSubstring;
                    }
                }, 30, (Object) null);
            }
            throw new NoWhenBranchMatchedException();
        }
        String strEncodeToString = Base64.encodeToString(bArrDigest, 2);
        Intrinsics.checkNotNull(strEncodeToString);
        return strEncodeToString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void digest(DigestAlgorithm algorithm, TypedArray output, TypedArray data) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm.getValue());
        messageDigest.update(data.toDirectBuffer());
        byte[] bArrDigest = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
        output.write(bArrDigest, output.getByteOffset(), output.getByteLength());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getRandomValues(TypedArray typedArray) {
        byte[] bArr = new byte[typedArray.getByteLength()];
        getSecureRandom().nextBytes(bArr);
        typedArray.write(bArr, typedArray.getByteOffset(), typedArray.getByteLength());
    }
}
