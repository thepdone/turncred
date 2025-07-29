package com.facebook.soloader;

import android.content.Context;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public class SoLoaderDSONotFoundError extends SoLoaderULError {
    public SoLoaderDSONotFoundError(String str) {
        super(str);
    }

    public SoLoaderDSONotFoundError(String str, String str2) {
        super(str, str2);
    }

    public static SoLoaderDSONotFoundError create(String str, @Nullable Context context, SoSource[] soSourceArr) {
        StringBuilder sbAppend = new StringBuilder("couldn't find DSO to load: ").append(str);
        sbAppend.append("\n\texisting SO sources: ");
        for (int i = 0; i < soSourceArr.length; i++) {
            sbAppend.append("\n\t\tSoSource ").append(i).append(": ").append(soSourceArr[i].toString());
        }
        if (context != null) {
            sbAppend.append("\n\tNative lib dir: ").append(context.getApplicationInfo().nativeLibraryDir).append("\n");
        }
        return new SoLoaderDSONotFoundError(str, sbAppend.toString());
    }
}
