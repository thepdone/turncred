package com.facebook.hermes.unicode;

import com.facebook.react.uimanager.ViewProps;
import java.text.Collator;
import java.text.DateFormat;
import java.text.Normalizer;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidUnicodeUtils.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J \u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0007J\u001c\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0007J\u001a\u0010\u0018\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/facebook/hermes/unicode/AndroidUnicodeUtils;", "", "()V", "FORM_C", "", "FORM_D", "FORM_KC", "FORM_KD", "TARGET_LOWERCASE", "TARGET_UPPERCASE", "convertToCase", "", "input", "targetCase", "useCurrentLocale", "", "dateFormat", "unixtimeMs", "", "formatDate", "formatTime", "localeCompare", "left", ViewProps.RIGHT, "normalize", "form", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AndroidUnicodeUtils {
    private static final int FORM_C = 0;
    private static final int FORM_D = 1;
    private static final int FORM_KC = 2;
    private static final int FORM_KD = 3;
    public static final AndroidUnicodeUtils INSTANCE = new AndroidUnicodeUtils();
    private static final int TARGET_LOWERCASE = 1;
    private static final int TARGET_UPPERCASE = 0;

    private AndroidUnicodeUtils() {
    }

    @JvmStatic
    public static final int localeCompare(String left, String right) {
        return Collator.getInstance().compare(left, right);
    }

    @JvmStatic
    public static final String dateFormat(double unixtimeMs, boolean formatDate, boolean formatTime) {
        DateFormat timeInstance;
        if (formatDate && formatTime) {
            timeInstance = DateFormat.getDateTimeInstance(2, 2);
        } else if (formatDate) {
            timeInstance = DateFormat.getDateInstance(2);
        } else if (formatTime) {
            timeInstance = DateFormat.getTimeInstance(2);
        } else {
            throw new IllegalStateException("Bad dateFormat configuration".toString());
        }
        return timeInstance.format(Long.valueOf((long) unixtimeMs)).toString();
    }

    @JvmStatic
    public static final String convertToCase(String input, int targetCase, boolean useCurrentLocale) {
        Intrinsics.checkNotNullParameter(input, "input");
        Locale locale = useCurrentLocale ? Locale.getDefault() : Locale.ENGLISH;
        if (targetCase == 0) {
            Intrinsics.checkNotNull(locale);
            String upperCase = input.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return upperCase;
        }
        if (targetCase == 1) {
            Intrinsics.checkNotNull(locale);
            String lowerCase = input.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return lowerCase;
        }
        throw new IllegalStateException("Invalid target case".toString());
    }

    @JvmStatic
    public static final String normalize(String input, int form) {
        if (form == 0) {
            String strNormalize = Normalizer.normalize(input, Normalizer.Form.NFC);
            Intrinsics.checkNotNullExpressionValue(strNormalize, "normalize(...)");
            return strNormalize;
        }
        if (form == 1) {
            String strNormalize2 = Normalizer.normalize(input, Normalizer.Form.NFD);
            Intrinsics.checkNotNullExpressionValue(strNormalize2, "normalize(...)");
            return strNormalize2;
        }
        if (form == 2) {
            String strNormalize3 = Normalizer.normalize(input, Normalizer.Form.NFKC);
            Intrinsics.checkNotNullExpressionValue(strNormalize3, "normalize(...)");
            return strNormalize3;
        }
        if (form == 3) {
            String strNormalize4 = Normalizer.normalize(input, Normalizer.Form.NFKD);
            Intrinsics.checkNotNullExpressionValue(strNormalize4, "normalize(...)");
            return strNormalize4;
        }
        throw new IllegalStateException("Invalid form".toString());
    }
}
