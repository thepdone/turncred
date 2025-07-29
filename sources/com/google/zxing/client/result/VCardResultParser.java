package com.google.zxing.client.result;

import com.facebook.share.internal.ShareConstants;
import com.google.zxing.Result;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public final class VCardResultParser extends ResultParser {
    private static final Pattern BEGIN_VCARD = Pattern.compile("BEGIN:VCARD", 2);
    private static final Pattern VCARD_LIKE_DATE = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");
    private static final Pattern CR_LF_SPACE_TAB = Pattern.compile("\r\n[ \t]");
    private static final Pattern NEWLINE_ESCAPE = Pattern.compile("\\\\[nN]");
    private static final Pattern VCARD_ESCAPES = Pattern.compile("\\\\([,;\\\\])");
    private static final Pattern EQUALS = Pattern.compile("=");
    private static final Pattern SEMICOLON = Pattern.compile(";");
    private static final Pattern UNESCAPED_SEMICOLONS = Pattern.compile("(?<!\\\\);+");
    private static final Pattern COMMA = Pattern.compile(",");
    private static final Pattern SEMICOLON_OR_COMMA = Pattern.compile("[;,]");

    @Override // com.google.zxing.client.result.ResultParser
    public AddressBookParsedResult parse(Result result) {
        String massagedText = getMassagedText(result);
        Matcher matcher = BEGIN_VCARD.matcher(massagedText);
        if (!matcher.find() || matcher.start() != 0) {
            return null;
        }
        List<List<String>> listMatchVCardPrefixedField = matchVCardPrefixedField("FN", massagedText, true, false);
        if (listMatchVCardPrefixedField == null) {
            listMatchVCardPrefixedField = matchVCardPrefixedField("N", massagedText, true, false);
            formatNames(listMatchVCardPrefixedField);
        }
        List<String> listMatchSingleVCardPrefixedField = matchSingleVCardPrefixedField("NICKNAME", massagedText, true, false);
        String[] strArrSplit = listMatchSingleVCardPrefixedField == null ? null : COMMA.split(listMatchSingleVCardPrefixedField.get(0));
        List<List<String>> listMatchVCardPrefixedField2 = matchVCardPrefixedField("TEL", massagedText, true, false);
        List<List<String>> listMatchVCardPrefixedField3 = matchVCardPrefixedField("EMAIL", massagedText, true, false);
        List<String> listMatchSingleVCardPrefixedField2 = matchSingleVCardPrefixedField("NOTE", massagedText, false, false);
        List<List<String>> listMatchVCardPrefixedField4 = matchVCardPrefixedField("ADR", massagedText, true, true);
        List<String> listMatchSingleVCardPrefixedField3 = matchSingleVCardPrefixedField("ORG", massagedText, true, true);
        List<String> listMatchSingleVCardPrefixedField4 = matchSingleVCardPrefixedField("BDAY", massagedText, true, false);
        List<String> list = (listMatchSingleVCardPrefixedField4 == null || isLikeVCardDate(listMatchSingleVCardPrefixedField4.get(0))) ? listMatchSingleVCardPrefixedField4 : null;
        List<String> listMatchSingleVCardPrefixedField5 = matchSingleVCardPrefixedField(ShareConstants.TITLE, massagedText, true, false);
        List<List<String>> listMatchVCardPrefixedField5 = matchVCardPrefixedField("URL", massagedText, true, false);
        List<String> listMatchSingleVCardPrefixedField6 = matchSingleVCardPrefixedField("IMPP", massagedText, true, false);
        List<String> listMatchSingleVCardPrefixedField7 = matchSingleVCardPrefixedField("GEO", massagedText, true, false);
        String[] strArrSplit2 = listMatchSingleVCardPrefixedField7 == null ? null : SEMICOLON_OR_COMMA.split(listMatchSingleVCardPrefixedField7.get(0));
        return new AddressBookParsedResult(toPrimaryValues(listMatchVCardPrefixedField), strArrSplit, null, toPrimaryValues(listMatchVCardPrefixedField2), toTypes(listMatchVCardPrefixedField2), toPrimaryValues(listMatchVCardPrefixedField3), toTypes(listMatchVCardPrefixedField3), toPrimaryValue(listMatchSingleVCardPrefixedField6), toPrimaryValue(listMatchSingleVCardPrefixedField2), toPrimaryValues(listMatchVCardPrefixedField4), toTypes(listMatchVCardPrefixedField4), toPrimaryValue(listMatchSingleVCardPrefixedField3), toPrimaryValue(list), toPrimaryValue(listMatchSingleVCardPrefixedField5), toPrimaryValues(listMatchVCardPrefixedField5), (strArrSplit2 == null || strArrSplit2.length == 2) ? strArrSplit2 : null);
    }

    static List<List<String>> matchVCardPrefixedField(CharSequence charSequence, String str, boolean z, boolean z2) {
        ArrayList arrayList;
        int i;
        String str2;
        String str3;
        int iIndexOf;
        int i2;
        String strReplaceAll;
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        ArrayList arrayList2 = null;
        while (i4 < length) {
            int i5 = 2;
            Matcher matcher = Pattern.compile("(?:^|\n)" + ((Object) charSequence) + "(?:;([^:]*))?:", 2).matcher(str);
            if (i4 > 0) {
                i4--;
            }
            if (!matcher.find(i4)) {
                break;
            }
            int iEnd = matcher.end(i3);
            String strGroup = matcher.group(1);
            if (strGroup != null) {
                String[] strArrSplit = SEMICOLON.split(strGroup);
                int length2 = strArrSplit.length;
                int i6 = i3;
                i = i6;
                arrayList = null;
                str2 = null;
                str3 = null;
                while (i6 < length2) {
                    String str4 = strArrSplit[i6];
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(str4);
                    String[] strArrSplit2 = EQUALS.split(str4, i5);
                    if (strArrSplit2.length > 1) {
                        String str5 = strArrSplit2[0];
                        String str6 = strArrSplit2[1];
                        if ("ENCODING".equalsIgnoreCase(str5) && "QUOTED-PRINTABLE".equalsIgnoreCase(str6)) {
                            i = 1;
                        } else if ("CHARSET".equalsIgnoreCase(str5)) {
                            str2 = str6;
                        } else if ("VALUE".equalsIgnoreCase(str5)) {
                            str3 = str6;
                        }
                    }
                    i6++;
                    i5 = 2;
                }
            } else {
                arrayList = null;
                i = 0;
                str2 = null;
                str3 = null;
            }
            int i7 = iEnd;
            while (true) {
                iIndexOf = str.indexOf(10, i7);
                if (iIndexOf < 0) {
                    break;
                }
                if (iIndexOf < str.length() - 1) {
                    int i8 = iIndexOf + 1;
                    if (str.charAt(i8) == ' ' || str.charAt(i8) == '\t') {
                        i7 = iIndexOf + 2;
                    }
                }
                if (i == 0 || ((iIndexOf <= 0 || str.charAt(iIndexOf - 1) != '=') && (iIndexOf < 2 || str.charAt(iIndexOf - 2) != '='))) {
                    break;
                }
                i7 = iIndexOf + 1;
            }
            if (iIndexOf < 0) {
                i4 = length;
                i3 = 0;
            } else if (iIndexOf <= iEnd) {
                i2 = 0;
                i3 = i2;
                i4 = iIndexOf + 1;
            } else {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                }
                if (iIndexOf > 0 && str.charAt(iIndexOf - 1) == '\r') {
                    iIndexOf--;
                }
                String strSubstring = str.substring(iEnd, iIndexOf);
                if (z) {
                    strSubstring = strSubstring.trim();
                }
                if (i != 0) {
                    strReplaceAll = decodeQuotedPrintable(strSubstring, str2);
                    if (z2) {
                        strReplaceAll = UNESCAPED_SEMICOLONS.matcher(strReplaceAll).replaceAll("\n").trim();
                    }
                } else {
                    if (z2) {
                        strSubstring = UNESCAPED_SEMICOLONS.matcher(strSubstring).replaceAll("\n").trim();
                    }
                    strReplaceAll = VCARD_ESCAPES.matcher(NEWLINE_ESCAPE.matcher(CR_LF_SPACE_TAB.matcher(strSubstring).replaceAll("")).replaceAll("\n")).replaceAll("$1");
                }
                if (ShareConstants.MEDIA_URI.equals(str3)) {
                    try {
                        strReplaceAll = URI.create(strReplaceAll).getSchemeSpecificPart();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                if (arrayList == null) {
                    ArrayList arrayList3 = new ArrayList(1);
                    arrayList3.add(strReplaceAll);
                    arrayList2.add(arrayList3);
                    i2 = 0;
                    i3 = i2;
                    i4 = iIndexOf + 1;
                } else {
                    i2 = 0;
                    arrayList.add(0, strReplaceAll);
                    arrayList2.add(arrayList);
                    i3 = i2;
                    i4 = iIndexOf + 1;
                }
            }
        }
        return arrayList2;
    }

    private static String decodeQuotedPrintable(CharSequence charSequence, String str) {
        char cCharAt;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < length) {
            char cCharAt2 = charSequence.charAt(i);
            if (cCharAt2 != '\n' && cCharAt2 != '\r') {
                if (cCharAt2 != '=') {
                    maybeAppendFragment(byteArrayOutputStream, str, sb);
                    sb.append(cCharAt2);
                } else if (i < length - 2 && (cCharAt = charSequence.charAt(i + 1)) != '\r' && cCharAt != '\n') {
                    i += 2;
                    char cCharAt3 = charSequence.charAt(i);
                    int hexDigit = parseHexDigit(cCharAt);
                    int hexDigit2 = parseHexDigit(cCharAt3);
                    if (hexDigit >= 0 && hexDigit2 >= 0) {
                        byteArrayOutputStream.write((hexDigit << 4) + hexDigit2);
                    }
                }
            }
            i++;
        }
        maybeAppendFragment(byteArrayOutputStream, str, sb);
        return sb.toString();
    }

    private static void maybeAppendFragment(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder sb) {
        String str2;
        if (byteArrayOutputStream.size() > 0) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new String(byteArray, StandardCharsets.UTF_8);
            } else {
                try {
                    str2 = new String(byteArray, str);
                } catch (UnsupportedEncodingException unused) {
                    str2 = new String(byteArray, StandardCharsets.UTF_8);
                }
            }
            byteArrayOutputStream.reset();
            sb.append(str2);
        }
    }

    static List<String> matchSingleVCardPrefixedField(CharSequence charSequence, String str, boolean z, boolean z2) {
        List<List<String>> listMatchVCardPrefixedField = matchVCardPrefixedField(charSequence, str, z, z2);
        if (listMatchVCardPrefixedField == null || listMatchVCardPrefixedField.isEmpty()) {
            return null;
        }
        return listMatchVCardPrefixedField.get(0);
    }

    private static String toPrimaryValue(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private static String[] toPrimaryValues(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<List<String>> it = collection.iterator();
        while (it.hasNext()) {
            String str = it.next().get(0);
            if (str != null && !str.isEmpty()) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static String[] toTypes(Collection<List<String>> collection) {
        String strSubstring;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            String str = list.get(0);
            if (str != null && !str.isEmpty()) {
                int i = 1;
                while (true) {
                    if (i >= list.size()) {
                        strSubstring = null;
                        break;
                    }
                    strSubstring = list.get(i);
                    int iIndexOf = strSubstring.indexOf(61);
                    if (iIndexOf < 0) {
                        break;
                    }
                    if ("TYPE".equalsIgnoreCase(strSubstring.substring(0, iIndexOf))) {
                        strSubstring = strSubstring.substring(iIndexOf + 1);
                        break;
                    }
                    i++;
                }
                arrayList.add(strSubstring);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static boolean isLikeVCardDate(CharSequence charSequence) {
        return charSequence == null || VCARD_LIKE_DATE.matcher(charSequence).matches();
    }

    private static void formatNames(Iterable<List<String>> iterable) {
        int iIndexOf;
        if (iterable != null) {
            for (List<String> list : iterable) {
                String str = list.get(0);
                String[] strArr = new String[5];
                int i = 0;
                int i2 = 0;
                while (i < 4 && (iIndexOf = str.indexOf(59, i2)) >= 0) {
                    strArr[i] = str.substring(i2, iIndexOf);
                    i++;
                    i2 = iIndexOf + 1;
                }
                strArr[i] = str.substring(i2);
                StringBuilder sb = new StringBuilder(100);
                maybeAppendComponent(strArr, 3, sb);
                maybeAppendComponent(strArr, 1, sb);
                maybeAppendComponent(strArr, 2, sb);
                maybeAppendComponent(strArr, 0, sb);
                maybeAppendComponent(strArr, 4, sb);
                list.set(0, sb.toString().trim());
            }
        }
    }

    private static void maybeAppendComponent(String[] strArr, int i, StringBuilder sb) {
        String str = strArr[i];
        if (str == null || str.isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append(' ');
        }
        sb.append(strArr[i]);
    }
}
