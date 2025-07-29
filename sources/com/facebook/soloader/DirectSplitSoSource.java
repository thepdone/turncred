package com.facebook.soloader;

import android.os.StrictMode;
import com.facebook.hermes.intl.Constants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public class DirectSplitSoSource extends SoSource {
    protected final String mSplitName;

    @Nullable
    protected Manifest mManifest = null;

    @Nullable
    protected Set<String> mLibs = null;

    public DirectSplitSoSource(String str) {
        this.mSplitName = str;
    }

    Manifest getManifest() {
        Manifest manifest = this.mManifest;
        if (manifest != null) {
            return manifest;
        }
        throw new IllegalStateException("prepare not called");
    }

    @Override // com.facebook.soloader.SoSource
    protected void prepare(int i) throws IOException {
        InputStream inputStreamOpen = SoLoader.sApplicationContext.getAssets().open(this.mSplitName + ".soloader-manifest");
        try {
            this.mManifest = Manifest.read(inputStreamOpen);
            if (inputStreamOpen != null) {
                inputStreamOpen.close();
            }
            this.mLibs = new HashSet(this.mManifest.libs);
        } catch (Throwable th) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        Set<String> set = this.mLibs;
        if (set == null) {
            throw new IllegalStateException("prepare not called");
        }
        if (set.contains(str)) {
            return loadLibraryImpl(str, i);
        }
        return 0;
    }

    protected int loadLibraryImpl(String str, int i) {
        String libraryPath = getLibraryPath(str);
        libraryPath.getClass();
        System.load(libraryPath);
        return 1;
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public File unpackLibrary(String str) {
        return getSoFileByName(str);
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    protected File getSoFileByName(String str) {
        String libraryPath = getLibraryPath(str);
        if (libraryPath == null) {
            return null;
        }
        return new File(libraryPath);
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public String getLibraryPath(String str) {
        Set<String> set = this.mLibs;
        if (set == null || this.mManifest == null) {
            throw new IllegalStateException("prepare not called");
        }
        if (set.contains(str)) {
            return getSplitPath(this.mSplitName) + "!/lib/" + this.mManifest.arch + "/" + str;
        }
        return null;
    }

    static String getSplitPath(String str) {
        if (Constants.SENSITIVITY_BASE.equals(str)) {
            return SoLoader.sApplicationContext.getApplicationInfo().sourceDir;
        }
        String[] strArr = SoLoader.sApplicationContext.getApplicationInfo().splitSourceDirs;
        if (strArr == null) {
            throw new IllegalStateException("No splits avaiable");
        }
        String str2 = "split_" + str + ".apk";
        for (String str3 : strArr) {
            if (str3.endsWith(str2)) {
                return str3;
            }
        }
        throw new IllegalStateException("Could not find " + str + " split");
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public String[] getLibraryDependencies(String str) {
        Set<String> set = this.mLibs;
        if (set == null) {
            throw new IllegalStateException("prepare not called");
        }
        if (set.contains(str)) {
            return new String[0];
        }
        return null;
    }

    @Override // com.facebook.soloader.SoSource
    public String[] getSoSourceAbis() {
        Manifest manifest = this.mManifest;
        if (manifest == null) {
            throw new IllegalStateException("prepare not called");
        }
        return new String[]{manifest.arch};
    }

    @Override // com.facebook.soloader.SoSource
    public String getName() {
        return "DirectSplitSoSource";
    }
}
