package expo.modules.notifications.notifications.model;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: NotificationData.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0016\n\u0002\b\f\b\u0087@\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010,\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b4\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\nR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\u001c\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\nR\u0011\u0010\u001e\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\nR\u0013\u0010 \u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b!\u0010\u0015R\u0011\u0010\"\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b#\u0010\nR\u0013\u0010$\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b%\u0010\u0015R\u0013\u0010&\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b'\u0010\u0015R\u0013\u0010(\u001a\u0004\u0018\u00010)8F¢\u0006\u0006\u001a\u0004\b*\u0010+\u0088\u0001\u0002\u0092\u0001\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¨\u00065"}, d2 = {"Lexpo/modules/notifications/notifications/model/NotificationData;", "", "data", "", "", "constructor-impl", "(Ljava/util/Map;)Ljava/util/Map;", "autoDismiss", "", "getAutoDismiss-impl", "(Ljava/util/Map;)Z", "badge", "", "getBadge-impl", "(Ljava/util/Map;)Ljava/lang/Integer;", "body", "Lorg/json/JSONObject;", "getBody-impl", "(Ljava/util/Map;)Lorg/json/JSONObject;", "categoryId", "getCategoryId-impl", "(Ljava/util/Map;)Ljava/lang/String;", ViewProps.COLOR, "getColor-impl", "isSticky", "isSticky-impl", "message", "getMessage-impl", "shouldPlayDefaultSound", "getShouldPlayDefaultSound-impl", "shouldUseDefaultVibrationPattern", "getShouldUseDefaultVibrationPattern-impl", NotificationsChannelSerializer.SOUND_KEY, "getSound-impl", "sticky", "getSticky-impl", "subText", "getSubText-impl", "title", "getTitle-impl", NotificationsChannelSerializer.VIBRATION_PATTERN_KEY, "", "getVibrationPattern-impl", "(Ljava/util/Map;)[J", "equals", "other", "equals-impl", "(Ljava/util/Map;Ljava/lang/Object;)Z", "hashCode", "hashCode-impl", "(Ljava/util/Map;)I", InAppPurchaseConstants.METHOD_TO_STRING, "toString-impl", "expo-notifications_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
/* loaded from: classes5.dex */
public final class NotificationData {
    private final Map<String, String> data;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ NotificationData m5789boximpl(Map map) {
        return new NotificationData(map);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static Map<String, ? extends String> m5790constructorimpl(Map<String, String> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5791equalsimpl(Map<String, ? extends String> map, Object obj) {
        return (obj instanceof NotificationData) && Intrinsics.areEqual(map, ((NotificationData) obj).getData());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5792equalsimpl0(Map<String, ? extends String> map, Map<String, ? extends String> map2) {
        return Intrinsics.areEqual(map, map2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5806hashCodeimpl(Map<String, ? extends String> map) {
        return map.hashCode();
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5808toStringimpl(Map<String, ? extends String> map) {
        return "NotificationData(data=" + map + ")";
    }

    public boolean equals(Object obj) {
        return m5791equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m5806hashCodeimpl(this.data);
    }

    public String toString() {
        return m5808toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ Map getData() {
        return this.data;
    }

    private /* synthetic */ NotificationData(Map map) {
        this.data = map;
    }

    /* renamed from: getTitle-impl, reason: not valid java name */
    public static final String m5804getTitleimpl(Map<String, ? extends String> map) {
        return map.get("title");
    }

    /* renamed from: getMessage-impl, reason: not valid java name */
    public static final String m5798getMessageimpl(Map<String, ? extends String> map) {
        return map.get("message");
    }

    /* renamed from: getBody-impl, reason: not valid java name */
    public static final JSONObject m5795getBodyimpl(Map<String, ? extends String> map) {
        try {
            String str = map.get("body");
            if (str != null) {
                return new JSONObject(str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: getSound-impl, reason: not valid java name */
    public static final String m5801getSoundimpl(Map<String, ? extends String> map) {
        return map.get(NotificationsChannelSerializer.SOUND_KEY);
    }

    /* renamed from: getShouldPlayDefaultSound-impl, reason: not valid java name */
    public static final boolean m5799getShouldPlayDefaultSoundimpl(Map<String, ? extends String> map) {
        return m5801getSoundimpl(map) == null;
    }

    /* renamed from: getShouldUseDefaultVibrationPattern-impl, reason: not valid java name */
    public static final boolean m5800getShouldUseDefaultVibrationPatternimpl(Map<String, ? extends String> map) {
        String str = map.get("vibrate");
        return str != null && Boolean.parseBoolean(str);
    }

    /* renamed from: isSticky-impl, reason: not valid java name */
    public static final boolean m5807isStickyimpl(Map<String, ? extends String> map) {
        String str = map.get("sticky");
        if (str != null) {
            return Boolean.parseBoolean(str);
        }
        return false;
    }

    /* renamed from: getVibrationPattern-impl, reason: not valid java name */
    public static final long[] m5805getVibrationPatternimpl(Map<String, ? extends String> map) {
        try {
            String str = map.get("vibrate");
            if (str == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            long[] jArr = new long[length];
            for (int i = 0; i < length; i++) {
                jArr[i] = jSONArray.getLong(i);
            }
            return jArr;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: getColor-impl, reason: not valid java name */
    public static final String m5797getColorimpl(Map<String, ? extends String> map) {
        return map.get(ViewProps.COLOR);
    }

    /* renamed from: getAutoDismiss-impl, reason: not valid java name */
    public static final boolean m5793getAutoDismissimpl(Map<String, ? extends String> map) {
        String str = map.get("autoDismiss");
        if (str != null) {
            return Boolean.parseBoolean(str);
        }
        return true;
    }

    /* renamed from: getCategoryId-impl, reason: not valid java name */
    public static final String m5796getCategoryIdimpl(Map<String, ? extends String> map) {
        return map.get("categoryId");
    }

    /* renamed from: getSticky-impl, reason: not valid java name */
    public static final boolean m5802getStickyimpl(Map<String, ? extends String> map) {
        String str = map.get("sticky");
        if (str != null) {
            return Boolean.parseBoolean(str);
        }
        return false;
    }

    /* renamed from: getSubText-impl, reason: not valid java name */
    public static final String m5803getSubTextimpl(Map<String, ? extends String> map) {
        return map.get("subtitle");
    }

    /* renamed from: getBadge-impl, reason: not valid java name */
    public static final Integer m5794getBadgeimpl(Map<String, ? extends String> map) {
        String str = map.get("badge");
        if (str != null) {
            return StringsKt.toIntOrNull(str);
        }
        return null;
    }
}
