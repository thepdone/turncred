package androidx.compose.foundation.pager;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* compiled from: PageInfo.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0005\u0082\u0001\u0001\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/pager/PageInfo;", "", FirebaseAnalytics.Param.INDEX, "", "getIndex", "()I", SDKConstants.PARAM_KEY, "getKey", "()Ljava/lang/Object;", "offset", "getOffset", "Landroidx/compose/foundation/pager/MeasuredPage;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface PageInfo {
    int getIndex();

    Object getKey();

    int getOffset();
}
