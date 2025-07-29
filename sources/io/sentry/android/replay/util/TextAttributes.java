package io.sentry.android.replay.util;

import androidx.compose.ui.graphics.Color;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Nodes.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001a\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\fJ\t\u0010\r\u001a\u00020\u0005HÆ\u0003J*\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u000fJ\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Lio/sentry/android/replay/util/TextAttributes;", "", ViewProps.COLOR, "Landroidx/compose/ui/graphics/Color;", "hasFillModifier", "", "(Landroidx/compose/ui/graphics/Color;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-QN2ZGVo", "()Landroidx/compose/ui/graphics/Color;", "getHasFillModifier", "()Z", "component1", "component1-QN2ZGVo", "component2", "copy", "copy-fRWUv9g", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "sentry-android-replay_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TextAttributes {
    private final Color color;
    private final boolean hasFillModifier;

    public /* synthetic */ TextAttributes(Color color, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(color, z);
    }

    /* renamed from: copy-fRWUv9g$default, reason: not valid java name */
    public static /* synthetic */ TextAttributes m5901copyfRWUv9g$default(TextAttributes textAttributes, Color color, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            color = textAttributes.color;
        }
        if ((i & 2) != 0) {
            z = textAttributes.hasFillModifier;
        }
        return textAttributes.m5903copyfRWUv9g(color, z);
    }

    /* renamed from: component1-QN2ZGVo, reason: not valid java name and from getter */
    public final Color getColor() {
        return this.color;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getHasFillModifier() {
        return this.hasFillModifier;
    }

    /* renamed from: copy-fRWUv9g, reason: not valid java name */
    public final TextAttributes m5903copyfRWUv9g(Color color, boolean hasFillModifier) {
        return new TextAttributes(color, hasFillModifier, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextAttributes)) {
            return false;
        }
        TextAttributes textAttributes = (TextAttributes) other;
        return Intrinsics.areEqual(this.color, textAttributes.color) && this.hasFillModifier == textAttributes.hasFillModifier;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Color color = this.color;
        int iM2283hashCodeimpl = (color == null ? 0 : Color.m2283hashCodeimpl(color.m2286unboximpl())) * 31;
        boolean z = this.hasFillModifier;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iM2283hashCodeimpl + i;
    }

    public String toString() {
        return "TextAttributes(color=" + this.color + ", hasFillModifier=" + this.hasFillModifier + ')';
    }

    private TextAttributes(Color color, boolean z) {
        this.color = color;
        this.hasFillModifier = z;
    }

    /* renamed from: getColor-QN2ZGVo, reason: not valid java name */
    public final Color m5904getColorQN2ZGVo() {
        return this.color;
    }

    public final boolean getHasFillModifier() {
        return this.hasFillModifier;
    }
}
