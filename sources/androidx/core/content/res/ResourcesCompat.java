package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public final class ResourcesCompat {
    public static final int ID_NULL = 0;
    private static final String TAG = "ResourcesCompat";
    private static final ThreadLocal<TypedValue> sTempTypedValue = new ThreadLocal<>();
    private static final WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> sColorStateCaches = new WeakHashMap<>(0);
    private static final Object sColorStateCacheLock = new Object();

    public static void clearCachesForTheme(Resources.Theme theme) {
        synchronized (sColorStateCacheLock) {
            Iterator<ColorStateListCacheKey> it = sColorStateCaches.keySet().iterator();
            while (it.hasNext()) {
                ColorStateListCacheKey next = it.next();
                if (next != null && theme.equals(next.mTheme)) {
                    it.remove();
                }
            }
        }
    }

    public static Drawable getDrawable(Resources resources, int i, Resources.Theme theme) throws Resources.NotFoundException {
        return Api21Impl.getDrawable(resources, i, theme);
    }

    public static Drawable getDrawableForDensity(Resources resources, int i, int i2, Resources.Theme theme) throws Resources.NotFoundException {
        return Api21Impl.getDrawableForDensity(resources, i, i2, theme);
    }

    public static int getColor(Resources resources, int i, Resources.Theme theme) throws Resources.NotFoundException {
        return Api23Impl.getColor(resources, i, theme);
    }

    public static ColorStateList getColorStateList(Resources resources, int i, Resources.Theme theme) throws Resources.NotFoundException {
        ColorStateListCacheKey colorStateListCacheKey = new ColorStateListCacheKey(resources, theme);
        ColorStateList cachedColorStateList = getCachedColorStateList(colorStateListCacheKey, i);
        if (cachedColorStateList != null) {
            return cachedColorStateList;
        }
        ColorStateList colorStateListInflateColorStateList = inflateColorStateList(resources, i, theme);
        if (colorStateListInflateColorStateList != null) {
            addColorStateListToCache(colorStateListCacheKey, i, colorStateListInflateColorStateList, theme);
            return colorStateListInflateColorStateList;
        }
        return Api23Impl.getColorStateList(resources, i, theme);
    }

    private static ColorStateList inflateColorStateList(Resources resources, int i, Resources.Theme theme) {
        if (isColorInt(resources, i)) {
            return null;
        }
        try {
            return ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(i), theme);
        } catch (Exception e) {
            Log.w(TAG, "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    private static ColorStateList getCachedColorStateList(ColorStateListCacheKey colorStateListCacheKey, int i) {
        ColorStateListCacheEntry colorStateListCacheEntry;
        synchronized (sColorStateCacheLock) {
            SparseArray<ColorStateListCacheEntry> sparseArray = sColorStateCaches.get(colorStateListCacheKey);
            if (sparseArray != null && sparseArray.size() > 0 && (colorStateListCacheEntry = sparseArray.get(i)) != null) {
                if (colorStateListCacheEntry.mConfiguration.equals(colorStateListCacheKey.mResources.getConfiguration()) && ((colorStateListCacheKey.mTheme == null && colorStateListCacheEntry.mThemeHash == 0) || (colorStateListCacheKey.mTheme != null && colorStateListCacheEntry.mThemeHash == colorStateListCacheKey.mTheme.hashCode()))) {
                    return colorStateListCacheEntry.mValue;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    private static void addColorStateListToCache(ColorStateListCacheKey colorStateListCacheKey, int i, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (sColorStateCacheLock) {
            WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> weakHashMap = sColorStateCaches;
            SparseArray<ColorStateListCacheEntry> sparseArray = weakHashMap.get(colorStateListCacheKey);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(colorStateListCacheKey, sparseArray);
            }
            sparseArray.append(i, new ColorStateListCacheEntry(colorStateList, colorStateListCacheKey.mResources.getConfiguration(), theme));
        }
    }

    private static boolean isColorInt(Resources resources, int i) throws Resources.NotFoundException {
        TypedValue typedValue = getTypedValue();
        resources.getValue(i, typedValue, true);
        return typedValue.type >= 28 && typedValue.type <= 31;
    }

    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> threadLocal = sTempTypedValue;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static final class ColorStateListCacheKey {
        final Resources mResources;
        final Resources.Theme mTheme;

        ColorStateListCacheKey(Resources resources, Resources.Theme theme) {
            this.mResources = resources;
            this.mTheme = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ColorStateListCacheKey colorStateListCacheKey = (ColorStateListCacheKey) obj;
            return this.mResources.equals(colorStateListCacheKey.mResources) && ObjectsCompat.equals(this.mTheme, colorStateListCacheKey.mTheme);
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.mResources, this.mTheme);
        }
    }

    private static class ColorStateListCacheEntry {
        final Configuration mConfiguration;
        final int mThemeHash;
        final ColorStateList mValue;

        ColorStateListCacheEntry(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.mValue = colorStateList;
            this.mConfiguration = configuration;
            this.mThemeHash = theme == null ? 0 : theme.hashCode();
        }
    }

    public static float getFloat(Resources resources, int i) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.getFloat(resources, i);
        }
        TypedValue typedValue = getTypedValue();
        resources.getValue(i, typedValue, true);
        if (typedValue.type == 4) {
            return typedValue.getFloat();
        }
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i) + " type #0x" + Integer.toHexString(typedValue.type) + " is not valid");
    }

    public static Typeface getFont(Context context, int i) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface getCachedFont(Context context, int i) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i, new TypedValue(), 0, null, null, false, true);
    }

    public static abstract class FontCallback {
        /* renamed from: onFontRetrievalFailed, reason: merged with bridge method [inline-methods] */
        public abstract void m5002xb24343b7(int i);

        /* renamed from: onFontRetrieved, reason: merged with bridge method [inline-methods] */
        public abstract void m5003x46c88379(Typeface typeface);

        public final void callbackSuccessAsync(final Typeface typeface, Handler handler) {
            getHandler(handler).post(new Runnable() { // from class: androidx.core.content.res.ResourcesCompat$FontCallback$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5003x46c88379(typeface);
                }
            });
        }

        public final void callbackFailAsync(final int i, Handler handler) {
            getHandler(handler).post(new Runnable() { // from class: androidx.core.content.res.ResourcesCompat$FontCallback$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5002xb24343b7(i);
                }
            });
        }

        public static Handler getHandler(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }
    }

    public static void getFont(Context context, int i, FontCallback fontCallback, Handler handler) throws Resources.NotFoundException {
        Preconditions.checkNotNull(fontCallback);
        if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, handler);
        } else {
            loadFont(context, i, new TypedValue(), 0, fontCallback, handler, false, false);
        }
    }

    public static Typeface getFont(Context context, int i, TypedValue typedValue, int i2, FontCallback fontCallback) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i, typedValue, i2, fontCallback, null, true, false);
    }

    private static Typeface loadFont(Context context, int i, TypedValue typedValue, int i2, FontCallback fontCallback, Handler handler, boolean z, boolean z2) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface typefaceLoadFont = loadFont(context, resources, typedValue, i, i2, fontCallback, handler, z, z2);
        if (typefaceLoadFont == null && fontCallback == null && !z2) {
            throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
        }
        return typefaceLoadFont;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Typeface loadFont(android.content.Context r17, android.content.res.Resources r18, android.util.TypedValue r19, int r20, int r21, androidx.core.content.res.ResourcesCompat.FontCallback r22, android.os.Handler r23, boolean r24, boolean r25) {
        /*
            r0 = r18
            r1 = r19
            r4 = r20
            r11 = r22
            r12 = r23
            java.lang.String r13 = "ResourcesCompat"
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto Lba
            java.lang.CharSequence r2 = r1.string
            java.lang.String r14 = r2.toString()
            java.lang.String r2 = "res/"
            boolean r2 = r14.startsWith(r2)
            r15 = -3
            r16 = 0
            if (r2 != 0) goto L28
            if (r11 == 0) goto L27
            r11.callbackFailAsync(r15, r12)
        L27:
            return r16
        L28:
            int r2 = r1.assetCookie
            r7 = r21
            android.graphics.Typeface r2 = androidx.core.graphics.TypefaceCompat.findFromCache(r0, r4, r14, r2, r7)
            if (r2 == 0) goto L38
            if (r11 == 0) goto L37
            r11.callbackSuccessAsync(r2, r12)
        L37:
            return r2
        L38:
            if (r25 == 0) goto L3b
            return r16
        L3b:
            java.lang.String r2 = r14.toLowerCase()     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> La1
            java.lang.String r3 = ".xml"
            boolean r2 = r2.endsWith(r3)     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> La1
            if (r2 == 0) goto L72
            android.content.res.XmlResourceParser r2 = r0.getXml(r4)     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> La1
            androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry r2 = androidx.core.content.res.FontResourcesParserCompat.parse(r2, r0)     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> La1
            if (r2 != 0) goto L5c
            java.lang.String r0 = "Failed to find font-family tag"
            android.util.Log.e(r13, r0)     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> La1
            if (r11 == 0) goto L5b
            r11.callbackFailAsync(r15, r12)     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> La1
        L5b:
            return r16
        L5c:
            int r6 = r1.assetCookie     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> La1
            r1 = r17
            r3 = r18
            r4 = r20
            r5 = r14
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            android.graphics.Typeface r0 = androidx.core.graphics.TypefaceCompat.createFromResourcesFamilyXml(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> La1
            return r0
        L72:
            int r5 = r1.assetCookie     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> La1
            r1 = r17
            r2 = r18
            r3 = r20
            r4 = r14
            r6 = r21
            android.graphics.Typeface r0 = androidx.core.graphics.TypefaceCompat.createFromResourcesFontFile(r1, r2, r3, r4, r5, r6)     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> La1
            if (r11 == 0) goto L8c
            if (r0 == 0) goto L89
            r11.callbackSuccessAsync(r0, r12)     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> La1
            goto L8c
        L89:
            r11.callbackFailAsync(r15, r12)     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> La1
        L8c:
            return r0
        L8d:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to read xml resource "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r14)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r13, r1, r0)
            goto Lb4
        La1:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to parse xml resource "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r14)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r13, r1, r0)
        Lb4:
            if (r11 == 0) goto Lb9
            r11.callbackFailAsync(r15, r12)
        Lb9:
            return r16
        Lba:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "Resource \""
            r3.<init>(r5)
            java.lang.String r0 = r0.getResourceName(r4)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r3 = "\" ("
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r20)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r3 = ") is not a Font: "
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.loadFont(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.res.ResourcesCompat$FontCallback, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static float getFloat(Resources resources, int i) {
            return resources.getFloat(i);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static ColorStateList getColorStateList(Resources resources, int i, Resources.Theme theme) {
            return resources.getColorStateList(i, theme);
        }

        static int getColor(Resources resources, int i, Resources.Theme theme) {
            return resources.getColor(i, theme);
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static Drawable getDrawable(Resources resources, int i, Resources.Theme theme) {
            return resources.getDrawable(i, theme);
        }

        static Drawable getDrawableForDensity(Resources resources, int i, int i2, Resources.Theme theme) {
            return resources.getDrawableForDensity(i, i2, theme);
        }
    }

    private ResourcesCompat() {
    }

    public static final class ThemeCompat {
        private ThemeCompat() {
        }

        public static void rebase(Resources.Theme theme) {
            if (Build.VERSION.SDK_INT >= 29) {
                Api29Impl.rebase(theme);
            } else {
                Api23Impl.rebase(theme);
            }
        }

        static class Api29Impl {
            private Api29Impl() {
            }

            static void rebase(Resources.Theme theme) {
                theme.rebase();
            }
        }

        static class Api23Impl {
            private static Method sRebaseMethod;
            private static boolean sRebaseMethodFetched;
            private static final Object sRebaseMethodLock = new Object();

            private Api23Impl() {
            }

            /* JADX WARN: Removed duplicated region for block: B:30:0x0028 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            static void rebase(android.content.res.Resources.Theme r6) {
                /*
                    java.lang.Object r0 = androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.sRebaseMethodLock
                    monitor-enter(r0)
                    boolean r1 = androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.sRebaseMethodFetched     // Catch: java.lang.Throwable -> L3d
                    r2 = 0
                    if (r1 != 0) goto L24
                    r1 = 1
                    java.lang.Class<android.content.res.Resources$Theme> r3 = android.content.res.Resources.Theme.class
                    java.lang.String r4 = "rebase"
                    java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch: java.lang.NoSuchMethodException -> L1a java.lang.Throwable -> L3d
                    java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch: java.lang.NoSuchMethodException -> L1a java.lang.Throwable -> L3d
                    androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.sRebaseMethod = r3     // Catch: java.lang.NoSuchMethodException -> L1a java.lang.Throwable -> L3d
                    r3.setAccessible(r1)     // Catch: java.lang.NoSuchMethodException -> L1a java.lang.Throwable -> L3d
                    goto L22
                L1a:
                    r3 = move-exception
                    java.lang.String r4 = "ResourcesCompat"
                    java.lang.String r5 = "Failed to retrieve rebase() method"
                    android.util.Log.i(r4, r5, r3)     // Catch: java.lang.Throwable -> L3d
                L22:
                    androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.sRebaseMethodFetched = r1     // Catch: java.lang.Throwable -> L3d
                L24:
                    java.lang.reflect.Method r1 = androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.sRebaseMethod     // Catch: java.lang.Throwable -> L3d
                    if (r1 == 0) goto L3b
                    java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.reflect.InvocationTargetException -> L2e java.lang.IllegalAccessException -> L30 java.lang.Throwable -> L3d
                    r1.invoke(r6, r2)     // Catch: java.lang.reflect.InvocationTargetException -> L2e java.lang.IllegalAccessException -> L30 java.lang.Throwable -> L3d
                    goto L3b
                L2e:
                    r6 = move-exception
                    goto L31
                L30:
                    r6 = move-exception
                L31:
                    java.lang.String r1 = "ResourcesCompat"
                    java.lang.String r2 = "Failed to invoke rebase() method via reflection"
                    android.util.Log.i(r1, r2, r6)     // Catch: java.lang.Throwable -> L3d
                    r6 = 0
                    androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.sRebaseMethod = r6     // Catch: java.lang.Throwable -> L3d
                L3b:
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L3d
                    return
                L3d:
                    r6 = move-exception
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L3d
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.ThemeCompat.Api23Impl.rebase(android.content.res.Resources$Theme):void");
            }
        }
    }
}
