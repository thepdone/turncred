package com.facebook.soloader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Parcel;
import android.os.Process;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import com.facebook.soloader.MinElf;
import com.nimbusds.jose.jwk.JWKParameterNames;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.TreeSet;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public final class SysUtil {
    private static final long APK_DEP_BLOCK_METADATA_LENGTH = 20;
    private static final byte APK_SIGNATURE_VERSION = 1;
    private static final String TAG = "SysUtil";

    public static int findAbiScore(String[] strArr, String str) {
        for (int i = 0; i < strArr.length; i++) {
            String str2 = strArr[i];
            if (str2 != null && str.equals(str2)) {
                return i;
            }
        }
        return -1;
    }

    public static void deleteOrThrow(File file) throws IOException {
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.canWrite() && !parentFile.setWritable(true)) {
            LogUtil.e(TAG, "Enable write permission failed: " + parentFile);
        }
        if (!file.delete() && file.exists()) {
            throw new IOException("Could not delete file " + file);
        }
    }

    public static String[] getSupportedAbis() {
        return MarshmallowSysdeps.getSupportedAbis();
    }

    public static void fallocateIfSupported(FileDescriptor fileDescriptor, long j) throws IOException, ErrnoException {
        LollipopSysdeps.fallocateIfSupported(fileDescriptor, j);
    }

    public static void dumbDelete(File file) throws IOException {
        Stack stack = new Stack();
        stack.push(file);
        ArrayList arrayList = new ArrayList();
        while (!stack.isEmpty()) {
            File file2 = (File) stack.pop();
            if (!file2.isDirectory()) {
                deleteOrThrow(file2);
            } else {
                arrayList.add(file2);
                File[] fileArrListFiles = file2.listFiles();
                if (fileArrListFiles != null) {
                    for (File file3 : fileArrListFiles) {
                        stack.push(file3);
                    }
                }
            }
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            deleteOrThrow((File) arrayList.get(size));
        }
    }

    private static final class LollipopSysdeps {
        private LollipopSysdeps() {
        }

        public static String[] getSupportedAbis() {
            String[] strArr = Build.SUPPORTED_ABIS;
            TreeSet treeSet = new TreeSet();
            try {
                if (is64Bit()) {
                    treeSet.add(MinElf.ISA.AARCH64);
                    treeSet.add(MinElf.ISA.X86_64);
                } else {
                    treeSet.add(MinElf.ISA.ARM);
                    treeSet.add(MinElf.ISA.X86);
                }
                ArrayList arrayList = new ArrayList();
                for (String str : strArr) {
                    if (treeSet.contains(str)) {
                        arrayList.add(str);
                    }
                }
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            } catch (ErrnoException e) {
                LogUtil.e(SysUtil.TAG, String.format("Could not read /proc/self/exe. Falling back to default ABI list: %s. errno: %d Err msg: %s", Arrays.toString(strArr), Integer.valueOf(e.errno), e.getMessage()));
                return Build.SUPPORTED_ABIS;
            }
        }

        public static void fallocateIfSupported(FileDescriptor fileDescriptor, long j) throws IOException, ErrnoException {
            try {
                Os.posix_fallocate(fileDescriptor, 0L, j);
            } catch (ErrnoException e) {
                if (e.errno != OsConstants.EOPNOTSUPP && e.errno != OsConstants.ENOSYS && e.errno != OsConstants.EINVAL) {
                    throw new IOException(e.toString(), e);
                }
            }
        }

        public static boolean is64Bit() throws ErrnoException {
            return Os.readlink("/proc/self/exe").contains("64");
        }
    }

    private static final class MarshmallowSysdeps {
        private MarshmallowSysdeps() {
        }

        public static String[] getSupportedAbis() {
            String[] strArr = Build.SUPPORTED_ABIS;
            TreeSet treeSet = new TreeSet();
            if (is64Bit()) {
                treeSet.add(MinElf.ISA.AARCH64);
                treeSet.add(MinElf.ISA.X86_64);
            } else {
                treeSet.add(MinElf.ISA.ARM);
                treeSet.add(MinElf.ISA.X86);
            }
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                if (treeSet.contains(str)) {
                    arrayList.add(str);
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }

        public static boolean is64Bit() {
            return Process.is64Bit();
        }

        public static boolean isSupportedDirectLoad(@Nullable Context context, int i) {
            if (i == 2) {
                return true;
            }
            return isDisabledExtractNativeLibs(context);
        }

        public static boolean isDisabledExtractNativeLibs(@Nullable Context context) {
            return context != null && (context.getApplicationInfo().flags & 268435456) == 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x004b, code lost:
        
            if (r1.getMethod() != 0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
        
            r2 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
        
            r5.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
        
            return r2;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static boolean isApkUncompressedDso(android.content.Context r5) throws java.io.IOException {
            /*
                java.io.File r0 = new java.io.File
                android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo()
                java.lang.String r5 = r5.sourceDir
                r0.<init>(r5)
                java.util.zip.ZipFile r5 = new java.util.zip.ZipFile
                r5.<init>(r0)
                java.util.Enumeration r0 = r5.entries()     // Catch: java.lang.Throwable -> L56
            L14:
                boolean r1 = r0.hasMoreElements()     // Catch: java.lang.Throwable -> L56
                r2 = 0
                if (r1 == 0) goto L52
                java.lang.Object r1 = r0.nextElement()     // Catch: java.lang.Throwable -> L56
                java.util.zip.ZipEntry r1 = (java.util.zip.ZipEntry) r1     // Catch: java.lang.Throwable -> L56
                if (r1 == 0) goto L14
                java.lang.String r3 = r1.getName()     // Catch: java.lang.Throwable -> L56
                java.lang.String r4 = ".so"
                boolean r3 = r3.endsWith(r4)     // Catch: java.lang.Throwable -> L56
                if (r3 == 0) goto L14
                java.lang.String r3 = r1.getName()     // Catch: java.lang.Throwable -> L56
                java.lang.String r4 = "/lib"
                boolean r3 = r3.contains(r4)     // Catch: java.lang.Throwable -> L56
                if (r3 == 0) goto L14
                java.lang.String r3 = r1.getName()     // Catch: java.lang.Throwable -> L56
                java.lang.String r4 = "assets/"
                boolean r3 = r3.startsWith(r4)     // Catch: java.lang.Throwable -> L56
                if (r3 != 0) goto L14
                int r0 = r1.getMethod()     // Catch: java.lang.Throwable -> L56
                if (r0 != 0) goto L4e
                r2 = 1
            L4e:
                r5.close()
                return r2
            L52:
                r5.close()
                return r2
            L56:
                r0 = move-exception
                r5.close()     // Catch: java.lang.Throwable -> L5b
                goto L5f
            L5b:
                r5 = move-exception
                r0.addSuppressed(r5)
            L5f:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SysUtil.MarshmallowSysdeps.isApkUncompressedDso(android.content.Context):boolean");
        }
    }

    public static void mkdirOrThrow(File file) throws IOException {
        if (!file.mkdirs() && !file.isDirectory()) {
            throw new IOException("cannot mkdir: " + file);
        }
    }

    static int copyBytes(RandomAccessFile randomAccessFile, InputStream inputStream, int i, byte[] bArr) throws IOException {
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, 0, Math.min(bArr.length, i - i2));
            if (i3 == -1) {
                break;
            }
            randomAccessFile.write(bArr, 0, i3);
            i2 += i3;
        }
        return i2;
    }

    public static void fsyncAll(File file) throws IOException {
        Stack stack = new Stack();
        stack.push(file);
        while (!stack.isEmpty()) {
            File file2 = (File) stack.pop();
            if (file2.isDirectory()) {
                File[] fileArrListFiles = file2.listFiles();
                if (fileArrListFiles == null) {
                    throw new IOException("cannot list directory " + file2);
                }
                for (File file3 : fileArrListFiles) {
                    stack.push(file3);
                }
            } else if (file2.getPath().endsWith("_lock")) {
                continue;
            } else {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file2, JWKParameterNames.RSA_OTHER_PRIMES__PRIME_FACTOR);
                    try {
                        randomAccessFile.getFD().sync();
                        randomAccessFile.close();
                    } catch (Throwable th) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (IOException e) {
                    LogUtil.e(TAG, "Syncing failed for " + file2 + ": " + e.getMessage());
                }
            }
        }
    }

    private static long getParcelPadSize(long j) {
        return j + ((4 - (j % 4)) % 4);
    }

    public static long getApkDepBlockLength(File file) throws IOException {
        return getParcelPadSize((file.getCanonicalFile().getPath().length() + 1) * 2) + 20;
    }

    public static byte[] makeApkDepBlock(File file, Context context) throws IOException {
        File canonicalFile = file.getCanonicalFile();
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeByte((byte) 1);
            parcelObtain.writeString(canonicalFile.getPath());
            parcelObtain.writeLong(canonicalFile.lastModified());
            parcelObtain.writeInt(getAppVersionCode(context));
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    public static int getAppVersionCode(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                return packageManager.getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            }
        }
        return 0;
    }

    public static boolean is64Bit() {
        return MarshmallowSysdeps.is64Bit();
    }

    public static boolean isSupportedDirectLoad(@Nullable Context context, int i) {
        return MarshmallowSysdeps.isSupportedDirectLoad(context, i);
    }

    public static boolean isDisabledExtractNativeLibs(Context context) {
        return MarshmallowSysdeps.isDisabledExtractNativeLibs(context);
    }

    @Nullable
    public static FileLocker getOrCreateLockOnDir(File file, File file2) throws Throwable {
        boolean z;
        try {
            return getFileLocker(file2);
        } catch (FileNotFoundException e) {
            z = true;
            try {
                if (!file.setWritable(true)) {
                    throw e;
                }
                FileLocker fileLocker = getFileLocker(file2);
                if (!file.setWritable(false)) {
                    LogUtil.w(TAG, "error removing " + file.getCanonicalPath() + " write permission");
                }
                return fileLocker;
            } catch (Throwable th) {
                th = th;
                if (z && !file.setWritable(false)) {
                    LogUtil.w(TAG, "error removing " + file.getCanonicalPath() + " write permission");
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
            if (z) {
                LogUtil.w(TAG, "error removing " + file.getCanonicalPath() + " write permission");
            }
            throw th;
        }
    }

    public static FileLocker getFileLocker(File file) throws IOException {
        return FileLocker.lock(file);
    }

    public static String getBaseName(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf > 0 ? str.substring(0, iLastIndexOf) : str;
    }

    @Nullable
    public static String makeNonZipPath(@Nullable String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(":");
        ArrayList arrayList = new ArrayList(strArrSplit.length);
        for (String str2 : strArrSplit) {
            if (!str2.contains("!")) {
                arrayList.add(str2);
            }
        }
        return TextUtils.join(":", arrayList);
    }

    @Nullable
    public static String getClassLoaderLdLoadLibrary() throws NoSuchMethodException, SecurityException {
        ClassLoader classLoader = SoLoader.class.getClassLoader();
        if (classLoader != null && !(classLoader instanceof BaseDexClassLoader)) {
            throw new IllegalStateException("ClassLoader " + classLoader.getClass().getName() + " should be of type BaseDexClassLoader");
        }
        try {
            return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke((BaseDexClassLoader) classLoader, new Object[0]);
        } catch (Exception e) {
            LogUtil.e(TAG, "Cannot call getLdLibraryPath", e);
            return null;
        }
    }

    @Nullable
    public static Method getNativeLoadRuntimeMethod() throws NoSuchMethodException, SecurityException {
        if (Build.VERSION.SDK_INT > 27) {
            return null;
        }
        try {
            Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", String.class, ClassLoader.class, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception e) {
            LogUtil.w(TAG, "Cannot get nativeLoad method", e);
            return null;
        }
    }
}
