package expo.modules.contacts;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import expo.modules.contacts.models.DateModelKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactsModule.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0002\u0010\u000e\u001a\u001a\u0010\u000f\u001a\u00020\u0010*\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u001a\u001a\u0010\u000f\u001a\u00020\u0010*\u0004\u0018\u00010\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\b\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"DEFAULT_PROJECTION", "", "", "RC_ADD_CONTACT", "", "RC_EDIT_CONTACT", "RC_PICK_CONTACT", "defaultFields", "", "safeGet", ExifInterface.GPS_DIRECTION_TRUE, "", "", SDKConstants.PARAM_KEY, "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Object;", "toBundle", "Landroid/os/Bundle;", "Lexpo/modules/contacts/Contact;", "keys", "Lexpo/modules/contacts/ContactPage;", "expo-contacts_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContactsModuleKt {
    public static final int RC_ADD_CONTACT = 2139;
    public static final int RC_EDIT_CONTACT = 2137;
    public static final int RC_PICK_CONTACT = 2138;
    private static final Set<String> defaultFields = SetsKt.setOf((Object[]) new String[]{"phoneNumbers", "emails", "addresses", "note", DateModelKt.BIRTHDAY, "dates", "instantMessageAddresses", "urlAddresses", "extraNames", "relationships", "phoneticFirstName", "phoneticLastName", "phoneticMiddleName", "namePrefix", "nameSuffix", "name", "firstName", "middleName", "lastName", "nickname", "id", "jobTitle", "company", "department", "image", "imageAvailable", "note", "isFavorite"});
    private static final List<String> DEFAULT_PROJECTION = CollectionsKt.listOf((Object[]) new String[]{"raw_contact_id", Columns.CONTACT_ID, "lookup", Columns.MIMETYPE, Columns.DISPLAY_NAME, Columns.PHOTO_URI, Columns.PHOTO_THUMBNAIL_URI, Columns.DATA, Columns.TYPE, Columns.DATA_5, Columns.LABEL, Columns.DATA_4, Columns.DATA_6, Columns.DATA_7, Columns.DATA_8, Columns.DATA_9, Columns.DATA, Columns.DATA_4, Columns.DATA_5, Columns.STARRED});

    public static final Bundle toBundle(ContactPage contactPage, Set<String> keys) {
        ArrayList arrayListEmptyList;
        List<Contact> data;
        Intrinsics.checkNotNullParameter(keys, "keys");
        if (contactPage == null || (data = contactPage.getData()) == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else {
            List<Contact> list = data;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((Contact) it.next()).toMap(keys));
            }
            arrayListEmptyList = arrayList;
        }
        boolean hasNextPage = contactPage != null ? contactPage.getHasNextPage() : false;
        boolean hasPreviousPage = contactPage != null ? contactPage.getHasPreviousPage() : false;
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("data", new ArrayList<>(arrayListEmptyList));
        bundle.putBoolean("hasNextPage", hasNextPage);
        bundle.putBoolean("hasPreviousPage", hasPreviousPage);
        return bundle;
    }

    public static final Bundle toBundle(Contact contact, Set<String> keys) {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(keys, "keys");
        Bundle map = contact != null ? contact.toMap(keys) : null;
        if (map == null || (listEmptyList = CollectionsKt.listOf(map)) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("data", new ArrayList<>(listEmptyList));
        bundle.putBoolean("hasNextPage", false);
        bundle.putBoolean("hasPreviousPage", false);
        return bundle;
    }

    public static final <T> T safeGet(Map<String, ? extends Object> map, String key) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        T t = (T) map.get(key);
        if (t == null) {
            return null;
        }
        return t;
    }
}
