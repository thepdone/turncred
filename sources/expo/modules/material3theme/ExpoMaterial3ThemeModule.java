package expo.modules.material3theme;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import androidx.core.view.ViewCompat;
import androidx.tracing.Trace;
import com.facebook.react.modules.appstate.AppStateModule;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeProvider;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: ExpoMaterial3ThemeModule.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J(\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0003J\"\u0010\u000f\u001a\u001c\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f\u0018\u00010\fH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lexpo/modules/material3theme/ExpoMaterial3ThemeModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "getApplicationResources", "Landroid/content/res/Resources;", "getCorePalette", "", "", "resources", "getDynamicColorPalette", "pchmn-expo-material3-theme_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExpoMaterial3ThemeModule extends Module {
    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        ExpoMaterial3ThemeModule expoMaterial3ThemeModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (expoMaterial3ThemeModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(expoMaterial3ThemeModule);
            moduleDefinitionBuilder.Name("ExpoMaterial3Theme");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[0];
            ReturnType returnType = ReturnTypeProvider.INSTANCE.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
            if (returnType == null) {
                returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
                ReturnTypeProvider.INSTANCE.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
            }
            moduleDefinitionBuilder2.getSyncFunctions().put("getSystemTheme", new SyncFunctionComponent("getSystemTheme", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.material3theme.ExpoMaterial3ThemeModule$definition$lambda$2$$inlined$FunctionWithoutArgs$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return this.this$0.getDynamicColorPalette();
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("getSystemThemeAsync", new AsyncFunctionComponent("getSystemThemeAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.material3theme.ExpoMaterial3ThemeModule$definition$lambda$2$$inlined$AsyncFunctionWithoutArgs$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return this.this$0.getDynamicColorPalette();
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Map<String, String>> getDynamicColorPalette() {
        Log.d("ExpoMaterial3Theme", "Get dynamic color palette");
        int i = Build.VERSION.SDK_INT;
        if (Build.VERSION.SDK_INT >= 31) {
            Resources applicationResources = getApplicationResources();
            if (applicationResources == null) {
                Log.w("ExpoMaterial3Theme", "could not get resources for dynamic color module");
                return null;
            }
            return getCorePalette(applicationResources);
        }
        Log.w("ExpoMaterial3Theme", "SDK version 31 is required to run this native module, got " + i);
        return null;
    }

    private final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final Resources getApplicationResources() {
        if (getContext().getResources() == null) {
            Log.d("ExpoMaterial3Theme", "React context resources was null, could not get resource list");
            return null;
        }
        return getContext().getResources();
    }

    private static final String getCorePalette$colorToHex(Resources resources, int i) throws Resources.NotFoundException {
        int color = resources.getColor(i, null);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(color & ViewCompat.MEASURED_SIZE_MASK)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private final Map<String, Map<String, String>> getCorePalette(Resources resources) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("primary", getCorePalette$colorToHex(resources, android.R.color.system_accent1_600));
        linkedHashMap2.put("onPrimary", getCorePalette$colorToHex(resources, android.R.color.system_accent1_0));
        linkedHashMap2.put("primaryContainer", getCorePalette$colorToHex(resources, android.R.color.system_accent1_100));
        linkedHashMap2.put("onPrimaryContainer", getCorePalette$colorToHex(resources, android.R.color.system_accent1_900));
        linkedHashMap2.put("secondary", getCorePalette$colorToHex(resources, android.R.color.system_accent2_600));
        linkedHashMap2.put("onSecondary", getCorePalette$colorToHex(resources, android.R.color.system_accent2_0));
        linkedHashMap2.put("secondaryContainer", getCorePalette$colorToHex(resources, android.R.color.system_accent2_100));
        linkedHashMap2.put("onSecondaryContainer", getCorePalette$colorToHex(resources, android.R.color.system_accent2_900));
        linkedHashMap2.put("tertiary", getCorePalette$colorToHex(resources, android.R.color.system_accent3_600));
        linkedHashMap2.put("onTertiary", getCorePalette$colorToHex(resources, android.R.color.system_accent3_0));
        linkedHashMap2.put("tertiaryContainer", getCorePalette$colorToHex(resources, android.R.color.system_accent3_100));
        linkedHashMap2.put("onTertiaryContainer", getCorePalette$colorToHex(resources, android.R.color.system_accent3_900));
        linkedHashMap2.put(AppStateModule.APP_STATE_BACKGROUND, getCorePalette$colorToHex(resources, android.R.color.system_neutral1_10));
        linkedHashMap2.put("onBackground", getCorePalette$colorToHex(resources, android.R.color.system_neutral1_900));
        linkedHashMap2.put("surface", getCorePalette$colorToHex(resources, android.R.color.system_neutral1_10));
        linkedHashMap2.put("onSurface", getCorePalette$colorToHex(resources, android.R.color.system_neutral1_900));
        linkedHashMap2.put("surfaceVariant", getCorePalette$colorToHex(resources, android.R.color.system_neutral2_100));
        linkedHashMap2.put("onSurfaceVariant", getCorePalette$colorToHex(resources, android.R.color.system_neutral2_700));
        linkedHashMap2.put("outline", getCorePalette$colorToHex(resources, android.R.color.system_neutral2_500));
        linkedHashMap2.put("outlineVariant", getCorePalette$colorToHex(resources, android.R.color.system_neutral2_200));
        linkedHashMap2.put("inverseSurface", getCorePalette$colorToHex(resources, android.R.color.system_neutral1_800));
        linkedHashMap2.put("inverseOnSurface", getCorePalette$colorToHex(resources, android.R.color.system_neutral1_50));
        linkedHashMap2.put("inversePrimary", getCorePalette$colorToHex(resources, android.R.color.system_accent1_200));
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        linkedHashMap3.put("primary", getCorePalette$colorToHex(resources, android.R.color.system_accent1_200));
        linkedHashMap3.put("onPrimary", getCorePalette$colorToHex(resources, android.R.color.system_accent1_800));
        linkedHashMap3.put("primaryContainer", getCorePalette$colorToHex(resources, android.R.color.system_accent1_700));
        linkedHashMap3.put("onPrimaryContainer", getCorePalette$colorToHex(resources, android.R.color.system_accent1_100));
        linkedHashMap3.put("secondary", getCorePalette$colorToHex(resources, android.R.color.system_accent2_200));
        linkedHashMap3.put("onSecondary", getCorePalette$colorToHex(resources, android.R.color.system_accent2_800));
        linkedHashMap3.put("secondaryContainer", getCorePalette$colorToHex(resources, android.R.color.system_accent2_700));
        linkedHashMap3.put("onSecondaryContainer", getCorePalette$colorToHex(resources, android.R.color.system_accent2_100));
        linkedHashMap3.put("tertiary", getCorePalette$colorToHex(resources, android.R.color.system_accent3_200));
        linkedHashMap3.put("onTertiary", getCorePalette$colorToHex(resources, android.R.color.system_accent3_800));
        linkedHashMap3.put("tertiaryContainer", getCorePalette$colorToHex(resources, android.R.color.system_accent3_700));
        linkedHashMap3.put("onTertiaryContainer", getCorePalette$colorToHex(resources, android.R.color.system_accent3_100));
        linkedHashMap3.put(AppStateModule.APP_STATE_BACKGROUND, getCorePalette$colorToHex(resources, android.R.color.system_neutral1_900));
        linkedHashMap3.put("onBackground", getCorePalette$colorToHex(resources, android.R.color.system_neutral1_100));
        linkedHashMap3.put("surface", getCorePalette$colorToHex(resources, android.R.color.system_neutral1_900));
        linkedHashMap3.put("onSurface", getCorePalette$colorToHex(resources, android.R.color.system_neutral1_100));
        linkedHashMap3.put("surfaceVariant", getCorePalette$colorToHex(resources, android.R.color.system_neutral2_700));
        linkedHashMap3.put("onSurfaceVariant", getCorePalette$colorToHex(resources, android.R.color.system_neutral2_200));
        linkedHashMap3.put("outline", getCorePalette$colorToHex(resources, android.R.color.system_neutral2_400));
        linkedHashMap3.put("outlineVariant", getCorePalette$colorToHex(resources, android.R.color.system_neutral2_700));
        linkedHashMap3.put("inverseSurface", getCorePalette$colorToHex(resources, android.R.color.system_neutral1_100));
        linkedHashMap3.put("inverseOnSurface", getCorePalette$colorToHex(resources, android.R.color.system_neutral1_800));
        linkedHashMap3.put("inversePrimary", getCorePalette$colorToHex(resources, android.R.color.system_accent1_600));
        linkedHashMap.put("dark", linkedHashMap3);
        linkedHashMap.put("light", linkedHashMap2);
        return linkedHashMap;
    }
}
