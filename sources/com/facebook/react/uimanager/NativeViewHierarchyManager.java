package com.facebook.react.uimanager;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.common.logging.FLog;
import com.facebook.react.R;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationController;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationListener;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.facebook.yoga.YogaDirection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes4.dex */
public class NativeViewHierarchyManager {
    private static final String TAG = "NativeViewHierarchyManager";
    private final boolean DEBUG_MODE;
    private final RectF mBoundingBox;
    private final JSResponderHandler mJSResponderHandler;
    private volatile boolean mLayoutAnimationEnabled;
    private final LayoutAnimationController mLayoutAnimator;
    private HashMap<Integer, Set<Integer>> mPendingDeletionsForTag;
    private final SparseBooleanArray mRootTags;
    private final RootViewManager mRootViewManager;
    private final SparseArray<ViewManager> mTagsToViewManagers;
    private final SparseArray<View> mTagsToViews;
    private final ViewManagerRegistry mViewManagers;

    public NativeViewHierarchyManager(ViewManagerRegistry viewManagerRegistry) {
        this(viewManagerRegistry, new RootViewManager());
    }

    public NativeViewHierarchyManager(ViewManagerRegistry viewManagerRegistry, RootViewManager rootViewManager) {
        boolean z = ReactBuildConfig.DEBUG;
        this.DEBUG_MODE = false;
        this.mJSResponderHandler = new JSResponderHandler();
        this.mLayoutAnimator = new LayoutAnimationController();
        this.mBoundingBox = new RectF();
        this.mViewManagers = viewManagerRegistry;
        this.mTagsToViews = new SparseArray<>();
        this.mTagsToViewManagers = new SparseArray<>();
        this.mRootTags = new SparseBooleanArray();
        this.mRootViewManager = rootViewManager;
    }

    public final synchronized View resolveView(int i) {
        View view;
        view = this.mTagsToViews.get(i);
        if (view == null) {
            throw new IllegalViewOperationException("Trying to resolve view with tag " + i + " which doesn't exist");
        }
        return view;
    }

    public final synchronized ViewManager resolveViewManager(int i) {
        ViewManager viewManager;
        viewManager = this.mTagsToViewManagers.get(i);
        if (viewManager == null) {
            throw new IllegalViewOperationException("ViewManager for tag " + i + " could not be found.\n");
        }
        return viewManager;
    }

    public void setLayoutAnimationEnabled(boolean z) {
        this.mLayoutAnimationEnabled = z;
    }

    public synchronized void updateInstanceHandle(int i, long j) {
        UiThreadUtil.assertOnUiThread();
        try {
            updateInstanceHandle(resolveView(i), j);
        } catch (IllegalViewOperationException e) {
            FLog.e(TAG, "Unable to update properties for view tag " + i, e);
        }
    }

    public synchronized void updateProperties(int i, ReactStylesDiffMap reactStylesDiffMap) {
        if (this.DEBUG_MODE) {
            FLog.d(TAG, "updateProperties[%d]: %s", Integer.valueOf(i), reactStylesDiffMap.toString());
        }
        UiThreadUtil.assertOnUiThread();
        try {
            ViewManager viewManagerResolveViewManager = resolveViewManager(i);
            View viewResolveView = resolveView(i);
            if (reactStylesDiffMap != null) {
                viewManagerResolveViewManager.updateProperties(viewResolveView, reactStylesDiffMap);
            }
        } catch (IllegalViewOperationException e) {
            FLog.e(TAG, "Unable to update properties for view tag " + i, e);
        }
    }

    public synchronized void updateViewExtraData(int i, Object obj) {
        if (this.DEBUG_MODE) {
            FLog.d(TAG, "updateViewExtraData[%d]: %s", Integer.valueOf(i), obj.toString());
        }
        UiThreadUtil.assertOnUiThread();
        resolveViewManager(i).updateExtraData(resolveView(i), obj);
    }

    @Deprecated
    public void updateLayout(int i, int i2, int i3, int i4, int i5) {
        updateLayout(i, i, i2, i3, i4, i5, YogaDirection.INHERIT);
    }

