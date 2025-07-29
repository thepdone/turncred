package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Selection.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0000J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u0019ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/text/selection/Selection;", "", ViewProps.START, "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", ViewProps.END, "handlesCrossed", "", "(Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;Z)V", "getEnd", "()Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "getHandlesCrossed", "()Z", "getStart", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "merge", InAppPurchaseConstants.METHOD_TO_STRING, "", "toTextRange", "Landroidx/compose/ui/text/TextRange;", "toTextRange-d9O1mEE", "()J", "AnchorInfo", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class Selection {
    public static final int $stable = 0;
    private final AnchorInfo end;
    private final boolean handlesCrossed;
    private final AnchorInfo start;

    public static /* synthetic */ Selection copy$default(Selection selection, AnchorInfo anchorInfo, AnchorInfo anchorInfo2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            anchorInfo = selection.start;
        }
        if ((i & 2) != 0) {
            anchorInfo2 = selection.end;
        }
        if ((i & 4) != 0) {
            z = selection.handlesCrossed;
        }
        return selection.copy(anchorInfo, anchorInfo2, z);
    }

    /* renamed from: component1, reason: from getter */
    public final AnchorInfo getStart() {
        return this.start;
    }

    /* renamed from: component2, reason: from getter */
    public final AnchorInfo getEnd() {
        return this.end;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getHandlesCrossed() {
        return this.handlesCrossed;
    }

    public final Selection copy(AnchorInfo start, AnchorInfo end, boolean handlesCrossed) {
        return new Selection(start, end, handlesCrossed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Selection)) {
            return false;
        }
        Selection selection = (Selection) other;
        return Intrinsics.areEqual(this.start, selection.start) && Intrinsics.areEqual(this.end, selection.end) && this.handlesCrossed == selection.handlesCrossed;
    }

    public int hashCode() {
        return (((this.start.hashCode() * 31) + this.end.hashCode()) * 31) + Boolean.hashCode(this.handlesCrossed);
    }

    public String toString() {
        return "Selection(start=" + this.start + ", end=" + this.end + ", handlesCrossed=" + this.handlesCrossed + ')';
    }

    public Selection(AnchorInfo anchorInfo, AnchorInfo anchorInfo2, boolean z) {
        this.start = anchorInfo;
        this.end = anchorInfo2;
        this.handlesCrossed = z;
    }

    public /* synthetic */ Selection(AnchorInfo anchorInfo, AnchorInfo anchorInfo2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(anchorInfo, anchorInfo2, (i & 4) != 0 ? false : z);
    }

    public final AnchorInfo getStart() {
        return this.start;
    }

    public final AnchorInfo getEnd() {
        return this.end;
    }

    public final boolean getHandlesCrossed() {
        return this.handlesCrossed;
    }

    /* compiled from: Selection.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "offset", "", "selectableId", "", "(Landroidx/compose/ui/text/style/ResolvedTextDirection;IJ)V", "getDirection", "()Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getOffset", "()I", "getSelectableId", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class AnchorInfo {
        public static final int $stable = 0;
        private final ResolvedTextDirection direction;
        private final int offset;
        private final long selectableId;

        public static /* synthetic */ AnchorInfo copy$default(AnchorInfo anchorInfo, ResolvedTextDirection resolvedTextDirection, int i, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                resolvedTextDirection = anchorInfo.direction;
            }
            if ((i2 & 2) != 0) {
                i = anchorInfo.offset;
            }
            if ((i2 & 4) != 0) {
                j = anchorInfo.selectableId;
            }
            return anchorInfo.copy(resolvedTextDirection, i, j);
        }

        /* renamed from: component1, reason: from getter */
        public final ResolvedTextDirection getDirection() {
            return this.direction;
        }

        /* renamed from: component2, reason: from getter */
        public final int getOffset() {
            return this.offset;
        }

        /* renamed from: component3, reason: from getter */
        public final long getSelectableId() {
            return this.selectableId;
        }

        public final AnchorInfo copy(ResolvedTextDirection direction, int offset, long selectableId) {
            return new AnchorInfo(direction, offset, selectableId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnchorInfo)) {
                return false;
            }
            AnchorInfo anchorInfo = (AnchorInfo) other;
            return this.direction == anchorInfo.direction && this.offset == anchorInfo.offset && this.selectableId == anchorInfo.selectableId;
        }

        public int hashCode() {
            return (((this.direction.hashCode() * 31) + Integer.hashCode(this.offset)) * 31) + Long.hashCode(this.selectableId);
        }

        public String toString() {
            return "AnchorInfo(direction=" + this.direction + ", offset=" + this.offset + ", selectableId=" + this.selectableId + ')';
        }

        public AnchorInfo(ResolvedTextDirection resolvedTextDirection, int i, long j) {
            this.direction = resolvedTextDirection;
            this.offset = i;
            this.selectableId = j;
        }

        public final ResolvedTextDirection getDirection() {
            return this.direction;
        }

        public final int getOffset() {
            return this.offset;
        }

        public final long getSelectableId() {
            return this.selectableId;
        }
    }

    public final Selection merge(Selection other) {
        if (other == null) {
            return this;
        }
        boolean z = this.handlesCrossed;
        if (z || other.handlesCrossed) {
            return new Selection(other.handlesCrossed ? other.start : other.end, z ? this.end : this.start, true);
        }
        return copy$default(this, null, other.end, false, 5, null);
    }

    /* renamed from: toTextRange-d9O1mEE, reason: not valid java name */
    public final long m1655toTextRanged9O1mEE() {
        return TextRangeKt.TextRange(this.start.getOffset(), this.end.getOffset());
    }
}
