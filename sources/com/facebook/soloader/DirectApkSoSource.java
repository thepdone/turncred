package com.facebook.soloader;

import android.content.Context;
import android.os.StrictMode;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public class DirectApkSoSource extends SoSource implements RecoverableSoSource {
    private final Set<String> mDirectApkLdPaths;
    private final Map<String, Set<String>> mLibsInApkCache = new HashMap();
    private final Map<String, Set<String>> mDepsCache = new HashMap();

    public DirectApkSoSource(Context context) {
        this.mDirectApkLdPaths = getDirectApkLdPaths(context);
    }

    public DirectApkSoSource(Set<String> set) {
        this.mDirectApkLdPaths = set;
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        if (SoLoader.sSoFileLoader == null) {
            throw new IllegalStateException("SoLoader.init() not yet called");
        }
        for (String str2 : this.mDirectApkLdPaths) {
            Set<String> set = this.mLibsInApkCache.get(str2);
            if (TextUtils.isEmpty(str2) || set == null || !set.contains(str)) {
                LogUtil.v(SoLoader.TAG, str + " not found on " + str2);
            } else {
                loadDependencies(str2, str, i, threadPolicy);
                try {
                    i |= 4;
                    SoLoader.sSoFileLoader.load(str2 + File.separator + str, i);
                    LogUtil.d(SoLoader.TAG, str + " found on " + str2);
                    return 1;
                } catch (UnsatisfiedLinkError e) {
                    LogUtil.w(SoLoader.TAG, str + " not found on " + str2 + " flag: " + i, e);
                }
            }
        }
        return 0;
    }

    @Override // com.facebook.soloader.SoSource
    public File unpackLibrary(String str) throws IOException {
        throw new UnsupportedOperationException("DirectAPKSoSource doesn't support unpackLibrary");
    }

    public boolean isValid() {
        return !this.mDirectApkLdPaths.isEmpty();
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public String getLibraryPath(String str) throws IOException {
        for (String str2 : this.mDirectApkLdPaths) {
            Set<String> set = this.mLibsInApkCache.get(str2);
            if (!TextUtils.isEmpty(str2) && set != null && set.contains(str)) {
                return str2 + File.separator + str;
            }
        }
        return null;
    }

    static Set<String> getDirectApkLdPaths(Context context) {
        HashSet hashSet = new HashSet();
        String fallbackApkLdPath = getFallbackApkLdPath(context.getApplicationInfo().sourceDir);
        if (fallbackApkLdPath != null) {
            hashSet.add(fallbackApkLdPath);
        }
        if (context.getApplicationInfo().splitSourceDirs != null) {
            for (String str : context.getApplicationInfo().splitSourceDirs) {
                String fallbackApkLdPath2 = getFallbackApkLdPath(str);
                if (fallbackApkLdPath2 != null) {
                    hashSet.add(fallbackApkLdPath2);
                }
            }
        }
        return hashSet;
    }

    @Nullable
    private static String getFallbackApkLdPath(String str) {
        String[] supportedAbis = SysUtil.getSupportedAbis();
        if (str == null || str.isEmpty()) {
            LogUtil.w(SoLoader.TAG, "Cannot compute fallback path, apk path is ".concat(str != null ? "empty" : "null"));
            return null;
        }
        if (supportedAbis == null || supportedAbis.length == 0) {
            LogUtil.w(SoLoader.TAG, "Cannot compute fallback path, supportedAbis is ".concat(supportedAbis != null ? "empty" : "null"));
            return null;
        }
        return str + "!/lib/" + supportedAbis[0];
    }

    private void loadDependencies(String str, String str2, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        Set<String> depsFromCache = getDepsFromCache(str, str2);
        if (depsFromCache == null) {
            buildLibDepsCache(str, str2);
            depsFromCache = getDepsFromCache(str, str2);
        }
        if (depsFromCache != null) {
            Iterator<String> it = depsFromCache.iterator();
            while (it.hasNext()) {
                SoLoader.loadDependency(it.next(), i, threadPolicy);
            }
        }
    }

    @Override // com.facebook.soloader.SoSource
    protected void prepare(int i) throws IOException {
        prepare();
    }

    private void prepare() throws IOException {
        int iIndexOf;
        int i;
        for (String str : this.mDirectApkLdPaths) {
            String strSubstring = (TextUtils.isEmpty(str) || (iIndexOf = str.indexOf(33)) < 0 || (i = iIndexOf + 2) >= str.length()) ? null : str.substring(i);
            if (!TextUtils.isEmpty(strSubstring)) {
                ZipFile zipFile = new ZipFile(getApkPathFromLdPath(str));
                try {
                    Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                    while (enumerationEntries.hasMoreElements()) {
                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        if (zipEntryNextElement != null && zipEntryNextElement.getMethod() == 0 && zipEntryNextElement.getName().startsWith(strSubstring) && zipEntryNextElement.getName().endsWith(".so")) {
                            appendLibsInApkCache(str, zipEntryNextElement.getName().substring(strSubstring.length() + 1));
                        }
                    }
                    zipFile.close();
                } catch (Throwable th) {
                    try {
                        zipFile.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        }
    }

    private void buildLibDepsCache(String str, String str2) throws IOException {
        String apkPathFromLdPath = getApkPathFromLdPath(str);
        ZipFile zipFile = new ZipFile(apkPathFromLdPath);
        try {
            String libraryPathInApk = getLibraryPathInApk(str, str2);
            ZipEntry entry = zipFile.getEntry(libraryPathInApk);
            if (entry == null) {
                LogUtil.e(SoLoader.TAG, libraryPathInApk + " not found in " + apkPathFromLdPath);
                zipFile.close();
            } else {
                buildLibDepsCacheImpl(str, zipFile, entry, str2);
                zipFile.close();
            }
        } catch (Throwable th) {
            try {
                zipFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private void buildLibDepsCacheImpl(String str, ZipFile zipFile, ZipEntry zipEntry, String str2) throws IOException {
        ElfZipFileChannel elfZipFileChannel = new ElfZipFileChannel(zipFile, zipEntry);
        try {
            for (String str3 : NativeDeps.getDependencies(str2, elfZipFileChannel)) {
                if (!str3.startsWith("/")) {
                    appendDepsCache(str, str2, str3);
                }
            }
            elfZipFileChannel.close();
        } catch (Throwable th) {
            try {
                elfZipFileChannel.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // com.facebook.soloader.SoSource
    public String getName() {
        return "DirectApkSoSource";
    }

    @Override // com.facebook.soloader.SoSource
    public String toString() {
        return getName() + "[root = " + this.mDirectApkLdPaths.toString() + ']';
    }

    private void appendLibsInApkCache(String str, String str2) {
        synchronized (this.mLibsInApkCache) {
            if (!this.mLibsInApkCache.containsKey(str)) {
                this.mLibsInApkCache.put(str, new HashSet());
            }
            this.mLibsInApkCache.get(str).add(str2);
        }
    }

    private void appendDepsCache(String str, String str2, String str3) {
        synchronized (this.mDepsCache) {
            String str4 = str + str2;
            if (!this.mDepsCache.containsKey(str4)) {
                this.mDepsCache.put(str4, new HashSet());
            }
            this.mDepsCache.get(str4).add(str3);
        }
    }

    @Nullable
    private Set<String> getDepsFromCache(String str, String str2) {
        Set<String> set;
        synchronized (this.mDepsCache) {
            set = this.mDepsCache.get(str + str2);
        }
        return set;
    }

    private static String getApkPathFromLdPath(String str) {
        return str.substring(0, str.indexOf(33));
    }

    private static String getLibraryPathInApk(String str, String str2) {
        return str.substring(str.indexOf(33) + 2) + File.separator + str2;
    }

    @Override // com.facebook.soloader.RecoverableSoSource
    public SoSource recover(Context context) {
        DirectApkSoSource directApkSoSource = new DirectApkSoSource(context);
        try {
            directApkSoSource.prepare();
            return directApkSoSource;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
