package expo.modules.clipboard;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ClipboardModule.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lexpo/modules/clipboard/ContentType;", "", "jsName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJsName", "()Ljava/lang/String;", "PLAIN_TEXT", "HTML", ShareConstants.IMAGE_URL, "expo-clipboard_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
final class ContentType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ContentType[] $VALUES;
    private final String jsName;
    public static final ContentType PLAIN_TEXT = new ContentType("PLAIN_TEXT", 0, "plain-text");
    public static final ContentType HTML = new ContentType("HTML", 1, "html");
    public static final ContentType IMAGE = new ContentType(ShareConstants.IMAGE_URL, 2, "image");

    private static final /* synthetic */ ContentType[] $values() {
        return new ContentType[]{PLAIN_TEXT, HTML, IMAGE};
    }

    public static EnumEntries<ContentType> getEntries() {
        return $ENTRIES;
    }

    public static ContentType valueOf(String str) {
        return (ContentType) Enum.valueOf(ContentType.class, str);
    }

    public static ContentType[] values() {
        return (ContentType[]) $VALUES.clone();
    }

    private ContentType(String str, int i, String str2) {
        this.jsName = str2;
    }

    public final String getJsName() {
        return this.jsName;
    }

    static {
        ContentType[] contentTypeArr$values = $values();
        $VALUES = contentTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(contentTypeArr$values);
    }
}
