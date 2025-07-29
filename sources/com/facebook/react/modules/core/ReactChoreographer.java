package com.facebook.react.modules.core;

import android.view.Choreographer;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.internal.ChoreographerProvider;
import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReactChoreographer.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bJ\b\u0010\u0018\u001a\u00020\u0013H\u0002J\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\r\u001a\u0004\u0018\u00010\bR\u001c\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\b\fR\u000e\u0010\r\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/facebook/react/modules/core/ReactChoreographer;", "", "choreographerProvider", "Lcom/facebook/react/internal/ChoreographerProvider;", "(Lcom/facebook/react/internal/ChoreographerProvider;)V", "callbackQueues", "", "Ljava/util/ArrayDeque;", "Landroid/view/Choreographer$FrameCallback;", "[Ljava/util/ArrayDeque;", "choreographer", "Lcom/facebook/react/internal/ChoreographerProvider$Choreographer;", "choreographer$1", "frameCallback", "hasPostedCallback", "", "totalCallbacks", "", "maybeRemoveFrameCallback", "", "postFrameCallback", "type", "Lcom/facebook/react/modules/core/ReactChoreographer$CallbackType;", "callback", "postFrameCallbackOnChoreographer", "removeFrameCallback", "CallbackType", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ReactChoreographer {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static ReactChoreographer choreographer;
    private final ArrayDeque<Choreographer.FrameCallback>[] callbackQueues;

    /* renamed from: choreographer$1, reason: from kotlin metadata */
    private ChoreographerProvider.Choreographer choreographer;
    private final Choreographer.FrameCallback frameCallback;
    private boolean hasPostedCallback;
    private int totalCallbacks;

    public /* synthetic */ ReactChoreographer(ChoreographerProvider choreographerProvider, DefaultConstructorMarker defaultConstructorMarker) {
        this(choreographerProvider);
    }

    @JvmStatic
    public static final ReactChoreographer getInstance() {
        return INSTANCE.getInstance();
    }

    @JvmStatic
    public static final void initialize(ChoreographerProvider choreographerProvider) {
        INSTANCE.initialize(choreographerProvider);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: ReactChoreographer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/facebook/react/modules/core/ReactChoreographer$CallbackType;", "", "order", "", "(Ljava/lang/String;II)V", "getOrder$ReactAndroid_release", "()I", "PERF_MARKERS", "DISPATCH_UI", "NATIVE_ANIMATED_MODULE", "TIMERS_EVENTS", "IDLE_EVENT", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CallbackType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CallbackType[] $VALUES;
        private final int order;
        public static final CallbackType PERF_MARKERS = new CallbackType("PERF_MARKERS", 0, 0);
        public static final CallbackType DISPATCH_UI = new CallbackType("DISPATCH_UI", 1, 1);
        public static final CallbackType NATIVE_ANIMATED_MODULE = new CallbackType("NATIVE_ANIMATED_MODULE", 2, 2);
        public static final CallbackType TIMERS_EVENTS = new CallbackType("TIMERS_EVENTS", 3, 3);
        public static final CallbackType IDLE_EVENT = new CallbackType("IDLE_EVENT", 4, 4);

        private static final /* synthetic */ CallbackType[] $values() {
            return new CallbackType[]{PERF_MARKERS, DISPATCH_UI, NATIVE_ANIMATED_MODULE, TIMERS_EVENTS, IDLE_EVENT};
        }

        public static EnumEntries<CallbackType> getEntries() {
            return $ENTRIES;
        }

        public static CallbackType valueOf(String str) {
            return (CallbackType) Enum.valueOf(CallbackType.class, str);
        }

        public static CallbackType[] values() {
            return (CallbackType[]) $VALUES.clone();
        }

        private CallbackType(String str, int i, int i2) {
            this.order = i2;
        }

        /* renamed from: getOrder$ReactAndroid_release, reason: from getter */
        public final int getOrder() {
            return this.order;
        }

        static {
            CallbackType[] callbackTypeArr$values = $values();
            $VALUES = callbackTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(callbackTypeArr$values);
        }
    }

    private ReactChoreographer(final ChoreographerProvider choreographerProvider) {
        int size = CallbackType.getEntries().size();
        ArrayDeque<Choreographer.FrameCallback>[] arrayDequeArr = new ArrayDeque[size];
        for (int i = 0; i < size; i++) {
            arrayDequeArr[i] = new ArrayDeque<>();
        }
        this.callbackQueues = arrayDequeArr;
        this.frameCallback = new Choreographer.FrameCallback() { // from class: com.facebook.react.modules.core.ReactChoreographer$$ExternalSyntheticLambda0
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                ReactChoreographer.frameCallback$lambda$1(this.f$0, j);
            }
        };
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.modules.core.ReactChoreographer$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ReactChoreographer._init_$lambda$2(this.f$0, choreographerProvider);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void frameCallback$lambda$1(ReactChoreographer this$0, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        synchronized (this$0.callbackQueues) {
            this$0.hasPostedCallback = false;
            int length = this$0.callbackQueues.length;
            for (int i = 0; i < length; i++) {
                ArrayDeque<Choreographer.FrameCallback> arrayDeque = this$0.callbackQueues[i];
                int size = arrayDeque.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Choreographer.FrameCallback frameCallbackPollFirst = arrayDeque.pollFirst();
                    if (frameCallbackPollFirst != null) {
                        frameCallbackPollFirst.doFrame(j);
                        this$0.totalCallbacks--;
                    } else {
                        FLog.e("ReactNative", "Tried to execute non-existent frame callback");
                    }
                }
            }
            this$0.maybeRemoveFrameCallback();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(ReactChoreographer this$0, ChoreographerProvider choreographerProvider) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(choreographerProvider, "$choreographerProvider");
        this$0.choreographer = choreographerProvider.getChoreographer();
    }

    public final void postFrameCallback(CallbackType type, Choreographer.FrameCallback callback) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (this.callbackQueues) {
            this.callbackQueues[type.getOrder()].addLast(callback);
            boolean z = true;
            int i = this.totalCallbacks + 1;
            this.totalCallbacks = i;
            if (i <= 0) {
                z = false;
            }
            Assertions.assertCondition(z);
            postFrameCallbackOnChoreographer();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void removeFrameCallback(CallbackType type, Choreographer.FrameCallback frameCallback) {
        Intrinsics.checkNotNullParameter(type, "type");
        synchronized (this.callbackQueues) {
            if (this.callbackQueues[type.getOrder()].removeFirstOccurrence(frameCallback)) {
                this.totalCallbacks--;
                maybeRemoveFrameCallback();
            } else {
                FLog.e("ReactNative", "Tried to remove non-existent frame callback");
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void postFrameCallbackOnChoreographer() {
        if (this.hasPostedCallback) {
            return;
        }
        ChoreographerProvider.Choreographer choreographer2 = this.choreographer;
        if (choreographer2 == null) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.modules.core.ReactChoreographer$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ReactChoreographer.postFrameCallbackOnChoreographer$lambda$6(this.f$0);
                }
            });
        } else {
            choreographer2.postFrameCallback(this.frameCallback);
            this.hasPostedCallback = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postFrameCallbackOnChoreographer$lambda$6(ReactChoreographer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        synchronized (this$0.callbackQueues) {
            this$0.postFrameCallbackOnChoreographer();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void maybeRemoveFrameCallback() {
        Assertions.assertCondition(this.totalCallbacks >= 0);
        if (this.totalCallbacks == 0 && this.hasPostedCallback) {
            ChoreographerProvider.Choreographer choreographer2 = this.choreographer;
            if (choreographer2 != null) {
                choreographer2.removeFrameCallback(this.frameCallback);
            }
            this.hasPostedCallback = false;
        }
    }

    /* compiled from: ReactChoreographer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0019\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0002\b\fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/facebook/react/modules/core/ReactChoreographer$Companion;", "", "()V", "choreographer", "Lcom/facebook/react/modules/core/ReactChoreographer;", "getInstance", "initialize", "", "choreographerProvider", "Lcom/facebook/react/internal/ChoreographerProvider;", "overrideInstanceForTest", "instance", "overrideInstanceForTest$ReactAndroid_release", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void initialize(ChoreographerProvider choreographerProvider) {
            Intrinsics.checkNotNullParameter(choreographerProvider, "choreographerProvider");
            if (ReactChoreographer.choreographer == null) {
                ReactChoreographer.choreographer = new ReactChoreographer(choreographerProvider, null);
            }
        }

        @JvmStatic
        public final ReactChoreographer getInstance() {
            ReactChoreographer reactChoreographer = ReactChoreographer.choreographer;
            if (reactChoreographer != null) {
                return reactChoreographer;
            }
            throw new IllegalStateException("ReactChoreographer needs to be initialized.".toString());
        }

        @VisibleForTesting
        public final ReactChoreographer overrideInstanceForTest$ReactAndroid_release(ReactChoreographer instance) {
            ReactChoreographer reactChoreographer = ReactChoreographer.choreographer;
            Companion companion = ReactChoreographer.INSTANCE;
            ReactChoreographer.choreographer = instance;
            return reactChoreographer;
        }
    }
}
