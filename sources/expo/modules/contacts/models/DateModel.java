package expo.modules.contacts.models;

import android.content.ContentProviderOperation;
import android.database.Cursor;
import android.provider.ContactsContract;
import com.google.firebase.messaging.Constants;
import expo.modules.contacts.Columns;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: DateModel.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0013"}, d2 = {"Lexpo/modules/contacts/models/DateModel;", "Lexpo/modules/contacts/models/BaseModel;", "()V", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_CONTENT_TYPE_KEY, "", "getContentType", "()Ljava/lang/String;", "dataAlias", "getDataAlias", "formatDateString", "getInsertOperation", "Landroid/content/ContentProviderOperation;", "rawId", "getLabelFromCursor", "cursor", "Landroid/database/Cursor;", "mapStringToType", "", Constants.ScionAnalytics.PARAM_LABEL, "expo-contacts_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class DateModel extends BaseModel {
    private final String contentType = "vnd.android.cursor.item/contact_event";
    private final String dataAlias = "date";

    @Override // expo.modules.contacts.CommonProvider
    public String getContentType() {
        return this.contentType;
    }

    @Override // expo.modules.contacts.models.BaseModel, expo.modules.contacts.CommonProvider
    public String getDataAlias() {
        return this.dataAlias;
    }

    @Override // expo.modules.contacts.models.BaseModel
    public int mapStringToType(String label) {
        if (label != null) {
            int iHashCode = label.hashCode();
            if (iHashCode != -940675184) {
                if (iHashCode != 106069776) {
                    if (iHashCode == 1069376125 && label.equals(DateModelKt.BIRTHDAY)) {
                        return 3;
                    }
                } else if (label.equals("other")) {
                    return 2;
                }
            } else if (label.equals("anniversary")) {
                return 1;
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
        int i = cursor.getInt(cursor.getColumnIndexOrThrow(Columns.TYPE));
        if (i == 1) {
            return "anniversary";
        }
        if (i == 2) {
            return "other";
        }
        if (i == 3) {
            return DateModelKt.BIRTHDAY;
        }
        return "unknown";
    }

    @Override // expo.modules.contacts.models.BaseModel
    public ContentProviderOperation getInsertOperation(String rawId) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
        Intrinsics.checkNotNullExpressionValue(builderNewInsert, "newInsert(...)");
        if (rawId == null) {
            builderNewInsert.withValueBackReference("raw_contact_id", 0);
        } else {
            builderNewInsert.withValue("raw_contact_id", rawId);
        }
        ContentProviderOperation contentProviderOperationBuild = builderNewInsert.withValue(Columns.MIMETYPE, getContentType()).withValue(Columns.TYPE, Integer.valueOf(mapStringToType(getLabel()))).withValue(Columns.DATA, formatDateString()).withValue(Columns.LABEL, getLabel()).build();
        Intrinsics.checkNotNullExpressionValue(contentProviderOperationBuild, "build(...)");
        return contentProviderOperationBuild;
    }

    private final String formatDateString() {
        Integer numValueOf = Integer.valueOf((int) getMap().getDouble("year", -1.0d));
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        Integer numValueOf2 = Integer.valueOf((int) getMap().getDouble("month", -1.0d));
        if (numValueOf2.intValue() < 0) {
            numValueOf2 = null;
        }
        Integer numValueOf3 = numValueOf2 != null ? Integer.valueOf(numValueOf2.intValue() + 1) : null;
        Integer numValueOf4 = Integer.valueOf((int) getMap().getDouble("day", -1.0d));
        if (numValueOf4.intValue() <= 0) {
            numValueOf4 = null;
        }
        if (numValueOf != null && numValueOf3 != null && numValueOf4 != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.US, "%04d-%02d-%02d", Arrays.copyOf(new Object[]{numValueOf, numValueOf3, numValueOf4}, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
        if (numValueOf3 == null || numValueOf4 == null) {
            return null;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String str2 = String.format(Locale.US, "--%02d-%02d", Arrays.copyOf(new Object[]{numValueOf3, numValueOf4}, 2));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }
}
