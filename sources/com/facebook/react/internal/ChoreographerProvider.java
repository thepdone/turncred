package com.facebook.react.internal;

import android.view.Choreographer;
import kotlin.Metadata;

/* compiled from: ChoreographerProvider.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Lcom/facebook/react/internal/ChoreographerProvider;", "", "getChoreographer", "Lcom/facebook/react/internal/ChoreographerProvider$Choreographer;", "Choreographer", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ChoreographerProvider {

    /* compiled from: ChoreographerProvider.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcom/facebook/react/internal/ChoreographerProvider$Choreographer;", "", "postFrameCallback", "", "callback", "Landroid/view/Choreographer$FrameCallback;", "removeFrameCallback", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Choreographer {
        void postFrameCallback(Choreographer.FrameCallback callback);

        void removeFrameCallback(Choreographer.FrameCallback callback);
    }

    Choreographer getChoreographer();
}
