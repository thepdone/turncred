package com.facebook.react.animated;

import android.util.SparseArray;
import com.facebook.common.logging.FLog;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import io.sentry.protocol.SentryStackTrace;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/* loaded from: classes4.dex */
public class NativeAnimatedNodesManager implements EventDispatcherListener {
    private static final String TAG = "NativeAnimatedNodesManager";
    private final ReactApplicationContext mReactApplicationContext;
    private final SparseArray<AnimatedNode> mAnimatedNodes = new SparseArray<>();
    private final SparseArray<AnimationDriver> mActiveAnimations = new SparseArray<>();
    private final SparseArray<AnimatedNode> mUpdatedNodes = new SparseArray<>();
    private final List<EventAnimationDriver> mEventDrivers = new ArrayList();
    private int mAnimatedGraphBFSColor = 0;
    private final List<AnimatedNode> mRunUpdateNodeList = new LinkedList();
    private boolean mEventListenerInitializedForFabric = false;
    private boolean mEventListenerInitializedForNonFabric = false;
    private boolean mWarnedAboutGraphTraversal = false;

    public NativeAnimatedNodesManager(ReactApplicationContext reactApplicationContext) {
        this.mReactApplicationContext = reactApplicationContext;
    }

    public void initializeEventListenerForUIManagerType(int i) {
        if (i == 2) {
            if (this.mEventListenerInitializedForFabric) {
                return;
            }
        } else if (this.mEventListenerInitializedForNonFabric) {
            return;
        }
        UIManager uIManager = UIManagerHelper.getUIManager(this.mReactApplicationContext, i);
        if (uIManager != null) {
            uIManager.getEventDispatcher().addListener(this);
            if (i == 2) {
                this.mEventListenerInitializedForFabric = true;
            } else {
                this.mEventListenerInitializedForNonFabric = true;
            }
        }
    }

    public AnimatedNode getNodeById(int i) {
        return this.mAnimatedNodes.get(i);
    }

    public boolean hasActiveAnimations() {
        return this.mActiveAnimations.size() > 0 || this.mUpdatedNodes.size() > 0;
    }

    public void createAnimatedNode(int i, ReadableMap readableMap) {
        AnimatedNode objectAnimatedNode;
        if (this.mAnimatedNodes.get(i) != null) {
            throw new JSApplicationIllegalArgumentException("createAnimatedNode: Animated node [" + i + "] already exists");
        }
        String string = readableMap.getString("type");
        if (AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE.equals(string)) {
            objectAnimatedNode = new StyleAnimatedNode(readableMap, this);
        } else if ("value".equals(string)) {
            objectAnimatedNode = new ValueAnimatedNode(readableMap);
        } else if (ViewProps.COLOR.equals(string)) {
            objectAnimatedNode = new ColorAnimatedNode(readableMap, this, this.mReactApplicationContext);
        } else if ("props".equals(string)) {
            objectAnimatedNode = new PropsAnimatedNode(readableMap, this);
        } else if ("interpolation".equals(string)) {
            objectAnimatedNode = new InterpolationAnimatedNode(readableMap);
        } else if ("addition".equals(string)) {
            objectAnimatedNode = new AdditionAnimatedNode(readableMap, this);
        } else if ("subtraction".equals(string)) {
            objectAnimatedNode = new SubtractionAnimatedNode(readableMap, this);
        } else if ("division".equals(string)) {
            objectAnimatedNode = new DivisionAnimatedNode(readableMap, this);
        } else if ("multiplication".equals(string)) {
            objectAnimatedNode = new MultiplicationAnimatedNode(readableMap, this);
        } else if ("modulus".equals(string)) {
            objectAnimatedNode = new ModulusAnimatedNode(readableMap, this);
        } else if ("diffclamp".equals(string)) {
            objectAnimatedNode = new DiffClampAnimatedNode(readableMap, this);
        } else if (ViewProps.TRANSFORM.equals(string)) {
            objectAnimatedNode = new TransformAnimatedNode(readableMap, this);
        } else if ("tracking".equals(string)) {
            objectAnimatedNode = new TrackingAnimatedNode(readableMap, this);
        } else if ("object".equals(string)) {
            objectAnimatedNode = new ObjectAnimatedNode(readableMap, this);
        } else {
            throw new JSApplicationIllegalArgumentException("Unsupported node type: " + string);
        }
        objectAnimatedNode.tag = i;
        this.mAnimatedNodes.put(i, objectAnimatedNode);
        this.mUpdatedNodes.put(i, objectAnimatedNode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateAnimatedNodeConfig(int i, ReadableMap readableMap) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == 0) {
            throw new JSApplicationIllegalArgumentException("updateAnimatedNode: Animated node [" + i + "] does not exist");
        }
        if (animatedNode instanceof AnimatedNodeWithUpdateableConfig) {
            stopAnimationsForNode(animatedNode);
            ((AnimatedNodeWithUpdateableConfig) animatedNode).onUpdateConfig(readableMap);
            this.mUpdatedNodes.put(i, animatedNode);
        }
    }

