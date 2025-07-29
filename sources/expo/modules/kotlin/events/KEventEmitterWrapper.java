package expo.modules.kotlin.events;

import android.os.Bundle;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import expo.modules.core.interfaces.services.EventEmitter;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.JSTypeConverter;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KModuleEventEmitterWrapper.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002:\u0001 B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J1\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010\u0016J!\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001aH\u0096\u0001J1\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010\u001cJ1\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010\u0010\u001a\n \u001b*\u0004\u0018\u00010\u00110\u00112\u000e\u0010\u0012\u001a\n \u001b*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u001eH\u0016J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0010\u0010\u0012\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u001fH\u0016J)\u0010\f\u001a\u00020\r2\u000e\u0010\u0010\u001a\n \u001b*\u0004\u0018\u00010\u00110\u00112\u000e\u0010\u0012\u001a\n \u001b*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lexpo/modules/kotlin/events/KEventEmitterWrapper;", "Lexpo/modules/kotlin/events/EventEmitter;", "Lexpo/modules/core/interfaces/services/EventEmitter;", "legacyEventEmitter", "reactContextHolder", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lexpo/modules/core/interfaces/services/EventEmitter;Ljava/lang/ref/WeakReference;)V", "deviceEventEmitter", "Lcom/facebook/react/modules/core/DeviceEventManagerModule$RCTDeviceEventEmitter;", "getDeviceEventEmitter", "()Lcom/facebook/react/modules/core/DeviceEventManagerModule$RCTDeviceEventEmitter;", "emit", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "eventName", "", "eventBody", "Lcom/facebook/react/bridge/WritableMap;", "coalescingKey", "", "(Landroid/view/View;Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;Ljava/lang/Short;)V", "viewId", "", NotificationCompat.CATEGORY_EVENT, "Lexpo/modules/core/interfaces/services/EventEmitter$Event;", "kotlin.jvm.PlatformType", "(ILjava/lang/String;Lcom/facebook/react/bridge/WritableMap;Ljava/lang/Short;)V", "Landroid/os/Bundle;", "Lexpo/modules/kotlin/records/Record;", "", "UIEvent", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class KEventEmitterWrapper implements EventEmitter, expo.modules.core.interfaces.services.EventEmitter {
    public static final int $stable = 8;
    private final expo.modules.core.interfaces.services.EventEmitter legacyEventEmitter;
    private final WeakReference<ReactApplicationContext> reactContextHolder;

    @Override // expo.modules.core.interfaces.services.EventEmitter
    public void emit(int viewId, EventEmitter.Event event) {
        this.legacyEventEmitter.emit(viewId, event);
    }

    @Override // expo.modules.core.interfaces.services.EventEmitter
    public void emit(int viewId, String eventName, Bundle eventBody) {
        this.legacyEventEmitter.emit(viewId, eventName, eventBody);
    }

    @Override // expo.modules.core.interfaces.services.EventEmitter
    public void emit(String eventName, Bundle eventBody) {
        this.legacyEventEmitter.emit(eventName, eventBody);
    }

    public KEventEmitterWrapper(expo.modules.core.interfaces.services.EventEmitter legacyEventEmitter, WeakReference<ReactApplicationContext> reactContextHolder) {
        Intrinsics.checkNotNullParameter(legacyEventEmitter, "legacyEventEmitter");
        Intrinsics.checkNotNullParameter(reactContextHolder, "reactContextHolder");
        this.legacyEventEmitter = legacyEventEmitter;
        this.reactContextHolder = reactContextHolder;
    }

    private final DeviceEventManagerModule.RCTDeviceEventEmitter getDeviceEventEmitter() {
        ReactApplicationContext reactApplicationContext = this.reactContextHolder.get();
        if (reactApplicationContext != null) {
            return (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        }
        return null;
    }

    @Override // expo.modules.kotlin.events.EventEmitter
    public void emit(String eventName, WritableMap eventBody) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        DeviceEventManagerModule.RCTDeviceEventEmitter deviceEventEmitter = getDeviceEventEmitter();
        if (deviceEventEmitter != null) {
            deviceEventEmitter.emit(eventName, eventBody);
        }
    }

    @Override // expo.modules.kotlin.events.EventEmitter
    public void emit(String eventName, Record eventBody) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        DeviceEventManagerModule.RCTDeviceEventEmitter deviceEventEmitter = getDeviceEventEmitter();
        if (deviceEventEmitter != null) {
            deviceEventEmitter.emit(eventName, JSTypeConverter.legacyConvertToJSValue$default(JSTypeConverter.INSTANCE, eventBody, null, 2, null));
        }
    }

    @Override // expo.modules.kotlin.events.EventEmitter
    public void emit(String eventName, Map<?, ?> eventBody) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        DeviceEventManagerModule.RCTDeviceEventEmitter deviceEventEmitter = getDeviceEventEmitter();
        if (deviceEventEmitter != null) {
            deviceEventEmitter.emit(eventName, JSTypeConverter.legacyConvertToJSValue$default(JSTypeConverter.INSTANCE, eventBody, null, 2, null));
        }
    }

    @Override // expo.modules.kotlin.events.EventEmitter
    public void emit(int viewId, String eventName, WritableMap eventBody, Short coalescingKey) {
        EventDispatcher eventDispatcherForReactTag;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        ReactApplicationContext reactApplicationContext = this.reactContextHolder.get();
        if (reactApplicationContext == null || (eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactApplicationContext, viewId)) == null) {
            return;
        }
        eventDispatcherForReactTag.dispatchEvent(new UIEvent(-1, viewId, eventName, eventBody, coalescingKey));
    }

    @Override // expo.modules.kotlin.events.EventEmitter
    public void emit(View view, String eventName, WritableMap eventBody, Short coalescingKey) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        ReactApplicationContext reactApplicationContext = this.reactContextHolder.get();
        if (reactApplicationContext == null) {
            return;
        }
        int surfaceId = UIManagerHelper.getSurfaceId(view);
        int id = view.getId();
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactApplicationContext, view.getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new UIEvent(surfaceId, id, eventName, eventBody, coalescingKey));
        }
    }

    /* compiled from: KModuleEventEmitterWrapper.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0014J\b\u0010\u0011\u001a\u00020\u0006H\u0016R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/modules/kotlin/events/KEventEmitterWrapper$UIEvent;", "Lcom/facebook/react/uimanager/events/Event;", "surfaceId", "", "viewId", "eventName", "", "eventBody", "Lcom/facebook/react/bridge/WritableMap;", "coalescingKey", "", "(IILjava/lang/String;Lcom/facebook/react/bridge/WritableMap;Ljava/lang/Short;)V", "Ljava/lang/Short;", "canCoalesce", "", "getCoalescingKey", "getEventData", "getEventName", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class UIEvent extends Event<UIEvent> {
        private final Short coalescingKey;
        private final WritableMap eventBody;
        private final String eventName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UIEvent(int i, int i2, String eventName, WritableMap writableMap, Short sh) {
            super(i, i2);
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            this.eventName = eventName;
            this.eventBody = writableMap;
            this.coalescingKey = sh;
        }

        @Override // com.facebook.react.uimanager.events.Event
        public String getEventName() {
            return KModuleEventEmitterWrapperKt.normalizeEventName(this.eventName);
        }

        @Override // com.facebook.react.uimanager.events.Event
        public boolean canCoalesce() {
            return this.coalescingKey != null;
        }

        @Override // com.facebook.react.uimanager.events.Event
        public short getCoalescingKey() {
            Short sh = this.coalescingKey;
            if (sh != null) {
                return sh.shortValue();
            }
            return (short) 0;
        }

        @Override // com.facebook.react.uimanager.events.Event
        /* renamed from: getEventData */
        protected WritableMap getData() {
            WritableMap writableMap = this.eventBody;
            if (writableMap != null) {
                return writableMap;
            }
            WritableMap writableMapCreateMap = Arguments.createMap();
            Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
            return writableMapCreateMap;
        }
    }
}