    public synchronized void updateLayout(int i, int i2, int i3, int i4, int i5, int i6, YogaDirection yogaDirection) {
        if (this.DEBUG_MODE) {
            FLog.d(TAG, "updateLayout[%d]->[%d]: %d %d %d %d", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
        }
        UiThreadUtil.assertOnUiThread();
        SystraceMessage.beginSection(0L, "NativeViewHierarchyManager_updateLayout").arg("parentTag", i).arg("tag", i2).flush();
        try {
            View viewResolveView = resolveView(i2);
            if (ReactNativeFeatureFlags.setAndroidLayoutDirection()) {
                viewResolveView.setLayoutDirection(LayoutDirectionUtil.toAndroidFromYoga(yogaDirection));
            }
            viewResolveView.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(i6, 1073741824));
            ViewParent parent = viewResolveView.getParent();
            if (parent instanceof RootView) {
                parent.requestLayout();
            }
            if (!this.mRootTags.get(i)) {
                NativeModule nativeModule = (ViewManager) this.mTagsToViewManagers.get(i);
                if (nativeModule instanceof IViewManagerWithChildren) {
                    IViewManagerWithChildren iViewManagerWithChildren = (IViewManagerWithChildren) nativeModule;
                    if (iViewManagerWithChildren != null && !iViewManagerWithChildren.needsCustomLayoutForChildren()) {
                        updateLayout(viewResolveView, i3, i4, i5, i6);
                    }
                } else {
                    throw new IllegalViewOperationException("Trying to use view with tag " + i + " as a parent, but its Manager doesn't implement IViewManagerWithChildren");
                }
            } else {
                updateLayout(viewResolveView, i3, i4, i5, i6);
            }
        } finally {
            Systrace.endSection(0L);
        }
    }

    private void updateInstanceHandle(View view, long j) {
        UiThreadUtil.assertOnUiThread();
        view.setTag(R.id.view_tag_instance_handle, Long.valueOf(j));
    }

    public synchronized long getInstanceHandle(int i) {
        Long l;
        View view = this.mTagsToViews.get(i);
        if (view == null) {
            throw new IllegalViewOperationException("Unable to find view for tag: " + i);
        }
        l = (Long) view.getTag(R.id.view_tag_instance_handle);
        if (l == null) {
            throw new IllegalViewOperationException("Unable to find instanceHandle for tag: " + i);
        }
        return l.longValue();
    }

    private void updateLayout(View view, int i, int i2, int i3, int i4) {
        if (this.mLayoutAnimationEnabled && this.mLayoutAnimator.shouldAnimateLayout(view)) {
            this.mLayoutAnimator.applyLayoutUpdate(view, i, i2, i3, i4);
        } else {
            view.layout(i, i2, i3 + i, i4 + i2);
        }
    }

    public synchronized void createView(ThemedReactContext themedReactContext, int i, String str, ReactStylesDiffMap reactStylesDiffMap) {
        if (this.DEBUG_MODE) {
            FLog.d(TAG, "createView[%d]: %s %s", Integer.valueOf(i), str, reactStylesDiffMap != null ? reactStylesDiffMap.toString() : "<null>");
        }
        UiThreadUtil.assertOnUiThread();
        SystraceMessage.beginSection(0L, "NativeViewHierarchyManager_createView").arg("tag", i).arg("className", str).flush();
        try {
            ViewManager viewManager = this.mViewManagers.get(str);
            this.mTagsToViews.put(i, viewManager.createView(i, themedReactContext, reactStylesDiffMap, null, this.mJSResponderHandler));
            this.mTagsToViewManagers.put(i, viewManager);
        } finally {
            Systrace.endSection(0L);
        }
    }

