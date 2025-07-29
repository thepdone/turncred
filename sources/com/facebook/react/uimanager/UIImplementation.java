package com.facebook.react.uimanager;

import android.os.SystemClock;
import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.facebook.yoga.YogaDirection;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class UIImplementation {
    protected final EventDispatcher mEventDispatcher;
    private long mLastCalculateLayoutTime;
    protected LayoutUpdateListener mLayoutUpdateListener;
    private final int[] mMeasureBuffer;
    private final NativeViewHierarchyOptimizer mNativeViewHierarchyOptimizer;
    private final UIViewOperationQueue mOperationsQueue;
    protected final ReactApplicationContext mReactContext;
    protected final ShadowNodeRegistry mShadowNodeRegistry;
    private final ViewManagerRegistry mViewManagers;
    private volatile boolean mViewOperationsEnabled;
    protected Object uiImplementationThreadLock;

    public interface LayoutUpdateListener {
        void onLayoutUpdated(ReactShadowNode reactShadowNode);
    }

    public void onHostDestroy() {
    }

    UIImplementation(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry, EventDispatcher eventDispatcher, int i) {
        this(reactApplicationContext, viewManagerRegistry, new UIViewOperationQueue(reactApplicationContext, new NativeViewHierarchyManager(viewManagerRegistry), i), eventDispatcher);
    }

    protected UIImplementation(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry, UIViewOperationQueue uIViewOperationQueue, EventDispatcher eventDispatcher) {
        this.uiImplementationThreadLock = new Object();
        ShadowNodeRegistry shadowNodeRegistry = new ShadowNodeRegistry();
        this.mShadowNodeRegistry = shadowNodeRegistry;
        this.mMeasureBuffer = new int[4];
        this.mLastCalculateLayoutTime = 0L;
        this.mViewOperationsEnabled = true;
        this.mReactContext = reactApplicationContext;
        this.mViewManagers = viewManagerRegistry;
        this.mOperationsQueue = uIViewOperationQueue;
        this.mNativeViewHierarchyOptimizer = new NativeViewHierarchyOptimizer(uIViewOperationQueue, shadowNodeRegistry);
        this.mEventDispatcher = eventDispatcher;
    }

    protected ReactShadowNode createRootShadowNode() {
        ReactShadowNodeImpl reactShadowNodeImpl = new ReactShadowNodeImpl();
        if (I18nUtil.getInstance().isRTL(this.mReactContext)) {
            reactShadowNodeImpl.setLayoutDirection(YogaDirection.RTL);
        }
        reactShadowNodeImpl.setViewClassName("Root");
        return reactShadowNodeImpl;
    }

    protected ReactShadowNode createShadowNode(String str) {
        return this.mViewManagers.get(str).createShadowNodeInstance(this.mReactContext);
    }

    public final ReactShadowNode resolveShadowNode(int i) {
        return this.mShadowNodeRegistry.getNode(i);
    }

    protected final ViewManager resolveViewManager(String str) {
        return this.mViewManagers.getViewManagerIfExists(str);
    }

    UIViewOperationQueue getUIViewOperationQueue() {
        return this.mOperationsQueue;
    }

    public void updateRootView(int i, int i2, int i3) {
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i);
        if (node == null) {
            FLog.w("ReactNative", "Tried to update non-existent root tag: " + i);
        } else {
            updateRootView(node, i2, i3);
        }
    }

    public void updateRootView(ReactShadowNode reactShadowNode, int i, int i2) {
        reactShadowNode.setMeasureSpecs(i, i2);
    }

    public <T extends View> void registerRootView(T t, int i, ThemedReactContext themedReactContext) {
        synchronized (this.uiImplementationThreadLock) {
            final ReactShadowNode reactShadowNodeCreateRootShadowNode = createRootShadowNode();
            reactShadowNodeCreateRootShadowNode.setReactTag(i);
            reactShadowNodeCreateRootShadowNode.setThemedContext(themedReactContext);
            themedReactContext.runOnNativeModulesQueueThread(new Runnable() { // from class: com.facebook.react.uimanager.UIImplementation.1
                @Override // java.lang.Runnable
                public void run() {
                    UIImplementation.this.mShadowNodeRegistry.addRootNode(reactShadowNodeCreateRootShadowNode);
                }
            });
            this.mOperationsQueue.addRootView(i, t);
        }
    }

    public void removeRootView(int i) {
        removeRootShadowNode(i);
        this.mOperationsQueue.enqueueRemoveRootView(i);
    }

    public int getRootViewNum() {
        return this.mOperationsQueue.getNativeViewHierarchyManager().getRootViewNum();
    }

    public void removeRootShadowNode(int i) {
        synchronized (this.uiImplementationThreadLock) {
            this.mShadowNodeRegistry.removeRootNode(i);
        }
    }

    public void updateNodeSize(int i, int i2, int i3) {
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i);
        if (node == null) {
            FLog.w("ReactNative", "Tried to update size of non-existent tag: " + i);
            return;
        }
        node.setStyleWidth(i2);
        node.setStyleHeight(i3);
        dispatchViewUpdatesIfNeeded();
    }

    public void updateInsetsPadding(int i, int i2, int i3, int i4, int i5) {
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i);
        if (node == null) {
            FLog.w("ReactNative", "Tried to update size of non-existent tag: " + i);
            return;
        }
        node.setPadding(4, i3);
        node.setPadding(1, i2);
        node.setPadding(5, i5);
        node.setPadding(3, i4);
        dispatchViewUpdatesIfNeeded();
    }

    public void setViewLocalData(int i, Object obj) {
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i);
        if (node == null) {
            FLog.w("ReactNative", "Attempt to set local data for view with unknown tag: " + i);
        } else {
            node.setLocalData(obj);
            dispatchViewUpdatesIfNeeded();
        }
    }

    public void profileNextBatch() {
        this.mOperationsQueue.profileNextBatch();
    }

    public Map<String, Long> getProfiledBatchPerfCounters() {
        return this.mOperationsQueue.getProfiledBatchPerfCounters();
    }

    public void createView(int i, String str, int i2, ReadableMap readableMap) {
        ReactStylesDiffMap reactStylesDiffMap;
        if (this.mViewOperationsEnabled) {
            synchronized (this.uiImplementationThreadLock) {
                ReactShadowNode reactShadowNodeCreateShadowNode = createShadowNode(str);
                ReactShadowNode node = this.mShadowNodeRegistry.getNode(i2);
                Assertions.assertNotNull(node, "Root node with tag " + i2 + " doesn't exist");
                reactShadowNodeCreateShadowNode.setReactTag(i);
                reactShadowNodeCreateShadowNode.setViewClassName(str);
                reactShadowNodeCreateShadowNode.setRootTag(node.getReactTag());
                reactShadowNodeCreateShadowNode.setThemedContext(node.getThemedContext());
                this.mShadowNodeRegistry.addNode(reactShadowNodeCreateShadowNode);
                if (readableMap != null) {
                    reactStylesDiffMap = new ReactStylesDiffMap(readableMap);
                    reactShadowNodeCreateShadowNode.updateProperties(reactStylesDiffMap);
                } else {
                    reactStylesDiffMap = null;
                }
                handleCreateView(reactShadowNodeCreateShadowNode, i2, reactStylesDiffMap);
            }
        }
    }

    protected void handleCreateView(ReactShadowNode reactShadowNode, int i, ReactStylesDiffMap reactStylesDiffMap) {
        if (reactShadowNode.isVirtual()) {
            return;
        }
        this.mNativeViewHierarchyOptimizer.handleCreateView(reactShadowNode, reactShadowNode.getThemedContext(), reactStylesDiffMap);
    }

    public void updateView(int i, String str, ReadableMap readableMap) {
        if (this.mViewOperationsEnabled) {
            if (this.mViewManagers.get(str) == null) {
                throw new IllegalViewOperationException("Got unknown view type: " + str);
            }
            ReactShadowNode node = this.mShadowNodeRegistry.getNode(i);
            if (node == null) {
                throw new IllegalViewOperationException("Trying to update non-existent view with tag " + i);
            }
            if (readableMap != null) {
                ReactStylesDiffMap reactStylesDiffMap = new ReactStylesDiffMap(readableMap);
                node.updateProperties(reactStylesDiffMap);
                handleUpdateView(node, str, reactStylesDiffMap);
            }
        }
    }

    public void synchronouslyUpdateViewOnUIThread(int i, ReactStylesDiffMap reactStylesDiffMap) {
        UiThreadUtil.assertOnUiThread();
        this.mOperationsQueue.getNativeViewHierarchyManager().updateProperties(i, reactStylesDiffMap);
    }

    protected void handleUpdateView(ReactShadowNode reactShadowNode, String str, ReactStylesDiffMap reactStylesDiffMap) {
        if (reactShadowNode.isVirtual()) {
            return;
        }
        this.mNativeViewHierarchyOptimizer.handleUpdateView(reactShadowNode, str, reactStylesDiffMap);
    }

    public void manageChildren(int i, ReadableArray readableArray, ReadableArray readableArray2, ReadableArray readableArray3, ReadableArray readableArray4, ReadableArray readableArray5) throws Throwable {
        ReadableArray readableArray6 = readableArray;
        if (!this.mViewOperationsEnabled) {
            return;
        }
        synchronized (this.uiImplementationThreadLock) {
            try {
                ReactShadowNode node = this.mShadowNodeRegistry.getNode(i);
                int size = readableArray6 == null ? 0 : readableArray.size();
                int size2 = readableArray3 == null ? 0 : readableArray3.size();
                int size3 = readableArray5 == null ? 0 : readableArray5.size();
                if (size != 0 && (readableArray2 == null || size != readableArray2.size())) {
                    throw new IllegalViewOperationException("Size of moveFrom != size of moveTo!");
                }
                if (size2 != 0 && (readableArray4 == null || size2 != readableArray4.size())) {
                    throw new IllegalViewOperationException("Size of addChildTags != size of addAtIndices!");
                }
                int i2 = size + size2;
                ViewAtIndex[] viewAtIndexArr = new ViewAtIndex[i2];
                int i3 = size + size3;
                int[] iArr = new int[i3];
                try {
                    int[] iArr2 = new int[i3];
                    int[] iArr3 = new int[size3];
                    if (size > 0) {
                        Assertions.assertNotNull(readableArray);
                        Assertions.assertNotNull(readableArray2);
                        int i4 = 0;
                        while (i4 < size) {
                            int i5 = i3;
                            int i6 = readableArray6.getInt(i4);
                            int reactTag = node.getChildAt(i6).getReactTag();
                            viewAtIndexArr[i4] = new ViewAtIndex(reactTag, readableArray2.getInt(i4));
                            iArr[i4] = i6;
                            iArr2[i4] = reactTag;
                            i4++;
                            readableArray6 = readableArray;
                            i3 = i5;
                            iArr3 = iArr3;
                            node = node;
                        }
                    }
                    ReactShadowNode reactShadowNode = node;
                    int[] iArr4 = iArr3;
                    int i7 = i3;
                    if (size2 > 0) {
                        Assertions.assertNotNull(readableArray3);
                        Assertions.assertNotNull(readableArray4);
                        for (int i8 = 0; i8 < size2; i8++) {
                            viewAtIndexArr[size + i8] = new ViewAtIndex(readableArray3.getInt(i8), readableArray4.getInt(i8));
                        }
                    }
                    if (size3 > 0) {
                        Assertions.assertNotNull(readableArray5);
                        int i9 = 0;
                        while (i9 < size3) {
                            int i10 = readableArray5.getInt(i9);
                            ReactShadowNode reactShadowNode2 = reactShadowNode;
                            int reactTag2 = reactShadowNode2.getChildAt(i10).getReactTag();
                            int i11 = size + i9;
                            iArr[i11] = i10;
                            iArr2[i11] = reactTag2;
                            iArr4[i9] = reactTag2;
                            i9++;
                            reactShadowNode = reactShadowNode2;
                        }
                    }
                    ReactShadowNode reactShadowNode3 = reactShadowNode;
                    Arrays.sort(viewAtIndexArr, ViewAtIndex.COMPARATOR);
                    Arrays.sort(iArr);
                    int i12 = -1;
                    for (int i13 = i7 - 1; i13 >= 0; i13--) {
                        int i14 = iArr[i13];
                        if (i14 == i12) {
                            throw new IllegalViewOperationException("Repeated indices in Removal list for view tag: " + i);
                        }
                        reactShadowNode3.removeChildAt(i14);
                        i12 = iArr[i13];
                    }
                    int i15 = 0;
                    while (i15 < i2) {
                        ViewAtIndex viewAtIndex = viewAtIndexArr[i15];
                        int[] iArr5 = iArr2;
                        ReactShadowNode node2 = this.mShadowNodeRegistry.getNode(viewAtIndex.mTag);
                        if (node2 == null) {
                            throw new IllegalViewOperationException("Trying to add unknown view tag: " + viewAtIndex.mTag);
                        }
                        reactShadowNode3.addChildAt(node2, viewAtIndex.mIndex);
                        i15++;
                        iArr2 = iArr5;
                    }
                    this.mNativeViewHierarchyOptimizer.handleManageChildren(reactShadowNode3, iArr, iArr2, viewAtIndexArr, iArr4);
                    for (int i16 = 0; i16 < size3; i16++) {
                        removeShadowNode(this.mShadowNodeRegistry.getNode(iArr4[i16]));
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public void setChildren(int i, ReadableArray readableArray) {
        if (this.mViewOperationsEnabled) {
            synchronized (this.uiImplementationThreadLock) {
                ReactShadowNode node = this.mShadowNodeRegistry.getNode(i);
                for (int i2 = 0; i2 < readableArray.size(); i2++) {
                    ReactShadowNode node2 = this.mShadowNodeRegistry.getNode(readableArray.getInt(i2));
                    if (node2 == null) {
                        throw new IllegalViewOperationException("Trying to add unknown view tag: " + readableArray.getInt(i2));
                    }
                    node.addChildAt(node2, i2);
                }
                this.mNativeViewHierarchyOptimizer.handleSetChildren(node, readableArray);
            }
        }
    }

    public void replaceExistingNonRootView(int i, int i2) throws Throwable {
        if (this.mShadowNodeRegistry.isRootNode(i) || this.mShadowNodeRegistry.isRootNode(i2)) {
            throw new IllegalViewOperationException("Trying to add or replace a root tag!");
        }
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i);
        if (node == null) {
            throw new IllegalViewOperationException("Trying to replace unknown view tag: " + i);
        }
        ReactShadowNode parent = node.getParent();
        if (parent == null) {
            throw new IllegalViewOperationException("Node is not attached to a parent: " + i);
        }
        int iIndexOf = parent.indexOf(node);
        if (iIndexOf < 0) {
            throw new IllegalStateException("Didn't find child tag in parent");
        }
        WritableArray writableArrayCreateArray = Arguments.createArray();
        writableArrayCreateArray.pushInt(i2);
        WritableArray writableArrayCreateArray2 = Arguments.createArray();
        writableArrayCreateArray2.pushInt(iIndexOf);
        WritableArray writableArrayCreateArray3 = Arguments.createArray();
        writableArrayCreateArray3.pushInt(iIndexOf);
        manageChildren(parent.getReactTag(), null, null, writableArrayCreateArray, writableArrayCreateArray2, writableArrayCreateArray3);
    }

    public void findSubviewIn(int i, float f, float f2, Callback callback) {
        this.mOperationsQueue.enqueueFindTargetForTouch(i, f, f2, callback);
    }

    @Deprecated
    public void viewIsDescendantOf(int i, int i2, Callback callback) {
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i);
        ReactShadowNode node2 = this.mShadowNodeRegistry.getNode(i2);
        if (node == null || node2 == null) {
            callback.invoke(false);
        } else {
            callback.invoke(Boolean.valueOf(node.isDescendantOf(node2)));
        }
    }

    public void measure(int i, Callback callback) {
        if (this.mViewOperationsEnabled) {
            this.mOperationsQueue.enqueueMeasure(i, callback);
        }
    }

    public void measureInWindow(int i, Callback callback) {
        if (this.mViewOperationsEnabled) {
            this.mOperationsQueue.enqueueMeasureInWindow(i, callback);
        }
    }

    public void measureLayout(int i, int i2, Callback callback, Callback callback2) {
        if (this.mViewOperationsEnabled) {
            try {
                measureLayout(i, i2, this.mMeasureBuffer);
                callback2.invoke(Float.valueOf(PixelUtil.toDIPFromPixel(this.mMeasureBuffer[0])), Float.valueOf(PixelUtil.toDIPFromPixel(this.mMeasureBuffer[1])), Float.valueOf(PixelUtil.toDIPFromPixel(this.mMeasureBuffer[2])), Float.valueOf(PixelUtil.toDIPFromPixel(this.mMeasureBuffer[3])));
            } catch (IllegalViewOperationException e) {
                callback.invoke(e.getMessage());
            }
        }
    }

    public void measureLayoutRelativeToParent(int i, Callback callback, Callback callback2) {
        if (this.mViewOperationsEnabled) {
            try {
                measureLayoutRelativeToParent(i, this.mMeasureBuffer);
                callback2.invoke(Float.valueOf(PixelUtil.toDIPFromPixel(this.mMeasureBuffer[0])), Float.valueOf(PixelUtil.toDIPFromPixel(this.mMeasureBuffer[1])), Float.valueOf(PixelUtil.toDIPFromPixel(this.mMeasureBuffer[2])), Float.valueOf(PixelUtil.toDIPFromPixel(this.mMeasureBuffer[3])));
            } catch (IllegalViewOperationException e) {
                callback.invoke(e.getMessage());
            }
        }
    }

    public void dispatchViewUpdates(int i) {
        SystraceMessage.beginSection(0L, "UIImplementation.dispatchViewUpdates").arg("batchId", i).flush();
        long jUptimeMillis = SystemClock.uptimeMillis();
        try {
            updateViewHierarchy();
            this.mNativeViewHierarchyOptimizer.onBatchComplete();
            this.mOperationsQueue.dispatchViewUpdates(i, jUptimeMillis, this.mLastCalculateLayoutTime);
        } finally {
            Systrace.endSection(0L);
        }
    }

    private void dispatchViewUpdatesIfNeeded() {
        if (this.mOperationsQueue.isEmpty()) {
            dispatchViewUpdates(-1);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a4, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ad, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b1, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void updateViewHierarchy() {
        /*
            r14 = this;
            java.lang.String r0 = "rootTag"
            java.lang.String r1 = "UIImplementation.updateViewHierarchy"
            r2 = 0
            com.facebook.systrace.Systrace.beginSection(r2, r1)
            r1 = 0
        Lb:
            com.facebook.react.uimanager.ShadowNodeRegistry r4 = r14.mShadowNodeRegistry     // Catch: java.lang.Throwable -> Lad
            int r4 = r4.getRootNodeCount()     // Catch: java.lang.Throwable -> Lad
            if (r1 >= r4) goto La9
            com.facebook.react.uimanager.ShadowNodeRegistry r4 = r14.mShadowNodeRegistry     // Catch: java.lang.Throwable -> Lad
            int r4 = r4.getRootTag(r1)     // Catch: java.lang.Throwable -> Lad
            com.facebook.react.uimanager.ShadowNodeRegistry r5 = r14.mShadowNodeRegistry     // Catch: java.lang.Throwable -> Lad
            com.facebook.react.uimanager.ReactShadowNode r4 = r5.getNode(r4)     // Catch: java.lang.Throwable -> Lad
            java.lang.Integer r5 = r4.getWidthMeasureSpec()     // Catch: java.lang.Throwable -> Lad
            if (r5 == 0) goto La5
            java.lang.Integer r5 = r4.getHeightMeasureSpec()     // Catch: java.lang.Throwable -> Lad
            if (r5 == 0) goto La5
            java.lang.String r5 = "UIImplementation.notifyOnBeforeLayoutRecursive"
            com.facebook.systrace.SystraceMessage$Builder r5 = com.facebook.systrace.SystraceMessage.beginSection(r2, r5)     // Catch: java.lang.Throwable -> Lad
            int r6 = r4.getReactTag()     // Catch: java.lang.Throwable -> Lad
            com.facebook.systrace.SystraceMessage$Builder r5 = r5.arg(r0, r6)     // Catch: java.lang.Throwable -> Lad
            r5.flush()     // Catch: java.lang.Throwable -> Lad
            r14.notifyOnBeforeLayoutRecursive(r4)     // Catch: java.lang.Throwable -> La0
            com.facebook.systrace.Systrace.endSection(r2)     // Catch: java.lang.Throwable -> Lad
            r14.calculateRootLayout(r4)     // Catch: java.lang.Throwable -> Lad
            java.lang.String r5 = "UIImplementation.applyUpdatesRecursive"
            com.facebook.systrace.SystraceMessage$Builder r5 = com.facebook.systrace.SystraceMessage.beginSection(r2, r5)     // Catch: java.lang.Throwable -> Lad
            int r6 = r4.getReactTag()     // Catch: java.lang.Throwable -> Lad
            com.facebook.systrace.SystraceMessage$Builder r5 = r5.arg(r0, r6)     // Catch: java.lang.Throwable -> Lad
            r5.flush()     // Catch: java.lang.Throwable -> Lad
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L9b
            r5.<init>()     // Catch: java.lang.Throwable -> L9b
            r6 = 0
            r14.applyUpdatesRecursive(r4, r6, r6, r5)     // Catch: java.lang.Throwable -> L9b
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L9b
        L63:
            boolean r6 = r5.hasNext()     // Catch: java.lang.Throwable -> L9b
            if (r6 == 0) goto L8e
            java.lang.Object r6 = r5.next()     // Catch: java.lang.Throwable -> L9b
            com.facebook.react.uimanager.ReactShadowNode r6 = (com.facebook.react.uimanager.ReactShadowNode) r6     // Catch: java.lang.Throwable -> L9b
            com.facebook.react.uimanager.events.EventDispatcher r7 = r14.mEventDispatcher     // Catch: java.lang.Throwable -> L9b
            int r9 = r6.getReactTag()     // Catch: java.lang.Throwable -> L9b
            int r10 = r6.getScreenX()     // Catch: java.lang.Throwable -> L9b
            int r11 = r6.getScreenY()     // Catch: java.lang.Throwable -> L9b
            int r12 = r6.getScreenWidth()     // Catch: java.lang.Throwable -> L9b
            int r13 = r6.getScreenHeight()     // Catch: java.lang.Throwable -> L9b
            r8 = -1
            com.facebook.react.uimanager.OnLayoutEvent r6 = com.facebook.react.uimanager.OnLayoutEvent.obtain(r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L9b
            r7.dispatchEvent(r6)     // Catch: java.lang.Throwable -> L9b
            goto L63
        L8e:
            com.facebook.systrace.Systrace.endSection(r2)     // Catch: java.lang.Throwable -> Lad
            com.facebook.react.uimanager.UIImplementation$LayoutUpdateListener r5 = r14.mLayoutUpdateListener     // Catch: java.lang.Throwable -> Lad
            if (r5 == 0) goto La5
            com.facebook.react.uimanager.UIViewOperationQueue r6 = r14.mOperationsQueue     // Catch: java.lang.Throwable -> Lad
            r6.enqueueLayoutUpdateFinished(r4, r5)     // Catch: java.lang.Throwable -> Lad
            goto La5
        L9b:
            r0 = move-exception
            com.facebook.systrace.Systrace.endSection(r2)     // Catch: java.lang.Throwable -> Lad
            throw r0     // Catch: java.lang.Throwable -> Lad
        La0:
            r0 = move-exception
            com.facebook.systrace.Systrace.endSection(r2)     // Catch: java.lang.Throwable -> Lad
            throw r0     // Catch: java.lang.Throwable -> Lad
        La5:
            int r1 = r1 + 1
            goto Lb
        La9:
            com.facebook.systrace.Systrace.endSection(r2)
            return
        Lad:
            r0 = move-exception
            com.facebook.systrace.Systrace.endSection(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.UIImplementation.updateViewHierarchy():void");
    }

    public void setLayoutAnimationEnabledExperimental(boolean z) {
        this.mOperationsQueue.enqueueSetLayoutAnimationEnabled(z);
    }

    public void configureNextLayoutAnimation(ReadableMap readableMap, Callback callback) {
        this.mOperationsQueue.enqueueConfigureLayoutAnimation(readableMap, callback);
    }

    public void setJSResponder(int i, boolean z) {
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i);
        if (node == null) {
            return;
        }
        while (node.getNativeKind() == NativeKind.NONE) {
            node = node.getParent();
        }
        this.mOperationsQueue.enqueueSetJSResponder(node.getReactTag(), i, z);
    }

    public void clearJSResponder() {
        this.mOperationsQueue.enqueueClearJSResponder();
    }

    @Deprecated
    public void dispatchViewManagerCommand(int i, int i2, ReadableArray readableArray) {
        if (checkOrAssertViewExists(i, "dispatchViewManagerCommand: " + i2)) {
            this.mOperationsQueue.enqueueDispatchCommand(i, i2, readableArray);
        }
    }

    public void dispatchViewManagerCommand(int i, String str, ReadableArray readableArray) {
        if (checkOrAssertViewExists(i, "dispatchViewManagerCommand: " + str)) {
            this.mOperationsQueue.enqueueDispatchCommand(i, str, readableArray);
        }
    }

    public void sendAccessibilityEvent(int i, int i2) {
        this.mOperationsQueue.enqueueSendAccessibilityEvent(i, i2);
    }

    public void onHostResume() {
        this.mOperationsQueue.resumeFrameCallback();
    }

    public void onHostPause() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.mOperationsQueue.pauseFrameCallback();
    }

    public void onCatalystInstanceDestroyed() {
        this.mViewOperationsEnabled = false;
        this.mViewManagers.invalidate();
    }

    public void setViewHierarchyUpdateDebugListener(NotThreadSafeViewHierarchyUpdateDebugListener notThreadSafeViewHierarchyUpdateDebugListener) {
        this.mOperationsQueue.setViewHierarchyUpdateDebugListener(notThreadSafeViewHierarchyUpdateDebugListener);
    }

    protected final void removeShadowNode(ReactShadowNode reactShadowNode) {
        removeShadowNodeRecursive(reactShadowNode);
        reactShadowNode.dispose();
    }

    private void removeShadowNodeRecursive(ReactShadowNode reactShadowNode) {
        NativeViewHierarchyOptimizer.handleRemoveNode(reactShadowNode);
        this.mShadowNodeRegistry.removeNode(reactShadowNode.getReactTag());
        for (int childCount = reactShadowNode.getChildCount() - 1; childCount >= 0; childCount--) {
            removeShadowNodeRecursive(reactShadowNode.getChildAt(childCount));
        }
        reactShadowNode.removeAndDisposeAllChildren();
    }

    private void measureLayout(int i, int i2, int[] iArr) {
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i);
        ReactShadowNode node2 = this.mShadowNodeRegistry.getNode(i2);
        if (node == null || node2 == null) {
            StringBuilder sb = new StringBuilder("Tag ");
            if (node != null) {
                i = i2;
            }
            throw new IllegalViewOperationException(sb.append(i).append(" does not exist").toString());
        }
        if (node != node2) {
            for (ReactShadowNode parent = node.getParent(); parent != node2; parent = parent.getParent()) {
                if (parent == null) {
                    throw new IllegalViewOperationException("Tag " + i2 + " is not an ancestor of tag " + i);
                }
            }
        }
        measureLayoutRelativeToVerifiedAncestor(node, node2, iArr);
    }

    private void measureLayoutRelativeToParent(int i, int[] iArr) {
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i);
        if (node == null) {
            throw new IllegalViewOperationException("No native view for tag " + i + " exists!");
        }
        ReactShadowNode parent = node.getParent();
        if (parent == null) {
            throw new IllegalViewOperationException("View with tag " + i + " doesn't have a parent!");
        }
        measureLayoutRelativeToVerifiedAncestor(node, parent, iArr);
    }

    private void measureLayoutRelativeToVerifiedAncestor(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int[] iArr) {
        int iRound;
        int iRound2;
        if (reactShadowNode == reactShadowNode2 || reactShadowNode.isVirtual()) {
            iRound = 0;
            iRound2 = 0;
        } else {
            iRound = Math.round(reactShadowNode.getLayoutX());
            iRound2 = Math.round(reactShadowNode.getLayoutY());
            for (ReactShadowNode parent = reactShadowNode.getParent(); parent != reactShadowNode2; parent = parent.getParent()) {
                Assertions.assertNotNull(parent);
                assertNodeDoesNotNeedCustomLayoutForChildren(parent);
                iRound += Math.round(parent.getLayoutX());
                iRound2 += Math.round(parent.getLayoutY());
            }
            assertNodeDoesNotNeedCustomLayoutForChildren(reactShadowNode2);
        }
        iArr[0] = iRound;
        iArr[1] = iRound2;
        iArr[2] = reactShadowNode.getScreenWidth();
        iArr[3] = reactShadowNode.getScreenHeight();
    }

    private boolean checkOrAssertViewExists(int i, String str) {
        if (this.mShadowNodeRegistry.getNode(i) != null) {
            return true;
        }
        String str2 = "Unable to execute operation " + str + " on view with tag: " + i + ", since the view does not exist";
        if (ReactBuildConfig.DEBUG) {
            throw new IllegalViewOperationException(str2);
        }
        FLog.w("ReactNative", str2);
        return false;
    }

    private void assertNodeDoesNotNeedCustomLayoutForChildren(ReactShadowNode reactShadowNode) {
        NativeModule nativeModule = (ViewManager) Assertions.assertNotNull(this.mViewManagers.get(reactShadowNode.getViewClass()));
        if (nativeModule instanceof IViewManagerWithChildren) {
            IViewManagerWithChildren iViewManagerWithChildren = (IViewManagerWithChildren) nativeModule;
            if (iViewManagerWithChildren != null && iViewManagerWithChildren.needsCustomLayoutForChildren()) {
                throw new IllegalViewOperationException("Trying to measure a view using measureLayout/measureLayoutRelativeToParent relative to an ancestor that requires custom layout for it's children (" + reactShadowNode.getViewClass() + "). Use measure instead.");
            }
            return;
        }
        throw new IllegalViewOperationException("Trying to use view " + reactShadowNode.getViewClass() + " as a parent, but its Manager doesn't extends ViewGroupManager");
    }

    private void notifyOnBeforeLayoutRecursive(ReactShadowNode reactShadowNode) {
        if (reactShadowNode.hasUpdates()) {
            for (int i = 0; i < reactShadowNode.getChildCount(); i++) {
                notifyOnBeforeLayoutRecursive(reactShadowNode.getChildAt(i));
            }
            reactShadowNode.onBeforeLayout(this.mNativeViewHierarchyOptimizer);
        }
    }

    protected void calculateRootLayout(ReactShadowNode reactShadowNode) {
        SystraceMessage.beginSection(0L, "cssRoot.calculateLayout").arg("rootTag", reactShadowNode.getReactTag()).flush();
        long jUptimeMillis = SystemClock.uptimeMillis();
        try {
            int iIntValue = reactShadowNode.getWidthMeasureSpec().intValue();
            int iIntValue2 = reactShadowNode.getHeightMeasureSpec().intValue();
            float size = Float.NaN;
            float size2 = View.MeasureSpec.getMode(iIntValue) == 0 ? Float.NaN : View.MeasureSpec.getSize(iIntValue);
            if (View.MeasureSpec.getMode(iIntValue2) != 0) {
                size = View.MeasureSpec.getSize(iIntValue2);
            }
            reactShadowNode.calculateLayout(size2, size);
        } finally {
            Systrace.endSection(0L);
            this.mLastCalculateLayoutTime = SystemClock.uptimeMillis() - jUptimeMillis;
        }
    }

    protected void applyUpdatesRecursive(ReactShadowNode reactShadowNode, float f, float f2, List<ReactShadowNode> list) {
        if (reactShadowNode.hasUpdates()) {
            if (reactShadowNode.dispatchUpdatesWillChangeLayout(f, f2) && reactShadowNode.shouldNotifyOnLayout() && !this.mShadowNodeRegistry.isRootNode(reactShadowNode.getReactTag())) {
                list.add(reactShadowNode);
            }
            Iterable<? extends ReactShadowNode> iterableCalculateLayoutOnChildren = reactShadowNode.calculateLayoutOnChildren();
            if (iterableCalculateLayoutOnChildren != null) {
                Iterator<? extends ReactShadowNode> it = iterableCalculateLayoutOnChildren.iterator();
                while (it.hasNext()) {
                    applyUpdatesRecursive(it.next(), reactShadowNode.getLayoutX() + f, reactShadowNode.getLayoutY() + f2, list);
                }
            }
            reactShadowNode.dispatchUpdates(f, f2, this.mOperationsQueue, this.mNativeViewHierarchyOptimizer);
            reactShadowNode.markUpdateSeen();
            this.mNativeViewHierarchyOptimizer.onViewUpdatesCompleted(reactShadowNode);
        }
    }

    public void addUIBlock(UIBlock uIBlock) {
        this.mOperationsQueue.enqueueUIBlock(uIBlock);
    }

    public void prependUIBlock(UIBlock uIBlock) {
        this.mOperationsQueue.prependUIBlock(uIBlock);
    }

    public int resolveRootTagFromReactTag(int i) {
        if (this.mShadowNodeRegistry.isRootNode(i)) {
            return i;
        }
        ReactShadowNode reactShadowNodeResolveShadowNode = resolveShadowNode(i);
        if (reactShadowNodeResolveShadowNode != null) {
            return reactShadowNodeResolveShadowNode.getRootTag();
        }
        FLog.w("ReactNative", "Warning : attempted to resolve a non-existent react shadow node. reactTag=" + i);
        return 0;
    }

    public void setLayoutUpdateListener(LayoutUpdateListener layoutUpdateListener) {
        this.mLayoutUpdateListener = layoutUpdateListener;
    }

    public void removeLayoutUpdateListener() {
        this.mLayoutUpdateListener = null;
    }
}
