package com.facebook.internal;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookDialog;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FacebookDialogBase.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 @*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0002@AB\u0017\b\u0014\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0017\b\u0014\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bB\u000f\b\u0014\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\fJ\u001e\u0010!\u001a\u0018\u0012\u0014\u0012\u00120\u0018R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u0017H\u0002J\u0015\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010%J\u001d\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00028\u00002\u0006\u0010'\u001a\u00020(H\u0014¢\u0006\u0002\u0010)J\u001e\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020,0+2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020,0+2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010'\u001a\u00020(H\u0004J\u001f\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010$\u001a\u00028\u00002\u0006\u0010'\u001a\u00020(H\u0002¢\u0006\u0002\u0010/J\b\u00100\u001a\u00020.H$J\u0012\u00101\u001a\u0002022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u001e\u00103\u001a\u0002022\u0006\u0010\u0010\u001a\u00020\u00112\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u000105H\u0016J&\u00103\u001a\u0002022\u0006\u0010\u0010\u001a\u00020\u00112\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u0001052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001e\u00106\u001a\u0002022\u0006\u0010\u0010\u001a\u0002072\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u000105H$J\u0010\u00108\u001a\u0002022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0015\u00109\u001a\u0002022\u0006\u0010$\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010:J\u001d\u0010;\u001a\u0002022\u0006\u0010$\u001a\u00028\u00002\u0006\u0010'\u001a\u00020(H\u0014¢\u0006\u0002\u0010<J\u0018\u0010=\u001a\u0002022\u0006\u0010>\u001a\u00020?2\u0006\u0010\u0006\u001a\u00020\u0007H\u0004R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00058DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118AX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0016\u001a\u001a\u0012\u0014\u0012\u00120\u0018R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0019\u001a\u0018\u0012\u0014\u0012\u00120\u0018R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u0017X¤\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010\fR\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/facebook/internal/FacebookDialogBase;", "CONTENT", "RESULT", "Lcom/facebook/FacebookDialog;", "activity", "Landroid/app/Activity;", "requestCode", "", "(Landroid/app/Activity;I)V", "fragmentWrapper", "Lcom/facebook/internal/FragmentWrapper;", "(Lcom/facebook/internal/FragmentWrapper;I)V", "(I)V", "activityContext", "getActivityContext", "()Landroid/app/Activity;", "callbackManager", "Lcom/facebook/CallbackManager;", "getCallbackManager$facebook_common_release", "()Lcom/facebook/CallbackManager;", "setCallbackManager$facebook_common_release", "(Lcom/facebook/CallbackManager;)V", "modeHandlers", "", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "orderedModeHandlers", "getOrderedModeHandlers", "()Ljava/util/List;", "value", "getRequestCode", "()I", "setRequestCode", "requestCodeField", "cachedModeHandlers", "canShow", "", "content", "(Ljava/lang/Object;)Z", "canShowImpl", "mode", "", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "createActivityResultContractForShowingDialog", "Landroidx/activity/result/contract/ActivityResultContract;", "Lcom/facebook/CallbackManager$ActivityResultParameters;", "createAppCallForMode", "Lcom/facebook/internal/AppCall;", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/facebook/internal/AppCall;", "createBaseAppCall", "memorizeCallbackManager", "", "registerCallback", "callback", "Lcom/facebook/FacebookCallback;", "registerCallbackImpl", "Lcom/facebook/internal/CallbackManagerImpl;", "setCallbackManager", "show", "(Ljava/lang/Object;)V", "showImpl", "(Ljava/lang/Object;Ljava/lang/Object;)V", "startActivityForResult", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "Companion", "ModeHandler", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class FacebookDialogBase<CONTENT, RESULT> implements FacebookDialog<CONTENT, RESULT> {
    private static final String TAG = "FacebookDialog";
    private final Activity activity;
    private CallbackManager callbackManager;
    private final FragmentWrapper fragmentWrapper;
    private List<? extends FacebookDialogBase<CONTENT, RESULT>.ModeHandler> modeHandlers;
    private int requestCodeField;
    public static final Object BASE_AUTOMATIC_MODE = new Object();

    protected abstract AppCall createBaseAppCall();

    protected abstract List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> getOrderedModeHandlers();

    protected abstract void registerCallbackImpl(CallbackManagerImpl callbackManager, FacebookCallback<RESULT> callback);

    /* renamed from: getCallbackManager$facebook_common_release, reason: from getter */
    public final CallbackManager getCallbackManager() {
        return this.callbackManager;
    }

    public final void setCallbackManager$facebook_common_release(CallbackManager callbackManager) {
        this.callbackManager = callbackManager;
    }

    public final void setCallbackManager(CallbackManager callbackManager) {
        this.callbackManager = callbackManager;
    }

    protected FacebookDialogBase(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.fragmentWrapper = null;
        this.requestCodeField = i;
        this.callbackManager = null;
    }

    protected FacebookDialogBase(FragmentWrapper fragmentWrapper, int i) {
        Intrinsics.checkNotNullParameter(fragmentWrapper, "fragmentWrapper");
        this.fragmentWrapper = fragmentWrapper;
        this.activity = null;
        this.requestCodeField = i;
        if (fragmentWrapper.getActivity() == null) {
            throw new IllegalArgumentException("Cannot use a fragment that is not attached to an activity".toString());
        }
    }

    protected FacebookDialogBase(int i) {
        this.requestCodeField = i;
        this.activity = null;
        this.fragmentWrapper = null;
    }

    @Override // com.facebook.FacebookDialog
    public void registerCallback(CallbackManager callbackManager, FacebookCallback<RESULT> callback) {
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!(callbackManager instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        memorizeCallbackManager(callbackManager);
        registerCallbackImpl((CallbackManagerImpl) callbackManager, callback);
    }

    @Override // com.facebook.FacebookDialog
    public void registerCallback(CallbackManager callbackManager, FacebookCallback<RESULT> callback, int requestCode) {
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(callback, "callback");
        memorizeCallbackManager(callbackManager);
        setRequestCode(requestCode);
        registerCallback(callbackManager, callback);
    }

    /* renamed from: getRequestCode, reason: from getter */
    public final int getRequestCodeField() {
        return this.requestCodeField;
    }

    public final void setRequestCode(int i) {
        if (FacebookSdk.isFacebookRequestCode(i)) {
            throw new IllegalArgumentException(("Request code " + i + " cannot be within the range reserved by the Facebook SDK.").toString());
        }
        this.requestCodeField = i;
    }

    @Override // com.facebook.FacebookDialog
    public boolean canShow(CONTENT content) {
        return canShowImpl(content, BASE_AUTOMATIC_MODE);
    }

    protected boolean canShowImpl(CONTENT content, Object mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        boolean z = mode == BASE_AUTOMATIC_MODE;
        for (FacebookDialogBase<CONTENT, RESULT>.ModeHandler modeHandler : cachedModeHandlers()) {
            if (z || Utility.areObjectsEqual(modeHandler.getMode(), mode)) {
                if (modeHandler.canShow(content, false)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.facebook.FacebookDialog
    public void show(CONTENT content) throws PackageManager.NameNotFoundException {
        showImpl(content, BASE_AUTOMATIC_MODE);
    }

    protected final ActivityResultContract<CONTENT, CallbackManager.ActivityResultParameters> createActivityResultContractForShowingDialog(final CallbackManager callbackManager, final Object mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        return new ActivityResultContract<CONTENT, CallbackManager.ActivityResultParameters>(this) { // from class: com.facebook.internal.FacebookDialogBase.createActivityResultContractForShowingDialog.1
            final /* synthetic */ FacebookDialogBase<CONTENT, RESULT> this$0;

            {
                this.this$0 = this;
            }

            @Override // androidx.activity.result.contract.ActivityResultContract
            public Intent createIntent(Context context, CONTENT content) throws PackageManager.NameNotFoundException {
                Intrinsics.checkNotNullParameter(context, "context");
                AppCall appCallCreateAppCallForMode = this.this$0.createAppCallForMode(content, mode);
                Intent requestIntent = appCallCreateAppCallForMode != null ? appCallCreateAppCallForMode.getRequestIntent() : null;
                if (requestIntent != null) {
                    appCallCreateAppCallForMode.setPending();
                    return requestIntent;
                }
                throw new FacebookException("Content " + content + " is not supported");
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.activity.result.contract.ActivityResultContract
            public CallbackManager.ActivityResultParameters parseResult(int resultCode, Intent intent) {
                CallbackManager callbackManager2 = callbackManager;
                if (callbackManager2 != null) {
                    callbackManager2.onActivityResult(this.this$0.getRequestCodeField(), resultCode, intent);
                }
                return new CallbackManager.ActivityResultParameters(this.this$0.getRequestCodeField(), resultCode, intent);
            }
        };
    }

    @Override // com.facebook.FacebookDialog
    public ActivityResultContract<CONTENT, CallbackManager.ActivityResultParameters> createActivityResultContractForShowingDialog(CallbackManager callbackManager) {
        return createActivityResultContractForShowingDialog(callbackManager, BASE_AUTOMATIC_MODE);
    }

    protected void showImpl(CONTENT content, Object mode) throws PackageManager.NameNotFoundException {
        Intrinsics.checkNotNullParameter(mode, "mode");
        AppCall appCallCreateAppCallForMode = createAppCallForMode(content, mode);
        if (appCallCreateAppCallForMode != null) {
            if (getActivityContext() instanceof ActivityResultRegistryOwner) {
                ComponentCallbacks2 activityContext = getActivityContext();
                Intrinsics.checkNotNull(activityContext, "null cannot be cast to non-null type androidx.activity.result.ActivityResultRegistryOwner");
                ActivityResultRegistry activityResultRegistry = ((ActivityResultRegistryOwner) activityContext).getActivityResultRegistry();
                Intrinsics.checkNotNullExpressionValue(activityResultRegistry, "registryOwner.activityResultRegistry");
                DialogPresenter.present(appCallCreateAppCallForMode, activityResultRegistry, this.callbackManager);
                appCallCreateAppCallForMode.setPending();
                return;
            }
            FragmentWrapper fragmentWrapper = this.fragmentWrapper;
            if (fragmentWrapper != null) {
                DialogPresenter.present(appCallCreateAppCallForMode, fragmentWrapper);
                return;
            }
            Activity activity = this.activity;
            if (activity != null) {
                DialogPresenter.present(appCallCreateAppCallForMode, activity);
                return;
            }
            return;
        }
        Log.e(TAG, "No code path should ever result in a null appCall");
        if (FacebookSdk.isDebugEnabled()) {
            throw new IllegalStateException("No code path should ever result in a null appCall".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Activity getActivityContext() {
        Activity activity = this.activity;
        if (activity != null) {
            return activity;
        }
        FragmentWrapper fragmentWrapper = this.fragmentWrapper;
        if (fragmentWrapper != null) {
            return fragmentWrapper.getActivity();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void startActivityForResult(android.content.Intent r4, int r5) {
        /*
            r3 = this;
            java.lang.String r0 = "intent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.app.Activity r0 = r3.getActivityContext()
            boolean r1 = r0 instanceof androidx.activity.result.ActivityResultRegistryOwner
            if (r1 == 0) goto L1e
            androidx.activity.result.ActivityResultRegistryOwner r0 = (androidx.activity.result.ActivityResultRegistryOwner) r0
            androidx.activity.result.ActivityResultRegistry r0 = r0.getActivityResultRegistry()
            java.lang.String r1 = "activity as ActivityResu…r).activityResultRegistry"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.facebook.CallbackManager r1 = r3.callbackManager
            com.facebook.internal.DialogPresenter.startActivityForResultWithAndroidX(r0, r1, r4, r5)
            goto L2b
        L1e:
            if (r0 == 0) goto L24
            r0.startActivityForResult(r4, r5)
            goto L2b
        L24:
            com.facebook.internal.FragmentWrapper r0 = r3.fragmentWrapper
            if (r0 == 0) goto L2d
            r0.startActivityForResult(r4, r5)
        L2b:
            r4 = 0
            goto L2f
        L2d:
            java.lang.String r4 = "Failed to find Activity or Fragment to startActivityForResult "
        L2f:
            if (r4 == 0) goto L47
            com.facebook.internal.Logger$Companion r5 = com.facebook.internal.Logger.INSTANCE
            com.facebook.LoggingBehavior r0 = com.facebook.LoggingBehavior.DEVELOPER_ERRORS
            java.lang.Class r1 = r3.getClass()
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "this.javaClass.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r2 = 6
            r5.log(r0, r2, r1, r4)
        L47:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FacebookDialogBase.startActivityForResult(android.content.Intent, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppCall createAppCallForMode(CONTENT content, Object mode) throws PackageManager.NameNotFoundException {
        AppCall appCallCreateAppCall;
        boolean z = mode == BASE_AUTOMATIC_MODE;
        Iterator<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> it = cachedModeHandlers().iterator();
        while (true) {
            if (!it.hasNext()) {
                appCallCreateAppCall = null;
                break;
            }
            FacebookDialogBase<CONTENT, RESULT>.ModeHandler next = it.next();
            if (z || Utility.areObjectsEqual(next.getMode(), mode)) {
                if (next.canShow(content, true)) {
                    try {
                        appCallCreateAppCall = next.createAppCall(content);
                        break;
                    } catch (FacebookException e) {
                        AppCall appCallCreateBaseAppCall = createBaseAppCall();
                        DialogPresenter.setupAppCallForValidationError(appCallCreateBaseAppCall, e);
                        appCallCreateAppCall = appCallCreateBaseAppCall;
                    }
                }
            }
        }
        if (appCallCreateAppCall != null) {
            return appCallCreateAppCall;
        }
        AppCall appCallCreateBaseAppCall2 = createBaseAppCall();
        DialogPresenter.setupAppCallForCannotShowError(appCallCreateBaseAppCall2);
        return appCallCreateBaseAppCall2;
    }

    private final void memorizeCallbackManager(CallbackManager callbackManager) {
        CallbackManager callbackManager2 = this.callbackManager;
        if (callbackManager2 == null) {
            this.callbackManager = callbackManager;
        } else if (callbackManager2 != callbackManager) {
            Log.w(TAG, "You're registering a callback on a Facebook dialog with two different callback managers. It's almost wrong and may cause unexpected results. Only the first callback manager will be used for handling activity result with androidx.");
        }
    }

    private final List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> cachedModeHandlers() {
        if (this.modeHandlers == null) {
            this.modeHandlers = getOrderedModeHandlers();
        }
        List<? extends FacebookDialogBase<CONTENT, RESULT>.ModeHandler> list = this.modeHandlers;
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<com.facebook.internal.FacebookDialogBase.ModeHandler<CONTENT of com.facebook.internal.FacebookDialogBase, RESULT of com.facebook.internal.FacebookDialogBase>>");
        return list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: FacebookDialogBase.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b¤\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001d\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\tH&¢\u0006\u0002\u0010\fJ\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u0001X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "", "(Lcom/facebook/internal/FacebookDialogBase;)V", "mode", "getMode", "()Ljava/lang/Object;", "setMode", "(Ljava/lang/Object;)V", "canShow", "", "content", "isBestEffort", "(Ljava/lang/Object;Z)Z", "createAppCall", "Lcom/facebook/internal/AppCall;", "(Ljava/lang/Object;)Lcom/facebook/internal/AppCall;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public abstract class ModeHandler {
        private Object mode = FacebookDialogBase.BASE_AUTOMATIC_MODE;

        public abstract boolean canShow(CONTENT content, boolean isBestEffort);

        public abstract AppCall createAppCall(CONTENT content);

        public ModeHandler() {
        }

        public Object getMode() {
            return this.mode;
        }

        public void setMode(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "<set-?>");
            this.mode = obj;
        }
    }
}
