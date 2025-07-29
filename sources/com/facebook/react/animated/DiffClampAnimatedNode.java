package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableMap;
import io.sentry.protocol.MetricSummary;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DiffClampAnimatedNode.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/react/animated/DiffClampAnimatedNode;", "Lcom/facebook/react/animated/ValueAnimatedNode;", "config", "Lcom/facebook/react/bridge/ReadableMap;", "nativeAnimatedNodesManager", "Lcom/facebook/react/animated/NativeAnimatedNodesManager;", "(Lcom/facebook/react/bridge/ReadableMap;Lcom/facebook/react/animated/NativeAnimatedNodesManager;)V", "inputNodeTag", "", "inputNodeValue", "", "getInputNodeValue", "()D", "lastValue", "maxValue", "minValue", "prettyPrint", "", "update", "", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DiffClampAnimatedNode extends ValueAnimatedNode {
    private final int inputNodeTag;
    private double lastValue;
    private final double maxValue;
    private final double minValue;
    private final NativeAnimatedNodesManager nativeAnimatedNodesManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiffClampAnimatedNode(ReadableMap config, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        this.nativeAnimatedNodesManager = nativeAnimatedNodesManager;
        this.inputNodeTag = config.getInt("input");
        this.minValue = config.getDouble(MetricSummary.JsonKeys.MIN);
        this.maxValue = config.getDouble(MetricSummary.JsonKeys.MAX);
        this.nodeValue = this.lastValue;
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public void update() {
        double inputNodeValue = getInputNodeValue();
        double d = inputNodeValue - this.lastValue;
        this.lastValue = inputNodeValue;
        this.nodeValue = Math.min(Math.max(this.nodeValue + d, this.minValue), this.maxValue);
    }

    private final double getInputNodeValue() {
        AnimatedNode nodeById = this.nativeAnimatedNodesManager.getNodeById(this.inputNodeTag);
        if (nodeById == null || !(nodeById instanceof ValueAnimatedNode)) {
            throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.DiffClamp node");
        }
        return ((ValueAnimatedNode) nodeById).getValue();
    }

    @Override // com.facebook.react.animated.ValueAnimatedNode, com.facebook.react.animated.AnimatedNode
    public String prettyPrint() {
        return "DiffClampAnimatedNode[" + this.tag + "]: InputNodeTag: " + this.inputNodeTag + " min: " + this.minValue + " max: " + this.maxValue + " lastValue: " + this.lastValue + " super: " + super.prettyPrint();
    }
}
