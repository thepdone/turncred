package com.facebook.hermes.intl;

import com.facebook.hermes.intl.LocaleIdTokenizer;
import com.facebook.hermes.intl.ParsedLocaleIdentifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

/* loaded from: classes4.dex */
public class LocaleIdentifier {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private static void addVariantSubtag(String str, ParsedLocaleIdentifier.ParsedLanguageIdentifier parsedLanguageIdentifier) throws JSRangeErrorException {
        if (parsedLanguageIdentifier.variantSubtagList != null) {
            if (Collections.binarySearch(parsedLanguageIdentifier.variantSubtagList, str) < 0) {
                parsedLanguageIdentifier.variantSubtagList.add((r0 * (-1)) - 1, str);
                return;
            }
            throw new JSRangeErrorException("Duplicate variant");
        }
        parsedLanguageIdentifier.variantSubtagList = new ArrayList<>();
        parsedLanguageIdentifier.variantSubtagList.add(str);
    }

    public static void replaceLanguageSubtagIfNeeded(StringBuffer stringBuffer, StringBuffer stringBuffer2, StringBuffer stringBuffer3) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String[] strArr4;
        String[] strArr5;
        String[] strArr6;
        if (LanguageTagsGenerated.languageAliasKeys2 == null) {
            return;
        }
        if (stringBuffer.length() == 2) {
            strArr = LanguageTagsGenerated.languageAliasKeys2;
            strArr2 = LanguageTagsGenerated.languageAliasReplacements2;
            strArr3 = LanguageTagsGenerated.complexLanguageAliasKeys2;
            strArr4 = LanguageTagsGenerated.complexLanguageAliasReplacementsLanguage2;
            strArr5 = LanguageTagsGenerated.complexLanguageAliasReplacementsScript2;
            strArr6 = LanguageTagsGenerated.complexLanguageAliasReplacementsRegion2;
        } else {
            strArr = LanguageTagsGenerated.languageAliasKeys3;
            strArr2 = LanguageTagsGenerated.languageAliasReplacements3;
            strArr3 = LanguageTagsGenerated.complexLanguageAliasKeys3;
            strArr4 = LanguageTagsGenerated.complexLanguageAliasReplacementsLanguage3;
            strArr5 = LanguageTagsGenerated.complexLanguageAliasReplacementsScript3;
            strArr6 = LanguageTagsGenerated.complexLanguageAliasReplacementsRegion3;
        }
        int iBinarySearch = Arrays.binarySearch(strArr, stringBuffer.toString());
        if (iBinarySearch >= 0) {
            stringBuffer.delete(0, stringBuffer.length());
            stringBuffer.append(strArr2[iBinarySearch]);
            return;
        }
        int iBinarySearch2 = Arrays.binarySearch(strArr3, stringBuffer.toString());
        if (iBinarySearch2 >= 0) {
            String str = strArr4[iBinarySearch2];
            String str2 = strArr5[iBinarySearch2];
            String str3 = strArr6[iBinarySearch2];
            stringBuffer.delete(0, stringBuffer.length());
            stringBuffer.append(str);
            if (stringBuffer2.length() == 0 && str2 != null) {
                stringBuffer2.append(str2);
            }
            if (stringBuffer3.length() != 0 || str3 == null) {
                return;
            }
            stringBuffer3.append(str3);
        }
    }

    public static String replaceRegionSubtagIfNeeded(StringBuffer stringBuffer) {
        if (LanguageTagsGenerated.regionAliasKeys2 == null) {
            return stringBuffer.toString();
        }
        if (stringBuffer.length() == 2) {
            int iBinarySearch = Arrays.binarySearch(LanguageTagsGenerated.regionAliasKeys2, stringBuffer.toString());
            if (iBinarySearch >= 0) {
                return LanguageTagsGenerated.regionAliasReplacements2[iBinarySearch];
            }
            return stringBuffer.toString();
        }
        int iBinarySearch2 = Arrays.binarySearch(LanguageTagsGenerated.regionAliasKeys3, stringBuffer.toString());
        if (iBinarySearch2 >= 0) {
            return LanguageTagsGenerated.regionAliasReplacements3[iBinarySearch2];
        }
        return stringBuffer.toString();
    }

    static String canonicalizeLocaleId(String str) throws JSRangeErrorException {
        return LocaleObject.createFromLocaleId(str).toCanonicalTag();
    }

    static void parseUnicodeExtensions(CharSequence charSequence, LocaleIdTokenizer localeIdTokenizer, ParsedLocaleIdentifier parsedLocaleIdentifier) throws LocaleIdTokenizer.LocaleIdSubtagIterationFailed, JSRangeErrorException {
        if (!localeIdTokenizer.hasMoreSubtags()) {
            throw new JSRangeErrorException("Extension sequence expected.");
        }
        LocaleIdTokenizer.LocaleIdSubtag localeIdSubtagNextSubtag = localeIdTokenizer.nextSubtag();
        if (parsedLocaleIdentifier.unicodeExtensionAttributes != null || parsedLocaleIdentifier.unicodeExtensionKeywords != null) {
            throw new JSRangeErrorException(String.format("Duplicate unicode extension sequence in [%s]", charSequence));
        }
        while (localeIdSubtagNextSubtag.isUnicodeExtensionAttribute()) {
            if (parsedLocaleIdentifier.unicodeExtensionAttributes == null) {
                parsedLocaleIdentifier.unicodeExtensionAttributes = new ArrayList<>();
            }
            parsedLocaleIdentifier.unicodeExtensionAttributes.add(localeIdSubtagNextSubtag.toString());
            if (!localeIdTokenizer.hasMoreSubtags()) {
                return;
            } else {
                localeIdSubtagNextSubtag = localeIdTokenizer.nextSubtag();
            }
        }
        if (localeIdSubtagNextSubtag.isUnicodeExtensionKey()) {
            if (parsedLocaleIdentifier.unicodeExtensionKeywords == null) {
                parsedLocaleIdentifier.unicodeExtensionKeywords = new TreeMap<>();
            }
            do {
                String string = localeIdSubtagNextSubtag.toString();
                ArrayList<String> arrayList = new ArrayList<>();
                parsedLocaleIdentifier.unicodeExtensionKeywords.put(string, arrayList);
                if (!localeIdTokenizer.hasMoreSubtags()) {
                    return;
                }
                localeIdSubtagNextSubtag = localeIdTokenizer.nextSubtag();
                while (localeIdSubtagNextSubtag.isUnicodeExtensionKeyTypeItem()) {
                    arrayList.add(localeIdSubtagNextSubtag.toString());
                    if (!localeIdTokenizer.hasMoreSubtags()) {
                        return;
                    } else {
                        localeIdSubtagNextSubtag = localeIdTokenizer.nextSubtag();
                    }
                }
            } while (localeIdSubtagNextSubtag.isUnicodeExtensionKey());
        }
        if (localeIdSubtagNextSubtag.isExtensionSingleton()) {
            parseExtensions(charSequence, localeIdSubtagNextSubtag, localeIdTokenizer, parsedLocaleIdentifier);
            return;
        }
        throw new JSRangeErrorException("Malformed sequence expected.");
    }

    static void parseTransformedExtensionFields(CharSequence charSequence, LocaleIdTokenizer localeIdTokenizer, LocaleIdTokenizer.LocaleIdSubtag localeIdSubtag, ParsedLocaleIdentifier parsedLocaleIdentifier) throws LocaleIdTokenizer.LocaleIdSubtagIterationFailed, JSRangeErrorException {
        if (localeIdSubtag.isTranformedExtensionTKey()) {
            if (parsedLocaleIdentifier.transformedExtensionFields != null) {
                throw new JSRangeErrorException(String.format("Duplicate transformed extension sequence in [%s]", charSequence));
            }
            if (parsedLocaleIdentifier.transformedExtensionFields == null) {
                parsedLocaleIdentifier.transformedExtensionFields = new TreeMap<>();
            }
            do {
                String string = localeIdSubtag.toString();
                ArrayList<String> arrayList = new ArrayList<>();
                parsedLocaleIdentifier.transformedExtensionFields.put(string, arrayList);
                if (localeIdTokenizer.hasMoreSubtags()) {
                    localeIdSubtag = localeIdTokenizer.nextSubtag();
                    while (localeIdSubtag.isTranformedExtensionTValueItem()) {
                        arrayList.add(localeIdSubtag.toString());
                        if (!localeIdTokenizer.hasMoreSubtags()) {
                            return;
                        } else {
                            localeIdSubtag = localeIdTokenizer.nextSubtag();
                        }
                    }
                } else {
                    throw new JSRangeErrorException(String.format("Malformated transformed key in : %s", charSequence));
                }
            } while (localeIdSubtag.isTranformedExtensionTKey());
        }
        if (localeIdSubtag.isExtensionSingleton()) {
            parseExtensions(charSequence, localeIdSubtag, localeIdTokenizer, parsedLocaleIdentifier);
            return;
        }
        throw new JSRangeErrorException("Malformed extension sequence.");
    }

    static void parseTransformedExtensions(CharSequence charSequence, LocaleIdTokenizer localeIdTokenizer, ParsedLocaleIdentifier parsedLocaleIdentifier) throws LocaleIdTokenizer.LocaleIdSubtagIterationFailed, JSRangeErrorException {
        if (!localeIdTokenizer.hasMoreSubtags()) {
            throw new JSRangeErrorException("Extension sequence expected.");
        }
        LocaleIdTokenizer.LocaleIdSubtag localeIdSubtagNextSubtag = localeIdTokenizer.nextSubtag();
        if (localeIdSubtagNextSubtag.isUnicodeLanguageSubtag()) {
            parseLanguageId(charSequence, localeIdTokenizer, localeIdSubtagNextSubtag, true, parsedLocaleIdentifier);
        } else {
            if (localeIdSubtagNextSubtag.isTranformedExtensionTKey()) {
                parseTransformedExtensionFields(charSequence, localeIdTokenizer, localeIdSubtagNextSubtag, parsedLocaleIdentifier);
                return;
            }
            throw new JSRangeErrorException(String.format("Unexpected token [%s] in transformed extension sequence [%s]", localeIdSubtagNextSubtag.toString(), charSequence));
        }
    }

    static void parsePrivateUseExtensions(CharSequence charSequence, LocaleIdTokenizer localeIdTokenizer, ParsedLocaleIdentifier parsedLocaleIdentifier) throws LocaleIdTokenizer.LocaleIdSubtagIterationFailed, JSRangeErrorException {
        if (!localeIdTokenizer.hasMoreSubtags()) {
            throw new JSRangeErrorException("Extension sequence expected.");
        }
        LocaleIdTokenizer.LocaleIdSubtag localeIdSubtagNextSubtag = localeIdTokenizer.nextSubtag();
        if (parsedLocaleIdentifier.puExtensions == null) {
            parsedLocaleIdentifier.puExtensions = new ArrayList<>();
        }
        while (localeIdSubtagNextSubtag.isPrivateUseExtension()) {
            parsedLocaleIdentifier.puExtensions.add(localeIdSubtagNextSubtag.toString());
            if (!localeIdTokenizer.hasMoreSubtags()) {
                return;
            } else {
                localeIdSubtagNextSubtag = localeIdTokenizer.nextSubtag();
            }
        }
        throw new JSRangeErrorException("Tokens are not expected after pu extension.");
    }

    static void parseOtherExtensions(CharSequence charSequence, LocaleIdTokenizer localeIdTokenizer, ParsedLocaleIdentifier parsedLocaleIdentifier, char c) throws LocaleIdTokenizer.LocaleIdSubtagIterationFailed, JSRangeErrorException {
        if (!localeIdTokenizer.hasMoreSubtags()) {
            throw new JSRangeErrorException("Extension sequence expected.");
        }
        LocaleIdTokenizer.LocaleIdSubtag localeIdSubtagNextSubtag = localeIdTokenizer.nextSubtag();
        if (parsedLocaleIdentifier.otherExtensionsMap == null) {
            parsedLocaleIdentifier.otherExtensionsMap = new TreeMap<>();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        parsedLocaleIdentifier.otherExtensionsMap.put(new Character(c), arrayList);
        while (localeIdSubtagNextSubtag.isOtherExtension()) {
            arrayList.add(localeIdSubtagNextSubtag.toString());
            if (!localeIdTokenizer.hasMoreSubtags()) {
                return;
            } else {
                localeIdSubtagNextSubtag = localeIdTokenizer.nextSubtag();
            }
        }
        if (localeIdSubtagNextSubtag.isExtensionSingleton()) {
            parseExtensions(charSequence, localeIdSubtagNextSubtag, localeIdTokenizer, parsedLocaleIdentifier);
            return;
        }
        throw new JSRangeErrorException("Malformed sequence expected.");
    }

    static void parseExtensions(CharSequence charSequence, LocaleIdTokenizer.LocaleIdSubtag localeIdSubtag, LocaleIdTokenizer localeIdTokenizer, ParsedLocaleIdentifier parsedLocaleIdentifier) throws LocaleIdTokenizer.LocaleIdSubtagIterationFailed, JSRangeErrorException {
        if (!localeIdTokenizer.hasMoreSubtags()) {
            throw new JSRangeErrorException("Extension sequence expected.");
        }
        char cCharAt = localeIdSubtag.toString().charAt(0);
        if (cCharAt == 'u') {
            parseUnicodeExtensions(charSequence, localeIdTokenizer, parsedLocaleIdentifier);
            return;
        }
        if (cCharAt == 't') {
            parseTransformedExtensions(charSequence, localeIdTokenizer, parsedLocaleIdentifier);
        } else if (cCharAt == 'x') {
            parsePrivateUseExtensions(charSequence, localeIdTokenizer, parsedLocaleIdentifier);
        } else {
            parseOtherExtensions(charSequence, localeIdTokenizer, parsedLocaleIdentifier, cCharAt);
        }
    }

    static boolean handleExtensions(CharSequence charSequence, LocaleIdTokenizer localeIdTokenizer, LocaleIdTokenizer.LocaleIdSubtag localeIdSubtag, boolean z, ParsedLocaleIdentifier parsedLocaleIdentifier) throws LocaleIdTokenizer.LocaleIdSubtagIterationFailed, JSRangeErrorException {
        if (z && localeIdSubtag.isTranformedExtensionTKey()) {
            parseTransformedExtensionFields(charSequence, localeIdTokenizer, localeIdSubtag, parsedLocaleIdentifier);
            return true;
        }
        if (!localeIdSubtag.isExtensionSingleton()) {
            return false;
        }
        if (!z) {
            parseExtensions(charSequence, localeIdSubtag, localeIdTokenizer, parsedLocaleIdentifier);
            return true;
        }
        throw new JSRangeErrorException(String.format("Extension singletons in transformed extension language tag: %s", charSequence));
    }

    static void parseLanguageId(CharSequence charSequence, LocaleIdTokenizer localeIdTokenizer, LocaleIdTokenizer.LocaleIdSubtag localeIdSubtag, boolean z, ParsedLocaleIdentifier parsedLocaleIdentifier) throws LocaleIdTokenizer.LocaleIdSubtagIterationFailed, JSRangeErrorException {
        ParsedLocaleIdentifier.ParsedLanguageIdentifier parsedLanguageIdentifier = new ParsedLocaleIdentifier.ParsedLanguageIdentifier();
        if (z) {
            parsedLocaleIdentifier.transformedLanguageIdentifier = parsedLanguageIdentifier;
        } else {
            parsedLocaleIdentifier.languageIdentifier = parsedLanguageIdentifier;
        }
        try {
            if (!localeIdSubtag.isUnicodeLanguageSubtag()) {
                throw new JSRangeErrorException(String.format("Language subtag expected at %s: %s", localeIdSubtag.toString(), charSequence));
            }
            parsedLanguageIdentifier.languageSubtag = localeIdSubtag.toLowerString();
            if (localeIdTokenizer.hasMoreSubtags()) {
                LocaleIdTokenizer.LocaleIdSubtag localeIdSubtagNextSubtag = localeIdTokenizer.nextSubtag();
                if (handleExtensions(charSequence, localeIdTokenizer, localeIdSubtagNextSubtag, z, parsedLocaleIdentifier)) {
                    return;
                }
                if (localeIdSubtagNextSubtag.isUnicodeScriptSubtag()) {
                    parsedLanguageIdentifier.scriptSubtag = localeIdSubtagNextSubtag.toTitleString();
                    if (!localeIdTokenizer.hasMoreSubtags()) {
                        return;
                    } else {
                        localeIdSubtagNextSubtag = localeIdTokenizer.nextSubtag();
                    }
                }
                if (localeIdSubtagNextSubtag.isUnicodeRegionSubtag()) {
                    parsedLanguageIdentifier.regionSubtag = localeIdSubtagNextSubtag.toUpperString();
                    if (!localeIdTokenizer.hasMoreSubtags()) {
                        return;
                    } else {
                        localeIdSubtagNextSubtag = localeIdTokenizer.nextSubtag();
                    }
                }
                while (!handleExtensions(charSequence, localeIdTokenizer, localeIdSubtagNextSubtag, z, parsedLocaleIdentifier)) {
                    if (!localeIdSubtagNextSubtag.isUnicodeVariantSubtag()) {
                        throw new JSRangeErrorException(String.format("Unknown token [%s] found in locale id: %s", localeIdSubtagNextSubtag.toString(), charSequence));
                    }
                    addVariantSubtag(localeIdSubtagNextSubtag.toString(), parsedLanguageIdentifier);
                    if (!localeIdTokenizer.hasMoreSubtags()) {
                        return;
                    } else {
                        localeIdSubtagNextSubtag = localeIdTokenizer.nextSubtag();
                    }
                }
            }
        } catch (LocaleIdTokenizer.LocaleIdSubtagIterationFailed unused) {
            throw new JSRangeErrorException(String.format("Locale Identifier subtag iteration failed: %s", charSequence));
        }
    }

    static ParsedLocaleIdentifier parseLocaleId(String str, LocaleIdTokenizer localeIdTokenizer) throws JSRangeErrorException {
        ParsedLocaleIdentifier parsedLocaleIdentifier = new ParsedLocaleIdentifier();
        try {
            if (!localeIdTokenizer.hasMoreSubtags()) {
                throw new JSRangeErrorException(String.format("Language subtag not found: %s", str));
            }
            parseLanguageId(str, localeIdTokenizer, localeIdTokenizer.nextSubtag(), false, parsedLocaleIdentifier);
            return parsedLocaleIdentifier;
        } catch (LocaleIdTokenizer.LocaleIdSubtagIterationFailed unused) {
            throw new JSRangeErrorException(String.format("Locale Identifier subtag iteration failed: %s", str));
        }
    }

    static ParsedLocaleIdentifier parseLocaleId(String str) throws JSRangeErrorException {
        int iBinarySearch;
        if (LanguageTagsGenerated.regularGrandfatheredKeys != null && (iBinarySearch = Arrays.binarySearch(LanguageTagsGenerated.regularGrandfatheredKeys, str.toString())) >= 0) {
            str = LanguageTagsGenerated.regularGrandfatheredReplacements[iBinarySearch];
        }
        String lowerCase = str.toLowerCase();
        return parseLocaleId(lowerCase, new LocaleIdTokenizer(lowerCase));
    }
}
