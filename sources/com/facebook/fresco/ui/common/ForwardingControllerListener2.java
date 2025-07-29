package com.facebook.fresco.ui.common;

import android.util.Log;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.react.util.ExceptionDataHelper;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForwardingControllerListener2.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 #*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001#B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006J+\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00020\b0\u000eH\u0082\bJ\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J)\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00018\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u001f\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010 \u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0006\u0010!\u001a\u00020\bJ\u0014\u0010\"\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/facebook/fresco/ui/common/ForwardingControllerListener2;", "I", "Lcom/facebook/fresco/ui/common/BaseControllerListener2;", "()V", "listeners", "", "Lcom/facebook/fresco/ui/common/ControllerListener2;", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "forEachListener", "methodName", "", "block", "Lkotlin/Function1;", "onEmptyEvent", "callerContext", "", "onFailure", "id", "throwable", "", "extras", "Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;", "onFinalImageSet", "imageInfo", ExceptionDataHelper.EXTRA_DATA_FIELD, "(Ljava/lang/String;Ljava/lang/Object;Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;)V", "onIntermediateImageFailed", "onIntermediateImageSet", "(Ljava/lang/String;Ljava/lang/Object;)V", "onRelease", "onSubmit", "removeAllListeners", "removeListener", "Companion", "ui-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public class ForwardingControllerListener2<I> extends BaseControllerListener2<I> {
    private static final String TAG = "FwdControllerListener2";
    private final List<ControllerListener2<I>> listeners = new ArrayList(2);

    public final synchronized void addListener(ControllerListener2<I> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final synchronized void removeListener(ControllerListener2<I> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    public final synchronized void removeAllListeners() {
        this.listeners.clear();
    }

    private final void forEachListener(String methodName, Function1<? super ControllerListener2<I>, Unit> block) {
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    block.invoke(this.listeners.get(i));
                } catch (Exception e) {
                    Log.e(TAG, "InternalListener exception in " + methodName, e);
                }
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onSubmit(String id, Object callerContext, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    this.listeners.get(i).onSubmit(id, callerContext, extras);
                } catch (Exception e) {
                    Log.e(TAG, "InternalListener exception in onSubmit", e);
                }
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onFinalImageSet(String id, I imageInfo, ControllerListener2.Extras extraData) {
        Intrinsics.checkNotNullParameter(id, "id");
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    this.listeners.get(i).onFinalImageSet(id, imageInfo, extraData);
                } catch (Exception e) {
                    Log.e(TAG, "InternalListener exception in onFinalImageSet", e);
                }
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onFailure(String id, Throwable throwable, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    this.listeners.get(i).onFailure(id, throwable, extras);
                } catch (Exception e) {
                    Log.e(TAG, "InternalListener exception in onFailure", e);
                }
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onRelease(String id, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    this.listeners.get(i).onRelease(id, extras);
                } catch (Exception e) {
                    Log.e(TAG, "InternalListener exception in onRelease", e);
                }
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onIntermediateImageSet(String id, I imageInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    this.listeners.get(i).onIntermediateImageSet(id, imageInfo);
                } catch (Exception e) {
                    Log.e(TAG, "InternalListener exception in onIntermediateImageSet", e);
                }
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onIntermediateImageFailed(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    this.listeners.get(i).onIntermediateImageFailed(id);
                } catch (Exception e) {
                    Log.e(TAG, "InternalListener exception in onIntermediateImageFailed", e);
                }
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onEmptyEvent(Object callerContext) {
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            try {
                try {
                    this.listeners.get(i).onEmptyEvent(callerContext);
                } catch (Exception e) {
                    Log.e(TAG, "InternalListener exception in onEmptyEvent", e);
                }
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }
}