    private static String constructManageChildrenErrorMessage(ViewGroup viewGroup, ViewGroupManager viewGroupManager, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2) {
        StringBuilder sb = new StringBuilder();
        if (viewGroup != null) {
            sb.append("View tag:" + viewGroup.getId() + " View Type:" + viewGroup.getClass().toString() + "\n");
            sb.append("  children(" + viewGroupManager.getChildCount((ViewGroupManager) viewGroup) + "): [\n");
            for (int i = 0; viewGroupManager.getChildAt((ViewGroupManager) viewGroup, i) != null; i += 16) {
                int i2 = 0;
                while (true) {
                    int i3 = i + i2;
                    if (viewGroupManager.getChildAt((ViewGroupManager) viewGroup, i3) == null || i2 >= 16) {
                        break;
                    }
                    sb.append(viewGroupManager.getChildAt((ViewGroupManager) viewGroup, i3).getId() + ",");
                    i2++;
                }
                sb.append("\n");
            }
            sb.append(" ],\n");
        }
        if (iArr != null) {
            sb.append("  indicesToRemove(" + iArr.length + "): [\n");
            for (int i4 = 0; i4 < iArr.length; i4 += 16) {
                int i5 = 0;
                while (true) {
                    int i6 = i4 + i5;
                    if (i6 >= iArr.length || i5 >= 16) {
                        break;
                    }
                    sb.append(iArr[i6] + ",");
                    i5++;
                }
                sb.append("\n");
            }
            sb.append(" ],\n");
        }
        if (viewAtIndexArr != null) {
            sb.append("  viewsToAdd(" + viewAtIndexArr.length + "): [\n");
            for (int i7 = 0; i7 < viewAtIndexArr.length; i7 += 16) {
                int i8 = 0;
                while (true) {
                    int i9 = i7 + i8;
                    if (i9 >= viewAtIndexArr.length || i8 >= 16) {
                        break;
                    }
                    sb.append("[" + viewAtIndexArr[i9].mIndex + "," + viewAtIndexArr[i9].mTag + "],");
                    i8++;
                }
                sb.append("\n");
            }
            sb.append(" ],\n");
        }
        if (iArr2 != null) {
            sb.append("  tagsToDelete(" + iArr2.length + "): [\n");
            for (int i10 = 0; i10 < iArr2.length; i10 += 16) {
                int i11 = 0;
                while (true) {
                    int i12 = i10 + i11;
                    if (i12 >= iArr2.length || i11 >= 16) {
                        break;
                    }
                    sb.append(iArr2[i12] + ",");
                    i11++;
                }
                sb.append("\n");
            }
            sb.append(" ]\n");
        }
        return sb.toString();
    }

    private Set<Integer> getPendingDeletionsForTag(int i) {
        if (this.mPendingDeletionsForTag == null) {
            this.mPendingDeletionsForTag = new HashMap<>();
        }
        if (!this.mPendingDeletionsForTag.containsKey(Integer.valueOf(i))) {
            this.mPendingDeletionsForTag.put(Integer.valueOf(i), new HashSet());
        }
        return this.mPendingDeletionsForTag.get(Integer.valueOf(i));
    }

