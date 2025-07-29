package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;

/* compiled from: UrlRedirectCache.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\b\u0010\r\u001a\u00020\tH\u0007J\b\u0010\u000e\u001a\u00020\u0007H\u0007J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/internal/UrlRedirectCache;", "", "()V", "redirectContentTag", "", "tag", "urlRedirectFileLruCache", "Lcom/facebook/internal/FileLruCache;", "cacheUriRedirect", "", "fromUri", "Landroid/net/Uri;", "toUri", "clearCache", "getCache", "getRedirectedUri", ShareConstants.MEDIA_URI, "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UrlRedirectCache {
    public static final UrlRedirectCache INSTANCE = new UrlRedirectCache();
    private static final String redirectContentTag;
    private static final String tag;
    private static FileLruCache urlRedirectFileLruCache;

    private UrlRedirectCache() {
    }

    static {
        String simpleName = Reflection.getOrCreateKotlinClass(UrlRedirectCache.class).getSimpleName();
        if (simpleName == null) {
            simpleName = "UrlRedirectCache";
        }
        tag = simpleName;
        redirectContentTag = simpleName + "_Redirect";
    }

    @JvmStatic
    public static final synchronized FileLruCache getCache() throws IOException {
        FileLruCache fileLruCache;
        fileLruCache = urlRedirectFileLruCache;
        if (fileLruCache == null) {
            fileLruCache = new FileLruCache(tag, new FileLruCache.Limits());
        }
        urlRedirectFileLruCache = fileLruCache;
        return fileLruCache;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r3, r10) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005e, code lost:
    
        r5 = r6;
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0061, code lost:
    
        com.facebook.internal.Logger.INSTANCE.log(com.facebook.LoggingBehavior.CACHE, 6, com.facebook.internal.UrlRedirectCache.tag, "A loop detected in UrlRedirectCache");
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006d, code lost:
    
        com.facebook.internal.Utility.closeQuietly(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0072, code lost:
    
        return null;
     */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00c4: MOVE (r0 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:43:0x00c4 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final android.net.Uri getRedirectedUri(android.net.Uri r10) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r10 != 0) goto L4
            return r0
        L4:
            java.lang.String r10 = r10.toString()
            java.lang.String r1 = "uri.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r1)
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            r1.add(r10)
            com.facebook.internal.FileLruCache r2 = getCache()     // Catch: java.lang.Throwable -> L9c java.io.IOException -> L9e
            java.lang.String r3 = com.facebook.internal.UrlRedirectCache.redirectContentTag     // Catch: java.lang.Throwable -> L9c java.io.IOException -> L9e
            java.io.InputStream r3 = r2.get(r10, r3)     // Catch: java.lang.Throwable -> L9c java.io.IOException -> L9e
            r4 = 0
            r5 = r0
            r6 = r4
        L23:
            if (r3 == 0) goto L8a
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch: java.io.IOException -> L88 java.lang.Throwable -> Lc3
            r6.<init>(r3)     // Catch: java.io.IOException -> L88 java.lang.Throwable -> Lc3
            r3 = 128(0x80, float:1.794E-43)
            char[] r5 = new char[r3]     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L85
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L85
            r7.<init>()     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L85
            int r8 = r6.read(r5, r4, r3)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L85
        L37:
            if (r8 <= 0) goto L41
            r7.append(r5, r4, r8)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L85
            int r8 = r6.read(r5, r4, r3)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L85
            goto L37
        L41:
            r3 = r6
            java.io.Closeable r3 = (java.io.Closeable) r3     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L85
            com.facebook.internal.Utility.closeQuietly(r3)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L85
            java.lang.String r3 = r7.toString()     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L85
            java.lang.String r5 = "urlBuilder.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L85
            boolean r5 = r1.contains(r3)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L85
            r7 = 1
            if (r5 == 0) goto L73
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r10)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L85
            if (r1 == 0) goto L61
            r5 = r6
            r6 = r7
            goto L8a
        L61:
            com.facebook.internal.Logger$Companion r10 = com.facebook.internal.Logger.INSTANCE     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L85
            com.facebook.LoggingBehavior r1 = com.facebook.LoggingBehavior.CACHE     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L85
            java.lang.String r2 = com.facebook.internal.UrlRedirectCache.tag     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L85
            java.lang.String r3 = "A loop detected in UrlRedirectCache"
            r4 = 6
            r10.log(r1, r4, r2, r3)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L85
            java.io.Closeable r6 = (java.io.Closeable) r6
            com.facebook.internal.Utility.closeQuietly(r6)
            return r0
        L73:
            r1.add(r3)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L85
            java.lang.String r10 = com.facebook.internal.UrlRedirectCache.redirectContentTag     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L85
            java.io.InputStream r10 = r2.get(r3, r10)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L85
            r5 = r6
            r6 = r7
            r9 = r3
            r3 = r10
            r10 = r9
            goto L23
        L82:
            r10 = move-exception
            r0 = r6
            goto Lc5
        L85:
            r10 = move-exception
            r5 = r6
            goto La0
        L88:
            r10 = move-exception
            goto La0
        L8a:
            if (r6 == 0) goto L96
            android.net.Uri r10 = android.net.Uri.parse(r10)     // Catch: java.io.IOException -> L88 java.lang.Throwable -> Lc3
            java.io.Closeable r5 = (java.io.Closeable) r5
            com.facebook.internal.Utility.closeQuietly(r5)
            return r10
        L96:
            java.io.Closeable r5 = (java.io.Closeable) r5
            com.facebook.internal.Utility.closeQuietly(r5)
            goto Lc2
        L9c:
            r10 = move-exception
            goto Lc5
        L9e:
            r10 = move-exception
            r5 = r0
        La0:
            com.facebook.internal.Logger$Companion r1 = com.facebook.internal.Logger.INSTANCE     // Catch: java.lang.Throwable -> Lc3
            com.facebook.LoggingBehavior r2 = com.facebook.LoggingBehavior.CACHE     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r3 = com.facebook.internal.UrlRedirectCache.tag     // Catch: java.lang.Throwable -> Lc3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc3
            r4.<init>()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r6 = "IOException when accessing cache: "
            java.lang.StringBuilder r4 = r4.append(r6)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> Lc3
            java.lang.StringBuilder r10 = r4.append(r10)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> Lc3
            r4 = 4
            r1.log(r2, r4, r3, r10)     // Catch: java.lang.Throwable -> Lc3
            goto L96
        Lc2:
            return r0
        Lc3:
            r10 = move-exception
            r0 = r5
        Lc5:
            java.io.Closeable r0 = (java.io.Closeable) r0
            com.facebook.internal.Utility.closeQuietly(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.UrlRedirectCache.getRedirectedUri(android.net.Uri):android.net.Uri");
    }

    @JvmStatic
    public static final void cacheUriRedirect(Uri fromUri, Uri toUri) {
        if (fromUri == null || toUri == null) {
            return;
        }
        OutputStream outputStreamOpenPutStream = null;
        try {
            try {
                FileLruCache cache = getCache();
                String string = fromUri.toString();
                Intrinsics.checkNotNullExpressionValue(string, "fromUri.toString()");
                outputStreamOpenPutStream = cache.openPutStream(string, redirectContentTag);
                String string2 = toUri.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toUri.toString()");
                byte[] bytes = string2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                outputStreamOpenPutStream.write(bytes);
            } catch (IOException e) {
                Logger.INSTANCE.log(LoggingBehavior.CACHE, 4, tag, "IOException when accessing cache: " + e.getMessage());
            }
        } finally {
            Utility.closeQuietly(outputStreamOpenPutStream);
        }
    }

    @JvmStatic
    public static final void clearCache() {
        try {
            getCache().clearCache();
        } catch (IOException e) {
            Logger.INSTANCE.log(LoggingBehavior.CACHE, 5, tag, "clearCache failed " + e.getMessage());
        }
    }
}
