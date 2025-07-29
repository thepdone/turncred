package com.facebook.react.uimanager;

import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaWrap;

/* loaded from: classes4.dex */
public class LayoutShadowNode extends ReactShadowNodeImpl {
    boolean mCollapsable;
    private final MutableYogaValue mTempYogaValue = new MutableYogaValue();

    @ReactProp(name = ViewProps.COLLAPSABLE_CHILDREN)
    public void setCollapsableChildren(boolean z) {
    }

    @ReactProp(name = "inset")
    public void setInset(Dynamic dynamic) {
    }

    @ReactPropGroup(names = {"insetBlock", "insetBlockEnd", "insetBlockStart"})
    public void setInsetBlock(int i, Dynamic dynamic) {
    }

    @ReactPropGroup(names = {"insetInline", "insetInlineEnd", "insetInlineStart"})
    public void setInsetInline(int i, Dynamic dynamic) {
    }

    @ReactProp(name = "experimental_layoutConformance")
    public void setLayoutConformance(String str) {
    }

    @ReactPropGroup(names = {"marginBlock", "marginBlockEnd", "marginBlockStart"})
    public void setMarginBlock(int i, Dynamic dynamic) {
    }

    @ReactPropGroup(names = {"marginInline", "marginInlineEnd", "marginInlineStart"})
    public void setMarginInline(int i, Dynamic dynamic) {
    }

    @ReactPropGroup(names = {"paddingBlock", "paddingBlockEnd", "paddingBlockStart"})
    public void setPaddingBlock(int i, Dynamic dynamic) {
    }

    @ReactPropGroup(names = {"paddingInline", "paddingInlineEnd", "paddingInlineStart"})
    public void setPaddingInline(int i, Dynamic dynamic) {
    }

    @ReactProp(name = "onPointerEnter")
    public void setShouldNotifyPointerEnter(boolean z) {
    }

    @ReactProp(name = "onPointerLeave")
    public void setShouldNotifyPointerLeave(boolean z) {
    }

    @ReactProp(name = "onPointerMove")
    public void setShouldNotifyPointerMove(boolean z) {
    }

    private static class MutableYogaValue {
        YogaUnit unit;
        float value;

        private MutableYogaValue() {
        }

        private MutableYogaValue(MutableYogaValue mutableYogaValue) {
            this.value = mutableYogaValue.value;
            this.unit = mutableYogaValue.unit;
        }

        void setFromDynamic(Dynamic dynamic) {
            if (dynamic.isNull()) {
                this.unit = YogaUnit.UNDEFINED;
                this.value = Float.NaN;
                return;
            }
            if (dynamic.getType() == ReadableType.String) {
                String strAsString = dynamic.asString();
                if (strAsString.equals("auto")) {
                    this.unit = YogaUnit.AUTO;
                    this.value = Float.NaN;
                    return;
                } else if (strAsString.endsWith("%")) {
                    this.unit = YogaUnit.PERCENT;
                    this.value = Float.parseFloat(strAsString.substring(0, strAsString.length() - 1));
                    return;
                } else {
                    FLog.w("ReactNative", "Unknown value: " + strAsString);
                    this.unit = YogaUnit.UNDEFINED;
                    this.value = Float.NaN;
                    return;
                }
            }
            if (dynamic.getType() == ReadableType.Number) {
                this.unit = YogaUnit.POINT;
                this.value = PixelUtil.toPixelFromDIP(dynamic.asDouble());
            } else {
                this.unit = YogaUnit.UNDEFINED;
                this.value = Float.NaN;
            }
        }
    }

