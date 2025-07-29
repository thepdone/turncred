package expo.modules.rncompatibility;

import android.content.Context;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.style.BoxShadow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RNCompatibleStaticWrapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"parseBoxShadow", "Lcom/facebook/react/uimanager/style/BoxShadow;", ViewProps.BOX_SHADOW, "Lcom/facebook/react/bridge/ReadableMap;", "context", "Landroid/content/Context;", "expo-modules-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RNCompatibleStaticWrapperKt {
    public static final BoxShadow parseBoxShadow(ReadableMap boxShadow, Context context) {
        Intrinsics.checkNotNullParameter(boxShadow, "boxShadow");
        Intrinsics.checkNotNullParameter(context, "context");
        return BoxShadow.INSTANCE.parse(boxShadow);
    }
}
