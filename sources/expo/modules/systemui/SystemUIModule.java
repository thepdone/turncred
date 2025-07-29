package expo.modules.systemui;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.ViewCompat;
import androidx.tracing.Trace;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.Promise;
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
import expo.modules.systemui.SystemUIModule;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KType;

/* compiled from: SystemUIModule.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lexpo/modules/systemui/SystemUIModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "prefs", "Landroid/content/SharedPreferences;", "getPrefs", "()Landroid/content/SharedPreferences;", "systemBackgroundColor", "", "getSystemBackgroundColor", "()I", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "setBackgroundColor", "", ViewProps.COLOR, "Companion", "expo-system-ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SystemUIModule extends Module {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    private final Context getContext() throws Exceptions.ReactContextLost {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPreferences getPrefs() throws Exceptions.ReactContextLost {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("expo_ui_preferences", 0);
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        throw new Exceptions.ReactContextLost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getSystemBackgroundColor() {
        int defaultNightMode = AppCompatDelegate.getDefaultNightMode();
        if (defaultNightMode == -1) {
            int i = getContext().getResources().getConfiguration().uiMode & 48;
            if (i != 16 && i == 32) {
                return ViewCompat.MEASURED_STATE_MASK;
            }
        } else if (defaultNightMode != 1 && defaultNightMode == 2) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        return -1;
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        SystemUIModule systemUIModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (systemUIModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(systemUIModule);
            moduleDefinitionBuilder.Name("ExpoSystemUI");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Integer.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("setBackgroundColorAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.systemui.SystemUIModule$definition$lambda$3$$inlined$AsyncFunction$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Integer num = (Integer) promise;
                        this.this$0.getPrefs().edit().putInt(SystemUIModuleKt.PREFERENCE_KEY, num.intValue()).apply();
                        this.this$0.setBackgroundColor(num.intValue());
                    }
                });
            } else {
                AnyType[] anyTypeArr = new AnyType[1];
                AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), true));
                if (anyType == null) {
                    anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), true, new Function0<KType>() { // from class: expo.modules.systemui.SystemUIModule$definition$lambda$3$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.nullableTypeOf(Integer.class);
                        }
                    }));
                }
                anyTypeArr[0] = anyType;
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.systemui.SystemUIModule$definition$lambda$3$$inlined$AsyncFunction$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Integer num = (Integer) objArr[0];
                        if (num != null) {
                            this.this$0.getPrefs().edit().putInt(SystemUIModuleKt.PREFERENCE_KEY, num.intValue()).apply();
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            this.this$0.getPrefs().edit().remove(SystemUIModuleKt.PREFERENCE_KEY).apply();
                        }
                        SystemUIModule systemUIModule2 = this.this$0;
                        systemUIModule2.setBackgroundColor(num != null ? num.intValue() : systemUIModule2.getSystemBackgroundColor());
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent = new StringAsyncFunctionComponent("setBackgroundColorAsync", anyTypeArr, function1);
                                } else {
                                    asyncFunctionComponent = new AsyncFunctionComponent("setBackgroundColorAsync", anyTypeArr, function1);
                                }
                            } else {
                                asyncFunctionComponent = new FloatAsyncFunctionComponent("setBackgroundColorAsync", anyTypeArr, function1);
                            }
                        } else {
                            asyncFunctionComponent = new DoubleAsyncFunctionComponent("setBackgroundColorAsync", anyTypeArr, function1);
                        }
                    } else {
                        asyncFunctionComponent = new BoolAsyncFunctionComponent("setBackgroundColorAsync", anyTypeArr, function1);
                    }
                } else {
                    asyncFunctionComponent = new IntAsyncFunctionComponent("setBackgroundColorAsync", anyTypeArr, function1);
                }
                asyncFunctionWithPromiseComponent = asyncFunctionComponent;
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("setBackgroundColorAsync", asyncFunctionWithPromiseComponent);
            asyncFunctionWithPromiseComponent.runOnQueue(Queues.MAIN);
            moduleDefinitionBuilder.getAsyncFunctions().put("getBackgroundColorAsync", new AsyncFunctionComponent("getBackgroundColorAsync", new AnyType[0], new Function1<Object[], String>() { // from class: expo.modules.systemui.SystemUIModule$definition$lambda$3$$inlined$AsyncFunction$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final String invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Drawable background = this.this$0.getAppContext().getThrowingActivity().getWindow().getDecorView().getBackground();
                    if (!(background instanceof ColorDrawable)) {
                        return null;
                    }
                    SystemUIModule.Companion companion = SystemUIModule.INSTANCE;
                    Drawable drawableMutate = background.mutate();
                    Intrinsics.checkNotNull(drawableMutate, "null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
                    return companion.colorToHex(((ColorDrawable) drawableMutate).getColor());
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setBackgroundColor(int color) {
        Window window = getAppContext().getThrowingActivity().getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        int color2 = Color.parseColor(INSTANCE.colorToHex(color));
        if (decorView != null) {
            decorView.setBackgroundColor(color2);
        }
    }

    /* compiled from: SystemUIModule.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/systemui/SystemUIModule$Companion;", "", "()V", "colorToHex", "", ViewProps.COLOR, "", "expo-system-ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String colorToHex(int color) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("#%02x%02x%02x", Arrays.copyOf(new Object[]{Integer.valueOf(Color.red(color)), Integer.valueOf(Color.green(color)), Integer.valueOf(Color.blue(color))}, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
    }
}
