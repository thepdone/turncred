package com.facebook.soloader;

import android.content.Context;
import android.os.StrictMode;
import com.facebook.soloader.MinElf;
import com.facebook.soloader.observer.ObserverHolder;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.Nullable;
import org.apache.commons.io.FilenameUtils;

/* loaded from: classes3.dex */
public final class NativeDeps {
    private static final float HASHMAP_LOAD_FACTOR = 1.0f;
    private static final int INITIAL_HASH = 5381;
    private static final int LIB_PREFIX_LEN;
    private static final int LIB_PREFIX_SUFFIX_LEN;
    private static final int LIB_SUFFIX_LEN;
    private static final String LOG_TAG = "NativeDeps";
    private static final HashSet<String> STANDARD_SYSTEM_LIBS;
    private static final int WAITING_THREADS_WARNING_THRESHOLD = 3;

    @Nullable
    private static byte[] sEncodedDeps;
    private static volatile boolean sInitialized;
    private static Map<Integer, List<Integer>> sPrecomputedDeps;
    private static List<Integer> sPrecomputedLibs;
    private static volatile boolean sUseDepsFileAsync;
    private static final ReentrantReadWriteLock sWaitForDepsFileLock;

    static {
        int length = "lib".length();
        LIB_PREFIX_LEN = length;
        int length2 = ".so".length();
        LIB_SUFFIX_LEN = length2;
        LIB_PREFIX_SUFFIX_LEN = length + length2;
        sInitialized = false;
        sUseDepsFileAsync = false;
        sWaitForDepsFileLock = new ReentrantReadWriteLock();
        STANDARD_SYSTEM_LIBS = new HashSet<String>() { // from class: com.facebook.soloader.NativeDeps.1
            {
                add("libEGL.so");
                add("libGLESv2.so");
                add("libGLESv3.so");
                add("libOpenSLES.so");
                add("libandroid.so");
                add("libc.so");
                add("libdl.so");
                add("libjnigraphics.so");
                add("liblog.so");
                add("libm.so");
                add("libstdc++.so");
                add("libz.so");
            }
        };
    }

    public static void loadDependencies(String str, ElfByteChannel elfByteChannel, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        String[] dependencies = getDependencies(str, elfByteChannel);
        LogUtil.d(SoLoader.TAG, "Loading " + str + "'s dependencies: " + Arrays.toString(dependencies));
        for (String str2 : dependencies) {
            if (!str2.startsWith("/") && !STANDARD_SYSTEM_LIBS.contains(str2)) {
                SoLoader.loadDependency(str2, i, threadPolicy);
            }
        }
    }

