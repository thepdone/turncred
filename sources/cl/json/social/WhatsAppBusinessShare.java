package cl.json.social;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;

/* loaded from: classes4.dex */
public class WhatsAppBusinessShare extends SingleShareIntent {
    private static final String PACKAGE = "com.whatsapp.w4b";
    private static final String PLAY_STORE_LINK = "market://details?id=com.whatsapp.w4b";
    private static final int START_ACTIVITY_TIME_GAP_MS = 10;
    private static final String START_CONVERSATION_CLASS = "com.whatsapp.Conversation";

    @Override // cl.json.social.ShareIntent
    protected String getDefaultWebLink() {
        return null;
    }

    public WhatsAppBusinessShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // cl.json.social.SingleShareIntent, cl.json.social.ShareIntent
    public void open(ReadableMap readableMap) throws InterruptedException, ActivityNotFoundException {
        super.open(readableMap);
        if (readableMap.hasKey("whatsAppNumber")) {
            try {
                getIntent().setComponent(new ComponentName(PACKAGE, START_CONVERSATION_CLASS));
                openIntentChooser();
                Thread.sleep(10L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        getIntent().setComponent(null);
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
