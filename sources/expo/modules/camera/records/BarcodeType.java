package expo.modules.camera.records;

import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: CameraRecords.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0016B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Lexpo/modules/camera/records/BarcodeType;", "", "Lexpo/modules/kotlin/types/Enumerable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "mapToBarcode", "", "AZTEC", "EAN13", "EAN8", "QR", "PDF417", "UPCE", "DATAMATRIX", "CODE39", "CODE93", "ITF14", "CODABAR", "CODE128", "UPCA", "UNKNOWN", "Companion", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BarcodeType implements Enumerable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BarcodeType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String value;
    public static final BarcodeType AZTEC = new BarcodeType("AZTEC", 0, "aztec");
    public static final BarcodeType EAN13 = new BarcodeType("EAN13", 1, "ean13");
    public static final BarcodeType EAN8 = new BarcodeType("EAN8", 2, "ean8");
    public static final BarcodeType QR = new BarcodeType("QR", 3, "qr");
    public static final BarcodeType PDF417 = new BarcodeType("PDF417", 4, "pdf417");
    public static final BarcodeType UPCE = new BarcodeType("UPCE", 5, "upc_e");
    public static final BarcodeType DATAMATRIX = new BarcodeType("DATAMATRIX", 6, "datamatrix");
    public static final BarcodeType CODE39 = new BarcodeType("CODE39", 7, "code39");
    public static final BarcodeType CODE93 = new BarcodeType("CODE93", 8, "code93");
    public static final BarcodeType ITF14 = new BarcodeType("ITF14", 9, "itf14");
    public static final BarcodeType CODABAR = new BarcodeType("CODABAR", 10, "codabar");
    public static final BarcodeType CODE128 = new BarcodeType("CODE128", 11, "code128");
    public static final BarcodeType UPCA = new BarcodeType("UPCA", 12, "upc_a");
    public static final BarcodeType UNKNOWN = new BarcodeType("UNKNOWN", 13, "unknown");

    /* compiled from: CameraRecords.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BarcodeType.values().length];
            try {
                iArr[BarcodeType.AZTEC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BarcodeType.EAN13.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BarcodeType.EAN8.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BarcodeType.QR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BarcodeType.PDF417.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[BarcodeType.UPCE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[BarcodeType.DATAMATRIX.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[BarcodeType.CODE39.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[BarcodeType.CODE93.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[BarcodeType.ITF14.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[BarcodeType.CODABAR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[BarcodeType.CODE128.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[BarcodeType.UPCA.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[BarcodeType.UNKNOWN.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ BarcodeType[] $values() {
        return new BarcodeType[]{AZTEC, EAN13, EAN8, QR, PDF417, UPCE, DATAMATRIX, CODE39, CODE93, ITF14, CODABAR, CODE128, UPCA, UNKNOWN};
    }

    public static EnumEntries<BarcodeType> getEntries() {
        return $ENTRIES;
    }

    public static BarcodeType valueOf(String str) {
        return (BarcodeType) Enum.valueOf(BarcodeType.class, str);
    }

    public static BarcodeType[] values() {
        return (BarcodeType[]) $VALUES.clone();
    }

    private BarcodeType(String str, int i, String str2) {
        this.value = str2;
    }

    static {
        BarcodeType[] barcodeTypeArr$values = $values();
        $VALUES = barcodeTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(barcodeTypeArr$values);
        INSTANCE = new Companion(null);
    }

    public final int mapToBarcode() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return 4096;
            case 2:
                return 32;
            case 3:
                return 64;
            case 4:
                return 256;
            case 5:
                return 2048;
            case 6:
                return 1024;
            case 7:
                return 16;
            case 8:
                return 2;
            case 9:
                return 4;
            case 10:
                return 128;
            case 11:
                return 8;
            case 12:
                return 1;
            case 13:
                return 512;
            case 14:
                return -1;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* compiled from: CameraRecords.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/camera/records/BarcodeType$Companion;", "", "()V", "mapFormatToString", "", "format", "", "expo-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String mapFormatToString(int format) {
            BarcodeType barcodeType;
            if (format == 1) {
                barcodeType = BarcodeType.CODE128;
            } else if (format == 2) {
                barcodeType = BarcodeType.CODE39;
            } else {
                switch (format) {
                    case 4:
                        barcodeType = BarcodeType.CODE93;
                        break;
                    case 8:
                        barcodeType = BarcodeType.CODABAR;
                        break;
                    case 16:
                        barcodeType = BarcodeType.DATAMATRIX;
                        break;
                    case 32:
                        barcodeType = BarcodeType.EAN13;
                        break;
                    case 64:
                        barcodeType = BarcodeType.EAN8;
                        break;
                    case 128:
                        barcodeType = BarcodeType.ITF14;
                        break;
                    case 256:
                        barcodeType = BarcodeType.QR;
                        break;
                    case 512:
                        barcodeType = BarcodeType.UPCA;
                        break;
                    case 1024:
                        barcodeType = BarcodeType.UPCE;
                        break;
                    case 2048:
                        barcodeType = BarcodeType.PDF417;
                        break;
                    case 4096:
                        barcodeType = BarcodeType.AZTEC;
                        break;
                    default:
                        barcodeType = BarcodeType.UNKNOWN;
                        break;
                }
            }
            return barcodeType.value;
        }
    }
}
