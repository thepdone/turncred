package com.facebook.react.uimanager.events;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: TouchEventType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/facebook/react/uimanager/events/TouchEventType;", "", "jsName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJsName", "START", "END", "MOVE", "CANCEL", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TouchEventType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TouchEventType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String jsName;
    public static final TouchEventType START = new TouchEventType("START", 0, "topTouchStart");
    public static final TouchEventType END = new TouchEventType("END", 1, "topTouchEnd");
    public static final TouchEventType MOVE = new TouchEventType("MOVE", 2, "topTouchMove");
    public static final TouchEventType CANCEL = new TouchEventType("CANCEL", 3, "topTouchCancel");

    private static final /* synthetic */ TouchEventType[] $values() {
        return new TouchEventType[]{START, END, MOVE, CANCEL};
    }

    public static EnumEntries<TouchEventType> getEntries() {
        return $ENTRIES;
    }

    @JvmStatic
    public static final String getJSEventName(TouchEventType touchEventType) {
        return INSTANCE.getJSEventName(touchEventType);
    }

    public static TouchEventType valueOf(String str) {
        return (TouchEventType) Enum.valueOf(TouchEventType.class, str);
    }

    public static TouchEventType[] values() {
        return (TouchEventType[]) $VALUES.clone();
    }

    private TouchEventType(String str, int i, String str2) {
        this.jsName = str2;
    }

    static {
        TouchEventType[] touchEventTypeArr$values = $values();
        $VALUES = touchEventTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(touchEventTypeArr$values);
        INSTANCE = new Companion(null);
    }

    public final String getJsName() {
        return this.jsName;
    }

    /* compiled from: TouchEventType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/facebook/react/uimanager/events/TouchEventType$Companion;", "", "()V", "getJSEventName", "", "type", "Lcom/facebook/react/uimanager/events/TouchEventType;", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final String getJSEventName(TouchEventType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return type.getJsName();
        }
    }
}