    public synchronized void manageChildren(final int i, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2) {
        int i2;
        int[] iArr3 = iArr;
        synchronized (this) {
            if (this.DEBUG_MODE) {
                FLog.d(TAG, "createView[%d]: %s %s %s", Integer.valueOf(i), iArr3 != null ? iArr.toString() : "<null>", viewAtIndexArr != null ? viewAtIndexArr.toString() : "<null>", iArr2 != null ? iArr2.toString() : "<null>");
            }
            UiThreadUtil.assertOnUiThread();
            final Set<Integer> pendingDeletionsForTag = getPendingDeletionsForTag(i);
            final ViewGroup viewGroup = (ViewGroup) this.mTagsToViews.get(i);
            final ViewGroupManager viewGroupManager = (ViewGroupManager) resolveViewManager(i);
            if (viewGroup == null) {
                throw new IllegalViewOperationException("Trying to manageChildren view with tag " + i + " which doesn't exist\n detail: " + constructManageChildrenErrorMessage(viewGroup, viewGroupManager, iArr3, viewAtIndexArr, iArr2));
            }
            int childCount = viewGroupManager.getChildCount((ViewGroupManager) viewGroup);
            if (iArr3 != null) {
                int length = iArr3.length - 1;
                while (length >= 0) {
                    int i3 = iArr3[length];
                    if (i3 < 0) {
                        throw new IllegalViewOperationException("Trying to remove a negative view index:" + i3 + " view tag: " + i + "\n detail: " + constructManageChildrenErrorMessage(viewGroup, viewGroupManager, iArr3, viewAtIndexArr, iArr2));
                    }
                    if (viewGroupManager.getChildAt((ViewGroupManager) viewGroup, i3) == null) {
                        if (!this.mRootTags.get(i) || viewGroupManager.getChildCount((ViewGroupManager) viewGroup) != 0) {
                            throw new IllegalViewOperationException("Trying to remove a view index above child count " + i3 + " view tag: " + i + "\n detail: " + constructManageChildrenErrorMessage(viewGroup, viewGroupManager, iArr3, viewAtIndexArr, iArr2));
                        }
                        return;
                    } else {
                        if (i3 >= childCount) {
                            throw new IllegalViewOperationException("Trying to remove an out of order view index:" + i3 + " view tag: " + i + "\n detail: " + constructManageChildrenErrorMessage(viewGroup, viewGroupManager, iArr3, viewAtIndexArr, iArr2));
                        }
                        View childAt = viewGroupManager.getChildAt((ViewGroupManager) viewGroup, i3);
                        if (!this.mLayoutAnimationEnabled || !this.mLayoutAnimator.shouldAnimateLayout(childAt) || !arrayContains(iArr2, childAt.getId())) {
                            viewGroupManager.removeViewAt((ViewGroupManager) viewGroup, i3);
                        }
                        length--;
                        childCount = i3;
                    }
                }
            }
            if (iArr2 != null) {
                int i4 = 0;
                while (i4 < iArr2.length) {
                    int i5 = iArr2[i4];
                    final View view = this.mTagsToViews.get(i5);
                    if (view == null) {
                        throw new IllegalViewOperationException("Trying to destroy unknown view tag: " + i5 + "\n detail: " + constructManageChildrenErrorMessage(viewGroup, viewGroupManager, iArr, viewAtIndexArr, iArr2));
                    }
                    if (this.mLayoutAnimationEnabled && this.mLayoutAnimator.shouldAnimateLayout(view)) {
                        pendingDeletionsForTag.add(Integer.valueOf(i5));
                        i2 = i4;
                        this.mLayoutAnimator.deleteView(view, new LayoutAnimationListener() { // from class: com.facebook.react.uimanager.NativeViewHierarchyManager.1
                            @Override // com.facebook.react.uimanager.layoutanimation.LayoutAnimationListener
                            public void onAnimationEnd() {
                                UiThreadUtil.assertOnUiThread();
                                viewGroupManager.removeView(viewGroup, view);
                                NativeViewHierarchyManager.this.dropView(view);
                                pendingDeletionsForTag.remove(Integer.valueOf(view.getId()));
                                if (pendingDeletionsForTag.isEmpty()) {
                                    NativeViewHierarchyManager.this.mPendingDeletionsForTag.remove(Integer.valueOf(i));
                                }
                            }
                        });
                    } else {
                        i2 = i4;
                        dropView(view);
                    }
                    i4 = i2 + 1;
                    iArr3 = iArr;
                }
            }
            int[] iArr4 = iArr3;
            if (viewAtIndexArr != null) {
                for (ViewAtIndex viewAtIndex : viewAtIndexArr) {
                    View view2 = this.mTagsToViews.get(viewAtIndex.mTag);
                    if (view2 == null) {
                        throw new IllegalViewOperationException("Trying to add unknown view tag: " + viewAtIndex.mTag + "\n detail: " + constructManageChildrenErrorMessage(viewGroup, viewGroupManager, iArr4, viewAtIndexArr, iArr2));
                    }
                    int i6 = viewAtIndex.mIndex;
                    if (!pendingDeletionsForTag.isEmpty()) {
                        i6 = 0;
                        int i7 = 0;
                        while (i6 < viewGroup.getChildCount() && i7 != viewAtIndex.mIndex) {
                            if (!pendingDeletionsForTag.contains(Integer.valueOf(viewGroup.getChildAt(i6).getId()))) {
                                i7++;
                            }
                            i6++;
                        }
                    }
                    viewGroupManager.addView((ViewGroupManager) viewGroup, view2, i6);
                }
            }
            if (pendingDeletionsForTag.isEmpty()) {
                this.mPendingDeletionsForTag.remove(Integer.valueOf(i));
            }
        }
    }

    private boolean arrayContains(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private static String constructSetChildrenErrorMessage(ViewGroup viewGroup, ViewGroupManager viewGroupManager, ReadableArray readableArray) {
        ViewAtIndex[] viewAtIndexArr = new ViewAtIndex[readableArray.size()];
        for (int i = 0; i < readableArray.size(); i++) {
            viewAtIndexArr[i] = new ViewAtIndex(readableArray.getInt(i), i);
        }
        return constructManageChildrenErrorMessage(viewGroup, viewGroupManager, null, viewAtIndexArr, null);
    }

    public synchronized void setChildren(int i, ReadableArray readableArray) {
        if (this.DEBUG_MODE) {
            FLog.d(TAG, "setChildren[%d]: %s", Integer.valueOf(i), readableArray != null ? readableArray.toString() : "<null>");
        }
        UiThreadUtil.assertOnUiThread();
        ViewGroup viewGroup = (ViewGroup) this.mTagsToViews.get(i);
        ViewGroupManager viewGroupManager = (ViewGroupManager) resolveViewManager(i);
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            View view = this.mTagsToViews.get(readableArray.getInt(i2));
            if (view == null) {
                throw new IllegalViewOperationException("Trying to add unknown view tag: " + readableArray.getInt(i2) + "\n detail: " + constructSetChildrenErrorMessage(viewGroup, viewGroupManager, readableArray));
            }
            viewGroupManager.addView((ViewGroupManager) viewGroup, view, i2);
        }
    }

