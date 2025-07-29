package androidx.compose.foundation.lazy.layout;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* compiled from: LazyLayoutMeasuredItem.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\u001d\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010 \u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0007H&J(\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0012\u0010\r\u001a\u00020\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\u0012\u0010\u0012\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\tR\u0018\u0010\u0014\u001a\u00020\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\tR\u0012\u0010\u001a\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\tø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006'À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getConstraints-msEJaDk", "()J", FirebaseAnalytics.Param.INDEX, "", "getIndex", "()I", "isVertical", "", "()Z", SDKConstants.PARAM_KEY, "getKey", "()Ljava/lang/Object;", "lane", "getLane", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "(Z)V", "placeablesCount", "getPlaceablesCount", "span", "getSpan", "getOffset", "Landroidx/compose/ui/unit/IntOffset;", "getOffset-Bjo55l4", "(I)J", "getParentData", ViewProps.POSITION, "", "mainAxisOffset", "crossAxisOffset", "layoutWidth", "layoutHeight", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface LazyLayoutMeasuredItem {
    /* renamed from: getConstraints-msEJaDk */
    long mo1113getConstraintsmsEJaDk();

    int getIndex();

    Object getKey();

    int getLane();

    int getMainAxisSizeWithSpacings();

    boolean getNonScrollableItem();

    /* renamed from: getOffset-Bjo55l4 */
    long mo1114getOffsetBjo55l4(int index);

    Object getParentData(int index);

    int getPlaceablesCount();

    int getSpan();

    boolean isVertical();

    void position(int mainAxisOffset, int crossAxisOffset, int layoutWidth, int layoutHeight);

    void setNonScrollableItem(boolean z);
}
