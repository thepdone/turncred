package com.swmansion.rnscreens.bottomsheet;

import com.swmansion.rnscreens.Screen;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SheetUtils.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0004"}, d2 = {"isSheetFitToContents", "", "Lcom/swmansion/rnscreens/Screen;", "usesFormSheetPresentation", "react-native-screens_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SheetUtilsKt {
    public static final boolean isSheetFitToContents(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "<this>");
        return screen.getStackPresentation() == Screen.StackPresentation.FORM_SHEET && screen.getSheetDetents().size() == 1 && ((Number) CollectionsKt.first((List) screen.getSheetDetents())).doubleValue() == -1.0d;
    }

    public static final boolean usesFormSheetPresentation(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "<this>");
        return screen.getStackPresentation() == Screen.StackPresentation.FORM_SHEET;
    }
}
