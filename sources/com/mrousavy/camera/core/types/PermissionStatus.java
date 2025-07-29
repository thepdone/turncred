package com.mrousavy.camera.core.types;

import expo.modules.interfaces.permissions.PermissionsResponse;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PermissionStatus.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/mrousavy/camera/core/types/PermissionStatus;", "", "Lcom/mrousavy/camera/core/types/JSUnionValue;", "unionValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getUnionValue", "()Ljava/lang/String;", "DENIED", "NOT_DETERMINED", "GRANTED", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PermissionStatus implements JSUnionValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PermissionStatus[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String unionValue;
    public static final PermissionStatus DENIED = new PermissionStatus("DENIED", 0, "denied");
    public static final PermissionStatus NOT_DETERMINED = new PermissionStatus("NOT_DETERMINED", 1, "not-determined");
    public static final PermissionStatus GRANTED = new PermissionStatus("GRANTED", 2, PermissionsResponse.GRANTED_KEY);

    private static final /* synthetic */ PermissionStatus[] $values() {
        return new PermissionStatus[]{DENIED, NOT_DETERMINED, GRANTED};
    }

    public static EnumEntries<PermissionStatus> getEntries() {
        return $ENTRIES;
    }

    public static PermissionStatus valueOf(String str) {
        return (PermissionStatus) Enum.valueOf(PermissionStatus.class, str);
    }

    public static PermissionStatus[] values() {
        return (PermissionStatus[]) $VALUES.clone();
    }

    private PermissionStatus(String str, int i, String str2) {
        this.unionValue = str2;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    static {
        PermissionStatus[] permissionStatusArr$values = $values();
        $VALUES = permissionStatusArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(permissionStatusArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: PermissionStatus.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/mrousavy/camera/core/types/PermissionStatus$Companion;", "", "()V", "fromPermissionStatus", "Lcom/mrousavy/camera/core/types/PermissionStatus;", "status", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PermissionStatus fromPermissionStatus(int status) {
            if (status == -1) {
                return PermissionStatus.DENIED;
            }
            if (status == 0) {
                return PermissionStatus.GRANTED;
            }
            return PermissionStatus.NOT_DETERMINED;
        }
    }
}
