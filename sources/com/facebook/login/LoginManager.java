package com.facebook.login;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.LoginStatusCallback;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginManager;
import io.sentry.SentryEvent;
import io.sentry.protocol.Request;
import io.sentry.protocol.Response;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: LoginManager.kt */
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 y2\u00020\u0001:\u0006wxyz{|B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u001e\u001a\u00060\u001fR\u00020\u00002\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010#\u001a\u00020$2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&H\u0014J\u0010\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020,H\u0014J\b\u0010-\u001a\u00020$H\u0014JH\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u00010$2\b\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\r2\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000109H\u0002J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020$H\u0014JL\u0010>\u001a\u00020/2\b\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020B2\u0014\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010D2\b\u00105\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020\r2\b\u0010=\u001a\u0004\u0018\u00010$H\u0002J\u0016\u0010G\u001a\u00020/2\u0006\u0010H\u001a\u00020I2\u0006\u0010+\u001a\u00020,J\u001e\u0010G\u001a\u00020/2\u0006\u0010H\u001a\u00020I2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&J(\u0010G\u001a\u00020/2\u0006\u0010H\u001a\u00020I2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&2\b\u0010\"\u001a\u0004\u0018\u00010\u0004J\u001e\u0010G\u001a\u00020/2\u0006\u0010J\u001a\u00020K2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&J(\u0010G\u001a\u00020/2\u0006\u0010J\u001a\u00020K2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&2\b\u0010\"\u001a\u0004\u0018\u00010\u0004J \u0010G\u001a\u00020/2\u0006\u0010L\u001a\u00020M2\u0006\u0010 \u001a\u00020!2\u0006\u0010+\u001a\u00020,H\u0002J$\u0010G\u001a\u00020/2\u0006\u0010L\u001a\u00020M2\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&J.\u0010G\u001a\u00020/2\u0006\u0010L\u001a\u00020M2\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&2\b\u0010\"\u001a\u0004\u0018\u00010\u0004J\u001e\u0010G\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&J(\u0010G\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&2\b\u0010\"\u001a\u0004\u0018\u00010\u0004J\u0016\u0010G\u001a\u00020/2\u0006\u0010J\u001a\u00020O2\u0006\u0010+\u001a\u00020,J\u001e\u0010G\u001a\u00020/2\u0006\u0010J\u001a\u00020O2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&J(\u0010G\u001a\u00020/2\u0006\u0010J\u001a\u00020O2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&2\b\u0010\"\u001a\u0004\u0018\u00010\u0004J\u0016\u0010P\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\u0006\u0010+\u001a\u00020,J\u001e\u0010Q\u001a\u00020/2\u0006\u0010H\u001a\u00020I2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&J\u001c\u0010Q\u001a\u00020/2\u0006\u0010J\u001a\u00020K2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&J$\u0010Q\u001a\u00020/2\u0006\u0010L\u001a\u00020M2\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&J$\u0010Q\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&J\u001e\u0010Q\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0007J\u001e\u0010Q\u001a\u00020/2\u0006\u0010J\u001a\u00020O2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0002J\u001e\u0010R\u001a\u00020/2\u0006\u0010H\u001a\u00020I2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&J\u001c\u0010R\u001a\u00020/2\u0006\u0010J\u001a\u00020K2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&J$\u0010R\u001a\u00020/2\u0006\u0010L\u001a\u00020M2\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&J$\u0010R\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&J\u001e\u0010R\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0007J\u001e\u0010R\u001a\u00020/2\u0006\u0010J\u001a\u00020O2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0002J\b\u0010S\u001a\u00020/H\u0016J\u001c\u0010T\u001a\u00020/2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010U\u001a\u0004\u0018\u00010$H\u0002J\u0016\u0010V\u001a\u00020/2\u0006\u0010H\u001a\u00020I2\u0006\u0010+\u001a\u00020,J\u0018\u0010V\u001a\u00020/2\u0006\u0010J\u001a\u00020O2\u0006\u0010+\u001a\u00020,H\u0002J,\u0010W\u001a\u00020\r2\u0006\u0010X\u001a\u00020Y2\b\u0010Z\u001a\u0004\u0018\u00010<2\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000109H\u0017J\u000e\u0010[\u001a\u00020/2\u0006\u0010H\u001a\u00020IJ\u000e\u0010[\u001a\u00020/2\u0006\u0010J\u001a\u00020NJ\u0010\u0010[\u001a\u00020/2\u0006\u0010J\u001a\u00020OH\u0002J \u0010\\\u001a\u00020/2\b\u0010 \u001a\u0004\u0018\u00010!2\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000109J\u0016\u0010]\u001a\u00020/2\u0006\u0010H\u001a\u00020I2\u0006\u0010(\u001a\u00020)J\u0016\u0010]\u001a\u00020/2\u0006\u0010J\u001a\u00020K2\u0006\u0010(\u001a\u00020)J\u001e\u0010]\u001a\u00020/2\u0006\u0010L\u001a\u00020M2\u0006\u0010 \u001a\u00020!2\u0006\u0010(\u001a\u00020)J\u001e\u0010]\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\u0006\u0010 \u001a\u00020!2\u0006\u0010(\u001a\u00020)J\u0018\u0010]\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\u0006\u0010(\u001a\u00020)H\u0007J\u0018\u0010]\u001a\u00020/2\u0006\u0010J\u001a\u00020O2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010^\u001a\u00020\r2\u0006\u0010_\u001a\u00020<H\u0002J\u0016\u0010`\u001a\u00020/2\u0006\u0010?\u001a\u00020@2\u0006\u0010a\u001a\u00020bJ\u001e\u0010`\u001a\u00020/2\u0006\u0010?\u001a\u00020@2\u0006\u0010c\u001a\u00020d2\u0006\u0010a\u001a\u00020bJ \u0010e\u001a\u00020/2\u0006\u0010?\u001a\u00020@2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020dH\u0002J\u000e\u0010f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010g\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010h\u001a\u00020/2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010i\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\rJ\u000e\u0010j\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010k\u001a\u00020\u00002\u0006\u0010l\u001a\u00020\u0014J\u0010\u0010m\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004J\u000e\u0010n\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\rJ\u000e\u0010o\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\rJ\u0018\u0010p\u001a\u00020/2\u0006\u0010q\u001a\u00020r2\u0006\u0010=\u001a\u00020$H\u0002J\u0018\u0010s\u001a\u00020\r2\u0006\u0010q\u001a\u00020r2\u0006\u0010=\u001a\u00020$H\u0002J\u0010\u0010t\u001a\u00020/2\b\u0010 \u001a\u0004\u0018\u00010!J\u0018\u0010u\u001a\u00020/2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&H\u0002J\u0018\u0010v\u001a\u00020/2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&H\u0002R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0014@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000e¨\u0006}"}, d2 = {"Lcom/facebook/login/LoginManager;", "", "()V", "<set-?>", "", "authType", "getAuthType", "()Ljava/lang/String;", "Lcom/facebook/login/DefaultAudience;", "defaultAudience", "getDefaultAudience", "()Lcom/facebook/login/DefaultAudience;", "isExpressLoginAllowed", "", "()Z", "isFamilyLogin", "Lcom/facebook/login/LoginBehavior;", "loginBehavior", "getLoginBehavior", "()Lcom/facebook/login/LoginBehavior;", "Lcom/facebook/login/LoginTargetApp;", "loginTargetApp", "getLoginTargetApp", "()Lcom/facebook/login/LoginTargetApp;", "messengerPageId", "resetMessengerState", "sharedPreferences", "Landroid/content/SharedPreferences;", "shouldSkipAccountDeduplication", "getShouldSkipAccountDeduplication", "createLogInActivityResultContract", "Lcom/facebook/login/LoginManager$FacebookLoginActivityResultContract;", "callbackManager", "Lcom/facebook/CallbackManager;", "loggerID", "createLoginRequest", "Lcom/facebook/login/LoginClient$Request;", "permissions", "", "createLoginRequestFromResponse", Response.TYPE, "Lcom/facebook/GraphResponse;", "createLoginRequestWithConfig", "loginConfig", "Lcom/facebook/login/LoginConfiguration;", "createReauthorizeRequest", "finishLogin", "", "newToken", "Lcom/facebook/AccessToken;", "newIdToken", "Lcom/facebook/AuthenticationToken;", "origRequest", "exception", "Lcom/facebook/FacebookException;", "isCanceled", "callback", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/login/LoginResult;", "getFacebookActivityIntent", "Landroid/content/Intent;", "request", "logCompleteLogin", "context", "Landroid/content/Context;", "result", "Lcom/facebook/login/LoginClient$Result$Code;", "resultExtras", "", "Ljava/lang/Exception;", "wasLoginActivityTried", "logIn", "activity", "Landroid/app/Activity;", Request.JsonKeys.FRAGMENT, "Landroid/app/Fragment;", "activityResultRegistryOwner", "Landroidx/activity/result/ActivityResultRegistryOwner;", "Landroidx/fragment/app/Fragment;", "Lcom/facebook/internal/FragmentWrapper;", "logInWithConfiguration", "logInWithPublishPermissions", "logInWithReadPermissions", "logOut", "logStartLogin", "loginRequest", "loginWithConfiguration", "onActivityResult", "resultCode", "", "data", "reauthorizeDataAccess", "registerCallback", "resolveError", "resolveIntent", SDKConstants.PARAM_INTENT, "retrieveLoginStatus", "responseCallback", "Lcom/facebook/LoginStatusCallback;", "toastDurationMs", "", "retrieveLoginStatusImpl", "setAuthType", "setDefaultAudience", "setExpressLoginStatus", "setFamilyLogin", "setLoginBehavior", "setLoginTargetApp", "targetApp", "setMessengerPageId", "setResetMessengerState", "setShouldSkipAccountDeduplication", "startLogin", "startActivityDelegate", "Lcom/facebook/login/StartActivityDelegate;", "tryFacebookActivity", "unregisterCallback", "validatePublishPermissions", "validateReadPermissions", "ActivityStartActivityDelegate", "AndroidxActivityResultRegistryOwnerStartActivityDelegate", "Companion", "FacebookLoginActivityResultContract", "FragmentStartActivityDelegate", "LoginLoggerHolder", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public class LoginManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final String EXPRESS_LOGIN_ALLOWED = "express_login_allowed";
    private static final String MANAGE_PERMISSION_PREFIX = "manage";
    private static final Set<String> OTHER_PUBLISH_PERMISSIONS;
    private static final String PREFERENCE_LOGIN_MANAGER = "com.facebook.loginManager";
    private static final String PUBLISH_PERMISSION_PREFIX = "publish";
    private static final String TAG;
    private static volatile LoginManager instance;
    private boolean isFamilyLogin;
    private String messengerPageId;
    private boolean resetMessengerState;
    private final SharedPreferences sharedPreferences;
    private boolean shouldSkipAccountDeduplication;
    private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
    private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
    private String authType = ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE;
    private LoginTargetApp loginTargetApp = LoginTargetApp.FACEBOOK;

    @JvmStatic
    public static final LoginResult computeLoginResult(LoginClient.Request request, AccessToken accessToken, AuthenticationToken authenticationToken) {
        return INSTANCE.computeLoginResult(request, accessToken, authenticationToken);
    }

    @JvmStatic
    public static final Map<String, String> getExtraDataFromIntent(Intent intent) {
        return INSTANCE.getExtraDataFromIntent(intent);
    }

    @JvmStatic
    public static LoginManager getInstance() {
        return INSTANCE.getInstance();
    }

    @JvmStatic
    public static final boolean isPublishPermission(String str) {
        return INSTANCE.isPublishPermission(str);
    }

    public final FacebookLoginActivityResultContract createLogInActivityResultContract() {
        return createLogInActivityResultContract$default(this, null, null, 3, null);
    }

    public final FacebookLoginActivityResultContract createLogInActivityResultContract(CallbackManager callbackManager) {
        return createLogInActivityResultContract$default(this, callbackManager, null, 2, null);
    }

    public final boolean onActivityResult(int i, Intent intent) {
        return onActivityResult$default(this, i, intent, null, 4, null);
    }

    public LoginManager() {
        Validate.sdkInitialized();
        SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(PREFERENCE_LOGIN_MANAGER, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getApplicationContext().…ER, Context.MODE_PRIVATE)");
        this.sharedPreferences = sharedPreferences;
        if (!FacebookSdk.hasCustomTabsPrefetching || CustomTabUtils.getChromePackage() == null) {
            return;
        }
        CustomTabsClient.bindCustomTabsService(FacebookSdk.getApplicationContext(), "com.android.chrome", new CustomTabPrefetchHelper());
        CustomTabsClient.connectAndInitialize(FacebookSdk.getApplicationContext(), FacebookSdk.getApplicationContext().getPackageName());
    }

    public final LoginBehavior getLoginBehavior() {
        return this.loginBehavior;
    }

    public final DefaultAudience getDefaultAudience() {
        return this.defaultAudience;
    }

    public final String getAuthType() {
        return this.authType;
    }

    public final LoginTargetApp getLoginTargetApp() {
        return this.loginTargetApp;
    }

    /* renamed from: isFamilyLogin, reason: from getter */
    public final boolean getIsFamilyLogin() {
        return this.isFamilyLogin;
    }

    public final boolean getShouldSkipAccountDeduplication() {
        return this.shouldSkipAccountDeduplication;
    }

    public final void resolveError(Activity activity, GraphResponse response) throws FacebookException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(response, "response");
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestFromResponse(response));
    }

    @Deprecated(message = "")
    public final void resolveError(Fragment fragment, GraphResponse response) throws FacebookException {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(response, "response");
        resolveError(new FragmentWrapper(fragment), response);
    }

    public final void resolveError(Fragment fragment, CallbackManager callbackManager, GraphResponse response) throws FacebookException {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(response, "response");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            resolveError(activity, callbackManager, response);
            return;
        }
        throw new FacebookException("Cannot obtain activity context on the fragment " + fragment);
    }

    public final void resolveError(android.app.Fragment fragment, GraphResponse response) throws FacebookException {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(response, "response");
        resolveError(new FragmentWrapper(fragment), response);
    }

    private final void resolveError(FragmentWrapper fragment, GraphResponse response) throws FacebookException {
        startLogin(new FragmentStartActivityDelegate(fragment), createLoginRequestFromResponse(response));
    }

    public final void resolveError(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, GraphResponse response) throws FacebookException {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(response, "response");
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(activityResultRegistryOwner, callbackManager), createLoginRequestFromResponse(response));
    }

    private final LoginClient.Request createLoginRequestFromResponse(GraphResponse response) {
        Set<String> permissions;
        AccessToken accessToken = response.getRequest().getAccessToken();
        return createLoginRequest((accessToken == null || (permissions = accessToken.getPermissions()) == null) ? null : CollectionsKt.filterNotNull(permissions));
    }

    public final void registerCallback(CallbackManager callbackManager, final FacebookCallback<LoginResult> callback) {
        if (!(callbackManager instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        ((CallbackManagerImpl) callbackManager).registerCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback() { // from class: com.facebook.login.LoginManager$$ExternalSyntheticLambda0
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public final boolean onActivityResult(int i, Intent intent) {
                return LoginManager.registerCallback$lambda$0(this.f$0, callback, i, intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean registerCallback$lambda$0(LoginManager this$0, FacebookCallback facebookCallback, int i, Intent intent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.onActivityResult(i, intent, facebookCallback);
    }

    public final void unregisterCallback(CallbackManager callbackManager) {
        if (!(callbackManager instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        ((CallbackManagerImpl) callbackManager).unregisterCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean onActivityResult$default(LoginManager loginManager, int i, Intent intent, FacebookCallback facebookCallback, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onActivityResult");
        }
        if ((i2 & 4) != 0) {
            facebookCallback = null;
        }
        return loginManager.onActivityResult(i, intent, facebookCallback);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onActivityResult(int r16, android.content.Intent r17, com.facebook.FacebookCallback<com.facebook.login.LoginResult> r18) {
        /*
            r15 = this;
            r0 = r16
            r1 = r17
            com.facebook.login.LoginClient$Result$Code r2 = com.facebook.login.LoginClient.Result.Code.ERROR
            r3 = 1
            r4 = 0
            r5 = 0
            if (r1 == 0) goto L4a
            java.lang.Class<com.facebook.login.LoginClient$Result> r6 = com.facebook.login.LoginClient.Result.class
            java.lang.ClassLoader r6 = r6.getClassLoader()
            r1.setExtrasClassLoader(r6)
            java.lang.String r6 = "com.facebook.LoginFragment:Result"
            android.os.Parcelable r1 = r1.getParcelableExtra(r6)
            com.facebook.login.LoginClient$Result r1 = (com.facebook.login.LoginClient.Result) r1
            if (r1 == 0) goto L55
            com.facebook.login.LoginClient$Request r2 = r1.request
            com.facebook.login.LoginClient$Result$Code r6 = r1.code
            r7 = -1
            if (r0 == r7) goto L2c
            if (r0 == 0) goto L2a
        L27:
            r0 = r4
            r7 = r0
            goto L43
        L2a:
            r5 = r3
            goto L27
        L2c:
            com.facebook.login.LoginClient$Result$Code r0 = r1.code
            com.facebook.login.LoginClient$Result$Code r7 = com.facebook.login.LoginClient.Result.Code.SUCCESS
            if (r0 != r7) goto L37
            com.facebook.AccessToken r0 = r1.token
            com.facebook.AuthenticationToken r7 = r1.authenticationToken
            goto L43
        L37:
            com.facebook.FacebookAuthorizationException r0 = new com.facebook.FacebookAuthorizationException
            java.lang.String r7 = r1.errorMessage
            r0.<init>(r7)
            com.facebook.FacebookException r0 = (com.facebook.FacebookException) r0
            r7 = r4
            r4 = r0
            r0 = r7
        L43:
            java.util.Map<java.lang.String, java.lang.String> r1 = r1.loggingExtras
            r8 = r1
            r13 = r5
            r1 = r7
            r7 = r6
            goto L5b
        L4a:
            if (r0 != 0) goto L55
            com.facebook.login.LoginClient$Result$Code r2 = com.facebook.login.LoginClient.Result.Code.CANCEL
            r7 = r2
            r13 = r3
            r0 = r4
            r1 = r0
            r2 = r1
            r8 = r2
            goto L5b
        L55:
            r7 = r2
            r0 = r4
            r1 = r0
            r2 = r1
            r8 = r2
            r13 = r5
        L5b:
            if (r4 != 0) goto L68
            if (r0 != 0) goto L68
            if (r13 != 0) goto L68
            com.facebook.FacebookException r4 = new com.facebook.FacebookException
            java.lang.String r5 = "Unexpected call to LoginManager.onActivityResult"
            r4.<init>(r5)
        L68:
            r12 = r4
            r6 = 0
            r9 = r12
            java.lang.Exception r9 = (java.lang.Exception) r9
            r10 = 1
            r5 = r15
            r11 = r2
            r5.logCompleteLogin(r6, r7, r8, r9, r10, r11)
            r8 = r15
            r9 = r0
            r10 = r1
            r14 = r18
            r8.finishLogin(r9, r10, r11, r12, r13, r14)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginManager.onActivityResult(int, android.content.Intent, com.facebook.FacebookCallback):boolean");
    }

    public final LoginManager setLoginBehavior(LoginBehavior loginBehavior) {
        Intrinsics.checkNotNullParameter(loginBehavior, "loginBehavior");
        this.loginBehavior = loginBehavior;
        return this;
    }

    public final LoginManager setLoginTargetApp(LoginTargetApp targetApp) {
        Intrinsics.checkNotNullParameter(targetApp, "targetApp");
        this.loginTargetApp = targetApp;
        return this;
    }

    public final LoginManager setDefaultAudience(DefaultAudience defaultAudience) {
        Intrinsics.checkNotNullParameter(defaultAudience, "defaultAudience");
        this.defaultAudience = defaultAudience;
        return this;
    }

    public final LoginManager setAuthType(String authType) {
        Intrinsics.checkNotNullParameter(authType, "authType");
        this.authType = authType;
        return this;
    }

    public final LoginManager setMessengerPageId(String messengerPageId) {
        this.messengerPageId = messengerPageId;
        return this;
    }

    public final LoginManager setResetMessengerState(boolean resetMessengerState) {
        this.resetMessengerState = resetMessengerState;
        return this;
    }

    public final LoginManager setFamilyLogin(boolean isFamilyLogin) {
        this.isFamilyLogin = isFamilyLogin;
        return this;
    }

    public final LoginManager setShouldSkipAccountDeduplication(boolean shouldSkipAccountDeduplication) {
        this.shouldSkipAccountDeduplication = shouldSkipAccountDeduplication;
        return this;
    }

    public void logOut() {
        AccessToken.INSTANCE.setCurrentAccessToken(null);
        AuthenticationToken.INSTANCE.setCurrentAuthenticationToken(null);
        Profile.INSTANCE.setCurrentProfile(null);
        setExpressLoginStatus(false);
    }

    public final void retrieveLoginStatus(Context context, LoginStatusCallback responseCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        retrieveLoginStatus(context, 5000L, responseCallback);
    }

    public final void retrieveLoginStatus(Context context, long toastDurationMs, LoginStatusCallback responseCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        retrieveLoginStatusImpl(context, responseCallback, toastDurationMs);
    }

    @Deprecated(message = "")
    public final void logInWithReadPermissions(Fragment fragment, Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        logInWithReadPermissions(new FragmentWrapper(fragment), permissions);
    }

    public final void logInWithReadPermissions(Fragment fragment, CallbackManager callbackManager, Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            logInWithReadPermissions(activity, callbackManager, permissions);
            return;
        }
        throw new FacebookException("Cannot obtain activity context on the fragment " + fragment);
    }

    public final void logInWithReadPermissions(android.app.Fragment fragment, Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        logInWithReadPermissions(new FragmentWrapper(fragment), permissions);
    }

    private final void logInWithReadPermissions(FragmentWrapper fragment, Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        validateReadPermissions(permissions);
        logIn(fragment, new LoginConfiguration(permissions, null, 2, null));
    }

    public final void logInWithReadPermissions(Activity activity, Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        validateReadPermissions(permissions);
        logIn(activity, new LoginConfiguration(permissions, null, 2, null));
    }

    public final void logInWithReadPermissions(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        validateReadPermissions(permissions);
        logIn(activityResultRegistryOwner, callbackManager, new LoginConfiguration(permissions, null, 2, null));
    }

    public final void logInWithConfiguration(Fragment fragment, LoginConfiguration loginConfig) throws FacebookException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(loginConfig, "loginConfig");
        loginWithConfiguration(new FragmentWrapper(fragment), loginConfig);
    }

    private final void loginWithConfiguration(FragmentWrapper fragment, LoginConfiguration loginConfig) throws FacebookException, NoSuchAlgorithmException {
        logIn(fragment, loginConfig);
    }

    public final void loginWithConfiguration(Activity activity, LoginConfiguration loginConfig) throws FacebookException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(loginConfig, "loginConfig");
        logIn(activity, loginConfig);
    }

    public final void reauthorizeDataAccess(Activity activity) throws FacebookException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        startLogin(new ActivityStartActivityDelegate(activity), createReauthorizeRequest());
    }

    public final void reauthorizeDataAccess(Fragment fragment) throws FacebookException {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        reauthorizeDataAccess(new FragmentWrapper(fragment));
    }

    private final void reauthorizeDataAccess(FragmentWrapper fragment) throws FacebookException {
        startLogin(new FragmentStartActivityDelegate(fragment), createReauthorizeRequest());
    }

    @Deprecated(message = "")
    public final void logInWithPublishPermissions(Fragment fragment, Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        logInWithPublishPermissions(new FragmentWrapper(fragment), permissions);
    }

    public final void logInWithPublishPermissions(Fragment fragment, CallbackManager callbackManager, Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            logInWithPublishPermissions(activity, callbackManager, permissions);
            return;
        }
        throw new FacebookException("Cannot obtain activity context on the fragment " + fragment);
    }

    public final void logInWithPublishPermissions(android.app.Fragment fragment, Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        logInWithPublishPermissions(new FragmentWrapper(fragment), permissions);
    }

    private final void logInWithPublishPermissions(FragmentWrapper fragment, Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        validatePublishPermissions(permissions);
        loginWithConfiguration(fragment, new LoginConfiguration(permissions, null, 2, null));
    }

    public final void logInWithPublishPermissions(Activity activity, Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        validatePublishPermissions(permissions);
        loginWithConfiguration(activity, new LoginConfiguration(permissions, null, 2, null));
    }

    public final void logInWithPublishPermissions(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        validatePublishPermissions(permissions);
        logIn(activityResultRegistryOwner, callbackManager, new LoginConfiguration(permissions, null, 2, null));
    }

    public final void logIn(Fragment fragment, Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), permissions);
    }

    public final void logIn(Fragment fragment, Collection<String> permissions, String loggerID) throws FacebookException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), permissions, loggerID);
    }

    public final void logIn(android.app.Fragment fragment, Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), permissions);
    }

    public final void logIn(android.app.Fragment fragment, Collection<String> permissions, String loggerID) throws FacebookException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), permissions, loggerID);
    }

    public final void logIn(FragmentWrapper fragment, Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(fragment, new LoginConfiguration(permissions, null, 2, null));
    }

    public final void logIn(FragmentWrapper fragment, Collection<String> permissions, String loggerID) throws FacebookException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        LoginClient.Request requestCreateLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(permissions, null, 2, null));
        if (loggerID != null) {
            requestCreateLoginRequestWithConfig.setAuthId(loggerID);
        }
        startLogin(new FragmentStartActivityDelegate(fragment), requestCreateLoginRequestWithConfig);
    }

    public final void logIn(Activity activity, Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        logIn(activity, new LoginConfiguration(permissions, null, 2, null));
    }

    public final void logIn(FragmentWrapper fragment, LoginConfiguration loginConfig) throws FacebookException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(loginConfig, "loginConfig");
        startLogin(new FragmentStartActivityDelegate(fragment), createLoginRequestWithConfig(loginConfig));
    }

    public final void logIn(Activity activity, LoginConfiguration loginConfig) throws FacebookException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(loginConfig, "loginConfig");
        if (activity instanceof ActivityResultRegistryOwner) {
            Log.w(TAG, "You're calling logging in Facebook with an activity supports androidx activity result APIs. Please follow our document to upgrade to new APIs to avoid overriding onActivityResult().");
        }
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestWithConfig(loginConfig));
    }

    public final void logIn(Activity activity, Collection<String> permissions, String loggerID) throws FacebookException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        LoginClient.Request requestCreateLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(permissions, null, 2, null));
        if (loggerID != null) {
            requestCreateLoginRequestWithConfig.setAuthId(loggerID);
        }
        startLogin(new ActivityStartActivityDelegate(activity), requestCreateLoginRequestWithConfig);
    }

    private final void logIn(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, LoginConfiguration loginConfig) throws FacebookException, NoSuchAlgorithmException {
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(activityResultRegistryOwner, callbackManager), createLoginRequestWithConfig(loginConfig));
    }

    public final void logIn(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, Collection<String> permissions, String loggerID) throws FacebookException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        LoginClient.Request requestCreateLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(permissions, null, 2, null));
        if (loggerID != null) {
            requestCreateLoginRequestWithConfig.setAuthId(loggerID);
        }
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(activityResultRegistryOwner, callbackManager), requestCreateLoginRequestWithConfig);
    }

    public final void logIn(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, Collection<String> permissions) throws FacebookException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        logIn(activityResultRegistryOwner, callbackManager, new LoginConfiguration(permissions, null, 2, null));
    }

    /* compiled from: LoginManager.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u001d\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u001a\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/facebook/login/LoginManager$FacebookLoginActivityResultContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "Lcom/facebook/CallbackManager$ActivityResultParameters;", "callbackManager", "Lcom/facebook/CallbackManager;", "loggerID", "(Lcom/facebook/login/LoginManager;Lcom/facebook/CallbackManager;Ljava/lang/String;)V", "getCallbackManager", "()Lcom/facebook/CallbackManager;", "setCallbackManager", "(Lcom/facebook/CallbackManager;)V", "getLoggerID", "()Ljava/lang/String;", "setLoggerID", "(Ljava/lang/String;)V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "permissions", "parseResult", "resultCode", "", SDKConstants.PARAM_INTENT, "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class FacebookLoginActivityResultContract extends ActivityResultContract<Collection<? extends String>, CallbackManager.ActivityResultParameters> {
        private CallbackManager callbackManager;
        private String loggerID;

        public FacebookLoginActivityResultContract(CallbackManager callbackManager, String str) {
            this.callbackManager = callbackManager;
            this.loggerID = str;
        }

        public /* synthetic */ FacebookLoginActivityResultContract(LoginManager loginManager, CallbackManager callbackManager, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : callbackManager, (i & 2) != 0 ? null : str);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context context, Collection<? extends String> collection) {
            return createIntent2(context, (Collection<String>) collection);
        }

        public final CallbackManager getCallbackManager() {
            return this.callbackManager;
        }

        public final void setCallbackManager(CallbackManager callbackManager) {
            this.callbackManager = callbackManager;
        }

        public final String getLoggerID() {
            return this.loggerID;
        }

        public final void setLoggerID(String str) {
            this.loggerID = str;
        }

        /* renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context context, Collection<String> permissions) throws NoSuchAlgorithmException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            LoginClient.Request requestCreateLoginRequestWithConfig = LoginManager.this.createLoginRequestWithConfig(new LoginConfiguration(permissions, null, 2, null));
            String str = this.loggerID;
            if (str != null) {
                requestCreateLoginRequestWithConfig.setAuthId(str);
            }
            LoginManager.this.logStartLogin(context, requestCreateLoginRequestWithConfig);
            Intent facebookActivityIntent = LoginManager.this.getFacebookActivityIntent(requestCreateLoginRequestWithConfig);
            if (LoginManager.this.resolveIntent(facebookActivityIntent)) {
                return facebookActivityIntent;
            }
            FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            LoginManager.this.logCompleteLogin(context, LoginClient.Result.Code.ERROR, null, facebookException, false, requestCreateLoginRequestWithConfig);
            throw facebookException;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        public CallbackManager.ActivityResultParameters parseResult(int resultCode, Intent intent) {
            LoginManager.onActivityResult$default(LoginManager.this, resultCode, intent, null, 4, null);
            int requestCode = CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
            CallbackManager callbackManager = this.callbackManager;
            if (callbackManager != null) {
                callbackManager.onActivityResult(requestCode, resultCode, intent);
            }
            return new CallbackManager.ActivityResultParameters(requestCode, resultCode, intent);
        }
    }

    public static /* synthetic */ FacebookLoginActivityResultContract createLogInActivityResultContract$default(LoginManager loginManager, CallbackManager callbackManager, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLogInActivityResultContract");
        }
        if ((i & 1) != 0) {
            callbackManager = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return loginManager.createLogInActivityResultContract(callbackManager, str);
    }

    public final FacebookLoginActivityResultContract createLogInActivityResultContract(CallbackManager callbackManager, String loggerID) {
        return new FacebookLoginActivityResultContract(callbackManager, loggerID);
    }

    private final void validateReadPermissions(Collection<String> permissions) {
        if (permissions == null) {
            return;
        }
        for (String str : permissions) {
            if (INSTANCE.isPublishPermission(str)) {
                throw new FacebookException("Cannot pass a publish or manage permission (" + str + ") to a request for read authorization");
            }
        }
    }

    private final void validatePublishPermissions(Collection<String> permissions) {
        if (permissions == null) {
            return;
        }
        for (String str : permissions) {
            if (!INSTANCE.isPublishPermission(str)) {
                throw new FacebookException("Cannot pass a read permission (" + str + ") to a request for publish authorization");
            }
        }
    }

    protected LoginClient.Request createLoginRequestWithConfig(LoginConfiguration loginConfig) throws NoSuchAlgorithmException {
        String codeVerifier;
        Intrinsics.checkNotNullParameter(loginConfig, "loginConfig");
        CodeChallengeMethod codeChallengeMethod = CodeChallengeMethod.S256;
        try {
            codeVerifier = PKCEUtil.generateCodeChallenge(loginConfig.getCodeVerifier(), codeChallengeMethod);
        } catch (FacebookException unused) {
            codeChallengeMethod = CodeChallengeMethod.PLAIN;
            codeVerifier = loginConfig.getCodeVerifier();
        }
        LoginBehavior loginBehavior = this.loginBehavior;
        Set set = CollectionsKt.toSet(loginConfig.getPermissions());
        DefaultAudience defaultAudience = this.defaultAudience;
        String str = this.authType;
        String applicationId = FacebookSdk.getApplicationId();
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        LoginTargetApp loginTargetApp = this.loginTargetApp;
        String nonce = loginConfig.getNonce();
        String codeVerifier2 = loginConfig.getCodeVerifier();
        LoginClient.Request request = new LoginClient.Request(loginBehavior, set, defaultAudience, str, applicationId, string, loginTargetApp, nonce, codeVerifier2, codeVerifier, codeChallengeMethod);
        request.setRerequest(AccessToken.INSTANCE.isCurrentAccessTokenActive());
        request.setMessengerPageId(this.messengerPageId);
        request.setResetMessengerState(this.resetMessengerState);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    protected LoginClient.Request createLoginRequest(Collection<String> permissions) {
        LoginBehavior loginBehavior = this.loginBehavior;
        Set set = permissions != null ? CollectionsKt.toSet(permissions) : null;
        DefaultAudience defaultAudience = this.defaultAudience;
        String str = this.authType;
        String applicationId = FacebookSdk.getApplicationId();
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        LoginClient.Request request = new LoginClient.Request(loginBehavior, set, defaultAudience, str, applicationId, string, this.loginTargetApp, null, null, null, null, 1920, null);
        request.setRerequest(AccessToken.INSTANCE.isCurrentAccessTokenActive());
        request.setMessengerPageId(this.messengerPageId);
        request.setResetMessengerState(this.resetMessengerState);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    protected LoginClient.Request createReauthorizeRequest() {
        LoginBehavior loginBehavior = LoginBehavior.DIALOG_ONLY;
        HashSet hashSet = new HashSet();
        DefaultAudience defaultAudience = this.defaultAudience;
        String applicationId = FacebookSdk.getApplicationId();
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        LoginClient.Request request = new LoginClient.Request(loginBehavior, hashSet, defaultAudience, "reauthorize", applicationId, string, this.loginTargetApp, null, null, null, null, 1920, null);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    private final void startLogin(StartActivityDelegate startActivityDelegate, LoginClient.Request request) throws FacebookException {
        logStartLogin(startActivityDelegate.getActivityContext(), request);
        CallbackManagerImpl.INSTANCE.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback() { // from class: com.facebook.login.LoginManager$$ExternalSyntheticLambda2
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public final boolean onActivityResult(int i, Intent intent) {
                return LoginManager.startLogin$lambda$1(this.f$0, i, intent);
            }
        });
        if (tryFacebookActivity(startActivityDelegate, request)) {
            return;
        }
        FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
        logCompleteLogin(startActivityDelegate.getActivityContext(), LoginClient.Result.Code.ERROR, null, facebookException, false, request);
        throw facebookException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean startLogin$lambda$1(LoginManager this$0, int i, Intent intent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return onActivityResult$default(this$0, i, intent, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logStartLogin(Context context, LoginClient.Request loginRequest) {
        LoginLogger logger = LoginLoggerHolder.INSTANCE.getLogger(context);
        if (logger == null || loginRequest == null) {
            return;
        }
        logger.logStartLogin(loginRequest, loginRequest.getIsFamilyLogin() ? LoginLogger.EVENT_NAME_FOA_LOGIN_START : LoginLogger.EVENT_NAME_LOGIN_START);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logCompleteLogin(Context context, LoginClient.Result.Code result, Map<String, String> resultExtras, Exception exception, boolean wasLoginActivityTried, LoginClient.Request request) {
        String str;
        LoginLogger logger = LoginLoggerHolder.INSTANCE.getLogger(context);
        if (logger == null) {
            return;
        }
        if (request == null) {
            LoginLogger.logUnexpectedError$default(logger, LoginLogger.EVENT_NAME_LOGIN_COMPLETE, "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", null, 4, null);
            return;
        }
        HashMap map = new HashMap();
        if (wasLoginActivityTried) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        } else {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        map.put(LoginLogger.EVENT_EXTRAS_TRY_LOGIN_ACTIVITY, str);
        logger.logCompleteLogin(request.getAuthId(), map, result, resultExtras, exception, request.getIsFamilyLogin() ? LoginLogger.EVENT_NAME_FOA_LOGIN_COMPLETE : LoginLogger.EVENT_NAME_LOGIN_COMPLETE);
    }

    private final boolean tryFacebookActivity(StartActivityDelegate startActivityDelegate, LoginClient.Request request) {
        Intent facebookActivityIntent = getFacebookActivityIntent(request);
        if (!resolveIntent(facebookActivityIntent)) {
            return false;
        }
        try {
            startActivityDelegate.startActivityForResult(facebookActivityIntent, LoginClient.INSTANCE.getLoginRequestCode());
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean resolveIntent(Intent intent) {
        return FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(intent, 0) != null;
    }

    protected Intent getFacebookActivityIntent(LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(request.getLoginBehavior().toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("request", request);
        intent.putExtra(LoginFragment.REQUEST_KEY, bundle);
        return intent;
    }

    private final void finishLogin(AccessToken newToken, AuthenticationToken newIdToken, LoginClient.Request origRequest, FacebookException exception, boolean isCanceled, FacebookCallback<LoginResult> callback) {
        if (newToken != null) {
            AccessToken.INSTANCE.setCurrentAccessToken(newToken);
            Profile.INSTANCE.fetchProfileForCurrentAccessToken();
        }
        if (newIdToken != null) {
            AuthenticationToken.INSTANCE.setCurrentAuthenticationToken(newIdToken);
        }
        if (callback != null) {
            LoginResult loginResultComputeLoginResult = (newToken == null || origRequest == null) ? null : INSTANCE.computeLoginResult(origRequest, newToken, newIdToken);
            if (isCanceled || (loginResultComputeLoginResult != null && loginResultComputeLoginResult.getRecentlyGrantedPermissions().isEmpty())) {
                callback.onCancel();
                return;
            }
            if (exception != null) {
                callback.onError(exception);
            } else {
                if (newToken == null || loginResultComputeLoginResult == null) {
                    return;
                }
                setExpressLoginStatus(true);
                callback.onSuccess(loginResultComputeLoginResult);
            }
        }
    }

    private final void retrieveLoginStatusImpl(Context context, final LoginStatusCallback responseCallback, long toastDurationMs) {
        final String applicationId = FacebookSdk.getApplicationId();
        final String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        final LoginLogger loginLogger = new LoginLogger(context == null ? FacebookSdk.getApplicationContext() : context, applicationId);
        if (!isExpressLoginAllowed()) {
            loginLogger.logLoginStatusFailure(string);
            responseCallback.onFailure();
            return;
        }
        LoginStatusClient loginStatusClientNewInstance$facebook_common_release = LoginStatusClient.INSTANCE.newInstance$facebook_common_release(context, applicationId, string, FacebookSdk.getGraphApiVersion(), toastDurationMs, null);
        loginStatusClientNewInstance$facebook_common_release.setCompletedListener(new PlatformServiceClient.CompletedListener() { // from class: com.facebook.login.LoginManager$$ExternalSyntheticLambda1
            @Override // com.facebook.internal.PlatformServiceClient.CompletedListener
            public final void completed(Bundle bundle) throws NumberFormatException {
                LoginManager.retrieveLoginStatusImpl$lambda$2(string, loginLogger, responseCallback, applicationId, bundle);
            }
        });
        loginLogger.logLoginStatusStart(string);
        if (loginStatusClientNewInstance$facebook_common_release.start()) {
            return;
        }
        loginLogger.logLoginStatusFailure(string);
        responseCallback.onFailure();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void retrieveLoginStatusImpl$lambda$2(String loggerRef, LoginLogger logger, LoginStatusCallback responseCallback, String applicationId, Bundle bundle) throws NumberFormatException {
        ArrayList<String> arrayList;
        String str;
        Intrinsics.checkNotNullParameter(loggerRef, "$loggerRef");
        Intrinsics.checkNotNullParameter(logger, "$logger");
        Intrinsics.checkNotNullParameter(responseCallback, "$responseCallback");
        Intrinsics.checkNotNullParameter(applicationId, "$applicationId");
        if (bundle != null) {
            String string = bundle.getString(NativeProtocol.STATUS_ERROR_TYPE);
            String string2 = bundle.getString(NativeProtocol.STATUS_ERROR_DESCRIPTION);
            if (string == null) {
                String string3 = bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
                Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH, new Date(0L));
                ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
                String string4 = bundle.getString(NativeProtocol.RESULT_ARGS_SIGNED_REQUEST);
                String string5 = bundle.getString("graph_domain");
                Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_DATA_ACCESS_EXPIRATION_TIME, new Date(0L));
                String str2 = string4;
                String userIDFromSignedRequest = (str2 == null || str2.length() == 0) ? null : LoginMethodHandler.INSTANCE.getUserIDFromSignedRequest(string4);
                String str3 = string3;
                if (str3 != null && str3.length() != 0 && (arrayList = stringArrayList) != null && !arrayList.isEmpty() && (str = userIDFromSignedRequest) != null && str.length() != 0) {
                    AccessToken accessToken = new AccessToken(string3, applicationId, userIDFromSignedRequest, arrayList, null, null, null, bundleLongAsDate, null, bundleLongAsDate2, string5);
                    AccessToken.INSTANCE.setCurrentAccessToken(accessToken);
                    Profile.INSTANCE.fetchProfileForCurrentAccessToken();
                    logger.logLoginStatusSuccess(loggerRef);
                    responseCallback.onCompleted(accessToken);
                    return;
                }
                logger.logLoginStatusFailure(loggerRef);
                responseCallback.onFailure();
                return;
            }
            INSTANCE.handleLoginStatusError(string, string2, loggerRef, logger, responseCallback);
            return;
        }
        logger.logLoginStatusFailure(loggerRef);
        responseCallback.onFailure();
    }

    private final void setExpressLoginStatus(boolean isExpressLoginAllowed) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putBoolean(EXPRESS_LOGIN_ALLOWED, isExpressLoginAllowed);
        editorEdit.apply();
    }

    private final boolean isExpressLoginAllowed() {
        return this.sharedPreferences.getBoolean(EXPRESS_LOGIN_ALLOWED, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LoginManager.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/login/LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate;", "Lcom/facebook/login/StartActivityDelegate;", "activityResultRegistryOwner", "Landroidx/activity/result/ActivityResultRegistryOwner;", "callbackManager", "Lcom/facebook/CallbackManager;", "(Landroidx/activity/result/ActivityResultRegistryOwner;Lcom/facebook/CallbackManager;)V", "activityContext", "Landroid/app/Activity;", "getActivityContext", "()Landroid/app/Activity;", "startActivityForResult", "", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "requestCode", "", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final class AndroidxActivityResultRegistryOwnerStartActivityDelegate implements StartActivityDelegate {
        private final ActivityResultRegistryOwner activityResultRegistryOwner;
        private final CallbackManager callbackManager;

        public AndroidxActivityResultRegistryOwnerStartActivityDelegate(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager) {
            Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
            Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
            this.activityResultRegistryOwner = activityResultRegistryOwner;
            this.callbackManager = callbackManager;
        }

        @Override // com.facebook.login.StartActivityDelegate
        public void startActivityForResult(Intent intent, int requestCode) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            final LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder = new LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder();
            loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.setLauncher(this.activityResultRegistryOwner.getActivityResultRegistry().register("facebook-login", new ActivityResultContract<Intent, Pair<Integer, Intent>>() { // from class: com.facebook.login.LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$1
                @Override // androidx.activity.result.contract.ActivityResultContract
                public Intent createIntent(Context context, Intent input) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(input, "input");
                    return input;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.activity.result.contract.ActivityResultContract
                public Pair<Integer, Intent> parseResult(int resultCode, Intent intent2) {
                    Pair<Integer, Intent> pairCreate = Pair.create(Integer.valueOf(resultCode), intent2);
                    Intrinsics.checkNotNullExpressionValue(pairCreate, "create(resultCode, intent)");
                    return pairCreate;
                }
            }, new ActivityResultCallback() { // from class: com.facebook.login.LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$$ExternalSyntheticLambda0
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    LoginManager.AndroidxActivityResultRegistryOwnerStartActivityDelegate.startActivityForResult$lambda$0(this.f$0, loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder, (Pair) obj);
                }
            }));
            ActivityResultLauncher<Intent> launcher = loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.getLauncher();
            if (launcher != null) {
                launcher.launch(intent);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void startActivityForResult$lambda$0(AndroidxActivityResultRegistryOwnerStartActivityDelegate this$0, LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder launcherHolder, Pair pair) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(launcherHolder, "$launcherHolder");
            CallbackManager callbackManager = this$0.callbackManager;
            int requestCode = CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
            Object obj = pair.first;
            Intrinsics.checkNotNullExpressionValue(obj, "result.first");
            callbackManager.onActivityResult(requestCode, ((Number) obj).intValue(), (Intent) pair.second);
            ActivityResultLauncher<Intent> launcher = launcherHolder.getLauncher();
            if (launcher != null) {
                launcher.unregister();
            }
            launcherHolder.setLauncher(null);
        }

        @Override // com.facebook.login.StartActivityDelegate
        public Activity getActivityContext() {
            Object obj = this.activityResultRegistryOwner;
            if (obj instanceof Activity) {
                return (Activity) obj;
            }
            return null;
        }
    }

    /* compiled from: LoginManager.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/facebook/login/LoginManager$ActivityStartActivityDelegate;", "Lcom/facebook/login/StartActivityDelegate;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "activityContext", "getActivityContext", "()Landroid/app/Activity;", "startActivityForResult", "", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "requestCode", "", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class ActivityStartActivityDelegate implements StartActivityDelegate {
        private final Activity activityContext;

        public ActivityStartActivityDelegate(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.activityContext = activity;
        }

        @Override // com.facebook.login.StartActivityDelegate
        public Activity getActivityContext() {
            return this.activityContext;
        }

        @Override // com.facebook.login.StartActivityDelegate
        public void startActivityForResult(Intent intent, int requestCode) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            getActivityContext().startActivityForResult(intent, requestCode);
        }
    }

    /* compiled from: LoginManager.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/login/LoginManager$FragmentStartActivityDelegate;", "Lcom/facebook/login/StartActivityDelegate;", Request.JsonKeys.FRAGMENT, "Lcom/facebook/internal/FragmentWrapper;", "(Lcom/facebook/internal/FragmentWrapper;)V", "activityContext", "Landroid/app/Activity;", "getActivityContext", "()Landroid/app/Activity;", "startActivityForResult", "", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "requestCode", "", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class FragmentStartActivityDelegate implements StartActivityDelegate {
        private final Activity activityContext;
        private final FragmentWrapper fragment;

        public FragmentStartActivityDelegate(FragmentWrapper fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.fragment = fragment;
            this.activityContext = fragment.getActivity();
        }

        @Override // com.facebook.login.StartActivityDelegate
        public void startActivityForResult(Intent intent, int requestCode) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            this.fragment.startActivityForResult(intent, requestCode);
        }

        @Override // com.facebook.login.StartActivityDelegate
        public Activity getActivityContext() {
            return this.activityContext;
        }
    }

    /* compiled from: LoginManager.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/login/LoginManager$LoginLoggerHolder;", "", "()V", SentryEvent.JsonKeys.LOGGER, "Lcom/facebook/login/LoginLogger;", "getLogger", "context", "Landroid/content/Context;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class LoginLoggerHolder {
        public static final LoginLoggerHolder INSTANCE = new LoginLoggerHolder();
        private static LoginLogger logger;

        private LoginLoggerHolder() {
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x000f A[Catch: all -> 0x0008, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0003, B:12:0x000f, B:14:0x0013, B:15:0x001e), top: B:20:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x000c A[DONT_GENERATE] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final synchronized com.facebook.login.LoginLogger getLogger(android.content.Context r3) {
            /*
                r2 = this;
                monitor-enter(r2)
                if (r3 != 0) goto La
                android.content.Context r3 = com.facebook.FacebookSdk.getApplicationContext()     // Catch: java.lang.Throwable -> L8
                goto La
            L8:
                r3 = move-exception
                goto L22
            La:
                if (r3 != 0) goto Lf
                monitor-exit(r2)
                r3 = 0
                return r3
            Lf:
                com.facebook.login.LoginLogger r0 = com.facebook.login.LoginManager.LoginLoggerHolder.logger     // Catch: java.lang.Throwable -> L8
                if (r0 != 0) goto L1e
                com.facebook.login.LoginLogger r0 = new com.facebook.login.LoginLogger     // Catch: java.lang.Throwable -> L8
                java.lang.String r1 = com.facebook.FacebookSdk.getApplicationId()     // Catch: java.lang.Throwable -> L8
                r0.<init>(r3, r1)     // Catch: java.lang.Throwable -> L8
                com.facebook.login.LoginManager.LoginLoggerHolder.logger = r0     // Catch: java.lang.Throwable -> L8
            L1e:
                com.facebook.login.LoginLogger r3 = com.facebook.login.LoginManager.LoginLoggerHolder.logger     // Catch: java.lang.Throwable -> L8
                monitor-exit(r2)
                return r3
            L22:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L8
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginManager.LoginLoggerHolder.getLogger(android.content.Context):com.facebook.login.LoginLogger");
        }
    }

    /* compiled from: LoginManager.kt */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J \u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\b\u0010\u001c\u001a\u00020\fH\u0017J2\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006)"}, d2 = {"Lcom/facebook/login/LoginManager$Companion;", "", "()V", "EXPRESS_LOGIN_ALLOWED", "", "MANAGE_PERMISSION_PREFIX", "OTHER_PUBLISH_PERMISSIONS", "", "PREFERENCE_LOGIN_MANAGER", "PUBLISH_PERMISSION_PREFIX", "TAG", "instance", "Lcom/facebook/login/LoginManager;", "otherPublishPermissions", "getOtherPublishPermissions", "()Ljava/util/Set;", "computeLoginResult", "Lcom/facebook/login/LoginResult;", "request", "Lcom/facebook/login/LoginClient$Request;", "newToken", "Lcom/facebook/AccessToken;", "newIdToken", "Lcom/facebook/AuthenticationToken;", "getExtraDataFromIntent", "", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "getInstance", "handleLoginStatusError", "", "errorType", "errorDescription", "loggerRef", SentryEvent.JsonKeys.LOGGER, "Lcom/facebook/login/LoginLogger;", "responseCallback", "Lcom/facebook/LoginStatusCallback;", "isPublishPermission", "", "permission", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public LoginManager getInstance() {
            if (LoginManager.instance == null) {
                synchronized (this) {
                    Companion companion = LoginManager.INSTANCE;
                    LoginManager.instance = new LoginManager();
                    Unit unit = Unit.INSTANCE;
                }
            }
            LoginManager loginManager = LoginManager.instance;
            if (loginManager != null) {
                return loginManager;
            }
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            return null;
        }

        @JvmStatic
        public final Map<String, String> getExtraDataFromIntent(Intent intent) {
            if (intent == null) {
                return null;
            }
            intent.setExtrasClassLoader(LoginClient.Result.class.getClassLoader());
            LoginClient.Result result = (LoginClient.Result) intent.getParcelableExtra(LoginFragment.RESULT_KEY);
            if (result == null) {
                return null;
            }
            return result.extraData;
        }

        @JvmStatic
        public final boolean isPublishPermission(String permission) {
            if (permission != null) {
                return StringsKt.startsWith$default(permission, LoginManager.PUBLISH_PERMISSION_PREFIX, false, 2, (Object) null) || StringsKt.startsWith$default(permission, LoginManager.MANAGE_PERMISSION_PREFIX, false, 2, (Object) null) || LoginManager.OTHER_PUBLISH_PERMISSIONS.contains(permission);
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Set<String> getOtherPublishPermissions() {
            return SetsKt.setOf((Object[]) new String[]{"ads_management", "create_event", "rsvp_event"});
        }

        @JvmStatic
        public final LoginResult computeLoginResult(LoginClient.Request request, AccessToken newToken, AuthenticationToken newIdToken) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(newToken, "newToken");
            Set<String> permissions = request.getPermissions();
            Set mutableSet = CollectionsKt.toMutableSet(CollectionsKt.filterNotNull(newToken.getPermissions()));
            if (request.getIsRerequest()) {
                mutableSet.retainAll(permissions);
            }
            Set mutableSet2 = CollectionsKt.toMutableSet(CollectionsKt.filterNotNull(permissions));
            mutableSet2.removeAll(mutableSet);
            return new LoginResult(newToken, newIdToken, mutableSet, mutableSet2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void handleLoginStatusError(String errorType, String errorDescription, String loggerRef, LoginLogger logger, LoginStatusCallback responseCallback) {
            FacebookException facebookException = new FacebookException(errorType + ": " + errorDescription);
            logger.logLoginStatusError(loggerRef, facebookException);
            responseCallback.onError(facebookException);
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        OTHER_PUBLISH_PERMISSIONS = companion.getOtherPublishPermissions();
        String string = LoginManager.class.toString();
        Intrinsics.checkNotNullExpressionValue(string, "LoginManager::class.java.toString()");
        TAG = string;
    }
}
