package com.facebook.react.uimanager;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.uimanager.TouchTargetHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.PointerEvent;
import com.facebook.react.uimanager.events.PointerEventHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class JSPointerDispatcher {
    private static final float ONMOVE_EPSILON = 0.1f;
    private static final String TAG = "POINTER EVENTS";
    private static final int UNSELECTED_VIEW_TAG = -1;
    private static final int UNSET_POINTER_ID = -1;
    private static final int[] sRootScreenCoords = {0, 0};
    private Map<Integer, float[]> mLastEventCoordinatesByPointerId;
    private Map<Integer, List<TouchTargetHelper.ViewTarget>> mLastHitPathByPointerId;
    private final ViewGroup mRootViewGroup;
    private Set<Integer> mHoveringPointerIds = new HashSet();
    private int mChildHandlingNativeGesture = -1;
    private int mPrimaryPointerId = -1;
    private int mCoalescingKey = 0;
    private int mLastButtonState = 0;
    private Map<Integer, List<TouchTargetHelper.ViewTarget>> mCurrentlyDownPointerIdsToHitPath = new HashMap();

    public JSPointerDispatcher(ViewGroup viewGroup) {
        this.mRootViewGroup = viewGroup;
    }

    public void onChildStartedNativeGesture(View view, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        if (this.mChildHandlingNativeGesture != -1 || view == null) {
            return;
        }
        MotionEvent motionEventConvertMotionToRootFrame = convertMotionToRootFrame(view, motionEvent);
        motionEventConvertMotionToRootFrame.setAction(3);
        handleMotionEvent(motionEventConvertMotionToRootFrame, eventDispatcher, false);
        this.mChildHandlingNativeGesture = view.getId();
    }

    private MotionEvent convertMotionToRootFrame(View view, MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        this.mRootViewGroup.getLocationOnScreen(new int[2]);
        motionEventObtain.setLocation(motionEvent.getRawX() - r0[0], motionEvent.getRawY() - r0[1]);
        return motionEventObtain;
    }

    public void onChildEndedNativeGesture() {
        this.mChildHandlingNativeGesture = -1;
    }

    private static List<TouchTargetHelper.ViewTarget> findHitPathIntersection(List<TouchTargetHelper.ViewTarget> list, List<TouchTargetHelper.ViewTarget> list2) {
        if (list.isEmpty()) {
            return new ArrayList();
        }
        if (list2.isEmpty()) {
            return new ArrayList();
        }
        HashSet hashSet = new HashSet(list);
        ArrayList arrayList = new ArrayList();
        for (TouchTargetHelper.ViewTarget viewTarget : list2) {
            if (hashSet.contains(viewTarget)) {
                arrayList.add(viewTarget);
            }
        }
        return arrayList;
    }

    private void onUp(int i, PointerEvent.PointerEventState pointerEventState, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        int activePointerId = pointerEventState.getActivePointerId();
        List<TouchTargetHelper.ViewTarget> list = pointerEventState.getHitPathByPointerId().get(Integer.valueOf(activePointerId));
        if (isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.UP, PointerEventHelper.EVENT.UP_CAPTURE)) {
            eventDispatcher.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_UP, i, pointerEventState, motionEvent));
        }
        if (!this.mHoveringPointerIds.contains(Integer.valueOf(activePointerId))) {
            if (isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.OUT, PointerEventHelper.EVENT.OUT_CAPTURE)) {
                eventDispatcher.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_OUT, i, pointerEventState, motionEvent));
            }
            dispatchEventForViewTargets(PointerEventHelper.POINTER_LEAVE, pointerEventState, motionEvent, filterByShouldDispatch(list, PointerEventHelper.EVENT.LEAVE, PointerEventHelper.EVENT.LEAVE_CAPTURE, false), eventDispatcher);
        }
        List<TouchTargetHelper.ViewTarget> listRemove = this.mCurrentlyDownPointerIdsToHitPath.remove(Integer.valueOf(activePointerId));
        if (listRemove != null && isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.CLICK, PointerEventHelper.EVENT.CLICK_CAPTURE)) {
            List<TouchTargetHelper.ViewTarget> listFindHitPathIntersection = findHitPathIntersection(listRemove, list);
            if (!listFindHitPathIntersection.isEmpty()) {
                eventDispatcher.dispatchEvent(PointerEvent.obtain(PointerEventHelper.CLICK, listFindHitPathIntersection.get(0).getViewId(), pointerEventState, motionEvent));
            }
        }
        if (motionEvent.getActionMasked() == 1) {
            this.mPrimaryPointerId = -1;
        }
        this.mHoveringPointerIds.remove(Integer.valueOf(activePointerId));
    }

    private void incrementCoalescingKey() {
        this.mCoalescingKey = (this.mCoalescingKey + 1) % Integer.MAX_VALUE;
    }

    private short getCoalescingKey() {
        return (short) (65535 & this.mCoalescingKey);
    }

    private void onDown(int i, PointerEvent.PointerEventState pointerEventState, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        List<TouchTargetHelper.ViewTarget> list = pointerEventState.getHitPathByPointerId().get(Integer.valueOf(pointerEventState.getActivePointerId()));
        incrementCoalescingKey();
        if (!this.mHoveringPointerIds.contains(Integer.valueOf(pointerEventState.getActivePointerId()))) {
            if (isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.OVER, PointerEventHelper.EVENT.OVER_CAPTURE)) {
                eventDispatcher.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_OVER, i, pointerEventState, motionEvent));
            }
            List<TouchTargetHelper.ViewTarget> listFilterByShouldDispatch = filterByShouldDispatch(list, PointerEventHelper.EVENT.ENTER, PointerEventHelper.EVENT.ENTER_CAPTURE, false);
            Collections.reverse(listFilterByShouldDispatch);
            dispatchEventForViewTargets(PointerEventHelper.POINTER_ENTER, pointerEventState, motionEvent, listFilterByShouldDispatch, eventDispatcher);
        }
        if (isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.CLICK, PointerEventHelper.EVENT.CLICK_CAPTURE)) {
            this.mCurrentlyDownPointerIdsToHitPath.put(Integer.valueOf(pointerEventState.getActivePointerId()), new ArrayList(list));
        }
        if (isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.DOWN, PointerEventHelper.EVENT.DOWN_CAPTURE)) {
            eventDispatcher.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_DOWN, i, pointerEventState, motionEvent));
        }
    }

    private float[] eventCoordsToScreenCoords(float[] fArr) {
        this.mRootViewGroup.getLocationOnScreen(sRootScreenCoords);
        return new float[]{fArr[0] + r1[0], fArr[1] + r1[1]};
    }

    private PointerEvent.PointerEventState createEventState(int i, MotionEvent motionEvent) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
            float[] fArr = new float[2];
            float[] fArr2 = {motionEvent.getX(i2), motionEvent.getY(i2)};
            List<TouchTargetHelper.ViewTarget> listFindTargetPathAndCoordinatesForTouch = TouchTargetHelper.findTargetPathAndCoordinatesForTouch(fArr2[0], fArr2[1], this.mRootViewGroup, fArr);
            int pointerId = motionEvent.getPointerId(i2);
            map.put(Integer.valueOf(pointerId), fArr);
            map2.put(Integer.valueOf(pointerId), listFindTargetPathAndCoordinatesForTouch);
            map3.put(Integer.valueOf(pointerId), fArr2);
            map4.put(Integer.valueOf(pointerId), eventCoordsToScreenCoords(fArr2));
        }
        return new PointerEvent.PointerEventState(this.mPrimaryPointerId, i, this.mLastButtonState, UIManagerHelper.getSurfaceId(this.mRootViewGroup), map, map2, map3, map4, this.mHoveringPointerIds);
    }

    public void handleMotionEvent(MotionEvent motionEvent, EventDispatcher eventDispatcher, boolean z) {
        int viewId;
        View view;
        float[] fArr;
        if (this.mChildHandlingNativeGesture != -1) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        if (actionMasked == 0) {
            this.mPrimaryPointerId = motionEvent.getPointerId(0);
        } else if (actionMasked == 7) {
            this.mHoveringPointerIds.add(Integer.valueOf(pointerId));
        }
        PointerEvent.PointerEventState pointerEventStateCreateEventState = createEventState(pointerId, motionEvent);
        boolean z2 = z && motionEvent.getActionMasked() == 10;
        if (z2) {
            Map<Integer, List<TouchTargetHelper.ViewTarget>> map = this.mLastHitPathByPointerId;
            List<TouchTargetHelper.ViewTarget> list = map != null ? map.get(Integer.valueOf(pointerEventStateCreateEventState.getActivePointerId())) : null;
            if (list == null || list.isEmpty()) {
                return;
            }
            TouchTargetHelper.ViewTarget viewTarget = list.get(list.size() - 1);
            viewId = viewTarget.getViewId();
            view = viewTarget.getView();
            pointerEventStateCreateEventState.getHitPathByPointerId().put(Integer.valueOf(pointerId), new ArrayList());
        } else {
            List<TouchTargetHelper.ViewTarget> list2 = pointerEventStateCreateEventState.getHitPathByPointerId().get(Integer.valueOf(pointerId));
            if (list2 == null || list2.isEmpty()) {
                return;
            }
            TouchTargetHelper.ViewTarget viewTarget2 = list2.get(0);
            viewId = viewTarget2.getViewId();
            view = viewTarget2.getView();
        }
        handleHitStateDivergence(viewId, pointerEventStateCreateEventState, motionEvent, eventDispatcher);
        switch (actionMasked) {
            case 0:
            case 5:
                onDown(viewId, pointerEventStateCreateEventState, motionEvent, eventDispatcher);
                break;
            case 1:
            case 6:
                incrementCoalescingKey();
                onUp(viewId, pointerEventStateCreateEventState, motionEvent, eventDispatcher);
                break;
            case 2:
                onMove(viewId, pointerEventStateCreateEventState, motionEvent, eventDispatcher);
                break;
            case 3:
                dispatchCancelEventForTarget(view, pointerEventStateCreateEventState, motionEvent, eventDispatcher);
                handleHitStateDivergence(-1, pointerEventStateCreateEventState, motionEvent, eventDispatcher);
                break;
            case 4:
            case 8:
            default:
                FLog.w("ReactNative", "Motion Event was ignored. Action=" + actionMasked + " Target=" + viewId);
                return;
            case 7:
                float[] fArr2 = pointerEventStateCreateEventState.getEventCoordinatesByPointerId().get(Integer.valueOf(pointerId));
                Map<Integer, float[]> map2 = this.mLastEventCoordinatesByPointerId;
                if (map2 != null && map2.containsKey(Integer.valueOf(pointerId))) {
                    fArr = this.mLastEventCoordinatesByPointerId.get(Integer.valueOf(pointerId));
                } else {
                    fArr = new float[]{0.0f, 0.0f};
                }
                if (qualifiedMove(fArr2, fArr)) {
                    onMove(viewId, pointerEventStateCreateEventState, motionEvent, eventDispatcher);
                    break;
                } else {
                    return;
                }
            case 9:
                return;
            case 10:
                if (z2) {
                    onMove(viewId, pointerEventStateCreateEventState, motionEvent, eventDispatcher);
                    break;
                }
                break;
        }
        this.mLastEventCoordinatesByPointerId = new HashMap(pointerEventStateCreateEventState.getEventCoordinatesByPointerId());
        this.mLastButtonState = motionEvent.getButtonState();
        this.mHoveringPointerIds.retainAll(this.mLastEventCoordinatesByPointerId.keySet());
    }

    private static boolean isAnyoneListeningForBubblingEvent(List<TouchTargetHelper.ViewTarget> list, PointerEventHelper.EVENT event, PointerEventHelper.EVENT event2) {
        for (TouchTargetHelper.ViewTarget viewTarget : list) {
            if (PointerEventHelper.isListening(viewTarget.getView(), event) || PointerEventHelper.isListening(viewTarget.getView(), event2)) {
                return true;
            }
        }
        return false;
    }

    private static List<TouchTargetHelper.ViewTarget> filterByShouldDispatch(List<TouchTargetHelper.ViewTarget> list, PointerEventHelper.EVENT event, PointerEventHelper.EVENT event2, boolean z) {
        ArrayList arrayList = new ArrayList(list);
        if (z) {
            return arrayList;
        }
        boolean z2 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            View view = list.get(size).getView();
            if (!z2 && !PointerEventHelper.isListening(view, event2) && !PointerEventHelper.isListening(view, event)) {
                arrayList.remove(size);
            } else if (!z2 && PointerEventHelper.isListening(view, event2)) {
                z2 = true;
            }
        }
        return arrayList;
    }

    private static void dispatchEventForViewTargets(String str, PointerEvent.PointerEventState pointerEventState, MotionEvent motionEvent, List<TouchTargetHelper.ViewTarget> list, EventDispatcher eventDispatcher) {
        Iterator<TouchTargetHelper.ViewTarget> it = list.iterator();
        while (it.hasNext()) {
            eventDispatcher.dispatchEvent(PointerEvent.obtain(str, it.next().getViewId(), pointerEventState, motionEvent));
        }
    }

    private static boolean qualifiedMove(float[] fArr, float[] fArr2) {
        return Math.abs(fArr2[0] - fArr[0]) > 0.1f || Math.abs(fArr2[1] - fArr[1]) > 0.1f;
    }

    private void handleHitStateDivergence(int i, PointerEvent.PointerEventState pointerEventState, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        List<TouchTargetHelper.ViewTarget> arrayList;
        List<TouchTargetHelper.ViewTarget> arrayList2;
        int activePointerId = pointerEventState.getActivePointerId();
        if (i != -1) {
            arrayList = pointerEventState.getHitPathByPointerId().get(Integer.valueOf(activePointerId));
        } else {
            arrayList = new ArrayList<>();
        }
        Map<Integer, List<TouchTargetHelper.ViewTarget>> map = this.mLastHitPathByPointerId;
        if (map != null && map.containsKey(Integer.valueOf(activePointerId))) {
            arrayList2 = this.mLastHitPathByPointerId.get(Integer.valueOf(activePointerId));
        } else {
            arrayList2 = new ArrayList<>();
        }
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (i2 < Math.min(arrayList.size(), arrayList2.size()) && arrayList.get((arrayList.size() - 1) - i2).equals(arrayList2.get((arrayList2.size() - 1) - i2))) {
            View view = arrayList.get((arrayList.size() - 1) - i2).getView();
            if (!z && PointerEventHelper.isListening(view, PointerEventHelper.EVENT.ENTER_CAPTURE)) {
                z = true;
            }
            if (!z2 && PointerEventHelper.isListening(view, PointerEventHelper.EVENT.LEAVE_CAPTURE)) {
                z2 = true;
            }
            i2++;
        }
        if (i2 < Math.max(arrayList.size(), arrayList2.size())) {
            incrementCoalescingKey();
            if (arrayList2.size() > 0) {
                int viewId = arrayList2.get(0).getViewId();
                if (isAnyoneListeningForBubblingEvent(arrayList2, PointerEventHelper.EVENT.OUT, PointerEventHelper.EVENT.OUT_CAPTURE)) {
                    eventDispatcher.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_OUT, viewId, pointerEventState, motionEvent));
                }
                List<TouchTargetHelper.ViewTarget> listFilterByShouldDispatch = filterByShouldDispatch(arrayList2.subList(0, arrayList2.size() - i2), PointerEventHelper.EVENT.LEAVE, PointerEventHelper.EVENT.LEAVE_CAPTURE, z2);
                if (listFilterByShouldDispatch.size() > 0) {
                    dispatchEventForViewTargets(PointerEventHelper.POINTER_LEAVE, pointerEventState, motionEvent, listFilterByShouldDispatch, eventDispatcher);
                }
            }
            if (isAnyoneListeningForBubblingEvent(arrayList, PointerEventHelper.EVENT.OVER, PointerEventHelper.EVENT.OVER_CAPTURE)) {
                eventDispatcher.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_OVER, i, pointerEventState, motionEvent));
            }
            List<TouchTargetHelper.ViewTarget> listFilterByShouldDispatch2 = filterByShouldDispatch(arrayList.subList(0, arrayList.size() - i2), PointerEventHelper.EVENT.ENTER, PointerEventHelper.EVENT.ENTER_CAPTURE, z);
            if (listFilterByShouldDispatch2.size() > 0) {
                Collections.reverse(listFilterByShouldDispatch2);
                dispatchEventForViewTargets(PointerEventHelper.POINTER_ENTER, pointerEventState, motionEvent, listFilterByShouldDispatch2, eventDispatcher);
            }
        }
        HashMap map2 = new HashMap(pointerEventState.getHitPathByPointerId());
        if (i == -1) {
            map2.remove(Integer.valueOf(activePointerId));
        }
        this.mLastHitPathByPointerId = map2;
    }

    private void onMove(int i, PointerEvent.PointerEventState pointerEventState, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        if (isAnyoneListeningForBubblingEvent(pointerEventState.getHitPathByPointerId().get(Integer.valueOf(pointerEventState.getActivePointerId())), PointerEventHelper.EVENT.MOVE, PointerEventHelper.EVENT.MOVE_CAPTURE)) {
            eventDispatcher.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_MOVE, i, pointerEventState, motionEvent, getCoalescingKey()));
        }
    }

    private void dispatchCancelEventForTarget(View view, PointerEvent.PointerEventState pointerEventState, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        Assertions.assertCondition(this.mChildHandlingNativeGesture == -1, "Expected to not have already sent a cancel for this gesture");
        List<TouchTargetHelper.ViewTarget> list = pointerEventState.getHitPathByPointerId().get(Integer.valueOf(pointerEventState.getActivePointerId()));
        if (list.isEmpty() || view == null) {
            return;
        }
        if (isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.CANCEL, PointerEventHelper.EVENT.CANCEL_CAPTURE)) {
            int viewId = list.get(0).getViewId();
            int[] childOffsetRelativeToRoot = getChildOffsetRelativeToRoot(view);
            ((EventDispatcher) Assertions.assertNotNull(eventDispatcher)).dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_CANCEL, viewId, normalizeToRoot(pointerEventState, childOffsetRelativeToRoot[0], childOffsetRelativeToRoot[1]), motionEvent));
        }
        incrementCoalescingKey();
        this.mPrimaryPointerId = -1;
    }

    private int[] getChildOffsetRelativeToRoot(View view) {
        Rect rect = new Rect(0, 0, 1, 1);
        this.mRootViewGroup.offsetDescendantRectToMyCoords(view, rect);
        return new int[]{rect.top, rect.left};
    }

    private PointerEvent.PointerEventState normalizeToRoot(PointerEvent.PointerEventState pointerEventState, float f, float f2) {
        HashMap map = new HashMap(pointerEventState.getOffsetByPointerId());
        HashMap map2 = new HashMap(pointerEventState.getEventCoordinatesByPointerId());
        HashMap map3 = new HashMap(pointerEventState.getScreenCoordinatesByPointerId());
        float[] fArr = {f, f2};
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            ((Map.Entry) it.next()).setValue(fArr);
        }
        float[] fArr2 = {0.0f, 0.0f};
        Iterator it2 = map2.entrySet().iterator();
        while (it2.hasNext()) {
            ((Map.Entry) it2.next()).setValue(fArr2);
        }
        float[] fArrEventCoordsToScreenCoords = eventCoordsToScreenCoords(fArr);
        Iterator it3 = map3.entrySet().iterator();
        while (it3.hasNext()) {
            ((Map.Entry) it3.next()).setValue(fArrEventCoordsToScreenCoords);
        }
        return new PointerEvent.PointerEventState(pointerEventState.getPrimaryPointerId(), pointerEventState.getActivePointerId(), pointerEventState.getLastButtonState(), pointerEventState.getSurfaceId(), map, new HashMap(pointerEventState.getHitPathByPointerId()), map2, map3, new HashSet(pointerEventState.getHoveringPointerIds()));
    }

    private static void debugPrintHitPath(List<TouchTargetHelper.ViewTarget> list) {
        StringBuilder sb = new StringBuilder("hitPath: ");
        Iterator<TouchTargetHelper.ViewTarget> it = list.iterator();
        while (it.hasNext()) {
            sb.append(String.format("%d, ", Integer.valueOf(it.next().getViewId())));
        }
        FLog.d(TAG, sb.toString());
    }
}
