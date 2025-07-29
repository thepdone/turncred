package com.facebook.react.animated;

import android.view.View;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.uimanager.common.ViewUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PropsAnimatedNode.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fJ\b\u0010\u0019\u001a\u00020\u0013H\u0016J\u0006\u0010\u001a\u001a\u00020\u0015J\u0006\u0010\u001b\u001a\u00020\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/facebook/react/animated/PropsAnimatedNode;", "Lcom/facebook/react/animated/AnimatedNode;", "config", "Lcom/facebook/react/bridge/ReadableMap;", "nativeAnimatedNodesManager", "Lcom/facebook/react/animated/NativeAnimatedNodesManager;", "(Lcom/facebook/react/bridge/ReadableMap;Lcom/facebook/react/animated/NativeAnimatedNodesManager;)V", "connectedView", "Landroid/view/View;", "getConnectedView", "()Landroid/view/View;", "connectedViewTag", "", "connectedViewUIManager", "Lcom/facebook/react/bridge/UIManager;", "propMap", "Lcom/facebook/react/bridge/JavaOnlyMap;", "propNodeMapping", "", "", "connectToView", "", "viewTag", "uiManager", "disconnectFromView", "prettyPrint", "restoreDefaultValues", "updateView", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PropsAnimatedNode extends AnimatedNode {
    private int connectedViewTag;
    private UIManager connectedViewUIManager;
    private final NativeAnimatedNodesManager nativeAnimatedNodesManager;
    private final JavaOnlyMap propMap;
    private final Map<String, Integer> propNodeMapping;

    public PropsAnimatedNode(ReadableMap config, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        this.nativeAnimatedNodesManager = nativeAnimatedNodesManager;
        this.connectedViewTag = -1;
        this.propMap = new JavaOnlyMap();
        ReadableMap map = config.getMap("props");
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map != null ? map.keySetIterator() : null;
        this.propNodeMapping = new LinkedHashMap();
        while (readableMapKeySetIteratorKeySetIterator != null && readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            this.propNodeMapping.put(strNextKey, Integer.valueOf(map.getInt(strNextKey)));
        }
    }

    public final void connectToView(int viewTag, UIManager uiManager) {
        if (this.connectedViewTag != -1) {
            throw new JSApplicationIllegalArgumentException("Animated node " + this.tag + " is already attached to a view: " + this.connectedViewTag);
        }
        this.connectedViewTag = viewTag;
        this.connectedViewUIManager = uiManager;
    }

    public final void disconnectFromView(int viewTag) {
        int i = this.connectedViewTag;
        if (i != viewTag && i != -1) {
            throw new JSApplicationIllegalArgumentException("Attempting to disconnect view that has not been connected with the given animated node: " + viewTag + " but is connected to view " + this.connectedViewTag);
        }
        this.connectedViewTag = -1;
    }

    public final void restoreDefaultValues() {
        int i = this.connectedViewTag;
        if (i == -1 || ViewUtil.getUIManagerType(i) == 2) {
            return;
        }
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = this.propMap.keySetIterator();
        Intrinsics.checkNotNullExpressionValue(readableMapKeySetIteratorKeySetIterator, "keySetIterator(...)");
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            this.propMap.putNull(readableMapKeySetIteratorKeySetIterator.nextKey());
        }
        UIManager uIManager = this.connectedViewUIManager;
        if (uIManager != null) {
            uIManager.synchronouslyUpdateViewOnUIThread(this.connectedViewTag, this.propMap);
        }
    }

    public final void updateView() {
        if (this.connectedViewTag == -1) {
            return;
        }
        for (Map.Entry<String, Integer> entry : this.propNodeMapping.entrySet()) {
            String key = entry.getKey();
            AnimatedNode nodeById = this.nativeAnimatedNodesManager.getNodeById(entry.getValue().intValue());
            if (nodeById == null) {
                throw new IllegalArgumentException("Mapped property node does not exist".toString());
            }
            if (nodeById instanceof StyleAnimatedNode) {
                ((StyleAnimatedNode) nodeById).collectViewUpdates(this.propMap);
            } else if (nodeById instanceof ValueAnimatedNode) {
                ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) nodeById;
                Object objectValue = valueAnimatedNode.getObjectValue();
                if (objectValue instanceof Integer) {
                    this.propMap.putInt(key, ((Number) objectValue).intValue());
                } else if (objectValue instanceof String) {
                    this.propMap.putString(key, (String) objectValue);
                } else {
                    this.propMap.putDouble(key, valueAnimatedNode.getValue());
                }
            } else if (nodeById instanceof ColorAnimatedNode) {
                this.propMap.putInt(key, ((ColorAnimatedNode) nodeById).getColor());
            } else if (nodeById instanceof ObjectAnimatedNode) {
                ((ObjectAnimatedNode) nodeById).collectViewUpdates(key, this.propMap);
            } else {
                throw new IllegalArgumentException("Unsupported type of node used in property node " + nodeById.getClass());
            }
        }
        UIManager uIManager = this.connectedViewUIManager;
        if (uIManager != null) {
            uIManager.synchronouslyUpdateViewOnUIThread(this.connectedViewTag, this.propMap);
        }
    }

    public final View getConnectedView() {
        Object objM5937constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            PropsAnimatedNode propsAnimatedNode = this;
            UIManager uIManager = this.connectedViewUIManager;
            objM5937constructorimpl = Result.m5937constructorimpl(uIManager != null ? uIManager.resolveView(this.connectedViewTag) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM5937constructorimpl = Result.m5937constructorimpl(ResultKt.createFailure(th));
        }
        return (View) (Result.m5943isFailureimpl(objM5937constructorimpl) ? null : objM5937constructorimpl);
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public String prettyPrint() {
        return "PropsAnimatedNode[" + this.tag + "] connectedViewTag: " + this.connectedViewTag + " propNodeMapping: " + this.propNodeMapping + " propMap: " + this.propMap;
    }
}
