package androidx.compose.foundation.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* compiled from: WindowInsets.android.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010#\u001a\u00020\u0003H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016J\u001d\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0003H\u0000¢\u0006\u0002\b*R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00108F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006+"}, d2 = {"Landroidx/compose/foundation/layout/AndroidWindowInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "type", "", "name", "", "(ILjava/lang/String;)V", "<set-?>", "Landroidx/core/graphics/Insets;", "insets", "getInsets$foundation_layout_release", "()Landroidx/core/graphics/Insets;", "setInsets$foundation_layout_release", "(Landroidx/core/graphics/Insets;)V", "insets$delegate", "Landroidx/compose/runtime/MutableState;", "", "isVisible", "()Z", "setVisible", "(Z)V", "isVisible$delegate", "getType$foundation_layout_release", "()I", "equals", "other", "", "getBottom", "density", "Landroidx/compose/ui/unit/Density;", "getLeft", ViewProps.LAYOUT_DIRECTION, "Landroidx/compose/ui/unit/LayoutDirection;", "getRight", "getTop", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "update", "", "windowInsetsCompat", "Landroidx/core/view/WindowInsetsCompat;", "typeMask", "update$foundation_layout_release", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidWindowInsets implements WindowInsets {
    public static final int $stable = 0;

    /* renamed from: insets$delegate, reason: from kotlin metadata */
    private final MutableState insets = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Insets.NONE, null, 2, null);

    /* renamed from: isVisible$delegate, reason: from kotlin metadata */
    private final MutableState isVisible = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
    private final String name;
    private final int type;

    public AndroidWindowInsets(int i, String str) {
        this.type = i;
        this.name = str;
    }

    /* renamed from: getType$foundation_layout_release, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Insets getInsets$foundation_layout_release() {
        return (Insets) this.insets.getValue();
    }

    public final void setInsets$foundation_layout_release(Insets insets) {
        this.insets.setValue(insets);
    }

    private final void setVisible(boolean z) {
        this.isVisible.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isVisible() {
        return ((Boolean) this.isVisible.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(Density density, LayoutDirection layoutDirection) {
        return getInsets$foundation_layout_release().left;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(Density density) {
        return getInsets$foundation_layout_release().top;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(Density density, LayoutDirection layoutDirection) {
        return getInsets$foundation_layout_release().right;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(Density density) {
        return getInsets$foundation_layout_release().bottom;
    }

    public final void update$foundation_layout_release(WindowInsetsCompat windowInsetsCompat, int typeMask) {
        if (typeMask == 0 || (typeMask & this.type) != 0) {
            setInsets$foundation_layout_release(windowInsetsCompat.getInsets(this.type));
            setVisible(windowInsetsCompat.isVisible(this.type));
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AndroidWindowInsets) && this.type == ((AndroidWindowInsets) other).type;
    }

    public int hashCode() {
        return this.type;
    }

    public String toString() {
        return this.name + '(' + getInsets$foundation_layout_release().left + ", " + getInsets$foundation_layout_release().top + ", " + getInsets$foundation_layout_release().right + ", " + getInsets$foundation_layout_release().bottom + ')';
    }
}
