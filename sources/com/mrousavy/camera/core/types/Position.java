package com.mrousavy.camera.core.types;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Position.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/mrousavy/camera/core/types/Position;", "", "Lcom/mrousavy/camera/core/types/JSUnionValue;", "unionValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getUnionValue", "()Ljava/lang/String;", "BACK", "FRONT", "EXTERNAL", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Position implements JSUnionValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Position[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String unionValue;
    public static final Position BACK = new Position("BACK", 0, "back");
    public static final Position FRONT = new Position("FRONT", 1, "front");
    public static final Position EXTERNAL = new Position("EXTERNAL", 2, "external");

    private static final /* synthetic */ Position[] $values() {
        return new Position[]{BACK, FRONT, EXTERNAL};
    }

    public static EnumEntries<Position> getEntries() {
        return $ENTRIES;
    }

    public static Position valueOf(String str) {
        return (Position) Enum.valueOf(Position.class, str);
    }

    public static Position[] values() {
        return (Position[]) $VALUES.clone();
    }

    private Position(String str, int i, String str2) {
        this.unionValue = str2;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    static {
        Position[] positionArr$values = $values();
        $VALUES = positionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(positionArr$values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: Position.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/mrousavy/camera/core/types/Position$Companion;", "", "()V", "fromLensFacing", "Lcom/mrousavy/camera/core/types/Position;", "lensFacing", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Position fromLensFacing(int lensFacing) {
            if (lensFacing == -1) {
                return Position.EXTERNAL;
            }
            if (lensFacing == 0) {
                return Position.FRONT;
            }
            if (lensFacing == 1) {
                return Position.BACK;
            }
            if (lensFacing == 2) {
                return Position.EXTERNAL;
            }
            return Position.EXTERNAL;
        }
    }
}
