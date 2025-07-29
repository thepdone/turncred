package com.canhub.cropper.utils;

import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.facebook.react.uimanager.events.TouchesHelper;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: GetFilePathFromUri.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a \u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a \u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¨\u0006\u0012"}, d2 = {"copy", "", "source", "Ljava/io/InputStream;", TouchesHelper.TARGET_KEY, "Ljava/io/OutputStream;", "getFileExtension", "", "context", "Landroid/content/Context;", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "getFileFromContentUri", "Ljava/io/File;", "contentUri", "uniqueName", "", "getFilePathFromUri", "cropper_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class GetFilePathFromUriKt {
    public static final String getFilePathFromUri(Context context, Uri uri, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        String path = uri.getPath();
        if (path == null || !StringsKt.contains$default((CharSequence) path, (CharSequence) "file://", false, 2, (Object) null)) {
            String path2 = getFileFromContentUri(context, uri, z).getPath();
            Intrinsics.checkNotNullExpressionValue(path2, "getFileFromContentUri(co…xt, uri, uniqueName).path");
            return path2;
        }
        String path3 = uri.getPath();
        Intrinsics.checkNotNull(path3);
        return path3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0090  */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.io.File getFileFromContentUri(android.content.Context r5, android.net.Uri r6, boolean r7) throws java.lang.Throwable {
        /*
            java.lang.String r0 = getFileExtension(r5, r6)
            java.lang.String r1 = ""
            if (r0 != 0) goto L9
            r0 = r1
        L9:
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.lang.String r3 = "yyyyMMdd_HHmmss"
            java.util.Locale r4 = java.util.Locale.getDefault()
            r2.<init>(r3, r4)
            java.util.Date r3 = new java.util.Date
            r3.<init>()
            java.lang.String r2 = r2.format(r3)
            if (r7 == 0) goto L21
            r1 = r2
        L21:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r2 = "temp_file_"
            r7.<init>(r2)
            java.lang.StringBuilder r7 = r7.append(r1)
            java.lang.String r1 = "."
            java.lang.StringBuilder r7 = r7.append(r1)
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.String r7 = r7.toString()
            java.io.File r0 = new java.io.File
            java.io.File r1 = r5.getCacheDir()
            r0.<init>(r1, r7)
            r0.createNewFile()
            r7 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6e
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L6e
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L82
            java.io.InputStream r7 = r5.openInputStream(r6)     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L82
            if (r7 == 0) goto L5d
            r5 = r1
            java.io.OutputStream r5 = (java.io.OutputStream) r5     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L82
            copy(r7, r5)     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L82
        L5d:
            r1.flush()     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L82
            if (r7 == 0) goto L65
            r7.close()
        L65:
            r1.close()
            goto L81
        L69:
            r5 = move-exception
            goto L70
        L6b:
            r5 = move-exception
            r1 = r7
            goto L83
        L6e:
            r5 = move-exception
            r1 = r7
        L70:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L82
            r5 = r7
            java.io.InputStream r5 = (java.io.InputStream) r5
            if (r7 == 0) goto L7b
            r7.close()
        L7b:
            r5 = r1
            java.io.FileOutputStream r5 = (java.io.FileOutputStream) r5
            if (r1 == 0) goto L81
            goto L65
        L81:
            return r0
        L82:
            r5 = move-exception
        L83:
            r6 = r7
            java.io.InputStream r6 = (java.io.InputStream) r6
            if (r7 == 0) goto L8b
            r7.close()
        L8b:
            r6 = r1
            java.io.FileOutputStream r6 = (java.io.FileOutputStream) r6
            if (r1 == 0) goto L93
            r1.close()
        L93:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.canhub.cropper.utils.GetFilePathFromUriKt.getFileFromContentUri(android.content.Context, android.net.Uri, boolean):java.io.File");
    }

    private static final String getFileExtension(Context context, Uri uri) {
        if (Intrinsics.areEqual(uri.getScheme(), "content")) {
            return MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri));
        }
        String path = uri.getPath();
        if (path != null) {
            return MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(path)).toString());
        }
        return null;
    }

    private static final void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i <= 0) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }
}
