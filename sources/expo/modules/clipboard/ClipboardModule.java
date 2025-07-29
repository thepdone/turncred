package expo.modules.clipboard;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;
import androidx.core.os.BundleKt;
import androidx.tracing.Trace;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import expo.modules.clipboard.ClipboardModule;
import expo.modules.clipboard.ClipboardModule.ClipboardEventEmitter;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: ClipboardModule.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lexpo/modules/clipboard/ClipboardModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "clipboardCacheDir", "Ljava/io/File;", "getClipboardCacheDir", "()Ljava/io/File;", "clipboardCacheDir$delegate", "Lkotlin/Lazy;", "clipboardEventEmitter", "Lexpo/modules/clipboard/ClipboardModule$ClipboardEventEmitter;", "clipboardManager", "Landroid/content/ClipboardManager;", "getClipboardManager", "()Landroid/content/ClipboardManager;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "firstItem", "Landroid/content/ClipData$Item;", "getFirstItem", "(Landroid/content/ClipboardManager;)Landroid/content/ClipData$Item;", "clipboardHasItemWithType", "", "mimeType", "", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "ClipboardEventEmitter", "expo-clipboard_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClipboardModule extends Module {

    /* renamed from: clipboardCacheDir$delegate, reason: from kotlin metadata */
    private final Lazy clipboardCacheDir = LazyKt.lazy(new Function0<File>() { // from class: expo.modules.clipboard.ClipboardModule$clipboardCacheDir$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final File invoke() {
            File file = new File(this.this$0.getContext().getCacheDir(), ClipboardModuleKt.CLIPBOARD_DIRECTORY_NAME);
            file.mkdirs();
            return file;
        }
    });
    private ClipboardEventEmitter clipboardEventEmitter;

    /* compiled from: ClipboardModule.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StringFormat.values().length];
            try {
                iArr[StringFormat.PLAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StringFormat.HTML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        AsyncFunctionComponent asyncFunctionComponent3;
        AsyncFunctionComponent asyncFunctionComponent4;
        ClipboardModule clipboardModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (clipboardModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(clipboardModule);
            moduleDefinitionBuilder.Name("ExpoClipboard");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(GetStringOptions.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("getStringAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$1
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        ClipboardModule clipboardModule2 = this.this$0;
                        ClipData.Item firstItem = clipboardModule2.getFirstItem(clipboardModule2.getClipboardManager());
                        int i = ClipboardModule.WhenMappings.$EnumSwitchMapping$0[((GetStringOptions) promise).getPreferredFormat().ordinal()];
                        if (i == 1) {
                            if (firstItem != null) {
                                ClipboardModuleKt.coerceToPlainText(firstItem, this.this$0.getContext());
                            }
                        } else {
                            if (i != 2) {
                                throw new NoWhenBranchMatchedException();
                            }
                            if (firstItem != null) {
                                firstItem.coerceToHtmlText(this.this$0.getContext());
                            }
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr = new AnyType[1];
                AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(GetStringOptions.class), false));
                if (anyType == null) {
                    anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(GetStringOptions.class), false, new Function0<KType>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(GetStringOptions.class);
                        }
                    }));
                }
                anyTypeArr[0] = anyType;
                Function1<Object[], String> function1 = new Function1<Object[], String>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        GetStringOptions getStringOptions = (GetStringOptions) objArr[0];
                        ClipboardModule clipboardModule2 = this.this$0;
                        ClipData.Item firstItem = clipboardModule2.getFirstItem(clipboardModule2.getClipboardManager());
                        int i = ClipboardModule.WhenMappings.$EnumSwitchMapping$0[getStringOptions.getPreferredFormat().ordinal()];
                        String strCoerceToPlainText = null;
                        if (i != 1) {
                            if (i != 2) {
                                throw new NoWhenBranchMatchedException();
                            }
                            if (firstItem != null) {
                                strCoerceToPlainText = firstItem.coerceToHtmlText(this.this$0.getContext());
                            }
                        } else if (firstItem != null) {
                            strCoerceToPlainText = ClipboardModuleKt.coerceToPlainText(firstItem, this.this$0.getContext());
                        }
                        return strCoerceToPlainText == null ? "" : strCoerceToPlainText;
                    }
                };
                if (!Intrinsics.areEqual(String.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(String.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(String.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(String.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(String.class, String.class)) {
                                    asyncFunctionComponent = new StringAsyncFunctionComponent("getStringAsync", anyTypeArr, function1);
                                } else {
                                    asyncFunctionComponent = new AsyncFunctionComponent("getStringAsync", anyTypeArr, function1);
                                }
                            } else {
                                asyncFunctionComponent = new FloatAsyncFunctionComponent("getStringAsync", anyTypeArr, function1);
                            }
                        } else {
                            asyncFunctionComponent = new DoubleAsyncFunctionComponent("getStringAsync", anyTypeArr, function1);
                        }
                    } else {
                        asyncFunctionComponent = new BoolAsyncFunctionComponent("getStringAsync", anyTypeArr, function1);
                    }
                } else {
                    asyncFunctionComponent = new IntAsyncFunctionComponent("getStringAsync", anyTypeArr, function1);
                }
                asyncFunctionWithPromiseComponent = asyncFunctionComponent;
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("getStringAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr2 = new AnyType[2];
            AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$4
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr2[0] = anyType2;
            AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(SetStringOptions.class), false));
            if (anyType3 == null) {
                anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(SetStringOptions.class), false, new Function0<KType>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(SetStringOptions.class);
                    }
                }));
            }
            anyTypeArr2[1] = anyType3;
            Function1<Object[], Boolean> function12 = new Function1<Object[], Boolean>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$6
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object[] objArr) {
                    ClipData clipDataNewPlainText;
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    String str = (String) objArr[0];
                    int i = ClipboardModule.WhenMappings.$EnumSwitchMapping$0[((SetStringOptions) objArr[1]).getInputFormat().ordinal()];
                    if (i == 1) {
                        clipDataNewPlainText = ClipData.newPlainText(null, str);
                    } else {
                        if (i != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        clipDataNewPlainText = ClipData.newHtmlText(null, ClipboardModuleKt.plainTextFromHtml(str), str);
                    }
                    this.this$0.getClipboardManager().setPrimaryClip(clipDataNewPlainText);
                    return true;
                }
            };
            if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                asyncFunctionComponent2 = new StringAsyncFunctionComponent("setStringAsync", anyTypeArr2, function12);
                            } else {
                                asyncFunctionComponent2 = new AsyncFunctionComponent("setStringAsync", anyTypeArr2, function12);
                            }
                        } else {
                            asyncFunctionComponent2 = new FloatAsyncFunctionComponent("setStringAsync", anyTypeArr2, function12);
                        }
                    } else {
                        asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("setStringAsync", anyTypeArr2, function12);
                    }
                } else {
                    asyncFunctionComponent2 = new BoolAsyncFunctionComponent("setStringAsync", anyTypeArr2, function12);
                }
            } else {
                asyncFunctionComponent2 = new IntAsyncFunctionComponent("setStringAsync", anyTypeArr2, function12);
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("setStringAsync", asyncFunctionComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr3 = new AnyType[0];
            Function1<Object[], Boolean> function13 = new Function1<Object[], Boolean>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$7
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ClipDescription primaryClipDescription = this.this$0.getClipboardManager().getPrimaryClipDescription();
                    return Boolean.valueOf(primaryClipDescription != null ? ClipboardModuleKt.getHasTextContent(primaryClipDescription) : false);
                }
            };
            if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                asyncFunctionComponent3 = new StringAsyncFunctionComponent("hasStringAsync", anyTypeArr3, function13);
                            } else {
                                asyncFunctionComponent3 = new AsyncFunctionComponent("hasStringAsync", anyTypeArr3, function13);
                            }
                        } else {
                            asyncFunctionComponent3 = new FloatAsyncFunctionComponent("hasStringAsync", anyTypeArr3, function13);
                        }
                    } else {
                        asyncFunctionComponent3 = new DoubleAsyncFunctionComponent("hasStringAsync", anyTypeArr3, function13);
                    }
                } else {
                    asyncFunctionComponent3 = new BoolAsyncFunctionComponent("hasStringAsync", anyTypeArr3, function13);
                }
            } else {
                asyncFunctionComponent3 = new IntAsyncFunctionComponent("hasStringAsync", anyTypeArr3, function13);
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("hasStringAsync", asyncFunctionComponent3);
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction = moduleDefinitionBuilder.AsyncFunction("getImageAsync");
            String name = asyncFunctionBuilderAsyncFunction.getName();
            AnyType[] anyTypeArr4 = new AnyType[1];
            AnyType anyType4 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(GetImageOptions.class), false));
            if (anyType4 == null) {
                anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(GetImageOptions.class), false, new Function0<KType>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$Coroutine$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(GetImageOptions.class);
                    }
                }));
            }
            anyTypeArr4[0] = anyType4;
            asyncFunctionBuilderAsyncFunction.setAsyncFunctionComponent(new SuspendFunctionComponent(name, anyTypeArr4, new ClipboardModule$definition$lambda$12$$inlined$Coroutine$2(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction2 = moduleDefinitionBuilder.AsyncFunction("setImageAsync");
            String name2 = asyncFunctionBuilderAsyncFunction2.getName();
            AnyType[] anyTypeArr5 = new AnyType[1];
            AnyType anyType5 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType5 == null) {
                anyType5 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$Coroutine$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }));
            }
            anyTypeArr5[0] = anyType5;
            asyncFunctionBuilderAsyncFunction2.setAsyncFunctionComponent(new SuspendFunctionComponent(name2, anyTypeArr5, new ClipboardModule$definition$lambda$12$$inlined$Coroutine$4(null, this)));
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr6 = new AnyType[0];
            Function1<Object[], Boolean> function14 = new Function1<Object[], Boolean>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$8
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ClipDescription primaryClipDescription = this.this$0.getClipboardManager().getPrimaryClipDescription();
                    boolean z = false;
                    if (primaryClipDescription != null && primaryClipDescription.hasMimeType("image/*")) {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
            };
            if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                asyncFunctionComponent4 = new StringAsyncFunctionComponent("hasImageAsync", anyTypeArr6, function14);
                            } else {
                                asyncFunctionComponent4 = new AsyncFunctionComponent("hasImageAsync", anyTypeArr6, function14);
                            }
                        } else {
                            asyncFunctionComponent4 = new FloatAsyncFunctionComponent("hasImageAsync", anyTypeArr6, function14);
                        }
                    } else {
                        asyncFunctionComponent4 = new DoubleAsyncFunctionComponent("hasImageAsync", anyTypeArr6, function14);
                    }
                } else {
                    asyncFunctionComponent4 = new BoolAsyncFunctionComponent("hasImageAsync", anyTypeArr6, function14);
                }
            } else {
                asyncFunctionComponent4 = new IntAsyncFunctionComponent("hasImageAsync", anyTypeArr6, function14);
            }
            moduleDefinitionBuilder5.getAsyncFunctions().put("hasImageAsync", asyncFunctionComponent4);
            moduleDefinitionBuilder.Events(ClipboardModuleKt.CLIPBOARD_CHANGED_EVENT_NAME);
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$OnCreate$1
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
                    this.this$0.clipboardEventEmitter = this.this$0.new ClipboardEventEmitter();
                    ClipboardModule.ClipboardEventEmitter clipboardEventEmitter = this.this$0.clipboardEventEmitter;
                    if (clipboardEventEmitter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("clipboardEventEmitter");
                        clipboardEventEmitter = null;
                    }
                    clipboardEventEmitter.attachListener();
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$OnDestroy$1
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
                    ClipboardModule.ClipboardEventEmitter clipboardEventEmitter = this.this$0.clipboardEventEmitter;
                    if (clipboardEventEmitter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("clipboardEventEmitter");
                        clipboardEventEmitter = null;
                    }
                    clipboardEventEmitter.detachListener();
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_ENTERS_BACKGROUND, new BasicEventListener(EventName.ACTIVITY_ENTERS_BACKGROUND, new Function0<Unit>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$OnActivityEntersBackground$1
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
                    ClipboardModule.ClipboardEventEmitter clipboardEventEmitter = this.this$0.clipboardEventEmitter;
                    if (clipboardEventEmitter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("clipboardEventEmitter");
                        clipboardEventEmitter = null;
                    }
                    clipboardEventEmitter.pauseListening();
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_ENTERS_FOREGROUND, new BasicEventListener(EventName.ACTIVITY_ENTERS_FOREGROUND, new Function0<Unit>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$OnActivityEntersForeground$1
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
                    ClipboardModule.ClipboardEventEmitter clipboardEventEmitter = this.this$0.clipboardEventEmitter;
                    if (clipboardEventEmitter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("clipboardEventEmitter");
                        clipboardEventEmitter = null;
                    }
                    clipboardEventEmitter.resumeListening();
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new IllegalArgumentException("React Application Context is null".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClipboardManager getClipboardManager() throws ClipboardUnavailableException {
        Object systemService = getContext().getSystemService("clipboard");
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        if (clipboardManager != null) {
            return clipboardManager;
        }
        throw new ClipboardUnavailableException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getClipboardCacheDir() {
        return (File) this.clipboardCacheDir.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ClipboardModule.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\u0001J\r\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lexpo/modules/clipboard/ClipboardModule$ClipboardEventEmitter;", "", "(Lexpo/modules/clipboard/ClipboardModule;)V", "isListening", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/content/ClipboardManager$OnPrimaryClipChangedListener;", "maybeClipboardManager", "Landroid/content/ClipboardManager;", "timestamp", "", "attachListener", "detachListener", "", "()Lkotlin/Unit;", "pauseListening", "resumeListening", "expo-clipboard_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    final class ClipboardEventEmitter {
        private final ClipboardManager.OnPrimaryClipChangedListener listener;
        private final ClipboardManager maybeClipboardManager;
        private boolean isListening = true;
        private long timestamp = -1;

        public ClipboardEventEmitter() {
            Object objM5937constructorimpl;
            this.listener = new ClipboardManager.OnPrimaryClipChangedListener() { // from class: expo.modules.clipboard.ClipboardModule$ClipboardEventEmitter$$ExternalSyntheticLambda0
                @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
                public final void onPrimaryClipChanged() {
                    ClipboardModule.ClipboardEventEmitter.listener$lambda$7(clipboardModule, this);
                }
            };
            try {
                Result.Companion companion = Result.INSTANCE;
                ClipboardEventEmitter clipboardEventEmitter = this;
                objM5937constructorimpl = Result.m5937constructorimpl(ClipboardModule.this.getClipboardManager());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM5937constructorimpl = Result.m5937constructorimpl(ResultKt.createFailure(th));
            }
            this.maybeClipboardManager = (ClipboardManager) (Result.m5943isFailureimpl(objM5937constructorimpl) ? null : objM5937constructorimpl);
        }

        public final void resumeListening() {
            this.isListening = true;
        }

        public final void pauseListening() {
            this.isListening = false;
        }

        public final Object attachListener() {
            Unit unit;
            ClipboardManager clipboardManager = this.maybeClipboardManager;
            if (clipboardManager != null) {
                clipboardManager.addPrimaryClipChangedListener(this.listener);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            return unit == null ? Integer.valueOf(Log.e(ClipboardModuleKt.TAG, "'CLIPBOARD_SERVICE' unavailable. Events won't be received")) : unit;
        }

        public final Unit detachListener() {
            ClipboardManager clipboardManager = this.maybeClipboardManager;
            if (clipboardManager == null) {
                return null;
            }
            clipboardManager.removePrimaryClipChangedListener(this.listener);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void listener$lambda$7(ClipboardModule this$0, ClipboardEventEmitter this$1) {
            ClipDescription primaryClipDescription;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (this$0.getAppContext().getHasActiveReactInstance()) {
                ClipboardManager clipboardManager = this$1.maybeClipboardManager;
                if (!this$1.isListening) {
                    clipboardManager = null;
                }
                if (clipboardManager == null || (primaryClipDescription = clipboardManager.getPrimaryClipDescription()) == null || this$1.timestamp == primaryClipDescription.getTimestamp()) {
                    return;
                }
                this$1.timestamp = primaryClipDescription.getTimestamp();
                Pair[] pairArr = new Pair[1];
                ContentType[] contentTypeArr = new ContentType[3];
                ContentType contentType = ContentType.PLAIN_TEXT;
                if (!ClipboardModuleKt.getHasTextContent(primaryClipDescription)) {
                    contentType = null;
                }
                contentTypeArr[0] = contentType;
                ContentType contentType2 = ContentType.HTML;
                if (!primaryClipDescription.hasMimeType("text/html")) {
                    contentType2 = null;
                }
                contentTypeArr[1] = contentType2;
                contentTypeArr[2] = primaryClipDescription.hasMimeType("image/*") ? ContentType.IMAGE : null;
                List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) contentTypeArr);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOfNotNull, 10));
                Iterator it = listListOfNotNull.iterator();
                while (it.hasNext()) {
                    arrayList.add(((ContentType) it.next()).getJsName());
                }
                pairArr[0] = TuplesKt.to("contentTypes", arrayList);
                this$0.sendEvent(ClipboardModuleKt.CLIPBOARD_CHANGED_EVENT_NAME, BundleKt.bundleOf(pairArr));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean clipboardHasItemWithType(String mimeType) {
        ClipDescription primaryClipDescription = getClipboardManager().getPrimaryClipDescription();
        if (primaryClipDescription != null) {
            return primaryClipDescription.hasMimeType(mimeType);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClipData.Item getFirstItem(ClipboardManager clipboardManager) {
        ClipData primaryClip = clipboardManager.getPrimaryClip();
        if (primaryClip == null) {
            return null;
        }
        if (primaryClip.getItemCount() <= 0) {
            primaryClip = null;
        }
        if (primaryClip != null) {
            return primaryClip.getItemAt(0);
        }
        return null;
    }
}
