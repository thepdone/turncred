package com.facebook.imageformat;

import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imageformat.ImageFormat;
import com.google.common.base.Ascii;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultImageFormatChecker.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/facebook/imageformat/DefaultImageFormatChecker;", "Lcom/facebook/imageformat/ImageFormat$FormatChecker;", "()V", "headerSize", "", "getHeaderSize", "()I", "determineFormat", "Lcom/facebook/imageformat/ImageFormat;", "headerBytes", "", "Companion", "imagepipeline-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultImageFormatChecker implements ImageFormat.FormatChecker {
    private static final byte[] BMP_HEADER;
    private static final int BMP_HEADER_LENGTH;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final byte[] DNG_HEADER_II;
    private static final int DNG_HEADER_LENGTH;
    private static final byte[] DNG_HEADER_MM;
    private static final int EXTENDED_WEBP_HEADER_LENGTH = 21;
    private static final byte[] GIF_HEADER_87A;
    private static final byte[] GIF_HEADER_89A;
    private static final int GIF_HEADER_LENGTH = 6;
    private static final int HEIF_HEADER_LENGTH = 12;
    private static final byte[] HEIF_HEADER_PREFIX;
    private static final byte[][] HEIF_HEADER_SUFFIXES;
    private static final byte[] ICO_HEADER;
    private static final int ICO_HEADER_LENGTH;
    private static final byte[] JPEG_HEADER;
    private static final int JPEG_HEADER_LENGTH;
    private static final byte[] PNG_HEADER;
    private static final int PNG_HEADER_LENGTH;
    private static final int SIMPLE_WEBP_HEADER_LENGTH = 20;
    private final int headerSize;

    public DefaultImageFormatChecker() {
        Object objMaxOrNull = ArraysKt.maxOrNull(new Integer[]{21, 20, Integer.valueOf(JPEG_HEADER_LENGTH), Integer.valueOf(PNG_HEADER_LENGTH), 6, Integer.valueOf(BMP_HEADER_LENGTH), Integer.valueOf(ICO_HEADER_LENGTH), 12});
        if (objMaxOrNull == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        this.headerSize = ((Number) objMaxOrNull).intValue();
    }

    @Override // com.facebook.imageformat.ImageFormat.FormatChecker
    public int getHeaderSize() {
        return this.headerSize;
    }

    @Override // com.facebook.imageformat.ImageFormat.FormatChecker
    public ImageFormat determineFormat(byte[] headerBytes, int headerSize) {
        Intrinsics.checkNotNullParameter(headerBytes, "headerBytes");
        if (!WebpSupportStatus.isWebpHeader(headerBytes, 0, headerSize)) {
            Companion companion = INSTANCE;
            if (companion.isJpegHeader(headerBytes, headerSize)) {
                return DefaultImageFormats.JPEG;
            }
            if (companion.isPngHeader(headerBytes, headerSize)) {
                return DefaultImageFormats.PNG;
            }
            if (companion.isGifHeader(headerBytes, headerSize)) {
                return DefaultImageFormats.GIF;
            }
            if (companion.isBmpHeader(headerBytes, headerSize)) {
                return DefaultImageFormats.BMP;
            }
            if (companion.isIcoHeader(headerBytes, headerSize)) {
                return DefaultImageFormats.ICO;
            }
            if (companion.isHeifHeader(headerBytes, headerSize)) {
                return DefaultImageFormats.HEIF;
            }
            if (companion.isDngHeader(headerBytes, headerSize)) {
                return DefaultImageFormats.DNG;
            }
            return ImageFormat.UNKNOWN;
        }
        return INSTANCE.getWebpFormat(headerBytes, headerSize);
    }

    /* compiled from: DefaultImageFormatChecker.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J\u0018\u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J\u0018\u0010!\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J\u0018\u0010#\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J\u0018\u0010$\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J\u0018\u0010%\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/facebook/imageformat/DefaultImageFormatChecker$Companion;", "", "()V", "BMP_HEADER", "", "BMP_HEADER_LENGTH", "", "DNG_HEADER_II", "DNG_HEADER_LENGTH", "DNG_HEADER_MM", "EXTENDED_WEBP_HEADER_LENGTH", "GIF_HEADER_87A", "GIF_HEADER_89A", "GIF_HEADER_LENGTH", "HEIF_HEADER_LENGTH", "HEIF_HEADER_PREFIX", "HEIF_HEADER_SUFFIXES", "", "[[B", "ICO_HEADER", "ICO_HEADER_LENGTH", "JPEG_HEADER", "JPEG_HEADER_LENGTH", "PNG_HEADER", "PNG_HEADER_LENGTH", "SIMPLE_WEBP_HEADER_LENGTH", "getWebpFormat", "Lcom/facebook/imageformat/ImageFormat;", "imageHeaderBytes", "headerSize", "isBmpHeader", "", "isDngHeader", "isGifHeader", "isHeifHeader", "isIcoHeader", "isJpegHeader", "isPngHeader", "imagepipeline-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ImageFormat getWebpFormat(byte[] imageHeaderBytes, int headerSize) {
            if (!WebpSupportStatus.isWebpHeader(imageHeaderBytes, 0, headerSize)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (WebpSupportStatus.isSimpleWebpHeader(imageHeaderBytes, 0)) {
                return DefaultImageFormats.WEBP_SIMPLE;
            }
            if (WebpSupportStatus.isLosslessWebpHeader(imageHeaderBytes, 0)) {
                return DefaultImageFormats.WEBP_LOSSLESS;
            }
            if (WebpSupportStatus.isExtendedWebpHeader(imageHeaderBytes, 0, headerSize)) {
                if (WebpSupportStatus.isAnimatedWebpHeader(imageHeaderBytes, 0)) {
                    return DefaultImageFormats.WEBP_ANIMATED;
                }
                if (WebpSupportStatus.isExtendedWebpHeaderWithAlpha(imageHeaderBytes, 0)) {
                    return DefaultImageFormats.WEBP_EXTENDED_WITH_ALPHA;
                }
                return DefaultImageFormats.WEBP_EXTENDED;
            }
            return ImageFormat.UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isJpegHeader(byte[] imageHeaderBytes, int headerSize) {
            return headerSize >= DefaultImageFormatChecker.JPEG_HEADER.length && ImageFormatCheckerUtils.startsWithPattern(imageHeaderBytes, DefaultImageFormatChecker.JPEG_HEADER);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isPngHeader(byte[] imageHeaderBytes, int headerSize) {
            return headerSize >= DefaultImageFormatChecker.PNG_HEADER.length && ImageFormatCheckerUtils.startsWithPattern(imageHeaderBytes, DefaultImageFormatChecker.PNG_HEADER);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isGifHeader(byte[] imageHeaderBytes, int headerSize) {
            if (headerSize < 6) {
                return false;
            }
            return ImageFormatCheckerUtils.startsWithPattern(imageHeaderBytes, DefaultImageFormatChecker.GIF_HEADER_87A) || ImageFormatCheckerUtils.startsWithPattern(imageHeaderBytes, DefaultImageFormatChecker.GIF_HEADER_89A);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isBmpHeader(byte[] imageHeaderBytes, int headerSize) {
            if (headerSize < DefaultImageFormatChecker.BMP_HEADER.length) {
                return false;
            }
            return ImageFormatCheckerUtils.startsWithPattern(imageHeaderBytes, DefaultImageFormatChecker.BMP_HEADER);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isIcoHeader(byte[] imageHeaderBytes, int headerSize) {
            if (headerSize < DefaultImageFormatChecker.ICO_HEADER.length) {
                return false;
            }
            return ImageFormatCheckerUtils.startsWithPattern(imageHeaderBytes, DefaultImageFormatChecker.ICO_HEADER);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isHeifHeader(byte[] imageHeaderBytes, int headerSize) {
            if (headerSize < 12 || imageHeaderBytes[3] < 8 || !ImageFormatCheckerUtils.hasPatternAt(imageHeaderBytes, DefaultImageFormatChecker.HEIF_HEADER_PREFIX, 4)) {
                return false;
            }
            for (byte[] bArr : DefaultImageFormatChecker.HEIF_HEADER_SUFFIXES) {
                if (ImageFormatCheckerUtils.hasPatternAt(imageHeaderBytes, bArr, 8)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isDngHeader(byte[] imageHeaderBytes, int headerSize) {
            return headerSize >= DefaultImageFormatChecker.DNG_HEADER_LENGTH && (ImageFormatCheckerUtils.startsWithPattern(imageHeaderBytes, DefaultImageFormatChecker.DNG_HEADER_II) || ImageFormatCheckerUtils.startsWithPattern(imageHeaderBytes, DefaultImageFormatChecker.DNG_HEADER_MM));
        }
    }

    static {
        byte[] bArr = {-1, -40, -1};
        JPEG_HEADER = bArr;
        JPEG_HEADER_LENGTH = bArr.length;
        byte[] bArr2 = {-119, 80, 78, 71, Ascii.CR, 10, Ascii.SUB, 10};
        PNG_HEADER = bArr2;
        PNG_HEADER_LENGTH = bArr2.length;
        GIF_HEADER_87A = ImageFormatCheckerUtils.asciiBytes("GIF87a");
        GIF_HEADER_89A = ImageFormatCheckerUtils.asciiBytes("GIF89a");
        byte[] bArrAsciiBytes = ImageFormatCheckerUtils.asciiBytes("BM");
        BMP_HEADER = bArrAsciiBytes;
        BMP_HEADER_LENGTH = bArrAsciiBytes.length;
        byte[] bArr3 = {0, 0, 1, 0};
        ICO_HEADER = bArr3;
        ICO_HEADER_LENGTH = bArr3.length;
        HEIF_HEADER_PREFIX = ImageFormatCheckerUtils.asciiBytes("ftyp");
        HEIF_HEADER_SUFFIXES = new byte[][]{ImageFormatCheckerUtils.asciiBytes("heic"), ImageFormatCheckerUtils.asciiBytes("heix"), ImageFormatCheckerUtils.asciiBytes("hevc"), ImageFormatCheckerUtils.asciiBytes("hevx"), ImageFormatCheckerUtils.asciiBytes("mif1"), ImageFormatCheckerUtils.asciiBytes("msf1")};
        byte[] bArr4 = {73, 73, 42, 0};
        DNG_HEADER_II = bArr4;
        DNG_HEADER_MM = new byte[]{77, 77, 0, 42};
        DNG_HEADER_LENGTH = bArr4.length;
    }
}
