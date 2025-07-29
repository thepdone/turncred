package expo.modules.notifications.service.delegates;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import expo.modules.notifications.notifications.model.NotificationRequest;
import expo.modules.notifications.service.NotificationsService;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SharedPreferencesNotificationsStore.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006J \u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u0011\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0007R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lexpo/modules/notifications/service/delegates/SharedPreferencesNotificationsStore;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allNotificationRequests", "", "Lexpo/modules/notifications/notifications/model/NotificationRequest;", "getAllNotificationRequests", "()Ljava/util/Collection;", "sharedPreferences", "Landroid/content/SharedPreferences;", "getNotificationRequest", "identifier", "", "preferencesNotificationRequestKey", "removeAllNotificationRequests", "removeNotificationRequest", "Landroid/content/SharedPreferences$Editor;", "kotlin.jvm.PlatformType", "editor", "", "saveNotificationRequest", NotificationsService.NOTIFICATION_REQUEST_KEY, "Companion", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SharedPreferencesNotificationsStore {
    private static final String NOTIFICATION_REQUEST_KEY_PREFIX = "notification_request-";
    private static final String SHARED_PREFERENCES_NAME = "expo.modules.notifications.SharedPreferencesNotificationsStore";
    private final SharedPreferences sharedPreferences;

    public SharedPreferencesNotificationsStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.sharedPreferences = sharedPreferences;
    }

    public final NotificationRequest getNotificationRequest(String identifier) throws IOException, ClassNotFoundException {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        String string = this.sharedPreferences.getString(preferencesNotificationRequestKey(identifier), null);
        if (string == null) {
            return null;
        }
        ObjectInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(string, 2));
        try {
            byteArrayInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                Object object = byteArrayInputStream.readObject();
                if (!(object instanceof NotificationRequest)) {
                    throw new InvalidClassException("Expected serialized object to be an instance of " + NotificationRequest.class + ". Found: " + object);
                }
                CloseableKt.closeFinally(byteArrayInputStream, null);
                CloseableKt.closeFinally(byteArrayInputStream, null);
                return (NotificationRequest) object;
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } finally {
            }
        }
    }

    public final Collection<NotificationRequest> getAllNotificationRequests() {
        NotificationRequest notificationRequest;
        String str;
        Map<String, ?> all = this.sharedPreferences.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "<get-key>(...)");
            if (StringsKt.startsWith$default(key, NOTIFICATION_REQUEST_KEY_PREFIX, false, 2, (Object) null)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            try {
                str = (String) ((Map.Entry) it.next()).getValue();
            } catch (IOException | ClassNotFoundException unused) {
            }
            if (str != null) {
                ObjectInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(str, 2));
                try {
                    byteArrayInputStream = new ObjectInputStream(byteArrayInputStream);
                    try {
                        Object object = byteArrayInputStream.readObject();
                        if (!(object instanceof NotificationRequest)) {
                            throw new InvalidClassException("Expected serialized object to be an instance of " + NotificationRequest.class + ". Found: " + object);
                        }
                        CloseableKt.closeFinally(byteArrayInputStream, null);
                        CloseableKt.closeFinally(byteArrayInputStream, null);
                        notificationRequest = (NotificationRequest) object;
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } else {
                notificationRequest = null;
            }
            if (notificationRequest != null) {
                arrayList.add(notificationRequest);
            }
        }
        return arrayList;
    }

    public final void saveNotificationRequest(NotificationRequest notificationRequest) throws IOException {
        Intrinsics.checkNotNullParameter(notificationRequest, "notificationRequest");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        String identifier = notificationRequest.getIdentifier();
        Intrinsics.checkNotNullExpressionValue(identifier, "getIdentifier(...)");
        editorEdit.putString(preferencesNotificationRequestKey(identifier), Base64SerializationKt.encodedInBase64(notificationRequest)).apply();
    }

    public final void removeNotificationRequest(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(editorEdit, "edit(...)");
        removeNotificationRequest(editorEdit, identifier).apply();
    }

    private final SharedPreferences.Editor removeNotificationRequest(SharedPreferences.Editor editor, String identifier) {
        return editor.remove(preferencesNotificationRequestKey(identifier));
    }

    public final Collection<String> removeAllNotificationRequests() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        Collection<NotificationRequest> allNotificationRequests = getAllNotificationRequests();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(allNotificationRequests, 10));
        for (NotificationRequest notificationRequest : allNotificationRequests) {
            Intrinsics.checkNotNull(editorEdit);
            String identifier = notificationRequest.getIdentifier();
            Intrinsics.checkNotNullExpressionValue(identifier, "getIdentifier(...)");
            removeNotificationRequest(editorEdit, identifier);
            arrayList.add(notificationRequest.getIdentifier());
        }
        editorEdit.apply();
        return arrayList;
    }

    private final String preferencesNotificationRequestKey(String identifier) {
        return NOTIFICATION_REQUEST_KEY_PREFIX + identifier;
    }
}
