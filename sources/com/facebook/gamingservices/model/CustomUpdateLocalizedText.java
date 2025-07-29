package com.facebook.gamingservices.model;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.hermes.intl.Constants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CustomUpdateContent.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J+\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/facebook/gamingservices/model/CustomUpdateLocalizedText;", "", Constants.COLLATION_DEFAULT, "", "localizations", "Ljava/util/HashMap;", "(Ljava/lang/String;Ljava/util/HashMap;)V", "getDefault", "()Ljava/lang/String;", "getLocalizations", "()Ljava/util/HashMap;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJSONObject", "Lorg/json/JSONObject;", InAppPurchaseConstants.METHOD_TO_STRING, "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CustomUpdateLocalizedText {
    private final String default;
    private final HashMap<String, String> localizations;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomUpdateLocalizedText copy$default(CustomUpdateLocalizedText customUpdateLocalizedText, String str, HashMap map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = customUpdateLocalizedText.default;
        }
        if ((i & 2) != 0) {
            map = customUpdateLocalizedText.localizations;
        }
        return customUpdateLocalizedText.copy(str, map);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDefault() {
        return this.default;
    }

    public final HashMap<String, String> component2() {
        return this.localizations;
    }

    public final CustomUpdateLocalizedText copy(String str, HashMap<String, String> localizations) {
        Intrinsics.checkNotNullParameter(str, "default");
        return new CustomUpdateLocalizedText(str, localizations);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomUpdateLocalizedText)) {
            return false;
        }
        CustomUpdateLocalizedText customUpdateLocalizedText = (CustomUpdateLocalizedText) other;
        return Intrinsics.areEqual(this.default, customUpdateLocalizedText.default) && Intrinsics.areEqual(this.localizations, customUpdateLocalizedText.localizations);
    }

    public int hashCode() {
        int iHashCode = this.default.hashCode() * 31;
        HashMap<String, String> map = this.localizations;
        return iHashCode + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        return "CustomUpdateLocalizedText(default=" + this.default + ", localizations=" + this.localizations + ')';
    }

    public CustomUpdateLocalizedText(String str, HashMap<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "default");
        this.default = str;
        this.localizations = map;
    }

    public /* synthetic */ CustomUpdateLocalizedText(String str, HashMap map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : map);
    }

    public final String getDefault() {
        return this.default;
    }

    public final HashMap<String, String> getLocalizations() {
        return this.localizations;
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.COLLATION_DEFAULT, this.default);
        HashMap<String, String> map = this.localizations;
        if (map != null) {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("localizations", jSONObject2);
        }
        return jSONObject;
    }
}
