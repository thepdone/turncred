package com.facebook.react.animated;

import androidx.camera.video.AudioStats;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DivisionAnimatedNode.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/facebook/react/animated/DivisionAnimatedNode;", "Lcom/facebook/react/animated/ValueAnimatedNode;", "config", "Lcom/facebook/react/bridge/ReadableMap;", "nativeAnimatedNodesManager", "Lcom/facebook/react/animated/NativeAnimatedNodesManager;", "(Lcom/facebook/react/bridge/ReadableMap;Lcom/facebook/react/animated/NativeAnimatedNodesManager;)V", "inputNodes", "", "prettyPrint", "", "update", "", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DivisionAnimatedNode extends ValueAnimatedNode {
    private final int[] inputNodes;
    private final NativeAnimatedNodesManager nativeAnimatedNodesManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DivisionAnimatedNode(ReadableMap config, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        int[] iArr;
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        this.nativeAnimatedNodesManager = nativeAnimatedNodesManager;
        ReadableArray array = config.getArray("input");
        if (array == null) {
            iArr = new int[0];
        } else {
            int size = array.size();
            int[] iArr2 = new int[size];
            for (int i = 0; i < size; i++) {
                iArr2[i] = array.getInt(i);
            }
            iArr = iArr2;
        }
        this.inputNodes = iArr;
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public void update() {
        int[] iArr = this.inputNodes;
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            AnimatedNode nodeById = this.nativeAnimatedNodesManager.getNodeById(iArr[i]);
            if (nodeById != null && (nodeById instanceof ValueAnimatedNode)) {
                double d = ((ValueAnimatedNode) nodeById).nodeValue;
                if (i2 == 0) {
                    this.nodeValue = d;
                } else {
                    if (d == AudioStats.AUDIO_AMPLITUDE_NONE) {
                        throw new JSApplicationCausedNativeException("Detected a division by zero in Animated.divide node with Animated ID " + this.tag);
                    }
                    this.nodeValue /= d;
                }
                i++;
                i2 = i3;
            } else {
                throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.divide node with Animated ID " + this.tag);
            }
        }
    }

    @Override // com.facebook.react.animated.ValueAnimatedNode, com.facebook.react.animated.AnimatedNode
    public String prettyPrint() {
        return "DivisionAnimatedNode[" + this.tag + "]: input nodes: " + this.inputNodes + " - super: " + super.prettyPrint();
    }
}
