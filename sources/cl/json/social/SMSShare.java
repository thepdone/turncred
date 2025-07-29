package cl.json.social;

import android.content.ActivityNotFoundException;
import android.provider.Telephony;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;

/* loaded from: classes4.dex */
public class SMSShare extends SingleShareIntent {
    private static final String PACKAGE = "com.android.mms";
    private static final String PLAY_STORE_LINK = "market://details?id=com.android.mms";
    private ReactApplicationContext reactContext;

    @Override // cl.json.social.ShareIntent
    protected String getDefaultWebLink() {
        return null;
    }

    public SMSShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @Override // cl.json.social.SingleShareIntent, cl.json.social.ShareIntent
    public void open(ReadableMap readableMap) throws ActivityNotFoundException {
        super.open(readableMap);
        openIntentChooser();
    }

    @Override // cl.json.social.ShareIntent
    protected String getPackage() {
        return Telephony.Sms.getDefaultSmsPackage(this.reactContext);
    }

    @Override // cl.json.social.ShareIntent
    protected String getPlayStoreLink() {
        return PLAY_STORE_LINK;
    }
}
