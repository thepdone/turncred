package expo.modules.crypto;

import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DigestAlgorithm.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lexpo/modules/crypto/DigestAlgorithm;", "", "Lexpo/modules/kotlin/types/Enumerable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", MessageDigestAlgorithms.MD5, "SHA1", "SHA256", "SHA384", "SHA512", "expo-crypto_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DigestAlgorithm implements Enumerable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DigestAlgorithm[] $VALUES;
    public static final DigestAlgorithm MD5 = new DigestAlgorithm(MessageDigestAlgorithms.MD5, 0, MessageDigestAlgorithms.MD5);
    public static final DigestAlgorithm SHA1 = new DigestAlgorithm("SHA1", 1, MessageDigestAlgorithms.SHA_1);
    public static final DigestAlgorithm SHA256 = new DigestAlgorithm("SHA256", 2, MessageDigestAlgorithms.SHA_256);
    public static final DigestAlgorithm SHA384 = new DigestAlgorithm("SHA384", 3, MessageDigestAlgorithms.SHA_384);
    public static final DigestAlgorithm SHA512 = new DigestAlgorithm("SHA512", 4, MessageDigestAlgorithms.SHA_512);
    private final String value;

    private static final /* synthetic */ DigestAlgorithm[] $values() {
        return new DigestAlgorithm[]{MD5, SHA1, SHA256, SHA384, SHA512};
    }

    public static EnumEntries<DigestAlgorithm> getEntries() {
        return $ENTRIES;
    }

    public static DigestAlgorithm valueOf(String str) {
        return (DigestAlgorithm) Enum.valueOf(DigestAlgorithm.class, str);
    }

    public static DigestAlgorithm[] values() {
        return (DigestAlgorithm[]) $VALUES.clone();
    }

    private DigestAlgorithm(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        DigestAlgorithm[] digestAlgorithmArr$values = $values();
        $VALUES = digestAlgorithmArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(digestAlgorithmArr$values);
    }
}