    public static String[] getDependencies(String str, ElfByteChannel elfByteChannel) throws IOException {
        if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
            Api18TraceUtils.beginTraceSection("soloader.NativeDeps.getDependencies[", str, "]");
        }
        ObserverHolder.onGetDependenciesStart();
        try {
            try {
                String[] strArrAwaitGetDepsFromPrecomputedDeps = awaitGetDepsFromPrecomputedDeps(str);
                if (strArrAwaitGetDepsFromPrecomputedDeps != null) {
                    return strArrAwaitGetDepsFromPrecomputedDeps;
                }
                String[] strArrExtract_DT_NEEDED = MinElf.extract_DT_NEEDED(elfByteChannel);
                ObserverHolder.onGetDependenciesEnd(null);
                if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
                    Api18TraceUtils.endSection();
                }
                return strArrExtract_DT_NEEDED;
            } catch (MinElf.ElfError e) {
                throw SoLoaderULErrorFactory.create(str, e);
            } catch (Error e2) {
                e = e2;
                throw e;
            } catch (RuntimeException e3) {
                e = e3;
                throw e;
            }
        } finally {
            ObserverHolder.onGetDependenciesEnd(null);
            if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
                Api18TraceUtils.endSection();
            }
        }
    }

    @Nullable
    private static String[] awaitGetDepsFromPrecomputedDeps(String str) {
        if (sInitialized) {
            return tryGetDepsFromPrecomputedDeps(str);
        }
        if (!sUseDepsFileAsync) {
            return null;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = sWaitForDepsFileLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            String[] strArrTryGetDepsFromPrecomputedDeps = tryGetDepsFromPrecomputedDeps(str);
            reentrantReadWriteLock.readLock().unlock();
            return strArrTryGetDepsFromPrecomputedDeps;
        } catch (Throwable th) {
            sWaitForDepsFileLock.readLock().unlock();
            throw th;
        }
    }

    public static boolean useDepsFile(final Context context, boolean z, final boolean z2) {
        if (!z) {
            return useDepsFileFromApkSync(context, z2);
        }
        new Thread(new Runnable() { // from class: com.facebook.soloader.NativeDeps.2
            @Override // java.lang.Runnable
            public void run() {
                NativeDeps.sWaitForDepsFileLock.writeLock().lock();
                boolean unused = NativeDeps.sUseDepsFileAsync = true;
                try {
                    NativeDeps.useDepsFileFromApkSync(context, z2);
                } finally {
                    int readLockCount = NativeDeps.sWaitForDepsFileLock.getReadLockCount();
                    if (readLockCount >= 3) {
                        LogUtil.w(NativeDeps.LOG_TAG, "NativeDeps initialization finished with " + Integer.toString(readLockCount) + " threads waiting.");
                    }
                    NativeDeps.sWaitForDepsFileLock.writeLock().unlock();
                    boolean unused2 = NativeDeps.sUseDepsFileAsync = false;
                }
            }
        }, "soloader-nativedeps-init").start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean useDepsFileFromApkSync(Context context, boolean z) throws Throwable {
        boolean zInitDeps;
        try {
            zInitDeps = initDeps(context, z);
        } catch (IOException unused) {
            zInitDeps = false;
        }
        if (!zInitDeps && z) {
            try {
                NativeDepsUnpacker.ensureNativeDepsAvailable(context);
                zInitDeps = initDeps(context, z);
            } catch (IOException unused2) {
            }
        }
        if (!zInitDeps) {
            LogUtil.w(LOG_TAG, "Failed to extract native deps from APK, falling back to using MinElf to get library dependencies.");
        }
        return zInitDeps;
    }

    private static boolean initDeps(Context context, boolean z) throws IOException {
        byte[] nativeDepsFromApk;
        byte[] bArrMakeApkDepBlock;
        verifyUninitialized();
        if (z) {
            bArrMakeApkDepBlock = SysUtil.makeApkDepBlock(new File(context.getApplicationInfo().sourceDir), context);
            nativeDepsFromApk = NativeDepsUnpacker.readNativeDepsFromDisk(context);
        } else {
            nativeDepsFromApk = NativeDepsUnpacker.readNativeDepsFromApk(context);
            bArrMakeApkDepBlock = null;
        }
        return processDepsBytes(bArrMakeApkDepBlock, nativeDepsFromApk);
    }

    private static void indexLib(int i, int i2) {
        sPrecomputedLibs.add(Integer.valueOf(i2));
        List<Integer> arrayList = sPrecomputedDeps.get(Integer.valueOf(i));
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            sPrecomputedDeps.put(Integer.valueOf(i), arrayList);
        }
        arrayList.add(Integer.valueOf(i2));
    }

    private static void indexDepsBytes(byte[] bArr, int i) {
        int i2;
        byte b;
        boolean z = true;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (z) {
                i3 = INITIAL_HASH;
                i2 = i;
                while (true) {
                    try {
                        b = bArr[i2];
                        if (b <= 32) {
                            break;
                        }
                        i3 = (i3 << 5) + i3 + b;
                        i2++;
                    } catch (IndexOutOfBoundsException unused) {
                        if (z) {
                            return;
                        } else {
                            return;
                        }
                    }
                }
                indexLib(i3, i);
                z = b != 32;
                int i5 = i2 + 1;
                i4 = i;
                i = i5;
            } else {
                while (bArr[i] != 10) {
                    try {
                        i++;
                    } catch (IndexOutOfBoundsException unused2) {
                        i = i4;
                        if (z || i == bArr.length) {
                            return;
                        }
                        indexLib(i3, i);
                        return;
                    }
                }
                z = true;
                int i6 = i4;
                i2 = i;
                i = i6;
                int i52 = i2 + 1;
                i4 = i;
                i = i52;
            }
        }
    }

    private static int verifyBytesAndGetOffset(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr2.length < bArr.length + 4) {
            return -1;
        }
        if (bArr2.length != bArr.length + 4 + ByteBuffer.wrap(bArr2, bArr.length, 4).getInt()) {
            return -1;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return -1;
            }
        }
        return bArr.length + 4;
    }

    private static int findNextLine(byte[] bArr, int i) {
        while (i < bArr.length && bArr[i] != 10) {
            i++;
        }
        return i < bArr.length ? i + 1 : i;
    }

    private static int parseLibCount(byte[] bArr, int i, int i2) {
        try {
            return Integer.parseInt(new String(bArr, i, i2));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    static boolean processDepsBytes(byte[] bArr, byte[] bArr2) throws IOException {
        int iVerifyBytesAndGetOffset;
        int libCount;
        if (bArr != null) {
            iVerifyBytesAndGetOffset = verifyBytesAndGetOffset(bArr, bArr2);
            if (iVerifyBytesAndGetOffset == -1) {
                return false;
            }
        } else {
            iVerifyBytesAndGetOffset = 0;
        }
        int iFindNextLine = findNextLine(bArr2, iVerifyBytesAndGetOffset);
        if (iFindNextLine >= bArr2.length || (libCount = parseLibCount(bArr2, iVerifyBytesAndGetOffset, (iFindNextLine - iVerifyBytesAndGetOffset) - 1)) <= 0) {
            return false;
        }
        sPrecomputedDeps = new HashMap(((int) (libCount / 1.0f)) + 1, 1.0f);
        sPrecomputedLibs = new ArrayList(libCount);
        indexDepsBytes(bArr2, iFindNextLine);
        if (sPrecomputedLibs.size() != libCount) {
            return false;
        }
        sEncodedDeps = bArr2;
        sInitialized = true;
        return true;
    }

    private static boolean libIsAtOffset(String str, int i) {
        int i2;
        int i3 = LIB_PREFIX_LEN;
        while (true) {
            int length = str.length();
            i2 = LIB_SUFFIX_LEN;
            if (i3 >= length - i2 || i >= sEncodedDeps.length || (str.codePointAt(i3) & 255) != sEncodedDeps[i]) {
                break;
            }
            i3++;
            i++;
        }
        return i3 == str.length() - i2;
    }

    private static int hashLib(String str) {
        int iCodePointAt = INITIAL_HASH;
        for (int i = LIB_PREFIX_LEN; i < str.length() - LIB_SUFFIX_LEN; i++) {
            iCodePointAt = str.codePointAt(i) + (iCodePointAt << 5) + iCodePointAt;
        }
        return iCodePointAt;
    }

    private static int getOffsetForLib(String str) {
        List<Integer> list = sPrecomputedDeps.get(Integer.valueOf(hashLib(str)));
        if (list == null) {
            return -1;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (libIsAtOffset(str, iIntValue)) {
                return iIntValue;
            }
        }
        return -1;
    }

    @Nullable
    private static String getLibString(int i) {
        if (i >= sPrecomputedLibs.size()) {
            return null;
        }
        int iIntValue = sPrecomputedLibs.get(i).intValue();
        int i2 = iIntValue;
        while (true) {
            byte[] bArr = sEncodedDeps;
            if (i2 >= bArr.length || bArr[i2] <= 32) {
                break;
            }
            i2++;
        }
        int i3 = (i2 - iIntValue) + LIB_PREFIX_SUFFIX_LEN;
        char[] cArr = new char[i3];
        cArr[0] = 'l';
        cArr[1] = 'i';
        cArr[2] = 'b';
        for (int i4 = 0; i4 < i3 - LIB_PREFIX_SUFFIX_LEN; i4++) {
            cArr[LIB_PREFIX_LEN + i4] = (char) sEncodedDeps[iIntValue + i4];
        }
        cArr[i3 - 3] = FilenameUtils.EXTENSION_SEPARATOR;
        cArr[i3 - 2] = 's';
        cArr[i3 - 1] = 'o';
        return new String(cArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x003e, code lost:
    
        if (r2 == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
    
        r6 = getLibString(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
    
        if (r6 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0047, code lost:
    
        r0.add(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004e, code lost:
    
        if (r0.isEmpty() == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0050, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005d, code lost:
    
        return (java.lang.String[]) r0.toArray(new java.lang.String[r0.size()]);
     */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String[] getDepsForLibAtOffset(int r6, int r7) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r6 = r6 + r7
            int r7 = com.facebook.soloader.NativeDeps.LIB_PREFIX_SUFFIX_LEN
            int r6 = r6 - r7
            r7 = 0
            r1 = r7
            r2 = r1
        Lc:
            byte[] r3 = com.facebook.soloader.NativeDeps.sEncodedDeps
            int r4 = r3.length
            r5 = 0
            if (r6 >= r4) goto L3e
            r3 = r3[r6]
            r4 = 10
            if (r3 == r4) goto L3e
            r4 = 32
            if (r3 != r4) goto L2b
            if (r2 == 0) goto L3a
            java.lang.String r1 = getLibString(r1)
            if (r1 != 0) goto L25
            return r5
        L25:
            r0.add(r1)
            r1 = r7
            r2 = r1
            goto L3a
        L2b:
            r2 = 48
            if (r3 < r2) goto L3d
            r2 = 57
            if (r3 <= r2) goto L34
            goto L3d
        L34:
            int r1 = r1 * 10
            int r3 = r3 + (-48)
            int r1 = r1 + r3
            r2 = 1
        L3a:
            int r6 = r6 + 1
            goto Lc
        L3d:
            return r5
        L3e:
            if (r2 == 0) goto L4a
            java.lang.String r6 = getLibString(r1)
            if (r6 != 0) goto L47
            return r5
        L47:
            r0.add(r6)
        L4a:
            boolean r6 = r0.isEmpty()
            if (r6 == 0) goto L51
            return r5
        L51:
            int r6 = r0.size()
            java.lang.String[] r6 = new java.lang.String[r6]
            java.lang.Object[] r6 = r0.toArray(r6)
            java.lang.String[] r6 = (java.lang.String[]) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.NativeDeps.getDepsForLibAtOffset(int, int):java.lang.String[]");
    }

    @Nullable
    static String[] tryGetDepsFromPrecomputedDeps(String str) {
        int offsetForLib;
        if (sInitialized && str.length() > LIB_PREFIX_SUFFIX_LEN && (offsetForLib = getOffsetForLib(str)) != -1) {
            return getDepsForLibAtOffset(offsetForLib, str.length());
        }
        return null;
    }

    private static void verifyUninitialized() {
        if (sInitialized) {
            synchronized (NativeDeps.class) {
                if (sInitialized) {
                    throw new IllegalStateException("Trying to initialize NativeDeps but it was already initialized");
                }
            }
        }
    }
}
