package com.facebook.react.animated;

import androidx.core.graphics.ColorUtils;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InterpolationAnimatedNode.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/facebook/react/animated/InterpolationAnimatedNode;", "Lcom/facebook/react/animated/ValueAnimatedNode;", "config", "Lcom/facebook/react/bridge/ReadableMap;", "(Lcom/facebook/react/bridge/ReadableMap;)V", "extrapolateLeft", "", "extrapolateRight", "inputRange", "", "objectValue", "", "outputRange", "outputType", "Lcom/facebook/react/animated/InterpolationAnimatedNode$OutputType;", "parent", "pattern", "getAnimatedObject", "onAttachedToNode", "", "Lcom/facebook/react/animated/AnimatedNode;", "onDetachedFromNode", "prettyPrint", "update", "Companion", "OutputType", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InterpolationAnimatedNode extends ValueAnimatedNode {
    private static final String COLOR_OUTPUT_TYPE = "color";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRAPOLATE_TYPE_CLAMP = "clamp";
    public static final String EXTRAPOLATE_TYPE_EXTEND = "extend";
    public static final String EXTRAPOLATE_TYPE_IDENTITY = "identity";
    private static final Pattern numericPattern;
    private final String extrapolateLeft;
    private final String extrapolateRight;
    private final double[] inputRange;
    private Object objectValue;
    private Object outputRange;
    private OutputType outputType;
    private ValueAnimatedNode parent;
    private String pattern;

    /* compiled from: InterpolationAnimatedNode.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OutputType.values().length];
            try {
                iArr[OutputType.Number.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OutputType.Color.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OutputType.String.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: InterpolationAnimatedNode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/react/animated/InterpolationAnimatedNode$OutputType;", "", "(Ljava/lang/String;I)V", "Number", "Color", "String", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class OutputType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ OutputType[] $VALUES;
        public static final OutputType Number = new OutputType("Number", 0);
        public static final OutputType Color = new OutputType("Color", 1);
        public static final OutputType String = new OutputType("String", 2);

        private static final /* synthetic */ OutputType[] $values() {
            return new OutputType[]{Number, Color, String};
        }

        public static EnumEntries<OutputType> getEntries() {
            return $ENTRIES;
        }

        public static OutputType valueOf(String str) {
            return (OutputType) Enum.valueOf(OutputType.class, str);
        }

        public static OutputType[] values() {
            return (OutputType[]) $VALUES.clone();
        }

        private OutputType(String str, int i) {
        }

        static {
            OutputType[] outputTypeArr$values = $values();
            $VALUES = outputTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(outputTypeArr$values);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterpolationAnimatedNode(ReadableMap config) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(config, "config");
        Companion companion = INSTANCE;
        this.inputRange = companion.fromDoubleArray(config.getArray("inputRange"));
        this.extrapolateLeft = config.getString("extrapolateLeft");
        this.extrapolateRight = config.getString("extrapolateRight");
        ReadableArray array = config.getArray("outputRange");
        if (Intrinsics.areEqual("color", config.getString("outputType"))) {
            this.outputType = OutputType.Color;
            this.outputRange = companion.fromIntArray(array);
            return;
        }
        if ((array != null ? array.getType(0) : null) == ReadableType.String) {
            this.outputType = OutputType.String;
            this.outputRange = companion.fromStringPattern(array);
            this.pattern = array.getString(0);
        } else {
            this.outputType = OutputType.Number;
            this.outputRange = companion.fromDoubleArray(array);
        }
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public void onAttachedToNode(AnimatedNode parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (this.parent != null) {
            throw new IllegalStateException("Parent already attached".toString());
        }
        if (!(parent instanceof ValueAnimatedNode)) {
            throw new IllegalArgumentException("Parent is of an invalid type".toString());
        }
        this.parent = (ValueAnimatedNode) parent;
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public void onDetachedFromNode(AnimatedNode parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (parent != this.parent) {
            throw new IllegalArgumentException("Invalid parent node provided".toString());
        }
        this.parent = null;
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public void update() {
        String str;
        ValueAnimatedNode valueAnimatedNode = this.parent;
        if (valueAnimatedNode != null) {
            double value = valueAnimatedNode.getValue();
            OutputType outputType = this.outputType;
            int i = outputType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[outputType.ordinal()];
            if (i == 1) {
                Companion companion = INSTANCE;
                double[] dArr = this.inputRange;
                Object obj = this.outputRange;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.DoubleArray");
                this.nodeValue = companion.interpolate(value, dArr, (double[]) obj, this.extrapolateLeft, this.extrapolateRight);
                return;
            }
            if (i == 2) {
                Companion companion2 = INSTANCE;
                double[] dArr2 = this.inputRange;
                Object obj2 = this.outputRange;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.IntArray");
                this.objectValue = Integer.valueOf(companion2.interpolateColor(value, dArr2, (int[]) obj2));
                return;
            }
            if (i == 3 && (str = this.pattern) != null) {
                Companion companion3 = INSTANCE;
                double[] dArr3 = this.inputRange;
                Object obj3 = this.outputRange;
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.DoubleArray>");
                this.objectValue = companion3.interpolateString(str, value, dArr3, (double[][]) obj3, this.extrapolateLeft, this.extrapolateRight);
            }
        }
    }

    @Override // com.facebook.react.animated.ValueAnimatedNode
    /* renamed from: getAnimatedObject, reason: from getter */
    public Object getObjectValue() {
        return this.objectValue;
    }

    @Override // com.facebook.react.animated.ValueAnimatedNode, com.facebook.react.animated.AnimatedNode
    public String prettyPrint() {
        return "InterpolationAnimatedNode[" + this.tag + "] super: {super.prettyPrint()}";
    }

    /* compiled from: InterpolationAnimatedNode.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u001d\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00162\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0017JB\u0010\u0018\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J2\u0010\u0018\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\u001e\u0010!\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0014JE\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u000f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010$R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/facebook/react/animated/InterpolationAnimatedNode$Companion;", "", "()V", "COLOR_OUTPUT_TYPE", "", "EXTRAPOLATE_TYPE_CLAMP", "EXTRAPOLATE_TYPE_EXTEND", "EXTRAPOLATE_TYPE_IDENTITY", "numericPattern", "Ljava/util/regex/Pattern;", "findRangeIndex", "", "value", "", "ranges", "", "fromDoubleArray", "array", "Lcom/facebook/react/bridge/ReadableArray;", "fromIntArray", "", "fromStringPattern", "", "(Lcom/facebook/react/bridge/ReadableArray;)[[D", "interpolate", "inputMin", "inputMax", "outputMin", "outputMax", "extrapolateLeft", "extrapolateRight", "inputRange", "outputRange", "interpolateColor", "interpolateString", "pattern", "(Ljava/lang/String;D[D[[DLjava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final double[] fromDoubleArray(ReadableArray array) {
            if (array != null) {
                int size = array.size();
                double[] dArr = new double[size];
                for (int i = 0; i < size; i++) {
                    dArr[i] = array.getDouble(i);
                }
                return dArr;
            }
            return new double[0];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int[] fromIntArray(ReadableArray array) {
            if (array != null) {
                int size = array.size();
                int[] iArr = new int[size];
                for (int i = 0; i < size; i++) {
                    iArr[i] = array.getInt(i);
                }
                return iArr;
            }
            return new int[0];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final double[][] fromStringPattern(ReadableArray array) {
            int size = array.size();
            double[][] dArr = new double[size][];
            Matcher matcher = InterpolationAnimatedNode.numericPattern.matcher(array.getString(0));
            ArrayList arrayList = new ArrayList();
            while (matcher.find()) {
                String strGroup = matcher.group();
                Intrinsics.checkNotNullExpressionValue(strGroup, "group(...)");
                arrayList.add(Double.valueOf(Double.parseDouble(strGroup)));
            }
            int size2 = arrayList.size();
            double[] dArr2 = new double[size2];
            int size3 = arrayList.size();
            for (int i = 0; i < size3; i++) {
                dArr2[i] = ((Number) arrayList.get(i)).doubleValue();
            }
            dArr[0] = dArr2;
            for (int i2 = 1; i2 < size; i2++) {
                double[] dArr3 = new double[size2];
                Matcher matcher2 = InterpolationAnimatedNode.numericPattern.matcher(array.getString(i2));
                for (int i3 = 0; matcher2.find() && i3 < size2; i3++) {
                    String strGroup2 = matcher2.group();
                    Intrinsics.checkNotNullExpressionValue(strGroup2, "group(...)");
                    dArr3[i3] = Double.parseDouble(strGroup2);
                }
                dArr[i2] = dArr3;
            }
            return dArr;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
        
            if (r23.equals(com.facebook.react.animated.InterpolationAnimatedNode.EXTRAPOLATE_TYPE_EXTEND) != false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0079, code lost:
        
            if (r24.equals(com.facebook.react.animated.InterpolationAnimatedNode.EXTRAPOLATE_TYPE_EXTEND) != false) goto L39;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final double interpolate(double r13, double r15, double r17, double r19, double r21, java.lang.String r23, java.lang.String r24) {
            /*
                r12 = this;
                r0 = r23
                r1 = r24
                int r2 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
                java.lang.String r3 = "clamp"
                java.lang.String r4 = "identity"
                java.lang.String r5 = "extend"
                r6 = 94742715(0x5a5a8bb, float:1.5578507E-35)
                r7 = -135761730(0xfffffffff7e870be, float:-9.428903E33)
                r8 = -1289044198(0xffffffffb32abf1a, float:-3.9755015E-8)
                java.lang.String r9 = "Invalid extrapolation type "
                if (r2 >= 0) goto L54
                if (r0 == 0) goto L3b
                int r10 = r23.hashCode()
                if (r10 == r8) goto L34
                if (r10 == r7) goto L2d
                if (r10 != r6) goto L3b
                boolean r10 = r0.equals(r3)
                if (r10 == 0) goto L3b
                r10 = r15
                goto L55
            L2d:
                boolean r1 = r0.equals(r4)
                if (r1 == 0) goto L3b
                return r13
            L34:
                boolean r10 = r0.equals(r5)
                if (r10 == 0) goto L3b
                goto L54
            L3b:
                com.facebook.react.bridge.JSApplicationIllegalArgumentException r1 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r9)
                java.lang.StringBuilder r0 = r2.append(r0)
                java.lang.String r2 = "for left extrapolation"
                java.lang.StringBuilder r0 = r0.append(r2)
                java.lang.String r0 = r0.toString()
                r1.<init>(r0)
                throw r1
            L54:
                r10 = r13
            L55:
                int r0 = (r10 > r17 ? 1 : (r10 == r17 ? 0 : -1))
                if (r0 <= 0) goto L95
                if (r1 == 0) goto L7c
                int r0 = r24.hashCode()
                if (r0 == r8) goto L75
                if (r0 == r7) goto L6e
                if (r0 != r6) goto L7c
                boolean r0 = r1.equals(r3)
                if (r0 == 0) goto L7c
                r10 = r17
                goto L95
            L6e:
                boolean r0 = r1.equals(r4)
                if (r0 == 0) goto L7c
                return r10
            L75:
                boolean r0 = r1.equals(r5)
                if (r0 == 0) goto L7c
                goto L95
            L7c:
                com.facebook.react.bridge.JSApplicationIllegalArgumentException r0 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r9)
                java.lang.StringBuilder r1 = r2.append(r1)
                java.lang.String r2 = "for right extrapolation"
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L95:
                int r0 = (r19 > r21 ? 1 : (r19 == r21 ? 0 : -1))
                if (r0 != 0) goto L9a
                return r19
            L9a:
                int r0 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
                if (r0 != 0) goto La6
                if (r2 > 0) goto La3
                r0 = r19
                goto Laf
            La3:
                r0 = r21
                goto Laf
            La6:
                double r0 = r21 - r19
                double r10 = r10 - r15
                double r0 = r0 * r10
                double r2 = r17 - r15
                double r0 = r0 / r2
                double r0 = r19 + r0
            Laf:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.animated.InterpolationAnimatedNode.Companion.interpolate(double, double, double, double, double, java.lang.String, java.lang.String):double");
        }

        public final double interpolate(double value, double[] inputRange, double[] outputRange, String extrapolateLeft, String extrapolateRight) {
            Intrinsics.checkNotNullParameter(inputRange, "inputRange");
            Intrinsics.checkNotNullParameter(outputRange, "outputRange");
            int iFindRangeIndex = findRangeIndex(value, inputRange);
            int i = iFindRangeIndex + 1;
            return interpolate(value, inputRange[iFindRangeIndex], inputRange[i], outputRange[iFindRangeIndex], outputRange[i], extrapolateLeft, extrapolateRight);
        }

        public final int interpolateColor(double value, double[] inputRange, int[] outputRange) {
            Intrinsics.checkNotNullParameter(inputRange, "inputRange");
            Intrinsics.checkNotNullParameter(outputRange, "outputRange");
            int iFindRangeIndex = findRangeIndex(value, inputRange);
            int i = outputRange[iFindRangeIndex];
            int i2 = iFindRangeIndex + 1;
            int i3 = outputRange[i2];
            if (i == i3) {
                return i;
            }
            double d = inputRange[iFindRangeIndex];
            double d2 = inputRange[i2];
            if (d == d2) {
                return value <= d ? i : i3;
            }
            return ColorUtils.blendARGB(i, i3, (float) ((value - d) / (d2 - d)));
        }

        public final String interpolateString(String pattern, double value, double[] inputRange, double[][] outputRange, String extrapolateLeft, String extrapolateRight) {
            double[] inputRange2 = inputRange;
            Intrinsics.checkNotNullParameter(pattern, "pattern");
            Intrinsics.checkNotNullParameter(inputRange2, "inputRange");
            Intrinsics.checkNotNullParameter(outputRange, "outputRange");
            int iFindRangeIndex = findRangeIndex(value, inputRange2);
            StringBuffer stringBuffer = new StringBuffer(pattern.length());
            Matcher matcher = InterpolationAnimatedNode.numericPattern.matcher(pattern);
            int i = 0;
            while (matcher.find()) {
                double[] dArr = outputRange[iFindRangeIndex];
                if (i >= dArr.length) {
                    break;
                }
                int i2 = iFindRangeIndex + 1;
                int i3 = i;
                StringBuffer stringBuffer2 = stringBuffer;
                double dInterpolate = interpolate(value, inputRange2[iFindRangeIndex], inputRange2[i2], dArr[i], outputRange[i2][i], extrapolateLeft, extrapolateRight);
                int i4 = (int) dInterpolate;
                matcher.appendReplacement(stringBuffer2, ((double) i4) == dInterpolate ? String.valueOf(i4) : String.valueOf(dInterpolate));
                i = i3 + 1;
                stringBuffer = stringBuffer2;
                inputRange2 = inputRange;
            }
            StringBuffer stringBuffer3 = stringBuffer;
            matcher.appendTail(stringBuffer3);
            String string = stringBuffer3.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        private final int findRangeIndex(double value, double[] ranges) {
            int i = 1;
            while (i < ranges.length - 1 && ranges[i] < value) {
                i++;
            }
            return i - 1;
        }
    }

    static {
        Pattern patternCompile = Pattern.compile("[+-]?(\\d+\\.?\\d*|\\.\\d+)([eE][+-]?\\d+)?");
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        numericPattern = patternCompile;
    }
}
