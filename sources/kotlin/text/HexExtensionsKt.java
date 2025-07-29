package kotlin.text;

import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.HexFormat;

/* compiled from: HexExtensions.kt */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002\u001a\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\nH\u0002\u001a(\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0002\u001a@\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0000\u001a@\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0000\u001a \u0010\u001b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002\u001a5\u0010\u001c\u001a\u00020\r*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0007H\u0082\b\u001a$\u0010#\u001a\u00020$*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010&\u001a\u00020\rH\u0002\u001a\u001c\u0010'\u001a\u00020\r*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rH\u0002\u001a<\u0010(\u001a\u00020$*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\u0006\u0010&\u001a\u00020\rH\u0002\u001a\u0015\u0010+\u001a\u00020\r*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\rH\u0082\b\u001a,\u0010,\u001a\u00020\r*\u00020-2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\rH\u0002\u001a<\u0010,\u001a\u00020\r*\u00020-2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\rH\u0002\u001a*\u00104\u001a\u000205*\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0003\u001a\u0016\u00104\u001a\u000205*\u00020\u00072\b\b\u0002\u00106\u001a\u000207H\u0007\u001a*\u00108\u001a\u00020-*\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0003\u001a\u0016\u00108\u001a\u00020-*\u00020\u00072\b\b\u0002\u00106\u001a\u000207H\u0007\u001a&\u00109\u001a\u0004\u0018\u00010-*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;H\u0003\u001a&\u0010<\u001a\u0004\u0018\u00010-*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;H\u0003\u001a&\u0010=\u001a\u0004\u0018\u00010-*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;H\u0003\u001a$\u0010>\u001a\u00020-*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;H\u0003\u001a*\u0010?\u001a\u00020\r*\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0003\u001a\u0016\u0010?\u001a\u00020\r*\u00020\u00072\b\b\u0002\u00106\u001a\u000207H\u0007\u001a,\u0010@\u001a\u00020\r*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u00106\u001a\u0002072\u0006\u0010&\u001a\u00020\rH\u0003\u001a*\u0010A\u001a\u00020\n*\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0003\u001a\u0016\u0010A\u001a\u00020\n*\u00020\u00072\b\b\u0002\u00106\u001a\u000207H\u0007\u001a,\u0010B\u001a\u00020\n*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u00106\u001a\u0002072\u0006\u0010&\u001a\u00020\rH\u0003\u001a*\u0010C\u001a\u00020D*\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0003\u001a\u0016\u0010C\u001a\u00020D*\u00020\u00072\b\b\u0002\u00106\u001a\u000207H\u0007\u001a\u0015\u0010E\u001a\u00020\n*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\rH\u0082\b\u001a\u0014\u0010F\u001a\u000205*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\rH\u0002\u001a\u001c\u0010G\u001a\u00020\r*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rH\u0002\u001a\u001c\u0010H\u001a\u00020\n*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rH\u0002\u001a\u0014\u0010I\u001a\u00020J*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\rH\u0002\u001a,\u0010K\u001a\u00020$*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010&\u001a\u00020\r2\u0006\u0010L\u001a\u00020!H\u0002\u001a,\u0010M\u001a\u00020$*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0002\u001a,\u0010N\u001a\u00020$*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0002\u001a\u001c\u0010O\u001a\u00020\r*\u00020\u00072\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\rH\u0002\u001a\u0016\u0010P\u001a\u00020\u0007*\u0002052\b\b\u0002\u00106\u001a\u000207H\u0007\u001a*\u0010P\u001a\u00020\u0007*\u00020-2\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0007\u001a\u0016\u0010P\u001a\u00020\u0007*\u00020-2\b\b\u0002\u00106\u001a\u000207H\u0007\u001a\u0016\u0010P\u001a\u00020\u0007*\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0007\u001a\u0016\u0010P\u001a\u00020\u0007*\u00020\n2\b\b\u0002\u00106\u001a\u000207H\u0007\u001a\u0016\u0010P\u001a\u00020\u0007*\u00020D2\b\b\u0002\u00106\u001a\u000207H\u0007\u001a$\u0010Q\u001a\u00020\u0007*\u00020\n2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\rH\u0003\u001a,\u0010V\u001a\u00020\u0007*\u00020-2\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;2\u0006\u0010.\u001a\u00020\u0001H\u0003\u001a,\u0010W\u001a\u00020\u0007*\u00020-2\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;2\u0006\u0010.\u001a\u00020\u0001H\u0003\u001a,\u0010X\u001a\u00020\u0007*\u00020-2\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;2\u0006\u0010.\u001a\u00020\u0001H\u0003\u001a,\u0010Y\u001a\u00020\u0007*\u00020-2\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;2\u0006\u0010.\u001a\u00020\u0001H\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"BYTE_TO_LOWER_CASE_HEX_DIGITS", "", "BYTE_TO_UPPER_CASE_HEX_DIGITS", "HEX_DIGITS_TO_DECIMAL", "HEX_DIGITS_TO_LONG_DECIMAL", "", "LOWER_CASE_HEX_DIGITS", "", "UPPER_CASE_HEX_DIGITS", "charsPerSet", "", "charsPerElement", "elementsPerSet", "", "elementSeparatorLength", "checkFormatLength", "formatLength", "formattedStringLength", "numberOfBytes", "byteSeparatorLength", "bytePrefixLength", "byteSuffixLength", "bytesPerLine", "bytesPerGroup", "groupSeparatorLength", "parsedByteArrayMaxSize", "stringLength", "wholeElementsPerSet", "checkContainsAt", FirebaseAnalytics.Param.INDEX, "endIndex", "part", "ignoreCase", "", "partName", "checkMaxDigits", "", "startIndex", "maxDigits", "checkNewLineAt", "checkPrefixSuffixMaxDigits", "prefix", "suffix", "decimalFromHexDigitAt", "formatByteAt", "", "byteToDigits", "destination", "", "destinationOffset", "bytePrefix", "byteSuffix", "hexToByte", "", "format", "Lkotlin/text/HexFormat;", "hexToByteArray", "hexToByteArrayNoLineAndGroupSeparator", "bytesFormat", "Lkotlin/text/HexFormat$BytesHexFormat;", "hexToByteArrayNoLineAndGroupSeparatorSlowPath", "hexToByteArrayShortByteSeparatorNoPrefixAndSuffix", "hexToByteArraySlowPath", "hexToInt", "hexToIntImpl", "hexToLong", "hexToLongImpl", "hexToShort", "", "longDecimalFromHexDigitAt", "parseByteAt", "parseInt", "parseLong", "throwInvalidDigitAt", "", "throwInvalidNumberOfDigits", "requireMaxLength", "throwInvalidPrefixSuffix", "throwNotContainedAt", "toCharArrayIfNotEmpty", "toHexString", "toHexStringImpl", "numberFormat", "Lkotlin/text/HexFormat$NumberHexFormat;", "digits", "bits", "toHexStringNoLineAndGroupSeparator", "toHexStringNoLineAndGroupSeparatorSlowPath", "toHexStringShortByteSeparatorNoPrefixAndSuffix", "toHexStringSlowPath", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HexExtensionsKt {
    private static final int[] BYTE_TO_LOWER_CASE_HEX_DIGITS;
    private static final int[] BYTE_TO_UPPER_CASE_HEX_DIGITS;
    private static final int[] HEX_DIGITS_TO_DECIMAL;
    private static final long[] HEX_DIGITS_TO_LONG_DECIMAL;
    private static final String LOWER_CASE_HEX_DIGITS = "0123456789abcdef";
    private static final String UPPER_CASE_HEX_DIGITS = "0123456789ABCDEF";

    static {
        int[] iArr = new int[256];
        int i = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            iArr[i2] = LOWER_CASE_HEX_DIGITS.charAt(i2 & 15) | (LOWER_CASE_HEX_DIGITS.charAt(i2 >> 4) << '\b');
        }
        BYTE_TO_LOWER_CASE_HEX_DIGITS = iArr;
        int[] iArr2 = new int[256];
        for (int i3 = 0; i3 < 256; i3++) {
            iArr2[i3] = UPPER_CASE_HEX_DIGITS.charAt(i3 & 15) | (UPPER_CASE_HEX_DIGITS.charAt(i3 >> 4) << '\b');
        }
        BYTE_TO_UPPER_CASE_HEX_DIGITS = iArr2;
        int[] iArr3 = new int[256];
        for (int i4 = 0; i4 < 256; i4++) {
            iArr3[i4] = -1;
        }
        int i5 = 0;
        int i6 = 0;
        while (i5 < str.length()) {
            iArr3[str.charAt(i5)] = i6;
            i5++;
            i6++;
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < str.length()) {
            iArr3[str.charAt(i7)] = i8;
            i7++;
            i8++;
        }
        HEX_DIGITS_TO_DECIMAL = iArr3;
        long[] jArr = new long[256];
        for (int i9 = 0; i9 < 256; i9++) {
            jArr[i9] = -1;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < str.length()) {
            jArr[str.charAt(i10)] = i11;
            i10++;
            i11++;
        }
        int i12 = 0;
        while (i < str.length()) {
            jArr[str.charAt(i)] = i12;
            i++;
            i12++;
        }
        HEX_DIGITS_TO_LONG_DECIMAL = jArr;
    }

    public static final String toHexString(byte[] bArr, HexFormat format) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return toHexString(bArr, 0, bArr.length, format);
    }

    public static /* synthetic */ String toHexString$default(byte[] bArr, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(bArr, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(byte[] bArr, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(bArr, i, i2, hexFormat);
    }

    public static final String toHexString(byte[] bArr, int i, int i2, HexFormat format) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, bArr.length);
        if (i == i2) {
            return "";
        }
        int[] iArr = format.getUpperCase() ? BYTE_TO_UPPER_CASE_HEX_DIGITS : BYTE_TO_LOWER_CASE_HEX_DIGITS;
        HexFormat.BytesHexFormat bytes = format.getBytes();
        if (bytes.getNoLineAndGroupSeparator()) {
            return toHexStringNoLineAndGroupSeparator(bArr, i, i2, bytes, iArr);
        }
        return toHexStringSlowPath(bArr, i, i2, bytes, iArr);
    }

    private static final String toHexStringNoLineAndGroupSeparator(byte[] bArr, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        if (bytesHexFormat.getShortByteSeparatorNoPrefixAndSuffix()) {
            return toHexStringShortByteSeparatorNoPrefixAndSuffix(bArr, i, i2, bytesHexFormat, iArr);
        }
        return toHexStringNoLineAndGroupSeparatorSlowPath(bArr, i, i2, bytesHexFormat, iArr);
    }

    private static final String toHexStringShortByteSeparatorNoPrefixAndSuffix(byte[] bArr, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        int length = bytesHexFormat.getByteSeparator().length();
        if (length > 1) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i3 = i2 - i;
        int byteAt = 0;
        if (length == 0) {
            char[] cArr = new char[checkFormatLength(i3 * 2)];
            while (i < i2) {
                byteAt = formatByteAt(bArr, i, iArr, cArr, byteAt);
                i++;
            }
            return StringsKt.concatToString(cArr);
        }
        char[] cArr2 = new char[checkFormatLength((i3 * 3) - 1)];
        char cCharAt = bytesHexFormat.getByteSeparator().charAt(0);
        int byteAt2 = formatByteAt(bArr, i, iArr, cArr2, 0);
        for (int i4 = i + 1; i4 < i2; i4++) {
            cArr2[byteAt2] = cCharAt;
            byteAt2 = formatByteAt(bArr, i4, iArr, cArr2, byteAt2 + 1);
        }
        return StringsKt.concatToString(cArr2);
    }

    private static final String toHexStringNoLineAndGroupSeparatorSlowPath(byte[] bArr, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        char[] cArr = new char[formattedStringLength(i2 - i, byteSeparator.length(), bytePrefix.length(), byteSuffix.length())];
        int byteAt = formatByteAt(bArr, i, bytePrefix, byteSuffix, iArr, cArr, 0);
        while (true) {
            i++;
            if (i < i2) {
                byteAt = formatByteAt(bArr, i, bytePrefix, byteSuffix, iArr, cArr, toCharArrayIfNotEmpty(byteSeparator, cArr, byteAt));
            } else {
                return StringsKt.concatToString(cArr);
            }
        }
    }

    private static final String toHexStringSlowPath(byte[] bArr, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        int i3;
        int i4;
        int bytesPerLine = bytesHexFormat.getBytesPerLine();
        int bytesPerGroup = bytesHexFormat.getBytesPerGroup();
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        String groupSeparator = bytesHexFormat.getGroupSeparator();
        int i5 = formattedStringLength(i2 - i, bytesPerLine, bytesPerGroup, groupSeparator.length(), byteSeparator.length(), bytePrefix.length(), byteSuffix.length());
        char[] cArr = new char[i5];
        int charArrayIfNotEmpty = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = i; i8 < i2; i8++) {
            if (i6 == bytesPerLine) {
                cArr[charArrayIfNotEmpty] = '\n';
                charArrayIfNotEmpty++;
                i3 = 0;
                i4 = 0;
            } else if (i7 == bytesPerGroup) {
                charArrayIfNotEmpty = toCharArrayIfNotEmpty(groupSeparator, cArr, charArrayIfNotEmpty);
                i3 = i6;
                i4 = 0;
            } else {
                i3 = i6;
                i4 = i7;
            }
            if (i4 != 0) {
                charArrayIfNotEmpty = toCharArrayIfNotEmpty(byteSeparator, cArr, charArrayIfNotEmpty);
            }
            charArrayIfNotEmpty = formatByteAt(bArr, i8, bytePrefix, byteSuffix, iArr, cArr, charArrayIfNotEmpty);
            i7 = i4 + 1;
            i6 = i3 + 1;
        }
        if (charArrayIfNotEmpty != i5) {
            throw new IllegalStateException("Check failed.".toString());
        }
        return StringsKt.concatToString(cArr);
    }

    private static final int formatByteAt(byte[] bArr, int i, String str, String str2, int[] iArr, char[] cArr, int i2) {
        return toCharArrayIfNotEmpty(str2, cArr, formatByteAt(bArr, i, iArr, cArr, toCharArrayIfNotEmpty(str, cArr, i2)));
    }

    private static final int formatByteAt(byte[] bArr, int i, int[] iArr, char[] cArr, int i2) {
        int i3 = iArr[bArr[i] & 255];
        cArr[i2] = (char) (i3 >> 8);
        cArr[i2 + 1] = (char) (i3 & 255);
        return i2 + 2;
    }

    private static final int formattedStringLength(int i, int i2, int i3, int i4) {
        if (i <= 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        long j = i2;
        return checkFormatLength((i * (((i3 + 2) + i4) + j)) - j);
    }

    public static final int formattedStringLength(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i <= 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i8 = (i - 1) / i2;
        int i9 = (i2 - 1) / i3;
        int i10 = i % i2;
        if (i10 != 0) {
            i2 = i10;
        }
        return checkFormatLength(i8 + (((i9 * i8) + ((i2 - 1) / i3)) * i4) + (((r0 - i8) - r2) * i5) + (i * (i6 + 2 + i7)));
    }

    private static final int checkFormatLength(long j) {
        if (0 > j || j > 2147483647L) {
            throw new IllegalArgumentException("The resulting string length is too big: " + ((Object) ULong.m6157toStringimpl(ULong.m6111constructorimpl(j))));
        }
        return (int) j;
    }

    public static final byte[] hexToByteArray(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToByteArray(str, 0, str.length(), format);
    }

    public static /* synthetic */ byte[] hexToByteArray$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByteArray(str, hexFormat);
    }

    static /* synthetic */ byte[] hexToByteArray$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByteArray(str, i, i2, hexFormat);
    }

    private static final byte[] hexToByteArray(String str, int i, int i2, HexFormat hexFormat) {
        byte[] bArrHexToByteArrayNoLineAndGroupSeparator;
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, str.length());
        if (i == i2) {
            return new byte[0];
        }
        HexFormat.BytesHexFormat bytes = hexFormat.getBytes();
        return (!bytes.getNoLineAndGroupSeparator() || (bArrHexToByteArrayNoLineAndGroupSeparator = hexToByteArrayNoLineAndGroupSeparator(str, i, i2, bytes)) == null) ? hexToByteArraySlowPath(str, i, i2, bytes) : bArrHexToByteArrayNoLineAndGroupSeparator;
    }

    private static final byte[] hexToByteArrayNoLineAndGroupSeparator(String str, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat) {
        if (bytesHexFormat.getShortByteSeparatorNoPrefixAndSuffix()) {
            return hexToByteArrayShortByteSeparatorNoPrefixAndSuffix(str, i, i2, bytesHexFormat);
        }
        return hexToByteArrayNoLineAndGroupSeparatorSlowPath(str, i, i2, bytesHexFormat);
    }

    private static final byte[] hexToByteArrayShortByteSeparatorNoPrefixAndSuffix(String str, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat) {
        int length = bytesHexFormat.getByteSeparator().length();
        if (length > 1) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i3 = i2 - i;
        int i4 = 2;
        if (length == 0) {
            if ((i3 & 1) != 0) {
                return null;
            }
            int i5 = i3 >> 1;
            byte[] bArr = new byte[i5];
            int i6 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                bArr[i7] = parseByteAt(str, i6);
                i6 += 2;
            }
            return bArr;
        }
        if (i3 % 3 != 2) {
            return null;
        }
        int i8 = (i3 / 3) + 1;
        byte[] bArr2 = new byte[i8];
        char cCharAt = bytesHexFormat.getByteSeparator().charAt(0);
        bArr2[0] = parseByteAt(str, 0);
        for (int i9 = 1; i9 < i8; i9++) {
            if (str.charAt(i4) != cCharAt) {
                String byteSeparator = bytesHexFormat.getByteSeparator();
                boolean ignoreCase$kotlin_stdlib = bytesHexFormat.getIgnoreCase();
                String str2 = byteSeparator;
                if (str2.length() != 0) {
                    int length2 = str2.length();
                    for (int i10 = 0; i10 < length2; i10++) {
                        if (!CharsKt.equals(byteSeparator.charAt(i10), str.charAt(i4 + i10), ignoreCase$kotlin_stdlib)) {
                            throwNotContainedAt(str, i4, i2, byteSeparator, "byte separator");
                        }
                    }
                    byteSeparator.length();
                }
            }
            bArr2[i9] = parseByteAt(str, i4 + 1);
            i4 += 3;
        }
        return bArr2;
    }

    private static final byte[] hexToByteArrayNoLineAndGroupSeparatorSlowPath(String str, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat) {
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        long length = byteSeparator.length();
        long length2 = bytePrefix.length() + 2 + byteSuffix.length() + length;
        long j = i2 - i;
        int i3 = (int) ((j + length) / length2);
        if ((i3 * length2) - length != j) {
            return null;
        }
        boolean ignoreCase$kotlin_stdlib = bytesHexFormat.getIgnoreCase();
        byte[] bArr = new byte[i3];
        String str2 = bytePrefix;
        if (str2.length() != 0) {
            int length3 = str2.length();
            for (int i4 = 0; i4 < length3; i4++) {
                if (!CharsKt.equals(bytePrefix.charAt(i4), str.charAt(i + i4), ignoreCase$kotlin_stdlib)) {
                    throwNotContainedAt(str, i, i2, bytePrefix, "byte prefix");
                }
            }
            i += bytePrefix.length();
        }
        String str3 = byteSuffix + byteSeparator + bytePrefix;
        int i5 = i3 - 1;
        for (int i6 = 0; i6 < i5; i6++) {
            bArr[i6] = parseByteAt(str, i);
            i += 2;
            String str4 = str3;
            if (str4.length() != 0) {
                int length4 = str4.length();
                for (int i7 = 0; i7 < length4; i7++) {
                    if (!CharsKt.equals(str3.charAt(i7), str.charAt(i + i7), ignoreCase$kotlin_stdlib)) {
                        throwNotContainedAt(str, i, i2, str3, "byte suffix + byte separator + byte prefix");
                    }
                }
                i += str3.length();
            }
        }
        bArr[i5] = parseByteAt(str, i);
        int i8 = i + 2;
        String str5 = byteSuffix;
        if (str5.length() != 0) {
            int length5 = str5.length();
            for (int i9 = 0; i9 < length5; i9++) {
                if (!CharsKt.equals(byteSuffix.charAt(i9), str.charAt(i8 + i9), ignoreCase$kotlin_stdlib)) {
                    throwNotContainedAt(str, i8, i2, byteSuffix, "byte suffix");
                }
            }
            byteSuffix.length();
        }
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final byte[] hexToByteArraySlowPath(java.lang.String r19, int r20, int r21, kotlin.text.HexFormat.BytesHexFormat r22) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.HexExtensionsKt.hexToByteArraySlowPath(java.lang.String, int, int, kotlin.text.HexFormat$BytesHexFormat):byte[]");
    }

    public static final int parsedByteArrayMaxSize(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        long jCharsPerSet;
        int i8;
        int i9;
        if (i <= 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        long j = i6 + 2 + i7;
        long jCharsPerSet2 = charsPerSet(j, i3, i5);
        if (i2 <= i3) {
            jCharsPerSet = charsPerSet(j, i2, i5);
        } else {
            jCharsPerSet = charsPerSet(jCharsPerSet2, i2 / i3, i4);
            int i10 = i2 % i3;
            if (i10 != 0) {
                jCharsPerSet = jCharsPerSet + i4 + charsPerSet(j, i10, i5);
            }
        }
        long j2 = i;
        long jWholeElementsPerSet = wholeElementsPerSet(j2, jCharsPerSet, 1);
        long j3 = j2 - ((jCharsPerSet + 1) * jWholeElementsPerSet);
        long jWholeElementsPerSet2 = wholeElementsPerSet(j3, jCharsPerSet2, i4);
        long j4 = j3 - ((jCharsPerSet2 + i4) * jWholeElementsPerSet2);
        long jWholeElementsPerSet3 = wholeElementsPerSet(j4, j, i5);
        if (j4 - ((j + i5) * jWholeElementsPerSet3) > 0) {
            i9 = i2;
            i8 = 1;
        } else {
            i8 = 0;
            i9 = i2;
        }
        return (int) ((jWholeElementsPerSet * i9) + (jWholeElementsPerSet2 * i3) + jWholeElementsPerSet3 + i8);
    }

    private static final long charsPerSet(long j, int i, int i2) {
        if (i <= 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        long j2 = i;
        return (j * j2) + (i2 * (j2 - 1));
    }

    private static final long wholeElementsPerSet(long j, long j2, int i) {
        if (j <= 0 || j2 <= 0) {
            return 0L;
        }
        long j3 = i;
        return (j + j3) / (j2 + j3);
    }

    private static final int checkNewLineAt(String str, int i, int i2) {
        if (str.charAt(i) == '\r') {
            int i3 = i + 1;
            return (i3 >= i2 || str.charAt(i3) != '\n') ? i3 : i + 2;
        }
        if (str.charAt(i) == '\n') {
            return i + 1;
        }
        throw new NumberFormatException("Expected a new line at index " + i + ", but was " + str.charAt(i));
    }

    public static /* synthetic */ String toHexString$default(byte b, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(b, hexFormat);
    }

    public static final String toHexString(byte b, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String str = format.getUpperCase() ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        HexFormat.NumberHexFormat number = format.getNumber();
        if (number.getIsDigitsOnly()) {
            char[] cArr = {str.charAt((b >> 4) & 15), str.charAt(b & Ascii.SI)};
            if (number.getRemoveLeadingZeros()) {
                return StringsKt.concatToString$default(cArr, RangesKt.coerceAtMost((Integer.numberOfLeadingZeros(b & 255) - 24) >> 2, 1), 0, 2, null);
            }
            return StringsKt.concatToString(cArr);
        }
        return toHexStringImpl(b, number, str, 8);
    }

    public static final byte hexToByte(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToByte(str, 0, str.length(), format);
    }

    public static /* synthetic */ byte hexToByte$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByte(str, hexFormat);
    }

    static /* synthetic */ byte hexToByte$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByte(str, i, i2, hexFormat);
    }

    private static final byte hexToByte(String str, int i, int i2, HexFormat hexFormat) {
        return (byte) hexToIntImpl(str, i, i2, hexFormat, 2);
    }

    public static /* synthetic */ String toHexString$default(short s, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(s, hexFormat);
    }

    public static final String toHexString(short s, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String str = format.getUpperCase() ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        HexFormat.NumberHexFormat number = format.getNumber();
        if (number.getIsDigitsOnly()) {
            char[] cArr = {str.charAt((s >> 12) & 15), str.charAt((s >> 8) & 15), str.charAt((s >> 4) & 15), str.charAt(s & 15)};
            if (number.getRemoveLeadingZeros()) {
                return StringsKt.concatToString$default(cArr, RangesKt.coerceAtMost((Integer.numberOfLeadingZeros(s & UShort.MAX_VALUE) - 16) >> 2, 3), 0, 2, null);
            }
            return StringsKt.concatToString(cArr);
        }
        return toHexStringImpl(s, number, str, 16);
    }

    public static final short hexToShort(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToShort(str, 0, str.length(), format);
    }

    public static /* synthetic */ short hexToShort$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToShort(str, hexFormat);
    }

    static /* synthetic */ short hexToShort$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToShort(str, i, i2, hexFormat);
    }

    private static final short hexToShort(String str, int i, int i2, HexFormat hexFormat) {
        return (short) hexToIntImpl(str, i, i2, hexFormat, 4);
    }

    public static /* synthetic */ String toHexString$default(int i, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(i, hexFormat);
    }

    public static final String toHexString(int i, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String str = format.getUpperCase() ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        HexFormat.NumberHexFormat number = format.getNumber();
        if (number.getIsDigitsOnly()) {
            char[] cArr = {str.charAt((i >> 28) & 15), str.charAt((i >> 24) & 15), str.charAt((i >> 20) & 15), str.charAt((i >> 16) & 15), str.charAt((i >> 12) & 15), str.charAt((i >> 8) & 15), str.charAt((i >> 4) & 15), str.charAt(i & 15)};
            if (number.getRemoveLeadingZeros()) {
                return StringsKt.concatToString$default(cArr, RangesKt.coerceAtMost(Integer.numberOfLeadingZeros(i) >> 2, 7), 0, 2, null);
            }
            return StringsKt.concatToString(cArr);
        }
        return toHexStringImpl(i, number, str, 32);
    }

    public static final int hexToInt(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToInt(str, 0, str.length(), format);
    }

    public static /* synthetic */ int hexToInt$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToInt(str, hexFormat);
    }

    static /* synthetic */ int hexToInt$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToInt(str, i, i2, hexFormat);
    }

    private static final int hexToInt(String str, int i, int i2, HexFormat hexFormat) {
        return hexToIntImpl(str, i, i2, hexFormat, 8);
    }

    public static /* synthetic */ String toHexString$default(long j, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(j, hexFormat);
    }

    public static final String toHexString(long j, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String str = format.getUpperCase() ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        HexFormat.NumberHexFormat number = format.getNumber();
        if (number.getIsDigitsOnly()) {
            char[] cArr = {str.charAt((int) ((j >> 60) & 15)), str.charAt((int) ((j >> 56) & 15)), str.charAt((int) ((j >> 52) & 15)), str.charAt((int) ((j >> 48) & 15)), str.charAt((int) ((j >> 44) & 15)), str.charAt((int) ((j >> 40) & 15)), str.charAt((int) ((j >> 36) & 15)), str.charAt((int) ((j >> 32) & 15)), str.charAt((int) ((j >> 28) & 15)), str.charAt((int) ((j >> 24) & 15)), str.charAt((int) ((j >> 20) & 15)), str.charAt((int) ((j >> 16) & 15)), str.charAt((int) ((j >> 12) & 15)), str.charAt((int) ((j >> 8) & 15)), str.charAt((int) ((j >> 4) & 15)), str.charAt((int) (15 & j))};
            if (number.getRemoveLeadingZeros()) {
                return StringsKt.concatToString$default(cArr, RangesKt.coerceAtMost(Long.numberOfLeadingZeros(j) >> 2, 15), 0, 2, null);
            }
            return StringsKt.concatToString(cArr);
        }
        return toHexStringImpl(j, number, str, 64);
    }

    public static final long hexToLong(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToLong(str, 0, str.length(), format);
    }

    public static /* synthetic */ long hexToLong$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToLong(str, hexFormat);
    }

    static /* synthetic */ long hexToLong$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToLong(str, i, i2, hexFormat);
    }

    private static final long hexToLong(String str, int i, int i2, HexFormat hexFormat) {
        return hexToLongImpl(str, i, i2, hexFormat, 16);
    }

    private static final String toHexStringImpl(long j, HexFormat.NumberHexFormat numberHexFormat, String str, int i) {
        if ((i & 3) != 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i2 = i >> 2;
        String prefix = numberHexFormat.getPrefix();
        String suffix = numberHexFormat.getSuffix();
        boolean removeLeadingZeros = numberHexFormat.getRemoveLeadingZeros();
        int iCheckFormatLength = checkFormatLength(prefix.length() + i2 + suffix.length());
        char[] cArr = new char[iCheckFormatLength];
        boolean z = removeLeadingZeros;
        int charArrayIfNotEmpty = toCharArrayIfNotEmpty(prefix, cArr, 0);
        int i3 = i;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 -= 4;
            int i5 = (int) ((j >> i3) & 15);
            z = z && i5 == 0 && i3 > 0;
            if (!z) {
                cArr[charArrayIfNotEmpty] = str.charAt(i5);
                charArrayIfNotEmpty++;
            }
        }
        int charArrayIfNotEmpty2 = toCharArrayIfNotEmpty(suffix, cArr, charArrayIfNotEmpty);
        return charArrayIfNotEmpty2 == iCheckFormatLength ? StringsKt.concatToString(cArr) : StringsKt.concatToString$default(cArr, 0, charArrayIfNotEmpty2, 1, null);
    }

    private static final int toCharArrayIfNotEmpty(String str, char[] cArr, int i) {
        int length = str.length();
        if (length != 0) {
            if (length == 1) {
                cArr[i] = str.charAt(0);
            } else {
                int length2 = str.length();
                Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                str.getChars(0, length2, cArr, i);
            }
        }
        return i + str.length();
    }

    private static final int hexToIntImpl(String str, int i, int i2, HexFormat hexFormat, int i3) {
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, str.length());
        HexFormat.NumberHexFormat number = hexFormat.getNumber();
        if (number.getIsDigitsOnly()) {
            checkMaxDigits(str, i, i2, i3);
            return parseInt(str, i, i2);
        }
        String prefix = number.getPrefix();
        String suffix = number.getSuffix();
        checkPrefixSuffixMaxDigits(str, i, i2, prefix, suffix, number.getIgnoreCase(), i3);
        return parseInt(str, i + prefix.length(), i2 - suffix.length());
    }

    private static final long hexToLongImpl(String str, int i, int i2, HexFormat hexFormat, int i3) {
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, str.length());
        HexFormat.NumberHexFormat number = hexFormat.getNumber();
        if (number.getIsDigitsOnly()) {
            checkMaxDigits(str, i, i2, i3);
            return parseLong(str, i, i2);
        }
        String prefix = number.getPrefix();
        String suffix = number.getSuffix();
        checkPrefixSuffixMaxDigits(str, i, i2, prefix, suffix, number.getIgnoreCase(), i3);
        return parseLong(str, i + prefix.length(), i2 - suffix.length());
    }

    private static final void checkPrefixSuffixMaxDigits(String str, int i, int i2, String str2, String str3, boolean z, int i3) {
        if ((i2 - i) - str2.length() <= str3.length()) {
            throwInvalidPrefixSuffix(str, i, i2, str2, str3);
        }
        String str4 = str2;
        if (str4.length() != 0) {
            int length = str4.length();
            for (int i4 = 0; i4 < length; i4++) {
                if (!CharsKt.equals(str2.charAt(i4), str.charAt(i + i4), z)) {
                    throwNotContainedAt(str, i, i2, str2, "prefix");
                }
            }
            i += str2.length();
        }
        int length2 = i2 - str3.length();
        String str5 = str3;
        if (str5.length() != 0) {
            int length3 = str5.length();
            for (int i5 = 0; i5 < length3; i5++) {
                if (!CharsKt.equals(str3.charAt(i5), str.charAt(length2 + i5), z)) {
                    throwNotContainedAt(str, length2, i2, str3, "suffix");
                }
            }
            str3.length();
        }
        checkMaxDigits(str, i, length2, i3);
    }

    private static final void checkMaxDigits(String str, int i, int i2, int i3) {
        if (i >= i2 || i2 - i > i3) {
            throwInvalidNumberOfDigits(str, i, i2, i3, false);
        }
    }

    private static final int checkContainsAt(String str, int i, int i2, String str2, boolean z, String str3) {
        String str4 = str2;
        if (str4.length() == 0) {
            return i;
        }
        int length = str4.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (!CharsKt.equals(str2.charAt(i3), str.charAt(i + i3), z)) {
                throwNotContainedAt(str, i, i2, str2, str3);
            }
        }
        return i + str2.length();
    }

    private static final int decimalFromHexDigitAt(String str, int i) {
        int i2;
        char cCharAt = str.charAt(i);
        if ((cCharAt >>> '\b') == 0 && (i2 = HEX_DIGITS_TO_DECIMAL[cCharAt]) >= 0) {
            return i2;
        }
        throwInvalidDigitAt(str, i);
        throw new KotlinNothingValueException();
    }

    private static final long longDecimalFromHexDigitAt(String str, int i) {
        char cCharAt = str.charAt(i);
        if ((cCharAt >>> '\b') == 0) {
            long j = HEX_DIGITS_TO_LONG_DECIMAL[cCharAt];
            if (j >= 0) {
                return j;
            }
        }
        throwInvalidDigitAt(str, i);
        throw new KotlinNothingValueException();
    }

    private static final void throwInvalidNumberOfDigits(String str, int i, int i2, int i3, boolean z) {
        String str2 = z ? "exactly" : "at most";
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        throw new NumberFormatException("Expected " + str2 + ' ' + i3 + " hexadecimal digits at index " + i + ", but was " + strSubstring + " of length " + (i2 - i));
    }

    private static final void throwNotContainedAt(String str, int i, int i2, String str2, String str3) {
        int iCoerceAtMost = RangesKt.coerceAtMost(str2.length() + i, i2);
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i, iCoerceAtMost);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        throw new NumberFormatException("Expected " + str3 + " \"" + str2 + "\" at index " + i + ", but was " + strSubstring);
    }

    private static final void throwInvalidPrefixSuffix(String str, int i, int i2, String str2, String str3) {
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        throw new NumberFormatException("Expected a hexadecimal number with prefix \"" + str2 + "\" and suffix \"" + str3 + "\", but was " + strSubstring);
    }

    private static final Void throwInvalidDigitAt(String str, int i) {
        throw new NumberFormatException("Expected a hexadecimal digit at index " + i + ", but was " + str.charAt(i));
    }

    private static final byte parseByteAt(String str, int i) {
        int[] iArr;
        int i2;
        int i3;
        char cCharAt = str.charAt(i);
        if ((cCharAt >>> '\b') != 0 || (i2 = (iArr = HEX_DIGITS_TO_DECIMAL)[cCharAt]) < 0) {
            throwInvalidDigitAt(str, i);
            throw new KotlinNothingValueException();
        }
        int i4 = i + 1;
        char cCharAt2 = str.charAt(i4);
        if ((cCharAt2 >>> '\b') == 0 && (i3 = iArr[cCharAt2]) >= 0) {
            return (byte) ((i2 << 4) | i3);
        }
        throwInvalidDigitAt(str, i4);
        throw new KotlinNothingValueException();
    }

    private static final int parseInt(String str, int i, int i2) {
        int i3;
        int i4 = 0;
        while (i < i2) {
            int i5 = i4 << 4;
            char cCharAt = str.charAt(i);
            if ((cCharAt >>> '\b') != 0 || (i3 = HEX_DIGITS_TO_DECIMAL[cCharAt]) < 0) {
                throwInvalidDigitAt(str, i);
                throw new KotlinNothingValueException();
            }
            i4 = i5 | i3;
            i++;
        }
        return i4;
    }

    private static final long parseLong(String str, int i, int i2) {
        long j = 0;
        while (i < i2) {
            long j2 = j << 4;
            char cCharAt = str.charAt(i);
            if ((cCharAt >>> '\b') == 0) {
                long j3 = HEX_DIGITS_TO_LONG_DECIMAL[cCharAt];
                if (j3 >= 0) {
                    j = j2 | j3;
                    i++;
                }
            }
            throwInvalidDigitAt(str, i);
            throw new KotlinNothingValueException();
        }
        return j;
    }
}
