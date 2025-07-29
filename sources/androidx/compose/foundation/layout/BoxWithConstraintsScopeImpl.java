package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BoxWithConstraints.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0015\u001a\u00020\u0004HÂ\u0003J\u0016\u0010\u0016\u001a\u00020\u0006HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\tJ'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0015\u0010#\u001a\u00020$*\u00020$2\u0006\u0010%\u001a\u00020&H\u0097\u0001J\r\u0010'\u001a\u00020$*\u00020$H\u0097\u0001R\u001c\u0010\u0005\u001a\u00020\u0006X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\f8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\f8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\f8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\f8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Landroidx/compose/foundation/layout/BoxWithConstraintsScopeImpl;", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "Landroidx/compose/foundation/layout/BoxScope;", "density", "Landroidx/compose/ui/unit/Density;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/ui/unit/Density;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConstraints-msEJaDk", "()J", "J", ViewProps.MAX_HEIGHT, "Landroidx/compose/ui/unit/Dp;", "getMaxHeight-D9Ej5fM", "()F", ViewProps.MAX_WIDTH, "getMaxWidth-D9Ej5fM", ViewProps.MIN_HEIGHT, "getMinHeight-D9Ej5fM", ViewProps.MIN_WIDTH, "getMinWidth-D9Ej5fM", "component1", "component2", "component2-msEJaDk", "copy", "copy-0kLqBqw", "(Landroidx/compose/ui/unit/Density;J)Landroidx/compose/foundation/layout/BoxWithConstraintsScopeImpl;", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "matchParentSize", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class BoxWithConstraintsScopeImpl implements BoxWithConstraintsScope, BoxScope {
    private final /* synthetic */ BoxScopeInstance $$delegate_0;
    private final long constraints;
    private final Density density;

    public /* synthetic */ BoxWithConstraintsScopeImpl(Density density, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(density, j);
    }

    /* renamed from: component1, reason: from getter */
    private final Density getDensity() {
        return this.density;
    }

    /* renamed from: copy-0kLqBqw$default, reason: not valid java name */
    public static /* synthetic */ BoxWithConstraintsScopeImpl m914copy0kLqBqw$default(BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl, Density density, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            density = boxWithConstraintsScopeImpl.density;
        }
        if ((i & 2) != 0) {
            j = boxWithConstraintsScopeImpl.constraints;
        }
        return boxWithConstraintsScopeImpl.m916copy0kLqBqw(density, j);
    }

    @Override // androidx.compose.foundation.layout.BoxScope
    public Modifier align(Modifier modifier, Alignment alignment) {
        return this.$$delegate_0.align(modifier, alignment);
    }

    /* renamed from: component2-msEJaDk, reason: not valid java name and from getter */
    public final long getConstraints() {
        return this.constraints;
    }

    /* renamed from: copy-0kLqBqw, reason: not valid java name */
    public final BoxWithConstraintsScopeImpl m916copy0kLqBqw(Density density, long constraints) {
        return new BoxWithConstraintsScopeImpl(density, constraints, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BoxWithConstraintsScopeImpl)) {
            return false;
        }
        BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl = (BoxWithConstraintsScopeImpl) other;
        return Intrinsics.areEqual(this.density, boxWithConstraintsScopeImpl.density) && Constraints.m4683equalsimpl0(this.constraints, boxWithConstraintsScopeImpl.constraints);
    }

    public int hashCode() {
        return (this.density.hashCode() * 31) + Constraints.m4693hashCodeimpl(this.constraints);
    }

    @Override // androidx.compose.foundation.layout.BoxScope
    public Modifier matchParentSize(Modifier modifier) {
        return this.$$delegate_0.matchParentSize(modifier);
    }

    public String toString() {
        return "BoxWithConstraintsScopeImpl(density=" + this.density + ", constraints=" + ((Object) Constraints.m4695toStringimpl(this.constraints)) + ')';
    }

    private BoxWithConstraintsScopeImpl(Density density, long j) {
        this.density = density;
        this.constraints = j;
        this.$$delegate_0 = BoxScopeInstance.INSTANCE;
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* renamed from: getConstraints-msEJaDk */
    public long mo909getConstraintsmsEJaDk() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* renamed from: getMinWidth-D9Ej5fM */
    public float mo913getMinWidthD9Ej5fM() {
        return this.density.mo691toDpu2uoSUM(Constraints.m4692getMinWidthimpl(mo909getConstraintsmsEJaDk()));
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* renamed from: getMaxWidth-D9Ej5fM */
    public float mo911getMaxWidthD9Ej5fM() {
        return Constraints.m4686getHasBoundedWidthimpl(mo909getConstraintsmsEJaDk()) ? this.density.mo691toDpu2uoSUM(Constraints.m4690getMaxWidthimpl(mo909getConstraintsmsEJaDk())) : Dp.INSTANCE.m4756getInfinityD9Ej5fM();
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* renamed from: getMinHeight-D9Ej5fM */
    public float mo912getMinHeightD9Ej5fM() {
        return this.density.mo691toDpu2uoSUM(Constraints.m4691getMinHeightimpl(mo909getConstraintsmsEJaDk()));
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* renamed from: getMaxHeight-D9Ej5fM */
    public float mo910getMaxHeightD9Ej5fM() {
        return Constraints.m4685getHasBoundedHeightimpl(mo909getConstraintsmsEJaDk()) ? this.density.mo691toDpu2uoSUM(Constraints.m4689getMaxHeightimpl(mo909getConstraintsmsEJaDk())) : Dp.INSTANCE.m4756getInfinityD9Ej5fM();
    }
}
