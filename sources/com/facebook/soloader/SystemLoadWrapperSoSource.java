package com.facebook.soloader;

import android.os.StrictMode;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public class SystemLoadWrapperSoSource extends SoSource {
    @Override // com.facebook.soloader.SoSource
    @Nullable
    public File unpackLibrary(String str) throws IOException {
        return null;
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        try {
            System.loadLibrary(str.substring("lib".length(), str.length() - ".so".length()));
            return 1;
        } catch (Exception e) {
            LogUtil.e(SoLoader.TAG, "Error loading library: " + str, e);
            return 0;
        }
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public String getLibraryPath(String str) throws NoSuchMethodException, SecurityException, IOException {
        String classLoaderLdLoadLibrary = SysUtil.getClassLoaderLdLoadLibrary();
        if (TextUtils.isEmpty(classLoaderLdLoadLibrary)) {
            return null;
        }
        for (String str2 : classLoaderLdLoadLibrary.split(":")) {
            if (SysUtil.isDisabledExtractNativeLibs(SoLoader.sApplicationContext) && str2.contains(".apk!")) {
                return str2 + File.separator + str;
            }
            File file = new File(str2, str);
            if (file.exists()) {
                return file.getCanonicalPath();
            }
        }
        return null;
    }

    @Override // com.facebook.soloader.SoSource
    public String getName() {
        return "SystemLoadWrapperSoSource";
    }

    @Override // com.facebook.soloader.SoSource
    public String toString() {
        return getName() + "[" + SysUtil.getClassLoaderLdLoadLibrary() + "]";
    }
}
