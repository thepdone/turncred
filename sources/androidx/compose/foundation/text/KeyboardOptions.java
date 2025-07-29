package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeyboardOptions.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 J2\u00020\u0001:\u0001JBQ\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB/\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u0010B;\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0011BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0013J:\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b6\u00107JF\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b8\u00109J^\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b:\u0010;J^\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eø\u0001\u0000¢\u0006\u0004\b:\u0010<J\u0013\u0010=\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0017\u0010?\u001a\u00020\u00002\b\u0010>\u001a\u0004\u0018\u00010\u0000H\u0001¢\u0006\u0002\b@J\b\u0010A\u001a\u00020BH\u0016J\u0010\u0010C\u001a\u00020\u00002\b\u0010>\u001a\u0004\u0018\u00010\u0000J\u0017\u0010D\u001a\u00020E2\b\b\u0002\u0010F\u001a\u00020\u0005H\u0000¢\u0006\u0002\bGJ\b\u0010H\u001a\u00020IH\u0016R\u001a\u0010\u0004\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0017R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020\u00038BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b!\u0010\u001eR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#R\u0019\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b&\u0010\u001eR\u001a\u0010'\u001a\u00020\t8@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b(\u0010\u001eR\u0014\u0010)\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0017R\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b*\u0010\u001eR\u001a\u0010+\u001a\u00020\u00078BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b,\u0010\u001eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0015\u001a\u0004\b1\u0010\u0017R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b2\u0010\u0019R\u0014\u00103\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0017\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006K"}, d2 = {"Landroidx/compose/foundation/text/KeyboardOptions;", "", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "autoCorrect", "", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "platformImeOptions", "Landroidx/compose/ui/text/input/PlatformImeOptions;", "showKeyboardOnFocus", "hintLocales", "Landroidx/compose/ui/text/intl/LocaleList;", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(IZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "autoCorrectEnabled", "(ILjava/lang/Boolean;IILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAutoCorrect$annotations", "()V", "getAutoCorrect", "()Z", "getAutoCorrectEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "autoCorrectOrDefault", "getAutoCorrectOrDefault", "getCapitalization-IUNYP9k", "()I", "I", "capitalizationOrDefault", "getCapitalizationOrDefault-IUNYP9k", "getHintLocales", "()Landroidx/compose/ui/text/intl/LocaleList;", "hintLocalesOrDefault", "getHintLocalesOrDefault", "getImeAction-eUduSuo", "imeActionOrDefault", "getImeActionOrDefault-eUduSuo$foundation_release", "isCompletelyUnspecified", "getKeyboardType-PjHm6EE", "keyboardTypeOrDefault", "getKeyboardTypeOrDefault-PjHm6EE", "getPlatformImeOptions", "()Landroidx/compose/ui/text/input/PlatformImeOptions;", "shouldShowKeyboardOnFocus", "getShouldShowKeyboardOnFocus$annotations", "getShouldShowKeyboardOnFocus", "getShowKeyboardOnFocus", "showKeyboardOnFocusOrDefault", "getShowKeyboardOnFocusOrDefault$foundation_release", "copy", "copy-3m2b7yw", "(IZII)Landroidx/compose/foundation/text/KeyboardOptions;", "copy-ij11fho", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;)Landroidx/compose/foundation/text/KeyboardOptions;", "copy-INvB4aQ", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/foundation/text/KeyboardOptions;", "(ILjava/lang/Boolean;IILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/foundation/text/KeyboardOptions;", "equals", "other", "fillUnspecifiedValuesWith", "fillUnspecifiedValuesWith$foundation_release", "hashCode", "", "merge", "toImeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "singleLine", "toImeOptions$foundation_release", InAppPurchaseConstants.METHOD_TO_STRING, "", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class KeyboardOptions {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KeyboardOptions Default = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
    private static final KeyboardOptions SecureTextField = new KeyboardOptions(0, (Boolean) false, KeyboardType.INSTANCE.m4459getPasswordPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 121, (DefaultConstructorMarker) null);
    private final Boolean autoCorrectEnabled;
    private final int capitalization;
    private final LocaleList hintLocales;
    private final int imeAction;
    private final int keyboardType;
    private final PlatformImeOptions platformImeOptions;
    private final Boolean showKeyboardOnFocus;

    public /* synthetic */ KeyboardOptions(int i, Boolean bool, int i2, int i3, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, bool, i2, i3, platformImeOptions, bool2, localeList);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Please use the new constructor that takes optional autoCorrectEnabled parameter.", replaceWith = @ReplaceWith(expression = "KeyboardOptions(capitalization = capitalization, autoCorrectEnabled = autoCorrect, keyboardType = keyboardType, imeAction = imeAction,platformImeOptions = platformImeOptions, showKeyboardOnFocus = showKeyboardOnFocus,hintLocales = hintLocales)", imports = {}))
    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions, Boolean bool, LocaleList localeList, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, i2, i3, platformImeOptions, bool, localeList);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compat")
    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, i2, i3, platformImeOptions);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new constructor that takes optional platformImeOptions parameter.")
    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, i2, i3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Please use the autoCorrectEnabled property.")
    public static /* synthetic */ void getAutoCorrect$annotations() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Included for binary compatibility. Use showKeyboardOnFocus.")
    public static /* synthetic */ void getShouldShowKeyboardOnFocus$annotations() {
    }

    private KeyboardOptions(int i, Boolean bool, int i2, int i3, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList) {
        this.capitalization = i;
        this.autoCorrectEnabled = bool;
        this.keyboardType = i2;
        this.imeAction = i3;
        this.platformImeOptions = platformImeOptions;
        this.showKeyboardOnFocus = bool2;
        this.hintLocales = localeList;
    }

    public /* synthetic */ KeyboardOptions(int i, Boolean bool, int i2, int i3, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? KeyboardCapitalization.INSTANCE.m4435getUnspecifiedIUNYP9k() : i, (i4 & 2) != 0 ? null : bool, (i4 & 4) != 0 ? KeyboardType.INSTANCE.m4462getUnspecifiedPjHm6EE() : i2, (i4 & 8) != 0 ? ImeAction.INSTANCE.m4408getUnspecifiedeUduSuo() : i3, (i4 & 16) != 0 ? null : platformImeOptions, (i4 & 32) != 0 ? null : bool2, (i4 & 64) == 0 ? localeList : null, (DefaultConstructorMarker) null);
    }

    /* renamed from: getCapitalization-IUNYP9k, reason: not valid java name and from getter */
    public final int getCapitalization() {
        return this.capitalization;
    }

    public final Boolean getAutoCorrectEnabled() {
        return this.autoCorrectEnabled;
    }

    /* renamed from: getKeyboardType-PjHm6EE, reason: not valid java name and from getter */
    public final int getKeyboardType() {
        return this.keyboardType;
    }

    /* renamed from: getImeAction-eUduSuo, reason: not valid java name and from getter */
    public final int getImeAction() {
        return this.imeAction;
    }

    public final PlatformImeOptions getPlatformImeOptions() {
        return this.platformImeOptions;
    }

    public final Boolean getShowKeyboardOnFocus() {
        return this.showKeyboardOnFocus;
    }

    public final LocaleList getHintLocales() {
        return this.hintLocales;
    }

    /* compiled from: KeyboardOptions.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/text/KeyboardOptions$Companion;", "", "()V", "Default", "Landroidx/compose/foundation/text/KeyboardOptions;", "getDefault$annotations", "getDefault", "()Landroidx/compose/foundation/text/KeyboardOptions;", "SecureTextField", "getSecureTextField$foundation_release$annotations", "getSecureTextField$foundation_release", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDefault$annotations() {
        }

        public static /* synthetic */ void getSecureTextField$foundation_release$annotations() {
        }

        private Companion() {
        }

        public final KeyboardOptions getDefault() {
            return KeyboardOptions.Default;
        }

        public final KeyboardOptions getSecureTextField$foundation_release() {
            return KeyboardOptions.SecureTextField;
        }
    }

    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions, Boolean bool, LocaleList localeList, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? KeyboardCapitalization.INSTANCE.m4435getUnspecifiedIUNYP9k() : i, z, (i4 & 4) != 0 ? KeyboardType.INSTANCE.m4462getUnspecifiedPjHm6EE() : i2, (i4 & 8) != 0 ? ImeAction.INSTANCE.m4408getUnspecifiedeUduSuo() : i3, (i4 & 16) != 0 ? null : platformImeOptions, (i4 & 32) != 0 ? null : bool, (i4 & 64) != 0 ? null : localeList, (DefaultConstructorMarker) null);
    }

    private KeyboardOptions(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions, Boolean bool, LocaleList localeList) {
        this(i, Boolean.valueOf(z), i2, i3, platformImeOptions, bool, localeList, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? KeyboardCapitalization.INSTANCE.m4435getUnspecifiedIUNYP9k() : i, (i4 & 2) != 0 ? Default.getAutoCorrectOrDefault() : z, (i4 & 4) != 0 ? KeyboardType.INSTANCE.m4462getUnspecifiedPjHm6EE() : i2, (i4 & 8) != 0 ? ImeAction.INSTANCE.m4400getDefaulteUduSuo() : i3, (DefaultConstructorMarker) null);
    }

    private KeyboardOptions(int i, boolean z, int i2, int i3) {
        this(i, Boolean.valueOf(z), i2, i3, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 96, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ KeyboardOptions(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? KeyboardCapitalization.INSTANCE.m4433getNoneIUNYP9k() : i, (i4 & 2) != 0 ? Default.getAutoCorrectOrDefault() : z, (i4 & 4) != 0 ? KeyboardType.INSTANCE.m4461getTextPjHm6EE() : i2, (i4 & 8) != 0 ? ImeAction.INSTANCE.m4400getDefaulteUduSuo() : i3, (i4 & 16) != 0 ? null : platformImeOptions, (DefaultConstructorMarker) null);
    }

    private KeyboardOptions(int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions) {
        this(i, Boolean.valueOf(z), i2, i3, platformImeOptions, Boolean.valueOf(Default.getShowKeyboardOnFocusOrDefault$foundation_release()), (LocaleList) null, 64, (DefaultConstructorMarker) null);
    }

    public final boolean getAutoCorrect() {
        return getAutoCorrectOrDefault();
    }

    public final /* synthetic */ boolean getShouldShowKeyboardOnFocus() {
        Boolean bool = this.showKeyboardOnFocus;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private final boolean getAutoCorrectOrDefault() {
        Boolean bool = this.autoCorrectEnabled;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    /* renamed from: getCapitalizationOrDefault-IUNYP9k, reason: not valid java name */
    private final int m1325getCapitalizationOrDefaultIUNYP9k() {
        KeyboardCapitalization keyboardCapitalizationM4420boximpl = KeyboardCapitalization.m4420boximpl(this.capitalization);
        if (KeyboardCapitalization.m4423equalsimpl0(keyboardCapitalizationM4420boximpl.getValue(), KeyboardCapitalization.INSTANCE.m4435getUnspecifiedIUNYP9k())) {
            keyboardCapitalizationM4420boximpl = null;
        }
        return keyboardCapitalizationM4420boximpl != null ? keyboardCapitalizationM4420boximpl.getValue() : KeyboardCapitalization.INSTANCE.m4433getNoneIUNYP9k();
    }

    /* renamed from: getKeyboardTypeOrDefault-PjHm6EE, reason: not valid java name */
    private final int m1326getKeyboardTypeOrDefaultPjHm6EE() {
        KeyboardType keyboardTypeM4437boximpl = KeyboardType.m4437boximpl(this.keyboardType);
        if (KeyboardType.m4440equalsimpl0(keyboardTypeM4437boximpl.getValue(), KeyboardType.INSTANCE.m4462getUnspecifiedPjHm6EE())) {
            keyboardTypeM4437boximpl = null;
        }
        return keyboardTypeM4437boximpl != null ? keyboardTypeM4437boximpl.getValue() : KeyboardType.INSTANCE.m4461getTextPjHm6EE();
    }

    /* renamed from: getImeActionOrDefault-eUduSuo$foundation_release, reason: not valid java name */
    public final int m1333getImeActionOrDefaulteUduSuo$foundation_release() {
        ImeAction imeActionM4384boximpl = ImeAction.m4384boximpl(this.imeAction);
        if (ImeAction.m4387equalsimpl0(imeActionM4384boximpl.getValue(), ImeAction.INSTANCE.m4408getUnspecifiedeUduSuo())) {
            imeActionM4384boximpl = null;
        }
        return imeActionM4384boximpl != null ? imeActionM4384boximpl.getValue() : ImeAction.INSTANCE.m4400getDefaulteUduSuo();
    }

    public final boolean getShowKeyboardOnFocusOrDefault$foundation_release() {
        Boolean bool = this.showKeyboardOnFocus;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private final LocaleList getHintLocalesOrDefault() {
        LocaleList localeList = this.hintLocales;
        return localeList == null ? LocaleList.INSTANCE.getEmpty() : localeList;
    }

    private final boolean isCompletelyUnspecified() {
        return KeyboardCapitalization.m4423equalsimpl0(this.capitalization, KeyboardCapitalization.INSTANCE.m4435getUnspecifiedIUNYP9k()) && this.autoCorrectEnabled == null && KeyboardType.m4440equalsimpl0(this.keyboardType, KeyboardType.INSTANCE.m4462getUnspecifiedPjHm6EE()) && ImeAction.m4387equalsimpl0(this.imeAction, ImeAction.INSTANCE.m4408getUnspecifiedeUduSuo()) && this.platformImeOptions == null && this.showKeyboardOnFocus == null && this.hintLocales == null;
    }

    public static /* synthetic */ ImeOptions toImeOptions$foundation_release$default(KeyboardOptions keyboardOptions, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = ImeOptions.INSTANCE.getDefault().getSingleLine();
        }
        return keyboardOptions.toImeOptions$foundation_release(z);
    }

    public final ImeOptions toImeOptions$foundation_release(boolean singleLine) {
        return new ImeOptions(singleLine, m1325getCapitalizationOrDefaultIUNYP9k(), getAutoCorrectOrDefault(), m1326getKeyboardTypeOrDefaultPjHm6EE(), m1333getImeActionOrDefaulteUduSuo$foundation_release(), this.platformImeOptions, getHintLocalesOrDefault(), (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-INvB4aQ$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1322copyINvB4aQ$default(KeyboardOptions keyboardOptions, int i, Boolean bool, int i2, int i3, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = keyboardOptions.capitalization;
        }
        if ((i4 & 2) != 0) {
            bool = keyboardOptions.autoCorrectEnabled;
        }
        Boolean bool3 = bool;
        if ((i4 & 4) != 0) {
            i2 = keyboardOptions.keyboardType;
        }
        int i5 = i2;
        if ((i4 & 8) != 0) {
            i3 = keyboardOptions.imeAction;
        }
        int i6 = i3;
        if ((i4 & 16) != 0) {
            platformImeOptions = keyboardOptions.platformImeOptions;
        }
        return keyboardOptions.m1328copyINvB4aQ(i, bool3, i5, i6, platformImeOptions, (i4 & 32) != 0 ? null : bool2, (i4 & 64) != 0 ? null : localeList);
    }

    /* renamed from: copy-INvB4aQ, reason: not valid java name */
    public final KeyboardOptions m1328copyINvB4aQ(int capitalization, Boolean autoCorrectEnabled, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions, Boolean showKeyboardOnFocus, LocaleList hintLocales) {
        return new KeyboardOptions(capitalization, autoCorrectEnabled, keyboardType, imeAction, platformImeOptions, showKeyboardOnFocus, hintLocales, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-INvB4aQ$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1323copyINvB4aQ$default(KeyboardOptions keyboardOptions, int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions, Boolean bool, LocaleList localeList, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = keyboardOptions.capitalization;
        }
        if ((i4 & 2) != 0) {
            z = keyboardOptions.getAutoCorrectOrDefault();
        }
        boolean z2 = z;
        if ((i4 & 4) != 0) {
            i2 = keyboardOptions.keyboardType;
        }
        int i5 = i2;
        if ((i4 & 8) != 0) {
            i3 = keyboardOptions.imeAction;
        }
        int i6 = i3;
        if ((i4 & 16) != 0) {
            platformImeOptions = keyboardOptions.platformImeOptions;
        }
        PlatformImeOptions platformImeOptions2 = platformImeOptions;
        if ((i4 & 32) != 0) {
            bool = Boolean.valueOf(keyboardOptions.getShowKeyboardOnFocusOrDefault$foundation_release());
        }
        Boolean bool2 = bool;
        if ((i4 & 64) != 0) {
            localeList = keyboardOptions.hintLocales;
        }
        return keyboardOptions.m1329copyINvB4aQ(i, z2, i5, i6, platformImeOptions2, bool2, localeList);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the copy function that takes an autoCorrectEnabled parameter.", replaceWith = @ReplaceWith(expression = "copy(capitalization = capitalization, autoCorrectEnabled = autoCorrect, keyboardType = keyboardType, imeAction = imeAction,platformImeOptions = platformImeOptions, showKeyboardOnFocus = showKeyboardOnFocus ?: true,hintLocales = hintLocales)", imports = {}))
    /* renamed from: copy-INvB4aQ, reason: not valid java name */
    public final /* synthetic */ KeyboardOptions m1329copyINvB4aQ(int capitalization, boolean autoCorrect, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions, Boolean showKeyboardOnFocus, LocaleList hintLocales) {
        return new KeyboardOptions(capitalization, Boolean.valueOf(autoCorrect), keyboardType, imeAction, platformImeOptions, showKeyboardOnFocus, hintLocales, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-ij11fho$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1324copyij11fho$default(KeyboardOptions keyboardOptions, int i, boolean z, int i2, int i3, PlatformImeOptions platformImeOptions, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = keyboardOptions.capitalization;
        }
        if ((i4 & 2) != 0) {
            z = keyboardOptions.getAutoCorrectOrDefault();
        }
        boolean z2 = z;
        if ((i4 & 4) != 0) {
            i2 = keyboardOptions.keyboardType;
        }
        int i5 = i2;
        if ((i4 & 8) != 0) {
            i3 = keyboardOptions.imeAction;
        }
        int i6 = i3;
        if ((i4 & 16) != 0) {
            platformImeOptions = keyboardOptions.platformImeOptions;
        }
        return keyboardOptions.m1330copyij11fho(i, z2, i5, i6, platformImeOptions);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: copy-ij11fho, reason: not valid java name */
    public final /* synthetic */ KeyboardOptions m1330copyij11fho(int capitalization, boolean autoCorrect, int keyboardType, int imeAction, PlatformImeOptions platformImeOptions) {
        return new KeyboardOptions(capitalization, Boolean.valueOf(autoCorrect), keyboardType, imeAction, platformImeOptions, this.showKeyboardOnFocus, this.hintLocales, (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-3m2b7yw$default, reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m1321copy3m2b7yw$default(KeyboardOptions keyboardOptions, int i, boolean z, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = keyboardOptions.capitalization;
        }
        if ((i4 & 2) != 0) {
            z = keyboardOptions.getAutoCorrectOrDefault();
        }
        if ((i4 & 4) != 0) {
            i2 = keyboardOptions.keyboardType;
        }
        if ((i4 & 8) != 0) {
            i3 = keyboardOptions.imeAction;
        }
        return keyboardOptions.m1327copy3m2b7yw(i, z, i2, i3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the new copy function that takes optional platformImeOptions parameter.")
    /* renamed from: copy-3m2b7yw, reason: not valid java name */
    public final /* synthetic */ KeyboardOptions m1327copy3m2b7yw(int capitalization, boolean autoCorrect, int keyboardType, int imeAction) {
        return new KeyboardOptions(capitalization, Boolean.valueOf(autoCorrect), keyboardType, imeAction, this.platformImeOptions, this.showKeyboardOnFocus, this.hintLocales, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyboardOptions)) {
            return false;
        }
        KeyboardOptions keyboardOptions = (KeyboardOptions) other;
        return KeyboardCapitalization.m4423equalsimpl0(this.capitalization, keyboardOptions.capitalization) && Intrinsics.areEqual(this.autoCorrectEnabled, keyboardOptions.autoCorrectEnabled) && KeyboardType.m4440equalsimpl0(this.keyboardType, keyboardOptions.keyboardType) && ImeAction.m4387equalsimpl0(this.imeAction, keyboardOptions.imeAction) && Intrinsics.areEqual(this.platformImeOptions, keyboardOptions.platformImeOptions) && Intrinsics.areEqual(this.showKeyboardOnFocus, keyboardOptions.showKeyboardOnFocus) && Intrinsics.areEqual(this.hintLocales, keyboardOptions.hintLocales);
    }

    public int hashCode() {
        int iM4424hashCodeimpl = KeyboardCapitalization.m4424hashCodeimpl(this.capitalization) * 31;
        Boolean bool = this.autoCorrectEnabled;
        int iHashCode = (((((iM4424hashCodeimpl + (bool != null ? bool.hashCode() : 0)) * 31) + KeyboardType.m4441hashCodeimpl(this.keyboardType)) * 31) + ImeAction.m4388hashCodeimpl(this.imeAction)) * 31;
        PlatformImeOptions platformImeOptions = this.platformImeOptions;
        int iHashCode2 = (iHashCode + (platformImeOptions != null ? platformImeOptions.hashCode() : 0)) * 31;
        Boolean bool2 = this.showKeyboardOnFocus;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        LocaleList localeList = this.hintLocales;
        return iHashCode3 + (localeList != null ? localeList.hashCode() : 0);
    }

    public String toString() {
        return "KeyboardOptions(capitalization=" + ((Object) KeyboardCapitalization.m4425toStringimpl(this.capitalization)) + ", autoCorrectEnabled=" + this.autoCorrectEnabled + ", keyboardType=" + ((Object) KeyboardType.m4442toStringimpl(this.keyboardType)) + ", imeAction=" + ((Object) ImeAction.m4389toStringimpl(this.imeAction)) + ", platformImeOptions=" + this.platformImeOptions + "showKeyboardOnFocus=" + this.showKeyboardOnFocus + ", hintLocales=" + this.hintLocales + ')';
    }

    public final KeyboardOptions merge(KeyboardOptions other) {
        KeyboardOptions keyboardOptionsFillUnspecifiedValuesWith$foundation_release;
        return (other == null || (keyboardOptionsFillUnspecifiedValuesWith$foundation_release = other.fillUnspecifiedValuesWith$foundation_release(this)) == null) ? this : keyboardOptionsFillUnspecifiedValuesWith$foundation_release;
    }

    public final KeyboardOptions fillUnspecifiedValuesWith$foundation_release(KeyboardOptions other) {
        int value;
        int value2;
        int value3;
        if (other == null || other.isCompletelyUnspecified() || Intrinsics.areEqual(other, this)) {
            return this;
        }
        if (isCompletelyUnspecified()) {
            return other;
        }
        KeyboardCapitalization keyboardCapitalizationM4420boximpl = KeyboardCapitalization.m4420boximpl(this.capitalization);
        if (KeyboardCapitalization.m4423equalsimpl0(keyboardCapitalizationM4420boximpl.getValue(), KeyboardCapitalization.INSTANCE.m4435getUnspecifiedIUNYP9k())) {
            keyboardCapitalizationM4420boximpl = null;
        }
        if (keyboardCapitalizationM4420boximpl != null) {
            value = keyboardCapitalizationM4420boximpl.getValue();
        } else {
            value = other.capitalization;
        }
        int i = value;
        Boolean bool = this.autoCorrectEnabled;
        if (bool == null) {
            bool = other.autoCorrectEnabled;
        }
        Boolean bool2 = bool;
        KeyboardType keyboardTypeM4437boximpl = KeyboardType.m4437boximpl(this.keyboardType);
        if (KeyboardType.m4440equalsimpl0(keyboardTypeM4437boximpl.getValue(), KeyboardType.INSTANCE.m4462getUnspecifiedPjHm6EE())) {
            keyboardTypeM4437boximpl = null;
        }
        if (keyboardTypeM4437boximpl != null) {
            value2 = keyboardTypeM4437boximpl.getValue();
        } else {
            value2 = other.keyboardType;
        }
        int i2 = value2;
        ImeAction imeActionM4384boximpl = ImeAction.m4384boximpl(this.imeAction);
        ImeAction imeAction = ImeAction.m4387equalsimpl0(imeActionM4384boximpl.getValue(), ImeAction.INSTANCE.m4408getUnspecifiedeUduSuo()) ? null : imeActionM4384boximpl;
        if (imeAction != null) {
            value3 = imeAction.getValue();
        } else {
            value3 = other.imeAction;
        }
        int i3 = value3;
        PlatformImeOptions platformImeOptions = this.platformImeOptions;
        if (platformImeOptions == null) {
            platformImeOptions = other.platformImeOptions;
        }
        PlatformImeOptions platformImeOptions2 = platformImeOptions;
        Boolean bool3 = this.showKeyboardOnFocus;
        if (bool3 == null) {
            bool3 = other.showKeyboardOnFocus;
        }
        Boolean bool4 = bool3;
        LocaleList localeList = this.hintLocales;
        return new KeyboardOptions(i, bool2, i2, i3, platformImeOptions2, bool4, localeList == null ? other.hintLocales : localeList, (DefaultConstructorMarker) null);
    }
}
