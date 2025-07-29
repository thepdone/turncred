package androidx.compose.ui.graphics.layer;

import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.core.os.HandlerCompat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayerManager.android.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\rJ\u0016\u0010\u0017\u001a\u00020\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\rJ\u0006\u0010\u001b\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/graphics/layer/LayerManager;", "", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "(Landroidx/compose/ui/graphics/CanvasHolder;)V", "getCanvasHolder", "()Landroidx/compose/ui/graphics/CanvasHolder;", "handler", "Landroid/os/Handler;", "imageReader", "Landroid/media/ImageReader;", "layerSet", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "persistenceIterationInProgress", "", "postponedReleaseRequests", "Landroidx/collection/MutableObjectList;", "destroy", "", "hasImageReader", "persist", "layer", "persistLayers", "layers", "Landroidx/collection/ScatterSet;", "release", "updateLayerPersistence", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayerManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean isRobolectric;
    private final CanvasHolder canvasHolder;
    private ImageReader imageReader;
    private boolean persistenceIterationInProgress;
    private MutableObjectList<GraphicsLayer> postponedReleaseRequests;
    private final MutableScatterSet<GraphicsLayer> layerSet = ScatterSetKt.mutableScatterSetOf();
    private final Handler handler = HandlerCompat.createAsync(Looper.getMainLooper(), new Handler.Callback() { // from class: androidx.compose.ui.graphics.layer.LayerManager$$ExternalSyntheticLambda1
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return LayerManager.handler$lambda$0(this.f$0, message);
        }
    });

    public LayerManager(CanvasHolder canvasHolder) {
        this.canvasHolder = canvasHolder;
    }

    public final CanvasHolder getCanvasHolder() {
        return this.canvasHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean handler$lambda$0(LayerManager layerManager, Message message) {
        layerManager.persistLayers(layerManager.layerSet);
        return true;
    }

    public final void persist(GraphicsLayer layer) {
        this.layerSet.add(layer);
        if (this.handler.hasMessages(0)) {
            return;
        }
        this.handler.sendMessageAtFrontOfQueue(Message.obtain());
    }

    public final void release(GraphicsLayer layer) {
        if (!this.persistenceIterationInProgress) {
            if (this.layerSet.remove(layer)) {
                layer.discardDisplayList$ui_graphics_release();
            }
        } else {
            MutableObjectList<GraphicsLayer> mutableObjectList = this.postponedReleaseRequests;
            if (mutableObjectList == null) {
                mutableObjectList = new MutableObjectList<>(0, 1, null);
                this.postponedReleaseRequests = mutableObjectList;
            }
            mutableObjectList.add(layer);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void persistLayers(androidx.collection.ScatterSet<androidx.compose.ui.graphics.layer.GraphicsLayer> r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            boolean r2 = r21.isNotEmpty()
            if (r2 == 0) goto Lc9
            boolean r2 = androidx.compose.ui.graphics.layer.LayerManager.isRobolectric
            if (r2 != 0) goto Lc9
            android.media.ImageReader r2 = r0.imageReader
            r3 = 1
            if (r2 != 0) goto L24
            r2 = 3
            android.media.ImageReader r2 = android.media.ImageReader.newInstance(r3, r3, r3, r2)
            androidx.compose.ui.graphics.layer.LayerManager$$ExternalSyntheticLambda0 r4 = new androidx.compose.ui.graphics.layer.LayerManager$$ExternalSyntheticLambda0
            r4.<init>()
            android.os.Handler r5 = r0.handler
            r2.setOnImageAvailableListener(r4, r5)
            r0.imageReader = r2
        L24:
            android.view.Surface r2 = r2.getSurface()
            androidx.compose.ui.graphics.layer.LockHardwareCanvasHelper r4 = androidx.compose.ui.graphics.layer.LockHardwareCanvasHelper.INSTANCE
            android.graphics.Canvas r4 = r4.lockHardwareCanvas(r2)
            r0.persistenceIterationInProgress = r3
            androidx.compose.ui.graphics.CanvasHolder r5 = r0.canvasHolder
            androidx.compose.ui.graphics.AndroidCanvas r6 = r5.getAndroidCanvas()
            android.graphics.Canvas r6 = r6.getInternalCanvas()
            androidx.compose.ui.graphics.AndroidCanvas r7 = r5.getAndroidCanvas()
            r7.setInternalCanvas(r4)
            androidx.compose.ui.graphics.AndroidCanvas r7 = r5.getAndroidCanvas()
            androidx.compose.ui.graphics.Canvas r7 = (androidx.compose.ui.graphics.Canvas) r7
            r4.save()
            r8 = 0
            r4.clipRect(r8, r8, r3, r3)
            java.lang.Object[] r3 = r1.elements
            long[] r1 = r1.metadata
            int r9 = r1.length
            int r9 = r9 + (-2)
            if (r9 < 0) goto L98
            r10 = r8
        L58:
            r11 = r1[r10]
            long r13 = ~r11
            r15 = 7
            long r13 = r13 << r15
            long r13 = r13 & r11
            r15 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r13 = r13 & r15
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 == 0) goto L92
            int r13 = r10 - r9
            int r13 = ~r13
            int r13 = r13 >>> 31
            r14 = 8
            int r13 = 8 - r13
            r15 = r8
        L72:
            if (r15 >= r13) goto L90
            r16 = 255(0xff, double:1.26E-321)
            long r16 = r11 & r16
            r18 = 128(0x80, double:6.32E-322)
            int r16 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r16 >= 0) goto L8b
            int r16 = r10 << 3
            int r16 = r16 + r15
            r16 = r3[r16]
            r8 = r16
            androidx.compose.ui.graphics.layer.GraphicsLayer r8 = (androidx.compose.ui.graphics.layer.GraphicsLayer) r8
            r8.drawForPersistence$ui_graphics_release(r7)
        L8b:
            long r11 = r11 >> r14
            int r15 = r15 + 1
            r8 = 0
            goto L72
        L90:
            if (r13 != r14) goto L98
        L92:
            if (r10 == r9) goto L98
            int r10 = r10 + 1
            r8 = 0
            goto L58
        L98:
            r4.restore()
            androidx.compose.ui.graphics.AndroidCanvas r1 = r5.getAndroidCanvas()
            r1.setInternalCanvas(r6)
            r1 = 0
            r0.persistenceIterationInProgress = r1
            androidx.collection.MutableObjectList<androidx.compose.ui.graphics.layer.GraphicsLayer> r3 = r0.postponedReleaseRequests
            if (r3 == 0) goto Lc6
            boolean r5 = r3.isNotEmpty()
            if (r5 == 0) goto Lc6
            r5 = r3
            androidx.collection.ObjectList r5 = (androidx.collection.ObjectList) r5
            java.lang.Object[] r6 = r5.content
            int r5 = r5._size
            r8 = r1
        Lb7:
            if (r8 >= r5) goto Lc3
            r1 = r6[r8]
            androidx.compose.ui.graphics.layer.GraphicsLayer r1 = (androidx.compose.ui.graphics.layer.GraphicsLayer) r1
            r0.release(r1)
            int r8 = r8 + 1
            goto Lb7
        Lc3:
            r3.clear()
        Lc6:
            r2.unlockCanvasAndPost(r4)
        Lc9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.layer.LayerManager.persistLayers(androidx.collection.ScatterSet):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void persistLayers$lambda$3$lambda$2(ImageReader imageReader) {
        Image imageAcquireLatestImage;
        if (imageReader == null || (imageAcquireLatestImage = imageReader.acquireLatestImage()) == null) {
            return;
        }
        imageAcquireLatestImage.close();
    }

    public final void destroy() {
        ImageReader imageReader = this.imageReader;
        if (imageReader != null) {
            imageReader.close();
        }
        this.imageReader = null;
    }

    public final boolean hasImageReader() {
        return this.imageReader != null;
    }

    public final void updateLayerPersistence() {
        destroy();
        persistLayers(this.layerSet);
    }

    /* compiled from: LayerManager.android.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/graphics/layer/LayerManager$Companion;", "", "()V", "isRobolectric", "", "()Z", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isRobolectric() {
            return LayerManager.isRobolectric;
        }
    }

    static {
        String lowerCase = Build.FINGERPRINT.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        isRobolectric = Intrinsics.areEqual(lowerCase, "robolectric");
    }
}
