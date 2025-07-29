package com.facebook.react.common.assets;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Build;
import android.util.SparseArray;
import androidx.core.content.res.ResourcesCompat;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.uimanager.ViewProps;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReactFontManager.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0003\u001d\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J(\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J(\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J \u0010\u001b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/facebook/react/common/assets/ReactFontManager;", "", "()V", "customTypefaceCache", "", "", "Landroid/graphics/Typeface;", "fontCache", "Lcom/facebook/react/common/assets/ReactFontManager$AssetFontFamily;", "addCustomFont", "", "context", "Landroid/content/Context;", ViewProps.FONT_FAMILY, "fontId", "", "font", "getTypeface", "fontFamilyName", "typefaceStyle", "Lcom/facebook/react/common/assets/ReactFontManager$TypefaceStyle;", "assetManager", "Landroid/content/res/AssetManager;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "weight", "italic", "", "setTypeface", "typeface", "AssetFontFamily", "Companion", "TypefaceStyle", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ReactFontManager {
    private static final String FONTS_ASSET_PATH = "fonts/";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String[] EXTENSIONS = {"", "_bold", "_italic", "_bold_italic"};
    private static final String[] FILE_EXTENSIONS = {".ttf", ".otf"};
    private static final ReactFontManager _instance = new ReactFontManager();
    private final Map<String, AssetFontFamily> fontCache = new LinkedHashMap();
    private final Map<String, Typeface> customTypefaceCache = new LinkedHashMap();

    @JvmStatic
    public static final ReactFontManager getInstance() {
        return INSTANCE.getInstance();
    }

    public final Typeface getTypeface(String fontFamilyName, int style, AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        return getTypeface(fontFamilyName, new TypefaceStyle(style, 0, 2, null), assetManager);
    }

    public final Typeface getTypeface(String fontFamilyName, int weight, boolean italic, AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        return getTypeface(fontFamilyName, new TypefaceStyle(weight, italic), assetManager);
    }

    public final Typeface getTypeface(String fontFamilyName, int style, int weight, AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        return getTypeface(fontFamilyName, new TypefaceStyle(style, weight), assetManager);
    }

    public final Typeface getTypeface(String fontFamilyName, TypefaceStyle typefaceStyle, AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        Intrinsics.checkNotNullParameter(typefaceStyle, "typefaceStyle");
        if (this.customTypefaceCache.containsKey(fontFamilyName)) {
            return typefaceStyle.apply(this.customTypefaceCache.get(fontFamilyName));
        }
        Map<String, AssetFontFamily> map = this.fontCache;
        AssetFontFamily assetFontFamily = map.get(fontFamilyName);
        if (assetFontFamily == null) {
            assetFontFamily = new AssetFontFamily();
            map.put(fontFamilyName, assetFontFamily);
        }
        AssetFontFamily assetFontFamily2 = assetFontFamily;
        int nearestStyle = typefaceStyle.getNearestStyle();
        Typeface typefaceForStyle = assetFontFamily2.getTypefaceForStyle(nearestStyle);
        if (typefaceForStyle != null) {
            return typefaceForStyle;
        }
        Typeface typefaceCreateAssetTypeface = INSTANCE.createAssetTypeface(fontFamilyName, nearestStyle, assetManager);
        assetFontFamily2.setTypefaceForStyle(nearestStyle, typefaceCreateAssetTypeface);
        return typefaceCreateAssetTypeface;
    }

    public final void addCustomFont(Context context, String fontFamily, int fontId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        addCustomFont(fontFamily, ResourcesCompat.getFont(context, fontId));
    }

    public final void addCustomFont(String fontFamily, Typeface font) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        if (font != null) {
            this.customTypefaceCache.put(fontFamily, font);
        }
    }

    public final void setTypeface(String fontFamilyName, int style, Typeface typeface) {
        Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
        if (typeface != null) {
            Map<String, AssetFontFamily> map = this.fontCache;
            AssetFontFamily assetFontFamily = map.get(fontFamilyName);
            if (assetFontFamily == null) {
                assetFontFamily = new AssetFontFamily();
                map.put(fontFamilyName, assetFontFamily);
            }
            assetFontFamily.setTypefaceForStyle(style, typeface);
        }
    }

    /* compiled from: ReactFontManager.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/react/common/assets/ReactFontManager$TypefaceStyle;", "", "weight", "", "italic", "", "(IZ)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "(II)V", "nearestStyle", "getNearestStyle", "()I", "apply", "Landroid/graphics/Typeface;", "typeface", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class TypefaceStyle {
        public static final int BOLD = 700;
        public static final int NORMAL = 400;
        private final boolean italic;
        private final int weight;

        public TypefaceStyle(int i) {
            this(i, 0, 2, null);
        }

        public TypefaceStyle(int i, boolean z) {
            this.italic = z;
            this.weight = i == -1 ? 400 : i;
        }

        public TypefaceStyle(int i, int i2) {
            i = i == -1 ? 0 : i;
            this.italic = (i & 2) != 0;
            this.weight = i2 == -1 ? (i & 1) != 0 ? BOLD : 400 : i2;
        }

        public /* synthetic */ TypefaceStyle(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i3 & 2) != 0 ? -1 : i2);
        }

        public final int getNearestStyle() {
            return this.weight < 700 ? this.italic ? 2 : 0 : this.italic ? 3 : 1;
        }

        public final Typeface apply(Typeface typeface) {
            if (Build.VERSION.SDK_INT < 28) {
                Typeface typefaceCreate = Typeface.create(typeface, getNearestStyle());
                Intrinsics.checkNotNull(typefaceCreate);
                return typefaceCreate;
            }
            Typeface typefaceCreate2 = Typeface.create(typeface, this.weight, this.italic);
            Intrinsics.checkNotNull(typefaceCreate2);
            return typefaceCreate2;
        }
    }

    /* compiled from: ReactFontManager.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\nH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/react/common/assets/ReactFontManager$Companion;", "", "()V", "EXTENSIONS", "", "", "[Ljava/lang/String;", "FILE_EXTENSIONS", "FONTS_ASSET_PATH", "_instance", "Lcom/facebook/react/common/assets/ReactFontManager;", "createAssetTypeface", "Landroid/graphics/Typeface;", "fontFamilyName", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "assetManager", "Landroid/content/res/AssetManager;", "getInstance", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ReactFontManager getInstance() {
            return ReactFontManager._instance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Typeface createAssetTypeface(String fontFamilyName, int style, AssetManager assetManager) {
            if (assetManager != null) {
                String str = ReactFontManager.EXTENSIONS[style];
                for (String str2 : ReactFontManager.FILE_EXTENSIONS) {
                    try {
                        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(assetManager, ReactFontManager.FONTS_ASSET_PATH + fontFamilyName + str + str2);
                        Intrinsics.checkNotNullExpressionValue(typefaceCreateFromAsset, "createFromAsset(...)");
                        return typefaceCreateFromAsset;
                    } catch (RuntimeException unused) {
                    }
                }
            }
            Typeface typefaceCreate = Typeface.create(fontFamilyName, style);
            Intrinsics.checkNotNullExpressionValue(typefaceCreate, "create(...)");
            return typefaceCreate;
        }
    }

    /* compiled from: ReactFontManager.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/react/common/assets/ReactFontManager$AssetFontFamily;", "", "()V", "typefaceSparseArray", "Landroid/util/SparseArray;", "Landroid/graphics/Typeface;", "getTypefaceForStyle", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "setTypefaceForStyle", "", "typeface", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class AssetFontFamily {
        private final SparseArray<Typeface> typefaceSparseArray = new SparseArray<>(4);

        public final Typeface getTypefaceForStyle(int style) {
            return this.typefaceSparseArray.get(style);
        }

        public final void setTypefaceForStyle(int style, Typeface typeface) {
            this.typefaceSparseArray.put(style, typeface);
        }
    }
}
