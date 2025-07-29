package com.swmansion.gesturehandler.react;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.events.Event;
import com.facebook.soloader.SoLoader;
import com.swmansion.common.GestureHandlerStateManager;
import com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec;
import com.swmansion.gesturehandler.ReactContextExtensionsKt;
import com.swmansion.gesturehandler.ReanimatedEventDispatcher;
import com.swmansion.gesturehandler.core.FlingGestureHandler;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.HoverGestureHandler;
import com.swmansion.gesturehandler.core.LongPressGestureHandler;
import com.swmansion.gesturehandler.core.ManualGestureHandler;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import com.swmansion.gesturehandler.core.OnTouchEventListener;
import com.swmansion.gesturehandler.core.PanGestureHandler;
import com.swmansion.gesturehandler.core.PinchGestureHandler;
import com.swmansion.gesturehandler.core.RotationGestureHandler;
import com.swmansion.gesturehandler.core.TapGestureHandler;
import com.swmansion.gesturehandler.react.RNGestureHandlerEvent;
import com.swmansion.gesturehandler.react.eventbuilders.FlingGestureHandlerEventDataBuilder;
import com.swmansion.gesturehandler.react.eventbuilders.GestureHandlerEventDataBuilder;
import com.swmansion.gesturehandler.react.eventbuilders.HoverGestureHandlerEventDataBuilder;
import com.swmansion.gesturehandler.react.eventbuilders.LongPressGestureHandlerEventDataBuilder;
import com.swmansion.gesturehandler.react.eventbuilders.ManualGestureHandlerEventDataBuilder;
import com.swmansion.gesturehandler.react.eventbuilders.NativeGestureHandlerEventDataBuilder;
import com.swmansion.gesturehandler.react.eventbuilders.PanGestureHandlerEventDataBuilder;
import com.swmansion.gesturehandler.react.eventbuilders.PinchGestureHandlerEventDataBuilder;
import com.swmansion.gesturehandler.react.eventbuilders.RotationGestureHandlerEventDataBuilder;
import com.swmansion.gesturehandler.react.eventbuilders.TapGestureHandlerEventDataBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RNGestureHandlerModule.kt */
@ReactModule(name = "RNGestureHandlerModule")
@Metadata(d1 = {"\u0000£\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0001\u0007\b\u0007\u0018\u0000 S2\u00020\u00012\u00020\u0002:\u000bSTUVWXYZ[\\]B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0017J \u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0017J0\u0010#\u001a\u00020\u0019\"\u000e\b\u0000\u0010$*\b\u0012\u0004\u0012\u0002H$0%2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010&\u001a\u00020'2\u0006\u0010!\u001a\u00020\"H\u0002J\u0011\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*H\u0082 J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0017J.\u0010,\u001a\n\u0012\u0004\u0012\u0002H$\u0018\u00010\u000b\"\u000e\b\u0000\u0010$*\b\u0012\u0004\u0012\u0002H$0%2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H$0%H\u0002J\u0012\u0010.\u001a\u0004\u0018\u00010\u00172\u0006\u0010/\u001a\u00020'H\u0002J\b\u00100\u001a\u00020\u0019H\u0017J\u0014\u00101\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020302H\u0016J\b\u00104\u001a\u00020 H\u0016J\b\u00105\u001a\u00020\u0019H\u0017J\u0018\u00106\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u00107\u001a\u000208H\u0017J\b\u00109\u001a\u000208H\u0017J\b\u0010:\u001a\u00020\u0019H\u0016J%\u0010;\u001a\u00020\u0019\"\u000e\b\u0000\u0010$*\b\u0012\u0004\u0012\u0002H$0%2\u0006\u0010-\u001a\u0002H$H\u0002¢\u0006\u0002\u0010<J5\u0010=\u001a\u00020\u0019\"\u000e\b\u0000\u0010$*\b\u0012\u0004\u0012\u0002H$0%2\u0006\u0010-\u001a\u0002H$2\u0006\u0010>\u001a\u00020'2\u0006\u0010?\u001a\u00020'H\u0002¢\u0006\u0002\u0010@J%\u0010A\u001a\u00020\u0019\"\u000e\b\u0000\u0010$*\b\u0012\u0004\u0012\u0002H$0%2\u0006\u0010-\u001a\u0002H$H\u0002¢\u0006\u0002\u0010<J\u000e\u0010B\u001a\u00020\u00192\u0006\u0010C\u001a\u00020\u0017J\u0018\u0010D\u001a\u00020\u00192\u0006\u0010E\u001a\u00020 2\u0006\u0010F\u001a\u00020GH\u0002J%\u0010H\u001a\u00020\u0019\"\u000e\b\u0000\u0010$*\b\u0012\u0004\u0012\u0002H$0I2\u0006\u0010J\u001a\u0002H$H\u0002¢\u0006\u0002\u0010KJ\u0010\u0010L\u001a\u00020\u00192\u0006\u0010J\u001a\u00020MH\u0002J%\u0010N\u001a\u00020\u0019\"\u000e\b\u0000\u0010$*\b\u0012\u0004\u0012\u0002H$0I2\u0006\u0010J\u001a\u0002H$H\u0002¢\u0006\u0002\u0010KJ\u0018\u0010O\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'2\u0006\u0010>\u001a\u00020'H\u0016J\u000e\u0010P\u001a\u00020\u00192\u0006\u0010C\u001a\u00020\u0017J\u0018\u0010Q\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0017J(\u0010R\u001a\u00020\u0019\"\u000e\b\u0000\u0010$*\b\u0012\u0004\u0012\u0002H$0%2\u0006\u0010&\u001a\u00020'2\u0006\u0010!\u001a\u00020\"H\u0002R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u001a\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule;", "Lcom/swmansion/gesturehandler/NativeRNGestureHandlerModuleSpec;", "Lcom/swmansion/common/GestureHandlerStateManager;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "eventListener", "com/swmansion/gesturehandler/react/RNGestureHandlerModule$eventListener$1", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$eventListener$1;", "handlerFactories", "", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "[Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "interactionManager", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerInteractionManager;", "reanimatedEventDispatcher", "Lcom/swmansion/gesturehandler/ReanimatedEventDispatcher;", "registry", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerRegistry;", "getRegistry", "()Lcom/swmansion/gesturehandler/react/RNGestureHandlerRegistry;", "roots", "", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerRootHelper;", "attachGestureHandler", "", "handlerTagDouble", "", "viewTagDouble", "actionTypeDouble", "createGestureHandler", "handlerName", "", "config", "Lcom/facebook/react/bridge/ReadableMap;", "createGestureHandlerHelper", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/swmansion/gesturehandler/core/GestureHandler;", "handlerTag", "", "decorateRuntime", "jsiPtr", "", "dropGestureHandler", "findFactoryForHandler", "handler", "findRootHelperForViewAncestor", "viewTag", "flushOperations", "getConstants", "", "", "getName", "handleClearJSResponder", "handleSetJSResponder", "blockNativeResponder", "", "install", "invalidate", "onHandlerUpdate", "(Lcom/swmansion/gesturehandler/core/GestureHandler;)V", "onStateChange", "newState", "oldState", "(Lcom/swmansion/gesturehandler/core/GestureHandler;II)V", "onTouchEvent", "registerRootHelper", "root", "sendEventForDeviceEvent", "eventName", "data", "Lcom/facebook/react/bridge/WritableMap;", "sendEventForDirectEvent", "Lcom/facebook/react/uimanager/events/Event;", NotificationCompat.CATEGORY_EVENT, "(Lcom/facebook/react/uimanager/events/Event;)V", "sendEventForNativeAnimatedEvent", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerEvent;", "sendEventForReanimated", "setGestureHandlerState", "unregisterRootHelper", "updateGestureHandler", "updateGestureHandlerHelper", "Companion", "FlingGestureHandlerFactory", "HandlerFactory", "HoverGestureHandlerFactory", "LongPressGestureHandlerFactory", "ManualGestureHandlerFactory", "NativeViewGestureHandlerFactory", "PanGestureHandlerFactory", "PinchGestureHandlerFactory", "RotationGestureHandlerFactory", "TapGestureHandlerFactory", "react-native-gesture-handler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RNGestureHandlerModule extends NativeRNGestureHandlerModuleSpec implements GestureHandlerStateManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_DIRECTION = "direction";
    private static final String KEY_ENABLED = "enabled";
    private static final String KEY_HIT_SLOP = "hitSlop";
    private static final String KEY_HIT_SLOP_BOTTOM = "bottom";
    private static final String KEY_HIT_SLOP_HEIGHT = "height";
    private static final String KEY_HIT_SLOP_HORIZONTAL = "horizontal";
    private static final String KEY_HIT_SLOP_LEFT = "left";
    private static final String KEY_HIT_SLOP_RIGHT = "right";
    private static final String KEY_HIT_SLOP_TOP = "top";
    private static final String KEY_HIT_SLOP_VERTICAL = "vertical";
    private static final String KEY_HIT_SLOP_WIDTH = "width";
    private static final String KEY_LONG_PRESS_MAX_DIST = "maxDist";
    private static final String KEY_LONG_PRESS_MIN_DURATION_MS = "minDurationMs";
    private static final String KEY_MANUAL_ACTIVATION = "manualActivation";
    private static final String KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION = "disallowInterruption";
    private static final String KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START = "shouldActivateOnStart";
    private static final String KEY_NEEDS_POINTER_DATA = "needsPointerData";
    private static final String KEY_NUMBER_OF_POINTERS = "numberOfPointers";
    private static final String KEY_PAN_ACTIVATE_AFTER_LONG_PRESS = "activateAfterLongPress";
    private static final String KEY_PAN_ACTIVE_OFFSET_X_END = "activeOffsetXEnd";
    private static final String KEY_PAN_ACTIVE_OFFSET_X_START = "activeOffsetXStart";
    private static final String KEY_PAN_ACTIVE_OFFSET_Y_END = "activeOffsetYEnd";
    private static final String KEY_PAN_ACTIVE_OFFSET_Y_START = "activeOffsetYStart";
    private static final String KEY_PAN_AVG_TOUCHES = "avgTouches";
    private static final String KEY_PAN_FAIL_OFFSET_RANGE_X_END = "failOffsetXEnd";
    private static final String KEY_PAN_FAIL_OFFSET_RANGE_X_START = "failOffsetXStart";
    private static final String KEY_PAN_FAIL_OFFSET_RANGE_Y_END = "failOffsetYEnd";
    private static final String KEY_PAN_FAIL_OFFSET_RANGE_Y_START = "failOffsetYStart";
    private static final String KEY_PAN_MAX_POINTERS = "maxPointers";
    private static final String KEY_PAN_MIN_DIST = "minDist";
    private static final String KEY_PAN_MIN_POINTERS = "minPointers";
    private static final String KEY_PAN_MIN_VELOCITY = "minVelocity";
    private static final String KEY_PAN_MIN_VELOCITY_X = "minVelocityX";
    private static final String KEY_PAN_MIN_VELOCITY_Y = "minVelocityY";
    private static final String KEY_SHOULD_CANCEL_WHEN_OUTSIDE = "shouldCancelWhenOutside";
    private static final String KEY_TAP_MAX_DELAY_MS = "maxDelayMs";
    private static final String KEY_TAP_MAX_DELTA_X = "maxDeltaX";
    private static final String KEY_TAP_MAX_DELTA_Y = "maxDeltaY";
    private static final String KEY_TAP_MAX_DIST = "maxDist";
    private static final String KEY_TAP_MAX_DURATION_MS = "maxDurationMs";
    private static final String KEY_TAP_MIN_POINTERS = "minPointers";
    private static final String KEY_TAP_NUMBER_OF_TAPS = "numberOfTaps";
    public static final String NAME = "RNGestureHandlerModule";
    private final RNGestureHandlerModule$eventListener$1 eventListener;
    private final HandlerFactory<?>[] handlerFactories;
    private final RNGestureHandlerInteractionManager interactionManager;
    private final ReanimatedEventDispatcher reanimatedEventDispatcher;
    private final RNGestureHandlerRegistry registry;
    private final List<RNGestureHandlerRootHelper> roots;

    private final native void decorateRuntime(long jsiPtr);

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void flushOperations() {
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void handleClearJSResponder() {
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.swmansion.gesturehandler.react.RNGestureHandlerModule$eventListener$1] */
    public RNGestureHandlerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.eventListener = new OnTouchEventListener() { // from class: com.swmansion.gesturehandler.react.RNGestureHandlerModule$eventListener$1
            @Override // com.swmansion.gesturehandler.core.OnTouchEventListener
            public <T extends GestureHandler<T>> void onHandlerUpdate(T handler, MotionEvent event) {
                Intrinsics.checkNotNullParameter(handler, "handler");
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.onHandlerUpdate(handler);
            }

            @Override // com.swmansion.gesturehandler.core.OnTouchEventListener
            public <T extends GestureHandler<T>> void onStateChange(T handler, int newState, int oldState) {
                Intrinsics.checkNotNullParameter(handler, "handler");
                this.this$0.onStateChange(handler, newState, oldState);
            }

            @Override // com.swmansion.gesturehandler.core.OnTouchEventListener
            public <T extends GestureHandler<T>> void onTouchEvent(T handler) {
                Intrinsics.checkNotNullParameter(handler, "handler");
                this.this$0.onTouchEvent(handler);
            }
        };
        this.handlerFactories = new HandlerFactory[]{new NativeViewGestureHandlerFactory(), new TapGestureHandlerFactory(), new LongPressGestureHandlerFactory(), new PanGestureHandlerFactory(), new PinchGestureHandlerFactory(), new RotationGestureHandlerFactory(), new FlingGestureHandlerFactory(), new ManualGestureHandlerFactory(), new HoverGestureHandlerFactory()};
        this.registry = new RNGestureHandlerRegistry();
        this.interactionManager = new RNGestureHandlerInteractionManager();
        this.roots = new ArrayList();
        this.reanimatedEventDispatcher = new ReanimatedEventDispatcher();
    }

    /* compiled from: RNGestureHandlerModule.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\"\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0012J\u0017\u0010\u0013\u001a\u00028\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0002\u0010\u0016J\u001b\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u000f\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0019R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/swmansion/gesturehandler/core/GestureHandler;", "", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "configure", "", "handler", "config", "Lcom/facebook/react/bridge/ReadableMap;", "(Lcom/swmansion/gesturehandler/core/GestureHandler;Lcom/facebook/react/bridge/ReadableMap;)V", "create", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Lcom/swmansion/gesturehandler/core/GestureHandler;", "createEventBuilder", "Lcom/swmansion/gesturehandler/react/eventbuilders/GestureHandlerEventDataBuilder;", "(Lcom/swmansion/gesturehandler/core/GestureHandler;)Lcom/swmansion/gesturehandler/react/eventbuilders/GestureHandlerEventDataBuilder;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static abstract class HandlerFactory<T extends GestureHandler<T>> {
        public abstract T create(Context context);

        public abstract GestureHandlerEventDataBuilder<T> createEventBuilder(T handler);

        public abstract String getName();

        public abstract Class<T> getType();

        public void configure(T handler, ReadableMap config) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(config, "config");
            handler.resetConfig();
            if (config.hasKey(RNGestureHandlerModule.KEY_SHOULD_CANCEL_WHEN_OUTSIDE)) {
                handler.setShouldCancelWhenOutside(config.getBoolean(RNGestureHandlerModule.KEY_SHOULD_CANCEL_WHEN_OUTSIDE));
            }
            if (config.hasKey("enabled")) {
                handler.setEnabled(config.getBoolean("enabled"));
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP)) {
                RNGestureHandlerModule.INSTANCE.handleHitSlopProperty(handler, config);
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_NEEDS_POINTER_DATA)) {
                handler.setNeedsPointerData(config.getBoolean(RNGestureHandlerModule.KEY_NEEDS_POINTER_DATA));
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_MANUAL_ACTIVATION)) {
                handler.setManualActivation(config.getBoolean(RNGestureHandlerModule.KEY_MANUAL_ACTIVATION));
            }
            if (config.hasKey("mouseButton")) {
                handler.setMouseButton(config.getInt("mouseButton"));
            }
        }
    }

    /* compiled from: RNGestureHandlerModule.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$NativeViewGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "configure", "", "handler", "config", "Lcom/facebook/react/bridge/ReadableMap;", "create", "context", "Landroid/content/Context;", "createEventBuilder", "Lcom/swmansion/gesturehandler/react/eventbuilders/NativeGestureHandlerEventDataBuilder;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class NativeViewGestureHandlerFactory extends HandlerFactory<NativeViewGestureHandler> {
        private final Class<NativeViewGestureHandler> type = NativeViewGestureHandler.class;
        private final String name = "NativeViewGestureHandler";

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public Class<NativeViewGestureHandler> getType() {
            return this.type;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public String getName() {
            return this.name;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public NativeViewGestureHandler create(Context context) {
            return new NativeViewGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public void configure(NativeViewGestureHandler handler, ReadableMap config) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(config, "config");
            super.configure((NativeViewGestureHandlerFactory) handler, config);
            if (config.hasKey(RNGestureHandlerModule.KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START)) {
                handler.setShouldActivateOnStart(config.getBoolean(RNGestureHandlerModule.KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START));
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION)) {
                handler.setDisallowInterruption(config.getBoolean(RNGestureHandlerModule.KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION));
            }
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public NativeGestureHandlerEventDataBuilder createEventBuilder(NativeViewGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new NativeGestureHandlerEventDataBuilder(handler);
        }
    }

    /* compiled from: RNGestureHandlerModule.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$TapGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/core/TapGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "configure", "", "handler", "config", "Lcom/facebook/react/bridge/ReadableMap;", "create", "context", "Landroid/content/Context;", "createEventBuilder", "Lcom/swmansion/gesturehandler/react/eventbuilders/TapGestureHandlerEventDataBuilder;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class TapGestureHandlerFactory extends HandlerFactory<TapGestureHandler> {
        private final Class<TapGestureHandler> type = TapGestureHandler.class;
        private final String name = "TapGestureHandler";

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public Class<TapGestureHandler> getType() {
            return this.type;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public String getName() {
            return this.name;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public TapGestureHandler create(Context context) {
            return new TapGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public void configure(TapGestureHandler handler, ReadableMap config) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(config, "config");
            super.configure((TapGestureHandlerFactory) handler, config);
            if (config.hasKey(RNGestureHandlerModule.KEY_TAP_NUMBER_OF_TAPS)) {
                handler.setNumberOfTaps(config.getInt(RNGestureHandlerModule.KEY_TAP_NUMBER_OF_TAPS));
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DURATION_MS)) {
                handler.setMaxDurationMs(config.getInt(RNGestureHandlerModule.KEY_TAP_MAX_DURATION_MS));
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DELAY_MS)) {
                handler.setMaxDelayMs(config.getInt(RNGestureHandlerModule.KEY_TAP_MAX_DELAY_MS));
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_X)) {
                handler.setMaxDx(PixelUtil.toPixelFromDIP(config.getDouble(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_X)));
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_Y)) {
                handler.setMaxDy(PixelUtil.toPixelFromDIP(config.getDouble(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_Y)));
            }
            if (config.hasKey("maxDist")) {
                handler.setMaxDist(PixelUtil.toPixelFromDIP(config.getDouble("maxDist")));
            }
            if (config.hasKey("minPointers")) {
                handler.setMinNumberOfPointers(config.getInt("minPointers"));
            }
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public TapGestureHandlerEventDataBuilder createEventBuilder(TapGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new TapGestureHandlerEventDataBuilder(handler);
        }
    }

    /* compiled from: RNGestureHandlerModule.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$LongPressGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/core/LongPressGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "configure", "", "handler", "config", "Lcom/facebook/react/bridge/ReadableMap;", "create", "context", "Landroid/content/Context;", "createEventBuilder", "Lcom/swmansion/gesturehandler/react/eventbuilders/LongPressGestureHandlerEventDataBuilder;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class LongPressGestureHandlerFactory extends HandlerFactory<LongPressGestureHandler> {
        private final Class<LongPressGestureHandler> type = LongPressGestureHandler.class;
        private final String name = "LongPressGestureHandler";

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public Class<LongPressGestureHandler> getType() {
            return this.type;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public String getName() {
            return this.name;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public LongPressGestureHandler create(Context context) {
            Intrinsics.checkNotNull(context);
            return new LongPressGestureHandler(context);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public void configure(LongPressGestureHandler handler, ReadableMap config) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(config, "config");
            super.configure((LongPressGestureHandlerFactory) handler, config);
            if (config.hasKey(RNGestureHandlerModule.KEY_LONG_PRESS_MIN_DURATION_MS)) {
                handler.setMinDurationMs(config.getInt(RNGestureHandlerModule.KEY_LONG_PRESS_MIN_DURATION_MS));
            }
            if (config.hasKey("maxDist")) {
                handler.setMaxDist(PixelUtil.toPixelFromDIP(config.getDouble("maxDist")));
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS)) {
                handler.setNumberOfPointers(config.getInt(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS));
            }
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public LongPressGestureHandlerEventDataBuilder createEventBuilder(LongPressGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new LongPressGestureHandlerEventDataBuilder(handler);
        }
    }

    /* compiled from: RNGestureHandlerModule.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$PanGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/core/PanGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "configure", "", "handler", "config", "Lcom/facebook/react/bridge/ReadableMap;", "create", "context", "Landroid/content/Context;", "createEventBuilder", "Lcom/swmansion/gesturehandler/react/eventbuilders/PanGestureHandlerEventDataBuilder;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class PanGestureHandlerFactory extends HandlerFactory<PanGestureHandler> {
        private final Class<PanGestureHandler> type = PanGestureHandler.class;
        private final String name = "PanGestureHandler";

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public Class<PanGestureHandler> getType() {
            return this.type;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public String getName() {
            return this.name;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public PanGestureHandler create(Context context) {
            return new PanGestureHandler(context);
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public void configure(PanGestureHandler handler, ReadableMap config) {
            boolean z;
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(config, "config");
            super.configure((PanGestureHandlerFactory) handler, config);
            boolean z2 = true;
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_START)) {
                handler.setActiveOffsetXStart(PixelUtil.toPixelFromDIP(config.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_START)));
                z = true;
            } else {
                z = false;
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_END)) {
                handler.setActiveOffsetXEnd(PixelUtil.toPixelFromDIP(config.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_END)));
                z = true;
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_START)) {
                handler.setFailOffsetXStart(PixelUtil.toPixelFromDIP(config.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_START)));
                z = true;
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_END)) {
                handler.setFailOffsetXEnd(PixelUtil.toPixelFromDIP(config.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_END)));
                z = true;
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_START)) {
                handler.setActiveOffsetYStart(PixelUtil.toPixelFromDIP(config.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_START)));
                z = true;
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_END)) {
                handler.setActiveOffsetYEnd(PixelUtil.toPixelFromDIP(config.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_END)));
                z = true;
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_START)) {
                handler.setFailOffsetYStart(PixelUtil.toPixelFromDIP(config.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_START)));
                z = true;
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_END)) {
                handler.setFailOffsetYEnd(PixelUtil.toPixelFromDIP(config.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_END)));
                z = true;
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY)) {
                handler.setMinVelocity(PixelUtil.toPixelFromDIP(config.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY)));
                z = true;
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_X)) {
                handler.setMinVelocityX(PixelUtil.toPixelFromDIP(config.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_X)));
                z = true;
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_Y)) {
                handler.setMinVelocityY(PixelUtil.toPixelFromDIP(config.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_Y)));
            } else {
                z2 = z;
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_DIST)) {
                handler.setMinDist(PixelUtil.toPixelFromDIP(config.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_DIST)));
            } else if (z2) {
                handler.setMinDist(Float.MAX_VALUE);
            }
            if (config.hasKey("minPointers")) {
                handler.setMinPointers(config.getInt("minPointers"));
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_MAX_POINTERS)) {
                handler.setMaxPointers(config.getInt(RNGestureHandlerModule.KEY_PAN_MAX_POINTERS));
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_AVG_TOUCHES)) {
                handler.setAverageTouches(config.getBoolean(RNGestureHandlerModule.KEY_PAN_AVG_TOUCHES));
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVATE_AFTER_LONG_PRESS)) {
                handler.setActivateAfterLongPress(config.getInt(RNGestureHandlerModule.KEY_PAN_ACTIVATE_AFTER_LONG_PRESS));
            }
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public PanGestureHandlerEventDataBuilder createEventBuilder(PanGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new PanGestureHandlerEventDataBuilder(handler);
        }
    }

    /* compiled from: RNGestureHandlerModule.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$PinchGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/core/PinchGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "create", "context", "Landroid/content/Context;", "createEventBuilder", "Lcom/swmansion/gesturehandler/react/eventbuilders/PinchGestureHandlerEventDataBuilder;", "handler", "react-native-gesture-handler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class PinchGestureHandlerFactory extends HandlerFactory<PinchGestureHandler> {
        private final Class<PinchGestureHandler> type = PinchGestureHandler.class;
        private final String name = "PinchGestureHandler";

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public Class<PinchGestureHandler> getType() {
            return this.type;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public String getName() {
            return this.name;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public PinchGestureHandler create(Context context) {
            return new PinchGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public PinchGestureHandlerEventDataBuilder createEventBuilder(PinchGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new PinchGestureHandlerEventDataBuilder(handler);
        }
    }

    /* compiled from: RNGestureHandlerModule.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$FlingGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/core/FlingGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "configure", "", "handler", "config", "Lcom/facebook/react/bridge/ReadableMap;", "create", "context", "Landroid/content/Context;", "createEventBuilder", "Lcom/swmansion/gesturehandler/react/eventbuilders/FlingGestureHandlerEventDataBuilder;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class FlingGestureHandlerFactory extends HandlerFactory<FlingGestureHandler> {
        private final Class<FlingGestureHandler> type = FlingGestureHandler.class;
        private final String name = "FlingGestureHandler";

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public Class<FlingGestureHandler> getType() {
            return this.type;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public String getName() {
            return this.name;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public FlingGestureHandler create(Context context) {
            return new FlingGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public void configure(FlingGestureHandler handler, ReadableMap config) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(config, "config");
            super.configure((FlingGestureHandlerFactory) handler, config);
            if (config.hasKey(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS)) {
                handler.setNumberOfPointersRequired(config.getInt(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS));
            }
            if (config.hasKey(RNGestureHandlerModule.KEY_DIRECTION)) {
                handler.setDirection(config.getInt(RNGestureHandlerModule.KEY_DIRECTION));
            }
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public FlingGestureHandlerEventDataBuilder createEventBuilder(FlingGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new FlingGestureHandlerEventDataBuilder(handler);
        }
    }

    /* compiled from: RNGestureHandlerModule.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$RotationGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/core/RotationGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "create", "context", "Landroid/content/Context;", "createEventBuilder", "Lcom/swmansion/gesturehandler/react/eventbuilders/RotationGestureHandlerEventDataBuilder;", "handler", "react-native-gesture-handler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class RotationGestureHandlerFactory extends HandlerFactory<RotationGestureHandler> {
        private final Class<RotationGestureHandler> type = RotationGestureHandler.class;
        private final String name = "RotationGestureHandler";

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public Class<RotationGestureHandler> getType() {
            return this.type;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public String getName() {
            return this.name;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public RotationGestureHandler create(Context context) {
            return new RotationGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public RotationGestureHandlerEventDataBuilder createEventBuilder(RotationGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new RotationGestureHandlerEventDataBuilder(handler);
        }
    }

    /* compiled from: RNGestureHandlerModule.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$ManualGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/core/ManualGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "create", "context", "Landroid/content/Context;", "createEventBuilder", "Lcom/swmansion/gesturehandler/react/eventbuilders/ManualGestureHandlerEventDataBuilder;", "handler", "react-native-gesture-handler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class ManualGestureHandlerFactory extends HandlerFactory<ManualGestureHandler> {
        private final Class<ManualGestureHandler> type = ManualGestureHandler.class;
        private final String name = "ManualGestureHandler";

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public Class<ManualGestureHandler> getType() {
            return this.type;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public String getName() {
            return this.name;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public ManualGestureHandler create(Context context) {
            return new ManualGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public ManualGestureHandlerEventDataBuilder createEventBuilder(ManualGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new ManualGestureHandlerEventDataBuilder(handler);
        }
    }

    /* compiled from: RNGestureHandlerModule.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HoverGestureHandlerFactory;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$HandlerFactory;", "Lcom/swmansion/gesturehandler/core/HoverGestureHandler;", "()V", "name", "", "getName", "()Ljava/lang/String;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "create", "context", "Landroid/content/Context;", "createEventBuilder", "Lcom/swmansion/gesturehandler/react/eventbuilders/HoverGestureHandlerEventDataBuilder;", "handler", "react-native-gesture-handler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class HoverGestureHandlerFactory extends HandlerFactory<HoverGestureHandler> {
        private final Class<HoverGestureHandler> type = HoverGestureHandler.class;
        private final String name = "HoverGestureHandler";

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public Class<HoverGestureHandler> getType() {
            return this.type;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public String getName() {
            return this.name;
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public HoverGestureHandler create(Context context) {
            return new HoverGestureHandler();
        }

        @Override // com.swmansion.gesturehandler.react.RNGestureHandlerModule.HandlerFactory
        public HoverGestureHandlerEventDataBuilder createEventBuilder(HoverGestureHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            return new HoverGestureHandlerEventDataBuilder(handler);
        }
    }

    public final RNGestureHandlerRegistry getRegistry() {
        return this.registry;
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNGestureHandlerModule";
    }

    private final <T extends GestureHandler<T>> void createGestureHandlerHelper(String handlerName, int handlerTag, ReadableMap config) {
        if (this.registry.getHandler(handlerTag) != null) {
            throw new IllegalStateException("Handler with tag " + handlerTag + " already exists. Please ensure that no Gesture instance is used across multiple GestureDetectors.");
        }
        for (HandlerFactory<?> handlerFactory : this.handlerFactories) {
            if (Intrinsics.areEqual(handlerFactory.getName(), handlerName)) {
                GestureHandler<?> gestureHandlerCreate = handlerFactory.create(getReactApplicationContext());
                gestureHandlerCreate.setTag(handlerTag);
                gestureHandlerCreate.setOnTouchEventListener(this.eventListener);
                this.registry.registerHandler(gestureHandlerCreate);
                this.interactionManager.configureInteractions(gestureHandlerCreate, config);
                handlerFactory.configure(gestureHandlerCreate, config);
                return;
            }
        }
        throw new JSApplicationIllegalArgumentException("Invalid handler name " + handlerName);
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void createGestureHandler(String handlerName, double handlerTagDouble, ReadableMap config) {
        Intrinsics.checkNotNullParameter(handlerName, "handlerName");
        Intrinsics.checkNotNullParameter(config, "config");
        createGestureHandlerHelper(handlerName, (int) handlerTagDouble, config);
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void attachGestureHandler(double handlerTagDouble, double viewTagDouble, double actionTypeDouble) {
        int i = (int) handlerTagDouble;
        if (!this.registry.attachHandlerToView(i, (int) viewTagDouble, (int) actionTypeDouble)) {
            throw new JSApplicationIllegalArgumentException("Handler with tag " + i + " does not exists");
        }
    }

    private final <T extends GestureHandler<T>> void updateGestureHandlerHelper(int handlerTag, ReadableMap config) {
        HandlerFactory<T> handlerFactoryFindFactoryForHandler;
        GestureHandler<?> handler = this.registry.getHandler(handlerTag);
        if (handler == null || (handlerFactoryFindFactoryForHandler = findFactoryForHandler(handler)) == null) {
            return;
        }
        this.interactionManager.dropRelationsForHandlerWithTag(handlerTag);
        this.interactionManager.configureInteractions(handler, config);
        handlerFactoryFindFactoryForHandler.configure(handler, config);
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void updateGestureHandler(double handlerTagDouble, ReadableMap config) {
        Intrinsics.checkNotNullParameter(config, "config");
        updateGestureHandlerHelper((int) handlerTagDouble, config);
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void dropGestureHandler(double handlerTagDouble) {
        int i = (int) handlerTagDouble;
        this.interactionManager.dropRelationsForHandlerWithTag(i);
        this.registry.dropHandler(i);
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod
    public void handleSetJSResponder(double viewTagDouble, boolean blockNativeResponder) {
        int i = (int) viewTagDouble;
        RNGestureHandlerRootHelper rNGestureHandlerRootHelperFindRootHelperForViewAncestor = findRootHelperForViewAncestor(i);
        if (rNGestureHandlerRootHelperFindRootHelperForViewAncestor != null) {
            rNGestureHandlerRootHelperFindRootHelperForViewAncestor.handleSetJSResponder(i, blockNativeResponder);
        }
    }

    @Override // com.swmansion.common.GestureHandlerStateManager
    public void setGestureHandlerState(int handlerTag, int newState) {
        GestureHandler<?> handler = this.registry.getHandler(handlerTag);
        if (handler != null) {
            if (newState == 1) {
                handler.fail();
                return;
            }
            if (newState == 2) {
                handler.begin();
                return;
            }
            if (newState == 3) {
                handler.cancel();
            } else if (newState == 4) {
                handler.activate(true);
            } else {
                if (newState != 5) {
                    return;
                }
                handler.end();
            }
        }
    }

    @Override // com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec
    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean install() {
        getReactApplicationContext().runOnJSQueueThread(new Runnable() { // from class: com.swmansion.gesturehandler.react.RNGestureHandlerModule$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RNGestureHandlerModule.install$lambda$2(this.f$0);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void install$lambda$2(RNGestureHandlerModule this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            SoLoader.loadLibrary("gesturehandler");
            JavaScriptContextHolder javaScriptContextHolder = this$0.getReactApplicationContext().getJavaScriptContextHolder();
            Intrinsics.checkNotNull(javaScriptContextHolder);
            this$0.decorateRuntime(javaScriptContextHolder.get());
        } catch (Exception unused) {
            Log.w("[RNGestureHandler]", "Could not install JSI bindings.");
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        return MapsKt.mapOf(TuplesKt.to("State", MapsKt.mapOf(TuplesKt.to("UNDETERMINED", 0), TuplesKt.to("BEGAN", 2), TuplesKt.to("ACTIVE", 4), TuplesKt.to("CANCELLED", 3), TuplesKt.to("FAILED", 1), TuplesKt.to("END", 5))), TuplesKt.to("Direction", MapsKt.mapOf(TuplesKt.to("RIGHT", 1), TuplesKt.to("LEFT", 2), TuplesKt.to("UP", 4), TuplesKt.to("DOWN", 8))));
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        this.registry.dropAllHandlers();
        this.interactionManager.reset();
        synchronized (this.roots) {
            while (!this.roots.isEmpty()) {
                int size = this.roots.size();
                this.roots.get(0).tearDown();
                if (this.roots.size() >= size) {
                    throw new IllegalStateException("Expected root helper to get unregistered while tearing down");
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        super.invalidate();
    }

    public final void registerRootHelper(RNGestureHandlerRootHelper root) {
        Intrinsics.checkNotNullParameter(root, "root");
        synchronized (this.roots) {
            if (this.roots.contains(root)) {
                throw new IllegalStateException("Root helper" + root + " already registered");
            }
            this.roots.add(root);
        }
    }

    public final void unregisterRootHelper(RNGestureHandlerRootHelper root) {
        Intrinsics.checkNotNullParameter(root, "root");
        synchronized (this.roots) {
            this.roots.remove(root);
        }
    }

    private final RNGestureHandlerRootHelper findRootHelperForViewAncestor(int viewTag) {
        RNGestureHandlerRootHelper rNGestureHandlerRootHelper;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        int iResolveRootTagFromReactTag = ExtensionsKt.getUIManager(reactApplicationContext).resolveRootTagFromReactTag(viewTag);
        Object obj = null;
        if (iResolveRootTagFromReactTag < 1) {
            return null;
        }
        synchronized (this.roots) {
            Iterator<T> it = this.roots.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                RNGestureHandlerRootHelper rNGestureHandlerRootHelper2 = (RNGestureHandlerRootHelper) next;
                if ((rNGestureHandlerRootHelper2.getRootView() instanceof ReactRootView) && ((ReactRootView) rNGestureHandlerRootHelper2.getRootView()).getRootViewTag() == iResolveRootTagFromReactTag) {
                    obj = next;
                    break;
                }
            }
            rNGestureHandlerRootHelper = (RNGestureHandlerRootHelper) obj;
        }
        return rNGestureHandlerRootHelper;
    }

    private final <T extends GestureHandler<T>> HandlerFactory<T> findFactoryForHandler(GestureHandler<T> handler) {
        for (Object obj : this.handlerFactories) {
            HandlerFactory<T> handlerFactory = (HandlerFactory<T>) obj;
            if (Intrinsics.areEqual(handlerFactory.getType(), handler.getClass())) {
                return handlerFactory;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends GestureHandler<T>> void onHandlerUpdate(T handler) {
        HandlerFactory<T> handlerFactoryFindFactoryForHandler;
        if (handler.getTag() >= 0 && handler.getState() == 4 && (handlerFactoryFindFactoryForHandler = findFactoryForHandler(handler)) != null) {
            if (handler.getActionType() == 1) {
                sendEventForReanimated(RNGestureHandlerEvent.Companion.obtain$default(RNGestureHandlerEvent.INSTANCE, handler, handlerFactoryFindFactoryForHandler.createEventBuilder(handler), false, 4, null));
                return;
            }
            if (handler.getActionType() == 2) {
                sendEventForNativeAnimatedEvent(RNGestureHandlerEvent.INSTANCE.obtain(handler, handlerFactoryFindFactoryForHandler.createEventBuilder(handler), true));
            } else if (handler.getActionType() == 3) {
                sendEventForDirectEvent(RNGestureHandlerEvent.Companion.obtain$default(RNGestureHandlerEvent.INSTANCE, handler, handlerFactoryFindFactoryForHandler.createEventBuilder(handler), false, 4, null));
            } else if (handler.getActionType() == 4) {
                sendEventForDeviceEvent("onGestureHandlerEvent", RNGestureHandlerEvent.INSTANCE.createEventData(handlerFactoryFindFactoryForHandler.createEventBuilder(handler)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends GestureHandler<T>> void onStateChange(T handler, int newState, int oldState) {
        HandlerFactory<T> handlerFactoryFindFactoryForHandler;
        if (handler.getTag() >= 0 && (handlerFactoryFindFactoryForHandler = findFactoryForHandler(handler)) != null) {
            if (handler.getActionType() == 1) {
                sendEventForReanimated(RNGestureHandlerStateChangeEvent.INSTANCE.obtain(handler, newState, oldState, handlerFactoryFindFactoryForHandler.createEventBuilder(handler)));
                return;
            }
            if (handler.getActionType() == 2 || handler.getActionType() == 3) {
                sendEventForDirectEvent(RNGestureHandlerStateChangeEvent.INSTANCE.obtain(handler, newState, oldState, handlerFactoryFindFactoryForHandler.createEventBuilder(handler)));
            } else if (handler.getActionType() == 4) {
                sendEventForDeviceEvent(RNGestureHandlerStateChangeEvent.EVENT_NAME, RNGestureHandlerStateChangeEvent.INSTANCE.createEventData(handlerFactoryFindFactoryForHandler.createEventBuilder(handler), newState, oldState));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends GestureHandler<T>> void onTouchEvent(T handler) {
        if (handler.getTag() < 0) {
            return;
        }
        if (handler.getState() == 2 || handler.getState() == 4 || handler.getState() == 0 || handler.getView() != null) {
            if (handler.getActionType() == 1) {
                sendEventForReanimated(RNGestureHandlerTouchEvent.INSTANCE.obtain(handler));
            } else if (handler.getActionType() == 4) {
                sendEventForDeviceEvent("onGestureHandlerEvent", RNGestureHandlerTouchEvent.INSTANCE.createEventData(handler));
            }
        }
    }

    private final <T extends Event<T>> void sendEventForReanimated(T event) {
        sendEventForDirectEvent(event);
    }

    private final void sendEventForNativeAnimatedEvent(RNGestureHandlerEvent event) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        ReactContextExtensionsKt.dispatchEvent(reactApplicationContext, event);
    }

    private final <T extends Event<T>> void sendEventForDirectEvent(T event) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        ReactContextExtensionsKt.dispatchEvent(reactApplicationContext, event);
    }

    private final void sendEventForDeviceEvent(String eventName, WritableMap data) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        ExtensionsKt.getDeviceEventEmitter(reactApplicationContext).emit(eventName, data);
    }

    /* compiled from: RNGestureHandlerModule.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b+\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010/\u001a\u0002002\n\u00101\u001a\u0006\u0012\u0002\b\u0003022\u0006\u00103\u001a\u000204H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerModule$Companion;", "", "()V", "KEY_DIRECTION", "", "KEY_ENABLED", "KEY_HIT_SLOP", "KEY_HIT_SLOP_BOTTOM", "KEY_HIT_SLOP_HEIGHT", "KEY_HIT_SLOP_HORIZONTAL", "KEY_HIT_SLOP_LEFT", "KEY_HIT_SLOP_RIGHT", "KEY_HIT_SLOP_TOP", "KEY_HIT_SLOP_VERTICAL", "KEY_HIT_SLOP_WIDTH", "KEY_LONG_PRESS_MAX_DIST", "KEY_LONG_PRESS_MIN_DURATION_MS", "KEY_MANUAL_ACTIVATION", "KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION", "KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START", "KEY_NEEDS_POINTER_DATA", "KEY_NUMBER_OF_POINTERS", "KEY_PAN_ACTIVATE_AFTER_LONG_PRESS", "KEY_PAN_ACTIVE_OFFSET_X_END", "KEY_PAN_ACTIVE_OFFSET_X_START", "KEY_PAN_ACTIVE_OFFSET_Y_END", "KEY_PAN_ACTIVE_OFFSET_Y_START", "KEY_PAN_AVG_TOUCHES", "KEY_PAN_FAIL_OFFSET_RANGE_X_END", "KEY_PAN_FAIL_OFFSET_RANGE_X_START", "KEY_PAN_FAIL_OFFSET_RANGE_Y_END", "KEY_PAN_FAIL_OFFSET_RANGE_Y_START", "KEY_PAN_MAX_POINTERS", "KEY_PAN_MIN_DIST", "KEY_PAN_MIN_POINTERS", "KEY_PAN_MIN_VELOCITY", "KEY_PAN_MIN_VELOCITY_X", "KEY_PAN_MIN_VELOCITY_Y", "KEY_SHOULD_CANCEL_WHEN_OUTSIDE", "KEY_TAP_MAX_DELAY_MS", "KEY_TAP_MAX_DELTA_X", "KEY_TAP_MAX_DELTA_Y", "KEY_TAP_MAX_DIST", "KEY_TAP_MAX_DURATION_MS", "KEY_TAP_MIN_POINTERS", "KEY_TAP_NUMBER_OF_TAPS", "NAME", "handleHitSlopProperty", "", "handler", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "config", "Lcom/facebook/react/bridge/ReadableMap;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void handleHitSlopProperty(GestureHandler<?> handler, ReadableMap config) {
            if (config.getType(RNGestureHandlerModule.KEY_HIT_SLOP) == ReadableType.Number) {
                float pixelFromDIP = PixelUtil.toPixelFromDIP(config.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP));
                handler.setHitSlop(pixelFromDIP, pixelFromDIP, pixelFromDIP, pixelFromDIP, Float.NaN, Float.NaN);
                return;
            }
            ReadableMap map = config.getMap(RNGestureHandlerModule.KEY_HIT_SLOP);
            Intrinsics.checkNotNull(map);
            float pixelFromDIP2 = map.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_HORIZONTAL) ? PixelUtil.toPixelFromDIP(map.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_HORIZONTAL)) : Float.NaN;
            float pixelFromDIP3 = pixelFromDIP2;
            float pixelFromDIP4 = map.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_VERTICAL) ? PixelUtil.toPixelFromDIP(map.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_VERTICAL)) : Float.NaN;
            float pixelFromDIP5 = pixelFromDIP4;
            if (map.hasKey("left")) {
                pixelFromDIP2 = PixelUtil.toPixelFromDIP(map.getDouble("left"));
            }
            float f = pixelFromDIP2;
            if (map.hasKey("top")) {
                pixelFromDIP4 = PixelUtil.toPixelFromDIP(map.getDouble("top"));
            }
            float f2 = pixelFromDIP4;
            if (map.hasKey("right")) {
                pixelFromDIP3 = PixelUtil.toPixelFromDIP(map.getDouble("right"));
            }
            float f3 = pixelFromDIP3;
            if (map.hasKey("bottom")) {
                pixelFromDIP5 = PixelUtil.toPixelFromDIP(map.getDouble("bottom"));
            }
            handler.setHitSlop(f, f2, f3, pixelFromDIP5, map.hasKey("width") ? PixelUtil.toPixelFromDIP(map.getDouble("width")) : Float.NaN, map.hasKey("height") ? PixelUtil.toPixelFromDIP(map.getDouble("height")) : Float.NaN);
        }
    }
}
