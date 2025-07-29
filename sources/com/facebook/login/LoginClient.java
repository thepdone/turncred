package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import com.facebook.react.util.ExceptionDataHelper;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import io.sentry.SentryEvent;
import io.sentry.Session;
import io.sentry.protocol.Request;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LoginClient.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0017\u0018\u0000 q2\u00020\u0001:\u0005pqrstB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020\u0013J \u0010I\u001a\u00020F2\u0006\u0010G\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020\u0013H\u0002J\u0010\u0010J\u001a\u00020F2\b\u0010K\u001a\u0004\u0018\u00010@J\u0006\u0010L\u001a\u00020FJ\u0006\u0010M\u001a\u00020\u0013J\u000e\u0010N\u001a\u00020\u00192\u0006\u0010O\u001a\u00020\u001cJ\u000e\u0010P\u001a\u00020F2\u0006\u0010Q\u001a\u00020RJ\u000e\u0010S\u001a\u00020F2\u0006\u0010Q\u001a\u00020RJ\b\u0010T\u001a\u00020FH\u0002J\b\u0010U\u001a\u00020\u0019H\u0016J\b\u0010V\u001a\u0004\u0018\u00010'J\u001d\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&2\u0006\u0010K\u001a\u00020@H\u0016¢\u0006\u0002\u0010WJ2\u0010X\u001a\u00020F2\u0006\u0010Y\u001a\u00020\u001c2\u0006\u0010Z\u001a\u00020R2\u0018\u00103\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010[H\u0002JF\u0010X\u001a\u00020F2\u0006\u0010Y\u001a\u00020\u001c2\u0006\u0010Z\u001a\u00020\u001c2\b\u0010\\\u001a\u0004\u0018\u00010\u001c2\b\u0010]\u001a\u0004\u0018\u00010\u001c2\u0018\u00103\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010[H\u0002J\u0006\u0010^\u001a\u00020FJ\u0006\u0010_\u001a\u00020FJ\u0010\u0010`\u001a\u00020F2\u0006\u0010Q\u001a\u00020RH\u0002J \u0010a\u001a\u00020\u00132\u0006\u0010b\u001a\u00020\u00192\u0006\u0010c\u001a\u00020\u00192\b\u0010d\u001a\u0004\u0018\u00010eJ\u0010\u0010f\u001a\u00020F2\u0006\u0010g\u001a\u00020\u0019H\u0004J\u0010\u0010h\u001a\u00020F2\b\u0010K\u001a\u0004\u0018\u00010@J\u0006\u0010i\u001a\u00020\u0013J\u0006\u0010j\u001a\u00020FJ\u000e\u0010k\u001a\u00020F2\u0006\u0010l\u001a\u00020RJ\u0018\u0010m\u001a\u00020F2\u0006\u0010n\u001a\u00020\u00062\u0006\u0010o\u001a\u00020\u0019H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010\u0004R$\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0011\u0010-\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b.\u0010\u0015R\u0014\u0010/\u001a\u0002008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R(\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001e\"\u0004\b5\u0010 R\u0010\u00106\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006u"}, d2 = {"Lcom/facebook/login/LoginClient;", "Landroid/os/Parcelable;", Request.JsonKeys.FRAGMENT, "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "backgroundProcessingListener", "Lcom/facebook/login/LoginClient$BackgroundProcessingListener;", "getBackgroundProcessingListener", "()Lcom/facebook/login/LoginClient$BackgroundProcessingListener;", "setBackgroundProcessingListener", "(Lcom/facebook/login/LoginClient$BackgroundProcessingListener;)V", "checkedInternetPermission", "", "getCheckedInternetPermission", "()Z", "setCheckedInternetPermission", "(Z)V", "currentHandler", "", ExceptionDataHelper.EXTRA_DATA_FIELD, "", "", "getExtraData", "()Ljava/util/Map;", "setExtraData", "(Ljava/util/Map;)V", "value", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "handlersToTry", "", "Lcom/facebook/login/LoginMethodHandler;", "getHandlersToTry", "()[Lcom/facebook/login/LoginMethodHandler;", "setHandlersToTry", "([Lcom/facebook/login/LoginMethodHandler;)V", "[Lcom/facebook/login/LoginMethodHandler;", "inProgress", "getInProgress", SentryEvent.JsonKeys.LOGGER, "Lcom/facebook/login/LoginLogger;", "getLogger", "()Lcom/facebook/login/LoginLogger;", "loggingExtras", "getLoggingExtras", "setLoggingExtras", "loginLogger", "numActivitiesReturned", "numTotalIntentsFired", "onCompletedListener", "Lcom/facebook/login/LoginClient$OnCompletedListener;", "getOnCompletedListener", "()Lcom/facebook/login/LoginClient$OnCompletedListener;", "setOnCompletedListener", "(Lcom/facebook/login/LoginClient$OnCompletedListener;)V", "pendingRequest", "Lcom/facebook/login/LoginClient$Request;", "getPendingRequest", "()Lcom/facebook/login/LoginClient$Request;", "setPendingRequest", "(Lcom/facebook/login/LoginClient$Request;)V", "addExtraData", "", SDKConstants.PARAM_KEY, "accumulate", "addLoggingExtra", "authorize", "request", "cancelCurrentHandler", "checkInternetPermission", "checkPermission", "permission", "complete", "outcome", "Lcom/facebook/login/LoginClient$Result;", "completeAndValidate", "completeWithFailure", "describeContents", "getCurrentHandler", "(Lcom/facebook/login/LoginClient$Request;)[Lcom/facebook/login/LoginMethodHandler;", "logAuthorizationMethodComplete", "method", "result", "", "errorMessage", "errorCode", "notifyBackgroundProcessingStart", "notifyBackgroundProcessingStop", "notifyOnCompleteListener", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "setCurrentHandlerIndex", FirebaseAnalytics.Param.INDEX, "startOrContinueAuth", "tryCurrentHandler", "tryNextHandler", "validateSameFbidAndFinish", "pendingResult", "writeToParcel", "dest", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "BackgroundProcessingListener", "Companion", "OnCompletedListener", "Request", "Result", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public class LoginClient implements Parcelable {
    private BackgroundProcessingListener backgroundProcessingListener;
    private boolean checkedInternetPermission;
    private int currentHandler;
    private Map<String, String> extraData;
    private Fragment fragment;
    private LoginMethodHandler[] handlersToTry;
    private Map<String, String> loggingExtras;
    private LoginLogger loginLogger;
    private int numActivitiesReturned;
    private int numTotalIntentsFired;
    private OnCompletedListener onCompletedListener;
    private Request pendingRequest;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<LoginClient> CREATOR = new Parcelable.Creator<LoginClient>() { // from class: com.facebook.login.LoginClient$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LoginClient createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new LoginClient(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LoginClient[] newArray(int size) {
            return new LoginClient[size];
        }
    };

    /* compiled from: LoginClient.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/facebook/login/LoginClient$BackgroundProcessingListener;", "", "onBackgroundProcessingStarted", "", "onBackgroundProcessingStopped", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface BackgroundProcessingListener {
        void onBackgroundProcessingStarted();

        void onBackgroundProcessingStopped();
    }

    /* compiled from: LoginClient.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/login/LoginClient$OnCompletedListener;", "", "onCompleted", "", "result", "Lcom/facebook/login/LoginClient$Result;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnCompletedListener {
        void onCompleted(Result result);
    }

    @JvmStatic
    public static final String getE2E() {
        return INSTANCE.getE2E();
    }

    @JvmStatic
    public static final int getLoginRequestCode() {
        return INSTANCE.getLoginRequestCode();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final LoginMethodHandler[] getHandlersToTry() {
        return this.handlersToTry;
    }

    public final void setHandlersToTry(LoginMethodHandler[] loginMethodHandlerArr) {
        this.handlersToTry = loginMethodHandlerArr;
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    public final void setFragment(Fragment fragment) {
        if (this.fragment != null) {
            throw new FacebookException("Can't set fragment once it is already set.");
        }
        this.fragment = fragment;
    }

    public final OnCompletedListener getOnCompletedListener() {
        return this.onCompletedListener;
    }

    public final void setOnCompletedListener(OnCompletedListener onCompletedListener) {
        this.onCompletedListener = onCompletedListener;
    }

    public final BackgroundProcessingListener getBackgroundProcessingListener() {
        return this.backgroundProcessingListener;
    }

    public final void setBackgroundProcessingListener(BackgroundProcessingListener backgroundProcessingListener) {
        this.backgroundProcessingListener = backgroundProcessingListener;
    }

    public final boolean getCheckedInternetPermission() {
        return this.checkedInternetPermission;
    }

    public final void setCheckedInternetPermission(boolean z) {
        this.checkedInternetPermission = z;
    }

    public final Request getPendingRequest() {
        return this.pendingRequest;
    }

    public final void setPendingRequest(Request request) {
        this.pendingRequest = request;
    }

    public final Map<String, String> getLoggingExtras() {
        return this.loggingExtras;
    }

    public final void setLoggingExtras(Map<String, String> map) {
        this.loggingExtras = map;
    }

    public final Map<String, String> getExtraData() {
        return this.extraData;
    }

    public final void setExtraData(Map<String, String> map) {
        this.extraData = map;
    }

    public LoginClient(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.currentHandler = -1;
        setFragment(fragment);
    }

    public final FragmentActivity getActivity() {
        Fragment fragment = this.fragment;
        if (fragment != null) {
            return fragment.getActivity();
        }
        return null;
    }

    public final void startOrContinueAuth(Request request) {
        if (getInProgress()) {
            return;
        }
        authorize(request);
    }

    public final void authorize(Request request) {
        if (request == null) {
            return;
        }
        if (this.pendingRequest != null) {
            throw new FacebookException("Attempted to authorize while a request is pending.");
        }
        if (!AccessToken.INSTANCE.isCurrentAccessTokenActive() || checkInternetPermission()) {
            this.pendingRequest = request;
            this.handlersToTry = getHandlersToTry(request);
            tryNextHandler();
        }
    }

    public final boolean getInProgress() {
        return this.pendingRequest != null && this.currentHandler >= 0;
    }

    public final void cancelCurrentHandler() {
        LoginMethodHandler currentHandler = getCurrentHandler();
        if (currentHandler != null) {
            currentHandler.cancel();
        }
    }

    public final LoginMethodHandler getCurrentHandler() {
        LoginMethodHandler[] loginMethodHandlerArr;
        int i = this.currentHandler;
        if (i < 0 || (loginMethodHandlerArr = this.handlersToTry) == null) {
            return null;
        }
        return loginMethodHandlerArr[i];
    }

    protected final void setCurrentHandlerIndex(int index) {
        this.currentHandler = index;
    }

    public final boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        this.numActivitiesReturned++;
        if (this.pendingRequest != null) {
            if (data != null && data.getBooleanExtra(CustomTabMainActivity.NO_ACTIVITY_EXCEPTION, false)) {
                tryNextHandler();
                return false;
            }
            LoginMethodHandler currentHandler = getCurrentHandler();
            if (currentHandler != null && (!currentHandler.shouldKeepTrackOfMultipleIntents() || data != null || this.numActivitiesReturned >= this.numTotalIntentsFired)) {
                return currentHandler.onActivityResult(requestCode, resultCode, data);
            }
        }
        return false;
    }

    public LoginMethodHandler[] getHandlersToTry(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        ArrayList arrayList = new ArrayList();
        LoginBehavior loginBehavior = request.getLoginBehavior();
        if (request.isInstagramLogin()) {
            if (!FacebookSdk.bypassAppSwitch && loginBehavior.getAllowsInstagramAppAuth()) {
                arrayList.add(new InstagramAppLoginMethodHandler(this));
            }
        } else {
            if (loginBehavior.getAllowsGetTokenAuth()) {
                arrayList.add(new GetTokenLoginMethodHandler(this));
            }
            if (!FacebookSdk.bypassAppSwitch && loginBehavior.getAllowsKatanaAuth()) {
                arrayList.add(new KatanaProxyLoginMethodHandler(this));
            }
        }
        if (loginBehavior.getAllowsCustomTabAuth()) {
            arrayList.add(new CustomTabLoginMethodHandler(this));
        }
        if (loginBehavior.getAllowsWebViewAuth()) {
            arrayList.add(new WebViewLoginMethodHandler(this));
        }
        if (!request.isInstagramLogin() && loginBehavior.getAllowsDeviceAuth()) {
            arrayList.add(new DeviceAuthMethodHandler(this));
        }
        return (LoginMethodHandler[]) arrayList.toArray(new LoginMethodHandler[0]);
    }

    public final boolean checkInternetPermission() {
        if (this.checkedInternetPermission) {
            return true;
        }
        if (checkPermission("android.permission.INTERNET") != 0) {
            FragmentActivity activity = getActivity();
            complete(Result.Companion.createErrorResult$default(Result.INSTANCE, this.pendingRequest, activity != null ? activity.getString(com.facebook.common.R.string.com_facebook_internet_permission_error_title) : null, activity != null ? activity.getString(com.facebook.common.R.string.com_facebook_internet_permission_error_message) : null, null, 8, null));
            return false;
        }
        this.checkedInternetPermission = true;
        return true;
    }

    public final void tryNextHandler() {
        LoginMethodHandler currentHandler = getCurrentHandler();
        if (currentHandler != null) {
            logAuthorizationMethodComplete(currentHandler.getNameForLogging(), LoginLogger.EVENT_PARAM_METHOD_RESULT_SKIPPED, null, null, currentHandler.getMethodLoggingExtras());
        }
        LoginMethodHandler[] loginMethodHandlerArr = this.handlersToTry;
        while (loginMethodHandlerArr != null) {
            int i = this.currentHandler;
            if (i >= loginMethodHandlerArr.length - 1) {
                break;
            }
            this.currentHandler = i + 1;
            if (tryCurrentHandler()) {
                return;
            }
        }
        if (this.pendingRequest != null) {
            completeWithFailure();
        }
    }

    private final void completeWithFailure() {
        complete(Result.Companion.createErrorResult$default(Result.INSTANCE, this.pendingRequest, "Login attempt failed.", null, null, 8, null));
    }

    private final void addLoggingExtra(String key, String value, boolean accumulate) {
        HashMap map = this.loggingExtras;
        if (map == null) {
            map = new HashMap();
        }
        if (this.loggingExtras == null) {
            this.loggingExtras = map;
        }
        if (map.containsKey(key) && accumulate) {
            value = map.get(key) + ',' + value;
        }
        map.put(key, value);
    }

    public final void addExtraData(String key, String value, boolean accumulate) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        HashMap map = this.extraData;
        if (map == null) {
            map = new HashMap();
        }
        if (this.extraData == null) {
            this.extraData = map;
        }
        if (map.containsKey(key) && accumulate) {
            value = map.get(key) + ',' + value;
        }
        map.put(key, value);
    }

    public final boolean tryCurrentHandler() {
        LoginMethodHandler currentHandler = getCurrentHandler();
        if (currentHandler == null) {
            return false;
        }
        if (currentHandler.needsInternetPermission() && !checkInternetPermission()) {
            addLoggingExtra(LoginLogger.EVENT_EXTRAS_MISSING_INTERNET_PERMISSION, AppEventsConstants.EVENT_PARAM_VALUE_YES, false);
            return false;
        }
        Request request = this.pendingRequest;
        if (request == null) {
            return false;
        }
        int iTryAuthorize = currentHandler.tryAuthorize(request);
        this.numActivitiesReturned = 0;
        if (iTryAuthorize > 0) {
            getLogger().logAuthorizationMethodStart(request.getAuthId(), currentHandler.getNameForLogging(), request.getIsFamilyLogin() ? LoginLogger.EVENT_NAME_FOA_LOGIN_METHOD_START : LoginLogger.EVENT_NAME_LOGIN_METHOD_START);
            this.numTotalIntentsFired = iTryAuthorize;
        } else {
            getLogger().logAuthorizationMethodNotTried(request.getAuthId(), currentHandler.getNameForLogging(), request.getIsFamilyLogin() ? LoginLogger.EVENT_NAME_FOA_LOGIN_METHOD_NOT_TRIED : LoginLogger.EVENT_NAME_LOGIN_METHOD_NOT_TRIED);
            addLoggingExtra(LoginLogger.EVENT_EXTRAS_NOT_TRIED, currentHandler.getNameForLogging(), true);
        }
        return iTryAuthorize > 0;
    }

    public final void completeAndValidate(Result outcome) {
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        if (outcome.token != null && AccessToken.INSTANCE.isCurrentAccessTokenActive()) {
            validateSameFbidAndFinish(outcome);
        } else {
            complete(outcome);
        }
    }

    public final void complete(Result outcome) {
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        LoginMethodHandler currentHandler = getCurrentHandler();
        if (currentHandler != null) {
            logAuthorizationMethodComplete(currentHandler.getNameForLogging(), outcome, currentHandler.getMethodLoggingExtras());
        }
        Map<String, String> map = this.loggingExtras;
        if (map != null) {
            outcome.loggingExtras = map;
        }
        Map<String, String> map2 = this.extraData;
        if (map2 != null) {
            outcome.extraData = map2;
        }
        this.handlersToTry = null;
        this.currentHandler = -1;
        this.pendingRequest = null;
        this.loggingExtras = null;
        this.numActivitiesReturned = 0;
        this.numTotalIntentsFired = 0;
        notifyOnCompleteListener(outcome);
    }

    public final int checkPermission(String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity.checkCallingOrSelfPermission(permission);
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002f A[Catch: Exception -> 0x0042, TryCatch #0 {Exception -> 0x0042, blocks: (B:6:0x0014, B:8:0x0022, B:10:0x003e, B:9:0x002f), top: B:17:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void validateSameFbidAndFinish(com.facebook.login.LoginClient.Result r8) {
        /*
            r7 = this;
            java.lang.String r0 = "pendingResult"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.facebook.AccessToken r0 = r8.token
            if (r0 == 0) goto L59
            com.facebook.AccessToken$Companion r0 = com.facebook.AccessToken.INSTANCE
            com.facebook.AccessToken r0 = r0.getCurrentAccessToken()
            com.facebook.AccessToken r1 = r8.token
            if (r0 == 0) goto L2f
            java.lang.String r0 = r0.getUserId()     // Catch: java.lang.Exception -> L42
            java.lang.String r1 = r1.getUserId()     // Catch: java.lang.Exception -> L42
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)     // Catch: java.lang.Exception -> L42
            if (r0 == 0) goto L2f
            com.facebook.login.LoginClient$Result$Companion r0 = com.facebook.login.LoginClient.Result.INSTANCE     // Catch: java.lang.Exception -> L42
            com.facebook.login.LoginClient$Request r1 = r7.pendingRequest     // Catch: java.lang.Exception -> L42
            com.facebook.AccessToken r2 = r8.token     // Catch: java.lang.Exception -> L42
            com.facebook.AuthenticationToken r8 = r8.authenticationToken     // Catch: java.lang.Exception -> L42
            com.facebook.login.LoginClient$Result r8 = r0.createCompositeTokenResult(r1, r2, r8)     // Catch: java.lang.Exception -> L42
            goto L3e
        L2f:
            com.facebook.login.LoginClient$Result$Companion r0 = com.facebook.login.LoginClient.Result.INSTANCE     // Catch: java.lang.Exception -> L42
            com.facebook.login.LoginClient$Request r1 = r7.pendingRequest     // Catch: java.lang.Exception -> L42
            java.lang.String r2 = "User logged in as different Facebook user."
            r5 = 8
            r6 = 0
            r3 = 0
            r4 = 0
            com.facebook.login.LoginClient$Result r8 = com.facebook.login.LoginClient.Result.Companion.createErrorResult$default(r0, r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L42
        L3e:
            r7.complete(r8)     // Catch: java.lang.Exception -> L42
            goto L58
        L42:
            r8 = move-exception
            com.facebook.login.LoginClient$Result$Companion r0 = com.facebook.login.LoginClient.Result.INSTANCE
            com.facebook.login.LoginClient$Request r1 = r7.pendingRequest
            java.lang.String r3 = r8.getMessage()
            r5 = 8
            r6 = 0
            java.lang.String r2 = "Caught exception"
            r4 = 0
            com.facebook.login.LoginClient$Result r8 = com.facebook.login.LoginClient.Result.Companion.createErrorResult$default(r0, r1, r2, r3, r4, r5, r6)
            r7.complete(r8)
        L58:
            return
        L59:
            com.facebook.FacebookException r8 = new com.facebook.FacebookException
            java.lang.String r0 = "Can't validate without a token"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginClient.validateSameFbidAndFinish(com.facebook.login.LoginClient$Result):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.facebook.login.LoginLogger getLogger() {
        /*
            r3 = this;
            com.facebook.login.LoginLogger r0 = r3.loginLogger
            if (r0 == 0) goto L18
            java.lang.String r1 = r0.getApplicationId()
            com.facebook.login.LoginClient$Request r2 = r3.pendingRequest
            if (r2 == 0) goto L11
            java.lang.String r2 = r2.getApplicationId()
            goto L12
        L11:
            r2 = 0
        L12:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 != 0) goto L3a
        L18:
            com.facebook.login.LoginLogger r0 = new com.facebook.login.LoginLogger
            androidx.fragment.app.FragmentActivity r1 = r3.getActivity()
            if (r1 == 0) goto L23
            android.content.Context r1 = (android.content.Context) r1
            goto L27
        L23:
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()
        L27:
            com.facebook.login.LoginClient$Request r2 = r3.pendingRequest
            if (r2 == 0) goto L31
            java.lang.String r2 = r2.getApplicationId()
            if (r2 != 0) goto L35
        L31:
            java.lang.String r2 = com.facebook.FacebookSdk.getApplicationId()
        L35:
            r0.<init>(r1, r2)
            r3.loginLogger = r0
        L3a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginClient.getLogger():com.facebook.login.LoginLogger");
    }

    private final void notifyOnCompleteListener(Result outcome) {
        OnCompletedListener onCompletedListener = this.onCompletedListener;
        if (onCompletedListener != null) {
            onCompletedListener.onCompleted(outcome);
        }
    }

    public final void notifyBackgroundProcessingStart() {
        BackgroundProcessingListener backgroundProcessingListener = this.backgroundProcessingListener;
        if (backgroundProcessingListener != null) {
            backgroundProcessingListener.onBackgroundProcessingStarted();
        }
    }

    public final void notifyBackgroundProcessingStop() {
        BackgroundProcessingListener backgroundProcessingListener = this.backgroundProcessingListener;
        if (backgroundProcessingListener != null) {
            backgroundProcessingListener.onBackgroundProcessingStopped();
        }
    }

    private final void logAuthorizationMethodComplete(String method, Result result, Map<String, String> loggingExtras) {
        logAuthorizationMethodComplete(method, result.code.getLoggingValue(), result.errorMessage, result.errorCode, loggingExtras);
    }

    private final void logAuthorizationMethodComplete(String method, String result, String errorMessage, String errorCode, Map<String, String> loggingExtras) {
        Request request = this.pendingRequest;
        String str = LoginLogger.EVENT_NAME_LOGIN_METHOD_COMPLETE;
        if (request == null) {
            getLogger().logUnexpectedError(LoginLogger.EVENT_NAME_LOGIN_METHOD_COMPLETE, "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", method);
            return;
        }
        LoginLogger logger = getLogger();
        String authId = request.getAuthId();
        if (request.getIsFamilyLogin()) {
            str = LoginLogger.EVENT_NAME_FOA_LOGIN_METHOD_COMPLETE;
        }
        logger.logAuthorizationMethodComplete(authId, method, result, errorMessage, errorCode, loggingExtras, str);
    }

    /* compiled from: LoginClient.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 K2\u00020\u0001:\u0001KB{\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013B\u000f\b\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\b\u0010C\u001a\u00020DH\u0016J\u0006\u0010E\u001a\u00020+J\u000e\u0010F\u001a\u00020G2\u0006\u0010B\u001a\u00020+J\u0006\u0010B\u001a\u00020+J\u0018\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020\u00152\u0006\u0010J\u001a\u00020DH\u0016R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0018\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001bR\u001c\u0010'\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001bR\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010,\"\u0004\b-\u0010.R\u0011\u0010/\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b/\u0010,R\u001a\u00100\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u00104\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0018\"\u0004\b9\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0018R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010,\"\u0004\bA\u0010.R\u000e\u0010B\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/facebook/login/LoginClient$Request;", "Landroid/os/Parcelable;", "loginBehavior", "Lcom/facebook/login/LoginBehavior;", "permissions", "", "", "defaultAudience", "Lcom/facebook/login/DefaultAudience;", "authType", "applicationId", "authId", "targetApp", "Lcom/facebook/login/LoginTargetApp;", "nonce", "codeVerifier", "codeChallenge", "codeChallengeMethod", "Lcom/facebook/login/CodeChallengeMethod;", "(Lcom/facebook/login/LoginBehavior;Ljava/util/Set;Lcom/facebook/login/DefaultAudience;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/login/LoginTargetApp;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/login/CodeChallengeMethod;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getApplicationId", "()Ljava/lang/String;", "getAuthId", "setAuthId", "(Ljava/lang/String;)V", "getAuthType", "setAuthType", "getCodeChallenge", "getCodeChallengeMethod", "()Lcom/facebook/login/CodeChallengeMethod;", "getCodeVerifier", "getDefaultAudience", "()Lcom/facebook/login/DefaultAudience;", "deviceAuthTargetUserId", "getDeviceAuthTargetUserId", "setDeviceAuthTargetUserId", "deviceRedirectUriString", "getDeviceRedirectUriString", "setDeviceRedirectUriString", "isFamilyLogin", "", "()Z", "setFamilyLogin", "(Z)V", "isInstagramLogin", "isRerequest", "setRerequest", "getLoginBehavior", "()Lcom/facebook/login/LoginBehavior;", "loginTargetApp", "getLoginTargetApp", "()Lcom/facebook/login/LoginTargetApp;", "messengerPageId", "getMessengerPageId", "setMessengerPageId", "getNonce", "getPermissions", "()Ljava/util/Set;", "setPermissions", "(Ljava/util/Set;)V", "resetMessengerState", "getResetMessengerState", "setResetMessengerState", "shouldSkipAccountDeduplication", "describeContents", "", "hasPublishPermission", "setShouldSkipAccountDeduplication", "", "writeToParcel", "dest", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Request implements Parcelable {
        private final String applicationId;
        private String authId;
        private String authType;
        private final String codeChallenge;
        private final CodeChallengeMethod codeChallengeMethod;
        private final String codeVerifier;
        private final DefaultAudience defaultAudience;
        private String deviceAuthTargetUserId;
        private String deviceRedirectUriString;
        private boolean isFamilyLogin;
        private boolean isRerequest;
        private final LoginBehavior loginBehavior;
        private final LoginTargetApp loginTargetApp;
        private String messengerPageId;
        private final String nonce;
        private Set<String> permissions;
        private boolean resetMessengerState;
        private boolean shouldSkipAccountDeduplication;
        public static final Parcelable.Creator<Request> CREATOR = new Parcelable.Creator<Request>() { // from class: com.facebook.login.LoginClient$Request$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LoginClient.Request createFromParcel(Parcel source) {
                Intrinsics.checkNotNullParameter(source, "source");
                return new LoginClient.Request(source, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LoginClient.Request[] newArray(int size) {
                return new LoginClient.Request[size];
            }
        };

        public /* synthetic */ Request(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Request(LoginBehavior loginBehavior, Set<String> set, DefaultAudience defaultAudience, String authType, String applicationId, String authId) {
            this(loginBehavior, set, defaultAudience, authType, applicationId, authId, null, null, null, null, null, 1984, null);
            Intrinsics.checkNotNullParameter(loginBehavior, "loginBehavior");
            Intrinsics.checkNotNullParameter(defaultAudience, "defaultAudience");
            Intrinsics.checkNotNullParameter(authType, "authType");
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(authId, "authId");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Request(LoginBehavior loginBehavior, Set<String> set, DefaultAudience defaultAudience, String authType, String applicationId, String authId, LoginTargetApp loginTargetApp) {
            this(loginBehavior, set, defaultAudience, authType, applicationId, authId, loginTargetApp, null, null, null, null, 1920, null);
            Intrinsics.checkNotNullParameter(loginBehavior, "loginBehavior");
            Intrinsics.checkNotNullParameter(defaultAudience, "defaultAudience");
            Intrinsics.checkNotNullParameter(authType, "authType");
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(authId, "authId");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Request(LoginBehavior loginBehavior, Set<String> set, DefaultAudience defaultAudience, String authType, String applicationId, String authId, LoginTargetApp loginTargetApp, String str) {
            this(loginBehavior, set, defaultAudience, authType, applicationId, authId, loginTargetApp, str, null, null, null, 1792, null);
            Intrinsics.checkNotNullParameter(loginBehavior, "loginBehavior");
            Intrinsics.checkNotNullParameter(defaultAudience, "defaultAudience");
            Intrinsics.checkNotNullParameter(authType, "authType");
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(authId, "authId");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Request(LoginBehavior loginBehavior, Set<String> set, DefaultAudience defaultAudience, String authType, String applicationId, String authId, LoginTargetApp loginTargetApp, String str, String str2) {
            this(loginBehavior, set, defaultAudience, authType, applicationId, authId, loginTargetApp, str, str2, null, null, 1536, null);
            Intrinsics.checkNotNullParameter(loginBehavior, "loginBehavior");
            Intrinsics.checkNotNullParameter(defaultAudience, "defaultAudience");
            Intrinsics.checkNotNullParameter(authType, "authType");
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(authId, "authId");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Request(LoginBehavior loginBehavior, Set<String> set, DefaultAudience defaultAudience, String authType, String applicationId, String authId, LoginTargetApp loginTargetApp, String str, String str2, String str3) {
            this(loginBehavior, set, defaultAudience, authType, applicationId, authId, loginTargetApp, str, str2, str3, null, 1024, null);
            Intrinsics.checkNotNullParameter(loginBehavior, "loginBehavior");
            Intrinsics.checkNotNullParameter(defaultAudience, "defaultAudience");
            Intrinsics.checkNotNullParameter(authType, "authType");
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(authId, "authId");
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final LoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        public final Set<String> getPermissions() {
            return this.permissions;
        }

        public final void setPermissions(Set<String> set) {
            Intrinsics.checkNotNullParameter(set, "<set-?>");
            this.permissions = set;
        }

        public final DefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        public final String getApplicationId() {
            return this.applicationId;
        }

        public final String getAuthId() {
            return this.authId;
        }

        public final void setAuthId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.authId = str;
        }

        /* renamed from: isRerequest, reason: from getter */
        public final boolean getIsRerequest() {
            return this.isRerequest;
        }

        public final void setRerequest(boolean z) {
            this.isRerequest = z;
        }

        public final String getDeviceRedirectUriString() {
            return this.deviceRedirectUriString;
        }

        public final void setDeviceRedirectUriString(String str) {
            this.deviceRedirectUriString = str;
        }

        public final String getAuthType() {
            return this.authType;
        }

        public final void setAuthType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.authType = str;
        }

        public final String getDeviceAuthTargetUserId() {
            return this.deviceAuthTargetUserId;
        }

        public final void setDeviceAuthTargetUserId(String str) {
            this.deviceAuthTargetUserId = str;
        }

        public final String getMessengerPageId() {
            return this.messengerPageId;
        }

        public final void setMessengerPageId(String str) {
            this.messengerPageId = str;
        }

        public final boolean getResetMessengerState() {
            return this.resetMessengerState;
        }

        public final void setResetMessengerState(boolean z) {
            this.resetMessengerState = z;
        }

        public final LoginTargetApp getLoginTargetApp() {
            return this.loginTargetApp;
        }

        /* renamed from: isFamilyLogin, reason: from getter */
        public final boolean getIsFamilyLogin() {
            return this.isFamilyLogin;
        }

        public final void setFamilyLogin(boolean z) {
            this.isFamilyLogin = z;
        }

        public final String getNonce() {
            return this.nonce;
        }

        public final String getCodeVerifier() {
            return this.codeVerifier;
        }

        public final String getCodeChallenge() {
            return this.codeChallenge;
        }

        public final CodeChallengeMethod getCodeChallengeMethod() {
            return this.codeChallengeMethod;
        }

        public /* synthetic */ Request(LoginBehavior loginBehavior, Set set, DefaultAudience defaultAudience, String str, String str2, String str3, LoginTargetApp loginTargetApp, String str4, String str5, String str6, CodeChallengeMethod codeChallengeMethod, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(loginBehavior, set, defaultAudience, str, str2, str3, (i & 64) != 0 ? LoginTargetApp.FACEBOOK : loginTargetApp, (i & 128) != 0 ? null : str4, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? null : str6, (i & 1024) != 0 ? null : codeChallengeMethod);
        }

        public Request(LoginBehavior loginBehavior, HashSet hashSet, DefaultAudience defaultAudience, String authType, String applicationId, String authId, LoginTargetApp loginTargetApp, String str, String str2, String str3, CodeChallengeMethod codeChallengeMethod) {
            Intrinsics.checkNotNullParameter(loginBehavior, "loginBehavior");
            Intrinsics.checkNotNullParameter(defaultAudience, "defaultAudience");
            Intrinsics.checkNotNullParameter(authType, "authType");
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(authId, "authId");
            this.loginBehavior = loginBehavior;
            this.permissions = hashSet == null ? new HashSet() : hashSet;
            this.defaultAudience = defaultAudience;
            this.authType = authType;
            this.applicationId = applicationId;
            this.authId = authId;
            this.loginTargetApp = loginTargetApp == null ? LoginTargetApp.FACEBOOK : loginTargetApp;
            if (str == null || str.length() == 0) {
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
                this.nonce = string;
            } else {
                this.nonce = str;
            }
            this.codeVerifier = str2;
            this.codeChallenge = str3;
            this.codeChallengeMethod = codeChallengeMethod;
        }

        /* renamed from: shouldSkipAccountDeduplication, reason: from getter */
        public final boolean getShouldSkipAccountDeduplication() {
            return this.shouldSkipAccountDeduplication;
        }

        public final void setShouldSkipAccountDeduplication(boolean shouldSkipAccountDeduplication) {
            this.shouldSkipAccountDeduplication = shouldSkipAccountDeduplication;
        }

        public final boolean hasPublishPermission() {
            Iterator<String> it = this.permissions.iterator();
            while (it.hasNext()) {
                if (LoginManager.Companion.isPublishPermission(it.next())) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isInstagramLogin() {
            return this.loginTargetApp == LoginTargetApp.INSTAGRAM;
        }

        private Request(Parcel parcel) {
            DefaultAudience defaultAudienceValueOf;
            LoginTargetApp loginTargetAppValueOf;
            this.loginBehavior = LoginBehavior.valueOf(Validate.notNullOrEmpty(parcel.readString(), "loginBehavior"));
            ArrayList arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            this.permissions = new HashSet(arrayList);
            String string = parcel.readString();
            if (string != null) {
                defaultAudienceValueOf = DefaultAudience.valueOf(string);
            } else {
                defaultAudienceValueOf = DefaultAudience.NONE;
            }
            this.defaultAudience = defaultAudienceValueOf;
            this.applicationId = Validate.notNullOrEmpty(parcel.readString(), "applicationId");
            this.authId = Validate.notNullOrEmpty(parcel.readString(), "authId");
            this.isRerequest = parcel.readByte() != 0;
            this.deviceRedirectUriString = parcel.readString();
            this.authType = Validate.notNullOrEmpty(parcel.readString(), "authType");
            this.deviceAuthTargetUserId = parcel.readString();
            this.messengerPageId = parcel.readString();
            this.resetMessengerState = parcel.readByte() != 0;
            String string2 = parcel.readString();
            if (string2 != null) {
                loginTargetAppValueOf = LoginTargetApp.valueOf(string2);
            } else {
                loginTargetAppValueOf = LoginTargetApp.FACEBOOK;
            }
            this.loginTargetApp = loginTargetAppValueOf;
            this.isFamilyLogin = parcel.readByte() != 0;
            this.shouldSkipAccountDeduplication = parcel.readByte() != 0;
            this.nonce = Validate.notNullOrEmpty(parcel.readString(), "nonce");
            this.codeVerifier = parcel.readString();
            this.codeChallenge = parcel.readString();
            String string3 = parcel.readString();
            this.codeChallengeMethod = string3 != null ? CodeChallengeMethod.valueOf(string3) : null;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.loginBehavior.name());
            dest.writeStringList(new ArrayList(this.permissions));
            dest.writeString(this.defaultAudience.name());
            dest.writeString(this.applicationId);
            dest.writeString(this.authId);
            dest.writeByte(this.isRerequest ? (byte) 1 : (byte) 0);
            dest.writeString(this.deviceRedirectUriString);
            dest.writeString(this.authType);
            dest.writeString(this.deviceAuthTargetUserId);
            dest.writeString(this.messengerPageId);
            dest.writeByte(this.resetMessengerState ? (byte) 1 : (byte) 0);
            dest.writeString(this.loginTargetApp.name());
            dest.writeByte(this.isFamilyLogin ? (byte) 1 : (byte) 0);
            dest.writeByte(this.shouldSkipAccountDeduplication ? (byte) 1 : (byte) 0);
            dest.writeString(this.nonce);
            dest.writeString(this.codeVerifier);
            dest.writeString(this.codeChallenge);
            CodeChallengeMethod codeChallengeMethod = this.codeChallengeMethod;
            dest.writeString(codeChallengeMethod != null ? codeChallengeMethod.name() : null);
        }
    }

    /* compiled from: LoginClient.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB7\b\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bBA\b\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000fB\u000f\b\u0012\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0017H\u0016R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/facebook/login/LoginClient$Result;", "Landroid/os/Parcelable;", "request", "Lcom/facebook/login/LoginClient$Request;", "code", "Lcom/facebook/login/LoginClient$Result$Code;", "token", "Lcom/facebook/AccessToken;", "errorMessage", "", "errorCode", "(Lcom/facebook/login/LoginClient$Request;Lcom/facebook/login/LoginClient$Result$Code;Lcom/facebook/AccessToken;Ljava/lang/String;Ljava/lang/String;)V", SDKConstants.PARAM_ACCESS_TOKEN, "authenticationToken", "Lcom/facebook/AuthenticationToken;", "(Lcom/facebook/login/LoginClient$Request;Lcom/facebook/login/LoginClient$Result$Code;Lcom/facebook/AccessToken;Lcom/facebook/AuthenticationToken;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", ExceptionDataHelper.EXTRA_DATA_FIELD, "", "loggingExtras", "describeContents", "", "writeToParcel", "", "dest", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "Code", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Result implements Parcelable {
        public final AuthenticationToken authenticationToken;
        public final Code code;
        public final String errorCode;
        public final String errorMessage;
        public Map<String, String> extraData;
        public Map<String, String> loggingExtras;
        public final Request request;
        public final AccessToken token;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() { // from class: com.facebook.login.LoginClient$Result$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LoginClient.Result createFromParcel(Parcel source) {
                Intrinsics.checkNotNullParameter(source, "source");
                return new LoginClient.Result(source, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LoginClient.Result[] newArray(int size) {
                return new LoginClient.Result[size];
            }
        };

        public /* synthetic */ Result(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        @JvmStatic
        public static final Result createCancelResult(Request request, String str) {
            return INSTANCE.createCancelResult(request, str);
        }

        @JvmStatic
        public static final Result createCompositeTokenResult(Request request, AccessToken accessToken, AuthenticationToken authenticationToken) {
            return INSTANCE.createCompositeTokenResult(request, accessToken, authenticationToken);
        }

        @JvmStatic
        public static final Result createErrorResult(Request request, String str, String str2) {
            return INSTANCE.createErrorResult(request, str, str2);
        }

        @JvmStatic
        public static final Result createErrorResult(Request request, String str, String str2, String str3) {
            return INSTANCE.createErrorResult(request, str, str2, str3);
        }

        @JvmStatic
        public static final Result createTokenResult(Request request, AccessToken accessToken) {
            return INSTANCE.createTokenResult(request, accessToken);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* compiled from: LoginClient.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/facebook/login/LoginClient$Result$Code;", "", "loggingValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getLoggingValue", "()Ljava/lang/String;", "SUCCESS", "CANCEL", "ERROR", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public enum Code {
            SUCCESS("success"),
            CANCEL("cancel"),
            ERROR("error");

            private final String loggingValue;

            Code(String str) {
                this.loggingValue = str;
            }

            public final String getLoggingValue() {
                return this.loggingValue;
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Result(Request request, Code code, AccessToken accessToken, String str, String str2) {
            this(request, code, accessToken, null, str, str2);
            Intrinsics.checkNotNullParameter(code, "code");
        }

        public Result(Request request, Code code, AccessToken accessToken, AuthenticationToken authenticationToken, String str, String str2) {
            Intrinsics.checkNotNullParameter(code, "code");
            this.request = request;
            this.token = accessToken;
            this.authenticationToken = authenticationToken;
            this.errorMessage = str;
            this.code = code;
            this.errorCode = str2;
        }

        private Result(Parcel parcel) {
            String string = parcel.readString();
            this.code = Code.valueOf(string == null ? "error" : string);
            this.token = (AccessToken) parcel.readParcelable(AccessToken.class.getClassLoader());
            this.authenticationToken = (AuthenticationToken) parcel.readParcelable(AuthenticationToken.class.getClassLoader());
            this.errorMessage = parcel.readString();
            this.errorCode = parcel.readString();
            this.request = (Request) parcel.readParcelable(Request.class.getClassLoader());
            this.loggingExtras = Utility.readNonnullStringMapFromParcel(parcel);
            this.extraData = Utility.readNonnullStringMapFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.code.name());
            dest.writeParcelable(this.token, flags);
            dest.writeParcelable(this.authenticationToken, flags);
            dest.writeString(this.errorMessage);
            dest.writeString(this.errorCode);
            dest.writeParcelable(this.request, flags);
            Utility.writeNonnullStringMapToParcel(dest, this.loggingExtras);
            Utility.writeNonnullStringMapToParcel(dest, this.extraData);
        }

        /* compiled from: LoginClient.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J&\u0010\u000b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J2\u0010\u0010\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0007J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\rH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/login/LoginClient$Result$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/LoginClient$Result;", "createCancelResult", "request", "Lcom/facebook/login/LoginClient$Request;", "message", "", "createCompositeTokenResult", SDKConstants.PARAM_ACCESS_TOKEN, "Lcom/facebook/AccessToken;", "authenticationToken", "Lcom/facebook/AuthenticationToken;", "createErrorResult", "errorType", "errorDescription", "errorCode", "createTokenResult", "token", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final Result createErrorResult(Request request, String str, String str2) {
                return createErrorResult$default(this, request, str, str2, null, 8, null);
            }

            private Companion() {
            }

            @JvmStatic
            public final Result createTokenResult(Request request, AccessToken token) {
                Intrinsics.checkNotNullParameter(token, "token");
                return new Result(request, Code.SUCCESS, token, null, null);
            }

            @JvmStatic
            public final Result createCompositeTokenResult(Request request, AccessToken accessToken, AuthenticationToken authenticationToken) {
                return new Result(request, Code.SUCCESS, accessToken, authenticationToken, null, null);
            }

            @JvmStatic
            public final Result createCancelResult(Request request, String message) {
                return new Result(request, Code.CANCEL, null, message, null);
            }

            public static /* synthetic */ Result createErrorResult$default(Companion companion, Request request, String str, String str2, String str3, int i, Object obj) {
                if ((i & 8) != 0) {
                    str3 = null;
                }
                return companion.createErrorResult(request, str, str2, str3);
            }

            @JvmStatic
            public final Result createErrorResult(Request request, String errorType, String errorDescription, String errorCode) {
                ArrayList arrayList = new ArrayList();
                if (errorType != null) {
                    arrayList.add(errorType);
                }
                if (errorDescription != null) {
                    arrayList.add(errorDescription);
                }
                return new Result(request, Code.ERROR, null, TextUtils.join(": ", arrayList), errorCode);
            }
        }
    }

    public LoginClient(Parcel source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.currentHandler = -1;
        Parcelable[] parcelableArray = source.readParcelableArray(LoginMethodHandler.class.getClassLoader());
        parcelableArray = parcelableArray == null ? new Parcelable[0] : parcelableArray;
        ArrayList arrayList = new ArrayList();
        int length = parcelableArray.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Parcelable parcelable = parcelableArray[i];
            LoginMethodHandler loginMethodHandler = parcelable instanceof LoginMethodHandler ? (LoginMethodHandler) parcelable : null;
            if (loginMethodHandler != null) {
                loginMethodHandler.setLoginClient(this);
            }
            if (loginMethodHandler != null) {
                arrayList.add(loginMethodHandler);
            }
            i++;
        }
        this.handlersToTry = (LoginMethodHandler[]) arrayList.toArray(new LoginMethodHandler[0]);
        this.currentHandler = source.readInt();
        this.pendingRequest = (Request) source.readParcelable(Request.class.getClassLoader());
        Map<String, String> nonnullStringMapFromParcel = Utility.readNonnullStringMapFromParcel(source);
        this.loggingExtras = nonnullStringMapFromParcel != null ? MapsKt.toMutableMap(nonnullStringMapFromParcel) : null;
        Map<String, String> nonnullStringMapFromParcel2 = Utility.readNonnullStringMapFromParcel(source);
        this.extraData = nonnullStringMapFromParcel2 != null ? MapsKt.toMutableMap(nonnullStringMapFromParcel2) : null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeParcelableArray(this.handlersToTry, flags);
        dest.writeInt(this.currentHandler);
        dest.writeParcelable(this.pendingRequest, flags);
        Utility.writeNonnullStringMapToParcel(dest, this.loggingExtras);
        Utility.writeNonnullStringMapToParcel(dest, this.extraData);
    }

    /* compiled from: LoginClient.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\tH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/login/LoginClient$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/LoginClient;", "getE2E", "", "getLoginRequestCode", "", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final int getLoginRequestCode() {
            return CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
        }

        @JvmStatic
        public final String getE2E() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Session.JsonKeys.INIT, System.currentTimeMillis());
            } catch (JSONException unused) {
            }
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "e2e.toString()");
            return string;
        }
    }
}
