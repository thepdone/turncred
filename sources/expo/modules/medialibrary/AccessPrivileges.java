package expo.modules.medialibrary;

import com.caverock.androidsvg.SVGParser;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.apache.commons.codec.language.bm.Rule;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: MediaLibraryEnums.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lexpo/modules/medialibrary/AccessPrivileges;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", Rule.ALL, "LIMITED", "NONE", "expo-media-library_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AccessPrivileges {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AccessPrivileges[] $VALUES;
    public static final AccessPrivileges ALL = new AccessPrivileges(Rule.ALL, 0, SVGParser.XML_STYLESHEET_ATTR_MEDIA_ALL);
    public static final AccessPrivileges LIMITED = new AccessPrivileges("LIMITED", 1, "limited");
    public static final AccessPrivileges NONE = new AccessPrivileges("NONE", 2, "none");
    private final String value;

    private static final /* synthetic */ AccessPrivileges[] $values() {
        return new AccessPrivileges[]{ALL, LIMITED, NONE};
    }

    public static EnumEntries<AccessPrivileges> getEntries() {
        return $ENTRIES;
    }

    public static AccessPrivileges valueOf(String str) {
        return (AccessPrivileges) Enum.valueOf(AccessPrivileges.class, str);
    }

    public static AccessPrivileges[] values() {
        return (AccessPrivileges[]) $VALUES.clone();
    }

    private AccessPrivileges(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        AccessPrivileges[] accessPrivilegesArr$values = $values();
        $VALUES = accessPrivilegesArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(accessPrivilegesArr$values);
    }
}
