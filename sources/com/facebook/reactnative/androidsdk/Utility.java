package com.facebook.reactnative.androidsdk;

import android.net.Uri;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.Profile;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes3.dex */
public final class Utility {
    public static AccessToken buildAccessToken(ReadableMap readableMap) {
        String string = readableMap.getString(SDKConstants.PARAM_ACCESS_TOKEN);
        String string2 = readableMap.getString("applicationID");
        String string3 = readableMap.getString(SDKConstants.PARAM_USER_ID);
        Date date = null;
        List<String> listReactArrayToStringList = (!readableMap.hasKey("permissions") || readableMap.isNull("permissions")) ? null : reactArrayToStringList(readableMap.getArray("permissions"));
        List<String> listReactArrayToStringList2 = (!readableMap.hasKey(SDKConstants.PARAM_DECLINED_PERMISSIONS) || readableMap.isNull(SDKConstants.PARAM_DECLINED_PERMISSIONS)) ? null : reactArrayToStringList(readableMap.getArray(SDKConstants.PARAM_DECLINED_PERMISSIONS));
        List<String> listReactArrayToStringList3 = (!readableMap.hasKey(SDKConstants.PARAM_EXPIRED_PERMISSIONS) || readableMap.isNull(SDKConstants.PARAM_EXPIRED_PERMISSIONS)) ? null : reactArrayToStringList(readableMap.getArray(SDKConstants.PARAM_EXPIRED_PERMISSIONS));
        AccessTokenSource accessTokenSourceValueOf = (!readableMap.hasKey(SDKConstants.PARAM_ACCESS_TOKEN_SOURCE) || readableMap.isNull(SDKConstants.PARAM_ACCESS_TOKEN_SOURCE)) ? null : AccessTokenSource.valueOf(readableMap.getString(SDKConstants.PARAM_ACCESS_TOKEN_SOURCE));
        Date date2 = (!readableMap.hasKey(SDKConstants.PARAM_EXPIRATION_TIME) || readableMap.isNull(SDKConstants.PARAM_EXPIRATION_TIME)) ? null : new Date((long) readableMap.getDouble(SDKConstants.PARAM_EXPIRATION_TIME));
        Date date3 = (!readableMap.hasKey(SDKConstants.PARAM_LAST_REFRESH_TIME) || readableMap.isNull(SDKConstants.PARAM_LAST_REFRESH_TIME)) ? null : new Date((long) readableMap.getDouble(SDKConstants.PARAM_LAST_REFRESH_TIME));
        if (readableMap.hasKey(SDKConstants.PARAM_DATA_ACCESS_EXPIRATION_TIME) && !readableMap.isNull(SDKConstants.PARAM_DATA_ACCESS_EXPIRATION_TIME)) {
            date = new Date((long) readableMap.getDouble(SDKConstants.PARAM_DATA_ACCESS_EXPIRATION_TIME));
        }
        return new AccessToken(string, string2, string3, listReactArrayToStringList, listReactArrayToStringList2, listReactArrayToStringList3, accessTokenSourceValueOf, date2, date3, date);
    }

