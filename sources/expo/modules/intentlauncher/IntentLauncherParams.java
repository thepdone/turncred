package expo.modules.intentlauncher;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import io.sentry.SentryBaseEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IntentLauncherParams.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jn\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010-\u001a\u00020\nHÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R*\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001c\u0012\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u0011R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u000f\u001a\u0004\b \u0010\u0011¨\u0006/"}, d2 = {"Lexpo/modules/intentlauncher/IntentLauncherParams;", "Lexpo/modules/kotlin/records/Record;", "type", "", "category", SentryBaseEvent.JsonKeys.EXTRA, "", "", "data", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "", "packageName", "className", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getCategory$annotations", "()V", "getCategory", "()Ljava/lang/String;", "getClassName$annotations", "getClassName", "getData$annotations", "getData", "getExtra$annotations", "getExtra", "()Ljava/util/Map;", "getFlags$annotations", "getFlags", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPackageName$annotations", "getPackageName", "getType$annotations", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lexpo/modules/intentlauncher/IntentLauncherParams;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "expo-intent-launcher_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class IntentLauncherParams implements Record {
    private final String category;
    private final String className;
    private final String data;
    private final Map<String, Object> extra;
    private final Integer flags;
    private final String packageName;
    private final String type;

    public static /* synthetic */ IntentLauncherParams copy$default(IntentLauncherParams intentLauncherParams, String str, String str2, Map map, String str3, Integer num, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = intentLauncherParams.type;
        }
        if ((i & 2) != 0) {
            str2 = intentLauncherParams.category;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            map = intentLauncherParams.extra;
        }
        Map map2 = map;
        if ((i & 8) != 0) {
            str3 = intentLauncherParams.data;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            num = intentLauncherParams.flags;
        }
        Integer num2 = num;
        if ((i & 32) != 0) {
            str4 = intentLauncherParams.packageName;
        }
        String str8 = str4;
        if ((i & 64) != 0) {
            str5 = intentLauncherParams.className;
        }
        return intentLauncherParams.copy(str, str6, map2, str7, num2, str8, str5);
    }

    @Field
    public static /* synthetic */ void getCategory$annotations() {
    }

    @Field
    public static /* synthetic */ void getClassName$annotations() {
    }

    @Field
    public static /* synthetic */ void getData$annotations() {
    }

    @Field
    public static /* synthetic */ void getExtra$annotations() {
    }

    @Field
    public static /* synthetic */ void getFlags$annotations() {
    }

    @Field
    public static /* synthetic */ void getPackageName$annotations() {
    }

    @Field
    public static /* synthetic */ void getType$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    public final Map<String, Object> component3() {
        return this.extra;
    }

    /* renamed from: component4, reason: from getter */
    public final String getData() {
        return this.data;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getFlags() {
        return this.flags;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component7, reason: from getter */
    public final String getClassName() {
        return this.className;
    }

    public final IntentLauncherParams copy(String type, String category, Map<String, ? extends Object> extra, String data, Integer flags, String packageName, String className) {
        return new IntentLauncherParams(type, category, extra, data, flags, packageName, className);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntentLauncherParams)) {
            return false;
        }
        IntentLauncherParams intentLauncherParams = (IntentLauncherParams) other;
        return Intrinsics.areEqual(this.type, intentLauncherParams.type) && Intrinsics.areEqual(this.category, intentLauncherParams.category) && Intrinsics.areEqual(this.extra, intentLauncherParams.extra) && Intrinsics.areEqual(this.data, intentLauncherParams.data) && Intrinsics.areEqual(this.flags, intentLauncherParams.flags) && Intrinsics.areEqual(this.packageName, intentLauncherParams.packageName) && Intrinsics.areEqual(this.className, intentLauncherParams.className);
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.category;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map<String, Object> map = this.extra;
        int iHashCode3 = (iHashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        String str3 = this.data;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.flags;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.packageName;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.className;
        return iHashCode6 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "IntentLauncherParams(type=" + this.type + ", category=" + this.category + ", extra=" + this.extra + ", data=" + this.data + ", flags=" + this.flags + ", packageName=" + this.packageName + ", className=" + this.className + ")";
    }

    public IntentLauncherParams(String str, String str2, Map<String, ? extends Object> map, String str3, Integer num, String str4, String str5) {
        this.type = str;
        this.category = str2;
        this.extra = map;
        this.data = str3;
        this.flags = num;
        this.packageName = str4;
        this.className = str5;
    }

    public final String getType() {
        return this.type;
    }

    public final String getCategory() {
        return this.category;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final String getData() {
        return this.data;
    }

    public final Integer getFlags() {
        return this.flags;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getClassName() {
        return this.className;
    }
}
