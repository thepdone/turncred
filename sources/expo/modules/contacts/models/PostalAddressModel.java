package expo.modules.contacts.models;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.database.Cursor;
import android.provider.ContactsContract;
import androidx.autofill.HintConstants;
import com.facebook.appevents.UserDataStore;
import com.google.firebase.messaging.Constants;
import expo.modules.contacts.Columns;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import io.sentry.protocol.Geo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PostalAddressModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001e\u0010\u0011\u001a\u00020\u000e2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\u001c"}, d2 = {"Lexpo/modules/contacts/models/PostalAddressModel;", "Lexpo/modules/contacts/models/BaseModel;", "()V", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_CONTENT_TYPE_KEY, "", "getContentType", "()Ljava/lang/String;", "contentValues", "Landroid/content/ContentValues;", "getContentValues", "()Landroid/content/ContentValues;", "dataAlias", "getDataAlias", "fromCursor", "", "cursor", "Landroid/database/Cursor;", "fromMap", "readableMap", "", "", "getInsertOperation", "Landroid/content/ContentProviderOperation;", "rawId", "getLabelFromCursor", "mapStringToType", "", Constants.ScionAnalytics.PARAM_LABEL, "expo-contacts_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PostalAddressModel extends BaseModel {
    private final String contentType = "vnd.android.cursor.item/postal-address_v2";
    private final String dataAlias = "formattedAddress";

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
        if (label == null) {
            return 3;
        }
        int iHashCode = label.hashCode();
        if (iHashCode == 3208415) {
            return label.equals("home") ? 1 : 3;
        }
        if (iHashCode == 3655441) {
            return !label.equals("work") ? 3 : 2;
        }
        if (iHashCode != 106069776) {
            return 3;
        }
        label.equals("other");
        return 3;
    }

    @Override // expo.modules.contacts.models.BaseModel
    public void fromCursor(Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        super.fromCursor(cursor);
        putString(cursor, "formattedAddress", Columns.DATA);
        putString(cursor, "street", Columns.DATA_4);
        putString(cursor, "poBox", Columns.DATA_5);
        putString(cursor, "neighborhood", Columns.DATA_6);
        putString(cursor, Geo.JsonKeys.CITY, Columns.DATA_7);
        putString(cursor, Geo.JsonKeys.REGION, Columns.DATA_8);
        putString(cursor, "state", Columns.DATA_8);
        putString(cursor, HintConstants.AUTOFILL_HINT_POSTAL_CODE, Columns.DATA_9);
        putString(cursor, UserDataStore.COUNTRY, Columns.DATA_10);
    }

    @Override // expo.modules.contacts.models.BaseModel
    public void fromMap(Map<String, ? extends Object> readableMap) {
        Intrinsics.checkNotNullParameter(readableMap, "readableMap");
        super.fromMap(readableMap);
        mapValue(readableMap, Geo.JsonKeys.REGION, "state");
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
        ContentProviderOperation contentProviderOperationBuild = builderNewInsert.withValue(Columns.MIMETYPE, getContentType()).withValue(Columns.TYPE, getType()).withValue(Columns.DATA_4, getString("street")).withValue(Columns.DATA_7, getString(Geo.JsonKeys.CITY)).withValue(Columns.DATA_8, getString(Geo.JsonKeys.REGION)).withValue(Columns.DATA_9, getString(HintConstants.AUTOFILL_HINT_POSTAL_CODE)).withValue(Columns.DATA_10, getString(UserDataStore.COUNTRY)).build();
        Intrinsics.checkNotNullExpressionValue(contentProviderOperationBuild, "build(...)");
        return contentProviderOperationBuild;
    }

    @Override // expo.modules.contacts.models.BaseModel
    public ContentValues getContentValues() {
        ContentValues contentValues = super.getContentValues();
        contentValues.put(Columns.DATA_4, getString("street"));
        contentValues.put(Columns.DATA_7, getString(Geo.JsonKeys.CITY));
        contentValues.put(Columns.DATA_8, getString(Geo.JsonKeys.REGION));
        contentValues.put(Columns.DATA_10, getString(UserDataStore.COUNTRY));
        contentValues.put(Columns.DATA_9, getString(HintConstants.AUTOFILL_HINT_POSTAL_CODE));
        return contentValues;
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
            return "home";
        }
        if (i == 2) {
            return "work";
        }
        if (i == 3) {
            return "other";
        }
        return "unknown";
    }
}
