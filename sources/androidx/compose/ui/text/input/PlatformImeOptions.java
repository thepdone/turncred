package androidx.compose.ui.text.input;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformImeOptions.android.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/input/PlatformImeOptions;", "", "privateImeOptions", "", "(Ljava/lang/String;)V", "getPrivateImeOptions", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PlatformImeOptions {
    public static final int $stable = 0;
    private final String privateImeOptions;

    public PlatformImeOptions() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public PlatformImeOptions(String str) {
        this.privateImeOptions = str;
    }

    public /* synthetic */ PlatformImeOptions(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getPrivateImeOptions() {
        return this.privateImeOptions;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PlatformImeOptions) && Intrinsics.areEqual(this.privateImeOptions, ((PlatformImeOptions) other).privateImeOptions);
    }

    public int hashCode() {
        String str = this.privateImeOptions;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "PlatformImeOptions(privateImeOptions=" + this.privateImeOptions + ')';
    }
}
