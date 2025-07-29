package com.mrousavy.camera.core.types;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DeviceType.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/mrousavy/camera/core/types/DeviceType;", "", "Lcom/mrousavy/camera/core/types/JSUnionValue;", "unionValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getUnionValue", "()Ljava/lang/String;", "ULTRA_WIDE_ANGLE", "WIDE_ANGLE", "TELEPHOTO", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeviceType implements JSUnionValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DeviceType[] $VALUES;
    private final String unionValue;
    public static final DeviceType ULTRA_WIDE_ANGLE = new DeviceType("ULTRA_WIDE_ANGLE", 0, "ultra-wide-angle-camera");
    public static final DeviceType WIDE_ANGLE = new DeviceType("WIDE_ANGLE", 1, "wide-angle-camera");
    public static final DeviceType TELEPHOTO = new DeviceType("TELEPHOTO", 2, "telephoto-camera");

    private static final /* synthetic */ DeviceType[] $values() {
        return new DeviceType[]{ULTRA_WIDE_ANGLE, WIDE_ANGLE, TELEPHOTO};
    }

    public static EnumEntries<DeviceType> getEntries() {
        return $ENTRIES;
    }

    public static DeviceType valueOf(String str) {
        return (DeviceType) Enum.valueOf(DeviceType.class, str);
    }

    public static DeviceType[] values() {
        return (DeviceType[]) $VALUES.clone();
    }

    private DeviceType(String str, int i, String str2) {
        this.unionValue = str2;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    static {
        DeviceType[] deviceTypeArr$values = $values();
        $VALUES = deviceTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(deviceTypeArr$values);
    }
}
