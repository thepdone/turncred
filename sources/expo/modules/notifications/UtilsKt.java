package expo.modules.notifications;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import expo.modules.kotlin.types.JSTypeConverter;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\u001aP\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2<\u0010\r\u001a8\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000ej\u0002`\u0013H\u0000\u001a\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0000\u001a7\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022%\u0010\u0015\u001a!\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007H\u0000\u001a\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0000\"3\u0010\u0000\u001a!\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0000\u0010\b*@\u0010\u0019\"\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001*n\u0010\u001a\"4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000e24\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000e¨\u0006\u001b"}, d2 = {"isBundleConvertibleToJSValue", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lkotlin/ParameterName;", "name", "bundle", "", "Lexpo/modules/notifications/BundleConversionTester;", "()Lkotlin/jvm/functions/Function1;", "createDefaultResultReceiver", "Landroid/os/ResultReceiver;", "handler", "Landroid/os/Handler;", "body", "Lkotlin/Function2;", "", "resultCode", "resultData", "", "Lexpo/modules/notifications/ResultReceiverBody;", "filteredBundleForJSTypeConverter", "testBundle", "isValidJSONString", "test", "", "BundleConversionTester", "ResultReceiverBody", "expo-notifications_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UtilsKt {
    private static final Function1<Bundle, Boolean> isBundleConvertibleToJSValue = new Function1<Bundle, Boolean>() { // from class: expo.modules.notifications.UtilsKt.isBundleConvertibleToJSValue.1
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Bundle bundle) {
            boolean z;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            try {
                JSTypeConverter.convertToJSValue$default(JSTypeConverter.INSTANCE, bundle, null, false, 6, null);
                z = true;
            } catch (Throwable unused) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    };

    public static final ResultReceiver createDefaultResultReceiver(Handler handler, final Function2<? super Integer, ? super Bundle, Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return new ResultReceiver(handler) { // from class: expo.modules.notifications.UtilsKt.createDefaultResultReceiver.1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, Bundle resultData) {
                super.onReceiveResult(resultCode, resultData);
                body.invoke(Integer.valueOf(resultCode), resultData);
            }
        };
    }

    public static final Bundle filteredBundleForJSTypeConverter(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        return filteredBundleForJSTypeConverter(bundle, isBundleConvertibleToJSValue);
    }

    public static final Bundle filteredBundleForJSTypeConverter(Bundle bundle, Function1<? super Bundle, Boolean> testBundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(testBundle, "testBundle");
        if (testBundle.invoke(bundle).booleanValue()) {
            return bundle;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Set<String> setKeySet = bundle.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "keySet(...)");
        for (String str : setKeySet) {
            Object obj = bundle.get(str);
            if (obj instanceof Bundle) {
                bundle.putBundle(str, filteredBundleForJSTypeConverter((Bundle) obj, testBundle));
                linkedHashSet.add(str);
            }
        }
        Set<String> setKeySet2 = bundle.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet2, "keySet(...)");
        for (String str2 : setKeySet2) {
            if (!linkedHashSet.contains(str2)) {
                Bundle bundle2 = new Bundle();
                bundle2.putAll(bundle);
                Set<String> setKeySet3 = bundle.keySet();
                Intrinsics.checkNotNullExpressionValue(setKeySet3, "keySet(...)");
                for (String str3 : setKeySet3) {
                    if (!str3.equals(str2)) {
                        bundle2.remove(str3);
                    }
                }
                if (testBundle.invoke(bundle2).booleanValue()) {
                    linkedHashSet.add(str2);
                }
            }
        }
        Bundle bundle3 = new Bundle();
        bundle3.putAll(bundle);
        Set<String> setKeySet4 = bundle.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet4, "keySet(...)");
        for (String str4 : setKeySet4) {
            if (!linkedHashSet.contains(str4)) {
                bundle3.remove(str4);
            }
        }
        return bundle3;
    }

    public static final Function1<Bundle, Boolean> isBundleConvertibleToJSValue() {
        return isBundleConvertibleToJSValue;
    }

    public static final boolean isValidJSONString(Object obj) {
        if (obj instanceof String) {
            try {
                try {
                    new JSONObject((String) obj);
                    return true;
                } catch (JSONException unused) {
                    new JSONArray((String) obj);
                    return true;
                }
            } catch (JSONException unused2) {
            }
        }
        return false;
    }
}
