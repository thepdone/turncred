package com.facebook.react.views.image;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ImageResizeMethod.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/react/views/image/ImageResizeMethod;", "", "(Ljava/lang/String;I)V", "AUTO", "RESIZE", "SCALE", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ImageResizeMethod {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ImageResizeMethod[] $VALUES;
    public static final ImageResizeMethod AUTO = new ImageResizeMethod("AUTO", 0);
    public static final ImageResizeMethod RESIZE = new ImageResizeMethod("RESIZE", 1);
    public static final ImageResizeMethod SCALE = new ImageResizeMethod("SCALE", 2);

    private static final /* synthetic */ ImageResizeMethod[] $values() {
        return new ImageResizeMethod[]{AUTO, RESIZE, SCALE};
    }

    public static EnumEntries<ImageResizeMethod> getEntries() {
        return $ENTRIES;
    }

    public static ImageResizeMethod valueOf(String str) {
        return (ImageResizeMethod) Enum.valueOf(ImageResizeMethod.class, str);
    }

    public static ImageResizeMethod[] values() {
        return (ImageResizeMethod[]) $VALUES.clone();
    }

    private ImageResizeMethod(String str, int i) {
    }

    static {
        ImageResizeMethod[] imageResizeMethodArr$values = $values();
        $VALUES = imageResizeMethodArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(imageResizeMethodArr$values);
    }
}
