package expo.modules.notifications.notifications.presentation.builders;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.util.Log;
import androidx.camera.video.AudioStats;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.notifications.notifications.enums.NotificationPriority;
import expo.modules.notifications.notifications.interfaces.INotificationContent;
import expo.modules.notifications.notifications.model.NotificationAction;
import expo.modules.notifications.notifications.model.NotificationBehavior;
import expo.modules.notifications.notifications.model.NotificationCategory;
import expo.modules.notifications.notifications.model.NotificationRequest;
import expo.modules.notifications.notifications.model.TextInputNotificationAction;
import expo.modules.notifications.service.NotificationsService;
import expo.modules.notifications.service.delegates.SharedPreferencesNotificationCategoriesStore;
import io.sentry.protocol.SentryThread;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: ExpoNotificationBuilder.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u0000 02\u00020\u0001:\u00010B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010 \u001a\u00020!H\u0096@¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0004J\u0010\u0010'\u001a\u00020$2\u0006\u0010%\u001a\u00020(H\u0004J\u0012\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,H\u0004J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020.H\u0002R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lexpo/modules/notifications/notifications/presentation/builders/ExpoNotificationBuilder;", "Lexpo/modules/notifications/notifications/presentation/builders/BaseNotificationBuilder;", "context", "Landroid/content/Context;", NotificationsService.NOTIFICATION_KEY, "Lexpo/modules/notifications/notifications/model/Notification;", "store", "Lexpo/modules/notifications/service/delegates/SharedPreferencesNotificationCategoriesStore;", "(Landroid/content/Context;Lexpo/modules/notifications/notifications/model/Notification;Lexpo/modules/notifications/service/delegates/SharedPreferencesNotificationCategoriesStore;)V", ViewProps.COLOR, "", "getColor", "()Ljava/lang/Number;", "icon", "", "getIcon", "()I", "largeIcon", "Landroid/graphics/Bitmap;", "getLargeIcon", "()Landroid/graphics/Bitmap;", SentryThread.JsonKeys.PRIORITY, "getPriority", "addActionsToBuilder", "", "builder", "Landroidx/core/app/NotificationCompat$Builder;", "categoryIdentifier", "", "applySoundsAndVibrations", "content", "Lexpo/modules/notifications/notifications/interfaces/INotificationContent;", "build", "Landroid/app/Notification;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildButtonAction", "Landroidx/core/app/NotificationCompat$Action;", "action", "Lexpo/modules/notifications/notifications/model/NotificationAction;", "buildTextInputAction", "Lexpo/modules/notifications/notifications/model/TextInputNotificationAction;", "marshallNotificationRequest", "", "request", "Lexpo/modules/notifications/notifications/model/NotificationRequest;", "shouldPlaySound", "", "shouldVibrate", "Companion", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class ExpoNotificationBuilder extends BaseNotificationBuilder {
    public static final String EXTRAS_BODY_KEY = "body";
    public static final String EXTRAS_MARSHALLED_NOTIFICATION_REQUEST_KEY = "expo.notification_request";
    public static final String META_DATA_DEFAULT_COLOR_KEY = "expo.modules.notifications.default_notification_color";
    public static final String META_DATA_DEFAULT_ICON_KEY = "expo.modules.notifications.default_notification_icon";
    public static final String META_DATA_LARGE_ICON_KEY = "expo.modules.notifications.large_notification_icon";
    private final SharedPreferencesNotificationCategoriesStore store;

    /* compiled from: ExpoNotificationBuilder.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder", f = "ExpoNotificationBuilder.kt", i = {0}, l = {151}, m = "build$suspendImpl", n = {"builder"}, s = {"L$0"})
    /* renamed from: expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder$build$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ExpoNotificationBuilder.build$suspendImpl(ExpoNotificationBuilder.this, this);
        }
    }

    @Override // expo.modules.notifications.notifications.interfaces.NotificationBuilder
    public Object build(Continuation<? super Notification> continuation) {
        return build$suspendImpl(this, continuation);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoNotificationBuilder(Context context, expo.modules.notifications.notifications.model.Notification notification, SharedPreferencesNotificationCategoriesStore store) {
        super(context, notification);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notification, "notification");
        Intrinsics.checkNotNullParameter(store, "store");
        this.store = store;
    }

    public void addActionsToBuilder(NotificationCompat.Builder builder, String categoryIdentifier) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(categoryIdentifier, "categoryIdentifier");
        List<NotificationAction> listEmptyList = CollectionsKt.emptyList();
        try {
            NotificationCategory notificationCategory = this.store.getNotificationCategory(categoryIdentifier);
            if (notificationCategory != null) {
                List<NotificationAction> actions = notificationCategory.getActions();
                Intrinsics.checkNotNullExpressionValue(actions, "getActions(...)");
                listEmptyList = actions;
            }
        } catch (IOException e) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("Could not read category with identifier: %s. %s", Arrays.copyOf(new Object[]{categoryIdentifier, e.getMessage()}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            Log.e("expo-notifications", str);
        } catch (ClassNotFoundException e2) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String str2 = String.format("Could not read category with identifier: %s. %s", Arrays.copyOf(new Object[]{categoryIdentifier, e2.getMessage()}, 2));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            Log.e("expo-notifications", str2);
        }
        for (NotificationAction notificationAction : listEmptyList) {
            if (notificationAction instanceof TextInputNotificationAction) {
                builder.addAction(buildTextInputAction((TextInputNotificationAction) notificationAction));
            } else {
                builder.addAction(buildButtonAction(notificationAction));
            }
        }
    }

    protected final NotificationCompat.Action buildButtonAction(NotificationAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        NotificationCompat.Action actionBuild = new NotificationCompat.Action.Builder(getIcon(), action.getTitle(), NotificationsService.INSTANCE.createNotificationResponseIntent(getContext(), getNotification(), action)).build();
        Intrinsics.checkNotNullExpressionValue(actionBuild, "build(...)");
        return actionBuild;
    }

    protected final NotificationCompat.Action buildTextInputAction(TextInputNotificationAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        PendingIntent pendingIntentCreateNotificationResponseIntent = NotificationsService.INSTANCE.createNotificationResponseIntent(getContext(), getNotification(), action);
        RemoteInput remoteInputBuild = new RemoteInput.Builder(NotificationsService.USER_TEXT_RESPONSE_KEY).setLabel(action.getPlaceholder()).build();
        Intrinsics.checkNotNullExpressionValue(remoteInputBuild, "build(...)");
        NotificationCompat.Action actionBuild = new NotificationCompat.Action.Builder(getIcon(), action.getTitle(), pendingIntentCreateNotificationResponseIntent).addRemoteInput(remoteInputBuild).build();
        Intrinsics.checkNotNullExpressionValue(actionBuild, "build(...)");
        return actionBuild;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object build$suspendImpl(expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder r8, kotlin.coroutines.Continuation<? super android.app.Notification> r9) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder.build$suspendImpl(expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void applySoundsAndVibrations(INotificationContent content, NotificationCompat.Builder builder) {
        boolean zShouldPlaySound = shouldPlaySound();
        boolean zShouldVibrate = shouldVibrate();
        if (zShouldPlaySound || zShouldVibrate) {
            return;
        }
        builder.setSilent(true);
    }

    protected final byte[] marshallNotificationRequest(NotificationRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            Parcel parcelObtain = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain(...)");
            request.writeToParcel(parcelObtain, 0);
            byte[] bArrMarshall = parcelObtain.marshall();
            parcelObtain.recycle();
            return bArrMarshall;
        } catch (Exception e) {
            Log.e("expo-notifications", "Could not marshalled notification request: " + request.getIdentifier() + ".", e);
            return null;
        }
    }

    private final boolean shouldPlaySound() {
        NotificationBehavior notificationBehavior = getNotificationBehavior();
        return (notificationBehavior != null ? notificationBehavior.shouldPlaySound() : true) && (getNotificationContent().getShouldPlayDefaultSound() || getNotificationContent().getSoundName() != null);
    }

    private final boolean shouldVibrate() {
        NotificationBehavior notificationBehavior = getNotificationBehavior();
        return (notificationBehavior != null ? notificationBehavior.shouldPlaySound() : true) && (getNotificationContent().getShouldUseDefaultVibrationPattern() || getNotificationContent().getVibrationPattern() != null);
    }

    private final int getPriority() {
        double dMin;
        NotificationPriority priority = getNotificationContent().getPriority();
        NotificationBehavior notificationBehavior = getNotificationBehavior();
        if (notificationBehavior == null) {
            if (priority != null) {
                return priority.getNativeValue();
            }
            return 1;
        }
        NotificationPriority priorityOverride = notificationBehavior.getPriorityOverride();
        if (priorityOverride != null) {
            return priorityOverride.getNativeValue();
        }
        if (priority == null) {
            priority = NotificationPriority.DEFAULT;
        }
        int nativeValue = priority.getNativeValue();
        if (notificationBehavior.shouldShowAlert()) {
            dMin = Math.max(1.0d, nativeValue);
        } else {
            dMin = Math.min(AudioStats.AUDIO_AMPLITUDE_NONE, nativeValue);
        }
        return (int) dMin;
    }

    protected final Bitmap getLargeIcon() throws PackageManager.NameNotFoundException {
        try {
            ApplicationInfo applicationInfo = getContext().getPackageManager().getApplicationInfo(getContext().getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            if (!applicationInfo.metaData.containsKey(META_DATA_LARGE_ICON_KEY)) {
                return null;
            }
            return BitmapFactory.decodeResource(getContext().getResources(), applicationInfo.metaData.getInt(META_DATA_LARGE_ICON_KEY));
        } catch (Exception e) {
            Log.e("expo-notifications", "Could not have fetched large notification icon.", e);
            return null;
        }
    }

    protected int getIcon() throws PackageManager.NameNotFoundException {
        try {
            ApplicationInfo applicationInfo = getContext().getPackageManager().getApplicationInfo(getContext().getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            if (applicationInfo.metaData.containsKey(META_DATA_DEFAULT_ICON_KEY)) {
                return applicationInfo.metaData.getInt(META_DATA_DEFAULT_ICON_KEY);
            }
        } catch (Exception e) {
            Log.e("expo-notifications", "Could not have fetched default notification icon.", e);
        }
        return getContext().getApplicationInfo().icon;
    }

    protected Number getColor() throws PackageManager.NameNotFoundException {
        Number color = getNotificationContent().getColor();
        if (color == null) {
            color = null;
            try {
                ApplicationInfo applicationInfo = getContext().getPackageManager().getApplicationInfo(getContext().getPackageName(), 128);
                Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
                if (applicationInfo.metaData.containsKey(META_DATA_DEFAULT_COLOR_KEY)) {
                    return Integer.valueOf(getContext().getResources().getColor(applicationInfo.metaData.getInt(META_DATA_DEFAULT_COLOR_KEY), null));
                }
            } catch (Exception e) {
                Log.e("expo-notifications", "Could not have fetched default notification color.", e);
            }
        }
        return color;
    }
}
