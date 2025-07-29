package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.facebook.react.common.assets.ReactFontManager;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class TypefaceCompatApi29Impl extends TypefaceCompatBaseImpl {
    private static int getMatchScore(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    private Font findBaseFont(FontFamily fontFamily, int i) {
        FontStyle fontStyle = new FontStyle((i & 1) != 0 ? ReactFontManager.TypefaceStyle.BOLD : 400, (i & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int matchScore = getMatchScore(fontStyle, font.getStyle());
        for (int i2 = 1; i2 < fontFamily.getSize(); i2++) {
            Font font2 = fontFamily.getFont(i2);
            int matchScore2 = getMatchScore(fontStyle, font2.getStyle());
            if (matchScore2 < matchScore) {
                font = font2;
                matchScore = matchScore2;
            }
        }
        return font;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    protected FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    protected Typeface createFromInputStream(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001b A[Catch: IOException -> 0x005b, Exception -> 0x007b, PHI: r3
  0x001b: PHI (r3v5 android.graphics.fonts.FontFamily$Builder) = (r3v3 android.graphics.fonts.FontFamily$Builder), (r3v1 android.graphics.fonts.FontFamily$Builder) binds: [B:15:0x004c, B:8:0x0019] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {Exception -> 0x007b, blocks: (B:3:0x0005, B:5:0x000a, B:6:0x000c, B:9:0x001b, B:23:0x005a, B:22:0x0057, B:27:0x0061), top: B:31:0x0005 }] */
    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Typeface createFromFontInfo(android.content.Context r9, android.os.CancellationSignal r10, androidx.core.provider.FontsContractCompat.FontInfo[] r11, int r12) throws java.io.IOException {
        /*
            r8 = this;
            android.content.ContentResolver r9 = r9.getContentResolver()
            r0 = 0
            int r1 = r11.length     // Catch: java.lang.Exception -> L7b
            r2 = 0
            r3 = r0
        L8:
            if (r2 >= r1) goto L5e
            r4 = r11[r2]     // Catch: java.lang.Exception -> L7b
            android.net.Uri r5 = r4.getUri()     // Catch: java.io.IOException -> L5b java.lang.Exception -> L7b
            java.lang.String r6 = "r"
            android.os.ParcelFileDescriptor r5 = r9.openFileDescriptor(r5, r6, r10)     // Catch: java.io.IOException -> L5b java.lang.Exception -> L7b
            if (r5 != 0) goto L1f
            if (r5 == 0) goto L5b
        L1b:
            r5.close()     // Catch: java.io.IOException -> L5b java.lang.Exception -> L7b
            goto L5b
        L1f:
            android.graphics.fonts.Font$Builder r6 = new android.graphics.fonts.Font$Builder     // Catch: java.lang.Throwable -> L4f
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L4f
            int r7 = r4.getWeight()     // Catch: java.lang.Throwable -> L4f
            android.graphics.fonts.Font$Builder r6 = r6.setWeight(r7)     // Catch: java.lang.Throwable -> L4f
            boolean r7 = r4.isItalic()     // Catch: java.lang.Throwable -> L4f
            android.graphics.fonts.Font$Builder r6 = r6.setSlant(r7)     // Catch: java.lang.Throwable -> L4f
            int r4 = r4.getTtcIndex()     // Catch: java.lang.Throwable -> L4f
            android.graphics.fonts.Font$Builder r4 = r6.setTtcIndex(r4)     // Catch: java.lang.Throwable -> L4f
            android.graphics.fonts.Font r4 = r4.build()     // Catch: java.lang.Throwable -> L4f
            if (r3 != 0) goto L49
            android.graphics.fonts.FontFamily$Builder r6 = new android.graphics.fonts.FontFamily$Builder     // Catch: java.lang.Throwable -> L4f
            r6.<init>(r4)     // Catch: java.lang.Throwable -> L4f
            r3 = r6
            goto L4c
        L49:
            r3.addFont(r4)     // Catch: java.lang.Throwable -> L4f
        L4c:
            if (r5 == 0) goto L5b
            goto L1b
        L4f:
            r4 = move-exception
            if (r5 == 0) goto L5a
            r5.close()     // Catch: java.lang.Throwable -> L56
            goto L5a
        L56:
            r5 = move-exception
            r4.addSuppressed(r5)     // Catch: java.io.IOException -> L5b java.lang.Exception -> L7b
        L5a:
            throw r4     // Catch: java.io.IOException -> L5b java.lang.Exception -> L7b
        L5b:
            int r2 = r2 + 1
            goto L8
        L5e:
            if (r3 != 0) goto L61
            return r0
        L61:
            android.graphics.fonts.FontFamily r9 = r3.build()     // Catch: java.lang.Exception -> L7b
            android.graphics.Typeface$CustomFallbackBuilder r10 = new android.graphics.Typeface$CustomFallbackBuilder     // Catch: java.lang.Exception -> L7b
            r10.<init>(r9)     // Catch: java.lang.Exception -> L7b
            android.graphics.fonts.Font r9 = r8.findBaseFont(r9, r12)     // Catch: java.lang.Exception -> L7b
            android.graphics.fonts.FontStyle r9 = r9.getStyle()     // Catch: java.lang.Exception -> L7b
            android.graphics.Typeface$CustomFallbackBuilder r9 = r10.setStyle(r9)     // Catch: java.lang.Exception -> L7b
            android.graphics.Typeface r9 = r9.build()     // Catch: java.lang.Exception -> L7b
            return r9
        L7b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatApi29Impl.createFromFontInfo(android.content.Context, android.os.CancellationSignal, androidx.core.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) throws IOException {
        try {
            FontFamily.Builder builder = null;
            for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.getEntries()) {
                try {
                    Font fontBuild = new Font.Builder(resources, fontFileResourceEntry.getResourceId()).setWeight(fontFileResourceEntry.getWeight()).setSlant(fontFileResourceEntry.isItalic() ? 1 : 0).setTtcIndex(fontFileResourceEntry.getTtcIndex()).setFontVariationSettings(fontFileResourceEntry.getVariationSettings()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(findBaseFont(fontFamilyBuild, i).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) throws IOException {
        try {
            Font fontBuild = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    Typeface createWeightStyle(Context context, Typeface typeface, int i, boolean z) {
        return Typeface.create(typeface, i, z);
    }
}
