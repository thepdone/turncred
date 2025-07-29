package expo.modules.contacts;

import com.facebook.GraphRequest;
import com.facebook.hermes.intl.Constants;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: ContactsModule.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\bR$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u00138\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u00020\u00138\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0002\u001a\u0004\b\u0019\u0010\u0016R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0002\u001a\u0004\b\u001c\u0010\u0011¨\u0006\u001d"}, d2 = {"Lexpo/modules/contacts/ContactQuery;", "Lexpo/modules/kotlin/records/Record;", "()V", GraphRequest.FIELDS_PARAM, "", "", "getFields$annotations", "getFields", "()Ljava/util/Set;", "id", "", "getId$annotations", "getId", "()Ljava/util/List;", "name", "getName$annotations", "getName", "()Ljava/lang/String;", "pageOffset", "", "getPageOffset$annotations", "getPageOffset", "()I", "pageSize", "getPageSize$annotations", "getPageSize", Constants.SORT, "getSort$annotations", "getSort", "expo-contacts_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContactQuery implements Record {
    private final Set<String> fields = ContactsModuleKt.defaultFields;
    private final List<String> id;
    private final String name;
    private final int pageOffset;
    private final int pageSize;
    private final String sort;

    @Field
    public static /* synthetic */ void getFields$annotations() {
    }

    @Field
    public static /* synthetic */ void getId$annotations() {
    }

    @Field
    public static /* synthetic */ void getName$annotations() {
    }

    @Field
    public static /* synthetic */ void getPageOffset$annotations() {
    }

    @Field
    public static /* synthetic */ void getPageSize$annotations() {
    }

    @Field
    public static /* synthetic */ void getSort$annotations() {
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final int getPageOffset() {
        return this.pageOffset;
    }

    public final Set<String> getFields() {
        return this.fields;
    }

    public final String getSort() {
        return this.sort;
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getId() {
        return this.id;
    }
}
