package cl.json.social;

import android.content.ActivityNotFoundException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;

/* loaded from: classes4.dex */
public class ViberShare extends SingleShareIntent {
    private static final String PACKAGE = "com.viber.voip";
    private static final String PLAY_STORE_LINK = "market://details?id=com.viber.voip";

    @Override // cl.json.social.ShareIntent
    protected String getDefaultWebLink() {
        return null;
    }

    public ViberShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // cl.json.social.SingleShareIntent, cl.json.social.ShareIntent
    public void open(ReadableMap readableMap) throws ActivityNotFoundException {
        super.open(readableMap);
        openIntentChooser();
    }

    @Override // cl.json.social.ShareIntent
    protected String getPackage() {
        return PACKAGE;
    }

    @Override // cl.json.social.ShareIntent
    protected String getPlayStoreLink() {
        return PLAY_STORE_LINK;
    }
}
