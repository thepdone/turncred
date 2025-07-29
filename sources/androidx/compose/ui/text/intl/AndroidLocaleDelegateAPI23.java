package androidx.compose.ui.text.intl;

import android.util.Log;
import io.sentry.protocol.SentryThread;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidLocaleDelegate.android.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u00060\bj\u0002`\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Landroidx/compose/ui/text/intl/AndroidLocaleDelegateAPI23;", "Landroidx/compose/ui/text/intl/PlatformLocaleDelegate;", "()V", SentryThread.JsonKeys.CURRENT, "Landroidx/compose/ui/text/intl/LocaleList;", "getCurrent", "()Landroidx/compose/ui/text/intl/LocaleList;", "parseLanguageTag", "Ljava/util/Locale;", "Landroidx/compose/ui/text/intl/PlatformLocale;", "languageTag", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AndroidLocaleDelegateAPI23 implements PlatformLocaleDelegate {
    public static final int $stable = 0;

    @Override // androidx.compose.ui.text.intl.PlatformLocaleDelegate
    public LocaleList getCurrent() {
        return new LocaleList((List<Locale>) CollectionsKt.listOf(new Locale(java.util.Locale.getDefault())));
    }

    @Override // androidx.compose.ui.text.intl.PlatformLocaleDelegate
    public java.util.Locale parseLanguageTag(String languageTag) {
        java.util.Locale localeForLanguageTag = java.util.Locale.forLanguageTag(languageTag);
        if (Intrinsics.areEqual(localeForLanguageTag.toLanguageTag(), "und")) {
            Log.e(AndroidLocaleDelegate_androidKt.TAG, "The language tag " + languageTag + " is not well-formed. Locale is resolved to Undetermined. Note that underscore '_' is not a valid subtags delimiter and must be replaced with '-'.");
        }
        return localeForLanguageTag;
    }
}
