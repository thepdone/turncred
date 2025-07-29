package com.facebook.soloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Nullable;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes3.dex */
public class SoFileLoaderImpl implements SoFileLoader {
    private static final String TAG = "SoFileLoaderImpl";

    @Nullable
    private final Runtime mRuntime = null;

    @Nullable
    private final Method mNativeLoadRuntimeMethod = null;

    @Nullable
    private final String mLocalLdLibraryPath = null;

    @Nullable
    private final String mLocalLdLibraryPathNoZips = null;

    @Override // com.facebook.soloader.SoFileLoader
    public void loadBytes(String str, ElfByteChannel elfByteChannel, int i) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
    
        if (r3 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        com.facebook.soloader.LogUtil.e(com.facebook.soloader.SoFileLoaderImpl.TAG, "Error when loading library: " + r3 + ", library hash is " + getLibHash(r8) + ", LD_LIBRARY_PATH is " + r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:?, code lost:
    
        return;
     */
    @Override // com.facebook.soloader.SoFileLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void load(java.lang.String r8, int r9) {
        /*
            r7 = this;
            java.lang.String r0 = "nativeLoad() returned error for "
            java.lang.reflect.Method r1 = r7.mNativeLoadRuntimeMethod
            if (r1 != 0) goto La
            java.lang.System.load(r8)
            return
        La:
            r1 = 4
            r9 = r9 & r1
            if (r9 != r1) goto L11
            java.lang.String r9 = r7.mLocalLdLibraryPath
            goto L13
        L11:
            java.lang.String r9 = r7.mLocalLdLibraryPathNoZips
        L13:
            r1 = 0
            java.lang.Runtime r2 = r7.mRuntime     // Catch: java.lang.Throwable -> L85 java.lang.reflect.InvocationTargetException -> L87 java.lang.IllegalArgumentException -> L89 java.lang.IllegalAccessException -> L8b
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L85 java.lang.reflect.InvocationTargetException -> L87 java.lang.IllegalArgumentException -> L89 java.lang.IllegalAccessException -> L8b
            java.lang.reflect.Method r3 = r7.mNativeLoadRuntimeMethod     // Catch: java.lang.Throwable -> L82
            java.lang.Runtime r4 = r7.mRuntime     // Catch: java.lang.Throwable -> L82
            java.lang.Class<com.facebook.soloader.SoLoader> r5 = com.facebook.soloader.SoLoader.class
            java.lang.ClassLoader r5 = r5.getClassLoader()     // Catch: java.lang.Throwable -> L82
            java.lang.Object[] r5 = new java.lang.Object[]{r8, r5, r9}     // Catch: java.lang.Throwable -> L82
            java.lang.Object r3 = r3.invoke(r4, r5)     // Catch: java.lang.Throwable -> L82
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L82
            if (r3 != 0) goto L60
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L5d
            if (r3 == 0) goto L5c
            java.lang.String r0 = "SoFileLoaderImpl"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Error when loading library: "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r2 = ", library hash is "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r8 = r7.getLibHash(r8)
            java.lang.StringBuilder r8 = r1.append(r8)
            java.lang.String r1 = ", LD_LIBRARY_PATH is "
            java.lang.StringBuilder r8 = r8.append(r1)
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r8 = r8.toString()
            com.facebook.soloader.LogUtil.e(r0, r8)
        L5c:
            return
        L5d:
            r0 = move-exception
            r1 = r3
            goto L83
        L60:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5d
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L5d
            java.lang.StringBuilder r0 = r1.append(r8)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r1 = ": "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L5d
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L5d
            com.facebook.soloader.SoLoaderULError r1 = new com.facebook.soloader.SoLoaderULError     // Catch: java.lang.Throwable -> L7d
            r1.<init>(r8, r0)     // Catch: java.lang.Throwable -> L7d
            throw r1     // Catch: java.lang.Throwable -> L7d
        L7d:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L83
        L82:
            r0 = move-exception
        L83:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L82
            throw r0     // Catch: java.lang.Throwable -> L85 java.lang.reflect.InvocationTargetException -> L87 java.lang.IllegalArgumentException -> L89 java.lang.IllegalAccessException -> L8b
        L85:
            r0 = move-exception
            goto Laf
        L87:
            r0 = move-exception
            goto L8c
        L89:
            r0 = move-exception
            goto L8c
        L8b:
            r0 = move-exception
        L8c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L85
            r2.<init>()     // Catch: java.lang.Throwable -> L85
            java.lang.String r3 = "nativeLoad() error during invocation for "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L85
            java.lang.StringBuilder r2 = r2.append(r8)     // Catch: java.lang.Throwable -> L85
            java.lang.String r3 = ": "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L85
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch: java.lang.Throwable -> L85
            java.lang.String r1 = r0.toString()     // Catch: java.lang.Throwable -> L85
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L85
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L85
            throw r0     // Catch: java.lang.Throwable -> L85
        Laf:
            if (r1 == 0) goto Ldd
            java.lang.String r2 = "SoFileLoaderImpl"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Error when loading library: "
            r3.<init>(r4)
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r3 = ", library hash is "
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r8 = r7.getLibHash(r8)
            java.lang.StringBuilder r8 = r1.append(r8)
            java.lang.String r1 = ", LD_LIBRARY_PATH is "
            java.lang.StringBuilder r8 = r8.append(r1)
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r8 = r8.toString()
            com.facebook.soloader.LogUtil.e(r2, r8)
        Ldd:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoFileLoaderImpl.load(java.lang.String, int):void");
    }

    private String getLibHash(String str) throws NoSuchAlgorithmException, IOException {
        try {
            File file = new File(str);
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i > 0) {
                        messageDigest.update(bArr, 0, i);
                    } else {
                        String str2 = String.format("%32x", new BigInteger(1, messageDigest.digest()));
                        fileInputStream.close();
                        return str2;
                    }
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException | SecurityException | NoSuchAlgorithmException e) {
            return e.toString();
        }
    }
}
