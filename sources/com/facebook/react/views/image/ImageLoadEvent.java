package com.facebook.react.views.image;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.share.internal.ShareConstants;
import com.horcrux.svg.events.SvgLoadEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageLoadEvent.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0002\b\u0005\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0014\u0015B_\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0013\u001a\u00020\u0007H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/react/views/image/ImageLoadEvent;", "Lcom/facebook/react/uimanager/events/Event;", "surfaceId", "", "viewId", "eventType", "errorMessage", "", "sourceUri", "width", "height", "loaded", "total", "(IIILjava/lang/String;Ljava/lang/String;IIII)V", "createEventDataSource", "Lcom/facebook/react/bridge/WritableMap;", "getCoalescingKey", "", "getEventData", "getEventName", "Companion", "ImageEventType", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ImageLoadEvent extends Event<ImageLoadEvent> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int ON_ERROR = 1;
    public static final int ON_LOAD = 2;
    public static final int ON_LOAD_END = 3;
    public static final int ON_LOAD_START = 4;
    public static final int ON_PROGRESS = 5;
    private final String errorMessage;
    private final int eventType;
    private final int height;
    private final int loaded;
    private final String sourceUri;
    private final int total;
    private final int width;

    /* compiled from: ImageLoadEvent.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/facebook/react/views/image/ImageLoadEvent$ImageEventType;", "", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ImageEventType {
    }

    public /* synthetic */ ImageLoadEvent(int i, int i2, int i3, String str, String str2, int i4, int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, str, str2, i4, i5, i6, i7);
    }

    @JvmStatic
    public static final ImageLoadEvent createErrorEvent(int i, int i2, Throwable th) {
        return INSTANCE.createErrorEvent(i, i2, th);
    }

    @Deprecated(message = "Use the createErrorEvent version that explicitly takes surfaceId as an argument", replaceWith = @ReplaceWith(expression = "createErrorEvent(surfaceId, viewId, throwable)", imports = {}))
    @JvmStatic
    public static final ImageLoadEvent createErrorEvent(int i, Throwable th) {
        return INSTANCE.createErrorEvent(i, th);
    }

    @Deprecated(message = "Use the createLoadEndEvent version that explicitly takes surfaceId as an argument", replaceWith = @ReplaceWith(expression = "createLoadEndEvent(surfaceId, viewId)", imports = {}))
    @JvmStatic
    public static final ImageLoadEvent createLoadEndEvent(int i) {
        return INSTANCE.createLoadEndEvent(i);
    }

    @JvmStatic
    public static final ImageLoadEvent createLoadEndEvent(int i, int i2) {
        return INSTANCE.createLoadEndEvent(i, i2);
    }

    @JvmStatic
    public static final ImageLoadEvent createLoadEvent(int i, int i2, String str, int i3, int i4) {
        return INSTANCE.createLoadEvent(i, i2, str, i3, i4);
    }

    @Deprecated(message = "Use the createLoadEvent version that explicitly takes surfaceId as an argument", replaceWith = @ReplaceWith(expression = "createLoadEvent(surfaceId, viewId, imageUri, width, height)", imports = {}))
    @JvmStatic
    public static final ImageLoadEvent createLoadEvent(int i, String str, int i2, int i3) {
        return INSTANCE.createLoadEvent(i, str, i2, i3);
    }

    @Deprecated(message = "Use the createLoadStartEvent version that explicitly takes surfaceId as an argument", replaceWith = @ReplaceWith(expression = "createLoadStartEvent(surfaceId, viewId)", imports = {}))
    @JvmStatic
    public static final ImageLoadEvent createLoadStartEvent(int i) {
        return INSTANCE.createLoadStartEvent(i);
    }

    @JvmStatic
    public static final ImageLoadEvent createLoadStartEvent(int i, int i2) {
        return INSTANCE.createLoadStartEvent(i, i2);
    }

    @JvmStatic
    public static final ImageLoadEvent createProgressEvent(int i, int i2, String str, int i3, int i4) {
        return INSTANCE.createProgressEvent(i, i2, str, i3, i4);
    }

    @Deprecated(message = "Use the createProgressEvent version that explicitly takes surfaceId as an argument", replaceWith = @ReplaceWith(expression = "createProgressEvent(surfaceId, viewId, imageUri, loaded, total)", imports = {}))
    @JvmStatic
    public static final ImageLoadEvent createProgressEvent(int i, String str, int i2, int i3) {
        return INSTANCE.createProgressEvent(i, str, i2, i3);
    }

    @JvmStatic
    public static final String eventNameForType(int i) {
        return INSTANCE.eventNameForType(i);
    }

    /* synthetic */ ImageLoadEvent(int i, int i2, int i3, String str, String str2, int i4, int i5, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, (i8 & 8) != 0 ? null : str, (i8 & 16) != 0 ? null : str2, (i8 & 32) != 0 ? 0 : i4, (i8 & 64) != 0 ? 0 : i5, (i8 & 128) != 0 ? 0 : i6, (i8 & 256) != 0 ? 0 : i7);
    }

    private ImageLoadEvent(int i, int i2, int i3, String str, String str2, int i4, int i5, int i6, int i7) {
        super(i, i2);
        this.eventType = i3;
        this.errorMessage = str;
        this.sourceUri = str2;
        this.width = i4;
        this.height = i5;
        this.loaded = i6;
        this.total = i7;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return INSTANCE.eventNameForType(this.eventType);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return (short) this.eventType;
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* renamed from: getEventData */
    protected WritableMap getData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        int i = this.eventType;
        if (i == 1) {
            writableMapCreateMap.putString("error", this.errorMessage);
        } else if (i == 2) {
            writableMapCreateMap.putMap("source", createEventDataSource());
        } else if (i == 5) {
            writableMapCreateMap.putInt("loaded", this.loaded);
            writableMapCreateMap.putInt("total", this.total);
            writableMapCreateMap.putDouble("progress", this.loaded / this.total);
        }
        return writableMapCreateMap;
    }

    private final WritableMap createEventDataSource() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(ShareConstants.MEDIA_URI, this.sourceUri);
        writableMapCreateMap.putDouble("width", this.width);
        writableMapCreateMap.putDouble("height", this.height);
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "apply(...)");
        return writableMapCreateMap;
    }

    /* compiled from: ImageLoadEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0007J2\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J*\u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0007J2\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0007J*\u0010\u0016\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0007J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/facebook/react/views/image/ImageLoadEvent$Companion;", "", "()V", "ON_ERROR", "", "ON_LOAD", "ON_LOAD_END", "ON_LOAD_START", "ON_PROGRESS", "createErrorEvent", "Lcom/facebook/react/views/image/ImageLoadEvent;", "surfaceId", "viewId", "throwable", "", "createLoadEndEvent", "createLoadEvent", "imageUri", "", "width", "height", "createLoadStartEvent", "createProgressEvent", "loaded", "total", "eventNameForType", "eventType", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Deprecated(message = "Use the createLoadStartEvent version that explicitly takes surfaceId as an argument", replaceWith = @ReplaceWith(expression = "createLoadStartEvent(surfaceId, viewId)", imports = {}))
        @JvmStatic
        public final ImageLoadEvent createLoadStartEvent(int viewId) {
            return createLoadStartEvent(-1, viewId);
        }

        @Deprecated(message = "Use the createProgressEvent version that explicitly takes surfaceId as an argument", replaceWith = @ReplaceWith(expression = "createProgressEvent(surfaceId, viewId, imageUri, loaded, total)", imports = {}))
        @JvmStatic
        public final ImageLoadEvent createProgressEvent(int viewId, String imageUri, int loaded, int total) {
            return createProgressEvent(-1, viewId, imageUri, loaded, total);
        }

        @Deprecated(message = "Use the createLoadEvent version that explicitly takes surfaceId as an argument", replaceWith = @ReplaceWith(expression = "createLoadEvent(surfaceId, viewId, imageUri, width, height)", imports = {}))
        @JvmStatic
        public final ImageLoadEvent createLoadEvent(int viewId, String imageUri, int width, int height) {
            return createLoadEvent(-1, viewId, imageUri, width, height);
        }

        @Deprecated(message = "Use the createErrorEvent version that explicitly takes surfaceId as an argument", replaceWith = @ReplaceWith(expression = "createErrorEvent(surfaceId, viewId, throwable)", imports = {}))
        @JvmStatic
        public final ImageLoadEvent createErrorEvent(int viewId, Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            return createErrorEvent(-1, viewId, throwable);
        }

        @Deprecated(message = "Use the createLoadEndEvent version that explicitly takes surfaceId as an argument", replaceWith = @ReplaceWith(expression = "createLoadEndEvent(surfaceId, viewId)", imports = {}))
        @JvmStatic
        public final ImageLoadEvent createLoadEndEvent(int viewId) {
            return createLoadEndEvent(-1, viewId);
        }

        @JvmStatic
        public final ImageLoadEvent createLoadStartEvent(int surfaceId, int viewId) {
            return new ImageLoadEvent(surfaceId, viewId, 4, null, null, 0, 0, 0, 0, 504, null);
        }

        @JvmStatic
        public final ImageLoadEvent createProgressEvent(int surfaceId, int viewId, String imageUri, int loaded, int total) {
            return new ImageLoadEvent(surfaceId, viewId, 5, null, imageUri, 0, 0, loaded, total, null);
        }

        @JvmStatic
        public final ImageLoadEvent createLoadEvent(int surfaceId, int viewId, String imageUri, int width, int height) {
            return new ImageLoadEvent(surfaceId, viewId, 2, null, imageUri, width, height, 0, 0, null);
        }

        @JvmStatic
        public final ImageLoadEvent createErrorEvent(int surfaceId, int viewId, Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            return new ImageLoadEvent(surfaceId, viewId, 1, throwable.getMessage(), null, 0, 0, 0, 0, null);
        }

        @JvmStatic
        public final ImageLoadEvent createLoadEndEvent(int surfaceId, int viewId) {
            return new ImageLoadEvent(surfaceId, viewId, 3, null, null, 0, 0, 0, 0, 504, null);
        }

        @JvmStatic
        public final String eventNameForType(int eventType) {
            if (eventType == 1) {
                return "topError";
            }
            if (eventType == 2) {
                return SvgLoadEvent.EVENT_NAME;
            }
            if (eventType == 3) {
                return "topLoadEnd";
            }
            if (eventType == 4) {
                return "topLoadStart";
            }
            if (eventType == 5) {
                return "topProgress";
            }
            throw new IllegalStateException(("Invalid image event: " + eventType).toString());
        }
    }
}
