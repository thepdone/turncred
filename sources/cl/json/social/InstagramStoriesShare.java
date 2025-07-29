package cl.json.social;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import cl.json.ShareFile;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.share.internal.ShareConstants;

/* loaded from: classes4.dex */
public class InstagramStoriesShare extends SingleShareIntent {
    private static final String PACKAGE = "com.instagram.android";
    private static final String PLAY_STORE_LINK = "https://play.google.com/store/apps/details?id=com.instagram.android";

    @Override // cl.json.social.ShareIntent
    protected String getDefaultWebLink() {
        return null;
    }

    public InstagramStoriesShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        setIntent(new Intent("com.instagram.share.ADD_TO_STORY"));
    }

    @Override // cl.json.social.SingleShareIntent, cl.json.social.ShareIntent
    public void open(ReadableMap readableMap) throws ActivityNotFoundException {
        super.open(readableMap);
        shareStory(readableMap);
        openIntentChooser(readableMap);
    }

    @Override // cl.json.social.ShareIntent
    protected String getPackage() {
        return PACKAGE;
    }

    @Override // cl.json.social.ShareIntent
    protected String getPlayStoreLink() {
        return PLAY_STORE_LINK;
    }

    private void shareStory(ReadableMap readableMap) {
        String string;
        String string2;
        String str;
        if (!hasValidKey("backgroundImage", readableMap) && !hasValidKey("backgroundVideo", readableMap) && !hasValidKey("stickerImage", readableMap)) {
            throw new IllegalArgumentException("Invalid background or sticker assets provided.");
        }
        Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity == null) {
            TargetChosenReceiver.callbackReject("Something went wrong");
            return;
        }
        this.intent.putExtra("source_application", readableMap.getString("appId"));
        this.intent.putExtra("bottom_background_color", "#906df4");
        this.intent.putExtra("top_background_color", "#837DF4");
        if (hasValidKey("attributionURL", readableMap)) {
            this.intent.putExtra(ShareConstants.STORY_DEEP_LINK_URL, readableMap.getString("attributionURL"));
        }
        if (hasValidKey("backgroundTopColor", readableMap)) {
            this.intent.putExtra("top_background_color", readableMap.getString("backgroundTopColor"));
        }
        if (hasValidKey("backgroundBottomColor", readableMap)) {
            this.intent.putExtra("bottom_background_color", readableMap.getString("backgroundBottomColor"));
        }
        boolean zValueOf = false;
        if (hasValidKey("useInternalStorage", readableMap)) {
            zValueOf = Boolean.valueOf(readableMap.getBoolean("useInternalStorage"));
        }
        if (hasValidKey("linkUrl", readableMap)) {
            this.intent.putExtra("link_url", readableMap.getString("linkUrl"));
        }
        if (hasValidKey("linkText", readableMap)) {
            this.intent.putExtra("link_text", readableMap.getString("linkText"));
        }
        Boolean boolValueOf = Boolean.valueOf(hasValidKey("backgroundImage", readableMap) || hasValidKey("backgroundVideo", readableMap));
        if (boolValueOf.booleanValue()) {
            if (hasValidKey("backgroundImage", readableMap)) {
                string = readableMap.getString("backgroundImage");
            } else if (!hasValidKey("backgroundVideo", readableMap)) {
                string = "";
            } else {
                string2 = readableMap.getString("backgroundVideo");
                str = "video/*";
                ShareFile shareFile = new ShareFile(string2, str, AppStateModule.APP_STATE_BACKGROUND, zValueOf, this.reactContext);
                this.intent.setDataAndType(shareFile.getURI(), shareFile.getType());
                this.intent.setFlags(1);
            }
            str = "image/jpeg";
            string2 = string;
            ShareFile shareFile2 = new ShareFile(string2, str, AppStateModule.APP_STATE_BACKGROUND, zValueOf, this.reactContext);
            this.intent.setDataAndType(shareFile2.getURI(), shareFile2.getType());
            this.intent.setFlags(1);
        }
        if (hasValidKey("stickerImage", readableMap)) {
            ShareFile shareFile3 = new ShareFile(readableMap.getString("stickerImage"), "image/png", "sticker", zValueOf, this.reactContext);
            if (!boolValueOf.booleanValue()) {
                this.intent.setType("image/*");
            }
            this.intent.putExtra(ShareConstants.STORY_INTERACTIVE_ASSET_URI, shareFile3.getURI());
            currentActivity.grantUriPermission(PACKAGE, shareFile3.getURI(), 1);
        }
    }
}
