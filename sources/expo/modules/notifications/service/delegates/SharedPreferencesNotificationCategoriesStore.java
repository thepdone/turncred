package expo.modules.notifications.service.delegates;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import expo.modules.notifications.notifications.model.NotificationCategory;
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
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SharedPreferencesNotificationCategoriesStore.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u0007R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lexpo/modules/notifications/service/delegates/SharedPreferencesNotificationCategoriesStore;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allNotificationCategories", "", "Lexpo/modules/notifications/notifications/model/NotificationCategory;", "getAllNotificationCategories", "()Ljava/util/Collection;", "sharedPreferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getNotificationCategory", "identifier", "", "preferencesNotificationCategoryKey", "removeNotificationCategory", "", "saveNotificationCategory", NotificationsService.NOTIFICATION_CATEGORY_KEY, "Companion", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SharedPreferencesNotificationCategoriesStore {
    private static final String NOTIFICATION_CATEGORY_KEY_PREFIX = "notification_category-";
    private static final String SHARED_PREFERENCES_NAME = "expo.modules.notifications.SharedPreferencesNotificationCategoriesStore";
    private final SharedPreferences sharedPreferences;

    public SharedPreferencesNotificationCategoriesStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
    }

    public final NotificationCategory getNotificationCategory(String identifier) throws IOException, ClassNotFoundException {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        String string = this.sharedPreferences.getString(preferencesNotificationCategoryKey(identifier), null);
        if (string == null) {
            return null;
        }
        ObjectInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(string, 2));
        try {
            byteArrayInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                Object object = byteArrayInputStream.readObject();
                if (!(object instanceof NotificationCategory)) {
                    throw new InvalidClassException("Expected serialized object to be an instance of " + NotificationCategory.class + ". Found: " + object);
                }
                CloseableKt.closeFinally(byteArrayInputStream, null);
                CloseableKt.closeFinally(byteArrayInputStream, null);
                return (NotificationCategory) object;
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } finally {
            }
        }
    }

    public final Collection<NotificationCategory> getAllNotificationCategories() {
        NotificationCategory notificationCategory;
        String str;
        Map<String, ?> all = this.sharedPreferences.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "<get-key>(...)");
            if (StringsKt.startsWith$default(key, NOTIFICATION_CATEGORY_KEY_PREFIX, false, 2, (Object) null)) {
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
                        if (!(object instanceof NotificationCategory)) {
                            throw new InvalidClassException("Expected serialized object to be an instance of " + NotificationCategory.class + ". Found: " + object);
                        }
                        CloseableKt.closeFinally(byteArrayInputStream, null);
                        CloseableKt.closeFinally(byteArrayInputStream, null);
                        notificationCategory = (NotificationCategory) object;
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
                notificationCategory = null;
            }
            if (notificationCategory != null) {
                arrayList.add(notificationCategory);
            }
        }
        return arrayList;
    }

    public final NotificationCategory saveNotificationCategory(NotificationCategory notificationCategory) throws IOException {
        Intrinsics.checkNotNullParameter(notificationCategory, "notificationCategory");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        String identifier = notificationCategory.getIdentifier();
        Intrinsics.checkNotNullExpressionValue(identifier, "getIdentifier(...)");
        if (editorEdit.putString(preferencesNotificationCategoryKey(identifier), Base64SerializationKt.encodedInBase64(notificationCategory)).commit()) {
            return notificationCategory;
        }
        return null;
    }

    public final boolean removeNotificationCategory(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        if (this.sharedPreferences.getString(preferencesNotificationCategoryKey(identifier), null) == null) {
            return false;
        }
        return this.sharedPreferences.edit().remove(preferencesNotificationCategoryKey(identifier)).commit();
    }

    private final String preferencesNotificationCategoryKey(String identifier) {
        return NOTIFICATION_CATEGORY_KEY_PREFIX + identifier;
    }
}