    public synchronized void addRootView(int i, View view) {
        addRootViewGroup(i, view);
    }

    protected final synchronized void addRootViewGroup(int i, View view) {
        if (this.DEBUG_MODE) {
            FLog.d(TAG, "addRootViewGroup[%d]: %s", Integer.valueOf(i), view != null ? view.toString() : "<null>");
        }
        if (view.getId() != -1) {
            FLog.e(TAG, "Trying to add a root view with an explicit id (" + view.getId() + ") already set. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID before calling addRootView.");
        }
        this.mTagsToViews.put(i, view);
        this.mTagsToViewManagers.put(i, this.mRootViewManager);
        this.mRootTags.put(i, true);
        view.setId(i);
    }

    protected synchronized void dropView(View view) {
        if (this.DEBUG_MODE) {
            FLog.d(TAG, "dropView[%d]", Integer.valueOf(view != null ? view.getId() : -1));
        }
        UiThreadUtil.assertOnUiThread();
        if (view == null) {
            return;
        }
        if (this.mTagsToViewManagers.get(view.getId()) == null) {
            return;
        }
        if (!this.mRootTags.get(view.getId())) {
            resolveViewManager(view.getId()).onDropViewInstance(view);
        }
        ViewManager viewManager = this.mTagsToViewManagers.get(view.getId());
        if ((view instanceof ViewGroup) && (viewManager instanceof ViewGroupManager)) {
            ViewGroup viewGroup = (ViewGroup) view;
            ViewGroupManager viewGroupManager = (ViewGroupManager) viewManager;
            for (int childCount = viewGroupManager.getChildCount((ViewGroupManager) viewGroup) - 1; childCount >= 0; childCount--) {
                View childAt = viewGroupManager.getChildAt((ViewGroupManager) viewGroup, childCount);
                if (childAt == null) {
                    FLog.e(TAG, "Unable to drop null child view");
                } else if (this.mTagsToViews.get(childAt.getId()) != null) {
                    dropView(childAt);
                }
            }
            viewGroupManager.removeAllViews(viewGroup);
        }
        this.mTagsToViews.remove(view.getId());
        this.mTagsToViewManagers.remove(view.getId());
    }

    public synchronized void removeRootView(int i) {
        if (this.DEBUG_MODE) {
            FLog.d(TAG, "removeRootView[%d]", Integer.valueOf(i));
        }
        UiThreadUtil.assertOnUiThread();
        if (!this.mRootTags.get(i)) {
            SoftAssertions.assertUnreachable("View with tag " + i + " is not registered as a root view");
        }
        dropView(this.mTagsToViews.get(i));
        this.mRootTags.delete(i);
    }

    public synchronized int getRootViewNum() {
        return this.mRootTags.size();
    }

    public synchronized void measure(int i, int[] iArr) {
        if (this.DEBUG_MODE) {
            FLog.d(TAG, "measure[%d]", Integer.valueOf(i));
        }
        UiThreadUtil.assertOnUiThread();
        View view = this.mTagsToViews.get(i);
        if (view == null) {
            throw new NoSuchNativeViewException("No native view for " + i + " currently exists");
        }
        View view2 = (View) RootViewUtil.getRootView(view);
        if (view2 == null) {
            throw new NoSuchNativeViewException("Native view " + i + " is no longer on screen");
        }
        computeBoundingBox(view2, iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        computeBoundingBox(view, iArr);
        iArr[0] = iArr[0] - i2;
        iArr[1] = iArr[1] - i3;
    }

    private void computeBoundingBox(View view, int[] iArr) {
        this.mBoundingBox.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        mapRectFromViewToWindowCoords(view, this.mBoundingBox);
        iArr[0] = Math.round(this.mBoundingBox.left);
        iArr[1] = Math.round(this.mBoundingBox.top);
        iArr[2] = Math.round(this.mBoundingBox.right - this.mBoundingBox.left);
        iArr[3] = Math.round(this.mBoundingBox.bottom - this.mBoundingBox.top);
    }

    private void mapRectFromViewToWindowCoords(View view, RectF rectF) {
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            matrix.mapRect(rectF);
        }
        rectF.offset(view.getLeft(), view.getTop());
        Object parent = view.getParent();
        while (parent instanceof View) {
            View view2 = (View) parent;
            rectF.offset(-view2.getScrollX(), -view2.getScrollY());
            Matrix matrix2 = view2.getMatrix();
            if (!matrix2.isIdentity()) {
                matrix2.mapRect(rectF);
            }
            rectF.offset(view2.getLeft(), view2.getTop());
            parent = view2.getParent();
        }
    }

