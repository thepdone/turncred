package expo.modules.contacts.models;

import android.database.Cursor;
import com.google.firebase.messaging.Constants;
import expo.modules.contacts.Columns;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import io.sentry.protocol.SentryThread;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: PhoneNumberModel.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0014"}, d2 = {"Lexpo/modules/contacts/models/PhoneNumberModel;", "Lexpo/modules/contacts/models/BaseModel;", "()V", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_CONTENT_TYPE_KEY, "", "getContentType", "()Ljava/lang/String;", "dataAlias", "getDataAlias", "fromMap", "", "readableMap", "", "", "getLabelFromCursor", "cursor", "Landroid/database/Cursor;", "mapStringToType", "", Constants.ScionAnalytics.PARAM_LABEL, "expo-contacts_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PhoneNumberModel extends BaseModel {
    private final String contentType = "vnd.android.cursor.item/phone_v2";
    private final String dataAlias = "number";

    @Override // expo.modules.contacts.CommonProvider
    public String getContentType() {
        return this.contentType;
    }

    @Override // expo.modules.contacts.models.BaseModel, expo.modules.contacts.CommonProvider
    public String getDataAlias() {
        return this.dataAlias;
    }

    @Override // expo.modules.contacts.models.BaseModel
    public void fromMap(Map<String, ? extends Object> readableMap) {
        Intrinsics.checkNotNullParameter(readableMap, "readableMap");
        super.fromMap(readableMap);
        String data = getData();
        Intrinsics.checkNotNull(data);
        getMap().putString("digits", new Regex("[^\\d.]").replace(data, ""));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // expo.modules.contacts.models.BaseModel
    public int mapStringToType(String label) {
        if (label != null) {
            switch (label.hashCode()) {
                case -1171162643:
                    if (label.equals("otherFax")) {
                        return 13;
                    }
                    break;
                case -1073799780:
                    if (label.equals("faxHome")) {
                        return 5;
                    }
                    break;
                case -1073745133:
                    if (label.equals("workMobile")) {
                        return 17;
                    }
                    break;
                case -1073352754:
                    if (label.equals("faxWork")) {
                        return 4;
                    }
                    break;
                case -1068855134:
                    if (label.equals("mobile")) {
                        return 2;
                    }
                    break;
                case -863168709:
                    if (label.equals("ttyTdd")) {
                        return 16;
                    }
                    break;
                case -508612650:
                    if (label.equals("companyMain")) {
                        return 10;
                    }
                    break;
                case -172220347:
                    if (label.equals("callback")) {
                        return 8;
                    }
                    break;
                case 98260:
                    if (label.equals("car")) {
                        return 9;
                    }
                    break;
                case 108243:
                    if (label.equals("mms")) {
                        return 20;
                    }
                    break;
                case 3208415:
                    if (label.equals("home")) {
                        return 1;
                    }
                    break;
                case 3241780:
                    if (label.equals("isdn")) {
                        return 11;
                    }
                    break;
                case 3343801:
                    if (label.equals(SentryThread.JsonKeys.MAIN)) {
                        return 12;
                    }
                    break;
                case 3655441:
                    if (label.equals("work")) {
                        return 3;
                    }
                    break;
                case 106069776:
                    if (label.equals("other")) {
                        return 7;
                    }
                    break;
                case 106426307:
                    if (label.equals("pager")) {
                        return 6;
                    }
                    break;
                case 108270587:
                    if (label.equals("radio")) {
                        return 14;
                    }
                    break;
                case 110244366:
                    if (label.equals("telex")) {
                        return 15;
                    }
                    break;
                case 1076099890:
                    if (label.equals("workPager")) {
                        return 18;
                    }
                    break;
                case 1429828318:
                    if (label.equals("assistant")) {
                        return 19;
                    }
                    break;
            }
        }
        return 0;
    }

    @Override // expo.modules.contacts.models.BaseModel
    protected String getLabelFromCursor(Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        String labelFromCursor = super.getLabelFromCursor(cursor);
        if (labelFromCursor != null) {
            return labelFromCursor;
        }
        switch (cursor.getInt(cursor.getColumnIndexOrThrow(Columns.TYPE))) {
            case 1:
                return "home";
            case 2:
                return "mobile";
            case 3:
                return "work";
            case 4:
                return "faxWork";
            case 5:
                return "faxHome";
            case 6:
                return "pager";
            case 7:
                return "other";
            case 8:
                return "callback";
            case 9:
                return "car";
            case 10:
                return "companyMain";
            case 11:
                return "isdn";
            case 12:
                return SentryThread.JsonKeys.MAIN;
            case 13:
                return "otherFax";
            case 14:
                return "radio";
            case 15:
                return "telex";
            case 16:
                return "ttyTdd";
            case 17:
                return "workMobile";
            case 18:
                return "workPager";
            case 19:
                return "assistant";
            case 20:
                return "mms";
            default:
                return "unknown";
        }
    }
}
