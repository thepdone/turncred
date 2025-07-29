package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.facebook.react.uimanager.events.TouchesHelper;
import kotlin.Metadata;

/* compiled from: EditingBuffer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", TouchesHelper.TARGET_KEY, "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EditingBufferKt {
    /* renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m4383updateRangeAfterDeletepWDy79M(long j, long j2) {
        int iM4218getLengthimpl;
        int iM4220getMinimpl = TextRange.m4220getMinimpl(j);
        int iM4219getMaximpl = TextRange.m4219getMaximpl(j);
        if (TextRange.m4224intersects5zctL8(j2, j)) {
            if (TextRange.m4212contains5zctL8(j2, j)) {
                iM4220getMinimpl = TextRange.m4220getMinimpl(j2);
                iM4219getMaximpl = iM4220getMinimpl;
            } else {
                if (TextRange.m4212contains5zctL8(j, j2)) {
                    iM4218getLengthimpl = TextRange.m4218getLengthimpl(j2);
                } else if (TextRange.m4213containsimpl(j2, iM4220getMinimpl)) {
                    iM4220getMinimpl = TextRange.m4220getMinimpl(j2);
                    iM4218getLengthimpl = TextRange.m4218getLengthimpl(j2);
                } else {
                    iM4219getMaximpl = TextRange.m4220getMinimpl(j2);
                }
                iM4219getMaximpl -= iM4218getLengthimpl;
            }
        } else if (iM4219getMaximpl > TextRange.m4220getMinimpl(j2)) {
            iM4220getMinimpl -= TextRange.m4218getLengthimpl(j2);
            iM4218getLengthimpl = TextRange.m4218getLengthimpl(j2);
            iM4219getMaximpl -= iM4218getLengthimpl;
        }
        return TextRangeKt.TextRange(iM4220getMinimpl, iM4219getMaximpl);
    }
}
