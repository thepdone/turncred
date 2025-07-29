package com.facebook.react.uimanager;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PointerEvents.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/facebook/react/uimanager/PointerEvents;", "", "(Ljava/lang/String;I)V", "NONE", "BOX_NONE", "BOX_ONLY", "AUTO", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PointerEvents {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PointerEvents[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final PointerEvents NONE = new PointerEvents("NONE", 0);
    public static final PointerEvents BOX_NONE = new PointerEvents("BOX_NONE", 1);
    public static final PointerEvents BOX_ONLY = new PointerEvents("BOX_ONLY", 2);
    public static final PointerEvents AUTO = new PointerEvents("AUTO", 3);

    private static final /* synthetic */ PointerEvents[] $values() {
        return new PointerEvents[]{NONE, BOX_NONE, BOX_ONLY, AUTO};
    }

    @JvmStatic
    public static final boolean canBeTouchTarget(PointerEvents pointerEvents) {
        return INSTANCE.canBeTouchTarget(pointerEvents);
    }

    @JvmStatic
    public static final boolean canChildrenBeTouchTarget(PointerEvents pointerEvents) {
        return INSTANCE.canChildrenBeTouchTarget(pointerEvents);
    }

    public static EnumEntries<PointerEvents> getEntries() {
        return $ENTRIES;
    }

    @JvmStatic
    public static final PointerEvents parsePointerEvents(String str) {
        return INSTANCE.parsePointerEvents(str);
    }

    public static PointerEvents valueOf(String str) {
        return (PointerEvents) Enum.valueOf(PointerEvents.class, str);
    }

    public static PointerEvents[] values() {
        return (PointerEvents[]) $VALUES.clone();
    }

    private PointerEvents(String str, int i) {
    }

    static {
        PointerEvents[] pointerEventsArr$values = $values();
        $VALUES = pointerEventsArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(pointerEventsArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: PointerEvents.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/facebook/react/uimanager/PointerEvents$Companion;", "", "()V", "canBeTouchTarget", "", ViewProps.POINTER_EVENTS, "Lcom/facebook/react/uimanager/PointerEvents;", "canChildrenBeTouchTarget", "parsePointerEvents", "pointerEventsStr", "", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PointerEvents parsePointerEvents(String pointerEventsStr) {
            if (pointerEventsStr == null) {
                return PointerEvents.AUTO;
            }
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String upperCase = pointerEventsStr.toUpperCase(US);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return PointerEvents.valueOf(StringsKt.replace$default(upperCase, "-", "_", false, 4, (Object) null));
        }

        @JvmStatic
        public final boolean canBeTouchTarget(PointerEvents pointerEvents) {
            Intrinsics.checkNotNullParameter(pointerEvents, "pointerEvents");
            return pointerEvents == PointerEvents.AUTO || pointerEvents == PointerEvents.BOX_ONLY;
        }

        @JvmStatic
        public final boolean canChildrenBeTouchTarget(PointerEvents pointerEvents) {
            Intrinsics.checkNotNullParameter(pointerEvents, "pointerEvents");
            return pointerEvents == PointerEvents.AUTO || pointerEvents == PointerEvents.BOX_NONE;
        }
    }
}
