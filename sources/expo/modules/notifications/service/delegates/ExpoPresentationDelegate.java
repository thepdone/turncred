package expo.modules.notifications.service.delegates;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.provider.Settings;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import expo.modules.notifications.notifications.enums.NotificationPriority;
import expo.modules.notifications.notifications.model.Notification;
import expo.modules.notifications.notifications.model.NotificationBehavior;
import expo.modules.notifications.notifications.model.NotificationContent;
import expo.modules.notifications.notifications.model.NotificationRequest;
import expo.modules.notifications.notifications.presentation.builders.ExpoNotificationBuilder;
import expo.modules.notifications.service.NotificationsService;
import expo.modules.notifications.service.interfaces.PresentationDelegate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ExpoPresentationDelegate.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 &2\u00020\u0001:\u0001&B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0094@¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u0014H\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\u001a\u0010$\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lexpo/modules/notifications/service/delegates/ExpoPresentationDelegate;", "Lexpo/modules/notifications/service/interfaces/PresentationDelegate;", "context", "Landroid/content/Context;", "notificationManager", "Landroidx/core/app/NotificationManagerCompat;", "(Landroid/content/Context;Landroidx/core/app/NotificationManagerCompat;)V", "getContext", "()Landroid/content/Context;", "createNotification", "Landroid/app/Notification;", NotificationsService.NOTIFICATION_KEY, "Lexpo/modules/notifications/notifications/model/Notification;", NotificationsService.NOTIFICATION_BEHAVIOR_KEY, "Lexpo/modules/notifications/notifications/model/NotificationBehavior;", "(Lexpo/modules/notifications/notifications/model/Notification;Lexpo/modules/notifications/notifications/model/NotificationBehavior;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dismissAllNotifications", "", "dismissNotifications", NotificationsService.IDENTIFIERS_KEY, "", "", "fromBundle", "Lorg/json/JSONObject;", "bundle", "Landroid/os/Bundle;", "getAllPresentedNotifications", "getNotification", "statusBarNotification", "Landroid/service/notification/StatusBarNotification;", "getNotificationSoundUri", "Landroid/net/Uri;", "getNotifyId", "", "request", "Lexpo/modules/notifications/notifications/model/NotificationRequest;", "presentNotification", "behavior", "Companion", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class ExpoPresentationDelegate implements PresentationDelegate {
    protected static final int ANDROID_NOTIFICATION_ID = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    protected static final String INTERNAL_IDENTIFIER_AUTHORITY = "foreign_notifications";
    protected static final String INTERNAL_IDENTIFIER_ID_KEY = "id";
    protected static final String INTERNAL_IDENTIFIER_SCHEME = "expo-notifications";
    protected static final String INTERNAL_IDENTIFIER_TAG_KEY = "tag";
    private final Context context;
    private final NotificationManagerCompat notificationManager;

    protected Object createNotification(Notification notification, NotificationBehavior notificationBehavior, Continuation<? super android.app.Notification> continuation) {
        return createNotification$suspendImpl(this, notification, notificationBehavior, continuation);
    }

    protected int getNotifyId(NotificationRequest request) {
        return 0;
    }

    public ExpoPresentationDelegate(Context context, NotificationManagerCompat notificationManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notificationManager, "notificationManager");
        this.context = context;
        this.notificationManager = notificationManager;
    }

    protected final Context getContext() {
        return this.context;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ExpoPresentationDelegate(Context context, NotificationManagerCompat notificationManagerCompat, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            notificationManagerCompat = NotificationManagerCompat.from(context);
            Intrinsics.checkNotNullExpressionValue(notificationManagerCompat, "from(...)");
        }
        this(context, notificationManagerCompat);
    }

    /* compiled from: ExpoPresentationDelegate.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0004J\u001e\u0010\r\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0084T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0084T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0084T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0084T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0084T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lexpo/modules/notifications/service/delegates/ExpoPresentationDelegate$Companion;", "", "()V", "ANDROID_NOTIFICATION_ID", "", "INTERNAL_IDENTIFIER_AUTHORITY", "", "INTERNAL_IDENTIFIER_ID_KEY", "INTERNAL_IDENTIFIER_SCHEME", "INTERNAL_IDENTIFIER_TAG_KEY", "getInternalIdentifierKey", NotificationsService.NOTIFICATION_KEY, "Landroid/service/notification/StatusBarNotification;", "parseNotificationIdentifier", "Landroid/util/Pair;", "identifier", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Pair<String, Integer> parseNotificationIdentifier(String identifier) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            try {
                Uri uri = Uri.parse(identifier);
                if (!Intrinsics.areEqual(ExpoPresentationDelegate.INTERNAL_IDENTIFIER_SCHEME, uri.getScheme()) || !Intrinsics.areEqual(ExpoPresentationDelegate.INTERNAL_IDENTIFIER_AUTHORITY, uri.getAuthority())) {
                    return null;
                }
                String queryParameter = uri.getQueryParameter("tag");
                String queryParameter2 = uri.getQueryParameter("id");
                Intrinsics.checkNotNull(queryParameter2);
                return new Pair<>(queryParameter, Integer.valueOf(Integer.parseInt(queryParameter2)));
            } catch (NullPointerException e) {
                Log.e(ExpoPresentationDelegate.INTERNAL_IDENTIFIER_SCHEME, "Malformed foreign notification identifier: " + identifier, e);
                return null;
            } catch (NumberFormatException e2) {
                Log.e(ExpoPresentationDelegate.INTERNAL_IDENTIFIER_SCHEME, "Malformed foreign notification identifier: " + identifier, e2);
                return null;
            } catch (UnsupportedOperationException e3) {
                Log.e(ExpoPresentationDelegate.INTERNAL_IDENTIFIER_SCHEME, "Malformed foreign notification identifier: " + identifier, e3);
                return null;
            }
        }

        protected final String getInternalIdentifierKey(StatusBarNotification notification) {
            Intrinsics.checkNotNullParameter(notification, "notification");
            Uri.Builder builderBuildUpon = Uri.parse("expo-notifications://foreign_notifications").buildUpon();
            String tag = notification.getTag();
            if (tag != null) {
                Intrinsics.checkNotNull(tag);
                builderBuildUpon.appendQueryParameter("tag", tag);
            }
            builderBuildUpon.appendQueryParameter("id", String.valueOf(notification.getId()));
            String string = builderBuildUpon.toString();
            Intrinsics.checkNotNullExpressionValue(string, "with(...)");
            return string;
        }
    }

    @Override // expo.modules.notifications.service.interfaces.PresentationDelegate
    public void presentNotification(Notification notification, NotificationBehavior behavior) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        if (behavior == null || behavior.shouldShowAlert()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(notification, behavior, null), 3, null);
        } else if (behavior.shouldPlaySound()) {
            Uri notificationSoundUri = getNotificationSoundUri(notification);
            if (notificationSoundUri == null) {
                notificationSoundUri = Settings.System.DEFAULT_NOTIFICATION_URI;
            }
            RingtoneManager.getRingtone(this.context, notificationSoundUri).play();
        }
    }

    /* compiled from: ExpoPresentationDelegate.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.notifications.service.delegates.ExpoPresentationDelegate$presentNotification$1", f = "ExpoPresentationDelegate.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: expo.modules.notifications.service.delegates.ExpoPresentationDelegate$presentNotification$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ NotificationBehavior $behavior;
        final /* synthetic */ Notification $notification;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Notification notification, NotificationBehavior notificationBehavior, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$notification = notification;
            this.$behavior = notificationBehavior;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ExpoPresentationDelegate.this.new AnonymousClass1(this.$notification, this.$behavior, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = ExpoPresentationDelegate.this.createNotification(this.$notification, this.$behavior, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            NotificationManagerCompat.from(ExpoPresentationDelegate.this.getContext()).notify(this.$notification.getNotificationRequest().getIdentifier(), ExpoPresentationDelegate.this.getNotifyId(this.$notification.getNotificationRequest()), (android.app.Notification) obj);
            return Unit.INSTANCE;
        }
    }

    private final Uri getNotificationSoundUri(Notification notification) {
        NotificationChannel notificationChannel;
        String notificationChannel2 = notification.getNotificationRequest().getTrigger().getNotificationChannel();
        if (notificationChannel2 == null || (notificationChannel = this.notificationManager.getNotificationChannel(notificationChannel2)) == null) {
            return null;
        }
        return notificationChannel.getSound();
    }

    @Override // expo.modules.notifications.service.interfaces.PresentationDelegate
    public Collection<Notification> getAllPresentedNotifications() {
        Object systemService = this.context.getSystemService(NotificationsService.NOTIFICATION_KEY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        StatusBarNotification[] activeNotifications = ((NotificationManager) systemService).getActiveNotifications();
        Intrinsics.checkNotNullExpressionValue(activeNotifications, "getActiveNotifications(...)");
        ArrayList arrayList = new ArrayList();
        for (StatusBarNotification statusBarNotification : activeNotifications) {
            Intrinsics.checkNotNull(statusBarNotification);
            Notification notification = getNotification(statusBarNotification);
            if (notification != null) {
                arrayList.add(notification);
            }
        }
        return arrayList;
    }

    @Override // expo.modules.notifications.service.interfaces.PresentationDelegate
    public void dismissNotifications(Collection<String> identifiers) {
        Object next;
        Intrinsics.checkNotNullParameter(identifiers, "identifiers");
        for (String str : identifiers) {
            Pair<String, Integer> notificationIdentifier = INSTANCE.parseNotificationIdentifier(str);
            if (notificationIdentifier != null) {
                NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(this.context);
                String str2 = (String) notificationIdentifier.first;
                Object second = notificationIdentifier.second;
                Intrinsics.checkNotNullExpressionValue(second, "second");
                notificationManagerCompatFrom.cancel(str2, ((Number) second).intValue());
            } else {
                Iterator<T> it = getAllPresentedNotifications().iterator();
                while (true) {
                    if (it.hasNext()) {
                        next = it.next();
                        if (Intrinsics.areEqual(((Notification) next).getNotificationRequest().getIdentifier(), str)) {
                            break;
                        }
                    } else {
                        next = null;
                        break;
                    }
                }
                Notification notification = (Notification) next;
                NotificationManagerCompat.from(this.context).cancel(str, getNotifyId(notification != null ? notification.getNotificationRequest() : null));
            }
        }
    }

    @Override // expo.modules.notifications.service.interfaces.PresentationDelegate
    public void dismissAllNotifications() {
        NotificationManagerCompat.from(this.context).cancelAll();
    }

    static /* synthetic */ Object createNotification$suspendImpl(ExpoPresentationDelegate expoPresentationDelegate, Notification notification, NotificationBehavior notificationBehavior, Continuation<? super android.app.Notification> continuation) {
        ExpoNotificationBuilder expoNotificationBuilder = new ExpoNotificationBuilder(expoPresentationDelegate.context, notification, new SharedPreferencesNotificationCategoriesStore(expoPresentationDelegate.context));
        expoNotificationBuilder.setAllowedBehavior(notificationBehavior);
        return expoNotificationBuilder.build(continuation);
    }

    protected Notification getNotification(StatusBarNotification statusBarNotification) {
        Intrinsics.checkNotNullParameter(statusBarNotification, "statusBarNotification");
        android.app.Notification notification = statusBarNotification.getNotification();
        byte[] byteArray = notification.extras.getByteArray(ExpoNotificationBuilder.EXTRAS_MARSHALLED_NOTIFICATION_REQUEST_KEY);
        if (byteArray != null) {
            try {
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.unmarshall(byteArray, 0, byteArray.length);
                parcelObtain.setDataPosition(0);
                NotificationRequest notificationRequestCreateFromParcel = NotificationRequest.CREATOR.createFromParcel(parcelObtain);
                Intrinsics.checkNotNullExpressionValue(notificationRequestCreateFromParcel, "createFromParcel(...)");
                parcelObtain.recycle();
                return new Notification(notificationRequestCreateFromParcel, new Date(statusBarNotification.getPostTime()));
            } catch (Exception unused) {
                Log.e(INTERNAL_IDENTIFIER_SCHEME, "Could not have unmarshalled NotificationRequest from (" + statusBarNotification.getTag() + ", " + statusBarNotification.getId() + ").");
            }
        }
        NotificationContent.Builder builder = new NotificationContent.Builder();
        CharSequence contentTitle = NotificationCompat.getContentTitle(notification);
        NotificationContent.Builder title = builder.setTitle(contentTitle != null ? contentTitle.toString() : null);
        CharSequence contentText = NotificationCompat.getContentText(notification);
        NotificationContent.Builder text = title.setText(contentText != null ? contentText.toString() : null);
        CharSequence subText = NotificationCompat.getSubText(notification);
        NotificationContent.Builder sound = text.setSubtitle(subText != null ? subText.toString() : null).setAutoDismiss(NotificationCompat.getAutoCancel(notification)).setSticky(NotificationCompat.getOngoing(notification)).setPriority(NotificationPriority.fromNativeValue(notification.priority)).setVibrationPattern(notification.vibrate).setSound(notification.sound);
        Bundle extras = notification.extras;
        Intrinsics.checkNotNullExpressionValue(extras, "extras");
        return new Notification(new NotificationRequest(INSTANCE.getInternalIdentifierKey(statusBarNotification), sound.setBody(fromBundle(extras)).build(), null), new Date(statusBarNotification.getPostTime()));
    }

    protected JSONObject fromBundle(Bundle bundle) throws JSONException {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            try {
                jSONObject.put(str, JSONObject.wrap(bundle.get(str)));
            } catch (JSONException e) {
                Log.d(INTERNAL_IDENTIFIER_SCHEME, "Error encountered while serializing Android notification extras: " + str + " -> " + bundle.get(str), e);
            }
        }
        return jSONObject;
    }
}
