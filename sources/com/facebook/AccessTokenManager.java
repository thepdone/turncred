package com.facebook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.Utility;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AccessTokenManager.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 !2\u00020\u0001:\u0005!\"#$%B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0012\u0010\u001b\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u001c\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\f\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0014H\u0002J\b\u0010 \u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/facebook/AccessTokenManager;", "", "localBroadcastManager", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "accessTokenCache", "Lcom/facebook/AccessTokenCache;", "(Landroidx/localbroadcastmanager/content/LocalBroadcastManager;Lcom/facebook/AccessTokenCache;)V", "value", "Lcom/facebook/AccessToken;", "currentAccessToken", "getCurrentAccessToken", "()Lcom/facebook/AccessToken;", "setCurrentAccessToken", "(Lcom/facebook/AccessToken;)V", "currentAccessTokenField", "lastAttemptedTokenExtendDate", "Ljava/util/Date;", "tokenRefreshInProgress", "Ljava/util/concurrent/atomic/AtomicBoolean;", "currentAccessTokenChanged", "", "extendAccessTokenIfNeeded", "loadCurrentAccessToken", "", "refreshCurrentAccessToken", "callback", "Lcom/facebook/AccessToken$AccessTokenRefreshCallback;", "refreshCurrentAccessTokenImpl", "sendCurrentAccessTokenChangedBroadcastIntent", "oldAccessToken", "saveToCache", "setTokenExpirationBroadcastAlarm", "shouldExtendAccessToken", "Companion", "FacebookRefreshTokenInfo", "InstagramRefreshTokenInfo", "RefreshResult", "RefreshTokenInfo", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AccessTokenManager {
    public static final String ACTION_CURRENT_ACCESS_TOKEN_CHANGED = "com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRA_NEW_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN";
    public static final String EXTRA_OLD_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN";
    private static final String ME_PERMISSIONS_GRAPH_PATH = "me/permissions";
    public static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
    public static final String TAG = "AccessTokenManager";
    private static final int TOKEN_EXTEND_RETRY_SECONDS = 3600;
    private static final int TOKEN_EXTEND_THRESHOLD_SECONDS = 86400;
    private static AccessTokenManager instanceField;
    private final AccessTokenCache accessTokenCache;
    private AccessToken currentAccessTokenField;
    private Date lastAttemptedTokenExtendDate;
    private final LocalBroadcastManager localBroadcastManager;
    private final AtomicBoolean tokenRefreshInProgress;

    /* compiled from: AccessTokenManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "", "grantType", "", "getGrantType", "()Ljava/lang/String;", "graphPath", "getGraphPath", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface RefreshTokenInfo {
        String getGrantType();

        String getGraphPath();
    }

    @JvmStatic
    public static final AccessTokenManager getInstance() {
        return INSTANCE.getInstance();
    }

    public AccessTokenManager(LocalBroadcastManager localBroadcastManager, AccessTokenCache accessTokenCache) {
        Intrinsics.checkNotNullParameter(localBroadcastManager, "localBroadcastManager");
        Intrinsics.checkNotNullParameter(accessTokenCache, "accessTokenCache");
        this.localBroadcastManager = localBroadcastManager;
        this.accessTokenCache = accessTokenCache;
        this.tokenRefreshInProgress = new AtomicBoolean(false);
        this.lastAttemptedTokenExtendDate = new Date(0L);
    }

    /* renamed from: getCurrentAccessToken, reason: from getter */
    public final AccessToken getCurrentAccessTokenField() {
        return this.currentAccessTokenField;
    }

    public final void setCurrentAccessToken(AccessToken accessToken) {
        setCurrentAccessToken(accessToken, true);
    }

    /* compiled from: AccessTokenManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/facebook/AccessTokenManager$FacebookRefreshTokenInfo;", "Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "()V", "grantType", "", "getGrantType", "()Ljava/lang/String;", "graphPath", "getGraphPath", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class FacebookRefreshTokenInfo implements RefreshTokenInfo {
        private final String graphPath = "oauth/access_token";
        private final String grantType = "fb_extend_sso_token";

        @Override // com.facebook.AccessTokenManager.RefreshTokenInfo
        public String getGraphPath() {
            return this.graphPath;
        }

        @Override // com.facebook.AccessTokenManager.RefreshTokenInfo
        public String getGrantType() {
            return this.grantType;
        }
    }

    /* compiled from: AccessTokenManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/facebook/AccessTokenManager$InstagramRefreshTokenInfo;", "Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "()V", "grantType", "", "getGrantType", "()Ljava/lang/String;", "graphPath", "getGraphPath", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class InstagramRefreshTokenInfo implements RefreshTokenInfo {
        private final String graphPath = "refresh_access_token";
        private final String grantType = "ig_refresh_token";

        @Override // com.facebook.AccessTokenManager.RefreshTokenInfo
        public String getGraphPath() {
            return this.graphPath;
        }

        @Override // com.facebook.AccessTokenManager.RefreshTokenInfo
        public String getGrantType() {
            return this.grantType;
        }
    }

    public final boolean loadCurrentAccessToken() {
        AccessToken accessTokenLoad = this.accessTokenCache.load();
        if (accessTokenLoad == null) {
            return false;
        }
        setCurrentAccessToken(accessTokenLoad, false);
        return true;
    }

    public final void currentAccessTokenChanged() {
        sendCurrentAccessTokenChangedBroadcastIntent(getCurrentAccessTokenField(), getCurrentAccessTokenField());
    }

    private final void setCurrentAccessToken(AccessToken currentAccessToken, boolean saveToCache) {
        AccessToken accessToken = this.currentAccessTokenField;
        this.currentAccessTokenField = currentAccessToken;
        this.tokenRefreshInProgress.set(false);
        this.lastAttemptedTokenExtendDate = new Date(0L);
        if (saveToCache) {
            if (currentAccessToken != null) {
                this.accessTokenCache.save(currentAccessToken);
            } else {
                this.accessTokenCache.clear();
                Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
            }
        }
        if (Utility.areObjectsEqual(accessToken, currentAccessToken)) {
            return;
        }
        sendCurrentAccessTokenChangedBroadcastIntent(accessToken, currentAccessToken);
        setTokenExpirationBroadcastAlarm();
    }

    private final void sendCurrentAccessTokenChangedBroadcastIntent(AccessToken oldAccessToken, AccessToken currentAccessToken) {
        Intent intent = new Intent(FacebookSdk.getApplicationContext(), (Class<?>) CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
        intent.putExtra(EXTRA_OLD_ACCESS_TOKEN, oldAccessToken);
        intent.putExtra(EXTRA_NEW_ACCESS_TOKEN, currentAccessToken);
        this.localBroadcastManager.sendBroadcast(intent);
    }

    private final void setTokenExpirationBroadcastAlarm() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        AccessToken currentAccessToken = AccessToken.INSTANCE.getCurrentAccessToken();
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (AccessToken.INSTANCE.isCurrentAccessTokenActive()) {
            if ((currentAccessToken != null ? currentAccessToken.getExpires() : null) == null || alarmManager == null) {
                return;
            }
            Intent intent = new Intent(applicationContext, (Class<?>) CurrentAccessTokenExpirationBroadcastReceiver.class);
            intent.setAction(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
            try {
                alarmManager.set(1, currentAccessToken.getExpires().getTime(), PendingIntent.getBroadcast(applicationContext, 0, intent, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL));
            } catch (Exception unused) {
            }
        }
    }

    public final void extendAccessTokenIfNeeded() {
        if (shouldExtendAccessToken()) {
            refreshCurrentAccessToken(null);
        }
    }

    private final boolean shouldExtendAccessToken() {
        AccessToken currentAccessTokenField = getCurrentAccessTokenField();
        if (currentAccessTokenField == null) {
            return false;
        }
        long time = new Date().getTime();
        return currentAccessTokenField.getSource().getCanExtendToken() && time - this.lastAttemptedTokenExtendDate.getTime() > 3600000 && time - currentAccessTokenField.getLastRefresh().getTime() > 86400000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AccessTokenManager.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/facebook/AccessTokenManager$RefreshResult;", "", "()V", SDKConstants.PARAM_ACCESS_TOKEN, "", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", SDKConstants.PARAM_DATA_ACCESS_EXPIRATION_TIME, "", "getDataAccessExpirationTime", "()Ljava/lang/Long;", "setDataAccessExpirationTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "expiresAt", "", "getExpiresAt", "()I", "setExpiresAt", "(I)V", "expiresIn", "getExpiresIn", "setExpiresIn", SDKConstants.PARAM_GRAPH_DOMAIN, "getGraphDomain", "setGraphDomain", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final class RefreshResult {
        private String accessToken;
        private Long dataAccessExpirationTime;
        private int expiresAt;
        private int expiresIn;
        private String graphDomain;

        public final String getAccessToken() {
            return this.accessToken;
        }

        public final void setAccessToken(String str) {
            this.accessToken = str;
        }

        public final int getExpiresAt() {
            return this.expiresAt;
        }

        public final void setExpiresAt(int i) {
            this.expiresAt = i;
        }

        public final int getExpiresIn() {
            return this.expiresIn;
        }

        public final void setExpiresIn(int i) {
            this.expiresIn = i;
        }

        public final Long getDataAccessExpirationTime() {
            return this.dataAccessExpirationTime;
        }

        public final void setDataAccessExpirationTime(Long l) {
            this.dataAccessExpirationTime = l;
        }

        public final String getGraphDomain() {
            return this.graphDomain;
        }

        public final void setGraphDomain(String str) {
            this.graphDomain = str;
        }
    }

    public final void refreshCurrentAccessToken(final AccessToken.AccessTokenRefreshCallback callback) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            refreshCurrentAccessTokenImpl(callback);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.facebook.AccessTokenManager$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    AccessTokenManager.refreshCurrentAccessToken$lambda$0(this.f$0, callback);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshCurrentAccessToken$lambda$0(AccessTokenManager this$0, AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
    }

    private final void refreshCurrentAccessTokenImpl(final AccessToken.AccessTokenRefreshCallback callback) {
        final AccessToken currentAccessTokenField = getCurrentAccessTokenField();
        if (currentAccessTokenField == null) {
            if (callback != null) {
                callback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
                return;
            }
            return;
        }
        if (!this.tokenRefreshInProgress.compareAndSet(false, true)) {
            if (callback != null) {
                callback.OnTokenRefreshFailed(new FacebookException("Refresh already in progress"));
                return;
            }
            return;
        }
        this.lastAttemptedTokenExtendDate = new Date();
        final HashSet hashSet = new HashSet();
        final HashSet hashSet2 = new HashSet();
        final HashSet hashSet3 = new HashSet();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final RefreshResult refreshResult = new RefreshResult();
        Companion companion = INSTANCE;
        GraphRequestBatch graphRequestBatch = new GraphRequestBatch(companion.createGrantedPermissionsRequest(currentAccessTokenField, new GraphRequest.Callback() { // from class: com.facebook.AccessTokenManager$$ExternalSyntheticLambda0
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                AccessTokenManager.refreshCurrentAccessTokenImpl$lambda$1(atomicBoolean, hashSet, hashSet2, hashSet3, graphResponse);
            }
        }), companion.createExtendAccessTokenRequest(currentAccessTokenField, new GraphRequest.Callback() { // from class: com.facebook.AccessTokenManager$$ExternalSyntheticLambda1
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                AccessTokenManager.refreshCurrentAccessTokenImpl$lambda$2(refreshResult, graphResponse);
            }
        }));
        graphRequestBatch.addCallback(new GraphRequestBatch.Callback() { // from class: com.facebook.AccessTokenManager$$ExternalSyntheticLambda2
            @Override // com.facebook.GraphRequestBatch.Callback
            public final void onBatchCompleted(GraphRequestBatch graphRequestBatch2) throws Throwable {
                AccessTokenManager.refreshCurrentAccessTokenImpl$lambda$3(refreshResult, currentAccessTokenField, callback, atomicBoolean, hashSet, hashSet2, hashSet3, this, graphRequestBatch2);
            }
        });
        graphRequestBatch.executeAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void refreshCurrentAccessTokenImpl$lambda$1(java.util.concurrent.atomic.AtomicBoolean r6, java.util.Set r7, java.util.Set r8, java.util.Set r9, com.facebook.GraphResponse r10) {
        /*
            java.lang.String r0 = "$permissionsCallSucceeded"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "$permissions"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "$declinedPermissions"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "$expiredPermissions"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            org.json.JSONObject r10 = r10.getJsonObject()
            if (r10 != 0) goto L21
            return
        L21:
            java.lang.String r0 = "data"
            org.json.JSONArray r10 = r10.optJSONArray(r0)
            if (r10 != 0) goto L2a
            return
        L2a:
            r0 = 1
            r6.set(r0)
            int r6 = r10.length()
            r0 = 0
        L33:
            if (r0 >= r6) goto Lbf
            org.json.JSONObject r1 = r10.optJSONObject(r0)
            if (r1 != 0) goto L3d
            goto Lbb
        L3d:
            java.lang.String r2 = "permission"
            java.lang.String r2 = r1.optString(r2)
            java.lang.String r3 = "status"
            java.lang.String r1 = r1.optString(r3)
            boolean r4 = com.facebook.internal.Utility.isNullOrEmpty(r2)
            if (r4 != 0) goto Lbb
            boolean r4 = com.facebook.internal.Utility.isNullOrEmpty(r1)
            if (r4 != 0) goto Lbb
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            java.util.Locale r4 = java.util.Locale.US
            java.lang.String r5 = "US"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.lang.String r1 = r1.toLowerCase(r4)
            java.lang.String r4 = "this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            int r3 = r1.hashCode()
            r4 = -1309235419(0xffffffffb1f6a725, float:-7.1785444E-9)
            if (r3 == r4) goto L9b
            r4 = 280295099(0x10b4f6bb, float:7.137763E-29)
            if (r3 == r4) goto L8f
            r4 = 568196142(0x21ddfc2e, float:1.5042294E-18)
            if (r3 == r4) goto L82
            goto La3
        L82:
            java.lang.String r3 = "declined"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L8b
            goto La3
        L8b:
            r8.add(r2)
            goto Lbb
        L8f:
            java.lang.String r3 = "granted"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto La3
            r7.add(r2)
            goto Lbb
        L9b:
            java.lang.String r3 = "expired"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto Lb8
        La3:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Unexpected status: "
            r2.<init>(r3)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "AccessTokenManager"
            android.util.Log.w(r2, r1)
            goto Lbb
        Lb8:
            r9.add(r2)
        Lbb:
            int r0 = r0 + 1
            goto L33
        Lbf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AccessTokenManager.refreshCurrentAccessTokenImpl$lambda$1(java.util.concurrent.atomic.AtomicBoolean, java.util.Set, java.util.Set, java.util.Set, com.facebook.GraphResponse):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshCurrentAccessTokenImpl$lambda$2(RefreshResult refreshResult, GraphResponse response) {
        Intrinsics.checkNotNullParameter(refreshResult, "$refreshResult");
        Intrinsics.checkNotNullParameter(response, "response");
        JSONObject jsonObject = response.getJsonObject();
        if (jsonObject == null) {
            return;
        }
        refreshResult.setAccessToken(jsonObject.optString("access_token"));
        refreshResult.setExpiresAt(jsonObject.optInt("expires_at"));
        refreshResult.setExpiresIn(jsonObject.optInt(AccessToken.EXPIRES_IN_KEY));
        refreshResult.setDataAccessExpirationTime(Long.valueOf(jsonObject.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME)));
        refreshResult.setGraphDomain(jsonObject.optString("graph_domain", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshCurrentAccessTokenImpl$lambda$3(RefreshResult refreshResult, AccessToken accessToken, AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback, AtomicBoolean permissionsCallSucceeded, Set permissions, Set declinedPermissions, Set set, AccessTokenManager this$0, GraphRequestBatch it) throws Throwable {
        boolean z;
        AccessToken accessToken2;
        Date dataAccessExpirationTime;
        Intrinsics.checkNotNullParameter(refreshResult, "$refreshResult");
        Intrinsics.checkNotNullParameter(permissionsCallSucceeded, "$permissionsCallSucceeded");
        Intrinsics.checkNotNullParameter(permissions, "$permissions");
        Intrinsics.checkNotNullParameter(declinedPermissions, "$declinedPermissions");
        Set expiredPermissions = set;
        Intrinsics.checkNotNullParameter(expiredPermissions, "$expiredPermissions");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        String accessToken3 = refreshResult.getAccessToken();
        int expiresAt = refreshResult.getExpiresAt();
        Long dataAccessExpirationTime2 = refreshResult.getDataAccessExpirationTime();
        String graphDomain = refreshResult.getGraphDomain();
        try {
            Companion companion = INSTANCE;
            if (companion.getInstance().getCurrentAccessTokenField() != null) {
                try {
                    AccessToken currentAccessTokenField = companion.getInstance().getCurrentAccessTokenField();
                    if ((currentAccessTokenField != null ? currentAccessTokenField.getUserId() : null) == accessToken.getUserId()) {
                        if (permissionsCallSucceeded.get() || accessToken3 != null || expiresAt != 0) {
                            Date expires = accessToken.getExpires();
                            if (refreshResult.getExpiresAt() != 0) {
                                expires = new Date(refreshResult.getExpiresAt() * 1000);
                            } else if (refreshResult.getExpiresIn() != 0) {
                                expires = new Date((refreshResult.getExpiresIn() * 1000) + new Date().getTime());
                            }
                            Date date = expires;
                            if (accessToken3 == null) {
                                accessToken3 = accessToken.getToken();
                            }
                            String str = accessToken3;
                            String applicationId = accessToken.getApplicationId();
                            String userId = accessToken.getUserId();
                            Set permissions2 = permissionsCallSucceeded.get() ? permissions : accessToken.getPermissions();
                            Set declinedPermissions2 = permissionsCallSucceeded.get() ? declinedPermissions : accessToken.getDeclinedPermissions();
                            if (!permissionsCallSucceeded.get()) {
                                expiredPermissions = accessToken.getExpiredPermissions();
                            }
                            Set set2 = expiredPermissions;
                            AccessTokenSource source = accessToken.getSource();
                            Date date2 = new Date();
                            if (dataAccessExpirationTime2 != null) {
                                dataAccessExpirationTime = new Date(dataAccessExpirationTime2.longValue() * 1000);
                            } else {
                                dataAccessExpirationTime = accessToken.getDataAccessExpirationTime();
                            }
                            Date date3 = dataAccessExpirationTime;
                            if (graphDomain == null) {
                                graphDomain = accessToken.getGraphDomain();
                            }
                            AccessToken accessToken4 = new AccessToken(str, applicationId, userId, permissions2, declinedPermissions2, set2, source, date, date2, date3, graphDomain);
                            try {
                                companion.getInstance().setCurrentAccessToken(accessToken4);
                                this$0.tokenRefreshInProgress.set(false);
                                if (accessTokenRefreshCallback != null) {
                                    accessTokenRefreshCallback.OnTokenRefreshed(accessToken4);
                                    return;
                                }
                                return;
                            } catch (Throwable th) {
                                th = th;
                                accessToken2 = accessToken4;
                                z = false;
                                this$0.tokenRefreshInProgress.set(z);
                                if (accessTokenRefreshCallback != null && accessToken2 != null) {
                                    accessTokenRefreshCallback.OnTokenRefreshed(accessToken2);
                                }
                                throw th;
                            }
                        }
                        if (accessTokenRefreshCallback != null) {
                            accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("Failed to refresh access token"));
                        }
                        this$0.tokenRefreshInProgress.set(false);
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z = false;
                    accessToken2 = null;
                    this$0.tokenRefreshInProgress.set(z);
                    if (accessTokenRefreshCallback != null) {
                        accessTokenRefreshCallback.OnTokenRefreshed(accessToken2);
                    }
                    throw th;
                }
            }
            if (accessTokenRefreshCallback != null) {
                accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
            }
            this$0.tokenRefreshInProgress.set(false);
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }

    /* compiled from: AccessTokenManager.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/facebook/AccessTokenManager$Companion;", "", "()V", "ACTION_CURRENT_ACCESS_TOKEN_CHANGED", "", "EXTRA_NEW_ACCESS_TOKEN", "EXTRA_OLD_ACCESS_TOKEN", "ME_PERMISSIONS_GRAPH_PATH", "SHARED_PREFERENCES_NAME", "TAG", "TOKEN_EXTEND_RETRY_SECONDS", "", "TOKEN_EXTEND_THRESHOLD_SECONDS", "instanceField", "Lcom/facebook/AccessTokenManager;", "createExtendAccessTokenRequest", "Lcom/facebook/GraphRequest;", SDKConstants.PARAM_ACCESS_TOKEN, "Lcom/facebook/AccessToken;", "callback", "Lcom/facebook/GraphRequest$Callback;", "createGrantedPermissionsRequest", "getInstance", "getRefreshTokenInfoForToken", "Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AccessTokenManager getInstance() {
            AccessTokenManager accessTokenManager;
            AccessTokenManager accessTokenManager2 = AccessTokenManager.instanceField;
            if (accessTokenManager2 != null) {
                return accessTokenManager2;
            }
            synchronized (this) {
                accessTokenManager = AccessTokenManager.instanceField;
                if (accessTokenManager == null) {
                    LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext());
                    Intrinsics.checkNotNullExpressionValue(localBroadcastManager, "getInstance(applicationContext)");
                    AccessTokenManager accessTokenManager3 = new AccessTokenManager(localBroadcastManager, new AccessTokenCache());
                    Companion companion = AccessTokenManager.INSTANCE;
                    AccessTokenManager.instanceField = accessTokenManager3;
                    accessTokenManager = accessTokenManager3;
                }
            }
            return accessTokenManager;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final GraphRequest createGrantedPermissionsRequest(AccessToken accessToken, GraphRequest.Callback callback) {
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "permission,status");
            GraphRequest graphRequestNewGraphPathRequest = GraphRequest.INSTANCE.newGraphPathRequest(accessToken, AccessTokenManager.ME_PERMISSIONS_GRAPH_PATH, callback);
            graphRequestNewGraphPathRequest.setParameters(bundle);
            graphRequestNewGraphPathRequest.setHttpMethod(HttpMethod.GET);
            return graphRequestNewGraphPathRequest;
        }

        private final RefreshTokenInfo getRefreshTokenInfoForToken(AccessToken accessToken) {
            String graphDomain = accessToken.getGraphDomain();
            if (graphDomain == null) {
                graphDomain = AccessToken.DEFAULT_GRAPH_DOMAIN;
            }
            return Intrinsics.areEqual(graphDomain, FacebookSdk.INSTAGRAM) ? new InstagramRefreshTokenInfo() : new FacebookRefreshTokenInfo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final GraphRequest createExtendAccessTokenRequest(AccessToken accessToken, GraphRequest.Callback callback) {
            RefreshTokenInfo refreshTokenInfoForToken = getRefreshTokenInfoForToken(accessToken);
            Bundle bundle = new Bundle();
            bundle.putString("grant_type", refreshTokenInfoForToken.getGrantType());
            bundle.putString("client_id", accessToken.getApplicationId());
            bundle.putString(GraphRequest.FIELDS_PARAM, "access_token,expires_at,expires_in,data_access_expiration_time,graph_domain");
            GraphRequest graphRequestNewGraphPathRequest = GraphRequest.INSTANCE.newGraphPathRequest(accessToken, refreshTokenInfoForToken.getGraphPath(), callback);
            graphRequestNewGraphPathRequest.setParameters(bundle);
            graphRequestNewGraphPathRequest.setHttpMethod(HttpMethod.GET);
            return graphRequestNewGraphPathRequest;
        }
    }
}
