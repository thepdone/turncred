package expo.modules.kotlin.objects;

import androidx.core.app.NotificationCompat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EventObservingDefinition.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0004\u0011\u0012\u0013\u0014B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rJ\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0010R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lexpo/modules/kotlin/objects/EventObservingDefinition;", "", "type", "Lexpo/modules/kotlin/objects/EventObservingDefinition$Type;", "filer", "Lexpo/modules/kotlin/objects/EventObservingDefinition$Filter;", "body", "Lkotlin/Function0;", "", "(Lexpo/modules/kotlin/objects/EventObservingDefinition$Type;Lexpo/modules/kotlin/objects/EventObservingDefinition$Filter;Lkotlin/jvm/functions/Function0;)V", "invokedIfNeed", "eventType", "eventName", "", "shouldBeInvoked", "", "shouldBeInvoked$expo_modules_core_release", "AllEventsFilter", "Filter", "SelectedEventFiler", "Type", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EventObservingDefinition {
    public static final int $stable = 0;
    private final Function0<Unit> body;
    private final Filter filer;
    private final Type type;

    public EventObservingDefinition(Type type, Filter filer, Function0<Unit> body) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(filer, "filer");
        Intrinsics.checkNotNullParameter(body, "body");
        this.type = type;
        this.filer = filer;
        this.body = body;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: EventObservingDefinition.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lexpo/modules/kotlin/objects/EventObservingDefinition$Type;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "StartObserving", "StopObserving", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type StartObserving = new Type("StartObserving", 0, "startObserving");
        public static final Type StopObserving = new Type("StopObserving", 1, "stopObserving");
        private final String value;

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{StartObserving, StopObserving};
        }

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        private Type(String str, int i, String str2) {
            this.value = str2;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
        }
    }

    /* compiled from: EventObservingDefinition.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lexpo/modules/kotlin/objects/EventObservingDefinition$Filter;", "", "()V", "Lexpo/modules/kotlin/objects/EventObservingDefinition$AllEventsFilter;", "Lexpo/modules/kotlin/objects/EventObservingDefinition$SelectedEventFiler;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Filter {
        public static final int $stable = 0;

        public /* synthetic */ Filter(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Filter() {
        }
    }

    /* compiled from: EventObservingDefinition.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lexpo/modules/kotlin/objects/EventObservingDefinition$AllEventsFilter;", "Lexpo/modules/kotlin/objects/EventObservingDefinition$Filter;", "()V", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class AllEventsFilter extends Filter {
        public static final int $stable = 0;
        public static final AllEventsFilter INSTANCE = new AllEventsFilter();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AllEventsFilter)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 728698842;
        }

        public String toString() {
            return "AllEventsFilter";
        }

        private AllEventsFilter() {
            super(null);
        }
    }

    /* compiled from: EventObservingDefinition.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/kotlin/objects/EventObservingDefinition$SelectedEventFiler;", "Lexpo/modules/kotlin/objects/EventObservingDefinition$Filter;", NotificationCompat.CATEGORY_EVENT, "", "(Ljava/lang/String;)V", "getEvent", "()Ljava/lang/String;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SelectedEventFiler extends Filter {
        public static final int $stable = 0;
        private final String event;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectedEventFiler(String event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.event = event;
        }

        public final String getEvent() {
            return this.event;
        }
    }

    public final boolean shouldBeInvoked$expo_modules_core_release(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Filter filter = this.filer;
        if (filter instanceof AllEventsFilter) {
            return true;
        }
        if (filter instanceof SelectedEventFiler) {
            return Intrinsics.areEqual(((SelectedEventFiler) filter).getEvent(), eventName);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void invokedIfNeed(Type eventType, String eventName) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (eventType == this.type && shouldBeInvoked$expo_modules_core_release(eventName)) {
            this.body.invoke();
        }
    }
}
