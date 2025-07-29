package com.facebook.hermes.intl;

import androidx.camera.video.AudioStats;
import androidx.core.text.util.LocalePreferences;
import com.facebook.hermes.intl.IPlatformNumberFormatter;
import com.facebook.hermes.intl.OptionHelpers;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.sentry.profilemeasurements.ProfileMeasurement;
import io.sentry.protocol.SentryStackFrame;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class NumberFormat {
    private static String[] s_sanctionedSimpleUnitIdentifiers = {"acre", "bit", ProfileMeasurement.UNIT_BYTES, LocalePreferences.TemperatureUnit.CELSIUS, "centimeter", "day", "degree", "fahrenheit", "fluid-ounce", "foot", "gallon", "gigabit", "gigabyte", "gram", "hectare", "hour", "inch", "kilobit", "kilobyte", "kilogram", "kilometer", "liter", "megabit", "megabyte", "meter", "mile", "mile-scandinavian", "milliliter", "millimeter", "millisecond", "minute", "month", "ounce", ProfileMeasurement.UNIT_PERCENT, "petabyte", "pound", "second", "stone", "terabit", "terabyte", "week", "yard", "year"};
    private IPlatformNumberFormatter.CompactDisplay mResolvedCompactDisplay;
    private IPlatformNumberFormatter.Style mResolvedStyle;
    private IPlatformNumberFormatter.UnitDisplay mResolvedUnitDisplay;
    private IPlatformNumberFormatter.RoundingType mRoundingType;
    private boolean mUseDefaultNumberSystem;
    private String mResolvedCurrency = null;
    private IPlatformNumberFormatter.CurrencyDisplay mResolvedCurrencyDisplay = IPlatformNumberFormatter.CurrencyDisplay.SYMBOL;
    private IPlatformNumberFormatter.CurrencySign mResolvedCurrencySign = IPlatformNumberFormatter.CurrencySign.STANDARD;
    private String mResolvedUnit = null;
    private boolean mGroupingUsed = true;
    private int mResolvedMinimumIntegerDigits = -1;
    private int mResolvedMinimumFractionDigits = -1;
    private int mResolvedMaximumFractionDigits = -1;
    private int mResolvedMinimumSignificantDigits = -1;
    private int mResolvedMaximumSignificantDigits = -1;
    private IPlatformNumberFormatter.SignDisplay mResolvedSignDisplay = IPlatformNumberFormatter.SignDisplay.AUTO;
    private String mResolvedNumberingSystem = null;
    private IPlatformNumberFormatter.Notation mResolvedNotation = null;
    private ILocaleObject<?> mResolvedLocaleObject = null;
    private ILocaleObject<?> mResolvedLocaleObjectForResolvedOptions = null;
    private IPlatformNumberFormatter mPlatformNumberFormatter = new PlatformNumberFormatterICU();

    private boolean isSanctionedSimpleUnitIdentifier(String str) {
        return Arrays.binarySearch(s_sanctionedSimpleUnitIdentifiers, str) >= 0;
    }

    private boolean isWellFormedUnitIdentifier(String str) {
        if (isSanctionedSimpleUnitIdentifier(str)) {
            return true;
        }
        int iIndexOf = str.indexOf("-per-");
        return iIndexOf >= 0 && str.indexOf("-per-", iIndexOf + 1) < 0 && isSanctionedSimpleUnitIdentifier(str.substring(0, iIndexOf)) && isSanctionedSimpleUnitIdentifier(str.substring(iIndexOf + "-per-".length()));
    }

    private String normalizeCurrencyCode(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= 'a' && cCharAt <= 'z') {
                sb.append((char) (cCharAt - ' '));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    private boolean isWellFormedCurrencyCode(String str) {
        return normalizeCurrencyCode(str).matches("^[A-Z][A-Z][A-Z]$");
    }

    private void setNumberFormatUnitOptions(Map<String, Object> map) throws JSRangeErrorException {
        this.mResolvedStyle = (IPlatformNumberFormatter.Style) OptionHelpers.searchEnum(IPlatformNumberFormatter.Style.class, JSObjects.getJavaString(OptionHelpers.GetOption(map, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, OptionHelpers.OptionType.STRING, new String[]{"decimal", ProfileMeasurement.UNIT_PERCENT, FirebaseAnalytics.Param.CURRENCY, "unit"}, "decimal")));
        Object objGetOption = OptionHelpers.GetOption(map, FirebaseAnalytics.Param.CURRENCY, OptionHelpers.OptionType.STRING, JSObjects.Undefined(), JSObjects.Undefined());
        if (JSObjects.isUndefined(objGetOption)) {
            if (this.mResolvedStyle == IPlatformNumberFormatter.Style.CURRENCY) {
                throw new JSRangeErrorException("Expected currency style !");
            }
        } else if (!isWellFormedCurrencyCode(JSObjects.getJavaString(objGetOption))) {
            throw new JSRangeErrorException("Malformed currency code !");
        }
        Object objGetOption2 = OptionHelpers.GetOption(map, "currencyDisplay", OptionHelpers.OptionType.STRING, new String[]{SentryStackFrame.JsonKeys.SYMBOL, "narrowSymbol", "code", "name"}, SentryStackFrame.JsonKeys.SYMBOL);
        Object objGetOption3 = OptionHelpers.GetOption(map, "currencySign", OptionHelpers.OptionType.STRING, new String[]{"accounting", Constants.COLLATION_STANDARD}, Constants.COLLATION_STANDARD);
        Object objGetOption4 = OptionHelpers.GetOption(map, "unit", OptionHelpers.OptionType.STRING, JSObjects.Undefined(), JSObjects.Undefined());
        if (JSObjects.isUndefined(objGetOption4)) {
            if (this.mResolvedStyle == IPlatformNumberFormatter.Style.UNIT) {
                throw new JSRangeErrorException("Expected unit !");
            }
        } else if (!isWellFormedUnitIdentifier(JSObjects.getJavaString(objGetOption4))) {
            throw new JSRangeErrorException("Malformed unit identifier !");
        }
        Object objGetOption5 = OptionHelpers.GetOption(map, "unitDisplay", OptionHelpers.OptionType.STRING, new String[]{"long", "short", "narrow"}, "short");
        if (this.mResolvedStyle == IPlatformNumberFormatter.Style.CURRENCY) {
            this.mResolvedCurrency = normalizeCurrencyCode(JSObjects.getJavaString(objGetOption));
            this.mResolvedCurrencyDisplay = (IPlatformNumberFormatter.CurrencyDisplay) OptionHelpers.searchEnum(IPlatformNumberFormatter.CurrencyDisplay.class, JSObjects.getJavaString(objGetOption2));
            this.mResolvedCurrencySign = (IPlatformNumberFormatter.CurrencySign) OptionHelpers.searchEnum(IPlatformNumberFormatter.CurrencySign.class, JSObjects.getJavaString(objGetOption3));
        } else if (this.mResolvedStyle == IPlatformNumberFormatter.Style.UNIT) {
            this.mResolvedUnit = JSObjects.getJavaString(objGetOption4);
            this.mResolvedUnitDisplay = (IPlatformNumberFormatter.UnitDisplay) OptionHelpers.searchEnum(IPlatformNumberFormatter.UnitDisplay.class, JSObjects.getJavaString(objGetOption5));
        }
    }

    private void setNumberFormatDigitOptions(Map<String, Object> map, Object obj, Object obj2) throws JSRangeErrorException {
        Object objGetNumberOption = OptionHelpers.GetNumberOption(map, "minimumIntegerDigits", JSObjects.newNumber(1.0d), JSObjects.newNumber(21.0d), JSObjects.newNumber(1.0d));
        Object objGet = JSObjects.Get(map, "minimumFractionDigits");
        Object objGet2 = JSObjects.Get(map, "maximumFractionDigits");
        Object objGet3 = JSObjects.Get(map, "minimumSignificantDigits");
        Object objGet4 = JSObjects.Get(map, "maximumSignificantDigits");
        this.mResolvedMinimumIntegerDigits = (int) Math.floor(JSObjects.getJavaDouble(objGetNumberOption));
        if (!JSObjects.isUndefined(objGet3) || !JSObjects.isUndefined(objGet4)) {
            this.mRoundingType = IPlatformNumberFormatter.RoundingType.SIGNIFICANT_DIGITS;
            Object objDefaultNumberOption = OptionHelpers.DefaultNumberOption("minimumSignificantDigits", objGet3, JSObjects.newNumber(1.0d), JSObjects.newNumber(21.0d), JSObjects.newNumber(1.0d));
            Object objDefaultNumberOption2 = OptionHelpers.DefaultNumberOption("maximumSignificantDigits", objGet4, objDefaultNumberOption, JSObjects.newNumber(21.0d), JSObjects.newNumber(21.0d));
            this.mResolvedMinimumSignificantDigits = (int) Math.floor(JSObjects.getJavaDouble(objDefaultNumberOption));
            this.mResolvedMaximumSignificantDigits = (int) Math.floor(JSObjects.getJavaDouble(objDefaultNumberOption2));
            return;
        }
        if (!JSObjects.isUndefined(objGet) || !JSObjects.isUndefined(objGet2)) {
            this.mRoundingType = IPlatformNumberFormatter.RoundingType.FRACTION_DIGITS;
            Object objDefaultNumberOption3 = OptionHelpers.DefaultNumberOption("minimumFractionDigits", objGet, JSObjects.newNumber(AudioStats.AUDIO_AMPLITUDE_NONE), JSObjects.newNumber(20.0d), JSObjects.Undefined());
            Object objDefaultNumberOption4 = OptionHelpers.DefaultNumberOption("maximumFractionDigits", objGet2, JSObjects.newNumber(AudioStats.AUDIO_AMPLITUDE_NONE), JSObjects.newNumber(20.0d), JSObjects.Undefined());
            if (JSObjects.isUndefined(objDefaultNumberOption3)) {
                objDefaultNumberOption3 = JSObjects.newNumber(Math.min(JSObjects.getJavaDouble(obj), JSObjects.getJavaDouble(objDefaultNumberOption4)));
            } else if (JSObjects.isUndefined(objDefaultNumberOption4)) {
                objDefaultNumberOption4 = JSObjects.newNumber(Math.max(JSObjects.getJavaDouble(obj2), JSObjects.getJavaDouble(objDefaultNumberOption3)));
            } else if (JSObjects.getJavaDouble(objDefaultNumberOption3) > JSObjects.getJavaDouble(objDefaultNumberOption4)) {
                throw new JSRangeErrorException("minimumFractionDigits is greater than maximumFractionDigits");
            }
            this.mResolvedMinimumFractionDigits = (int) Math.floor(JSObjects.getJavaDouble(objDefaultNumberOption3));
            this.mResolvedMaximumFractionDigits = (int) Math.floor(JSObjects.getJavaDouble(objDefaultNumberOption4));
            return;
        }
        if (this.mResolvedNotation == IPlatformNumberFormatter.Notation.COMPACT) {
            this.mRoundingType = IPlatformNumberFormatter.RoundingType.COMPACT_ROUNDING;
            return;
        }
        if (this.mResolvedNotation == IPlatformNumberFormatter.Notation.ENGINEERING) {
            this.mRoundingType = IPlatformNumberFormatter.RoundingType.FRACTION_DIGITS;
            this.mResolvedMaximumFractionDigits = 5;
        } else {
            this.mRoundingType = IPlatformNumberFormatter.RoundingType.FRACTION_DIGITS;
            this.mResolvedMinimumFractionDigits = (int) Math.floor(JSObjects.getJavaDouble(obj));
            this.mResolvedMaximumFractionDigits = (int) Math.floor(JSObjects.getJavaDouble(obj2));
        }
    }

    private boolean isLocaleIdType(String str) {
        return IntlTextUtils.isUnicodeExtensionKeyTypeItem(str, 0, str.length() - 1);
    }

    private void initializeNumberFormat(List<String> list, Map<String, Object> map) throws JSRangeErrorException {
        Object objNewNumber;
        Object objNewNumber2;
        Object objNewObject = JSObjects.newObject();
        JSObjects.Put(objNewObject, Constants.LOCALEMATCHER, OptionHelpers.GetOption(map, Constants.LOCALEMATCHER, OptionHelpers.OptionType.STRING, Constants.LOCALEMATCHER_POSSIBLE_VALUES, Constants.LOCALEMATCHER_BESTFIT));
        Object objGetOption = OptionHelpers.GetOption(map, "numberingSystem", OptionHelpers.OptionType.STRING, JSObjects.Undefined(), JSObjects.Undefined());
        if (!JSObjects.isUndefined(objGetOption) && !isLocaleIdType(JSObjects.getJavaString(objGetOption))) {
            throw new JSRangeErrorException("Invalid numbering system !");
        }
        JSObjects.Put(objNewObject, "nu", objGetOption);
        HashMap<String, Object> mapResolveLocale = LocaleResolver.resolveLocale(list, objNewObject, Collections.singletonList("nu"));
        ILocaleObject<?> iLocaleObject = (ILocaleObject) JSObjects.getJavaMap(mapResolveLocale).get("locale");
        this.mResolvedLocaleObject = iLocaleObject;
        this.mResolvedLocaleObjectForResolvedOptions = iLocaleObject.cloneObject();
        Object objGet = JSObjects.Get(mapResolveLocale, "nu");
        if (!JSObjects.isNull(objGet)) {
            this.mUseDefaultNumberSystem = false;
            this.mResolvedNumberingSystem = JSObjects.getJavaString(objGet);
        } else {
            this.mUseDefaultNumberSystem = true;
            this.mResolvedNumberingSystem = this.mPlatformNumberFormatter.getDefaultNumberingSystem(this.mResolvedLocaleObject);
        }
        setNumberFormatUnitOptions(map);
        if (this.mResolvedStyle == IPlatformNumberFormatter.Style.CURRENCY) {
            double currencyDigits = PlatformNumberFormatterICU.getCurrencyDigits(this.mResolvedCurrency);
            objNewNumber = JSObjects.newNumber(currencyDigits);
            objNewNumber2 = JSObjects.newNumber(currencyDigits);
        } else {
            objNewNumber = JSObjects.newNumber(AudioStats.AUDIO_AMPLITUDE_NONE);
            objNewNumber2 = this.mResolvedStyle == IPlatformNumberFormatter.Style.PERCENT ? JSObjects.newNumber(AudioStats.AUDIO_AMPLITUDE_NONE) : JSObjects.newNumber(3.0d);
        }
        this.mResolvedNotation = (IPlatformNumberFormatter.Notation) OptionHelpers.searchEnum(IPlatformNumberFormatter.Notation.class, JSObjects.getJavaString(OptionHelpers.GetOption(map, "notation", OptionHelpers.OptionType.STRING, new String[]{Constants.COLLATION_STANDARD, "scientific", "engineering", "compact"}, Constants.COLLATION_STANDARD)));
        setNumberFormatDigitOptions(map, objNewNumber, objNewNumber2);
        Object objGetOption2 = OptionHelpers.GetOption(map, "compactDisplay", OptionHelpers.OptionType.STRING, new String[]{"short", "long"}, "short");
        if (this.mResolvedNotation == IPlatformNumberFormatter.Notation.COMPACT) {
            this.mResolvedCompactDisplay = (IPlatformNumberFormatter.CompactDisplay) OptionHelpers.searchEnum(IPlatformNumberFormatter.CompactDisplay.class, JSObjects.getJavaString(objGetOption2));
        }
        this.mGroupingUsed = JSObjects.getJavaBoolean(OptionHelpers.GetOption(map, "useGrouping", OptionHelpers.OptionType.BOOLEAN, JSObjects.Undefined(), JSObjects.newBoolean(true)));
        this.mResolvedSignDisplay = (IPlatformNumberFormatter.SignDisplay) OptionHelpers.searchEnum(IPlatformNumberFormatter.SignDisplay.class, JSObjects.getJavaString(OptionHelpers.GetOption(map, "signDisplay", OptionHelpers.OptionType.STRING, new String[]{"auto", "never", "always", "exceptZero"}, "auto")));
    }

    public NumberFormat(List<String> list, Map<String, Object> map) throws JSRangeErrorException {
        initializeNumberFormat(list, map);
        this.mPlatformNumberFormatter.configure(this.mResolvedLocaleObject, this.mUseDefaultNumberSystem ? "" : this.mResolvedNumberingSystem, this.mResolvedStyle, this.mResolvedCurrencySign, this.mResolvedNotation, this.mResolvedCompactDisplay).setCurrency(this.mResolvedCurrency, this.mResolvedCurrencyDisplay).setGrouping(this.mGroupingUsed).setMinIntergerDigits(this.mResolvedMinimumIntegerDigits).setSignificantDigits(this.mRoundingType, this.mResolvedMinimumSignificantDigits, this.mResolvedMaximumSignificantDigits).setFractionDigits(this.mRoundingType, this.mResolvedMinimumFractionDigits, this.mResolvedMaximumFractionDigits).setSignDisplay(this.mResolvedSignDisplay).setUnits(this.mResolvedUnit, this.mResolvedUnitDisplay);
    }

    public static List<String> supportedLocalesOf(List<String> list, Map<String, Object> map) throws JSRangeErrorException {
        String javaString = JSObjects.getJavaString(OptionHelpers.GetOption(map, Constants.LOCALEMATCHER, OptionHelpers.OptionType.STRING, Constants.LOCALEMATCHER_POSSIBLE_VALUES, Constants.LOCALEMATCHER_BESTFIT));
        String[] strArr = new String[list.size()];
        if (javaString.equals(Constants.LOCALEMATCHER_BESTFIT)) {
            return Arrays.asList(LocaleMatcher.bestFitSupportedLocales((String[]) list.toArray(strArr)));
        }
        return Arrays.asList(LocaleMatcher.lookupSupportedLocales((String[]) list.toArray(strArr)));
    }

    public Map<String, Object> resolvedOptions() throws JSRangeErrorException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("locale", this.mResolvedLocaleObjectForResolvedOptions.toCanonicalTag());
        linkedHashMap.put("numberingSystem", this.mResolvedNumberingSystem);
        linkedHashMap.put(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, this.mResolvedStyle.toString());
        if (this.mResolvedStyle == IPlatformNumberFormatter.Style.CURRENCY) {
            linkedHashMap.put(FirebaseAnalytics.Param.CURRENCY, this.mResolvedCurrency);
            linkedHashMap.put("currencyDisplay", this.mResolvedCurrencyDisplay.toString());
            linkedHashMap.put("currencySign", this.mResolvedCurrencySign.toString());
        } else if (this.mResolvedStyle == IPlatformNumberFormatter.Style.UNIT) {
            linkedHashMap.put("unit", this.mResolvedUnit);
            linkedHashMap.put("unitDisplay", this.mResolvedUnitDisplay.toString());
        }
        int i = this.mResolvedMinimumIntegerDigits;
        if (i != -1) {
            linkedHashMap.put("minimumIntegerDigits", Integer.valueOf(i));
        }
        if (this.mRoundingType == IPlatformNumberFormatter.RoundingType.SIGNIFICANT_DIGITS) {
            int i2 = this.mResolvedMaximumSignificantDigits;
            if (i2 != -1) {
                linkedHashMap.put("minimumSignificantDigits", Integer.valueOf(i2));
            }
            int i3 = this.mResolvedMinimumSignificantDigits;
            if (i3 != -1) {
                linkedHashMap.put("maximumSignificantDigits", Integer.valueOf(i3));
            }
        } else if (this.mRoundingType == IPlatformNumberFormatter.RoundingType.FRACTION_DIGITS) {
            int i4 = this.mResolvedMinimumFractionDigits;
            if (i4 != -1) {
                linkedHashMap.put("minimumFractionDigits", Integer.valueOf(i4));
            }
            int i5 = this.mResolvedMaximumFractionDigits;
            if (i5 != -1) {
                linkedHashMap.put("maximumFractionDigits", Integer.valueOf(i5));
            }
        }
        linkedHashMap.put("useGrouping", Boolean.valueOf(this.mGroupingUsed));
        linkedHashMap.put("notation", this.mResolvedNotation.toString());
        if (this.mResolvedNotation == IPlatformNumberFormatter.Notation.COMPACT) {
            linkedHashMap.put("compactDisplay", this.mResolvedCompactDisplay.toString());
        }
        linkedHashMap.put("signDisplay", this.mResolvedSignDisplay.toString());
        return linkedHashMap;
    }

    public String format(double d) throws JSRangeErrorException {
        return this.mPlatformNumberFormatter.format(d);
    }

    public List<Map<String, String>> formatToParts(double d) throws JSRangeErrorException {
        String strFieldToString;
        ArrayList arrayList = new ArrayList();
        AttributedCharacterIterator toParts = this.mPlatformNumberFormatter.formatToParts(d);
        StringBuilder sb = new StringBuilder();
        for (char cFirst = toParts.first(); cFirst != 65535; cFirst = toParts.next()) {
            sb.append(cFirst);
            if (toParts.getIndex() + 1 == toParts.getRunLimit()) {
                Iterator<AttributedCharacterIterator.Attribute> it = toParts.getAttributes().keySet().iterator();
                if (it.hasNext()) {
                    strFieldToString = this.mPlatformNumberFormatter.fieldToString(it.next(), d);
                } else {
                    strFieldToString = "literal";
                }
                String string = sb.toString();
                sb.setLength(0);
                HashMap map = new HashMap();
                map.put("type", strFieldToString);
                map.put("value", string);
                arrayList.add(map);
            }
        }
        return arrayList;
    }
}
