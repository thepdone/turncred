package com.mrousavy.camera.core.extensions;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CameraSelector+byId.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"byId", "Landroidx/camera/core/CameraSelector$Builder;", "id", "", "react-native-vision-camera_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CameraSelector_byIdKt {
    public static final CameraSelector.Builder byId(CameraSelector.Builder builder, final String id) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(id, "id");
        CameraSelector.Builder builderAddCameraFilter = builder.addCameraFilter(new CameraFilter() { // from class: com.mrousavy.camera.core.extensions.CameraSelector_byIdKt$$ExternalSyntheticLambda0
            @Override // androidx.camera.core.CameraFilter
            public final List filter(List list) {
                return CameraSelector_byIdKt.byId$lambda$1(id, list);
            }
        });
        Intrinsics.checkNotNullExpressionValue(builderAddCameraFilter, "addCameraFilter(...)");
        return builderAddCameraFilter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List byId$lambda$1(String id, List cameraInfos) {
        Intrinsics.checkNotNullParameter(id, "$id");
        Intrinsics.checkNotNullParameter(cameraInfos, "cameraInfos");
        ArrayList arrayList = new ArrayList();
        for (Object obj : cameraInfos) {
            CameraInfo cameraInfo = (CameraInfo) obj;
            Intrinsics.checkNotNull(cameraInfo);
            if (Intrinsics.areEqual(CameraInfo_idKt.getId(cameraInfo), id)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toMutableList((Collection) arrayList);
    }
}
