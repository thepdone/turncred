package com.swmansion.gesturehandler.core;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import androidx.core.app.NotificationCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GestureHandlerOrchestrator.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 H2\u00020\u0001:\u0001HB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0014\u0010\"\u001a\u00020\u001f2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\rH\u0002J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010%\u001a\u00020\u001fH\u0002J\b\u0010&\u001a\u00020\u001fH\u0002J\b\u0010'\u001a\u00020\u001fH\u0002J\u001c\u0010(\u001a\u00020\u001f2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020*H\u0002J \u0010-\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\nH\u0002J\u0010\u00101\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020*H\u0002J(\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\n2\u0006\u0010,\u001a\u00020*H\u0002J\u001a\u00103\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0018\u00010\f2\u0006\u0010 \u001a\u00020!J\u0014\u00104\u001a\u00020\u00132\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\rH\u0002J\u0006\u00105\u001a\u00020\u0013J\u0010\u00106\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0002J\u0012\u00107\u001a\u00020\u00132\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0010\u00108\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0002J\u0014\u00109\u001a\u00020\u001f2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\rH\u0002J\"\u0010:\u001a\u00020\u001f2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\nJ\u000e\u0010=\u001a\u00020\u00132\u0006\u0010,\u001a\u00020*J\u001c\u0010>\u001a\u00020\u001f2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010 \u001a\u00020!H\u0002J(\u0010?\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\n2\u0006\u0010,\u001a\u00020*H\u0002J\b\u0010@\u001a\u00020\u001fH\u0002J\u0014\u0010A\u001a\u00020\u00132\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\rH\u0002J\u0018\u0010B\u001a\u00020*2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010,\u001a\u00020*J\u0018\u0010C\u001a\u00020D2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010E\u001a\u00020DJ(\u0010F\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\n2\u0006\u0010,\u001a\u00020*H\u0002J\u0014\u0010G\u001a\u00020\u001f2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030\rH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0010j\b\u0012\u0004\u0012\u00020\n`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0014\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR&\u0010\u001d\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/swmansion/gesturehandler/core/GestureHandlerOrchestrator;", "", "wrapperView", "Landroid/view/ViewGroup;", "handlerRegistry", "Lcom/swmansion/gesturehandler/core/GestureHandlerRegistry;", "viewConfigHelper", "Lcom/swmansion/gesturehandler/core/ViewConfigurationHelper;", "(Landroid/view/ViewGroup;Lcom/swmansion/gesturehandler/core/GestureHandlerRegistry;Lcom/swmansion/gesturehandler/core/ViewConfigurationHelper;)V", "activationIndex", "", "awaitingHandlers", "Ljava/util/ArrayList;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "Lkotlin/collections/ArrayList;", "awaitingHandlersTags", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "finishedHandlersCleanupScheduled", "", "gestureHandlers", "handlingChangeSemaphore", "isHandlingTouch", "minimumAlphaForTraversal", "", "getMinimumAlphaForTraversal", "()F", "setMinimumAlphaForTraversal", "(F)V", "preparedHandlers", "activateNativeHandlersForView", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "addAwaitingHandler", "handler", "canReceiveEvents", "cancelAll", "cleanupAwaitingHandlers", "cleanupFinishedHandlers", "deliverEventToGestureHandler", "sourceEvent", "Landroid/view/MotionEvent;", "deliverEventToGestureHandlers", NotificationCompat.CATEGORY_EVENT, "extractAncestorHandlers", "coords", "", "pointerId", "extractGestureHandlers", "viewGroup", "getHandlersForView", "hasOtherHandlerToWaitFor", "isAnyHandlerActive", "isClipping", "isViewAttachedUnderWrapper", "isViewOverflowingParent", "makeActive", "onHandlerStateChange", "newState", "prevState", "onTouchEvent", "recordHandlerIfNotPresent", "recordViewHandlersForPointer", "scheduleFinishedHandlersCleanup", "shouldBeCancelledByFinishedHandler", "transformEventToViewCoords", "transformPointToViewCoords", "Landroid/graphics/PointF;", "point", "traverseWithPointerEvents", "tryActivate", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GestureHandlerOrchestrator {
    private static final float DEFAULT_MIN_ALPHA_FOR_TRAVERSAL = 0.0f;
    private int activationIndex;
    private final ArrayList<GestureHandler<?>> awaitingHandlers;
    private final HashSet<Integer> awaitingHandlersTags;
    private boolean finishedHandlersCleanupScheduled;
    private final ArrayList<GestureHandler<?>> gestureHandlers;
    private final GestureHandlerRegistry handlerRegistry;
    private int handlingChangeSemaphore;
    private boolean isHandlingTouch;
    private float minimumAlphaForTraversal;
    private final ArrayList<GestureHandler<?>> preparedHandlers;
    private final ViewConfigurationHelper viewConfigHelper;
    private final ViewGroup wrapperView;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final PointF tempPoint = new PointF();
    private static final float[] matrixTransformCoords = new float[2];
    private static final Matrix inverseMatrix = new Matrix();
    private static final float[] tempCoords = new float[2];
    private static final Comparator<GestureHandler<?>> handlersComparator = new Comparator() { // from class: com.swmansion.gesturehandler.core.GestureHandlerOrchestrator$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return GestureHandlerOrchestrator.handlersComparator$lambda$12((GestureHandler) obj, (GestureHandler) obj2);
        }
    };

    /* compiled from: GestureHandlerOrchestrator.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PointerEventsConfig.values().length];
            try {
                iArr[PointerEventsConfig.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PointerEventsConfig.BOX_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PointerEventsConfig.BOX_NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PointerEventsConfig.AUTO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public GestureHandlerOrchestrator(ViewGroup wrapperView, GestureHandlerRegistry handlerRegistry, ViewConfigurationHelper viewConfigHelper) {
        Intrinsics.checkNotNullParameter(wrapperView, "wrapperView");
        Intrinsics.checkNotNullParameter(handlerRegistry, "handlerRegistry");
        Intrinsics.checkNotNullParameter(viewConfigHelper, "viewConfigHelper");
        this.wrapperView = wrapperView;
        this.handlerRegistry = handlerRegistry;
        this.viewConfigHelper = viewConfigHelper;
        this.gestureHandlers = new ArrayList<>();
        this.awaitingHandlers = new ArrayList<>();
        this.preparedHandlers = new ArrayList<>();
        this.awaitingHandlersTags = new HashSet<>();
    }

    public final float getMinimumAlphaForTraversal() {
        return this.minimumAlphaForTraversal;
    }

    public final void setMinimumAlphaForTraversal(float f) {
        this.minimumAlphaForTraversal = f;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 1
            r3.isHandlingTouch = r0
            int r1 = r4.getActionMasked()
            if (r1 == 0) goto L1c
            r2 = 3
            if (r1 == r2) goto L18
            r2 = 5
            if (r1 == r2) goto L1c
            r2 = 7
            if (r1 == r2) goto L1c
            goto L1f
        L18:
            r3.cancelAll()
            goto L1f
        L1c:
            r3.extractGestureHandlers(r4)
        L1f:
            r3.deliverEventToGestureHandlers(r4)
            r4 = 0
            r3.isHandlingTouch = r4
            boolean r4 = r3.finishedHandlersCleanupScheduled
            if (r4 == 0) goto L30
            int r4 = r3.handlingChangeSemaphore
            if (r4 != 0) goto L30
            r3.cleanupFinishedHandlers()
        L30:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.core.GestureHandlerOrchestrator.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final ArrayList<GestureHandler<?>> getHandlersForView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return this.handlerRegistry.getHandlersForView(view);
    }

    private final void scheduleFinishedHandlersCleanup() {
        if (this.isHandlingTouch || this.handlingChangeSemaphore != 0) {
            this.finishedHandlersCleanupScheduled = true;
        } else {
            cleanupFinishedHandlers();
        }
    }

    private final void cleanupFinishedHandlers() {
        for (GestureHandler gestureHandler : CollectionsKt.asReversedMutable(this.gestureHandlers)) {
            if (INSTANCE.isFinished(gestureHandler.getState()) && !gestureHandler.getIsAwaiting()) {
                gestureHandler.reset();
                gestureHandler.setActive(false);
                gestureHandler.setAwaiting(false);
                gestureHandler.setActivationIndex(Integer.MAX_VALUE);
            }
        }
        CollectionsKt.removeAll((List) this.gestureHandlers, (Function1) new Function1<GestureHandler<?>, Boolean>() { // from class: com.swmansion.gesturehandler.core.GestureHandlerOrchestrator.cleanupFinishedHandlers.2
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(GestureHandler<?> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(GestureHandlerOrchestrator.INSTANCE.isFinished(it.getState()) && !it.getIsAwaiting());
            }
        });
        this.finishedHandlersCleanupScheduled = false;
    }

    private final boolean hasOtherHandlerToWaitFor(GestureHandler<?> handler) {
        ArrayList<GestureHandler<?>> arrayList = this.gestureHandlers;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return false;
        }
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            GestureHandler gestureHandler = (GestureHandler) it.next();
            Companion companion = INSTANCE;
            if (!companion.isFinished(gestureHandler.getState()) && companion.shouldHandlerWaitForOther(handler, gestureHandler)) {
                return true;
            }
        }
        return false;
    }

    private final boolean shouldBeCancelledByFinishedHandler(GestureHandler<?> handler) {
        ArrayList<GestureHandler<?>> arrayList = this.gestureHandlers;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return false;
        }
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            GestureHandler gestureHandler = (GestureHandler) it.next();
            if (INSTANCE.shouldHandlerWaitForOther(handler, gestureHandler) && gestureHandler.getState() == 5) {
                return true;
            }
        }
        return false;
    }

    private final void tryActivate(GestureHandler<?> handler) {
        if (shouldBeCancelledByFinishedHandler(handler)) {
            handler.cancel();
        } else if (hasOtherHandlerToWaitFor(handler)) {
            addAwaitingHandler(handler);
        } else {
            makeActive(handler);
            handler.setAwaiting(false);
        }
    }

    private final void cleanupAwaitingHandlers() {
        for (GestureHandler gestureHandler : CollectionsKt.toList(this.awaitingHandlers)) {
            if (!gestureHandler.getIsAwaiting()) {
                this.awaitingHandlers.remove(gestureHandler);
                this.awaitingHandlersTags.remove(Integer.valueOf(gestureHandler.getTag()));
            }
        }
    }

    public final void onHandlerStateChange(GestureHandler<?> handler, int newState, int prevState) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.handlingChangeSemaphore++;
        if (INSTANCE.isFinished(newState)) {
            for (GestureHandler<?> gestureHandler : CollectionsKt.toList(this.awaitingHandlers)) {
                if (INSTANCE.shouldHandlerWaitForOther(gestureHandler, handler) && this.awaitingHandlersTags.contains(Integer.valueOf(gestureHandler.getTag()))) {
                    if (newState == 5) {
                        gestureHandler.cancel();
                        if (gestureHandler.getState() == 5) {
                            gestureHandler.dispatchStateChange(3, 2);
                        }
                        gestureHandler.setAwaiting(false);
                    } else {
                        tryActivate(gestureHandler);
                    }
                }
            }
            cleanupAwaitingHandlers();
        }
        if (newState == 4) {
            tryActivate(handler);
        } else if (prevState == 4 || prevState == 5) {
            if (handler.getIsActive()) {
                handler.dispatchStateChange(newState, prevState);
            } else if (prevState == 4 && (newState == 3 || newState == 1)) {
                handler.dispatchStateChange(newState, 2);
            }
        } else if (prevState != 0 || newState != 3) {
            handler.dispatchStateChange(newState, prevState);
        }
        this.handlingChangeSemaphore--;
        scheduleFinishedHandlersCleanup();
    }

    private final void makeActive(GestureHandler<?> handler) {
        int state = handler.getState();
        handler.setAwaiting(false);
        handler.setActive(true);
        handler.setShouldResetProgress(true);
        int i = this.activationIndex;
        this.activationIndex = i + 1;
        handler.setActivationIndex(i);
        for (GestureHandler gestureHandler : CollectionsKt.asReversedMutable(this.gestureHandlers)) {
            if (INSTANCE.shouldHandlerBeCancelledBy(gestureHandler, handler)) {
                gestureHandler.cancel();
            }
        }
        for (GestureHandler gestureHandler2 : CollectionsKt.reversed(this.awaitingHandlers)) {
            if (INSTANCE.shouldHandlerBeCancelledBy(gestureHandler2, handler)) {
                gestureHandler2.setAwaiting(false);
            }
        }
        cleanupAwaitingHandlers();
        if (state == 1 || state == 3) {
            return;
        }
        handler.dispatchStateChange(4, 2);
        if (state != 4) {
            handler.dispatchStateChange(5, 4);
            if (state != 5) {
                handler.dispatchStateChange(0, 5);
            }
        }
    }

    private final void deliverEventToGestureHandlers(MotionEvent event) {
        this.preparedHandlers.clear();
        this.preparedHandlers.addAll(this.gestureHandlers);
        CollectionsKt.sortWith(this.preparedHandlers, handlersComparator);
        Iterator<GestureHandler<?>> it = this.preparedHandlers.iterator();
        while (it.hasNext()) {
            GestureHandler<?> next = it.next();
            Intrinsics.checkNotNull(next);
            deliverEventToGestureHandler(next, event);
        }
    }

    private final void cancelAll() {
        Iterator it = CollectionsKt.reversed(this.awaitingHandlers).iterator();
        while (it.hasNext()) {
            ((GestureHandler) it.next()).cancel();
        }
        this.preparedHandlers.clear();
        this.preparedHandlers.addAll(this.gestureHandlers);
        Iterator it2 = CollectionsKt.reversed(this.gestureHandlers).iterator();
        while (it2.hasNext()) {
            ((GestureHandler) it2.next()).cancel();
        }
    }

    private final void deliverEventToGestureHandler(GestureHandler<?> handler, MotionEvent sourceEvent) {
        if (!isViewAttachedUnderWrapper(handler.getView())) {
            handler.cancel();
            return;
        }
        if (handler.wantEvents()) {
            int actionMasked = sourceEvent.getActionMasked();
            View view = handler.getView();
            MotionEvent motionEventObtain = MotionEvent.obtain(sourceEvent);
            Intrinsics.checkNotNullExpressionValue(motionEventObtain, "obtain(...)");
            MotionEvent motionEventTransformEventToViewCoords = transformEventToViewCoords(view, motionEventObtain);
            if (handler.getNeedsPointerData() && handler.getState() != 0) {
                handler.updatePointerData(motionEventTransformEventToViewCoords, sourceEvent);
            }
            if (!handler.getIsAwaiting() || actionMasked != 2) {
                boolean z = handler.getState() == 0;
                handler.handle(motionEventTransformEventToViewCoords, sourceEvent);
                if (handler.getIsActive()) {
                    if (handler.getShouldResetProgress()) {
                        handler.setShouldResetProgress(false);
                        handler.resetProgress();
                    }
                    handler.dispatchHandlerUpdate(motionEventTransformEventToViewCoords);
                }
                if (handler.getNeedsPointerData() && z) {
                    handler.updatePointerData(motionEventTransformEventToViewCoords, sourceEvent);
                }
                if (actionMasked == 1 || actionMasked == 6 || actionMasked == 10) {
                    handler.stopTrackingPointer(motionEventTransformEventToViewCoords.getPointerId(motionEventTransformEventToViewCoords.getActionIndex()));
                }
            }
            motionEventTransformEventToViewCoords.recycle();
        }
    }

    private final boolean isViewAttachedUnderWrapper(View view) {
        if (view == null) {
            return false;
        }
        if (view == this.wrapperView) {
            return true;
        }
        ViewParent parent = view.getParent();
        while (parent != null && parent != this.wrapperView) {
            parent = parent.getParent();
        }
        return parent == this.wrapperView;
    }

    public final boolean isAnyHandlerActive() {
        ArrayList<GestureHandler<?>> arrayList = this.gestureHandlers;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return false;
        }
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            if (((GestureHandler) it.next()).getState() == 4) {
                return true;
            }
        }
        return false;
    }

    public final MotionEvent transformEventToViewCoords(View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (view == null) {
            return event;
        }
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (!Intrinsics.areEqual(viewGroup, this.wrapperView)) {
            transformEventToViewCoords(viewGroup, event);
        }
        if (viewGroup != null) {
            event.setLocation((event.getX() + viewGroup.getScrollX()) - view.getLeft(), (event.getY() + viewGroup.getScrollY()) - view.getTop());
        }
        if (!view.getMatrix().isIdentity()) {
            Matrix matrix = view.getMatrix();
            Matrix matrix2 = inverseMatrix;
            matrix.invert(matrix2);
            event.transform(matrix2);
        }
        return event;
    }

    public final PointF transformPointToViewCoords(View view, PointF point) {
        Intrinsics.checkNotNullParameter(point, "point");
        if (view == null) {
            return point;
        }
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (!Intrinsics.areEqual(viewGroup, this.wrapperView)) {
            transformPointToViewCoords(viewGroup, point);
        }
        if (viewGroup != null) {
            point.x += viewGroup.getScrollX() - view.getLeft();
            point.y += viewGroup.getScrollY() - view.getTop();
        }
        if (!view.getMatrix().isIdentity()) {
            Matrix matrix = view.getMatrix();
            Matrix matrix2 = inverseMatrix;
            matrix.invert(matrix2);
            float[] fArr = tempCoords;
            fArr[0] = point.x;
            fArr[1] = point.y;
            matrix2.mapPoints(fArr);
            point.x = fArr[0];
            point.y = fArr[1];
        }
        return point;
    }

    private final void addAwaitingHandler(GestureHandler<?> handler) {
        if (this.awaitingHandlers.contains(handler)) {
            return;
        }
        this.awaitingHandlers.add(handler);
        this.awaitingHandlersTags.add(Integer.valueOf(handler.getTag()));
        handler.setAwaiting(true);
        int i = this.activationIndex;
        this.activationIndex = i + 1;
        handler.setActivationIndex(i);
    }

    private final void recordHandlerIfNotPresent(GestureHandler<?> handler, View view) {
        if (this.gestureHandlers.contains(handler)) {
            return;
        }
        this.gestureHandlers.add(handler);
        handler.setActive(false);
        handler.setAwaiting(false);
        handler.setActivationIndex(Integer.MAX_VALUE);
        handler.prepare(view, this);
    }

    private final boolean isViewOverflowingParent(View view) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return false;
        }
        Matrix matrix = view.getMatrix();
        float[] fArr = matrixTransformCoords;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        matrix.mapPoints(fArr);
        float left = fArr[0] + view.getLeft();
        float top = fArr[1] + view.getTop();
        return left < 0.0f || left + ((float) view.getWidth()) > ((float) viewGroup.getWidth()) || top < 0.0f || top + ((float) view.getHeight()) > ((float) viewGroup.getHeight());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.ViewParent] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    private final boolean extractAncestorHandlers(View view, float[] coords, int pointerId) {
        boolean z = false;
        for (ViewGroup parent = view.getParent(); parent != 0; parent = parent.getParent()) {
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = parent;
                ArrayList<GestureHandler<?>> handlersForView = this.handlerRegistry.getHandlersForView(parent);
                if (handlersForView != null) {
                    synchronized (handlersForView) {
                        Iterator<GestureHandler<?>> it = handlersForView.iterator();
                        while (it.hasNext()) {
                            GestureHandler<?> next = it.next();
                            if (next.getIsEnabled() && next.isWithinBounds(view, coords[0], coords[1])) {
                                Intrinsics.checkNotNull(next);
                                recordHandlerIfNotPresent(next, viewGroup);
                                next.startTrackingPointer(pointerId);
                                z = true;
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                } else {
                    continue;
                }
            }
        }
        return z;
    }

    private final boolean recordViewHandlersForPointer(View view, float[] coords, int pointerId, MotionEvent event) {
        boolean z;
        ArrayList<GestureHandler<?>> handlersForView = this.handlerRegistry.getHandlersForView(view);
        if (handlersForView != null) {
            synchronized (handlersForView) {
                Iterator<GestureHandler<?>> it = handlersForView.iterator();
                z = false;
                while (it.hasNext()) {
                    GestureHandler<?> next = it.next();
                    if (next.getIsEnabled() && next.isWithinBounds(view, coords[0], coords[1]) && (!CollectionsKt.listOf((Object[]) new Integer[]{10, 9, 7}).contains(Integer.valueOf(event.getAction())) || (next instanceof HoverGestureHandler))) {
                        Intrinsics.checkNotNull(next);
                        recordHandlerIfNotPresent(next, view);
                        next.startTrackingPointer(pointerId);
                        z = true;
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        } else {
            z = false;
        }
        float width = view.getWidth();
        float f = coords[0];
        if (0.0f <= f && f <= width) {
            float height = view.getHeight();
            float f2 = coords[1];
            if (0.0f <= f2 && f2 <= height && isViewOverflowingParent(view) && extractAncestorHandlers(view, coords, pointerId)) {
                return true;
            }
        }
        return z;
    }

    private final void extractGestureHandlers(MotionEvent event) {
        int actionIndex = event.getActionIndex();
        int pointerId = event.getPointerId(actionIndex);
        float[] fArr = tempCoords;
        fArr[0] = event.getX(actionIndex);
        fArr[1] = event.getY(actionIndex);
        traverseWithPointerEvents(this.wrapperView, fArr, pointerId, event);
        extractGestureHandlers(this.wrapperView, fArr, pointerId, event);
    }

    private final boolean extractGestureHandlers(ViewGroup viewGroup, float[] coords, int pointerId, MotionEvent event) {
        for (int childCount = viewGroup.getChildCount() - 1; -1 < childCount; childCount--) {
            View childInDrawingOrderAtIndex = this.viewConfigHelper.getChildInDrawingOrderAtIndex(viewGroup, childCount);
            if (canReceiveEvents(childInDrawingOrderAtIndex)) {
                PointF pointF = tempPoint;
                Companion companion = INSTANCE;
                companion.transformPointToChildViewCoords(coords[0], coords[1], viewGroup, childInDrawingOrderAtIndex, pointF);
                float f = coords[0];
                float f2 = coords[1];
                coords[0] = pointF.x;
                coords[1] = pointF.y;
                boolean zTraverseWithPointerEvents = (!isClipping(childInDrawingOrderAtIndex) || companion.isTransformedTouchPointInView(coords[0], coords[1], childInDrawingOrderAtIndex)) ? traverseWithPointerEvents(childInDrawingOrderAtIndex, coords, pointerId, event) : false;
                coords[0] = f;
                coords[1] = f2;
                if (zTraverseWithPointerEvents) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean traverseWithPointerEvents(View view, float[] coords, int pointerId, MotionEvent event) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.viewConfigHelper.getPointerEventsConfigForView(view).ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    boolean zExtractGestureHandlers = view instanceof ViewGroup ? extractGestureHandlers((ViewGroup) view, coords, pointerId, event) : false;
                    if (recordViewHandlersForPointer(view, coords, pointerId, event) || zExtractGestureHandlers || INSTANCE.shouldHandlerlessViewBecomeTouchTarget(view, coords)) {
                        return true;
                    }
                } else {
                    if (view instanceof ViewGroup) {
                        boolean zExtractGestureHandlers2 = extractGestureHandlers((ViewGroup) view, coords, pointerId, event);
                        if (!zExtractGestureHandlers2) {
                            return zExtractGestureHandlers2;
                        }
                        recordViewHandlersForPointer(view, coords, pointerId, event);
                        return zExtractGestureHandlers2;
                    }
                    if (view instanceof EditText) {
                        return recordViewHandlersForPointer(view, coords, pointerId, event);
                    }
                }
            } else if (recordViewHandlersForPointer(view, coords, pointerId, event) || INSTANCE.shouldHandlerlessViewBecomeTouchTarget(view, coords)) {
                return true;
            }
        }
        return false;
    }

    private final boolean canReceiveEvents(View view) {
        return view.getVisibility() == 0 && view.getAlpha() >= this.minimumAlphaForTraversal;
    }

    private final boolean isClipping(View view) {
        return !(view instanceof ViewGroup) || this.viewConfigHelper.isViewClippingChildren((ViewGroup) view);
    }

    public final void activateNativeHandlersForView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ArrayList<GestureHandler<?>> handlersForView = this.handlerRegistry.getHandlersForView(view);
        if (handlersForView != null) {
            for (final GestureHandler<?> gestureHandler : handlersForView) {
                if (gestureHandler instanceof NativeViewGestureHandler) {
                    recordHandlerIfNotPresent(gestureHandler, view);
                    gestureHandler.withMarkedAsInBounds(new Function0<Unit>() { // from class: com.swmansion.gesturehandler.core.GestureHandlerOrchestrator$activateNativeHandlersForView$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            gestureHandler.begin();
                            gestureHandler.activate();
                            gestureHandler.end();
                        }
                    });
                }
            }
        }
    }

    /* compiled from: GestureHandlerOrchestrator.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00072\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J \u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J \u0010\u001b\u001a\u00020\u00102\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u00072\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0002J \u0010\u001e\u001a\u00020\u00102\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u00072\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0002J\u0018\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u000bH\u0002J0\u0010\"\u001a\u00020#2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/swmansion/gesturehandler/core/GestureHandlerOrchestrator$Companion;", "", "()V", "DEFAULT_MIN_ALPHA_FOR_TRAVERSAL", "", "handlersComparator", "Ljava/util/Comparator;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "inverseMatrix", "Landroid/graphics/Matrix;", "matrixTransformCoords", "", "tempCoords", "tempPoint", "Landroid/graphics/PointF;", "canRunSimultaneously", "", "a", "b", "isFinished", "state", "", "isTransformedTouchPointInView", "x", "y", "child", "Landroid/view/View;", "shouldHandlerBeCancelledBy", "handler", "other", "shouldHandlerWaitForOther", "shouldHandlerlessViewBecomeTouchTarget", ViewHierarchyConstants.VIEW_KEY, "coords", "transformPointToChildViewCoords", "", "parent", "Landroid/view/ViewGroup;", "outLocalPoint", "react-native-gesture-handler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isFinished(int state) {
            return state == 3 || state == 1 || state == 5;
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean shouldHandlerlessViewBecomeTouchTarget(View view, float[] coords) {
            return !((view instanceof ViewGroup) && view.getBackground() == null) && isTransformedTouchPointInView(coords[0], coords[1], view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void transformPointToChildViewCoords(float x, float y, ViewGroup parent, View child, PointF outLocalPoint) {
            float scrollX = (x + parent.getScrollX()) - child.getLeft();
            float scrollY = (y + parent.getScrollY()) - child.getTop();
            Matrix matrix = child.getMatrix();
            if (!matrix.isIdentity()) {
                float[] fArr = GestureHandlerOrchestrator.matrixTransformCoords;
                fArr[0] = scrollX;
                fArr[1] = scrollY;
                matrix.invert(GestureHandlerOrchestrator.inverseMatrix);
                GestureHandlerOrchestrator.inverseMatrix.mapPoints(fArr);
                float f = fArr[0];
                scrollY = fArr[1];
                scrollX = f;
            }
            outLocalPoint.set(scrollX, scrollY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isTransformedTouchPointInView(float x, float y, View child) {
            return 0.0f <= x && x <= ((float) child.getWidth()) && 0.0f <= y && y <= ((float) child.getHeight());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean shouldHandlerWaitForOther(GestureHandler<?> handler, GestureHandler<?> other) {
            return handler != other && (handler.shouldWaitForHandlerFailure(other) || other.shouldRequireToWaitForFailure(handler));
        }

        private final boolean canRunSimultaneously(GestureHandler<?> a2, GestureHandler<?> b) {
            return a2 == b || a2.shouldRecognizeSimultaneously(b) || b.shouldRecognizeSimultaneously(a2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean shouldHandlerBeCancelledBy(GestureHandler<?> handler, GestureHandler<?> other) {
            if (!handler.hasCommonPointers(other) || canRunSimultaneously(handler, other)) {
                return false;
            }
            if (handler == other || !(handler.getIsAwaiting() || handler.getState() == 4)) {
                return true;
            }
            return handler.shouldBeCancelledBy(other);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int handlersComparator$lambda$12(GestureHandler gestureHandler, GestureHandler gestureHandler2) {
        if ((gestureHandler.getIsActive() && gestureHandler2.getIsActive()) || (gestureHandler.getIsAwaiting() && gestureHandler2.getIsAwaiting())) {
            return Integer.signum(gestureHandler2.getActivationIndex() - gestureHandler.getActivationIndex());
        }
        if (!gestureHandler.getIsActive()) {
            if (!gestureHandler2.getIsActive()) {
                if (!gestureHandler.getIsAwaiting()) {
                    if (!gestureHandler2.getIsAwaiting()) {
                        return 0;
                    }
                }
            }
            return 1;
        }
        return -1;
    }
}
