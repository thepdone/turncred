package com.facebook.react.views.scroll;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ScrollEventType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/facebook/react/views/scroll/ScrollEventType;", "", "(Ljava/lang/String;I)V", "BEGIN_DRAG", "END_DRAG", "SCROLL", "MOMENTUM_BEGIN", "MOMENTUM_END", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ScrollEventType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ScrollEventType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final ScrollEventType BEGIN_DRAG = new ScrollEventType("BEGIN_DRAG", 0);
    public static final ScrollEventType END_DRAG = new ScrollEventType("END_DRAG", 1);
    public static final ScrollEventType SCROLL = new ScrollEventType("SCROLL", 2);
    public static final ScrollEventType MOMENTUM_BEGIN = new ScrollEventType("MOMENTUM_BEGIN", 3);
    public static final ScrollEventType MOMENTUM_END = new ScrollEventType("MOMENTUM_END", 4);

    private static final /* synthetic */ ScrollEventType[] $values() {
        return new ScrollEventType[]{BEGIN_DRAG, END_DRAG, SCROLL, MOMENTUM_BEGIN, MOMENTUM_END};
    }

    public static EnumEntries<ScrollEventType> getEntries() {
        return $ENTRIES;
    }

    @JvmStatic
    public static final String getJSEventName(ScrollEventType scrollEventType) {
        return INSTANCE.getJSEventName(scrollEventType);
    }

    public static ScrollEventType valueOf(String str) {
        return (ScrollEventType) Enum.valueOf(ScrollEventType.class, str);
    }

    public static ScrollEventType[] values() {
        return (ScrollEventType[]) $VALUES.clone();
    }

    private ScrollEventType(String str, int i) {
    }

    static {
        ScrollEventType[] scrollEventTypeArr$values = $values();
        $VALUES = scrollEventTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(scrollEventTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: ScrollEventType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/facebook/react/views/scroll/ScrollEventType$Companion;", "", "()V", "getJSEventName", "", "type", "Lcom/facebook/react/views/scroll/ScrollEventType;", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {

        /* compiled from: ScrollEventType.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ScrollEventType.values().length];
                try {
                    iArr[ScrollEventType.BEGIN_DRAG.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ScrollEventType.END_DRAG.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ScrollEventType.SCROLL.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ScrollEventType.MOMENTUM_BEGIN.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ScrollEventType.MOMENTUM_END.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final String getJSEventName(ScrollEventType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i == 1) {
                return "topScrollBeginDrag";
            }
            if (i == 2) {
                return "topScrollEndDrag";
            }
            if (i == 3) {
                return "topScroll";
            }
            if (i == 4) {
                return "topMomentumScrollBegin";
            }
            if (i == 5) {
                return "topMomentumScrollEnd";
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