    public static WritableMap accessTokenToReactMap(AccessToken accessToken) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(SDKConstants.PARAM_ACCESS_TOKEN, accessToken.getToken());
        writableMapCreateMap.putString("applicationID", accessToken.getApplicationId());
        writableMapCreateMap.putString(SDKConstants.PARAM_USER_ID, accessToken.getUserId());
        writableMapCreateMap.putArray("permissions", Arguments.fromJavaArgs(setToStringArray(accessToken.getPermissions())));
        writableMapCreateMap.putArray(SDKConstants.PARAM_DECLINED_PERMISSIONS, Arguments.fromJavaArgs(setToStringArray(accessToken.getDeclinedPermissions())));
        writableMapCreateMap.putArray(SDKConstants.PARAM_EXPIRED_PERMISSIONS, Arguments.fromJavaArgs(setToStringArray(accessToken.getExpiredPermissions())));
        writableMapCreateMap.putString(SDKConstants.PARAM_ACCESS_TOKEN_SOURCE, accessToken.getSource().name());
        writableMapCreateMap.putDouble(SDKConstants.PARAM_EXPIRATION_TIME, accessToken.getExpires().getTime());
        writableMapCreateMap.putDouble(SDKConstants.PARAM_LAST_REFRESH_TIME, accessToken.getLastRefresh().getTime());
        writableMapCreateMap.putDouble(SDKConstants.PARAM_DATA_ACCESS_EXPIRATION_TIME, accessToken.getDataAccessExpirationTime().getTime());
        return writableMapCreateMap;
    }

    public static WritableMap profileToReactMap(Profile profile) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        putStringOrNull(writableMapCreateMap, "name", profile.getName());
        putStringOrNull(writableMapCreateMap, "firstName", profile.getFirstName());
        putStringOrNull(writableMapCreateMap, "lastName", profile.getLastName());
        putStringOrNull(writableMapCreateMap, "middleName", profile.getMiddleName());
        putStringOrNull(writableMapCreateMap, "imageURL", profile.getProfilePictureUri(100, 100).toString());
        putStringOrNull(writableMapCreateMap, "linkURL", profile.getLinkUri().toString());
        putStringOrNull(writableMapCreateMap, SDKConstants.PARAM_USER_ID, profile.getId());
        return writableMapCreateMap;
    }

    public static ShareContent buildShareContent(ReadableMap readableMap) {
        if (readableMap != null) {
            String string = readableMap.getString(NotificationsChannelSerializer.AUDIO_ATTRIBUTES_CONTENT_TYPE_KEY);
            if (string.equals("link")) {
                return buildShareLinkContent(readableMap);
            }
            if (string.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO)) {
                return buildSharePhotoContent(readableMap);
            }
            if (string.equals("video")) {
                return buildShareVideoContent(readableMap);
            }
        }
        return null;
    }

    public static GameRequestContent buildGameRequestContent(ReadableMap readableMap) {
        GameRequestContent.Builder builder = new GameRequestContent.Builder();
        String valueOrNull = getValueOrNull(readableMap, SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE);
        if (valueOrNull != null) {
            builder.setActionType(GameRequestContent.ActionType.valueOf(valueOrNull.toUpperCase(Locale.ROOT)));
        }
        String valueOrNull2 = getValueOrNull(readableMap, "filters");
        if (valueOrNull2 != null) {
            builder.setFilters(GameRequestContent.Filters.valueOf(valueOrNull2.toUpperCase(Locale.ROOT)));
        }
        builder.setMessage(readableMap.getString("message"));
        if (readableMap.hasKey("recipients")) {
            builder.setRecipients(reactArrayToStringList(readableMap.getArray("recipients")));
        }
        builder.setTitle(getValueOrNull(readableMap, "title"));
        builder.setData(getValueOrNull(readableMap, "data"));
        builder.setObjectId(getValueOrNull(readableMap, "objectId"));
        if (readableMap.hasKey(ShareConstants.WEB_DIALOG_PARAM_SUGGESTIONS)) {
            builder.setSuggestions(reactArrayToStringList(readableMap.getArray(ShareConstants.WEB_DIALOG_PARAM_SUGGESTIONS)));
        }
        return builder.build();
    }

    public static ShareLinkContent buildShareLinkContent(ReadableMap readableMap) {
        ShareLinkContent.Builder builder = new ShareLinkContent.Builder();
        builder.setContentUrl(Uri.parse(readableMap.getString("contentUrl")));
        builder.setQuote(getValueOrNull(readableMap, ShareConstants.WEB_DIALOG_PARAM_QUOTE));
        appendGenericContent(builder, readableMap);
        return builder.build();
    }

    public static SharePhotoContent buildSharePhotoContent(ReadableMap readableMap) {
        SharePhotoContent.Builder builder = new SharePhotoContent.Builder();
        builder.setPhotos(reactArrayToPhotoList(readableMap.getArray("photos")));
        String valueOrNull = getValueOrNull(readableMap, "contentUrl");
        builder.setContentUrl(valueOrNull != null ? Uri.parse(valueOrNull) : null);
        appendGenericContent(builder, readableMap);
        return builder.build();
    }

    public static SharePhoto buildSharePhoto(ReadableMap readableMap) {
        SharePhoto.Builder builder = new SharePhoto.Builder();
        builder.setImageUrl(Uri.parse(readableMap.getString("imageUrl")));
        builder.setCaption(getValueOrNull(readableMap, ShareConstants.FEED_CAPTION_PARAM));
        if (readableMap.hasKey("userGenerated")) {
            builder.setUserGenerated(readableMap.getBoolean("userGenerated"));
        }
        return builder.build();
    }

    public static ShareContent buildShareVideoContent(ReadableMap readableMap) {
        ShareVideoContent.Builder builder = new ShareVideoContent.Builder();
        String valueOrNull = getValueOrNull(readableMap, "contentUrl");
        builder.setContentUrl(valueOrNull != null ? Uri.parse(valueOrNull) : null);
        builder.setContentDescription(getValueOrNull(readableMap, "contentDescription"));
        builder.setContentTitle(getValueOrNull(readableMap, "contentTitle"));
        if (readableMap.hasKey("previewPhoto")) {
            builder.setPreviewPhoto(buildSharePhoto(readableMap.getMap("previewPhoto")));
        }
        if (readableMap.hasKey("video")) {
            builder.setVideo(buildShareVideo(readableMap.getMap("video")));
        }
        appendGenericContent(builder, readableMap);
        return builder.build();
    }

    private static void appendGenericContent(ShareContent.Builder builder, ReadableMap readableMap) {
        if (readableMap.hasKey("commonParameters")) {
            ReadableMap map = readableMap.getMap("commonParameters");
            builder.setPeopleIds(map.hasKey("peopleIds") ? reactArrayToStringList(map.getArray("peopleIds")) : null);
            builder.setPlaceId(getValueOrNull(map, "placeId"));
            builder.setRef(getValueOrNull(map, "ref"));
            if (map.hasKey(ShareConstants.WEB_DIALOG_PARAM_HASHTAG)) {
                builder.setShareHashtag(new ShareHashtag.Builder().setHashtag(map.getString(ShareConstants.WEB_DIALOG_PARAM_HASHTAG)).build());
            }
        }
    }

    public static ShareVideo buildShareVideo(ReadableMap readableMap) {
        ShareVideo.Builder builder = new ShareVideo.Builder();
        if (readableMap.hasKey("localUrl")) {
            builder.setLocalUrl(Uri.parse(readableMap.getString("localUrl")));
        }
        return builder.build();
    }

    public static List<SharePhoto> reactArrayToPhotoList(ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList(readableArray.size());
        for (int i = 0; i < readableArray.size(); i++) {
            arrayList.add(buildSharePhoto(readableArray.getMap(i)));
        }
        return arrayList;
    }

    public static String getValueOrNull(ReadableMap readableMap, String str) {
        if (readableMap.hasKey(str)) {
            return readableMap.getString(str);
        }
        return null;
    }

    public static List<String> reactArrayToStringList(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(readableArray.size());
        for (int i = 0; i < readableArray.size(); i++) {
            arrayList.add(readableArray.getString(i));
        }
        return arrayList;
    }

    public static WritableArray listToReactArray(List<String> list) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            writableArrayCreateArray.pushString(it.next());
        }
        return writableArrayCreateArray;
    }

    public static String[] setToStringArray(Set<String> set) {
        String[] strArr = new String[set.size()];
        Iterator<String> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            strArr[i] = it.next();
            i++;
        }
        return strArr;
    }

    private static void putStringOrNull(WritableMap writableMap, String str, String str2) {
        if (str2 == null) {
            writableMap.putNull(str);
        } else {
            writableMap.putString(str, str2);
        }
    }
}
