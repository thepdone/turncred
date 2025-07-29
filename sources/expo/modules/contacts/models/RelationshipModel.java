package expo.modules.contacts.models;

import android.database.Cursor;
import com.facebook.appevents.codeless.internal.Constants;
import expo.modules.contacts.Columns;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RelationshipModel.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0014R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\f"}, d2 = {"Lexpo/modules/contacts/models/RelationshipModel;", "Lexpo/modules/contacts/models/BaseModel;", "()V", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_CONTENT_TYPE_KEY, "", "getContentType", "()Ljava/lang/String;", "dataAlias", "getDataAlias", "getLabelFromCursor", "cursor", "Landroid/database/Cursor;", "expo-contacts_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RelationshipModel extends BaseModel {
    private final String contentType = "vnd.android.cursor.item/relation";
    private final String dataAlias = "name";

    @Override // expo.modules.contacts.CommonProvider
    public String getContentType() {
        return this.contentType;
    }

    @Override // expo.modules.contacts.models.BaseModel, expo.modules.contacts.CommonProvider
    public String getDataAlias() {
        return this.dataAlias;
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
                return "assistant";
            case 2:
                return "bother";
            case 3:
                return "child";
            case 4:
                return "domesticPartner";
            case 5:
                return "father";
            case 6:
                return "friend";
            case 7:
                return "manager";
            case 8:
                return "mother";
            case 9:
                return "parent";
            case 10:
                return "partner";
            case 11:
                return "referredBy";
            case 12:
                return Constants.PATH_TYPE_RELATIVE;
            case 13:
                return "sister";
            case 14:
                return "spouse";
            default:
                return "unknown";
        }
    }
}