    @ReactProp(name = "width")
    public void setWidth(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2) {
            setStyleWidth(this.mTempYogaValue.value);
        } else if (i == 3) {
            setStyleWidthAuto();
        } else if (i == 4) {
            setStyleWidthPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    /* renamed from: com.facebook.react.uimanager.LayoutShadowNode$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$yoga$YogaUnit;

        static {
            int[] iArr = new int[YogaUnit.values().length];
            $SwitchMap$com$facebook$yoga$YogaUnit = iArr;
            try {
                iArr[YogaUnit.POINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$yoga$YogaUnit[YogaUnit.UNDEFINED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$yoga$YogaUnit[YogaUnit.AUTO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$yoga$YogaUnit[YogaUnit.PERCENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @ReactProp(name = ViewProps.MIN_WIDTH)
    public void setMinWidth(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2) {
            setStyleMinWidth(this.mTempYogaValue.value);
        } else if (i == 4) {
            setStyleMinWidthPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactProp(name = ViewProps.COLLAPSABLE)
    public void setCollapsable(boolean z) {
        this.mCollapsable = z;
    }

    @ReactProp(name = ViewProps.MAX_WIDTH)
    public void setMaxWidth(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2) {
            setStyleMaxWidth(this.mTempYogaValue.value);
        } else if (i == 4) {
            setStyleMaxWidthPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactProp(name = "height")
    public void setHeight(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2) {
            setStyleHeight(this.mTempYogaValue.value);
        } else if (i == 3) {
            setStyleHeightAuto();
        } else if (i == 4) {
            setStyleHeightPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactProp(name = ViewProps.MIN_HEIGHT)
    public void setMinHeight(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2) {
            setStyleMinHeight(this.mTempYogaValue.value);
        } else if (i == 4) {
            setStyleMinHeightPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactProp(name = ViewProps.MAX_HEIGHT)
    public void setMaxHeight(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2) {
            setStyleMaxHeight(this.mTempYogaValue.value);
        } else if (i == 4) {
            setStyleMaxHeightPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    @ReactProp(defaultFloat = 0.0f, name = ViewProps.FLEX)
    public void setFlex(float f) {
        if (isVirtual()) {
            return;
        }
        super.setFlex(f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    @ReactProp(defaultFloat = 0.0f, name = ViewProps.FLEX_GROW)
    public void setFlexGrow(float f) {
        if (isVirtual()) {
            return;
        }
        super.setFlexGrow(f);
    }

    @ReactProp(name = ViewProps.ROW_GAP)
    public void setRowGap(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            setRowGap(this.mTempYogaValue.value);
        } else if (i == 4) {
            setRowGapPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactProp(name = ViewProps.COLUMN_GAP)
    public void setColumnGap(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            setColumnGap(this.mTempYogaValue.value);
        } else if (i == 4) {
            setColumnGapPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactProp(name = ViewProps.GAP)
    public void setGap(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            setGap(this.mTempYogaValue.value);
        } else if (i == 4) {
            setGapPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    @ReactProp(defaultFloat = 0.0f, name = ViewProps.FLEX_SHRINK)
    public void setFlexShrink(float f) {
        if (isVirtual()) {
            return;
        }
        super.setFlexShrink(f);
    }

    @ReactProp(name = ViewProps.FLEX_BASIS)
    public void setFlexBasis(Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i == 1 || i == 2) {
            setFlexBasis(this.mTempYogaValue.value);
        } else if (i == 3) {
            setFlexBasisAuto();
        } else if (i == 4) {
            setFlexBasisPercent(this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactProp(defaultFloat = Float.NaN, name = ViewProps.ASPECT_RATIO)
    public void setAspectRatio(float f) {
        setStyleAspectRatio(f);
    }

    @ReactProp(name = ViewProps.FLEX_DIRECTION)
    public void setFlexDirection(String str) {
        if (isVirtual()) {
        }
        if (str == null) {
            setFlexDirection(YogaFlexDirection.COLUMN);
            return;
        }
        str.hashCode();
        switch (str) {
            case "row-reverse":
                setFlexDirection(YogaFlexDirection.ROW_REVERSE);
                break;
            case "column":
                setFlexDirection(YogaFlexDirection.COLUMN);
                break;
            case "row":
                setFlexDirection(YogaFlexDirection.ROW);
                break;
            case "column-reverse":
                setFlexDirection(YogaFlexDirection.COLUMN_REVERSE);
                break;
            default:
                FLog.w("ReactNative", "invalid value for flexDirection: " + str);
                setFlexDirection(YogaFlexDirection.COLUMN);
                break;
        }
    }

    @ReactProp(name = ViewProps.FLEX_WRAP)
    public void setFlexWrap(String str) {
        if (isVirtual()) {
        }
        if (str == null) {
            setFlexWrap(YogaWrap.NO_WRAP);
            return;
        }
        str.hashCode();
        switch (str) {
            case "nowrap":
                setFlexWrap(YogaWrap.NO_WRAP);
                break;
            case "wrap-reverse":
                setFlexWrap(YogaWrap.WRAP_REVERSE);
                break;
            case "wrap":
                setFlexWrap(YogaWrap.WRAP);
                break;
            default:
                FLog.w("ReactNative", "invalid value for flexWrap: " + str);
                setFlexWrap(YogaWrap.NO_WRAP);
                break;
        }
    }

    @ReactProp(name = ViewProps.ALIGN_SELF)
    public void setAlignSelf(String str) {
        if (isVirtual()) {
        }
        if (str == null) {
            setAlignSelf(YogaAlign.AUTO);
            return;
        }
        str.hashCode();
        switch (str) {
            case "stretch":
                setAlignSelf(YogaAlign.STRETCH);
                break;
            case "baseline":
                setAlignSelf(YogaAlign.BASELINE);
                break;
            case "center":
                setAlignSelf(YogaAlign.CENTER);
                break;
            case "flex-start":
                setAlignSelf(YogaAlign.FLEX_START);
                break;
            case "auto":
                setAlignSelf(YogaAlign.AUTO);
                break;
            case "space-between":
                setAlignSelf(YogaAlign.SPACE_BETWEEN);
                break;
            case "flex-end":
                setAlignSelf(YogaAlign.FLEX_END);
                break;
            case "space-around":
                setAlignSelf(YogaAlign.SPACE_AROUND);
                break;
            default:
                FLog.w("ReactNative", "invalid value for alignSelf: " + str);
                setAlignSelf(YogaAlign.AUTO);
                break;
        }
    }

    @ReactProp(name = ViewProps.ALIGN_ITEMS)
    public void setAlignItems(String str) {
        if (isVirtual()) {
        }
        if (str == null) {
            setAlignItems(YogaAlign.STRETCH);
            return;
        }
        str.hashCode();
        switch (str) {
            case "stretch":
                setAlignItems(YogaAlign.STRETCH);
                break;
            case "baseline":
                setAlignItems(YogaAlign.BASELINE);
                break;
            case "center":
                setAlignItems(YogaAlign.CENTER);
                break;
            case "flex-start":
                setAlignItems(YogaAlign.FLEX_START);
                break;
            case "auto":
                setAlignItems(YogaAlign.AUTO);
                break;
            case "space-between":
                setAlignItems(YogaAlign.SPACE_BETWEEN);
                break;
            case "flex-end":
                setAlignItems(YogaAlign.FLEX_END);
                break;
            case "space-around":
                setAlignItems(YogaAlign.SPACE_AROUND);
                break;
            default:
                FLog.w("ReactNative", "invalid value for alignItems: " + str);
                setAlignItems(YogaAlign.STRETCH);
                break;
        }
    }

    @ReactProp(name = ViewProps.ALIGN_CONTENT)
    public void setAlignContent(String str) {
        if (isVirtual()) {
        }
        if (str == null) {
            setAlignContent(YogaAlign.FLEX_START);
            return;
        }
        str.hashCode();
        switch (str) {
            case "stretch":
                setAlignContent(YogaAlign.STRETCH);
                break;
            case "baseline":
                setAlignContent(YogaAlign.BASELINE);
                break;
            case "center":
                setAlignContent(YogaAlign.CENTER);
                break;
            case "flex-start":
                setAlignContent(YogaAlign.FLEX_START);
                break;
            case "auto":
                setAlignContent(YogaAlign.AUTO);
                break;
            case "space-between":
                setAlignContent(YogaAlign.SPACE_BETWEEN);
                break;
            case "flex-end":
                setAlignContent(YogaAlign.FLEX_END);
                break;
            case "space-around":
                setAlignContent(YogaAlign.SPACE_AROUND);
                break;
            case "space-evenly":
                setAlignContent(YogaAlign.SPACE_EVENLY);
                break;
            default:
                FLog.w("ReactNative", "invalid value for alignContent: " + str);
                setAlignContent(YogaAlign.FLEX_START);
                break;
        }
    }

    @ReactProp(name = ViewProps.JUSTIFY_CONTENT)
    public void setJustifyContent(String str) {
        if (isVirtual()) {
        }
        if (str == null) {
            setJustifyContent(YogaJustify.FLEX_START);
            return;
        }
        str.hashCode();
        switch (str) {
            case "center":
                setJustifyContent(YogaJustify.CENTER);
                break;
            case "flex-start":
                setJustifyContent(YogaJustify.FLEX_START);
                break;
            case "space-between":
                setJustifyContent(YogaJustify.SPACE_BETWEEN);
                break;
            case "flex-end":
                setJustifyContent(YogaJustify.FLEX_END);
                break;
            case "space-around":
                setJustifyContent(YogaJustify.SPACE_AROUND);
                break;
            case "space-evenly":
                setJustifyContent(YogaJustify.SPACE_EVENLY);
                break;
            default:
                FLog.w("ReactNative", "invalid value for justifyContent: " + str);
                setJustifyContent(YogaJustify.FLEX_START);
                break;
        }
    }

    @ReactProp(name = ViewProps.OVERFLOW)
    public void setOverflow(String str) {
        if (isVirtual()) {
        }
        if (str == null) {
            setOverflow(YogaOverflow.VISIBLE);
            return;
        }
        str.hashCode();
        switch (str) {
            case "hidden":
                setOverflow(YogaOverflow.HIDDEN);
                break;
            case "scroll":
                setOverflow(YogaOverflow.SCROLL);
                break;
            case "visible":
                setOverflow(YogaOverflow.VISIBLE);
                break;
            default:
                FLog.w("ReactNative", "invalid value for overflow: " + str);
                setOverflow(YogaOverflow.VISIBLE);
                break;
        }
    }

    @ReactProp(name = "display")
    public void setDisplay(String str) {
        if (isVirtual()) {
            return;
        }
        if (str == null) {
            setDisplay(YogaDisplay.FLEX);
            return;
        }
        str.hashCode();
        if (str.equals(ViewProps.FLEX)) {
            setDisplay(YogaDisplay.FLEX);
        } else if (str.equals("none")) {
            setDisplay(YogaDisplay.NONE);
        } else {
            FLog.w("ReactNative", "invalid value for display: " + str);
            setDisplay(YogaDisplay.FLEX);
        }
    }

    @ReactPropGroup(names = {ViewProps.MARGIN, ViewProps.MARGIN_VERTICAL, ViewProps.MARGIN_HORIZONTAL, ViewProps.MARGIN_START, ViewProps.MARGIN_END, ViewProps.MARGIN_TOP, ViewProps.MARGIN_BOTTOM, ViewProps.MARGIN_LEFT, ViewProps.MARGIN_RIGHT})
    public void setMargins(int i, Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        int iMaybeTransformLeftRightToStartEnd = maybeTransformLeftRightToStartEnd(ViewProps.PADDING_MARGIN_SPACING_TYPES[i]);
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i2 = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i2 == 1 || i2 == 2) {
            setMargin(iMaybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
        } else if (i2 == 3) {
            setMarginAuto(iMaybeTransformLeftRightToStartEnd);
        } else if (i2 == 4) {
            setMarginPercent(iMaybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactPropGroup(names = {ViewProps.PADDING, ViewProps.PADDING_VERTICAL, ViewProps.PADDING_HORIZONTAL, ViewProps.PADDING_START, ViewProps.PADDING_END, ViewProps.PADDING_TOP, ViewProps.PADDING_BOTTOM, ViewProps.PADDING_LEFT, ViewProps.PADDING_RIGHT})
    public void setPaddings(int i, Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        int iMaybeTransformLeftRightToStartEnd = maybeTransformLeftRightToStartEnd(ViewProps.PADDING_MARGIN_SPACING_TYPES[i]);
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i2 = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i2 == 1 || i2 == 2) {
            setPadding(iMaybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
        } else if (i2 == 4) {
            setPaddingPercent(iMaybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {ViewProps.BORDER_WIDTH, ViewProps.BORDER_START_WIDTH, ViewProps.BORDER_END_WIDTH, ViewProps.BORDER_TOP_WIDTH, ViewProps.BORDER_BOTTOM_WIDTH, ViewProps.BORDER_LEFT_WIDTH, ViewProps.BORDER_RIGHT_WIDTH})
    public void setBorderWidths(int i, float f) {
        if (isVirtual()) {
            return;
        }
        setBorder(maybeTransformLeftRightToStartEnd(ViewProps.BORDER_SPACING_TYPES[i]), PixelUtil.toPixelFromDIP(f));
    }

    @ReactPropGroup(names = {ViewProps.START, ViewProps.END, "left", ViewProps.RIGHT, "top", ViewProps.BOTTOM})
    public void setPositionValues(int i, Dynamic dynamic) {
        if (isVirtual()) {
            return;
        }
        int iMaybeTransformLeftRightToStartEnd = maybeTransformLeftRightToStartEnd(new int[]{4, 5, 0, 2, 1, 3}[i]);
        this.mTempYogaValue.setFromDynamic(dynamic);
        int i2 = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
        if (i2 == 1 || i2 == 2) {
            setPosition(iMaybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
        } else if (i2 == 4) {
            setPositionPercent(iMaybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
        }
        dynamic.recycle();
    }

    private int maybeTransformLeftRightToStartEnd(int i) {
        if (!I18nUtil.getInstance().doLeftAndRightSwapInRTL(getThemedContext())) {
            return i;
        }
        if (i == 0) {
            return 4;
        }
        if (i != 2) {
            return i;
        }
        return 5;
    }

    @ReactProp(name = ViewProps.POSITION)
    public void setPosition(String str) {
        if (isVirtual()) {
            return;
        }
        if (str == null) {
            setPositionType(YogaPositionType.RELATIVE);
            return;
        }
        str.hashCode();
        if (str.equals(Constants.PATH_TYPE_RELATIVE)) {
            setPositionType(YogaPositionType.RELATIVE);
        } else if (str.equals(Constants.PATH_TYPE_ABSOLUTE)) {
            setPositionType(YogaPositionType.ABSOLUTE);
        } else {
            FLog.w("ReactNative", "invalid value for position: " + str);
            setPositionType(YogaPositionType.RELATIVE);
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    @ReactProp(name = ViewProps.ON_LAYOUT)
    public void setShouldNotifyOnLayout(boolean z) {
        super.setShouldNotifyOnLayout(z);
    }
}
