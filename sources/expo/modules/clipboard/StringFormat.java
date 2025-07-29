package expo.modules.clipboard;

import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ClipboardOptions.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lexpo/modules/clipboard/StringFormat;", "", "Lexpo/modules/kotlin/types/Enumerable;", "jsValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJsValue", "()Ljava/lang/String;", "PLAIN", "HTML", "expo-clipboard_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StringFormat implements Enumerable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StringFormat[] $VALUES;
    private final String jsValue;
    public static final StringFormat PLAIN = new StringFormat("PLAIN", 0, "plainText");
    public static final StringFormat HTML = new StringFormat("HTML", 1, "html");

    private static final /* synthetic */ StringFormat[] $values() {
        return new StringFormat[]{PLAIN, HTML};
    }

    public static EnumEntries<StringFormat> getEntries() {
        return $ENTRIES;
    }

    public static StringFormat valueOf(String str) {
        return (StringFormat) Enum.valueOf(StringFormat.class, str);
    }

    public static StringFormat[] values() {
        return (StringFormat[]) $VALUES.clone();
    }

    private StringFormat(String str, int i, String str2) {
        this.jsValue = str2;
    }

    public final String getJsValue() {
        return this.jsValue;
    }

    static {
        StringFormat[] stringFormatArr$values = $values();
        $VALUES = stringFormatArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(stringFormatArr$values);
    }
}
