package expo.modules.adapters.react.views;

/* loaded from: classes5.dex */
public class ViewManagerAdapterUtils {
    public static String normalizeEventName(String str) {
        return str.startsWith("on") ? "top" + str.substring(2) : str;
    }
}