    public void dropAnimatedNode(int i) {
        this.mAnimatedNodes.remove(i);
        this.mUpdatedNodes.remove(i);
    }

    public void startListeningToAnimatedNodeValue(int i, AnimatedNodeValueListener animatedNodeValueListener) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("startListeningToAnimatedNodeValue: Animated node [" + i + "] does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).setValueListener(animatedNodeValueListener);
    }

    public void stopListeningToAnimatedNodeValue(int i) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("startListeningToAnimatedNodeValue: Animated node [" + i + "] does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).setValueListener(null);
    }

    public void setAnimatedNodeValue(int i, double d) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("setAnimatedNodeValue: Animated node [" + i + "] does not exist, or is not a 'value' node");
        }
        stopAnimationsForNode(animatedNode);
        ((ValueAnimatedNode) animatedNode).nodeValue = d;
        this.mUpdatedNodes.put(i, animatedNode);
    }

    public void setAnimatedNodeOffset(int i, double d) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("setAnimatedNodeOffset: Animated node [" + i + "] does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).offset = d;
        this.mUpdatedNodes.put(i, animatedNode);
    }

    public void flattenAnimatedNodeOffset(int i) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("flattenAnimatedNodeOffset: Animated node [" + i + "] does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).flattenOffset();
    }

    public void extractAnimatedNodeOffset(int i) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("extractAnimatedNodeOffset: Animated node [" + i + "] does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).extractOffset();
    }

    public void startAnimatingNode(int i, int i2, ReadableMap readableMap, Callback callback) {
        AnimationDriver decayAnimation;
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i2);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("startAnimatingNode: Animated node [" + i2 + "] does not exist");
        }
        if (!(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("startAnimatingNode: Animated node [" + i2 + "] should be of type " + ValueAnimatedNode.class.getName());
        }
        AnimationDriver animationDriver = this.mActiveAnimations.get(i);
        if (animationDriver != null) {
            animationDriver.resetConfig(readableMap);
            return;
        }
        String string = readableMap.getString("type");
        if (SentryStackTrace.JsonKeys.FRAMES.equals(string)) {
            decayAnimation = new FrameBasedAnimationDriver(readableMap);
        } else if ("spring".equals(string)) {
            decayAnimation = new SpringAnimation(readableMap);
        } else if ("decay".equals(string)) {
            decayAnimation = new DecayAnimation(readableMap);
        } else {
            throw new JSApplicationIllegalArgumentException("startAnimatingNode: Unsupported animation type [" + i2 + "]: " + string);
        }
        decayAnimation.id = i;
        decayAnimation.endCallback = callback;
        decayAnimation.animatedValue = (ValueAnimatedNode) animatedNode;
        this.mActiveAnimations.put(i, decayAnimation);
    }

    private void stopAnimationsForNode(AnimatedNode animatedNode) {
        WritableArray writableArrayCreateArray = null;
        int i = 0;
        while (i < this.mActiveAnimations.size()) {
            AnimationDriver animationDriverValueAt = this.mActiveAnimations.valueAt(i);
            if (animatedNode.equals(animationDriverValueAt.animatedValue)) {
                if (animationDriverValueAt.endCallback != null) {
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    writableMapCreateMap.putBoolean("finished", false);
                    writableMapCreateMap.putDouble("value", animationDriverValueAt.animatedValue.nodeValue);
                    animationDriverValueAt.endCallback.invoke(writableMapCreateMap);
                } else if (this.mReactApplicationContext != null) {
                    WritableMap writableMapCreateMap2 = Arguments.createMap();
                    writableMapCreateMap2.putInt("animationId", animationDriverValueAt.id);
                    writableMapCreateMap2.putBoolean("finished", false);
                    writableMapCreateMap2.putDouble("value", animationDriverValueAt.animatedValue.nodeValue);
                    if (writableArrayCreateArray == null) {
                        writableArrayCreateArray = Arguments.createArray();
                    }
                    writableArrayCreateArray.pushMap(writableMapCreateMap2);
                }
                this.mActiveAnimations.removeAt(i);
                i--;
            }
            i++;
        }
        if (writableArrayCreateArray != null) {
            this.mReactApplicationContext.emitDeviceEvent("onNativeAnimatedModuleAnimationFinished", writableArrayCreateArray);
        }
    }

    public void stopAnimation(int i) {
        WritableArray writableArray;
        int i2 = 0;
        while (true) {
            writableArray = null;
            if (i2 >= this.mActiveAnimations.size()) {
                break;
            }
            AnimationDriver animationDriverValueAt = this.mActiveAnimations.valueAt(i2);
            if (animationDriverValueAt.id == i) {
                if (animationDriverValueAt.endCallback != null) {
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    writableMapCreateMap.putBoolean("finished", false);
                    writableMapCreateMap.putDouble("value", animationDriverValueAt.animatedValue.nodeValue);
                    animationDriverValueAt.endCallback.invoke(writableMapCreateMap);
                } else if (this.mReactApplicationContext != null) {
                    WritableMap writableMapCreateMap2 = Arguments.createMap();
                    writableMapCreateMap2.putInt("animationId", animationDriverValueAt.id);
                    writableMapCreateMap2.putBoolean("finished", false);
                    writableMapCreateMap2.putDouble("value", animationDriverValueAt.animatedValue.nodeValue);
                    WritableArray writableArrayCreateArray = Arguments.createArray();
                    writableArrayCreateArray.pushMap(writableMapCreateMap2);
                    writableArray = writableArrayCreateArray;
                }
                this.mActiveAnimations.removeAt(i2);
            } else {
                i2++;
            }
        }
        if (writableArray != null) {
            this.mReactApplicationContext.emitDeviceEvent("onNativeAnimatedModuleAnimationFinished", writableArray);
        }
    }

    public void connectAnimatedNodes(int i, int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("connectAnimatedNodes: Animated node with tag (parent) [" + i + "] does not exist");
        }
        AnimatedNode animatedNode2 = this.mAnimatedNodes.get(i2);
        if (animatedNode2 == null) {
            throw new JSApplicationIllegalArgumentException("connectAnimatedNodes: Animated node with tag (child) [" + i2 + "] does not exist");
        }
        animatedNode.addChild(animatedNode2);
        this.mUpdatedNodes.put(i2, animatedNode2);
    }

    public void disconnectAnimatedNodes(int i, int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("disconnectAnimatedNodes: Animated node with tag (parent) [" + i + "] does not exist");
        }
        AnimatedNode animatedNode2 = this.mAnimatedNodes.get(i2);
        if (animatedNode2 == null) {
            throw new JSApplicationIllegalArgumentException("disconnectAnimatedNodes: Animated node with tag (child) [" + i2 + "] does not exist");
        }
        animatedNode.removeChild(animatedNode2);
        this.mUpdatedNodes.put(i2, animatedNode2);
    }

    public void connectAnimatedNodeToView(int i, int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("connectAnimatedNodeToView: Animated node with tag [" + i + "] does not exist");
        }
        if (!(animatedNode instanceof PropsAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("connectAnimatedNodeToView: Animated node connected to view [" + i2 + "] should be of type " + PropsAnimatedNode.class.getName());
        }
        ReactApplicationContext reactApplicationContext = this.mReactApplicationContext;
        if (reactApplicationContext == null) {
            throw new IllegalStateException("connectAnimatedNodeToView: Animated node could not be connected, no ReactApplicationContext: " + i2);
        }
        UIManager uIManagerForReactTag = UIManagerHelper.getUIManagerForReactTag(reactApplicationContext, i2);
        if (uIManagerForReactTag == null) {
            ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("connectAnimatedNodeToView: Animated node could not be connected to UIManager - uiManager disappeared for tag: " + i2));
        } else {
            ((PropsAnimatedNode) animatedNode).connectToView(i2, uIManagerForReactTag);
            this.mUpdatedNodes.put(i, animatedNode);
        }
    }

    public void disconnectAnimatedNodeFromView(int i, int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("disconnectAnimatedNodeFromView: Animated node with tag [" + i + "] does not exist");
        }
        if (!(animatedNode instanceof PropsAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("disconnectAnimatedNodeFromView: Animated node connected to view [" + i2 + "] should be of type " + PropsAnimatedNode.class.getName());
        }
        ((PropsAnimatedNode) animatedNode).disconnectFromView(i2);
    }

    public void getValue(int i, Callback callback) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("getValue: Animated node with tag [" + i + "] does not exist or is not a 'value' node");
        }
        double value = ((ValueAnimatedNode) animatedNode).getValue();
        if (callback != null) {
            callback.invoke(Double.valueOf(value));
        } else {
            if (this.mReactApplicationContext == null) {
                return;
            }
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putInt("tag", i);
            writableMapCreateMap.putDouble("value", value);
            this.mReactApplicationContext.emitDeviceEvent("onNativeAnimatedModuleGetValue", writableMapCreateMap);
        }
    }

    public void restoreDefaultValues(int i) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null) {
            return;
        }
        if (!(animatedNode instanceof PropsAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("Animated node connected to view [?] should be of type " + PropsAnimatedNode.class.getName());
        }
        ((PropsAnimatedNode) animatedNode).restoreDefaultValues();
    }

    public void addAnimatedEventToView(int i, String str, ReadableMap readableMap) {
        int i2 = readableMap.getInt("animatedValueTag");
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i2);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("addAnimatedEventToView: Animated node with tag [" + i2 + "] does not exist");
        }
        if (!(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("addAnimatedEventToView: Animated node on view [" + i + "] connected to event handler (" + str + ") should be of type " + ValueAnimatedNode.class.getName());
        }
        ReadableArray array = readableMap.getArray("nativeEventPath");
        ArrayList arrayList = new ArrayList(array.size());
        for (int i3 = 0; i3 < array.size(); i3++) {
            arrayList.add(array.getString(i3));
        }
        String strNormalizeEventName = normalizeEventName(str);
        this.mEventDrivers.add(new EventAnimationDriver(strNormalizeEventName, i, arrayList, (ValueAnimatedNode) animatedNode));
        if (strNormalizeEventName.equals("topScroll")) {
            addAnimatedEventToView(i, "topScrollEnded", readableMap);
        }
    }

    public void removeAnimatedEventFromView(int i, String str, int i2) {
        String strNormalizeEventName = normalizeEventName(str);
        ListIterator<EventAnimationDriver> listIterator = this.mEventDrivers.listIterator();
        while (listIterator.hasNext()) {
            EventAnimationDriver next = listIterator.next();
            if (strNormalizeEventName.equals(next.eventName) && i == next.viewTag && i2 == next.valueNode.tag) {
                listIterator.remove();
                return;
            }
        }
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcherListener
    public void onEventDispatch(final Event event) {
        if (UiThreadUtil.isOnUiThread()) {
            handleEvent(event);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.animated.NativeAnimatedNodesManager.1
                @Override // java.lang.Runnable
                public void run() {
                    NativeAnimatedNodesManager.this.handleEvent(event);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleEvent(Event event) {
        ReactApplicationContext reactApplicationContext;
        if (this.mEventDrivers.isEmpty() || (reactApplicationContext = this.mReactApplicationContext) == null || UIManagerHelper.getUIManager(reactApplicationContext, ViewUtil.getUIManagerType(event.getViewTag(), event.getSurfaceId())) == null) {
            return;
        }
        Event.EventAnimationDriverMatchSpec eventAnimationDriverMatchSpec = event.getEventAnimationDriverMatchSpec();
        boolean z = false;
        for (EventAnimationDriver eventAnimationDriver : this.mEventDrivers) {
            if (eventAnimationDriverMatchSpec.match(eventAnimationDriver.viewTag, eventAnimationDriver.eventName)) {
                stopAnimationsForNode(eventAnimationDriver.valueNode);
                event.dispatchModern(eventAnimationDriver);
                this.mRunUpdateNodeList.add(eventAnimationDriver.valueNode);
                z = true;
            }
        }
        if (z) {
            updateNodes(this.mRunUpdateNodeList);
            this.mRunUpdateNodeList.clear();
        }
    }

    public void runUpdates(long j) {
        UiThreadUtil.assertOnUiThread();
        for (int i = 0; i < this.mUpdatedNodes.size(); i++) {
            this.mRunUpdateNodeList.add(this.mUpdatedNodes.valueAt(i));
        }
        this.mUpdatedNodes.clear();
        boolean z = false;
        for (int i2 = 0; i2 < this.mActiveAnimations.size(); i2++) {
            AnimationDriver animationDriverValueAt = this.mActiveAnimations.valueAt(i2);
            animationDriverValueAt.runAnimationStep(j);
            this.mRunUpdateNodeList.add(animationDriverValueAt.animatedValue);
            if (animationDriverValueAt.hasFinished) {
                z = true;
            }
        }
        updateNodes(this.mRunUpdateNodeList);
        this.mRunUpdateNodeList.clear();
        if (z) {
            WritableArray writableArrayCreateArray = null;
            for (int size = this.mActiveAnimations.size() - 1; size >= 0; size--) {
                AnimationDriver animationDriverValueAt2 = this.mActiveAnimations.valueAt(size);
                if (animationDriverValueAt2.hasFinished) {
                    if (animationDriverValueAt2.endCallback != null) {
                        WritableMap writableMapCreateMap = Arguments.createMap();
                        writableMapCreateMap.putBoolean("finished", true);
                        writableMapCreateMap.putDouble("value", animationDriverValueAt2.animatedValue.nodeValue);
                        animationDriverValueAt2.endCallback.invoke(writableMapCreateMap);
                    } else if (this.mReactApplicationContext != null) {
                        WritableMap writableMapCreateMap2 = Arguments.createMap();
                        writableMapCreateMap2.putInt("animationId", animationDriverValueAt2.id);
                        writableMapCreateMap2.putBoolean("finished", true);
                        writableMapCreateMap2.putDouble("value", animationDriverValueAt2.animatedValue.nodeValue);
                        if (writableArrayCreateArray == null) {
                            writableArrayCreateArray = Arguments.createArray();
                        }
                        writableArrayCreateArray.pushMap(writableMapCreateMap2);
                    }
                    this.mActiveAnimations.removeAt(size);
                }
            }
            if (writableArrayCreateArray != null) {
                this.mReactApplicationContext.emitDeviceEvent("onNativeAnimatedModuleAnimationFinished", writableArrayCreateArray);
            }
        }
    }

    Set<Integer> getTagsOfConnectedNodes(int i, String str) {
        HashSet hashSet = new HashSet();
        ListIterator<EventAnimationDriver> listIterator = this.mEventDrivers.listIterator();
        while (listIterator.hasNext()) {
            EventAnimationDriver next = listIterator.next();
            if (next != null && str.equals(next.eventName) && i == next.viewTag) {
                hashSet.add(Integer.valueOf(next.viewTag));
                if (next.valueNode != null && next.valueNode.children != null) {
                    Iterator<AnimatedNode> it = next.valueNode.children.iterator();
                    while (it.hasNext()) {
                        hashSet.add(Integer.valueOf(it.next().tag));
                    }
                }
            }
        }
        return hashSet;
    }

    private void updateNodes(List<AnimatedNode> list) {
        int i = this.mAnimatedGraphBFSColor;
        int i2 = i + 1;
        this.mAnimatedGraphBFSColor = i2;
        if (i2 == 0) {
            this.mAnimatedGraphBFSColor = i + 2;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i3 = 0;
        for (AnimatedNode animatedNode : list) {
            int i4 = animatedNode.BFSColor;
            int i5 = this.mAnimatedGraphBFSColor;
            if (i4 != i5) {
                animatedNode.BFSColor = i5;
                i3++;
                arrayDeque.add(animatedNode);
            }
        }
        while (!arrayDeque.isEmpty()) {
            AnimatedNode animatedNode2 = (AnimatedNode) arrayDeque.poll();
            if (animatedNode2.children != null) {
                for (int i6 = 0; i6 < animatedNode2.children.size(); i6++) {
                    AnimatedNode animatedNode3 = animatedNode2.children.get(i6);
                    animatedNode3.activeIncomingNodes++;
                    int i7 = animatedNode3.BFSColor;
                    int i8 = this.mAnimatedGraphBFSColor;
                    if (i7 != i8) {
                        animatedNode3.BFSColor = i8;
                        i3++;
                        arrayDeque.add(animatedNode3);
                    }
                }
            }
        }
        int i9 = this.mAnimatedGraphBFSColor;
        int i10 = i9 + 1;
        this.mAnimatedGraphBFSColor = i10;
        if (i10 == 0) {
            this.mAnimatedGraphBFSColor = i9 + 2;
        }
        int i11 = 0;
        for (AnimatedNode animatedNode4 : list) {
            if (animatedNode4.activeIncomingNodes == 0) {
                int i12 = animatedNode4.BFSColor;
                int i13 = this.mAnimatedGraphBFSColor;
                if (i12 != i13) {
                    animatedNode4.BFSColor = i13;
                    i11++;
                    arrayDeque.add(animatedNode4);
                }
            }
        }
        int i14 = 0;
        while (!arrayDeque.isEmpty()) {
            AnimatedNode animatedNode5 = (AnimatedNode) arrayDeque.poll();
            try {
                animatedNode5.update();
                if (animatedNode5 instanceof PropsAnimatedNode) {
                    ((PropsAnimatedNode) animatedNode5).updateView();
                }
            } catch (JSApplicationCausedNativeException e) {
                FLog.e(TAG, "Native animation workaround, frame lost as result of race condition", e);
            }
            if (animatedNode5 instanceof ValueAnimatedNode) {
                ((ValueAnimatedNode) animatedNode5).onValueUpdate();
            }
            if (animatedNode5.children != null) {
                for (int i15 = 0; i15 < animatedNode5.children.size(); i15++) {
                    AnimatedNode animatedNode6 = animatedNode5.children.get(i15);
                    animatedNode6.activeIncomingNodes--;
                    if (animatedNode6.BFSColor != this.mAnimatedGraphBFSColor && animatedNode6.activeIncomingNodes == 0) {
                        animatedNode6.BFSColor = this.mAnimatedGraphBFSColor;
                        i11++;
                        arrayDeque.add(animatedNode6);
                    } else if (animatedNode6.BFSColor == this.mAnimatedGraphBFSColor) {
                        i14++;
                    }
                }
            }
        }
        if (i3 != i11) {
            if (this.mWarnedAboutGraphTraversal) {
                return;
            }
            this.mWarnedAboutGraphTraversal = true;
            FLog.e(TAG, "Detected animation cycle or disconnected graph. ");
            Iterator<AnimatedNode> it = list.iterator();
            while (it.hasNext()) {
                FLog.e(TAG, it.next().prettyPrintWithChildren());
            }
            IllegalStateException illegalStateException = new IllegalStateException("Looks like animated nodes graph has " + (i14 > 0 ? "cycles (" + i14 + ")" : "disconnected regions") + ", there are " + i3 + " but toposort visited only " + i11);
            boolean z = this.mEventListenerInitializedForFabric;
            if (z && i14 == 0) {
                ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException(illegalStateException));
                return;
            } else {
                if (z) {
                    ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException(illegalStateException));
                    return;
                }
                throw illegalStateException;
            }
        }
        this.mWarnedAboutGraphTraversal = false;
    }

    private String normalizeEventName(String str) {
        return str.startsWith("on") ? "top" + str.substring(2) : str;
    }
}
