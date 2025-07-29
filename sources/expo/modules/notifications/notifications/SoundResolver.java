package expo.modules.notifications.notifications;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import com.facebook.common.util.UriUtil;

/* loaded from: classes5.dex */
public class SoundResolver {
    private Context mContext;

    public SoundResolver(Context context) {
        this.mContext = context;
    }

    public Uri resolve(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String packageName = this.mContext.getPackageName();
        String strFilenameToBasename = filenameToBasename(str);
        if (this.mContext.getResources().getIdentifier(strFilenameToBasename, "raw", packageName) != 0) {
            return new Uri.Builder().scheme(UriUtil.QUALIFIED_RESOURCE_SCHEME).authority(packageName).appendPath("raw").appendPath(strFilenameToBasename).build();
        }
        return Settings.System.DEFAULT_NOTIFICATION_URI;
    }

    private String filenameToBasename(String str) {
        return !str.contains(".") ? str : str.substring(0, str.lastIndexOf(46));
    }
}
