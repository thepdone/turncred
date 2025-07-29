package expo.modules.contacts;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactsModule.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\tHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\tHÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lexpo/modules/contacts/ContactPage;", "", "data", "", "Lexpo/modules/contacts/Contact;", "hasPreviousPage", "", "hasNextPage", "total", "", "(Ljava/util/List;ZZI)V", "getData", "()Ljava/util/List;", "getHasNextPage", "()Z", "getHasPreviousPage", "getTotal", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "expo-contacts_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ContactPage {
    private final List<Contact> data;
    private final boolean hasNextPage;
    private final boolean hasPreviousPage;
    private final int total;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ContactPage copy$default(ContactPage contactPage, List list, boolean z, boolean z2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = contactPage.data;
        }
        if ((i2 & 2) != 0) {
            z = contactPage.hasPreviousPage;
        }
        if ((i2 & 4) != 0) {
            z2 = contactPage.hasNextPage;
        }
        if ((i2 & 8) != 0) {
            i = contactPage.total;
        }
        return contactPage.copy(list, z, z2, i);
    }

    public final List<Contact> component1() {
        return this.data;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getHasPreviousPage() {
        return this.hasPreviousPage;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getHasNextPage() {
        return this.hasNextPage;
    }

    /* renamed from: component4, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    public final ContactPage copy(List<Contact> data, boolean hasPreviousPage, boolean hasNextPage, int total) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new ContactPage(data, hasPreviousPage, hasNextPage, total);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContactPage)) {
            return false;
        }
        ContactPage contactPage = (ContactPage) other;
        return Intrinsics.areEqual(this.data, contactPage.data) && this.hasPreviousPage == contactPage.hasPreviousPage && this.hasNextPage == contactPage.hasNextPage && this.total == contactPage.total;
    }

    public int hashCode() {
        return (((((this.data.hashCode() * 31) + Boolean.hashCode(this.hasPreviousPage)) * 31) + Boolean.hashCode(this.hasNextPage)) * 31) + Integer.hashCode(this.total);
    }

    public String toString() {
        return "ContactPage(data=" + this.data + ", hasPreviousPage=" + this.hasPreviousPage + ", hasNextPage=" + this.hasNextPage + ", total=" + this.total + ")";
    }

    public ContactPage(List<Contact> data, boolean z, boolean z2, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.hasPreviousPage = z;
        this.hasNextPage = z2;
        this.total = i;
    }

    public final List<Contact> getData() {
        return this.data;
    }

    public final boolean getHasPreviousPage() {
        return this.hasPreviousPage;
    }

    public final boolean getHasNextPage() {
        return this.hasNextPage;
    }

    public /* synthetic */ ContactPage(List list, boolean z, boolean z2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? list.size() : i);
    }

    public final int getTotal() {
        return this.total;
    }
}
