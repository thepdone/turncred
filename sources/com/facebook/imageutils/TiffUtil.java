package com.facebook.imageutils;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.common.RotationOptions;
import io.sentry.SentryEnvelopeItemHeader;
import io.sentry.protocol.Device;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TiffUtil.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J \u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J(\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0007J \u0010\u0015\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/facebook/imageutils/TiffUtil;", "", "()V", "TAG", "Ljava/lang/Class;", "TIFF_BYTE_ORDER_BIG_END", "", "TIFF_BYTE_ORDER_LITTLE_END", "TIFF_TAG_ORIENTATION", "TIFF_TYPE_SHORT", "getAutoRotateAngleFromOrientation", Device.JsonKeys.ORIENTATION, "getOrientationFromTiffEntry", "stream", "Ljava/io/InputStream;", SentryEnvelopeItemHeader.JsonKeys.LENGTH, "isLittleEndian", "", "moveToTiffEntryWithTag", "tagToFind", "readOrientationFromTIFF", "readTiffHeader", "tiffHeader", "Lcom/facebook/imageutils/TiffUtil$TiffHeader;", "TiffHeader", "imagepipeline-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TiffUtil {
    public static final TiffUtil INSTANCE = new TiffUtil();
    private static final Class<?> TAG = TiffUtil.class;
    public static final int TIFF_BYTE_ORDER_BIG_END = 1296891946;
    public static final int TIFF_BYTE_ORDER_LITTLE_END = 1229531648;
    public static final int TIFF_TAG_ORIENTATION = 274;
    public static final int TIFF_TYPE_SHORT = 3;

    @JvmStatic
    public static final int getAutoRotateAngleFromOrientation(int orientation) {
        if (orientation == 0 || orientation == 1) {
            return 0;
        }
        if (orientation == 3) {
            return RotationOptions.ROTATE_180;
        }
        if (orientation == 6) {
            return 90;
        }
        if (orientation != 8) {
            return 0;
        }
        return RotationOptions.ROTATE_270;
    }

    private TiffUtil() {
    }

    @JvmStatic
    public static final int readOrientationFromTIFF(InputStream stream, int length) throws IOException {
        Intrinsics.checkNotNullParameter(stream, "stream");
        TiffHeader tiffHeader = new TiffHeader();
        TiffUtil tiffUtil = INSTANCE;
        int tiffHeader2 = tiffUtil.readTiffHeader(stream, length, tiffHeader);
        int firstIfdOffset = tiffHeader.getFirstIfdOffset() - 8;
        if (tiffHeader2 == 0 || firstIfdOffset > tiffHeader2) {
            return 0;
        }
        stream.skip(firstIfdOffset);
        return tiffUtil.getOrientationFromTiffEntry(stream, tiffUtil.moveToTiffEntryWithTag(stream, tiffHeader2 - firstIfdOffset, tiffHeader.getIsLittleEndian(), TIFF_TAG_ORIENTATION), tiffHeader.getIsLittleEndian());
    }

    private final int readTiffHeader(InputStream stream, int length, TiffHeader tiffHeader) throws IOException {
        if (length <= 8) {
            return 0;
        }
        tiffHeader.setByteOrder(StreamProcessor.readPackedInt(stream, 4, false));
        if (tiffHeader.getByteOrder() != 1229531648 && tiffHeader.getByteOrder() != 1296891946) {
            FLog.e(TAG, "Invalid TIFF header");
            return 0;
        }
        tiffHeader.setLittleEndian(tiffHeader.getByteOrder() == 1229531648);
        tiffHeader.setFirstIfdOffset(StreamProcessor.readPackedInt(stream, 4, tiffHeader.getIsLittleEndian()));
        int i = length - 8;
        if (tiffHeader.getFirstIfdOffset() >= 8 && tiffHeader.getFirstIfdOffset() - 8 <= i) {
            return i;
        }
        FLog.e(TAG, "Invalid offset");
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int moveToTiffEntryWithTag(java.io.InputStream r7, int r8, boolean r9, int r10) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 14
            r1 = 0
            if (r8 >= r0) goto L6
            return r1
        L6:
            r0 = 2
            int r2 = com.facebook.imageutils.StreamProcessor.readPackedInt(r7, r0, r9)
            int r8 = r8 + (-2)
        Ld:
            int r3 = r2 + (-1)
            if (r2 <= 0) goto L27
            r2 = 12
            if (r8 < r2) goto L27
            int r2 = com.facebook.imageutils.StreamProcessor.readPackedInt(r7, r0, r9)
            int r4 = r8 + (-2)
            if (r2 != r10) goto L1e
            return r4
        L1e:
            r4 = 10
            r7.skip(r4)
            int r8 = r8 + (-12)
            r2 = r3
            goto Ld
        L27:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imageutils.TiffUtil.moveToTiffEntryWithTag(java.io.InputStream, int, boolean, int):int");
    }

    private final int getOrientationFromTiffEntry(InputStream stream, int length, boolean isLittleEndian) throws IOException {
        if (length >= 10 && StreamProcessor.readPackedInt(stream, 2, isLittleEndian) == 3 && StreamProcessor.readPackedInt(stream, 4, isLittleEndian) == 1) {
            return StreamProcessor.readPackedInt(stream, 2, isLittleEndian);
        }
        return 0;
    }

    /* compiled from: TiffUtil.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/facebook/imageutils/TiffUtil$TiffHeader;", "", "()V", "byteOrder", "", "getByteOrder", "()I", "setByteOrder", "(I)V", "firstIfdOffset", "getFirstIfdOffset", "setFirstIfdOffset", "isLittleEndian", "", "()Z", "setLittleEndian", "(Z)V", "imagepipeline-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class TiffHeader {
        private int byteOrder;
        private int firstIfdOffset;
        private boolean isLittleEndian;

        /* renamed from: isLittleEndian, reason: from getter */
        public final boolean getIsLittleEndian() {
            return this.isLittleEndian;
        }

        public final void setLittleEndian(boolean z) {
            this.isLittleEndian = z;
        }

        public final int getByteOrder() {
            return this.byteOrder;
        }

        public final void setByteOrder(int i) {
            this.byteOrder = i;
        }

        public final int getFirstIfdOffset() {
            return this.firstIfdOffset;
        }

        public final void setFirstIfdOffset(int i) {
            this.firstIfdOffset = i;
        }
    }
}
