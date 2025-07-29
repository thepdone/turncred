package androidx.compose.ui.text.android.selection;

import kotlin.Metadata;

/* compiled from: SegmentFinder.android.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/android/selection/GraphemeClusterSegmentFinder;", "Landroidx/compose/ui/text/android/selection/SegmentFinder;", "()V", "next", "", "offset", "nextEndBoundary", "nextStartBoundary", "previous", "previousEndBoundary", "previousStartBoundary", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class GraphemeClusterSegmentFinder implements SegmentFinder {
    public static final int $stable = 0;

    public abstract int next(int offset);

    public abstract int previous(int offset);

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int previousStartBoundary(int offset) {
        return previous(offset);
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int previousEndBoundary(int offset) {
        int iPrevious = previous(offset);
        if (iPrevious == -1 || previous(iPrevious) == -1) {
            return -1;
        }
        return iPrevious;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int nextStartBoundary(int offset) {
        int next = next(offset);
        if (next == -1 || next(next) == -1) {
            return -1;
        }
        return next;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int nextEndBoundary(int offset) {
        return next(offset);
    }
}
