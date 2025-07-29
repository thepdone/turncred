package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.internal.Utility;
import com.facebook.share.model.AppGroupCreationContent;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebDialogParameters.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\u00042\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u0013"}, d2 = {"Lcom/facebook/share/internal/WebDialogParameters;", "", "()V", "create", "Landroid/os/Bundle;", "appGroupCreationContent", "Lcom/facebook/share/model/AppGroupCreationContent;", "gameRequestContent", "Lcom/facebook/share/model/GameRequestContent;", "shareLinkContent", "Lcom/facebook/share/model/ShareLinkContent;", "sharePhotoContent", "Lcom/facebook/share/model/SharePhotoContent;", "createBaseParameters", "shareContent", "Lcom/facebook/share/model/ShareContent;", "createForFeed", "shareFeedContent", "Lcom/facebook/share/internal/ShareFeedContent;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WebDialogParameters {
    public static final WebDialogParameters INSTANCE = new WebDialogParameters();

    private WebDialogParameters() {
    }

    @JvmStatic
    public static final Bundle create(AppGroupCreationContent appGroupCreationContent) {
        String lowerCase;
        String string;
        Intrinsics.checkNotNullParameter(appGroupCreationContent, "appGroupCreationContent");
        Bundle bundle = new Bundle();
        Utility.putNonEmptyString(bundle, "name", appGroupCreationContent.getName());
        Utility.putNonEmptyString(bundle, "description", appGroupCreationContent.getDescription());
        AppGroupCreationContent.AppGroupPrivacy appGroupPrivacy = appGroupCreationContent.getAppGroupPrivacy();
        if (appGroupPrivacy == null || (string = appGroupPrivacy.toString()) == null) {
            lowerCase = null;
        } else {
            Locale ENGLISH = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
            lowerCase = string.toLowerCase(ENGLISH);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        }
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_PRIVACY, lowerCase);
        return bundle;
    }

    @JvmStatic
    public static final Bundle create(GameRequestContent gameRequestContent) {
        String lowerCase;
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(gameRequestContent, "gameRequestContent");
        Bundle bundle = new Bundle();
        Utility.putNonEmptyString(bundle, "message", gameRequestContent.getMessage());
        Utility.putCommaSeparatedStringList(bundle, "to", gameRequestContent.getRecipients());
        Utility.putNonEmptyString(bundle, "title", gameRequestContent.getTitle());
        Utility.putNonEmptyString(bundle, "data", gameRequestContent.getData());
        GameRequestContent.ActionType actionType = gameRequestContent.getActionType();
        String lowerCase2 = null;
        if (actionType == null || (string2 = actionType.toString()) == null) {
            lowerCase = null;
        } else {
            Locale ENGLISH = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
            lowerCase = string2.toLowerCase(ENGLISH);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        }
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, lowerCase);
        Utility.putNonEmptyString(bundle, "object_id", gameRequestContent.getObjectId());
        GameRequestContent.Filters filters = gameRequestContent.getFilters();
        if (filters != null && (string = filters.toString()) != null) {
            Locale ENGLISH2 = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(ENGLISH2, "ENGLISH");
            lowerCase2 = string.toLowerCase(ENGLISH2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
        }
        Utility.putNonEmptyString(bundle, "filters", lowerCase2);
        Utility.putCommaSeparatedStringList(bundle, ShareConstants.WEB_DIALOG_PARAM_SUGGESTIONS, gameRequestContent.getSuggestions());
        return bundle;
    }

    @JvmStatic
    public static final Bundle create(ShareLinkContent shareLinkContent) {
        Intrinsics.checkNotNullParameter(shareLinkContent, "shareLinkContent");
        Bundle bundleCreateBaseParameters = createBaseParameters(shareLinkContent);
        Utility.putUri(bundleCreateBaseParameters, "href", shareLinkContent.getContentUrl());
        Utility.putNonEmptyString(bundleCreateBaseParameters, ShareConstants.WEB_DIALOG_PARAM_QUOTE, shareLinkContent.getQuote());
        return bundleCreateBaseParameters;
    }

    @JvmStatic
    public static final Bundle create(SharePhotoContent sharePhotoContent) {
        Intrinsics.checkNotNullParameter(sharePhotoContent, "sharePhotoContent");
        Bundle bundleCreateBaseParameters = createBaseParameters(sharePhotoContent);
        List<SharePhoto> photos = sharePhotoContent.getPhotos();
        if (photos == null) {
            photos = CollectionsKt.emptyList();
        }
        List<SharePhoto> list = photos;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((SharePhoto) it.next()).getImageUrl()));
        }
        bundleCreateBaseParameters.putStringArray("media", (String[]) arrayList.toArray(new String[0]));
        return bundleCreateBaseParameters;
    }

    @JvmStatic
    public static final Bundle createBaseParameters(ShareContent<?, ?> shareContent) {
        Intrinsics.checkNotNullParameter(shareContent, "shareContent");
        Bundle bundle = new Bundle();
        ShareHashtag shareHashtag = shareContent.getShareHashtag();
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_HASHTAG, shareHashtag != null ? shareHashtag.getHashtag() : null);
        return bundle;
    }

    @JvmStatic
    public static final Bundle createForFeed(ShareLinkContent shareLinkContent) {
        Intrinsics.checkNotNullParameter(shareLinkContent, "shareLinkContent");
        Bundle bundle = new Bundle();
        Utility.putNonEmptyString(bundle, "link", Utility.getUriString(shareLinkContent.getContentUrl()));
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_QUOTE, shareLinkContent.getQuote());
        ShareHashtag shareHashtag = shareLinkContent.getShareHashtag();
        Utility.putNonEmptyString(bundle, ShareConstants.WEB_DIALOG_PARAM_HASHTAG, shareHashtag != null ? shareHashtag.getHashtag() : null);
        return bundle;
    }

    @JvmStatic
    public static final Bundle createForFeed(ShareFeedContent shareFeedContent) {
        Intrinsics.checkNotNullParameter(shareFeedContent, "shareFeedContent");
        Bundle bundle = new Bundle();
        Utility.putNonEmptyString(bundle, "to", shareFeedContent.getToId());
        Utility.putNonEmptyString(bundle, "link", shareFeedContent.getLink());
        Utility.putNonEmptyString(bundle, "picture", shareFeedContent.getPicture());
        Utility.putNonEmptyString(bundle, "source", shareFeedContent.getMediaSource());
        Utility.putNonEmptyString(bundle, "name", shareFeedContent.getLinkName());
        Utility.putNonEmptyString(bundle, ShareConstants.FEED_CAPTION_PARAM, shareFeedContent.getLinkCaption());
        Utility.putNonEmptyString(bundle, "description", shareFeedContent.getLinkDescription());
        return bundle;
    }
}
