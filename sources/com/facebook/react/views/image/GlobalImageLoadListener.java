package com.facebook.react.views.image;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;

/* compiled from: GlobalImageLoadListener.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/facebook/react/views/image/GlobalImageLoadListener;", "", "onLoadAttempt", "", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface GlobalImageLoadListener {
    void onLoadAttempt(Uri uri);
}
