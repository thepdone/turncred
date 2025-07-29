package com.horcrux.svg;

import androidx.camera.video.AudioStats;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import io.sentry.ProfilingTraceData;
import java.util.ArrayList;

/* loaded from: classes5.dex */
class SVGLength {
    final UnitType unit;
    final double value;

    public enum UnitType {
        UNKNOWN,
        NUMBER,
        PERCENTAGE,
        EMS,
        EXS,
        PX,
        CM,
        MM,
        IN,
        PT,
        PC
    }

    private SVGLength() {
        this.value = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.unit = UnitType.UNKNOWN;
    }

    SVGLength(double d) {
        this.value = d;
        this.unit = UnitType.NUMBER;
    }

    SVGLength(String str) {
        String strTrim = str.trim();
        int length = strTrim.length();
        int i = length - 1;
        if (length == 0 || strTrim.equals(ProfilingTraceData.TRUNCATION_REASON_NORMAL)) {
            this.unit = UnitType.UNKNOWN;
            this.value = AudioStats.AUDIO_AMPLITUDE_NONE;
            return;
        }
        if (strTrim.codePointAt(i) == 37) {
            this.unit = UnitType.PERCENTAGE;
            this.value = Double.valueOf(strTrim.substring(0, i)).doubleValue();
            return;
        }
        int i2 = length - 2;
        if (i2 > 0) {
            String strSubstring = strTrim.substring(i2);
            strSubstring.hashCode();
            switch (strSubstring) {
                case "cm":
                    this.unit = UnitType.CM;
                    length = i2;
                    break;
                case "em":
                    this.unit = UnitType.EMS;
                    length = i2;
                    break;
                case "ex":
                    this.unit = UnitType.EXS;
                    length = i2;
                    break;
                case "in":
                    this.unit = UnitType.IN;
                    length = i2;
                    break;
                case "mm":
                    this.unit = UnitType.MM;
                    length = i2;
                    break;
                case "pc":
                    this.unit = UnitType.PC;
                    length = i2;
                    break;
                case "pt":
                    this.unit = UnitType.PT;
                    length = i2;
                    break;
                case "px":
                    this.unit = UnitType.NUMBER;
                    length = i2;
                    break;
                default:
                    this.unit = UnitType.NUMBER;
                    break;
            }
            this.value = Double.valueOf(strTrim.substring(0, length)).doubleValue();
            return;
        }
        this.unit = UnitType.NUMBER;
        this.value = Double.valueOf(strTrim).doubleValue();
    }

    /* renamed from: com.horcrux.svg.SVGLength$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        static {
            int[] iArr = new int[ReadableType.values().length];
            $SwitchMap$com$facebook$react$bridge$ReadableType = iArr;
            try {
                iArr[ReadableType.Number.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.String.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Array.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static SVGLength from(Dynamic dynamic) {
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[dynamic.getType().ordinal()];
        if (i == 1) {
            return new SVGLength(dynamic.asDouble());
        }
        if (i == 2) {
            return new SVGLength(dynamic.asString());
        }
        return new SVGLength();
    }

    static SVGLength from(String str) {
        return str != null ? new SVGLength(str) : new SVGLength();
    }

    static SVGLength from(Double d) {
        return d != null ? new SVGLength(d.doubleValue()) : new SVGLength();
    }

    static String toString(Dynamic dynamic) {
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[dynamic.getType().ordinal()];
        if (i == 1) {
            return String.valueOf(dynamic.asDouble());
        }
        if (i != 2) {
            return null;
        }
        return dynamic.asString();
    }

    static ArrayList<SVGLength> arrayFrom(Dynamic dynamic) {
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[dynamic.getType().ordinal()];
        if (i == 1) {
            ArrayList<SVGLength> arrayList = new ArrayList<>(1);
            arrayList.add(new SVGLength(dynamic.asDouble()));
            return arrayList;
        }
        int i2 = 0;
        if (i == 2) {
            String[] strArrSplit = dynamic.asString().trim().replaceAll(",", " ").split(" ");
            ArrayList<SVGLength> arrayList2 = new ArrayList<>(strArrSplit.length);
            int length = strArrSplit.length;
            while (i2 < length) {
                arrayList2.add(new SVGLength(strArrSplit[i2]));
                i2++;
            }
            return arrayList2;
        }
        if (i != 3) {
            return null;
        }
        ReadableArray readableArrayAsArray = dynamic.asArray();
        int size = readableArrayAsArray.size();
        ArrayList<SVGLength> arrayList3 = new ArrayList<>(size);
        while (i2 < size) {
            arrayList3.add(from(readableArrayAsArray.getDynamic(i2)));
            i2++;
        }
        return arrayList3;
    }

    static ArrayList<SVGLength> arrayFrom(ReadableArray readableArray) {
        int size = readableArray.size();
        ArrayList<SVGLength> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(from(readableArray.getDynamic(i)));
        }
        return arrayList;
    }
}
