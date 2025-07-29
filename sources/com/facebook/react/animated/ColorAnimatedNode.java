package com.facebook.react.animated;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.view.ColorUtil;
import com.nimbusds.jose.jwk.JWKParameterNames;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ColorAnimatedNode.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/facebook/react/animated/ColorAnimatedNode;", "Lcom/facebook/react/animated/AnimatedNode;", "Lcom/facebook/react/animated/AnimatedNodeWithUpdateableConfig;", "config", "Lcom/facebook/react/bridge/ReadableMap;", "nativeAnimatedNodesManager", "Lcom/facebook/react/animated/NativeAnimatedNodesManager;", "reactApplicationContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReadableMap;Lcom/facebook/react/animated/NativeAnimatedNodesManager;Lcom/facebook/react/bridge/ReactApplicationContext;)V", "aNodeId", "", "bNodeId", ViewProps.COLOR, "getColor", "()I", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "gNodeId", "nativeColor", "nativeColorApplied", "", "rNodeId", "onUpdateConfig", "", "prettyPrint", "", "tryApplyNativeColor", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ColorAnimatedNode extends AnimatedNode implements AnimatedNodeWithUpdateableConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int aNodeId;
    private int bNodeId;
    private int gNodeId;
    private final NativeAnimatedNodesManager nativeAnimatedNodesManager;
    private ReadableMap nativeColor;
    private boolean nativeColorApplied;
    private int rNodeId;
    private final ReactApplicationContext reactApplicationContext;

    public ColorAnimatedNode(ReadableMap config, NativeAnimatedNodesManager nativeAnimatedNodesManager, ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(nativeAnimatedNodesManager, "nativeAnimatedNodesManager");
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        this.nativeAnimatedNodesManager = nativeAnimatedNodesManager;
        this.reactApplicationContext = reactApplicationContext;
        onUpdateConfig(config);
    }

    public final int getColor() {
        tryApplyNativeColor();
        ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) this.nativeAnimatedNodesManager.getNodeById(this.rNodeId);
        ValueAnimatedNode valueAnimatedNode2 = (ValueAnimatedNode) this.nativeAnimatedNodesManager.getNodeById(this.gNodeId);
        ValueAnimatedNode valueAnimatedNode3 = (ValueAnimatedNode) this.nativeAnimatedNodesManager.getNodeById(this.bNodeId);
        ValueAnimatedNode valueAnimatedNode4 = (ValueAnimatedNode) this.nativeAnimatedNodesManager.getNodeById(this.aNodeId);
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        double d2 = valueAnimatedNode != null ? valueAnimatedNode.nodeValue : 0.0d;
        double d3 = valueAnimatedNode2 != null ? valueAnimatedNode2.nodeValue : 0.0d;
        double d4 = valueAnimatedNode3 != null ? valueAnimatedNode3.nodeValue : 0.0d;
        if (valueAnimatedNode4 != null) {
            d = valueAnimatedNode4.nodeValue;
        }
        return ColorUtil.normalize(d2, d3, d4, d);
    }

    @Override // com.facebook.react.animated.AnimatedNodeWithUpdateableConfig
    public void onUpdateConfig(ReadableMap config) {
        if (config != null) {
            this.rNodeId = config.getInt(JWKParameterNames.RSA_OTHER_PRIMES__PRIME_FACTOR);
            this.gNodeId = config.getInt("g");
            this.bNodeId = config.getInt("b");
            this.aNodeId = config.getInt("a");
            this.nativeColor = config.getMap("nativeColor");
            this.nativeColorApplied = false;
            tryApplyNativeColor();
            return;
        }
        this.rNodeId = 0;
        this.gNodeId = 0;
        this.bNodeId = 0;
        this.aNodeId = 0;
        this.nativeColor = null;
        this.nativeColorApplied = false;
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public String prettyPrint() {
        return "ColorAnimatedNode[" + this.tag + "]: r: " + this.rNodeId + "  g: " + this.gNodeId + " b: " + this.bNodeId + " a: " + this.aNodeId;
    }

    private final void tryApplyNativeColor() {
        Context context;
        if (this.nativeColor == null || this.nativeColorApplied || (context = getContext()) == null) {
            return;
        }
        Integer color = ColorPropConverter.getColor(this.nativeColor, context);
        ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) this.nativeAnimatedNodesManager.getNodeById(this.rNodeId);
        ValueAnimatedNode valueAnimatedNode2 = (ValueAnimatedNode) this.nativeAnimatedNodesManager.getNodeById(this.gNodeId);
        ValueAnimatedNode valueAnimatedNode3 = (ValueAnimatedNode) this.nativeAnimatedNodesManager.getNodeById(this.bNodeId);
        ValueAnimatedNode valueAnimatedNode4 = (ValueAnimatedNode) this.nativeAnimatedNodesManager.getNodeById(this.aNodeId);
        if (valueAnimatedNode != null) {
            Intrinsics.checkNotNull(color);
            valueAnimatedNode.nodeValue = Color.red(color.intValue());
        }
        if (valueAnimatedNode2 != null) {
            Intrinsics.checkNotNull(color);
            valueAnimatedNode2.nodeValue = Color.green(color.intValue());
        }
        if (valueAnimatedNode3 != null) {
            Intrinsics.checkNotNull(color);
            valueAnimatedNode3.nodeValue = Color.blue(color.intValue());
        }
        if (valueAnimatedNode4 != null) {
            Intrinsics.checkNotNull(color);
            valueAnimatedNode4.nodeValue = Color.alpha(color.intValue()) / 255.0d;
        }
        this.nativeColorApplied = true;
    }

    private final Context getContext() {
        Activity currentActivity = this.reactApplicationContext.getCurrentActivity();
        return currentActivity != null ? currentActivity : INSTANCE.getContextHelper(this);
    }

    /* compiled from: ColorAnimatedNode.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/facebook/react/animated/ColorAnimatedNode$Companion;", "", "()V", "getContextHelper", "Landroid/content/Context;", "node", "Lcom/facebook/react/animated/AnimatedNode;", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Context getContextHelper(AnimatedNode node) {
            List<AnimatedNode> list = node.children;
            if (list == null) {
                return null;
            }
            Iterator<AnimatedNode> it = list.iterator();
            if (!it.hasNext()) {
                return null;
            }
            AnimatedNode next = it.next();
            if (next instanceof PropsAnimatedNode) {
                View connectedView = ((PropsAnimatedNode) next).getConnectedView();
                if (connectedView != null) {
                    return connectedView.getContext();
                }
                return null;
            }
            return ColorAnimatedNode.INSTANCE.getContextHelper(next);
        }
    }
}
