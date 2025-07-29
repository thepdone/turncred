package com.facebook.gamingservices;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.gamingservices.TournamentJoinDialog;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.internal.TournamentJoinDialogURIBuilder;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import io.sentry.protocol.Request;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TournamentJoinDialog.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u0000 (2\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0004'()*B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0012\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0014J \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\"H\u0014J\u001a\u0010#\u001a\u00020\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002J\u001a\u0010$\u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010%\u001a\u00020&H\u0014R.\u0010\u000f\u001a\u001c\u0012\u0018\u0012\u00160\u0011R\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u00108TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/facebook/gamingservices/TournamentJoinDialog;", "Lcom/facebook/internal/FacebookDialogBase;", "", "Lcom/facebook/gamingservices/TournamentJoinDialog$Result;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", Request.JsonKeys.FRAGMENT, "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "Landroid/app/Fragment;", "(Landroid/app/Fragment;)V", "fragmentWrapper", "Lcom/facebook/internal/FragmentWrapper;", "(Lcom/facebook/internal/FragmentWrapper;)V", "orderedModeHandlers", "", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "getOrderedModeHandlers", "()Ljava/util/List;", "payload", SDKConstants.REQUEST_ID, "", "tournamentID", "canShow", "", "content", "createBaseAppCall", "Lcom/facebook/internal/AppCall;", "registerCallbackImpl", "", "callbackManager", "Lcom/facebook/internal/CallbackManagerImpl;", "callback", "Lcom/facebook/FacebookCallback;", "show", "showImpl", "mode", "", "ChromeCustomTabHandler", "Companion", "FacebookAppHandler", "Result", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TournamentJoinDialog extends FacebookDialogBase<String, Result> {
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.TournamentJoinDialog.toRequestCode();
    private static final String JOIN_TOURNAMENT_ACCESS_TOKEN_KEY = "access_token";
    private static final String JOIN_TOURNAMENT_ACTION = "com.facebook.games.gaming_services.DEEPLINK";
    private static final String JOIN_TOURNAMENT_CONTENT_TYPE = "text/plain";
    private static final String JOIN_TOURNAMENT_DIALOG = "join_tournament";
    private static final String JOIN_TOURNAMENT_ERROR_MESSAGE_KEY = "error_message";
    private String payload;
    private Number requestID;
    private String tournamentID;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TournamentJoinDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TournamentJoinDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TournamentJoinDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    private TournamentJoinDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, DEFAULT_REQUEST_CODE);
    }

    public final void show(String tournamentID, String payload) throws PackageManager.NameNotFoundException {
        this.tournamentID = tournamentID;
        this.payload = payload;
        super.showImpl((TournamentJoinDialog) tournamentID, FacebookDialogBase.BASE_AUTOMATIC_MODE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.internal.FacebookDialogBase
    public void showImpl(String content, Object mode) throws PackageManager.NameNotFoundException {
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (CloudGameLoginHandler.isRunningInCloud()) {
            return;
        }
        super.showImpl((TournamentJoinDialog) content, mode);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected void registerCallbackImpl(CallbackManagerImpl callbackManager, final FacebookCallback<Result> callback) {
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final ResultProcessor resultProcessor = new ResultProcessor(callback) { // from class: com.facebook.gamingservices.TournamentJoinDialog$registerCallbackImpl$resultProcessor$1
            final /* synthetic */ FacebookCallback<TournamentJoinDialog.Result> $callback;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(callback);
                this.$callback = callback;
            }

            @Override // com.facebook.share.internal.ResultProcessor
            public void onSuccess(AppCall appCall, Bundle results) {
                Intrinsics.checkNotNullParameter(appCall, "appCall");
                if (results != null) {
                    if (results.getString("error_message") != null) {
                        this.$callback.onError(new FacebookException(results.getString("error_message")));
                        return;
                    } else if (results.getString("payload") != null) {
                        this.$callback.onSuccess(new TournamentJoinDialog.Result(results));
                        return;
                    }
                }
                onCancel(appCall);
            }
        };
        callbackManager.registerCallback(getRequestCodeField(), new CallbackManagerImpl.Callback() { // from class: com.facebook.gamingservices.TournamentJoinDialog$$ExternalSyntheticLambda0
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public final boolean onActivityResult(int i, Intent intent) {
                return TournamentJoinDialog.registerCallbackImpl$lambda$0(this.f$0, resultProcessor, i, intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean registerCallbackImpl$lambda$0(TournamentJoinDialog this$0, ResultProcessor resultProcessor, int i, Intent intent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(resultProcessor, "$resultProcessor");
        return ShareInternalUtility.handleActivityResult(this$0.getRequestCodeField(), i, intent, resultProcessor);
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected List<FacebookDialogBase<String, Result>.ModeHandler> getOrderedModeHandlers() {
        return CollectionsKt.listOf((Object[]) new FacebookDialogBase.ModeHandler[]{new FacebookAppHandler(), new ChromeCustomTabHandler()});
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected AppCall createBaseAppCall() {
        return new AppCall(getRequestCodeField(), null, 2, null);
    }

    /* compiled from: TournamentJoinDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/facebook/gamingservices/TournamentJoinDialog$Result;", "", "results", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "payload", "", "getPayload", "()Ljava/lang/String;", "setPayload", "(Ljava/lang/String;)V", SDKConstants.REQUEST_ID, "getRequestID", "setRequestID", "tournamentID", "getTournamentID", "setTournamentID", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Result {
        private String payload;
        private String requestID;
        private String tournamentID;

        public Result(Bundle results) {
            Intrinsics.checkNotNullParameter(results, "results");
            if (results.getString("request") != null) {
                this.requestID = results.getString("request");
            }
            this.tournamentID = results.getString(SDKConstants.PARAM_TOURNAMENTS_ID);
            this.payload = results.getString("payload");
        }

        public final String getRequestID() {
            return this.requestID;
        }

        public final void setRequestID(String str) {
            this.requestID = str;
        }

        public final String getTournamentID() {
            return this.tournamentID;
        }

        public final void setTournamentID(String str) {
            this.tournamentID = str;
        }

        public final String getPayload() {
            return this.payload;
        }

        public final void setPayload(String str) {
            this.payload = str;
        }
    }

    @Override // com.facebook.internal.FacebookDialogBase, com.facebook.FacebookDialog
    public boolean canShow(String content) {
        if (CloudGameLoginHandler.isRunningInCloud()) {
            return false;
        }
        if (new FacebookAppHandler().canShow(content, true)) {
            return true;
        }
        return new ChromeCustomTabHandler().canShow(content, true);
    }

    /* compiled from: TournamentJoinDialog.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00160\u0001R\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/TournamentJoinDialog$FacebookAppHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "", "Lcom/facebook/gamingservices/TournamentJoinDialog$Result;", "(Lcom/facebook/gamingservices/TournamentJoinDialog;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class FacebookAppHandler extends FacebookDialogBase<String, Result>.ModeHandler {
        public FacebookAppHandler() {
            super();
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(String content, boolean isBestEffort) {
            PackageManager packageManager = FacebookSdk.getApplicationContext().getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "getApplicationContext().packageManager");
            Intent intent = new Intent(TournamentJoinDialog.JOIN_TOURNAMENT_ACTION);
            intent.setType("text/plain");
            return intent.resolveActivity(packageManager) != null;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(String content) {
            AccessToken currentAccessToken = AccessToken.INSTANCE.getCurrentAccessToken();
            AppCall appCallCreateBaseAppCall = TournamentJoinDialog.this.createBaseAppCall();
            Intent intent = new Intent(TournamentJoinDialog.JOIN_TOURNAMENT_ACTION);
            intent.setType("text/plain");
            if (currentAccessToken == null || currentAccessToken.isExpired()) {
                throw new FacebookException("Attempted to present TournamentJoinDialog with an invalid access token");
            }
            if (currentAccessToken.getGraphDomain() != null && !Intrinsics.areEqual(FacebookSdk.GAMING, currentAccessToken.getGraphDomain())) {
                throw new FacebookException("Attempted to present TournamentJoinDialog while user is not gaming logged in");
            }
            NativeProtocol.setupProtocolRequestIntent(intent, appCallCreateBaseAppCall.getCallId().toString(), "", NativeProtocol.PROTOCOL_VERSION_20210906, TournamentJoinDialogURIBuilder.INSTANCE.bundle$facebook_gamingservices_release(currentAccessToken.getApplicationId(), TournamentJoinDialog.this.tournamentID, TournamentJoinDialog.this.payload));
            appCallCreateBaseAppCall.setRequestIntent(intent);
            return appCallCreateBaseAppCall;
        }
    }

    /* compiled from: TournamentJoinDialog.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00160\u0001R\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/TournamentJoinDialog$ChromeCustomTabHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "", "Lcom/facebook/gamingservices/TournamentJoinDialog$Result;", "(Lcom/facebook/gamingservices/TournamentJoinDialog;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class ChromeCustomTabHandler extends FacebookDialogBase<String, Result>.ModeHandler {
        public ChromeCustomTabHandler() {
            super();
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(String content, boolean isBestEffort) {
            return CustomTabUtils.getChromePackage() != null;
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(String content) {
            String applicationId;
            AppCall appCallCreateBaseAppCall = TournamentJoinDialog.this.createBaseAppCall();
            AccessToken currentAccessToken = AccessToken.INSTANCE.getCurrentAccessToken();
            Bundle bundle = new Bundle();
            Bundle bundle2 = new Bundle();
            if (currentAccessToken == null || (applicationId = currentAccessToken.getApplicationId()) == null) {
                applicationId = FacebookSdk.getApplicationId();
            }
            bundle.putString("app_id", applicationId);
            bundle.putString("payload", bundle2.toString());
            if (currentAccessToken != null) {
                currentAccessToken.getToken();
            }
            bundle.putString("access_token", currentAccessToken != null ? currentAccessToken.getToken() : null);
            bundle.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, CustomTabUtils.getDefaultRedirectURI());
            DialogPresenter.setupAppCallForCustomTabDialog(appCallCreateBaseAppCall, TournamentJoinDialog.JOIN_TOURNAMENT_DIALOG, bundle);
            return appCallCreateBaseAppCall;
        }
    }
}
