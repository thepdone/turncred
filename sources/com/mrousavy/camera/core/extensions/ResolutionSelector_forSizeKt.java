package com.mrousavy.camera.core.extensions;

import android.util.Size;
import androidx.camera.core.resolutionselector.ResolutionFilter;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import com.facebook.react.uimanager.ViewProps;
import io.sentry.rrweb.RRWebVideoEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResolutionSelector+forSize.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\u0012\u0010\u0007\u001a\u00020\b*\u00020\b2\u0006\u0010\t\u001a\u00020\u0003¨\u0006\n"}, d2 = {"aspectRatioDifference", "", "left", "Landroid/util/Size;", ViewProps.RIGHT, "sizeDifference", "", "forSize", "Landroidx/camera/core/resolutionselector/ResolutionSelector$Builder;", RRWebVideoEvent.JsonKeys.SIZE, "react-native-vision-camera_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ResolutionSelector_forSizeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int sizeDifference(Size size, Size size2) {
        return Math.abs((size.getWidth() * size.getHeight()) - (size2.getWidth() * size2.getHeight()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float aspectRatioDifference(Size size, Size size2) {
        return Math.abs(Size_aspectRatioKt.getAspectRatio(size) - Size_aspectRatioKt.getAspectRatio(size2));
    }

    public static final ResolutionSelector.Builder forSize(ResolutionSelector.Builder builder, final Size size) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(size, "size");
        ResolutionSelector.Builder resolutionFilter = builder.setResolutionFilter(new ResolutionFilter() { // from class: com.mrousavy.camera.core.extensions.ResolutionSelector_forSizeKt$$ExternalSyntheticLambda0
            @Override // androidx.camera.core.resolutionselector.ResolutionFilter
            public final List filter(List list, int i) {
                return ResolutionSelector_forSizeKt.forSize$lambda$0(size, list, i);
            }
        });
        Intrinsics.checkNotNullExpressionValue(resolutionFilter, "setResolutionFilter(...)");
        return resolutionFilter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List forSize$lambda$0(final Size size, List supportedSizes, int i) {
        Intrinsics.checkNotNullParameter(size, "$size");
        Intrinsics.checkNotNullParameter(supportedSizes, "supportedSizes");
        return CollectionsKt.sortedWith(supportedSizes, ComparisonsKt.compareBy(new Function1<Size, Comparable<?>>() { // from class: com.mrousavy.camera.core.extensions.ResolutionSelector_forSizeKt$forSize$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(Size size2) {
                Intrinsics.checkNotNull(size2);
                return Float.valueOf(ResolutionSelector_forSizeKt.aspectRatioDifference(size2, size));
            }
        }, new Function1<Size, Comparable<?>>() { // from class: com.mrousavy.camera.core.extensions.ResolutionSelector_forSizeKt$forSize$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(Size size2) {
                Intrinsics.checkNotNull(size2);
                return Integer.valueOf(ResolutionSelector_forSizeKt.sizeDifference(size2, size));
            }
        }));
    }
}
