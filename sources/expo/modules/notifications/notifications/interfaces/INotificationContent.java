package expo.modules.notifications.notifications.interfaces;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Parcelable;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import expo.modules.notifications.notifications.enums.NotificationPriority;
import io.sentry.protocol.SentryThread;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

/* compiled from: INotificationContent.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010(\u001a\u00020\u0011H&J\u0018\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,H¦@¢\u0006\u0002\u0010-R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012R\u0012\u0010\u001a\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0012R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\rR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\rR\u0014\u0010 \u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\rR\u0014\u0010\"\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\rR\u0014\u0010$\u001a\u0004\u0018\u00010%X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006."}, d2 = {"Lexpo/modules/notifications/notifications/interfaces/INotificationContent;", "Landroid/os/Parcelable;", "badgeCount", "", "getBadgeCount", "()Ljava/lang/Number;", "body", "Lorg/json/JSONObject;", "getBody", "()Lorg/json/JSONObject;", "categoryId", "", "getCategoryId", "()Ljava/lang/String;", ViewProps.COLOR, "getColor", "isAutoDismiss", "", "()Z", "isSticky", SentryThread.JsonKeys.PRIORITY, "Lexpo/modules/notifications/notifications/enums/NotificationPriority;", "getPriority", "()Lexpo/modules/notifications/notifications/enums/NotificationPriority;", "shouldPlayDefaultSound", "getShouldPlayDefaultSound", "shouldUseDefaultVibrationPattern", "getShouldUseDefaultVibrationPattern", "soundName", "getSoundName", "subText", "getSubText", "text", "getText", "title", "getTitle", NotificationsChannelSerializer.VIBRATION_PATTERN_KEY, "", "getVibrationPattern", "()[J", "containsImage", "getImage", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface INotificationContent extends Parcelable {
    boolean containsImage();

    Number getBadgeCount();

    JSONObject getBody();

    String getCategoryId();

    Number getColor();

    Object getImage(Context context, Continuation<? super Bitmap> continuation);

    NotificationPriority getPriority();

    boolean getShouldPlayDefaultSound();

    boolean getShouldUseDefaultVibrationPattern();

    String getSoundName();

    String getSubText();

    String getText();

    String getTitle();

    long[] getVibrationPattern();

    boolean isAutoDismiss();

    boolean isSticky();
}
