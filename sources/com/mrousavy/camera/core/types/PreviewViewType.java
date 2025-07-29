package com.mrousavy.camera.core.types;

import androidx.camera.view.PreviewView;
import com.mrousavy.camera.core.InvalidTypeScriptUnionError;
import com.mrousavy.camera.core.types.JSUnionValue;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PreviewViewType.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/mrousavy/camera/core/types/PreviewViewType;", "", "Lcom/mrousavy/camera/core/types/JSUnionValue;", "unionValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getUnionValue", "()Ljava/lang/String;", "toPreviewImplementationMode", "Landroidx/camera/view/PreviewView$ImplementationMode;", "SURFACE_VIEW", "TEXTURE_VIEW", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PreviewViewType implements JSUnionValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PreviewViewType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final PreviewViewType SURFACE_VIEW = new PreviewViewType("SURFACE_VIEW", 0, "surface-view");
    public static final PreviewViewType TEXTURE_VIEW = new PreviewViewType("TEXTURE_VIEW", 1, "texture-view");
    private final String unionValue;

    /* compiled from: PreviewViewType.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PreviewViewType.values().length];
            try {
                iArr[PreviewViewType.SURFACE_VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PreviewViewType.TEXTURE_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ PreviewViewType[] $values() {
        return new PreviewViewType[]{SURFACE_VIEW, TEXTURE_VIEW};
    }

    public static EnumEntries<PreviewViewType> getEntries() {
        return $ENTRIES;
    }

    public static PreviewViewType valueOf(String str) {
        return (PreviewViewType) Enum.valueOf(PreviewViewType.class, str);
    }

    public static PreviewViewType[] values() {
        return (PreviewViewType[]) $VALUES.clone();
    }

    private PreviewViewType(String str, int i, String str2) {
        this.unionValue = str2;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    public String getUnionValue() {
        return this.unionValue;
    }

    static {
        PreviewViewType[] previewViewTypeArr$values = $values();
        $VALUES = previewViewTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(previewViewTypeArr$values);
        INSTANCE = new Companion(null);
    }

    public final PreviewView.ImplementationMode toPreviewImplementationMode() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return PreviewView.ImplementationMode.PERFORMANCE;
        }
        if (i == 2) {
            return PreviewView.ImplementationMode.COMPATIBLE;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* compiled from: PreviewViewType.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/mrousavy/camera/core/types/PreviewViewType$Companion;", "Lcom/mrousavy/camera/core/types/JSUnionValue$Companion;", "Lcom/mrousavy/camera/core/types/PreviewViewType;", "()V", "fromUnionValue", "unionValue", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion implements JSUnionValue.Companion<PreviewViewType> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mrousavy.camera.core.types.JSUnionValue.Companion
        public PreviewViewType fromUnionValue(String unionValue) throws InvalidTypeScriptUnionError {
            if (Intrinsics.areEqual(unionValue, "surface-view")) {
                return PreviewViewType.SURFACE_VIEW;
            }
            if (Intrinsics.areEqual(unionValue, "texture-view")) {
                return PreviewViewType.TEXTURE_VIEW;
            }
            throw new InvalidTypeScriptUnionError("androidPreviewViewType", unionValue);
        }
    }
}
