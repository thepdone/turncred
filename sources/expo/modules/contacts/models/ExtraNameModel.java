package expo.modules.contacts.models;

import android.database.Cursor;
import com.google.firebase.messaging.Constants;
import expo.modules.contacts.Columns;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExtraNameModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u000f"}, d2 = {"Lexpo/modules/contacts/models/ExtraNameModel;", "Lexpo/modules/contacts/models/BaseModel;", "()V", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_CONTENT_TYPE_KEY, "", "getContentType", "()Ljava/lang/String;", "dataAlias", "getDataAlias", "getLabelFromCursor", "cursor", "Landroid/database/Cursor;", "mapStringToType", "", Constants.ScionAnalytics.PARAM_LABEL, "expo-contacts_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExtraNameModel extends BaseModel {
    private final String contentType = "vnd.android.cursor.item/nickname";
    private final String dataAlias = "value";

    @Override // expo.modules.contacts.CommonProvider
    public String getContentType() {
        return this.contentType;
    }

    @Override // expo.modules.contacts.models.BaseModel, expo.modules.contacts.CommonProvider
    public String getDataAlias() {
        return this.dataAlias;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // expo.modules.contacts.models.BaseModel
    public int mapStringToType(String label) {
        if (label != null) {
            switch (label.hashCode()) {
                case -2028219097:
                    if (label.equals("shortName")) {
                        return 4;
                    }
                    break;
                case -1946065477:
                    if (label.equals("otherName")) {
                        return 2;
                    }
                    break;
                case 269062575:
                    if (label.equals("initials")) {
                        return 5;
                    }
                    break;
                case 688538947:
                    if (label.equals("maidenName")) {
                        return 3;
                    }
                    break;
                case 1544803905:
                    if (label.equals(com.facebook.hermes.intl.Constants.COLLATION_DEFAULT)) {
                        return 1;
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
        int i = cursor.getInt(cursor.getColumnIndexOrThrow(Columns.TYPE));
        if (i == 1) {
            return "nickname";
        }
        if (i == 2) {
            return "otherName";
        }
        if (i == 3) {
            return "maidenName";
        }
        if (i == 4) {
            return "shortName";
        }
        if (i == 5) {
            return "initials";
        }
        return "unknown";
    }
}
