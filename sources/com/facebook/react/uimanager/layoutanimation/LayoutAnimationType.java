package com.facebook.react.uimanager.layoutanimation;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LayoutAnimationType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/facebook/react/uimanager/layoutanimation/LayoutAnimationType;", "", "(Ljava/lang/String;I)V", "CREATE", "UPDATE", "DELETE", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LayoutAnimationType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LayoutAnimationType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final LayoutAnimationType CREATE = new LayoutAnimationType("CREATE", 0);
    public static final LayoutAnimationType UPDATE = new LayoutAnimationType("UPDATE", 1);
    public static final LayoutAnimationType DELETE = new LayoutAnimationType("DELETE", 2);

    private static final /* synthetic */ LayoutAnimationType[] $values() {
        return new LayoutAnimationType[]{CREATE, UPDATE, DELETE};
    }

    public static EnumEntries<LayoutAnimationType> getEntries() {
        return $ENTRIES;
    }

    @JvmStatic
    public static final String toString(LayoutAnimationType layoutAnimationType) {
        return INSTANCE.toString(layoutAnimationType);
    }

    public static LayoutAnimationType valueOf(String str) {
        return (LayoutAnimationType) Enum.valueOf(LayoutAnimationType.class, str);
    }

    public static LayoutAnimationType[] values() {
        return (LayoutAnimationType[]) $VALUES.clone();
    }

    private LayoutAnimationType(String str, int i) {
    }

    static {
        LayoutAnimationType[] layoutAnimationTypeArr$values = $values();
        $VALUES = layoutAnimationTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(layoutAnimationTypeArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: LayoutAnimationType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/facebook/react/uimanager/layoutanimation/LayoutAnimationType$Companion;", "", "()V", InAppPurchaseConstants.METHOD_TO_STRING, "", "type", "Lcom/facebook/react/uimanager/layoutanimation/LayoutAnimationType;", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {

        /* compiled from: LayoutAnimationType.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[LayoutAnimationType.values().length];
                try {
                    iArr[LayoutAnimationType.CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LayoutAnimationType.UPDATE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[LayoutAnimationType.DELETE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
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
        public final String toString(LayoutAnimationType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i == 1) {
                return "create";
            }
            if (i == 2) {
                return "update";
            }
            if (i == 3) {
                return "delete";
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
