package com.facebook.soloader.recovery;

import android.content.Context;
import com.facebook.soloader.LogUtil;
import com.facebook.soloader.NoBaseApkException;
import com.facebook.soloader.SoSource;
import java.io.File;

/* loaded from: classes3.dex */
public class CheckBaseApkExists implements RecoveryStrategy {
    private static final String TAG = "soloader.recovery.CheckBaseApkExists";
    private final BaseApkPathHistory mBaseApkPathHistory;
    private final Context mContext;

    public CheckBaseApkExists(Context context, BaseApkPathHistory baseApkPathHistory) {
        this.mContext = context;
        this.mBaseApkPathHistory = baseApkPathHistory;
    }

    @Override // com.facebook.soloader.recovery.RecoveryStrategy
    public boolean recover(UnsatisfiedLinkError unsatisfiedLinkError, SoSource[] soSourceArr) {
        String str = this.mContext.getApplicationInfo().sourceDir;
        if (!new File(str).exists()) {
            StringBuilder sbAppend = new StringBuilder("Base apk does not exist: ").append(str).append(". ");
            this.mBaseApkPathHistory.report(sbAppend);
            throw new NoBaseApkException(sbAppend.toString(), unsatisfiedLinkError);
        }
        LogUtil.w(TAG, "Base apk exists: " + str);
        return false;
    }
}