    public synchronized void measureInWindow(int i, int[] iArr) {
        if (this.DEBUG_MODE) {
            FLog.d(TAG, "measureInWindow[%d]", Integer.valueOf(i));
        }
        UiThreadUtil.assertOnUiThread();
        View view = this.mTagsToViews.get(i);
        if (view == null) {
            throw new NoSuchNativeViewException("No native view for " + i + " currently exists");
        }
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        iArr[0] = iArr[0] - rect.left;
        iArr[1] = iArr[1] - rect.top;
        iArr[2] = view.getWidth();
        iArr[3] = view.getHeight();
    }

    public synchronized int findTargetTagForTouch(int i, float f, float f2) {
        View view;
        if (this.DEBUG_MODE) {
            FLog.d(TAG, "findTargetTagForTouch[%d]: %f %f", Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2));
        }
        UiThreadUtil.assertOnUiThread();
        view = this.mTagsToViews.get(i);
        if (view == null) {
            throw new JSApplicationIllegalArgumentException("Could not find view with tag " + i);
        }
        return TouchTargetHelper.findTargetTagForTouch(f, f2, (ViewGroup) view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void setJSResponder(int i, int i2, boolean z) {
        if (!z) {
            this.mJSResponderHandler.setJSResponder(i2, null);
            return;
        }
        View view = this.mTagsToViews.get(i);
        if (i2 != i && (view instanceof ViewParent)) {
            this.mJSResponderHandler.setJSResponder(i2, (ViewParent) view);
            return;
        }
        if (this.mRootTags.get(i)) {
            SoftAssertions.assertUnreachable("Cannot block native responder on " + i + " that is a root view");
        }
        this.mJSResponderHandler.setJSResponder(i2, view.getParent());
    }

    public synchronized void clearJSResponder() {
        this.mJSResponderHandler.clearJSResponder();
    }

    synchronized void configureLayoutAnimation(ReadableMap readableMap, Callback callback) {
        this.mLayoutAnimator.initializeFromConfig(readableMap, callback);
    }

    synchronized void clearLayoutAnimation() {
        this.mLayoutAnimator.reset();
    }

    @Deprecated
    public synchronized void dispatchCommand(int i, int i2, ReadableArray readableArray) {
        if (this.DEBUG_MODE) {
            FLog.d(TAG, "dispatchCommand[%d]: %d %s", Integer.valueOf(i), Integer.valueOf(i2), readableArray != null ? readableArray.toString() : "<null>");
        }
        UiThreadUtil.assertOnUiThread();
        View view = this.mTagsToViews.get(i);
        if (view == null) {
            throw new RetryableMountingLayerException("Trying to send command to a non-existing view with tag [" + i + "] and command " + i2);
        }
        resolveViewManager(i).receiveCommand((ViewManager) view, i2, readableArray);
    }

    public synchronized void dispatchCommand(int i, String str, ReadableArray readableArray) {
        if (this.DEBUG_MODE) {
            FLog.d(TAG, "dispatchCommand[%d]: %s %s", Integer.valueOf(i), str, readableArray != null ? readableArray.toString() : "<null>");
        }
        UiThreadUtil.assertOnUiThread();
        View view = this.mTagsToViews.get(i);
        if (view == null) {
            throw new RetryableMountingLayerException("Trying to send command to a non-existing view with tag [" + i + "] and command " + str);
        }
        resolveViewManager(i).receiveCommand((ViewManager) view, str, readableArray);
    }

    private ThemedReactContext getReactContextForView(int i) {
        View view = this.mTagsToViews.get(i);
        if (view == null) {
            throw new JSApplicationIllegalArgumentException("Could not find view with tag " + i);
        }
        return (ThemedReactContext) view.getContext();
    }

    public synchronized void sendAccessibilityEvent(int i, int i2) {
        View view = this.mTagsToViews.get(i);
        if (view == null) {
            throw new RetryableMountingLayerException("Could not find view with tag " + i);
        }
        view.sendAccessibilityEvent(i2);
    }
}
