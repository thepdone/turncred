package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.input.internal.IndexTransformationType;
import androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: TextPreparedSelection.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0001¨\u0006\t"}, d2 = {"calculateAdjacentCursorPosition", "", "transformedText", "", "cursor", "forward", "", "state", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextPreparedSelectionKt {

    /* compiled from: TextPreparedSelection.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IndexTransformationType.values().length];
            try {
                iArr[IndexTransformationType.Untransformed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IndexTransformationType.Deletion.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IndexTransformationType.Replacement.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IndexTransformationType.Insertion.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int calculateAdjacentCursorPosition(String str, int i, boolean z, TransformedTextFieldState transformedTextFieldState) {
        int iFindPrecedingBreak;
        IndexTransformationType indexTransformationType;
        if (z) {
            iFindPrecedingBreak = StringHelpers_androidKt.findFollowingBreak(str, i);
        } else {
            iFindPrecedingBreak = StringHelpers_androidKt.findPrecedingBreak(str, i);
        }
        if (iFindPrecedingBreak == -1) {
            return i;
        }
        long jM1549mapFromTransformedjx7JFs = transformedTextFieldState.m1549mapFromTransformedjx7JFs(iFindPrecedingBreak);
        long jM1552mapToTransformedGEjPoXI = transformedTextFieldState.m1552mapToTransformedGEjPoXI(jM1549mapFromTransformedjx7JFs);
        if (TextRange.m4216getCollapsedimpl(jM1549mapFromTransformedjx7JFs) && TextRange.m4216getCollapsedimpl(jM1552mapToTransformedGEjPoXI)) {
            indexTransformationType = IndexTransformationType.Untransformed;
        } else if (!TextRange.m4216getCollapsedimpl(jM1549mapFromTransformedjx7JFs) && !TextRange.m4216getCollapsedimpl(jM1552mapToTransformedGEjPoXI)) {
            indexTransformationType = IndexTransformationType.Replacement;
        } else if (TextRange.m4216getCollapsedimpl(jM1549mapFromTransformedjx7JFs) && !TextRange.m4216getCollapsedimpl(jM1552mapToTransformedGEjPoXI)) {
            indexTransformationType = IndexTransformationType.Insertion;
        } else {
            indexTransformationType = IndexTransformationType.Deletion;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[indexTransformationType.ordinal()];
        if (i2 == 1 || i2 == 2) {
            return iFindPrecedingBreak;
        }
        if (i2 == 3) {
            return z ? TextRange.m4217getEndimpl(jM1552mapToTransformedGEjPoXI) : TextRange.m4222getStartimpl(jM1552mapToTransformedGEjPoXI);
        }
        if (i2 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        if (z) {
            if (iFindPrecedingBreak == TextRange.m4222getStartimpl(jM1552mapToTransformedGEjPoXI)) {
                transformedTextFieldState.setSelectionWedgeAffinity(new SelectionWedgeAffinity(WedgeAffinity.Start));
                return iFindPrecedingBreak;
            }
            transformedTextFieldState.setSelectionWedgeAffinity(new SelectionWedgeAffinity(WedgeAffinity.End));
            return i;
        }
        if (iFindPrecedingBreak == TextRange.m4217getEndimpl(jM1552mapToTransformedGEjPoXI)) {
            transformedTextFieldState.setSelectionWedgeAffinity(new SelectionWedgeAffinity(WedgeAffinity.End));
            return iFindPrecedingBreak;
        }
        transformedTextFieldState.setSelectionWedgeAffinity(new SelectionWedgeAffinity(WedgeAffinity.Start));
        return i;
    }
}
