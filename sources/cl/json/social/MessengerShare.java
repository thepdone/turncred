package cl.json.social;

import android.content.ActivityNotFoundException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;

/* loaded from: classes4.dex */
public class MessengerShare extends SingleShareIntent {
    private static final String PACKAGE = "com.facebook.orca";
    private static final String PLAY_STORE_LINK = "market://details?id=com.facebook.orca";

    @Override // cl.json.social.ShareIntent
    protected String getDefaultWebLink() {
        return null;
    }

    public MessengerShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // cl.json.social.SingleShareIntent, cl.json.social.ShareIntent
    public void open(ReadableMap readableMap) throws ActivityNotFoundException {
        super.open(readableMap);
        openIntentChooser();
    }

    @Override // cl.json.social.ShareIntent
    protected String getPackage() {
        return "com.facebook.orca";
    }

    @Override // cl.json.social.ShareIntent
    protected String getPlayStoreLink() {
        return PLAY_STORE_LINK;
    }
}
