package com.facebook.react.uimanager;

import com.facebook.infer.annotation.Assertions;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaBaselineFunction;
import com.facebook.yoga.YogaConfig;
import com.facebook.yoga.YogaConstants;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaGutter;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaNodeFactory;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaValue;
import com.facebook.yoga.YogaWrap;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes4.dex */
public class ReactShadowNodeImpl implements ReactShadowNode<ReactShadowNodeImpl> {
    private static final YogaConfig sYogaConfig = ReactYogaConfigProvider.get();
    private ArrayList<ReactShadowNodeImpl> mChildren;
    private Integer mHeightMeasureSpec;
    private boolean mIsLayoutOnly;
    private ReactShadowNodeImpl mLayoutParent;
    private ArrayList<ReactShadowNodeImpl> mNativeChildren;
    private ReactShadowNodeImpl mNativeParent;
    private final float[] mPadding;
    private ReactShadowNodeImpl mParent;
    private int mReactTag;
    private int mRootTag;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mScreenX;
    private int mScreenY;
    private boolean mShouldNotifyOnLayout;
    private ThemedReactContext mThemedContext;
    private String mViewClassName;
    private Integer mWidthMeasureSpec;
    private YogaNode mYogaNode;
    private boolean mNodeUpdated = true;
    private int mTotalNativeChildren = 0;
    private final boolean[] mPaddingIsPercent = new boolean[9];
    private final Spacing mDefaultPadding = new Spacing(0.0f);

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public boolean hoistNativeChildren() {
        return false;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public boolean isVirtual() {
        return false;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public boolean isVirtualAnchor() {
        return false;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void onAfterUpdateTransaction() {
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void onBeforeLayout(NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void onCollectExtraUpdates(UIViewOperationQueue uIViewOperationQueue) {
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setLocalData(Object obj) {
    }

    public ReactShadowNodeImpl() {
        float[] fArr = new float[9];
        this.mPadding = fArr;
        if (!isVirtual()) {
            YogaNode yogaNodeAcquire = YogaNodePool.get().acquire();
            yogaNodeAcquire = yogaNodeAcquire == null ? YogaNodeFactory.create(sYogaConfig) : yogaNodeAcquire;
            this.mYogaNode = yogaNodeAcquire;
            yogaNodeAcquire.setData(this);
            Arrays.fill(fArr, Float.NaN);
            return;
        }
        this.mYogaNode = null;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public boolean isYogaLeafNode() {
        return isMeasureDefined();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final String getViewClass() {
        return (String) Assertions.assertNotNull(this.mViewClassName);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final boolean hasUpdates() {
        return this.mNodeUpdated || hasNewLayout() || isDirty();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void markUpdateSeen() {
        this.mNodeUpdated = false;
        if (hasNewLayout()) {
            markLayoutSeen();
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void markUpdated() {
        if (this.mNodeUpdated) {
            return;
        }
        this.mNodeUpdated = true;
        ReactShadowNodeImpl parent = getParent();
        if (parent != null) {
            parent.markUpdated();
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final boolean hasUnseenUpdates() {
        return this.mNodeUpdated;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void dirty() {
        if (!isVirtual()) {
            this.mYogaNode.dirty();
        } else if (getParent() != null) {
            getParent().dirty();
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final boolean isDirty() {
        YogaNode yogaNode = this.mYogaNode;
        return yogaNode != null && yogaNode.isDirty();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void addChildAt(ReactShadowNodeImpl reactShadowNodeImpl, int i) {
        if (this.mChildren == null) {
            this.mChildren = new ArrayList<>(4);
        }
        this.mChildren.add(i, reactShadowNodeImpl);
        reactShadowNodeImpl.mParent = this;
        if (this.mYogaNode != null && !isYogaLeafNode()) {
            YogaNode yogaNode = reactShadowNodeImpl.mYogaNode;
            if (yogaNode == null) {
                throw new RuntimeException("Cannot add a child that doesn't have a YogaNode to a parent without a measure function! (Trying to add a '" + reactShadowNodeImpl.toString() + "' to a '" + toString() + "')");
            }
            this.mYogaNode.addChildAt(yogaNode, i);
        }
        markUpdated();
        int totalNativeNodeContributionToParent = reactShadowNodeImpl.getTotalNativeNodeContributionToParent();
        this.mTotalNativeChildren += totalNativeNodeContributionToParent;
        updateNativeChildrenCountInParent(totalNativeNodeContributionToParent);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public ReactShadowNodeImpl removeChildAt(int i) {
        ArrayList<ReactShadowNodeImpl> arrayList = this.mChildren;
        if (arrayList == null) {
            throw new ArrayIndexOutOfBoundsException("Index " + i + " out of bounds: node has no children");
        }
        ReactShadowNodeImpl reactShadowNodeImplRemove = arrayList.remove(i);
        reactShadowNodeImplRemove.mParent = null;
        if (this.mYogaNode != null && !isYogaLeafNode()) {
            this.mYogaNode.removeChildAt(i);
        }
        markUpdated();
        int totalNativeNodeContributionToParent = reactShadowNodeImplRemove.getTotalNativeNodeContributionToParent();
        this.mTotalNativeChildren -= totalNativeNodeContributionToParent;
        updateNativeChildrenCountInParent(-totalNativeNodeContributionToParent);
        return reactShadowNodeImplRemove;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final int getChildCount() {
        ArrayList<ReactShadowNodeImpl> arrayList = this.mChildren;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final ReactShadowNodeImpl getChildAt(int i) {
        ArrayList<ReactShadowNodeImpl> arrayList = this.mChildren;
        if (arrayList == null) {
            throw new ArrayIndexOutOfBoundsException("Index " + i + " out of bounds: node has no children");
        }
        return arrayList.get(i);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final int indexOf(ReactShadowNodeImpl reactShadowNodeImpl) {
        ArrayList<ReactShadowNodeImpl> arrayList = this.mChildren;
        if (arrayList == null) {
            return -1;
        }
        return arrayList.indexOf(reactShadowNodeImpl);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void removeAndDisposeAllChildren() {
        if (getChildCount() == 0) {
            return;
        }
        int totalNativeNodeContributionToParent = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (this.mYogaNode != null && !isYogaLeafNode()) {
                this.mYogaNode.removeChildAt(childCount);
            }
            ReactShadowNodeImpl childAt = getChildAt(childCount);
            childAt.mParent = null;
            totalNativeNodeContributionToParent += childAt.getTotalNativeNodeContributionToParent();
            childAt.dispose();
        }
        ((ArrayList) Assertions.assertNotNull(this.mChildren)).clear();
        markUpdated();
        this.mTotalNativeChildren -= totalNativeNodeContributionToParent;
        updateNativeChildrenCountInParent(-totalNativeNodeContributionToParent);
    }

    private void updateNativeChildrenCountInParent(int i) {
        if (getNativeKind() != NativeKind.PARENT) {
            for (ReactShadowNodeImpl parent = getParent(); parent != null; parent = parent.getParent()) {
                parent.mTotalNativeChildren += i;
                if (parent.getNativeKind() == NativeKind.PARENT) {
                    return;
                }
            }
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void updateProperties(ReactStylesDiffMap reactStylesDiffMap) {
        ViewManagerPropertyUpdater.updateProps(this, reactStylesDiffMap);
        onAfterUpdateTransaction();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public boolean dispatchUpdatesWillChangeLayout(float f, float f2) {
        if (!hasNewLayout()) {
            return false;
        }
        float layoutX = getLayoutX();
        float layoutY = getLayoutY();
        float f3 = f + layoutX;
        int iRound = Math.round(f3);
        float f4 = f2 + layoutY;
        int iRound2 = Math.round(f4);
        return (Math.round(layoutX) == this.mScreenX && Math.round(layoutY) == this.mScreenY && Math.round(f3 + getLayoutWidth()) - iRound == this.mScreenWidth && Math.round(f4 + getLayoutHeight()) - iRound2 == this.mScreenHeight) ? false : true;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void dispatchUpdates(float f, float f2, UIViewOperationQueue uIViewOperationQueue, NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        if (this.mNodeUpdated) {
            onCollectExtraUpdates(uIViewOperationQueue);
        }
        if (hasNewLayout()) {
            float layoutX = getLayoutX();
            float layoutY = getLayoutY();
            float f3 = f + layoutX;
            int iRound = Math.round(f3);
            float f4 = f2 + layoutY;
            int iRound2 = Math.round(f4);
            int iRound3 = Math.round(f3 + getLayoutWidth());
            int iRound4 = Math.round(f4 + getLayoutHeight());
            int iRound5 = Math.round(layoutX);
            int iRound6 = Math.round(layoutY);
            int i = iRound3 - iRound;
            int i2 = iRound4 - iRound2;
            boolean z = (iRound5 == this.mScreenX && iRound6 == this.mScreenY && i == this.mScreenWidth && i2 == this.mScreenHeight) ? false : true;
            this.mScreenX = iRound5;
            this.mScreenY = iRound6;
            this.mScreenWidth = i;
            this.mScreenHeight = i2;
            if (z) {
                if (nativeViewHierarchyOptimizer != null) {
                    nativeViewHierarchyOptimizer.handleUpdateLayout(this);
                } else {
                    uIViewOperationQueue.enqueueUpdateLayout(getParent().getReactTag(), getReactTag(), getScreenX(), getScreenY(), getScreenWidth(), getScreenHeight(), getLayoutDirection());
                }
            }
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final int getReactTag() {
        return this.mReactTag;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setReactTag(int i) {
        this.mReactTag = i;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final int getRootTag() {
        Assertions.assertCondition(this.mRootTag != 0);
        return this.mRootTag;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void setRootTag(int i) {
        this.mRootTag = i;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void setViewClassName(String str) {
        this.mViewClassName = str;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final ReactShadowNodeImpl getParent() {
        return this.mParent;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final ReactShadowNodeImpl getLayoutParent() {
        ReactShadowNodeImpl reactShadowNodeImpl = this.mLayoutParent;
        return reactShadowNodeImpl != null ? reactShadowNodeImpl : getNativeParent();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void setLayoutParent(ReactShadowNodeImpl reactShadowNodeImpl) {
        this.mLayoutParent = reactShadowNodeImpl;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final ThemedReactContext getThemedContext() {
        return (ThemedReactContext) Assertions.assertNotNull(this.mThemedContext);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setThemedContext(ThemedReactContext themedReactContext) {
        this.mThemedContext = themedReactContext;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final boolean shouldNotifyOnLayout() {
        return this.mShouldNotifyOnLayout;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void calculateLayout() {
        calculateLayout(Float.NaN, Float.NaN);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void calculateLayout(float f, float f2) {
        this.mYogaNode.calculateLayout(f, f2);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final boolean hasNewLayout() {
        YogaNode yogaNode = this.mYogaNode;
        return yogaNode != null && yogaNode.hasNewLayout();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void markLayoutSeen() {
        YogaNode yogaNode = this.mYogaNode;
        if (yogaNode != null) {
            yogaNode.markLayoutSeen();
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void addNativeChildAt(ReactShadowNodeImpl reactShadowNodeImpl, int i) {
        Assertions.assertCondition(getNativeKind() == NativeKind.PARENT);
        Assertions.assertCondition(reactShadowNodeImpl.getNativeKind() != NativeKind.NONE);
        if (this.mNativeChildren == null) {
            this.mNativeChildren = new ArrayList<>(4);
        }
        this.mNativeChildren.add(i, reactShadowNodeImpl);
        reactShadowNodeImpl.mNativeParent = this;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final ReactShadowNodeImpl removeNativeChildAt(int i) {
        Assertions.assertNotNull(this.mNativeChildren);
        ReactShadowNodeImpl reactShadowNodeImplRemove = this.mNativeChildren.remove(i);
        reactShadowNodeImplRemove.mNativeParent = null;
        return reactShadowNodeImplRemove;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void removeAllNativeChildren() {
        ArrayList<ReactShadowNodeImpl> arrayList = this.mNativeChildren;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.mNativeChildren.get(size).mNativeParent = null;
            }
            this.mNativeChildren.clear();
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final int getNativeChildCount() {
        ArrayList<ReactShadowNodeImpl> arrayList = this.mNativeChildren;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final int indexOfNativeChild(ReactShadowNodeImpl reactShadowNodeImpl) {
        Assertions.assertNotNull(this.mNativeChildren);
        return this.mNativeChildren.indexOf(reactShadowNodeImpl);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final ReactShadowNodeImpl getNativeParent() {
        return this.mNativeParent;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void setIsLayoutOnly(boolean z) {
        Assertions.assertCondition(getParent() == null, "Must remove from no opt parent first");
        Assertions.assertCondition(this.mNativeParent == null, "Must remove from native parent first");
        Assertions.assertCondition(getNativeChildCount() == 0, "Must remove all native children first");
        this.mIsLayoutOnly = z;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final boolean isLayoutOnly() {
        return this.mIsLayoutOnly;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public NativeKind getNativeKind() {
        if (isVirtual() || isLayoutOnly()) {
            return NativeKind.NONE;
        }
        return hoistNativeChildren() ? NativeKind.LEAF : NativeKind.PARENT;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final int getTotalNativeChildren() {
        return this.mTotalNativeChildren;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public boolean isDescendantOf(ReactShadowNodeImpl reactShadowNodeImpl) {
        for (ReactShadowNodeImpl parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent == reactShadowNodeImpl) {
                return true;
            }
        }
        return false;
    }

    private int getTotalNativeNodeContributionToParent() {
        NativeKind nativeKind = getNativeKind();
        if (nativeKind == NativeKind.NONE) {
            return this.mTotalNativeChildren;
        }
        if (nativeKind == NativeKind.LEAF) {
            return this.mTotalNativeChildren + 1;
        }
        return 1;
    }

    public String toString() {
        return "[" + this.mViewClassName + " " + getReactTag() + "]";
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final int getNativeOffsetForChild(ReactShadowNodeImpl reactShadowNodeImpl) {
        int totalNativeNodeContributionToParent = 0;
        for (int i = 0; i < getChildCount(); i++) {
            ReactShadowNodeImpl childAt = getChildAt(i);
            if (reactShadowNodeImpl == childAt) {
                return totalNativeNodeContributionToParent;
            }
            totalNativeNodeContributionToParent += childAt.getTotalNativeNodeContributionToParent();
        }
        throw new RuntimeException("Child " + reactShadowNodeImpl.getReactTag() + " was not a child of " + this.mReactTag);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final float getLayoutX() {
        return this.mYogaNode.getLayoutX();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final float getLayoutY() {
        return this.mYogaNode.getLayoutY();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final float getLayoutWidth() {
        return this.mYogaNode.getLayoutWidth();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final float getLayoutHeight() {
        return this.mYogaNode.getLayoutHeight();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public int getScreenX() {
        return this.mScreenX;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public int getScreenY() {
        return this.mScreenY;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public int getScreenWidth() {
        return this.mScreenWidth;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public int getScreenHeight() {
        return this.mScreenHeight;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final YogaDirection getLayoutDirection() {
        return this.mYogaNode.getLayoutDirection();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setLayoutDirection(YogaDirection yogaDirection) {
        this.mYogaNode.setDirection(yogaDirection);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final YogaValue getStyleWidth() {
        return this.mYogaNode.getWidth();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setStyleWidth(float f) {
        this.mYogaNode.setWidth(f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setStyleWidthPercent(float f) {
        this.mYogaNode.setWidthPercent(f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setStyleWidthAuto() {
        this.mYogaNode.setWidthAuto();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setStyleMinWidth(float f) {
        this.mYogaNode.setMinWidth(f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setStyleMinWidthPercent(float f) {
        this.mYogaNode.setMinWidthPercent(f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setStyleMaxWidth(float f) {
        this.mYogaNode.setMaxWidth(f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setStyleMaxWidthPercent(float f) {
        this.mYogaNode.setMaxWidthPercent(f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final YogaValue getStyleHeight() {
        return this.mYogaNode.getHeight();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setStyleHeight(float f) {
        this.mYogaNode.setHeight(f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setStyleHeightPercent(float f) {
        this.mYogaNode.setHeightPercent(f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setStyleHeightAuto() {
        this.mYogaNode.setHeightAuto();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setStyleMinHeight(float f) {
        this.mYogaNode.setMinHeight(f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setStyleMinHeightPercent(float f) {
        this.mYogaNode.setMinHeightPercent(f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setStyleMaxHeight(float f) {
        this.mYogaNode.setMaxHeight(f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setStyleMaxHeightPercent(float f) {
        this.mYogaNode.setMaxHeightPercent(f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public float getFlex() {
        return this.mYogaNode.getFlex();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setFlex(float f) {
        this.mYogaNode.setFlex(f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setFlexGrow(float f) {
        this.mYogaNode.setFlexGrow(f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setRowGap(float f) {
        this.mYogaNode.setGap(YogaGutter.ROW, f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setRowGapPercent(float f) {
        this.mYogaNode.setGapPercent(YogaGutter.ROW, f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setColumnGap(float f) {
        this.mYogaNode.setGap(YogaGutter.COLUMN, f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setColumnGapPercent(float f) {
        this.mYogaNode.setGapPercent(YogaGutter.COLUMN, f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setGap(float f) {
        this.mYogaNode.setGap(YogaGutter.ALL, f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setGapPercent(float f) {
        this.mYogaNode.setGap(YogaGutter.ALL, f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setFlexShrink(float f) {
        this.mYogaNode.setFlexShrink(f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setFlexBasis(float f) {
        this.mYogaNode.setFlexBasis(f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setFlexBasisAuto() {
        this.mYogaNode.setFlexBasisAuto();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setFlexBasisPercent(float f) {
        this.mYogaNode.setFlexBasisPercent(f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setStyleAspectRatio(float f) {
        this.mYogaNode.setAspectRatio(f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setFlexDirection(YogaFlexDirection yogaFlexDirection) {
        this.mYogaNode.setFlexDirection(yogaFlexDirection);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setFlexWrap(YogaWrap yogaWrap) {
        this.mYogaNode.setWrap(yogaWrap);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setAlignSelf(YogaAlign yogaAlign) {
        this.mYogaNode.setAlignSelf(yogaAlign);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setAlignItems(YogaAlign yogaAlign) {
        this.mYogaNode.setAlignItems(yogaAlign);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setAlignContent(YogaAlign yogaAlign) {
        this.mYogaNode.setAlignContent(yogaAlign);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setJustifyContent(YogaJustify yogaJustify) {
        this.mYogaNode.setJustifyContent(yogaJustify);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setOverflow(YogaOverflow yogaOverflow) {
        this.mYogaNode.setOverflow(yogaOverflow);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setDisplay(YogaDisplay yogaDisplay) {
        this.mYogaNode.setDisplay(yogaDisplay);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setMargin(int i, float f) {
        this.mYogaNode.setMargin(YogaEdge.fromInt(i), f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setMarginPercent(int i, float f) {
        this.mYogaNode.setMarginPercent(YogaEdge.fromInt(i), f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setMarginAuto(int i) {
        this.mYogaNode.setMarginAuto(YogaEdge.fromInt(i));
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final float getPadding(int i) {
        return this.mYogaNode.getLayoutPadding(YogaEdge.fromInt(i));
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final YogaValue getStylePadding(int i) {
        return this.mYogaNode.getPadding(YogaEdge.fromInt(i));
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setDefaultPadding(int i, float f) {
        this.mDefaultPadding.set(i, f);
        updatePadding();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setPadding(int i, float f) {
        this.mPadding[i] = f;
        this.mPaddingIsPercent[i] = false;
        updatePadding();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setPaddingPercent(int i, float f) {
        this.mPadding[i] = f;
        this.mPaddingIsPercent[i] = !YogaConstants.isUndefined(f);
        updatePadding();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void updatePadding() {
        /*
            r4 = this;
            r0 = 0
        L1:
            r1 = 8
            if (r0 > r1) goto Lb6
            if (r0 == 0) goto L62
            r2 = 2
            if (r0 == r2) goto L62
            r2 = 4
            if (r0 == r2) goto L62
            r2 = 5
            if (r0 != r2) goto L11
            goto L62
        L11:
            r2 = 1
            if (r0 == r2) goto L33
            r2 = 3
            if (r0 != r2) goto L18
            goto L33
        L18:
            float[] r1 = r4.mPadding
            r1 = r1[r0]
            boolean r1 = com.facebook.yoga.YogaConstants.isUndefined(r1)
            if (r1 == 0) goto L91
            com.facebook.yoga.YogaNode r1 = r4.mYogaNode
            com.facebook.yoga.YogaEdge r2 = com.facebook.yoga.YogaEdge.fromInt(r0)
            com.facebook.react.uimanager.Spacing r3 = r4.mDefaultPadding
            float r3 = r3.getRaw(r0)
            r1.setPadding(r2, r3)
            goto Lb2
        L33:
            float[] r2 = r4.mPadding
            r2 = r2[r0]
            boolean r2 = com.facebook.yoga.YogaConstants.isUndefined(r2)
            if (r2 == 0) goto L91
            float[] r2 = r4.mPadding
            r3 = 7
            r2 = r2[r3]
            boolean r2 = com.facebook.yoga.YogaConstants.isUndefined(r2)
            if (r2 == 0) goto L91
            float[] r2 = r4.mPadding
            r1 = r2[r1]
            boolean r1 = com.facebook.yoga.YogaConstants.isUndefined(r1)
            if (r1 == 0) goto L91
            com.facebook.yoga.YogaNode r1 = r4.mYogaNode
            com.facebook.yoga.YogaEdge r2 = com.facebook.yoga.YogaEdge.fromInt(r0)
            com.facebook.react.uimanager.Spacing r3 = r4.mDefaultPadding
            float r3 = r3.getRaw(r0)
            r1.setPadding(r2, r3)
            goto Lb2
        L62:
            float[] r2 = r4.mPadding
            r2 = r2[r0]
            boolean r2 = com.facebook.yoga.YogaConstants.isUndefined(r2)
            if (r2 == 0) goto L91
            float[] r2 = r4.mPadding
            r3 = 6
            r2 = r2[r3]
            boolean r2 = com.facebook.yoga.YogaConstants.isUndefined(r2)
            if (r2 == 0) goto L91
            float[] r2 = r4.mPadding
            r1 = r2[r1]
            boolean r1 = com.facebook.yoga.YogaConstants.isUndefined(r1)
            if (r1 == 0) goto L91
            com.facebook.yoga.YogaNode r1 = r4.mYogaNode
            com.facebook.yoga.YogaEdge r2 = com.facebook.yoga.YogaEdge.fromInt(r0)
            com.facebook.react.uimanager.Spacing r3 = r4.mDefaultPadding
            float r3 = r3.getRaw(r0)
            r1.setPadding(r2, r3)
            goto Lb2
        L91:
            boolean[] r1 = r4.mPaddingIsPercent
            boolean r1 = r1[r0]
            if (r1 == 0) goto La5
            com.facebook.yoga.YogaNode r1 = r4.mYogaNode
            com.facebook.yoga.YogaEdge r2 = com.facebook.yoga.YogaEdge.fromInt(r0)
            float[] r3 = r4.mPadding
            r3 = r3[r0]
            r1.setPaddingPercent(r2, r3)
            goto Lb2
        La5:
            com.facebook.yoga.YogaNode r1 = r4.mYogaNode
            com.facebook.yoga.YogaEdge r2 = com.facebook.yoga.YogaEdge.fromInt(r0)
            float[] r3 = r4.mPadding
            r3 = r3[r0]
            r1.setPadding(r2, r3)
        Lb2:
            int r0 = r0 + 1
            goto L1
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.ReactShadowNodeImpl.updatePadding():void");
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setBorder(int i, float f) {
        this.mYogaNode.setBorder(YogaEdge.fromInt(i), f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setPosition(int i, float f) {
        this.mYogaNode.setPosition(YogaEdge.fromInt(i), f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setPositionPercent(int i, float f) {
        this.mYogaNode.setPositionPercent(YogaEdge.fromInt(i), f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setPositionType(YogaPositionType yogaPositionType) {
        this.mYogaNode.setPositionType(yogaPositionType);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setShouldNotifyOnLayout(boolean z) {
        this.mShouldNotifyOnLayout = z;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setBaselineFunction(YogaBaselineFunction yogaBaselineFunction) {
        this.mYogaNode.setBaselineFunction(yogaBaselineFunction);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setMeasureFunction(YogaMeasureFunction yogaMeasureFunction) {
        this.mYogaNode.setMeasureFunction(yogaMeasureFunction);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public boolean isMeasureDefined() {
        return this.mYogaNode.isMeasureDefined();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public String getHierarchyInfo() {
        StringBuilder sb = new StringBuilder();
        getHierarchyInfoWithIndentation(sb, 0);
        return sb.toString();
    }

    private void getHierarchyInfoWithIndentation(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
        sb.append("<").append(getClass().getSimpleName()).append(" view='").append(getViewClass()).append("' tag=").append(getReactTag());
        if (this.mYogaNode != null) {
            sb.append(" layout='x:").append(getScreenX()).append(" y:").append(getScreenY()).append(" w:").append(getLayoutWidth()).append(" h:").append(getLayoutHeight()).append("'");
        } else {
            sb.append("(virtual node)");
        }
        sb.append(">\n");
        if (getChildCount() == 0) {
            return;
        }
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            getChildAt(i3).getHierarchyInfoWithIndentation(sb, i + 1);
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void dispose() {
        YogaNode yogaNode = this.mYogaNode;
        if (yogaNode != null) {
            yogaNode.reset();
            YogaNodePool.get().release(this.mYogaNode);
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setMeasureSpecs(int i, int i2) {
        this.mWidthMeasureSpec = Integer.valueOf(i);
        this.mHeightMeasureSpec = Integer.valueOf(i2);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public Integer getWidthMeasureSpec() {
        return this.mWidthMeasureSpec;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public Integer getHeightMeasureSpec() {
        return this.mHeightMeasureSpec;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public Iterable<? extends ReactShadowNode> calculateLayoutOnChildren() {
        if (isVirtualAnchor()) {
            return null;
        }
        return this.mChildren;
    }
}
