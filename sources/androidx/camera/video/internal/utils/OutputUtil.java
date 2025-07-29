package androidx.camera.video.internal.utils;

import java.io.File;

/* loaded from: classes.dex */
public final class OutputUtil {
    private static final String TAG = "OutputUtil";

    private OutputUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getAbsolutePathFromUri(android.content.ContentResolver r8, android.net.Uri r9, java.lang.String r10) throws java.lang.Throwable {
        /*
            r0 = 1
            r1 = 0
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L2b java.lang.RuntimeException -> L2d
            r0 = 0
            r4[r0] = r10     // Catch: java.lang.Throwable -> L2b java.lang.RuntimeException -> L2d
            r6 = 0
            r7 = 0
            r5 = 0
            r2 = r8
            r3 = r9
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L2b java.lang.RuntimeException -> L2d
            if (r8 != 0) goto L18
            if (r8 == 0) goto L17
            r8.close()
        L17:
            return r1
        L18:
            int r10 = r8.getColumnIndexOrThrow(r10)     // Catch: java.lang.RuntimeException -> L29 java.lang.Throwable -> L4c
            r8.moveToFirst()     // Catch: java.lang.RuntimeException -> L29 java.lang.Throwable -> L4c
            java.lang.String r9 = r8.getString(r10)     // Catch: java.lang.RuntimeException -> L29 java.lang.Throwable -> L4c
            if (r8 == 0) goto L28
            r8.close()
        L28:
            return r9
        L29:
            r10 = move-exception
            goto L2f
        L2b:
            r9 = move-exception
            goto L4e
        L2d:
            r10 = move-exception
            r8 = r1
        L2f:
            java.lang.String r0 = "OutputUtil"
            java.lang.String r2 = "Failed in getting absolute path for Uri %s with Exception %s"
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L4c
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L4c
            java.lang.Object[] r9 = new java.lang.Object[]{r9, r10}     // Catch: java.lang.Throwable -> L4c
            java.lang.String r9 = java.lang.String.format(r2, r9)     // Catch: java.lang.Throwable -> L4c
            androidx.camera.core.Logger.e(r0, r9)     // Catch: java.lang.Throwable -> L4c
            if (r8 == 0) goto L4b
            r8.close()
        L4b:
            return r1
        L4c:
            r9 = move-exception
            r1 = r8
        L4e:
            if (r1 == 0) goto L53
            r1.close()
        L53:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.utils.OutputUtil.getAbsolutePathFromUri(android.content.ContentResolver, android.net.Uri, java.lang.String):java.lang.String");
    }

    public static boolean createParentFolder(File file) {
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return false;
        }
        return parentFile.exists() ? parentFile.isDirectory() : parentFile.mkdirs();
    }
}
